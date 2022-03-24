package singleton1;

public class TestMain {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();	//private이라 new SingletonClass();불가능
		SingletonClass obj2 = SingletonClass.getInstance();
		obj1.setI(99);
		System.out.println("obj1의 i : "+obj1.getI());
		System.out.println("obj2의 i : "+obj2.getI());
		obj2.setI(20);
		System.out.println("obj1의 i : "+obj1.getI());
		System.out.println("obj2의 i : "+obj2.getI());
	}
}
