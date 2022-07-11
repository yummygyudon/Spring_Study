package com.encore.demo.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// GET은 데이터를 뿌려줄 때 주로 사용

@Controller
@RequestMapping("/member") // Member 전용 Controller이니 GET이든 POST든 모두 해당 Controller로 오도록
public class MemberController {
	
	@Autowired
	private MemberService service ;
	
	
	
	
	@GetMapping("/join") // GET 방식의 " /member/join "만 허용
	public void joinForm() { // 요청 처리 및 결과 페이지 경로 반환 , 반환값이 void면 " 요청 url과 동일한 경로 "로 반환된다 -> 블럭 내부에 코드가 없어도 redirect 되는 이유
	}
	
	@PostMapping("/join") // POST 방식의 " /member/join "만 허용
	public String join(Member m) {
		System.out.println(m);
		service.addMember(m);
		return "redirect:/member/login" ;
	}
	
	
	@GetMapping("/login")
	public void loginForm() {
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, HttpSession session) {
		Member m = service.getMember(id);
		String path = "member/login" ;
		if(m != null && m.getPwd().equals(pwd)) {
			session.setAttribute("loginid", id);
			path = "member/menu" ;
		}
		return path ;
	}
	
	
	
	@GetMapping("/myinfo")
	public void info(HttpSession session, Map<String, Member> map) { //매개변수로 map을 넘겨주면 해당 map 객체는 해당 페이지로 넘어간다.
		String id = (String)session.getAttribute("loginid");
		Member m = service.getMember(id);
		map.put("m", m);
	}
	
	@GetMapping("/menu")
	public void menu() {
	}
	
	@PostMapping("/edit")
	public String edit(Member m) {
		service.editMember(m);
		return "member/menu";
	}
	
	
	
	@GetMapping("/list")
	public void list(Map<String, ArrayList<Member> > map) {
		ArrayList<Member> list = service.getAll();
		map.put("list", list) ;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// session.removeAttribute("loginid");
		session.invalidate();
		return "redirect:/member/login" ;
	}
	
	@GetMapping("/out")
	public String out(HttpSession session) {
		// session.removeAttribute("loginid");
		String id = (String)session.getAttribute("loginid");
		service.delMember(id) ;
		return "redirect:/member/login" ;
	}
	
	@ResponseBody
	@RequestMapping("/idcheck") // GET&POST  모두 허용
	public Map<String, Boolean> idCheck(String id) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		System.out.println(id);
		
		Member m = service.getMember(id);
		System.out.println(m);
		boolean flag = false;
		if (m==null) {
			flag = true ;
		}
		map.put("flag", flag);
		return map;
	}
}
