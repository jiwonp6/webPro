package com.lec.ex04_newexcetpion;

public class AccountTestMain {
	public static void main(String[] args) {
		Account obj1 = new Account("111-111","ȫ�浿");
		Account obj2 = new Account("222-222","���浿",2000);
		Account obj3 = new Account("333-333","�ű浿");
		obj1.deposit(1000);
		obj2.deposit(1000);
		obj3.deposit(1000);
		try {
			obj1.withdraw(500);
		} catch (Exception e) {			
			System.out.println(e.getMessage());
		}
		try {
			obj2.withdraw(30000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
