package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		//순서X
		hashSet.add("str0");
		hashSet.add("str1");
		System.out.println(hashSet);
		//중복불가
		hashSet.add("str1");
		System.out.println(hashSet);
		//idx(순서)없는 거 출력시에 iterator(반복자)사용
		Iterator<String> iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
