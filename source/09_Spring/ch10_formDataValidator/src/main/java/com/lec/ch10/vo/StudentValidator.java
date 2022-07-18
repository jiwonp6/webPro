package com.lec.ch10.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);	//검증할 객체의 클래스 타입 명시
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 컨트롤러에서 호출 : validate(student, errors) 호출
		Student student = (Student)target;	//형변환
		String name = student.getName();
		int id = student.getId();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no"); //name 에러 등록
		/*
		=if(name == null || name.trim().isEmpty()) {
			// name 에러
			errors.rejectValue("name", "no");	//name 에러 등록
		 }
		*/
		if(id<=0) {
			errors.rejectValue("id", "no"); //id 에러 등록
		}
	}
	
}
