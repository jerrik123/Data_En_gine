package com.mangocity.de.mbr.datafactory;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class VoucherFactoryTest {

	@Test
	public void testQueryNotUsedVoucher() throws ExceptionAbstract {
		Map headMap = new HashMap();
		headMap.put("memberCd", "0001918036");
		//headMap.put("voucherCode", "99991509473555");
		headMap.put("status", 0);
		List<Map<String,Object>> dataList = SqlUtil.getInstance().selectList("queryNotUsedVoucher", headMap);
		System.out.println(dataList);
	}

	@Test
	public void testQueryUsedVoucher() throws ExceptionAbstract {
		Map headMap = new HashMap();
		headMap.put("memberCd", "0001918036");
		//headMap.put("voucherCode", "99991509473555");
		List<Map<String,Object>> dataList = SqlUtil.getInstance().selectList("queryUsedVoucher", headMap);
		System.out.println(dataList);
	}

}
