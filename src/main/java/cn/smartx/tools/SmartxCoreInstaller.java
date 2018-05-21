package cn.smartx.tools;

import java.util.Date;
import java.util.List;

import cn.smartx.core.AAA.SmartxSecurityManager;
import cn.smartx.core.AAA.model.Group;
import cn.smartx.core.AAA.model.User;
import cn.smartx.core.AAA.service.UserService;
import cn.smartx.core.common.SmartxConstants;
import cn.smartx.core.model.entity.AcctGroup;
import cn.smartx.core.model.entity.AcctGroupRole;
import cn.smartx.core.model.entity.AcctMenu;
import cn.smartx.core.model.entity.AcctOperation;
import cn.smartx.core.model.entity.AcctPermission;
import cn.smartx.core.model.entity.AcctResource;
import cn.smartx.core.model.entity.AcctRole;
import cn.smartx.core.model.entity.AcctRolePermission;
import cn.smartx.core.model.entity.AcctUser;
import cn.smartx.core.model.entity.AcctUserGroup;
import cn.smartx.core.model.entity.AcctUserProp;
import cn.smartx.core.model.entity.AcctUserRole;
import cn.smartx.core.model.entity.WfApproveData;
import cn.smartx.core.model.entity.WfInstance;
import cn.smartx.core.model.entity.WfRole;
import cn.smartx.core.model.entity.WfRoleMapping;
import cn.smartx.core.model.entity.WfTask;
import cn.smartx.core.model.entity.WfWorkflow;
import cn.smartx.core.model.entity.XApp;
import cn.smartx.core.model.entity.XDocbase;
import cn.smartx.core.model.entity.XDocitem;
import cn.smartx.core.model.entity.XPage;
import cn.smartx.core.model.entity.XTask;

public class SmartxCoreInstaller extends AppInstaller {

    public SmartxCoreInstaller() {
        super("smartx");
    }

    @Override
    public void createAppMenu() {
        log.warn("no menu installation configuration.");
        return;
    }

    @Override
    public XApp createApp() {
        log.warn("start create smartx system data.....");
        XApp smartxApp = loader.ceateNew(XApp.class);
        smartxApp.setCode("smartx");
        smartxApp.setInitPage("none");
        smartxApp.setLastModifyDate(new Date());
        smartxApp.setLastModifyUser("smartxInstaller");
        smartxApp.setName("smartx核心应用");

        loader.commit();
        return smartxApp;
    }

    @Override
    public void createAppTemplate(XApp app) {
        // 工作流模板
        createTemplatePage("wfCreateInstance", "创建流程实例", "smartx/page/workflow/wfCreateInstance.xml", "创建流程实例", app);
        createTemplatePage("wfOpenTask", "流程任务执行表单", "smartx/page/workflow/wfOpenTask.xml", "流程任务执行表单", app);
        createTemplatePage("applist", "应用列表", "smartx/page/main/applist.xml", "应用列表", app);
        createTemplatePage("updateapp", "修改应用属性", "smartx/page/main/updateapp.xml", "修改应用属性", app);
     
        //测试数据
        createTemplatePage("testDownloadFile", "测试下载文件", "smartx/page/test/testDownloadFile.xml", "测试下载文件", app);
        createTemplatePage("testUploadFile", "测试上传文件", "smartx/page/test/testUploadFile.xml", "测试上传文件", app);
        createTemplatePage("testAuthorizedWidget", "测试控件授权", "smartx/page/test/testAuthorizedWidget.xml", "测试控件授权", app);
        createTemplatePage("testAuthorizedPageSeq", "测试页面授权", "smartx/page/test/testAuthorizedPageSeq.xml", "测试页面授权", app);
        createTemplatePage("testSmartXLogout", "测试登出", "smartx/page/test/testSmartXLogout.xml", "测试登出", app);
        createTemplatePage("testAuthorizationFailed", "测试认证失败", "smartx/page/test/testAuthorizationFailed.xml", "测试认证失败",
                app);
        createTemplatePage("testNoAuthorization", "测试未授权", "smartx/page/test/testNoAuthorization.xml", "测试未授权", app);
        createTemplatePage("testSmartXSession", "测试session", "smartx/page/test/testSmartXSession.xml", "测试session", app);
        createTemplatePage("testSmartXSessionMultiThread", "测试多线程Session", "smartx/page/test/testSmartXSessionMultiThread.xml",
                "测试多线程Session", app);
        createTemplatePage("testMultiThreadAccessTomcat", "测试多线程访问", "smartx/page/test/testMultiThreadAccessTomcat.xml",
                "测试多线程访问", app);

        createTemplatePage("testWorkflowChart", "流程图控件测试页面", "smartx/page/test/testWorkflowChart.xml", "流程图控件测试页面", app);
        createTemplatePage("testAuthTree", "权限树控件测试页面", "smartx/page/test/testAuthTree.xml", "权限树控件测试页面", app);
        createTemplatePage("testMImgPicker", "移动端图片选择控件测试页面", "smartx/page/test/testMImgPicker.xml", "移动端图片选择控件测试页面", app);
        createTemplatePage("testApprove", "签批控件测试", "smartx/page/test/testApprove.xml", "签批控件测试", app);
        createTemplatePage("testDeptTree", "部门树控件测试", "smartx/page/test/testDeptTree.xml", "部门树控件测试", app);
        createTemplatePage("testPageInclude", "页面Include测试", "smartx/page/test/testPageInclude.xml", "页面Include测试", app);
        createTemplatePage("testPersistBinding", "测试存储框架(双向绑定)", "smartx/page/test/testPersistBinding.xml", "测试存储框架(双向绑定)", app);
        createTemplatePage("testTabs", "测试标签页", "smartx/page/test/testTabs.xml", "测试标签页", app);
        createTemplatePage("testExportExcel", "测试导出excel", "smartx/page/test/testExportExcel.xml", "测试导出excel", app);
        createTemplatePage("IndexOfTestPages", "测试页面目录", "smartx/page/test/IndexOfTestPages.xml", "测试页面目录", app);
        createTemplatePage("testCountDownButton", "倒计时按钮测试页面", "smartx/page/test/testCountDownButton.xml", "倒计时按钮测试页面", app);
        createTemplatePage("testCMSContentCachePage", "缓存内容页面", "smartx/page/test/testCMSContentCachePage.xml", "缓存内容页面", app);
        createTemplatePage("testCMSContentCachePageUpdate", "更新缓存内容页面", "smartx/page/test/testCMSContentCachePageUpdate.xml", "更新缓存内容页面", app);
        createTemplatePage("testResourcei18n", "多语言支持", "smartx/page/test/testResourcei18n.xml", "多语言支持", app);
        createTemplatePage("testResourcei18nLayout", "多语言支持-布局文件", "smartx/page/test/testResourcei18nLayout.xml", "多语言支持-布局文件", app);
        createTemplatePage("testGallery", "图库控件测试页面", "smartx/page/test/testGallery.xml", "图库控件测试页面", app);
        
        createTemplatePage("testSmartXLogin", "测试SmartxLogin", "smartx/page/test/testSmartXLogin.xml", "测试SmartxLogin", app);
        createTemplatePage("pathleaf", "测试页节点", "smartx/page/main/pathleaf.xml", "测试页节点", app);
        createTemplatePage("pathbranch", "测试分支节点", "smartx/page/main/pathbranch.xml", "测试分支节点", app);
        createTemplatePage("pathroot", "测试根节点", "smartx/page/main/pathroot.xml", "测试根节点", app);
        createTemplatePage("test", "临时测试", "smartx/page/main/test.xml", "临时测试", app);
    }

