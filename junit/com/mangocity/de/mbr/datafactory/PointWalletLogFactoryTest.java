package com.mangocity.de.mbr.datafactory;

import java.util.Date;

import org.junit.Test;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class PointWalletLogFactoryTest {
	@Test
	public void testinsertPointWalletLog() throws ExceptionAbstract {

		SqlUtil.getInstance().init();
		EngineBean eb=new EngineBean();
		eb.setHead("id", 591084);
		eb.setHead("mbrId", "59108443");
		eb.setHead("transNo", "20160421105400005");
		eb.setHead("orderCode", "abc123");
		eb.setHead("productName", "测试产品");
		eb.setHead("pointValue", 10);
		eb.setHead("transTime", new Date());
		eb.setHead("transType", "P");
		eb.setHead("adjustTime", new Date());
		eb.setHead("remark", "");
		System.out.println(SqlUtil.getInstance().selectOneString("insertPointWalletLog", eb.getHeadMap()));
	}
}
