package com.lec.ex01_inputstreamOutputstream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//(1)��Ʈ����ü(�Է¿�, ��¿�) (2)�а� ���� (3)���ϴݴ´�(��Ʈ����ü.close)
import java.io.InputStream;
import java.io.OutputStream;

public class Ex05_filecopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:\\pjw\\webPro\\nctdream.jpg");	//(1)
			os = new FileOutputStream("d:\\pjw\\webPro\\nctdream_copy.jpg");
			int cnt = 0;
			while(true) {	//(2)
				int i = is.read();	//1byte�б�
				if(i == -1) break;	//������ ������ ����
				os.write(i);
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
