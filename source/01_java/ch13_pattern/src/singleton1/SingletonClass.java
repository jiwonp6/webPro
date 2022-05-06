package singleton1;
//教臂沛 : 迭茄锅父 按眉积己
public class SingletonClass {
	private int i;
	//按眉积己沁栏搁 弊 按眉 林家甫 return窍绊
	//按眉积己 救 沁栏搁 按眉积己窍绊 弊 林家甫 return
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
