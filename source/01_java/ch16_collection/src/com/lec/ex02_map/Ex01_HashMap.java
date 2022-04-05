package com.lec.ex02_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		System.out.println(list.get(0));	//list 계열의 collection은 idx로 get함
		//HashMap<key값, Data> <- idx없어서 출력시에 for문 못씀
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(11, "str11");	//11키값에 데이터 "str11"추가
		hashMap.put(20, "str11");	//20키값에 데이터 "str20"추가
		hashMap.put(33, "str33");	//33키값에 데이터 "str33"추가
		System.out.println(hashMap.get(20));	//키값으로 데이터 get함
		System.out.println("remove 전 : "+hashMap);
		hashMap.remove(20);	//키값으로 remove해야함 (즉, 20key와 값이 remove됨)
		System.out.println("remove 후 : "+hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "데이터X "+hashMap : "데이터O "+hashMap);
		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "Lee soonsin");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap);
		Iterator<Integer> iterator = hashMap.keySet().iterator();	//hashMap의 keyset(순서지정)
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key+"의 데이터는 "+hashMap.get(key));
		}
	}
}
