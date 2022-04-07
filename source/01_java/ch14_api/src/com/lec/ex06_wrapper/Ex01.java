package com.lec.ex06_wrapper;

public class Ex01 {
	public static void main(String[] args) {
		// Wrapper 클래스는 기초데이터를 객체데이터로 변환 해주는 클래스이다.

		int i = 10;
		int j = 10;
		int sum = i + j;
		System.out.println("합은 : " + sum);
		System.out.println(i == j ? "두 int는 같다" : "두 int는 다르다");
		Integer iObj = new Integer(10);
		Integer jObj = 10; // 위아래 둘다 결국 10
		sum = iObj.intValue() + jObj.intValue();
		System.out.println("합은 : " + sum);
		System.out.println(iObj.equals(jObj) ? "두 wrapper객체 값은 같다" : "두 wrapper객체 값은 다르다");
		System.out.println(iObj == jObj ? "주소가 같다" : "주소가 다르다");

		// if ( s.equals(i)) { // 왼쪽이 원래는 이런형태 알아서 객체형으로 변환해줌 s.equals(new Integer(10))

	}
}
