package com.lec.ex;
// �Ҵ翬����(= += -= *= /= %=)
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 10;
		n1 += 10; // n1 = n1+10;
//		n1 += 1; //n1 = n1+1; ahen n1�� 1������Ŵ
//		n1++;
//		++n1;
//		n1 = n1+1;
		System.out.println("n1 = "+n1);
		n1 -=10; // n1 = n1-10;
		n1 *=10; // n1 = n1*10;
		int n2 = n1 = 10;
		System.out.println("n1="+ n1 + "\t n2=" + 10);
	}
}
