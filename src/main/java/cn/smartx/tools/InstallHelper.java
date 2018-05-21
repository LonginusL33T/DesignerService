package cn.smartx.tools;

import java.util.Date;

import cn.smartx.core.ds.database.DataBaseLoader;
import cn.smartx.core.model.entity.WfWorkflow;
import cn.smartx.core.model.entity.XApp;
import cn.smartx.core.model.entity.XPage;

/**
 * 插入数据的帮助函数
 * @author pengrobin
 * 2014年11月18日
 */
public class InstallHelper {
    public static WfWorkflow createWorkflowDefine(String appCode, String code, String name, String pagetype, String datapageurl, String templatefile, DataBaseLoader loader){
        WfWorkflow workflow = loader.ceateNew(WfWorkflow.class);
        workflow.setAdmin("");
        workflow.setAdmindept("");
        workflow.setAppcode(appCode);
        workflow.setBiztype("");
        workflow.setCode(code);
        workflow.setDatapagetype(pagetype);
        workflow.setDatapageurl(datapageurl);
        workflow.setMemo("");
        workflow.setName(name);
        workflow.setSpecification("");
        workflow.setTemplate(templatefile);
        workflow.setValidated("true");
        
        loader.commit();
        return workflow;
    }
    
    public static XPage createTemplatePage(String code, String name, String templatefile, String title, XApp app, DataBaseLoader loader){
        XPage page = loader.ceateNew(XPage.class);
        page.setToXApp(app);
        page.setCode(code);
        page.setLastModifyDate(new Date());
        page.setLastModifyUser("installer");
        page.setName(name);
        page.setPageTemplate(templatefile);
        page.setTitle(title);
        loader.commit();
        
        return page;
    }

}
