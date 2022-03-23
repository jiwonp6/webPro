package com.lec.ex02_store;
//대학가에 매장2호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-5,000 순대국-5,000  공기밥-무료
public class StoreNum2 implements HeadQuarterStore{	//매개변수 없는 생성자 없다고 에러
	private String str;
	//생성자
	public StoreNum2(String str) {
		this.str = str;
	}
	//override
	@Override
	public void kimchi() {
		System.out.println("김치찌개 5,000원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순댓국 5,000원");
	}
	@Override
	public void gonggibab() {
		System.out.println("공기밥은 무료");
	}
	//getter&setter
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}
