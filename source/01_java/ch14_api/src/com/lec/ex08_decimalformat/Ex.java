package com.lec.ex08_decimalformat;

import java.text.DecimalFormat;

public class Ex {

	public static void main(String[] args) {
		double num = 1234567.89;
		long num2 = 12300000000000L;
		DecimalFormat df0 = new DecimalFormat("00000000"); // 0이 8자리 : 자리수를 0으로하면 반드시 출력
		System.out.println(df0.format(num));
		DecimalFormat df1 = new DecimalFormat("########"); // #이 8자리 : 8자리를 출력하는데 없으면 출력 안함
		System.out.println(df1.format(num));   // 알아서 반올림해서 올려줌
		DecimalFormat df2 = new DecimalFormat("0,000.000"); // 3자리마다 콤마. 소수점 3자리 출력
		System.out.println(df2.format(num));
		DecimalFormat df3 = new DecimalFormat("#,###.##%");
		System.out.println(df3.format(num));
		DecimalFormat df4 = new DecimalFormat("#.##E00");
		System.out.println(df4.format(num2));

	}

}
