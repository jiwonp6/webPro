package strategy3.modularization;

import strategy3.interfaces.*;

public class Staff extends Person{
	private String buseo;
	public Staff(String id, String name, String buseo) {
		super(id, name);
		this.buseo=buseo;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.print("\tºÎ¼­ : "+ buseo);
		System.out.println();
	}
}
