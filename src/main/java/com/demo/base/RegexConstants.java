package com.demo.base;

/**
 * <strong>Title : RegexConstants</strong><br>
 * <strong>Description : 常用正则表达式常量</strong><br>
 * <strong>Create on : Jul 10, 2011 9:55:49 PM</strong><br>
 * @author LiuLang<br>
 * @version v1.0<br>
 * <br>
 * <br>
 */
public abstract class RegexConstants {

	/**
	 * 正整数的正则表达式
	 */
	public static final String REGEX_POSITIVE_INTEGER = "\\d+";
	/**
	 * 负整数的正则表达式
	 */
	public static final String REGEX_NEGATIVE_INTEGER = "-\\d+";
	/**
	 * 整数的正则表达式
	 */
	public static final String REGEX_INTEGER = "[-+]?\\d+";
	
	/** 实数的正则表达式, 值为{@value}  -String*/ 
	public static final String REGEX_FLOAT = "[-+]?\\d+\\.?\\d*";
	/**
	 * 短日期（yy-MM）的正则表达式
	 */
	public static final String REGEX_YEAR_MONTH = "\\d{4}[-\\/]\\d{1,2}";
	/**
	 * 短日期（yy-MM-dd）的正则表达式
	 */
	public static final String REGEX_SHORT_DATE = "\\d{4}[-\\/]\\d{1,2}[-\\/]\\d{1,2}";
	/**
	 * 长日期（yy-MM-dd hh:mm:ss）的正则表达式
	 */
	public static final String REGEX_LONG_DATE = "\\d{4}[-\\/]\\d{1,2}[-\\/]\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}";
	
	/**
	 * 长日期（yy-MM-dd hh:mm:ss）的正则表达式
	 */
	public static final String REGEX_MM_DATE = "\\d{4}[-\\/]\\d{1,2}[-\\/]\\d{1,2}\\s\\d{1,2}:\\d{1,2}";
	
	/**
	 * 单个大写字母
	 */
	public static final String SINGLE_UPPER_CASE = "[A-Z]";
	/**
	 * 大写字母字符串
	 */
	public static final String UPPER_CASE = "[A-Z]+";
	
	/** 验证如${xxx}这样类型的字符串的正则表达式, 值为{@value}  -String*/ 
	public static final String PROPERTY_VALUE_ONLY = "^(\\$\\{)(.+)(\\})$";
	
	/** 验证如xx${xxx}xx${xxx}xx这样类型的字符串的正则表达式, 值为{@value}  -String*/ 
	public static final String HAS_PROPERTY_VALUE = "(\\$\\{([^\\$\\{\\}]+)\\})";
	
	public static void main(String[] args) {
		System.out.println("2012/05/07 14:23:40".matches(REGEX_LONG_DATE));
		System.out.println("2012-05".matches(REGEX_YEAR_MONTH));
//		System.out.println("AVG({other},dsfslf-2341)".matches("^AVG\\(([\\w,\\W]*)\\)$"));
//		System.out.println(Float.parseFloat("001.2"));
//		System.out.println("11--"+("avg()".subSequence(4, 4)).length());
//		Pattern p = Pattern.compile(PROPERTY_VALUE);
//		Matcher m = p.matcher("1ada${s23}sdlfs${sss}");
//		System.out.println("23--"+m.find());
//		System.out.println("11--"+"${sss}".matches(PROPERTY_VALUE));
//		System.out.println("22--"+m.group(2));
	}
}
