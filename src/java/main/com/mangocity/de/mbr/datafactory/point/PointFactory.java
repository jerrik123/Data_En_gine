package com.mangocity.de.mbr.datafactory.point;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.book.ErrorBook;
import com.mangocity.ce.book.SysBook;
import com.mangocity.ce.deploy.ConfigManage;
import com.mangocity.ce.exception.BusinessException;
import com.mangocity.ce.exception.DatabaseException;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.exception.IllegalParamException;
import com.mangocity.ce.exception.SystemException;
import com.mangocity.ce.util.AssertUtils;
import com.mangocity.ce.util.CommonUtils;
import com.mangocity.ce.util.MbrPost;
import com.mangocity.ce.util.New;
import com.mangocity.ce.book.ErrorConstant;
import com.mangocity.de.mbr.book.SqlMapper;
import com.mangocity.de.mbr.book.SqlMapper.TransacOperation;
import com.mangocity.ce.book.ConstantArgs;
import com.mangocity.de.mbr.util.DateFormatUtil;
import com.mangocity.de.mbr.util.SqlUtil;
import com.mangocity.de.mbr.util.Tools;

/**
 * 注意:基本已将方法迁移到PointCommFactory,成了原子接口
 * @ClassName: PointFactory
 * @Description: (积分数据工厂)
 * @author YangJie
 * @date 2015年8月25日 下午6:19:22
 */
public class PointFactory {
	private static final Logger log = Logger.getLogger(PointFactory.class);

	
	/**
	 * @Title: queryPointTransaction
	 * @Description: 查询积分交易明细
	 * @param pb {"accountId":"20551682","endDate":"2015-10-01""beginDate":"2001-10-01","startNum":""}
	 * @param @throws ExceptionAbstract 参数说明
	 * @return Map 返回类型
	 */
	public List<Map<String,Object>> queryPointTransaction(EngineBean pb) throws ExceptionAbstract {
		log.info("PointFactory queryPointTransaction begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Long pageNo = CommonUtils.objectToLong((String)pb.getHead("pageNo"), -1L);
		Long pageSize = CommonUtils.objectToLong((String)pb.getHead("pageSize"), -1L);
		Long startNum = (pageNo - 1) * pageSize;
		Long endNum = startNum + pageSize;
		headMap.put("startNum", startNum);
		headMap.put("endNum", endNum);
		String controlShow = String.valueOf(pb.getHead("controlShow"));//用于是否区分显示积分账户(充值和奖励)和积分消费
		List<Map<String,Object>> dataList = SqlUtil.getInstance().selectList("queryPointTransactionByPagination", headMap);
		List<Map<String,Object>> pointAcctList = New.list();//积分账户List
		List<Map<String,Object>> pointExpireList = New.list();//积分消费list
		log.info("积分明细: "+"startNum: " + startNum + ",endNum: " + endNum + " details: " + dataList);
		for(Map<String,Object> dataMap : dataList){
			if(ConstantArgs.POINT_TRANS_TYPE_RECHARGE.equals(dataMap.get("transType"))){
				dataMap.put("adjustType", "积分充值");
				pointAcctList.add(dataMap);
			}else if(ConstantArgs.POINT_TRANS_TYPE_AWARD.equals(dataMap.get("transType"))){
				dataMap.put("adjustType", "奖励积分");
				pointAcctList.add(dataMap);
			}else if(ConstantArgs.POINT_TRANS_TYPE_ADJUSTMENT.equals(dataMap.get("transType"))){
				dataMap.put("adjustType", "积分消费");
				pointExpireList.add(dataMap);
			}else if(ConstantArgs.POINT_TRANS_TYPE_CONVERT.equals(dataMap.get("transType"))){
				dataMap.put("adjustType", "积分兑换");
				pointExpireList.add(dataMap);
			}else if(ConstantArgs.POINT_TRANS_TYPE_ADJUST.equals(dataMap.get("transType"))){
				dataMap.put("adjustType", "调整积分");
				pointExpireList.add(dataMap);
			}
		}
		if(CommonUtils.isBlankIncludeNull(controlShow)){
			return dataList;
		}else if("1".equals(controlShow)){
			return pointAcctList;
		}else if("2".equals(controlShow)){
			return pointExpireList;
		}else{
			return dataList;
		}
	}
	
	//根据mbrId或者会籍编码查询会员信息
	@SuppressWarnings("unused")
	private Map<String,Object> queryMbrByMbrIdOrOldMbrshipCd(Long mbrId,String oldMbrshipCd) throws ExceptionAbstract, BusinessException {
		Map<String,Object> mbrMap = null;
		Map<String,Object> paramMap = New.map();
		if(CommonUtils.isEmpty(mbrId) || mbrId == -1L){
			paramMap.put("mbrshipCd", oldMbrshipCd);
			mbrMap = SqlUtil.getInstance().selectOne("queryMbrByMbrshipCd", paramMap);//根据会籍查询会员信息
			if(null == mbrMap){
				log.info("mbr: " + mbrMap + "mbrshipCd: " + oldMbrshipCd);
				throw new BusinessException(this, ErrorConstant.Mbr.ERROR_MBR_NOT_EXIST_30001, "根据会籍查询不到该会员");
			}
			mbrId = CommonUtils.objectToLong(mbrMap.get("mbrId"), -1L);
			paramMap.put("mbrId",mbrId);
		}else{
			paramMap.put("mbrId",mbrId);
		}
		mbrMap = SqlUtil.getInstance().selectOne("queryMbrByMbrId", paramMap);
		if(null == mbrMap){
			log.info("mbr: " + mbrMap + "mbrId: " + paramMap.get("mbrId"));
			throw new BusinessException(this, ErrorConstant.Mbr.ERROR_MBR_NOT_EXIST_30001, "根据该mbrId查询不到会员");
		}
		return mbrMap;
	}
}
