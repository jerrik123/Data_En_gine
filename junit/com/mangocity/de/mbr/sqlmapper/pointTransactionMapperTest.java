package com.mangocity.de.mbr.sqlmapper;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class pointTransactionMapperTest {

	@Test
	public void testQueryPointTransactionByPagination() throws ExceptionAbstract {
		SqlUtil.getInstance().init();
		Map inMap = new HashMap();
		inMap.put("mbrId", "42586905");
		inMap.put("beginDate", "2001-10-01");
		inMap.put("endDate", "2015-10-01");
		inMap.put("startNum", 0);
		inMap.put("endNum", 1);
		long start = System.currentTimeMillis();
		List<Map<String,Object>> list = SqlUtil.getInstance().selectList("queryPointTransactionByPagination", inMap);
		long end = System.currentTimeMillis();
		System.out.println(list);
		System.out.println((end-start)/1000.0);
	}

}
