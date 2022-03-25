package strategy2.modularization;
//상속받은 멤버 : 3가지 부품 변수 + drive(일반), shape(추상), engine(일반), km(일반), fuel(일반), setter
import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km15;

public class Sonata extends Car{
	public Sonata() {
		setEngine(new EngineHigh());//engine = new EngineHigh(); 안됨
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.print("소나타 외형은");
		super.shape();
	}

}
