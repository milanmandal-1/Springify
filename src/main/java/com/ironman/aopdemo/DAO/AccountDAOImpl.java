package com.ironman.aopdemo.DAO;


import com.ironman.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;

    private String serviceCode;

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in   SetName()");
        this.name = name;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        // for academic purpose ... simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!");
        }

        List<Account> myAccounts = new ArrayList<>();
        //create sample accounts
        Account temp1 = new Account("john", "silver");
        Account temp2 = new Account("Milan", "Mandal");
        Account temp3 = new Account("john", "gold");

        //add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;

    }

    @Override
    public void addAccount(Account theAccountDAO, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my DB work: Adding an account");
    }
}