package com.lec.ex;

public class VarEx06 {
	public static void main(String[] args) {
		int i1 = 10; // 4byte
		long l =2200000000L; // 8byte, L�ٿ���� �Ѵ�!
		double d1 = i1; 
			// 8byte = 4byte -> �������� ����ȯ(���� byte���� ū byte������)
		System.out.println("d1="+d1);
		
		double d2 = 10.19;
		//int i2 = d2;
			//4byte = 8 byte ����ȯ �Ұ���
		int i2 = (int)d2; 
			// ������� ����ȯ(������ �ս��� �߻��� ���� ����)
		System.out.println("i2="+i2);
		
	}

}
