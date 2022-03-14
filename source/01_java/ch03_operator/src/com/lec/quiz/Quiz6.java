package com.lec.quiz;

import java.util.Scanner;

public class Quiz6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System. in);
		System.out.println("좋아하는 숫자가 뭔가요?");
		int su = scanner.nextInt();
		
		String result = su == 5 ? "저랑 같네요." : "저랑 다르네요.";
		System.out.println(result);
		scanner.close();
	}

}
