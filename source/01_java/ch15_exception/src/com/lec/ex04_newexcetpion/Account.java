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
	} // ���� : ���� �� �������� ��� -> ���� -> ������ �������� ���
	public void deposit(int amount) { // Account a = new Account("1-1","ȫ",100)
									  // sysout(a)
		System.out.println("������ : " + this); // this�� ��ü�� ������ �ڵ������� deposit�� �����ϸ� �˾Ƽ� �� ��ü�� toString�� �����Ŵ!
		balance += amount; 
		System.out.println(amount+" �� ������ : " + this);
	}
	public void withdraw(int amount) throws Exception {
		if(balance < amount) {
			throw new Exception(amount + " �� ����ϱ⿡�� �ܾ�("+balance+")�� �����մϴ�.");			
		}
		System.out.println("��� �� : "+ this);
		balance -= amount;
		System.out.println(amount+" �� ��� �� : "+ this);
		

	}
	@Override
	public String toString() { // �ܾ���ȸ 
		return "���¹�ȣ : "+accountNo + "\t������ : "+ownerName+"\t�ܾ� : "+balance;
	}
	
	
	
}
