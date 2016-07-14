package com.mangocity.de.mbr.datafactory.point;

import static com.mangocity.ce.util.CommonUtils.isEmpty;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.book.ErrorConstant;
import com.mangocity.ce.exception.BusinessException;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.CommonUtils;
import com.mangocity.ce.util.New;
import com.mangocity.de.mbr.util.SqlUtil;

/**
 * @ClassName: PointConvertBindFactory
 * @Description: 积分互换绑定服务
 * @author YangJie
 * @date 2016年4月1日 下午6:19:22
 */
public class PointConvertBindFactory {
	private static final Logger LOGGER = Logger.getLogger(PointConvertBindFactory.class);

	/**
	 * 根据万里通用户名查询绑定信息
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public List<Map<String,Object>> queryWltAccoutByBindUserName(EngineBean pb) throws ExceptionAbstract {
		LOGGER.info("PointConvertBindFactory queryWltAccoutByBindUserName begin()...appId: " + pb.getAppId() + " ,params: "
				+ pb.getHeadMap());
		List<Map<String,Object>> resultList = SqlUtil.getInstance().selectList("queryWltAccoutByCondition", pb.getHeadMap());
		LOGGER.info("resultList: " + resultList);
		if(isEmpty(resultList) || resultList.size() == 0){
			throw new BusinessException(this, ErrorConstant.PointExchange.ERROR_WLTACCOUT_IS_NOT_BINDED, "该万里通用户没有被绑定");
		}
		LOGGER.info("PointConvertBindFactory queryWltAccoutByBindUserName end()...");
		return resultList;
	}
	
	/**
	 * 根据mbrId查询绑定信息
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public List<Map<String,Object>> queryWltAccoutByMbrId(EngineBean pb) throws ExceptionAbstract {
		LOGGER.info("PointConvertBindFactory queryWltAccoutByMbrId begin()...appId: " + pb.getAppId() + " ,params: "
				+ pb.getHeadMap());
		List<Map<String,Object>> resultList = SqlUtil.getInstance().selectList("queryWltAccoutByCondition", pb.getHeadMap());
		LOGGER.info("resultList: " + resultList);
		if(isEmpty(resultList) || resultList.size() == 0){
			throw new BusinessException(this, ErrorConstant.PointExchange.ERROR_WLTACCOUT_IS_NOT_BINDED, "该会员没有绑定万里通用户");
		}
		LOGGER.info("PointConvertBindFactory queryWltAccoutByMbrId end()...");
		return resultList;
	}
	
	/**
	 * 创建万里通绑定记录
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public int pointConvertBindCreate(EngineBean pb) throws ExceptionAbstract {
		LOGGER.info("PointConvertBindFactory pointConvertBindCreate begin()...appId: " + pb.getAppId() + " ,params: "
				+ pb.getHeadMap());
		int row = SqlUtil.getInstance().insertOne("pointConvertBindCreate", pb.getHeadMap());
		LOGGER.info("row: " + row);
		if(row <= 0){
			throw new BusinessException(this, ErrorConstant.ERROR_INSERT_DATA_FAIL_10001, "创建万里通绑定信息失败");
		}
		LOGGER.info("PointConvertBindFactory pointConvertBindCreate end()...");
		return row;
	}
	
	
	/**
	 * 检查平安万里通的充值流水是否存在
	 * {
	 * 		"selCode":"wlt订单号"
	 * }
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Long isExistWltOrder(EngineBean pb) throws ExceptionAbstract {
		LOGGER.info("PointConvertBindFactory isExistWltOrder begin()...appId: " + pb.getAppId() + " ,params: "
				+ pb.getHeadMap());
		Long count = CommonUtils.objectToLong(SqlUtil.getInstance().selectOneString("isExistWltOrder", pb.getHeadMap()), -1L);
		LOGGER.info("isExistWltOrder count: " + count);
		if(count.intValue() <= 0){
			throw new BusinessException(this, ErrorConstant.PointExchange.ERROR_WLTORDER_IS_NOT_EXIST, "万里通的充值流水不存在");
		}
		LOGGER.info("PointConvertBindFactory isExistWltOrder end()...");
		return count;
	}
	
	/**
	 * 根据万里通订单号查询芒果订单流水情况
	 * {
	 * 		"selCode":"wlt订单号"
	 * }
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public List<Map<String,Object>> queryPointConvertOrderByWltOrder(EngineBean pb) throws ExceptionAbstract {
		LOGGER.info("PointConvertBindFactory queryPointConvertOrderByWltOrder begin()...appId: " + pb.getAppId() + " ,params: "
				+ pb.getHeadMap());
		List<Map<String,Object>> resultList = SqlUtil.getInstance().selectList("queryPointConvertByOrder", pb.getHeadMap());
		if(null == resultList || resultList.size() == 0){
			throw new BusinessException(this, ErrorConstant.ERROR_NO_RESULT_DATA, "根据万里通订单号查询不到订单流水");
		}
		LOGGER.info("PointConvertBindFactory queryPointConvertOrderByWltOrder end()...");
		return resultList;
	}
	
	/**
	 * 根据万里通交易号查询总积分
	 * @param pb
	 * @return
	 * @throws ExceptionAbstract
	 */
	public Map<String,Object> querySumMangoPointByOrder(EngineBean pb) throws ExceptionAbstract {
		LOGGER.info("PointConvertBindFactory querySumMangoPointByOrder begin()...appId: " + pb.getAppId() + " ,params: "
				+ pb.getHeadMap());
		pb.setHead("tranStus", "P");//查询交易完成流水
		Long totalPoints = CommonUtils.objectToLong(SqlUtil.getInstance().
				selectOneString("querySumMangoPointByOrder", pb.getHeadMap()), -1L);
		Map<String,Object> resultMap = New.map();
		resultMap.put("totalPoints", totalPoints);
		if(totalPoints == -1L){
			resultMap.put("totalPoints", 0L);
		}
		LOGGER.info("PointConvertBindFactory querySumMangoPointByOrder end()...totalPoints: " + resultMap);
		return resultMap;
		
	}
}
