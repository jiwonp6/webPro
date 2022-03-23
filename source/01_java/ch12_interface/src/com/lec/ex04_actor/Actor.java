package com.lec.ex04_actor;
//6�� �޼ҵ� - �߻�޼ҵ�(�������̵带 ����)
public class Actor implements IChef, IPoliceMan, IFireFIghter {
	private String actorName;
	public Actor(String actorName) {
		this.actorName = actorName;
	}
	@Override
	public void outFire() {
		System.out.println(actorName + "�� ������ ���� �� �ֽ��ϴ�.");
	}
	@Override
	public void saveMan() {
		System.out.println(actorName + "�� ����� ���� �� �ֽ��ϴ�.");
	}

	@Override
	public void canCatchCriminal() {
		System.out.println(actorName + "�� ������ ���� �� �ֽ��ϴ�.");
	}
	@Override
	public void canSearch() {
		System.out.println(actorName + "�� ã�� �� �ֽ��ϴ�.");
	}
	@Override
	public void makePizza() {
		System.out.println(actorName + "�� ���ڸ� ���� �� �ֽ��ϴ�.");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println(actorName + "�� ���İ�Ƽ�� ���� �� �ֽ��ϴ�.");
	}

}

