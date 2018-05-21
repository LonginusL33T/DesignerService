package cn.smartx.test;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import cn.smartx.core.datacenter.DataCenterUtils;
import cn.smartx.core.model.template.data.Property;
import cn.smartx.core.model.template.data.Webpage;

public class HelpTools {
	public static String generateWidgetListFromWebpage(String appcode, String webpagecode){
		Webpage page = DataCenterUtils.getWebPageEntity(appcode, webpagecode);
		StringBuilder sb = new StringBuilder();
		sb.append("\n  <data id=\"pageform\" import=\"").append(webpagecode).append("\" iterator=\"object\" init=\"true\">\n");
		sb.append("  </data>\n\n");
		sb.append("  <layout file=\"").append(appcode).append("/layout/main/login.html\"/>\n\n");
	 
		for(Property prop : page.getProperty()){
			sb.append("  <widget id=\"").append(prop.getName()).append("\"")
				.append(" title=\"").append(prop.getName()).append("\"")
				.append(" container=\"contentpane\" bind=\"@{pageform.get('")
				.append(prop.getName()).append("')}\">\n");
			sb.append("    <label></label>\n");
			sb.append("  </widget>\n");
		}
		sb.append("\n  <action type=\"click\" target=\"addbtn\" do=\"submit\"/>\n");
		sb.append("\n  <event when=\"submit\">\n");
		sb.append("    context.submit();\n");
		sb.append("  </event>\n\n");
		sb.append("  <transfer on=\"true\" to=\"\"/>\n");
		
		//放到剪贴板方便使用
		Clipboard sysClb=null;  
	    sysClb = Toolkit.getDefaultToolkit().getSystemClipboard();
	    StringSelection ss = new StringSelection(sb.toString()); 
	    sysClb.setContents(ss,null);  		

	    return sb.toString();
	} 
}
