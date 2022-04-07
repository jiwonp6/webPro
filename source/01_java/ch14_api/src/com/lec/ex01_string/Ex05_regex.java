package com.lec.ex01_string;

public class Ex05_regex {
	public static void main(String[] args) {
		String str = "010-9999-9999    yisy0703@naver.com    (02)565-8888    ¹İ°©½À´Ï´Ù. Hello   951212-2524251    010-8888-8888";
		System.out.println("replace => "+ str.replace("0", "È«"));	//0¸¸ È«À¸·Î ¹Ù²ñ
		/* Á¤±ÔÇ¥Çö½Ä(regex)
		 1. ÂüÁ¶ : goo.gl/HLntbd		¿¬½ÀÀå : regexr.com/regexpal.com
		 2. °£·«ÇÑ ¹®¹ı
		 	\d : ¼ıÀÚ¿Í ¸ÅÄ¡, [0-9]¿Í µ¿ÀÏ	\D : ¼ıÀÚ°¡ ¾Æ´Ñ °Í
		 	\s : whitespacen : space, ÅÇ, ¿£ÅÍ
		 	\w : ¿µ¹®ÀÚ³ª ¼ıÀÚ, [a-zA-z0-9]¿Í µ¿ÀÏ		\W : ¿µ¹®ÀÚ³ª ¼ıÀÚ°¡ ¾Æ´Ñ°Í
		 	. : ¹®ÀÚÇÏ³ª
		 	+ : 1¹øÀÌ»ó ¹İº¹
		 	* : 0¹øÀÌ»ó ¹İº¹
		 	? : 0~1¹øÀÌ»ó ¹İº¹
		 	{2,4} : 2~4È¸ ¹İº¹
		 3. Á¤±ÔÇ¥Çö½Ä ¿¬½ÀÀå : 
		 	ex. ÀüÈ­¹øÈ£ : .?[0-9]{2,3}.[0-9]{3,4}-[0,9]{4}
		 4. Æ¯Á¤ Á¤±ÔÇ¥Çö½ÄÀÇ ¹®ÀÚ¿­ º¯°æ : replaceAll("Á¤±ÔÇ¥Çö½Ä", "´ëÃ¼¹®ÀÚ¿­")
		 */
		//ÀüÈ­¹øÈ£ Áö¿ò
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0,9]{4}", "*ÀüÈ­¹øÈ£Áö¿ò*"));
		//ÀÌ¸ŞÀÏ Áö¿ò
		String str2 = "010-9999-9999    yisy0703@naver.com    (02)565-8888    ¹İ°©½À´Ï´Ù. Hello   951212-2524251    abc@hong.co.kr";
		System.out.println(str2.replaceAll("\\w+@\\w+(.\\w+){1,2}", "+"));
		//¾ËÆÄºª Áö¿ò
		System.out.println(str2.replaceAll("[a-zA-Z]", "-"));
		//ÇÑ±Û Áö¿ò
		System.out.println(str2.replaceAll("[°¡-ÆR¤¡-¤¾]", "~"));
		//ÁÖ¹Î¹øÈ£ µŞÀÚ¸® Áö¿ò
		System.out.println(str2.replaceAll("[0-9]{7}", "*******"));
	}
}
