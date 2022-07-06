package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "Validator(1)";
	}
	@RequestMapping("/insertForm")
	public String insert() {
		return "create" ;
	}
	// 직접 Attibute 접근
	@RequestMapping("/create")
	public String insert2(@ModelAttribute("dto") ContentDTO contentdto, BindingResult result) {
		
		String page="createDonePage";
		System.out.println(contentdto) ;
		
		// 유효성 검사 이후, 오류 발생시 다시 create 페이지로
		// 문제 없을 땐, createDonePage 로
		ContentValidator validator = new ContentValidator();
		validator.validate(contentdto, result);
		if (result.hasErrors()) {
			page="create";
		}
		return page ;
	}
	
}
