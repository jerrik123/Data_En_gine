package com.mangocity.de.mbr.crm;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.AssertUtils;
import com.mangocity.de.mbr.util.mongo.MongoDBUtil;
/**
 * 用户类
 * @author longshu.chen
 *
 */
public class User {
private static final Logger log = Logger.getLogger(User.class);
	
	/**
	 * 新增用户
	 * @param pb
	 * @throws ExceptionAbstract
	 */
	public String insertUser(EngineBean pb) throws ExceptionAbstract{
		log.info("User insertUser begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		return MongoDBUtil.getInstance().insertOne("organizationstructure", headMap);
	}
	
	/**
	 * 通过id删除用户
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Long deleteUserById(EngineBean pb) throws ExceptionAbstract{
		log.info("User deleteUserById begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		String id=(String) headMap.get("id");
		Map<String, Object> param=headMap;
		param.remove("id");
		param.put("stus", 0);
		return MongoDBUtil.getInstance().updateById("organizationstructure", id, param);
	}
	/**
	 * 删除用户
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Long deleteUser(EngineBean pb) throws ExceptionAbstract{
		log.info("User deleteUser begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("stus", 0);
		return MongoDBUtil.getInstance().updateMany("organizationstructure", headMap, map);
	}
	/**
	 * 更新用户
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Long updateUser(EngineBean pb) throws ExceptionAbstract{
		log.info("User updateUser begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		String id=(String) headMap.get("id");
		Map<String, Object> param=headMap;
		param.remove("id");
		return MongoDBUtil.getInstance().updateById("organizationstructure", id, param);
	}
	/**
	 * 通过id查询用户
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public String selectUserById(EngineBean pb)throws ExceptionAbstract{
		log.info("User selectUserById begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		return MongoDBUtil.getInstance().selectById("organizationstructure", headMap.get("id").toString());
	}
	/**
	 * 查询用户
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public String selectUser(EngineBean pb)throws ExceptionAbstract{
		log.info("User selectUser begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		return MongoDBUtil.getInstance().select("organizationstructure", headMap);
	}
}
