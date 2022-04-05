package com.lec.ex01_inputstreamOutputstream;
//(1)������ ����(��¿� ��Ʈ����ü ����) (2)write�Ѵ� (3)������ �ݴ´�(��Ʈ����ü.close)
import java.io.*;

public class Ex03_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true);	//(1)������ ����	true�� ��°��� ��� �߰��ż� ����
			byte[] bs = {'H', 'e', 'l', 'l','o'};
			for(int i=0; i<bs.length; i++) {	//(2)write��
				os.write(bs[i]);
			}
			os.write(bs);
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
