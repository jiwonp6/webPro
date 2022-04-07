package com.lec.ex04_object;

public class Point3D implements Cloneable {
	private double x;
	private double y;
	private double z;
	
	public Point3D() {
	}

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "x = "+x + " y = "+y+" z = "+ z;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Point3D) {
			Point3D temp = (Point3D)obj;
			boolean xChk = x == temp.x;
			boolean yChk = y == temp.y;
			boolean zChk = z == temp.z;
			return xChk && yChk && zChk;
		} else {
			return false;
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	

	
	
	
	
}
