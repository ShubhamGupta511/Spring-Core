package com.love2code.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDialyWorkout() {
        return "Practice Bowling for 30 minutes Daily :-)";
    }


}
