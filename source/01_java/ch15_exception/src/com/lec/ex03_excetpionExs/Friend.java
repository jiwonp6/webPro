package com.lec.ex03_excetpionExs;

import java.text.SimpleDateFormat;
import java.util.Date;

// Friend f = new Friend("�̸�","��ȭ��ȣ");
// sysout(f) => [�̸�]ȫ�浿 [��ȭ]****-****-9999 [�Է���]22��4��1��
public class Friend {
	private String name;
	private String tel;
	private Date enterDate;

	public Friend() {
	}

	public Friend(String name) {
		this.name = name;
		enterDate = new Date();
	}

	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
		enterDate = new Date();
	}

	@Override
	public String toString() {
		String telPost;
		if(tel != null) {
			String post = tel.substring(tel.lastIndexOf('-') + 1);
			telPost = "***-****-"+post;
		}else {
			telPost = "����\t\t";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy��MM��dd��");		
		return "[�̸�] " + name + " [��ȭ��ȣ] " + telPost + " [�Է���] " + sdf.format(enterDate) + " ģ����";		

		}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

}
