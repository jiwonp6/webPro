package com.lec.ex02_protectedmember;

public class Child extends SuperIJ{	//����� SuperIJ���� �����Ƿ� �ڿ� extends SuperIJ����
	private int total;

	public Child() {
		System.out.println("�Ű����� ���� Child ������");
	}
	//������
		// Child c = new Child(10, 20);
	public Child(int i, int j) {	//superŬ�������� ��ӹ��� i, j �ʱ�ȭ
		setI(i);
		setJ(j);
		System.out.println("�Ű����� �ִ� Child ������");
	}
	//�޼ҵ�
	public void sum() {	//void ---> returnŸ��X
		total = getI() + getJ();	// total = i+j;
		System.out.printf("�� ��ü�� i=%d, j=%d\n", getI(), getJ());
		System.out.printf("�� ��ü�� total=%d", total);
	}



}
