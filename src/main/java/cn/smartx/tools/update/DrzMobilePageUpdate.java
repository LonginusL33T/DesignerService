package cn.smartx.tools.update;

import cn.smartx.core.AAA.model.Menu;
import cn.smartx.core.model.entity.XApp;

/** 
 * @author Bona
 * @time   2017年6月21日 下午4:52:28 
 */

public class DrzMobilePageUpdate extends PageUpdate{

	public DrzMobilePageUpdate(){
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

	}

	@Override
	public void createAppTemplate(XApp app) {

		// service mobile
        // service mobile course
        createTemplatePage("CellCourseList", "课程列表", "drz/page/service/mobile/course/CellCourseList.xml", "课程列表", app);
        createTemplatePage("CellCourseMain", "获取单节课程信息", "drz/page/service/mobile/course/CellCourseMain.xml", "获取单节课程信息", app);
        createTemplatePage("CellGetCourseInfo", "获取课程信息", "drz/page/service/mobile/course/CellGetCourseInfo.xml", "获取课程信息", app);
        createTemplatePage("CellGetCourseTimes", "获取上课时间列表", "drz/page/service/mobile/course/CellGetCourseTimes.xml", "获取上课时间列表", app);
        createTemplatePage("CellMotifyCourseInfo", "修改课程信息", "drz/page/service/mobile/course/CellMotifyCourseInfo.xml", "修改课程信息", app);
        createTemplatePage("CellMotifyCourseTime", "编辑上课时间/添加上课时间", "drz/page/service/mobile/course/CellMotifyCourseTime.xml", "编辑上课时间/添加上课时间", app);

		// service mobile group
		// service mobile group student
		createTemplatePage("CellStudentGroupCreate", "学生创建分组", "drz/page/service/mobile/group/student/CellStudentGroupCreate.xml", "学生创建分组", app);
		createTemplatePage("CellStudentGroupDetail", "分组详情", "drz/page/service/mobile/group/student/CellStudentGroupDetail.xml", "分组详情", app);
		createTemplatePage("CellStudentGroupDismiss", "解散分组", "drz/page/service/mobile/group/student/CellStudentGroupDismiss.xml", "解散分组", app);
		createTemplatePage("CellStudentGroupJoin", "加入分组", "drz/page/service/mobile/group/student/CellStudentGroupJoin.xml", "加入分组", app);
		createTemplatePage("CellStudentGroupKickOutMember", "踢出分组成员", "drz/page/service/mobile/group/student/CellStudentGroupKickOutMember.xml", "踢出分组成员", app);
		createTemplatePage("CellStudentGroupList", "标签下分组列表", "drz/page/service/mobile/group/student/CellStudentGroupList.xml", "标签下分组列表", app);
		createTemplatePage("CellStudentGroupModifyInfo", "修改分组信息", "drz/page/service/mobile/group/student/CellStudentGroupModifyInfo.xml", "修改分组信息", app);
		createTemplatePage("CellStudentGroupQuit", "退出分组", "drz/page/service/mobile/group/student/CellStudentGroupQuit.xml", "退出分组", app);
		createTemplatePage("CellStudentIsInGroupOrTimeOver", "检查是否已加入某标签下的分组或已超出分组时间", "drz/page/service/mobile/group/student/CellStudentIsInGroupOrTimeOver.xml", "检查是否已加入某标签下的分组或已超出分组时间", app);
		createTemplatePage("CellStudentLabelList", "课程标签列表", "drz/page/service/mobile/group/student/CellStudentLabelList.xml", "课程标签列表", app);
		
		// service mobile group teacher
		createTemplatePage("CellTeacherCreateGroup", "教师创建分组", "drz/page/service/mobile/group/teacher/CellTeacherCreateGroup.xml", "教师创建分组", app);
		createTemplatePage("CellTeacherCreateGroupMessage", "教师分组前信息获取", "drz/page/service/mobile/group/teacher/CellTeacherCreateGroupMessage.xml", "教师分组前信息获取", app);
		createTemplatePage("CellTeacherGroupDetail", "教师分组信息查看", "drz/page/service/mobile/group/teacher/CellTeacherGroupDetail.xml", "教师分组信息查看", app);
		createTemplatePage("CellTeacherGroupDissolve", "教师解散分组", "drz/page/service/mobile/group/teacher/CellTeacherGroupDissolve.xml", "教师解散分组", app);
		createTemplatePage("CellTeacherGroupList", "教师分组列表服务", "drz/page/service/mobile/group/teacher/CellTeacherGroupList.xml", "教师分组列表服务", app);
		createTemplatePage("CellTeacherLabelAdd", "教师分组标签添加服务", "drz/page/service/mobile/group/teacher/CellTeacherLabelAdd.xml", "教师分组标签添加服务", app);
		createTemplatePage("CellTeacherLabelDelete", "教师分组标签删除服务", "drz/page/service/mobile/group/teacher/CellTeacherLabelDelete.xml", "教师分组标签删除服务", app);
		createTemplatePage("CellTeacherLabelList", "教师分组标签列表服务", "drz/page/service/mobile/group/teacher/CellTeacherLabelList.xml", "教师分组标签列表服务", app);
		createTemplatePage("CellTeacherLabelMessage", "分组主题信息", "drz/page/service/mobile/group/teacher/CellTeacherLabelMessage.xml", "分组主题信息", app);
		createTemplatePage("CellTeacherLabelModify", "修改分组主题信息", "drz/page/service/mobile/group/teacher/CellTeacherLabelModify.xml", "修改分组主题信息", app);
		createTemplatePage("CellTeacherLabelStop", "结束分组", "drz/page/service/mobile/group/teacher/CellTeacherLabelStop.xml", "结束分组", app);
		
		// service mobile login
        createTemplatePage("CellLogin", "手机端登录", "drz/page/service/mobile/login/CellLogin.xml", "手机端登录", app);
        
        // service mobile moments
        createTemplatePage("CellMomentsCourseList", "动态圈课程名单", "drz/page/service/mobile/moments/CellMomentsCourseList.xml", "动态圈课程名单", app);
        createTemplatePage("CellMomentsCourseMemberList", "动态圈学生名单", "drz/page/service/mobile/moments/CellMomentsCourseMemberList.xml", "动态圈学生名单", app);
        createTemplatePage("CellMomentsCreate", "动态创建服务", "drz/page/service/mobile/moments/CellMomentsCreate.xml", "动态创建服务", app);
        createTemplatePage("CellMomentsFetch", "动态获取", "drz/page/service/mobile/moments/CellMomentsFetch.xml", "动态获取", app);
        createTemplatePage("CellMomentsGetItem", "获取单条动态", "drz/page/service/mobile/moments/CellMomentsGetItem.xml", "获取单条动态", app);
        createTemplatePage("CellMomentsNewestCount", "动态圈最新条目计数", "drz/page/service/mobile/moments/CellMomentsNewestCount.xml", "动态圈最新条目计数", app);
        createTemplatePage("CellMomentsRecall", "动态圈撤回", "drz/page/service/mobile/moments/CellMomentsRecall.xml", "动态圈撤回", app);
        
        // service mobile notice
        createTemplatePage("CellNoticeCreate", "公告创建", "drz/page/service/mobile/notice/CellNoticeCreate.xml", "公告创建", app);
        createTemplatePage("CellNoticeList", "公告列表", "drz/page/service/mobile/notice/CellNoticeList.xml", "公告列表", app);
        
        // service mobile password 密码
        createTemplatePage("CellSMSCodeSend", "发送短信验证码", "drz/page/service/mobile/password/CellSMSCodeSend.xml", "发送短信验证码", app);
        createTemplatePage("CellSMSValidation", "短信验证", "drz/page/service/mobile/password/CellSMSValidation.xml", "短信验证", app);
        
        // service mobile performance 成绩中心
        createTemplatePage("CellPerformanceGradeEdit", "成绩中心成绩修改服务", "drz/page/service/mobile/performance/CellPerformanceGradeEdit.xml", "成绩中心成绩修改服务", app);
        createTemplatePage("CellPerformanceList", "成绩中心列表", "drz/page/service/mobile/performance/CellPerformanceList.xml", "成绩中心列表", app);
        createTemplatePage("CellPerformancePersonalList", "成绩中心学生个人成绩列表", "drz/page/service/mobile/performance/CellPerformancePersonalList.xml", "成绩中心学生个人成绩列表", app);
        createTemplatePage("CellPerformanceStuGrades", "成绩中心学生成绩列表请求服务", "drz/page/service/mobile/performance/CellPerformanceStuGrades.xml", "成绩中心学生成绩列表请求服务", app);
        
        // service mobile random 随机抽人
        createTemplatePage("CellRandomChoice", "随机抽人", "drz/page/service/mobile/random/CellRandomChoice.xml", "随机抽人", app);
        
        // service mobile school 学校
        createTemplatePage("CellSchoolList", "学校列表", "drz/page/service/mobile/school/CellSchoolList.xml", "学校列表", app);

        // service mobile user 用户
        createTemplatePage("CellGetUserInfo", "获取单个用户信息", "drz/page/service/mobile/user/CellGetUserInfo.xml", "获取单个用户信息", app);

	}

	@Override
	public void clearData() {

	}

}
