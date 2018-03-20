package com.demo.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <strong>Title : DateUtil</strong><br>
 * <strong>Description : 日期/时间处理工具类</strong><br>
 * <strong>Create on : May 10, 2011 11:12:15 AM</strong><br>
 * 
 * @author LiuLang<br>
 * @version v1.0<br>
 * <br>
 *          <strong>修改历史:</strong><br>
 *          修改人-------------修改日期-------------修改描述<br>
 *          --------------------------------------------<br>
 * <br>
 */
public abstract class DateUtil {
	/**
	 * 判断系统当前时间是否在给定的时间段内方法的返回值：在时间段内
	 */
	public static final int IN_TIME_SLICING = 0;
	/**
	 * 判断系统当前时间是否在给定的时间段内方法的返回值：在时间段之前
	 */
	public static final int BEFORE_TIME_SLICING = -1;
	/**
	 * 判断系统当前时间是否在给定的时间段内方法的返回值：在时间段之后
	 */
	public static final int AFTER_TIME_SLICING = 1;
	/**
	 * 判断系统当前时间是否在给定的时间段内方法的返回值：方法参数有错
	 */
	public static final int IN_OR_OUT_TIME_SLICING_ERR = -100;
	/**
	 * 判断两个Date时间的前后方法的返回值：第一个参数时间在第二个参数时间之前
	 */
	public static final int DATE1_BEFORE_DATE2 = 1;
	/**
	 * 判断两个Date时间的前后方法的返回值：第一个参数时间在第二个参数时间之后
	 */
	public static final int DATE1_AFTER_DATE2 = -1;
	/**
	 * 判断两个Date时间的前后方法的返回值：第一个参数时间和第二个参数时间相同
	 */
	public static final int DATE1_EQUAL_DATE2 = 0;
	/**
	 * 长日期格式（String）：yy-MM-dd hh:mm:ss
	 */
	public static final String LONG_DATE_FORMAT_STR = "yyyy-MM-dd hh:mm:ss";
	/**
	 * 长日期格式（String）：yy-MM-dd hh:mm:ss 
	 */
	public static final String SSS_DATE_FORMAT_STR = "yyyy-MM-dd hh:mm:ss SSS";
	/**
	 * 短日期格式（String）：yy-MM-dd
	 */
	public static final String SHORT_DATE_FORMAT_STR = "yyyy-MM-dd";
	
	/**
	 * 短日期格式（String）：yy-MM-dd HH:ss
	 */
	public static final String DATE_FORMAT_STR_MM = "yyyy-MM-dd HH:mm";
	
	public static final String LONG_DATE_FORMAT_24STR = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 页面日期格式
	 */
	public static final String PAGE_DATE_FORMAT_STR = "MM/dd/yyyy";
	
	public static final SimpleDateFormat DATE_FORMAT_MM_SDF = new SimpleDateFormat(
			DATE_FORMAT_STR_MM);
	
	public static final SimpleDateFormat PAGE_DATE_FORMAT_SDF = new SimpleDateFormat(
			"MM/dd/yyyy");
	
	/**
	 * 长日期格式（SimpleDateFormat）：yy-MM-dd hh:mm:ss
	 */
	public static final SimpleDateFormat LONG_DATE_FORMAT_SDF = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	/**
	 * 长日期格式（SimpleDateFormat）：yy-MM-dd hh:mm:ss
	 */
	public static final SimpleDateFormat SSS_DATE_FORMAT_SDF = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss SSS");
	/**
	 * 短日期格式（SimpleDateFormat）：yy-MM-dd
	 */
	public static final SimpleDateFormat SHORT_DATE_FORMAT_SDF = new SimpleDateFormat(
			"yyyy-MM-dd");

	/**
	 * 判断系统当前时间是否在给定的时间段内
	 * 
	 * @param stime
	 *            开始时间字符串
	 * @param etime
	 *            结束时间字符串
	 * @return 如果当前系统时间在配置开始时间前返回-1；如果当前系统时间在配置的时间段内返回0；相等返回1
	 */
	public static int inOrOutTimeSlicing(Date sDate, Date eDate) {
		return inOrOutTimeSlicing(new Date(), sDate, eDate);
	}

