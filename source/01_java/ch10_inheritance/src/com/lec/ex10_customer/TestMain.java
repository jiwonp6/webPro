package com.lec.ex10_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("ȫ", "010-9999-9999", "����", "1999-06-16");
		customer.buy(100000);
		System.out.println(customer.infoString());
		Staff staff = new Staff("��", "010-9999-9998", "2022-09-01", "������");
		Person person = new Person("��", "010-9999-9997");
		Person[] personArr = {customer, staff, person};
		//�迭 0~������� infoString()
		System.out.println("�Ϲ� for��");
		for(int i=0; i<personArr.length; i++) {
			System.out.println(personArr[i].infoString());
		}
		System.out.println("Ȯ�� for��");
		for(Person p : personArr) {
			System.out.println(p.infoString());
		}
		//�迭 0~������� buy(1000)
		for(Person p : personArr) {
			if(p instanceof Customer) {	//p������ Customer�� ��ü�ΰ�?
				((Customer)p).buy(1000);
			}else {
				System.out.println("buy�� Customer�� �����մϴ�.");
			}
		}
	}
}
