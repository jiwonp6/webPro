package com.lex.ex;
//1~10���� ������ �� ����ϰ�, �� ���� ¦������ Ȧ������ ���
public class Ex01_1 {
	public static void main(String[] args) {
// <1~to���� �����ϴ� ����>	
		int tot = sum(10);
		System.out.println(tot);
		
// <from~to���� �����ϴ� ����>	
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
		System.out.printf("1~10���� ������ ���� %d�Դϴ�.\n", tot);
*/
		
// <¦Ȧ �Ǻ� ����>
		
/*		String msg;
		if(tot%2 == 0) {
			msg = "¦���Դϴ�.";
		}else {
			msg = "Ȧ���Դϴ�.";
		}
		System.out.println("�� "+tot+"�� "+msg);
*/
	}
	
//	<�޼ҵ�1>	
	private static int sum(int to) {	//1~to���� ������ ��� return
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
//	<�޼ҵ�2>	
	private static int sum(int from, int to) {	//from~to���� ������ ��� return
		int result = 0;
		for(int i=from ; i<=to ; i++) {
			result += i;
		}
		return result;	//main�Լ��� ȣ���� ������ �ҷ���
	}
//	<�޼ҵ�3>
	private static String evenOdd(int value) {
		return value%2==0 ? "¦���Դϴ�." : "Ȧ���Դϴ�.";
//		String result = null;
//		if(value%2 == 0) {
//			return "¦���Դϴ�.";
//		}else {
//			return "Ȧ���Դϴ�.";
//		}
//		return result;
	}

}











