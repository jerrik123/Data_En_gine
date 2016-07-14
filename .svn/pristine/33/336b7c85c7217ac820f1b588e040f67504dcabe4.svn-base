package com.mangocity.de.mbr.sqlmapper.thirdparty;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface thirdpartyAccountMapper {
	/**
	  * @Title:  bindThirdpartyAccount
	  * @Description: (绑定第三方账户) 
	  * @param @param headMap  参数说明 
	  * @return int    返回类型
	 */
	public int bindThirdpartyAccount(Map headMap);
	
	/**
	  * @Title:  queryTsIntUserByOpenid
	  * @Description: (根据微信返回的openid查询t_mbr_ts_int_user信息) 
	  * @param @param headMap  参数说明 
	  * @return Map    返回类型
	 */
	public Map queryTsIntUserByOpenid(Map headMap);
	@Select("select  *  from  t_mbr_register t left join t_mbr_ts_int_user u on t.mbr_id=u.csn where t.stus=1 and u.login_code=#{opid} and rownum=1")
	public Map queryReisterByOpenid(Map headMap);
	public Map queryTsIntUserByCsn(Map headMap);
}