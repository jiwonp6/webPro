package com.lec.ex02_datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_DataInputStream {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis);	//������Ʈ���� �⺻��Ʈ���� ���ؼ� ����
			while(true) {
				String name = dis.readUTF();
				int grade = dis.readInt();
				double score = dis.readDouble();
				System.out.printf("%s�� %d�г� %.1f��\n", name, grade, score);
			}
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ã��"+e.getMessage());
		} catch (IOException e) {
			System.out.println("�̻� ������ ��"+e.getMessage());
		}finally {
			try {
				if(dis!=null) dis.close();	//dos���� �ݾƾ���
				if(fis!=null) fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
