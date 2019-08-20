package com.learnspring.gl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Transaction {
    private Long transactionID;
    private String debitAccountNumber;
    private String creditAccountNumber;
    private int amount;
    private Date transactionDate;

    public Transaction(String debitAccountNumber, String creditAccountNumber, int amount) {
        this.transactionID = new Random().nextLong();
        this.debitAccountNumber = debitAccountNumber;
        this.creditAccountNumber = creditAccountNumber;
        this.amount = amount;
        this.transactionDate = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        return this.transactionID+"~"+this.debitAccountNumber+"~"+this.creditAccountNumber+"~"+this.amount+"~"+simpleDateFormat.format(this.transactionDate);
    }

    public Long getTransactionID() {
        return transactionID;
    }
}
