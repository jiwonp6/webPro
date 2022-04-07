package com.lec.ex03_excetpionExs;

import java.text.SimpleDateFormat;
import java.util.Date;

// Friend f = new Friend("이름","전화번호");
// sysout(f) => [이름]홍길동 [전화]****-****-9999 [입력일]22년4월1일
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
			telPost = "없음\t\t";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy년MM월dd일");		
		return "[이름] " + name + " [전화번호] " + telPost + " [입력일] " + sdf.format(enterDate) + " 친구됨";		

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
