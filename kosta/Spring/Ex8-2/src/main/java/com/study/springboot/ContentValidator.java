package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {
	// Validator : 유효성 검사 기구
	@Override
	public boolean supports(Class<?> arg0) {
		// 검증할 객체의 클래스 타입 정보
		return ContentDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ContentDTO dto = (ContentDTO)target ;
		String sWriter = dto.getWriter();
		if(sWriter==null || sWriter.trim().isEmpty()) {
			System.out.println("Writer is null or empty");
			errors.rejectValue("writer", "trouble");
		}
		
		ValidatorUtils.rejectIfEmptyOrWhitespace(errors)
		
		String sContent = dto.getContent();
		if(sContent==null || sContent.trim().isEmpty()) {
			System.out.println("Content is null or empty");
			errors.rejectValue("content", "trouble");
		}
	}
		
		String sContent = dto.getContent();
		if(sContent==null || sContent.trim().isEmpty()) {
			System.out.println("Content is null or empty");
			errors.rejectValue("content", "trouble");
		}
	}
	
}
