package com.lec.ex11_robot;

public class TestMain {
	public static void main(String[] args) {
		Robot[] robots = { new SingRobot(), 
							new DanceRobot(), 
							new DrawRobot()};
		RobotOrder order = new RobotOrder();
		for(Robot robot : robots) {
			order.action(robot);
		}
		
	}
}
