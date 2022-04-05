package com.lec.ex02_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		System.out.println(list.get(0));	//list �迭�� collection�� idx�� get��
		//HashMap<key��, Data> <- idx��� ��½ÿ� for�� ����
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(11, "str11");	//11Ű���� ������ "str11"�߰�
		hashMap.put(20, "str11");	//20Ű���� ������ "str20"�߰�
		hashMap.put(33, "str33");	//33Ű���� ������ "str33"�߰�
		System.out.println(hashMap.get(20));	//Ű������ ������ get��
		System.out.println("remove �� : "+hashMap);
		hashMap.remove(20);	//Ű������ remove�ؾ��� (��, 20key�� ���� remove��)
		System.out.println("remove �� : "+hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "������X "+hashMap : "������O "+hashMap);
		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "Lee soonsin");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap);
		Iterator<Integer> iterator = hashMap.keySet().iterator();	//hashMap�� keyset(��������)
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key+"�� �����ʹ� "+hashMap.get(key));
		}
	}
}