	/**
	 * 判断指定的时间cDate是否在给定的时间段内
	 * 
	 * @param cDate
	 *            需判断的时间
	 * @param stime
	 *            开始时间字符串
	 * @param etime
	 *            结束时间字符串
	 * @return 如果cDate在配置开始时间前返回-1；如果cDate在配置的时间段内(包含等于开始时间或者等于结束时间)返回0；相等返回1
	 */
	public static int inOrOutTimeSlicing(Date cDate, Date sDate, Date eDate) {
		if (null != cDate && null != sDate && null != eDate) {
			if (cDate.before(sDate)) {
				return BEFORE_TIME_SLICING;
			} else if (cDate.after(eDate)) {
				return AFTER_TIME_SLICING;
			} else {
				return IN_TIME_SLICING;
			}
		}
		return IN_OR_OUT_TIME_SLICING_ERR;
	}

	/**
	 * 判断系统当前时间是否在给定的时间段内
	 * 
	 * @param stime
	 *            开始时间字符串
	 * @param etime
	 *            结束时间字符串
	 * @return 如果当前系统时间在配置开始时间前返回-1；如果当前系统时间在配置的时间段内返回0；相等返回1
	 */
	public static int inOrOutTimeSlicing(String stime, String etime) {
		if (stime != null && etime != null) {
			if (stime.matches(RegexConstants.REGEX_SHORT_DATE))
				stime += " 00:00:00";
			if (etime.matches(RegexConstants.REGEX_SHORT_DATE))
				etime += " 23:59:59";
			Date sDate = getDate(LONG_DATE_FORMAT_SDF, stime);
			Date eDate = getDate(LONG_DATE_FORMAT_SDF, etime);
			return inOrOutTimeSlicing(sDate, eDate);
		}
		return IN_OR_OUT_TIME_SLICING_ERR;
	}

	public static int inOrOutTimeSlicing(String ctime, String stime,
			String etime) {
		if (ctime != null && stime != null && etime != null) {
			if (ctime.matches(RegexConstants.REGEX_SHORT_DATE))
				ctime += " 00:00:01";
			if (stime.matches(RegexConstants.REGEX_SHORT_DATE))
				stime += " 00:00:00";
			if (etime.matches(RegexConstants.REGEX_SHORT_DATE))
				etime += " 23:59:59";
			Date cDate = getDate(LONG_DATE_FORMAT_SDF, ctime);
			Date sDate = getDate(LONG_DATE_FORMAT_SDF, stime);
			Date eDate = getDate(LONG_DATE_FORMAT_SDF, etime);
			return inOrOutTimeSlicing(cDate, sDate, eDate);
		}
		return IN_OR_OUT_TIME_SLICING_ERR;
	}

	/**
	 * 为指定的Date增加指定的年数（可为正整数，负整数，0）
	 * 
	 * @param date
	 * @param yearNum
	 * @return
	 */
	public static Date addYear(Date date, int yearNum) {
		return add(date, yearNum, 0, 0, 0, 0, 0);
	}

	/**
	 * 为指定的Date增加指定的月数（可为正整数，负整数，0）
	 * 
	 * @param date
	 * @param monthNum
	 * @return
	 */
	public static Date addMonth(Date date, int monthNum) {
		return add(date, 0, monthNum, 0, 0, 0, 0);
	}

	/**
	 * 为指定的Date增加指定的天数（可为正整数，负整数，0）
	 * 
	 * @param date
	 * @param dayNum
	 * @return
	 */
	public static Date addDay(Date date, int dayNum) {
		return add(date, 0, 0, dayNum, 0, 0, 0);
	}

	/**
	 * 为指定的Date增加指定的小时数（可为正整数，负整数，0）
	 * 
	 * @param date
	 * @param hNum
	 * @return
	 */
	public static Date addHour(Date date, int hNum) {
		return add(date, 0, 0, 0, hNum, 0, 0);
	}

	/**
	 * 为指定的Date增加指定的分钟数（可为正整数，负整数，0）
	 * 
	 * @param date
	 * @param mNum
	 * @return
	 */
	public static Date addMinute(Date date, int mNum) {
		return add(date, 0, 0, 0, 0, mNum, 0);
	}

	/**
	 * 为指定的Date增加指定的秒数（可为正整数，负整数，0）
	 * 
	 * @param date
	 * @param sNum
	 * @return
	 */
	public static Date addSecond(Date date, int sNum) {
		return add(date, 0, 0, 0, 0, 0, sNum);
	}

	/**
	 * 为指定的Date增加指定的年数、月数、天数
	 * 
	 * @param date
	 * @param yearNum
	 * @param monthNum
	 * @param dayNum
	 * @return
	 */
	public static Date addShortDate(Date date, int yearNum, int monthNum,
			int dayNum) {
		return add(date, yearNum, monthNum, dayNum, 0, 0, 0);
	}

