package com.lec.ex01_list;

import java.util.ArrayList;

//순서O, 중복O
public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[5];
		array[0] = "str0";
		array[1] = "str1";
		array[3] = "str3";
		for(int i=0; i<array.length; i++) {
			System.out.print("array["+i+"] = "+array[i]+"\t");
		}
		System.out.println();
		for(String arr : array) {
			System.out.print(arr+"\t");
		}
		System.out.println();
		System.out.println("~~~~~ArrayList~~~~~");
		ArrayList<String> arrayList = new ArrayList<String>();		
				// -> String형 arraylist(Object형(객체형)만 가능하다.)
		arrayList.add("str0");	//0번 인덱스 str0
		arrayList.add("str1");	//1번 인덱스 str1 -> 2
		arrayList.add("str2");	//2번 인덱스 str2 -> 3
		arrayList.add(1,"str11111");	//1번 인덱스 str11111
		System.out.println(arrayList);
		arrayList.set(1, "111");	//1번 인덱스 값을 수정
		for(String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove한 후에 - ");
		arrayList.remove(1);	//1번 인덱스의 데이터 삭제->방크기도 변함(인덱스가 하나씩 앞으로)
		System.out.println(arrayList);	
		arrayList.remove(arrayList.size()-1);	//맨마지막 인덱스 데이터 삭제
		System.out.println(arrayList);	
		for(int idx=0; idx<arrayList.size(); idx++) {
			System.out.printf("%d번 인덱스 값은 %s\n", idx, arrayList.get(idx));
		}
		arrayList.clear();	//arrayList의 모든 데이터 삭제
		if(arrayList.size()==0) {
			System.out.println("arrayList의 데이터는 없습니다.");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList의 데이터는 없습니다.");
		}
		System.out.println(arrayList);
		arrayList = null;	//arrayList 자체가 없어지는 것
//		System.out.println(arrayList.size());
	}
}
