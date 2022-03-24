package com.lec.ex11_robot;
//RobotOrder order = new RobotOrder();
//order.action(drawRobot형 객체);
public class RobotOrder {
	public void action(Robot robot) {	//Robot메소드의 robot형 변수
		if(robot instanceof SingRobot) {	// <- robot을 SingRobot으로 타입을 바꿔줌
			((SingRobot) robot).sing();
		}else if(robot instanceof DanceRobot) {
			((DanceRobot) robot).dance();
		}else {
			System.out.println("확장된 로봇이면 이곳에 구현하세요.");
		}
	}
}
