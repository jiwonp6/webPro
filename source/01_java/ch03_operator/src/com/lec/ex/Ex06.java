package com.lec.ex;
// ���׿�����(?:) -> (����) ? (O�϶�) : (X�϶�)
public class Ex06 {
	public static void main(String[] args) {
		int h = 100;
		String result;
		result = (h%2==0) ? "¦��" : "Ȧ��";
		
			/*if (h%2==0) {
				result="¦��";
			}else {
				result="Ȧ��";
			} */
		
		System.out.println(result); 
	}
}
