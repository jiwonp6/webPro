package com.lec.ex0_janmuri;
class PersonInfo{
	private String name;
	private int age;
	public PersonInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void print() {
		System.out.printf("이름=%s\t나이=%d\n", name, age);
	}
}
public class PersonInfoTestMain {
	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("박지원", 24), new PersonInfo("박지성", 21)};
		for(PersonInfo p : person) {
			p.print();
		}
		for(int idx=0 ; idx<person.length ; idx++) {
			person[idx].print();
		}
		//PersonInfo p = new PersonInfo();

	}

}
