package com.lec.quiz01;
//(��ȣ)st101  (ID)A01	(�̸�):������	(��)JAVA��
//(��ȣ)st102  (ID)A02	(�̸�):ȫ�浿	(��)C++��
public class Student extends Person{
	private String ban;
	private static int count;
	Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		int studentNum=1;
		studentNum = ++count;
		System.out.print("(��ȣ)st10"+studentNum+"\t(ID)"+id+"\t(�̸�)"+name+"\t(��)"+ban);
		System.out.println();
	}
}

//�л���ȣ�� �ű� �� st10�� �ٿ��־�� �Ѵ�.
//�̰��� print �ȿ� ���� �־��ָ� �����ϱ⿡ ����...
//���� ���־ String ������ �ٽ� �޴� ���� �����ϱ⿡ ����.