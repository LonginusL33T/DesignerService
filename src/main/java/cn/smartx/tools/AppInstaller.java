package cn.smartx.tools;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.smartx.core.AAA.SmartxMenuService;
import cn.smartx.core.AAA.SmartxSecurityManager;
import cn.smartx.core.AAA.model.Menu;
import cn.smartx.core.AAA.model.Operation;
import cn.smartx.core.AAA.model.Permission;
import cn.smartx.core.AAA.model.Resource;
import cn.smartx.core.AAA.service.PermissionService;
import cn.smartx.core.common.SmartxConstants;
import cn.smartx.core.ds.database.DataBaseLoader;
import cn.smartx.core.model.entity.WfWorkflow;
import cn.smartx.core.model.entity.XApp;
import cn.smartx.core.model.entity.XPage;
import cn.smartx.core.model.template.page.Authorizeoperation;

/**
 * @author pengrobin
 * 2014年7月7日
 */
public abstract class AppInstaller {
	private String appCode;
	protected DataBaseLoader loader = new DataBaseLoader();
	protected final static Logger log = LoggerFactory.getLogger(Installer.class);

	public AppInstaller(String appcode){
		this.appCode = appcode;
	}
	
	public String getAppCode(){
		return appCode;
	}
	
	public abstract void createAppMenu();
	public abstract XApp createApp();
	public abstract void createAppTemplate(XApp app);
	public abstract void createAppTask(XApp app);
	public abstract void configAAABasicData();
	public abstract void createRoleAndUser();
	public abstract void clearData();
	public abstract void createWorkflow();

	protected WfWorkflow createWorkflowDefine(String code, String name, String pagetype, String datapageurl, String templatefile){
	    return InstallHelper.createWorkflowDefine(this.appCode, code, name, pagetype, datapageurl, templatefile, this.loader);
	}
	
	protected XPage createTemplatePage(String code, String name, String templatefile, String title, XApp app){
		return InstallHelper.createTemplatePage(code, name, templatefile, title, app, this.loader);
	}

	protected Menu createMenuItem(String title, String level, String code, String url,
			Menu pm, String appcode) {
		Menu menu = new Menu();
		menu.setTitle(title);
		menu.setLevel(level);
		menu.setCode(code);
		menu.setUrl(url);
		menu.setAppcode(appcode);
		SmartxMenuService menuSvc = SmartxSecurityManager.getInstance().getMenuService(appCode);
		menu = menuSvc.createMenuItem(menu, pm);
		
		//插入菜单权限
		initMenuPermission(menu, pm);
		return menu;
	}
	
	private void initMenuPermission(Menu menu, Menu pm){
		Operation readOp = new Operation();
		readOp.setCode(Authorizeoperation.READ.value());
		
		PermissionService ps = SmartxSecurityManager.getInstance().getPermissionService(appCode);
		Resource res = new Resource();
		res.setCode(menu.getCode());
		if(pm != null){
		    Resource parentRes = ps.getResouce(pm.getCode());
		    res.setName(parentRes.getName() + ":" + menu.getTitle());
		} else {
		    res.setName(menu.getTitle());
		}
		res.setCategory(SmartxConstants.SEC_RESOURCE_CATEGORY_MENU);
		res.setAppcode(this.appCode);
		res = ps.createResouce(res);
		
		//菜单使用read权限控制
		Permission permission = new Permission(res, readOp);
		permission.setName(res.getName());
		permission.setAppcode(appCode);
		ps.createPermission(permission);
	}

}
