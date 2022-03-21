package com.lec.ex10_customer;
//name, tel, address, sum, point, date, vip
//Customer c = new Customer("홍", "010", "설", "1000", "1999-06-16");
public class Customer extends Person{
	private String address;
	private int sum;	//구매누적금액
	private int point;	//포인트
	private String date;	//기념일(Date타입될 예정)
	private boolean vip;	//true or false
	
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);	//반드시 첫번째 라인에 와야한다!
		this.address = address;
		this.date = date;
		point = 1000;	//새 고객은 1000점 자동 부여
		//vip = false;	//새 고객은 일반고객
		//sum =0;	//새 누적 고객의 구매누적 금액 0
		System.out.println(name+"님 감사합니다. 포인트 1000점을 선물로 적립됩니다.");
	}
	//method
	public void buy(int price) {	//c.buy(10000)
		sum += price;	//누적구매
		int tempPoint = (int)(price*0.05);
		point += tempPoint;
		System.out.println(getName()+"님 감사합니다. 이번 구매로 포인트 " + tempPoint+"점 추가 되어 총 포인트 " + point);
		if(sum>=1000000 && vip==false) {
			vip = true;	//구매누적금액이 100만원 이상시 vip고객으로
			System.out.println(getName()+"님 VIP고객으로 업그레이드 되셨습니다.");
		}
	}
	//sysout(c.infoString()) / super.infoString() "[이름]홍 [전화]010-9999-9999"
	@Override	//@ : 어노테이션, 바로 다음 줄만 영향을 미침
	public String infoString() {
		return super.infoString() +"[주소]"+address+"[포인트]"+point+"[누적금액]"+sum;
				
	}
	
}
