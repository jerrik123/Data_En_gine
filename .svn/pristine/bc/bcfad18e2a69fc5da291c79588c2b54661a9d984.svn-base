package com.mangocity.de.mbr.sqlmapper;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class pointConvertMapperTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQueryWltAccoutByBindUserName() throws ExceptionAbstract {
		SqlUtil.getInstance().init();
		Map inMap = new HashMap();
		inMap.put("bindUsername", "CLAIRE1009");
		List<Map<String, Object>> bodyListMap = SqlUtil.getInstance().selectList("queryWltAccoutByBindUserName",
				inMap);
		System.out.println(bodyListMap);
	}

}
