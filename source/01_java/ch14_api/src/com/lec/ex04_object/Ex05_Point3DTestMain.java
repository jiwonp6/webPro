package com.lec.ex04_object;

public class Ex05_Point3DTestMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Point3D point1 = new Point3D();
		Point3D point2 = new Point3D(5.0,5.0,5.0);
		
		Point3D point3 = (Point3D) point2.clone();
		
		if(point2.equals(point3)) {
			System.out.println("���� ��ǥ�� ����Ű�� �ֽ��ϴ�.");
		} else {
			System.out.println("�ٸ� ��ǥ�� ����Ű�� �ֽ��ϴ�.");
		}
		
		if(point2 == point3) {
			System.out.println("���� �ּ�");
		} else {
			System.out.println("�ٸ� �ּ�");
		}
		
		
		
		
		
		

	}

}
