package com.lec.ex03_set;
//TreeSet : 크기 순으로 나열
import java.util.TreeSet;
import java.util.Random;

public class Ex02_lotto2 {
	public static void main(String[] args) {
		//int[] lotto = new int[6];
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		Random random = new Random();
		int cnt=0;
		while(lotto.size() <6) {
			cnt++;
			lotto.add(random.nextInt(45)+1);	//1~45사이의 정수 난수 add
		}
		System.out.println(cnt +"번 숫자 뽑아 나온 로또 수들 "+lotto);
	}
}
