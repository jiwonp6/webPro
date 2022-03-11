package com.lec.ex;
// 논리연산자 : &&(and), ||(or) 
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		
		// &&연산자 좌항이 F면 우항 실행X
		boolean result = ((i>j) && (++j>h));//i>j가 F이므로 j 증가X
		System.out.println("result="+result+"\t j="+j);
		
		// ||연산자 좌항이 T이면 우항 실행X -> 즉, 실행시키려면 우항 F로 잡아야 함 
		result = ((i<j) || (++j>h));
		System.out.println("result="+result+"\t j="+j);	
	}
}
