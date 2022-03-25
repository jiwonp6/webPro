package strategy2.modularization;
//��ӹ��� ��� : 3���� ��ǰ ���� + drive(�Ϲ�), shape(�߻�), engine(�Ϲ�), km(�Ϲ�), fuel(�Ϲ�), setter
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
		System.out.print("���׽ý� ������");
		super.shape();
	}

}
