package com.lec.loop;

public class Quiz04 {
	public static void main(String[] args) {
		int tot = 1;
		for(int j=1 ; j<10 ; j++) {
			for(int i=2 ; i<10 ; i++) {
				tot = i*j;
				System.out.printf("%d * %d = %d\t", i, j, tot );
				if(i==9)
					System.out.println();
			}//for.i
		}//for.j
	}
}
