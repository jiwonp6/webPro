package com.lec.ex12_store;
//주택가에 매장1호점: 부대찌개-5,000  순댓국-안팔아
public class StoreNum1 extends HeadQuarterStore{	//매개변수 없는 생성자 없다고 에러

	public StoreNum1(String str) {
		super(str);
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순댓국 안팜");
	}
}
