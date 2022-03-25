package strategy1.step4.modularization;
//필요한것만 import(ctrl+shift+o)
import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileNo;

public class LowRobot extends Robot{
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	public LowRobot() {
		setFly(new FlyNo());	//fly = new FlyNo();
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
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
