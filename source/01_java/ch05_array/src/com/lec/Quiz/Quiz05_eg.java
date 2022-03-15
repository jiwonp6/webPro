package com.lec.Quiz;

public class Quiz05_eg {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};	//8개(0~7)
		int[] sortArr = new int[arr.length];
		
		for(int i=0 ; i<arr.length ; i++) {
			sortArr[i] = arr[i];
		}
		//	오름차순 정렬 : Arrays.sort(sortArr);
		for(int i=0 ; i<sortArr.length ; i++) {	//i=0~7까지
			for(int j=i+1 ; j<sortArr.length ; j++) {	//j=i+1 ~ 7까지
				//i번째와 j번째 비교해서 i번째가 크면 교환
				if(sortArr[i]>sortArr[j]) {
					int temp = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = temp;
				}//if
			}//for.2
		}//for.1
		for(int temp : sortArr)
		System.out.print(temp+"\t");
	}
}
