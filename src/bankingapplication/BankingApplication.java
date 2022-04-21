package bankingapplication;

import java.util.Scanner;

/**
 * @author Adam Rittermann
 */
public class BankingApplication {

    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount("Adam Rittermann", "48391");
        acct1.showMenu();
    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;
    
    BankAccount(String custName, String cId) {
        customerName = custName;
        customerId = cId;
    }
    
    void deposit (int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    
    void withdraw (int amount) {
        if (amount != 0 && amount <= balance) {
            balance = balance - amount;
            previousTransaction = -amount;
        } else {
            System.out.println("ERROR: Withdrawal exceeds account balance.");
        }
    }
    
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrew: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction found.");
        }
    }
    
    void menu() {
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");
    }
    
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome " + customerName);
        System.out.println("ID: " + customerId);
        System.out.println("\n");
        
        //Do While Loop
        do {
            menu();
            System.out.println("================================");
            System.out.println("Enter an Option");
            System.out.println("================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");
            
            switch(option) {
                case 'A':
                    System.out.println("------------------------------");
                    System.out.println("Current Balance is " + balance);
                    System.out.println("------------------------------");
                    System.out.println();
                    break;
                    
                case 'B':
                    System.out.println("------------------------------");
                    System.out.println("Enter Deposit Amount:");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("------------------------------");
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("------------------------------");
                    System.out.println("Enter Withdrawal Amount:");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("------------------------------");
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("------------------------------");
                    System.out.println("Previous Transaction:");
                    getPreviousTransaction();
                    System.out.println("------------------------------");
                    System.out.println();
                    break;
                
                default:
                    System.out.println("Invalid Option, please try again.");
                    break;
            } 
        }while (option != 'E');
            System.out.println("Thank you for using this service.");
        
    }
}
