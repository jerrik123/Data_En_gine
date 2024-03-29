package com.mangocity.de.mbr.sqlmapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.MD5Algorithm;
import com.mangocity.ce.book.ConstantArgs;
import com.mangocity.de.mbr.util.SqlUtil;

public class mbrMapperTest {

	@Test
	public void testMbrCreate() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("mbrId", "10101010222");
		int i = SqlUtil.getInstance().insertOne("mbrCreate", inMap);
		System.out.println(i);
	}
	
	@Test
	public void testValidateUniqueRegisterByLoginName() throws ExceptionAbstract {
		Map inMap = new HashMap();
		inMap.put("loginName", "13555856788");
		inMap.put("loginSubtype", "M");
		Long i = (Long) SqlUtil.getInstance().selectOneString("validateUniqueRegisterByLoginName", inMap);
		System.out.println(i);
	}
	
	@Test
	public void testQueryMbrshipCategoryByCategoryCd() throws ExceptionAbstract {
		Map map = new HashMap();
		map.put("categoryCd", ConstantArgs.DEFULT_MBRSHIP);//默认会籍
		map = SqlUtil.getInstance().selectOne("queryMbrshipCategoryByCategoryCd", map);
		System.out.println(map);
	}
	
	@Test
	public void testResetPassword() throws ExceptionAbstract {
		Map map = new HashMap();
		map.put("resetLoginPwd",new MD5Algorithm().generateMD5Str("12345612"));
		map.put("loginName", "jie.yang@mangocity.com");
		map.put("oldPassword", new MD5Algorithm().generateMD5Str("081620"));
		map.put("loginSubType", "E");
		map.put("updateBy", "xxx");
		int row = SqlUtil.getInstance().updateOne("resetPassword", map);
		System.out.println(row);
	}
	
	/**
	 * login_name=#reg.loginName# AND
			login_pwd=#reg.loginPwd#
	 * @throws ExceptionAbstract
	 */
	@Test
	public void testValidateLogin() throws ExceptionAbstract {
		Map map = new HashMap();
		map.put("loginName", "jie.yang@mangocity.com");
		map.put("loginPwd", new MD5Algorithm().generateMD5Str("081620"));
		map.put("loginSubType", "E");
		map = SqlUtil.getInstance().selectOne("validateLogin", map);
		System.out.println(map);
	}
	
	@Test
	public void testQueryRegisterByLoginNameAndPassword() throws ExceptionAbstract {
		Map map = new HashMap();
		map.put("loginName", "13554774675");
		map.put("loginPwd", new MD5Algorithm().generateMD5Str("425493"));
		List<Map<String,Object>> dataList = SqlUtil.getInstance().selectList("queryRegisterByLoginNameAndPassword", map);
		System.out.println(dataList);
	}
	
	

}
