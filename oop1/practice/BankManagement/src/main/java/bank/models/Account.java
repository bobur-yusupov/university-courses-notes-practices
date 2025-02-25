package bank.models;

import java.util.List;
import java.util.ArrayList;
import bank.exceptions.InsufficientFundsException;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<Transaction> transactionHistory = new ArrayList<>();

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() { return this.accountNumber; }
    public String getAccountHolder() { return this.accountHolder; }
    public double getBalance() { return this.balance; }
    public List<Transaction> getTransactionHistory() { return this.transactionHistory; }

    public void setAccountNumber(String newAccountNumber) { this.accountNumber = newAccountNumber; }
    public void setAccountHolder(String newAccountHolder) { this.accountHolder = newAccountHolder; }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should not be negative or 0");
        }

        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should not be negative or 0");
        }

        if (amount > this.balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }

        this.balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionHistory.add(transaction);
    }
}

/*
* if a class constructor does not have access modifier, by default it will have package-private
* it is default constructor which gives access to only within package but not out of package
* */