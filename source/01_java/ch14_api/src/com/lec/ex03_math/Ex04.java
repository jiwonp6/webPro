package com.lec.ex03_math;

import java.util.Random;

// 로또번호 6개 뽑기
public class Ex04 {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		Random random = new Random();

		for (int idx = 0; idx < lotto.length; idx++) {
//			lotto[i] = (random.nextInt(45)+1);		
			int temp = (random.nextInt(45) + 1); // 뽑은 난수를 임시 변수에 저장하고
			boolean ok = true; // 뽑은 난수가 중복이 아닐 경우 true / 중복일 경우 false
			for (int i = 0; i < idx; i++) {
				if (temp == lotto[i]) { // 뽑은 난수가 중복임 그러니 다시 뽑아야함
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
				if (lotto[i] > lotto[j]) { // idx번째 수가 j번째 수보다 크면 바꿈
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
