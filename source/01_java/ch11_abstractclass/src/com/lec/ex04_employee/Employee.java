package com.lec.ex04_employee;

public abstract class Employee {
	private String name;
	private int sang;
	//»ı¼ºÀÚ
	public Employee(String name) {
		super();
		this.name = name;
	}
	public abstract int ComputePay();
	
	public final int computeIncentive() {
		int pay = ComputePay();
		if(pay>=2000000) {
			return (int)(pay/10);	
		}else {
			return 0;
		}
	}
	//getter&setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSang() {
		return sang;
	}
	public void setSang(int sang) {
		this.sang = sang;
	}
}
