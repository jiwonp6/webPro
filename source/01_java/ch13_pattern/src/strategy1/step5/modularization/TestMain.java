package strategy1.step5.modularization;
//5단계 : 기능을 부품화 -> 유지보수를 간편하게
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
		//SuperRobot을 업그레이드 요청 : 날수있습니다. => 고공비행합니다.
		//고공배행하는 부품 만들어 setFly만 호출
		
	}
}
