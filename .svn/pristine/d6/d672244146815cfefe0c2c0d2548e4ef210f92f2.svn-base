package com.mangocity.de.mbr.util;

import java.util.Random;

/**
 * Created by Mango User dell Date 2011-3-31 Time 下午01:50:17 生成会员编号
 */
public class MbrCdUtil {

	/**
	 * 生成会员编号的逻辑 格式：MGO+02+12位的seq
	 */
	public static String getMbrCd(String cd, String seq12) {
		StringBuffer sb = new StringBuffer();
		if (seq12 == null || seq12.length() <= 0 || seq12.length() >= 12)
			return "";
		sb.append("MGO");
		sb.append(cd);
		for (int i = 0; i < (12 - seq12.length()); i++) {
			sb.append("0");
		}
		sb.append(seq12);
		return sb.toString();
	}

	/**
	 * 生成会籍编号的逻辑 格式：10位的seq
	 */
	public static String getMbrshipCd(String seq10) {
		StringBuffer sb = new StringBuffer();
		sb.append("66");
		if (seq10 == null || seq10.length() <= 0 || seq10.length() > 10)
			return "";
		for (int i = 0; i < (10 - seq10.length()); i++) {
			sb.append("0");
		}
		sb.append(seq10);
		return sb.toString();
	}

	/**
	 * 随机生成6位密码
	 */
	public static String gen6RandomPwd() {
		String password = "";
		for (int mm = 0; mm < 100; mm++) {
			Random rdm = new Random();
			String temp = Integer.toString(Math.abs(rdm.nextInt()));
			if (temp.trim().length() > 6) {
				password = temp.substring(0, 6);
			} else {
				password = temp;
			}
			if (!"111111".equals(password) && !"222222".equals(password)
					&& !"333333".equals(password) && !"444444".equals(password)
					&& !"555555".equals(password) && !"666666".equals(password)
					&& !"777777".equals(password) && !"888888".equals(password)
					&& !"999999".equals(password) && !"000000".equals(password)
					&& !"123456".equals(password) && !"654321".equals(password)) {
				break;
			}
		}
		return password;
	}

	/**
	 * 随机获取六位验证码
	 * 
	 * @return
	 */
	public static String gen6RandomCode() {
		String verifyCode = "";
		for (int mm = 0; mm < 100; mm++) {
			Random rdm = new Random();
			String temp = Integer.toString(Math.abs(rdm.nextInt()));
			if (temp.trim().length() > 6) {
				verifyCode = temp.substring(0, 6);
			} else {
				verifyCode = temp;
			}
			if (!"111111".equals(verifyCode) && !"222222".equals(verifyCode)
					&& !"333333".equals(verifyCode)
					&& !"444444".equals(verifyCode)
					&& !"555555".equals(verifyCode)
					&& !"666666".equals(verifyCode)
					&& !"777777".equals(verifyCode)
					&& !"888888".equals(verifyCode)
					&& !"999999".equals(verifyCode)
					&& !"000000".equals(verifyCode)
					&& !"123456".equals(verifyCode)
					&& !"654321".equals(verifyCode)) {
				break;
			}
		}
		return verifyCode;
	}
}
