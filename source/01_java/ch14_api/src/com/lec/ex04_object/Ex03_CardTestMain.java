package com.lec.ex04_object;

import java.util.Random;

// ��  �� �� ��
public class Ex03_CardTestMain {
	public static void main(String[] args) {
		Card[] cards = { new Card('��',1),
						 new Card('��',2),
						 new Card('��',3),
						 new Card('��',4)};
		for(Card card : cards) {
			System.out.println(card);
		}
		
		Random random = new Random();
		char[] kinds = {'��',  '��', '��', '��'};
		Card comCard = new Card(kinds[random.nextInt(4)], random.nextInt(13)+1);
		System.out.println("��ǻ�Ͱ� �����ϰ� ���� �� ī�� : "+ comCard);
		for (int idx = 0; idx < cards.length; idx ++) {
		if(cards[idx].equals(comCard)) {
			System.out.println(idx+"��° ī��� ��ġ�մϴ�.");
		} else {
			System.out.println(idx+"��° ī��� ����ġ �մϴ�.");
		}
		}
	}
}
