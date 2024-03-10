package email;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String comparnySuffix = "google.in";

    //Constructor taking first and last name.
    public Email(String firstName , String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created : " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
//        System.out.println("Department is " + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your passwrod is " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + comparnySuffix;
//        System.out.println("Your email is : " + email);
    }

    //Setting the department.
    private String setDepartment(){
        System.out.println("Department Codes \n1 for SALES\n2 for Development\n3 for Accounts\n0 for none\nEnter department code : ");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();
        if(depChoice == 1) return "sales";
        else if(depChoice == 2) return "dev";
        else if(depChoice == 3) return "acc";
        else return "";
    }

    //Random password generator.
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char password[] = new char[length];
        for(int i = 0 ; i < length ; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    //Alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity() { return mailBoxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public void showInfo(){
        System.out.println( "Display Name : " + firstName + " " + lastName +
                "\nCompany Name : " + email +
                "\nMailBox Capacity : " + mailBoxCapacity + "mb");
    }
}
