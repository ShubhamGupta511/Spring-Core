package com.love2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getDialyWorkout() {
        return "Practice the tennis daily for 1 hours :-)";
    }
    
}
