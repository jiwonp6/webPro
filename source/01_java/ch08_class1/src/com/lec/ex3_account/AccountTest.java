package com.lec.ex3_account;

public class AccountTest {
	public static void main(String[] args) {
		Account park = new Account("100-1", "������",2200000000L);	//�ν��Ͻ� ����
		Account park2 = new Account("101-1", "������");
		Account acc = new Account();
		acc.setAccountNo("101-2");
		acc.setOwnerName("������");
		//park
		System.out.println(park.infoPrint());
		park.withdraw(2000);
		System.out.println(park.infoPrint());
		//park2
		System.out.println(park2.infoPrint());
		park2.deposit(20000);
		park2.withdraw(30000);
		System.out.println(park2.infoPrint());
		//acc
		System.out.println(acc.infoPrint());
		acc.withdraw(1000);
		System.out.println(acc.infoPrint());
		
		
		
	}
}
