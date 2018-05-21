package cn.smartx.tools.update;

import cn.smartx.core.AAA.model.Menu;
import cn.smartx.core.model.entity.XApp;

public class DrzPageUpdate extends PageUpdate{
	
	public DrzPageUpdate(){
		super("drz");
	}
	
	@Override
	public XApp getApp() {
		XApp app = loader.getEntity(63, XApp.class); 
		loader.getByCondition(XApp.class, "code = 'drz'");
		return app;
	}
	
	@Override
	public void createAppMenu() {
		Menu 一级基础信息管理 = this.createMenuItem("基础信息管理", "1", "menu_jichuxinxiuanli", "", null, this.getAppCode());
		Menu 基础信息 = this.createMenuItem("基础信息", "2", "menu_jichuxinxi", "", 一级基础信息管理, this.getAppCode());
		Menu 创建课程 = this.createMenuItem("创建课程", "3", "jichuxinxi_chuangjiankecheng", "/smartx/v2/main.html?pagecode=createClass", 基础信息, this.getAppCode());
		Menu 课程列表 = this.createMenuItem("课程列表", "3", "jichuxinxi_kechengliebiao", "/smartx/v2/main.html?pagecode=classGrid", 基础信息, this.getAppCode());
		
		Menu 我的信息 = this.createMenuItem("我的信息", "2", "menu_wodexinxi", "", 一级基础信息管理, this.getAppCode());
		Menu 课程信息 = this.createMenuItem("课程信息", "3", "jichuxinxi_kechengxinxi", "/smartx/v2/main.html?pagecode=ClassList", 我的信息, this.getAppCode());
		
		Menu 毕设信息 = this.createMenuItem("毕设信息", "2", "menu_bishexinxi", "", 一级基础信息管理, this.getAppCode());
		Menu 毕设管理 = this.createMenuItem("毕设管理", "3", "bishexinxi_bisheguanli", "/smartx/v2/main.html?pagecode=GraduaGrid", 毕设信息, this.getAppCode());
		
		Menu 教师毕设信息 = this.createMenuItem("教师毕设信息", "2", "menu_jiaoshibishexinxi", "", 一级基础信息管理, this.getAppCode());
		Menu 教师人员管理 = this.createMenuItem("人员管理", "3", "jiaoshibishexinxi_renyuanguanli", "/smartx/v2/main.html?pagecode=MgraStudentGrid", 教师毕设信息, this.getAppCode());
		Menu 教师公告信息 = this.createMenuItem("公告信息", "3", "jiaoshibishexinxi_gonggaoxinxi", "/smartx/v2/main.html?pagecode=MgraNoticeGrid", 教师毕设信息, this.getAppCode());
		Menu 教师文件资料 = this.createMenuItem("文件资料", "3", "jiaoshibishexinxi_wenjianziliao", "/smartx/v2/main.html?pagecode=MgraResourceGrid", 教师毕设信息, this.getAppCode());
		Menu 教师学生文档 = this.createMenuItem("学生文档", "3", "jiaoshibishexinxi_xueshengwendang", "/smartx/v2/main.html?pagecode=MgraDocumentGrid", 教师毕设信息, this.getAppCode());
		
		Menu 学生毕设信息 = this.createMenuItem("学生毕设信息", "2", "menu_xueshengbishexinxi", "", 一级基础信息管理, this.getAppCode());
		Menu 学生毕设基本信息 = this.createMenuItem("基本信息", "3", "xueshengbishexinxi_jibenxinxi", "/smartx/v2/main.html?pagecode=SgraMessage", 学生毕设信息, this.getAppCode());
		Menu 学生毕设导师信息 = this.createMenuItem("导师信息", "3", "xueshengbishexinxi_daoshixinxi", "/smartx/v2/main.html?pagecode=SgraMentorMsg", 学生毕设信息, this.getAppCode());
		Menu 学生毕设公告信息 = this.createMenuItem("公告信息", "3", "xueshengbishexinxi_gonggaoxinxi", "/smartx/v2/main.html?pagecode=SgraNoticeGrid", 学生毕设信息, this.getAppCode());
		Menu 学生毕设文件资料 = this.createMenuItem("文件资料", "3", "xueshengbishexinxi_wenjianziliao", "/smartx/v2/main.html?pagecode=SgraResourceGrid", 学生毕设信息, this.getAppCode());
		Menu 学生毕设文档提交 = this.createMenuItem("文档提交", "3", "xueshengbishexinxi_wendangtijiao", "/smartx/v2/main.html?pagecode=SgraDocumentGrid", 学生毕设信息, this.getAppCode());
		
		Menu 统计信息 = this.createMenuItem("学习过程统计", "2", "menu_tongjixinxi", "", 一级基础信息管理, this.getAppCode());
		Menu 课程签到率 = this.createMenuItem("课程签到率", "3", "tongjixinxi_kechengqiandaolv", "/smartx/v2/main.html?pagecode=ClassAttendanceRate", 统计信息, this.getAppCode());
		Menu 院系点到率 = this.createMenuItem("院系点到率", "3", "tongjixinxi_yuanxidiandaolv", "/smartx/v2/main.html?pagecode=CollegeAttendanceRate", 统计信息, this.getAppCode());
		Menu 用户登录情况 = this.createMenuItem("用户登录情况", "3", "tongjixinxi_yonghudengluqingkuang", "/smartx/v2/main.html?pagecode=UserLoginRate", 统计信息, this.getAppCode());
		
		Menu 一级系统管理 = this.createMenuItem("系统管理", "1", "menu_xitongguanli", "", null, this.getAppCode());
		Menu 个人信息 = this.createMenuItem("个人信息", "2", "menu_gerenxinxi", "", 一级系统管理, this.getAppCode());
		Menu 修改密码 = this.createMenuItem("修改密码", "3", "menu_xiugaimima", "/smartx/v2/main.html?pagecode=changePassword", 个人信息, this.getAppCode());
		
		Menu 管理信息 = this.createMenuItem("管理信息", "2", "menu_guanlixinxi", "", 一级系统管理, this.getAppCode());
		Menu 学校列表 = this.createMenuItem("学校列表", "3", "menu_xuexiaoliebiao", "/smartx/v2/main.html?pagecode=schoolGrid", 管理信息, this.getAppCode());
		Menu 导入学生 = this.createMenuItem("导入学生", "3", "menu_daoruxuesheng", "/smartx/v2/main.html?pagecode=studentImport", 管理信息, this.getAppCode());
		Menu 导入教师 = this.createMenuItem("导入教师", "3", "menu_daorujiaoshi", "/smartx/v2/main.html?pagecode=teachersImport", 管理信息, this.getAppCode());
		Menu 教师注册 = this.createMenuItem("教师注册", "3", "menu_jiaoshizhuce", "/smartx/v2/main.html?pagecode=backRegister", 管理信息, this.getAppCode());
		Menu 课程管理 = this.createMenuItem("课程管理", "3", "menu_kechengguanli", "/smartx/v2/main.html?pagecode=CourseManager", 管理信息, this.getAppCode());
		
		Menu 权限管理 = this.createMenuItem("权限管理", "2", "menu_quanxianguanli", "", 一级系统管理, this.getAppCode());
		Menu 角色管理 = this.createMenuItem("角色管理", "3", "menu_jueseguanli", "/smartx/v2/main.html?pagecode=roleGrid", 权限管理, this.getAppCode());
		Menu 用户管理 = this.createMenuItem("用户管理", "3", "menu_yonghuguanli", "/smartx/v2/main.html?pagecode=userGrid", 权限管理, this.getAppCode());
		
		Menu 模板管理 = this.createMenuItem("模板管理", "2", "menu_mubanguanli", "", 一级系统管理, this.getAppCode());
		Menu 模板列表 = this.createMenuItem("模板列表", "3", "menu_mubanliebiao", "/smartx/v2/main.html?pagecode=DocTemplateGrid", 模板管理, this.getAppCode());
		
		Menu 吐槽信息 = this.createMenuItem("吐槽信息", "2", "menu_tucaoxinxi", "", 一级系统管理, this.getAppCode());
		Menu 吐槽列表 = this.createMenuItem("吐槽列表", "3", "menu_tucaoliebiao", "/smartx/v2/main.html?pagecode=feedbackGrid", 吐槽信息, this.getAppCode());
		
		Menu 其他 = this.createMenuItem("其他", "2", "menu_other", "", 一级系统管理, this.getAppCode());
		Menu 用户入库情况 = this.createMenuItem("用户入库情况", "3", "menu_yonghurukuqingkuang", "/smartx/v2/main.html?pagecode=UserInfoDSLifecycle", 其他, this.getAppCode());
		
		Menu 核心监控 = this.createMenuItem("核心监控", "1", "menu_smartx_hexinjiankong", "", null, this.getAppCode());
		Menu 核心指标 = this.createMenuItem("核心指标", "2", "menu_smartx_hexinzhibiao", "", 核心监控, this.getAppCode());
		Menu 核心缓存数 = this.createMenuItem("核心缓存数", "3", "smartx_cache", "customize=smartx_cache", 核心指标, this.getAppCode());
		Menu Api响应时间 = this.createMenuItem("Api响应时间", "3", "smartx_api", "customize=smartx_api", 核心指标, this.getAppCode());


        // new web
        //系统管理
        Menu 一级系统管理2 = this.createMenuItem("系统监管", "1", "admin", "",
                null, this.getAppCode());
        Menu 二级首页 = this.createMenuItem("首页", "2", "adminIndex", "/home/admin",
                一级系统管理2, this.getAppCode());

        Menu 二级院系管理 = this.createMenuItem("院系管理", "2", "adminCollegeManager", "/home/admin/college",
                一级系统管理2, this.getAppCode());
        Menu 二级院系开通 = this.createMenuItem("院系开通", "2", "adminCollegeActivate", "/home/admin/collegeactivate",
                一级系统管理2, this.getAppCode());
        Menu 二级人员注册 = this.createMenuItem("账号注册", "2", "adminCollegeRegister", "/home/admin/register",
                一级系统管理2, this.getAppCode());
        Menu 二级全局账号导入 = this.createMenuItem("账号导入", "2", "adminAccountImport", "/home/admin/import",
                一级系统管理2, this.getAppCode());
        Menu 二级全局模板管理 = this.createMenuItem("模板管理", "2", "adminTemplateManage", "/home/admin/template",
                一级系统管理2, this.getAppCode());
        //院系管理
        Menu 一级院系管理 = this.createMenuItem("院系管理", "1", "managerCollege", "",
                null, this.getAppCode());

        Menu 二级管理员首页 = this.createMenuItem("首页", "2", "managerCollege", "/home/manager",
                一级院系管理, this.getAppCode());
        Menu 二级院系账号管理 = this.createMenuItem("账号管理", "2", "managerAccount", "/home/manager/account",
                一级院系管理, this.getAppCode());
        Menu 二级院系账号导入 = this.createMenuItem("账号导入", "2", "managerAccountImport", "/home/manager/import",
                一级院系管理, this.getAppCode());
        Menu 二级院系课程管理 = this.createMenuItem("课程管理", "2", "managerCourse", "/home/manager/course",
                一级院系管理, this.getAppCode());

        //数据产品
        Menu 一级数据产品 = this.createMenuItem("数据产品", "1", "managerData", "",
                null, this.getAppCode());

        Menu 二级院系签到分析 = this.createMenuItem("院系签到分析", "2", "managerDataAttendance", "/home/datachart/courseAttendanceRate",
                一级数据产品, this.getAppCode());
        Menu 二级院系课程活跃度 = this.createMenuItem("院系课程活跃度", "2", "managerDataClassLiveness", "/home/ranklist/activity/course",
                一级数据产品, this.getAppCode());
        Menu 二级院系学生活跃度 = this.createMenuItem("院系学生活跃度", "2", "managerDataStudentLiveness", "/home/ranklist/activity/college",
                一级数据产品, this.getAppCode());
        Menu 二级院系缺课预警名单 = this.createMenuItem("院系缺课预警名单", "2", "managerDataAbsentWarning", "/home/ranklist/studentAttendanceMonitor/all",
                一级数据产品, this.getAppCode());

        Menu 二级课程学生活跃度 = this.createMenuItem("课程学生活跃度", "2", "managerDataClassStudentLiveness", "/home/ranklist/activity/student",
                一级数据产品, this.getAppCode());
        Menu 二级课程学生成绩趋势分析 = this.createMenuItem("课程学生成绩趋势分析", "2", "managerDataClassGradeAnalysis;", "/home/datachart/achievementTrend",
                一级数据产品, this.getAppCode());
        Menu 二级课程缺课预警名单 = this.createMenuItem("课程缺课预警名单", "2", "managerDataAbsentWarning", "/home/ranklist/studentAttendanceMonitor/teacher",
                一级数据产品, this.getAppCode());

        //院系管理
        Menu 一级权限管理 = this.createMenuItem("权限管理", "1", "authManage", "",
                null, this.getAppCode());
        Menu 二级角色管理 = this.createMenuItem("角色管理", "2", "authRoleManage", "/home/admin/auth/role",
                一级权限管理, this.getAppCode());
        Menu 二级管理员管理 = this.createMenuItem("管理员管理", "2", "authAdminManage", "/home/admin/auth/users",
                一级权限管理, this.getAppCode());
        Menu 二级院系实习就业管理 = this.createMenuItem("实习就业管理", "2", "managerPlacement", "/home/manager/placement",
                一级院系管理, this.getAppCode());
        //课程管理
        Menu 一级课程管理 = this.createMenuItem("课程管理", "1", "classManage", "",
                null, this.getAppCode());
        Menu 二级教师首页 = this.createMenuItem("首页", "2", "teacherDashboard", "/home/teacher",
                一级课程管理, this.getAppCode());
        Menu 二级课程管理 = this.createMenuItem("课程列表", "2", "teacherClassManage", "/home/teacher/course/open",
                一级课程管理, this.getAppCode());
		
	}

