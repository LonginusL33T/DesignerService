package cn.smartx.tools;

import java.util.Date;
import cn.smartx.core.model.entity.XApp;

public class LayoutGeneratorInstaller extends AppInstaller {

	public LayoutGeneratorInstaller() {
		super("layoutGenerator");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createAppMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public XApp createApp() {
		log.warn("新建LayoutGenerator测试");
		XApp thisApp=loader.ceateNew(XApp.class);
		thisApp.setCode(this.getAppCode());
		thisApp.setInitPage("none");
		thisApp.setLastModifyDate(new Date());
		thisApp.setLastModifyUser("administrator");
		thisApp.setName("布局测试");
		loader.commit();
		return thisApp;
	}

	@Override
	public void createAppTemplate(XApp app) {
		// TODO Auto-generated method stub
		createTemplatePage("testFlowlayoutGenerator","流式布局测试","smartx/page/test/testFlowlayoutGenerator.xml","流式布局",app);
		createTemplatePage("testGridlayoutGenerator","网格布局测试","smartx/page/test/testGridlayoutGenerator.xml","网格布局",app);
		
	}

	@Override
	public void createAppTask(XApp app) {
		log.warn("no App Task installation configuration.");
		
	}

	@Override
	public void configAAABasicData() {
		log.warn("create operation list.....");

	}

	@Override
	public void createRoleAndUser() {
	log.warn("no message left!");
		
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
