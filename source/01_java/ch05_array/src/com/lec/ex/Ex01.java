package com.lec.ex;
//
public class Ex01 {
	public static void main(String[] args) {
		int i ;	//변수의 선언
		i = 20;	//초기화
		//1. 배열 변수의 선언과 초기화
		int[] iArr = {10, 20, 30, 40, 50};	//{ }이용해서 값 넣어줌, iArr은 주소 넣고 있음
		iArr[2] = 300;	//배열은 index로 접근 (0~4, 4=iArr.length-1) ; 번째
		
		for(int idx = 0 ; idx<iArr.length ; idx++) {
			System.out.println(iArr[idx]);
		}
		//iArr[5] = 100;	->5번 없어서 넣으면 에러남!!
		
		//2. 배열변수 선언과 배열 메모리 공간 확보 = 배열크기 지정(변경불가)
		int[] iArr2 = new int[5];	//(변수new가 메모리 공간확보해주는 역할) ; 갯수
		// iArr2->쓰레기 값이 아니라 0으로 세팅되어져 있음
		for(int idx=0 ; idx<iArr2.length ; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		iArr[0] = 999; iArr2[1] = 888;
		for(int idx=0; idx<iArr2.length ; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		
		//3.배열 변수 선언
		int[] iArr3;
		iArr3= new int[3];	//배열공간 확보하고 그 안의 값은 0으로 자동 초기화(레퍼런스 변수)
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			System.out.printf("iArr3[%d] = %d\n", idx, iArr3[idx]);
		}
		
	}
}
