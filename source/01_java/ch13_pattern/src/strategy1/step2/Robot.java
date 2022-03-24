package strategy1.step2;
//Robot�� ��ӹ��� Ŭ���� : SuperRobot, StandardRobot, LowRobot
public class Robot {
	public void actionWalk(){
		System.out.println("���� �� �ִ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ִ�.");
	}
	public void shape() {
		String className = getClass().getName();	
		// strategy1.step2.SuperRobot���� SuperRobot�� ������ �ÿ���
		int idx = className.lastIndexOf('.');	//�� ������ '.'�� �ִ� ��ġ
		String name = className.substring(idx+1);	//idx+1��° �۾����� ������
		System.out.println(name + "������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}
}