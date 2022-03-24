package com.lec.ex06_volume;

public class TestMain {
	public static void main(String[] args) {
		IVolume[] volumes = {new TV(3), new Speaker(5), new TV(10), new Speaker(7)};
		for(IVolume temp : volumes) {
			temp.volumeDown();
			temp.volumeDown(8);
			temp.volumeUp();
			temp.volumeUp(11);
			temp.setMute(true);	//default ¸Þ¼Òµå
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}
}
