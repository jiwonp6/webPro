package com.lec.loop;
//¦���� ��� or Ȧ���� ���
public class Quiz02 {
	public static void main(String[] args) {
		int sum=0;
		for (int i=0; i<=10; i++)
			if(i%2==0) { //¦��, Ȧ��->i%2==1
				sum += i;
			}
		System.out.println(sum);
	}
}
