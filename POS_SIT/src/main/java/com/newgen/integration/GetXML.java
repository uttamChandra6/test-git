package com.newgen.integration;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.newgen.iforms.user.POSCommon;

public class GetXML extends POSCommon {
	
	private static Logger logger = Logger.getLogger(GetXML.class);
	private static final Properties prop = new Properties();

	public static Properties getProp() {
		logger.info("Property File fetching");
		return prop;
	}

	static {
		try {
			
			prop.load(new FileReader(System.getProperty("user.dir") + File.separator + "MSB_ARB_Properties"
					+ File.separator + "properties" + File.separator + "Integration.properties"));
			
			
		} catch (Exception e) {
			// logger.error("exception in reading Accrual properties file :",e);
		}
	}
}