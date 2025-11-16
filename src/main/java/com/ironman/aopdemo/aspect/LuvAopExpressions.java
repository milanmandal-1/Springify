package com.ironman.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.ironman.aopdemo.DAO.*.*(..))")
    public void forDaoPackage() {
    }

    //Create pointcut for getter methods
    @Pointcut("execution(* com.ironman.aopdemo.DAO.*.get*(..))")
    public void getter() {
    }

    //create pointcut for setter methods
    @Pointcut("execution(* com.ironman.aopdemo.DAO.*.set*(..))")
    public void setter() {
    }

    //create pointcut: include package.....exclude getter/setter
    @Pointcut("forDaoPackage() && ! (getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}