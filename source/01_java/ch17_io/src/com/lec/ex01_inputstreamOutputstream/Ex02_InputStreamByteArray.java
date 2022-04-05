package com.lec.ex01_inputstreamOutputstream;
//(1)������ ����(�Է¿� ��Ʈ����ü����) 
//(2)�����͸� �д´� : read() 1byte�� �д´�. �ӵ��� ����/ read(byte[]) byte[]��ŭ �ϱ�
//(3)������ �ݴ´�
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");	//1. ������ ����
			byte[] bs = new byte[10];
			while(true) {	//2.�����͸� �д´�
				int readByteCount = is.read(bs);	//bs�� byte��ŭ�� �б�
				if(readByteCount==-1) break;	//������ ���̸� �ݺ��� break;
				for(int i=0; i<readByteCount; i++) {	//byte���� ���ڸ� ���ڷ� ���� Ȯ��for��� �Ұ�
					System.out.print((char)bs[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {	//catch���� ���ܴ� ū �� ������ ������
			System.out.println(e.getMessage());
		} finally {	//3.������ �ݴ´�.
			try {
				if(is != null) {	//���� �����̸��� �߸��Էµż� is�� null�̸� close���� ���� �ֱ⶧���� if�� ���
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
