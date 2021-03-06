package com.study.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public Friend friend() {
		//Constructor
		Friend b = new Friend("BMW", 30) ;
		return b ;
	}
	
	@Bean(name="hello")
	public Car car() {
		return new Car("BMW") ;
	}
	
	@Bean
	public Owner owner() {
		return new Owner("JeonUChi", new Car("audi")) ; 
	}
}
