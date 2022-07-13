package com.lec.ch03.ex1;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class StudentInfo {
	@Autowired	//알아서 필요한 의존객체인 Student 객체를 찾아 주입
	private Student student;
}
