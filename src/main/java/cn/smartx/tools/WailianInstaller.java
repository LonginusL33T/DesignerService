package cn.smartx.tools;

import java.util.Date;
import java.util.List;

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

public class WailianInstaller extends AppInstaller {

	public WailianInstaller(){
		super("visa");
	}
	
	@Override
	public void createAppMenu() {
		//系统管理
		Menu 一级系统管理 = this.createMenuItem("系统管理", "1", "menu_xitongguanli", "", null, this.getAppCode());
		//APP管理
		Menu 二级APP管理 = this.createMenuItem("APP管理", "2", "menu_appguanli", "", 一级系统管理, this.getAppCode());
		Menu 三级APP启动页管理 = this.createMenuItem("APP启动页管理", "3", "startupPictureConfig", "/smartx/visaadminloader.html?pagecode=startupPictureConfig", 二级APP管理, this.getAppCode());
		//用户
		Menu 二级用户管理 = this.createMenuItem("用户管理", "2", "menu_yonghuguanli", "", 一级系统管理, this.getAppCode());
		Menu 三级注册用户管理 = this.createMenuItem("注册用户管理", "3", "visaUserList", "/smartx/visaadminloader.html?pagecode=visaUserList", 二级用户管理, this.getAppCode());
		//外联内部用户
		Menu 二级系统账号管理 = this.createMenuItem("系统账号管理", "2", "menu_quanxianguanli", "", 一级系统管理, this.getAppCode());
		Menu 三级员工账号管理 = this.createMenuItem("员工账号管理", "3", "userList", "/smartx/visaadminloader.html?pagecode=userList", 二级系统账号管理, this.getAppCode());
		Menu 三级角色管理 = this.createMenuItem("角色管理", "3", "roleList", "/smartx/visaadminloader.html?pagecode=roleList", 二级系统账号管理, this.getAppCode());
		//Menu 三级用户组管理 = this.createMenuItem("用户组管理", "3", "groupList", "/smartx/visaadminloader.html?pagecode=groupList", 二级系统账号管理, this.getAppCode());
		//个人信息
		Menu 二级个人信息管理 = this.createMenuItem("我的个人信息", "2", "menu_gerenxinxiguanli", "", 一级系统管理, this.getAppCode());
		Menu 三级密码管理 = this.createMenuItem("修改密码", "3", "adminChangePassword", "/smartx/visaadminloader.html?pagecode=adminChangePassword", 二级个人信息管理, this.getAppCode());
		
		//信息管理
		Menu 一级信息管理 = this.createMenuItem("信息管理", "1", "menu_xinxiguanli", "", null, this.getAppCode());
		//新闻
		Menu 二级新闻管理 = this.createMenuItem("新闻管理", "2", "menu_xinwenguanli", "", 一级信息管理, this.getAppCode());
		Menu 三级新闻列表 = this.createMenuItem("新闻列表", "3", "newsGrid", "/smartx/visaadminloader.html?pagecode=newsGrid", 二级新闻管理, this.getAppCode());
		Menu 三级新增新闻 = this.createMenuItem("新增新闻", "3", "createNews", "/smartx/visaadminloader.html?pagecode=createNews", 二级新闻管理, this.getAppCode());
		//活动
		Menu 二级活动管理 = this.createMenuItem("活动管理", "2", "menu_huodongguanli", "", 一级信息管理, this.getAppCode());
		Menu 三级活动列表 = this.createMenuItem("活动列表", "3", "activitiesList", "/smartx/visaadminloader.html?pagecode=activitiesList", 二级活动管理, this.getAppCode());
		Menu 三级新增活动 = this.createMenuItem("新增活动", "3", "createActivities", "/smartx/visaadminloader.html?pagecode=createActivities", 二级活动管理, this.getAppCode());
		Menu 三级活动报名列表 = this.createMenuItem("用户报名列表", "3", "activityEnrollList", "/smartx/visaadminloader.html?pagecode=activityEnrollList", 二级活动管理, this.getAppCode());
		//项目
		Menu 二级项目管理 = this.createMenuItem("项目管理", "2", "menu_xiangmuguanli", "", 一级信息管理, this.getAppCode());
		Menu 三级项目列表 = this.createMenuItem("项目列表", "3", "projectGrid", "/smartx/visaadminloader.html?pagecode=projectGrid", 二级项目管理, this.getAppCode());
		Menu 三级新增项目 = this.createMenuItem("新增项目", "3", "createProject", "/smartx/visaadminloader.html?pagecode=createProject", 二级项目管理, this.getAppCode());
		//成功案例
		Menu 二级成功案例管理 = this.createMenuItem("成功案例管理", "2", "menu_chenggonganliguanli", "", 一级信息管理, this.getAppCode());
		Menu 三级成功案例列表 = this.createMenuItem("成功案例列表", "3", "successfulcaseGrid", "/smartx/visaadminloader.html?pagecode=successfulcaseGrid", 二级成功案例管理, this.getAppCode());
		Menu 三级新增成功案例 = this.createMenuItem("新增成功案例", "3", "createSuccessfulcase", "/smartx/visaadminloader.html?pagecode=createSuccessfulcase", 二级成功案例管理, this.getAppCode());
		//知识库
		Menu 二级知识库管理 = this.createMenuItem("知识库管理", "2", "menu_zhishikuguanli", "", 一级信息管理, this.getAppCode());
		Menu 三级知识库列表 = this.createMenuItem("知识库列表", "3", "knowledgeGrid", "/smartx/visaadminloader.html?pagecode=knowledgeGrid", 二级知识库管理, this.getAppCode());
		Menu 三级新增知识库 = this.createMenuItem("新增知识库", "3", "createKnowledge", "/smartx/visaadminloader.html?pagecode=createKnowledge", 二级知识库管理, this.getAppCode());
		//专家库
		Menu 二级专家库管理 = this.createMenuItem("专家库管理", "2", "menu_zhuanjiakuguanli", "", 一级信息管理, this.getAppCode());
		Menu 三级专家库列表 = this.createMenuItem("专家库列表", "3", "expertGrid", "/smartx/visaadminloader.html?pagecode=expertGrid", 二级专家库管理, this.getAppCode());
		Menu 三级新增专家库 = this.createMenuItem("新增专家库", "3", "createExpert", "/smartx/visaadminloader.html?pagecode=createExpert", 二级专家库管理, this.getAppCode());
		
		//业务管理
		Menu 一级业务查询管理 = this.createMenuItem("业务查询管理", "1", "menu_yewuchaxun", "", null, this.getAppCode());
		//业务信息
		Menu 二级业务信息管理 = this.createMenuItem("业务信息管理", "2", "menu_yewuxinxiguanli", "", 一级业务查询管理, this.getAppCode());
		Menu 三级业务信息列表 = this.createMenuItem("业务信息列表", "3", "businessInfoGrid", "/smartx/visaadminloader.html?pagecode=businessInfoGrid", 二级业务信息管理, this.getAppCode());
		Menu 三级新增业务信息 = this.createMenuItem("新增业务信息", "3", "createBusinessInfo", "/smartx/visaadminloader.html?pagecode=createBusinessInfo", 二级业务信息管理, this.getAppCode());
		Menu 三级导入业务信息 = this.createMenuItem("导入业务信息", "3", "importBusinessInfo", "/smartx/visaadminloader.html?pagecode=importBusinessInfo", 二级业务信息管理, this.getAppCode());
		
		//增值信息管理
		Menu 一级增值信息管理 = this.createMenuItem("增值信息管理", "1", "menu_zengzhixinxi", "", null, this.getAppCode());
		//志愿者
		Menu 二级志愿者管理 = this.createMenuItem("志愿者管理", "2", "menu_zhiyuanzheguanli", "", 一级增值信息管理, this.getAppCode());
		Menu 三级志愿者列表 = this.createMenuItem("志愿者列表", "3", "volunteerGrid", "/smartx/visaadminloader.html?pagecode=volunteerGrid", 二级志愿者管理, this.getAppCode());
		Menu 三级新增志愿者 = this.createMenuItem("新增志愿者", "3", "createVolunteer", "/smartx/visaadminloader.html?pagecode=createVolunteer", 二级志愿者管理, this.getAppCode());
		Menu 三级志愿者评价列表 = this.createMenuItem("志愿者评价列表", "3", "volunteerAppraiseList", "/smartx/visaadminloader.html?pagecode=volunteerAppraiseList", 二级志愿者管理, this.getAppCode());
		//服务商
		Menu 二级服务商管理 = this.createMenuItem("服务商管理", "2", "menu_fuwushangguanli", "", 一级增值信息管理, this.getAppCode());
		Menu 三级服务商列表 = this.createMenuItem("服务商列表", "3", "serviceProviderGrid", "/smartx/visaadminloader.html?pagecode=serviceProviderGrid", 二级服务商管理, this.getAppCode());
		Menu 三级新增服务商 = this.createMenuItem("新增服务商", "3", "createServiceProvider", "/smartx/visaadminloader.html?pagecode=createServiceProvider", 二级服务商管理, this.getAppCode());
		Menu 三级服务商评价列表 = this.createMenuItem("服务商评价列表", "3", "serviceProviderAppraiseList", "/smartx/visaadminloader.html?pagecode=serviceProviderAppraiseList", 二级服务商管理, this.getAppCode());
		//外联驻地管理
		Menu 二级外联驻地管理 = this.createMenuItem("外联驻地管理", "2", "menu_wailianzhudiguanli", "", 一级增值信息管理, this.getAppCode());
		Menu 三级外联驻地列表 = this.createMenuItem("外联驻地列表", "3", "residentInfoGrid", "/smartx/visaadminloader.html?pagecode=residentInfoGrid", 二级外联驻地管理, this.getAppCode());
		Menu 三级新增外联驻地 = this.createMenuItem("新增外联驻地", "3", "createResidentInfo", "/smartx/visaadminloader.html?pagecode=createResidentInfo", 二级外联驻地管理, this.getAppCode());
		
		//基础数据管理
		Menu 一级基础数据管理 = this.createMenuItem("基础数据管理", "1", "menu_jichushujuguanli", "", null, this.getAppCode());
		//国家管理
		Menu 二级国家管理 = this.createMenuItem("国家管理", "2", "menu_guojiaguanli", "", 一级基础数据管理, this.getAppCode());
		Menu 三级国家列表 = this.createMenuItem("国家列表", "3", "countryList", "/smartx/visaadminloader.html?pagecode=countryList", 二级国家管理, this.getAppCode());
		Menu 三级新增国家 = this.createMenuItem("新增国家", "3", "createCountry", "/smartx/visaadminloader.html?pagecode=createCountry", 二级国家管理, this.getAppCode());
		//省份（州）管理
		Menu 二级省份管理 = this.createMenuItem("省份（州）管理", "2", "menu_shengfenguanli", "", 一级基础数据管理, this.getAppCode());
		Menu 三级省份列表 = this.createMenuItem("省份（州）列表", "3", "provinceList", "/smartx/visaadminloader.html?pagecode=provinceList", 二级省份管理, this.getAppCode());
		Menu 三级新增省份 = this.createMenuItem("新增省份（州）", "3", "createProvince", "/smartx/visaadminloader.html?pagecode=createProvince", 二级省份管理, this.getAppCode());
		//城市管理
		Menu 二级城市管理 = this.createMenuItem("城市管理", "2", "menu_chengshiguanli", "", 一级基础数据管理, this.getAppCode());
		Menu 三级城市列表 = this.createMenuItem("城市列表", "3", "cityList", "/smartx/visaadminloader.html?pagecode=cityList", 二级城市管理, this.getAppCode());
		Menu 三级新增城市 = this.createMenuItem("新增城市", "3", "createCity", "/smartx/visaadminloader.html?pagecode=createCity", 二级城市管理, this.getAppCode());
		
	}

