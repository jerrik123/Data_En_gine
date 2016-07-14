package com.mangocity.de.mbr.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUtil {

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	 /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, Object> paraFilter(Map<String, Object> sArray) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (sArray == null || sArray.size() <= 0) {
            return resultMap;
        }
        for (String key : sArray.keySet()) {
        	Object value = sArray.get(key);
            if (value == null || key.equals("sign")) {
                continue;
            }
            if(value instanceof String && "".equals(String.valueOf(value))){
            	continue;
            }
            if(value instanceof Date){
            	continue;
            }
            resultMap.put(key, value);
        }
        return resultMap;
    }
    
    public static void main(String[] args) {
		Date date = new Date();	
		System.out.println("date: " + date);
		System.out.println("millions: " + date.getTime() );
		
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}
}
