package com.lec.ex;
//변수 중 실수형
public class VarEx05 {
	public static void main(String[] args) {
		//boolean b = true; //boolean -> true or false만 가능!
		//char b = '글';
				
		float f1;
		//f1 = 10.1 <- 실수 기본형은 double이므로 실행X (float은 4byte짜리여서 작음...)
		f1 = 10.1F; //<-소숫점자릿수가 작을 때 float으로 쓰기위해서는 뒤에 F붙여주면 된다
		System.out.println("f1="+f1);
		
		double d = 10.0000017;//<-기본형
		System.out.println("d="+d);
		
		f1=10.1f;
		d=10.1;
		if(f1==d) 
			System.out.println("Same!");
		else
			System.out.println("Different!");
	}

}
