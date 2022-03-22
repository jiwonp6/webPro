package com.lec.ex12_store;

public class TestMain {
	public static void main(String[] args) {
		HeadQuarterStore st = new HeadQuarterStore("====본사====");
		System.out.println(st.getStr());
		st.kimchi();
		st.bude();
		st.bibim();
		st.sunde();
		st.gonggibab();
		
		HeadQuarterStore st1 = new StoreNum1("====1호점====");
		//StoreNum1 st1 = new StoreNum1(); 도 가능 <--- 메소드 개수 다르면 안됨(지금은 5개로 같다)
		st1.kimchi();
		st1.bude();
		st1.bibim();
		st1.sunde();
		st1.gonggibab();
		
		HeadQuarterStore st2 = new StoreNum2("====2호점====");
		st2.kimchi();
		st2.bude();
		st1.bibim();
		st1.sunde();
		st1.gonggibab();
		
		HeadQuarterStore st3 = new StoreNum3("====3호점====");
		st1.kimchi();
		st1.bude();
		st1.bibim();
		st1.sunde();
		st1.gonggibab();
	}
	
}
