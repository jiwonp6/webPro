package strategy3.modularization;

import strategy3.interfaces.*;

public class Lecturer extends Person{
	private String gua;
	public Lecturer(String id, String name, String gua) {
		super(id, name);
		this.gua=gua;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.print("\t°ú¸ñ : "+ gua);
		System.out.println();
	}

}
