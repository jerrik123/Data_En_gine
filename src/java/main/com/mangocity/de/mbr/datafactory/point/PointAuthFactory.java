package com.mangocity.de.mbr.datafactory.point;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.book.ErrorConstant;
import com.mangocity.ce.exception.BusinessException;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.AssertUtils;
import com.mangocity.ce.util.CommonUtils;
import com.mangocity.ce.util.New;
import com.mangocity.de.mbr.util.SqlUtil;

/**
 * 积分授权
 * @author longshu.chen
 *
 */
public class PointAuthFactory {
	private static final Logger log = Logger.getLogger(PointAuthFactory.class);
	/**
	 * 通过mbrid查询授权
	 * @param map
	 * @return
	 */
	public Map<String,Object> selectPointAuthorizeBymbrId(EngineBean pb)throws ExceptionAbstract{
		log.info("PointAuthFactory selectPointAuthorizeBymbrId begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Map<String,Object> pointAuth=SqlUtil.getInstance().selectOne("selectPointAuthorizeBymbrId", headMap);
		return pointAuth;
	}
	
	/**
	 * 插入积分授权
	 * @param map
	 * @return
	 */
	public Integer insertPointAuthorize(EngineBean pb)throws ExceptionAbstract{
		log.info("PointAuthFactory insertPointAuthorize begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		pb.setHead("id", (long) SqlUtil.getInstance().selectOneString("getPointAuthId", null));
		pb.setHead("stus", 1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			pb.setHead("authTime", sdf.parse(sdf.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Integer result= (Integer) SqlUtil.getInstance().insertOne("insertPointAuthorize", headMap);
		return result;
	}
	
	/**
	 * 通过授权Id查询有效授权信息
	 * @param map
	 * @return
	 */
	public Map<String,Object> queryPointAuthorizeByAuthorizeId(EngineBean pb)throws ExceptionAbstract{
		log.info("PointAuthFactory queryPointAuthorizeByAuthorizeId begin()...param: " + pb.getHeadMap());
		String authorizeId = String.valueOf(pb.getHead("authorizeId"));
		if(CommonUtils.isBlankIncludeNull(authorizeId)){
			throw new BusinessException(this, ErrorConstant.ERROR_PARAM_NULL_10000, "授权Id不能为空");
		}
		Map<String,Object> paramMap = New.map();
		Map<String,Object> resultMap = null;
		paramMap.put("authorizeId", authorizeId);
		paramMap.put("stus", 1);
		resultMap = SqlUtil.getInstance().selectOne("queryPointAuthorizeByCondition", paramMap);
		log.info("PointAuthFactory queryPointAuthorizeByAuthorizeId end()...result: " + resultMap);
		if(null == resultMap){
			throw new BusinessException(this, ErrorConstant.ERROR_NO_RESULT_DATA, "根据authorizeId查询不到授权信息");
		}
		return resultMap;
	}
}
