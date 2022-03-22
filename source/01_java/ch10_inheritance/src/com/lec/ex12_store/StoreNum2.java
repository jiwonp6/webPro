package com.lec.ex12_store;
//대학가에 매장2호점: 부대찌개-5,000 비빔밥-5,000 공기밥-무료
public class StoreNum2 extends HeadQuarterStore{	//매개변수 없는 생성자 없다고 에러

	public StoreNum2(String str) {
		super(str);
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
	public void gonggibab() {
		System.out.println("공기밥은 무료");
	}
}
