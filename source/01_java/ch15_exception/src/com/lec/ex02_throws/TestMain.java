package com.lec.ex02_throws;

public class TestMain {
	public static void main(String[] args) {
		try {
			new ThrowsEx();
		} catch (Exception e) {
			System.out.println("¿¹¿Ü"+e.getMessage());
		}
		System.out.println("³¡");
		
	}
}
