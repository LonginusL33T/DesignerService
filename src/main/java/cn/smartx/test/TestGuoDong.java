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

public class TestGuoDong {
	final static Logger log = LoggerFactory.getLogger(TestGuoDong.class);
	public static void TestImportFile() {
		DataBaseLoader appLoader = new DataBaseLoader();
		XApp app = DataCenterUtils.getAppFromDataCloud("guodong");
				
		RequestHandler handler = new RequestHandler();
		RequestParameter parameter = new RequestParameter();
		
		parameter.setAppCode(app.getCode());
		parameter.setPageCode("login");
		
		//获取登录页面
		ResponseResult result = null;
		result = handler.requestFeature(parameter,null);
		log.info(JsonUtils.ConvertToJson(result));
	}
}
