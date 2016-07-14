package com.mangocity.de.mbr.datafactory.mbr;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.exception.BusinessException;
import com.mangocity.ce.exception.DatabaseException;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.exception.SystemException;
import com.mangocity.ce.util.CommonUtils;
import com.mangocity.ce.util.New;
import com.mangocity.ce.book.ErrorConstant;
import com.mangocity.de.mbr.util.SqlUtil;

/**
 * @ClassName: MbrManage
 * @Description: mbrmg管理后台
 * @author YangJie
 * @date 2015年11月18日 下午4:19:22
 */
public class MbrManageFactory {

	private static final Logger log = Logger.getLogger(MbrManageFactory.class);
	/**
	 * @Title: adminLogin
	 * @Description: 管理员登陆接口
	 * @param  pb
	 * @param @throws ExceptionAbstract 参数说明
	 * @return Map 返回类型
	 */
	public Map<String,Object> adminLogin(EngineBean pb) throws ExceptionAbstract{
		log.info("MbrManageFactory adminLogin()..." + "headMap: " + pb.getHeadMap());
		pb.setHead("stus", null);
		Map<String,Object> usrMap = null;
		String stus = null;
		List<Map<String,Object>> usrList = SqlUtil.getInstance().selectList("queryUserByLoginNameAndPassword", pb.getHeadMap());
		if(null == usrList || usrList.size() == 0){
			log.info("该管理员用户不存在: " + pb.getHeadMap());
			throw new BusinessException(this, ErrorConstant.User.ERROR_USER_IS_NOT_EXIST, "该管理员用户登录名或密码错误");
		}else if(usrList.size()>1){
			log.info("该管理员用户存在多条有效记录: " + pb.getHeadMap());
			throw new DatabaseException(this, ErrorConstant.User.ERROR_USER_EXIST_MULTI_RECORDS, "该管理员用户存在多条有效记录");
		}else if(usrList.size() == 1){
			usrMap =  usrList.get(0);
			stus = (String)usrMap.get("stus");
			if(CommonUtils.isBlank(stus)){
				throw new BusinessException(this, ErrorConstant.ERROR_PARAM_NULL_10000, "stus为空");
			}
			stus = stus.trim();//因为stus数据库类型为char类型
			usrMap.put("stus", stus);
			if("0".equals(stus)){
				throw new BusinessException(this, ErrorConstant.User.ERROR_USER_IS_LOGOUT, "该用户被注销");
			}
			return usrMap;
		}
		log.info("返回  Collections.EMPTY_MAP");
		return Collections.EMPTY_MAP;
	}
	public List<Map<String, Object>> queryModuleByUserId(EngineBean pb) throws ExceptionAbstract{
		log.info("MbrManageFactory queryModuleByUserId()..." + "headMap: " + pb.getHeadMap());
		List<Map<String,Object>> usrList = SqlUtil.getInstance().selectList("queryModuleByUserId", pb.getHeadMap());
		return usrList;
	}
}
