package com.lec.loop;
//Â¦¼öÇÕ Ãâ·Â or È¦¼öÇÕ Ãâ·Â
public class Quiz02 {
	public static void main(String[] args) {
		int sum=0;
		for (int i=0; i<=10; i++)
			if(i%2==0) { //Â¦¼ö, È¦¼ö->i%2==1
				sum += i;
			}
		System.out.println(sum);
	}
}
