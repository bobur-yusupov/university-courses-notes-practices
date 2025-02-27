package bank.models;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private String accountNumber;
    private double amount;
    private Date date;
    private String type; // deposit, withdraw, transfer

    public Transaction(String transactionId, String accountNumber, double amount, Date date, String type) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public String getTransactionId() { return this.transactionId; }
    public String getAccountNumber() { return this.accountNumber; }
    public double getAmount() { return this.amount; }
    public Date getDate() { return this.date; }
    public String getType() { return this.type; }
}
