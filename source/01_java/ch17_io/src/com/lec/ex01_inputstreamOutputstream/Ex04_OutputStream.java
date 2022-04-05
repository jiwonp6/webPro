package com.lec.ex01_inputstreamOutputstream;
//(1)������ ����(��¿� ��Ʈ����ü ����) (2)write�Ѵ� (3)������ �ݴ´�(��Ʈ����ü.close)
import java.io.*;

public class Ex04_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt");	//(1)������ ����	true�� ��°��� ��� �߰��ż� ����
			String str = "Hello, Java\n�� �ñ��� ��� �ǰ��ϼ���";
			byte[] bs = str.getBytes();	//�˾Ƽ� �迭��
			os.write(bs); //(2)write��
			System.out.println("���� ��� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os != null) {	//(3)���� ����
					os.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
