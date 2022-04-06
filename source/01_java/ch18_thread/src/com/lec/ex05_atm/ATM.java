package com.lec.ex05_atm;
//ATM a = new ATM(10000)
public class ATM {
	private int balance;

	public ATM(int balance) {
		this.balance = balance;
	}
	public synchronized void deposit(int amount, String who) {
		System.out.println(who +"�� �Ա� ����");
		balance +=amount;
		System.out.println(who+"��"+ amount +"�� �Ա��Ͽ� �ܾ� "+balance+"��");
		System.out.println(who+"�� �Ա� �Ϸ�");
	}
	public synchronized void withdraw(int amount, String who) {
		System.out.println(who +"�� ��� ����");
		balance -=amount;
		System.out.println(who+"��"+ amount +"�� ����Ͽ� �ܾ� "+balance+"��");
		System.out.println(who+"�� ��� �Ϸ�");
	}
	public int getBalance() {
		return balance;
	}
}
