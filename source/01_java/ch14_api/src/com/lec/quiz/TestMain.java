package com.lec.quiz;

import java.util.Scanner;

public class TestMain{
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "05-22"),
							new Friend("�ű浿", "010-8888-8888", "09-22"),
							new Friend("���浿", "010-7777-8888", "08-22")};
	
		Scanner sc = new Scanner(System.in);
		String searchTel = null;
		int idx=0;
		while(true) {
			System.out.println("�˻��� ��ȭ��ȣ ���ڸ�(��, ���Ḧ ���ϸ� x�� �Է��Ͻÿ�) : ");
			searchTel = sc.next();
			boolean searchOk = false;	
			for(idx=0; idx<friends.length; idx++) {
				String tel = friends[idx].getTel();
				String post = tel.substring(tel.lastIndexOf('-')+1);
				if(post.equals(searchTel)) {
					System.out.println(friends[idx]);
					searchOk = true;
				}
			}
			if(!searchOk)	{	
				System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�.");
			}
		}
		//sc.close();
	}
}
