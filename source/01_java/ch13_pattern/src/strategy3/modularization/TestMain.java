package strategy3.modularization;

public class TestMain {

	public static void main(String[] args) {
		Person student = new Student("456", "������", "654");
		Person lecturer = new Lecturer("123", "�̼ҿ�", "321");
		Person staff = new Staff("789", "�̴ټ�", "987");
		Person[] persons = {student, lecturer, staff};
		for(Person p : persons) {
			p.get();
			p.job();
			p.print();
		}
	
	
	}

}
