package com.newgen.integration;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.user.POSCommon;
import com.newgen.omni.jts.cmgr.XMLParser;


public class SocketConnector extends POSCommon {
	
	Logger logger = Logger.getLogger(POSCommon.class);
	
	@SuppressWarnings("unchecked")
	public String getSocketXMLResponse(String XMLRequest,String callName,IFormReference iformObj) {
		/*
		if(callName.equalsIgnoreCase("SIMAH_Individual"))
		{
			String simah_ind_user=GetXML.getProp().getProperty("SIMAH_Individual_Username");;
			String simah_ind_pass=GetXML.getProp().getProperty("SIMAH_Individual_Password");;
			XMLRequest=XMLRequest+"<BasicAuthorizationRequired>";
			XMLRequest=XMLRequest+"<BasicAuthPass>"+simah_ind_pass+"</BasicAuthPass>";
			XMLRequest=XMLRequest+"<BasicAuthUser>"+simah_ind_user+"</BasicAuthUser>";
			XMLRequest=XMLRequest+"</BasicAuthorizationRequired>";
		}
		*/
		String requestSentAt="",responseReceivedAt="";
		String status="",exceptionOccured="";
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		String XMLResponse = "";
		String serverIP = "", serverPort = "";
		serverIP = GetXML.getProp().getProperty("SocketServerIP");
		logger.info("Socket serverIP "+serverIP);
		serverPort = GetXML.getProp().getProperty("SocketServerPort");
		logger.info("Socket serverPort "+serverPort);
		try 
		{
			socket = new Socket(serverIP, Integer.parseInt(serverPort));
			logger.info("Socket value"+socket);			
			oos = new ObjectOutputStream(socket.getOutputStream());
			logger.info("oos value"+oos);
			ois = null; 
			XMLRequest=XMLRequest+"<NewgenIntegrationCallName>"+callName+"</NewgenIntegrationCallName>";
			//XMLRequest.put("NewgenIntegrationCallName", callName);
			logger.info("XML Request after appending call Name is "+XMLRequest);
			requestSentAt=getCurrentTimeStamp();
			oos.writeObject(XMLRequest);
			ois = new ObjectInputStream(socket.getInputStream());
			logger.info("ois value is "+ois);
			XMLResponse=(String) ois.readObject();
			responseReceivedAt = getCurrentTimeStamp();
			//jsonResponse = (JSONObject)ois.readObject(); 
			// logger.info("XML Response is "+XMLResponse); //Commenting on 1st Jan 2021, sahdev kansal
			XMLParser parser = new XMLParser(XMLResponse);
		//	Accrual.mLogger.info("jsonResponse "+jsonResponse);
		if ((XMLResponse != null) && parser.getValueOf("HTTPResponseCode") != null)
		{
			if (parser.getValueOf("SocketError") != null) 
			{
				  if ("Socket Time Out".equalsIgnoreCase((String)parser.getValueOf("SocketError")))
				  {
		                status = "FAIL";
		                exceptionOccured = "Error in Connectivity";
		          //   returnMsg = "API Service is unreachable";
			      }
			}
		}
		else
		{
			status="Pass";
		}
		
		String logQuery = new StringBuilder().append(
				"INSERT INTO NG_ARB_API_LOGS (CALL_NAME, REQUEST, REQUEST_SENT, RESPONSE, RESPONSE_RECEIVED, EXCEPTION_OCCURED, STATUS, WI_NAME, ACTIVITY_NAME, USERNAME)VALUES ('")
				.append(callName).append("',N'").append(XMLRequest).append("','")
				.append(requestSentAt).append("',N' ").append(XMLResponse.replace("'", "''"))
				.append("','").append(responseReceivedAt).append("','"+exceptionOccured+"', '")
				.append(status).append("', '").append(getWorkitemName(iformObj)).append("', '").append(getActivityName(iformObj))
				.append("', '").append(getUserName(iformObj).replace("'", "''")).append("') ").toString();
		//Without using getCLOBString and Removing To_timestamp function also 
		logger.info("Log Query is "+logQuery);
		
		//if(!callName.equalsIgnoreCase("Broker_Document"))
		//{
			saveDataInDB(iformObj, logQuery);
		//}
		//else
		//{
			//logger.info("As Call Name is "+callName+" Hence we are not inserting in logs table.");
		//}
	
		
		}catch(Exception e) {
			logger.error("Exception occured in calling NG_ARB_API_LOGS", e);
		}finally {
				try {
					if(socket!=null) { socket.close(); socket = null; }
					if(oos != null) { oos.close(); oos = null; }
					if(ois != null) { ois.close(); ois = null; }
				} catch (IOException e) {
					//Accrual.mLogger.error("Exception occured", e);
				}
		}
		return XMLResponse;
	}

	public String getCLOBString(String inputString) {
		/* 1299 */     String jsonRequestString = inputString;
		/* 1300 */     String requestJSONParameter = "";
		/* 1301 */     if (inputString != null) {
		/* 1302 */       jsonRequestString = inputString.toString().replace("'", "''");
		/* 1303 */       for (int i = 0; i < jsonRequestString.length(); i += 4000)
		/* 1304 */         if (i + 4000 < jsonRequestString.length()) {
		/* 1305 */           requestJSONParameter = new StringBuilder().append(requestJSONParameter).append("TO_CLOB('").append(jsonRequestString.substring(i, i + 4000)).append("')").toString();
		/* 1306 */           requestJSONParameter = new StringBuilder().append(requestJSONParameter).append(" || ").toString();
		/*      */         }
		/*      */         else {
		/* 1309 */           requestJSONParameter = new StringBuilder().append(requestJSONParameter).append("TO_CLOB('").append(jsonRequestString.substring(i)).append("')").toString();
		/*      */         }
		/*      */     }
		/*      */     else
		/*      */     {
		/* 1314 */       requestJSONParameter = "TO_CLOB('')";
		/*      */     }
		/* 1316 */     return requestJSONParameter;
		/*      */   }
	
	
	public String getCurrentTimeStamp()
	/*      */   {
	/*      */     try {
	/*  337 */       return new Timestamp(System.currentTimeMillis()).toString();
	/*      */     } catch (Exception e) {
	/*  339 */     System.out.println(e);
	/*  340 */     }return "";
	/*      */   }
	
	/*public JSONObject getSocketJSONResponse(String callName) {
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		JSONObject XMLRequest = null;
		JSONObject jsonResponse = null;
		String serverIP = "", serverPort = "";
		serverIP = GetJSON.prop.getProperty("SocketServerIP");
		serverPort = GetJSON.prop.getProperty("SocketServerPort");
		try {
			socket = new Socket(serverIP, Integer.parseInt(serverPort));
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = null; 
			XMLRequest = new JSONObject();
			XMLRequest.put("NewgenIntegrationCallName", callName);
			oos.writeObject(XMLRequest);
			ois = new ObjectInputStream(socket.getInputStream());
			jsonResponse = (JSONObject)ois.readObject(); 
		}catch(Exception e) {
			Accrual.mLogger.error("Exception occured", e);
		}finally {
				try {
					if(socket!=null) {
						socket.close();
						socket = null;
					}
					if(oos != null) {
						oos.close();
						oos = null;
					}
					if(ois != null) {
						ois.close();
						ois = null;
					}
				} catch (IOException e) {
					Accrual.mLogger.error("Exception occured", e);
				}
		}
		return jsonResponse;
	}*/

}
