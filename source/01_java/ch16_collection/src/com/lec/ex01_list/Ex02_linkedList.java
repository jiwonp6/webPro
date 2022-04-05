package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex02_linkedList {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0");	//0번 인덱스
		linkedList.add("str1");	//1번 인덱스
		linkedList.add("str2");	//2번 인덱스
		linkedList.add("str3");	//3번 인덱스
		linkedList.add(1, "str1111");	//1번 인덱스 추가
		System.out.println(linkedList);	
		for(String list : linkedList) {
			System.out.print(list+"\t");
		}
		System.out.println();
		linkedList.clear();
		System.out.println(linkedList.isEmpty() ? "데이터X" : "데이터O");
	}
}
