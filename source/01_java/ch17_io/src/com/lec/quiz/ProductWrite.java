package com.lec.quiz;

import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ProductWrite {	//n�� �Է��� ������ ���(��ǰ��, ����, ���)�� �Է¹޾� ���� ���
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("src/com/lec/quiz/product.dat", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.print("�Է��� ��� �ֽ��ϱ�?(y/n)");
				ans = sc.next();
				if(ans.equalsIgnoreCase("n")) {
					break;
				}else if(ans.equalsIgnoreCase("y")) {	//��ǰ��, ����, ����� ���Ϸ� ���
					System.out.print("��ǰ�� : ");
					dos.writeUTF(sc.next());
					System.out.print("���� : ");
					dos.writeInt(sc.nextInt());
					System.out.print("������ : ");
					dos.writeInt(sc.nextInt());
					dos.writeUTF("\n");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
