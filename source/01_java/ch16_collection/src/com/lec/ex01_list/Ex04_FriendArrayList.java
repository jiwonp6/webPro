package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex02_map.Friend;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("È«", "010-9999-9999");
		friends[1] = new Friend("±è", "010-8888-9999");
		for(int i=0; i<friends.length; i++) {
			System.out.println(friends[i]);
		}
		/* ***ArrayList : index°¡ ÀÖ°í, Áßº¹Çã¿ë*** */
		ArrayList<Friend> fs = new ArrayList<Friend>();
		fs.add(new Friend("È«", "010-9999-9999"));	//0¹ø ÀÎµ¦½º
		fs.add(new Friend("±è", "010-8888-9999"));	//1¹ø ÀÎµ¦½º
		Friend temp = new Friend("ÀÌ", "010-7777-7777", new Date(95, 11, 12));
		fs.add(temp);	//2¹ø ÀÎµ¦½º
		for(int i=0; i<fs.size(); i++) {
			System.out.println(fs.get(i));
		}
	}
}
