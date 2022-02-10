import accounts.Account;
import accounts.Authentication;

import java.util.Scanner;

public class Transaction {
    Account account;
    Authentication auth;
    final static Scanner scanner = new Scanner(System.in);

    public Transaction(Account account) {
        this.account = account;
    }

    public void viewBalance() {
        Authentication auth = new Authentication(account);
        if (auth.Authenticate() == false) {
            System.out.println("Transaction failed, cannot authenticate");
            return;
        }

        System.out.println("Current Balance: " + account.getBalance());
    }


    public void withdraw(double amount) {
        // authenticate first
        // check balance
        // if balance < amount, return
        // if balance >= amount, update balance and get amount
        // then print statement (card number, account number, amount, remaining balance)

        // AUTHENTICATION
        Authentication auth = new Authentication(account);
        if (auth.Authenticate() == false) {
            System.out.println("Transaction failed, cannot authenticate");
            return;
        }

        double originalAmount = account.getBalance();

        if (amount > originalAmount) {
            System.out.println("Insufficient balance");
            return;
        }

        account.setBalance(originalAmount - amount);


        // ask if user wants statement
        this.statement(amount, "withdrawn");

        return;
    }


    public void deposit(double amount) {

        // check amount if less than 0
        // if less than 0, display error
        // if amount greater than 0, update amount

        if (amount < 0) {
            System.out.println("Amount is less than 0");
            return;
        }

        // AUTHENTICATION
        Authentication auth = new Authentication(account);
        if (auth.Authenticate() == false) {
            System.out.println("Transaction failed, cannot authenticate");
            return;
        }

        double originalAmount = account.getBalance();
        account.setBalance(originalAmount + amount);

        double newAmount = account.getBalance();

        // ask if user wants statement
        this.statement(amount, "deposited");
    }


    public void statement(double amount, String transactionType) {
        System.out.println("Do you want a receipt?(Y/N)");
        String option;

        do {
            option = scanner.nextLine();
        } while (!(option.toUpperCase().equals("Y") || option.toUpperCase().equals("N")));

        if (option.equals("Y")) {
            System.out.println();
            System.out.println("Statement:");
            System.out.println("Account Name:" + account.getAccountName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Amount " + transactionType + " :" + amount);
            System.out.println("Account Balance: " + account.getBalance());

            System.out.println();
            System.out.println();
        }
    }

    // Help option - change pin
    public void help() {
        System.out.println("Change PIN? (Y/press any other key");
        String option = scanner.nextLine();

        if (option.toUpperCase().equals("Y")) {

            Authentication auth = new Authentication(account);
            if (auth.Authenticate() == false) {
                System.out.println("Transaction failed, cannot authenticate");
                return;
            }

            System.out.println("Input new pin:");
            String newPin1 = scanner.nextLine();

            if (newPin1.length() != 6) {
                System.out.println("Error: Pin size is not 6");
            }


            System.out.println("Input new pin again:");
            String newPin2 = scanner.nextLine();
            if (newPin2.length() != 6) {
                System.out.println("Error: Pin size is not 6");
                return;
            }
            if (!newPin2.equals(newPin1)) {
                System.out.println("Error: Pin mismatch");
                return;
            }

            // Executes if checkpoint blocks are passed
            this.account.setHashedPassword(String.valueOf(newPin1.hashCode()));

        } else {
            System.out.println("Transaction cancelled");
            return;
        }
    }


}
