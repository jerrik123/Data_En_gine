package com.mangocity.de.mbr.sqlmapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.CommonUtils;
import com.mangocity.ce.util.MD5Algorithm;
import com.mangocity.de.mbr.util.SqlUtil;

public class ThirdpartyFactoryTest {

	@Test
	public void testWechatBinding() throws ExceptionAbstract {
		Map headMap = new HashMap();
		headMap.put("mbrId", "27493760");
		headMap.put("type", "11");
		headMap.put("openid", "F2BD0F73415D0F5AED38955BDAC73F9C");
		headMap.put("nick", "弑魂3");
		System.out.println(SqlUtil.getInstance().insertOne("bindThirdpartyAccount", headMap));
	}
	
	@Test
	public void testQueryTsIntUserByOpenid() throws ExceptionAbstract {
		Map headMap = new HashMap();
		headMap.put("openid", "CB0BCAC092B9F6F5620B21E5E6A2C55D");
		System.out.println(SqlUtil.getInstance().selectOne("queryTsIntUserByOpenid", headMap));
	}
	
	@Test
	public void testPassword() throws ExceptionAbstract {
		MD5Algorithm md5 = new MD5Algorithm();
		System.out.println(md5.generateMD5Str("081620"));
	}
	
	@Test
	public void test1() throws ExceptionAbstract {
		Object obj = "hel";
		System.out.println(CommonUtils.objectToLong(obj, -1L));
	}
	
	@Test
	public void testBindThirdpartyAccount() throws ExceptionAbstract {
		Map<String, Object> headMap = new HashMap<String, Object>();
		headMap.put("csn", 11200);
		headMap.put("type", 11);
		int rows = SqlUtil.getInstance().insertOne("bindThirdpartyAccount",
				headMap);
	}
	
	@Test
	public void testCore() throws ExceptionAbstract {
		JSONObject headMap = new JSONObject();
		headMap.put("id", "1002900");
		headMap.put("csn", "29041801");
		headMap.put("type", "11");
		headMap.put("loginCode", "CB0BCAC092B9F6F5620B21E5E6A2C55D");
		headMap.put("loginName", "CB0BCAC092B9F6F5620B21E5E6A2C55D");
		headMap.put("gendar", "1");
		headMap.put("birthday", "");
		headMap.put("region", "");
		headMap.put("birthday", "");
		headMap.put("remark", "");
		headMap.put("status", "1");
		headMap.put("saftKey", "");
		
		System.out.println(headMap.toJSONString());
	}

}
