package com.lec.ex03_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		Student s = new Student(6, "�̼���");
		students.add(s);
		students.add(s);
		students.add(new Student(3, "ȫ�浿"));	
		students.add(new Student(3, "ȫ�浿"));	//ȫ�浿�� �� �� ����...
		students.add(new Student(6, "�̼���"));	//�̼��ŵ� �� �� ����...
		//��, ���� �ٸ� ��ü�� �ν��ؼ� ������ ������<-�߸��� ���
			//(Set�� �����ɷ� �ν��ؼ� ������ ���ƾ��Ѵ�)
				//=>set�� ���� hashcode��, equals���ؼ� �� �� �Ȱ����� ����
		System.out.println(students);
	}
}
