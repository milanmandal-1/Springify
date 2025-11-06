package com.luv2code.springboot.demo.mycoolapp.common;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy

public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("CricketCoach constructor"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
