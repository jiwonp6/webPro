package com.lec.quiz;

import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ProductWrite {	//n을 입력할 때까지 재고(상품명, 가격, 재고량)를 입력받아 파일 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("src/com/lec/quiz/product.dat", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.print("입력할 재고가 있습니까?(y/n)");
				ans = sc.next();
				if(ans.equalsIgnoreCase("n")) {
					break;
				}else if(ans.equalsIgnoreCase("y")) {	//상품명, 가격, 재고량을 파일로 출력
					System.out.print("상품명 : ");
					dos.writeUTF(sc.next());
					System.out.print("가격 : ");
					dos.writeInt(sc.nextInt());
					System.out.print("재고수량 : ");
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
