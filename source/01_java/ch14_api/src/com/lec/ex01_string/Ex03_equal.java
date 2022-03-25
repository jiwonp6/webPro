package com.lec.ex01_string;

import java.util.Scanner;

public class Ex03_equal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;
		do {
			System.out.println("I : input | U : update | X : exit");
			fn = sc.next();	//XxIiUu, etc
			switch(fn) {
			case "i" :
			case "I" : 
				System.out.println("input 로직 있을 곳");
				break;
			case "u" :
			case "U" : 
				System.out.println("update 로직 있을 곳");
				break;
			}
		}while(!fn.equalsIgnoreCase("x"));
		System.out.println("DONE");
	}
}
