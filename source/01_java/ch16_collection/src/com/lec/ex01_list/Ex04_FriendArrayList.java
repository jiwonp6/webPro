package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex02_map.Friend;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("ȫ", "010-9999-9999");
		friends[1] = new Friend("��", "010-8888-9999");
		for(int i=0; i<friends.length; i++) {
			System.out.println(friends[i]);
		}
		/* ***ArrayList : index�� �ְ�, �ߺ����*** */
		ArrayList<Friend> fs = new ArrayList<Friend>();
		fs.add(new Friend("ȫ", "010-9999-9999"));	//0�� �ε���
		fs.add(new Friend("��", "010-8888-9999"));	//1�� �ε���
		Friend temp = new Friend("��", "010-7777-7777", new Date(95, 11, 12));
		fs.add(temp);	//2�� �ε���
		for(int i=0; i<fs.size(); i++) {
			System.out.println(fs.get(i));
		}
	}
}
