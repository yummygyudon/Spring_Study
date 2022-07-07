package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springbean.Config;
import com.study.springbean.SportsCar;
import com.study.springbean.Truck;

@SpringBootApplication
public class Springdi0Application {

	public static void main(String[] args) {
		SpringApplication.run(Springdi0Application.class, args);
	
		//1. IoC 컨테이너 생성 ( 각 객체를 생성하는 생성자 정보가 있는 Config의 정보 가져오기 )
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		//2. Member Bean 기져오기
		SportsCar sportscar = (SportsCar)context.getBean("SportsCar");
		sportscar.go();
		
		//3. name속성 설정한 Bean name으로 가져오기
		Truck truck = context.getBean("hello", Truck.class);
		truck.go();
	
	}

}
