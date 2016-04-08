package api.pengxin.util;

import java.util.Random;

public class RandomNumberUtils {
		//随机生成6位数字,每位数字都是小于10的数字
		public static String getSixRandomNumber(){
			Random random = new Random();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 6; i++) {
				int result=random.nextInt(10);
				sb.append(String.valueOf(result));
			}
			return sb.toString();
		}
}
