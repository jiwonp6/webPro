//��Ű����, Ŭ������, ������, �������Լ�(�����ε�), �޼ҵ�, setter & getter

//�Ű����� �ִ� ������ �����
//		�Ű����� ���� ����Ʈ ������ �׻� �ϳ� ����� ������
package com.lec.ex1_square;

public class Square {
	private int side;
	//�������Լ� ��ü�� ���� ���� JVM�� ����Ʈ������(�ƹ��͵� ���� �ʰ� �Ű����� ���� ������)�� ����
											//->private int side;
	//�������Լ� : return type�� ����, class��� ���� �Լ�, ������ �ʱ�ȭ
	public Square() {	//�Ű����� ���� ������ �Լ�
		System.out.println("�Ű����� ���� ������ �Լ� ȣ���");
		
	}
	public Square(int side) {	//�Ű����� �ִ� ������ �Լ� �뵵 
		this.side = side;
		System.out.println("�Ű����� �ִ� ������ �Լ� ȣ���. side �ʱ�ȭ");
	}
	public int area() {
		return side*side;
	}
//	setter & getter
	public void setSide(int side) {
		this.side = side;
	}
	public int getSide() {
		return side;
	}
}
