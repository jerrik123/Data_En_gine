package com.mangocity.de.mbr.sqlmapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.New;
import com.mangocity.de.mbr.book.SqlMapper;
import com.mangocity.de.mbr.book.SqlMapper.TransacOperation;
import com.mangocity.de.mbr.util.SqlUtil;

public class PointFactoryTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testCutPoint() throws ExceptionAbstract {

		Map headMap = new HashMap();
		headMap.put("acctId", "22637439");
		System.out.println(SqlUtil.getInstance().selectOneString(
				"queryPointBalanceByAccountId", headMap));
	}

	@Test
	public void testAdjust() throws ExceptionAbstract {

		Map transactionMap = new HashMap();
		transactionMap.put("pointTransactionId", 7894557);
		transactionMap.put("adjustType", transactionMap.get("adjustType"));
		transactionMap.put("refSalesTransNO",
				transactionMap.get("salesTransNO"));
		transactionMap
				.put("adjustRemarks", transactionMap.get("adjustRemarks"));
		transactionMap.put("adjustReasonCode",
				transactionMap.get("adjustReasonCode"));
		transactionMap.put("productCode", transactionMap.get("partNumber"));
		transactionMap.put("createBy", "MEMBER API");
		transactionMap.put("createTime", new Date());
		SqlUtil.getInstance().init();
		System.out.println(SqlUtil.getInstance().selectOneString(
				"insertPointAdjustment", transactionMap));
	}

	/**
	 *    "mbrId": "59106423",
        "mbrshipCd": "660009912659",
        "mbrshipId":"9912659",
        "order_num":"201505156000246M",
        "order_src":"cc",
        "sales_trans_code":"8866050000",
        "sales_trans_amount":"1000",
        "sales_trans_date_time":"2015-10-12",
        "award_points":"5"
	 * @throws ExceptionAbstract
	 */
	@Test
	public void testAddAwardPoints() throws ExceptionAbstract {
		SqlUtil.getInstance().init();
		SqlMapper sqlMapper = null;
		List<SqlMapper> sqlMapperList = new ArrayList<SqlMapper>();//事务处理列表*/		
		
		Map inMap = new HashMap();
		inMap.put("salesTransCode", "8866050000");// 5代表跟团游
		inMap.put("merchantAccNo", "MANGO");
		// TODO scheme_id
		// TODO渠道
		inMap.put("salesBookingNo", "201505156000246M");
		inMap.put("salesTransNo", "201505156000246M");
		// inMap.put("salesTransDateTime",pb.getHead("sales_trans_date_time"));
		inMap.put("salesTransAmount", 1000);
		inMap.put("salesTransForeignAmount",1000);
		// TODO SALE_QTY
		// TODO付款方式
		inMap.put("createBy", "MEMBER API");
		
		sqlMapper = SqlMapper.getInstance().sqlId("pointAwardCreate").sqlType(TransacOperation.INSERT).paramMap(inMap).build();
		sqlMapperList.add(sqlMapper);
		
		SqlUtil.getInstance().transactionAll(sqlMapperList);
	}
	
	
	@Test
	public void testGetSumRefundByOrderNo() throws ExceptionAbstract {
		SqlUtil.getInstance().init();
		Map<String,Object> map = New.map();
		map.put("salesTransNo", "2015917101008");
		System.out.println(SqlUtil.getInstance().selectOneString("getSumRefundByOrderNo", map));
	}
	
	@Test
	public void testGetSumPaymentByOrderNo() throws ExceptionAbstract {
		SqlUtil.getInstance().init();
		Map<String,Object> map = New.map();
		map.put("salesTransNo", "2015917101008");
		System.out.println(SqlUtil.getInstance().selectOneString("getSumPaymentByOrderNo", map));
	}
}
