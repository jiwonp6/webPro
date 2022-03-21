package com.lec.ex3_account;
//<�����ͼӼ�, ��������ν��Ͻ�����)> 
//	���¹�ȣ(accountNo:String) 
//	������(ownerName:String)
//	�ܾ�(balance:long)

//<���(�޼ҵ�)>  
//	�����ϴ�(void deposit(int)) 
//	�����ϴ�(int withdraw(int)) 
//	�ܾ���ȸ(long infoPrint())

//Account a = new Account("100-1", "ȫ�浿");/Account("100-2", "�ű浿", 2200000000);


public class Account {
//������
	private String accountNo;
	private String ownerName;
	private long balance;
	
	public Account() {}	// ����Ʈ ������
	public Account(String accountNo, String ownerName) {	// ������ ���� : ������ �ʱ�ȭ�� ����
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s(%s)�� ���� ���� �����մϴ�.\n\n", ownerName, accountNo);
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s(%s)�� %d�Ա� ���� ���� �����մϴ�.\n\n", ownerName, accountNo, balance);
	}
	
//�޼ҵ�-deposit, withdraw, infoPrint
	public void deposit(int money) {	//������ ��� money�� ������ ����ó��
		if(money>=0) {
			balance += money;
			System.out.printf("%s�� %d���� �ԱݵǾ����ϴ�.\n", ownerName, money);
		}else {
			System.out.println("�۾��� ������ �� �����ϴ�.");
		}
	}
	public void withdraw(int money) {
		if(money<=balance) {
			balance -= money;
			System.out.printf("%s�� ��ݵǼ̽��ϴ�. �ܾ��� %d�Դϴ�.\n", ownerName, balance);
		}else {
			System.out.printf("%s�� �ܾ��� �����Ͽ� ������ �Ұ����մϴ�.\n", ownerName);
		}
	}
	public String infoPrint() {
		return String.format("%s(%s)�� �ܾ� : %d��", ownerName, accountNo, balance);
		//return ownerName+"("+ accountNo +")"+"�� �ܾ� : " + balance + "��";
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
