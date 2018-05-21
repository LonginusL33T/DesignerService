package cn.smartx.tools;

import cn.smartx.core.AAA.SmartxSecurityManager;
import cn.smartx.core.AAA.model.Menu;
import cn.smartx.core.AAA.model.Permission;
import cn.smartx.core.AAA.model.Role;
import cn.smartx.core.AAA.model.User;
import cn.smartx.core.AAA.service.PermissionService;
import cn.smartx.core.AAA.service.RoleService;
import cn.smartx.core.AAA.service.UserService;
import cn.smartx.core.common.SmartxConstants;
import cn.smartx.core.model.entity.XApp;

import java.util.Date;
import java.util.List;

public class DesignerInstaller extends AppInstaller {

	public DesignerInstaller(){
		super("designer");
	}
	
	@Override
	public void createAppMenu() {
		
		Menu 一级注册信息审核 = this.createMenuItem("注册信息审核", "1", "menu_registion", "", null, this.getAppCode());
        Menu 一级申请应聘信息汇总 = this.createMenuItem("申请应聘信息汇总", "1", "menu_apply", "", null, this.getAppCode());
        Menu 一级企业列表 = this.createMenuItem("企业列表", "1", "menu_companys", "", null, this.getAppCode());
        Menu 一级设计师列表 = this.createMenuItem("设计师列表", "1", "menu_designer", "", null, this.getAppCode());
        Menu 一级设计师工作站 = this.createMenuItem("设计师工作站", "1", "menu_designer_work", "", null, this.getAppCode());
        Menu 一级最新活动发布 = this.createMenuItem("最新活动发布", "1", "menu_activity", "", null, this.getAppCode());
        Menu 一级用户反馈 = this.createMenuItem("用户反馈", "1", "menu_feedback", "", null, this.getAppCode());
        Menu 一级数据统计 = this.createMenuItem("数据统计", "1", "menu_collection", "", null, this.getAppCode());
        Menu 一级超级管理员 = this.createMenuItem("超级管理员", "1", "menu_admin", "", null, this.getAppCode());

		
	}

	@Override
	public XApp createApp() {
		log.warn("start create xapp system data.....");
		XApp thisApp = loader.ceateNew(XApp.class);
		thisApp.setCode(this.getAppCode());
		thisApp.setInitPage("none");
		thisApp.setLastModifyDate(new Date());
		thisApp.setLastModifyUser("Designer Installer");
		thisApp.setName("Designer Application");
		loader.commit();
		return thisApp;
	}

	@Override
	public void createAppTemplate(XApp app) {
	    // mobile
		createTemplatePage("CellSearchDesigners", "搜索设计师", "designer/page/client/service/mobile/CellSearchDesigners.xml", "搜索设计师", app);
        createTemplatePage("CellTop100Designers", "Top100设计师", "designer/page/client/service/mobile/CellTop100Designers.xml", "Top100设计师", app);
        createTemplatePage("CellFeedBack", "用户反馈", "designer/page/client/service/mobile/CellFeedBack.xml", "用户反馈", app);
        createTemplatePage("CellCompanyRegister", "企业用户注册", "designer/page/client/service/mobile/CellCompanyRegister.xml", "企业用户注册", app);
        createTemplatePage("CellFwSendValidateCode", "忘记密码发送验证码", "designer/page/client/service/mobile/CellFwSendValidateCode.xml", "忘记密码发送验证码", app);
        createTemplatePage("CellLogin", "用户登录", "designer/page/client/service/mobile/CellLogin.xml", "用户登录", app);
        createTemplatePage("CellResetPassword", "重置密码", "designer/page/client/service/mobile/CellResetPassword.xml", "重置密码", app);
        createTemplatePage("CellTagsAdd", "添加标签", "designer/page/client/service/mobile/CellTagsAdd.xml", "添加标签", app);
        createTemplatePage("CellUserRegister", "普通用户注册", "designer/page/client/service/mobile/CellUserRegister.xml", "普通用户注册", app);

        //web
        createTemplatePage("WebGetCompanys", "获取企业列表", "designer/page/client/service/web/WebGetCompanys.xml", "获取企业列表", app);
        createTemplatePage("WebFwSendValidateCode", "忘记密码发送验证码", "designer/page/client/service/web/WebFwSendValidateCode.xml", "忘记密码发送验证码", app);
        createTemplatePage("WebGetUserInfo", "获取用户信息", "designer/page/client/service/web/WebGetUserInfo.xml", "获取用户信息", app);
        createTemplatePage("WebLogin", "用户登录", "designer/page/client/service/web/WebLogin.xml", "用户登录", app);
        createTemplatePage("WebResetPassword", "重置密码", "designer/page/client/service/web/WebResetPassword.xml", "重置密码", app);
        createTemplatePage("WebUploadUserInfo", "上传用户信息", "designer/page/client/service/web/WebUploadUserInfo.xml", "上传用户信息", app);
        createTemplatePage("WebVerifyRegistion", "注册信息审核列表", "designer/page/client/service/web/WebVerifyRegistion.xml", "注册信息审核列表", app);
        createTemplatePage("WebVerifyRegistionAccept", "审核通过", "designer/page/client/service/web/WebVerifyRegistionAccept.xml", "审核通过", app);
        createTemplatePage("WebVerifyRegistionReject", "审核不通过", "designer/page/client/service/web/WebVerifyRegistionReject.xml", "审核不通过", app);

    }

	@Override
	public void createAppTask(XApp app) {
    }

	@Override
	public void configAAABasicData() {
		log.warn("create operation list.....");
		TemplateAuthorizationHelper.initOperation(this.getAppCode());
		log.warn("create operation list.....done");

		log.warn("start parse page authorized data...");
		TemplateAuthorizationHelper.parsePageAuthorization(this.getAppCode());
		log.warn("start parse page authorized data...done");
	}

	@Override
	public void createRoleAndUser() {
        RoleService rs = SmartxSecurityManager.getInstance().getRoleService(this.getAppCode());
        UserService us = SmartxSecurityManager.getInstance().getUserService(this.getAppCode());
        PermissionService ps = SmartxSecurityManager.getInstance().getPermissionService(this.getAppCode());

        //创建超级管理员角色
        log.warn("create admin role.....");
        Role adminRole = new Role();
        adminRole.setAppcode(this.getAppCode());
        adminRole.setMemo("系统生成管理员");
        adminRole.setName("管理员");
        adminRole = rs.createRole(adminRole);
        
        List<Permission> allPermissions = ps.listAll();
        rs.addPermissions(adminRole, allPermissions);
        log.warn("create admin role.....done");
        
        log.warn("create administration user.....");
        User admin = new User();
        admin.setLoginname(SmartxConstants.SEC_ADMINISTRATOR);
        admin.setName(SmartxConstants.SEC_ADMINISTRATOR_NAME);
        admin.setPassword(SmartxConstants.SEC_ADMINISTRATOR_PWD);
        admin.setAppcode(this.getAppCode());
        admin = us.createUser(admin);
        us.addRole(admin, adminRole);
        log.warn("create administration user.....done");
        log.warn("create anonymous user.....");
        User usr = new User();
        usr.setLoginname(SmartxConstants.SEC_ANONYMOUS_USER);
        usr.setName(SmartxConstants.SEC_ANONYMOUS_USER_NAME);
        usr.setPassword(SmartxConstants.SEC_ANONYMOUS_USER_PWD);
        usr.setAppcode(this.getAppCode());
        usr = us.createUser(usr);
        log.warn("create anonymous user.....done");
	}

	@Override
	public void clearData() {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void createWorkflow() {
        // TODO Auto-generated method stub
        
    }

}
