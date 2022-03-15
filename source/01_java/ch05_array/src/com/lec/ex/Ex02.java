package com.lec.ex;
//일반 for문 v.s. 확장 for문(배열출력)
public class Ex02 {
	public static void main(String[] args) {
		int[] arr = new int[3]; // ={0,0,0}
		for(int idx=0 ; idx<arr.length ; idx++) { //일반 for문 이용한 출력
			System.out.printf("arr[%d]=%d\n", idx, arr[idx]);
		}
		for(int temp : arr) { //확장 for문을 이용한 출력
		//temp가 0~2방까지 받음(값만 뿌려주고 싶을 때)
			System.out.println(temp);
		}
		for(int i=0 ; i<arr.length ; i++) {	//일반 for문을 이용한 배열 수정(배열 변경 가능)
			arr[i] = 5;
			System.out.println(arr[i]);
		}
		for(int temp : arr) { //확장 for문을 이용한 출력
			temp = 9;	
			System.out.println(temp);
		}
		
		System.out.println("수정후");	
		//temp가 바뀐거지 arr은 그대로임! 
		//따라서 그냥 출력할 때만 씀. 값이 바뀌진 않는다!
		
		for(int temp : arr) { //확장 for문을 이용한 출력	
			System.out.println(temp);
		}
	}
}
