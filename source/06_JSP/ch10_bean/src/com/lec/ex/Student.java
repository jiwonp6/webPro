package com.lec.ex;

public class Student {
	private String snum;
	private String name;
	private int grade;
	private char classes;
	private int score;
	public Student() { }
	public Student(String snum, String name, int grade, char classes, int score) {
		super();
		this.snum = snum;
		this.name = name;
		this.grade = grade;
		this.classes = classes;
		this.score = score;
	}
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getClasses() {
		return classes;
	}
	public void setClasses(char classes) {
		this.classes = classes;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
