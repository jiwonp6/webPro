package com.lec.ex01_string;
//전화번호 입력 받아, 입력받은 전화번호, 짝수번째 문자, 거꾸로, 전화번호 앞자리, 전화번호 뒷자리
import java.util.Scanner;

public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("전화번호 입력하세요 : ");
			String tel = sc.next();	//string 형식
			if(tel.equalsIgnoreCase("X"))
				break;
			System.out.println("입력한 전화번호 : " + tel);
			System.out.print("짝수번째 문자열 : ");
			for(int i=0; i<tel.length(); i++) {
				if(i%2 == 0) {
					System.out.print(tel.charAt(i));	//짝수번째 출력
				}else {
					System.out.print(" ");	//space출력
				}
			}
			System.out.println();
			System.out.print("문자를 거꾸로");
			for(int i=tel.length()-1; i>=0; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			String pre ="전화번호 앞자리";
			String post = "전화번호 뒷자리";
			String mid = "전화번호 중간자리";
			System.out.println("");
			pre = tel.substring(0,tel.indexOf("-"));
			System.out.print("전화번호 앞자리 : "+pre);
			post = tel.substring(tel.lastIndexOf("-")+1);
			System.out.println("전화번호 뒷자리 : "+post);
			mid = tel.substring(tel.indexOf("-")+1,tel.lastIndexOf("-"));
			System.out.print("전화번호 중간자리 : "+mid);
		}while(true);
	}
}
