package singleton1;
//�̱��� : ���ѹ��� ��ü����
public class SingletonClass {
	private int i;
	//��ü���������� �� ��ü �ּҸ� return�ϰ�
	//��ü���� �� ������ ��ü�����ϰ� �� �ּҸ� return
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
