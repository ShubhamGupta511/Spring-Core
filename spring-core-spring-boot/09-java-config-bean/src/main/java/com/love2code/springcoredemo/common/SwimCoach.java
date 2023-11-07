package com.love2code.springcoredemo.common;


public class SwimCoach implements Coach{
	
	public SwimCoach() {
		System.out.println("In Constructor: "+getClass().getSimpleName());
	}

	@Override
	public String getDialyWorkout() {
		return "Swim for 1000 meters minutes dialy";
	}

}