    @Override
    public void createAppTask(XApp app) {
        XTask task = loader.ceateNew(XTask.class);
        task.setToXApp(app);
        task.setCode("repeat_by_interval_task");
        task.setName("测试定时调度任务");
        task.setTaskTemplate("smartx/task/repeat_by_interval_task.xml");

        XTask task2 = loader.ceateNew(XTask.class);
        task2.setToXApp(app);
        task2.setCode("repeat_by_everyday_at_task");
        task2.setName("测试每天定时调度任务");
        task2.setTaskTemplate("smartx/task/repeat_by_everyday_at_task.xml");

        loader.commit();
    }

    @Override
    public void clearData() {
        log.warn("start clear system x data.....");
        loader.deleteAll(loader.getAll(XTask.class));
        loader.deleteAll(loader.getAll(XPage.class));
        loader.deleteAll(loader.getAll(XApp.class));
        loader.deleteAll(loader.getAll(XDocitem.class));
        loader.deleteAll(loader.getAll(XDocbase.class));
        loader.commit();
        log.warn("clear system x data.....done");

        log.warn("start clear system acct data.....");
        loader.deleteAll(loader.getAll(AcctRolePermission.class));
        loader.deleteAll(loader.getAll(AcctUserRole.class));
        loader.deleteAll(loader.getAll(AcctGroupRole.class));
        loader.deleteAll(loader.getAll(AcctRole.class));
        loader.deleteAll(loader.getAll(AcctPermission.class));
        loader.deleteAll(loader.getAll(AcctOperation.class));
        loader.deleteAll(loader.getAll(AcctResource.class));
        loader.deleteAll(loader.getAll(AcctUserGroup.class));
        loader.deleteAll(loader.getAll(AcctGroup.class));
        //注释掉使之不删除用户表的内容
        loader.deleteAll(loader.getAll(AcctUserProp.class));
        loader.deleteAll(loader.getAll(AcctUser.class));
        List<AcctMenu> lstMenu;
        for (int i = 3; i > 0; i--) {
            lstMenu = loader.getByCondition(AcctMenu.class, "level = '" + i + "'");
            for (AcctMenu m : lstMenu) {
                loader.delete(m);
            }
        }
        loader.commit();
        log.warn("clear system acct data.....done");

        log.warn("start clear system workflow data.....");
        loader.deleteAll(loader.getAll(WfRoleMapping.class));
        loader.deleteAll(loader.getAll(WfApproveData.class));
        loader.deleteAll(loader.getAll(WfTask.class));
        loader.deleteAll(loader.getAll(WfRole.class));
        loader.deleteAll(loader.getAll(WfInstance.class));
        loader.deleteAll(loader.getAll(WfWorkflow.class));
        loader.commit();
        log.warn("clear system workflow data.....done");
    }

    @Override
    public void configAAABasicData() {
        log.warn("no AAA Basic Data installation configuration.");
    }

    @Override
    public void createRoleAndUser() {
        UserService us = SmartxSecurityManager.getInstance().getUserService(this.getAppCode());

        Group group = new Group();
        group.setAppcode(this.getAppCode());
        group.setGroupcode("D0001");
        group.setName("IT管理");
        group.setGrouptype(SmartxConstants.GROUPTYPE_DEPT);
        group = us.createUserGroup(group);
        
        log.warn("create administration user.....");
        User admin = new User();
        admin.setLoginname(SmartxConstants.SEC_ADMINISTRATOR);
        admin.setName(SmartxConstants.SEC_ADMINISTRATOR_NAME);
        admin.setPassword(SmartxConstants.SEC_ADMINISTRATOR_PWD);
        admin.setAppcode(this.getAppCode());
        admin = us.createUser(admin);
        
        us.addUserToGroup(admin, group);
        log.warn("create administration user.....done");
    }

    @Override
    public void createWorkflow() {
    }

}
