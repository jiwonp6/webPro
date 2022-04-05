package com.lec.ex03_set;
//HashSet
public class Student {
	private int grade;
	private String name;
	
	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}
	@Override
	public String toString() {
		return grade+"ÇÐ³â "+name;
	}
//equals ¿Í hashcode override
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Student) {
			return toString().equals(obj.toString());
// =		boolean gradeChk = grade ==((Student)obj).grade;
//			boolean nameChk = name.equals(((Student)obj).name);
//			return gradeChk && nameChk;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
