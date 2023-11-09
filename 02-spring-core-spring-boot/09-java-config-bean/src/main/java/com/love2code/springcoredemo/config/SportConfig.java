package com.love2code.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.love2code.springcoredemo.common.Coach;
import com.love2code.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
	
	// @Bean use case---> third party class and expose as a spring bean
	
	
	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}

}
