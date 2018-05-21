package cn.smartx.tools;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.smartx.core.AAA.SmartxSecurityManager;
import cn.smartx.core.AAA.model.Operation;
import cn.smartx.core.AAA.model.Permission;
import cn.smartx.core.AAA.model.Resource;
import cn.smartx.core.AAA.service.PermissionService;
import cn.smartx.core.common.NameResolver;
import cn.smartx.core.common.SmartxConstants;
import cn.smartx.core.ds.database.DataBaseLoader;
import cn.smartx.core.model.entity.AcctOperation;
import cn.smartx.core.model.entity.XApp;
import cn.smartx.core.model.entity.XPage;
import cn.smartx.core.model.template.page.Authorizeoperation;
import cn.smartx.core.model.template.page.Col;
import cn.smartx.core.model.template.page.Page;
import cn.smartx.core.model.template.page.Widget;

/**
 * @author pengrobin
 * 2014年6月23日
 */
public class TemplateAuthorizationHelper {
	static final Logger log = LoggerFactory.getLogger(TemplateAuthorizationHelper.class);

	public static void parsePageAuthorization(String appcode){
		DataBaseLoader loader = new DataBaseLoader();
		List<XApp> lst = loader.getByCondition(XApp.class, "code = '" + appcode + "'");
		if(lst == null || lst.size() == 0){
			log.warn("没有找到对应的app实例");
		}
		
		Operation readOp = new Operation();
		readOp.setCode(Authorizeoperation.READ.value());
		//获取操作定义
		PermissionService ps = SmartxSecurityManager.getInstance().getPermissionService(appcode);
		readOp = ps.createOperation(readOp);
		
		XApp thisApp = lst.get(0);
		String root = NameResolver.getTemplateRoot();
		List<XPage> pages = thisApp.getXPageArray();
		for(XPage pageEntity : pages){
			String path = root + pageEntity.getPageTemplate();
			File file = new File(path);
			try {
				if(!file.exists()){
					log.warn("模板文件不存在:{}", path);
					continue;
				}
				
				log.info("开始解析模板权限:{} >>>>>>>>>>>", path);
				JAXBContext jaxbCxt = JAXBContext.newInstance(Page.class);
				Unmarshaller parser = jaxbCxt.createUnmarshaller();
				Page page = (Page)parser.unmarshal(file);
				if(page.isAuthorize()){
					Resource resPage = new Resource();
					resPage.setCode(pageEntity.getCode());
					resPage.setName(pageEntity.getName());
					resPage.setAppcode(appcode);
					resPage.setCategory(SmartxConstants.SEC_RESOURCE_CATEGORY_PAGE);
					ps.createResouce(resPage);

					//默认每个页面都是read权限
					Permission permission = new Permission(resPage, readOp);
					permission.setName(resPage.getName());
					permission.setAppcode(appcode);
					ps.createPermission(permission);

					//continue;
				}
				
				
				//开始解析控件权限
				for(Widget wgt : page.getWidget()){
					if(wgt.isAuthorize()){
						Operation thisOp = ps.getOperation(wgt.getAuthop().value());
						Resource thisRes = new Resource();
						thisRes.setCode(pageEntity.getCode() + ":" + wgt.getId());
						thisRes.setName(pageEntity.getName() + ":" + wgt.getTitle());
						thisRes.setCategory(SmartxConstants.SEC_RESOURCE_CATEGORY_WIDGET);
						thisRes.setAppcode(appcode);
						ps.createResouce(thisRes);
						Permission permWidget = new Permission(thisRes, thisOp);
						permWidget.setAppcode(appcode);
						permWidget.setName(thisRes.getName());
						ps.createPermission(permWidget);
					}
					
					//如果是grid控件，解析col权限
					if(wgt.getMGrid() != null){
						for (Col c : wgt.getMGrid().getCol()) {
							if (c.isAuthorize()) {
								Operation thisOp = ps.getOperation(c.getAuthop().value());
								Resource thisRes = new Resource();
								StringBuffer permCode = new StringBuffer()
								.append(pageEntity.getCode()).append(":").append(wgt.getId())
								.append(":").append(c.getId());
								thisRes.setCode(permCode.toString());
								thisRes.setName(wgt.getTitle() + ":" + c.getTitle());
								thisRes.setCategory(SmartxConstants.SEC_RESOURCE_CATEGORY_GRID_COL);
								thisRes.setAppcode(appcode);
								ps.createResouce(thisRes);

								Permission permWidget = new Permission(thisRes, thisOp);
								permWidget.setAppcode(appcode);
								permWidget.setName(thisRes.getName());
								ps.createPermission(permWidget);
							}
						}
					}
				}
				log.info("解析模板权限结束:{} <<<<<<<<<<<<<", path);
				
			} catch (JAXBException e) {
				log.warn("页面模板解析错误", e);
			}
		}
	}
	
	public static void initOperation(String appcode){
		DataBaseLoader loader = new DataBaseLoader();
		//loader.deleteAll(loader.getAll(AcctOperation.class));
		loader.deleteAll(loader.getByCondition(AcctOperation.class, "appcode='" + appcode + "'"));
		
		PermissionService ps = SmartxSecurityManager.getInstance().getPermissionService(appcode);
		for(Authorizeoperation ao : Authorizeoperation.values()){
			Operation op = new Operation();
			op.setCode(ao.value());
			op.setName(ao.value());
			op.setAppcode(appcode);
			ps.createOperation(op);
		}
	}
}
