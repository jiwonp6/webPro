package com.lec.ex01_trycatch;

public class Ex04_finally {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2 };
		for (int i = 0; i <= arr.length; i++) { // �迭�� �ε���3���� ��� ����
			try {
			System.out.println("arr[" + i + "] = " + arr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("���� �޼��� : "+ e.getMessage());
			} finally { // ���ܰ� �߻����� �ʾƵ� ����, ���ܰ� �߻��ص� ����  �ݵ�� ���� ��
				System.out.println("try�� ���� �Ŀ��� catch�� �����Ŀ��� ����� �ᱹ �ݵ�� ����");
			}
		}
		System.out.println("���α׷� ��");
	}

}
