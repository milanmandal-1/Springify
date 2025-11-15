package com.ironman.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is where we add of our related advice for logging

    //let's start with an @Before advice

//    @Before("execution(public void com.ironman.aopdemo.DAO.AccountDAO.addAccount())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n======>>>> Executing @Before advice an addAccount()");
//    }

//    @Before("execution(void add*())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n======>>>> Executing @Before advice an addAccount()");
//    }

//    @Before("execution(* add*())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n======>>>> Executing @Before advice an addAccount()");
//    }
// method parameter type
//    @Before("execution(* add*(com.ironman.aopdemo.Account))")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n======>>>> Executing @Before advice an addAccount()");
//    }

// any number of parameters
//    @Before("execution(* add*(com.ironman.aopdemo.Account,..))")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n======>>>> Executing @Before advice

    @Before("execution(* add*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>>> Executing @Before advice\n");
    }
}