	/**
	 * 为指定的Date增加指定的年数、月数、天数、小时数、分钟数、秒数
	 * 
	 * @param date
	 * @param yearNum
	 * @param monthNum
	 * @param dayNum
	 * @param hNum
	 * @param mNum
	 * @param sNum
	 * @return
	 */
	public static Date add(Date date, int yearNum, int monthNum, int dayNum,
			int hNum, int mNum, int sNum) {
		if (date == null) {
			date = new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, yearNum);
		cal.add(Calendar.MONTH, monthNum);
		cal.add(Calendar.DAY_OF_MONTH, dayNum);
		cal.add(Calendar.HOUR_OF_DAY, hNum);
		cal.add(Calendar.MINUTE, mNum);
		cal.add(Calendar.SECOND, sNum);
		return cal.getTime();
	}

	/**
	 * 根据日期格式（SimpleDateFormat） 格式化指定日期（Date）为日期字符串
	 * 
	 * @param dateFormat
	 * @param date
	 * @return
	 */
	public static String getDateStr(SimpleDateFormat dateFormat, Date date) {
		if (dateFormat == null || date == null) {
			return null;
		}
		return dateFormat.format(date);
	}

	/**
	 * 根据日期格式（SimpleDateFormat） 格式化指定日期字符串为日期（Date）
	 * 
	 * @param dateFormat
	 * @param dateStr
	 * @return
	 */
	public static Date getDate(SimpleDateFormat dateFormat, String dateStr) {
		if (dateFormat == null
				|| dateStr == null
				|| (!dateStr.matches(RegexConstants.REGEX_MM_DATE)) && (!dateStr.matches(RegexConstants.REGEX_LONG_DATE) && !dateStr
						.matches(RegexConstants.REGEX_SHORT_DATE))) {
			return null;
		}
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取指定日期到系统当前时间相距年数
	 */
	public static long getYearsGap(Date date) {
		return (long) (getDaysGap(date, new Date()) / 365.24219);
	}

	/**
	 * 获取两个日期对象的相距年数
	 */
	public static long getYearsGap(Date date1, Date date2) {
		return (long) (getDaysGap(date1, date2) / 365.24219);
	}

	/**
	 * 获取两个日期对象的相距天数
	 */
	public static long getDaysGap(Date date1, Date date2) {
		return getHoursGap(date1, date2) / 24;
	}

	/**
	 * 获取两个日期对象的相距小时数
	 */
	public static long getHoursGap(Date date1, Date date2) {
		return getMinutesGap(date1, date2) / 60;
	}

	/**
	 * 获取两个日期对象的相距分钟数
	 */
	public static long getMinutesGap(Date date1, Date date2) {
		return getSecGap(date1, date2) / 60;
	}

	/**
	 * 获取两个日期对象的相距秒数
	 */
	public static long getSecGap(Date date1, Date date2) {
		return getMillSecGap(date1, date2) / 1000;
	}

	/**
	 * 获取两个日期对象的相距毫秒数
	 */
	public static long getMillSecGap(Date date1, Date date2) {
		return (date2.getTime() - date1.getTime());
	}

	/**
	 * 判断两个Date时间的前后
	 * 
	 * @param dstart
	 *            第一个Date类型的时间
	 * @param dend
	 *            第二个Date类型的时间
	 * @return 如果第一个时间在第二个时间之前返回值大于0；如果第一个时间在第二个时间之后返回值小于0；相当返回0
	 */
	public static int beforeOrAfter(Date date1, Date date2) {
		long tN = getMillSecGap(date1, date2);
		if (tN > 0)
			return DATE1_BEFORE_DATE2;
		else if (tN < 0)
			return DATE1_AFTER_DATE2;
		else
			return DATE1_EQUAL_DATE2;
	}

	/**
	 * 取得自1970年1月1日00:00:00 GMT以来此Date对象表示的毫秒数
	 */
	public static long dToN(Date date) {
		if (date == null) {
			date = new Date();
		}
		return date.getTime();
	}

	/**
	 * 取得常整型数字表示的时间
	 */
	public static Date nToD(long timeN) {
		Date date = new Date();
		date.setTime(timeN);
		return date;
	}

	/**
	 * 取得常整型数字表示的时间
	 */
	public static Date nToD(String timeNStr) {
		if (timeNStr != null) {
			try {
				return nToD(new Long(timeNStr).longValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String getDateFormatStr(int i) {
		if (i > 9)
			return i + "";
		if (i > 0 && i < 10)
			return "0" + i;
		return "-1";
	}

	public static String getDateFormatStr(String i) {
		return getDateFormatStr(Integer.parseInt(i));
	}

	public static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static int getCurrentMonth() {
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}

	public static String getCurrentYYYYMM() {
		int cMonth = getCurrentMonth();
		return getCurrentYear() + "-" + (cMonth > 9 ? "" : "0") + cMonth;
	}

	public static String getPrevYYYYMM() {
		int cMonth = getCurrentMonth();
		int cYear = getCurrentYear();
		if (cMonth == 1) {
			cMonth = 12;
			cYear = cYear - 1;
		} else {
			cMonth = cMonth - 1;
		}
		return cYear + "-" + (cMonth > 9 ? "" : "0") + cMonth;
	}

	public static int getCurrentDayOfMonth() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	public static int getCurrentDayOfWeek() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}

	public static int getCurrenDayOfYear() {
		return Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 
	 * TOD O返回指定年月的最后一天即获取指定年月一共有多少天
	 * 
	 * @param yearmonth
	 *            字符串的年月
	 * @return
	 */
	public static int getLastDayOfMonth(String yearmonth) {
		String year = yearmonth.substring(0, 4);
		String month = yearmonth.substring(5, 7);
		System.out.println("year--------------" + year + "month-------------"
				+ month);
		return getLastDayOfMonth(year, month);
	}

	/**
	 * 返回指定年月的最后一天即获取指定年月一共有多少天
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份，从1开始
	 * @return
	 */
	public static int getLastDayOfMonth(String year, String month) {
		if (!year.matches(RegexConstants.REGEX_POSITIVE_INTEGER)
				|| !month.matches(RegexConstants.REGEX_POSITIVE_INTEGER))
			return 0;
		return getLastDayOfMonth(Integer.parseInt(year, 10),
				Integer.parseInt(month, 10));
	}

	/**
	 * 返回指定年月的最后一天即获取指定年月一共有多少天
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份，从1开始
	 * @return
	 */
	public static int getLastDayOfMonth(int year, int month) {
		if (year < 0 || year > 9999 || month < 1 || month > 12)
			return 0;
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回指定年月的第一天是星期几，周日为第1天，从1开始
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return
	 */
	public static int getWeekForFirstDayOfMonth(String year, String month) {
		if (!year.matches(RegexConstants.REGEX_POSITIVE_INTEGER)
				|| !month.matches(RegexConstants.REGEX_POSITIVE_INTEGER))
			return 0;
		return getWeekForFirstDayOfMonth(Integer.parseInt(year, 10),
				Integer.parseInt(month, 10));
	}

	/**
	 * 返回指定年月的第一天是星期几，周日为第1天，从1开始
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getWeekForFirstDayOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获取两个日期之间月份集合
	 * 
	 * @param start
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @return
	 */
	public static String[] getAllMonths(String start, String end) {
		if (null == start || null == end)
			return null;
		String splitSign = "-";
		start = (start.matches(RegexConstants.REGEX_LONG_DATE) || start
				.matches(RegexConstants.REGEX_SHORT_DATE)) ? start.substring(0,
				7) : (start.matches(RegexConstants.REGEX_YEAR_MONTH) ? start
				: null);
		end = (end.matches(RegexConstants.REGEX_LONG_DATE) || end
				.matches(RegexConstants.REGEX_SHORT_DATE)) ? end
				.substring(0, 7) : (end
				.matches(RegexConstants.REGEX_YEAR_MONTH) ? end : null);
		if (null == start || null == end)
			return null;
		/*
		 * if(start.compareTo(end)>0){ //start大于end日期时，互换 String temp=start;
		 * start=end; end=temp; }
		 */
		List<String> list = new ArrayList<String>();
		String temp = start; // 从最小月份开始
		while (temp.compareTo(start) >= 0 && temp.compareTo(end) <= 0) {
			list.add(temp); // 首先加上最小月份,接着计算下一个月份
			String[] arr = temp.split(splitSign);
			int year = Integer.valueOf(arr[0]);
			int month = Integer.valueOf(arr[1]) + 1;
			if (month > 12) {
				month = 1;
				year++;
			}
			if (month < 10) {// 补0操作
				temp = year + splitSign + "0" + month;
			} else {
				temp = year + splitSign + month;
			}
		}

		return list.toArray(new String[list.size()]);
	}

	public static String[] getMonths(Date sDate, Date eDate, int day) {
		if(null == sDate || null == eDate || sDate.after(eDate)) return null;
		Calendar sc = Calendar.getInstance();
		sc.setTime(sDate);
		Calendar ec = Calendar.getInstance();
		ec.setTime(eDate);
		List<String> list = new ArrayList<String>();
		int sY = sc.get(Calendar.YEAR);
		int eY = ec.get(Calendar.YEAR);
		int sM = sc.get(Calendar.MONTH) + 1;
		int eM = ec.get(Calendar.MONTH) + 1;
		if(sY == eY && sM == eM) {
			list.add(sY + (sM > 9 ? "-" : "-0") + sM );
			return list.toArray(new String[list.size()]);
		}
		int diffMonth = (eY - sY) * 12 + eM - sM;
		int sDay = sc.get(Calendar.DAY_OF_MONTH);
		int eDay = ec.get(Calendar.DAY_OF_MONTH);
		Calendar ec1 = Calendar.getInstance();
		ec1.setTime(eDate);
		ec1.set(Calendar.DAY_OF_MONTH, eDay + 1);
		boolean f = false;
		if(sDay < day) {
			f = true;
			diffMonth++;
		}
		sc.set(Calendar.DAY_OF_MONTH, 1);
		sc.set(Calendar.MONTH, sM);
		int alldays = sc.getActualMaximum(Calendar.DAY_OF_MONTH);
		int tday = sDay > alldays ? alldays : sDay;
		sc.set(Calendar.DAY_OF_MONTH, tday);
		
		for(int i=0; i<diffMonth; i++) {
//			System.out.println("11--"+DateUtil.SHORT_DATE_FORMAT_SDF.format(sc.getTime()));
			if(sc.after(ec) && ec1.compareTo(sc) != 0) continue;
			int tY = sc.get(Calendar.YEAR);
			int tM = sc.get(Calendar.MONTH) + 1;
			int ttm = tM;
			int tty = tY;
			if(f) {
				ttm = ttm - 1;
				if(0 == ttm) {
					ttm = 12;
					tty = tty-1;
				}
			}
			list.add(tty + (ttm > 9 ? "-" : "-0") + ttm );
			sc.set(Calendar.DAY_OF_MONTH, 1);
			sc.set(Calendar.MONTH, tM);
			alldays = sc.getActualMaximum(Calendar.DAY_OF_MONTH);
			tday = sDay > alldays ? alldays : sDay;
			sc.set(Calendar.DAY_OF_MONTH, tday);
		}
//		System.out.println(list);
		return list.toArray(new String[list.size()]);
	}
	
	public static String getStrByDate(Date d){
		if(d!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date=sdf.format(d);
			return date;
		}
		return null;
	}

	public static void main(String[] args) {
		// String abs = "abs";
		// System.out.println("set"+abs.substring(0,
		// 1).toUpperCase()+abs.substring(1));
//		 Date date = getDate(SHORT_DATE_FORMAT_SDF, "2014-5-15");
//		 Date date1 = getDate(SHORT_DATE_FORMAT_SDF, "2014-8-13");
//		 System.out.println(getMonths(date, date1, 15));
		// System.out.println(getDateStr(SHORT_DATE_FORMAT_SDF, date));
		// date = add(date, 0, 13, 0, 0, 0, 0);
		// System.out.println(getDateStr(SHORT_DATE_FORMAT_SDF, date));
		// System.out.println(getDateStr(LONG_DATE_FORMAT_SDF,
		// nToD("1310199867000")));
		// Calendar calendar = Calendar.getInstance();
		// calendar.set(2013, 1, 1);
		// System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		// System.out.println(Integer.parseInt("09", 10));
		// System.out.println("2013".matches(RegexConstants.REGEX_POSITIVE_INTEGER));
		// System.out.println("02".matches(RegexConstants.REGEX_POSITIVE_INTEGER));
		// Calendar calendar = Calendar.getInstance();
		// calendar.set(2013, 2, 1);
		// SimpleDateFormat format = new SimpleDateFormat("E");
		// System.out.println("本月第一天是：" + format.format(calendar.getTime()));
		// System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		// System.out.println(getAllMonths("2014-02-31","2014-04-01").length);
//		 System.out.println("2014-02-31 14:23:32".substring(0,7));
		// System.out.println(getCurrentDayOfMonth());
		// System.out.println(getCurrentMonth());
		// System.out.println(getCurrentYear());
		// String[] oaTime = "2014-02-31".split("-");
		// String cost_month=oaTime[0]+"-"+oaTime[1];
		// oaTime = null;
		// System.out.println(cost_month);

//		System.out.println(getMonthsGap("2012-05-10", "2012-9-1", 15) + "");
		System.out.println("2012-05".compareTo("2012-06"));
		System.out.println(DateUtil.getDate(DateUtil.LONG_DATE_FORMAT_SDF, "2015-06-18 14:44:12"));
	}

}
