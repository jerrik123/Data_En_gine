package com.mangocity.de.mbr.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.mangocity.ce.util.CommonUtils;

/**
 * @ClassName: NullValueHandler.java
 * @Description: MyBatis空值处理器
 * @author: jie.yang
 * @email: jie.yang@mangocity.com
 * @date: 2016年5月6日 下午1:52:03
 */
public class NullValueHandler implements TypeHandler<String> {

	@Override
	public String getResult(ResultSet resultSet, String str) throws SQLException {
		String columnValue = resultSet.getString(str);
		if (CommonUtils.isBlank(columnValue))
			return "";
		return columnValue;
	}

	@Override
	public String getResult(ResultSet resultSet, int index) throws SQLException {
		String columnValue = resultSet.getString(index);
		if (CommonUtils.isBlank(columnValue))
			return "";
		return columnValue;
	}

	@Override
	public String getResult(CallableStatement cs, int index) throws SQLException {
		return null;
	}

	@Override
	public void setParameter(PreparedStatement pstmt, int index, String str, JdbcType type) throws SQLException {
	}

}
