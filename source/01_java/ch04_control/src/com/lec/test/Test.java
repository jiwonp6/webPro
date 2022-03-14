package com.lec.test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단을 수행할 수를 입력하세요 : ");
		int ans;
		ans=sc.nextInt();
		int tot = 1;
		if(ans>0) {
			System.out.printf("<구구단 %d단>\n", ans);
			for(int i=1;i<=10;i++) {
			tot = ans*i;
			System.out.printf("%d * %d = %d\n", ans, i, tot );
			}
		}else {
			System.out.println("구구단을 수행할 수 없습니다.");
		}
		sc.close();
	}
}
