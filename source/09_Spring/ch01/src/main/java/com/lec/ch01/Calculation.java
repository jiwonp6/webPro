package com.lec.ch01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//어노테이션
@Data	//게터&세터
@NoArgsConstructor	//매개변수 없는 생성자
@AllArgsConstructor	//매개변수 있는 생성자
public class Calculation {
	private int num1;
	private int num2;
	public void add() {
		System.out.println("더하기");
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
	}
	public void sub() {
		System.out.println("빼기");
		System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
	}
	public void mul() {
		System.out.println("곱하기");
		System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
	}
	public void div() {
		System.out.println("나누기");
		System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
	}
}
