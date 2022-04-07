package com.lec.ex03_math;

import java.util.Random;

// �ζǹ�ȣ 6�� �̱�
public class Ex04 {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		Random random = new Random();

		for (int idx = 0; idx < lotto.length; idx++) {
//			lotto[i] = (random.nextInt(45)+1);		
			int temp = (random.nextInt(45) + 1); // ���� ������ �ӽ� ������ �����ϰ�
			boolean ok = true; // ���� ������ �ߺ��� �ƴ� ��� true / �ߺ��� ��� false
			for (int i = 0; i < idx; i++) {
				if (temp == lotto[i]) { // ���� ������ �ߺ��� �׷��� �ٽ� �̾ƾ���
					idx--;
					ok = false;
					break;
				}
			}
			if (ok) {
				lotto[idx] = temp;
			}
		}
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) { // idx��° ���� j��° ������ ũ�� �ٲ�
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		for (int l : lotto) {
			System.out.print(l + "\t");
		}

	}
}
