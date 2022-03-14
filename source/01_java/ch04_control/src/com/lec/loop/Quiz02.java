package com.lec.loop;

public class Quiz02 {
	public static void main(String[] args) {
		int tot=0;
		for (int i=0; i<=10; i++)
			if(i%2==0) { //Â¦¼ö, È¦¼ö->i%2==1
				tot += i;
			}
		System.out.println(tot);
	}
}
