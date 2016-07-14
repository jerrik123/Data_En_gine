package com.mangocity.de.mbr.crm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.AssertUtils;
import com.mangocity.de.mbr.util.mongo.Criteria;
import com.mangocity.de.mbr.util.mongo.MongoDBUtil;
import com.mangocity.de.mbr.util.mongo.Operation;
import com.mangocity.de.mbr.util.mongo.Order;
import com.mangocity.de.mbr.util.mongo.Restrictions;

/**
 * 组织结构
 * @author longshu.chen
 *
 */
public class OrganizationStructure {
	
	private static final Logger log = Logger.getLogger(OrganizationStructure.class);
	
	/**
	 * 新增组织结构
	 * @param pb
	 * @throws ExceptionAbstract
	 */
	public String insertStructure(EngineBean pb) throws Exception{
		log.info("OrganizationStructure insertStructure begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		//format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
		pb.setHead("createTime", format.parse(format.format(new Date())));
		return MongoDBUtil.getInstance().insertOne("organizationstructure", headMap);
	}
	
	/**
	 * 通过id删除组织结构
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Long deleteStructureById(EngineBean pb) throws ExceptionAbstract{
		log.info("OrganizationStructure deleteStructureById begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("parentId",  headMap.get("id").toString());
		MongoDBUtil.getInstance().deleteMany("organizationstructure", map);
		return MongoDBUtil.getInstance().deleteById("organizationstructure", headMap.get("id").toString());
	}
	/**
	 * 删除组织结构
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Long deleteStructure(EngineBean pb) throws ExceptionAbstract{
		log.info("OrganizationStructure deleteStructure begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		return MongoDBUtil.getInstance().deleteMany("organizationstructure", headMap);
	}
	/**
	 * 更新组织结构
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Long updateStructure(EngineBean pb) throws ExceptionAbstract{
		log.info("OrganizationStructure updateStructure begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		String id=(String) headMap.get("id");
		Map<String, Object> param=headMap;
		param.remove("id");
		return MongoDBUtil.getInstance().updateById("organizationstructure", id, param);
	}
	/**
	 * 通过id查询组织结构
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public String selectStructureById(EngineBean pb)throws ExceptionAbstract{
		log.info("OrganizationStructure selectStructureById begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		return MongoDBUtil.getInstance().selectById("organizationstructure", headMap.get("id").toString());
	}
	/**
	 * 查询组织结构
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public String selectStructure(EngineBean pb)throws ExceptionAbstract{
		log.info("OrganizationStructure selectStructure begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		Criteria criteria=new Criteria("organizationstructure",Operation.and);
		criteria.addOrder(Order.desc("type"));
		Map<String, Object> map=pb.getHeadMap();
		Set<Entry<String, Object>> set=map.entrySet();
		for (Entry<String, Object> entry : set) {
			criteria.add(Restrictions.eq(entry.getKey(),entry.getValue()));
		}
		//criteria.add(Restrictions.eq("parentId", headMap.get("parentId").toString()));
		//criteria.add(restriction);
		return MongoDBUtil.getInstance().select(criteria);
	}
}
