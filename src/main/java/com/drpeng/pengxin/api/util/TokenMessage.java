package com.drpeng.pengxin.api.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


import org.springframework.stereotype.Controller;


/**
 * 获取token 和校验token类
 * 
 * @author zhangqiang
 *
 */

@Controller
public class TokenMessage {

	private String salt = "1c4416d4b23fb789a17016e0e4fc6061";
	
	// 获取token
	public String getToken() {

		String time = getTokenCurrentTime();
		String randnum = getCharAndNumr(32);
		String md5 = MD5(time + randnum + salt);
		return time + randnum + md5;

	}

	// 校验token
	public boolean checkToken(String token) {

		if (!token.isEmpty()) {
			if (token.length() == 81) {		// 截取出后32位
				String bgan = token.substring(0, token.length() - 32);
				String _token = token.substring(token.length() - 32, token.length());
				bgan = bgan + salt;
				if (_token.equals(MD5(bgan))) {
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	// =========================
	
	public String getTokenCurrentTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmssSSS");// 设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		return time;
		
	}

	// 获取到系统时间
	public String getCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");// 设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		return time;
	}

	// 生成32位随机字符串
	public String getCharAndNumr(int length) {
		String val = "";

		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字

			if ("char".equalsIgnoreCase(charOrNum)) // 字符串
			{
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) // 数字
			{
				val += String.valueOf(random.nextInt(10));
			}
		}

		return val;
	}

	// 利用md5加密，md5(20160111182625038＋32位随机数字加字母+salt)
	public String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
