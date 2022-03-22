package com.lec.ex12_store;
//본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
//주택가에 매장1호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-6,000 순대국-안팔아 공기밥-1,000원
//대학가에 매장2호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-5,000 순대국-5,000  공기밥-무료
//증권가에 매장3호점: 김치찌개-6,000  부대찌개-7,000  비빔밥-7,000 순대국-6,000  공기밥-1,000원
public class HeadQuarterStore {
	//본사
	private String str;	
	public HeadQuarterStore(String str) {
		//super();	//object로 부터 상속받은 디폴트생성자
		this.str = str;
	}
	public void kimchi() {
		System.out.println("김치찌개 5,000원");
	}
	public void bude() {
		System.out.println("부대찌개 6,000원");
	}
	public void bibim() {
		System.out.println("비빔밥 6,000원");
	}
	public void sunde() {
		System.out.println("순댓국 5,000원");
	}
	public void gonggibab() {
		System.out.println("공기밥 1,000원");
	}
	//getter&setter
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
