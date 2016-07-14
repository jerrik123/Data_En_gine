package com.mangocity.de.mbr.sqlmapper.point;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface pointMapper {
	/**
	 * 根据订单号获取扣减的积分总数
	 * @param headMap
	 * @return
	 */
	public Long getSumPaymentByOrderNo(Map headMap);
	
	/**
	 * 根据订单号获取已经退还的积分
	 * @param headMap
	 * @return
	 */
	public Long getSumRefundByOrderNo(Map headMap);
}