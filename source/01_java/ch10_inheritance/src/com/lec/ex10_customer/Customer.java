package com.lec.ex10_customer;
//name, tel, address, sum, point, date, vip
//Customer c = new Customer("ȫ", "010", "��", "1000", "1999-06-16");
public class Customer extends Person{
	private String address;
	private int sum;	//���Ŵ����ݾ�
	private int point;	//����Ʈ
	private String date;	//�����(DateŸ�Ե� ����)
	private boolean vip;	//true or false
	
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);	//�ݵ�� ù��° ���ο� �;��Ѵ�!
		this.address = address;
		this.date = date;
		point = 1000;	//�� ���� 1000�� �ڵ� �ο�
		//vip = false;	//�� ���� �Ϲݰ�
		//sum =0;	//�� ���� ���� ���Ŵ��� �ݾ� 0
		System.out.println(name+"�� �����մϴ�. ����Ʈ 1000���� ������ �����˴ϴ�.");
	}
	//method
	public void buy(int price) {	//c.buy(10000)
		sum += price;	//��������
		int tempPoint = (int)(price*0.05);
		point += tempPoint;
		System.out.println(getName()+"�� �����մϴ�. �̹� ���ŷ� ����Ʈ " + tempPoint+"�� �߰� �Ǿ� �� ����Ʈ " + point);
		if(sum>=1000000 && vip==false) {
			vip = true;	//���Ŵ����ݾ��� 100���� �̻�� vip������
			System.out.println(getName()+"�� VIP������ ���׷��̵� �Ǽ̽��ϴ�.");
		}
	}
	//sysout(c.infoString()) / super.infoString() "[�̸�]ȫ [��ȭ]010-9999-9999"
	@Override	//@ : ������̼�, �ٷ� ���� �ٸ� ������ ��ħ
	public String infoString() {
		return super.infoString() +"[�ּ�]"+address+"[����Ʈ]"+point+"[�����ݾ�]"+sum;
				
	}
	
}
