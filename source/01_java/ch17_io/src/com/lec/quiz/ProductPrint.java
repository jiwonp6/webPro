package com.lec.quiz;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
//파일에 저장된 재고들을 출력
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
				String name = dis.readUTF();	//상품명
				int price = dis.readInt();
				int ps = dis.readInt();
				products.add(new Product(name, price, ps));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("재고 데이터는 다음과 같습니다.");
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			} catch (Exception e2) {}
		}
		//ArrayList products 출력
		if(products.isEmpty()){
			System.out.println("입력된 재고량이 없습니다");
		}else {
			for(Product p : products) {
				System.out.println(p);
			}
			System.out.println("이상 물품 "+products.size()+"가지 입력됨");
		}
	}
}
