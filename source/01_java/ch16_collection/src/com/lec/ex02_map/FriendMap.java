package com.lec.ex02_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class FriendMap {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("friends1", new Friend("홍길동", "010-9999-9999"));
		friends.put("friends2", new Friend("김길동", "010-8888-9999"));
		friends.put("friends3", new Friend("신길동", "010-7777-9999"));
		friends.put("friends4", new Friend("마길동", "010-6666-9999"));
		friends.put("friends5", new Friend("윤길동", "010-5555-9999", new Date(95, 12, 12)));
		Iterator<String> iterator = friends.keySet().iterator();	//iterator(반복자)사용해서 while문으로 출력
		while(iterator.hasNext()) {	
			String key = iterator.next();
			System.out.println(key+"의 데이터는 "+friends.get(key));
		}
		//System.out.println(friends);	
	}
}
