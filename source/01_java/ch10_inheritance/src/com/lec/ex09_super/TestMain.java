package com.lec.ex09_super;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("�ƺ���");
		papa.setCharacter("�׶���");
		papa.intro();
		Person mom = new Person("������", "������");
		mom.intro();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		Baby child1 = new Baby();
		child1.setName("�Ʊ��1");
		child1.setCharacter("�Ϳ���");
		child1.intro();
		Baby child2 = new Baby("�Ʊ��2", "�ʹ��Ϳ���");
	}
}

