package com.lex.ex;
//1~10까지 정수의 합 출력하고, 그 합이 짝수인지 홀수인지 출력
public class Ex01_1 {
	public static void main(String[] args) {
// <1~to까지 누적하는 로직>	
		int tot = sum(10);
		System.out.println(tot);
		
// <from~to까지 누적하는 로직>	
		int tot2 = sum(1,10);
		System.out.println(tot2);
		System.out.println(evenOdd(tot2));
		int tot3 = sum(10,100);
		System.out.println(tot3);
		System.out.println(evenOdd(tot3));
		
/*		int tot=0;
		for(int i=1 ; i<=10 ; i++) {
			tot += i;
		}	
		System.out.printf("1~10까지 정수의 합은 %d입니다.\n", tot);
*/
		
// <짝홀 판별 로직>
		
/*		String msg;
		if(tot%2 == 0) {
			msg = "짝수입니다.";
		}else {
			msg = "홀수입니다.";
		}
		System.out.println("합 "+tot+"는 "+msg);
*/
	}
	
//	<메소드1>	
	private static int sum(int to) {	//1~to까지 누적한 결과 return
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
//	<메소드2>	
	private static int sum(int from, int to) {	//from~to까지 누적한 결과 return
		int result = 0;
		for(int i=from ; i<=to ; i++) {
			result += i;
		}
		return result;	//main함수의 호출한 곳으로 불러들어감
	}
//	<메소드3>
	private static String evenOdd(int value) {
		return value%2==0 ? "짝수입니다." : "홀수입니다.";
//		String result = null;
//		if(value%2 == 0) {
//			return "짝수입니다.";
//		}else {
//			return "홀수입니다.";
//		}
//		return result;
	}

}











