package com.study.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	// 빈(Bean) : Spring의 IoC방식으로 관리하는 객체
	// 빈 팩토리(Bean Factory) : Spring의 IoC를 담당하는 핵심 컨테이너
	// 어플리케이션 컨텍스트(ApplicationContext) : Bean Factory를 확장한 IoC컨테이너
	
	// Setter Injection( Setter 메서드를 이용한 의존성 주입 )
	@Bean
	public Member member1() {
		// Setter Injection( Setter 메서드 의존성 주입 )
		Member member1 = new Member();
		member1.setName("홍길동");
		member1.setNickname("쾌걸");
		member1.setPrinter(new PrinterA());
		
		return member1 ;
	}
	
	@Bean(name="hello")
	public Member member2() {
		// Constructor Injection( 생성자 의존성 주입 )
		return new Member("전우치", "도사", new PrinterA());
	}
	
	@Bean
	public PrinterA printerA() {
		return new PrinterA();
	}
	
	@Bean
	public PrinterB printerB() {
		return new PrinterB();
	}
}
