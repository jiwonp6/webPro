package singleton1;

public class SingletonClass {
	private int i;
	//객체생성했으면 그 객체 주소를 return하고
	//객체생성 안 했으면 객체생성하고 그 주소를 return
	private static SingletonClass INSTANCE=null;
	public static SingletonClass getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
	private SingletonClass() {}
	//setter&getter
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
}
