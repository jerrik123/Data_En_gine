package com.mangocity.de.mbr.sqlmapper;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class mbrShipMapperTest {

	@Test
	public void testMbrShipCreate() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrshipId", "1010101011");
		int i = SqlUtil.getInstance().insertOne("mbrShipCreate", inMap);
		System.out.println(i);
	}
	
	@Test
	public void testMbrshipCategoryByCategoryCd() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("categoryCd", "0100100001");
		Map<String, Object> i = SqlUtil.getInstance().selectOne("mbrshipCategoryByCategoryCd", inMap);
		System.out.println(i);
	}
	
	@Test
	public void testMbrshipCategoryByCategoryId() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrshipCategoryId", "555");
		Map<String, Object> i = SqlUtil.getInstance().selectOne("queryMbrshipCategoryByCategoryId", inMap);
		System.out.println(i);
	}
	
	@Test
	public void testQueryMbrShipListByMbrid() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "857642");
		List<Map<String, Object>> i = SqlUtil.getInstance().selectList("queryMbrShipListByMbrid", inMap);
		System.out.println(i);
	}

}
