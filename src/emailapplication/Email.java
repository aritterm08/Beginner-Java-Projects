/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapplication;

import java.util.Scanner;

/**
 * Objects for EmailApplication
 * @author Adam Rittermann
 */
public class Email {
    
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail = "";
    private int mailboxCapacity = 100;
    private int defaultPasswordLength = 10;
    private String companySuffix = "xyzcompany.com";
    
    // Constructor to receive first name and last name, get department, generate password, and create email address
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;        
        
        // Call method to ask department and return department
        this.department = setDepartment();
        System.out.println("DEPARTMENT SET: " + this.department);
        if (this.department == "none") {
            this.department = "";
        }
        
        // Call method to return random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);
        
        // Combine to generate email address
        if (this.department != "") {
            email = this.firstName + "." + this.lastName + "@" + this.department + "." + this.companySuffix;
        } else {
            email = this.firstName + "." + this.lastName + "@" + this.companySuffix;
        }
        System.out.println(email);
        
    } 
    
    // Ask for department
    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department Code:");
        Scanner in = new Scanner(System.in);
        char departmentChoice = in.next().charAt(0);
        switch (departmentChoice) {
            case '1':
                return "sales";
            case '2':
                return "dev";
            case '3':
                return "acct";
            default:
                return "none";
        }
    }
    
    // Generate random password
    private String randomPassword(int passwordLength) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&0123456789";
        char[] pw = new char[passwordLength];
        for (int i=0; i<passwordLength; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            pw[i] = passwordSet.charAt(rand);
        }
        return new String(pw);
        
    }
    
    // Set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    
    // Set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    
    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }
    
    public String getName() { return firstName + " " + lastName; }
    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }
        
}
