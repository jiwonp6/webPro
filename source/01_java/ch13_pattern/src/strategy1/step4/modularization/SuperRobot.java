package strategy1.step4.modularization;

import strategy1.step4.interfaces.*;

public class SuperRobot extends Robot{
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	public SuperRobot() {
		setFly(new FlyYes());	//fly = new FlyYes();
		setMissile(new MissileYes());
		setKnife(new KnifeYes());
	}
	@Override
	public void actionFly() {
		fly.fly();
	}
	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.knife();
	}
	//setter&getter
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
	

}
