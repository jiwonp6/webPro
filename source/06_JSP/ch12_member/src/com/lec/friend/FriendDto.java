package com.lec.friend;

public class FriendDto {
	private int num;
	private String name;
	private String phone1;
	private String phone2;
	private String phone3;
	public FriendDto() { }
	public FriendDto(int num, String name, String phone1, String phone2, String phone3) {
		this.num = num;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	//toString(error확인 위함)
	@Override
	public String toString() {
		return "FriendDto [num=" + num + ", name=" + name + ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3="
				+ phone3 + "]";
	}
}
