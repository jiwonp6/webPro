package com.lec.test1.dto;

public class GradeDto {
	private String grade;
	private String gname;
	
	public GradeDto() {}
	public GradeDto(String grade, String gname) {
		this.grade = grade;
		this.gname = gname;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
	@Override
	public String toString() {
		return "GradeDto [grade=" + grade + ", gname=" + gname + "]";
	}
	
}
