package singleton2;

public class SingletonClass {
	private int i=10;
	private static SingletonClass INSTANCE;	//singletonObject�� ����Ű�� �Ͱ� ����
	public static SingletonClass getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
//	=>�̷��Ե� ����
//	private static SingletonClass INSTANCE = new SingletonClass();
//	public static SingletonClass getInstance() {
//		return INSTANCE;
//	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
