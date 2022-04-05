package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		//����X
		hashSet.add("str0");
		hashSet.add("str1");
		System.out.println(hashSet);
		//�ߺ��Ұ�
		hashSet.add("str1");
		System.out.println(hashSet);
		//idx(����)���� �� ��½ÿ� iterator(�ݺ���)���
		Iterator<String> iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
