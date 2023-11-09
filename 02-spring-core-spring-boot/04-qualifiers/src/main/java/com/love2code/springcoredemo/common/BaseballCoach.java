package com.love2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    @Override
    public String getDialyWorkout() {
       return "Practice daily 1 hour";
    }

   

    
}
