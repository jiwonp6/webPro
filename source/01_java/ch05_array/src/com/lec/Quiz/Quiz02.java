package com.lec.Quiz;

public class Quiz02 {
	public static void main(String[] args) {
		int[][] arr= {{5,5,5,5,5},
					  {10,10,10,10,10}, 
					  {20,20,20,20,20}, 
					  {30,30,30,30,30}};
		int tot=0;
		int i=0;
		int j=0;
		for(i=0 ; i<arr.length ; i++){
			for(j=0; j<arr[i].length ; j++) {
				tot += arr[i][j];
			}
		}
		System.out.println(tot);
	}
}
