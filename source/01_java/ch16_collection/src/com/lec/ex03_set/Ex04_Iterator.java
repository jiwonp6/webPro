package com.lec.ex03_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Ex04_Iterator {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("STR1");
		list.add("STR2");
		System.out.println(list);
		//iterator �� �Ⱦ�(for�� ���� ��)
		Iterator<String> iterator1 = list.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		//Ȯ��for
		for(String l : list) {
			System.out.println(l);
		}
		//map
		HashMap<String, String> map = new HashMap<String, String>(); 
		map.put("ȫ�浿", "010-8888-9999");
		map.put("��浿", "010-9999-9999");
		Iterator<String> iterator2 = map.keySet().iterator();
		while(iterator2.hasNext()) {
			String key = iterator2.next();	//key���� ���� ����� Ű�� �����Ͱ� ������ ���� ��°���
			System.out.println(key+" Ű ������ : "+map.get(key));
		}
		//set
		HashSet<String> set = new HashSet<String>();
		set.add("str0");
		set.add("str1");
		set.add("str1");
		Iterator<String> iterator3 = set.iterator();	//cf. map�� iterator
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}
	}
}
