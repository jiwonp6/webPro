package com.lec.ex04_object;

public class Ex05_Point3DTestMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Point3D point1 = new Point3D();
		Point3D point2 = new Point3D(5.0,5.0,5.0);
		
		Point3D point3 = (Point3D) point2.clone();
		
		if(point2.equals(point3)) {
			System.out.println("같은 좌표를 가리키고 있습니다.");
		} else {
			System.out.println("다른 좌표를 가리키고 있습니다.");
		}
		
		if(point2 == point3) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
		
		
		
		
		
		

	}

}
