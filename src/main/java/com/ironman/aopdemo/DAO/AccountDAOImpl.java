package com.ironman.aopdemo.DAO;


import com.ironman.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccountDAO,boolean vipFlag) {
        System.out.println(getClass()+": Doing my DB work: Adding an account");
    }


}