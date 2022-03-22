package com.lec.ex14_account;
//CheckingAccount a2 = new CheckingAccount("11-11", "ȫ�浿", 2000, "1111-1111-2222-3333")
public class CheckingAccount extends Account{
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
//a2.pay("1111-1111-2222-3333", 1000);
	public void pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) {	//String�� ���� �� equals�� �񱳤�
			if(getBalance() >= amount) {	//�Լ�ȣ���� get�� �� ()�ʿ�!
				setBalance(getBalance()-amount);
				System.out.printf("%s(%s)�� %d�� �����Ͽ� �ܾ� %d�� ���ҽ��ϴ�.\n", getOwnerName(), getAccountNo(), amount, getBalance());
			}else {
				System.out.printf("%s(%s)�� �ܾ�%d������ %d�� ���� �Ұ��մϴ�.\n", getOwnerName(), getAccountNo(), getBalance(), amount);
			}
		}else {
			System.out.println("���� �Ұ��մϴ�.");
		}
	}
	//getter
	public String getCardNo() {
		return cardNo;
	}

}
