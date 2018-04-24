package com.doyd.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 获取或转换时间的工具类
 * 
 * 2011-11-1上午09:42:00
 * 
 */
public class DateUtil {

	public final static String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public final static String DEFAULT_DAY_FORMAT = "yyyy-MM-dd";
	public final static String HOUR_MINUTE_FORMAT = "HH:mm";
	
	/**
	 * 获取SimpleDateFormat实例
	 * 
	 * @param format
	 * @return
	 * 
	 */
	private static SimpleDateFormat getSimpleDateFormat(String format) {
		return new SimpleDateFormat(format);
	}

	/**
	 * 获取自定义格式的当前时间
	 * 
	 * @param format
	 * @return
	 */
	public static String now(String format) {
		return convertToString(new Date(), format);
	}
	

	/**
	 * 获取普通格式当前时间
	 * 
	 * @return
	 */
	public static String now() {
		return convertToString(new Date(), DEFAULT_TIME_FORMAT);
	}

	/**
	 * 获取普通格式当前时间
	 * 
	 * @return
	 */
	public static String today() {
		return convertToString(new Date(), DEFAULT_DAY_FORMAT);
	}
	
	public static String yesterday() {
		return convertToString(getYesterdayTimestamp());
	}
	
	public static String tomorrow() {
		return convertToString(getTomorrowTimestamp());
	}
	/**
	 * 将Date类型转换为自定义类型的String类型时间
	 * 
	 * @param format
	 * @param date
	 * @return
	 */
	public static String convertToString(Date date, String format) {
		return getSimpleDateFormat(format).format(date);
	}

	/**
	 * 将Date类型转换为普通格式的String类型时间
	 * 
	 * @param date
	 * @return
	 */
	public static String convertToString(Date date) {
		return convertToString(date, DEFAULT_TIME_FORMAT);
	}

	/**
	 * 将指定格式的String类型时间转换为Date类型
	 * 
	 * @param date
	 * @param format
	 * @return
	 * 
	 */
	public static Date convertToDate(String date, String format) {
		try {
			return getSimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			System.err.println("未能转换时间：" + date + "到格式：" + format + "\n" + e);
		}
		return null;
	}

	/**
	 * 将普通格式的的String类型时间转换成Date类型
	 * 
	 * @param date
	 * @return
	 * 
	 */
	public static Date convertToDate(String date) {
		return convertToDate(date, DEFAULT_TIME_FORMAT);
	}

	/**
	 * 将字符串类型的时间转换为Date类型
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertToDateFromLocaleUS(String date) {
		if (StringUtil.isEmpty(date)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			System.err.println("未能转换时间：" + date + "到格式：EEE MMM dd HH:mm:ss Z yyyy\n" + e);
		}
		return null;
	}

	/**
	 * LocaleUS时间格式转化为自定义时间格式
	 * 
	 * @param date
	 * @return
	 */
	public static String convertToString(String date) {
		return convertToString(convertToDateFromLocaleUS(date));
	}

	/**
	 * 时间戳转化为Date类型的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertToDate(long timestamp) {
		if(String.valueOf(timestamp).length()==10){
			timestamp *= 1000;
		}
		return new Date(timestamp);
	}

	/**
	 * 时间戳转化为String类型的时间
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String convertToString(long timestamp) {
		return convertToString(convertToDate(timestamp));
	}

	public static long convertToTimestamp(String date) {
		return convertToDate(date).getTime();
	}

	public static long convertToTimestamp(String date, String format) {
		return convertToDate(date, format).getTime();
	}

	/**
	 * 判断当前时间是否在指定的时间范围内
	 * 
	 * @auth 闫海鹏
	 * 
	 * @param str
	 *            数据库中取出来的时间
	 * @return
	 * @throws ParseException
	 * 
	 */
	/*
	public static boolean checkTime(String str) {
		List<String> allowedSendTime = StringUtil.splitToList(str);

		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);// 获得当前小时数
		int minutes = c.get(Calendar.MINUTE);// 获得当前分钟数
		c.clear();
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minutes);

		SimpleDateFormat sdf = getSimpleDateFormat("HH:mm");
		for (String sendTime : allowedSendTime) {
			try {
				Date d1 = sdf.parse(sendTime.split("-")[0]);
				Date d2 = sdf.parse(sendTime.split("-")[1]);
				if (d1.compareTo(c.getTime()) == -1 && d2.compareTo(c.getTime()) == 1)
					return true;
			} catch (ParseException e) {
				System.err.println("未能转换时间：" + sendTime + "到格式：HH:mm\n" + e);
			}
		}
		return false;
	}
	*/
	

