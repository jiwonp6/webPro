package com.lec.ex;

public class VarEx06 {
	public static void main(String[] args) {
		int i1 = 10; // 4byte
		long l =2200000000L; // 8byte, L붙여줘야 한다!
		double d1 = i1; 
			// 8byte = 4byte -> 묵시적인 형변환(작은 byte값을 큰 byte공간에)
		System.out.println("d1="+d1);
		
		double d2 = 10.19;
		//int i2 = d2;
			//4byte = 8 byte 형변환 불가능
		int i2 = (int)d2; 
			// 명시적인 형변환(데이터 손실이 발생할 수도 있음)
		System.out.println("i2="+i2);
		
	}

}
