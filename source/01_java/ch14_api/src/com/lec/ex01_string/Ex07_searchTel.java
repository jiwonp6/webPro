package com.lec.ex01_string;
//�迭�� �ִ� ��ȭ��ȣ ã�� ��ü ��ȭ��ȣ ���
import java.util.Scanner;

public class Ex07_searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999", "010-8888-8888", "010-7777-8888"};
		Scanner sc = new Scanner(System.in);
		String searchTel;	//����ڷκ��� ��ȭ��ȣ �޹�ȣ �Է¹��� ������ �Ҵ�
		boolean searchOk = false;	
		int idx=0;
		System.out.println("�˻��ϰ��� �ϴ� ȸ���� ��ȭ��ȣ ���ڸ���?");
		searchTel = sc.next();
		for(idx=0; idx<tels.length; idx++) {
			//��ȭ��ȣ ���ڸ� ����
			String post = tels[idx].substring(tels[idx].lastIndexOf('-')+1);
			if(post.equals(searchTel)) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ�� "+tels[idx]+"�Դϴ�.");
				searchOk = true;	//break �� ��� ���� ó������ ��ġ�ϴ� ��ȣ 1���� ����
			}//if- ��ȭ��ȣ ã�� ��� ���̻� �˻����� �ʰ� for�� ��������.
		}//for
		if(!searchOk)	{	//searchTel�� �迭 ��ȭ�� ��� ��ã�� idx ������ ���� ����
			System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�.");
		}
	
	
	}
}
