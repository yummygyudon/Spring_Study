package com.study.springbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
	public AsianaTicket a() {
		AsianaTicket at = new AsianaTicket();
		at.ticketing();
		return at ;
	}
	
	@Bean
	public KalTicket k() {
		KalTicket kt = new KalTicket() ;
		kt.ticketing();
		return kt ;
	}
}
