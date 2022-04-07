package com.lec.ex01_string;

public class Ex05_regex {
	public static void main(String[] args) {
		String str = "010-9999-9999    yisy0703@naver.com    (02)565-8888    �ݰ����ϴ�. Hello   951212-2524251    010-8888-8888";
		System.out.println("replace => "+ str.replace("0", "ȫ"));	//0�� ȫ���� �ٲ�
		/* ����ǥ����(regex)
		 1. ���� : goo.gl/HLntbd		������ : regexr.com/regexpal.com
		 2. ������ ����
		 	\d : ���ڿ� ��ġ, [0-9]�� ����	\D : ���ڰ� �ƴ� ��
		 	\s : whitespacen : space, ��, ����
		 	\w : �����ڳ� ����, [a-zA-z0-9]�� ����		\W : �����ڳ� ���ڰ� �ƴѰ�
		 	. : �����ϳ�
		 	+ : 1���̻� �ݺ�
		 	* : 0���̻� �ݺ�
		 	? : 0~1���̻� �ݺ�
		 	{2,4} : 2~4ȸ �ݺ�
		 3. ����ǥ���� ������ : 
		 	ex. ��ȭ��ȣ : .?[0-9]{2,3}.[0-9]{3,4}-[0,9]{4}
		 4. Ư�� ����ǥ������ ���ڿ� ���� : replaceAll("����ǥ����", "��ü���ڿ�")
		 */
		//��ȭ��ȣ ����
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0,9]{4}", "*��ȭ��ȣ����*"));
		//�̸��� ����
		String str2 = "010-9999-9999    yisy0703@naver.com    (02)565-8888    �ݰ����ϴ�. Hello   951212-2524251    abc@hong.co.kr";
		System.out.println(str2.replaceAll("\\w+@\\w+(.\\w+){1,2}", "+"));
		//���ĺ� ����
		System.out.println(str2.replaceAll("[a-zA-Z]", "-"));
		//�ѱ� ����
		System.out.println(str2.replaceAll("[��-�R��-��]", "~"));
		//�ֹι�ȣ ���ڸ� ����
		System.out.println(str2.replaceAll("[0-9]{7}", "*******"));
	}
}
