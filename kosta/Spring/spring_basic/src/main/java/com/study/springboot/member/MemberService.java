package com.study.springboot.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	public String getStr() {
		return "hello data";
	}
	
	public Member getMember() {
		return new Member("ccc", "333", "namec", "ccc@email.com");
	}
}
