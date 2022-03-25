package strategy1.step5.modularization;

import strategy1.step4.interfaces.*;

public class SuperRobot extends Robot{
	public SuperRobot() {
		setFly(new FlyHigh());
		setMissile(new MissileYes());
		setKnife(new KnifeYes());
	}

}
