package com.lec.ex;
//���� �� �Ǽ���
public class VarEx05 {
	public static void main(String[] args) {
		//boolean b = true; //boolean -> true or false�� ����!
		//char b = '��';
				
		float f1;
		//f1 = 10.1 <- �Ǽ� �⺻���� double�̹Ƿ� ����X (float�� 4byte¥������ ����...)
		f1 = 10.1F; //<-�Ҽ����ڸ����� ���� �� float���� �������ؼ��� �ڿ� F�ٿ��ָ� �ȴ�
		System.out.println("f1="+f1);
		
		double d = 10.0000017;//<-�⺻��
		System.out.println("d="+d);
		
		f1=10.1f;
		d=10.1;
		if(f1==d) 
			System.out.println("Same!");
		else
			System.out.println("Different!");
	}

}
