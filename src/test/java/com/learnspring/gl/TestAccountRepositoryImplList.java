package com.learnspring.gl;


import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestAccountRepositoryImplList {

    private AccountRepositoryImplList accountRepositoryImplList = new AccountRepositoryImplList();

    @Test
    public void testCreateAccount() {
        boolean res = accountRepositoryImplList.createAccount("000001");
        assertTrue(res);

    }
    @Test
    public void testFindByCustomerID() {
        boolean b1 = accountRepositoryImplList.createAccount("100000");
        boolean b2 = accountRepositoryImplList.createAccount("100000");
        Map<String, Account> map = accountRepositoryImplList.findByCustomerID("100000");
        for (Map.Entry<String, Account> entry:map.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
        assertEquals(map.size(),2);
    }

    @Test
    public void testFindAll() {
        this.testCreateAccount();
        this.testCreateAccount();
        this.testCreateAccount();
        this.testCreateAccount();
        Map<String, Account> map = accountRepositoryImplList.findAll();
        for (Map.Entry<String, Account> entry:map.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
        assertTrue(true);
    }
}
