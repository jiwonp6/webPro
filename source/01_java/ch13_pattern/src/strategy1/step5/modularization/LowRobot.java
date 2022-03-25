package strategy1.step5.modularization;
//필요한것만 import(ctrl+shift+o)
import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileNo;

public class LowRobot extends Robot{
	public LowRobot() {
		setFly(new FlyNo());	//fly = new FlyNo(); 안됨
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}

}
