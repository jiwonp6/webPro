package com.lec.ex02_map;
import java.text.SimpleDateFormat;
//Friend f = new Friend("全", "010-9999-9999");
//sysout(f) => 全狼 楷遏贸 010-9999-9999, 积老:04岿14老
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date birth;
	
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public Friend(String name, String tel, Date birth) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("积老 : MM岿dd老");
		if(birth != null){
			return name+"狼 楷遏贸 "+tel+", "+sdf.format(birth);
		}else {
			return name+"狼 楷遏贸 "+tel;
		}
	}
}
