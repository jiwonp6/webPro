package com.lec.ex04_object;

public class Ex01_SawonTestMain {
	public static void main(String[] args) {
		
	
	Sawon s1 = new Sawon("a01", "홍길동", Dept.COMPUTER);
	Sawon s2 = new Sawon("a02", "신길동", Dept.HUMANRESOURCES, 2022, 3, 24);
	System.out.println(s1.toString()); // [사번]a01 [이름]홍길동 [부서]COMPUTER [입사일]2022년3월24일(목)
	System.out.println(s2);
	Sawon2 s3 = new Sawon2("c01","마길동",Dept2.PLANNING, 2022,3,10);
	System.out.println(s3);
	
	}
}
