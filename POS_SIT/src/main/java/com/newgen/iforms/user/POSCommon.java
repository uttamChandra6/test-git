package com.newgen.iforms.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;
import javax.tools.JavaCompiler;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.bouncycastle.util.encoders.Base64Encoder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.newgen.iforms.custom.IFormReference;
import com.newgen.integration.GetXML;
import com.newgen.integration.SocketConnector;
import com.newgen.omni.jts.cmgr.XMLParser;
import com.newgen.omni.wf.util.app.NGEjbClient;
import com.newgen.wfdesktop.xmlapi.WFXmlList;
import com.newgen.wfdesktop.xmlapi.WFXmlResponse;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class POSCommon {

	String sLocaleForMessage = java.util.Locale.getDefault().toString();
	Logger logger = Logger.getLogger(POSCommon.class);
	protected IFormReference iFormReference;

	public POSCommon(IFormReference iFormReference)
	{
		this.iFormReference = iFormReference;
	}

	public POSCommon() {

	}

	
	public void callProcedure(IFormReference arg0, String arg2, String arg3) {
		List<String> paramList = new ArrayList<>();
		String[] myStringArray = arg3.split("~");
		String value = "";
		for (int i = 0; i < myStringArray.length; i++) {
			value = "Text:" + myStringArray[i];
			paramList.add(value);
		}
		logger.debug("callProcedure 123 : " + arg2 + " " + paramList);
		arg0.getDataFromStoredProcedure(arg2, paramList);
		
				
	}
	
	public String isarabic(IFormReference iformObj, String id )
	{
		String field=getControlValue(iformObj, id);
		/*
		boolean flag=false;
		if(field!=null)
		{
			java.util.regex.Pattern p=java.util.regex.Pattern.compile("^[\\u0621-\\u064A ]+$");
			java.util.regex.Matcher m=p.matcher(field);
			flag=m.matches();
			logger.info("Inside isarabic function flag="+flag);
			System.out.println(flag);
		}
		
		String return_string=String.valueOf(flag);
		return return_string;
		*/
		String return_string="";
		boolean arabic_flag=false,english_flag=false;
		if(field!=null)
		{
			java.util.regex.Pattern p=java.util.regex.Pattern.compile("^[\\u0621-\\u064A\\u0660-\\u0669 ]+$"); // Regex to Check Arabic
			java.util.regex.Matcher m=p.matcher(field);
			arabic_flag=m.matches();
			//logger.info("Inside isarabic function flag="+flag);
			System.out.println(arabic_flag);
		}

		if(arabic_flag==false)
		{
			
			java.util.regex.Pattern p=java.util.regex.Pattern.compile("^[0-9A-Za-z\\s-]+$"); //Regex to check English
			java.util.regex.Matcher m=p.matcher(field);
			english_flag=m.matches();
			System.out.println(english_flag);
			if(english_flag==true)
			{
				return_string="false";
			}
			else
			{
				return_string="mix";
			}
		}
		else 
		{
			return_string="true";
		}
		logger.info("Inside isarabic function: field is is "+id+" and its value is "+field+" and return string is "+return_string);
		return return_string;
		
	}

	public String callProcedurewithreturn(IFormReference arg0, String arg2, String arg3) {
		List<String> paramList = new ArrayList<>();
		String[] myStringArray = arg3.split("~");
		String value = "";
		for (int i = 0; i < myStringArray.length; i++) {
			value = "Text:" + myStringArray[i];
			paramList.add(value);
		}
		logger.debug("callProcedure 123 : " + arg2 + " " + paramList);
		List result =arg0.getDataFromStoredProcedure(arg2, paramList);
		logger.info("callProcedurewithreturn result is "+result);
		/*
		if(result!=null && result!="")
		{
			
		}
		*/
		return result.get(0).toString();
		
				
	}


	public List<List<String>> getDataFromDB(IFormReference iformObj, String query) {
		logger.debug("WINAME : " + getWorkitemName(iformObj) + ", WSNAME: " + getActivityName(iformObj)
				+ ", Inside Done()--->query is: " + query);
		try {
			List<List<String>> result = iformObj.getDataFromDB(query);
			logger.debug("WINAME : " + getWorkitemName(iformObj) + ", WSNAME: " + getActivityName(iformObj)
					+ ", Inside Done()---result:" + result);
			if (!result.isEmpty() && result.get(0) != null) {
				return result;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return Collections.emptyList();
	}

	public String saveDataInDB(IFormReference iformObj, String query) {
		logger.debug("WINAME : " + getWorkitemName(iformObj) + ", WSNAME: " + getActivityName(iformObj)
				+ ", Inside Done()---Exception_Mail_ID->query is: " + query);
		try {
			int mainCode = iformObj.saveDataInDB(query);
			logger.debug("WINAME : " + getWorkitemName(iformObj) + ", WSNAME: " + getActivityName(iformObj)
					+ ", Inside Done()---result:" + mainCode);
			return mainCode + "";
		} catch (Exception e) {
			logger.debug("Exception Occurred: saveDataInDB and Exception is "+e);
		}
		return null;
	}

	public static Date convertGrToHijri(Date dlExpiryDateGj)
    {   
        //block 1 start
        Date dd= new Date();
        String s="";        
        try
        {
            SimpleDateFormat srdf=new SimpleDateFormat("yyyy/MM/dd");
            s=srdf.format(dlExpiryDateGj);    // if the input parameters are in the form Date date---->change accordingly here 
           // s=srdf.format(date);            
            System.out.println(s);         
          }
        catch(Exception ex)
        {
            System.out.println(ex);
        }    
        //block 2 end
        //if the input parameters are in the form String s---->remove the block 1 and start from here  
        String array1[]= s.split("/");
        int y=Integer.parseInt(array1[0]);
        int m=Integer.parseInt(array1[1]);
        int d=Integer.parseInt(array1[2]);
        System.out.println(y);
        System.out.println(m);
        System.out.println(d);
        int jd;         if ((y>1582)||((y==1582)&&(m>10))||((y==1582)&&(m==10)&&(d>14))) 
        {             jd=((1461*(y+4800+(m-14)/12))/4)+((367*(m-2-12*(((m-14)/12))))/12)-((3*(((y+4900+((m-14)/12))/100)))/4)+d-32075;         } 
        else
        {
            jd = 367*y-((7*(y+5001+((m-9)/7)))/4)+((275*m)/9)+d+1729777;
        }         int l=jd-1948440+10632;         int n=((l-1)/10631);         l=l-10631*n+354;         int j=(((10985-l)/5316))*(((50*l)/17719))+((l/5670))*(((43*l)/15238));         l=l-(((30-j)/15))*(((17719*j)/50))-((j/16))*(((15238*j)/43))+29;         m=((24*l)/709);         d=l-((709*m)/24);         System.out.println("d>>"+d);         y=30*n+j-30;         String mm="",ddd="",yy="";         if (m < 10)
        {
            mm="0"+m;
        }         else
        {
            mm=String.valueOf(m);
        }         if (d < 10)
        {
            ddd="0"+d;
        }         else
        {
            ddd=String.valueOf(d);
        }      
        yy=String.valueOf(y);         
        String sDateInHijari= yy + "/" + mm + "/" + ddd;     
        Date dt=convertStringToDate(sDateInHijari);
        System.out.println("final calc date = "+dt);
        return(dt);    //in case you are defining this as a function instead of print statement define this as a return sDateINHijari   
		} 



     private static Date convertStringToDate(String sDateInHijari) {
		// TODO Auto-generated method stub
		return null;
	}

	public String convertHijriToGr(IFormReference iformObj,Date dlExpiryDateHj)
    {   
        System.out.println("Inside function convertHijriToGr");
        String query="";
        String return_date=null;
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
        String expHJ=formatter.format(dlExpiryDateHj);
        System.out.println("expHJ "+expHJ);
        //query="SELECT CONVERT(datetime, value, 131) FROM( values ('"+expHJ+"') ) samples(value)";
        query="SELECT convert(nvarchar,CONVERT(date, value, 131),103) FROM( values ('"+expHJ+"') ) samples(value)";
        logger.info("Query to convert from hj to gr is "+query);
        List<List<String>> result=getDataFromDB(iformObj, query);  
        if(result.size()>0)
        {
        	logger.info("Returning date as "+result.get(0).get(0).replaceAll("\\[", "").replaceAll("\\]",""));
        	return_date=result.get(0).get(0).replaceAll("\\[", "").replaceAll("\\]","");
        }/*
        try {
        	return_date=new SimpleDateFormat("dd/MM/yyyy").format(result.get(0).get(0).replaceAll("\\[", "").replaceAll("\\]",""));
		} catch (Exception e) {
			logger.info("Error in coversion of date from Gr to Hj");
			e.printStackTrace();
		}*/
        
        return(return_date);   
		}
	
	
	public String createWorkitem(IFormReference forObj, String sessionID) 
	{
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		NGEjbClient objNGEjbClient = null;
		String sJtsIp = "127.0.0.1";
		String iJtsPort = "8080";
		String retval = "";
		try {
			String uploadWorkitem = "<?xml version=\"1.0\"?><WFUploadWorkItem_Input><Option>WFUploadWorkItem</Option>"
					+ "<EngineName>" + forObj.getCabinetName() + "</EngineName><SessionId>" + sessionID
					+ "</SessionId><ProcessDefId>19</ProcessDefId>"
					+ "<QueueId>308</QueueId><InitiateFromActivityId>1</InitiateFromActivityId>"
					+ "<UserDefVarFlag>Y</UserDefVarFlag><InitiateAlso>N</InitiateAlso><Attributes><CREATEDDATE>"+date+"</CREATEDDATE></Attributes><IsWorkItemExtInfo>N</IsWorkItemExtInfo><Documents></Documents></WFUploadWorkItem_Input>";
			logger.debug("uploadWorkitem " + uploadWorkitem);
			logger.debug("sJtsIp " + sJtsIp);
			logger.debug("iJtsPort " + iJtsPort);

			if (objNGEjbClient == null) {
				objNGEjbClient = NGEjbClient.getSharedInstance();
				objNGEjbClient.initialize(sJtsIp, String.valueOf(iJtsPort), "JBossEAP");
			}
			String outputXml = objNGEjbClient.makeCall(uploadWorkitem);
			logger.debug("create workitem outputXml->" + outputXml);
			if (outputXml.contains("<MainCode>0</MainCode>")) {
				retval = outputXml.substring(outputXml.indexOf("<ProcessInstanceId>") + 19,
						outputXml.indexOf("</ProcessInstanceId>"));
			} else
				retval = outputXml.substring(outputXml.indexOf("<Subject>") + 9, outputXml.indexOf("</Subject>"));

		} catch (Exception e) {
			logger.error(e);
		}

		
		return retval;
	}
	
	//Still Under Development
	public String assignWorkitem(IFormReference iformObj, String sessionID) 
	{
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String username=iformObj.getUserName();
		NGEjbClient objNGEjbClient = null;
		String sJtsIp = "127.0.0.1";
		
		String iJtsPort = "8080";
		String retval = "";
		try 
		{
			String assignWorkitem = "<?xml version=\"1.0\"?> <WMReassignWorkItem_Input> <Option>WMReassignWorkItem</Option> <EngineName>"+iformObj.getCabinetName()+"</EngineName> "
					+ "<SessionId>"+sessionID+"</SessionId> <ProcessInstanceId>"+getWorkitemName(iformObj)+"</ProcessInstanceId> <WorkItemId>1</WorkItemId> <SourceUser /> "
					+ "<TargetUser>"+username+"</TargetUser> <Comments /> <OpenMode>PM</OpenMode></WMReassignWorkItem_Input>";
			logger.debug("uploadWorkitem " + assignWorkitem);
			logger.debug("sJtsIp " + sJtsIp);
			logger.debug("iJtsPort " + iJtsPort);

			if (objNGEjbClient == null) {
				objNGEjbClient = NGEjbClient.getSharedInstance();
				objNGEjbClient.initialize(sJtsIp, String.valueOf(iJtsPort), "JBossEAP");
			}
			String outputXml = objNGEjbClient.makeCall(assignWorkitem);
			
			logger.debug("assign workitem outputXml->" + outputXml);
			if (outputXml.contains("<MainCode>0</MainCode>")) 
			{
				retval = "Success~Workitem no "+getWorkitemName(iformObj)+" assigned to "+username;
			} else
				retval = outputXml.substring(outputXml.indexOf("<Subject>") + 9, outputXml.indexOf("</Subject>"));

		}catch (Exception e) 
		{
			logger.error("Exception Occurred:: assignWorkitem and exception is "+e);
		}
		logger.info("assignWorkitem call returns"+retval);
		return retval;
	}

	public String createWorkitemDisbursement(IFormReference iformObj, String sessionID) 
	{
		NGEjbClient objNGEjbClient = null;
		String sJtsIp = "127.0.0.1";
		String iJtsPort = "8080";
		String retval = "";

		try 
		{
			String uploadWorkitem = "<?xml version=\"1.0\"?><WFUploadWorkItem_Input><Option>WFUploadWorkItem</Option>"
					+ "<EngineName>" + iformObj.getCabinetName() + "</EngineName><SessionId>" + sessionID
					+ "</SessionId><ProcessDefId>32</ProcessDefId>"
					+ "<QueueId>484</QueueId><InitiateFromActivityId>1</InitiateFromActivityId>\""
					+ "<UserDefVarFlag>Y</UserDefVarFlag><InitiateAlso>N</InitiateAlso><Attributes><PARENT_WI_NAME>"+getWorkitemName(iformObj)+"</PARENT_WI_NAME></Attributes><IsWorkItemExtInfo>N</IsWorkItemExtInfo><Documents></Documents></WFUploadWorkItem_Input>";
			logger.debug("uploadWorkitem " + uploadWorkitem);
			logger.debug("sJtsIp " + sJtsIp);
			logger.debug("iJtsPort " + iJtsPort);

			if (objNGEjbClient == null) {
				objNGEjbClient = NGEjbClient.getSharedInstance();
				objNGEjbClient.initialize(sJtsIp, String.valueOf(iJtsPort), "JBossEAP");
			}
			String outputXml = objNGEjbClient.makeCall(uploadWorkitem);
			logger.debug("create workitem outputXml->" + outputXml);
			if (outputXml.contains("<MainCode>0</MainCode>")) {
				retval = outputXml.substring(outputXml.indexOf("<ProcessInstanceId>") + 19,
						outputXml.indexOf("</ProcessInstanceId>"));
			} else
				retval = outputXml.substring(outputXml.indexOf("<Subject>") + 9, outputXml.indexOf("</Subject>"));

			logger.debug("Process wi name of new workitem created is " + retval);

		} 
		catch (Exception e) 
		{
			logger.error("Exception Occurred:: createWorkitemDisbursement and exception is "+e);
		}
		return retval;

	}

	public String addHashtoDate(IFormReference iformObj,String date_without_hash)
	{
		String return_string = "";
		String query="select convert(varchar,cast(right('"+date_without_hash+"', 4)+substring('"+date_without_hash+"', 3, 2)+left('"+date_without_hash+"', 2) as datetime),101)";
		logger.info("Query to convert add hash in date is "+query);
		List<List<String>> returned_result = iformObj.getDataFromDB(query);
		if(returned_result.size()>0)
		{
			return_string=returned_result.get(0).get(0);
		}
		logger.info("Return string is "+return_string);
		return return_string;
	}
	
	public String getSessionId(IFormReference iformObj) {
		return (iformObj.getObjGeneralData()).getM_strDMSSessionId();
	}

	public String getItemIndex(IFormReference iformObj) {
		return (iformObj.getObjGeneralData()).getM_strFolderId();
	}

	public String getWorkitemName(IFormReference iformObj) {
		return (iformObj.getObjGeneralData()).getM_strProcessInstanceId();
	}

	public void setControlValue(IFormReference iformObj, String controlName, String controlValue) {
		iformObj.setValue(controlName, controlValue);
	}

	public String getCabinetName(IFormReference iformObj) {
		return (String) iformObj.getCabinetName();
	}

	public String getUserName(IFormReference iformObj) {
		return (String) iformObj.getUserName();
	}

	public String getActivityName(IFormReference iformObj) {
		return (String) iformObj.getActivityName();
	}

	public String getControlValue(IFormReference iformObj, String controlName) {
		return (String) iformObj.getValue(controlName);
	}

	public boolean introduceWorkItemInSpecificProcess(IFormReference arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public String onChangeEventServerSide(IFormReference arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public String postHookExportToPDF(IFormReference arg0, File arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void postHookOnDocumentUpload(IFormReference arg0, String arg1, String arg2, File arg3, int arg4) {
		// TODO Auto-generated method stub

	}

	public static String readDummyRequest(String callName) {
		try {
			Builder build = new Builder();
			//File f = new File("C:\\EAP-7.3.0\\bin\\MSB_ARB_Properties\\XMLFiles\\DummyRequest" + callName + ".xml");
			// File f=new
			// File("C:\\Newgen\\JBOSS-7.2\\bin\\MSB_ARB_Properties\\XMLFiles\\DummyRequestGetCrInfobyCrNo.xml");
			
			 File f = new File(System.getProperty("user.dir") + File.separator+"MSB_ARB_Properties" + File.separator + "XMLFiles" + File.separator +"DummyRequest" + callName + ".xml");
			
			Document doc = build.build(f);
			return doc.toXML();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		/*
		 * 
		 * try {
		 * 
		 * BufferedReader bufReader = null; FileInputStream fis = new FileInputStream(
		 * System.getProperty("user.dir") + File.separator + "MSB_ARB_Properties" +
		 * File.separator + "XMLFiles" + File.separator + "DummyRequest" + callName +
		 * ".xml"); Reader reader = new InputStreamReader(fis, "UTF-8"); bufReader = new
		 * BufferedReader(reader); StringBuilder sb = new StringBuilder(); String line =
		 * bufReader.readLine(); while (line != null) { sb.append(line).append("\n");
		 * line = bufReader.readLine(); } String dummyXMLString = sb.toString();
		 * bufReader.close();
		 * 
		 * return dummyXMLString;
		 * 
		 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (UnsupportedEncodingException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		

		return null;
	}
	
	public String DDPRequestXML(IFormReference iformObj, String callName) {
		try
		{
			logger.info("Inside DDPRequestXML Function and callName is " + callName);
			String tagName = "_TagName";
			
			String request_prefix=GetXML.getProp().getProperty(callName+"_RequestPrefix");
			if(request_prefix.equals(null))
			{
				request_prefix="";
			}
			logger.info("Request prefix is "+request_prefix+"please check");
			
			String header_tags=GetXML.getProp().getProperty(callName+"_Header");
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
		
			String tagNames = GetXML.getProp().getProperty(callName + tagName);
			logger.info(tagNames);
			String[] tags = tagNames.split(",");
			logger.info(tags.length +"*****************"+callName);
			String requestXML = readDummyRequest(callName);
			logger.info(requestXML +"*****************");
			XMLParser parser = new XMLParser(requestXML);
			
			//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			
			//String dt = sdf.format(new Date());
			String dt=OffsetDateTime.now().toString();
			logger.info(dt);
			
			for (String tag : tags) {
				String tagValue = parser.getValueOf(request_prefix+tag);
				logger.info("tag values are"+tagValue);
				if(tagValue.contains("header~"))
				{
					try {

						if(tagValue.split("~")[1].equalsIgnoreCase("UUID"))
						{
							parser.changeValue(request_prefix+tag, java.util.UUID.randomUUID().toString());
						}
						else if(tagValue.split("~")[1].equalsIgnoreCase("TradeDate") || tagValue.split("~")[1].equalsIgnoreCase("SettlementDate") || tagValue.split("~")[1].equalsIgnoreCase("MaturityDate") )
						{
							parser.changeValue(request_prefix+tag, dt);
						}
						else
						{

							String value=(String) jsonobj_header.get(tagValue.split("~")[1]);
							logger.info("Value to be replaced by jsonobj_header is "+value);
							parser.changeValue(request_prefix+tag, value);
						}
					}
					catch(Exception e)
					{
						logger.info("Exception is "+e);
					}
				}
				if (tagValue.startsWith("formid~")) {
					String value = (String) iformObj.getValue(tagValue.split("~")[1]);
					parser.changeValue(request_prefix+tag, value);
				}
				
			}
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML is :\n" + parser.toString());
			String responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);

			System.out.println("Response XML is: \n" + responseXML);
			//logger.info("Response XML is: \n" + responseXML);
		return responseXML;
		}catch(Exception e)
		{
			logger.info("Exception occurred: DDPRequestXML "+e);
			return "";
		}
	}

	
	
	public String createRequestXML(IFormReference iformObj, String callName) 
	{
		try
		{
			logger.info("Inside createRequestXML Function and callName is " + callName);
			String tagName = "_TagName";
			
			String request_prefix=GetXML.getProp().getProperty(callName+"_RequestPrefix");
			if(request_prefix.equals(null))
			{
				request_prefix="";
			}
			logger.info("Request prefix is "+request_prefix+"please check");
			
			String header_tags=GetXML.getProp().getProperty(callName+"_Header");
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
		
			String tagNames = GetXML.getProp().getProperty(callName + tagName);
			logger.info(tagNames);
			String[] tags = tagNames.split(",");
	
			String requestXML = readDummyRequest(callName);
	
			XMLParser parser = new XMLParser(requestXML);
	
			for (String tag : tags) {
				String tagValue = parser.getValueOf(request_prefix+tag);
				logger.info("tag values are"+tagValue);
				if(tagValue.contains("header~"))
				{
					try 
					{
						if(tagValue.split("~")[1].equalsIgnoreCase("UUID"))
						{
							parser.changeValue(request_prefix+tag, java.util.UUID.randomUUID().toString());
						}
						else
						{
							String value=(String) jsonobj_header.get(tagValue.split("~")[1]);
							logger.info("Value to be replaced by jsonobj_header is "+value);
							parser.changeValue(request_prefix+tag, value);
						}
					}
					catch(Exception e)
					{
						logger.info("Exception is "+e);
					}
				}
				if (tagValue.startsWith("formid~")) 
				{
					String value = (String) iformObj.getValue(tagValue.split("~")[1]);
					if(callName.equalsIgnoreCase("MSBCommodityMng") || callName.equalsIgnoreCase("MSBCommodityMng_sale"))
					{
					String DummytagName=tag;
						if(DummytagName.equalsIgnoreCase("UnitPrice"))
						{
							logger.info("Before formatting "+value);
							value=String.format("%.9f", Double.parseDouble(value));
							logger.info("After formatting "+value);
						}
						else if(DummytagName.equalsIgnoreCase("Quantity"))
						{
							logger.info("Before formatting "+value);
							value=String.format("%.9f",Double.parseDouble(value));
							logger.info("After formatting "+value);
						}
						else if(DummytagName.equalsIgnoreCase("LoanAppNum"))
						{
							String los_app_num=(String) iformObj.getValue("LOS_APPLICATION_NO");
							value=los_app_num+"-001";
						}
						
					}
					else if(callName.equalsIgnoreCase("MSBLimitMng_Enable_Update") || callName.equalsIgnoreCase("MSBLimitMng_Create_Update"))
					{
						String expiry_date_query="SELECT CONVERT(VARCHAR,DATEADD(DAY,(SELECT CAST(PARAM_VALUE AS INT) FROM NG_POS_PARAM_CONFIG WHERE PARAM_KEY='LIMITVALIDITY'),CONTRACT_DATE),23) FROM NG_POS_DISBURSAL_DATA WHERE WI_NAME = '"+getWorkitemName(iformObj)+"'  ";
						List<List<String>> expiry_date_result=iformObj.getDataFromDB(expiry_date_query);
						logger.info("Query for find expiry date using contract date is "+expiry_date_query+" and it's result is "+expiry_date_result);
						String expiry_date="";
						if(expiry_date_result.size()>0)
						{
							if(expiry_date_result.get(0).size()>0)
							{
								expiry_date=expiry_date_result.get(0).get(0);
							}
						}
						
						if(tag.equalsIgnoreCase("ExpiryDate"))
						{
							value=expiry_date;
						}
					}
					else if(callName.equalsIgnoreCase("RetrieveCommercialSummaryReport"))
					{
						logger.info("Inside RetrieveCommercialSummaryReport createrequestxml");
						String DummytagName=tag;
						if(DummytagName.equalsIgnoreCase("com:ENQUIRY_REFERENCE"))
						{
							String timestamp=new Timestamp(System.currentTimeMillis()).toString();
							logger.info("Setting Enquiy Reference for simah call "+timestamp);
							value=timestamp;
						}
					}
					else if(callName.equalsIgnoreCase("MSBLimitMng_Create"))
					{
						logger.info("Inside MSBLimitMng_Create createrequestxml");
						String tagValue_in_request=tagValue.split("~")[1];
						if(tagValue_in_request.equalsIgnoreCase("EXPIRY_DATE"))
						{
							logger.info("Inside Expiry date handling ");
							try
							{
								String contract_date=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CONTRACT_DATE");
								String expriy_limit=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_LIMIT_VALIDITY");
								String query="select dateadd(DD,"+expriy_limit+",cast('"+contract_date+"' as date))";
								logger.info("Query for enable limit and create limit is "+query);
								
								List<List<String>> expriy_Date= iformObj.getDataFromDB(query);	
								logger.info("Result of Query for enable limit and create limit is "+expriy_Date);
								if(expriy_Date.size()>0)
								{
									value=expriy_Date.get(0).get(0);
								}
							}
							catch(Exception e)
							{
								logger.info("Exception Occurred MSBLimitMng_Create ");
							}
						}
						
					}
					
					parser.changeValue(request_prefix+tag, value);
				}
				
			}
			logger.info("CreateRequestXML :Handling Language in Request ");
			logger.info("Language tag for "+callName+" present in proerty file or not ??? "+GetXML.getProp().containsKey(callName+"_LanguageTag"));
			if(GetXML.getProp().containsKey(callName+"_LanguageTag"))
			{
				logger.info("CreateRequestXML : Language tag is present in property file");
				String language_tag=GetXML.getProp().getProperty(callName+"_LanguageTag");
				logger.info("CreateRequestXML : Language tag value in property file is "+language_tag);
				String session_lang=(String) iformObj.getValue("SESSION_LANG");
				logger.info("CreateRequestXML : Session Language is "+session_lang);
				parser.changeValue(request_prefix+language_tag, session_lang);
				logger.info(request_prefix+language_tag+" got value "+session_lang);
			}
			
			logger.info("Request prefix is "+request_prefix+"please check");
			
			
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML is :\n" + parser.toString());
			String responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
	
			System.out.println("Response XML is: \n" + responseXML);
			//logger.info("Response XML is: \n" + responseXML);
		return responseXML;
		}catch(Exception e)
		{
			logger.info("Exception occurred: createRequestXML "+e);
			return "";
		}
	}
	
	public String createRequestXML_2(IFormReference iformObj, String callName) {
		try
		{
			logger.info("Inside createRequestXML Function and callName is " + callName);
			String tagName = "_TagName";
			
			String request_prefix=GetXML.getProp().getProperty(callName+"_RequestPrefix");
			if(request_prefix.equals(null))
			{
				request_prefix="";
			}
			logger.info("Request prefix is "+request_prefix+"please check");
			
			String header_tags=GetXML.getProp().getProperty(callName+"_Header");
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
		
			String tagNames = GetXML.getProp().getProperty(callName + tagName);
			logger.info(tagNames);
			String[] tags = tagNames.split(",");
	
			String requestXML = readDummyRequest(callName);
	
			XMLParser parser = new XMLParser(requestXML);
			
	
			for (String tag : tags) {
				String tagValue = parser.getValueOf(request_prefix+tag);
				logger.info("tag values are"+tagValue);
				if(tagValue.contains("header~"))
				{
					try 
					{
						if(tagValue.split("~")[1].equalsIgnoreCase("UUID"))
						{
							parser.changeValue(request_prefix+tag, java.util.UUID.randomUUID().toString());
						}
						else
						{
						String value=(String) jsonobj_header.get(tagValue.split("~")[1]);
						logger.info("Value to be replaced by jsonobj_header is "+value);
						parser.changeValue(request_prefix+tag, value);
						}
					}
					catch(Exception e)
					{
						logger.info("Exception is "+e);
					}
				}
				else if (tagValue.startsWith("formid~")) 
				{
					String value = (String) iformObj.getValue(tagValue.split("~")[1]);
					if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_ID_ISSUE_HJ") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_CR_ISSUE_HJ") )
					{
						if(value.length()==8)
							value = value.substring(4,8)+'-'+value.substring(2,4)+'-'+value.substring(0,2);
						parser.changeValue(request_prefix+tag, value);
						logger.info("Date with hash is:: "+value);
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_ID_EXPIRY_HJ") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_DATE_OF_BIRTH_HJ") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_CR_EXPIRY_HJ")  )
					{
						if(value.length()==8)
							value = value.substring(4,8)+'-'+value.substring(2,4)+'-'+value.substring(0,2);
						parser.changeValue(request_prefix+tag, value);
						logger.info("Date with hash is:: "+value);
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_ID_NO"))
					{
						value="0"+value;
						parser.changeValue(request_prefix+tag, value);
						logger.info("Date with hash is:: "+value);
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_MOBILE_NO"))
					{
						value="966"+value;
						parser.changeValue(request_prefix+tag, value);
						logger.info("Date with hash is:: "+value);
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_ID_TYPE"))
					{
						if(value.equalsIgnoreCase("Iqama"))
							value="02";
						else
							value="01";
						parser.changeValue(request_prefix+tag, value);
						logger.info("Date with hash is:: "+value);
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_ID_ISSUE_COUNTRY") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_COUNTRY") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_ID_ISSUE_COUNTRY") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_COUNTRY")  )
					{
						String query="SELECT COUNTRY_CODE FROM NG_MAST_Country_Main WHERE COUNTRY='"+value+"' ";
						try
						{
							List<List<String>> country_code= iformObj.getDataFromDB(query);	
							if(country_code.size()>0)
							{
								value=country_code.get(0).get(0);
							}
						}
						catch(Exception e)
						{
							logger.info("Exception Occurred: in Query "+query);
						}
						parser.changeValue(request_prefix+tag, value);
						logger.info("Country in short cic is:: "+value);
						
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_ID_ISSUE_REGION") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_REGION") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_ID_ISSUE_REGION") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_REGION") )
					{
						String query="SELECT CODE FROM NG_MAST_region WHERE REGION='"+value+"'";
						try
						{
							List<List<String>> region_code= iformObj.getDataFromDB(query);	
							if(region_code.size()>0)
							{
								value=region_code.get(0).get(0);
							}
						}
						catch(Exception e)
						{
							logger.info("Exception Occurred: in Query "+query);
						}
						parser.changeValue(request_prefix+tag, value);
						logger.info("Region in shortcic is:: "+value);
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_ID_ISSUE_CITY") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_ID_ISSUE_CITY") || tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_CITY"))
					{
						String query="SELECT CODE FROM NG_MAST_CITY WHERE CITY='"+value+"' ";
						try
						{
							List<List<String>> city_code= iformObj.getDataFromDB(query);	
							if(city_code.size()>0)
							{
								value=city_code.get(0).get(0);
							}
							int no_of_zeroes=8-value.length();
						    for(int i=0;i<no_of_zeroes;i++)
							{
						    	value='0'+value;
						    }
							
						}
						catch(Exception e)
						{
							logger.info("Exception Occurred: in Query "+query);
						}
						parser.changeValue(request_prefix+tag, value);
						logger.info("IssueDate in shortcic is:: "+value);
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_NATIONALITY"))
					{
						String query="SELECT CODE FROM NG_MAST_COUNTRY WHERE NATIONALITY='"+value+"' ";
						try
						{
							List<List<String>> nationality_code= iformObj.getDataFromDB(query);	
							if(nationality_code.size()>0)
							{
								value=nationality_code.get(0).get(0);
							}
						}
						catch(Exception e)
						{
							logger.info("Exception Occurred: in Query "+query);
						}
						parser.changeValue(request_prefix+tag, value);
						logger.info("Nationality in shortcic is:: "+value);
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_SECTOR"))
					{
						String query="SELECT SECTOR_CODE FROM NG_MAST_SECTOR WHERE SECTOR='"+value+"' ";
						try
						{
							List<List<String>> nationality_code= iformObj.getDataFromDB(query);	
							if(nationality_code.size()>0)
							{
								value=nationality_code.get(0).get(0);
							}
						}
						catch(Exception e)
						{
							logger.info("Exception Occurred: in Query "+query);
						}
						parser.changeValue(request_prefix+tag, value);
					}	
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_TITLE"))
					{
						String query="SELECT CODE FROM NG_MAST_TITLE WHERE TITLE='"+value+"' ";
						try
						{
							List<List<String>> title_code= iformObj.getDataFromDB(query);	
							if(title_code.size()>0)
							{
								value=title_code.get(0).get(0);
							}
						}
						catch(Exception e)
						{
							logger.info("Exception Occurred: in Query "+query);
						}
						parser.changeValue(request_prefix+tag, value);
						logger.info("TitleCode in shortcic is:: "+value);
					}//Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_DEFAULT_FLAG
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_DEFAULT_FLAG"))
					{
						logger.info("Value of company details default flag is "+value);
						if(value.equalsIgnoreCase("true"))
							value="Y";
						else if(value.equalsIgnoreCase("false"))
							value="N";
						parser.changeValue(request_prefix+tag, value);
						logger.info("UNN Number is:: "+value);
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_COMPANY_DETAILS_ID_TYPE"))
					{
						if(value.equalsIgnoreCase("UNN Number"))
							value="39";
						parser.changeValue(request_prefix+tag, value);
						logger.info("UNN Number is:: "+value);
					}
					else
						parser.changeValue(request_prefix+tag, value);
				}
				
			}
			
			String UpdatedXML="";	
			if(callName.equalsIgnoreCase("ShortCICMng_Corporate"))
			{
			logger.info("inside corporate details to be replaced" +callName);
			String ToBeReplaced = GetXML.getProp().getProperty(callName + "_ToBeReplaced");
			String tag[] = ToBeReplaced.split(",");
			logger.info("to be replaced tags" +ToBeReplaced);
			String ReplacedWith = GetXML.getProp().getProperty(callName + "_ReplacedWith");
			String tag1[] = ReplacedWith.split(",");
			logger.info("replaced tags" +ReplacedWith);
			
			for(int i=0; i<tag.length;i++)
			{

			if(i==0)
				UpdatedXML = parser.toString().replace(tag[i], tag1[i]);
			else
				UpdatedXML = UpdatedXML.replace(tag[i], tag1[i]);
			}
			System.out.println("\n\n\n\n\n\nUpdated XML "+UpdatedXML);
		}
		else if(callName.equalsIgnoreCase("ShortCICMng_Person"))
		{
			logger.info("inside person details to be replaced" +callName);
			String ToBeReplaced = GetXML.getProp().getProperty(callName + "_ToBeReplaced");
			String tag[] = ToBeReplaced.split(",");
			logger.info("to be replaced tags" +ToBeReplaced);
			String ReplacedWith = GetXML.getProp().getProperty(callName + "_ReplacedWith");
			String tag1[] = ReplacedWith.split(",");
			logger.info("replaced tags" +ReplacedWith);
			
			for(int i=0; i<tag.length;i++)
			{

			if(i==0)
				UpdatedXML = parser.toString().replace(tag[i], tag1[i]);
			else
				UpdatedXML = UpdatedXML.replace(tag[i], tag1[i]);
			}
			System.out.println("\n\n\n\n\n\nUpdated XML "+UpdatedXML);
		}
			
			logger.info("RequestXML is :\n" + UpdatedXML);
			String responseXML = new SocketConnector().getSocketXMLResponse(UpdatedXML, callName,iformObj);
	
			System.out.println("Response XML is: \n" + responseXML);
			//logger.info("Response XML is: \n" + responseXML);
		return responseXML;
		}catch(Exception e)
		{
			logger.info("Exception occurred: createRequestXML "+e);
			return "";
		}
	}

	public JSONObject setResponseData(IFormReference iformObj, String callName, String ResponseXML) 
	{
		
		JSONObject jsonobj = new JSONObject();
		try {
		
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			ResponseXML=ResponseXML.replace(temp,"");
	
		
		String tagName = "_TagNameResponse";	
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");
		

		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		
		logger.info(tagNames);
		String[] tags = tagNames.split(",");
		
		XMLParser parser = new XMLParser(ResponseXML);
		
		String status_code_in_response=parser.getValueOf(status_code_split[0]);
		
		logger.info("Status code in property file "+status_code_split[1]);
		logger.info("Status code in response file "+status_code_in_response);
		
		//Due to DDCAP call only, we are inclulding OK in this condition, if its not used in your code remove it.
		if(status_code_in_response.equalsIgnoreCase(status_code_split[1]) || status_code_in_response.equalsIgnoreCase("OK")) 
		{
			logger.info("Status code is success");
			for (String tag : tags) {
				//logger.info("Tag =" + tag);
				String[] key = tag.split("~");
				
				if(key[0].contains("#"))
				{
			    		if(!key[0].contains("@"))
			    		{
					    	String []parent_child_tags=key[0].split("#");
					    	logger.info("Length of hash String is "+parent_child_tags.length);
					    		String result=ResponseXML;
					    		for(int i=0;i<parent_child_tags.length;i++)
					    		{
					    			XMLParser internal_parser=new XMLParser(result);
					    			result=internal_parser.getValueOf(parent_child_tags[i]);
					    			logger.info("For "+parent_child_tags[i]+" result is "+result);
					    		}
					    		logger.info("Result returned by fillCRSData is"+result);
					    		jsonobj.put(key[1],result.trim());
			    		}
			    		else
			    		{
			    			String[] inputTagswithoutRateSign = key[0].split("@");
					    	String []parent_child_tags=inputTagswithoutRateSign[0].split("#");
					    	logger.info("Length of hash String is "+parent_child_tags.length);
					    		String result=ResponseXML;
					    		for(int i=0;i<parent_child_tags.length;i++)
					    		{
					    			XMLParser internal_parser=new XMLParser(result);
					    			result=internal_parser.getValueOf(parent_child_tags[i]);
					    			logger.info("For "+parent_child_tags[i]+" result is "+result);
					    		}
					    	logger.info("Result returned by fillCRSData with @ is"+result);
					    	String returned_value="",query="";
					    	try 
					    	{
			    				query="SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y'" ;
						    	logger.info("Query to replace key with value is"+query);
				    			List<List<String>> code_values = iformObj.getDataFromDB(query);
				    			
					    			if(code_values.size()>0)
					    			{
					    				returned_value=code_values.get(0).get(0);
					    			}
			    			}
			    			catch(Exception e)
			    			{
			    				logger.info("Exception occurred: setResponseData: Database Query "+query+" and stack trace is"+e);
			    				
			    			}
					    	
			    			jsonobj.put(key[1], returned_value.trim());
			    		}
				}
				else
				{	
					if(!key[0].contains("@"))
					{
						String tagValue = parser.getValueOf(key[0]);
						jsonobj.put(key[1], tagValue.trim());
					}
					else
					{
						String []inputTagswithoutRateSign=key[0].split("@");
						String tagValue = parser.getValueOf(inputTagswithoutRateSign[0]);
		    			String returned_value="",query="";
		    			try {
			    			query="SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+tagValue+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y'" ;
			    			logger.info("Query to replace key with value is"+query);
			    			List<List<String>> code_values = iformObj.getDataFromDB(query);
			    			
			    			if(code_values.size()>0)
				    			{
				    				returned_value=code_values.get(0).get(0);
				    			}
		    			}
		    			catch(Exception e)
		    			{
		    				logger.info("Exception occurred: setResponseData: Database Query "+query+" and stack trace is"+e);
		    				
		    			}
		    			//returned_value = returned_value.substring(1, returned_value.length() - 1);
		    			jsonobj.put(key[1], returned_value.trim());
					}
				}
				
			}
		}
			else
			{
				logger.info("For "+callName+" Status code returned from response is not success ");
			}	
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: createRequestXML "+e);
		}
		
		logger.info("For callname "+callName+" JSONObject for setResponseData is"+jsonobj);
		return jsonobj;
	}







	public JSONObject setResponseData_2(IFormReference iformObj, String callName, String ResponseXML) {
		
		JSONObject jsonobj = new JSONObject();
		try {
		
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			ResponseXML=ResponseXML.replace(temp,"");
	
		
		String tagName = "_TagNameResponse";	
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");
		

		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		
		logger.info(tagNames);
		String[] tags = tagNames.split(",");
		
		XMLParser parser = new XMLParser(ResponseXML);
		
		String status_code_in_response=parser.getValueOf(status_code_split[0]);
		if(status_code_in_response.equalsIgnoreCase(status_code_split[1]) || status_code_in_response.equalsIgnoreCase("OK"))
		{
			logger.info("As callname is RetrieveCommercialSummaryReport");
			if(callName.equalsIgnoreCase("RetrieveCommercialSummaryReport"))
			{
				iformObj.setValue("SIMAH_COMM_STATUS", "Success");
				logger.info("As callname is RetrieveCommercialSummaryReport and status code is success, value of SIMAH_COMM_STATUS is success");
			}
			
			for (String tag : tags) {
				//logger.info("Tag =" + tag);
				String[] key = tag.split("~");
				
				if(key[0].contains("#"))
				{
			    		if(!key[0].contains("@"))
			    		{
					    	String []parent_child_tags=key[0].split("#");
					    	logger.info("Length of hash String is "+parent_child_tags.length);
					    		String result=ResponseXML;
					    		for(int i=0;i<parent_child_tags.length;i++)
					    		{
					    			XMLParser internal_parser=new XMLParser(result);
					    			result=internal_parser.getValueOf(parent_child_tags[i]);
					    			logger.info("For "+parent_child_tags[i]+" result is "+result);
					    		}
					    		logger.info("Result returned by fillCRSData is"+result);
					    		jsonobj.put(key[1],result.trim());
			    		}
			    		else
			    		{
			    			String[] inputTagswithoutRateSign = key[0].split("@");
					    	String []parent_child_tags=inputTagswithoutRateSign[0].split("#");
					    	logger.info("Length of hash String is "+parent_child_tags.length);
					    		String result=ResponseXML;
					    		for(int i=0;i<parent_child_tags.length;i++)
					    		{
					    			XMLParser internal_parser=new XMLParser(result);
					    			result=internal_parser.getValueOf(parent_child_tags[i]);
					    			logger.info("For "+parent_child_tags[i]+" result is "+result);
					    		}
					    	logger.info("Result returned by fillCRSData with @ is"+result);
					    	String returned_value="",query="";
					    	try {
			    				query="SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y'" ;
						    	logger.info("Query to replace key with value is"+query);
				    			List<List<String>> code_values = iformObj.getDataFromDB(query);
				    			
					    			if(code_values.size()>0)
					    			{
					    				returned_value=code_values.get(0).get(0);
					    			}
			    			}
			    			catch(Exception e)
			    			{
			    				logger.info("Exception occurred: setResponseData: Database Query "+query+" and stack trace is"+e);
			    				
			    			}
					    	
			    			jsonobj.put(key[1], returned_value.trim());
			    		}
				}
				else
				{	
					if(!key[0].contains("@"))
					{
						String tagValue = parser.getValueOf(key[0]);
						jsonobj.put(key[1], tagValue.trim());
					}
					else
					{
						String []inputTagswithoutRateSign=key[0].split("@");
						String tagValue = parser.getValueOf(inputTagswithoutRateSign[0]);
		    			String returned_value="",query="";
		    			try {
			    			query="SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+tagValue+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y'" ;
			    			logger.info("Query to replace key with value is"+query);
			    			List<List<String>> code_values = iformObj.getDataFromDB(query);
			    			
			    			if(code_values.size()>0)
				    			{
				    				returned_value=code_values.get(0).get(0);
				    			}
		    			}
		    			catch(Exception e)
		    			{
		    				logger.info("Exception occurred: setResponseData: Database Query "+query+" and stack trace is"+e);
		    				
		    			}
		    			//returned_value = returned_value.substring(1, returned_value.length() - 1);
		    			jsonobj.put(key[1], returned_value.trim());
					}
				}
				
			}
		}
			else
			{
				String error_description=parser.getValueOf("StatusDesc");
				if(callName.equalsIgnoreCase("MSBContractMng"))
				{
					if(status_code_in_response.equalsIgnoreCase("E090818"))
					{
						String arr_ref_no=parser.getValueOf("ArrangementID");
						iformObj.setValue("Q_NG_POS_APPLICATION_DATA_REF_NO_MASTER_AGRMNT", arr_ref_no);
						logger.info("For "+callName+" Status code returned from response is not success & arragement id is "+arr_ref_no);
						jsonobj.put("Error","In "+callName+", "+error_description+" and arrangement id is "+arr_ref_no);
						logger.info("For callname "+callName+" JSONObject for setResponseData is"+jsonobj);
						return jsonobj;
					}
					
				}
				else if (callName.equalsIgnoreCase("MSBContractMngChild") || callName.equalsIgnoreCase("MSBContractMngChild_With_GP_With_Capitalization") || callName.equalsIgnoreCase("ContractMngChild_With_GP_Without_Payment") || callName.equalsIgnoreCase("MSBContractMngChild_With_GP_With_Int_Payment") || callName.equalsIgnoreCase("MSBContractMngChild_Without_GP")  )
				{
					if(status_code_in_response.equalsIgnoreCase("E090818"))
					{
						String arr_ref_no=parser.getValueOf("ArrangementID");
						iformObj.setValue("Q_NG_DIS_STIPULATE_AND_SELL_STIPULATION_ARRGMNT_REF_NO", arr_ref_no);
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");//("yyyy-MM-dd");  
						LocalDateTime now = LocalDateTime.now();  
						
						iformObj.setValue("Q_NG_DIS_STIPULATE_AND_SELL_STIPULATION_DATE", dtf.format(now));
						logger.info("For "+callName+" Status code returned from response is not success & arragement id is "+arr_ref_no);
						jsonobj.put("Error","In "+callName+", "+error_description+" and arrangement id is "+arr_ref_no);
						logger.info("For callname "+callName+" JSONObject for setResponseData is"+jsonobj);
						return jsonobj;
					}
				}
				else if (callName.equalsIgnoreCase("MSBCommodityMng"))
				{
					if(status_code_in_response.equalsIgnoreCase("E090818"))
					{
						String trans_ref_no=parser.getValueOf("TrxnRef");
						String trans_status=parser.getValueOf("T24TrxnStatus");
						iformObj.setValue("Q_NG_DIS_COMMODITY_PURCHASE_TRANSACT_REFERENCE", trans_ref_no);
						iformObj.setValue("Q_NG_DIS_COMMODITY_PURCHASE_COMMODITY_STATUS", trans_status);
						logger.info("For "+callName+" Status code returned from response is not success & Transation Reference id is "+trans_ref_no);
						jsonobj.put("Error","In "+callName+", "+error_description+" & Transation Reference id is "+trans_ref_no);
						logger.info("For callname "+callName+" JSONObject for setResponseData is"+jsonobj);
						return jsonobj;
					}
				}
				else if (callName.equalsIgnoreCase("MSBCommodityMng_sale"))
				{
					if(status_code_in_response.equalsIgnoreCase("E090818"))
					{
						String trans_ref_no=parser.getValueOf("TrxnRef");
						String trans_status=parser.getValueOf("T24TrxnStatus");
						iformObj.setValue("Q_NG_DIS_COMMODITY_PURCHASE_TXN_REFERENCE", trans_ref_no);
						iformObj.setValue("Q_NG_DIS_COMMODITY_PURCHASE_TXN_STATUS", trans_status);
						logger.info("For "+callName+" Status code returned from response is not success & Transation Reference id is "+trans_ref_no);
						jsonobj.put("Error","In "+callName+", "+error_description+" & Transation Reference id is "+trans_ref_no);
						logger.info("For callname "+callName+" JSONObject for setResponseData is"+jsonobj);
						return jsonobj;
					}
				}
				else if (callName.equalsIgnoreCase("MSBCommodityMng_sale"))
				{
					if(status_code_in_response.equalsIgnoreCase("E090818"))
					{
						String trans_ref_no=parser.getValueOf("TrxnRef");
						String trans_status=parser.getValueOf("T24TrxnStatus");
						iformObj.setValue("Q_NG_DIS_COMMODITY_PURCHASE_TXN_REFERENCE", trans_ref_no);
						iformObj.setValue("Q_NG_DIS_COMMODITY_PURCHASE_TXN_STATUS", trans_status);
						logger.info("For "+callName+" Status code returned from response is not success & Transation Reference id is "+trans_ref_no);
						jsonobj.put("Error","In "+callName+", "+error_description+" & Transation Reference id is "+trans_ref_no);
						logger.info("For callname "+callName+" JSONObject for setResponseData is"+jsonobj);
						return jsonobj;
					}
				}
				else if (callName.equalsIgnoreCase("MSBAcctMng"))
				{
					if(status_code_in_response.equalsIgnoreCase("E102400"))
					{
						String t24_acc_no=parser.getValueOf("T24RepmtAcctNum");
						iformObj.setValue("Q_NG_POS_APPLICATION_DATA_T24_ACC_NO", t24_acc_no);
						logger.info("For "+callName+" Status code returned from response is not success & Repayment Acc no is "+t24_acc_no);
						jsonobj.put("Error","In "+callName+", "+error_description+" & Transation Reference id is "+t24_acc_no);
						logger.info("For callname "+callName+" JSONObject for setResponseData is"+jsonobj);
						return jsonobj;
					}
				}
				else if (callName.equalsIgnoreCase("MSBLimitMng_Create"))
				{
					if(status_code_in_response.equalsIgnoreCase("E102403"))
					{
						//StatusDesc~Q_NG_POS_APPLICATION_DATA_T24_LMT_CRTN_STATUS,T24LimitRef~T24_LIMIT_REF
						String limit_ref_no=parser.getValueOf("T24LimitRef");
						iformObj.setValue("Q_NG_POS_APPLICATION_DATA_T24_LMT_CRTN_STATUS", "Success");
						iformObj.setValue("T24_LIMIT_REF",limit_ref_no);
						jsonobj=new JSONObject();
						return jsonobj;
						//jsonobj.put("Error","In "+callName+", "+error_description+" & Limit Reference no is "+limit_ref_no);
					}
				
				}
				else if (callName.equalsIgnoreCase("MSBLimitMng_Enable"))
				{
					if(status_code_in_response.equalsIgnoreCase("E102403"))
					{
						//StatusDesc~Q_NG_POS_APPLICATION_DATA_T24_LMT_ENBL_STATUS,T24LimitRef~Q_NG_POS_APPLICATION_DATA_LIMIT_REF_PARENT
						String limit_ref_no=parser.getValueOf("T24LimitRef");
						iformObj.setValue("Q_NG_POS_APPLICATION_DATA_LIMIT_REF_PARENT", limit_ref_no);
						iformObj.setValue("Q_NG_POS_APPLICATION_DATA_T24_LMT_ENBL_STATUS","Success");
						jsonobj.put("Error","In "+callName+", "+error_description+" & Limit Reference no is "+limit_ref_no);
						return jsonobj;
					}
				
				}
				else if (callName.equalsIgnoreCase("MSBCommodityMng_LoanDisbursement"))
				{
					if(status_code_in_response.equalsIgnoreCase("E102401"))
					{
						//StatusDesc~Q_NG_POS_APPLICATION_DATA_T24_LMT_ENBL_STATUS,T24LimitRef~Q_NG_POS_APPLICATION_DATA_LIMIT_REF_PARENT
						iformObj.setValue("FIN_DISBURSEMENT_FLAG","Success");
						jsonobj.put("Error","In "+callName+", "+error_description);
						return jsonobj;
					}
				
				}
				else if(callName.equalsIgnoreCase("RetrieveCommercialSummaryReport"))
				{
					if(status_code_in_response.equalsIgnoreCase("E064016"))
					{
						String msg=parser.getValueOf("StatusDesc");
						if(msg==null)
							msg="";
						logger.info("Im Commercial Summary error recieved with message "+msg);
						iformObj.setValue("SIMAH_COMM_STATUS", msg);
						
						jsonobj.put("Q_NG_POS_SIMAH_BASIC_DETAILS_SERVICE",parser.getValueOf("SERVICE"));
						jsonobj.put("Q_NG_POS_SIMAH_BASIC_DETAILS_ACTION",parser.getValueOf("ACTION"));
						jsonobj.put("Q_NG_POS_SIMAH_BASIC_DETAILS_MEMBER_ID",parser.getValueOf("MEMBER_ID"));
						jsonobj.put("Q_NG_POS_SIMAH_BASIC_DETAILS_USER_ID",parser.getValueOf("USER_ID"));
						jsonobj.put("Q_NG_POS_SIMAH_BASIC_DETAILS_RUN_NO",parser.getValueOf("RUN_NO"));
						jsonobj.put("Q_NG_POS_SIMAH_BASIC_DETAILS_ERROR_ITEMS",parser.getValueOf("ERR_ITEMS"));
						jsonobj.put("Q_NG_POS_SIMAH_BASIC_DETAILS_REFERENCE_NO",parser.getValueOf("ENQUIRY_REFERENCE"));
						
						return jsonobj;
					}
				}
				else if(callName.equalsIgnoreCase("DDCAP_Cancel"))
				{
					if(status_code_in_response.equalsIgnoreCase("DEAL-CANCELLED") || status_code_in_response.equalsIgnoreCase("DEAL-COMPLETED") || status_code_in_response.equalsIgnoreCase("OK"))
					{
						jsonobj.put("DDCAP_CANCEL_FLAG",status_code_in_response);
						return jsonobj;
					}
				}
							
				//MSBAcctMng
				logger.info("For "+callName+" Status code returned from response is not success ");
				jsonobj.put("Error","In "+callName+" error received with error code "+status_code_in_response+"-"+error_description);
				
			}
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: createRequestXML "+e);
			
		}
		
		logger.info("For callname "+callName+" and "+getWorkitemName(iformObj)+" JSONObject for setResponseData is"+jsonobj);
		return jsonobj;
	}

	public JSONObject setResponseDataGrid(IFormReference iformObj, String callName, String ResponseXML)
	{
		JSONObject return_obj=new JSONObject();
		
		try
		{
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			ResponseXML=ResponseXML.replace(temp,"");
	
		//logger.info("Response XML received by setResponseDataGrid is"+ResponseXML);
		String tagName = "_TagNameResponseGrid";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		logger.info(tagNames);
		
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");
		
		String[] tagValue = tagNames.split(",");
		for(String tag: tagValue)
		{
			String []tags=tag.split("~");
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(ResponseXML);
			logger.info("objWFxmlResponse value is "+objWFxmlResponse);

			JSONArray jsonarr=new JSONArray();
			
			logger.info("Status codes are"+status_code_split[0]+"and"+status_code_split[1]);
			
			logger.info("Value of status tag in response is"+objWFxmlResponse.getVal(status_code_split[0]));
			
			if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
			//logger.info("Wfmxmlsit is --------------"+WFXmlList);
			for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) {
			
				JSONObject jsonobj = new JSONObject();
				for(int j=2;j<tags.length-1;++j)
				{
				
					String tag_split_values=tags[j];
					if((!tag_split_values.contains("@")))
					{
						String []hash_split_values=tag_split_values.split("#");
						String result_from_response=WFXmlList.getVal(hash_split_values[1]);
						
						if(result_from_response.equals(null) || result_from_response.equals(""))
						{
							result_from_response="";
						}
						jsonobj.put(hash_split_values[0],result_from_response.trim());
					}
					else
					{
						String []inputTagswithoutRateSign=tag_split_values.split("@");
						
						String []hash_split_values=inputTagswithoutRateSign[0].split("#");
						String result_from_response=WFXmlList.getVal(hash_split_values[1]);
						if(result_from_response.equals(null) || result_from_response.equals(""))
						{
							result_from_response=" ";
						}
						String returned_value="",query="";
		    			try
		    			{
			    			query="SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result_from_response+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y'" ;
			    			logger.info("Query to replace key with value is"+query);
			    			List<List<String>> code_values = iformObj.getDataFromDB(query);
			    			
				    			if(code_values.size()>0)
				    			{	
				    				returned_value=code_values.get(0).get(0);
				    			}
		    			}catch(Exception e)
		    			{
		    				logger.info("Exception occurred: setResponseDataGrid: Database Query "+query+" and stack trace is"+e);
		    			}
		    			
		    			jsonobj.put(hash_split_values[0],returned_value.trim());
		    			
					}
				}
				logger.info(jsonarr);
				jsonarr.add(jsonobj);
			}
			return_obj.put(tags[tags.length-1], jsonarr);
			
			}
			else
			{
				logger.info("For "+callName+" Status code returned from response is not success ");
			}
			
		}
			logger.info("Returning object is"+return_obj);
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: setResponseDataGrid "+e);
		}
		
		logger.info("For callname "+callName+" JSONObject for setResponseDataGrid is"+return_obj);
		return return_obj;
	}
	public String setResponseToDropdown(IFormReference iformObj, String callName, String ResponseXML) {
		
		try {
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			ResponseXML=ResponseXML.replace(temp,"");
		
		logger.info("Response XML received by setResponseDataGrid is" + ResponseXML);
		String tagName = "_TagNameResponseGrid";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		logger.info(tagNames);
		
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");

		
		String[] tagValue = tagNames.split(",");
		for (String tag : tagValue) {
			String[] tags = tag.split("~");
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(ResponseXML);
			logger.info("objWFxmlResponse value is " + objWFxmlResponse);
			JSONArray jsonarr = new JSONArray();
			
			if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
				WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0], tags[1]);
				logger.info("Wfmxmlsit is --------------" + WFXmlList);
				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) {

					JSONObject jsonobj = new JSONObject();
					logger.info("iiiiiiiiii" + i);
					for (int j = 2; j <=tags.length - 1; ++j) {
						String one = tags[j];
						String[] temp = one.split("#");
						String xyz = WFXmlList.getVal(temp[1]);
						logger.info(xyz);
						iformObj.addItemInCombo(temp[0], xyz.trim(), xyz.trim());

					}

				}
			}
			else
			{
				logger.info("For "+callName+" Status code returned from response is not success ");
			}
		}
			
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: setResponseToDropdown "+e);
		}
		return "";

	}
	
	public  org.json.JSONObject executePOSTRequest( org.json.JSONObject requestJSON,String URL) 
	{
		DefaultHttpClient httpclient = new DefaultHttpClient();

      //  httpclient.getCredentialsProvider().setCredentials(
            //    new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT), 
              //  new UsernamePasswordCredentials("FTSRAJB", "ftsrajb"));
		  
	
		//setting common headers
		//httpPost.setHeader(AUTH_HEADER_NAME,properties.getProperty(AUTH_TOKEN));
		//httpPost.setHeader(HttpHeaders.CONTENT_TYPE,CONTENT_TYPE_APPLICATION_JSON);
		//httpPost.setHeader(EXECUTABLE_HANDLER_HEADER_NAME,executableHandlerHeaderValue);		
		//setting URI
		logger.info("Request in executePOSTRequest is  "+requestJSON);
		HttpPost httpPost = new HttpPost();
		httpPost.setURI(URI.create(URL));
		
		try{
			//setting request body
			httpPost.setEntity(new StringEntity(requestJSON.toString()));
			
			//executing request
			long beginTime = System.currentTimeMillis();
			HttpResponse httpResponse = httpclient.execute(httpPost);//HttpClientBuilder.create().build().execute(httpPost);
			logger.info("In executePOSTRequest httpResponseCode is  "+httpResponse);
			//calculating response time in seconds
			double timeTaken = (System.currentTimeMillis() - beginTime) / 1000D;
			logger.info("In executePOSTRequest timeTaken is  "+timeTaken);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuilder responseBuilder = new StringBuilder();
			String data = null;
			//reading response data
			while(( data = bufferedReader.readLine())!=null)
				responseBuilder.append(data);
			String response = responseBuilder.toString();
			logger.info("In executePOSTRequest response string is  "+response);
			if(httpResponse.getStatusLine().getStatusCode()!=200)
			{
				return new org.json.JSONObject();
			}
			org.json.JSONObject responseJSONObject = new org.json.JSONObject(response);
			responseJSONObject.put("timeTaken", timeTaken);
			logger.info("In executePOSTRequest responseJSONObject is  "+responseJSONObject);
			return responseJSONObject;
		}
		
		catch(Exception ex)
		{
			logger.info("In executePOSTRequest exception is  "+ex);
		}
		return new org.json.JSONObject();
	}// end of function
	
	public org.json.JSONObject executeGETurl(String marchantID) 
	{
		logger.info("inside GET execute with marchantID === " + marchantID);
		org.json.JSONObject responseJSONObject = null;
		try {
			String url = "http://10.98.118.47:4001/tmsrpa/"+ marchantID + "";
			URL urldemo = new URL(url);
			long beginTime = System.currentTimeMillis();
			URLConnection yc = urldemo.openConnection();
			logger.info(" URL Input Stream ================ " + new InputStreamReader(yc.getInputStream()));
			double timeTaken = (System.currentTimeMillis() - beginTime) / 1000D;
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			StringBuilder responseBuilder = new StringBuilder();
			String data = null;
			// reading response data
			while ((data = in.readLine()) != null) {
				responseBuilder.append(data);
			}
			String response = responseBuilder.toString();
			if (response != "" || response != null) {
				logger.info("====== fatched Response :" + response);
				responseJSONObject = new org.json.JSONObject(response);
				responseJSONObject.put("timeTaken", timeTaken);
				logger.info("====== JSON Response :" + responseJSONObject.toString(4));
			}

			else {
				responseJSONObject = new org.json.JSONObject();
			}

		} catch (Exception e) {
			logger.info("====== GET EXCEPTION :\n\n"+e);
			e.printStackTrace();
		}
		return responseJSONObject;
	}// end of fun
	
	public String setResponseDataSearchScreen(IFormReference iformObj, String callName, String ResponseXML)
	{
		
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			ResponseXML=ResponseXML.replace(temp,"");
		
		
		String tagName = "_TagNameResponse";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		logger.info(tagNames);
		String[] tags = tagNames.split(",");
 
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		
		String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
		
		XMLParser parser = new XMLParser(ResponseXML);
		String values="( '"+cic_number+"',";
		String query="";
		String columnames="CIC_NO,";
		String insertinto="INSERT INTO ";
		String tablename=GetXML.getProp().getProperty(callName+"_Table");
		
		String delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table is emptied :: "+delete_query);
		
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");
		String status_code_in_response=parser.getValueOf(status_code_split[0]);
		if(status_code_in_response.equalsIgnoreCase(status_code_split[1]))
		{
			String tagValue;
			for (String tag : tags) {
				logger.info("Tag =" + tag);
				String[] key = tag.split("~");
				logger.info("Key is "+key[0]);
				if(key[0].contains("#"))
				{
					if(!key[0].contains("@"))
		    		{
						String []parent_child_tags=key[0].split("#");
				    	logger.info("Length of hash String is "+parent_child_tags.length);
				    	String result=ResponseXML;
				    	for(int i=0;i<parent_child_tags.length;i++)
				    	{
				    		XMLParser internal_parser=new XMLParser(result);
				    		result=internal_parser.getValueOf(parent_child_tags[i]);
				    		result=result.replace("'","''");
				    	}
				    	tagValue=result;
		    		}
					else
					{
						String[] inputTagswithoutRateSign = key[0].split("@");
				    	String []parent_child_tags=inputTagswithoutRateSign[0].split("#");
				    	logger.info("Length of hash String is "+parent_child_tags.length);
				    		String result=ResponseXML;
				    		for(int i=0;i<parent_child_tags.length;i++)
				    		{
				    			XMLParser internal_parser=new XMLParser(result);
				    			result=internal_parser.getValueOf(parent_child_tags[i]);
				    			logger.info("For "+parent_child_tags[i]+" result is "+result);
				    		}
				    	String internal_query="";
				    	internal_query="(SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y' )";
					    logger.info("Query to replace key with value is"+internal_query);
				    	tagValue=internal_query;
					}
				}
				else
				{
					if(!key[0].contains("@"))
					{
						tagValue = parser.getValueOf(key[0]);
					}
					else
					{
						String []inputTagswithoutRateSign=key[0].split("@");
						String result = parser.getValueOf(inputTagswithoutRateSign[0]);
		    			String internal_query="";
		    			
		    			internal_query="(SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y' )" ;
			    		logger.info("Query to replace key with value is"+internal_query);
						tagValue=internal_query;
					}
					
				}
				
				logger.info("Tag Value Derived from ResponseXML is " + tagValue);
				logger.info("Key 2 =" + key[1]);
				tagValue=tagValue.replace("'","''");
				
				
				if(tagValue.contains("SELECT PARAM_VALUE"))
				{
					values=values+tagValue+",";
				}
				else
				{
					if(key[1].contains("$"))
						values=values+"'"+tagValue.trim()+"',";
					else
						values=values+"N'"+tagValue.trim()+"',";
				}
				
				columnames=columnames+key[1].replace("$","")+",";
			}
			
			columnames=columnames+"ENTRY_DATE_TIME";
			values=values+"'"+date+"')";

			query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
			logger.info("Query for "+callName+" setting response in search screen tables is"+query);
			if(values.trim()!="")
				iformObj.saveDataInDB(query);	
		}
		else
		{
			logger.info("For "+callName+" Status code returned from response is not success ");
		}
		
		return "";
	}
	
	public String setResponseDataGridSearchScreen(IFormReference iformObj, String callName, String ResponseXML)
	{
		
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			ResponseXML=ResponseXML.replace(temp,"");
		
		logger.info("Response XML received by setResponseDataGrid is"+ResponseXML);
		String tagName = "_TagNameResponseGrid";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		
		logger.info(tagNames);
		String[] tagValue = tagNames.split(",");
		
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String cic_number="";
		if(callName.equalsIgnoreCase("MSBAcctsDataInq_OldCIC_SearchScreen") || callName.equalsIgnoreCase("MSBAcctsDataInq_OldCIC_ClosingBalance") || callName.equalsIgnoreCase("MSBAcctsDataInq_OldCIC_AccountStatus") || callName.equalsIgnoreCase("MerchantPOSTrxnsSummaryInq_OldCIC_SearchScreen") )
		{
			cic_number=getControlValue(iformObj, "MSB_SEARCH_OLD_CIC_NUMBER_2");
		}
		else
		{
			cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
		}
		
		String values=" ";
		String query="";
		String columnames="CIC_NO,";
		String insertinto="INSERT INTO ";
		String tablename=GetXML.getProp().getProperty(callName+"_Table_Grid");
		
		String delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table is emptied :: "+delete_query);
		
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");
		
		
		for(String tag: tagValue)
		{
			String []tags=tag.split("~");
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(ResponseXML);
			logger.info("objWFxmlResponse value is "+objWFxmlResponse);
			
			columnames="CIC_NO,";
			values=" ";
			for(int j=2;j<tags.length;++j)
			{
				String tag_split_values=tags[j];
				logger.info("Tag values split to set column names"+tag_split_values);
				String []hash_split_values=tag_split_values.split("#");
				columnames=columnames+hash_split_values[0].replace("$","")+",";
			}
			
			columnames=columnames+"ENTRY_DATE_TIME";
			logger.info("column names are"+columnames);
			
			if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
			logger.info("Wfmxmlsit is --------------"+WFXmlList);
			for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
			{
				values=values+"( '"+cic_number+"',";
				
				for(int j=2;j<tags.length;++j)
				{
					String tag_split_values=tags[j];
					if((!tag_split_values.contains("@")))
					{
						String []hash_split_values=tag_split_values.split("#");
						String result_from_response=WFXmlList.getVal(hash_split_values[1]);
						result_from_response=result_from_response.replace("'","''");
						if(result_from_response== null || result_from_response=="")
						{
							result_from_response="";
						}
						else if(callName.equalsIgnoreCase("MerchantPOSTrxnsSummaryInq_SearchScreen") || callName.equalsIgnoreCase("MerchantPOSTrxnsSummaryInq_OldCIC_SearchScreen"))
						{
							if(hash_split_values[0].equalsIgnoreCase("THROUGHPUT") || hash_split_values[0].equalsIgnoreCase("AVG_TRANSACTN_AMT"))
							{
								String temp=result_from_response;
								try
								{
									result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
								}
								catch(Exception e)
								{
									result_from_response=temp;
								}
							}
						}
						else if(callName.equalsIgnoreCase("MSBAcctsDataInq_SearchScreen") || callName.equalsIgnoreCase("MSBAcctsDataInq_OldCIC_SearchScreen"))
						{
							if(hash_split_values[0].equalsIgnoreCase("DEPOSIT") || hash_split_values[0].equalsIgnoreCase("WITHDRAWAL") || hash_split_values[0].equalsIgnoreCase("AVG_BAL") || hash_split_values[0].equalsIgnoreCase("NEG_BAL") || hash_split_values[0].equalsIgnoreCase("THROUGHPUT"))
							{
								String temp=result_from_response;
								try
								{
									result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
								}
								catch(Exception e)
								{
									result_from_response=temp;
								}
							}
						}
						else if(callName.equalsIgnoreCase("MSBAcctsDataInq_ClosingBalance") || callName.equalsIgnoreCase("MSBAcctsDataInq_OldCIC_ClosingBalance"))
						{
							if(hash_split_values[0].equalsIgnoreCase("CLOSING_BALANCE"))
							{
								String temp=result_from_response;
								try
								{
									result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
								}
								catch(Exception e)
								{
									result_from_response=temp;
								}
							}
						}
						else if(callName.equalsIgnoreCase("CustOutstandingInq_SearchScreen"))
						{
							if(hash_split_values[0].equalsIgnoreCase("GROSS_AMT") || hash_split_values[0].equalsIgnoreCase("FIN_AMT") || hash_split_values[0].equalsIgnoreCase("GROSS_OUTSDING") || hash_split_values[0].equalsIgnoreCase("OUTSTDNG_PRINCIPAL") || hash_split_values[0].equalsIgnoreCase("OUTSTDNG_PROFIT") || hash_split_values[0].equalsIgnoreCase("INSTALLMENT") || hash_split_values[0].equalsIgnoreCase("PROFIT_PERCENT")  )
							{
								String temp=result_from_response;
								try
								{
									result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
								}
								catch(Exception e)
								{
									result_from_response=temp;
								}
							}
						}
						else if(callName.equalsIgnoreCase("MSBFacilitiesDataInq_SearchScreen"))
						{
							if(hash_split_values[0].equalsIgnoreCase("INSTL_AMT") || hash_split_values[0].equalsIgnoreCase("AVAIL_DRAWDOWN") || hash_split_values[0].equalsIgnoreCase("UTILIZED_AMT") || hash_split_values[0].equalsIgnoreCase("ELIG_LIMIT_AMT") )
							{
								String temp=result_from_response;
								try
								{
									result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
								}
								catch(Exception e)
								{
									result_from_response=temp;
								}
							}
						}
						if(hash_split_values[0].contains("$"))
							values=values+"'"+result_from_response.trim()+"',";
						else
							values=values+"N'"+result_from_response.trim()+"',";
					}
					else
					{
						String []inputTagswithoutRateSign=tag_split_values.split("@");
						String []hash_split_values=inputTagswithoutRateSign[0].split("#");
						String result_from_response=WFXmlList.getVal(hash_split_values[1]);
						if(result_from_response.equals(null) || result_from_response.equals(""))
						{
							result_from_response=" ";
						}
						String internal_query="";
						internal_query="( SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result_from_response+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y' )" ;
						values=values+internal_query+",";
					}		
				}
				
				values=values+"'"+date+"'),";
			}
			
			if (values.endsWith(",")) 
			{
				values = values.substring(0, values.length() - 1);
			}
			
			logger.info("Final column variables are"+columnames);
			logger.info("values are"+values);
			
			query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
			logger.info("Query for setting response in search screen tables is"+query);
				if(values.trim()!="")
					iformObj.saveDataInDB(query);	
			}
			else
			{
				logger.info("For "+callName+" Status code returned from response is not success ");
			}
			
		}
		
		return "";
	}
	
	public String setResponseDataGridApprovedSales(IFormReference iformObj, String callName, String ResponseXML,String cic_no,
			String wi_name)
	{
		logger.info("Inside handling of setResponseDataGridApprovedSales where wi_name is "+wi_name+" and cic_no is "+cic_no+" and callName is "+callName);
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			ResponseXML=ResponseXML.replace(temp,"");
		
		logger.info("Response XML received by setResponseDataGridApprovedSales is"+ResponseXML);
		String tagName = "_TagNameResponseGrid";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		
		logger.info(tagNames);
		String[] tagValue = tagNames.split(",");
		
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String cic_number=cic_no;
		
		String values=" ";
		String query="";
		String columnames="";
		String insertinto="INSERT INTO ";
		String tablename=GetXML.getProp().getProperty(callName+"_Table_Grid");
		String delete_query="";
		if(callName.equalsIgnoreCase("CustOutstandingInq_GroupExposure"))
		{
			delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_no+"' ";
			iformObj.saveDataInDB(delete_query);
			logger.info("With this query table is emptied :: "+delete_query);
		}
		else
		{
			delete_query="DELETE FROM "+tablename+" where WI_NAME= '"+wi_name+"' ";
			iformObj.saveDataInDB(delete_query);
			logger.info("With this query table is emptied :: "+delete_query);
			
		}
		
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");
		
		
		for(String tag: tagValue)
		{
			String []tags=tag.split("~");
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(ResponseXML);
			logger.info("objWFxmlResponse value is "+objWFxmlResponse);
			
			columnames="CIC_NO,WI_NAME,";
			values=" ";
			for(int j=2;j<tags.length;++j)
			{
				String tag_split_values=tags[j];
				logger.info("Tag values split to set column names"+tag_split_values);
				String []hash_split_values=tag_split_values.split("#");
				columnames=columnames+hash_split_values[0].replace("$","")+",";
			}
			
			columnames=columnames+"ENTRY_DATE_TIME";
			logger.info("column names are"+columnames);
			
			if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) 
			{
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
			logger.info("Wfmxmlsit is --------------"+WFXmlList);
			for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
			{
				values=values+"( '"+cic_number+"','"+wi_name+"',";
				
				for(int j=2;j<tags.length;++j)
				{
					String tag_split_values=tags[j];
					if((!tag_split_values.contains("@")))
					{
						String []hash_split_values=tag_split_values.split("#");
						String result_from_response=WFXmlList.getVal(hash_split_values[1]);
						result_from_response=result_from_response.replace("'","''");
						if(result_from_response== null || result_from_response=="")
						{
							result_from_response="";
						}
						else if(callName.equalsIgnoreCase("CustOutstandingInq_ApprovedSales") || callName.equalsIgnoreCase("CustOutstandingInq_GroupExposure") )
						{
							if(hash_split_values[0].equalsIgnoreCase("GROSS_AMT") || hash_split_values[0].equalsIgnoreCase("FIN_AMT") || hash_split_values[0].equalsIgnoreCase("GROSS_OUTSDING") || hash_split_values[0].equalsIgnoreCase("OUTSTDNG_PRINCIPAL") || hash_split_values[0].equalsIgnoreCase("OUTSTDNG_PROFIT") || hash_split_values[0].equalsIgnoreCase("INSTALLMENT") || hash_split_values[0].equalsIgnoreCase("PROFIT_PERCENT")  )
							{
								String temp=result_from_response;
								try
								{
									result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
								}
								catch(Exception e)
								{
									result_from_response=temp;
								}
							}
						}
						
						if(hash_split_values[0].contains("$"))
							values=values+"'"+result_from_response.trim()+"',";
						else
							values=values+"N'"+result_from_response.trim()+"',";
					}
					else
					{
						String []inputTagswithoutRateSign=tag_split_values.split("@");
						String []hash_split_values=inputTagswithoutRateSign[0].split("#");
						String result_from_response=WFXmlList.getVal(hash_split_values[1]);
						if(result_from_response.equals(null) || result_from_response.equals(""))
						{
							result_from_response=" ";
						}
						String internal_query="";
						internal_query="( SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result_from_response+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y' )" ;
						values=values+internal_query+",";
					}		
				}
				
				values=values+"'"+date+"'),";
			}
			
			if (values.endsWith(",")) 
			{
				values = values.substring(0, values.length() - 1);
			}
			
			logger.info("Final column variables are"+columnames);
			logger.info("values are"+values);
			
			query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
			logger.info("Query for setting response in search screen tables is"+query);
				if(values.trim()!="")
					iformObj.saveDataInDB(query);	
			}
			else
			{
				logger.info("For "+callName+" Status code returned from response is not success ");
			}
			
		}
		
		return "";
	}
	
	public String fetchAllCTFDataApprovedSales(IFormReference iformObj, String stringData,String cic_no,String wi_name)
	{
		try
		{	
		logger.info("Inside fetchAllCTFDataApprovedSales handling");
		String callName="MSBFacilitiesDataInq_ApprovedSales";
		String responseXML = createRequestXML(iformObj, callName);
		//setResponseDataGridSearchScreen(iformObj, call_name, responseXML);
		
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			responseXML=responseXML.replace(temp,"");
		
		logger.info("Response XML received by setResponseDataGrid is"+responseXML);
		String tagName = "_TagNameResponseGrid";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		
		logger.info(tagNames);
		String[] tagValue = tagNames.split(",");
		
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String cic_number=cic_no;
		
		
		String values=" ";
		String query="";
		String columnames="CIC_NO,WI_NAME,";
		String insertinto="INSERT INTO ";
		String tablename=GetXML.getProp().getProperty(callName+"_Table_Grid");
		
		String delete_query="DELETE FROM "+tablename+" where WI_NAME= '"+wi_name+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table is emptied :: "+delete_query);
		
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");
		
		List<String> dossier_no_list=new ArrayList<>();
		
		for(String tag: tagValue)
		{
			String []tags=tag.split("~");
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
			logger.info("objWFxmlResponse value is "+objWFxmlResponse);
			
			columnames="CIC_NO,WI_NAME,FACILITY_TYPE,";
			values=" ";
			for(int j=2;j<tags.length;++j)
			{
				String tag_split_values=tags[j];
				logger.info("Tag values split to set column names"+tag_split_values);
				String []hash_split_values=tag_split_values.split("#");
				columnames=columnames+hash_split_values[0].replace("$","")+",";
			}
			
			columnames=columnames+"ENTRY_DATE_TIME";
			logger.info("column names are"+columnames);
			
			if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
			logger.info("Wfmxmlsit is --------------"+WFXmlList);
			for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
			{
				values=values+"( '"+cic_number+"','"+wi_name+"',";
				
				if(tags[0].equalsIgnoreCase("FacilitiesLst"))
				{
					values=values+"'MSB',";
				}
				else if(tags[0].equalsIgnoreCase("RetailFacilitiesLst"))
				{
					 values=values+"'Retail',";
				}
				else
				{
					 values=values+"'Error',";
				}
				
				for(int j=2;j<tags.length;++j)
				{
					String tag_split_values=tags[j];
					if((!tag_split_values.contains("@")))
					{
						String []hash_split_values=tag_split_values.split("#");
						String result_from_response=WFXmlList.getVal(hash_split_values[1]);
						result_from_response=result_from_response.replace("'","''");
						if(result_from_response== null)
						{
							result_from_response="";
						}
						else if(hash_split_values[0].equalsIgnoreCase("INSTL_AMT") || hash_split_values[0].equalsIgnoreCase("AVAIL_DRAWDOWN") || hash_split_values[0].equalsIgnoreCase("UTILIZED_AMT") || hash_split_values[0].equalsIgnoreCase("ELIG_LIMIT_AMT") || hash_split_values[0].equalsIgnoreCase("OUTSTANDING_BALANCE") )
						{
							String temp=result_from_response;
							try
							{
								result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
							}
							catch(Exception e)
							{
								result_from_response=temp;
							}
						}
						else if(hash_split_values[0].equalsIgnoreCase("DOSSIER_NUMBER") ) 
						{
							dossier_no_list.add(result_from_response);
						}
						
						if(hash_split_values[0].contains("$"))
							values=values+"'"+result_from_response.trim()+"',";
						else
							values=values+"N'"+result_from_response.trim()+"',";
					}
				}
				values=values+"'"+date+"'),";
			}
			
			if (values.endsWith(",")) 
			{
				values = values.substring(0, values.length() - 1);
			}
			
			logger.info("Final column variables are"+columnames);
			logger.info("values are"+values);
			
			query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
			logger.info("Query for setting response in search screen tables is"+query);
				if(values.trim()!="")
					iformObj.saveDataInDB(query);	
			}
			else
			{
				logger.info("For "+callName+" Status code returned from response is not success ");
			}	
		}
		
		logger.info("For CIC "+cic_number+" final dossier list is "+dossier_no_list);
		
		callName="LoanDisburseDataInq_ApprovedSales";
		logger.info("Inside createRequestXML Function and callName is " + callName);
	    tagName = "_TagName";
		
		String request_prefix=GetXML.getProp().getProperty(callName+"_RequestPrefix");
		if(request_prefix.equals(null))
		{
			request_prefix="";
		}
		logger.info("Request prefix is "+request_prefix+"please check");
		
		String header_tags=GetXML.getProp().getProperty(callName+"_Header");
		
		tablename=GetXML.getProp().getProperty(callName+"_Table_Grid");
		delete_query="DELETE FROM "+tablename+" where WI_NAME= '"+wi_name+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table is emptied :: "+delete_query);
		
		
		for(String dossierno:dossier_no_list)
		{
			
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
		
			tagNames = GetXML.getProp().getProperty(callName + tagName);
			logger.info(tagNames);
			String[] tags = tagNames.split(",");
	
			String requestXML = readDummyRequest(callName);
	
			XMLParser parser = new XMLParser(requestXML);
			
	
			for (String tag : tags) 
			{
				String tagValue_2 = parser.getValueOf(request_prefix+tag);
				logger.info("tag values are"+tagValue_2);
				if(tagValue_2.contains("header~"))
				{
					try 
					{
						
						if(tagValue_2.split("~")[1].equalsIgnoreCase("UUID"))
						{
							parser.changeValue(request_prefix+tag, java.util.UUID.randomUUID().toString());
						}
						else
						{
							String value=(String) jsonobj_header.get(tagValue_2.split("~")[1]);
							logger.info("Value to be replaced by jsonobj_header is "+value);
							parser.changeValue(request_prefix+tag, value);
						}
					}
					catch(Exception e)
					{
						logger.info("Exception is "+e);
					}
				}
				else if (tagValue_2.startsWith("formid~")) 
				{
					String value = (String) iformObj.getValue(tagValue_2.split("~")[1]);
					parser.changeValue(request_prefix+tag, value);
				}
			}
			
			parser.changeValue(request_prefix+"DossierID", dossierno);
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML of LoanDisburseDataInq_SearchScreen for dossier no "+dossierno+" is :\n" + parser.toString());
			responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
			//setResponseDataGridSearchScreen(iformObj,callName, responseXML);
			
			try
			{
			restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
			restricted_values=restricted_tags.split(",");
			for(String temp:restricted_values)
				responseXML=responseXML.replace(temp,"");
			
			logger.info("Response XML received by setResponseDataGrid is"+responseXML);
			tagName = "_TagNameResponseGrid";
			tagNames = GetXML.getProp().getProperty(callName + tagName);
			
			logger.info(tagNames);
			tagValue = tagNames.split(",");
			
			date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			cic_number=cic_no;

			values=" ";
			query="";
			columnames="CIC_NO,WI_NAME,";
			insertinto="INSERT INTO ";
			
			statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
			status_code_split=statuscode.split("~");
			
			
			for(String tag: tagValue)
			{
				tags=tag.split("~");
				WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
				logger.info("objWFxmlResponse value is "+objWFxmlResponse);
				
				columnames="CIC_NO,WI_NAME,";
				values=" ";
				for(int j=2;j<tags.length;++j)
				{
					String tag_split_values=tags[j];
					logger.info("Tag values split to set column names"+tag_split_values);
					String []hash_split_values=tag_split_values.split("#");
					columnames=columnames+hash_split_values[0].replace("$","")+",";
				}
				
				columnames=columnames+"ENTRY_DATE_TIME";
				logger.info("column names are"+columnames);
				
				if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
				WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
				logger.info("Wfmxmlsit is --------------"+WFXmlList);
				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
				{
					values=values+"( '"+cic_number+"','"+wi_name+"',";
					
					for(int j=2;j<tags.length;++j)
					{
						String tag_split_values=tags[j];
						if((!tag_split_values.contains("@")))
						{
							String []hash_split_values=tag_split_values.split("#");
							String result_from_response=WFXmlList.getVal(hash_split_values[1]);
							result_from_response=result_from_response.replace("'","''");
							if(result_from_response== null || result_from_response=="")
							{
								result_from_response="";
							}
							
							if(hash_split_values[0].contains("$"))
								values=values+"'"+result_from_response.trim()+"',";
							else
								values=values+"N'"+result_from_response.trim()+"',";
						}
						else
						{
							String []inputTagswithoutRateSign=tag_split_values.split("@");
							String []hash_split_values=inputTagswithoutRateSign[0].split("#");
							String result_from_response=WFXmlList.getVal(hash_split_values[1]);
							if(result_from_response.equals(null) || result_from_response.equals(""))
							{
								result_from_response=" ";
							}
							String internal_query="";
							internal_query="( SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result_from_response+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y' )" ;
							values=values+internal_query+",";
						}		
					}
					
					values=values+"'"+date+"'),";
				}
				
				if (values.endsWith(",")) 
				{
					values = values.substring(0, values.length() - 1);
				}
				
				logger.info("Final column variables are"+columnames);
				logger.info("values are"+values);
				
				query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
				logger.info("Query for setting response in search screen tables is"+query);
					if(values.trim()!="")
						iformObj.saveDataInDB(query);	
				}
				else
				{
					logger.info("For "+callName+" Status code returned from response is not success ");
				}
				
			}
			
		}
		catch (Exception e)
		{
			logger.info("Exeption Occurred:: fetchAllCTFData in LoanDisburseDataInq_SearchScreen DB saving and exception is "+e);
		}
		
		}
		
		}
		catch(Exception e)
		{
			logger.info("Exeption Occurred:: fetchAllCTFData and exception is "+e);
		}
	
		return "sucess~fetchAllCTFData";
		
			
	}
	
	public String fetchAllCTFDataGroupExposure(IFormReference iformObj, String stringData,String cic_no,String wi_name)
	{
		try
		{	
		logger.info("Inside MSBFacilitiesDataInq_GroupExposure handling");
		String callName="MSBFacilitiesDataInq_GroupExposure";
		String responseXML = createRequestXML(iformObj, callName);
		//setResponseDataGridSearchScreen(iformObj, call_name, responseXML);
		
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			responseXML=responseXML.replace(temp,"");
		
		logger.info("Response XML received by setResponseDataGrid is"+responseXML);
		String tagName = "_TagNameResponseGrid";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		
		logger.info(tagNames);
		String[] tagValue = tagNames.split(",");
		
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String cic_number=cic_no;
		
		
		String values=" ";
		String query="";
		String columnames="CIC_NO,WI_NAME,";
		String insertinto="INSERT INTO ";
		String tablename=GetXML.getProp().getProperty(callName+"_Table_Grid");
		
		String delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table is emptied :: "+delete_query);
		
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");
		
		List<String> dossier_no_list=new ArrayList<>();
		
		for(String tag: tagValue)
		{
			String []tags=tag.split("~");
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
			logger.info("objWFxmlResponse value is "+objWFxmlResponse);
			
			columnames="CIC_NO,WI_NAME,FACILITY_TYPE,";
			values=" ";
			for(int j=2;j<tags.length;++j)
			{
				String tag_split_values=tags[j];
				logger.info("Tag values split to set column names"+tag_split_values);
				String []hash_split_values=tag_split_values.split("#");
				columnames=columnames+hash_split_values[0].replace("$","")+",";
			}
			
			columnames=columnames+"ENTRY_DATE_TIME";
			logger.info("column names are"+columnames);
			
			if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
			logger.info("Wfmxmlsit is --------------"+WFXmlList);
			for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
			{
				values=values+"( '"+cic_number+"','"+wi_name+"',";
				
				if(tags[0].equalsIgnoreCase("FacilitiesLst"))
				{
					values=values+"'MSB',";
				}
				else if(tags[0].equalsIgnoreCase("RetailFacilitiesLst"))
				{
					 values=values+"'Retail',";
				}
				else
				{
					 values=values+"'Error',";
				}
				
				for(int j=2;j<tags.length;++j)
				{
					String tag_split_values=tags[j];
					if((!tag_split_values.contains("@")))
					{
						String []hash_split_values=tag_split_values.split("#");
						String result_from_response=WFXmlList.getVal(hash_split_values[1]);
						result_from_response=result_from_response.replace("'","''");
						if(result_from_response== null)
						{
							result_from_response="";
						}
						else if(hash_split_values[0].equalsIgnoreCase("INSTL_AMT") || hash_split_values[0].equalsIgnoreCase("AVAIL_DRAWDOWN") || hash_split_values[0].equalsIgnoreCase("UTILIZED_AMT") || hash_split_values[0].equalsIgnoreCase("ELIG_LIMIT_AMT") || hash_split_values[0].equalsIgnoreCase("OUTSTANDING_BALANCE") )
						{
							String temp=result_from_response;
							try
							{
								result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
							}
							catch(Exception e)
							{
								result_from_response=temp;
							}
						}
						else if(hash_split_values[0].equalsIgnoreCase("DOSSIER_NUMBER") ) 
						{
							dossier_no_list.add(result_from_response);
						}
						
						if(hash_split_values[0].contains("$"))
							values=values+"'"+result_from_response.trim()+"',";
						else
							values=values+"N'"+result_from_response.trim()+"',";
					}
				}
				values=values+"'"+date+"'),";
			}
			
			if (values.endsWith(",")) 
			{
				values = values.substring(0, values.length() - 1);
			}
			
			logger.info("Final column variables are"+columnames);
			logger.info("values are"+values);
			
			query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
			logger.info("Query for setting response in search screen tables is"+query);
				if(values.trim()!="")
					iformObj.saveDataInDB(query);	
			}
			else
			{
				logger.info("For "+callName+" Status code returned from response is not success ");
			}	
		}
		
		logger.info("For CIC "+cic_number+" final dossier list is "+dossier_no_list);
		
		callName="LoanDisburseDataInq_GroupExposure";
		logger.info("Inside createRequestXML Function and callName is " + callName);
	    tagName = "_TagName";
		
		String request_prefix=GetXML.getProp().getProperty(callName+"_RequestPrefix");
		if(request_prefix.equals(null))
		{
			request_prefix="";
		}
		logger.info("Request prefix is "+request_prefix+"please check");
		
		String header_tags=GetXML.getProp().getProperty(callName+"_Header");
		
		tablename=GetXML.getProp().getProperty(callName+"_Table_Grid");
		delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table is emptied :: "+delete_query);
		
		
		for(String dossierno:dossier_no_list)
		{
			
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
		
			tagNames = GetXML.getProp().getProperty(callName + tagName);
			logger.info(tagNames);
			String[] tags = tagNames.split(",");
	
			String requestXML = readDummyRequest(callName);
	
			XMLParser parser = new XMLParser(requestXML);
			
	
			for (String tag : tags) 
			{
				String tagValue_2 = parser.getValueOf(request_prefix+tag);
				logger.info("tag values are"+tagValue_2);
				if(tagValue_2.contains("header~"))
				{
					try 
					{
						
						if(tagValue_2.split("~")[1].equalsIgnoreCase("UUID"))
						{
							parser.changeValue(request_prefix+tag, java.util.UUID.randomUUID().toString());
						}
						else
						{
							String value=(String) jsonobj_header.get(tagValue_2.split("~")[1]);
							logger.info("Value to be replaced by jsonobj_header is "+value);
							parser.changeValue(request_prefix+tag, value);
						}
					}
					catch(Exception e)
					{
						logger.info("Exception is "+e);
					}
				}
				else if (tagValue_2.startsWith("formid~")) 
				{
					String value = (String) iformObj.getValue(tagValue_2.split("~")[1]);
					parser.changeValue(request_prefix+tag, value);
				}
			}
			
			parser.changeValue(request_prefix+"DossierID", dossierno);
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML of LoanDisburseDataInq_GroupExposure for dossier no "+dossierno+" is :\n" + parser.toString());
			responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
			//setResponseDataGridSearchScreen(iformObj,callName, responseXML);
			
			try
			{
			restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
			restricted_values=restricted_tags.split(",");
			for(String temp:restricted_values)
				responseXML=responseXML.replace(temp,"");
			
			logger.info("Response XML received by setResponseDataGrid is"+responseXML);
			tagName = "_TagNameResponseGrid";
			tagNames = GetXML.getProp().getProperty(callName + tagName);
			
			logger.info(tagNames);
			tagValue = tagNames.split(",");
			
			date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			cic_number=cic_no;

			values=" ";
			query="";
			columnames="CIC_NO,WI_NAME,";
			insertinto="INSERT INTO ";
			
			statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
			status_code_split=statuscode.split("~");
			
			
			for(String tag: tagValue)
			{
				tags=tag.split("~");
				WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
				logger.info("objWFxmlResponse value is "+objWFxmlResponse);
				
				columnames="CIC_NO,WI_NAME,";
				values=" ";
				for(int j=2;j<tags.length;++j)
				{
					String tag_split_values=tags[j];
					logger.info("Tag values split to set column names"+tag_split_values);
					String []hash_split_values=tag_split_values.split("#");
					columnames=columnames+hash_split_values[0].replace("$","")+",";
				}
				
				columnames=columnames+"ENTRY_DATE_TIME";
				logger.info("column names are"+columnames);
				
				if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
				WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
				logger.info("Wfmxmlsit is --------------"+WFXmlList);
				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
				{
					values=values+"( '"+cic_number+"','"+wi_name+"',";
					
					for(int j=2;j<tags.length;++j)
					{
						String tag_split_values=tags[j];
						if((!tag_split_values.contains("@")))
						{
							String []hash_split_values=tag_split_values.split("#");
							String result_from_response=WFXmlList.getVal(hash_split_values[1]);
							result_from_response=result_from_response.replace("'","''");
							if(result_from_response== null || result_from_response=="")
							{
								result_from_response="";
							}
							
							if(hash_split_values[0].contains("$"))
								values=values+"'"+result_from_response.trim()+"',";
							else
								values=values+"N'"+result_from_response.trim()+"',";
						}
						else
						{
							String []inputTagswithoutRateSign=tag_split_values.split("@");
							String []hash_split_values=inputTagswithoutRateSign[0].split("#");
							String result_from_response=WFXmlList.getVal(hash_split_values[1]);
							if(result_from_response.equals(null) || result_from_response.equals(""))
							{
								result_from_response=" ";
							}
							String internal_query="";
							internal_query="( SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result_from_response+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y' )" ;
							values=values+internal_query+",";
						}		
					}
					
					values=values+"'"+date+"'),";
				}
				
				if (values.endsWith(",")) 
				{
					values = values.substring(0, values.length() - 1);
				}
				
				logger.info("Final column variables are"+columnames);
				logger.info("values are"+values);
				
				query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
				logger.info("Query for setting response in search screen tables is"+query);
					if(values.trim()!="")
						iformObj.saveDataInDB(query);	
				}
				else
				{
					logger.info("For "+callName+" Status code returned from response is not success ");
				}
				
			}
			
		}
		catch (Exception e)
		{
			logger.info("Exeption Occurred:: fetchAllCTFData in LoanDisburseDataInq_GroupExposure DB saving and exception is "+e);
		}
		
		}
		
		}
		catch(Exception e)
		{
			logger.info("Exeption Occurred:: fetchAllCTFDataGroupExposure and exception is "+e);
		}
	
		return "sucess~fetchAllCTFDataGroupExposure";
		
			
	}


	/*
	public  String executePOSTRequestSIMAHIndividual( String requestXML,String URL) 
    {
		try
		{
			DefaultHttpClient Client = new DefaultHttpClient ();
			Client.getCredentialsProvider().setCredentials(AuthScope.ANY,new UsernamePasswordCredentials("FTSRAJB", "ftsrajb"));
	    	HttpPost httppost = new HttpPost(URL);
	    	HttpHost proxy = new HttpHost("proxy1", 80);
	    	Client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
	    	httppost.setEntity(new StringEntity(requestXML ));//requestXML is inputxml
	    	HttpResponse response = Client.execute(httppost);
	
	    	System.out.println("response = " + response);
	
	    	BufferedReader breader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	    	StringBuilder responseString = new StringBuilder();
	    	String line = "";
	    	while ((line = breader.readLine()) != null) 
	    	{
	    		responseString.append(line);
	    	}
	    	breader.close();
	    	String responseStr = responseString.toString();
	    	System.out.println("responseStr = " + responseStr);
	    	return responseStr;
    	} 
		catch (Exception e) 
		{
			e.printStackTrace();
    	}
		
		return "Error~executePOSTRequestSIMAHIndividual";
	}
	*/
	
	public String executePOSTRequestSIMAHIndividual( String requestXML,String callName) 
	{
		try 
		{
			//URL url = new URL ("http://ip:port/download_url");
			//https://commprob2b.simah.com/enquiry/inthttpset.pgm
			//String urlStr = "https://consumerdev.simah.com/enquiry/inthttp.pgm"; // For SIT and UAT
			//String urlStr= "http://172.16.3.209:7804/enquiry/inthttpset.pgm"; //For Production Only
			//String urlStr= "https://commprob2b.simah.com/enquiry/inthttpset.pgm"; //For Production Only
			
			//String urlStr= "http://172.16.3.209:7804/enquiry/inthttp.pgm"; //For Production Only (Final)
			//SIMAH_Individual_Proxy_Username
			//SIMAH_Individual_Proxy_Password
			String urlStr=GetXML.getProp().getProperty(callName+"_EndpointURL");
			logger.info("For simah individual endpoint url is "+urlStr);
			URL url = new URL(urlStr);
			//String authStr = "FTSRAJB:ftsrajb"; //For SIT and UAT
			//String authStr = "onlineraj:onlineraj"; //For Production ONly
			//String authStr = "B2BCUMRAJB:AcP1qCa2"; //For Production ONly
			
			//String authStr = "ONLINERAJ:ONLINERAJ"; //For Production ONly (Final)
			String authStr=GetXML.getProp().getProperty(callName+"_BasicAuthenticationUserPass");
			logger.info("For simah individual basic authentication username:password is"+authStr);

			//String proxy_username=GetXML.getProp().getProperty(callName+"_Proxy_Username");
			//String proxy_password=GetXML.getProp().getProperty(callName+"_Proxy_Password");
			//logger.info("For simah proxy username is "+proxy_username+"  and  password is"+proxy_password);
			
			String authEncoded = Base64.getEncoder().encodeToString((authStr).getBytes());
			//Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy1", 80));
			//Properties systemProperties = System.getProperties();
			// systemProperties.put("proxySetrue");
			//systemProperties.setProperty("http.proxyHost", "proxy1");
			//systemProperties.setProperty("http.proxyPort", "80");
			
			//System.setProperty("http.proxyUser", proxy_username);
			//System.setProperty("http.proxyPassword", proxy_password);

			//System.setProperty("http.proxyUser", "ARBANK\\c000004");
			//System.setProperty("http.proxyPassword", "GIer2868");

			/*
			 * Authenticator.setDefault(new Authenticator() { public PasswordAuthentication
			 * getPasswordAuthentication() { return new
			 * PasswordAuthentication(proxy_username, proxy_password.toCharArray());
			 * //return new PasswordAuthentication("ARBANK\\c000004",
			 * "GIer2868".toCharArray()); } });
			 */
			//HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + authEncoded);
			//connection.setRequestProperty("Proxy-Authorization", "Basic " + authEncoded);
			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = requestXML.getBytes("utf-8");
				os.write(input, 0, input.length);
			}
			// File file = new File(outFilePath);
			// InputStream in = (InputStream) connection.getInputStream();
			connection.getInputStream().read();
			
			String result = new BufferedReader(new InputStreamReader(connection.getInputStream())).lines().parallel()
					.collect(Collectors.joining("\n"));
			// OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			System.out.println(result);
			return result;
		} 
		catch (Exception e) 
		{
			logger.info("Exception Occurred: In executePOSTRequestSIMAHIndividual "+e);
			e.printStackTrace();
			return "Error~Exception in Request,Please Check";
		}
	}
	
	public String setResponseDataGridToDBAfterApplicationCreation(IFormReference iformObj, String callName, String responseXML)
	{
		try
		{
			String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
			String []restricted_values=restricted_tags.split(",");
			for(String temp:restricted_values)
				responseXML=responseXML.replace(temp,"");
			
			logger.info("Response XML received by setResponseDataGrid is"+responseXML);
			String tagName = "_TagNameResponseGrid";
			String tagNames = GetXML.getProp().getProperty(callName + tagName);
			
			logger.info(tagNames);
			String[] tagValue = tagNames.split(",");
			
			//String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			//String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
			String wi_name=getWorkitemName(iformObj);
	
			String values=" ";
			String query="";
			String columnames="WI_NAME,"; //CIC_NO IS REPLACED WITH WI_NAME (redundant)
			String insertinto="INSERT INTO ";
			String tablename=GetXML.getProp().getProperty(callName+"_Table_Grid");
			
			String delete_query="DELETE FROM "+tablename+" where WI_NAME= '"+wi_name+"' "; //Changed
			iformObj.saveDataInDB(delete_query);
			logger.info("With this query table is emptied :: "+delete_query);
			
			String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
			String []status_code_split=statuscode.split("~");
			
			for(String tag: tagValue)
			{
				String []tags=tag.split("~");
				WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
				logger.info("objWFxmlResponse value is "+objWFxmlResponse);
				
				columnames="WI_NAME,";
				values=" ";
				for(int j=2;j<tags.length;++j)
				{
					String tag_split_values=tags[j];
					logger.info("Tag values split to set column names"+tag_split_values);
					String []hash_split_values=tag_split_values.split("#");
					columnames=columnames+hash_split_values[0].replace("$","")+",";
				}
				if (columnames.endsWith(",")) 
				{
					columnames = columnames.substring(0, columnames.length() - 1);
				}
				
				//columnames=columnames+"ENTRY_DATE_TIME";
				logger.info("column names are"+columnames);
				
				if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) 
				{
					WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
					logger.info("Wfmxmlsit is --------------"+WFXmlList);
					for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
					{
						values=values+"( '"+wi_name+"',"; //Changed
					
						for(int j=2;j<tags.length;++j)
						{
							String tag_split_values=tags[j];
							if((!tag_split_values.contains("@")))
							{
								String []hash_split_values=tag_split_values.split("#");
								String result_from_response=WFXmlList.getVal(hash_split_values[1]);
								result_from_response=result_from_response.replace("'","''");
								if(result_from_response== null || result_from_response.trim()=="")
								{
									result_from_response="";
								}
								else if(callName.equalsIgnoreCase("MSBAcctsDataInq_PQ1") || callName.equalsIgnoreCase("MSBAcctsDataInq_OldCIC_PQ1"))
								{
									if(hash_split_values[0].equalsIgnoreCase("DEPOSIT") || hash_split_values[0].equalsIgnoreCase("WITHDRAWAL") || hash_split_values[0].equalsIgnoreCase("AVG_BAL") || hash_split_values[0].equalsIgnoreCase("NEG_BAL") || hash_split_values[0].equalsIgnoreCase("THROUGHPUT"))
									{
										String temp=result_from_response;
										try
										{
											result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
										}
										catch(Exception e)
										{
											result_from_response=temp;
										}
									}
								}
								else if(callName.equalsIgnoreCase("MSBAcctsDataInq_PQ1_ClosingBalance") || callName.equalsIgnoreCase("MSBAcctsDataInq_OldCIC_PQ1_ClosingBalance"))
								{
									if(hash_split_values[0].equalsIgnoreCase("CLOSING_BALANCE"))
									{
										String temp=result_from_response;
										try
										{
											result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
										}
										catch(Exception e)
										{
											result_from_response=temp;
										}
									}
								}
								else if(callName.equalsIgnoreCase("MerchantPOSTrxnsSummaryInq_PQ1") || callName.equalsIgnoreCase("MerchantPOSTrxnsSummaryInq_OldCIC_PQ1"))
								{
									if(hash_split_values[0].equalsIgnoreCase("THROUGHPUT") || hash_split_values[0].equalsIgnoreCase("AVG_TRANSACTN_AMT"))
									{
										String temp=result_from_response;
										try
										 {
											result_from_response=String.format("%.2f", Double.parseDouble(result_from_response));
										 }
										catch(Exception e)
										{
											result_from_response=temp;
										}
									}
								}
								
								if(hash_split_values[0].contains("$"))
									values=values+"'"+result_from_response.trim()+"',";
								else
									values=values+"N'"+result_from_response.trim()+"',";
							}
							else
							{
								String []inputTagswithoutRateSign=tag_split_values.split("@");
								String []hash_split_values=inputTagswithoutRateSign[0].split("#");
								String result_from_response=WFXmlList.getVal(hash_split_values[1]);
								if(result_from_response.equals(null) || result_from_response.equals(""))
								{
									result_from_response=" ";
								}
								String internal_query="";
								internal_query="( SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result_from_response+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y' )" ;
								values=values+internal_query+",";
							}		
					}
					if (values.endsWith(",")) 
					{
						values = values.substring(0, values.length() - 1);
					}
					values=values+"),";
				}
				
				if (values.endsWith(",")) 
				{
					values = values.substring(0, values.length() - 1);
				}
				
				logger.info("Final column variables are"+columnames);
				logger.info("values are"+values);
				
				query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
				logger.info("Query for setting response in search screen tables is"+query);
					if(values.trim()!="")
						iformObj.saveDataInDB(query);	
				}
				else
				{
					logger.info("For "+callName+" Status code returned from response is not success ");
				}
				
			}	
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: In setResponseDataGridToDBAfterApplicationCreation "+e);
			e.printStackTrace();
			return "Error~Exception in setResponseDataGridToDBAfterApplicationCreation,Please Check";
		}
		return "Success~setResponseDataGridToDBAfterApplicationCreation";
	}
	
	//callName="MerchantDtlsInq_SearchScreen#MerchantPOSTrxnsSummaryInq_SearchScreen";// For terminal data
	
	
}
