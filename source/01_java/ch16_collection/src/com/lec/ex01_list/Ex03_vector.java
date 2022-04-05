package com.lec.ex01_list;

import java.util.Vector;

public class Ex03_vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(10);	// = vec.add(new Integer(10));
		//1.
		vec.add(new AClass());
		//2.
		BClass objB = new BClass();
		vec.add(objB);
		System.out.println(vec);
		//»Æ¿ÂforπÆ
		for(Object obj : vec) {
			System.out.print(obj+" ");
		}
		System.out.println();
		for(int idx=0; idx<vec.size();idx++) {
			System.out.print(vec.get(idx)+" ");
		}
		
		
	}
}
