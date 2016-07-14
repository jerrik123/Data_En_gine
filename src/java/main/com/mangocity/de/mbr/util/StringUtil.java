package com.mangocity.de.mbr.util;

import java.util.regex.Pattern;

import com.mangocity.ce.exception.IllegalParamException;
import com.mangocity.ce.util.AssertUtils;
/**
 * 
* @ClassName: StringUtil 
* @Description: (字符串工具类) 
* @author 刘春元
* @date 2015年6月16日 下午1:48:40 
*
 */
public class StringUtil {
	/**
	 * 字符串正则匹配方法
	 * @param string 要匹配的字符串
	 * @param regex 正则表达式
	 * @return
	 */
	public static boolean stringFilter(String string, String regex) {
		Pattern p = Pattern.compile(regex);
		return p.matcher(string).matches();
	}
	
	/**
	 * 移除日期后的.0
	 * @param string 
	 * @param 
	 * @return
	 * @throws IllegalParamException 
	 */
	public static String removeExtraDateChar(String localDateStr) throws IllegalParamException{
		AssertUtils.assertBlank(localDateStr);
		if(localDateStr.endsWith(".0")){
			localDateStr = localDateStr.substring(0, localDateStr.lastIndexOf(".0"));
		}
		return localDateStr;
	}
}
