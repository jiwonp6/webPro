package com.lec.Quiz;

public class Quiz03 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		int tot=0;
		for(int i=0 ; i<arr.length ; i++) {
			tot += arr[i];
		}
		System.out.println("�հ� : "+ tot);
		System.out.println("��� : "+ tot/arr.length);
		
		int min = 999, minIdx=0;	
		int max = 0, maxIdx=0; 	
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i]<min) {
				min = arr[i];
				minIdx = i;
				}
			if(arr[i]>max) {
				max = arr[i];
				maxIdx = i;
				}
			}
		System.out.println("�ּڰ� : "+arr[minIdx]);
		System.out.println("�ִ� : "+arr[maxIdx]);
	}
}

