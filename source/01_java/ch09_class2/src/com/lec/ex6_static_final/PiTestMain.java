package com.lec.ex6_static_final;

import com.lec.cons.Constant;	//Constant파일에서 받아오기위해 import필요

public class PiTestMain {
	public static void main(String[] args) {
		
	int r = 3;
	System.out.println("반지름 3의 원의 둘레는 "+2*Constant.PI*r);
	}
}