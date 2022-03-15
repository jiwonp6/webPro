package com.lec.Quiz;

public class Quiz05 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};	//8개(0~7)
		for(int j=0 ; j<arr.length ; j++) {
			int max = -999;
			int maxIdx = 0;
			for(int i=0 ; i<arr.length ; i++) {
				if(arr[i]>max) {
					max = arr[i];
					maxIdx = i;
				}
			}//for.안쪽
			System.out.print(max+"\t");
			arr[maxIdx] = 0;	//max였던 arr[i]값을 -999로 reset
		}//for.바깥쪽
	}
}
