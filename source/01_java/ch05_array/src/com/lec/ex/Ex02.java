package com.lec.ex;
//�Ϲ� for�� v.s. Ȯ�� for��(�迭���)
public class Ex02 {
	public static void main(String[] args) {
		int[] arr = new int[3]; // ={0,0,0}
		for(int idx=0 ; idx<arr.length ; idx++) { //�Ϲ� for�� �̿��� ���
			System.out.printf("arr[%d]=%d\n", idx, arr[idx]);
		}
		for(int temp : arr) { //Ȯ�� for���� �̿��� ���
		//temp�� 0~2����� ����(���� �ѷ��ְ� ���� ��)
			System.out.println(temp);
		}
		for(int i=0 ; i<arr.length ; i++) {	//�Ϲ� for���� �̿��� �迭 ����(�迭 ���� ����)
			arr[i] = 5;
			System.out.println(arr[i]);
		}
		for(int temp : arr) { //Ȯ�� for���� �̿��� ���
			temp = 9;	
			System.out.println(temp);
		}
		
		System.out.println("������");	
		//temp�� �ٲ���� arr�� �״����! 
		//���� �׳� ����� ���� ��. ���� �ٲ��� �ʴ´�!
		
		for(int temp : arr) { //Ȯ�� for���� �̿��� ���	
			System.out.println(temp);
		}
	}
}
