package strategy3.modularization;

public class TestMain {

	public static void main(String[] args) {
		Person student = new Student("456", "박지원", "654");
		Person lecturer = new Lecturer("123", "이소영", "321");
		Person staff = new Staff("789", "이다솜", "987");
		Person[] persons = {student, lecturer, staff};
		for(Person p : persons) {
			p.get();
			p.job();
			p.print();
		}
	
	
	}

}