	/**
	 * 返回一个时间几小时后的时间
	 * 
	 * @author 王勇
	 * @param date
	 *            string格式的时间
	 * @param hour
	 *            要增加的小时数
	 * @return
	 */
	public static Calendar addHoursToDate(String date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(convertToDate(date));
		calendar.add(Calendar.HOUR, hour);
		return calendar;
	}

	/**
	 * 比较指定的参数是否与现在相同
	 * 
	 * @auth 闫海鹏
	 * 
	 * @param pamram
	 *            年份、月份、日期、小时、分钟
	 * @param date
	 *            需要比较的时间
	 * @return
	 * 
	 */
	public static boolean compareTime(int pamram, String date) {
		Calendar calendar = Calendar.getInstance();
		int nowTime = calendar.get(pamram);
		calendar.setTime(convertToDate(date, "yyyy-MM-dd"));
		return nowTime == calendar.get(pamram);
	}

	/**
	 * 获取消息发送时间格式
	 * 
	 * @auth 闫海鹏
	 * 
	 * @param time
	 * @return
	 * 
	 */
	public static String getFormatTime(Date time) {
		if (time == null)
			return null;
		Calendar cNow = Calendar.getInstance();

		Calendar cCom = Calendar.getInstance();
		cCom.setTime(time);
		long timeDiff = cNow.getTimeInMillis() - cCom.getTimeInMillis();
		long dateDiff = cNow.get(Calendar.DATE) - cCom.get(Calendar.DATE);

		if (cNow.get(Calendar.YEAR) != cCom.get(Calendar.YEAR))
			return convertToString(time, "yyyy年MM月dd日 HH:mm");
		if (timeDiff < 1000 * 60)
			return "刚刚";
		else if (timeDiff < 1000 * 60 * 60)
			return timeDiff / 1000 / 60 + "分钟前";
		else if (timeDiff < 1000 * 60 * 60 * 24 && dateDiff == 0)
			return "今天 " + convertToString(time, "HH:mm");
		else if (timeDiff < 1000 * 60 * 60 * 24 * 2 && dateDiff == 1)
			return "昨天 " + convertToString(time, "HH:mm");
		else if (timeDiff < 1000 * 60 * 60 * 24 * 2 && dateDiff == 2)
			return "前天 " + convertToString(time, "HH:mm");
		else if (cNow.get(Calendar.MONTH) == cCom.get(Calendar.MONTH))
			return cNow.get(Calendar.DAY_OF_MONTH) - cCom.get(Calendar.DAY_OF_MONTH) + "天前" + convertToString(time, "HH:mm");
		else
			return convertToString(time, "MM月dd日 HH:mm");
	}

	public static String getFormatTime(String time) {
		return getFormatTime(convertToDate(time));
	}

	/**
	 * 当天的00:00:00.000时刻的时间戳
	 * 
	 * @return
	 * @author 郑德湖
	 * @date Oct 28, 2011 5:09:59 PM
	 */
	public static long getTodayTimestamp() {
		return convertToTimestamp(today(), DEFAULT_DAY_FORMAT);
	}
	
	public static long getYesterdayTimestamp() {
		return convertToTimestamp(today(), DEFAULT_DAY_FORMAT)-86400000;
	}
	
	public static long getTomorrowTimestamp() {
		return convertToTimestamp(today(), DEFAULT_DAY_FORMAT)+86400000;
	}
	
	public static void main(String[] args) {
		System.out.println(tomorrow().substring(0, 10));
		System.out.println(yesterday());
		System.out.println(System.currentTimeMillis());
		System.out.println(convertToTimestamp("2015-04-13 12:30:45"));
	}
}
