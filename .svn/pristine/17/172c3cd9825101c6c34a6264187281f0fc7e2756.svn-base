package com.mangocity.de.mbr.sqlmapper.cash;

import java.util.List;
import java.util.Map;

public interface cashMapper {
	public void cashAccountCreate(Map headMap);
	
	/**
	* @Title: generateCashAccountId 
	* @Description: (获得现金账户id,序列生成) 
	* @param
	* @return Long    返回类型
	 */
	public Long generateCashAccountId();
	
	
	/**
	* @Title: queryCashAccountByMbrId 
	* @Description: (根据会员id查询现金账户信息) 
	* @param
	* @return Map    返回类型
	 */
	public Map queryCashAccountByMbrId(Map headMap);
	
	/**
	* @Title: queryCashAccountInComeByCondition 
	* @Description: (按条件查询现金账户进账信息) 
	* @param (mbrId,日期)
	* @return List<Map<String,Object>>    返回类型
	 */
	public List<Map<String,Object>> queryCashAccountInComeByCondition(Map headMap);
	
	/**
	* @Title: queryCashAccountOutComeByCondition 
	* @Description: (按条件查询现金账户出账信息) 
	* @param (mbrId,日期)
	* @return List<Map<String,Object>>    返回类型
	 */
	public List<Map<String,Object>> queryCashAccountOutComeByCondition(Map headMap);
	
	/**
	* @Title: queryCashAccountOutComeByCondition 
	* @Description: (按条件查询现金账户出账申请记录 注意:其实就是待出账信息) 
	* @param 
	* @return List<Map<String,Object>>    返回类型
	 */
	public List<Map<String,Object>> queryCashAccountApplyRecordByCondition(Map headMap);
	
	/**
	* @Title: queryAllCashAccountTrans 
	* @Description: 查询指定会员现金账户明细
	* @param 
	* @return List<Map<String,Object>>    返回类型
	 */
	public List<Map<String,Object>> queryAllCashAccountTrans(Map headMap);
}