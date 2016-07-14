package com.mangocity.de.mbr.sqlmapper.address;

import java.util.List;
import java.util.Map;

public interface deliveryAddressMapper {

	/**
	 * 根据会员id分页查询
	 */
	public List<Map<String,Object>> queryAddressWithPage(Map headMap);

    /**
     * 根据会员id统计地址总数
     */
    public long queryAddressCount(Map headMap);

	/**
	 * 插入常用地址信息
	 * @param deliveryAddress
	 * @return
	 */
	public Integer createAddress(Map headMap);
	
	/**
	 * 更新常用地址
	 * @param deliveryAddress
	 * @return
	 */
	public Integer updateAddress(Map headMap);
	
	/**
	 * 根据常用地址id列表删除记录
	 * @return
	 */
    public Integer deleteAddressById(Map headMap);
	
	/**
	 * 根据会员id设置默认使用地址
	 */
	public Integer setDefaulAddressById(Map headMap);
	
	/**
	 * 根据会员Id取消默认地址
	 */
	public Integer cancleDefaulAddressById();
	
	/**
	 * 根据地址id获取地址信息
	 * @param addressId
	 * @return
	 */
	public Map<String,Object> getAddressByAddressId(Map headMap);
}
