package com.lec.ex02_store;
//증권가에 매장3호점: 김치찌개-6,000  부대찌개-7,000  비빔밥-7,000 순대국-6,000  공기밥-1,000원
public class StoreNum3 implements HeadQuarterStore{	//매개변수 없는 생성자 없다고 에러
	private String str;
	//생성자
	public StoreNum3(String str) {
		this.str = str;
	}
	//override
	@Override
	public void kimchi() {
		System.out.println("김치찌개 6,000원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 7,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 7,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순댓국 6,000원");
	}
	@Override
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
