package com.love2code.springcoredemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDialyWorkout() {
        return "Practice Bowling for 30 minutes Daily !!!!!";
    }


}
