package com.lec.ex12_store;

public class TestMain2 {
	public static void main(String[] args) {
		HeadQuarterStore st[] = {new HeadQuarterStore("====본사===="), 
								 new StoreNum1("====1호점===="),
								 new StoreNum2("====2호점===="),
								 new StoreNum3("====3호점====")};
	//확장for
		for(HeadQuarterStore store : st) {
			System.out.println(store.getStr());
			store.kimchi();
			store.bude();
			store.bibim();
			store.sunde();
			store.gonggibab();
		}
	//일반for	
		System.out.println();
		for(int idx=0; idx<st.length; idx++) {
			System.out.println(st[idx].getStr());
			st[idx].kimchi();
			st[idx].bude();
			st[idx].bibim();
			st[idx].sunde();
			st[idx].gonggibab();
		}
	}
}
