package com.mangocity.de.mbr.sqlmapper;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.CommonUtils;
import com.mangocity.de.mbr.util.SqlUtil;

public class VoucherFactoryTest {

	@Test
	public void testQueryNotUsedVoucher() throws ExceptionAbstract {
		Map headMap = new HashMap();
		headMap.put("memberCd", "0001918036");
		//headMap.put("voucherCode", "99991509473555");
		headMap.put("status", 0);
		headMap.put("startNum", "0");
		headMap.put("endNum", "5");
		List<Map<String,Object>> dataList = SqlUtil.getInstance().selectList("voucher_queryNotUsedVoucher", headMap);
		System.out.println(dataList);
	}

	@Test
	public void testQueryUsedVoucher() throws ExceptionAbstract {
		Map headMap = new HashMap();
		headMap.put("memberCd", "0001918036");
		headMap.put("startNum", "0");
		headMap.put("endNum", "5");
		//headMap.put("voucherCode", "99991509473555");
		List<Map<String,Object>> dataList = SqlUtil.getInstance().selectList("voucher_queryUsedVoucher", headMap);
		System.out.println(dataList);
	}
	@Test
	public void testUUID(){
		System.out.println(UUID.randomUUID().toString());
		System.out.println(CommonUtils.generateSpecifyLengthUUIDStr(32));
	}
	
	@Test
	public void voucher_queryVoucherOrderId(){
	}

}
