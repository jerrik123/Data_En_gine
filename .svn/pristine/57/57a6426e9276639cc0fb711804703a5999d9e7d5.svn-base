package com.mangocity.de.mbr.datafactory.address;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.AssertUtils;
import com.mangocity.de.mbr.util.SqlUtil;

/**
 * @ClassName: DeliverAddressFactory
 * @Description: (会员常用地址工厂)
 * @author longshu.chen
 * @date 2016年3月3日 下午3:34:22
 *
 */
public class DeliverAddressFactory {
	
	private static final Logger log = Logger.getLogger(DeliverAddressFactory.class);
	/**
	 * 根据会员id分页查询
	 * @throws ExceptionAbstract 
	 */
	public List<Map<String,Object>> queryAddressWithPage(EngineBean pb) throws ExceptionAbstract{
		log.info("DeliverAddressFactory queryAddressWithPage begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		int pageNo=Integer.parseInt( (String) pb.getHead("pageNo"));
		int pageSize=Integer.parseInt( (String) pb.getHead("pageSize"));
		pb.setHead("startRow", (pageNo-1)*pageSize+1);
		pb.setHead("endRow", (pageNo)*pageSize);
		List<Map<String,Object>> addressMap = SqlUtil.getInstance().selectList("queryAddressWithPage", headMap);
		
		return addressMap;
	}

    /**
     * 根据会员id统计地址总数
     */
    public long queryAddressCount(EngineBean pb)throws ExceptionAbstract{
    	log.info("DeliverAddressFactory queryAddressCount begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		long num=  (long) SqlUtil.getInstance().selectOneString("queryAddressCount", headMap);
		return num;
    }

	/**
	 * 插入常用地址信息
	 * @param deliveryAddress
	 * @return
	 */
	public Integer createAddress(EngineBean pb)throws ExceptionAbstract{
		log.info("DeliverAddressFactory createAddress begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		pb.setHead("addressId", (long) SqlUtil.getInstance().selectOneString("getAddressId", null));
		pb.setHead("status", "VALID");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Integer result= (Integer) SqlUtil.getInstance().insertOne("createAddress", headMap);
		return result;
	}
	
	/**
	 * 更新常用地址
	 * @param deliveryAddress
	 * @return
	 */
	public Integer updateAddress(EngineBean pb)throws ExceptionAbstract{
		log.info("DeliverAddressFactory updateAddress begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Integer result= (Integer) SqlUtil.getInstance().updateOne("updateAddress", headMap);
		return result;
	}
	
	/**
	 * 根据常用地址id列表删除记录
	 * @return
	 */
    public Integer deleteAddressById(EngineBean pb)throws ExceptionAbstract{
    	log.info("DeliverAddressFactory deleteAddressById begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Integer result= (Integer) SqlUtil.getInstance().updateOne("deleteAddressById", headMap);
		return result;
	}
	/**
	 * 根据会员id设置默认使用地址
	 */
	public Integer setDefaulAddressById(EngineBean pb)throws ExceptionAbstract{
		log.info("DeliverAddressFactory setDefaulAddressById begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Integer result= (Integer) SqlUtil.getInstance().updateOne("setDefaulAddressById", headMap);
		return result;
	}
	/**
	 * 根据会员Id取消默认地址
	 */
	public Integer cancleDefaulAddressById(EngineBean pb)throws ExceptionAbstract{
		log.info("DeliverAddressFactory cancleDefaulAddressById begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Integer result= (Integer) SqlUtil.getInstance().updateOne("cancleDefaulAddressById", headMap);
		return result;
	}
	
	/**
	 * 根据地址id获取地址信息
	 * @param addressId
	 * @return
	 */
	public Map<String,Object> getAddressByAddressId(EngineBean pb)throws ExceptionAbstract{
		log.info("DeliverAddressFactory getAddressByAddressId begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Map<String,Object> address= SqlUtil.getInstance().selectOne("getAddressByAddressId", headMap);
		return address;
	}
}
