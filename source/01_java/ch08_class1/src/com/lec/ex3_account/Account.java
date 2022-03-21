package com.lec.ex3_account;
//<데이터속성, 멤버변수인스턴스변수)> 
//	계좌번호(accountNo:String) 
//	예금주(ownerName:String)
//	잔액(balance:long)

//<기능(메소드)>  
//	예금하다(void deposit(int)) 
//	인출하다(int withdraw(int)) 
//	잔액조회(long infoPrint())

//Account a = new Account("100-1", "홍길동");/Account("100-2", "신길동", 2200000000);


public class Account {
//데이터
	private String accountNo;
	private String ownerName;
	private long balance;
	
	public Account() {}	// 디폴트 생성자
	public Account(String accountNo, String ownerName) {	// 생성자 역할 : 데이터 초기화의 목적
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s(%s)님 계좌 개설 감사합니다.\n\n", ownerName, accountNo);
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s(%s)님 %d입금 계좌 개설 감사합니다.\n\n", ownerName, accountNo, balance);
	}
	
//메소드-deposit, withdraw, infoPrint
	public void deposit(int money) {	//예금은 양수 money가 들어오면 예금처리
		if(money>=0) {
			balance += money;
			System.out.printf("%s님 %d원이 입금되었습니다.\n", ownerName, money);
		}else {
			System.out.println("작업을 수행할 수 없습니다.");
		}
	}
	public void withdraw(int money) {
		if(money<=balance) {
			balance -= money;
			System.out.printf("%s님 출금되셨습니다. 잔액은 %d입니다.\n", ownerName, balance);
		}else {
			System.out.printf("%s님 잔액이 부족하여 인출이 불가능합니다.\n", ownerName);
		}
	}
	public String infoPrint() {
		return String.format("%s(%s)님 잔액 : %d원", ownerName, accountNo, balance);
		//return ownerName+"("+ accountNo +")"+"님 잔액 : " + balance + "원";
	}
//setter&getter	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}

}
