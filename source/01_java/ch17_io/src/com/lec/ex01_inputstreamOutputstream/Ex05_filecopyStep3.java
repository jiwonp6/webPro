package com.lec.ex01_inputstreamOutputstream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//(1)��Ʈ����ü(�Է¿�, ��¿�) (2)�а� ���� (3)���ϴݴ´�(��Ʈ����ü.close)
import java.io.InputStream;
import java.io.OutputStream;

public class Ex05_filecopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File("d:\\pjw\\webPro\\nctdream.jpg");
			is = new FileInputStream(file);	//(1)
			os = new FileOutputStream("d:\\pjw\\webPro\\nctdream_copy.jpg");
			int cnt = 0;
			byte[] bs = new byte[(int)file.length()];	//(������ �뷮)���� �� ���� ���� ����(int�� ����ȯ �ʿ�)
			while(true) {	//(2)
				int readByteCount = is.read(bs);	//1024 byte�б�
				if(readByteCount == -1) break;		//������ ������ ����
				os.write(bs, 0, readByteCount);		//bs�� 0�� idx���� readBytecount��ŭ ����
				cnt++;
			}
			System.out.println(cnt+ "�� while�� �����Ͽ� ����� ���� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) {
					os.close();
				}
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
