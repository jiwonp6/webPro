package com.lec.ex5_mompouch;
//Child first = new Child("ù°");
//first.takeMoney(1000) ; ���� õ������
public class Child {
	private String name;
	static MomPouch momPouch;	//<--- static���� ����� momPouch�� �ϳ�
										//default�� ����� ���� momPouch�� �ϳ��� ���ܹ���
					//= new MomPouch();�� ����
	public Child(String name) { 	//������ �ʱ�ȭ
		this.name = name;
		momPouch = new MomPouch();
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name+"�� "+money+"�� �������� ���� ������ ���� "
										+momPouch.money+"�� �־�.");
		}else {
			System.out.println(name+"�� ���� ���޾Ҿ�. ���� ������ ���� "
										+momPouch.money+"�� �ۿ� ����.");
		}//if
	}//takeMoney
}//main
