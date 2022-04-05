package com.lec.ex01_list;

import java.util.ArrayList;

//����O, �ߺ�O
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
				// -> String�� arraylist(Object��(��ü��)�� �����ϴ�.)
		arrayList.add("str0");	//0�� �ε��� str0
		arrayList.add("str1");	//1�� �ε��� str1 -> 2
		arrayList.add("str2");	//2�� �ε��� str2 -> 3
		arrayList.add(1,"str11111");	//1�� �ε��� str11111
		System.out.println(arrayList);
		arrayList.set(1, "111");	//1�� �ε��� ���� ����
		for(String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove�� �Ŀ� - ");
		arrayList.remove(1);	//1�� �ε����� ������ ����->��ũ�⵵ ����(�ε����� �ϳ��� ������)
		System.out.println(arrayList);	
		arrayList.remove(arrayList.size()-1);	//�Ǹ����� �ε��� ������ ����
		System.out.println(arrayList);	
		for(int idx=0; idx<arrayList.size(); idx++) {
			System.out.printf("%d�� �ε��� ���� %s\n", idx, arrayList.get(idx));
		}
		arrayList.clear();	//arrayList�� ��� ������ ����
		if(arrayList.size()==0) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�.");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�.");
		}
		System.out.println(arrayList);
		arrayList = null;	//arrayList ��ü�� �������� ��
//		System.out.println(arrayList.size());
	}
}
