package com.lec.ex4_access;

import com.lec.ex3_access.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();	
		// = com.lec.ex3_access.AccessTest obj;
		//static �޼ҵ�� �ϸ� ---> Ŭ���� ���赵�� ���ܼ� �ű⼭ �ٷ� ����
		System.out.println(obj.publicMember);
		//private, 
			//default(���� ��Ű�� �������� �� �� ����), 
				//protected(���� ��Ű�� ���ų� ��ӹ����� �� �� ����) ����
		obj.publicMethod();
	}
}
