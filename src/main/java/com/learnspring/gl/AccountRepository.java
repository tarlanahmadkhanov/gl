package com.learnspring.gl;


import java.util.Map;

public interface AccountRepository {
    public boolean createAccount(String customerID);
    public boolean closeAccount(String accountNumber);
    public boolean updateBalance(String accountNumber, int amount);
    public Account findByAccountNumber(String accountNumber);
    public Map<String, Account> findByCustomerID(String customerID);
}
