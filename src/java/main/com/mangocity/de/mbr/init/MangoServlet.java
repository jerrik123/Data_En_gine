package com.mangocity.de.mbr.init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.mangocity.ce.deploy.ConfigManage;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.de.mbr.util.SqlUtil;
/**
 * 
* @ClassName: MangoServlet 
* @Description: (这里用一句话描述这个类的作用) 
* @author 刘春元
* @date 2015年8月10日 下午3:27:26 
*
 */
@SuppressWarnings("serial")
public class MangoServlet extends HttpServlet {
	public void init() throws ServletException {
		ConfigManage.instance();
		try {
			SqlUtil.getInstance().init();
		} catch (ExceptionAbstract e) {
			e.printStackTrace();
		}
	}
}
