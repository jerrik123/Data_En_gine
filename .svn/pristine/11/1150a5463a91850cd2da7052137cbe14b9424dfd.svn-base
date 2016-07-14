package com.mangocity.de.mbr.crm;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.AssertUtils;
import com.mangocity.de.mbr.util.mongo.MongoDBUtil;

/**
 * 权限类
 * @author longshu.chen
 *
 */
public class Authority {
private static final Logger log = Logger.getLogger(Authority.class);
	
	/**
	 * 新增权限
	 * @param pb
	 * @throws ExceptionAbstract
	 */
	public String insertAuthority(EngineBean pb) throws ExceptionAbstract{
		log.info("Authority insertAuthority begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		return MongoDBUtil.getInstance().insertOne("authority", headMap);
	}
	
	/**
	 * 通过id删除权限
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Long deleteAuthorityById(EngineBean pb) throws ExceptionAbstract{
		log.info("Authority deleteAuthorityById begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		return MongoDBUtil.getInstance().deleteById("authority", headMap.get("id").toString());
	}
	/**
	 * 删除权限
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Long deleteAuthority(EngineBean pb) throws ExceptionAbstract{
		log.info("Authority deleteAuthority begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		return MongoDBUtil.getInstance().deleteMany("authority", headMap);
	}
	/**
	 * 更新权限
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Long updateAuthority(EngineBean pb) throws ExceptionAbstract{
		log.info("Authority updateAuthority begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		String id=(String) headMap.get("id");
		Map<String, Object> param=headMap;
		param.remove("id");
		return MongoDBUtil.getInstance().updateById("authority", id, param);
	}
	/**
	 * 通过id查询权限
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public String selectAuthorityById(EngineBean pb)throws ExceptionAbstract{
		log.info("Authority selectAuthorityById begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		return MongoDBUtil.getInstance().selectById("authority", headMap.get("id").toString());
	}
	/**
	 * 查询权限
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public String selectAuthority(EngineBean pb)throws ExceptionAbstract{
		log.info("Authority selectAuthority begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		return MongoDBUtil.getInstance().select("authority", headMap);
	}
	
	/**
	 * 根据id集合查询权限
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public String selectAuthorityByIds(EngineBean pb)throws ExceptionAbstract{
		log.info("Authority selectAuthorityByIds begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		List<String> ids=(List<String>) pb.getHead("ids");
		return MongoDBUtil.getInstance().selectInIds("authority", ids);
	}
}
