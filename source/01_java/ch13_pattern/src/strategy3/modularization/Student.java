package strategy3.modularization;

import strategy3.interfaces.*;

public class Student extends Person{
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudey());
		setGet(new GetStudentPay());
	}
	@Override
	public void print() {
		super.print();
		System.out.print("\t¹Ý : "+ ban);
		System.out.println();
	}
	
}
