package com.ironman.aopdemo.DAO;

import com.ironman.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    //add a new method : findAccounts()


    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    void addAccount(Account theAccount, boolean vipFlag);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    public String getName();

    public void setName(String name);

}
