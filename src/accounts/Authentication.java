package accounts;

import java.util.HashMap;
import java.util.Scanner;

/**
 * authenticator returns false if authentication is unsuccessful
 * returns true if successful
 *
 */
public class Authentication {
    final Scanner scanner = new Scanner(System.in);
    Account account;

    public Authentication(Account account) {
        this.account = account;
    }

    public boolean Authenticate() {

        String pin = account.getHashedPassword();

        System.out.println("Enter 6-digit PIN");

        int attempts = 0;
        while (attempts < 3) {
            System.out.println("Enter 6-digit pin");
            String input = scanner.nextLine();

            // Checks if length of pin is wrong
            if (input.length() != 6) {
                System.out.println("You must enter a 6-digit pin");
                continue;
            }

            // Checks if pin is wrong
            if (!String.valueOf(input.hashCode()).equals(pin)) {
                System.out.println("Wrong pin");
                attempts++;
                continue;
            }

            // executes if the checkpoints are passed
            return true;
        }

        return false;
    }
}
