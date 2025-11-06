package com.luv2code.springboot.demo.mycoolapp.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("TrackCoach constructor"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "track the coach for 20min";
    }
}
