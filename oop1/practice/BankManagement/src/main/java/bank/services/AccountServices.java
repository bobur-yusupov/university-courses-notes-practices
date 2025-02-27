package bank.services;

import bank.models.Account;
import bank.models.User;
import bank.exceptions.InsufficientFundsException;
import bank.utils;

public class AccountServices {
    public Account createAccount(User user, String accountHolder) {
        String newAccountNumber = utils.generateID();

        return new Account(newAccountNumber, accountHolder, 0);
    }

    public void deposit(Account account, double amount) {
        try {
            account.deposit(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(Account account, double amount) {
        try {
            account.withdraw(amount);
        } catch (IllegalArgumentException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void transfer(Account fromAccount, Account toAccount, double amount) {
        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } catch (IllegalArgumentException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean validateAccount(String accountNumber) {
        return accountNumber.matches("^[0-9]{4}$");
    }

    private boolean validateAccount(String accountNumber, String accountHolder) {
        return accountNumber.matches("^[0-9]{4}$") && accountHolder.matches("^[a-zA-Z ]+$");
    }
}
