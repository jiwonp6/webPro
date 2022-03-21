package com.lec.ex11_final;

public class TestMain {
	public static void main(String[] args) {
		Animal[] animals = {new Dog(), new Rabbit()};
		for(Animal animal : animals) {
			animal.running();
			animal.running();
			animal.stop();
		}
//		animals[0].running();
//		animals[0].running();
//		animals[0].stop();
//		animals[1].running();
//		animals[1].running();
//		animals[1].stop();
	
	}
}
