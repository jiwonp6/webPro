package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass fistObj = new FirstClass();
		SecondClass secnObj = new SecondClass();
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("Main�Լ����� �̱��� ��ü�� i�� : "+singObj.getI());
	}
}
