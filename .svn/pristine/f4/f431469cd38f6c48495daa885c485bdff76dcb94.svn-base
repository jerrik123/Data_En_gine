package com.mangocity.de.mbr.util;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.log4j.Logger;

import com.mangocity.ce.exception.DatabaseException;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.exception.SystemException;
import com.mangocity.ce.util.CommonUtils;
import com.mangocity.ce.book.ErrorConstant;
import com.mangocity.de.mbr.book.SqlMapper;
import com.mangocity.de.mbr.book.SqlMapper.TransacOperation;
import com.mangocity.de.mbr.book.SysConstant;

/**
 * sql工具类 Title:SqlUtil.java Copyright:Copyright(c)2013 Company:chinacreator
 *
 * @author 刘春元
 * @version 1.0 2013-5-8
 */
public class SqlUtil {
	private static final Logger logger = Logger.getLogger(SqlUtil.class
			.getName());
	private static SqlUtil uniqueInstance = null;
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSessionFactory sqlVoucherSessionFactory;
	private static String resource = "sqlconfig.xml";

	// TransactionFactory transactionFactory = new JdbcTransactionFactory();
	private SqlUtil() {
		logger.debug("init SqlManager .....");
	}

	public static SqlUtil getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new SqlUtil();
		}
		return uniqueInstance;
	}

	public void init() throws ExceptionAbstract {
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			Reader voucherReader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
			sqlVoucherSessionFactory = new SqlSessionFactoryBuilder().build(voucherReader,"development1");
		} catch (IOException e) {
			throw new SystemException(this, e);
		}
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	/*
	 * 查询一条
	 * 
	 * @param sqlid
	 * 
	 * @param inmap
	 * 
	 * @return作者:刘春元2013-5-13
	 */
	public Map<String, Object> selectOne(String sqlid, Map<String, Object> inmap)
			throws ExceptionAbstract {
		Map<String, Object> outmap = new HashMap<String, Object>();
		SqlSession sqlsession = null;
		if(sqlid.contains("voucher_")){
			sqlsession = sqlVoucherSessionFactory.openSession();
		}else{
			sqlsession = sqlSessionFactory.openSession();
		}
		try {
			outmap = sqlsession.selectOne(sqlid, inmap);
			/*if (null != outmap) {
				StringUtil.mapconvert(outmap);
			}*/
		} catch (Exception e) {
			throw new SystemException(this, e);
		} finally {
			sqlsession.close();
		}
		return outmap;
	}

	public Object selectOneString(String sqlid, Map<String, Object> inmap)
			throws ExceptionAbstract {
		Object str = "";
		SqlSession sqlsession = null;
		if(sqlid.contains("voucher_")){
			sqlsession = sqlVoucherSessionFactory.openSession();
		}else{
			sqlsession = sqlSessionFactory.openSession();
		}
		try {
			str = sqlsession.selectOne(sqlid, inmap);
			/*if (str instanceof Clob) {
				str = StringUtil.ClobToString((Clob) str);
			}
			if (str instanceof Blob) {// 附件
				str = StringUtil.BlobToStream((Blob) str, inmap);
			}*/
		} catch (Exception e) {
			throw new SystemException(this, e);
		} finally {
			sqlsession.close();
		}
		return str;
	}

	/*
	 * 查询所有
	 * 
	 * @param sqlid
	 * 
	 * @return作者:刘春元2013-5-13
	 */
	public List<Map<String, Object>> selectList(String sqlid,
			Map<String, Object> inmap) throws ExceptionAbstract {
		List<Map<String, Object>> outListMap = new ArrayList<Map<String, Object>>();
		SqlSession sqlsession = null;
		if(sqlid.contains("voucher_")){
			sqlsession = sqlVoucherSessionFactory.openSession();
		}else{
			sqlsession = sqlSessionFactory.openSession();
		}
		try {
			outListMap = sqlsession.selectList(sqlid, inmap);
			/*if (outListMap.size() > 0) {
				StringUtil.listconvert(outListMap);
			}*/
		} catch (Exception e) {
			throw new SystemException(this, e);
			// e.printStackTrace();
		} finally {
			sqlsession.close();
		}
		return outListMap;
	}

	/*
	 * 插入单条数据(此方式没有事务处理)
	 * 
	 * @param sqlid
	 * 
	 * @param inMap
	 * 
	 * @return
	 * 
	 * @throws Exception作者:刘春元2013-5-17
	 */
	public int insertOne(String sqlid, Map<String, Object> inMap)
			throws ExceptionAbstract {
		int flag = 0;
		Transaction newTransaction = null;
		SqlSession sqlsession = null;
		try {
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			sqlsession = sqlSessionFactory.openSession();
			newTransaction = transactionFactory.newTransaction(sqlsession
					.getConnection());
			flag = sqlsession.insert(sqlid, inMap);
		} catch (Exception e) {
			try {
				newTransaction.rollback();
				throw new SystemException(this, e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				newTransaction.close();
				sqlsession.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public int updateOne(String sqlid, Map<String, Object> inMap)
			throws ExceptionAbstract {
		int flag = 0;
		Transaction newTransaction = null;
		SqlSession sqlsession = null;
		try {
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			sqlsession = sqlSessionFactory.openSession();
			newTransaction = transactionFactory.newTransaction(sqlsession
					.getConnection());
			flag = sqlsession.update(sqlid, inMap);
		} catch (Exception e) {
			try {
				newTransaction.rollback();
				throw new SystemException(this, e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				newTransaction.close();
				sqlsession.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public int deleteOne(String sqlid, Map<String, Object> inMap)
			throws ExceptionAbstract {
		int flag = -1;
		Transaction newTransaction = null;
		SqlSession sqlsession = null;
		try {
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			sqlsession = sqlSessionFactory.openSession();
			newTransaction = transactionFactory.newTransaction(sqlsession
					.getConnection());
			flag = sqlsession.delete(sqlid, inMap);
		} catch (Exception e) {
			try {
				newTransaction.rollback();
				throw new SystemException(this, e);
			} catch (SQLException e1) {
				throw new SystemException(this, e);
			}
		} finally {
			try {
				newTransaction.close();
				sqlsession.close();
			} catch (SQLException e) {
				throw new SystemException(this, e);
			}
		}
		return flag;
	}

	/*
	 * db全事务处理用于新增，修改，删除遵循CURD原则性
	 * 
	 * @param objectMap(key：sqlId，sqlType，addMap)
	 * 
	 * @return作者:刘春元2013-5-19
	 */
	@SuppressWarnings("unchecked")
	public int transactionAll(List<SqlMapper> sqlMapperList) throws ExceptionAbstract {
		int row = 0;
		String sqlId = null;
		TransacOperation transacOperation = null;
		Map<String, Object> paramMap = null;
		Transaction newTransaction = null;
		SqlSession sqlsession = null;
		try {
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			sqlsession = sqlSessionFactory.openSession();
			newTransaction = transactionFactory.newTransaction(sqlsession.getConnection());
			int i = 0;
			for (SqlMapper sqlMapper : sqlMapperList) {
				sqlId = (String) sqlMapper.getSqlId();
				logger.info("第"+i+"次循环,sqlId: " + sqlId);
				transacOperation = sqlMapper.getTransacOperation();
				paramMap = sqlMapper.getParamMap();
				if (CommonUtils.isBlank(sqlId)
						|| CommonUtils.isBlank(transacOperation.getSqlType())
						|| CommonUtils.isEmpty(paramMap)) {
					throw new DatabaseException(this, ErrorConstant.ERROR_PARAM_NULL_10000);
				} else {
					if (SysConstant.C.equals(transacOperation.getSqlType())) {
						row = sqlsession.insert(sqlId, paramMap);
						logger.info("[sqlId: " + sqlId + " ,sqlType: "
								+ transacOperation.getSqlType() + " ,paramMap: " + paramMap
								+ "]-数据操作成功,影响的条数: " + row);
					} else if (SysConstant.U.equals(transacOperation.getSqlType())) {
						row = sqlsession.update(sqlId, paramMap);
					} else if (SysConstant.D.equals(transacOperation.getSqlType())) {
						row = sqlsession.delete(sqlId, paramMap);
					}
				}
				i++;
			}
			logger.info("transactionAll 操作成功,事务提交 sqlMapperList: " + sqlMapperList.toString());
		} catch (Exception e) {
			try {
				row = 0;
				logger.error(e.getMessage(), e);
				logger.info("transactionAll 操作失败,执行回滚操作...");
				newTransaction.rollback();
				logger.info( "[sqlId: " + sqlId
						+ " ,sqlType: " + transacOperation.getSqlType() + " ,paramMap: " + paramMap
						+ "]-数据操作失败,回滚数据");
				throw new DatabaseException(this, ErrorConstant.ERROR_TRANSACTION_ROLL_BACK_10006, "[sqlId: " + sqlId
						+ " ,sqlType: " + transacOperation.getSqlType()+"]执行失败,系统自动回滚数据");
			} catch (SQLException e1) {
				throw new SystemException(this, e);
			}
		} finally {
			try {
				newTransaction.close();
				sqlsession.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return 1;
	}

	public String selectSequences(String sequences) throws ExceptionAbstract {
		String str = "";
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try {
			// str = (String) this.selectOneString(sequences,null);
			str = sqlsession.selectOne("Sql_sequences", sequences);
		} catch (Exception e) {
			throw new SystemException(this, e);
		} finally {
			sqlsession.close();
		}
		return str;
	}
}
