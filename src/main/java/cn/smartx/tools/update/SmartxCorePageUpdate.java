package cn.smartx.tools.update;

import cn.smartx.core.model.entity.AcctMenu;
import cn.smartx.core.model.entity.XApp;
import cn.smartx.core.model.entity.XPage;

public class SmartxCorePageUpdate extends PageUpdate {

	public SmartxCorePageUpdate() {
		super("smartx");
	}

	@Override
	public void clearData() {
		loader.deleteAll(loader.getAll(XPage.class));
		loader.deleteAll(loader.getAll(AcctMenu.class));
		loader.commit();
	}

	@Override
	public XApp getApp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAppMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAppTemplate(XApp app) {
		// TODO Auto-generated method stub
		
	}

}
