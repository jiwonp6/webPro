package com.lec.ex10_customer;
//name, tel, hiredate(입사일), department(부서)
// Staff s = new Staff("홍", "010", "2022-09-01", "개발팀")
public class Staff extends Person {
	private String hiredate;
	private String department;
	
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}
	//sysout(s.infoString) - [이름]홍 [전화]010 [입사일]2022-09-01 [부서]개발팀
	@Override
	public String infoString() {
		return super.infoString() +"[입사일]"+hiredate+" [부서]"+department;
	}


}
