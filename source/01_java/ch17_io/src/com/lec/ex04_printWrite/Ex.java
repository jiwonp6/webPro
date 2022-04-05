package com.lec.ex04_printWrite;

import java.io.*;

public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter printWriter = null;
		try {
			//1
			os = new FileOutputStream("txtFile/outTest.txt", true);	//�⺻��Ʈ��
			printWriter = new PrintWriter(os);	//������Ʈ��
			//2
			writer = new FileWriter("txtFile/outTest.txt", true);
			printWriter = new PrintWriter(writer);	//������Ʈ��
			//3
			printWriter = new PrintWriter("txtFile/outTest.txt");	//���� append�Ұ�
			
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			printWriter.println("�ȳ��ϼ���\\n�ݰ����ϴ�");
			
			System.out.println("print�� �ڵ������� �ȵǼ� �����߰�\n");
			printWriter.println("print�� �ڵ������� �ȵǼ� �����߰�\n");
			
			System.out.printf("%s\t %d\t %d\t %5.1f\n", "ȫ�浿", 90, 91, 90.5);
			printWriter.printf("%s\t %d\t %d\t %5.1f\n", "ȫ�浿", 90, 91, 90.5);

			System.out.printf("%s\t %d\t %d\t %5.1f\n", "�ű浿", 100, 91, 90.5);
			printWriter.printf("%s\t %d\t %d\t %5.1f\n", "�ű浿", 100, 91, 90.5);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if(printWriter!=null) printWriter.close();	//try-catch �ʿ����
			if(writer!=null)
				try {
					writer.close();
				} catch (IOException ignore) {}
			if(os!=null)
				try {
					os.close();
				} catch (IOException ignore) {}
			
		}
	}
}
