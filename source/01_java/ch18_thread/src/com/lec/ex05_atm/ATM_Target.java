package com.lec.ex05_atm;
//ATM card = new ATM(20000)
//ATM_Target target = new ATM_Target(card)
public class ATM_Target implements Runnable{
	private boolean flag;
	private ATM card;
	public ATM_Target(ATM card) {
		this.card = card;
	}
	@Override
	public void run() {
		//저금했다 출금했다 반복
		for(int i=0; i<10; i++) {
			if(flag) {	//출금
				card.withdraw(1000, Thread.currentThread().getName());
				flag = false;
			}else {	//적금
				card.deposit(1000, Thread.currentThread().getName());
				flag = true;
			}
		}
	}
	
}
