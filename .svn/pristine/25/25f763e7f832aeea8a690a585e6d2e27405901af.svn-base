package com.mangocity.de.mbr.sqlmapper;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.exception.IllegalParamException;
import com.mangocity.ce.util.AssertUtils;
import com.mangocity.de.mbr.util.SqlUtil;

public class registerMapperTest {

	@Test
	public void testRegisterCreate() throws ExceptionAbstract {
		/**
		 * #register.mbrId#,#register.loginNick#,#register.loginName#,#register.loginPwd#,#register.loginTyp#,#register.reqUrl#,
		 * #register.reqIp#,#register.remark#,SYSDATE,#register.createBy#,SYSDATE,#register.updateBy#,1,#register.loginSubtyp#)")
		 */
		Map inMap = new HashMap();
		inMap.put("mbrId", "1010101012");
		inMap.put("loginNick", "弑魂3");
		inMap.put("loginName", "jieyang@111.com");
		inMap.put("loginPwd", "123121");
		inMap.put("loginTyp", "1");
		inMap.put("loginSubtyp", "E");
		int i = SqlUtil.getInstance().insertOne("registerCreate", inMap);
		System.out.println(i);
	}
	
	@Test
	public void testLongToString(){
		Long a = 1231L;
		System.out.println(a.toString());
	}
	
	@Test
	public void testAssertUtils() throws IllegalParamException{
		String str = null;
		Long a = 1L;
		AssertUtils.assertNullArray(new Object[]{
			str,a	
		}, "参数不能有空");
	}
	
	@Test
	public void testLong(){
		Long a = null;
		System.out.println((Long)a);
	}

}
