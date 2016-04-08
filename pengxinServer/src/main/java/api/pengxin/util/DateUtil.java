package api.pengxin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getCurrentTime() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = df.format(new Date());// new Date()为获取当前系统时间
		return time;
	}

	//获取系统年月日的时间
	public static String getshowCurrentTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time = df.format(new Date());// new Date()为获取当前系统时间
		return time;
		
	}
	
	
	// 获取到一天后的时间
	public static String getAfonedayTime() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time2 = df.format(new Date(d.getTime() + 1 * 24 * 60 * 60 * 1000));
		return time2;
	}

	// 获取14后的时间
	public static String getMeetingRoomExp() {

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time2 = df.format(new Date(d.getTime() + 14 * 24 * 60 * 60 * 1000));
		return time2;

	}
	
 //获取14天后的年月日
	public static String getshowMeetingRoomExp() {

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time2 = df.format(new Date(d.getTime() + 14 * 24 * 60 * 60 * 1000));
		return time2;

	}
	

	// 获取当前时间后10分钟的时间
	public static String getAfterCurrentTimeByTenMinutes() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = df.format(new Date(d.getTime() + 10 * 60 * 1000));
		return time;
	}

	// 通过比较，判断是否过期
	/**
	 * 
	 * @param CurrentTime
	 *            系统当前时间
	 * @param AfonedayTime
	 *            24小时之后的时间
	 * @return
	 */

	public static boolean compare_date(String CurrentTime, String AfonedayTime) {

		boolean flag = true;

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date ct = df.parse(CurrentTime);
			Date at = df.parse(AfonedayTime);
			if (ct.getTime() > at.getTime()) {

				flag = false;
			} else if (ct.getTime() <= at.getTime()) {

				flag = true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return flag;
	}

	//获取两个日期之间的天数
	public static long getDays(String time) throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long s = df.parse(time).getTime()-new Date().getTime();
		long days =  (s/(24*60*60*1000));
		if(s>0 && days==0){
			return 1;
		}else if(s<=0){
			
			return 0;
		}else{
			return days;
		}
	}
	
}
