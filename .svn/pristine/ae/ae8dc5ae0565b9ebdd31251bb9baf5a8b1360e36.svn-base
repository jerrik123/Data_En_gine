package com.mangocity.de.mbr.datafactory.person;

import java.util.Map;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.AssertUtils;
import com.mangocity.de.mbr.util.SqlUtil;
/**
 * 获取用户信息工厂
 * @author longshu.chen
 *
 */
public class PersonInfoFactory {
	private static final Logger log = Logger.getLogger(PersonInfoFactory.class);

	/**
	 * 获取用户信息
	 * 
	 * @param headMap
	 * @return
	 */
	public Map<String, Object> getPersonInfo(EngineBean pb)
			throws ExceptionAbstract {

		log.info("PersonInfoFactory getPersonInfo begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Map<String, Object> personInfo = SqlUtil.getInstance().selectOne(
				"getPersonInfo", headMap);
		return personInfo;
	}
}
