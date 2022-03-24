package strategy1.step2;

public class TestMain {
	public static void main(String[] args) {
		Robot[] robots = { new SuperRobot(),
							new StandardRobot(),
							new LowRobot()};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionRun();
			robot.actionWalk();
//			robot.actionFly();	//얘는 불가능 -> 형변환해서 가능하게 해줌
			if(robot instanceof SuperRobot) {
				SuperRobot r = (SuperRobot) robot;
				r.actionFly();
				r.actionMissile();
				r.actionKnife();
			}else if(robot instanceof StandardRobot) {
				StandardRobot r = (StandardRobot)robot;
				r.actionFly();
				r.actionMissile();
				r.actionKnife();
			}else if(robot instanceof LowRobot) {
				LowRobot r = (LowRobot)robot;
				r.actionFly();
				r.actionMissile();
				r.actionKnife();
			}
		}
	}
}