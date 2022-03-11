package com.lec.ex;
// 증감연산 : ++ --
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; //앞에다가 ++ : +1, -- : -1
		//int n2 = n1++; //뒤에다가 ++ : n2전의 앞수가 +1됨, n2는 원래 n1, n1이 하나 늘어남
		System.out.println("n1=" + n1 + "\t n2=" + n2); // ++n1;써도된다
	}

}
