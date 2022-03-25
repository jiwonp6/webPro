package strategy2.modularization;
//��ӹ��� ��� : 3���� ��ǰ ���� + drive(�Ϲ�), shape(�߻�), engine(�Ϲ�), km(�Ϲ�), fuel(�Ϲ�), setter
import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km15;

public class Sonata extends Car{
	public Sonata() {
		setEngine(new EngineHigh());//engine = new EngineHigh(); �ȵ�
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.print("�ҳ�Ÿ ������");
		super.shape();
	}

}
