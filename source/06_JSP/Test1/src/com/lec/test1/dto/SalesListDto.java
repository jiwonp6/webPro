package com.lec.test1.dto;

public class SalesListDto {
	private int custno;
	private String custname;
	private String gname;
	private int sum;
	
	private String pcode;
	
	public SalesListDto() {}

	//memberSalesList
	public SalesListDto(int custno, String custname, String gname, int sum) {
		this.custno = custno;
		this.custname = custname;
		this.gname = gname;
		this.sum = sum;
	}
	//productSalesList
	public SalesListDto(String pcode, int sum ) {
		this.pcode = pcode;
		this.sum = sum;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	@Override
	public String toString() {
		return "SalesListDto [custno=" + custno + ", custname=" + custname + ", gname=" + gname + ", sum=" + sum
				+ ", pcode=" + pcode + "]";
	}

}
