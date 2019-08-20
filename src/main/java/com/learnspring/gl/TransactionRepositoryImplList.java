package com.learnspring.gl;

import java.util.HashMap;
import java.util.Map;

public class TransactionRepositoryImplList implements TransactionRepository {

    private AccountRepository accountRepository;
    private Map<Long, Transaction> transactions = new HashMap<Long, Transaction>();

    public TransactionRepositoryImplList(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean createTransaction(String debitAccountNumber, String creditAccountNumber, int amount) {

        Account debitAccount = accountRepository.findByAccountNumber(debitAccountNumber);
        Account creditAccount = accountRepository.findByAccountNumber(creditAccountNumber);

        if(debitAccount!=null & creditAccount!=null) {

            if (accountRepository.updateBalance(debitAccountNumber, debitAccount.getBalance() - amount) & accountRepository.updateBalance(creditAccountNumber, creditAccount.getBalance() + amount)) {

                Transaction transaction = new Transaction(debitAccountNumber, creditAccountNumber, amount);
                transactions.put(transaction.getTransactionID(), transaction);
                return true;
            }
        }
        return false;
    }
}
