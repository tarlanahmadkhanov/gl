package com.learnspring.gl;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class AccountRepositoryImplList implements AccountRepository {

    private Map<String, Account> accounts = new HashMap<String, Account>();
    private Random random = new Random();
    private final int ACCOUNT_RANGE = 10;



    public boolean createAccount(String customerID) {
        String accountNumber = "3801"+customerID+random.nextInt(ACCOUNT_RANGE);
        accounts.put(accountNumber, new Account(accountNumber, customerID));
        return true;
    }

    public boolean closeAccount(String accountNumber) {
        Account account = this.findByAccountNumber(accountNumber);
        if (account!=null) {
            account.setStatus('C');
            accounts.put(accountNumber, account);
            return true;
        }
        return false;
    }

    public Account findByAccountNumber(String accountNumber) {
        for (Map.Entry<String, Account> entry:accounts.entrySet()) {
            if (entry.getKey().substring(4,10).equals(accountNumber)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Map<String, Account> findByCustomerID(String customerID) {
        Map<String, Account> results = new HashMap<String, Account>();

        for (Map.Entry<String, Account> entry:accounts.entrySet()) {
            if (entry.getKey().substring(4,10).equals(customerID)) {
                results.put(entry.getKey(), entry.getValue());
            }
        }
        return results;

    }
    public Map<String, Account> findAll() {
        return accounts;
    }

    public boolean updateBalance(String accountNumber, int amount) {
        Account account = this.findByAccountNumber(accountNumber);
        if (account!=null) {
            account.setBalance(amount);
            accounts.put(accountNumber, account);
            return true;
        }
        return false;
    }
}
