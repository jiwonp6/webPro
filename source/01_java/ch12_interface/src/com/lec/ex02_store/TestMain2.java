package com.lec.ex02_store;
//���� ��ħ         : ��ġ�- 000  �δ��- 000  �����- 000 ���뱹- 000  �����- 000��
//���ð��� ����1ȣ��: ��ġ�-5,000  �δ��-5,000  �����-6,000 ���뱹-���Ⱦ� �����-1,000��
//���а��� ����2ȣ��: ��ġ�-5,000  �δ��-5,000  �����-5,000 ���뱹-5,000  �����-����
//���ǰ��� ����3ȣ��: ��ġ�-6,000  �δ��-7,000  �����-7,000 ���뱹-6,000  �����-1,000��
public class TestMain2 {
	public static void main(String[] args) {
		HeadQuarterStore[] st = {new StoreNum1("====1ȣ��===="),
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
