package com.learnspring.gl;

public class Account {
    private String accountNumber;
    private int balance;
    private char status;
    private String customerID;

    public Account(String accountNumber, String customerID) {
        this.accountNumber = accountNumber;
        this.customerID = customerID;
        this.balance = 0;
        this.status = 'O';
    }

    @Override
    public String toString() {
        return this.accountNumber+"~"+this.customerID+"~"+this.balance+"~"+this.status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}
