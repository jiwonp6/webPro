package com.lec.ex03_math;
// Math.ceil (�ø� �Ǽ���) => double �� return
// Math.round(�ݿø��� �Ǽ���) => ������ return
// Math.floor ( ���� �Ǽ���) => double �� return 
public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("�Ҽ������� �ݿø�, �ø�, ���� ");
		System.out.println("9.15�� �ø� : "+ (int)Math.ceil(9.15));
		System.out.println("9.15�� �ݿø� : "+ Math.round(9.15));
		System.out.println("9.15�� ���� : "+ (int)Math.floor(9.15));
		
		System.out.println("�Ҽ��� ù° �ڸ����� �ݿø�, �ø�, ����");
		System.out.println("9.15�� �ø� : "+ Math.ceil(9.15 * 10)/10); // 10�̳� 100 ��� �� ���ϰ� �������༭ ���ϴ� �ڸ����� �ݿø��ϰ�
		// �ٽ� ���� �ڸ� ã���ֱ�. ���Ѽ��� �ٽ� ������ 
		System.out.println("9.15�� �ݿø� : "+ Math.round(9.15* 10)/10.0); // round�� ������ return �̶� ������ 10.0 ���� �ϱ�
		System.out.println("9.15�� ���� : "+ Math.floor(9.15 * 10)/10);
		
		System.out.println("���� �ڸ����� �ݿø�, �ø�, ����");
		System.out.println("85�� �ø� : "+ (int)Math.ceil(85/10.0)*10);
		System.out.println("85�� �ݿø� : "+ Math.round(85/10.0)*10);
		
		
	}

}
