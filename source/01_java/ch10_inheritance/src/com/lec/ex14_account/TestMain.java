package com.lec.ex14_account;

public class TestMain {
	public static void main(String[] args) {
		Account a1 = new Account("111-11111", "홍길동");
		a1.deposit(3000);
		a1.deposit(6000);
		a1.withdraw(10000);
		
		System.out.println("============================");
		CheckingAccount a2 = new CheckingAccount("222-2222", "신길동", 1000, "1111-2222-3333-4444");
		a2.deposit(9000);
		a2.withdraw(20000);
		a2.pay("1111-2222-3333-1111", 20000);
		a2.pay("1111-2222-3333-4444", 20000);
		a2.pay("1111-2222-3333-4444", 10000);
		
		System.out.println("============================");
		CheckingAccount a3 = new CreditLineAccount("333-3333", "박길동", "1111-5555", 10000);
		a3.deposit(10000);
		a3.pay("1111-5555", 15000);
	}
}
