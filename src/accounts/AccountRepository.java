package accounts;

import java.util.HashMap;

public class AccountRepository {
    HashMap<String, Account> accountList;


    // If a hashmap is passed as parameter, it will create a reference to that hashmap
    public AccountRepository(HashMap<String, Account> accountList) {
        this.accountList = accountList;
    }

    // If there are no parameters, this will initialize a hashmap to store accounts
    public AccountRepository() {
        this.accountList = new HashMap<String, Account>();
    }

    public void addAccount(Account account) {
        accountList.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accountList.getOrDefault(accountNumber, null);
    }

}
