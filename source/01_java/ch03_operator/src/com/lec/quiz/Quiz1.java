package com.lec.quiz;
//����ڷκ��� �Է¹��� ���� 3�� ������� ���� ���
import java.util.Scanner; //Scanner�� ���� �ȽἭ ����� ���̶�� ���� ����������Ѵ�.

public class Quiz1 {
	public static void main(String[] args) {
		//int i = 10 ;
		//String name = "ȫ�浿";
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : "); //���� �Է� �ޱ�
		int su = scanner.nextInt();//����ڷκ��� �Է� �ޱ�
		String result = su%3 == 0 ? "�Է��Ͻ� ���� 3�� ��� �Դϴ�." : "�Է��Ͻ� ���� 3�� ����� �ƴմϴ�.";
		System.out.println(result);
		
		scanner.close();
	}
}
