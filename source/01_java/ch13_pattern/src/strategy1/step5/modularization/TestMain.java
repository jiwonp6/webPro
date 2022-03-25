package strategy1.step5.modularization;
//5�ܰ� : ����� ��ǰȭ -> ���������� �����ϰ�
public class TestMain {
	public static void main(String[] args) {
		Robot superR = new SuperRobot();
		Robot standR = new StandardRobot();
		Robot lowR = new LowRobot();
		Robot[] robots = { superR, standR, lowR };
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		//SuperRobot�� ���׷��̵� ��û : �����ֽ��ϴ�. => ��������մϴ�.
		//��������ϴ� ��ǰ ����� setFly�� ȣ��
		
	}
}
