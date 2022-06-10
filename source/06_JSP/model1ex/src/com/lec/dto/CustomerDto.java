package com.lec.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class CustomerDto {
	private String cid;
	private String cpw;
	private String cname;
	private String ctel;
	private String cemail;
	private String caddress;
	private String cgender;
	private Date cbirth;
	private Timestamp rdate;
	//생성자
	public CustomerDto() { }	//빈태그 사용하기 위해
	public CustomerDto(String cid, String cpw, String cname, String ctel, String cemail, String caddress,
			String cgender, Date cbirth, Timestamp rdate) {
		this.cid = cid;
		this.cpw = cpw;
		this.cname = cname;
		this.ctel = ctel;
		this.cemail = cemail;
		this.caddress = caddress;
		this.cgender = cgender;
		this.cbirth = cbirth;
		this.rdate = rdate;
	}
	//setter&getter
	public synchronized String getCid() {
		return cid;
	}
	public synchronized void setCid(String cid) {
		this.cid = cid;
	}
	public synchronized String getCpw() {
		return cpw;
	}
	public synchronized void setCpw(String cpw) {
		this.cpw = cpw;
	}
	public synchronized String getCname() {
		return cname;
	}
	public synchronized void setCname(String cname) {
		this.cname = cname;
	}
	public synchronized String getCtel() {
		return ctel;
	}
	public synchronized void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public synchronized String getCemail() {
		return cemail;
	}
	public synchronized void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public synchronized String getCaddress() {
		return caddress;
	}
	public synchronized void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public synchronized String getCgender() {
		return cgender;
	}
	public synchronized void setCgender(String cgender) {
		this.cgender = cgender;
	}
	public synchronized Date getCbirth() {
		return cbirth;
	}
	public synchronized void setCbirth(Date cbirth) {
		this.cbirth = cbirth;
	}
	public synchronized Timestamp getRdate() {
		return rdate;
	}
	public synchronized void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	//toString - 에러확인차 사용
	@Override
	public String toString() {
		return "CustomerDto [cid=" + cid + ", cpw=" + cpw + ", cname=" + cname + ", ctel=" + ctel + ", cemail=" + cemail
				+ ", caddress=" + caddress + ", cgender=" + cgender + ", cbirth=" + cbirth + ", rdate=" + rdate + "]";
	}
}