	@Override
	public void createAppTemplate(XApp app) {
		// app core user
		createTemplatePage("UserMenuListService", "用户菜单列表服务", "drz/page/app/core/user/UserMenuListService.xml", "用户菜单列表服务", app);
		
		createTemplatePage("SvcSmartxCacheMonitor", "Smartx ehcache缓存监控服务", "drz/page/service/core/monitor/SvcSmartxCacheMonitor.xml", "Smartx ehcache缓存监控服务", app);
		createTemplatePage("SvcSmartxApiCostMonitor", "Smartx Api延时监控服务", "drz/page/service/core/monitor/SvcSmartxApiCostMonitor.xml", "Smartx Api延时监控服务", app);
		createTemplatePage("SvcSmartxTheNumberOfUsers", "Smartx 用户总人数和激活人数", "drz/page/service/core/monitor/SvcSmartxTheNumberOfUsers.xml", "Smartx 用户总人数和激活人数", app);
        createTemplatePage("SvcSmartxApiCostOverviewMonitor", "Smartx Api延时监控服务（概要）", "drz/page/service/core/monitor/SvcSmartxApiCostOverviewMonitor.xml", "Smartx Api延时监控服务（概要）", app);
        
        createTemplatePage("SvcSmartxUserLoginMonitor", "Smartx 用户Login统计服务", "drz/page/service/core/monitor/SvcSmartxUserLoginMonitor.xml", "Smartx 用户Login统计服务", app);
        createTemplatePage("SvcAccountStatistics", "drz测试-用户统计", "drz/page/service/drz/statistics/SvcAccountStatistics.xml", "drz测试-用户账户统计", app);
        createTemplatePage("SvcBizCountStatistics", "drz业务数量统计", "drz/page/service/drz/statistics/SvcBizCountStatistics.xml", "drz业务数量统计", app);
        createTemplatePage("SvcBizClassRank", "drz班级活跃度排名", "drz/page/service/drz/statistics/SvcBizClassRank.xml", "drz班级活跃度排名", app);
        createTemplatePage("SvcBizStudentRank", "drz学生活跃度排名", "drz/page/service/drz/statistics/SvcBizStudentRank.xml", "drz学生活跃度排名", app);
        createTemplatePage("SvcBizClassify", "drz业务按统计值归集", "drz/page/service/drz/statistics/SvcBizClassify.xml", "drz业务按统计值归集", app);
        createTemplatePage("SvcCourseInfo", "drz课程及活跃度信息", "drz/page/service/drz/statistics/SvcCourseInfo.xml", "drz课程及活跃度信息", app);
        createTemplatePage("SvcCourseAttendanceRatio", "drz课程签到率", "drz/page/service/drz/statistics/SvcCourseAttendanceRatio.xml", "drz课程签到率", app);
        createTemplatePage("SvcBizCountStatisticsOfClass", "drz业务数量统计（班级）", "drz/page/service/drz/statistics/SvcBizCountStatisticsOfClass.xml", "drz业务数量统计（班级）", app);
        createTemplatePage("LoggerFetch", "SmartX日志获取", "drz/page/service/drz/statistics/LoggerFetch.xml", "SmartX日志获取", app);
        createTemplatePage("PageHandleTimeFetcher", "SmartX API性能监控", "drz/page/service/drz/statistics/PageHandleTimeFetcher.xml", "SmartX API性能监控", app);
        createTemplatePage("AppBehaviorFetcher", "App行为统计", "drz/page/service/drz/statistics/AppBehaviorFetcher.xml", "App行为统计", app);
        
		//rate
		createTemplatePage("ClassAttendanceRate", "课程签到率", "drz/page/app/drz/org/diagram/ClassAttendanceRate.xml", "课程签到率", app);
		createTemplatePage("CollegeAttendanceRate", "院系点到率", "drz/page/app/drz/org/diagram/CollegeAttendanceRate.xml", "院系点到率", app);
		createTemplatePage("UserLoginRate", "用户登录情况", "drz/page/app/drz/org/diagram/UserLoginRate.xml", "用户登录情况", app);

		
		////////////////////////////////////////////////////////////service
        createTemplatePage("IMGetUserToken", "获取token", "drz/page/app/drz/org/service/IMGetUserToken.xml", "获取token", app);
        createTemplatePage("IMGetUserMessage", "获取用户信息", "drz/page/app/drz/org/service/IMGetUserMessage.xml", "获取用户信息", app);
        createTemplatePage("IMGetGroupMessage", "获取群组信息", "drz/page/app/drz/org/service/IMGetGroupMessage.xml", "获取群组信息", app);
        createTemplatePage("IMGetListMessage", "获取列表信息", "drz/page/app/drz/org/service/IMGetListMessage.xml", "获取列表信息", app);
        
        //Login
       createTemplatePage("RNLogin", "登陆（new）", "drz/page/app/drz/org/service/Login/RNLogin.xml", "登陆（new）", app);
       createTemplatePage("RNFirstLogin", "首次登陆（填写手机号、修改密码）", "drz/page/app/drz/org/service/Login/RNFirstLogin.xml", "首次登陆（填写手机号、修改密码）", app);

        
        //DynamicCircle
        createTemplatePage("DynamicCircleClazzMemberList", "动态圈学生名单", "drz/page/app/drz/org/service/DynamicCircle/DynamicCircleClazzMemberList.xml", "动态圈学生名单", app);
        createTemplatePage("DynamicCircleClazzList", "动态圈课程名单", "drz/page/app/drz/org/service/DynamicCircle/DynamicCircleClazzList.xml", "动态圈课程名单", app);
        createTemplatePage("TweestarCreate", "drz tweestar create", "drz/page/app/drz/org/service/DynamicCircle/TweestarCreate.xml", "drz tweestar create", app);
        createTemplatePage("TweestarFetch", "drz动态获取", "drz/page/app/drz/org/service/DynamicCircle/TweestarFetch.xml", "drz动态获取", app);
        createTemplatePage("TweestarGetItem", "drz获取单条动态", "drz/page/app/drz/org/service/DynamicCircle/TweestarGetItem.xml", "drz获取单条动态", app);
        createTemplatePage("TweestarRecallPage", "Drz Tweestar撤回", "drz/page/app/drz/org/service/DynamicCircle/TweestarRecallPage.xml", "Drz Tweestar撤回", app);

        //Clazz
        createTemplatePage("ClazzList", "课程列表", "drz/page/app/drz/org/service/Clazz/ClazzList.xml", "课程列表", app);
        createTemplatePage("ClazzMain", "获取单节课程信息", "drz/page/app/drz/org/service/Clazz/ClazzMain.xml", "获取单节课程信息", app);
        
        //Main
        createTemplatePage("TVGetCourse", "首页获取教师课程", "drz/page/app/drz/org/service/Main/TVGetCourse.xml", "首页获取教师课程", app);
        //PassWordAbout
        createTemplatePage("PasswordFound", "发送邮箱验证码", "drz/page/app/drz/org/service/PassWordAbout/PasswordFound.xml", "发送邮箱验证码", app);
        createTemplatePage("PasswordReset", "密码重置", "drz/page/app/drz/org/service/PassWordAbout/PasswordReset.xml", "密码重置", app);
        createTemplatePage("PasswordTokenValidate", "邮箱验证", "drz/page/app/drz/org/service/PassWordAbout/PasswordTokenValidate.xml", "邮箱验证", app);
        //Tools 
        createTemplatePage("GetContactsInfo", "获取通讯录数据", "drz/page/app/drz/org/service/Tools/GetContactsInfo.xml", "获取通讯录数据", app);
        
        //Set
        createTemplatePage("GetCollege", "获取学校下的学院信息", "drz/page/app/drz/org/service/GetCollege.xml", "获取学校下的学院信息", app);
        createTemplatePage("GetUserInfo", "获取单个用户信息", "drz/page/app/drz/org/service/GetUserInfo.xml", "获取单个用户信息", app);
        createTemplatePage("ModifyUserInfo", "修改单个用户信息", "drz/page/app/drz/org/service/ModifyUserInfo.xml", "修改单个用户信息", app);
        createTemplatePage("PasswordChange", "修改用户密码", "drz/page/app/drz/org/service/PasswordChange.xml", "修改用户密码", app);

        
        //QAService
        createTemplatePage("QAGetQuestionList", "获取问题列表", "drz/page/app/drz/org/service/QuestionAnswer/QAGetQuestionList.xml", "获取问题列表", app);
        createTemplatePage("QAGetAnswerList", "获取答案列表", "drz/page/app/drz/org/service/QuestionAnswer/QAGetAnswerList.xml", "获取答案列表", app);
        createTemplatePage("QACreateQuestion", "创建问题", "drz/page/app/drz/org/service/QuestionAnswer/QACreateQuestion.xml", "创建问题", app);
        createTemplatePage("QACreateAnswer", "创建回答", "drz/page/app/drz/org/service/QuestionAnswer/QACreateAnswer.xml", "创建回答", app);
        
        createTemplatePage("QASupportAnswer", "支持回答", "drz/page/app/drz/org/service/QuestionAnswer/QASupportAnswer.xml", "支持回答", app);
        createTemplatePage("QASupportQuestion", "支持问题", "drz/page/app/drz/org/service/QuestionAnswer/QASupportQuestion.xml", "支持问题", app);
        
        createTemplatePage("QAGetQuestionDetail", "问题详情", "drz/page/app/drz/org/service/QuestionAnswer/QAGetQuestionDetail.xml", "问题详情", app);
        createTemplatePage("QAGetAnswerDetail", "回答详情", "drz/page/app/drz/org/service/QuestionAnswer/QAGetAnswerDetail.xml", "回答详情", app);
		createTemplatePage("QABestAnswerChoose", "最佳回答选择", "drz/page/app/drz/org/service/QuestionAnswer/QABestAnswerChoose.xml", "最佳回答选择", app);
		createTemplatePage("QABestQuestionChoose", "最佳问题选择", "drz/page/app/drz/org/service/QuestionAnswer/QABestQuestionChoose.xml", "最佳问题选择", app);
		
		//AttendanceService
		createTemplatePage("AttendanceChangeFlagTV", "教师修改学生签到状态", "drz/page/app/drz/org/service/AttendanceChangeFlagTV.xml", "教师修改学生签到状态", app);
        createTemplatePage("AttendanceCheckSV", "学生签到", "drz/page/app/drz/org/service/AttendanceCheckSV.xml", "学生签到", app);
        createTemplatePage("AttendanceCloseTV", "教师签到关闭页面", "drz/page/app/drz/org/service/AttendanceCloseTV.xml", "教师签到关闭页面", app);
        createTemplatePage("AttendanceDetailListTV", "教师签到详情列表", "drz/page/app/drz/org/service/AttendanceDetailListTV.xml", "教师签到详情列表", app);
        createTemplatePage("AttendanceDetailSV", "学生签到详情", "drz/page/app/drz/org/service/AttendanceDetailSV.xml", "学生签到详情", app);
        createTemplatePage("AttendanceGetRandomNum", "获取随机数/二维码参数", "drz/page/app/drz/org/service/AttendanceGetRandomNum.xml", "获取随机数/二维码参数", app);
        createTemplatePage("AttendanceListTV", "教师签到列表", "drz/page/app/drz/org/service/AttendanceListTV.xml", "教师签到列表", app);
        createTemplatePage("AttendanceMainSV", "学生签到主页", "drz/page/app/drz/org/service/AttendanceMainSV.xml", "学生签到主页", app);
        
        createTemplatePage("AttendanceReleaseTV", "教师签到详情列表", "drz/page/app/drz/org/service/AttendanceReleaseTV.xml", "教师签到详情列表", app);
        createTemplatePage("AttendanceStudentDetailTV", "教师端学生签到详情列表", "drz/page/app/drz/org/service/AttendanceStudentDetailTV.xml", "教师端学生签到详情列表", app);
        createTemplatePage("AttendanceDelete", "签到删除", "drz/page/app/drz/org/service/AttendanceDelete.xml", "签到删除", app);
        
        //获取课程表数据
        createTemplatePage("GetCourseTableData", "获取课程表数据", "drz/page/app/drz/org/service/GetCourseTableData.xml", "获取课程表数据", app);
        //MasterPage
        createTemplatePage("MainMasterPage", "主导航", "drz/page/app/drz/org/masterpage/MainMasterPage.xml", "主导航", app);
        createTemplatePage("TeacherMasterPage", "教师导航", "drz/page/app/drz/org/masterpage/TeacherMasterPage.xml", "教师导航", app);
        createTemplatePage("StudentMasterPage", "学生导航", "drz/page/app/drz/org/masterpage/StudentMasterPage.xml", "学生导航", app);
        
		//页面模板
        createTemplatePage("login", "后台系统登录页面", "drz/page/app/drz/org/login.xml", "后台系统登录页面", app);
        createTemplatePage("classlist", "课程列表页面", "drz/page/app/drz/org/classlist.xml", "课程列表页面", app);
        createTemplatePage("classinformation", "课程信息页面", "drz/page/app/drz/org/classinformation.xml", "课程信息页面", app);
        createTemplatePage("friendlist", "好友列表页面", "drz/page/app/drz/org/friendlist.xml", "好友列表页面", app);
        createTemplatePage("friendadd", "好友添加页面", "drz/page/app/drz/org/friendadd.xml", "好友添加页面", app);
        createTemplatePage("resourcelist", "资源列表页面", "drz/page/app/drz/org/resourcelist.xml", "资源列表页面", app);
        createTemplatePage("grouplist", "课程群组列表页面", "drz/page/app/drz/org/grouplist.xml", "课程群组列表页面", app);
        createTemplatePage("groupmemberlist", "课程群组成员列表页面", "drz/page/app/drz/org/groupmemberlist.xml", "课程群组成员列表页面", app);
        createTemplatePage("groupmemberinfo", "课程群组成员信息表页面", "drz/page/app/drz/org/groupmemberinfo.xml", "课程群组成员信息表页面", app);
        createTemplatePage("classstudentlist", "课程学生列表", "drz/page/app/drz/org/tview/classstudentlist.xml", "课程学生列表", app);
        createTemplatePage("passwordfound", "发送邮箱验证码", "drz/page/app/drz/org/passwordfound.xml", "发送邮箱验证码", app);
        createTemplatePage("passwordreset", "密码重置窗口", "drz/page/app/drz/org/passwordreset.xml", "密码重置窗口", app);
        createTemplatePage("passwordtokenvalidate", "验证码验证", "drz/page/app/drz/org/passwordtokenvalidate.xml", "验证码验证", app);
        
        
        createTemplatePage("contactssv", "课程通讯录", "drz/page/app/drz/org/contactssv.xml", "课程通讯录", app);
        createTemplatePage("contacts", "课程通讯录", "drz/page/app/drz/org/contacts.xml", "课程通讯录", app);
        createTemplatePage("showexam", "试卷详情", "drz/page/app/drz/org/showexam.xml", "试卷详情", app);
        
        createTemplatePage("register", "注册", "drz/page/app/drz/org/register.xml", "注册", app);
        createTemplatePage("changepasswordmv", "改密", "drz/page/app/drz/org/changepasswordmv.xml", "改密", app);
        
        createTemplatePage("infofirstadd", "第一次登陆信息修改", "drz/page/app/drz/org/infofirstadd.xml", "第一次登陆信息修改", app);

        createTemplatePage("classlisthistory", "历史课程列表页面", "drz/page/app/drz/org/classlisthistory.xml", "历史课程列表页面", app);
       
        createTemplatePage("previewpager", "预览", "drz/page/app/drz/org/previewpager.xml", "预览", app);
        
        createTemplatePage("UpdateService", "更新", "drz/page/app/drz/org/UpdateService.xml", "更新", app);
        createTemplatePage("set", "设置", "drz/page/app/drz/org/set.xml", "设置", app);
        createTemplatePage("complaint", "吐槽", "drz/page/app/drz/org/complaint.xml", "吐槽", app);
        createTemplatePage("personalinformation", "个人信息", "drz/page/app/drz/org/personalinformation.xml", "个人信息", app);
        createTemplatePage("personalinformationchange", "个人信息", "drz/page/app/drz/org/personalinformationchange.xml", "个人信息修改", app);

        createTemplatePage("classinformationchange", "课程信息页面修改", "drz/page/app/drz/org/classinformationchange.xml", "课程信息页面修改", app);
        createTemplatePage("appinformation", "软件信息", "drz/page/app/drz/org/appinformation.xml", "软件信息", app);
        createTemplatePage("backstage", "后台功能", "drz/page/app/drz/org/backstage.xml", "后台功能", app);
        
        createTemplatePage("dynamic", "动态", "drz/page/app/drz/org/dynamic.xml", "动态", app);
        createTemplatePage("Graduation", "毕设", "drz/page/app/drz/org/Graduation.xml", "毕设", app);

        
        /////////////////////////////////////////service
        createTemplatePage("IMGetUserToken", "IM获取用户token服务", "drz/page/app/drz/org/service/IMGetUserToken.xml", "IM获取用户token服务", app);
		createTemplatePage("IMCreateGroup", "IM创建组服务", "drz/page/app/drz/org/service/IMCreateGroup.xml", "IM创建组服务", app);
		createTemplatePage("IMQueryGroup", "IM查询组服务", "drz/page/app/drz/org/service/IMQueryGroup.xml", "IM查询组服务", app);
		createTemplatePage("IMQueryGroupInfo", "IM查询组信息服务", "drz/page/app/drz/org/service/IMQueryGroupInfo.xml", "IM查询组信息服务", app);
        
        ///////////////////////////////////教师界面
        createTemplatePage("classgrouptv", "课程学生群组", "drz/page/app/drz/org/tview/classgrouptv.xml", "课程学生群组", app);
        createTemplatePage("classstudentaddtv", "课程学生添加", "drz/page/app/drz/org/tview/classstudentaddtv.xml", "课程学生添加", app);
        /////分组(label)
        createTemplatePage("classlabeladd", "添加标签", "drz/page/app/drz/org/tview/label/classlabeladd.xml", "添加标签", app);
        createTemplatePage("classlabelchange", "修改标签信息", "drz/page/app/drz/org/tview/label/classlabelchange.xml", "标签群组成员", app);
        createTemplatePage("classlabelgroupaddtv", "标签教师建立群组", "drz/page/app/drz/org/tview/label/classlabelgroupaddtv.xml", "标签教师建立群组", app);
        createTemplatePage("classlabelgroupmemberlisttv", "标签群组成员", "drz/page/app/drz/org/tview/label/classlabelgroupmemberlisttv.xml", "标签群组成员", app);     
        createTemplatePage("classlabelgrouptv", "标签进入群组列表", "drz/page/app/drz/org/tview/label/classlabelgrouptv.xml", "标签进入群组列表", app);    
        createTemplatePage("classlabellisttv", "标签列表", "drz/page/app/drz/org/tview/label/classlabellisttv.xml", "标签列表", app);      
        createTemplatePage("classlabelgroupmemberaddtv", "选择群组成员", "drz/page/app/drz/org/tview/label/classlabelgroupmemberaddtv.xml", "选择群组成员", app);
        createTemplatePage("classlabelgroupmemberowntv", "选择群组组长", "drz/page/app/drz/org/tview/label/classlabelgroupmemberowntv.xml", "选择群组成员组长", app);

        createTemplatePage("commentlisttv", "评论列表", "drz/page/app/drz/org/tview/commentlisttv.xml", "评论列表", app);
        createTemplatePage("commentanswerlist", "评论回答情况", "drz/page/app/drz/org/tview/commentanswerlist.xml", "评论回答情况", app);
        createTemplatePage("commentanswerdetail", "评论详情", "drz/page/app/drz/org/tview/commentanswerdetail.xml", "评论详情页面", app);
        
        
        createTemplatePage("classlabelgroupreleasesure", "确认发布", "drz/page/app/drz/org/tview/classlabelgroupreleasesure.xml", "确认发布", app);
        createTemplatePage("classgradestudent", "评分页面", "drz/page/app/drz/org/tview/classgradestudent.xml", "评分页面", app);

        createTemplatePage("noticecreate", "公告发布页面", "drz/page/app/drz/org/tview/noticecreate.xml", "公告发布页面", app);
        createTemplatePage("noticedetail", "公告详情页面", "drz/page/app/drz/org/tview/noticedetail.xml", "公告详情页面", app);
        createTemplatePage("noticelist", "公告列表页面", "drz/page/app/drz/org/tview/noticelist.xml", "公告列表页面", app);

        createTemplatePage("classresourceupload", "文件上传页面", "drz/page/app/drz/org/tview/classresourceupload.xml", "文件上传页面", app);
        createTemplatePage("classresourcelisttv", "文件列表", "drz/page/app/drz/org/tview/classresourcelisttv.xml", "文件列表", app);
        createTemplatePage("classresourcedetailtv", "文件下载", "drz/page/app/drz/org/tview/classresourcedetailtv.xml", "文件下载", app);

        
        
        createTemplatePage("personaltv", "教师个人界面", "drz/page/app/drz/org/tview/personaltv.xml", "教师个人界面", app);
        createTemplatePage("personalinfochangeinfo", "教师个人信息修改", "drz/page/app/drz/org/tview/personalinfochangeinfo.xml", "教师个人信息修改", app);
        createTemplatePage("classlabelgroupreleasemian", "评论发布窗口", "drz/page/app/drz/org/tview/classlabelgroupreleasemian.xml", "评论发布窗口", app);

        createTemplatePage("classhomeworklist", "作业列表", "drz/page/app/drz/org/tview/classhomeworklist.xml", "作业列表", app);
        createTemplatePage("classhomeworkcreate", "作业创建", "drz/page/app/drz/org/tview/classhomeworkcreate.xml", "作业创建", app);
        createTemplatePage("classhomeworkdetail", "作业详情", "drz/page/app/drz/org/tview/classhomeworkdetail.xml", "作业详情", app);
        createTemplatePage("classhomeworkchange", "作业修改", "drz/page/app/drz/org/tview/classhomeworkchange.xml", "作业修改", app);
        
        createTemplatePage("classhomeworkadminanswerlist", "作业提交列表", "drz/page/app/drz/org/tview/classhomeworkadminanswerlist.xml", "作业提交列表", app);
        createTemplatePage("classhomeworkadmincomment", "作业评分", "drz/page/app/drz/org/tview/classhomeworkadmincomment.xml", "作业评分", app);
        createTemplatePage("classhomeworkadminlist", "作业列表(评分)", "drz/page/app/drz/org/tview/classhomeworkadminlist.xml", "作业列表(评分)", app);
        createTemplatePage("classaddtv", "增加课程", "drz/page/app/drz/org/tview/classaddtv.xml", "增加课程", app);
        createTemplatePage("classstudentlistadd", "学生列表导入", "drz/page/app/drz/org/tview/classstudentlistadd.xml", "学生列表导入", app);

        createTemplatePage("classtimeadd", "上课时间添加", "drz/page/app/drz/org/tview/classtimeadd.xml", "上课时间添加", app);
        createTemplatePage("classtimelist", "上课时间列表", "drz/page/app/drz/org/tview/classtimelist.xml", "上课时间列表", app);
        createTemplatePage("classtimechange", "上课时间更改", "drz/page/app/drz/org/tview/classtimechange.xml", "上课时间更改", app);

        createTemplatePage("classtoolstv", "课堂工具", "drz/page/app/drz/org/tview/classtoolstv.xml", "课堂工具", app);

        //随机抽取
		
      	createTemplatePage("randomselect", "随机抽取", "drz/page/app/drz/org/tview/randomselect.xml", "随机抽取", app);
        ///////教师界面（签到）
        createTemplatePage("attendancecreatetv", "上课签到", "drz/page/app/drz/org/tview/attendance/attendancecreatetv.xml", "上课签到", app);
        createTemplatePage("attendancedetailtv", "上课签到详情列表", "drz/page/app/drz/org/tview/attendance/attendancedetailtv.xml", "上课签到详情列表", app);
        createTemplatePage("attendancechangetv", "学生签到情况修改", "drz/page/app/drz/org/tview/attendance/attendancechangetv.xml", "学生签到情况修改", app);
        createTemplatePage("attendancehistorytv", "学生历史签到情况", "drz/page/app/drz/org/tview/attendance/attendancehistorytv.xml", "学生历史签到情况", app);
        createTemplatePage("attendancehistorydetailtv", "学生历史签到详情", "drz/page/app/drz/org/tview/attendance/attendancehistorydetailtv.xml", "学生历史签到详情", app);
        createTemplatePage("attendancecondition", "签到情况页面", "drz/page/app/drz/org/tview/attendance/attendancecondition.xml", "签到情况页面", app);

        ///////////group
        createTemplatePage("classmygrouplisttv", "课程群组", "drz/page/app/drz/org/tview/group/classmygrouplisttv.xml", "课程群组", app);
        /////////////////////////////学生界面
        createTemplatePage("classgrouplistsv", "学生课程分组列表页面", "drz/page/app/drz/org/sview/classgrouplistsv.xml", "学生课程分组列表页面", app);
        createTemplatePage("classgrouplabel", "小组列表页面", "drz/page/app/drz/org/sview/classgrouplabel.xml", "小组列表页面", app);
        createTemplatePage("classcreatesubgroup", "建立小组页面", "drz/page/app/drz/org/sview/classcreatesubgroup.xml", "建立小组页面", app);
        createTemplatePage("classsubgroupjoin", "加入分组页面", "drz/page/app/drz/org/sview/classsubgroupjoin.xml", "加入分组页面", app);
        createTemplatePage("classgroupmodify", "小组修改页面", "drz/page/app/drz/org/sview/classgroupmodify.xml", "小组修改页面", app);
        createTemplatePage("classsubgroupkickout", "小组修改页面", "drz/page/app/drz/org/sview/classsubgroupkickout.xml", "小组修改页面", app);
       
        createTemplatePage("classgroupmemberlistsv", "学生小组成员", "drz/page/app/drz/org/sview/classgroupmemberlistsv.xml", "学生小组成员", app);
        
        createTemplatePage("uncommentlistsv", "学生待评价列表", "drz/page/app/drz/org/sview/uncommentlistsv.xml", "学生待评价列表", app);
        createTemplatePage("evaluatepager", "评价问卷", "drz/page/app/drz/org/sview/evaluatepager.xml", "评价问卷", app);
        createTemplatePage("commentdefaultanswer", "评价默认问卷", "drz/page/app/drz/org/sview/commentdefaultanswer.xml", "评价默认问卷", app);
 
        createTemplatePage("classgroupnotice", "学生公告列表", "drz/page/app/drz/org/sview/classgroupnotice.xml", "学生公告列表", app);
        createTemplatePage("personalsv", "学生个人界面", "drz/page/app/drz/org/sview/personalsv.xml", "学生个人界面", app);
        createTemplatePage("classgrade", "学生成绩及评价界面", "drz/page/app/drz/org/sview/classgrade.xml", "学生成绩及评价界面", app);
        
        createTemplatePage("classgrade", "成绩及评价", "drz/page/app/drz/org/sview/classgrade.xml", "成绩及评价", app);
        createTemplatePage("classgradeallclass", "本学期所有课程期末成绩", "drz/page/app/drz/org/sview/classgradeallclass.xml", "本学期所有课程期末成绩", app);
        createTemplatePage("classhomeworkofclass", "课程内作业列表页面", "drz/page/app/drz/org/sview/classhomeworkofclass.xml", "课程内作业列表页面", app);
        createTemplatePage("classhomeworkdetailsv", "内作详情及提交", "drz/page/app/drz/org/sview/classhomeworkdetailsv.xml", "内作详情及提交", app);
        createTemplatePage("classgroupnoticedetail", "公告详情", "drz/page/app/drz/org/sview/classgroupnoticedetail.xml", "公告详情", app);

        createTemplatePage("classhomeworkofall", "学生作业管理", "drz/page/app/drz/org/sview/classhomeworkofall.xml", "学生作业管理", app);
        createTemplatePage("classresourcelistsv", "学生课堂资源列表", "drz/page/app/drz/org/sview/classresourcelistsv.xml", "学生课堂资源列表", app);
        
        createTemplatePage("classattendancesv", "学生签到页面", "drz/page/app/drz/org/sview/classattendancesv.xml", "学生签到页面", app);
        createTemplatePage("classattendancehistorysv", "学生签到历史页面", "drz/page/app/drz/org/sview/classattendancehistorysv.xml", "学生签到页面", app);
        
        createTemplatePage("classtoolssv", "课堂工具", "drz/page/app/drz/org/sview/classtoolssv.xml", "课堂工具", app);
 
        createTemplatePage("classlabellistsv", "标签列表", "drz/page/app/drz/org/sview/classlabellistsv.xml", "标签列表", app);      
        ///////////group
        createTemplatePage("classmygrouplistsv", "课程群组", "drz/page/app/drz/org/sview/group/classmygrouplistsv.xml", "课程群组", app);
        ////////////////////////////////管理员界面
        createTemplatePage("ImportUserList", "加入分组页面", "drz/page/app/drz/org/adminview/ImportUserList.xml", "加入分组页面", app);
        
        //	手机端       quest  vote
        createTemplatePage("createonevote", "创建投票", "drz/page/app/drz/org/quest/vote/createonevote.xml", "创建投票", app);
        createTemplatePage("votefinish", "投票完成", "drz/page/app/drz/org/quest/vote/votefinish.xml", "投票完成", app);
        createTemplatePage("votelist", "投票列表", "drz/page/app/drz/org/quest/vote/votelist.xml", "投票列表", app);
        createTemplatePage("voteresult", "投票结果", "drz/page/app/drz/org/quest/vote/voteresult.xml", "投票结果", app);
        createTemplatePage("singlevote", "一道投票", "drz/page/app/drz/org/quest/vote/singlevote.xml", "一道投票", app);
            
      //quest questionnaire
        createTemplatePage("questlist", "问卷列表", "drz/page/app/drz/org/quest/questionnaire/questlist.xml", "问卷列表", app);
        createTemplatePage("respondquest", "回答问卷", "drz/page/app/drz/org/quest/questionnaire/respondquest.xml", "回答问卷", app);
        createTemplatePage("respondfinish", "问卷结束", "drz/page/app/drz/org/quest/questionnaire/respondfinish.xml", "问卷结束", app);
      
        //quest questionnaire
        createTemplatePage("questlist", "问卷列表", "drz/page/app/drz/org/quest/questionnaire/questlist.xml", "问卷列表", app);
        createTemplatePage("respondquest", "回答问卷", "drz/page/app/drz/org/quest/questionnaire/respondquest.xml", "回答问卷", app);
        createTemplatePage("respondfinish", "问卷结束", "drz/page/app/drz/org/quest/questionnaire/respondfinish.xml", "问卷结束", app);
        
        //mobel client
        createTemplatePage("GraNoticeDetailsMC", "毕设公告详情", "drz/page/app/drz/org/graduation/GraNoticeDetailsMC.xml", "毕设公告详情", app);
        //graduation mentor
        createTemplatePage("MgraNoticesMC", "导师公告列表", "drz/page/app/drz/org/graduation/mentor/MgraNoticesMC.xml", "导师公告列表", app);
        createTemplatePage("MgraResourcesMC", "导师资源列表", "drz/page/app/drz/org/graduation/mentor/MgraResourcesMC.xml", "导师资源列表", app);
        createTemplatePage("MgraStudentsMC", "导师毕设学生人员表", "drz/page/app/drz/org/graduation/mentor/MgraStudentsMC.xml", "导师毕设学生人员表", app);
        createTemplatePage("MgraStudentsRequestMC", "导师端学生请求列表", "drz/page/app/drz/org/graduation/mentor/MgraStudentsRequestMC.xml", "导师端学生请求列表", app);
        createTemplatePage("MgraStudentAddMC", "导师添加毕设学生人员表", "drz/page/app/drz/org/graduation/mentor/MgraStudentAddMC.xml", "导师添加毕设学生人员表", app);
        createTemplatePage("MgraDocumentsMC", "导师毕设学生文档", "drz/page/app/drz/org/graduation/mentor/MgraDocumentsMC.xml", "导师毕设学生文档", app);
        createTemplatePage("MgraContactsMC", "导师毕设学生文档", "drz/page/app/drz/org/graduation/mentor/MgraContactsMC.xml", "学生端通讯录", app);

        // graduation student
        createTemplatePage("SgraMessageMC", "学生毕设基本信息", "drz/page/app/drz/org/graduation/student/SgraMessageMC.xml", "学生毕设基本信息", app);
        createTemplatePage("SgraMessageEditMC", "编辑学生毕设基本信息", "drz/page/app/drz/org/graduation/student/SgraMessageEditMC.xml", "编辑学生毕设基本信息", app);
        createTemplatePage("SgraMentorMsgMC", "学生导师信息", "drz/page/app/drz/org/graduation/student/SgraMentorMsgMC.xml", "学生导师信息", app);
        createTemplatePage("SgraMentorAddMC", "添加导师", "drz/page/app/drz/org/graduation/student/SgraMentorAddMC.xml", "添加导师", app);
        createTemplatePage("SgraNoticesMC", "学生公告列表", "drz/page/app/drz/org/graduation/student/SgraNoticesMC.xml", "学生公告列表", app);
        createTemplatePage("SgraResourcesMC", "学生资源列表", "drz/page/app/drz/org/graduation/student/SgraResourcesMC.xml", "学生资源列表", app);
        createTemplatePage("SgraDocumentsMC", "学生文档列表", "drz/page/app/drz/org/graduation/student/SgraDocumentsMC.xml", "学生文档列表", app);
        createTemplatePage("SgraContactsMC", "学生端通讯录", "drz/page/app/drz/org/graduation/student/SgraContactsMC.xml", "学生端通讯录", app);
        
        //performance
        //performance student
        createTemplatePage("SperformanceMC", "学生端成绩中心成绩", "drz/page/app/drz/org/performance/student/SperformanceMC.xml", "学生端成绩中心成绩", app);
        createTemplatePage("SperBubbleMC", "学生端成绩中心气泡图", "drz/page/app/drz/org/performance/student/SperBubbleMC.xml", "学生端成绩中心气泡图", app);
        createTemplatePage("SperRadarMC", "学生端成绩中心雷达图", "drz/page/app/drz/org/performance/student/SperRadarMC.xml", "学生端成绩中心雷达图", app);
        //performance teacher
        createTemplatePage("TperformanceMC", "教师端成绩中心成绩", "drz/page/app/drz/org/performance/teacher/TperformanceMC.xml", "教师端成绩中心成绩", app);
        createTemplatePage("TperBubbleMC", "教师端成绩中心气泡图", "drz/page/app/drz/org/performance/teacher/TperBubbleMC.xml", "教师端成绩中心成绩列表", app);
        createTemplatePage("TperRadarMC", "教师端成绩中心雷达图", "drz/page/app/drz/org/performance/teacher/TperRadarMC.xml", "教师端成绩中心雷达图", app);
        createTemplatePage("TperSgradeEditMC", "教师端成绩中心学生成绩修改", "drz/page/app/drz/org/performance/teacher/TperSgradeEditMC.xml", "教师端成绩中心学生成绩修改", app);
        createTemplatePage("TperStudentGradeMC", "教师端成绩中心学生成绩", "drz/page/app/drz/org/performance/teacher/TperStudentGradeMC.xml", "教师端成绩中心学生成绩", app);


        //back manage
        createTemplatePage("changePassword", "修改密码", "drz/page/app/drz/org/back/manage/changePassword.xml", "修改密码", app);
        //back manage school
        createTemplatePage("schoolGrid", "学校列表", "drz/page/app/drz/org/back/manage/school/schoolGrid.xml", "学校列表", app);
        createTemplatePage("createSchool", "创建学校", "drz/page/app/drz/org/back/manage/school/createSchool.xml", "创建学校", app);
        createTemplatePage("collegeGrid", "院系列表", "drz/page/app/drz/org/back/manage/school/collegeGrid.xml", "院系列表", app);
        createTemplatePage("createCollege", "创建院系", "drz/page/app/drz/org/back/manage/school/createCollege.xml", "创建院系", app);
        createTemplatePage("studentImport", "导入学生名单", "drz/page/app/drz/org/back/manage/school/studentImport.xml", "导入学生名单", app);
        createTemplatePage("teachersImport", "导入教师名单", "drz/page/app/drz/org/back/manage/school/teachersImport.xml", "导入教师名单", app);
        
        //back manage feedback
        createTemplatePage("feedbackGrid", "吐槽反馈表", "drz/page/app/drz/org/back/manage/feedback/feedbackGrid.xml", "吐槽反馈表", app);
        
        //back manage course 
        createTemplatePage("CourseManager", "课程管理列表", "drz/page/app/drz/org/back/manage/course/CourseManager.xml", "课程管理列表", app);
        createTemplatePage("CourseStuManager", "课程名单管理", "drz/page/app/drz/org/back/manage/course/CourseStuManager.xml", "课程名单管理", app);
        createTemplatePage("CourseStusAdd", "课程名单管理", "drz/page/app/drz/org/back/manage/course/CourseStusAdd.xml", "课程名单管理", app);
        
        //back permission
        createTemplatePage("roleGrid", "角色管理", "drz/page/app/drz/org/back/permission/roleGrid.xml", "角色管理", app);
        createTemplatePage("roleCreate", "创建角色", "drz/page/app/drz/org/back/permission/roleCreate.xml", "创建角色", app);
        createTemplatePage("roleEdit", "编辑角色", "drz/page/app/drz/org/back/permission/roleEdit.xml", "编辑角色", app);
        createTemplatePage("DataManage", "数据同步管理", "drz/page/app/drz/org/back/permission/DataManage.xml", "数据同步管理", app);
        //back permission course
        createTemplatePage("CourseGrid", "课程管理", "drz/page/app/drz/org/back/permission/course/CourseGrid.xml", "课程管理", app);
        createTemplatePage("CoursetimeGrid", "课程时间管理", "drz/page/app/drz/org/back/permission/course/CoursetimeGrid.xml", "课程时间管理", app);
        createTemplatePage("CourseCreate", "课程创建", "drz/page/app/drz/org/back/permission/course/CourseCreate.xml", "课程创建", app);
        createTemplatePage("CourseStudents", "课程名单", "drz/page/app/drz/org/back/permission/course/CourseStudents.xml", "课程名单", app);
        createTemplatePage("CourseStuImport", "课程名单导入", "drz/page/app/drz/org/back/permission/course/CourseStuImport.xml", "课程名单导入", app);
        createTemplatePage("CourseAttendance", "管理端签到列表", "drz/page/app/drz/org/back/permission/course/CourseAttendance.xml", "管理端签到列表", app);
        createTemplatePage("CourseAttDetails", "管理员端签到详情列表", "drz/page/app/drz/org/back/permission/course/CourseAttDetails.xml", "管理员端签到详情列表", app);
        
        //back permission user
        createTemplatePage("userGrid", "用户管理", "drz/page/app/drz/org/back/permission/user/userGrid.xml", "用户管理", app);
        createTemplatePage("userEdit", "用户编辑", "drz/page/app/drz/org/back/permission/user/userEdit.xml", "用户编辑", app);
        
        //back attendance
        createTemplatePage("AttendanceGrid", "签到列表", "drz/page/app/drz/org/back/attendance/AttendanceGrid.xml", "签到列表", app);
        createTemplatePage("AttendanceDetailGrid", "电脑端教师签到详情列表", "drz/page/app/drz/org/back/attendance/AttendanceDetailGrid.xml", "电脑端教师签到详情列表", app);
        createTemplatePage("AttendanceStart", "发起签到", "drz/page/app/drz/org/back/attendance/AttendanceStart.xml", "发起签到", app);

        //default
        createTemplatePage("Default", "默认空白", "drz/page/app/drz/org/back/Default.xml", "默认空白", app);
        
        //back temporary
        createTemplatePage("UserInfoDSLifecycle", "学生信息同步生命周期查看", "drz/page/app/drz/org/back/temporary/UserInfoDSLifecycle.xml", "学生信息同步生命周期查看", app);
        
        //service drz qrcode
        createTemplatePage("SvcDrzQRCodeProduce", "二维码内容产生服务", "drz/page/service/drz/code/SvcDrzQRCodeProduce.xml", "二维码内容产生服务", app);
        createTemplatePage("SvcDrzQRCodeVerify", "二维码验证服务", "drz/page/service/drz/code/SvcDrzQRCodeVerify.xml", "二维码验证服务", app);
        createTemplatePage("SvcDrzQRCodeReturn", "二维码轮询结果返回服务", "drz/page/service/drz/code/SvcDrzQRCodeReturn.xml", "二维码轮询结果返回服务", app);
        
        //service drz login
        createTemplatePage("SvcDrzLogin", "drz登录服务", "drz/page/service/drz/login/SvcDrzLogin.xml", "drz登录服务", app);

        // service exam
        createTemplatePage("SvcExamCreate", "考卷创建", "drz/page/service/exam/SvcExamCreate.xml", "考卷创建", app);
        createTemplatePage("SvcExamEdit", "考卷编辑请求服务", "drz/page/service/exam/SvcExamEdit.xml", "考卷编辑请求服务", app);
        createTemplatePage("SvcExamList", "考卷列表服务", "drz/page/service/exam/SvcExamList.xml", "考卷列表服务", app);
        createTemplatePage("SvcAnswerReceiver", "答卷提交", "drz/page/service/exam/SvcAnswerReceiver.xml", "答卷提交", app);
        createTemplatePage("SvcExamCheckedSender", "批改后考卷下发", "drz/page/service/exam/SvcExamCheckedSender.xml", "答卷提交", app);
        createTemplatePage("SvcExamInfoSender", "批改后考卷下发", "drz/page/service/exam/SvcExamInfoSender.xml", "答卷提交", app);
        createTemplatePage("SvcExaminationPaper", "考试服务列表", "drz/page/service/exam/SvcExaminationPaper.xml", "考试服务列表", app);
        createTemplatePage("SvcExamUserResult", "学生作答情况", "drz/page/service/exam/SvcExamUserResult.xml", "学生作答情况", app);
        createTemplatePage("SvcExamStart", "考卷请求开始服务", "drz/page/service/exam/SvcExamStart.xml", "考卷请求开始服务", app);
        createTemplatePage("SvcExamStuGradeList", "学生成绩列表服务", "drz/page/service/exam/SvcExamStuGradeList.xml", "学生成绩列表服务", app);
        createTemplatePage("SvcExamStandards", "考卷详情（包括答案）服务", "drz/page/service/exam/SvcExamStandards.xml", "考卷详情（包括答案）服务", app);
        createTemplatePage("SvcEvaluateOfExam", "考试添加到成绩中心（平时成绩）服务", "drz/page/service/exam/SvcEvaluateOfExam.xml", "考试添加到成绩中心（平时成绩）服务", app);
        createTemplatePage("SvcExamTimeCountDown", "考卷剩余时间", "drz/page/service/exam/SvcExamTimeCountDown.xml", "考卷剩余时间", app);

        // service exam analyze
        createTemplatePage("SvcExamAnalyze", "试卷分析服务", "drz/page/service/exam/analyze/SvcExamAnalyze.xml", "试卷分析服务", app);

        
        //basicinfo
        createTemplatePage("SvcUserInfo", "用户信息数据同步服务", "drz/page/service/drz/basicinfo/SvcUserInfo.xml", "用户信息数据同步服务", app);
        
        //service vote
        createTemplatePage("SvcVoteCreate", "创建投票服务", "drz/page/service/vote/SvcVoteCreate.xml", "创建投票服务", app);
        createTemplatePage("SvcVoteControl", "管理投票服务", "drz/page/service/vote/SvcVoteControl.xml", "管理投票服务", app);
        createTemplatePage("SvcVoteList", "投票列表服务", "drz/page/service/vote/SvcVoteList.xml", "投票列表服务", app);
        createTemplatePage("SvcVoteSender", "投票内容下发服务", "drz/page/service/vote/SvcVoteSender.xml", "投票内容下发服务", app);
        createTemplatePage("SvcVoteReceiver", "投票结果提交服务", "drz/page/service/vote/SvcVoteReceiver.xml", "投票结果提交服务", app);
        createTemplatePage("SvcVoteState", "获取投票状态服务", "drz/page/service/vote/SvcVoteState.xml", "获取投票状态服务", app);
        createTemplatePage("SvcVoteResult", "投票结果服务", "drz/page/service/vote/SvcVoteResult.xml", "投票结果服务", app);
        
        //service attendance
        createTemplatePage("SvcQuickAttendance", "快速签到列表", "drz/page/service/attendance/SvcQuickAttendance.xml", "快速签到列表", app);
        createTemplatePage("SvcGetQrcode", "快速签到获取二维码内容", "drz/page/service/attendance/SvcGetQrcode.xml", "快速签到获取二维码内容", app);
        createTemplatePage("QuickAttendance", "快速签到", "drz/page/service/attendance/QuickAttendance.xml", "快速签到", app);
        createTemplatePage("SvcAttendanceMonitorStu", "学生签到情况监控服务", "drz/page/service/attendance/SvcAttendanceMonitorStu.xml", "学生签到情况监控服务", app);
        createTemplatePage("ExpAttendanceStu", "学生签到情况导出", "drz/page/service/attendance/ExpAttendanceStu.xml", "学生签到情况导出", app);
        
        // service graphic
        createTemplatePage("SvcMedianCompareOfPer", "成绩中心中位数比较服务", "drz/page/service/graphic/SvcMedianCompareOfPer.xml", "成绩中心中位数比较服务", app);
        createTemplatePage("SvcCollegeAttendanceRate", "drz课程签到率服务", "drz/page/service/graphic/SvcCollegeAttendanceRate.xml", "drz课程签到率服务", app);
        
        // service minutespaper
        createTemplatePage("SvcMPListTea", "MinutesPaper教师列表服务", "drz/page/service/minutespaper/SvcMPListTea.xml", "MinutesPaper教师列表服务", app);
        createTemplatePage("SvcMPListStu", "MinutesPaper学生列表服务", "drz/page/service/minutespaper/SvcMPListStu.xml", "MinutesPaper学生列表服务", app);
        createTemplatePage("SvcMPCreate", "MinutesPaper创建服务", "drz/page/service/minutespaper/SvcMPCreate.xml", "MinutesPaper创建服务", app);
        createTemplatePage("SvcMPSender", "MinutesPaper下发服务", "drz/page/service/minutespaper/SvcMPSender.xml", "MinutesPaper下发服务", app);
        createTemplatePage("SvcMPResponse", "MinutesPaper回答服务", "drz/page/service/minutespaper/SvcMPResponse.xml", "MinutesPaper回答服务", app);
        createTemplatePage("SvcMPHandle", "MinutesPaper状态控制服务", "drz/page/service/minutespaper/SvcMPHandle.xml", "MinutesPaper状态控制服务", app);
        createTemplatePage("SvcMPFeedback", "MinutesPaper反馈服务", "drz/page/service/minutespaper/SvcMPFeedback.xml", "MinutesPaper反馈服务", app);
        createTemplatePage("SvcMPDelete", "MinutesPaper删除服务", "drz/page/service/minutespaper/SvcMPDelete.xml", "MinutesPaper删除服务", app);

    }

	@Override
	public void clearData() {

	}

}
