package com.ironman.aopdemo.aspect;

import com.ironman.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Around("execution(* com.ironman.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theproceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theproceedingJoinPoint.getSignature().toShortString();
        System.out.println("========> Executing @after (finally) on method: " + method);


        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now, let's execute the method
        Object result = null;
        try {
            theproceedingJoinPoint.proceed();
        }
        catch (Exception exc) {
            //log the exception
            System.out.println(exc.getMessage());

//            //give user a custom message
//            result = "major accident ! But no worries, your private AOP helicopter is on the way!";
                throw exc;
        }
        //get and timestamp
        long end = System.currentTimeMillis();

        //compute duration and display it
        long duration = end - begin;
        System.out.println("\n=======> Duration:" + duration / 1000.0 + " seconds");
        return result;
    }

    @After("execution(* com.ironman.aopdemo.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("========> Executing @after (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.ironman.aopdemo.DAO.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint,
            Throwable theExc) {
        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("========> Executing @afterThrowing on method: " + method);
    }

    //add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.ironman.aopdemo.DAO.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccounntsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        //print out which method we are advicing on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("========> Executing @afterReturning on method: " + method);

        //print out the results of the method call
        System.out.println("=========> result is milu: " + result);

        convertAccountNameToUpperCase(result);

        System.out.println("=========> result is milu: " + result);


    }

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

    @Before("com.ironman.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    private void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n======>>>> Executing @Before advice");
        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display the method arguments

        //get args
        Object[] args = theJoinPoint.getArgs();

        //loop thru args

        for (Object tempArg : args) {
            System.out.println("tenpArg: " + tempArg);
            if (tempArg instanceof Account) {
                //downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account Level: " + theAccount.getLevel());
            }
        }
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }


}