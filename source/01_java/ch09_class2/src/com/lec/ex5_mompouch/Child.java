package com.lec.ex5_mompouch;
//Child first = new Child("첫째");
//first.takeMoney(1000) ; 엄마 천원만ㅎ
public class Child {
	private String name;
	static MomPouch momPouch;	//<--- static으로 만들면 momPouch는 하나
										//default로 만들면 각자 momPouch가 하나씩 생겨버림
					//= new MomPouch();도 가능
	public Child(String name) { 	//데이터 초기화
		this.name = name;
		momPouch = new MomPouch();
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name+"가 "+money+"원 가져가서 엄마 지갑에 지금 "
										+momPouch.money+"원 있어.");
		}else {
			System.out.println(name+"가 돈을 못받았어. 엄마 지갑에 지금 "
										+momPouch.money+"원 밖에 없다.");
		}//if
	}//takeMoney
}//main
