package com.lec.ex02_store;
//본사 지침         : 김치찌개- 000  부대찌개- 000  비빔밥- 000 순대국- 000  공기밥- 000원
//주택가에 매장1호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-6,000 순대국-안팔아 공기밥-1,000원
//대학가에 매장2호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-5,000 순대국-5,000  공기밥-무료
//증권가에 매장3호점: 김치찌개-6,000  부대찌개-7,000  비빔밥-7,000 순대국-6,000  공기밥-1,000원
public class TestMain2 {
	public static void main(String[] args) {
		HeadQuarterStore[] st = {new StoreNum1("====1호점===="),
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
