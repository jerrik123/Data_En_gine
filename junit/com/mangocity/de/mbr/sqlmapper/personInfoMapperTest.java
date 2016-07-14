package com.mangocity.de.mbr.sqlmapper;


import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class personInfoMapperTest {

	@Test
	public void getPersonInfoTest() throws ExceptionAbstract{
		
		Map<String, Object> inMap = new HashMap<String, Object>();
		inMap.put("mbrId", "120342");
		inMap.put("mbrCd","MGO02000052991543");
		SqlUtil.getInstance().init();
		Map<String, Object> personInfo = SqlUtil.getInstance().selectOne(
				"getPersonInfo", inMap);
		
		
		System.out.println(personInfo);
	}

}
