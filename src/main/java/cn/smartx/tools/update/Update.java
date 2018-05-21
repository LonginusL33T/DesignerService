package cn.smartx.tools.update;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.smartx.core.ds.database.DataBaseLoader;
import cn.smartx.core.model.entity.XApp;

public class Update {
	final static Logger log = LoggerFactory.getLogger(Update.class);
	public static void main(String[] args) {
		List<PageUpdate> ups = new ArrayList<PageUpdate>();
		ups.add(new SmartxCorePageUpdate());
		ups.add(new DrzPageUpdate());
		ups.add(new DrzWebPageUpdate());
		ups.add(new DrzMobilePageUpdate());

		for(PageUpdate pu : ups){
			log.warn("start update " + pu.getAppCode() + ">>>>>>>>>>>>>");
			XApp thisApp = pu.getApp();
			pu.clearData();
			pu.createAppTemplate(thisApp);
			pu.createAppMenu();
			log.warn("update " + pu.getAppCode() + "<<<<<<<<finished");
		}
	}
}
