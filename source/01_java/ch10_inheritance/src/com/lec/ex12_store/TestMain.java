package com.lec.ex12_store;

public class TestMain {
	public static void main(String[] args) {
		HeadQuarterStore st = new HeadQuarterStore("====����====");
		System.out.println(st.getStr());
		st.kimchi();
		st.bude();
		st.bibim();
		st.sunde();
		st.gonggibab();
		
		HeadQuarterStore st1 = new StoreNum1("====1ȣ��====");
		//StoreNum1 st1 = new StoreNum1(); �� ���� <--- �޼ҵ� ���� �ٸ��� �ȵ�(������ 5���� ����)
		st1.kimchi();
		st1.bude();
		st1.bibim();
		st1.sunde();
		st1.gonggibab();
		
		HeadQuarterStore st2 = new StoreNum2("====2ȣ��====");
		st2.kimchi();
		st2.bude();
		st1.bibim();
		st1.sunde();
		st1.gonggibab();
		
		HeadQuarterStore st3 = new StoreNum3("====3ȣ��====");
		st1.kimchi();
		st1.bude();
		st1.bibim();
		st1.sunde();
		st1.gonggibab();
	}
	
}
