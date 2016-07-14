package com.mangocity.de.mbr.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 工具类
 */
public class Tools {

	/**
	 * 判字符串、对象是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static boolean isEmpty(Object obj_str) {
		return (obj_str == null || isEmpty(obj_str.toString()));
	}

	public static boolean isEmpty(Object[] objs) {
		return objs == null || objs.length == 0;
	}

	public static boolean isEmpty(Map map) {
		return map == null || map.isEmpty();
	}

	public static boolean isEmpty(Collection c) {
		return c == null || c.isEmpty();
	}

	public static boolean equals(Object src, Object dest) {
		if (null != src) {
			return src.equals(dest);
		}
		return src == dest;
	}

	public static boolean notEquals(Object src, Object dest) {
		return !equals(src, dest);
	}
	
	public static String toUpperCase(String str){
		if(!isEmpty(str)) return str.toUpperCase();
		return str;
	}
	
	public static  Date getLastDayOfMonthByDate(String date){
		  //String date = "2012-2-12";
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(java.sql.Date.valueOf(date));
		  calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		  int lastDate = calendar.get(Calendar.DATE);
		  System.out.println("lastDate:"+lastDate);
		  return calendar.getTime();
			
	}

	/**
	 * 获取当前月份
	 * 
	 * @return
	 */
	public static Integer getMonth() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}

	/**
	 * 获取当前年
	 * 
	 * @return
	 */
	public static Integer getYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 获取过期的年（默认为2年）
	 * 
	 * @return
	 */
	public static Integer getExpiryYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR) + 2;
		return year;
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static Integer getDate() {
		Calendar cal = Calendar.getInstance();
		int date = cal.get(Calendar.DATE);
		return date;
	}

	public static Integer getLastDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		int date = calendar.get(Calendar.DATE);
		return date;
	}

	public static Date getExpiryTime(Date date) throws ParseException {
		if (Tools.isEmpty(date)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String expirydate = String.valueOf(Tools.getTargetYear(date))
				+ Tools.addZeroByNum(Tools.getTargetMonth(date))
				+ Tools.getLastDate();
		return sdf.parse(expirydate);
	}
	
	public static Date getDateTime(Date date) throws ParseException {
		if (Tools.isEmpty(date)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String expirydate = String.valueOf(Tools.getYear(date))
				+ Tools.addZeroByNum(Tools.getTargetMonth(date))
				+ Tools.getDate(date);
		return sdf.parse(expirydate);
	}
	public static int getDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DATE);
	}
	public static int getTargetMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	public static int getTargetYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR) + 2;
	}
	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 对数目增加减号
	 * 
	 * @param points
	 * @return
	 */
	public static Long addBearPoints(Long points) {
		String targe = "-" + points.toString();
		return Long.parseLong(targe);
	}

	public static Long delBearPoints(Long points) {
		String targe = points.toString();
		if (targe.charAt(0) == '-') {
			targe = targe.substring(1, targe.length());
		}
		return Long.parseLong(targe);
	}

	public static Double exceptBearPoints(Double points) {
		if (points == null) {
			return Double.valueOf(0);
		}
		String p = points.toString();
		String b = p.substring(0, 1);
		if (b.equals("-")) {
			String n = p.substring(1, p.length());
			return Double.parseDouble(n);
		} else {
			return points;
		}
	}

	public static String validateToStr(Object obj) {
		return obj == null ? "" : obj.toString().trim();
	}

	// 把double转化成String类型返回
	public static String formatDouble(double intf) {
		Double intfD = new Double(intf);
		DecimalFormat df = new DecimalFormat("0.0");
		return df.format(intfD);
	}

	public static String addZeroByNum(Integer num) {
		String target = "1";
		if (num == 0) {
			return num.toString();
		}
		if (num < 10) {
			target = "0" + num;
		} else {
			target = num.toString();
		}
		return target;
	}

	public static boolean isBearNum(Long num) {
		String s = String.valueOf(num);
		char a = 'a';
		if (!Tools.isEmpty(s)) {
			a = s.charAt(0);
		}
		if ('-' == a) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取Txt文件的编码格式
	 * @param f
	 * @return
	 */
	public static String getFileEnCodeType(File f) {
		java.io.BufferedInputStream bin;
		String code = null;
		try {
			bin = new java.io.BufferedInputStream(new java.io.FileInputStream(f));
			int p = (bin.read() << 8) + bin.read();
			
			switch (p) {
			case 0xefbb:
				code = "UTF-8";
				break;
			case 0xfffe:
				code = "Unicode";
				break;
			case 0xfeff:
				code = "Unicode big endian";
				break;
			default:
				code = "ANSI";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("文件格式："+code);
		return code;
	}
	
	/**
	 * 获取会员登录的IP地址
	 * @return String ip
	 */
	public static String getIpAddr(HttpServletRequest request){
        String ip = request.getHeader("clientip");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
	}
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\mixianwang\\Desktop\\批量调整积分模板数据_new.txt");
		getFileEnCodeType(file );
	}

}
