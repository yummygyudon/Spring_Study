package com.study.springbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	// 빈(Bean) : Spring의 IOC 방식으로 관리하는 객체
	@Bean
	public SportsCar SportsCar() {
		SportsCar sportscar = new SportsCar();
		sportscar.go();
		return sportscar;
	}
	
	@Bean(name="hello")
	public Truck Truck() {
		Truck truck = new Truck();
		truck.go();
		return truck ;
	}
}
