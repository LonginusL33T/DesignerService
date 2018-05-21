package cn.smartx.tools;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.smartx.core.model.entity.XApp;

/**
 * @author pengrobin
 * 2014年6月23日
 */
public class Installer {
	final static Logger log = LoggerFactory.getLogger(Installer.class);
	public static void main(String[] args) {
		List<AppInstaller> apps = new ArrayList<AppInstaller>();
		apps.add(new SmartxCoreInstaller());
		apps.add(new DesignerInstaller());
		
		
		for(AppInstaller ai : apps){
			log.warn("start install " + ai.getAppCode() + ">>>>>>>>>>>>>");
			ai.clearData();
			XApp thisApp = ai.createApp();
			ai.createAppTemplate(thisApp);
			ai.createAppTask(thisApp);
			ai.configAAABasicData();
			ai.createAppMenu();
			ai.createRoleAndUser();
			ai.createWorkflow();
			log.warn("install " + ai.getAppCode() + "<<<<<<<<finished");
		}
	}
}
