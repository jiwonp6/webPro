package com.lec.ex04_newexcetpion;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	
	public Account(String accountNo, String ownerName) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	} // 예금 : 예금 전 계좌정보 출력 -> 예금 -> 예금후 계좌정보 출력
	public void deposit(int amount) { // Account a = new Account("1-1","홍",100)
									  // sysout(a)
		System.out.println("예금전 : " + this); // this는 객체기 때문에 자동적으로 deposit을 실행하면 알아서 그 객체의 toString을 실행시킴!
		balance += amount; 
		System.out.println(amount+" 원 예금후 : " + this);
	}
	public void withdraw(int amount) throws Exception {
		if(balance < amount) {
			throw new Exception(amount + " 원 출금하기에는 잔액("+balance+")이 부족합니다.");			
		}
		System.out.println("출금 전 : "+ this);
		balance -= amount;
		System.out.println(amount+" 원 출금 후 : "+ this);
		

	}
	@Override
	public String toString() { // 잔액조회 
		return "계좌번호 : "+accountNo + "\t예금주 : "+ownerName+"\t잔액 : "+balance;
	}
	
	
	
}
