package com.mangocity.de.mbr.datafactory.mbrship;

import java.util.Map;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

/**
 * 
 * @author longshu.chen
 *
 */
public class MbrShipCategoryFactory {
	private static final Logger log = Logger.getLogger(MbrShipCategoryFactory.class);
	
	/**
	 * 根据会籍类型编码查询
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Map<String,Object> mbrshipCategoryByCategoryCd(EngineBean pb) throws ExceptionAbstract {
		log.info("MbrShipCategoryFactory mbrshipCategoryByCategoryCd begin()...param: " + pb.getHeadMap());
		Map<String,Object> mbrshipCategory = SqlUtil.getInstance().selectOne("queryMbrshipCategoryByCategoryCd", pb.getHeadMap());
		return mbrshipCategory;
	}
}
