package com.lec.ex01_inputstreamOutputstream;
//(1)������ ����(�Է¿� ��Ʈ����ü����) (2)�����͸� �д´� (3)������ �ݴ´�
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");	//1. ������ ����
			while(true) {	//2.�����͸� �д´�
				int i = is.read();	//1byte�� �б�
				if(i==-1) break;	//������ ���̸� �ݺ��� break;
				System.out.print((char)i + "("+i+")");	//i�� int�̹Ƿ� ���ڷ� �������� char�� ��ȯ(��, ���ĺ����� ��ȯ����)
			}
			System.out.println("\n��");
		} catch (FileNotFoundException e) {
			System.out.println("������ �� ã�� ��� : "+e.getMessage());
		} catch (IOException e) {	//catch���� ���ܴ� ū �� ������ ������
			System.out.println("������ �� �д� ��� : "+e.getMessage());
		} finally {	//3.������ �ݴ´�.
			try {
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
