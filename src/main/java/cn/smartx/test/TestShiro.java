package cn.smartx.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TestShiro {
	final static Logger log = LoggerFactory.getLogger(TestShiro.class);

	public static void TestShiroCore() {
		//1. Load the INI configuration
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//2. Create the SecurityManager
		SecurityManager securityManager = factory.getInstance();
		//3. Make it accessible
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject currentUser = SecurityUtils.getSubject();
		log.warn(currentUser.toString());
	}
}
