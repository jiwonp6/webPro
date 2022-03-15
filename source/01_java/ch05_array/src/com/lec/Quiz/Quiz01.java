package com.lec.Quiz;

public class Quiz01 {
	public static void main(String[] args) {
		int[] iArr= {10, 20, 30, 40, 50};
		int tot=0;

		for(int i=0 ; i<iArr.length ; i++) {
			tot += iArr[i];
		}
		System.out.printf("배열 값의 합은 %d", tot);
		
		//for(int temp : arr) {
		//	tot += temp;
		//}
	}
}


