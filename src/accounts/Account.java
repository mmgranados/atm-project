package accounts;

public class Account {
    private String accountName;
    private String accountNumber;
    private String hashedPassword;
    private double balance;
    private boolean isBlocked;


    public Account(String accountName, String accountNumber, String hashedPassword, double balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.hashedPassword = hashedPassword;
        this.balance = balance;
        isBlocked = false;
    }
//    double transactionLimit;


    public String getAccountName() {

        try {
            this.checkIfBlocked();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return accountName;
    }

    public void setAccountName(String accountName) {

        try {
            this.checkIfBlocked();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.accountName = accountName;
    }

    public String getAccountNumber() {

        try {
            this.checkIfBlocked();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {

        try {
            this.checkIfBlocked();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.accountNumber = accountNumber;
    }

    public String getHashedPassword() {

        try {
            this.checkIfBlocked();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {

        try {
            this.checkIfBlocked();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.hashedPassword = hashedPassword;
    }

    public double getBalance() {

        try {
            this.checkIfBlocked();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return balance;
    }

    public void setBalance(double balance) {

        try {
            this.checkIfBlocked();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.balance = balance;
    }

    public void checkIfBlocked() throws Exception {
        if (isBlocked == true) {
            throw new Exception("Account is blocked");
        }
    }
}
