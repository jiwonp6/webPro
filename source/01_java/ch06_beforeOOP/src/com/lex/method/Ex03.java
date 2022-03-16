package com.lex.method;
//Arithmetic.sum / evenOdd(static) v.s. abs(일반)
public class Ex03 {
//	<static 함수 호출>	public이면 쓸 수 있음 (private X, 아무것도 안쓰면 그 내에서만 쓸 수 있음)
	//static은 사실 잘 쓰지 않는다. heap메모리 정리가 안되기 때문
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);	//Arithmetic class에 있는거 불러옴
		System.out.println("1부터 10까지의 합은 " + tot);
		System.out.println(Arithmetic.evenOdd(tot));
		
//	<abs 함수 호출>	 <-----객체화 과정 필요(heap메모리의 설계도를 ar(객체)로 만들어 따로 빼줌)
		Arithmetic ar = new Arithmetic();	
		//메모리 확보 위해 new 사용, ar이 class주소를 받아 가지고 있음
		System.out.println("-8의 절댓값은" + ar.abs(-8));
	}
}
