package bank.models;

import java.util.List;
import java.util.ArrayList;

public class User {
    private String userId;
    private String name;
    private String email;
    private List<Account> accounts = new ArrayList<>();

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getUserId() { return this.userId; }
    public String getName() { return this.name; }
    public String getEmail() { return this.email; }
    public List<Account> getAccounts() { return this.accounts; }
    public void addAccount(Account newAccount) {
        this.accounts.add(newAccount);
    }
}
