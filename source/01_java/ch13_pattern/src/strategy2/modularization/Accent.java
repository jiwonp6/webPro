package strategy2.modularization;
//상속받은 멤버 : 3가지 부품 변수 + drive(일반), shape(추상), engine(일반), km(일반), fuel(일반), setter
import strategy2.interfaces.EngineLow;
import strategy2.interfaces.FuelDiesel;
import strategy2.interfaces.Km20;

public class Accent extends Car{
	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}
	@Override
	public void shape() {
		System.out.print("액센트 외형은");
		super.shape();
	}

}
