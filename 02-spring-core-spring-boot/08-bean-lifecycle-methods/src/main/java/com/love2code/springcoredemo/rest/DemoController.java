package com.love2code.springcoredemo.rest;

import com.love2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a private field for the dependency
    private Coach myCoach;


    // Define a Constructor for the Dependency Injection

    // @Qualifier ----> In the Case of Multiple Coach implementation we resolved it 
    // Alternate Solution---> @Primary out of multiple coaches

    @Autowired
    public void setCoach(@Qualifier("cricketCoach") Coach theCoach){
        System.out.println("In Constructor: "+getClass().getSimpleName());
        myCoach=theCoach;


    }

             //  /dailyworkout
//    Web Browser-------------> DemoController------->Coach


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        System.out.println("api hit here");
        return myCoach.getDialyWorkout();

    }

}
