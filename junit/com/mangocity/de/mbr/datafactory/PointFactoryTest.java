package com.mangocity.de.mbr.datafactory;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class PointFactoryTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testCutPoint() throws ExceptionAbstract {

		Map headMap = new HashMap();
		headMap.put("acctId", "22637439");
		System.out.println(SqlUtil.getInstance().selectOneString("queryPointBalanceByAccountId", headMap));
	}

}
