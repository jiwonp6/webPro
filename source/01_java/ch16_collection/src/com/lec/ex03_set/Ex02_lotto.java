package com.lec.ex03_set;
//HashSet
import java.util.HashSet;
import java.util.Random;

public class Ex02_lotto {
	public static void main(String[] args) {
		//int[] lotto = new int[6];
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random random = new Random();
		int cnt=0;
		while(lotto.size() <6) {
			cnt++;
			lotto.add(random.nextInt(45)+1);	//1~45������ ���� ���� add
		}
		System.out.println(cnt +"�� ���� �̾� ���� �ζ� ���� "+lotto);
	}
}
