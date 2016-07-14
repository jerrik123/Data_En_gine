package com.mangocity.de.mbr.sqlmapper;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;

public class deliveryAddressMapperTest {

	@Test
	public void testQueryAddressWithPage() throws ExceptionAbstract {
		Map<String, Object> inMap = new HashMap<String, Object>();
		inMap.put("mbrId", "89986");
		inMap.put("startRow","0");
		inMap.put("endRow","10");
		SqlUtil.getInstance().init();
		List<Map<String,Object>> addressMap = SqlUtil.getInstance().selectList("queryAddressWithPage", inMap);
		System.out.println(addressMap);
	}

	@Test
	public void testQueryAddressCount() throws ExceptionAbstract {
		Map<String, Object> inMap = new HashMap<String, Object>();
		inMap.put("mbrId", "89986");
		SqlUtil.getInstance().init();
		long num=  (long) SqlUtil.getInstance().selectOneString("queryAddressCount", inMap);
		System.out.println(num);
	}

	@Test
	public void testCreateAddress() throws ExceptionAbstract{
		Map<String, Object> inMap = new HashMap<String, Object>();
		SqlUtil.getInstance().init();
		inMap.put("addressId", (long) SqlUtil.getInstance().selectOneString("getAddressId", null));
		inMap.put("mbrId","8739191");
		inMap.put("receiveName","asdfg");
		inMap.put("province","广东省");
		inMap.put("city","深圳市");
		inMap.put("district","南山区");
		inMap.put("detailAddr","芒果网大厦");
		inMap.put("postalCode","88888");
		inMap.put("status","VALID");
		inMap.put("defaultAddr","1");
		inMap.put("createBy","8739191");
		inMap.put("updateBy","8739191");
		inMap.put("mobileNo","123456");
		inMap.put("linkPhoneNo","654321");
		inMap.put("addrType","");
		Integer result= (Integer) SqlUtil.getInstance().insertOne("createAddress", inMap);
		System.out.println(result);
	}

	@Test
	public void testUpdateAddress() throws ExceptionAbstract{
		Map<String, Object> inMap = new HashMap<String, Object>();
		SqlUtil.getInstance().init();
		inMap.put("addressId","10819");
		//inMap.put("mbrId","8739191");
		inMap.put("receiveName","qwert");
		inMap.put("province","广东省");
		inMap.put("city","深圳市");
		inMap.put("district","南山区");
		inMap.put("detailAddr","芒果网大厦");
		inMap.put("postalCode","77777");
		//inMap.put("status","VALID");
		inMap.put("defaultAddr","1");
		//inMap.put("createBy","8739191");
		inMap.put("updateBy","8739191");
		inMap.put("mobileNo","123456");
		inMap.put("linkPhoneNo","654321");
		inMap.put("addrType","");
		Integer result= (Integer) SqlUtil.getInstance().updateOne("updateAddress", inMap);
		System.out.println(result);
	}

	@Test
	public void testDeleteAddressById() throws ExceptionAbstract{
		Map<String, Object> inMap = new HashMap<String, Object>();
		SqlUtil.getInstance().init();
		List<Long> ids=new ArrayList<Long>();
		ids.add(10819L);
		ids.add(61L);
		inMap.put("ids",ids);
		Integer result= (Integer) SqlUtil.getInstance().updateOne("deleteAddressById", inMap);
		System.out.println(result);
	}

	@Test
	public void testSetDefaulAddressById() throws ExceptionAbstract{
		Map<String, Object> inMap = new HashMap<String, Object>();
		SqlUtil.getInstance().init();
		inMap.put("mbrId","8739191");
		inMap.put("addressId","61");
		Integer result= (Integer) SqlUtil.getInstance().updateOne("setDefaulAddressById", inMap);
		System.out.println(result);
	}

	@Test
	public void testCancleDefaulAddressById() throws ExceptionAbstract{
		Map<String, Object> inMap = new HashMap<String, Object>();
		SqlUtil.getInstance().init();
		inMap.put("mbrId","8739191");
		Integer result= (Integer) SqlUtil.getInstance().updateOne("cancleDefaulAddressById", inMap);
		System.out.println(result);
	}

	@Test
	public void testGetAddressByAddressId() throws ExceptionAbstract{
		Map<String, Object> inMap = new HashMap<String, Object>();
		SqlUtil.getInstance().init();
		inMap.put("addressId","10819");
		Map<String,Object> address= SqlUtil.getInstance().selectOne("getAddressByAddressId", inMap);
		System.out.println(address);
	}

}
