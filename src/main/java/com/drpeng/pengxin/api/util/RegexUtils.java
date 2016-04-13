/**
 * 
 */
package com.drpeng.pengxin.api.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * @since v1.1, 2016年2月6日
 */
public class RegexUtils {
	public static boolean isNumbers(Integer num){
		Pattern pattern = Pattern.compile("[0-9]*"); 
		Matcher isNum = pattern.matcher(String.valueOf(num));
		if(isNum.matches()){
			return true;
		}
		return false;
	}
}
