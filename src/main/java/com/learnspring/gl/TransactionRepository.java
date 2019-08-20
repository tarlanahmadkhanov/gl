package com.learnspring.gl;

public interface TransactionRepository {
    public boolean createTransaction(String debitAccountNumber, String creditAccountNumber, int amount);
}
