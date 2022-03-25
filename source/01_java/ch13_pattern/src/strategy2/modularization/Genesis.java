package strategy2.modularization;
//상속받은 멤버 : 3가지 부품 변수 + drive(일반), shape(추상), engine(일반), km(일반), fuel(일반), setter
import strategy2.interfaces.EngineMid;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;

public class Genesis extends Car{
	public Genesis() {
		setEngine(new EngineMid());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.print("제네시스 외형은");
		super.shape();
	}

}
