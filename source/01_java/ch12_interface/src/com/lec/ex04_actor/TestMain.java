package com.lec.ex04_actor;
//���� ������ ���� <---> ���� ����� �Ұ���
public class TestMain {
	public static void main(String[] args) {
		Actor park = new Actor("�ں���");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();
		
		System.out.println("====================");
		
		IChef chefPark = new Actor("�ڿ丮��");
				//---> chefPark.canCatchCriminal()	//�Ұ�
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		IFireFIghter firePark = new Actor("�ڼҹ��");
		firePark.saveMan();
		firePark.outFire();
		IPoliceMan policePark = new Actor("�ڰ�����");
		policePark.canCatchCriminal();
		policePark.canSearch();
	}
}
