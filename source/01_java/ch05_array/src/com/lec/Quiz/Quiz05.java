package com.lec.Quiz;

public class Quiz05 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};	//8��(0~7)
		for(int j=0 ; j<arr.length ; j++) {
			int max = -999;
			int maxIdx = 0;
			for(int i=0 ; i<arr.length ; i++) {
				if(arr[i]>max) {
					max = arr[i];
					maxIdx = i;
				}
			}//for.����
			System.out.print(max+"\t");
			arr[maxIdx] = 0;	//max���� arr[i]���� -999�� reset
		}//for.�ٱ���
	}
}
