package com.lec.ex03_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		System.out.println("double ���� : "+ Math.random());
		/*  0 <= Math.random() < 1
		 *  0 <= Math.random()*45 < 45
		 */
		System.out.println("0~45�̸��� double ���� : "+ (int)(Math.random()*45));
		System.out.println("�ζ� ��ȣ �̱� : "+ ((int)(Math.random()*45)+1));  // 1���� �������� +1
		
		Random random = new Random();
		System.out.println("int ���� : "+ random.nextInt());
		System.out.println("double ���� : "+ random.nextDouble()); // Math.random() �� ���� 
		System.out.println("T/F �� �ϳ� ���� : "+  random.nextBoolean());
		System.out.println("0~44 ������ ���� ���� : "+ random.nextInt(45)); //  0~3�̸��� ���� ���� 
		System.out.println("�ζ� ��ȣ �̱� : "+ (random.nextInt(45)+1));
		
		
	}
}
