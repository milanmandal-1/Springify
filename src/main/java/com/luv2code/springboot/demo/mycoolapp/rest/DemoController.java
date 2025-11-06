package com.luv2code.springboot.demo.mycoolapp.rest;

import com.luv2code.springboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependecy
    private Coach myCoach;

    private Coach anotherCoach;

    public DemoController(@Qualifier("trackCoach") Coach theCoach,
                          @Qualifier("trackCoach") Coach theAnotherCoach) {
        myCoach = theCoach;
        anotherCoach=theAnotherCoach;
        System.out.println("Democontroller constructor"+getClass().getSimpleName());
    }

    //define a constructor for dependdency injection
//    @Autowired
//    public DemoController(Coach theCoach) {
//        myCoach = theCoach;
//        System.out.println(myCoach.getDailyWorkout());
//    }


//    @Autowired
//    public void setMyCoach(@Qualifier("trackCoach")Coach theCoach) {
//        this.myCoach = theCoach;
//    }

//    @Autowired
//    public void setMyCoach(Coach theCoach) {
//        this.myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "comparing beans: myCoach==anotherCoach "+(myCoach ==anotherCoach);
    }
}