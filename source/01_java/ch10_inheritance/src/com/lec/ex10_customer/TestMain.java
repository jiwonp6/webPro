package com.lec.ex10_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("홍", "010-9999-9999", "서울", "1999-06-16");
		customer.buy(100000);
		System.out.println(customer.infoString());
		Staff staff = new Staff("김", "010-9999-9998", "2022-09-01", "개발팀");
		Person person = new Person("이", "010-9999-9997");
		Person[] personArr = {customer, staff, person};
		//배열 0~끝방까지 infoString()
		System.out.println("일반 for문");
		for(int i=0; i<personArr.length; i++) {
			System.out.println(personArr[i].infoString());
		}
		System.out.println("확장 for문");
		for(Person p : personArr) {
			System.out.println(p.infoString());
		}
		//배열 0~끝방까지 buy(1000)
		for(Person p : personArr) {
			if(p instanceof Customer) {	//p변수가 Customer형 객체인가?
				((Customer)p).buy(1000);
			}else {
				System.out.println("buy는 Customer만 가능합니다.");
			}
		}
	}
}
