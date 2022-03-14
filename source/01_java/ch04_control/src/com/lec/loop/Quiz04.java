package com.lec.loop;
//구구단 출력
public class Quiz04 {
	public static void main(String[] args) {
		int tot = 1;
		for(int j=1 ; j<10 ; j++) {
			for(int i=2 ; i<10 ; i++) {
				tot = i*j;
				System.out.printf("%d * %d = %d\t", i, j, tot );
			}//for.i
			System.out.println();
			}//for.j
		}//class
	}//main