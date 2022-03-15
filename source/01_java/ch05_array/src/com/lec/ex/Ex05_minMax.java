package com.lec.ex;

import java.util.Scanner;
//1. 사용자로 부터 영희, 철수, 길동, 영수, 말자의 키를 입력받아 평균키 출력
// 2. 최장신 친구 이름과 키, 최단신 친구이름과 키 출력
public class Ex05_minMax {
	public static void main(String[] args) {
		String[] arrName = {"영희", "철수", "길동", "영수", "말자"};
		int[] arrHeight = new int[arrName.length];
		Scanner sc = new Scanner(System.in);
		int totalHeight = 0;	// 입력받은 키 누적 변수
		
		for(int idx=0 ; idx < arrName.length ; idx++) {
			System.out.print(arrName[idx]+"의 키는 : ");
			arrHeight[idx] = sc.nextInt();
			totalHeight += arrHeight[idx];
		}
		System.out.println("평균키는 "+(double)totalHeight/arrName.length);
		
		int minHeight = 999, minIdx=0;	//최단신키와 인덱스(위치) 저장
		int maxHeight = 0, maxIdx=0; 	//최장신키와 인덱스(위치) 저장
		for(int i=0 ; i<arrName.length ; i++) {
			if(arrHeight[i]<minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
				}//if - 최단신키와 최단신 인덱스 찾기
			if(arrHeight[i]>maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
				}//if - 최장신키와 최장신 인덱스 찾기
			}//for
		System.out.println("최단신은 "+arrName[minIdx]+"이고, 키는 " + minHeight+"입니다.");
		System.out.println("최장신은 "+arrName[maxIdx]+"이고, 키는 " + maxHeight+"입니다.");
	}
}
