package com.lec.ex12_store;

public class TestMain2 {
	public static void main(String[] args) {
		HeadQuarterStore st[] = {new HeadQuarterStore("====����===="), 
								 new StoreNum1("====1ȣ��===="),
								 new StoreNum2("====2ȣ��===="),
								 new StoreNum3("====3ȣ��====")};
	//Ȯ��for
		for(HeadQuarterStore store : st) {
			System.out.println(store.getStr());
			store.kimchi();
			store.bude();
			store.bibim();
			store.sunde();
			store.gonggibab();
		}
	//�Ϲ�for	
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
