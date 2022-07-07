package com.study.springbean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springboot.Car;
import com.study.springboot.Config;
import com.study.springboot.Friend;
import com.study.springboot.Owner;

@SpringBootApplication
public class Springdi3Application {

	public static void main(String[] args) {
//		SpringApplication.run(Springdi3Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Friend f = (Friend)context.getBean("friend") ;
		System.out.println(f.getName());
		System.out.println(f.getAge());
		
		Car c = (Car)context.getBean("hello", Car.class);
		System.out.println(c.getModel());
		
		Owner o = (Owner)context.getBean("owner");
		System.out.println(o.getCar());
		System.out.println(o.getName());
	}

}
