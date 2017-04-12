package com.dante.common.util;

public class StrUtil {
	
	/**
	 * 字符串为null或者空字符串
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string) {
		if(string==null||"".equals(string)){
			return true;
		}
		return false;
	}
	
	/**
	 * 字符串不为null或者空字符串
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty(String string) {
		if(string==null||"".equals(string)){
			return false;
		}
		return true;
	}

}
