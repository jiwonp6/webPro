package com.lec.ex;
//
public class Ex01 {
	public static void main(String[] args) {
		int i ;	//������ ����
		i = 20;	//�ʱ�ȭ
		//1. �迭 ������ ����� �ʱ�ȭ
		int[] iArr = {10, 20, 30, 40, 50};	//{ }�̿��ؼ� �� �־���, iArr�� �ּ� �ְ� ����
		iArr[2] = 300;	//�迭�� index�� ���� (0~4, 4=iArr.length-1) ; ��°
		
		for(int idx = 0 ; idx<iArr.length ; idx++) {
			System.out.println(iArr[idx]);
		}
		//iArr[5] = 100;	->5�� ��� ������ ������!!
		
		//2. �迭���� ����� �迭 �޸� ���� Ȯ�� = �迭ũ�� ����(����Ұ�)
		int[] iArr2 = new int[5];	//(����new�� �޸� ����Ȯ�����ִ� ����) ; ����
		// iArr2->������ ���� �ƴ϶� 0���� ���õǾ��� ����
		for(int idx=0 ; idx<iArr2.length ; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		iArr[0] = 999; iArr2[1] = 888;
		for(int idx=0; idx<iArr2.length ; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		
		//3.�迭 ���� ����
		int[] iArr3;
		iArr3= new int[3];	//�迭���� Ȯ���ϰ� �� ���� ���� 0���� �ڵ� �ʱ�ȭ(���۷��� ����)
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			System.out.printf("iArr3[%d] = %d\n", idx, iArr3[idx]);
		}
		
	}
}
