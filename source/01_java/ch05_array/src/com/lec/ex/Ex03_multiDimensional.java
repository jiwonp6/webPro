package com.lec.ex;
//배열은 1차원 배열을 주로 씀
public class Ex03_multiDimensional {
	public static void main(String[] args) {
		int[] arr = {1,2,3};	//1차원 배열
		int[][] test = {{1,2,3},
						{4,5,6}};	//2차원 배열
		System.out.println(arr[2]);	//0~2번 index
		System.out.println(test[0][0]);	//0~1행 0~2열
		for(int i=0 ; i<test.length ; i++) {	//i=> 0~1행
			for(int j=0 ; j<test[i].length ; j++) {
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);
			}//for.j
		}//for.i
	}
}
