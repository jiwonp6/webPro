package com.lec.ex11_robot;
//RobotOrder order = new RobotOrder();
//order.action(drawRobot�� ��ü);
public class RobotOrder {
	public void action(Robot robot) {	//Robot�޼ҵ��� robot�� ����
		if(robot instanceof SingRobot) {	// <- robot�� SingRobot���� Ÿ���� �ٲ���
			((SingRobot) robot).sing();
		}else if(robot instanceof DanceRobot) {
			((DanceRobot) robot).dance();
		}else {
			System.out.println("Ȯ��� �κ��̸� �̰��� �����ϼ���.");
		}
	}
}
