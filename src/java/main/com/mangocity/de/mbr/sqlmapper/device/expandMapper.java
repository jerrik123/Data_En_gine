package com.mangocity.de.mbr.sqlmapper.device;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface expandMapper {
	
	/**
	 * 添加用户设备
	 * @param headMap
	 * @return
	 */
	public int addUserDevice(Map headMap);
	
	/**
	 * 修改用户设备信息
	 * @param headMap
	 * @return
	 */
	public int updateUserDevice(Map headMap);
	
	/**
	 * 根据userId查询设备信息
	 * @param headMap
	 * @return
	 */
	public List<Map> queryUserDeviceByUserId(Map headMap);
}