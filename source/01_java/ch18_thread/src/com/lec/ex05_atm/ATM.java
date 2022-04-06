package com.lec.ex05_atm;
//ATM a = new ATM(10000)
public class ATM {
	private int balance;

	public ATM(int balance) {
		this.balance = balance;
	}
	public synchronized void deposit(int amount, String who) {
		System.out.println(who +"가 입금 시작");
		balance +=amount;
		System.out.println(who+"가"+ amount +"원 입금하여 잔액 "+balance+"원");
		System.out.println(who+"가 입금 완료");
	}
	public synchronized void withdraw(int amount, String who) {
		System.out.println(who +"가 출금 시작");
		balance -=amount;
		System.out.println(who+"가"+ amount +"원 출금하여 잔액 "+balance+"원");
		System.out.println(who+"가 출금 완료");
	}
	public int getBalance() {
		return balance;
	}
}
