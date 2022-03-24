package strategy1.step4.modularization;

public class TestMain {
	public static void main(String[] args) {
		SuperRobot robot = new SuperRobot();
		robot.actionFly();
	//	robot.setFly(new FlyNo());	//외부에서 바꿔줄 수 있음
		robot.actionFly();
	}
}
