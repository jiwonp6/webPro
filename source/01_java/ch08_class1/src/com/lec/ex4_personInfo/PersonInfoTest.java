package com.lec.ex4_personInfo;

public class PersonInfoTest {
	public static void main(String[] args) {
		PersonInfo park = new PersonInfo("������", 24, 'w');
		park.print();
		System.out.println("");
		
//		<�迭�� ����1>
		int[] arr = new int[2];
		PersonInfo p1 =new PersonInfo("������", 21, 'm');
		PersonInfo p2 =new PersonInfo("������", 23, 'm');
		PersonInfo[] person = {p1, p2};
		p1.print();
		p2.print();
		
//		<�迭�� ����2>		
		PersonInfo[] person2 = new PersonInfo[2];
		//=>PersonInfo[] person = {new PersonInfo("������", 21, 'm'),
		//						 new PersonInfo("������", 23, 'm')};
		person2[0] = new PersonInfo("������", 21, 'm');
		person2[1] = new PersonInfo("������", 23, 'm');
		for(int idx=0 ; idx<person2.length ; idx++) {
			person2[idx].print();
		}
		for(PersonInfo p : person2) {
			p.print();
		}
	}
	
}
