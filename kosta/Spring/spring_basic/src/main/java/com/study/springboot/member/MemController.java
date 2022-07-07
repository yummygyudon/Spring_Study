package com.study.springboot.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member") // 본 Controller의 공통 url
public class MemController {
	@Autowired // 의존성 자동 주입
	private MemberService service;
	
	@GetMapping("/index") // /member/index 으로 설정
	public void index() {
	}
	
	@GetMapping("/join") // /member/join 으로 설정
	public void joinForm() {
	}
	
	@PostMapping("/join") // member/join에 POST로 요청이 왔을 경우
	public String join(@ModelAttribute("m") Member m) {
		String path = "member/join_result"; // 위에서 생성한 ModelAttribute "m" -> 속성에 m이라는 이름으로 Member 객체를 던져주는 것
		return path ;
	}
	
	@GetMapping("/login")
	public void loginForm() {
		
	}
	@PostMapping("/login")
	public void login(String id, String pwd) {
		System.out.println(id);
		System.out.println(pwd);
	}
	
	@RequestMapping("/getstr")
	public void getstr(Map<String,Object> mp) { 
		//@RequestMapping 되는 메서드의 파라미터가 커맨드 객체, Map, ModelMap이면 자동으로 View페이지로 전달
		String str = service.getStr();
		Member m = service.getMember();
		mp.put("str", str);
		mp.put("m", m);
	}
}
