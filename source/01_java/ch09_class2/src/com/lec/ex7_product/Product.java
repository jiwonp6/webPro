package com.lec.ex7_product;

public class Product {
	private int serialNo;	//객체 고유의 번호 101, 102, 103 ...
	public static int count = 100;	//count는 0부터 시작함. 101부터로 하고싶어서 처음에 100넣어줌
	//static은 공간을 확보해놓음
	public Product() {
		serialNo = ++count;
	}
	public void infoPrint() {
		System.out.println("serialNo = " + serialNo + "\t공유변수 count = "+count);
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

}
