package cn.smartx.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.smartx.core.RequestHandler;
import cn.smartx.core.RequestParameter;
import cn.smartx.core.common.SmartxConstants;
import cn.smartx.core.datacenter.DataCenterUtils;
import cn.smartx.core.datacenter.DataCloud;
import cn.smartx.core.datacenter.TokenGenerator;
import cn.smartx.core.ds.database.DataBaseLoader;
import cn.smartx.core.model.entity.XApp;
import cn.smartx.core.model.entity.XPage;
import cn.smartx.core.ui.PageModel;
import cn.smartx.core.webapi.ResponseDataResult;
import cn.smartx.core.webapi.ResponseResult;
import cn.smartx.utils.JsonUtils;

public class TestSiti {
	final static Logger log = LoggerFactory.getLogger(TestSiti.class);

	public static void TestLogin() {
		DataBaseLoader appLoader = new DataBaseLoader();
		XApp app = DataCenterUtils.getAppFromDataCloud("siti");
				
		RequestHandler handler = new RequestHandler();
		RequestParameter parameter = new RequestParameter();
		
		parameter.setAppCode(app.getCode());
		parameter.setPageCode("login");
		
		//获取登录页面
		ResponseResult result = null;
		result = handler.requestFeature(parameter, null);
		log.info(JsonUtils.ConvertToJson(result));

		//登录
		RequestParameter parameter2 = new RequestParameter();
		parameter2.setPageSignature(result.getSignature());
		parameter2.addRequestParameter("Username", "pmtest");
		parameter2.addRequestParameter("Password", "111111");
		result = handler.submitHandler(parameter2);
		log.info(JsonUtils.ConvertToJson(result));

		//登录后的首页中的新闻列表
		RequestParameter parameter3 = new RequestParameter();
		parameter3.setPageSignature(result.getSignature());
		parameter3.setPagerGridId("newslist");
		parameter3.setPagerPageNum("0");
		result = handler.requestGridData(parameter3);
		log.info(JsonUtils.ConvertToJson(result));
	}

	public static void TestGetNewDetail() {
		DataBaseLoader appLoader = new DataBaseLoader();
		XApp app = DataCenterUtils.getAppFromDataCloud("siti");

		RequestHandler handler = new RequestHandler();
		RequestParameter parameter = new RequestParameter();

		parameter.setAppCode(app.getCode());
		parameter.setPageCode("login");

		// 获取登录页面
		ResponseResult result = null;
		result = handler.requestFeature(parameter, null);
		log.info(JsonUtils.ConvertToJson(result));

		// 登录
		RequestParameter parameter2 = new RequestParameter();
		parameter2.setPageSignature(result.getSignature());
		parameter2.addRequestParameter("Username", "pmtest");
		parameter2.addRequestParameter("Password", "111111");
		result = handler.submitHandler(parameter2);
		log.info(JsonUtils.ConvertToJson(result));

		// 登录后的首页中的新闻列表
		RequestParameter parameter3 = new RequestParameter();
		String signature = result.getSignature();
		parameter3.setPageSignature(signature);
		parameter3.setPagerGridId("newslist");
		parameter3.setPagerPageNum("0");
		result = handler.requestGridData(parameter3);
		log.info(JsonUtils.ConvertToJson(result));

		// 登录后的首页中的新闻列表中点击获取新闻内容
		RequestParameter parameter4 = new RequestParameter();
		parameter4.setPageSignature(signature);
		parameter4
				.addRequestParameter("href",
						"../mesboard.nsf/Bydate_homepage/4A4FE9898C25914948257C3D002F2F62?opendocument");
		result = handler.linkToHandler(parameter4);
		log.info(JsonUtils.ConvertToJson(result));
	}

	public static void TestNewsPager() {
		DataBaseLoader appLoader = new DataBaseLoader();
		XApp app = DataCenterUtils.getAppFromDataCloud("siti");

		RequestHandler handler = new RequestHandler();
		RequestParameter parameter = new RequestParameter();

		parameter.setAppCode(app.getCode());
		parameter.setPageCode("login");

		// 获取登录页面
		ResponseResult result = null;
		result = handler.requestFeature(parameter, null);
		log.info(JsonUtils.ConvertToJson(result));

		// 登录
		RequestParameter parameter2 = new RequestParameter();
		parameter2.setPageSignature(result.getSignature());
		parameter2.addRequestParameter("Username", "pmtest");
		parameter2.addRequestParameter("Password", "111111");
		result = handler.submitHandler(parameter2);
		log.info(JsonUtils.ConvertToJson(result));

		String signature = result.getSignature();

		// 登录后取新闻列表-page1
		RequestParameter parameter3 = new RequestParameter();
		parameter3.setPageSignature(signature);
		parameter3.setPagerGridId("newslist");
		parameter3.setPagerPageNum("1");

		result = handler.requestGridData(parameter3);
		log.info(JsonUtils.ConvertToJson(result));

		// 登录后取新闻列表-page2
		RequestParameter parameter4 = new RequestParameter();
		parameter4.setPageSignature(signature);
		parameter4.setPagerGridId("newslist");
		parameter4.setPagerPageNum("2");
		result = handler.requestGridData(parameter4);
		log.info(JsonUtils.ConvertToJson(result));
	}

	// 测试通过页面交互动态获取实际数据url
	public static void TestDynamicUrlFilling() {
		// login
		DataBaseLoader appLoader = new DataBaseLoader();
		XApp app = DataCenterUtils.getAppFromDataCloud("siti");

		RequestHandler handler = new RequestHandler();
		RequestParameter parameter = new RequestParameter();

		parameter.setAppCode(app.getCode());
		parameter.setPageCode("login");

		// 获取登录页面
		ResponseResult result = null;
		result = handler.requestFeature(parameter, null);
		log.info(JsonUtils.ConvertToJson(result));

		// 登录
		RequestParameter parameter2 = new RequestParameter();
		parameter2.setPageSignature(result.getSignature());
		parameter2.addRequestParameter("Username", "pmtest");
		parameter2.addRequestParameter("Password", "111111");
		result = handler.submitHandler(parameter2);
		log.info(JsonUtils.ConvertToJson(result));

		// 跳转到在办
		RequestParameter parameter3 = new RequestParameter();
		parameter3.setPageSignature(result.getSignature());
		parameter3.addRequestParameter("x_source", "zaiban");
		result = handler.submitHandler(parameter3);
		log.info(JsonUtils.ConvertToJson(result));

		String signature = result.getSignature();
		// 获取在办一级列表
		RequestParameter parameter4 = new RequestParameter();
		parameter4.setPageSignature(signature);
		parameter4.setPagerGridId("zaiban_list");
		parameter4.setPagerPageNum("1");
		result = handler.requestGridData(parameter4);
		log.info(JsonUtils.ConvertToJson(result));

		// 获取在办二级列表
		RequestParameter parameter5 = new RequestParameter();
		parameter5.setPageSignature(signature);
		parameter5
				.addRequestParameter(
						"href",
						"/xtoa/system/taskbox.nsf/_idpine4ukr89r1r0jp3717jnhat2k4_?OpenForm&Start=1&Count=30&Expand=1&Seq=1");
		result = handler.linkToHandler(parameter5);
		log.info(JsonUtils.ConvertToJson(result));
		// 获取在办一级列表
		RequestParameter parameter6 = new RequestParameter();
		parameter6.setPageSignature(result.getSignature());
		parameter6.setPagerGridId("zaiban_list");
		parameter6.setPagerPageNum("1");
		result = handler.requestGridData(parameter6);
		log.info(JsonUtils.ConvertToJson(result));

	}
}
