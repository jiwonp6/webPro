package com.lec.ex04_employee;

public class SalaryEmployee extends Employee{
private int annalSalary;
	
	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}
	@Override
	public int ComputePay() {
		return (annalSalary/14);
	}
	
}
