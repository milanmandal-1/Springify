package com.luv2code.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach(){
        System.out.println("TennisCoach constructor"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "practice your backhand volley";
    }
}
