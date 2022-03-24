package strategy1.step3;

public class TestMain {
	public static void main(String[] args) {
		Robot[] robots = { new SuperRobot(),
							new StandardRobot(),
							new LowRobot()};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionRun();
			robot.actionWalk();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
	}
}