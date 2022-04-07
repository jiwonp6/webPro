package com.lec.ex01_string;

public class Ex10_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		System.out.println("해쉬코드 결과 : "+str.hashCode());
		str =str + "d";
		System.out.println("해쉬코드 바뀐 결과 : "+str.hashCode());
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("해쉬코드 결과2 : "+strBuilder.hashCode());
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.append("def");	//abc에 def 추가
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.insert(3, "AAA");	//3번째에 "AAA" 추가 abcAAAdef
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.delete(3, 5);	//3~5번째 앞까지 삭제 : abcAdef
		System.out.println("strBuilder : "+strBuilder);
		System.out.println("해쉬코드 결과 : "+strBuilder.hashCode());
		strBuilder.deleteCharAt(3);	//3번째 문자만 삭제 delete(3,4)
		System.out.println("strBuilder : "+strBuilder);
		System.out.println("해쉬코드 결과 : "+strBuilder.hashCode());
	}
	
}
