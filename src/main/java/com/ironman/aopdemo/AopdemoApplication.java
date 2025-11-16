package com.ironman.aopdemo;

import com.ironman.aopdemo.DAO.AccountDAO;
import com.ironman.aopdemo.DAO.MembershipDAO;
import com.ironman.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
                                               MembershipDAO theMembershipDAO,
                                               TrafficFortuneService theTrafficFortuneService) {

        return runner -> {
//            demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
//            demoTheAfterReturningAdvice(theAccountDAO);
//            demoTheAfterThrowingAdvice(theAccountDAO);
//            demoTheAfterAdvice(theAccountDAO);
//            demoTheAroundAdvice(theTrafficFortuneService);
//              demoTheAroundAdviceHandleException(theTrafficFortuneService);
            demoTheAroundRethrowException(theTrafficFortuneService);
        };
    }

    private void demoTheAroundRethrowException(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");

        System.out.println("Calling getFortune()");

        boolean tripWire =true;
        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy fortune is: "+data);

        System.out.println("Finished");
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");

        System.out.println("Calling getFortune()");

        boolean tripWire =true;
        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy fortune is: "+data);

        System.out.println("Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");
        System.out.println("Calling getFortune()");
        String data = theTrafficFortuneService.getFortune();
        System.out.println("\nMy fortune is: "+data);
        System.out.println("Finished");
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;

        try {
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program: ... caught exception:" + exc);
        }

        //display the accounts
        System.out.println("\n\nMain program: demoTheAfterAdvice");
        System.out.println("-------------------------------------------------");
        System.out.println("Accounts: " + theAccounts);

        System.out.println('\n');
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;

        try {
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program: ... caught exception:" + exc);
        }

        //display the accounts
        System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
        System.out.println("-------------------------------------------------");
        System.out.println("Accounts: " + theAccounts);

        System.out.println('\n');


    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

        List<Account> theAccounts = theAccountDAO.findAccounts();

        //display the accounts
        System.out.println("\n\nMain program: demoTheAfterReturningAdvice");
        System.out.println("-------------------------------------------------");
        System.out.println("Accounts: " + theAccounts);

        System.out.println('\n');
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        //call the business method
        Account myAccount = new Account();
        myAccount.setName("Madhu");
        myAccount.setLevel("Platinum");

        theAccountDAO.addAccount(myAccount, true);

        //call the accountdao getter/setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        //call the membership business method
        theMembershipDAO.addsAccount();
    }
}