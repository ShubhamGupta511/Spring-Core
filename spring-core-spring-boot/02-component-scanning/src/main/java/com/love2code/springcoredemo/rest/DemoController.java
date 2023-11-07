package com.love2code.springcoredemo.rest;

import com.love2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a private field for the dependency
    private Coach myCoach;

    // Define a Constructor for the Dependency Injection
    @Autowired
    public DemoController(Coach theCoach){
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
