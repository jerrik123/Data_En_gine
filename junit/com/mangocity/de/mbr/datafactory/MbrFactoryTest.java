package com.mangocity.de.mbr.datafactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
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
		headMap.put("mbrshipCd", "0000107130");
		Map map = SqlUtil.getInstance().selectOne("queryMbrByMbrshipCd", headMap);
		System.out.println(map);
	}
	
	@Test
	public void testQuerySystemDate() throws ExceptionAbstract{
		SqlUtil.getInstance().init();
		Date d=(Date) SqlUtil.getInstance().selectOneString("querySystemDate", null);
		System.out.println(d);
	}
	
	@Test
	public void testQueryMbrByMbrId() throws ExceptionAbstract{
		SqlUtil.getInstance().init();
		Map<String,Object> headMap = new HashMap<String,Object>();
		headMap.put("mbrId", "59108443");
		Map<String,Object> map = SqlUtil.getInstance().selectOne("queryMbrByMbrId", headMap);
		System.out.println(map);
	}

}
