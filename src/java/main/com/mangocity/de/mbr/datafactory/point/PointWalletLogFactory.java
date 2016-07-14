package com.mangocity.de.mbr.datafactory.point;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.AssertUtils;
import com.mangocity.de.mbr.book.SqlMapper;
import com.mangocity.de.mbr.book.SqlMapper.TransacOperation;
import com.mangocity.de.mbr.util.SqlUtil;

/**
 * 积分兑换明细
 * @author longshu.chen
 *
 */
public class PointWalletLogFactory {
	private static final Logger log = Logger.getLogger(PointWalletLogFactory.class);
	/**
	 * 插入积分授权
	 * @param map
	 * @return
	 */
	public Integer insertPointWalletLog(EngineBean pb)throws ExceptionAbstract{
		log.info("PointWalletLogFactory insertPointWalletLog begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		pb.setHead("id", (long) SqlUtil.getInstance().selectOneString("getPointWalletLogId", null));
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Integer result= (Integer) SqlUtil.getInstance().insertOne("insertPointWalletLog", headMap);
		return result;
	};
	
	/**
	 * 插入积分明细事务，两条记录，积分记录和手续费
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Integer insertPointWalletLogPointAndFee(EngineBean pb)throws ExceptionAbstract{
		List<SqlMapper> sqlMapperList=new ArrayList<SqlMapper>();
		pb.setHead("id", (long) SqlUtil.getInstance().selectOneString("getPointWalletLogId", null));
		pb.setHead("pointValue", pb.getHead("point"));
		pb.setHead("pointType","交易积分");
		SqlMapper sm1=SqlMapper.getInstance().sqlId("insertPointWalletLog").sqlType(TransacOperation.INSERT).paramMap(pb.getHeadMap()).build();
		sqlMapperList.add(sm1);
		
		EngineBean eb=new EngineBean(pb);
		eb.setHead("id", (long) SqlUtil.getInstance().selectOneString("getPointWalletLogId", null));
		eb.setHead("pointValue", pb.getHead("pointfee"));
		eb.setHead("pointType","手续费");
		SqlMapper sm2=SqlMapper.getInstance().sqlId("insertPointWalletLog").sqlType(TransacOperation.INSERT).paramMap(eb.getHeadMap()).build();
		sqlMapperList.add(sm2);
		return SqlUtil.getInstance().transactionAll(sqlMapperList);
	}
	
	/**
	 * 根据订单号和交易类型查询（支付P，退还R）
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectPointWalletLogByOrdercodeAndType(EngineBean pb)throws ExceptionAbstract{
		log.info("PointWalletLogFactory selectPointWalletLogByOrdercodeAndType begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		List<Map<String, Object>> list =SqlUtil.getInstance().selectList("selectPointWalletLogByOrdercodeAndType", headMap);
		return list;
	};
	/**
	 * 通过订单号和交易类型查询交易积分总额
	 * @param map
	 * @return
	 */
	public Long getSumPointByOrderCode(EngineBean pb)throws ExceptionAbstract{
		log.info("PointWalletLogFactory getSumPointByOrderCode begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Long result=(Long) SqlUtil.getInstance().selectOneString("getSumPointByOrderCode", headMap);
		return result;
	}
	/**
	 * 通过原订单号和交易类型查询冲账积分总额
	 * @param map
	 * @return
	 */
	public Long getSumPointByRemark(EngineBean pb)throws ExceptionAbstract{
		log.info("PointWalletLogFactory getSumPointByRemark begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Long result=(Long) SqlUtil.getInstance().selectOneString("getSumPointByRemark", headMap);
		return result;
	}
	
	/**
	 * 更具订单号和交易类型查询订单是否存在
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> isExit(EngineBean pb)throws ExceptionAbstract{
		log.info("PointWalletLogFactory isExit begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		List<Map<String, Object>> result=SqlUtil.getInstance().selectList("isExit", headMap);
		return result;
	}
	
}
