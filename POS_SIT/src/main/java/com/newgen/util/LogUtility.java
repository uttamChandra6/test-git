package com.newgen.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.newgen.exception.CustomException;

/***
 * Utility class to configure Log4J
 * 
 * @author navjot.singh
 *
 */
public class LogUtility 
{
	private LogUtility(){
	}
	
	// flag to check whether Log4J is already initialized
	static boolean logInitialized = false;
	
	//	path for log file
    static String logFilePath = System.getProperty("user.dir") + File.separator + "Ng_Config" + File.separator + "Disbursement-log4j.properties";

    /***
     * Utility method to initialize logger
     * 
     * Method is called in IFormListener class in static block
     * 
     * @author navjot.singh
     */
    public static void initializeLogger()
    {	
        if(logInitialized)
        {
            return;
        }
        try {
            configureLogger();
        }
        catch (CustomException e) 
        {
        	// Exception while initializing logger printing Error message to Standard output
            System.out.println("Ex occured while initializing logs for MSB_POS process . Ex : "+e.getMessage());            
        }
        logInitialized = true;
    }

    /***
     * Utility method to read configuration from properties file and configure Log4J
     * @throws Exception - handles any Exception (intentionally used to handle FileNotFoundException,IOException)
     * @author navjot.singh
     */
    private static void configureLogger(){
    	try(FileInputStream fis = new FileInputStream(logFilePath);)
    	{
            Properties properties = new Properties();
            properties.load(fis);
            PropertyConfigurator.configure(properties);
    	}
    	catch(Exception ex){
    		throw new CustomException(ex.getMessage());
    	}
    }
}
