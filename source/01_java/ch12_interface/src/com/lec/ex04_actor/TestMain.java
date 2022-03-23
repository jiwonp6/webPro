package com.lec.ex04_actor;
//다중 구현은 가능 <---> 다중 상속은 불가능
public class TestMain {
	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();
		
		System.out.println("====================");
		
		IChef chefPark = new Actor("박요리사");
				//---> chefPark.canCatchCriminal()	//불가
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		IFireFIghter firePark = new Actor("박소방관");
		firePark.saveMan();
		firePark.outFire();
		IPoliceMan policePark = new Actor("박경찰관");
		policePark.canCatchCriminal();
		policePark.canSearch();
	}
}
