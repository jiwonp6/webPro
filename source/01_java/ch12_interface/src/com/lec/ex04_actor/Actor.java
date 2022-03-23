package com.lec.ex04_actor;
//6개 메소드 - 추상메소드(오버라이드를 강요)
public class Actor implements IChef, IPoliceMan, IFireFIghter {
	private String actorName;
	public Actor(String actorName) {
		this.actorName = actorName;
	}
	@Override
	public void outFire() {
		System.out.println(actorName + "은 범인을 잡을 수 있습니다.");
	}
	@Override
	public void saveMan() {
		System.out.println(actorName + "은 사람을 구할 수 있습니다.");
	}

	@Override
	public void canCatchCriminal() {
		System.out.println(actorName + "은 범인을 잡을 수 있습니다.");
	}
	@Override
	public void canSearch() {
		System.out.println(actorName + "은 찾을 수 있습니다.");
	}
	@Override
	public void makePizza() {
		System.out.println(actorName + "은 피자를 만들 수 있습니다.");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println(actorName + "은 스파게티를 만들 수 있습니다.");
	}

}

