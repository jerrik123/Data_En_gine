package com.mangocity.de.mbr.sqlmapper;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class thirdpartyAccountMapperTest {

	@Test
	public void testBindThirdpartyAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryTsIntUserByOpenid() throws ExceptionAbstract {
		Map headMap = new HashMap();
		headMap.put("openid", "C06A346E47D1D1D59FCF311D6069EC12");
		headMap.put("type", "11");
		Map<String,Object> body = SqlUtil.getInstance().selectOne("queryTsIntUserByOpenid", headMap);
		System.out.println(body);
	}
	
	//绑定芒果用户
	@Test //{"openid":"15014567981657","mbrId":"32150","nick":"墨风","type":"11"}
	public void testWechatBinding() throws ExceptionAbstract {
		Map headMap = new HashMap();
		headMap.put("openid", "C06A346E47D1D1D59FCF311D6069EC99");
		headMap.put("mbrId", "456179");
		headMap.put("nick", "杀阡陌");
		headMap.put("type", "11");
		Map<String,Object> body = SqlUtil.getInstance().selectOne("wechatBinding", headMap);
		System.out.println(body);
	}

}
