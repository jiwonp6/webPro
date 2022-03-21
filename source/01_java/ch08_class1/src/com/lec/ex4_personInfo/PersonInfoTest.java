package com.lec.ex4_personInfo;

public class PersonInfoTest {
	public static void main(String[] args) {
		PersonInfo park = new PersonInfo("박지원", 24, 'w');
		park.print();
		System.out.println("");
		
//		<배열로 실행1>
		int[] arr = new int[2];
		PersonInfo p1 =new PersonInfo("박지성", 21, 'm');
		PersonInfo p2 =new PersonInfo("이제노", 23, 'm');
		PersonInfo[] person = {p1, p2};
		p1.print();
		p2.print();
		
//		<배열로 실행2>		
		PersonInfo[] person2 = new PersonInfo[2];
		//=>PersonInfo[] person = {new PersonInfo("박지성", 21, 'm'),
		//						 new PersonInfo("이제노", 23, 'm')};
		person2[0] = new PersonInfo("박지성", 21, 'm');
		person2[1] = new PersonInfo("이제노", 23, 'm');
		for(int idx=0 ; idx<person2.length ; idx++) {
			person2[idx].print();
		}
		for(PersonInfo p : person2) {
			p.print();
		}
	}
	
}
