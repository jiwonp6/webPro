package com.lec.ex06_wrapper;

public class Ex02 {
	public static void main(String[] args) {
		// Wrapper 클래스는 기초데이터를 객체데이터로 변환 해주는 클래스이다.

		double i = 10.1;
		double j = 10.1;
		double sum = i + j;
		System.out.println("합은 : " + sum);
		System.out.println(i == j ? "두 double은 같다" : "두 double은 다르다");
		Double iObj = 10.1;
		Double jObj = 10.1;
		sum = iObj + jObj;     // iObj.intValue() + jObj.intValue();
		System.out.println("합은 : " + sum);
		System.out.println(iObj.equals(jObj) ? "두 wrapper객체 값은 같다" : "두 wrapper객체 값은 다르다");
		System.out.println(iObj == jObj ? "주소가 같다" : "주소가 다르다");

	}
}
