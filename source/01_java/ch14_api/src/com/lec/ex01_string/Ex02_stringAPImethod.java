package com.lec.ex01_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "      ja   va      ";
		System.out.println("1."+str1.concat(str2));		//¹®ÀÚ¿­ °áÇÕ : abcXabcABCXabc
		System.out.println("2."+str1.substring(3));		//3¹ø¹æ ¹®ÀÚºÎÅÍ Âß
		System.out.println("3."+str1.substring(3,5));	//3¹ø¹æ ¹®ÀÚºÎÅÍ 5¹ø¹æ ¾Õ±îÁö
		System.out.println("4."+str1.length());		//±ÛÀÚ±æÀÌ7
		System.out.println("5."+str1.toUpperCase());	//´ë¹®ÀÚ·Î ABCXABC
		System.out.println("6."+str1.toLowerCase());	//¼Ò¹®ÀÚ·Î abcxabc
		System.out.println("7."+str1.charAt(3));	//3¹ø¹æ ¹®ÀÚ 'X'
		System.out.println("8."+str1.indexOf('b'));	//¹®ÀÚ idx 1Ãâ·Â
		System.out.println("9."+str1.indexOf('b', 3));	//3¹ø¹æºÎÅÍ °Ë»öÇØ¼­ Ã¹¹øÂ° 'b'À§Ä¡
		System.out.println("10."+str1.indexOf("abc"));	//"abc"À§Ä¡
		System.out.println("11."+str1.indexOf("abc", 2));	//2¹ø¹æºÎÅÍ °Ë»öÇØ¼­ "abc"À§Ä¡
		System.out.println("12."+str1.indexOf('j'));	//¾øÀ¸¸é -1 
		System.out.println("13."+str1.lastIndexOf('b'));	//¸¶Áö¸· 'b' idx¹İÈ¯
		System.out.println("14."+str1.lastIndexOf('b', 3));	//3¹ø¹æºÎÅÍ ¾ÕÀ¸·Î ¿À¸é¼­ bÃ£À½
		System.out.println("15."+str1.equals(str2));	//str1°ú str2°¡ °°Àº ¹®ÀÚ¿­ÀÎÁö false(´ë¼Ò¹®ÀÚ ±¸ºĞO)
		System.out.println("16."+str1.equalsIgnoreCase(str2));	//´ë¼Ò¹®ÀÚ ±¸ºĞ¾øÀÌ ºñ±³ true
		System.out.println("17."+str3.trim());	//¾ÕµÚ °ø¹éÁ¦°Å (Áß°£X)
		System.out.println("18."+str1.replace('a', 'b'));	//¹®ÀÚ¸¦ ¹Ù²Ş
		System.out.println("19."+str1.replace("abc", "££"));	//¹®ÀÚ¿­µµ °¡´É
		System.out.println("20."+str1.replaceAll("abc", "Z"));	
			//Á¤±ÔÇ¥Çö½Ä http://goo.gl/HLntbd
				//¿¬½ÀÀå : http://nextree.co.kr/p4327/
			// replaceAll°ú cf.replace
			String str = "¾È³çHello";		//¿µ¹®ÀÚ ´Ù *·Î ¹Ù²Ù±â
			System.out.println("+"+str.replaceAll("[a-zA-Z]", "*"));	//¾ËÆÄºªÀ» "*"À¸·Î ¼öÁ¤
			System.out.println("+"+str.replaceAll("[°¡-ÆR]", "*"));	//ÇÑ±ÛÀ» "*"À¸·Î ¼öÁ¤
		//¹®ÀÚ¿­ ¸Ş¼Òµå´Â ¹®ÀÚ¿­À» ¼öÁ¤ ¾ÈÇÔ
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+str2);
		System.out.println("str3 = "+str3);
		
	}
}
