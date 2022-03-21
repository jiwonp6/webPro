package com.lec.ex7_product;

public class Product {
	private int serialNo;	//��ü ������ ��ȣ 101, 102, 103 ...
	public static int count = 100;	//count�� 0���� ������. 101���ͷ� �ϰ�; ó���� 100�־���
	//static�� ������ Ȯ���س���
	public Product() {
		serialNo = ++count;
	}
	public void infoPrint() {
		System.out.println("serialNo = " + serialNo + "\t�������� count = "+count);
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

}
