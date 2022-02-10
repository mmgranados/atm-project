import accounts.Account;
import accounts.AccountRepository;

import java.util.Scanner;

public class ATMMachine{
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        AccountRepository accountList = new AccountRepository();

        loadTestCredentials(accountList);
        boolean isSessionDone = false;
        boolean areTransactionsDone = false;

        while (isSessionDone == false && areTransactionsDone == false) {    // exit condition
            System.out.println("Choose:");
            System.out.println("1 - Use ATM Machine");
            System.out.println("2 - Visit the bank (Create account or view account details)");
            System.out.println("press any other key - Do nothing");
            String option = scanner.nextLine();



            switch (option) {
                case "1":
                    System.out.println("Input account number: ");
                    String accountNum = scanner.nextLine();
                    Account checkAccount = accountList.getAccount(accountNum);
                    if (checkAccount == null) {
                        System.out.println("Account id " + accountNum +" does not exist");
                        break;
                    }

                    while (areTransactionsDone == false) {
                        startTransaction(checkAccount);

                        System.out.println("Do you want to do another transaction? (1 - yes/ any other key - no");
                        String anotherTransaction = scanner.nextLine();
                        if (anotherTransaction.equals("1")) {
                            areTransactionsDone = false;
                        } else {
                            areTransactionsDone = true;
                        }
                    }

                    break;

                case "2":
                    // Makes an account in the bank
                    // Simulates visiting the bank and filling up the details there.
                    Account createdAccount = Bank.createAccount();
                    accountList.addAccount(createdAccount);
                    break;
            }

            // Get account
            // start transaction
            // authenticate
            // ask if statement or receipt is to be printed


            System.out.println("Do you want to insert another card? (1 - Yes/ 2 - No)");
            String insertAnotherCard = scanner.nextLine();

            if (insertAnotherCard.equals("1")) {
                isSessionDone = false;
            } else {
                isSessionDone = true;
            }
        }
    }

    public static void loadTestCredentials(AccountRepository accountRepository) {
        Account mikojerg = new Account("Miko Granados", "123", String.valueOf("555555".hashCode()), 1000);
        Account jopat = new Account("Jopat Notario", "456", String.valueOf("696969".hashCode()), 9999.99);
        Account ariel = new Account("Ariel Breboneria", "789", String.valueOf("123456".hashCode()), 0);

        accountRepository.addAccount(mikojerg);
        accountRepository.addAccount(jopat);
        accountRepository.addAccount(ariel);

    }

    public static boolean startTransaction(Account account) {
        Transaction newTransaction = new Transaction(account);

        System.out.println();
        System.out.println("Choose transaction type:");
        System.out.println("1 - Check Balance");
        System.out.println("2 - Deposit");
        System.out.println("3 - Withdraw");
        System.out.println("4 - Help/ Change Pin");
        String option = scanner.nextLine();

        switch(option) {
            case "1":
                newTransaction.viewBalance();
                break;
            case "2":
                System.out.println("Enter amount:");
                double depositAmount = Double.valueOf(scanner.nextLine());
                newTransaction.deposit(depositAmount);
                break;
            case "3":
                System.out.println("Enter amount:");
                double withdrawAmount = Double.valueOf(scanner.nextLine());
                newTransaction.withdraw(withdrawAmount);
                break;
            case "4":
                newTransaction.help();
                break;

        }

        return false;
    }
}
