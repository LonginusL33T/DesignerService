package cn.smartx.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.smartx.core.AAA.SmartxMenuService;
import cn.smartx.core.AAA.SmartxSecurityManager;
import cn.smartx.core.AAA.model.Menu;
import cn.smartx.core.AAA.model.Permission;
import cn.smartx.core.AAA.model.Role;
import cn.smartx.core.AAA.model.User;
import cn.smartx.core.AAA.service.PermissionService;
import cn.smartx.core.AAA.service.RoleService;
import cn.smartx.core.AAA.service.UserService;
import cn.smartx.core.common.SmartxConfig;
import cn.smartx.core.common.SmartxConstants;
import cn.smartx.core.ds.database.DataBaseLoader;
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
import cn.smartx.core.model.entity.AcctUserRole;
import cn.smartx.core.model.entity.XApp;
import cn.smartx.core.model.entity.XDocbase;
import cn.smartx.core.model.entity.XDocitem;
import cn.smartx.core.model.entity.XPage;
import cn.smartx.core.model.entity.XTask;
import cn.smartx.test.TestCore;

/**
 * @author pengrobin
 * 2014年6月23日
 */
public class LogAnalyzer {
	final static Logger log = LoggerFactory.getLogger(LogAnalyzer.class);
	private static String LogFileFolder;
	private static String LogFilePattern;
	//独立行，由于异常等日志占据多行，这些多行组成一块，不能作为独立行，独立行用于判断日志有意义的内容块
	private static String IndepentLinePattern;
	private static List<Analyzer> Analyzers;
	private static int MaxResultCount = 1000;

	static{
		PropertiesConfiguration config;
		try {
			config = new PropertiesConfiguration("tools.ini");
			LogFileFolder = config.getString("logFileFolder");
			LogFilePattern = config.getString("logFilePattern");
			IndepentLinePattern = config.getString("indepentLinePattern");
			MaxResultCount = config.getInt("maxResultCount");
			Analyzers = new ArrayList<Analyzer>();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			LogAnalyzer logAnalyzer = new LogAnalyzer();
			logAnalyzer.analyze();

			//dump result
			for(Analyzer a : Analyzers){
				logAnalyzer.print("====================result=======================");
				logAnalyzer.print(a.toString());
				for(AnalyzeResultItem item : a.getItems()){
					logAnalyzer.print("====" + item.toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public void print(String content){
		log.warn(content);
		//System.out.println(content);
	}
	
	public void analyze() throws IOException, ConfigurationException{
		PropertiesConfiguration config;
		config = new PropertiesConfiguration("tools.ini");

		int i = 1;
		while(config.getString("analyzePattern." + i + ".desc") != null){
			Analyzer analyzer = this.new Analyzer();
			analyzer.setDesc(config.getString("analyzePattern." + i + ".desc"));
			analyzer.setPattern(config.getString("analyzePattern." + i + ".pattern"));
			analyzer.setStart(config.getString("analyzePattern." + i + ".start"));
			analyzer.setEnd(config.getString("analyzePattern." + i + ".end"));
			Analyzers.add(analyzer);
			i++;
		}
		startAnalyze();
	}
	
	private void startAnalyze() throws IOException{
		File directory = new File(LogFileFolder);
		Iterator<File> it = FileUtils.iterateFiles(directory, null, true);
		
		while(it.hasNext()){
			File file = it.next();
			if(!file.getName().matches(LogFilePattern)){
				continue;
			}
			
			//打开日志文件
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			int nLine = 0;
			while((line = reader.readLine()) != null){
				nLine++;
				if(nLine%1000 == 0){
					this.print(">>>" + file.getName() + ":line " + nLine);
				}
				
				if(line.matches(IndepentLinePattern)){
					for(Analyzer a : Analyzers){
						if(!line.matches(a.getPattern())){
							continue;
						}
						
						if(a.getStart() != null && line.compareTo(a.getStart()) < 0){
							continue;
						}
						
						if(a.getEnd() != null && line.compareTo(a.getEnd()) > 0){
							continue;
						}
						
						AnalyzeResultItem item = new AnalyzeResultItem();
						item.setFileName(file.getName());
						item.setLineNumber(nLine);
						item.setLogContent(line);
						if(a.getCount() < MaxResultCount){
							a.addItem(item);
						}
					}
				}
			}
			
			reader.close();
		}
	}
	
	public class Analyzer{
		//分析描述(显示用)
		private String desc = null;
		//分析结果
		private ArrayList<AnalyzeResultItem> items;
		//分析模式
		private String pattern = null;
		//开始时间
		private String start = null;
		//结束时间
		private String end = null;

		@Override
		public String toString() {
			return this.desc + ";total count:" + items.size();
		}
		
		public String getPattern() {
			return pattern;
		}

		public void setPattern(String pattern) {
			this.pattern = pattern;
		}

		public String getStart() {
			return start;
		}

		public void setStart(String start) {
			this.start = start;
		}

		public String getEnd() {
			return end;
		}

		public void setEnd(String end) {
			this.end = end;
		}
		
		public Analyzer(){
			items = new ArrayList<AnalyzeResultItem>();
		}
		
		public int getCount() {
			return items.size();
		}

		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}

		public ArrayList<AnalyzeResultItem> getItems() {
			return items;
		}

		public void addItem(AnalyzeResultItem item) {
			this.items.add(item);
		}
	}
	
	public class AnalyzeResultItem{
		private String fileName;
		private int lineNumber;
		private String logContent;
		
		@Override
		public String toString() {
			return fileName + ":" + lineNumber + "--[" + logContent + "]"; 
		}
		
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public int getLineNumber() {
			return lineNumber;
		}
		public void setLineNumber(int lineNumber) {
			this.lineNumber = lineNumber;
		}
		public String getLogContent() {
			return logContent;
		}
		public void setLogContent(String logContent) {
			this.logContent = logContent;
		}
	}
}
