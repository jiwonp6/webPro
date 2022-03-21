package com.lec.ex2_human.main;

//com.lec.ex2_human 패키지의 모든 class를 import
import com.lec.ex2_human.*;
//import com.lec.ex2_human.*;은 모든 패키지 import함
//							즉, ---> import com.lec.ex2_human.Woman;
//								---> import com.lec.ex2_human.Man;
public class TestMain {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		System.out.println((i==j) ? "같다" : "다르다");		//기초데이터 타입에서의 같은지 비교(==)
		
		String name = "홍길동";
		String name2 = "홍길동";	//name이랑 name2에 같은 이름이면 같은 걸 가르킴, 즉 같음
		if(name.equals(name2)) {
			System.out.println("name과 name2는 같다.");
		}
		Woman hee1 = new Woman();	//ctrl + shift + o	---> 필요한 것만 import해줌(불필요한 것 삭제)
		Woman hee2 = new Woman();
//		hee1.method();
		if(hee1.equals(hee2)) {
			System.out.println("hee1과 hee2는 같다");
		}
		Man kang = new Man(22, 165, 60.2);
		Man kim = new Man(22, 180, 65.6);
		Man kim1;	// 래퍼런스 변수(객체변수) 선언
		kim1 = kim;
		Man kim2 = new Man(22, 180, 65.6);
		if(kim.equals(kim1)) {
			System.out.println("kim과 kim1은 같다.");	//같은 주소를 가리킨다.
		}
		if(!kim.equals(kim2)) {
			System.out.println("kim과 kim2는 다르다.");	//값들은 동일하지만 서로 다른 주소에 저장하므로 서로 다름.
		}
		kang.setHeight(160);
		kang.setWeight(50.9);	//매개변수 안에 double형 말고 int형 넣으면 묵시적 형변환 발생
		if(kang.calculateBMI() > 30) {
			System.out.println("건강하세요.");
		}else {
			System.out.println("건강하겠네요.");
		}
	}
}
