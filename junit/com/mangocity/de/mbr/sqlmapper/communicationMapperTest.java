package com.mangocity.de.mbr.sqlmapper;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.CommonUtils;
import com.mangocity.de.mbr.util.SqlUtil;

public class communicationMapperTest {

	@Test
	public void testValidateSms() throws ExceptionAbstract, ParseException {
		/*Map inMap = new HashMap();
		inMap.put("mobileNo", "13554774675");
		inMap.put("signCode", "129864");
		inMap.put("smsStatus", "VALID");
		inMap.put("expireTime", "30");
		@SuppressWarnings("unchecked")
		Map map = (Map) SqlUtil.getInstance().selectOne("validateSmsByCondition",
				inMap);
		String str = String.valueOf(map.get("createTime"));
		CommonUtils.parseDate(str, "yyyy-MM-dd")
		System.out.println();*/
		
		if(CommonUtils.addMinutes(new Date(), -3).
				before(CommonUtils.parseDate("2015-10-10 17:07:43", 
						"yyyy-MM-dd HH:mm:ss"))){
			System.out.println(1);//有效
		}else{
			System.out.println(2);
		}
		
	}
	
	@Test
	public void testUpdateSmsStusByMobileNoAndCode() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mobileNo", "13538171516");
		inMap.put("signCode", "484330");
		inMap.put("status", "INVALID");
		inMap.put("updateBy", "YANGJIE");
		@SuppressWarnings("unchecked")
		int rows =  SqlUtil.getInstance().updateOne("updateSmsStusByMobileNoAndCode", inMap);
		System.out.println(rows);
	}
	
	/**
	 * '${signCode}',
		'${status}',
		'${type}',
		'${createBy}',
		'${createTime}',
		'${updateBy}',
		'${updateTime}')
	 * @throws ExceptionAbstract
	 */
	@Test
	public void testAddSmsRecord() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mobileNo", "13538171522");
		inMap.put("signCode", "484330");
		inMap.put("status", "VALID");
		inMap.put("updateTime", new Date());
		inMap.put("createTime", new Date());
		inMap.put("createBy", "lcy");
		inMap.put("updateBy", "lcy");
		inMap.put("type", "cly");
		@SuppressWarnings("unchecked")
		int rows =  SqlUtil.getInstance().insertOne("addSmsRecord", inMap);
		System.out.println(rows);
	}
	
	@Test
	public void testQuerySmsCounter() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mobileNo", "13554774675");
		inMap.put("day", CommonUtils.format(new Date(), "yyyy-MM-dd"));
		inMap.put("type", "S");
		@SuppressWarnings("unchecked")
		Long rows =  (Long) SqlUtil.getInstance().selectOneString("querySmsCount", inMap);
		System.out.println(rows);
	}
	
	@Test
	public void testAddSmsCounter() throws ExceptionAbstract {
		/**
		 * SmsCounter smsCounter = new SmsCounter();
		smsCounter.setSmsType("R");
		smsCounter.setCreateTime(new Date());
		smsCounter.setUpdateBy("");
		smsCounter.setUpdateTime(null);
		smsCounter.setCreateBy("");
		smsCounter.setMobile(mobileNo);
		smsCounter.setRemark("");
		smsCounter.setStatus("EFFECTIVE");		
		smsCounter.setCounterId(iSmsCounterService.getSmsCounterId());	
		 */
		Map inMap = new HashMap();
		inMap.put("smsType", "S");
		inMap.put("createTime", new Date());
		inMap.put("mobileNo", "13554774675");
		inMap.put("status", "EFFECTIVE");
		inMap.put("remark", "微信");
		@SuppressWarnings("unchecked")
		int rows =   SqlUtil.getInstance().insertOne("addSmsCount", inMap);
		System.out.println(rows);
	}
	
	@Test
	public void testInsertMobileWhiteList() throws ExceptionAbstract {
		/**
		 * 	Date currentDate = new Date();
			MobileWhiteList insertItem = new MobileWhiteList();
			insertItem.setMobileNo(mobileNo);
			insertItem.setCreateDate(currentDate);
			insertItem.setModifyDate(currentDate);
			insertItem.setValidBeginDate(currentDate);
			insertItem.setValidTime(Double.valueOf(0.00695));
			return mobileWhiteListDao.insertMobileWhiteList(insertItem);
		 */
		SqlUtil.getInstance().init();
		Map inMap = new HashMap();
		inMap.put("mobileNo", "13554774675");
		inMap.put("createDate", new Date());
		inMap.put("validTime", Double.valueOf(0.00695));
		inMap.put("validBeginDate",  new Date());
		inMap.put("modifyDate", new Date());
		@SuppressWarnings("unchecked")
		int rows =   SqlUtil.getInstance().insertOne("insertMobileWhiteList", inMap);
		System.out.println(rows);
	}

}
