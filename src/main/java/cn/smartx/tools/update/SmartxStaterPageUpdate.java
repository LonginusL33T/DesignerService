package cn.smartx.tools.update;

import cn.smartx.core.AAA.model.Menu;
import cn.smartx.core.model.entity.XApp;

public class SmartxStaterPageUpdate extends PageUpdate{
	
	public SmartxStaterPageUpdate(){
		super("starter");
	}
	
	@Override
	public XApp getApp() {
		XApp app = loader.getEntity(310, XApp.class); 
		loader.getByCondition(XApp.class, "code = 'starter'");
		return app;
	}
	
	@Override
	public void createAppMenu() {
		//////////////////////////系统管理
		Menu 一级系统管理 = this.createMenuItem("系统管理", "1", "menu_xitongguanli", "", null, this.getAppCode());
		//系统管理
		Menu 系统管理 = this.createMenuItem("系统管理", "2", "menu_appguanli", "", 一级系统管理, this.getAppCode());
		Menu 用户账号管理 = this.createMenuItem("用户账号管理", "3", "acctUserList", "/smartx/starter/loader.html?pagecode=acctUserList", 系统管理, this.getAppCode());
		Menu 系统角色管理 = this.createMenuItem("系统角色管理", "3", "acctRoleList", "/smartx/starter/loader.html?pagecode=acctRoleList", 系统管理, this.getAppCode());
		Menu 部门管理 = this.createMenuItem("部门管理", "3", "group_guanli", "/smartx/starter/loader.html?pagecode=acctGroupList", 系统管理, this.getAppCode());
		Menu 用户组管理 = this.createMenuItem("用户组管理", "3", "usergroup_guanli", "/smartx/starter/loader.html?pagecode=groupList", 系统管理, this.getAppCode());
		
		//我的个人信息
		Menu 我的个人信息 = this.createMenuItem("我的个人信息", "2", "menu_gerenxinxiguanli", "", 一级系统管理, this.getAppCode());
		Menu 修改密码 = this.createMenuItem("修改密码", "3", "usergroup_guanli", "/smartx/starter/loader.html?pagecode=adminChangePassword", 我的个人信息, this.getAppCode());
		
		//////////////////////////基础数据管理
		Menu 一级基础数据管理 = this.createMenuItem("基础数据管理", "1", "menu_jichushujuguanli", "", null, this.getAppCode());
		Menu 行政区管理 = this.createMenuItem("行政区管理", "2", "menu_appguanli", "", 一级基础数据管理, this.getAppCode());
		
		Menu 省份列表 = this.createMenuItem("省份列表", "3", "provinceList", "/smartx/starter/loader.html?pagecode=provinceList", 行政区管理, this.getAppCode());
		Menu 城市列表 = this.createMenuItem("城市列表", "3", "cityList", "/smartx/starter/loader.html?pagecode=cityList", 行政区管理, this.getAppCode());
		Menu 县区列表 = this.createMenuItem("县区列表", "3", "districtList", "/smartx/starter/loader.html?pagecode=districtList", 行政区管理, this.getAppCode());
		
		//////////////////////////流程管理
		Menu 一级流程管理 = this.createMenuItem("工作流", "1", "menu_gongzuoliu", "", null, this.getAppCode());
		Menu 流程管理 = this.createMenuItem("流程管理", "2", "menu_liuchengguanli", "", 一级流程管理, this.getAppCode());
		
		Menu 流程定义 = this.createMenuItem("流程定义", "3", "wfWorkflowList", "/smartx/starter/loader.html?pagecode=wfWorkflowList", 流程管理, this.getAppCode());
		Menu 流程实例 = this.createMenuItem("流程实例", "3", "wfInstanceList", "/smartx/starter/loader.html?pagecode=wfInstanceList", 流程管理, this.getAppCode());
		Menu 待办任务 = this.createMenuItem("待办任务", "3", "wfTodoTaskList", "/smartx/starter/loader.html?pagecode=wfTodoTaskList", 流程管理, this.getAppCode());
		Menu 已办任务 = this.createMenuItem("已办任务", "3", "wfFinishTaskList", "/smartx/starter/loader.html?pagecode=wfFinishTaskList", 流程管理, this.getAppCode());
		Menu 转派任务 = this.createMenuItem("转派任务", "3", "wfForwordList", "/smartx/starter/loader.html?pagecode=wfForwordList", 流程管理, this.getAppCode());
		Menu 回退任务 = this.createMenuItem("回退任务", "3", "wfBackList", "/smartx/starter/loader.html?pagecode=wfBackList", 流程管理, this.getAppCode());
		
		//////////////////////////测试菜单
		Menu 测试菜单 = this.createMenuItem("测试菜单", "1", "menu_ceshicaidan", "", null, this.getAppCode());
		Menu 基础控件A = this.createMenuItem("基础控件A", "2", "menu_jichukongjianA", "", 测试菜单, this.getAppCode());
		Menu 测试Button控件 = this.createMenuItem("Button", "3", "TestWidgetButton", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetButton", 基础控件A, this.getAppCode());
		Menu 测试IconButton控件 = this.createMenuItem("IconButton", "3", "TestWidgetButton", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetIconButton", 基础控件A, this.getAppCode());
		Menu 测试ImgButton控件 = this.createMenuItem("ImgButton", "3", "TestWidgetImgButton", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetImgButton", 基础控件A, this.getAppCode());
		Menu 测试TextView控件 = this.createMenuItem("TextView", "3", "TestWidgetTextView", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetTextView", 基础控件A, this.getAppCode());
		Menu 测试Label控件 = this.createMenuItem("Label", "3", "TestWidgetLabel", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetLabel", 基础控件A, this.getAppCode());
		Menu 测试Text控件 = this.createMenuItem("Text", "3", "TestWidgetCheckboxGroup", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetText", 基础控件A, this.getAppCode());
		Menu 测试Password控件 = this.createMenuItem("Password", "3", "TestWidgetPassword", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetPassword", 基础控件A, this.getAppCode());
		Menu 测试Textarea控件 = this.createMenuItem("TextArea", "3", "TestWidgetTextArea", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetTextArea", 基础控件A, this.getAppCode());
		Menu 测试EMail控件 = this.createMenuItem("EMail", "3", "TestWidgetEmail", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetEmail", 基础控件A, this.getAppCode());
		Menu 测试NumInput控件 = this.createMenuItem("NumInput", "3", "TestWidgetNumInput", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetNumInput", 基础控件A, this.getAppCode());
		Menu 测试TelText控件 = this.createMenuItem("TelText", "3", "TestWidgetTelText", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetTelText", 基础控件A, this.getAppCode());
		
		Menu 基础控件B = this.createMenuItem("基础控件B", "2", "menu_jichukongjianB", "", 测试菜单, this.getAppCode());
		Menu 测试ImageView控件 = this.createMenuItem("ImageView", "3", "TestWidgetImageView", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetImageView", 基础控件B, this.getAppCode());
		Menu 测试TimeView控件 = this.createMenuItem("TimeView", "3", "TestWidgetTimeView", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetTimeView", 基础控件B, this.getAppCode());
		Menu 测试RadioGroup控件 = this.createMenuItem("RadioGroup", "3", "TestWidgetRadioGroup", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetRadioGroup", 基础控件B, this.getAppCode());
		Menu 测试CheckboxGroup控件 = this.createMenuItem("CheckboxGroup", "3", "TestWidgetCheckboxGroup", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetCheckboxGroup", 基础控件B, this.getAppCode());
		Menu 测试Select控件 = this.createMenuItem("Select", "3", "TestWidgetSelect", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetSelect", 基础控件B, this.getAppCode());
		Menu 测试MultipleSelect控件 = this.createMenuItem("MultipleSelect", "3", "TestWidgetMultiselect", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetMultiselect", 基础控件B, this.getAppCode());
		Menu 测试Resource控件 = this.createMenuItem("Resource", "3", "TestWidgetResource", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetResource", 基础控件B, this.getAppCode());
		Menu 测试TimePicker控件 = this.createMenuItem("TimePicker", "3", "TestWidgetTimePicker", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetTimePicker", 基础控件B, this.getAppCode());
		Menu 测试Slick控件 = this.createMenuItem("Slick", "3", "TestWidgetSlick", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetSlick", 基础控件B, this.getAppCode());
		Menu 测试Timer控件 = this.createMenuItem("Timer", "3", "TestWidgetTimer", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetTimer", 基础控件B, this.getAppCode());
		Menu 测试Progress控件 = this.createMenuItem("Progress", "3", "TestWidgetProgress", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetProgress", 基础控件B, this.getAppCode());
		Menu 测试FileUpload控件 = this.createMenuItem("FileUpload", "3", "TestWidgetFileUpload", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetFileUpload", 基础控件B, this.getAppCode());
		
		Menu 复合控件 = this.createMenuItem("复合控件", "2", "menu_liebiaokongjian", "", 测试菜单, this.getAppCode());
		Menu 测试ListView控件分页 = this.createMenuItem("ListView(分页)", "3", "TestWidgetListView", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetListView", 复合控件, this.getAppCode());
		Menu 测试GridView控件分页 = this.createMenuItem("GridView(分页)", "3", "TestWidgetGridView", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetGridView", 复合控件, this.getAppCode());
		Menu 工作流签批控件 = this.createMenuItem("工作流签批控件", "3", "TestWidgetApprove", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetApprove", 复合控件, this.getAppCode());
		Menu 部门树控件 = this.createMenuItem("部门树控件", "3", "TestWidgetDeptTree", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetDeptTree", 复合控件, this.getAppCode());
		Menu 授权树控件 = this.createMenuItem("授权树控件", "3", "TestWidgetAuthTree", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetAuthTree", 复合控件, this.getAppCode());
		Menu 弹框控件 = this.createMenuItem("弹框控件", "3", "TestWidgetDialog", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetDialog", 复合控件, this.getAppCode());
		Menu 下载控件 = this.createMenuItem("下载控件", "3", "TestWidgetResource", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetResource", 复合控件, this.getAppCode());
		
		
		Menu 图表控件 = this.createMenuItem("图表控件", "2", "menu_tubiaokongjia", "", 测试菜单, this.getAppCode());
		Menu 测试Bar图表 = this.createMenuItem("柱状图", "3", "TestWidgetChartsBar", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetChartsBar", 图表控件, this.getAppCode());
		Menu 测试Line图表 = this.createMenuItem("折线图", "3", "TestWidgetChartsLine", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetChartsLine", 图表控件, this.getAppCode());
		Menu 测试Pie图表 = this.createMenuItem("饼图", "3", "TestWidgetChartsPie", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetChartsPie", 图表控件, this.getAppCode());
		Menu 测试Scatter图表 = this.createMenuItem("散点图", "3", "TestWidgetChartsScatter", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetChartsScatter", 图表控件, this.getAppCode());
		Menu 测试Map图表 = this.createMenuItem("地图", "3", "TestWidgetChartsMap", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetChartsMap", 图表控件, this.getAppCode());
		Menu 测试Graph图表 = this.createMenuItem("关系图", "3", "TestWidgetChartsGraph", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetChartsGraph", 图表控件, this.getAppCode());
		Menu 测试Gauge图表 = this.createMenuItem("仪表盘", "3", "TestWidgetChartsGauge", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetChartsGauge", 图表控件, this.getAppCode());
		
		Menu 容器与布局 = this.createMenuItem("容器与布局", "2", "menu_rongqiyubuju", "", 测试菜单, this.getAppCode());
		Menu Touch布局A = this.createMenuItem("Touch布局A", "3", "TestTouchLayoutA", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestTouchLayoutA", 容器与布局, this.getAppCode());
		Menu NavBar容器 = this.createMenuItem("NavBar容器", "3", "TestWidgetNavBar", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetNavBar", 容器与布局, this.getAppCode());
		Menu TabBar容器 = this.createMenuItem("TabBar容器", "3", "TestWidgetTabBar", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetTabBar", 容器与布局, this.getAppCode());
		Menu 左滑菜单 = this.createMenuItem("左滑菜单", "3", "TestWidgetTabBar", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetLeftPane", 容器与布局, this.getAppCode());
		
		Menu 移动端专用控件 = this.createMenuItem("移动端专用控件", "2", "menu_yidongkongjian", "", 测试菜单, this.getAppCode());
		Menu 测试Tel控件 = this.createMenuItem("Tel", "3", "TestWidgetTel", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestWidgetTel", 移动端专用控件, this.getAppCode());
		
		Menu 应用代码测试 = this.createMenuItem("应用代码测试", "2", "menu_yidongdaima", "", 测试菜单, this.getAppCode());
		Menu 测试获取Data实例 = this.createMenuItem("Data实例", "3", "TestDataQuery", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestDataQuery", 应用代码测试, this.getAppCode());
		Menu 测试表单A = this.createMenuItem("测试表单A", "3", "TestFormA", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestFormA", 应用代码测试, this.getAppCode());
		Menu 测试表单BTabs = this.createMenuItem("测试表单BTabs", "3", "TestFormBTabsLayout", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestFormBTabsLayout", 应用代码测试, this.getAppCode());
		Menu 测试页面异步Job = this.createMenuItem("测试页面异步Job(待完成)", "3", "TestPageJob", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestPageJob", 应用代码测试, this.getAppCode());
		Menu 测试Cassandra = this.createMenuItem("测试Cassandra", "3", "TestCassandraData", "/smartx/starter/starterv2/indexTouch.html?pagecode=TestCassandraData", 应用代码测试, this.getAppCode());
	}

	@Override
	public void createAppTemplate(XApp app) {
		//页面模板
        createTemplatePage("adminLogin", "后台系统登录页面", "starter/page/app/core/user/login.xml", "后台系统登录页面", app);
        createTemplatePage("acctUserList", "用户账户列表页面", "starter/page/app/core/org/acctUserList.xml", "用户账户列表页面", app);
        createTemplatePage("acctUserAdd", "用户账户添加页面", "starter/page/app/core/org/acctUserAdd.xml", "用户账户添加页面", app);
        createTemplatePage("acctUserUpdate", "用户账户修改页面", "starter/page/app/core/org/acctUserUpdate.xml", "用户账户修改页面", app);

        createTemplatePage("acctRoleList", "系统角色管理页面", "starter/page/app/core/org/acctRoleList.xml", "系统角色管理页面", app);
        createTemplatePage("acctRoleUpdate", "系统角色更新页面", "starter/page/app/core/org/acctRoleUpdate.xml", "系统角色更新页面", app);
        createTemplatePage("acctRoleAdd", "系统角色增加页面", "starter/page/app/core/org/acctRoleAdd.xml", "系统角色增加页面", app);
        
        createTemplatePage("acctGroupList", "部门管理页面", "starter/page/app/core/org/acctGroupList.xml", "部门管理页面", app);
        createTemplatePage("acctGroupUpdate", "部门更新页面", "starter/page/app/core/org/acctGroupUpdate.xml", "部门更新页面", app);
        createTemplatePage("acctGroupAdd", "部门增加页面", "starter/page/app/core/org/acctGroupAdd.xml", "部门增加页面", app);
        createTemplatePage("acctDeptPropAdd", "部门属性增加页面", "starter/page/app/core/org/acctDeptPropAdd.xml", "部门属性增加页面", app);
        createTemplatePage("acctDeptPropDetail", "部门属性显示页面", "starter/page/app/core/org/acctDeptPropDetail.xml", "部门属性显示页面", app);
        createTemplatePage("acctDeptPropUpdate", "部门属性更新页面", "starter/page/app/core/org/acctDeptPropUpdate.xml", "部门属性更新页面", app);

        createTemplatePage("groupList", "用户组管理页面", "starter/page/app/core/org/groupList.xml", "用户组管理页面", app);
        createTemplatePage("groupUpdate", "用户组更新页面", "starter/page/app/core/org/groupUpdate.xml", "用户组更新页面", app);
        createTemplatePage("groupAdd", "用户组增加页面", "starter/page/app/core/org/groupAdd.xml", "用户组增加页面", app);

        createTemplatePage("adminChangePassword", "修改个人密码页面", "starter/page/app/core/user/adminChangePassword.xml", "修改个人密码页面", app);

        createTemplatePage("provinceList", "省份列表页面", "starter/page/app/core/common/provinceList.xml", "省份列表页面", app);
        createTemplatePage("cityList", "城市列表页面", "starter/page/app/core/common/cityList.xml", "城市列表页面", app);
        createTemplatePage("districtList", "区县列表页面", "starter/page/app/core/common/districtList.xml", "区县列表页面", app);
        
        createTemplatePage("wfWorkflowList", "流程定义列表页面", "starter/page/app/core/workflow/wfWorkflowList.xml", "流程定义列表页面", app);
        createTemplatePage("wfWorkflowUpdate", "流程定义更新页面", "starter/page/app/core/workflow/wfWorkflowUpdate.xml", "流程定义更新页面", app);
        createTemplatePage("wfWorkflowAdd", "流程定义新增页面", "starter/page/app/core/workflow/wfWorkflowAdd.xml", "流程定义新增页面", app);
        createTemplatePage("wfRoleMappingList", "流程角色配置页面", "starter/page/app/core/workflow/wfRoleMappingList.xml", "流程角色配置页面", app);
        createTemplatePage("wfInstanceList", "流程实例管理页面", "starter/page/app/core/workflow/wfInstanceList.xml", "流程实例管理页面", app);
        createTemplatePage("wfTaskList", "流程示例任务管理页面", "starter/page/app/core/workflow/wfTaskList.xml", "流程示例任务管理页面", app);
        createTemplatePage("wfCreateInstance", "创建流程实例", "starter/page/app/core/workflow/wfCreateInstance.xml", "创建流程实例", app);
        createTemplatePage("wfOpenTask", "流程任务执行表单", "starter/page/app/core/workflow/wfOpenTask.xml", "流程任务执行表单", app);
        createTemplatePage("wfTodoTaskList", "待办任务表单", "starter/page/app/core/workflow/wfTodoTaskList.xml", "待办任务表单", app);
        createTemplatePage("wfFinishTaskList", "已完成任务表单", "starter/page/app/core/workflow/wfFinishTaskList.xml", "已完成任务表单", app);
        createTemplatePage("wfForwordList", "转派任务表单", "starter/page/app/core/workflow/wfForwordList.xml", "转派任务表单", app);
        createTemplatePage("wfBackList", "回退任务表单", "starter/page/app/core/workflow/wfBackList.xml", "回退任务表单", app);
                
        //服务模板
        createTemplatePage("serviceUserList", "用户账户列表服务", "starter/page/service/core/user/serviceUserList.xml", "用户账户列表服务", app);
        createTemplatePage("IMGetUserToken", "IM获取用户Token", "starter/page/service/im/IMGetUserToken.xml", "IM获取用户Token", app);
        createTemplatePage("IMCreateGroup", "IM创建讨论组", "starter/page/service/im/IMCreateGroup.xml", "IM创建讨论组", app);
        createTemplatePage("IMQueryGroup", "IM查询讨论组成员", "starter/page/service/im/IMQueryGroup.xml", "IM查询讨论组成员", app);
        
        //测试用模板
        createTemplatePage("TestWidgetButton", "测试按钮控件", "starter/page/app/test/widgets/TestWidgetButton.xml", "测试按钮控件", app);
        createTemplatePage("TestWidgetIconButton", "测试Icon按钮控件", "starter/page/app/test/widgets/TestWidgetIconButton.xml", "测试按钮控件", app);
        createTemplatePage("TestWidgetTextView", "测试TextView控件", "starter/page/app/test/widgets/TestWidgetTextView.xml", "测试TextView控件", app);
        createTemplatePage("TestWidgetLabel", "测试Label控件", "starter/page/app/test/widgets/TestWidgetLabel.xml", "测试Label控件", app);
        createTemplatePage("TestWidgetPassword", "测试Password控件", "starter/page/app/test/widgets/TestWidgetPassword.xml", "测试Password控件", app);
        createTemplatePage("TestWidgetRadioGroup", "测试RadioGroup控件", "starter/page/app/test/widgets/TestWidgetRadioGroup.xml", "测试RadioGroup控件", app);
        createTemplatePage("TestWidgetCheckboxGroup", "测试CheckboxGroup控件", "starter/page/app/test/widgets/TestWidgetCheckboxGroup.xml", "测试CheckboxGroup控件", app);
        createTemplatePage("TestWidgetText", "测试Text控件", "starter/page/app/test/widgets/TestWidgetText.xml", "测试Text控件", app);
        createTemplatePage("TestWidgetSelect", "测试Select控件", "starter/page/app/test/widgets/TestWidgetSelect.xml", "测试Select控件", app);
        createTemplatePage("TestWidgetTextArea", "测试TextArea控件", "starter/page/app/test/widgets/TestWidgetTextArea.xml", "测试TextArea控件", app);
        createTemplatePage("TestWidgetEmail", "测试Email控件", "starter/page/app/test/widgets/TestWidgetEmail.xml", "测试Email控件", app);
        createTemplatePage("TestWidgetMultiselect", "测试MultiSelect控件", "starter/page/app/test/widgets/TestWidgetMultiselect.xml", "测试MultiSelect控件", app);
        createTemplatePage("TestWidgetNumInput", "测试NumInput控件", "starter/page/app/test/widgets/TestWidgetNumInput.xml", "测试NumInput控件", app);
        createTemplatePage("TestWidgetTelText", "测试TelText控件", "starter/page/app/test/widgets/TestWidgetTelText.xml", "测试TelText控件", app);
        createTemplatePage("TestWidgetTimeView", "测试TimeView控件", "starter/page/app/test/widgets/TestWidgetTimeView.xml", "测试TimeView控件", app);
        createTemplatePage("TestWidgetSlick", "测试Slick控件", "starter/page/app/test/widgets/TestWidgetSlick.xml", "测试Slick控件", app);
        createTemplatePage("TestWidgetImgButton", "测试ImgButton控件", "starter/page/app/test/widgets/TestWidgetImgButton.xml", "测试ImgButton控件", app);
        createTemplatePage("TestWidgetImageView", "测试ImageView控件", "starter/page/app/test/widgets/TestWidgetImageView.xml", "测试ImageView控件", app);
        createTemplatePage("TestWidgetTel", "测试Tel控件", "starter/page/app/test/widgets/TestWidgetTel.xml", "测试Tel控件", app);
        createTemplatePage("TestWidgetResource", "测试Resource控件", "starter/page/app/test/widgets/TestWidgetResource.xml", "测试Resource控件", app);
        createTemplatePage("TestWidgetTimePicker", "测试TimePicker控件", "starter/page/app/test/widgets/TestWidgetTimePicker.xml", "测试TimePicker控件", app);
        createTemplatePage("TestWidgetListView", "测试ListView控件", "starter/page/app/test/widgets/TestWidgetListView.xml", "测试ListView控件", app);
        createTemplatePage("TestWidgetGridView", "测试GridView控件", "starter/page/app/test/widgets/TestWidgetGridView.xml", "测试GridView控件", app);
        createTemplatePage("TestWidgetDialog", "测试Dialog控件", "starter/page/app/test/widgets/TestWidgetDialog.xml", "测试Dialog控件", app);
        createTemplatePage("TestWidgetResource", "测试Resource控件", "starter/page/app/test/widgets/TestWidgetResource.xml", "测试Resource控件", app);
        
        createTemplatePage("TestDataQuery", "测试Data实例", "starter/page/app/test/app/TestDataQuery.xml", "测试Data实例", app);
        createTemplatePage("TestTouchLayoutA", "Touch布局A", "starter/page/app/test/app/TestTouchLayoutA.xml", "Touch布局A", app);
        createTemplatePage("TestFormA", "测试表单A", "starter/page/app/test/form/TestFormA.xml", "测试表单A", app);
        createTemplatePage("TestFormBTabsLayout", "测试表单BTabs", "starter/page/app/test/form/TestFormBTabsLayout.xml", "测试表单BTabs", app);
        createTemplatePage("TestWidgetApprove", "工作流签批控件", "starter/page/app/test/widgets/TestWidgetApprove.xml", "工作流签批控件", app);
        createTemplatePage("TestWidgetTimer", "Timer控件", "starter/page/app/test/widgets/TestWidgetTimer.xml", "Timer控件", app);
        createTemplatePage("TestWidgetProgress", "Progress控件", "starter/page/app/test/widgets/TestWidgetProgress.xml", "Progress控件", app);
        createTemplatePage("TestWidgetFileUpload", "FileUpload控件", "starter/page/app/test/widgets/TestWidgetFileUpload.xml", "FileUpload控件", app);
        createTemplatePage("TestWidgetNavBar", "NavBar控件", "starter/page/app/test/container/TestWidgetNavBar.xml", "NavBar控件", app);
        createTemplatePage("TestWidgetTabBar", "TabBar控件", "starter/page/app/test/container/TestWidgetTabBar.xml", "TabBar控件", app);
        
        createTemplatePage("TestWidgetDeptTree", "DeptTree控件", "starter/page/app/test/widgets/TestWidgetDeptTree.xml", "DeptTree控件", app);
        createTemplatePage("TestWidgetAuthTree", "AuthTree控件", "starter/page/app/test/widgets/TestWidgetAuthTree.xml", "AuthTree控件", app);
        createTemplatePage("TestWidgetLeftPane", "左滑菜单", "starter/page/app/test/container/TestWidgetLeftPane.xml", "左滑菜单控件", app);
        
        createTemplatePage("TestCassandraData", "测试Cassandra数据", "starter/page/app/test/app/TestCassandraData.xml", "测试Cassandra数据", app);

        createTemplatePage("TestWidgetChartsBar", "测试图表控件-柱状图", "starter/page/app/test/charts/TestWidgetChartsBar.xml", "测试图表控件-柱状图", app);
        createTemplatePage("TestWidgetChartsLine", "测试图表控件-折线图", "starter/page/app/test/charts/TestWidgetChartsLine.xml", "测试图表控件-折线图", app);
        createTemplatePage("TestWidgetChartsPie", "测试图表控件-饼图", "starter/page/app/test/charts/TestWidgetChartsPie.xml", "测试图表控件-饼图", app);
        createTemplatePage("TestWidgetChartsScatter", "测试图表控件-散点图", "starter/page/app/test/charts/TestWidgetChartsScatter.xml", "测试图表控件-散点图", app);
        createTemplatePage("TestWidgetChartsMap", "测试图表控件-地图", "starter/page/app/test/charts/TestWidgetChartsMap.xml", "测试图表控件-地图", app);
        createTemplatePage("TestWidgetChartsGraph", "测试图表控件-关系图", "starter/page/app/test/charts/TestWidgetChartsGraph.xml", "测试图表控件-关系图", app);
        createTemplatePage("TestWidgetChartsGauge", "测试图表控件-仪表盘", "starter/page/app/test/charts/TestWidgetChartsGauge.xml", "测试图表控件-仪表盘", app);

	}

	@Override
	public void clearData() {

	}

}
