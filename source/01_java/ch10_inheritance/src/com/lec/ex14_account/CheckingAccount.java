package com.lec.ex14_account;
//CheckingAccount a2 = new CheckingAccount("11-11", "홍길동", 2000, "1111-1111-2222-3333")
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
		if(this.cardNo.equals(cardNo)) {	//String은 비교할 때 equals로 비교ㅛ
			if(getBalance() >= amount) {	//함수호출은 get할 때 ()필요!
				setBalance(getBalance()-amount);
				System.out.printf("%s(%s)님 %d원 지불하여 잔액 %d원 남았습니다.\n", getOwnerName(), getAccountNo(), amount, getBalance());
			}else {
				System.out.printf("%s(%s)님 잔액%d원으로 %d원 지불 불가합니다.\n", getOwnerName(), getAccountNo(), getBalance(), amount);
			}
		}else {
			System.out.println("서비스 불가합니다.");
		}
	}
	//getter
	public String getCardNo() {
		return cardNo;
	}

}
