package com.lec.ex03_set;
//TreeSet : ũ�� ������ ����
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
			lotto.add(random.nextInt(45)+1);	//1~45������ ���� ���� add
		}
		System.out.println(cnt +"�� ���� �̾� ���� �ζ� ���� "+lotto);
	}
}
