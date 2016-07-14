package com.mangocity.de.mbr.sqlmapper;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class personMapperTest {

	@Test
	public void testPersonCreate() throws ExceptionAbstract {
		Map headMap = new HashMap();
		headMap.put("personId", 1111111111);
		int i = SqlUtil.getInstance().insertOne("personCreate", headMap);
		System.out.println(i);
	}

	@Test
	public void testQueryPersonByPersonId() throws ExceptionAbstract {
		Map headMap = new HashMap();
		headMap.put("personId", 3631509);
		System.out.println( SqlUtil.getInstance().selectOne("queryPersonByPersonId", headMap));
	}
	
	@Test
	public void testGetPersonId(){
		try {
			System.out.println(SqlUtil.getInstance().selectOneString("getPersonId", null));
		} catch (ExceptionAbstract e) {
			e.printStackTrace();
		}
	}
}
