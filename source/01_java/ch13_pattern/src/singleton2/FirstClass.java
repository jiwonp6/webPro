package singleton2;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();	//SingletonClass.getInstance()�� ������� �ʴ� ����
		System.out.println("�̱��� ��ü�� i�� : "+singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("�̱��� ��ü�� i��(������) : "+singletonObject.getI());
	}	//������ ����� -> ������ INSTANCE�� ������ i�� ����Ǿ� �ֱ⶧���� i ���� 999�� �״����
}
