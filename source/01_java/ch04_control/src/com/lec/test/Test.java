package com.lec.test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�������� ������ ���� �Է��ϼ��� : ");
		int ans;
		ans=sc.nextInt();
		int tot = 1;
		if(ans>0) {
			System.out.printf("<������ %d��>\n", ans);
			for(int i=1;i<=10;i++) {
			tot = ans*i;
			System.out.printf("%d * %d = %d\n", ans, i, tot );
			}
		}else {
			System.out.println("�������� ������ �� �����ϴ�.");
		}
		sc.close();
	}
}