	@Override
	public XApp createApp() {
		log.warn("start create xapp system data.....");
		XApp thisApp = loader.ceateNew(XApp.class);
		thisApp.setCode(this.getAppCode());
		thisApp.setInitPage("none");
		thisApp.setLastModifyDate(new Date());
		thisApp.setLastModifyUser("smartxInstaller");
		thisApp.setName("外联出国后台");

		loader.commit();
		return thisApp;
	}

	@Override
	public void createAppTemplate(XApp app) {
		// TODO Auto-generated method stub
		createTemplatePage("newsGrid","新闻列表","visa/page/admin/newsList.xml","新闻列表",app);
		createTemplatePage("createNews","新增新闻","visa/page/admin/createNews.xml","新增新闻",app);
		createTemplatePage("updateNews","修改新闻","visa/page/admin/updateNews.xml","修改新闻",app);
		createTemplatePage("createVolunteer","新增志愿者","visa/page/admin/createVolunteer.xml","新增志愿者",app);
		createTemplatePage("volunteerGrid","志愿者列表","visa/page/admin/volunteerList.xml","志愿者列表",app);
		createTemplatePage("updateVolunteer","更新志愿者","visa/page/admin/updateVolunteer.xml","更新志愿者",app);
		createTemplatePage("volunteerAppraiseList","志愿者评价列表","visa/page/admin/volunteerAppraiseList.xml","志愿者评价列表",app);
		createTemplatePage("serviceProviderGrid","服务商列表","visa/page/admin/ServiceProviderList.xml","服务商列表",app);
		createTemplatePage("createServiceProvider","新增服务商","visa/page/admin/createServiceProvider.xml","新增服务商",app);
		createTemplatePage("updateServiceProvider","更新服务商","visa/page/admin/updateServiceProvider.xml","更新服务商",app);
		createTemplatePage("serviceProviderAppraiseList","服务商评价列表","visa/page/admin/serviceProviderAppraiseList.xml","服务商评价列表",app);
		createTemplatePage("businessInfoGrid","业务信息列表","visa/page/admin/businessInfoList.xml","业务信息列表",app);
		createTemplatePage("createBusinessInfo","新增业务信息","visa/page/admin/createBusinessInfo.xml","新增业务信息",app);
		createTemplatePage("updateBusinessInfo","修改业务信息","visa/page/admin/updateBusinessInfo.xml","修改业务信息",app);
		createTemplatePage("createResidentInfo","新增外联驻地信息","visa/page/admin/createResidentInfo.xml","新增外联驻地信息",app);
		createTemplatePage("updateResidentInfo","修改外联驻地信息","visa/page/admin/updateResidentInfo.xml","修改外联驻地信息",app);
		createTemplatePage("residentInfoGrid","外联驻地信息列表","visa/page/admin/residentInfoList.xml","外联驻地信息列表",app);
		createTemplatePage("roleList","角色列表","visa/page/admin/roleList.xml","角色列表",app);
		createTemplatePage("createRole","新增角色","visa/page/admin/createRole.xml","新增角色",app);
		createTemplatePage("updateRole","更新角色","visa/page/admin/updateRole.xml","更新角色",app);
		createTemplatePage("groupList","用户组列表","visa/page/admin/groupList.xml","用户组列表",app);
		createTemplatePage("createGroup","新增用户组","visa/page/admin/createGroup.xml","新增用户组",app);
		createTemplatePage("updateGroup","更新用户组","visa/page/admin/updateGroup.xml","更新用户组",app);
		createTemplatePage("userList","用户列表","visa/page/admin/userList.xml","用户列表",app);
		createTemplatePage("createAdminUser","创建系统管理用户","visa/page/admin/createAdminUser.xml","创建系统管理用户",app);
		createTemplatePage("updateUser","更新用户","visa/page/admin/updateUser.xml","更新用户",app);
		createTemplatePage("adminChangePassword","管理员修改密码","visa/page/admin/adminChangePassword.xml","管理员修改密码",app);
		createTemplatePage("startupPictureConfig","启动图片配置","visa/page/admin/startupPictureConfig.xml","启动图片配置",app);
		createTemplatePage("startupPictureDownload","启动图片下载","visa/page/admin/startupPictureDownload.xml","启动图片下载",app);
		createTemplatePage("importBusinessInfo","导入业务信息","visa/page/admin/importBusinessInfo.xml","导入业务信息",app);
		createTemplatePage("activitiesList","活动列表","visa/page/admin/activitiesList.xml","活动列表",app);
		createTemplatePage("activityEnrollList","活动报名列表","visa/page/admin/activityEnrollList.xml","活动报名列表",app);
		createTemplatePage("createActivities","新增活动","visa/page/admin/createActivities.xml","新增活动",app);
		createTemplatePage("updateActivities","更新活动","visa/page/admin/updateActivities.xml","更新活动",app);
		createTemplatePage("projectGrid","项目列表","visa/page/admin/projectList.xml","项目列表",app);
		createTemplatePage("createProject","新增项目","visa/page/admin/createProject.xml","新增项目",app);
		createTemplatePage("updateProject","更新项目","visa/page/admin/updateProject.xml","更新项目",app);
		createTemplatePage("successfulcaseGrid","成功案例列表","visa/page/admin/successfulcaseList.xml","成功案例列表",app);
		createTemplatePage("createSuccessfulcase","新增成功案例","visa/page/admin/createSuccessfulcase.xml","新增成功案例",app);
		createTemplatePage("updateSuccessfulcase","更新成功案例","visa/page/admin/updateSuccessfulcase.xml","更新成功案例",app);
		createTemplatePage("knowledgeGrid","知识库列表","visa/page/admin/knowledgeList.xml","知识库列表",app);
		createTemplatePage("createKnowledge","新增知识库","visa/page/admin/createKnowledge.xml","新增知识库",app);
		createTemplatePage("updateKnowledge","更新知识库","visa/page/admin/updateKnowledge.xml","更新知识库",app);
		createTemplatePage("expertGrid","专家库列表","visa/page/admin/expertList.xml","专家库列表",app);
		createTemplatePage("createExpert","新增专家库","visa/page/admin/createExpert.xml","新增专家库",app);
		createTemplatePage("updateExpert","更新专家库","visa/page/admin/updateExpert.xml","更新专家库",app);
		createTemplatePage("adminLogin","登录","visa/page/admin/login.xml","登录",app);
		createTemplatePage("visaUserList","用户管理","visa/page/admin/visaUserList.xml","用户管理",app);
		createTemplatePage("updateVisaUser","用户详情","visa/page/admin/updateVisaUser.xml","用户详情",app);
		createTemplatePage("countryList","国家列表","visa/page/admin/countryList.xml","国家列表",app);
		createTemplatePage("provinceList","省份列表","visa/page/admin/provinceList.xml","省份列表",app);
		createTemplatePage("cityList","城市列表","visa/page/admin/cityList.xml","城市列表",app);
		createTemplatePage("push","推送","visa/page/admin/push.xml","推送",app);
		createTemplatePage("createCountry","添加国家","visa/page/admin/createCountry.xml","添加国家",app);
		createTemplatePage("updateCountry","更新国家","visa/page/admin/updateCountry.xml","更新国家",app);
		createTemplatePage("createProvince","添加省份","visa/page/admin/createProvince.xml","添加省份",app);
		createTemplatePage("updateProvince","更新省份","visa/page/admin/updateProvince.xml","更新省份",app);
		createTemplatePage("createCity","添加城市","visa/page/admin/createCity.xml","添加城市",app);
		createTemplatePage("updateCity","更新城市","visa/page/admin/updateCity.xml","更新城市",app);		

		createTemplatePage("serviceProviderList","服务商列表","visa/page/client/serviceProviderList.xml","服务商列表",app);
		createTemplatePage("serviceProvider","服务商详情","visa/page/client/serviceProvider.xml","服务商详情",app);
		createTemplatePage("volunteerList","志愿者列表","visa/page/client/volunteerList.xml","志愿者列表",app);
		createTemplatePage("volunteer","志愿者详情","visa/page/client/volunteer.xml","志愿者详情",app);
		createTemplatePage("businessInfoList","业务信息列表","visa/page/client/businessInfoList.xml","业务信息列表",app);
		createTemplatePage("businessInfo","业务信息详情","visa/page/client/businessInfo.xml","业务信息详情",app);
		createTemplatePage("residentInfoList","外联驻地列表","visa/page/client/residentInfoList.xml","外联驻地列表",app);
		createTemplatePage("residentInfo","外联驻地详情","visa/page/client/residentInfo.xml","外联驻地详情",app);
		createTemplatePage("pushDeviceInfo","推送设备信息","visa/page/client/pushDeviceInfo.xml","推送设备信息",app);
		createTemplatePage("login","登录","visa/page/client/login.xml","登录",app);
		createTemplatePage("register","注册","visa/page/client/register.xml","注册",app);
		createTemplatePage("newsList","新闻列表","visa/page/client/newsList.xml","新闻列表",app);
		createTemplatePage("volunteerPush","志愿者推送","visa/page/client/volunteerPush.xml","志愿者推送",app);
		createTemplatePage("news","新闻详情页","visa/page/client/news.xml","新闻详情页",app);
		createTemplatePage("successfulcaseList","成功案例列表","visa/page/client/successfulcaseList.xml","成功案例列表",app);
		createTemplatePage("successfulcase","成功案例","visa/page/client/successfulcase.xml","成功案例",app);
		createTemplatePage("activityList","活动列表","visa/page/client/activityList.xml","活动列表",app);
		createTemplatePage("activity","活动详情","visa/page/client/activity.xml","活动详情",app);
		createTemplatePage("projectList","项目列表","visa/page/client/projectList.xml","项目列表",app);
		createTemplatePage("project","项目详情","visa/page/client/project.xml","项目详情",app);
		createTemplatePage("knowledgeList","知识列表","visa/page/client/knowledgeList.xml","知识列表",app);
		createTemplatePage("knowledge","知识详情","visa/page/client/knowledge.xml","知识详情",app);
		createTemplatePage("expertCountry","专家按擅长国家分类","visa/page/client/expertCountry.xml","专家按擅长国家分类",app);
		createTemplatePage("expertList","专家列表","visa/page/client/expertList.xml","专家列表",app);
		createTemplatePage("expert","专家详情","visa/page/client/expert.xml","专家详情",app);
		createTemplatePage("mine","我的","visa/page/client/mine.xml","我的",app);
		createTemplatePage("relogin","验证登录","visa/page/client/relogin.xml","验证登录",app);
		createTemplatePage("minepro","我的业务","visa/page/client/minepro.xml","我的业务",app);
		createTemplatePage("setting","设置","visa/page/client/setting.xml","设置",app);
		createTemplatePage("subscriptionCenter","订阅中心","visa/page/client/subscriptionCenter.xml","订阅中心",app);
		createTemplatePage("subscriptionSetting","订阅设置","visa/page/client/subscriptionSetting.xml","订阅设置",app);
		createTemplatePage("changePassword","修改登录密码","visa/page/client/changePassword.xml","修改登录密码",app);
		createTemplatePage("changeSecondPassword","修改验证密码","visa/page/client/changeSecondPassword.xml","修改验证密码",app);
		createTemplatePage("weChatLogin","微网站登录","visa/page/client/weChatLogin.xml","微网站登录",app);
		createTemplatePage("weChatBizInfoList","微网站业务信息列表","visa/page/client/weChatBizInfoList.xml","微网站业务信息列表",app);
		createTemplatePage("myCollection","信息收藏","visa/page/client/myCollection.xml","信息收藏",app);
		createTemplatePage("fullTextSearch","全文搜索","visa/page/client/fullTextSearch.xml","全文搜索",app);
		createTemplatePage("youkuvideo","优酷测试","visa/page/client/Youkuvideo.xml","优酷测试",app);
		createTemplatePage("userInfo","个人信息","visa/page/client/userInfo.xml","个人信息",app);
		createTemplatePage("activityEnroll","活动报名","visa/page/client/activityEnroll.xml","活动报名",app);
		createTemplatePage("needToLogin","需要登录（没登陆点击需要登录的功能会跳到这个界面）","visa/page/client/needToLogin.xml","需要登录（没登陆点击需要登录的功能会跳到这个界面）",app);
	}

	@Override
	public void createAppTask(XApp app) {
		log.warn("no App Task installation configuration.");
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
