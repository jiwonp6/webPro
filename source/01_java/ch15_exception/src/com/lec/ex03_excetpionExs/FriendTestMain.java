package com.lec.ex03_excetpionExs;

import java.util.Date;

public class FriendTestMain {

	public static void main(String[] args) {
		Friend hong = new Friend("È«±æµ¿","010-1234-9878");
		hong.setEnterDate(new Date(122,2,11));
		System.out.println(hong);
		Friend kim = new Friend("±è±æµ¿");
		System.out.println(kim);
		

	}

}
