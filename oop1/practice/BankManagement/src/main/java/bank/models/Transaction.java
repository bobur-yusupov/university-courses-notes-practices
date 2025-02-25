package bank.models;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private String accountNumber;
    private double amount;
    private Date date;
    private String type; // deposit, withdraw, transfer
}
