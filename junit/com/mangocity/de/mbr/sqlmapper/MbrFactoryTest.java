package com.mangocity.de.mbr.sqlmapper;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.CommonUtils;
import com.mangocity.ce.util.MD5Algorithm;
import com.mangocity.de.mbr.util.SqlUtil;

public class MbrFactoryTest {

	@Test
	public void testQueryMbrIdByLoginNameAndPassword() throws ExceptionAbstract {
		Map<String,Object> headMap = new HashMap<String,Object>();
		headMap.put("loginName", "jie.yang@mangocity.com");
		MD5Algorithm md5Algorithm = new MD5Algorithm();
		headMap.put("loginPwd", md5Algorithm.generateMD5Str("081620"));
		System.out.println( SqlUtil.getInstance().selectOneString("queryMbrIdByLoginNameAndPassword", headMap));
	}
	
	@Test
	public void testQueryMbrByMbrshipCd() throws ExceptionAbstract {
		Map<String,Object> headMap = new HashMap<String,Object>();
		Map map = SqlUtil.getInstance().selectOne("queryMbrByMbrshipCd", headMap);
		System.out.println(map);
	}
	
	@Test
	public void testQueryRegisterByLoginNameAndPassword() throws ExceptionAbstract {
		Map<String,Object> headMap = new HashMap<String,Object>();
		headMap.put("loginName", "jie.yang@mangocity.com");
		MD5Algorithm md5Algorithm = new MD5Algorithm();
		headMap.put("loginPwd", md5Algorithm.generateMD5Str("122222"));
		System.out.println( SqlUtil.getInstance().selectOneString("queryRegisterByLoginNameAndPassword", headMap));
	}
	
	@Test
	public void testPageNo() throws ParseException{
		/*Long pageNo = 2L;
		Long pageSize = 10L;
		Long startNum = (pageNo - 1) * pageSize;
		Long endNum = startNum + pageSize;
		System.out.println(startNum);
		System.out.println(endNum);*/
		
		/*String beginDate = "2014-09-01";
		String endDate = "2014-10-01";
		if(CommonUtils.parseDate(beginDate, "yyyy-MM-dd").after(CommonUtils.parseDate(endDate, "yyyy-MM-dd"))){
			System.out.println(1);
		}else{
			System.out.println(2);
		}*/
		/*String str = "OneTwoThreeFour";
		System.out.println("OneTwoThreeFour".indexOf("five"));*/
		
		if(true){
			System.out.println(2);
		}else if(true){
			System.out.println(1);
		}
	}

}
