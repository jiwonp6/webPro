package practice;

import java.util.Scanner;

public class Prac {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("i ? ");
		int i = scanner.nextInt();
		
		System.out.println((i%3)==0 ? "3�ǹ��":"3�ǹ�����ƴ�");
		scanner.close();
	}

}
