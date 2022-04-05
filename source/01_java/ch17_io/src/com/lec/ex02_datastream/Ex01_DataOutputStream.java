package com.lec.ex02_datastream;
//(1)��Ʈ����ü���� == ������ ���� (2)�����;��� (3)��Ʈ����ü�ݴ´� == ������ �ݴ´�
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat", true);	//�⺻��Ʈ��
			dos = new DataOutputStream(fos);	//������Ʈ���� �⺻��Ʈ���� ���ؼ��� ����
			//�̸�-�г�-���� write
			dos.writeUTF("ȫ�浿");	//��Ʈ��������
			dos.writeInt(2);	//����������
			dos.writeDouble(95.5);	//double������
			
			dos.writeUTF("�ű浿");	//��Ʈ��������
			dos.writeInt(1);	//����������
			dos.writeDouble(90.5);	//double������
			
			System.out.println("���� ���� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dos!=null) dos.close();	//dos���� �ݾƾ���
				if(fos!=null) fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
