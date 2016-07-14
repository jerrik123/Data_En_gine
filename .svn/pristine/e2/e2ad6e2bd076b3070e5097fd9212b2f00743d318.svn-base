package com.mangocity.de.mbr.sqlmapper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class pointAccountMapperTest {

	@Test
	public void testPointAccountCreate() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "10101010999");
		inMap.put("pointTotal", "100.00");
		int i = SqlUtil.getInstance().insertOne("pointAccountCreate", inMap);
		System.out.println(i);
	}
	
	@Test
	public void testQueryUseredPointBalanceByMbrId() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "2454776");
		List<Map<String, Object>> bodyListMap = SqlUtil.getInstance().selectList("queryUseredPointBalanceByMbrId", inMap);
		System.out.println(bodyListMap);
	}
	
	@Test
	public void testQueryPointBalanceOnMonthByMbrId() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "2454776");
		List<Map<String, Object>> bodyListMap = SqlUtil.getInstance().selectList("queryPointBalanceOnMonthByMbrId", inMap);
		System.out.println(bodyListMap);
	}
	
	@Test
	public void testInsertPointBalance() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "1111100011");
		inMap.put("accountId", "88888888");
		int i = SqlUtil.getInstance().insertOne("insertPointBalance", inMap);
		System.out.println(i);
	}
	
	@Test
	public void testAutoAddVersion() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "468155");
		inMap.put("version", "2");
		int i = SqlUtil.getInstance().updateOne("updateVersionByMbrId", inMap);
		System.out.println(i);
	}
	
	@Test
	public void testQueryPointTranId() throws ExceptionAbstract {
		Long s =  (Long) SqlUtil.getInstance().selectOneString("queryPointTranId", null);
		System.out.println(s);
	}
	
	@Test
	public void testQueryPointAccountByCondition() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "468155");
		Map<String, Object> map = SqlUtil.getInstance().selectOne("queryPointAccountByCondition", inMap);
		System.out.println(map);
	}
	
	@Test
	public void testQueryPointAccountByMbrId() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "55255");
		Map<String, Object> map = SqlUtil.getInstance().selectOne("queryPointAccountByMbrId", inMap);
		System.out.println(map.get("stus"));
		BigDecimal b = (BigDecimal)map.get("stus");
		System.out.println(map);
	}

}
