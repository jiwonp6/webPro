package com.lec.ex04_object;

public class Ex01_SawonTestMain {
	public static void main(String[] args) {
		
	
	Sawon s1 = new Sawon("a01", "ȫ�浿", Dept.COMPUTER);
	Sawon s2 = new Sawon("a02", "�ű浿", Dept.HUMANRESOURCES, 2022, 3, 24);
	System.out.println(s1.toString()); // [���]a01 [�̸�]ȫ�浿 [�μ�]COMPUTER [�Ի���]2022��3��24��(��)
	System.out.println(s2);
	Sawon2 s3 = new Sawon2("c01","���浿",Dept2.PLANNING, 2022,3,10);
	System.out.println(s3);
	
	}
}
