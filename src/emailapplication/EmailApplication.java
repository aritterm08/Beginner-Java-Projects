package emailapplication;

import java.util.Scanner;

/**
 * Simple Email Application
 * @author Adam Rittermann
 */
public class EmailApplication {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("EMAIL ACCOUNT CREATION");
        System.out.println("======================");
        System.out.print("Enter First Name: ");
        String firstName = in.next();
        System.out.print("Enter Last Name: ");
        String lastName = in.next();
        Email em1 = new Email(firstName, lastName);
        
        // Set Mailbox Capacity
        System.out.println("Default Mailbox Capacity: " + em1.getMailboxCapacity());
        System.out.print("Set new Mailbox Capacity (Y/N)? ");
        char input = in.next().charAt(0);
        if (input == 'Y') {
            System.out.print("Enter Capacity: ");
            em1.setMailboxCapacity(in.nextInt());
            System.out.println("Mailbox Capacity set to " + em1.getMailboxCapacity()); 
        }
        
        // Set Alternate Email
        System.out.print("Set Alternate Email: ");
        em1.setAlternateEmail(in.next());
        System.out.println("Alternate Email applied: " + em1.getAlternateEmail());
        
        // Closing Message
        System.out.println("Email account created for " + em1.getName());
    }
    
}
