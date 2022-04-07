package com.lec.ex08_decimalformat;

import java.text.DecimalFormat;

public class Ex {

	public static void main(String[] args) {
		double num = 1234567.89;
		long num2 = 12300000000000L;
		DecimalFormat df0 = new DecimalFormat("00000000"); // 0�� 8�ڸ� : �ڸ����� 0�����ϸ� �ݵ�� ���
		System.out.println(df0.format(num));
		DecimalFormat df1 = new DecimalFormat("########"); // #�� 8�ڸ� : 8�ڸ��� ����ϴµ� ������ ��� ����
		System.out.println(df1.format(num));   // �˾Ƽ� �ݿø��ؼ� �÷���
		DecimalFormat df2 = new DecimalFormat("0,000.000"); // 3�ڸ����� �޸�. �Ҽ��� 3�ڸ� ���
		System.out.println(df2.format(num));
		DecimalFormat df3 = new DecimalFormat("#,###.##%");
		System.out.println(df3.format(num));
		DecimalFormat df4 = new DecimalFormat("#.##E00");
		System.out.println(df4.format(num2));

	}

}
