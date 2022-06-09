package com.lec.customer;


import java.sql.Date;
import java.sql.Timestamp;

public class CustomerDto {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String email;
	private String address;
	private String gender;
	private Date birth;
	private Timestamp rdate;
	//생성자
	public CustomerDto() {	}
	public CustomerDto(String id, String pw, String name, String tel, String email, String address, String gender,
			Date birth, Timestamp rdate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.birth = birth;
		this.rdate = rdate;
	}
	//setter&getter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	//toString
	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", address=" + address + ", gender=" + gender + ", birth=" + birth + ", rdate=" + rdate + "]";
	}
}
