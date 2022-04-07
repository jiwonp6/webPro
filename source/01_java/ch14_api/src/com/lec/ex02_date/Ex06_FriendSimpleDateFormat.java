package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.lec.quiz.Friend;

public class Ex06_FriendSimpleDateFormat {
		public static void main(String[] args) {
			Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "05-22"),
								new Friend("�ű浿", "010-8888-8888", "03-28"),
								new Friend("���浿", "010-7777-8888", "08-22")};
			/*�˻��� ��ȭ��ȣ ���ڸ��� �Է¹޾�	=>�ý������κ��� ��¥�� �޾� "MM-dd"��Ÿ���� String���� ��ȯ "03-28"
			 * 0~������� �ش� ��ȭ��ȣ�� ������ ���		=>0~������� �ش� ���ϰ� ������ ��ȯ�� ��Ʈ�� "03-28" ������ ���
			 * �˻��� ���� �ʾ� ��� ���ϸ� ���µ���� ���	=>�ش�����ڰ� ���� ����� ���ϸ� ���µ���� ���
			 */
			Calendar now = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			int idx=0;
			while(true) {
				boolean searchOk = false;	
				for(idx=0; idx<friends.length; idx++) {
					String birth = friends[idx].getBirth();
					if(birth.equals(sdf.format(now.getTime()))) {
						System.out.println(friends[idx]);
						searchOk = true;
					}
				}
				if(!searchOk)	{	
					System.out.println("���� �����ڴ� �����ϴ�.");
				}
			}

	}
}
