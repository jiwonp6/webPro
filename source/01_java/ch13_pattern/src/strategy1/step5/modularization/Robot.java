package strategy1.step5.modularization;

import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
//Robot r = new Robot();
//r.actionFly(); ����(�����ڿ��� fly=new FlyNO(); ���ؼ�)
					// -> �̸� �����ϰ��� ��ü�����Ұ��ϵ��� abstract class�� 
public abstract class Robot {	//->��ü�����Ұ���
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	public void actionWalk(){
		System.out.println("���� �� �ִ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ִ�.");
	}
	public void shape() {
		String className = getClass().getName();	
		// strategy1.step2.SuperRobot���� SuperRobot�� ������ �ÿ���
		int idx = className.lastIndexOf('.');	//�� ������ '.'�� �ִ� ��ġ
		String name = className.substring(idx+1);	//idx+1��° �۾����� ������
		System.out.println("======"+name+"======");
		System.out.println(name + "������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}
	public void actionFly() {
		fly.fly();
	}
	public void actionMissile() {
		missile.missile();
	}
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