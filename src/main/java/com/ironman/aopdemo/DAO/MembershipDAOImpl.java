package com.ironman.aopdemo.DAO;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addsAccount() {
        System.out.println(getClass() + ": Doing my DB work: Adding a membership account");
        return true;
    }
}