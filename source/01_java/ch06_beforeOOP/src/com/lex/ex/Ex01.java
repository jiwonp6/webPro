package com.lex.ex;
//1~10���� ������ �� ����ϰ�, �� ���� ¦������ Ȧ������ ���
public class Ex01 {
	public static void main(String[] args) {
		int tot=0;
		for(int i=1 ; i<=10 ; i++) {
			tot += i;
		}
		System.out.printf("1~10���� ������ ���� %d�Դϴ�.\n", tot);
		String msg;
		if(tot%2 == 0) {
			msg = "¦���Դϴ�.";
		}else {
			msg = "Ȧ���Դϴ�.";
		}
		System.out.println("�� "+tot+"�� "+msg);
	}
}
