package com.newgen.iforms.user;
//svn test
//import java.io.File;
//import java.io.FileInputStream;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Properties;

import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

import com.newgen.iforms.custom.IFormListenerFactory;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;
import com.newgen.util.Constants;
import com.newgen.util.LogUtility;
import com.newgen.workstep.POS_Search;

//public class POS implements IFormListenerFactory {
public class POS implements IFormListenerFactory {


	static {
		LogUtility.initializeLogger();
	}

	Logger logger = Logger.getLogger(POS.class);

	public IFormServerEventHandler getClassInstance(IFormReference iFormReference) {
		
		String activityName = iFormReference.getActivityName();
		try {
			logger.debug("pos.java file>>>>activityName "+activityName);
			System.out.println("activityName "+activityName);
			if(activityName.equalsIgnoreCase(Constants.WORKSTEP.POS_SEARCH))
				return new POS_Search();
			else
				return new EventHandler();	
		} catch (Exception e) {
			logger.error("ex in getClassInstance : ", e);
		}
		return null;
	}
	
	
	/*
	public static void setLogger() 
	{
		try 
		{
			Date date = new Date();
			DateFormat logDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
		
			Properties p = new Properties();
			p.load(new FileInputStream(System.getProperty("user.dir")+ File.separator + "CustomConfig"+ File.separator+ "log4j_ARB.properties"));
			String dynamicLog = null;
			String orgFileName = null; 
			File d = null;
			File fl = null; 
			
			dynamicLog = "CustomLog"+File.separator+processName+"_Logs"+File.separator+logDateFormat.format(date)+File.separator+processName+"_Log.xml";
			orgFileName = p.getProperty("log4j.appender."+loggerName+".File");
			if(!(orgFileName==null || orgFileName.equalsIgnoreCase("")))
			{
				dynamicLog = orgFileName.substring(0,orgFileName.lastIndexOf("/")+1)+logDateFormat.format(date)+orgFileName.substring(orgFileName.lastIndexOf("/"));
			}			
			d = new File(dynamicLog.substring(0,dynamicLog.lastIndexOf("/")));
			d.mkdirs();
			fl = new File(dynamicLog);
			boolean fc = false;
			if(!fl.exists())
				 fc= fl.createNewFile();
			
			p.put("log4j.appender."+loggerName+".File", dynamicLog );
			PropertyConfigurator.configure(p);
			
		//	loggerDateMap.put(logDateFormat.format(date),"Y");
			
		}
		catch (Exception e) 
		{
			printException(e);
		}
	}
	*/
	
	
}
