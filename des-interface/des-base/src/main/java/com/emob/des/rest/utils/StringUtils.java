package com.emob.des.rest.utils;

public class StringUtils {
	public static boolean hasText(String text) {
		return text == null || text.trim().length() == 0 ? false : true;
	}
}
