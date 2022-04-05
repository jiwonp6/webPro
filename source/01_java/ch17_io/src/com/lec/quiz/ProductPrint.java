package com.lec.quiz;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
//���Ͽ� ����� ������ ���
public class ProductPrint {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			fis = new FileInputStream("src/com/lec/quiz/product.dat");
			dis = new DataInputStream(fis);
			while(true) {
				Product p = new Product();
				String name = dis.readUTF();	//��ǰ��
				int price = dis.readInt();
				int ps = dis.readInt();
				products.add(new Product(name, price, ps));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("��� �����ʹ� ������ �����ϴ�.");
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			} catch (Exception e2) {}
		}
		//ArrayList products ���
		if(products.isEmpty()){
			System.out.println("�Էµ� ����� �����ϴ�");
		}else {
			for(Product p : products) {
				System.out.println(p);
			}
			System.out.println("�̻� ��ǰ "+products.size()+"���� �Էµ�");
		}
	}
}
