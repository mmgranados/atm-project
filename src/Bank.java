import accounts.Account;
import accounts.Authentication;

import java.util.Scanner;

/**
 * Only used for creating users
 * Has an authentication server
 */
public class Bank {
    final static Scanner bankScanner = new Scanner(System.in);

    /**
     * Alternate way to create account, requiring no parameters
     * @return
     */
    public static Account createAccount() {
        System.out.println("Input Account Name: ");
        String accountName = bankScanner.nextLine();

        System.out.println("Input Account Number: ");
        String accountNumber = bankScanner.nextLine();

        System.out.println("Input 6-digit PIN:");
        String pin = String.valueOf(bankScanner.nextLine().hashCode()); // Hashes the password using java hashcode

        System.out.println("Input initial balance: ");
        double balance = Double.valueOf(bankScanner.nextLine());

        Account newAcc = new Account(accountName, accountNumber, String.valueOf(pin.hashCode()), balance);
        return newAcc;

//        System.out.println("Input ");
    }

    public static Account createAccount(String name, String accountNumber, String pin, double balance) {
        Account newAccount = new Account(name, accountNumber, pin, balance);
        return newAccount;
    }

}
