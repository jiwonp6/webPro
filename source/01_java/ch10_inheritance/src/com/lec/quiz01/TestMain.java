package com.lec.quiz01;
//(��ȣ)st101  (ID)A01	(�̸�):������	(��)JAVA��
//(��ȣ)st102  (ID)A02	(�̸�):ȫ�浿	(��)C++��
//(��ȣ)staff1  (ID)S01	(�̸�):���浿	(����)�������
//(��ȣ)staff2  (ID)S01	(�̸�):��浿	(����)���������
//(��ȣ)lec1   (ID)G01	(�̸�):�̱浿	(�μ�)��ü����
public class TestMain {
	public static void main(String[] args) {
		Person p[] = {new Student("A01", "������", "Java��"),
				new Student("A02", "ȫ�浿", "C++��"),
				new Staff("S01", "���浿", "�������"),
				new Staff("S02", "��浿", "���������"), 
				new Gangsa("G01", "�̱浿", "��ü����")};
	}
}
