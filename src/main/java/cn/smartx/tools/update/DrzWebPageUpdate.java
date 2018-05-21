package cn.smartx.tools.update;

import cn.smartx.core.AAA.model.Menu;
import cn.smartx.core.model.entity.XApp;

/** 
 * @author Bona
 * @time   2017年6月21日 下午4:52:28 
 */

public class DrzWebPageUpdate extends PageUpdate{
	
	public DrzWebPageUpdate(){
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
        // service web
		// service web attendance 签到
		createTemplatePage("SvcAttendanceManagerTea", "签到管理", "drz/page/service/web/attendance/SvcAttendanceManagerTea.xml", "签到管理", app);
        createTemplatePage("SvcAttendanceDetailTea", "签到详情", "drz/page/service/web/attendance/SvcAttendanceDetailTea.xml", "签到详情", app);
        createTemplatePage("SvcGenerateQrcode", "签到二维码生成", "drz/page/service/web/attendance/SvcGenerateQrcode.xml", "签到二维码生成", app);
        createTemplatePage("SvcAttendanceExportTea", "签到信息导出", "drz/page/service/web/attendance/SvcAttendanceExportTea.xml", "签到信息导出", app);
        
        // service web college 院系
        createTemplatePage("SvcCollegeActivate", "开通院系服务", "drz/page/service/web/college/SvcCollegeActivate.xml", "开通院系服务", app);
        createTemplatePage("SvcCollegeCreate", "创建分院服务", "drz/page/service/web/college/SvcCollegeCreate.xml", "创建分院服务", app);
        createTemplatePage("SvcCollegeUser", "获取系部用户服务", "drz/page/service/web/college/SvcCollegeUser.xml", "获取系部用户服务", app);
        createTemplatePage("SvcCollegeInfo", "院系信息服务", "drz/page/service/web/college/SvcCollegeInfo.xml", "院系信息服务", app);
        
        // service web common 公共功能
        createTemplatePage("SvcFileDownload", "下载文件/模板服务", "drz/page/service/web/common/SvcFileDownload.xml", "下载文件/模板", app);
        createTemplatePage("SvcJobProgress", "job进度查询服务", "drz/page/service/web/common/SvcJobProgress.xml", "job进度查询服务", app);
        
        
        // service web course 课程
        createTemplatePage("SvcCourseDetail", "教师课程详情", "drz/page/service/web/course/SvcCourseDetail.xml", "教师课程详情", app);
        createTemplatePage("SvcCourse", "获取课程信息服务", "drz/page/service/web/course/SvcCourse.xml", "课程信息", app);
        createTemplatePage("SvcCourseUser", "获取课程学生信息服务", "drz/page/service/web/course/SvcCourseUser.xml", "课程学生信息", app);
        createTemplatePage("SvcCourseStuImport", "导入课程学生服务", "drz/page/service/web/course/SvcCourseStuImport.xml", "导入课程学生", app);
        createTemplatePage("SvcSemesterCourseList", "学期课程列表请求服务", "drz/page/service/web/course/SvcSemesterCourseList.xml", "学期课程列表请求服务", app);
        createTemplatePage("SvcSemesterCourseImport", "学期课程导入服务", "drz/page/service/web/course/SvcSemesterCourseImport.xml", "学期课程导入服务", app);
        createTemplatePage("SvcCourseCreate", "课程添加", "drz/page/service/web/course/SvcCourseCreate.xml", "课程添加", app);
        createTemplatePage("SvcCourseNumberProduce", "课程号产生服务", "drz/page/service/web/course/SvcCourseNumberProduce.xml", "课程号产生服务", app);
        
        
        // service web dashboard 
        createTemplatePage("SvcDBWebInfoTea", "教师dashboard网页信息请求服务", "drz/page/service/web/dashboard/SvcDBWebInfoTea.xml", "教师dashboard网页信息请求服务", app);
        
        // service web exam 考试
        createTemplatePage("SvcExamFullList", "考卷全部列表服务", "drz/page/service/web/exam/SvcExamFullList.xml", "考卷全部列表服务", app);
        createTemplatePage("SvcExamDelete", "考卷删除服务", "drz/page/service/web/exam/SvcExamDelete.xml", "考卷删除服务", app);
        createTemplatePage("SvcExamRedact", "考卷编辑服务", "drz/page/service/web/exam/SvcExamRedact.xml", "考卷编辑服务", app);
        createTemplatePage("SvcExamRedactData", "考卷编辑数据请求服务", "drz/page/service/web/exam/SvcExamRedactData.xml", "考卷编辑数据请求服务", app);
        createTemplatePage("SvcExamBegin", "考卷请求开始服务", "drz/page/service/web/exam/SvcExamBegin.xml", "考卷请求开始服务", app);
        createTemplatePage("SvcExamStuGrades", "学生成绩列表服务", "drz/page/service/web/exam/SvcExamStuGrades.xml", "学生成绩列表服务", app);

        // service web graphic 图表
        createTemplatePage("ExpAttendanceStu", "缺课预警导出", "drz/page/service/web/graphic/ExpAttendanceStu.xml", "缺课预警导出", app);
        createTemplatePage("SvcGraphicAttMonStuCollege", "院系学生签到情况监控服务", "drz/page/service/web/graphic/SvcGraphicAttMonStuCollege.xml", "院系学生签到情况监控服务", app);
        createTemplatePage("SvcGraphicAttMonStuCollegeDetail", "院系学生签到情况监控服务", "drz/page/service/web/graphic/SvcGraphicAttMonStuCollegeDetail.xml", "院系学生签到情况监控服务", app);
        createTemplatePage("SvcGraphicAttMonStuCourse", "课程学生签到情况监控服务", "drz/page/service/web/graphic/SvcGraphicAttMonStuCourse.xml", "学生签到情况监控服务", app);
        createTemplatePage("SvcGraphicAttMonStuCourseDetail", "课程学生签到情况监控服务", "drz/page/service/web/graphic/SvcGraphicAttMonStuCourseDetail.xml", "学生签到情况监控服务", app);
        createTemplatePage("SvcRankCourse", "drz班级活跃度排名", "drz/page/service/web/graphic/SvcRankCourse.xml", "drz班级活跃度排名", app);
        createTemplatePage("SvcRankStudentCourse", "drz学生活跃度排名", "drz/page/service/web/graphic/SvcRankStudentCourse.xml", "drz学生活跃度排名", app);
        createTemplatePage("SvcRankStudentCollege", "drz系部学生活跃度排名", "drz/page/service/web/graphic/SvcRankStudentCollege.xml", "drz系部学生活跃度排名", app);
        createTemplatePage("SvcAttendanceRateCourseOfCollege", "drz课程签到率服务", "drz/page/service/web/graphic/SvcAttendanceRateCourseOfCollege.xml", "drz课程签到率服务", app);
        createTemplatePage("SvcAttendanceRateCourse", "drz课程签到率", "drz/page/service/web/graphic/SvcAttendanceRateCourse.xml", "drz课程签到率", app);
        createTemplatePage("SvcCoursePerfermanceLine", "成绩中心中位数比较服务（折线图）", "drz/page/service/web/graphic/SvcCoursePerfermanceLine.xml", "成绩中心中位数比较服务（折线图）", app);
        createTemplatePage("SvcCoursePerfermanceRadar", "课程学生表现雷达图", "drz/page/service/web/graphic/SvcCoursePerfermanceRadar.xml", "课程学生表现雷达图", app);
		
        // service web login 登录
        createTemplatePage("SvcLoginUserNo", "账号登录服务", "drz/page/service/web/login/SvcLoginUserNo.xml", "账号登录服务", app);
        createTemplatePage("SvcLoginPhone", "手机号登录服务", "drz/page/service/web/login/SvcLoginPhone.xml", "手机号登录服务", app);
        
        // service web notice 公告
        createTemplatePage("SvcNotice", "课程公告", "drz/page/service/web/notice/SvcNotice.xml", "课程公告", app);
        
        // service web performance 成绩中心
        createTemplatePage("SvcPerformances", "成绩中心列表请求服务", "drz/page/service/web/performance/SvcPerformances.xml", "成绩中心列表请求服务", app);
        createTemplatePage("SvcPerformanceStuGrades", "成绩中心学生成绩列表请求服务", "drz/page/service/web/performance/SvcPerformanceStuGrades.xml", "成绩中心学生成绩列表请求服务", app);
        createTemplatePage("SvcPerformanceDelete", "成绩中心删除服务", "drz/page/service/web/performance/SvcPerformanceDelete.xml", "成绩中心删除服务", app);
        createTemplatePage("SvcPerformanceCreate", "成绩中心添加评价服务", "drz/page/service/web/performance/SvcPerformanceCreate.xml", "成绩中心添加评价服务", app);
        createTemplatePage("SvcPerformanceSummary", "成绩中心总汇列表服务", "drz/page/service/web/performance/SvcPerformanceSummary.xml", "成绩中心总汇列表服务", app);
        createTemplatePage("SvcPerformanceGradeEdit", "成绩中心成绩修改服务", "drz/page/service/web/performance/SvcPerformanceGradeEdit.xml", "成绩中心成绩修改服务", app);
        createTemplatePage("SvcPerformanceGradeImport", "成绩中心成绩导入服务", "drz/page/service/web/performance/SvcPerformanceGradeImport.xml", "成绩中心成绩导入服务", app);
        
        // service web permission 权限
        createTemplatePage("SvcGetMenus", "获取权限服务", "drz/page/service/web/permission/SvcGetMenus.xml", "获取权限服务", app);
        createTemplatePage("SvcGetRoles", "获取角色", "drz/page/service/web/permission/SvcGetRoles.xml", "获取角色", app);
        createTemplatePage("SvcGetPermissions", "获取权限", "drz/page/service/web/permission/SvcGetPermissions.xml", "获取权限", app);
        createTemplatePage("SvcAddRole", "添加角色", "drz/page/service/web/permission/SvcAddRole.xml", "添加角色", app);
        createTemplatePage("SvcUpdateRole", "更新角色", "drz/page/service/web/permission/SvcUpdateRole.xml", "更新角色", app);
        createTemplatePage("SvcDeleteRole", "删除角色", "drz/page/service/web/permission/SvcDeleteRole.xml", "删除角色", app);
        createTemplatePage("SvcGetUsers", "获取用户", "drz/page/service/web/permission/SvcGetUsers.xml", "获取用户", app);
        createTemplatePage("SvcGetUserRoles", "获取用户角色", "drz/page/service/web/permission/SvcGetUserRoles.xml", "获取用户角色", app);
        createTemplatePage("SvcUpdateUserRoles", "更新用户角色", "drz/page/service/web/permission/SvcUpdateUserRoles.xml", "更新用户角色", app);
        createTemplatePage("SvcResetPassword", "重置密码", "drz/page/service/web/permission/SvcResetPassword.xml", "重置密码", app);
        createTemplatePage("SvcLockOrUnLockUser", "锁定/解锁用户", "drz/page/service/web/permission/SvcLockOrUnLockUser.xml", "锁定/解锁用户", app);

        // server web placement 实习就业
        createTemplatePage("SvcPlacementList", "实习就业管理服务", "drz/page/service/web/placement/SvcPlacementList.xml", "实习就业管理服务", app);
        createTemplatePage("SvcPlacementImport", "实习就业导入服务", "drz/page/service/web/placement/SvcPlacementImport.xml", "实习就业导入服务", app);
        createTemplatePage("SvcPracticeList", "实习情况管理服务", "drz/page/service/web/placement/SvcPracticeList.xml", "实习情况管理服务", app);
        createTemplatePage("SvcPracticeExport", "实习情况导出服务", "drz/page/service/web/placement/SvcPracticeExport.xml", "实习情况导出服务", app);
        createTemplatePage("SvcEmploymentList", "就业情况管理服务", "drz/page/service/web/placement/SvcEmploymentList.xml", "就业情况管理服务", app);
        createTemplatePage("SvcEmploymentExport", "就业情况导出服务", "drz/page/service/web/placement/SvcEmploymentExport.xml", "就业情况导出服务", app);

        // service web register 注册
        createTemplatePage("SvcRegisterData", "注册信息服务", "drz/page/service/web/register/SvcRegisterData.xml", "注册信息服务", app);
        createTemplatePage("SvcRegister", "注册服务", "drz/page/service/web/register/SvcRegister.xml", "注册服务", app);

        // service web school 学校
        createTemplatePage("SvcSchoolAndCollege", "获取学校及分院列表服务", "drz/page/service/web/school/SvcSchoolAndCollege.xml", "获取学校及分院列表服务", app);
        createTemplatePage("SvcSchoolCreate", "创建学校服务", "drz/page/service/web/school/SvcSchoolCreate.xml", "创建学校服务", app);
        createTemplatePage("SvcSchoolList", "创建学校服务", "drz/page/service/web/school/SvcSchoolList.xml", "创建学校服务", app);
        createTemplatePage("SvcSchoolInfo", "学校信息服务", "drz/page/service/web/school/SvcSchoolInfo.xml", "学校信息服务", app);
        
        // service web semester 学年服务
        createTemplatePage("SvcSchoolYearAdd", "学年添加服务", "drz/page/service/web/semester/SvcSchoolYearAdd.xml", "学年添加服务", app);
        createTemplatePage("SvcSchoolYearAndSemester", "学年学期获取服务", "drz/page/service/web/semester/SvcSchoolYearAndSemester.xml", "学年学期获取服务", app);
        createTemplatePage("SvcSchoolYearDelete", "学年删除服务", "drz/page/service/web/semester/SvcSchoolYearDelete.xml", "学年删除服务", app);
        createTemplatePage("SvcSchoolYearList", "学年列表请求服务", "drz/page/service/web/semester/SvcSchoolYearList.xml", "学年列表请求服务", app);
        createTemplatePage("SvcSemesterAdd", "学期添加服务", "drz/page/service/web/semester/SvcSemesterAdd.xml", "学期添加服务", app);
        createTemplatePage("SvcSemesterDelete", "学期删除服务", "drz/page/service/web/semester/SvcSemesterDelete.xml", "学期删除服务", app);
        createTemplatePage("SvcSemesterList", "学期列表请求服务", "drz/page/service/web/semester/SvcSemesterList.xml", "学期列表请求服务", app);
        createTemplatePage("SvcSemesterModify", "学期修改服务", "drz/page/service/web/semester/SvcSemesterModify.xml", "学期修改服务", app);
        
        // service web template 文件模板
        createTemplatePage("SvcTemplateList", "下载文件模板列表服务", "drz/page/service/web/template/SvcTemplateList.xml", "下载文件模板列表服务", app);
        createTemplatePage("SvcTemplateAdd", "下载文件模板添加服务", "drz/page/service/web/template/SvcTemplateAdd.xml", "下载文件模板添加服务", app);
        createTemplatePage("SvcTemplateDelete", "下载文件模板删除服务", "drz/page/service/web/template/SvcTemplateDelete.xml", "下载文件模板删除服务", app);
        
        // service web user 用户
        createTemplatePage("SvcUserImport", "用户导入", "drz/page/service/web/user/SvcUserImport.xml", "用户导入", app);
        createTemplatePage("SvcCollegeUserImport", "院系用户导入", "drz/page/service/web/user/SvcCollegeUserImport.xml", "院系用户导入", app);
        createTemplatePage("SvcUserList", "获取用户列表服务", "drz/page/service/web/user/SvcUserList.xml", "获取用户列表服务", app);
        createTemplatePage("SvcUserInfo", "用户信息服务", "drz/page/service/web/user/SvcUserInfo.xml", "用户信息服务", app);

	}

	@Override
	public void clearData() {

	}

}
