package com.lec.loop;
//1~20까지 누적합 출력
public class Ex02_for {
	public static void main(String[] args) {
		int tot = 0; //누적할 변수
		for(int i=1 ; i<=20 ; i++) {
			tot += i;
		}
		System.out.println("1~20까지 누적합은 "+tot);
	}
}
