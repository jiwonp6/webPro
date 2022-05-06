package com.lec.quiz3;

public class CustomerDto {
	private int cid;
	private String cphone;
	private String cname;
	private int cpoint;
	
	public CustomerDto() {}
	public CustomerDto(int cid, String cphone, String cname, int cpoint) {
		super();
		this.cid = cid;
		this.cphone = cphone;
		this.cname = cname;
		this.cpoint = cpoint;
	}
	public CustomerDto(String cname, String cphone, int cpoint) {
		super();
		this.cname = cname;
		this.cphone = cphone;
		this.cpoint = cpoint;
	}
	
	@Override
	public String toString() {
		return cname+"\t"+cphone+"\t\t"+cpoint+"\t";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCpoint() {
		return cpoint;
	}
	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}
	
	
}
