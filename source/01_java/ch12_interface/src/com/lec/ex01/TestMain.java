package com.lec.ex01;
//�ϳ����� �������� ���� -> ������
public class TestMain {
	public static void main(String[] args) {
		//InterfaceEx01 ex01 = new InterfaceEx01();	//---> �������̽� ��ü ���� �Ұ���
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		System.out.println(obj1.CONSTANT_NUM+"/"+obj1.CONSTANT_STRING); 	
		//��ü ������ static access����
		System.out.println(InterfaceEx01.CONSTANT_NUM+"/"+InterfaceEx02.CONSTANT_STRING); 	
		//��ü ������ �������̽� ������ ȣ��
		InterfaceEx01 obj2 = new InterfaceClass();
		obj2.method1();
		//obj2.method2();	
		// ---> InterfaceEx01���� �ҷ��Ա� ������ obj2�� method2�� �־ ����ȯ �ʿ�
		if(obj2 instanceof InterfaceClass) {
			((InterfaceClass) obj2).method2();	//<--- ����ȯ
		}
		System.out.println(obj2.CONSTANT_NUM);
		//System.out.println(obj2.CONSTANT_STRING);	//<--- ���� ���������� �Ұ���
		InterfaceEx02 obj3 = new InterfaceClass ();
		//obj3.method1();	<--- �Ұ���
		obj3.method2();
	}
}
