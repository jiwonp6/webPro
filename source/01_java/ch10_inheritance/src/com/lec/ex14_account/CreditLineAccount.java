package com.lec.ex14_account;
//CreditLineAccount c2 = new CreditAccount("11-11", "ȫ", "1111-2222-3333-4444", 10000)
//CreditLineAccount c2 = new CreditAccount("11-11", "ȫ", 1000, "1111-2222-3333-4444", 10000)
public class CreditLineAccount extends CheckingAccount{
	private int creditLine;	//ī���ѵ�
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	@Override
	public void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) {
			if(creditLine >= amount) {	
				creditLine = creditLine - amount;
				System.out.printf("%s(%s)�� %d�� ����, �ѵ� %d�� �Դϴ�..\n", getOwnerName(), getAccountNo(), amount, creditLine);
			}else {
				System.out.printf("%s(%s)�� �ѵ�%d������ %d�� ���� �Ұ��մϴ�.\n", getOwnerName(), getAccountNo(), creditLine, amount);
			}
		}else {
			System.out.println("���� �Ұ��մϴ�.");
		}
	}
}
