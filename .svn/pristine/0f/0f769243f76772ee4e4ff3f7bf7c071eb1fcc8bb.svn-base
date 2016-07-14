package com.mangocity.de.mbr.sqlmapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.CommonUtils;
import com.mangocity.de.mbr.util.SqlUtil;

public class cashMapperTest {

	@Test
	public void testCashAccountCreate() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "10101010999");
		int i = SqlUtil.getInstance().insertOne("cashAccountCreate", inMap);
		System.out.println(i);
	}

	// 现金账户余额
	@Test
	public void testQueryCashAccountByMbrId() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "468162");
		Map<String, Object> map = SqlUtil.getInstance().selectOne(
				"queryCashAccountByMbrId", inMap);
		System.out.println(map);
	}

	// 现金账户进账
	@Test
	public void testQueryCashAccountInComeByCondition()
			throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "29875");
		long start = System.currentTimeMillis();
		List<Map<String, Object>> list = SqlUtil.getInstance().selectList(
				"queryCashAccountInComeByCondition", inMap);
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000.0);
		System.out.println(list);
	}

	// 现金账户出账
	@Test
	public void testQueryCashAccountOutComeByCondition()
			throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "29875");
		long start = System.currentTimeMillis();
		List<Map<String, Object>> list = SqlUtil.getInstance().selectList(
				"queryCashAccountOutComeByCondition", inMap);
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000.0);
		System.out.println(list);
	}

	// 现金账户申请记录(待出账记录)
	@Test
	public void testQueryCashAccountApplyRecordByCondition()
			throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "29875");
		List<Map<String, Object>> list = SqlUtil.getInstance().selectList(
				"queryCashAccountApplyRecordByCondition", inMap);
		System.out.println(list);
	}

	// 现金账户申请记录(待出账记录)
	@Test
	public void queryAllCashAccountTrans()
			throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "857642");
		inMap.put("beginDate", "2010-10-06");
		inMap.put("endDate", "2015-10-06");
		inMap.put("startNum", "0");
		inMap.put("endNum", "1");
		List<Map<String, Object>> list = SqlUtil.getInstance().selectList(
				"queryAllCashAccountTrans", inMap);
		System.out.println(list);
	}
}
