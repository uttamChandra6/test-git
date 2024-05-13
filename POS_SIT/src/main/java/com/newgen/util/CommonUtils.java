package com.newgen.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.newgen.iforms.custom.IFormReference;
import com.newgen.omni.jts.cmgr.XMLParser;



/***
 * Class containing common utility methods
 * 
 * @author navjot.singh
 *
 */
public class CommonUtils {
	
    Logger logger =  Logger.getLogger(CommonUtils.class);
    public static final String SOCKET_IP_ADDRESS = "127.0.0.1";
    public static final Integer SOCKET_PORT = 1331;
    
	/***
	 * Utility method to perform read/write operation with Socket
	 * 
	 * @param data	- String to be send/write to Socket as input
	 * @return	data read from socket output
	 * 
	 * @author navjot.singh
	 */
	public String connectToSocket(String data)  
	{
		String result="";
		try(Socket s = new Socket(SOCKET_IP_ADDRESS,SOCKET_PORT) ; 
				DataInputStream din=new DataInputStream(s.getInputStream());
				DataOutputStream dout=new DataOutputStream(s.getOutputStream())) 
			{
				writeDataToSocket(dout,data);
				result=readDataFromSocket(din);
			} catch (IOException e) {
				logger.error("Error in socket read/write ", e);
			}
		return result; 
	}
	
	/***
	 * Utility method to write data to socket
	 * 
	 * @param dataOutputStream	- dataOutputStream associated with socket
	 * @param data- String to be write to Socket
	 * 
	 * @author navjot.singh
	 */
	public boolean writeDataToSocket(DataOutputStream dataOutputStream, String data) {
		boolean bFlag = false;
		try {
			if (data != null && data.length() > 0) {
				dataOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
				bFlag=true;
			} 
		} catch (Exception e) {
			logger.error("Error in socket write ", e);
		}
		return bFlag;
	}

	/***
	 * Utility method to read data from socket
	 * 
	 * @param dataInputStream	- dataInputStream associated with socket
	 * 
	 * @author navjot.singh
	 */
	public String readDataFromSocket(DataInputStream dataInputStream) {
		 StringBuilder data = new StringBuilder();
		try {
			byte[] buffer = new byte[99999];
			int length = dataInputStream.read(buffer, 0, 99999);
			byte[] arrayBytes = new byte[length];
			System.arraycopy(buffer, 0, arrayBytes, 0, length);
			data.append(new String(arrayBytes, StandardCharsets.UTF_8));
			int len = 0;
			while ((len = dataInputStream.read(buffer)) > 0) {
				arrayBytes = new byte[len];
				System.arraycopy(buffer, 0, arrayBytes, 0, len);
				data.append(new String(arrayBytes, StandardCharsets.UTF_8));
				if (dataInputStream.available()<=0)
					break;
			}
		} catch (Exception e) {
			logger.error("Error in socket read/write ", e);
		}
		return data.toString();
	}
		
	/**
	 * A generic method to convert a date string from one pattern to another
	 * Ex	givenDateInString	"22/02/1996"
	 * 		givenDatePattern	"dd/MM/yyyy"
	 * 		requiredDatePattern	"dd-MMM-yyyy"
	 * 		
	 * 		then method will return	"22-FEB-1996"
	 * 
	 * @param givenDateInString
	 * @param givenDatePattern
	 * @param requiredDatePattern
	 * @return	the converted date format
	 * @throws ParseException	- in case date is in wrong format
	 * @author navjot.singh
	 */
	public static String convertDate(String givenDateInString , String givenDatePattern , String requiredDatePattern) throws ParseException
	{
		DateFormat givenDateFormat = new SimpleDateFormat(givenDatePattern);
		Date dateObtained  = givenDateFormat.parse(givenDateInString);
		DateFormat requiredDateFormat = new SimpleDateFormat(requiredDatePattern);
		return requiredDateFormat.format(dateObtained);
	}
	
	/**
	 * A generic method to get a formatted date string for a given pattern and date
	 * 
	 * @param givenDate Date object
	 * @param requiredDatePattern ex: dd/MM/yyyy
	 * @return converted format
	 * @author navjot.singh
	 */
	public static String convertDateInParticularFormat(Date givenDate , String requiredDatePattern)
	{
		DateFormat requiredDateFormat = new SimpleDateFormat(requiredDatePattern);
		return requiredDateFormat.format(givenDate);
	}
	
	
}
	
