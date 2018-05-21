package cn.smartx.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.MBeanServer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Ostermiller.util.CircularByteBuffer;

import cn.smartx.core.RequestHandler;
import cn.smartx.core.RequestParameter;
import cn.smartx.core.common.SmartxConstants;
import cn.smartx.core.datacenter.DataCenterUtils;
import cn.smartx.core.datacenter.DataCloud;
import cn.smartx.core.datacenter.TokenGenerator;
import cn.smartx.core.ds.database.DataBaseLoader;
import cn.smartx.core.ds.webpage.HttpClientUtils;
import cn.smartx.core.model.TaskCache;
import cn.smartx.core.model.Utils;
import cn.smartx.core.model.entity.XApp;
import cn.smartx.core.model.entity.XPage;
import cn.smartx.core.service.workflow.WorkflowServiceProxy;
import cn.smartx.core.ui.PageModel;
import cn.smartx.core.webapi.ResponseDataResult;
import cn.smartx.core.webapi.ResponseResult;
import cn.smartx.utils.CommonUtils;
import cn.smartx.utils.HttpUtils;
import cn.smartx.utils.JsonUtils;

public class TestCore {
	final static Logger log = LoggerFactory.getLogger(TestCore.class);
	public static void main(String[] args) {
//		TestSmartx.TestAppList();
//		for(int i = 1; i < 500; i++){System.out.println("Loop:" + i);
//		TestHelperTools();
//		TestSiti.TestLogin();
//		TestSiti.TestGetNewDetail();
//		TestSiti.TestNewsPager();
//		TestSiti.TestDynamicUrlFilling();
////
//		TestSmartx.TestAppList();
//		TestSmartx.TestTest();
	    
//		TestSmartx.TestPath();
//		//TestGuoDong.TestImportFile();
//		
//		}
//		Utils.dumpCacheSummary();
//		DataCloud.getInstance().shutdown();
		//TestShiro.TestShiroCore();
//		touchServer("http://127.0.0.1:8080/smartx/");
//		DataBaseLoader loader = new DataBaseLoader();
//		long ncount = loader.getQueryTotalCount("select count(t.code) from XApp t where t.code='smartx'");
//		List<XApp> lst = loader.getByCondition(XApp.class, "code='smartx'");
//		System.out.println(ncount);
//		System.out.println(lst);
//		TestIsChineseChar();
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put(WorkflowServiceProxy.WFTASKID, "281");
	    HttpClientUtils.invokeWebapiJson("http://localhost:8080/smartx/webapi/adapterx/page/execute/smartx/wfOpenTask", params);
		System.out.println("Done.");
	}
	
	public static void TestIsChineseChar(){
		ArrayList<Integer> l = new ArrayList<Integer>(); 
		String test = "中文";
		System.out.println(test + ":" + CommonUtils.isContainChineseChar(test));
		test = "test中文";
		System.out.println(test + ":" + CommonUtils.isContainChineseChar(test));
		test = "test,12中文test";
		System.out.println(test + ":" + CommonUtils.isContainChineseChar(test));
		test = "，，";
		System.out.println(test + ":" + CommonUtils.isContainChineseChar(test));
		test = "1977 中文.txt";
		System.out.println(test + ":" + CommonUtils.isContainChineseChar(test));
		test = "1977 a_b_c t.txt";
		System.out.println(test + ":" + CommonUtils.isContainChineseChar(test));
		test = "test。txt";
		System.out.println(test + ":" + CommonUtils.isContainChineseChar(test));
	}
	
	public static void TestHelperTools(){
		//初始化缓存
		DataCloud.getInstance().getApplication("siti");
		log.warn(HelpTools.generateWidgetListFromWebpage("siti", "wp_unprocessed_business_view"));		
	}
	
	public static void touchServer(String webAppRoot){
		//触发应用初始化
		String url = webAppRoot + "webapi/adapterx/page/get/smartx/applist";
		try {
	        String result = "";
	        BufferedReader in = null;
	        try {
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            URLConnection connection = realUrl.openConnection();
	            // 设置通用的请求属性
	            connection.setRequestProperty("accept", "*/*");
	            connection.setRequestProperty("connection", "Keep-Alive");
	            connection.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            // 建立实际的连接
	            connection.connect();
	            // 获取所有响应头字段
	            Map<String, List<String>> map = connection.getHeaderFields();
	            // 遍历所有的响应头字段
	            for (String key : map.keySet()) {
	                System.out.println(key + "--->" + map.get(key));
	            }
	            // 定义 BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(new InputStreamReader(
	                    connection.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	            System.out.println("response body:" + result);
	        } catch (Exception e) {
	            System.out.println("发送GET请求出现异常！" + e);
	            e.printStackTrace();
	        }
	        // 使用finally块来关闭输入流
	        finally {
	            try {
	                if (in != null) {
	                    in.close();
	                }
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        return;
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
