package com.newgen.workstep;

import java.io.File;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.newgen.encryption.DataEncryption;
import com.newgen.iforms.EControl;
import com.newgen.iforms.FormDef;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;
import com.newgen.iforms.user.POSCommon;
import com.newgen.integration.GetXML;
import com.newgen.integration.SocketConnector;
import com.newgen.mvcbeans.model.WorkdeskModel;
import com.newgen.omni.jts.cmgr.XMLParser;
import com.newgen.omni.wf.util.app.NGEjbClient;
import com.newgen.wfdesktop.xmlapi.WFXmlList;
import com.newgen.wfdesktop.xmlapi.WFXmlResponse;

//import sun.font.AttributeValues;

public class POS_Search extends POSCommon implements IFormServerEventHandler 
{
	
	List<String> cic_no_visited=null;
	boolean customer_blacklisted=false;
	String customer_blacklisted_descr="";
	int counter=0; // Not usefull, Just for understanding related party movement
	
	Logger logger = Logger.getLogger(POS_Search.class);

	@Override
	public void beforeFormLoad(FormDef arg0, IFormReference arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public String executeCustomService(FormDef arg0, IFormReference arg1, String arg2, String arg3, String arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray executeEvent(FormDef arg0, IFormReference arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String executeServerEvent(IFormReference iformObj, String controlName, String eventType, String stringData) 
	{
		
		
		if (controlName.equalsIgnoreCase("createapplication")) {
			return createNewApplication(iformObj, stringData);
		}else if (controlName.equalsIgnoreCase("msbSearchButtonClicked")) {
			logger.info("Inside msbSearchButtonClicked handler");
			return msbSearchButtonClicked(iformObj, stringData);
		}else if (controlName.equalsIgnoreCase("msbUploadNonARBButtonClicked")) {
			logger.info("Inside msbUploadNonARBButtonClicked  function");
			return msbUploadNonARBButtonClicked(iformObj, stringData);
		}else if (controlName.equalsIgnoreCase("msbEligibilityCheckButtonClicked")) {
			logger.info("Inside Eligibility button function");
			return msbEligibilityCheckButtonClicked(iformObj, stringData);
		}else if (controlName.equalsIgnoreCase("msbFetchButtonClicked")) {
			logger.info("inside Fetch Button function ");
			fetchButtonClicked(iformObj, stringData);	
		}else if (controlName.equalsIgnoreCase("setSearchScreenHeader")) {
			logger.info("inside setSearchScreenHeader function ");
			return setSearchScreenHeader(iformObj, stringData);
		} else if (controlName.equalsIgnoreCase("checkeligibility")) {
            logger.info("inside checkeligibility function ");
            return checkEligibility(iformObj, stringData);
		}else if (controlName.equalsIgnoreCase("ListViewTest")) {
			logger.info("inside ListViewTest");
			return ListViewTest(iformObj, stringData);
		}else if (controlName.equalsIgnoreCase("retrurnMax_and_Min")) {
			logger.info("inside retrurnMax_and_Min function ");
			return return_max_min_amount_search_screen(iformObj, stringData);
		}else if (controlName.equalsIgnoreCase("isarabic")) {
			logger.info("inside isarabic function ");
			return isarabic(iformObj, stringData);
		}else if (controlName.equalsIgnoreCase("saveRelatedPartySearchScreen")) {
			logger.info("inside saveRelatedPartySearchScreen function ");
			return saveRelatedPartySearchScreen(iformObj, stringData);
		}else if (controlName.equalsIgnoreCase("checkAccountBlockCode_SearchScreen")) {
			logger.info("inside checkAccountBlockCode_SearchScreen function ");
			return checkAccountBlockCode_SearchScreen(iformObj, stringData);
		}else if (controlName.equalsIgnoreCase("fetchOldCICDetails_SearchScreen")) {
			logger.info("inside fetchOldCICDetails_SearchScreen function ");
			return fetchOldCICDetails_SearchScreen(iformObj, stringData);
		}

		return "";
	}
	
	private String fetchOldCICDetails_SearchScreen(IFormReference iformObj, String stringData) 
	{
		logger.info("Inside fetchOldCICDetails_SearchScreen with  stringData "+stringData);
		try
		{
			
			iformObj.setValue("MSB_SEARCH_OLD_CIC_NUMBER_2",stringData);
			String cic_number = (String) iformObj.getValue("MSB_SEARCH_OLD_CIC_NUMBER_2");
			logger.info("VAlue of MSB_SEARCH_OLD_CIC_NUMBER_2 Ssssssc before setting "+cic_number);
			logger.info(" MSB_SEARCH_OLD_CIC_NUMBER_2 Third"+cic_number);
			String cr_number = (String) iformObj.getValue("MSB_SEARCH_OLD_CIC_UNN");
			String unn_number = (String) iformObj.getValue("MSB_SEARCH_OLD_CIC_CR");
			String english_name = (String) iformObj.getValue("MSB_SEARCH_OLD_CIC_ENG_NAME");
			String arabic_name = (String) iformObj.getValue("MSB_SEARCH_OLD_CIC_AR_NAME");
			
			String textbox = (String) iformObj.getValue("textbox461");
			String textbox2 = (String) iformObj.getValue("SAHDEV");
			logger.info("Cic Number is "+cic_number+"dfgdsfg");
			
			String call_Name = "MSBAcctsDataInq_OldCIC_SearchScreen";
			String responseXML = createRequestXML(iformObj, call_Name);
			setResponseDataGridSearchScreen(iformObj,call_Name, responseXML);
			if(call_Name.equalsIgnoreCase("MSBAcctsDataInq_OldCIC_SearchScreen"))
			{
				setResponseDataGridSearchScreen(iformObj,"MSBAcctsDataInq_OldCIC_ClosingBalance", responseXML);
				setResponseDataGridSearchScreen(iformObj,"MSBAcctsDataInq_OldCIC_AccountStatus", responseXML);
			}
			
			call_Name="MerchantDtlsInq_OldCIC_SearchScreen#MerchantPOSTrxnsSummaryInq_OldCIC_SearchScreen";// For terminal data
			fillTerminalData_SearchScreen(iformObj, call_Name);
			fillTerminalData_allmachines_SearchScreen(iformObj,"MerchantPOSTrxnsSummaryInq_OldCIC_SearchScreen");
			
			call_Name="MSBEntityDataInq_OldCIC";
			responseXML = createRequestXML(iformObj, call_Name);		
			JSONObject jsonobj=setResponseData(iformObj, call_Name, responseXML);
			for(Iterator iterator = jsonobj.keySet().iterator(); iterator.hasNext();)
			{
				String key = (String) iterator.next();
				if(key.equalsIgnoreCase("Error"))
				{
					return "Error~"+jsonobj.get(key).toString();
				}
				else
				{
					logger.info("Values set for"+key+" are "+jsonobj.get(key).toString());
					setControlValue(iformObj, key, jsonobj.get(key).toString());
				}
			}
		
			String table_name="NG_MSB_SEARCH_OLD_CIC_DETAILS";
			String column_names="CIC_NO,CR_NO,ENTITY_NAME_ENG,ENTITY_NAME_AR,UNN_NO,ENTRY_DATE_TIME";
			String company_data_id="MSB_SEARCH_OLD_CIC_NUMBER_2,MSB_SEARCH_OLD_CIC_CR_2,MSB_SEARCH_OLD_CIC_ENG_NAME_2,MSB_SEARCH_OLD_CIC_AR_NAME_2,MSB_SEARCH_OLD_CIC_UNN_2";
			setDatainDBfromSearchScreen(iformObj,"MSB_SEARCH_OLD_CIC_NUMBER_2",table_name,company_data_id,column_names);
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: Inside fetchOldCICDetails_SearchScreen and exception is "+e);
		}
		return "Success~fetchOldCICDetails_SearchScreen";
	}

	private String checkAccountBlockCode_SearchScreen(IFormReference iformObj, String stringData) 
	{
		logger.info("Inside checkAccountBlockCode_SearchScreen");
		try
		{
			int block_present=0;
			String cic_no=(String) iformObj.getValue("NG_MSB_CIC_NO");
			String return_string="<style>table, th, td {border:1px solid black; text-align:center}</style><h3>Following block codes are present for this CIC-</h3><table style=\"width:100%\"> <tr>  "
					+ "<th>Account Number</th>  <th>Block Code</th>  <th>Block Description</th>"
					+ "</tr>";				
			String query="SELECT ACCOUNT_NO,ACCOUNT_BLOCK_CODE,ACCOUNT_DESCRIPTION FROM NG_MSB_SEARCH_ACCOUNT_STATUS_GRID WHERE CIC_NO= '"+cic_no+"' AND ACCOUNT_STATUS='ACTIVE' AND ACCOUNT_BLOCK_CODE IN ('A8','B9','FP','50') ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("checkAccountBlockCode_SearchScreen :: Query to fetch blocked account is "+query+" and it's result is "+result);
			for(int i=0;i<result.size();i++)
			{
				block_present++;
				return_string=return_string+"<tr>  <td>"+result.get(i).get(0)+"</td>  <td>"+result.get(i).get(1)+"</td>  <td>"+result.get(i).get(2)+"</td></tr>";
			}
			return_string=return_string+ "</table>";
			return_string="Success~"+block_present+"~"+return_string;
			logger.info("checkAccountBlockCode_SearchScreen final HTML is"+return_string);
			return return_string;
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: Inside checkAccountBlockCode_SearchScreen and exception is "+e);
		}
		return "Error~checkAccountBlockCode_SearchScreen";
	}

	private String findcustomercategory(IFormReference iformObj) 
	{
		logger.info("Inside findcustomercategory");
		try
		{
			String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
			String request_type=getControlValue(iformObj, "REQUEST_TYPE");
			if(request_type.equalsIgnoreCase("Top-Up Request"))
			{
				setControlValue(iformObj,"CUSTOMER_CATEGORY","ARB POS Customer");
				logger.info("As for cic "+cic_number+" request type is Top-Up Customer Category is set to ARB POS Customer");
				return "findcustomercategory";
			}

			
			String query="SELECT COUNT(1) FROM NG_MSB_SEARCH_STMTDATA_ACCMOVMNT_GRID WHERE CIC_NO = '"+cic_number+"' ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			String months="";;
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					months=result.get(0).get(0);
				}
			}
			logger.info("Inside findcustomercategory and query is "+query+"and its result is "+result+" and hence months is "+months);
		
			query="SELECT COUNT(1) FROM NG_MSB_SEARCH_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE CIC_NO='"+cic_number+"'  AND CORTEX_MONTH<>'' AND CORTEX_MONTH IS NOT NULL ";
			result=iformObj.getDataFromDB(query);
			logger.info("Query to fetch no of rows for cortex of all machines is "+query+" and it's result is "+result);
			int no_of_rows_in_cortex=0;
			try
			{
				if(result.size()>0)
				{
					if(result.get(0).size()>0)
					{
						no_of_rows_in_cortex=Integer.parseInt(result.get(0).get(0));
					}
				}
			}
			catch(Exception e)
			{
				no_of_rows_in_cortex=0;
			}
			String customer_category=(String) iformObj.getValue("CUSTOMER_CATEGORY");
			logger.info("Customer Category before applying cortex validation is "+customer_category);
			//if(customer_category.equalsIgnoreCase(""))
			
			if(months.trim()!="" && !months.equalsIgnoreCase("Null") )
			{
				int months_in_int=Integer.parseInt(months);
				if(months_in_int>=3 && no_of_rows_in_cortex<3)
				{
					setControlValue(iformObj,"CUSTOMER_CATEGORY","Non-ARB POS Customer"); //Eariler value was but then we changed it due to some production issue.
					logger.info("findcustomercategory Customer Category is Non-ARB POS Customer");
				}
				else if(months_in_int<3 && no_of_rows_in_cortex<3)
				{
					setControlValue(iformObj,"CUSTOMER_CATEGORY","Non-ARB POS Customer");
					logger.info("findcustomercategory Customer Category is Non-ARB POS Customer");
				}
				else if(months_in_int>=3 && no_of_rows_in_cortex>=3)
				{
					setControlValue(iformObj,"CUSTOMER_CATEGORY","ARB POS Customer");
					logger.info("findcustomercategory Customer Category is ARB POS Customer");
				}
				else if(months_in_int<3 && no_of_rows_in_cortex>=3)
				{
					setControlValue(iformObj,"CUSTOMER_CATEGORY","");
					logger.info("findcustomercategory Customer Category as blank");
				}
				
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: Inside findcustomercategory and exception is "+e);
		}
		return "findcustomercategory";
	}
	
	
	private String saveRelatedPartySearchScreen(IFormReference iformObj, String stringData) 
	{
		String grid_id="MSB_SEARCH_ROLE_GRID";
		String table_name="NG_MSB_SEARCH_RELATED_PARTY_ROLES_GRID";
		String column_names="CHILD_CIC,ROLE_DESCRIPTION,PERCENTAGE,PARTY_TYPE,NAME_ENG,NAME_AR,GROUP_DESCRIPTION,CR,UNN,CICStatus,RegisterDate,Establishate,entityName,entityNameOther,entityTypeCd,entityTypeDesc,CountryCd,SectorCd,SubSectorCd,SamaSectorDesc,BankSectorDesc,ActivityDesc,SubSectorDesc,RegTypeCd,RegTypeDesc,entityCityName,entityRegionCd,entityCountryCd,entitySAMASectorCd,FirstNameAR,SecondNameAR,FamilyNameAR,FirstNameEN,SecondNameEN,FamilyNameEN,Nationality,BirthDate,Age,MaritalStatus,MaritalStatusDesc,AddressBuildingNumber,AddressUnitNumber,AddressStreetName,AddressRegion,AddressCityCd,AddressCityName,AddressAdditionalNumber,AddressPostalCd,PrefContactNo,MobileNum,PartyStatusDesc,NationalityDesc,ID_NUMBER,ID_ISSUE_DATE,ID_EXPIRY_DATE,GENDER,PARENT_CIC,PARENT_CR,ENTRY_DATE_TIME";
		String field_list="CIC,Role Description,Percentage,Party Type,Name (Eng),Name (Ar),Group Description,CR Number,UNN Number,CIC Status,Register Date,Establish Date,Entity Name,Entity Name Other,Entity Type Code,Entity Type Description,Country Code,Sector Code,Sub Sector Code,Sama Sector Description,Bank Sector Description,Activity Description,Sub Sector Description,Registration Type Code,Registration Type Description,Entity City Name,Entity Registration Code,Entity Country Code,Entity Sama Sector Code,First Name (Ar),Second Name (Ar),Family Name (Ar),First Name (Eng),Second Name (Eng),Family Name (Eng),Nationality,Birth Date,Age,Marital Status,Martial Status Description,Address Building No,Address Unit No,Address Street No,Address Region,Address City Code,Address City Name,Address Additional Number,Address Postal Code,Pref Contact Number,Mobile Number,Party Status Desciption,Nationality Description,ID Number,ID Issue Date,ID Expiry Date,Gender,Parent CIC,Parent CR";
		setDatainDBfromSearchScreenGrid(iformObj,"NG_MSB_CIC_NO",grid_id,table_name,column_names,field_list);
		logger.info("Inside MSB_SEARCH_ROLE_GRID");
		return "Success~saveRelatedPartySearchScreen";
	}
	
	private String RelatedPartyiterator(String cic_no,IFormReference iformObj)
	{
		logger.info("Inside RelatedPartyiterator Function and cic_no is " + cic_no);
		if(cic_no_visited.contains(cic_no)==false)
		{
			cic_no_visited.add(cic_no);
			counter++;
			logger.info("Updated Counter is "+counter+" and cic_no_visited is  " + cic_no_visited);
			JSONArray DataGrid =iformObj.getDataFromGrid("MSB_SEARCH_ROLE_GRID");
			logger.info("For counter "+counter+" data fetched is " + DataGrid);
			Iterator iterator = DataGrid.iterator();
			while (iterator.hasNext())
			{
				JSONObject slide = (JSONObject) iterator.next();
				String party_type = (String) slide.get("Party Type");
				if(party_type.equalsIgnoreCase("Company"))
				{
					String company_cic = (String) slide.get("CIC");
					logger.info("comapny cic is "+company_cic);
					if(cic_no_visited.contains(company_cic)==false)
					{
						logger.info("company cic needed for iterator is " + company_cic);
						RelatedParty(company_cic,iformObj);
						RelatedPartyiterator(company_cic,iformObj);
					}
				}
			}

		}
		
		return "";
	}
	
	private String RelatedParty(String cic_no,IFormReference iformObj )
	{
		String callName="MSBEntityDataInq";
		String responseXML="";
		try
		{
			logger.info("Inside RelatedParty createRequestXML Function and callName is " + callName);
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
					parser.changeValue(request_prefix+tag, value);
				}
				
			}
			parser.changeValue(request_prefix+"CIC", cic_no);
			parser.changeValue(request_prefix+"CICNum", cic_no);
			System.out.println("RequestXML of RelatedParty is :\n" + parser.toString());
			logger.info("RequestXML of RelatedParty is :\n" + parser.toString());
			responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
		}
		catch (Exception e)
		{
			logger.info("Exception is "+e);
		}
		
		fillRelatedPartyDetails(iformObj,responseXML,callName);
	
		return "";
	}

	private String fillAccountMovementDetails(IFormReference iformObj,String processInstanceID)
	{
		try
		{
			String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");	
			String query="SELECT DISTINCT ACC_NO FROM NG_MSB_SEARCH_STMTDATA_ACCMOVMNT_GRID WHERE CIC_NO='"+cic_number+"' ";
			logger.info("fillAccountMovementDetails fetch query is "+query);
			List<List<String>> acc_number = iformObj.getDataFromDB(query);
			logger.info("fillAccountMovementDetails account numbers are "+acc_number);
			double total_12_month_througput=0,average_12_month_througput=0,average_12_month_balance=0;
			int zero_balance_12_month=0;
			for (List<String> value : acc_number) 
			{
				logger.info("fillAccountMovementDetails account numbers in loop is "+value.get(0));
				query="SELECT TOP 12 DEPOSIT,AVG_BAL FROM NG_MSB_SEARCH_STMTDATA_ACCMOVMNT_GRID WHERE CIC_NO='"+cic_number+"' and acc_no='"+value.get(0)+"' ORDER BY TO_DATE DESC";
				logger.info("fillAccountMovementDetails fetch query 2 is "+query);
				List<List<String>> query_result_combined= iformObj.getDataFromDB(query);
				logger.info("fillAccountMovementDetails fetch query 2 result is "+query_result_combined);
				for(List<String> query_result:query_result_combined)
				{
					logger.info("fillAccountMovementDetails fetch query 2 result values are  "+query_result.get(0).toString());
					total_12_month_througput=total_12_month_througput+Double.parseDouble(query_result.get(0).toString());
					logger.info("fillAccountMovementDetails total_12_month_througput is "+total_12_month_througput +"and result from query is "+query_result.get(0).toString());
					average_12_month_balance=average_12_month_balance+Double.parseDouble(query_result.get(1).toString());
					logger.info("fillAccountMovementDetails average_12_month_balance is "+average_12_month_balance +"and result from query is "+query_result.get(1).toString());
					double zero=Double.parseDouble(query_result.get(0).toString());
					logger.info("fillAccountMovementDetails Zeros are "+zero);
					if(zero==0.0)
					{
						zero_balance_12_month=zero_balance_12_month+1;
					}
				}
				
			}
			logger.info("fillAccountMovementDetails average_12_month_througput is "+average_12_month_througput);
			average_12_month_througput=total_12_month_througput/12;
			query="INSERT INTO NG_POS_STMTDATA_ACCMOVMNT (WI_NAME,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH) VALUES('"+processInstanceID+"','"+String.format("%.2f",total_12_month_througput)+"','"+String.format("%.2f",average_12_month_througput)+"','"+String.format("%.2f",average_12_month_balance)+"','"+zero_balance_12_month+"') ";
			logger.info("fillAccountMovementDetails save query is "+query);
			iformObj.saveDataInDB(query);
		}
		catch(Exception e)
		{
			logger.info("fillAccountMovementDetails exception occurred:  "+e);
		}
		return "Success~fillAccountMovementDetails";
	}

	private String fillAccountMovementDetails_OldCIC(IFormReference iformObj,String processInstanceID)
	{
		try
		{
			String cic_number=getControlValue(iformObj, "MSB_SEARCH_OLD_CIC_NUMBER_2");	
			String query="SELECT DISTINCT ACC_NO FROM NG_MSB_SEARCH_OLD_CIC_STMTDATA_ACCMOVMNT_GRID WHERE CIC_NO='"+cic_number+"' ";
			logger.info("fillAccountMovementDetails fetch query is "+query);
			List<List<String>> acc_number = iformObj.getDataFromDB(query);
			logger.info("fillAccountMovementDetails account numbers are "+acc_number);
			double total_12_month_througput=0,average_12_month_througput=0,average_12_month_balance=0;
			int zero_balance_12_month=0;
			for (List<String> value : acc_number) 
			{
				logger.info("fillAccountMovementDetails account numbers in loop is "+value.get(0));
				query="SELECT TOP 12 DEPOSIT,AVG_BAL FROM NG_MSB_SEARCH_OLD_CIC_STMTDATA_ACCMOVMNT_GRID WHERE CIC_NO='"+cic_number+"' and acc_no='"+value.get(0)+"' ORDER BY TO_DATE DESC";
				logger.info("fillAccountMovementDetails fetch query 2 is "+query);
				List<List<String>> query_result_combined= iformObj.getDataFromDB(query);
				logger.info("fillAccountMovementDetails fetch query 2 result is "+query_result_combined);
				for(List<String> query_result:query_result_combined)
				{
					logger.info("fillAccountMovementDetails fetch query 2 result values are  "+query_result.get(0).toString());
					total_12_month_througput=total_12_month_througput+Double.parseDouble(query_result.get(0).toString());
					logger.info("fillAccountMovementDetails total_12_month_througput is "+total_12_month_througput +"and result from query is "+query_result.get(0).toString());
					average_12_month_balance=average_12_month_balance+Double.parseDouble(query_result.get(1).toString());
					logger.info("fillAccountMovementDetails average_12_month_balance is "+average_12_month_balance +"and result from query is "+query_result.get(1).toString());
					double zero=Double.parseDouble(query_result.get(0).toString());
					logger.info("fillAccountMovementDetails Zeros are "+zero);
					if(zero==0.0)
					{
						zero_balance_12_month=zero_balance_12_month+1;
					}
				}
				
			}
			logger.info("fillAccountMovementDetails average_12_month_througput is "+average_12_month_througput);
			average_12_month_througput=total_12_month_througput/12;
			query="INSERT INTO NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT (WI_NAME,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH) VALUES('"+processInstanceID+"','"+String.format("%.2f",total_12_month_througput)+"','"+String.format("%.2f",average_12_month_througput)+"','"+String.format("%.2f",average_12_month_balance)+"','"+zero_balance_12_month+"') ";
			logger.info("fillAccountMovementDetails save query is "+query);
			iformObj.saveDataInDB(query);
		}
		catch(Exception e)
		{
			logger.info("fillAccountMovementDetails_OldCIC exception occurred:  "+e);
		}
		return "Success~fillAccountMovementDetails_OldCIC";
	}

	/*
	private String fillRelatedPartyDetails(IFormReference iformObj, String ResponseXML,String callName) 
	{		
		logger.info("Inside fillRelatedPartyDetails -------------------------------------");
		JSONObject return_obj=new JSONObject();
		
		try
		{
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			ResponseXML=ResponseXML.replace(temp,"");
	
		//logger.info("Response XML received by setResponseDataGrid is"+ResponseXML);
		String tagName = "_RelatedPartyRoleGrid";
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
							result_from_response=" ";
						}
						jsonobj.put(hash_split_values[0],result_from_response);
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
		    			
		    			jsonobj.put(hash_split_values[0],returned_value);
					}
				}
				logger.info("JSONObject is "+jsonobj);
				if(tags[0].equalsIgnoreCase("shareCompaniesLst"))
				{
					jsonobj.put("Party Type", "Company");
				}
				else
				{
					jsonobj.put("Party Type", "Individual");
				}
				
				//jsonobj.put("Party Type", "Individual");
				
				jsonarr.add(jsonobj);
			}
			
			
			//iformObj.addDataToGrid("", (JSONArray) return_obj.get(key));
			iformObj.addDataToGrid(tags[tags.length-1], jsonarr);
			
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
		
	
		
		
		
		return  "fillRelatedPartyDetails executed successfully";
	}
	*/
	
	
	//Fill Related Party Details OLD
	private String fillRelatedPartyDetails(IFormReference iformObj, String ResponseXML,String callName) 
	{
		String cic_searched_for=getControlValue(iformObj, "MSB_SEARCH_CIC");
		
		logger.info("Inside fillRelatedPartyDetails function ");
		try {
		//shareHoldersLst~shareHoldersItem~CIC#CIC~Role Descripton#RoleDesc~Percentage#Percent~Name (Eng)
		//#NameEng~Name (Ar)#NameArb~Party Type#PartyType~~MSB_SEARCH_ROLE_GRID
	
			//iformObj.clearTable("MSB_SEARCH_ROLE_GRID"); //Need to check this later
		
		JSONObject return_obj=new JSONObject();
		String tagName = "_RelatedPartyRoleGrid";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		logger.info(tagNames);
		
		XMLParser parser = new XMLParser(ResponseXML);
		String registration_type=parser.getValueOf("RegistrationType");
		parser=new  XMLParser(registration_type);
		String number=parser.getValueOf("Number");
		
		String[] tagValue = tagNames.split(",");
		for(String tag: tagValue)
		{
			String []tags=tag.split("~");
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(ResponseXML);
		//	logger.info("objWFxmlResponse value is "+objWFxmlResponse);

			JSONArray jsonarr=new JSONArray();
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
			//logger.info("Wfmxmlsit is --------------"+WFXmlList);
			for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
			{
			if (WFXmlList.getVal("GroupRoleDesc").contains("Owner")) 
			{
				JSONObject jsonobj = new JSONObject();
				for(int j=2;j<tags.length-1;++j)
				{
					
					String tag_split_values=tags[j];
					if((!tag_split_values.contains("@")))
					{
						String result_from_response="";
						String []hash_split_values=tag_split_values.split("#");
						
						if(hash_split_values[1].equalsIgnoreCase("PartyType"))
						{
							String cic_no= WFXmlList.getVal("CIC");
							result_from_response=getNameRelatedParty(callName,ResponseXML,hash_split_values[1],cic_no);
							if(result_from_response.equals(null))
							{
								result_from_response="";
							}
						}
						else if(hash_split_values[1].equalsIgnoreCase("RoleDesc"))
						{
							String role_code= WFXmlList.getVal("RoleCd");
							String role_description= WFXmlList.getVal(hash_split_values[1]);
							result_from_response=role_code+"-"+role_description;
							if(result_from_response.equals(null))
							{
								result_from_response="";
							}
						}
						else if(hash_split_values[1].equalsIgnoreCase("NameEng"))
						{	String cic_no= WFXmlList.getVal("CIC");
							result_from_response=getNameRelatedParty(callName,ResponseXML,hash_split_values[1],cic_no);
							if(result_from_response.equals(null))
							{
								result_from_response="";
							}
						}
						else if(hash_split_values[1].equalsIgnoreCase("NameArb"))
						{   String cic_no= WFXmlList.getVal("CIC");
							result_from_response=getNameRelatedParty(callName,ResponseXML,hash_split_values[1],cic_no);
							if(result_from_response.equals(null))
							{
								result_from_response="";
							}
						}
						else if(hash_split_values[1].equalsIgnoreCase("CIC") || hash_split_values[1].equalsIgnoreCase("Percent") || hash_split_values[1].equalsIgnoreCase("GroupRoleDesc") || hash_split_values[1].equalsIgnoreCase("CompanyCIC") )
						{
							result_from_response=WFXmlList.getVal(hash_split_values[1]);
							if(result_from_response.equals(null))
							{
								result_from_response="";
							}
						}
						else 
						{   String cic_no= WFXmlList.getVal("CIC");
							result_from_response=getNameRelatedParty(callName,ResponseXML,hash_split_values[1],cic_no);
							if(result_from_response.equals(null))
							{
								result_from_response="";
							}
						}
						
						
						jsonobj.put(hash_split_values[0],result_from_response);
						jsonobj.put("CIC Searched", cic_searched_for);
					}
					else
					{
						String []inputTagswithoutRateSign=tag_split_values.split("@");
						
						String []hash_split_values=inputTagswithoutRateSign[0].split("#");
						String result_from_response=WFXmlList.getVal(hash_split_values[1]);
						if(result_from_response.equals(null))
						{
							result_from_response="";
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
		    			
		    			jsonobj.put(hash_split_values[0],returned_value);
					}
					jsonobj.put("Parent CR",number);
				}
				jsonarr.add(jsonobj);
				logger.info("For related party role grid is "+jsonobj);
			}
		}
			logger.info("Everything ok till now");
			logger.info(jsonarr);
			if(jsonarr!=null && jsonarr.size()>0)
				iformObj.addDataToGrid(tags[tags.length-1],jsonarr);
			
		 }
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: fillRelatedPartyDetails and exception is "+e);
		}
			
		return  "fillRelatedPartyDetails executed successfully";
	}
	

	private String getNameRelatedParty(String callName, String ResponseXML, String requestedParameter,String cic_no) {
		
		//shareIndvidualsLst~shareIndvidualsItem~
		String return_string="";
		/*String tagName = "_RelatedPartyIndividualGrid_Tags";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		String []tags=tagNames.split("~");
		logger.info(tagNames);
		*/
		
		
		WFXmlResponse objWFxmlResponse = new WFXmlResponse(ResponseXML);
		if(requestedParameter.equalsIgnoreCase("PartyType")) 
		{
			boolean data_found=true;
			
			WFXmlList WFXmlList = objWFxmlResponse.createList("shareIndvidualsLst","shareIndvidualsItem");
			for (int i = 0; WFXmlList.hasMoreElements(true) && data_found==true; WFXmlList.skip(true), i++) 
			{
				String cic_no_child=WFXmlList.getVal("CIC");
				if(cic_no_child.equals(cic_no))
				{
					return_string="Individual";
					data_found=false;
					break ;
				}
			}
			
			WFXmlList = objWFxmlResponse.createList("shareCompaniesLst","shareCompaniesItem");
			for (int i = 0; WFXmlList.hasMoreElements(true) && data_found==true; WFXmlList.skip(true), i++) 
			{
				String cic_no_child=WFXmlList.getVal("CIC");
				if(cic_no_child.equals(cic_no))
				{
					return_string="Company";
					data_found=false;
					break;
				}
			}
			
		}
		else if(requestedParameter.equalsIgnoreCase("NameEng")) 
		{
			boolean data_found=true;
			WFXmlList WFXmlList = objWFxmlResponse.createList("shareIndvidualsLst","shareIndvidualsItem");
			for (int i = 0; WFXmlList.hasMoreElements(true) && data_found==true; WFXmlList.skip(true), i++) 
			{
				String cic_no_child=WFXmlList.getVal("CIC");
				if(cic_no_child.equals(cic_no))
				{
					String English_First_Name=WFXmlList.getVal("FirstNameEN");
					String English_Second_Name=WFXmlList.getVal("SecondNameEN");
					String English_Last_Name=WFXmlList.getVal("FamilyNameEN");
					return_string=English_First_Name+" "+English_Second_Name+" "+English_Last_Name;
					data_found=false;
					break;
				}
			}
			
			WFXmlList = objWFxmlResponse.createList("shareCompaniesLst","shareCompaniesItem");
			for (int i = 0; WFXmlList.hasMoreElements(true) && data_found==true; WFXmlList.skip(true), i++) 
			{
				String cic_no_child=WFXmlList.getVal("CIC");
				if(cic_no_child.equals(cic_no))
				{
					return_string=WFXmlList.getVal("entityName");
					data_found=false;
					break;
				}
			}
			
		}
		else if(requestedParameter.equalsIgnoreCase("NameArb")) 
		{
			boolean data_found=true;
			WFXmlList WFXmlList = objWFxmlResponse.createList("shareIndvidualsLst","shareIndvidualsItem");
			for (int i = 0; WFXmlList.hasMoreElements(true) && data_found==true; WFXmlList.skip(true), i++) 
			{
				
				String cic_no_child=WFXmlList.getVal("CIC");
				if(cic_no_child.equals(cic_no))
				{
					String Arabic_First_Name=WFXmlList.getVal("FirstNameAR");
					String Arabic_Second_Name=WFXmlList.getVal("SecondNameAR");
					String Arabic_Last_Name=WFXmlList.getVal("FamilyNameAR");
					return_string=Arabic_First_Name+" "+Arabic_Second_Name+" "+Arabic_Last_Name;
					data_found=false;
					break;
				}
			}	
			
			WFXmlList = objWFxmlResponse.createList("shareCompaniesLst","shareCompaniesItem");
			for (int i = 0; WFXmlList.hasMoreElements(true) && data_found==true; WFXmlList.skip(true), i++) 
			{
				String cic_no_child=WFXmlList.getVal("CIC");
				if(cic_no_child.equals(cic_no))
				{
					return_string=WFXmlList.getVal("entityNameOther");
					data_found=false;
					break;
				}
			}
		}
		else if(requestedParameter.equalsIgnoreCase("RegisterDate") || requestedParameter.equalsIgnoreCase("Establishate")) 
		{
			boolean data_found=true;
			WFXmlList WFXmlList = objWFxmlResponse.createList("shareCompaniesLst","shareCompaniesItem");
			for (int i = 0; WFXmlList.hasMoreElements(true) && data_found==true; WFXmlList.skip(true), i++) 
			{
				String cic_no_child=WFXmlList.getVal("CIC");
				if(cic_no_child.equals(cic_no))
				{
					String register_date=WFXmlList.getVal(requestedParameter);
					String new_date="";
					if(register_date.contains("/"))
					{
						new_date=register_date.split("/")[2]+"/"+register_date.split("/")[1]+"/"+register_date.split("/")[0];
					}
					else if(register_date.contains("-"))
					{
						new_date=register_date.split("-")[2]+"-"+register_date.split("-")[1]+"-"+register_date.split("-")[0];
					}
					return_string=new_date;
					data_found=false;
					break;
				}
			}
			
		}
		else if(requestedParameter.equalsIgnoreCase("IDIssueDate") || requestedParameter.equalsIgnoreCase("IDExpiryDate") || requestedParameter.equalsIgnoreCase("BirthDate") ) 
		{
			boolean data_found=true;
			WFXmlList WFXmlList = objWFxmlResponse.createList("shareIndvidualsLst","shareIndvidualsItem");
			for (int i = 0; WFXmlList.hasMoreElements(true) && data_found==true; WFXmlList.skip(true), i++) 
			{
				String cic_no_child=WFXmlList.getVal("CIC");
				if(cic_no_child.equals(cic_no))
				{
					String register_date=WFXmlList.getVal(requestedParameter);
					String new_date="";
					if(register_date.contains("/"))
					{
						new_date=register_date.split("/")[2]+"/"+register_date.split("/")[1]+"/"+register_date.split("/")[0];
					}
					else if(register_date.contains("-"))
					{
						new_date=register_date.split("-")[2]+"-"+register_date.split("-")[1]+"-"+register_date.split("-")[0];
					}
					return_string=new_date;
					data_found=false;
					break;
				}
			}
			
		}
		else
		{
			boolean data_found=true;
			WFXmlList WFXmlList = objWFxmlResponse.createList("shareIndvidualsLst","shareIndvidualsItem");
			for (int i = 0; WFXmlList.hasMoreElements(true) && data_found==true; WFXmlList.skip(true), i++) 
			{
				
				String cic_no_child=WFXmlList.getVal("CIC");
				if(cic_no_child.equals(cic_no))
				{
					return_string=WFXmlList.getVal(requestedParameter);;
					data_found=false;
					break;
				}
			}	
			
			WFXmlList = objWFxmlResponse.createList("shareCompaniesLst","shareCompaniesItem");
			for (int i = 0; WFXmlList.hasMoreElements(true) && data_found==true; WFXmlList.skip(true), i++) 
			{
				String cic_no_child=WFXmlList.getVal("CIC");
				if(cic_no_child.equals(cic_no))
				{
					return_string=WFXmlList.getVal(requestedParameter);;
					data_found=false;
					break;
				}
			}
		}
		
		
		return return_string.trim();
	}

	
	private String fillStatementAnalysisDetails(IFormReference iformObj, String WI_name) {
		//Logic to calculate 3 month average
		try {
		String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
		String newquery="SELECT TOP 3 THROUGHPUT FROM NG_MSB_SEARCH_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE CIC_NO='"+cic_number+"' and cortex_month<>'' AND CORTEX_MONTH<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC";//OTHER_MONTH CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC";
		logger.info("Query to calculate total througput 3 month cortex for main CIC is "+newquery);
		List<List<String>> top_3_throughput= iformObj.getDataFromDB(newquery);	
		
		double total_transaction_amt_3_months=0;
		if(top_3_throughput.size()>0)
		{
			for (Iterator<List<String>> iter = top_3_throughput.iterator(); iter.hasNext(); ) 
			{
			    List<String> element = iter.next();
			    total_transaction_amt_3_months=total_transaction_amt_3_months+Double.parseDouble(element.get(0));
			}	
		}
		
		logger.info("avg_transaction_amt for three months  cortex for main CIC  is "+total_transaction_amt_3_months);	
		
		newquery="SELECT TOT_THROUGPUT_LAST_12_MONTH,AVG_THROUGPUT_LAST_12_MONTH FROM NG_MSB_SEARCH_POS_THROUGPUT_DATA_ALL_MACHINES where CIC_NO='"+cic_number+"' ";
		logger.info("Query to calculate total througput and avg througput 12 month is "+newquery);
		List<List<String>> top_12_throughput= iformObj.getDataFromDB(newquery);	
		double total_transaction_amt_12_months=0,avg_transaction_amt_12_months=0;
		if(top_12_throughput.size()>0)
		{
				if(top_12_throughput.get(0).size()==2)
				{
					if(top_12_throughput.get(0).get(0)!="" && top_12_throughput.get(0).get(0)!="NULL")
						total_transaction_amt_12_months=Double.parseDouble(top_12_throughput.get(0).get(0));
					if(top_12_throughput.get(0).get(0)!="" && top_12_throughput.get(0).get(0)!="NULL")
						avg_transaction_amt_12_months=Double.parseDouble(top_12_throughput.get(0).get(1));
		
				}
		}
		
		double total_transaction_amt_9_months=total_transaction_amt_12_months-total_transaction_amt_3_months;
		//iformObj.setValue("Q_NG_POS_STMTDATA_STMT_ANALYSIS_AVG_POS_MACHN_LAST_12MNTH",Double.toString(total_transaction_amt_9_months));
		//Added By Deepak Goyal
				newquery="select TOP 3 THROUGHPUT from NG_MSB_SEARCH_NONPOS_POS_DETAILS where CIC='"+cic_number+"' AND transaction_month<>'0' ORDER BY convert(date,'01/'+transaction_month,103) DESC";// convert(DATETIME,replace('01-'+transaction_month,'-',' '),13) desc";
				logger.info("Query to calculate total througput for non POS 3 month is "+newquery);
				List<List<String>> top_3_throughput_nonPOS= iformObj.getDataFromDB(newquery);
				if(top_3_throughput_nonPOS.size()>0)
				{
					for (Iterator<List<String>> iter = top_3_throughput_nonPOS.iterator(); iter.hasNext(); ) {
					    List<String> element = iter.next();
					    total_transaction_amt_3_months=total_transaction_amt_3_months+Double.parseDouble(element.get(0));
						//logger.info("Individual avg_transaction amoutn for 4 months is "+element+" and sum is "+avg_transaction_amt );    
					}	
				}
				//End By Deepak Goyal
				
				
		//Start Edit By Deepak Goyal
		double total_transaction_amt_9_months_non=0;
		newquery="select TOP 9 THROUGHPUT from NG_MSB_SEARCH_NONPOS_POS_DETAILS where CIC='"+cic_number+"' AND transaction_month<>'0' ORDER BY convert(date,'01/'+transaction_month,103) ASC";//convert(DATETIME,replace('01-'+transaction_month,'-',' '),13) asc";
		logger.info("Query to calculate total througput for non POS 9 month is "+newquery);		
		List<List<String>> top_9_throughput= iformObj.getDataFromDB(newquery);	
		if(top_9_throughput.size()>0)
		{
			for (Iterator<List<String>> iter = top_9_throughput.iterator(); iter.hasNext(); ) {
			    List<String> element = iter.next();
			    total_transaction_amt_9_months_non=total_transaction_amt_9_months_non+Double.parseDouble(element.get(0));
				//logger.info("Individual avg_transaction amoutn for 4 months is "+element+" and sum is "+avg_transaction_amt );    
			}	
		}
		total_transaction_amt_9_months=total_transaction_amt_9_months+total_transaction_amt_9_months_non;
		//End edit by Deepak Goyal
		
		
		//Start of Calculation for Old CIC Data
		String Old_Cic=(String) iformObj.getValue("MSB_SEARCH_OLD_CIC_NUMBER_2");
		
		double total_transaction_amt_9_months_oldCIC=0,total_transaction_amt_3_months_oldCIC=0;
		newquery="SELECT TOP 3 THROUGHPUT FROM NG_MSB_SEARCH_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE CIC_NO='"+Old_Cic+"' and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC";//--CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC		
		List<List<String>> top_3_throughput_POS_oldCIC= iformObj.getDataFromDB(newquery);
		logger.info("Query to calculate total througput for old CIC 3 month is "+newquery+ "and it's result is "+top_3_throughput_POS_oldCIC);
				if(top_3_throughput_POS_oldCIC.size()>0)
				{
					for (Iterator<List<String>> iter = top_3_throughput_POS_oldCIC.iterator(); iter.hasNext(); ) 
					{
					    List<String> element = iter.next();
					    if(element.get(0)!="")
					    total_transaction_amt_3_months_oldCIC=total_transaction_amt_3_months_oldCIC+Double.parseDouble(element.get(0));
					}	
				}
		
		logger.info("Final Total Value of 3 months old CIC througput is "+total_transaction_amt_3_months_oldCIC+" and now we will add it total 3 months througput whose value upto now is "+total_transaction_amt_3_months+" and final value  will be");
		total_transaction_amt_3_months=total_transaction_amt_3_months+total_transaction_amt_3_months_oldCIC;
		logger.info(total_transaction_amt_3_months);
		
		newquery="SELECT TOP 9 THROUGHPUT FROM NG_MSB_SEARCH_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE CIC_NO='"+Old_Cic+"' and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) ASC ";//--CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) ASC
		List<List<String>> top_9_throughput_oldCIC= iformObj.getDataFromDB(newquery);	
		logger.info("Query to calculate total througput for for old CIC 9 month is "+newquery+" and it's result is "+top_9_throughput_oldCIC);		
		if(top_9_throughput_oldCIC.size()>0)
		{
			for (Iterator<List<String>> iter = top_9_throughput_oldCIC.iterator(); iter.hasNext(); ) 
			{
			    List<String> element = iter.next();
			    if(element.get(0)!="")
			    	total_transaction_amt_9_months_oldCIC=total_transaction_amt_9_months_oldCIC+Double.parseDouble(element.get(0));
				    
			}	
		}
		
		logger.info("Final Total Value of 3 months old CIC througput is "+total_transaction_amt_9_months_oldCIC+" and now we will add it total 9 months througput whose value upto now is "+total_transaction_amt_9_months+" and final value  will be");
		total_transaction_amt_9_months=total_transaction_amt_9_months+total_transaction_amt_9_months_oldCIC;
		logger.info(total_transaction_amt_9_months);
		//End of Calculation for Old CIC Data
		
		
		double no_of_pos_machine=0;
		newquery="SELECT COUNT(DISTINCT TERMINAL_ID) FROM NG_POS_STMTDATA_CORTEX_DETAIL_GRID WHERE WI_NAME='"+WI_name+"' ";
		logger.info("Result of query to calculate no of pos machines is "+newquery);
		List<List<String>> no_of_pos_machine_object= iformObj.getDataFromDB(newquery);
		if(no_of_pos_machine_object.size()>0)
		{
			if(!no_of_pos_machine_object.get(0).get(0).equalsIgnoreCase("NULL"))
				no_of_pos_machine=no_of_pos_machine+Double.parseDouble(no_of_pos_machine_object.get(0).get(0));
		}
		
		//Adding Number of POS machines for Old CIC (Start)
		newquery="SELECT COUNT(DISTINCT TERMINAL_ID) FROM NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID WHERE WI_NAME='"+WI_name+"' ";
		no_of_pos_machine_object= iformObj.getDataFromDB(newquery);
		logger.info("Result of query to calculate no of pos machines for Old CIC is "+newquery+" and it's result is "+no_of_pos_machine_object);
		if(no_of_pos_machine_object.size()>0)
		{
			if(!no_of_pos_machine_object.get(0).get(0).equalsIgnoreCase("NULL") && !no_of_pos_machine_object.get(0).get(0).equalsIgnoreCase(""))
				no_of_pos_machine=no_of_pos_machine+Double.parseDouble(no_of_pos_machine_object.get(0).get(0));
		}
		//Adding Number of POS machines for Old CIC (End)
		
		String padded_cic_no=cic_number;
		for(int i=0;i<16-cic_number.length();i++)
		{
			padded_cic_no="0"+padded_cic_no;
		}
		
		String no_non_of_pos_machine="0";
		//newquery="SELECT TOP 1 NON_ARB_POS_MACHINE_NO FROM NG_STATEMENT_OCR_CUST_INFO WHERE CIC_NO ='"+padded_cic_no+"' ORDER BY CAST(SUBSTRING(WI_NAME,5,14) AS INT) DESC ";
		
		newquery="SELECT convert(varchar,min(convert(date,pos_since,103)),103),sum(num_of_pos) FROM (select pos_since,num_of_pos,row_number() over(partition by  bank_name+'_'+ACCOUNT_NO order by  bank_name+'_'+ACCOUNT_NO ) rownum from NG_MSB_SEARCH_NONPOS_POS_DETAILS  WHERE  CIC='"+padded_cic_no+"' ) a where rownum=1  ";

		List<List<String>> no_of_non_pos_machine_object= iformObj.getDataFromDB(newquery);
		logger.info("Result of query to calculate no of non pos machines is "+newquery+"and its result is "+no_of_non_pos_machine_object);
		if(no_of_non_pos_machine_object.size()>0)
		{
			if(!no_of_non_pos_machine_object.get(0).get(1).equalsIgnoreCase("NULL"))
				no_non_of_pos_machine=no_of_non_pos_machine_object.get(0).get(1);
		}
		
		String savequery="INSERT INTO NG_POS_STMTDATA_STMT_ANALYSIS (WI_NAME,AVG_POS_MACHN_LAST_3MNTH,AVG_POS_MACHN_LAST_12MNTH,NO_POS_MACHINE,NO_NON_POS_MACHINE) VALUES ('"+WI_name+"','"+String.format("%.2f",total_transaction_amt_3_months/3)+"','"+String.format("%.2f",total_transaction_amt_9_months/9)+"','"+Double.valueOf(no_of_pos_machine).intValue()+"','"+no_non_of_pos_machine+" ') ";
		logger.info("Query to update statement analysis in statement data tab is "+savequery);
		saveDataInDB(iformObj, savequery);
			
		newquery="SELECT TOT_THRGPUT_12MNTH, AVG_THRGPUT_12MNTH FROM NG_POS_STMTDATA_OTHER_DETAIL WHERE WI_NAME ='"+WI_name+"' ";
		logger.info("Query to calculate total througput and avg througput 12 month for non arb customer is "+newquery);
		List<List<String>> top_12_throughput_non_arb= iformObj.getDataFromDB(newquery);	
		
		double total_transaction_amt_12_months_non_arb=0,avg_transaction_amt_12_months_non_arb=0;
		if(top_12_throughput_non_arb.size()>0)
		{
				if(top_12_throughput_non_arb.get(0).size()==2)
				{
					if(top_12_throughput_non_arb.get(0).get(0)!="" && top_12_throughput_non_arb.get(0).get(0)!="NULL")
						total_transaction_amt_12_months_non_arb=Double.parseDouble(top_12_throughput_non_arb.get(0).get(0));
					if(top_12_throughput_non_arb.get(0).get(1)!="" && top_12_throughput_non_arb.get(0).get(1)!="NULL")
						avg_transaction_amt_12_months_non_arb=Double.parseDouble(top_12_throughput_non_arb.get(0).get(1));
				}
		}
		
		//Calculation of Total and Average throughput for old CIC (Start)
		newquery="SELECT TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH FROM NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL WHERE WI_NAME ='"+WI_name+"' ";
		logger.info("Query to calculate total througput and avg througput 12 month for old CIC is "+newquery);
		List<List<String>> top_12_throughput_oldCIC= iformObj.getDataFromDB(newquery);	
		
		double total_transaction_amt_12_months_oldCIC=0,avg_transaction_amt_12_months_oldCIC=0;
		if(top_12_throughput_oldCIC.size()>0)
		{
				if(top_12_throughput_oldCIC.get(0).size()==2)
				{
					if(top_12_throughput_oldCIC.get(0).get(0)!="" && top_12_throughput_oldCIC.get(0).get(0)!="NULL")
						total_transaction_amt_12_months_oldCIC=Double.parseDouble(top_12_throughput_oldCIC.get(0).get(0));
					if(top_12_throughput_oldCIC.get(0).get(1)!="" && top_12_throughput_oldCIC.get(0).get(1)!="NULL")
						avg_transaction_amt_12_months_oldCIC=Double.parseDouble(top_12_throughput_oldCIC.get(0).get(1));
				}
		}
		
		logger.info("Total 12 Months throuput for Old CIC is "+total_transaction_amt_12_months_oldCIC);
		logger.info("Average 12 Months throuput for Old CIC is "+avg_transaction_amt_12_months_oldCIC);
		
		total_transaction_amt_12_months=total_transaction_amt_12_months+total_transaction_amt_12_months_oldCIC;
		avg_transaction_amt_12_months=avg_transaction_amt_12_months+avg_transaction_amt_12_months_oldCIC;
		//Calculation of Total and Average throughput for old CIC (End)
		
		
		
		newquery="SELECT MAX_INDICATIVE_AMT_ELIGIBLE FROM NG_POS_APPLICATION_DATA WHERE WI_NAME='"+WI_name+"' ";
		logger.info("Query to calculate total througput and avg througput 12 month for non arb customer is "+newquery);
		List<List<String>> max_limit_amnt= iformObj.getDataFromDB(newquery);	
		String max_indicative_amt="0";
		if(max_limit_amnt.size()>0)
		{
			max_indicative_amt=max_limit_amnt.get(0).get(0);
		}
		//iformObj.setValue("Q_NG_POS_ELIGIBILITY_ELIGIBLE_POS_LIMIT",max_indicative_amt);
		//savequery="UPDATE NG_POS_ELIGIBILITY SET POS_TRNOVR_ALL='"+Double.toString(total_transaction_amt_12_months_non_arb+total_transaction_amt_12_months)+"',POS_TRNOVR_ALRAJHI='"+Double.toString(total_transaction_amt_12_months)+"',POS_TRNOVR_OTHRBANK='"+Double.toString(total_transaction_amt_12_months_non_arb)+"',AVG_POS_MNTHLY_TRNOVRALL='"+Double.toString(avg_transaction_amt_12_months_non_arb+avg_transaction_amt_12_months)+"',AVG_POS_MNTHLY_TRNOVRALL_ALRAJHI='"+Double.toString(avg_transaction_amt_12_months)+"',AVG_POS_MNTHLY_TRNOVRALL_OTHRBANK='"+Double.toString(avg_transaction_amt_12_months_non_arb)+"',ELIGIBILE_POS_LIMIT='"+max_indicative_amt+"' WHERE WI_NAME='"+WI_name+"' ";
		savequery="INSERT INTO NG_POS_ELIGIBILITY (WI_NAME,POS_TRNOVR_ALL,POS_TRNOVR_ALRAJHI,POS_TRNOVR_OTHRBANK,AVG_POS_MNTHLY_TRNOVRALL,AVG_POS_MNTHLY_TRNOVRALL_ALRAJHI,AVG_POS_MNTHLY_TRNOVRALL_OTHRBANK,ELIGIBILE_POS_LIMIT) VALUES ('"+WI_name+"','"+String.format("%.2f",total_transaction_amt_12_months_non_arb+total_transaction_amt_12_months)+"','"+String.format("%.2f",total_transaction_amt_12_months)+"','"+String.format("%.2f",total_transaction_amt_12_months_non_arb)+"','"+String.format("%.2f",avg_transaction_amt_12_months_non_arb+avg_transaction_amt_12_months)+"','"+String.format("%.2f",avg_transaction_amt_12_months)+"','"+String.format("%.2f",avg_transaction_amt_12_months_non_arb)+"','"+max_indicative_amt+"')";
		logger.info("Query to update eligibilty tab is "+savequery);
		saveDataInDB(iformObj, savequery);
		
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: fillStatementAnalysisDetails  "+e);
		}
		return "fillStatementAnalysisDetails executed Successfully";
	}

	private String ListViewTest(IFormReference iformObj, String stringdata) {
		 logger.info("Inside ListViewTest");
		 JSONArray jsonArray=new JSONArray();
		 JSONObject obj=new JSONObject();
	
		 obj.put("One", "Banana");
		 obj.put("Two", "Mango");
		 obj.put("Three", "Orange");
		 obj.put("Four", "Pineapple");
		 
		 jsonArray.add(obj);
		 iformObj.addDataToGrid("MSB_SEARCH_LISTVIEWTEST",jsonArray);
		 logger.info("Inside ListViewTest and jsonarray is "+jsonArray);
		 return "ListViewTest returns sucess";
	}
	
	private String return_max_min_amount_search_screen(IFormReference iformObj, String stringdata) {
		logger.info("+++++++++++++ we are inside max and min function ++++++++++++++");
		String product_category=(String) iformObj.getValue("PRODUCT_CATEGORY");
		String request_type=(String) iformObj.getValue("REQUEST_TYPE");
		String cutomer_category=(String) iformObj.getValue("CUSTOMER_CATEGORY");
		String maxamt = "";
		String minamt = "";
		try {
			String query = "SELECT max(Max_Amount), min(Min_Amount) FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+cutomer_category+"') AND a.request_type='"+request_type+"' ";
			logger.info("To select min and max value query is "+query);
			List<List<String>> result = iformObj.getDataFromDB(query);
			if(result.size()>0)
			{
				maxamt = (String) result.get(0).get(0);
				minamt = (String) result.get(0).get(1);
			}
		}
		catch(Exception e) {
			logger.info("Exception occurred: retrurnMax_and_Min "+e);
		}
		String minMaxData = maxamt+"@"+minamt;
		logger.info("min max data String ============> "+minMaxData);

		return minMaxData;
	}
	
	private String setSearchScreenHeader(IFormReference iformObj, String stringData) {
		int rowindex = Integer.parseInt(stringData);
		logger.info("Row index selected by user is" + rowindex);
		JSONArray jsonarr = iformObj.getDataFromGrid("MSB_SEARCH_HEADER_GRID");
		JSONObject jsonobj = (JSONObject) jsonarr.get(rowindex);
		String cic_no=(String) jsonobj.get("CIC No");
		String comp_eng_name=(String) jsonobj.get("Entity Name (Eng)");
		String comp_ar_name=(String) jsonobj.get("Entity Name (Ar)");
		String unn=(String) jsonobj.get("UNN");
		String cr_number=(String) jsonobj.get("CR Number");
		String entity_type=(String) jsonobj.get("Entity Type");
		
		iformObj.setValue("NG_MSB_CIC_NO", cic_no);
		iformObj.setValue("NG_MSB_COMP_ENGLISH_NAME", comp_eng_name);
		iformObj.setValue("NG_MSB_COMP_ARABIC_NAME", comp_ar_name);
		iformObj.setValue("NG_MSB_UNN_NO", unn);
		iformObj.setValue("NG_MSB_CR_NO", cr_number);
		//iformObj.setValue(entity_type, jsonarr);
		return "setSearchScreenHeader set successfully";
	}

	private String fetchButtonClicked(IFormReference iformObj, String stringData) 
	{
		iformObj.clearTable("MSB_SEARCH_ROLE_GRID");
		cic_no_visited=new ArrayList<String>();
		
		try
		{
			String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
			logger.info("CIC_no checked at msbSearchButtonClicked is"+cic_number);
			customer_blacklisted=false;
			customer_blacklisted_descr="";
			
			//Code to check if customer is blacklisted or not using Clist
			String second_query="SELECT CIC_NO FROM NG_MAST_CLIST_DATA WHERE ISACTIVE='Y' ";
			List<List<String>> second_blacklisted_data = iformObj.getDataFromDB(second_query);
			for(List<String> temp: second_blacklisted_data)
			{
					if(temp.get(0).equalsIgnoreCase(cic_number))
					{
						customer_blacklisted=true;
						customer_blacklisted_descr="CIC No "+cic_number+" is blacklisted~";
						logger.info("Customer is blacklisted with description "+customer_blacklisted_descr+"~");
						break;
					}
			}
			
			if(customer_blacklisted==true)
				setControlValue(iformObj, "MSB_SEARCH_BLACKLIST_STATUS", "Blacklisted");
			else
				setControlValue(iformObj, "MSB_SEARCH_BLACKLIST_STATUS", "Not Blacklisted");
			
			
			//String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
			setControlValue(iformObj, "MSB_SEARCH_CIC", cic_number);
			String callName="MSBEntityDataInq";
			String responseXML = createRequestXML(iformObj, callName);		
			fillCompanyDataSearchScreen(iformObj,stringData,cic_number,responseXML,callName);
			
			logger.info("Before first call of RelatedPartyiterator ");
			RelatedPartyiterator(cic_number,iformObj);
			logger.info("After first call of RelatedPartyiterator");
			
			
			
			String grid_id="MSB_SEARCH_ROLE_GRID";
			String table_name="NG_MSB_SEARCH_RELATED_PARTY_ROLES_GRID";
			String column_names="CHILD_CIC,ROLE_DESCRIPTION,PERCENTAGE,PARTY_TYPE,NAME_ENG,NAME_AR,GROUP_DESCRIPTION,CR,UNN,CICStatus,RegisterDate,Establishate,entityName,entityNameOther,entityTypeCd,entityTypeDesc,CountryCd,SectorCd,SubSectorCd,SamaSectorDesc,BankSectorDesc,ActivityDesc,SubSectorDesc,RegTypeCd,RegTypeDesc,entityCityName,entityRegionCd,entityCountryCd,entitySAMASectorCd,FirstNameAR,SecondNameAR,FamilyNameAR,FirstNameEN,SecondNameEN,FamilyNameEN,Nationality,BirthDate,Age,MaritalStatus,MaritalStatusDesc,AddressBuildingNumber,AddressUnitNumber,AddressStreetName,AddressRegion,AddressCityCd,AddressCityName,AddressAdditionalNumber,AddressPostalCd,PrefContactNo,MobileNum,PartyStatusDesc,NationalityDesc,ID_NUMBER,ID_ISSUE_DATE,ID_EXPIRY_DATE,GENDER,PARENT_CIC,PARENT_CR,ENTRY_DATE_TIME";
			String field_list="CIC,Role Description,Percentage,Party Type,Name (Eng),Name (Ar),Group Description,CR Number,UNN Number,CIC Status,Register Date,Establish Date,Entity Name,Entity Name Other,Entity Type Code,Entity Type Description,Country Code,Sector Code,Sub Sector Code,Sama Sector Description,Bank Sector Description,Activity Description,Sub Sector Description,Registration Type Code,Registration Type Description,Entity City Name,Entity Registration Code,Entity Country Code,Entity Sama Sector Code,First Name (Ar),Second Name (Ar),Family Name (Ar),First Name (Eng),Second Name (Eng),Family Name (Eng),Nationality,Birth Date,Age,Marital Status,Martial Status Description,Address Building No,Address Unit No,Address Street No,Address Region,Address City Code,Address City Name,Address Additional Number,Address Postal Code,Pref Contact Number,Mobile Number,Party Status Desciption,Nationality Description,ID Number,ID Issue Date,ID Expiry Date,Gender,Parent CIC,Parent CR";
			setDatainDBfromSearchScreenGrid(iformObj,"NG_MSB_CIC_NO",grid_id,table_name,column_names,field_list);
			logger.info("Inside MSB_SEARCH_ROLE_GRID");
			
			
			//logger.info("Inside Fetch Thiqah details for search screen");
			
			//callName = "GetCrInfobyCrNo_SearchScreen"; //For Thiqah details
			//responseXML = createRequestXML(iformObj, callName);
			//setResponseDataSearchScreen(iformObj, callName, responseXML);
			
			
			callName = "MSBCustMng"; //For Prospect Customer
			responseXML = createRequestXML(iformObj, callName);
			logger.info("Setting prospect customer from search screen");
			setResponseDataSearchScreen(iformObj, callName, responseXML);
			
		    //String[] callNamesGrid = { "MSBAcctsDataInq_SearchScreen","MSBFacilitiesDataInq_SearchScreen","CustOutstandingInq_SearchScreen" }; //For account movement, CTF and loan details
		    String[] callNamesGrid = { "MSBAcctsDataInq_SearchScreen","CustOutstandingInq_SearchScreen" }; //For account movement and loan details
			//String[] callNamesGrid = { "MSBAcctsDataInq_SearchScreen", "MSBFacilitiesDataInq_SearchScreen"}; //For cortex and bankdetails
			for (String callNames : callNamesGrid) 
			{
				responseXML = createRequestXML(iformObj, callNames);
				setResponseDataGridSearchScreen(iformObj, callNames, responseXML);
				if(callNames.equalsIgnoreCase("MSBAcctsDataInq_SearchScreen"))
				{
					setResponseDataGridSearchScreen(iformObj,"MSBAcctsDataInq_ClosingBalance", responseXML);
					setResponseDataGridSearchScreen(iformObj,"MSBAcctsDataInq_AccountStatus", responseXML);
				}
			}
			
			fetchAllCTFData(iformObj,"");
			
			callName="MerchantDtlsInq_SearchScreen#MerchantPOSTrxnsSummaryInq_SearchScreen";// For terminal data
			logger.info("calling filltermnialdata_searchscreen function");
			fillTerminalData_SearchScreen(iformObj, callName);
		//	String returnResponse=createRequestXML(iformObj,"MerchantPOSTrxnsSummaryInq_SearchScreen");
			fillTerminalData_allmachines_SearchScreen(iformObj,"MerchantPOSTrxnsSummaryInq_SearchScreen");
			findRequestType(iformObj);
			findcustomercategory(iformObj);
			/*
			String query="0";
			double throughput_12=0,throughput_3=0,max_eligible_amt=0,total_throughput_12=0;
			boolean handle_case=false;
			try
			{
				List<List<String>> pos_data = iformObj.getDataFromDB(query);
				logger.info("DB query restul for max amount is"+pos_data);
				if(pos_data.size()>0)
				{
					
					for(List<String> temp:pos_data)
					{
						total_throughput_12=total_throughput_12+Double.parseDouble(temp.get(0));
						throughput_12=throughput_12+Double.parseDouble(temp.get(1));
						if(!temp.get(2).isEmpty() && !temp.get(2).equals("") && !temp.get(2).equals(null))
						{
							throughput_3=throughput_3+Double.parseDouble(temp.get(2));
						}
						else
						{
							handle_case=true;
						}
					}
					logger.info("Total 12 month throughput is "+total_throughput_12);
					logger.info("Total avg 12 month throughput is "+throughput_12);
					logger.info("Total avg 3 month throughput is "+throughput_3);
				}
				
				if(handle_case==false)
				{
					logger.info("Minimum of these throughput is "+Math.min(throughput_12, throughput_3));
					max_eligible_amt=6*Math.min(throughput_12, throughput_3);
					logger.info("Maximum Eligible amount is"+max_eligible_amt);
				}
				else
				{
					max_eligible_amt=(total_throughput_12/12)*6;

				}
				setControlValue(iformObj,"MAX_INDICATIVE_AMNT_ELEGIBLE",String.format("%.3f", max_eligible_amt));
				setControlValue(iformObj,"LAST_TWELVE_AVERAGE_BALANCE",String.format("%.3f", throughput_12));
			}
			catch(Exception e)
			{
				logger.info("Exception occurred: msbSearchButtonClicked: Database Query "+query+" and stack trace is"+e);
			}
			*/
			int serial_number=1;
			
			iformObj.clearTable("PREVIOUS_APP_GRID");
			
			try
			{
				table_name="NG_MSB_SEARCH_PREVIOUS_APPLICATION_GRID";
				String delete_query="DELETE FROM "+table_name+" where CIC_NO= '"+cic_number+"' ";
				iformObj.saveDataInDB(delete_query);
				//logger.info("With this query table is emptied :: "+delete_query);
				
				String query="SELECT  '',A.WI_NAME,CIC_NO,PRODUCT_CATEGORY,PRODUCT,CUSTOMER_CATEGORY,CAMPAIGN,'',MAX_INDICATIVE_AMT_ELIGIBLE,APPROVED_LIMIT_AMT_AFTER_SIMAH,PROCESSBY,CREATEDDATE,CURR_WSNAME,DECISION_KEY FROM NG_POS_EXTTABLE A,NG_POS_APPLICATION_DATA B WHERE A.WI_NAME=B.WI_NAME AND CIC_NO='"+cic_number+"'";
				List<List<String>> previous_app_data = iformObj.getDataFromDB(query);
				//logger.info("result from previous app data query is"+previous_app_data);
				
				String field_names="S. No,Application No,CIC No,Product Category,Product,Customer Category,Campaign,Limit Number,Limit Amount,Loan Amount,Created By,Entry Date,Current Workstep Name,Current Status,";
				String []column_names_arr=field_names.split(",");
				
				JSONArray jsonarr=new JSONArray();
				JSONObject jsonobj;//=new JSONObject();
				//boolean request_type_flag=false;
				
				if(previous_app_data.size()>0)
				{
					for(List<String> temp: previous_app_data)
					{
						jsonobj=new JSONObject();
						logger.info("temp is :::::"+temp);
						temp.set(0,Integer.toString(serial_number));
						String CURR_WS=temp.get(temp.size()-2);
						if(CURR_WS.equalsIgnoreCase("EXIT"))
							{
								temp.set(temp.size()-1,"Completed");
								//request_type_flag=true;
							}
						else if(CURR_WS.equalsIgnoreCase("DISCARD"))
						{
							temp.set(temp.size()-1,"Discard");
						}
						else
							temp.set(temp.size()-1,"WIP");
						
						for(int i=0;i<temp.size();i++)
						{
							jsonobj.put(column_names_arr[i], temp.get(i));
							
						}
						//logger.info("Json arr of previous data is "+jsonobj);
						jsonarr.add(jsonobj);
						serial_number++;
					}
					
				
				
				logger.info("Json arr of previous data is "+jsonarr);
				iformObj.addDataToGrid("PREVIOUS_APP_GRID",jsonarr);
				column_names="SERIAL_NO,APPLICATION_NO,PRODUCT_CATEGORY,PRODUCT,CUSTOMER_CATEGORY,CAMPAIGN,LIMIT_NUMBER,LIMIT_AMOUNT,LOAN_AMOUNT,CURRENT_STATUS,CREATED_BY,ENTRY_DATE,CURRENT_WORKSTEP_NAME,ENTRY_DATE_TIME";
			    SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
				field_list="S. No,Application No,Product Category,Product,Customer Category,Campaign,Limit Number,Limit Amount,Loan Amount,Current Status,Created By,Entry Date,Current Workstep Name";
				setDatainDBfromSearchScreenGrid(iformObj,"NG_MSB_CIC_NO","PREVIOUS_APP_GRID",table_name,column_names,field_list);
				
				//String request_type_query="SELECT DISTINCT LOAN_STATUS FROM NG_MSB_SEARCH_POS_CREDITLINE_FINACC_GRID WHERE CIC_NO='3101145'";
				//iformObj.saveDataInDB(request_type_query);
				
				}
			}catch(Exception e)
			{
				logger.info("Exception occurred: fetchButtonClicked:: PreviousApplicationGrid "+e);
			}
			
			
			/*
			boolean request_type_flag=false;
			String request_type_query="SELECT DISTINCT LOAN_STATUS FROM NG_MSB_SEARCH_POS_CREDITLINE_FINACC_GRID WHERE CIC_NO='"+cic_number+"' ";
			logger.info("Query of request type is "+request_type_query);
			List<List<String>> returned_result = getDataFromDB(iformObj, request_type_query);
			for (List<String> value : returned_result) 
			{
				String result = value.get(0);
				if(result.equalsIgnoreCase("Regular"))
				{
					request_type_flag=true;
					break;
				}
			}
			if(request_type_flag==true)
				setControlValue(iformObj,"REQUEST_TYPE", "Top-Up Request");
			*/
			table_name="NG_MSB_SEARCH_NEW_REQUEST_DATA";
			String new_request_column_names="CIC_NO,CUSTOMER_CATEGORY,REQUEST_TYPE,PRODUCT_CATEGORY,PRODUCT,LAST_12_MONTH_AVG_BAL,MAX_INDIC_AMT_ELIGIBLE,REQUIRED_AMT_SAR,ENTRY_DATE_TIME";
			String new_request_data_id="NG_MSB_CIC_NO,CUSTOMER_CATEGORY,REQUEST_TYPE,PRODUCT_CATEGORY,PRODUCT,LAST_TWELVE_AVERAGE_BALANCE,MAX_INDICATIVE_AMNT_ELEGIBLE,REQUIRED_AMT_SAR";
			setDatainDBfromSearchScreen(iformObj,"NG_MSB_CIC_NO",table_name,new_request_data_id,new_request_column_names);
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: fetchButtonClicked "+e);
		}
		
		return "MSB fetch button operations performed successfully";
	}

	private String findRequestType(IFormReference iformObj)
	{
		logger.info("Inside handling of findRequestType");
		String cic_no="";
		cic_no=getControlValue(iformObj, "NG_MSB_CIC_NO");	
		String regex="^0+(?!$)";
		String unpadded_cic_no=cic_no.replaceAll(regex,"");
		logger.info("Padded cic no is "+cic_no+" and the unpadded cic_no is "+unpadded_cic_no);
		
		try
		{
		
			String query="SELECT SUM(B.A) FROM ( SELECT COUNT(1) A FROM NG_MSB_CREDITLINE_CTF_MSB_GRID WHERE CIC_NO = '"+cic_no+"' AND PRODUCT_CODE='1012' UNION SELECT COUNT(1) A FROM NG_MSB_SEARCH_POS_CREDITLINE_FINACC_GRID WHERE CIC_NO = '"+cic_no+"' AND PRODUCT='Point of Sale Finance' UNION SELECT  COUNT(1) A FROM NG_MAST_TRASSET_DATA WHERE CIC = '"+unpadded_cic_no+"' ) B";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to findRequestType for cic no "+cic_no+" is "+query+" and it's result is "+result);
			String count="";
			int counter;
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					count=result.get(0).get(0);
				}
			}
			
			try
			{
				counter=Integer.parseInt(count);
			}
			catch(Exception e)
			{
				counter=0;
			}
			
			logger.info("findRequestType counter value is "+counter);
			
			if(counter==0)
			{
				setControlValue(iformObj,"REQUEST_TYPE", "New Request");
			}
			else
			{
				//setControlValue(iformObj,"REQUEST_TYPE", "New Request");
				setControlValue(iformObj,"REQUEST_TYPE", "Top-Up Request");
			}
		
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: findRequestType and exception is"+e);
		}
		
		return "Success~findRequestType";
	}
	
	private String fetchAllCTFData(IFormReference iformObj, String stringData)
	{
		try
		{
			
		
		logger.info("Inside fetchAllCTFData handling");
		String callName="MSBFacilitiesDataInq_SearchScreen";
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
		String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
		
		
		String values=" ";
		String query="";
		String columnames="CIC_NO,FACILITY_TYPE,";
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
			
			columnames="CIC_NO,FACILITY_TYPE,";
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
				values=values+"( '"+cic_number+"',";
				
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
		
		callName="LoanDisburseDataInq_SearchScreen";
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
			cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");

			values=" ";
			query="";
			columnames="CIC_NO,";
			insertinto="INSERT INTO ";
			
			statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
			status_code_split=statuscode.split("~");
			
			
			for(String tag: tagValue)
			{
				tags=tag.split("~");
				WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
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
	
	public String msbUploadNonARBButtonClicked(IFormReference iformObj, String sessionID) {
		NGEjbClient objNGEjbClient = null;
		String sJtsIp = "127.0.0.1";
		String iJtsPort = "8080";
		String retval = "";
		String cic_no=getControlValue(iformObj, "NG_MSB_CIC_NO");
		String cr_no=getControlValue(iformObj, "NG_MSB_CR_NO");
		if("".equalsIgnoreCase(cic_no))
		{
			cic_no=getControlValue(iformObj, "PADDED_CIC_NO");
			cr_no=getControlValue(iformObj, "Q_NG_POS_COMPANY_DATA_CR_NUMBER");
		}
		try {
		String uploadWorkitem = "<?xml version=\"1.0\"?><WFUploadWorkItem_Input><Option>WFUploadWorkItem</Option>"
		+ "<EngineName>" + iformObj.getCabinetName() + "</EngineName><SessionId>" + sessionID
		+ "</SessionId><ProcessDefId>31</ProcessDefId>"
		+ "<QueueId>483</QueueId><InitiateFromActivityId>1</InitiateFromActivityId>"
		+ "<UserDefVarFlag>Y</UserDefVarFlag><InitiateAlso>N</InitiateAlso><Attributes><Q_NG_STATEMENT_OCR_CUST_INFO><CIC_NO>"+cic_no+"</CIC_NO><CR_NO>"+cr_no+"</CR_NO></Q_NG_STATEMENT_OCR_CUST_INFO></Attributes><IsWorkItemExtInfo>N</IsWorkItemExtInfo><Documents></Documents></WFUploadWorkItem_Input>";
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


	
	private String msbEligibilityCheckButtonClicked(IFormReference iformObj, String stringData) 
	{

		String old_cic_number=(String) iformObj.getValue("MSB_SEARCH_OLD_CIC_NUMBER_2");
		
		String query="select top 1 cast(AVG_BAL_ELIG as decimal) from NG_STATEMENT_OCR_CUST_INFO where CIC_NO='"+iformObj.getValue("NG_MSB_CIC_NO").toString()+"' order by cast(substring(WI_NAME,5,(CHARINDEX('-',substring(WI_NAME,5,50))-1)) as numeric) desc";
		List<List<String>> avg_bal_Elig = iformObj.getDataFromDB(query);
		logger.info("Query to fetch avg_bal_Elig  is "+query+" and its result is "+avg_bal_Elig);
		if(avg_bal_Elig.size()>0)
		{
			if(avg_bal_Elig.get(0).size()>0)
			{
				iformObj.setValue("LAST_TWELVE_AVERAGE_BALANCE_STMT_UPLOAD", avg_bal_Elig.get(0).get(0));
			}
			else
			{
				iformObj.setValue("LAST_TWELVE_AVERAGE_BALANCE_STMT_UPLOAD","");
			}
		}
		else
		{
			iformObj.setValue("LAST_TWELVE_AVERAGE_BALANCE_STMT_UPLOAD","");
		}
		/*
		if(customer_blacklisted==false)
		{
		return "All ok";
		}*/
		if(old_cic_number.equalsIgnoreCase(""))
		{
			old_cic_number="0";
		}
		
		String parameterlist =  iformObj.getValue("NG_MSB_CIC_NO").toString() + "~" +old_cic_number;
		String eligibility=callProcedurewithreturn(iformObj, "NG_calculate_limit_msb",parameterlist);
		logger.info("eligibility:"+eligibility);
		if(eligibility!=null)
		{
			iformObj.setValue("MAX_INDICATIVE_AMNT_ELEGIBLE", eligibility.split("~")[0].replace("[[", "").replace("[", "").replace("]", ""));

		/*logger.info("NG_POS_Eligibility_check"+iformObj.getValue("NG_MSB_CIC_NO")+"~"+iformObj.getValue("MSB_SEARCH_BLACKLIST_STATUS").toString()+"~"+iformObj.getValue("MSB_SEARCH_EXPIRY_DATE"));
		String expdate=iformObj.getValue("MSB_SEARCH_EXPIRY_DATE").toString();
		if(expdate==null || "".equalsIgnoreCase(expdate))
		expdate="novalue";
		String result=callProcedurewithreturn(iformObj, "NG_POS_Eligibility_check", iformObj.getValue("NG_MSB_CIC_NO")+"~"+iformObj.getValue("MSB_SEARCH_BLACKLIST_STATUS").toString()+"~"+expdate);
		logger.info("result:"+result);*/
		}
		String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
		String query1="select sum(cast(isnull(a.THROUGHPUT,0) as numeric)+cast(a.THROUGHPUT1 as numeric)+cast(isnull(a.THROUGHPUT2,0) as numeric))/12 from ( select TOP 12  isnull(convert(date,'01/'+a.cortex_month,103),convert(date,'01-'+transaction_month,103))transaction_month , sum(cast(isnull(a.THROUGHPUT,0) as numeric)) THROUGHPUT,sum(cast(isnull(b.THROUGHPUT,0) as numeric)) THROUGHPUT1 ,sum(cast(isnull(C.THROUGHPUT,0) as numeric)) THROUGHPUT2 from (select * from NG_MSB_SEARCH_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES where cic_no=cast('"+cic_number+"' AS NUMERIC) and cortex_month<>'' and cortex_month<>'0') a  full outer join (select * from NG_MSB_SEARCH_NONPOS_POS_DETAILS where cic='"+cic_number+"' and transaction_month<>'') b on cast(isnull(a.cic_no,0) as numeric)=cast(isnull(b.cic,0) as numeric) and convert(date,'01/'+a.cortex_month,103)=convert(date,'01-'+transaction_month,103) full outer join (select * from NG_MSB_SEARCH_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES where cic_no=cast('"+old_cic_number+"' AS NUMERIC) and cortex_month<>'' and cortex_month<>'0') c on  convert(date,'01/'+a.cortex_month,103)=convert(date,'01/'+c.CORTEX_MONTH,103) group by convert(date,'01/'+a.cortex_month,103),convert(date,'01-'+transaction_month,103),convert(date,'01/'+C.cortex_month,103) order by isnull(convert(date,'01/'+a.cortex_month,103),convert(date,'01-'+transaction_month,103)) desc, convert(date,'01/'+C.cortex_month,103) DESC ) as a ";
		String query2="select sum(cast(isnull(a.THROUGHPUT,0) as numeric)+cast(a.THROUGHPUT1 as numeric)+cast(isnull(a.THROUGHPUT2,0) as numeric))/4 from ( select TOP   4  isnull(convert(date,'01/'+a.cortex_month,103),convert(date,'01-'+transaction_month,103))transaction_month , sum(cast(isnull(a.THROUGHPUT,0) as numeric)) THROUGHPUT,sum(cast(isnull(b.THROUGHPUT,0) as numeric)) THROUGHPUT1 ,sum(cast(isnull(C.THROUGHPUT,0) as numeric)) THROUGHPUT2 from (select * from NG_MSB_SEARCH_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES where cic_no=cast('"+cic_number+"' AS NUMERIC) and cortex_month<>'' and cortex_month<>'0') a  full outer join (select * from NG_MSB_SEARCH_NONPOS_POS_DETAILS where cic='"+cic_number+"' and transaction_month<>'') b on cast(isnull(a.cic_no,0) as numeric)=cast(isnull(b.cic,0) as numeric) and convert(date,'01/'+a.cortex_month,103)=convert(date,'01-'+transaction_month,103) full outer join (select * from NG_MSB_SEARCH_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES where cic_no=cast('"+old_cic_number+"' AS NUMERIC) and cortex_month<>'' and cortex_month<>'0') c on  convert(date,'01/'+a.cortex_month,103)=convert(date,'01/'+c.CORTEX_MONTH,103) group by convert(date,'01/'+a.cortex_month,103),convert(date,'01-'+transaction_month,103),convert(date,'01/'+C.cortex_month,103) order by isnull(convert(date,'01/'+a.cortex_month,103),convert(date,'01-'+transaction_month,103)) desc, convert(date,'01/'+C.cortex_month,103) DESC ) as a ";
		double final_average_balance=0;
		try
		{
			List<List<String>> avg_throughput_last_12_month = iformObj.getDataFromDB(query1);
			List<List<String>> avg_throughput_last_4_month = iformObj.getDataFromDB(query2);
			logger.info("Query to fetch 12 month trougput is "+query1+" and its result is "+avg_throughput_last_12_month);
			logger.info("Query to fetch 4 month trougput is "+query2+" and its result is "+avg_throughput_last_4_month);
			if(avg_throughput_last_12_month.size()>0  && avg_throughput_last_4_month.size()>0)
			{
				if(avg_throughput_last_12_month.get(0).size()>0 && avg_throughput_last_4_month.get(0).size()>0 )
				{
					final_average_balance=Math.min(Double.parseDouble(avg_throughput_last_12_month.get(0).get(0)),Double.parseDouble(avg_throughput_last_4_month.get(0).get(0)));
				}
				
			}
		}
		catch(Exception e)
		{
			logger.info("Exception occurred : msbEligibilityCheckButtonClicked in calculating final_average_balance and exception is "+e);
		}
		iformObj.setValue("LAST_TWELVE_AVERAGE_BALANCE", String.format("%.2f",final_average_balance));
		/*
		logger.info("Query to insert LAST_TWELVE_AVERAGE_BALANCE is "+query);
		try
		{
			List<List<String>> avg_throughput_last_12_month = iformObj.getDataFromDB(query);
			if(avg_throughput_last_12_month.size()>0)
			{
				iformObj.setValue("LAST_TWELVE_AVERAGE_BALANCE", avg_throughput_last_12_month.get(0).get(0));
			}
		}catch(Exception e)
		{
			logger.info("Exception occurred: msbEligibilityCheckButtonClicked in db operation with query "+query+" and stack trace is "+e);
		}
		*/
		return eligibility.split("~")[1].replace("]]", "").replace("[", "").replace("]", "");
		}
	
	private String checkEligibility(IFormReference iformObj, String stringData)
	{
	logger.info("NG_POS_Eligibility_check"+iformObj.getValue("NG_MSB_CIC_NO")+"~"+iformObj.getValue("MSB_SEARCH_BLACKLIST_STATUS").toString()+"~"+iformObj.getValue("MSB_SEARCH_EXPIRY_DATE"));
	String expdate=iformObj.getValue("MSB_SEARCH_EXPIRY_DATE").toString();
	if(expdate==null || "".equalsIgnoreCase(expdate))
	expdate="novalue";
	String result=callProcedurewithreturn(iformObj, "NG_POS_Eligibility_check", iformObj.getValue("NG_MSB_CIC_NO")+"~"+iformObj.getValue("MSB_SEARCH_BLACKLIST_STATUS").toString()+"~"+expdate);
	logger.info("result:"+result);
	return result.replace("[[", "").replace("]]", "").replace("[", "").replace("]", "");
	}

	private String createNewApplication(IFormReference iformObj, String stringData) {
		logger.info("Customer blacklisted status is"+customer_blacklisted+" and its description is "+customer_blacklisted_descr);
		
		if(customer_blacklisted==false)
		{
			logger.info("Not blacklisted hence creating new workitem");
			String processInstanceID = "";
			POSCommon obj = new POSCommon(iformObj);
			processInstanceID = obj.createWorkitem(iformObj, stringData);
			fillPOSdataFromSearchScreen(iformObj,processInstanceID);
			fillStatementAnalysisDetails(iformObj,processInstanceID);
			fillAccountMovementDetails(iformObj,processInstanceID);
			fillAccountMovementDetails_OldCIC(iformObj,processInstanceID);
			logger.info("Process instance id is "+processInstanceID);
			fillHeaderDetails(iformObj,stringData,processInstanceID);
			return processInstanceID;
		}
		return "Blacklist#"+customer_blacklisted_descr;
	}

	private String fillCompanyDataSearchScreen(IFormReference iformObj, String stringdata,String cic_number,String responseXML,String callName)
	{
		
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			responseXML=responseXML.replace(temp,"");
		
		XMLParser parser = new XMLParser(responseXML);
		JSONObject jsonobj=setResponseData(iformObj, callName, responseXML);
		
		logger.info("For search screen jsonobject is "+jsonobj);
		
		for(Iterator iterator = jsonobj.keySet().iterator(); iterator.hasNext();) 
		{
		    String key = (String) iterator.next();
		    
		    	logger.info("Values set for"+key+" are "+jsonobj.get(key).toString());
		    	if(key.equalsIgnoreCase("MSB_SEARCH_ENTITY_TYPE_JURI_STATUS"))
		    	{
		    		String Evidence_Code=parser.getValueOf("EntityTypeCd");
		    		String Evidence_Code_desc=parser.getValueOf("EntityTypeDesc");
		    		logger.info("Entity Type Setting:::"+Evidence_Code+" and "+Evidence_Code_desc);
		    		setControlValue(iformObj, key, Evidence_Code+"-"+Evidence_Code_desc);
					
		    	}
		    	else if(key.equalsIgnoreCase("MSB_SEARCH_SECTOR"))
		    	{
		    		String Sector_Code=parser.getValueOf("SectorCd");
		    		String Sector_Code_desc=parser.getValueOf("SectorDesc");
		    		logger.info("sector Setting:::"+Sector_Code+" and "+Sector_Code_desc);
		    		setControlValue(iformObj, key, Sector_Code+"-"+Sector_Code_desc);
		    		
		    	}
		    	else if(key.equalsIgnoreCase("MSB_SEARCH_SUBSECTOR"))
		    	{
		    		String Sub_Sector_Code=parser.getValueOf("SubSectorCd");
		    		String Sub_Sector_Code_desc=parser.getValueOf("SubSectorDesc");
		    		logger.info("sub sector Setting:::"+Sub_Sector_Code+" and "+Sub_Sector_Code_desc);
		    		setControlValue(iformObj, key, Sub_Sector_Code+"-"+Sub_Sector_Code_desc);
		    		
		    	}
		    	else if(key.equalsIgnoreCase("MSB_SEARCH_COUNTRY_OF_INCORPORATION"))
		    	{
		    		String country_code=parser.getValueOf("IncorporationCtryCd");
		    		String country_desc=parser.getValueOf("RegistrationCtry");
		    		logger.info("sub sector Setting:::"+country_code+" and "+country_desc);
		    		setControlValue(iformObj, key, country_code+"-"+country_desc);
		    		
		    	}
		    	else if(key.equalsIgnoreCase("MSB_SEARCH_COUNTRY"))
		    	{
		    		String country_code=parser.getValueOf("CtryCode");
		    		String country_desc=parser.getValueOf("CtryName");
		    		logger.info("sub sector Setting:::"+country_code+" and "+country_desc);
		    		setControlValue(iformObj, key, country_code+"-"+country_desc);
		    		
		    	}
		    	else if(key.equalsIgnoreCase("MSB_SEARCH_CITY"))
		    	{
		    		String city_code=parser.getValueOf("CityCode");
		    		String city_desc=parser.getValueOf("CityName");
		    		logger.info("sub sector Setting:::"+city_code+" and "+city_desc);
		    		setControlValue(iformObj, key, city_code+"-"+city_desc);
		    	}
		    	else if(key.equalsIgnoreCase("MSB_SEARCH_INDUSTRY"))
		    	{
		    		String city_code=parser.getValueOf("ActivityCd");
		    		String city_desc=parser.getValueOf("ActivityDesc");
		    		logger.info("sub sector Setting:::"+city_code+" and "+city_desc);
		    		setControlValue(iformObj, key, city_code+"-"+city_desc);
		    		
		    	}
		    	else if(key.equalsIgnoreCase("MSB_SEARCH_CENTRAL_BANK_SECTOR_CODE"))
		    	{
		    		String city_code=parser.getValueOf("SAMASectorCd");
		    		String city_desc=parser.getValueOf("SamaSectorDesc");
		    		logger.info("sub sector Setting:::"+city_code+" and "+city_desc);
		    		setControlValue(iformObj, key, city_code+"-"+city_desc);
		    	}
		    	else if(key.equalsIgnoreCase("MSB_SEARCH_PREFERRED_LANGUAGE"))
		    	{
		    		String language=parser.getValueOf("PreferredLanguage");
		    		logger.info("Value of preferred language in response is"+language+"sdf");
		    		//setControlValue(iformObj, key,"Language");
		    		if(language.contains("1"))
			    		{
			    			setControlValue(iformObj, key,language+"-Arabic");
			    			logger.info("Arabic case");
			    		}
		    		else if(language.contains("2"))
		    			{
		    				setControlValue(iformObj, key,language+"-English");
		    				logger.info("Arabic case");
		    			}
		    			logger.info("Value set in language successfully ");
		    		
		    	}
		    	else
		    	setControlValue(iformObj, key, jsonobj.get(key).toString());
		}
		
		try {
		JSONArray contact_grid_obj_array = new JSONArray();
		JSONObject contact_grid_obj;
	
		String contact_grid_tag=GetXML.getProp().getProperty(callName+"_Contact_Grid_Tags");
		logger.info("Contact grid tags are "+contact_grid_tag);
		String[] contact_grid_tag_split=contact_grid_tag.split(",");
		logger.info("Contact grid id on form is "+contact_grid_tag_split[0]);
		iformObj.clearTable(contact_grid_tag_split[0]);
		
		for(int j=1;j<contact_grid_tag_split.length;j++)
		{
			String temp=contact_grid_tag_split[j];
			contact_grid_obj=null;
			String[] temp_split=temp.split("~");
			logger.info("Contact info temp_split zero is "+temp_split[0]);
			logger.info("Contact grid corresponding tag values are "+parser.getValueOf(temp_split[0]));
			XMLParser internal_parser=new XMLParser(parser.getValueOf(temp_split[0]));
			if(parser.getValueOf(temp_split[0]).length()>0)
			{
				contact_grid_obj=new JSONObject();
				contact_grid_obj.put("Contact Type",temp_split[0]);
				
				for(int i=1;i<temp_split.length;i++)
				{
					String[] xyz=temp_split[i].split("#");
					contact_grid_obj.put(xyz[0],internal_parser.getValueOf(xyz[1]));
				}
				logger.info("Contact grid object is "+contact_grid_obj);				
			}
			if(contact_grid_obj!=null)
				contact_grid_obj_array.add(contact_grid_obj);
		}
		logger.info("Contact grid array is  "+contact_grid_obj_array);	
		iformObj.addDataToGrid(contact_grid_tag_split[0], contact_grid_obj_array);
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: Error in fetching contact details and error is "+e);		
		}
		/*
		JSONArray evidence_code_obj_array = new JSONArray();
		JSONObject evidence_code_obj;
		String evidence_code_tags=GetXML.getProp().getProperty(callName+"_EvidenceCodeTags");
		String []evidence_code_tags_arry=evidence_code_tags.split(",");
		iformObj.clearTable("MSB_SEARCH_EVIDENCE_CODE_GRID");
		logger.info("Evidence code itags array is "+evidence_code_tags_arry);
		
		for(String temp:evidence_code_tags_arry)
		{
			String tagValue_with_code =temp;
			String []tagValue_with_code_array=tagValue_with_code.split("#");
			
			String tagValue=parser.getValueOf(tagValue_with_code_array[0]);
			String evidence_code=tagValue_with_code_array[1];
			if(tagValue!=null && tagValue!="")
			{
				String query="SELECT CODE_DESCRIPTION FROM NG_MAST_ALLOWED_EVIDENCE_CODE WHERE ISACTIVE ='Y' AND CODE='"+evidence_code+"'  ";
				List<List<String>> description_list = iformObj.getDataFromDB(query);
				logger.info("Query to select evidence code is "+query);
				if(description_list.size()>0)
				{
					String desc=description_list.get(0).get(0);
					evidence_code_obj = new JSONObject();
					evidence_code_obj.put("Evidence Code",evidence_code);
					evidence_code_obj.put("Description",desc);
					evidence_code_obj.put("Status","Active");
					logger.info("Evidence code object is "+evidence_code_obj);
					evidence_code_obj_array.add(evidence_code_obj);
				}
			}
		}
		
		logger.info("Evidence code Array is "+evidence_code_obj_array);
		iformObj.addDataToGrid("MSB_SEARCH_EVIDENCE_CODE_GRID", evidence_code_obj_array);
		*/
		fillRelatedPartyDetails(iformObj,responseXML,callName);
		//fillRelatedPartyDetailsDetailed(iformObj,responseXML);
		
		JSONObject return_obj = setResponseDataGrid(iformObj,callName,responseXML);
		for (Iterator iterator = return_obj.keySet().iterator(); iterator.hasNext();) 
		{
			String key = (String) iterator.next();
			iformObj.clearTable(key);
			iformObj.addDataToGrid(key, (JSONArray) return_obj.get(key));
		}
		
		/*
		//JSONArray related_party_obj_array = new JSONArray();
		//JSONObject related_party_obj;
		//String related_party_tags=GetXML.getProp().getProperty(callName+"_RelatedPartyTags");
		//String []related_party_tags_arry=related_party_tags.split(",");
		//JSONObject related_party_obj=setResponseDataGrid(iformObj, callName, responseXML);
		//logger.info("Related Party Grid Object is ::  "+related_party_obj);
		
		JSONObject return_obj=setResponseDataGrid(iformObj, callName, responseXML);
		List<String> cleared_list=new ArrayList<String>();
		for(Iterator iterator = return_obj.keySet().iterator(); iterator.hasNext();) {
		    String key = (String) iterator.next();
		    logger.info("Key for CRS table is "+key+"and value is"+ return_obj.get(key));
		    if(!cleared_list.contains(key))
		    {		    	
		    	iformObj.clearTable(key);
		    	cleared_list.add(key);
		    }
		   
		    /*
		    if(key.equalsIgnoreCase("MSB_SEARCH_EVIDENCE_CODE_GRID"))
		    {
				boolean allowed_evidence_code_found=false;
				JSONArray evidence_code_arr= (JSONArray) return_obj.get(key);
		    	Iterator evidence_code_iterator = evidence_code_arr.iterator();
		    	String query="SELECT CODE FROM NG_MAST_ALLOWED_EVIDENCE_CODE WHERE ISACTIVE='Y'  ";
				List<List<String>> allowed_evidence_codes = iformObj.getDataFromDB(query);
				
				logger.info("Allowed evidence codes are "+allowed_evidence_codes);
				try 
				{
				 
					outerloop: while (evidence_code_iterator.hasNext()) 
					{
						JSONObject evidence_code_obj = (JSONObject) evidence_code_iterator.next();
						String evidence_code=(String) evidence_code_obj.get("Evidence Code");
						
						logger.info("Evidence code is"+evidence_code);
						
						 for(List<String> temp: allowed_evidence_codes)
							{
							 	logger.info("Blacklist code in master table is"+temp.get(0));
								if(temp.get(0).equalsIgnoreCase(evidence_code))
								{
									
									//customer_blacklisted=true;
									//customer_blacklisted_descr=customer_blacklisted_descr +"Customer is Blacklisted with Evidence Code "+temp.get(0)+"~";
									//logger.info("Customer is blacklisted with description "+customer_blacklisted_descr);
									
									allowed_evidence_code_found=true;
									break outerloop;
								}
							}
					}
					logger.info("Allowed evidence code flag value is "+allowed_evidence_code_found);
					if(allowed_evidence_code_found==false)
					{
						customer_blacklisted=true;
						customer_blacklisted_descr=customer_blacklisted_descr +"Customer is Blacklisted because required Evidence Code not found"+"~";
						logger.info("Customer is blacklisted with description "+customer_blacklisted_descr);
					}
				
				}
				catch(Exception e)
				{
					logger.info("Exception occurred: fillCompanyDataSearchScreen: Database Query "+query+" and stack trace is"+e);
				}
				
				//if(customer_blacklisted==true)
					//setControlValue(iformObj, "MSB_SEARCH_BLACKLIST_STATUS", "Blacklisted");
				//else
					//setControlValue(iformObj, "MSB_SEARCH_BLACKLIST_STATUS", "Not Blacklisted");
				
				iformObj.addDataToGrid( key, (JSONArray) return_obj.get(key));
				logger.info("Customer blacklisted status is"+customer_blacklisted+" and its description is "+customer_blacklisted_descr);
		    }
		 //   else
		   // {
		    	 iformObj.addDataToGrid( key, (JSONArray) return_obj.get(key));
		    //}
		   
		    	
		}
		*/
		
		
		/*
		String table_name="NG_MSB_SEARCH_COMPANY_DATA";
		String delete_query="DELETE FROM "+table_name+" WHERE CIC_NO='"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		
		logger.info("Delete Query is"+delete_query);
		String company_data_id="MSB_SEARCH_CIC,MSB_SEARCH_USER,MSB_SEARCH_CIC_STATUS,MSB_SEARCH_REG_AMEND_DATE,MSB_SEARCH_CLOSURE_DATE,MSB_SEARCH_BLACKLIST_STATUS,MSB_SEARCH_CR_NO,MSB_SEARCH_NAME_OF_ENTITY_EN,MSB_SEARCH_NAME_OF_ENTITY_AR,MSB_SEARCH_ENTITY_TYPE_JURI_STATUS,MSB_SEARCH_COUNTRY_OF_INCORPORATION,MSB_SEARCH_RESIDENCE,MSB_SEARCH_CENTRAL_BANK_SECTOR_CODE,MSB_SEARCH_DATE_OF_ESTABLISHMENT,MSB_SEARCH_EMPLOYEES_NO,MSB_SEARCH_SECTOR,MSB_SEARCH_SUB_SECTOR,MSB_SEARCH_INDUSTRY,MSB_SEARCH_REGISTRATION_TYPE,MSB_SEARCH_NUMBER,MSB_SEARCH_COUNTRY,MSB_SEARCH_REGION,MSB_SEARCH_CITY,MSB_SEARCH_ISSUE_DATE,MSB_SEARCH_EXPIRY_DATE,MSB_SEARCH_UNDER_RENEWAL,MSB_SEARCH_MCI_CONTRACT_NUMBER,MSB_SEARCH_MCI_CONTRACT_DATE,MSB_SEARCH_BRANCH_OFFICER,MSB_SEARCH_AUTHORIZED_ACC_DTL,MSB_SEARCH_COUNTRY_1,MSB_SEARCH_DOCUMENT_TYPE,MSB_SEARCH_DOCUMENT_NUMBER,MSB_SEARCH_DOC_ISSUE_DATE,MSB_SEARCH_DOC_EXPIRY_DATE,MSB_SEARCH_PREFERRED_LANGUAGE,MSB_SEARCH_HEAD_BRANCH,MSB_SEARCH_ACCOUNT_CURRENCY,MSB_SEARCH_BIC_CODE,MSB_SEARCH_SUP,MSB_SEARCH_NFA_CODE";
		List<String> comp_data_id_list=Arrays.asList(company_data_id.split(","));
		
		logger.info("comp_data_id_list is"+comp_data_id_list);

		
		List<String> comp_data_value_list=new ArrayList<>();
		Iterator<String> comp_data_iterator=comp_data_id_list.iterator();
		while(comp_data_iterator.hasNext())
		{	
			comp_data_value_list.add((String) iformObj.getValue(comp_data_iterator.next()));
		};
		
		logger.info("comp_data_value_list is"+comp_data_value_list);
		String query="INSERT INTO ";
		String column_names="CIC_NO,USER_NAME,CIC_STATUS,REGISTRATION_AMEND_DATE,CLOSURE_DATE,BLACKLIST_STATUS,CR_NUMBER,NAME_OF_ENITITY_ENG,NAME_OF_ENTITY_ARB,ENTITY_TYPE_JUR_STATUS,COUNTRY_OF_INCORP,RESIDENCE,CENTRAL_BANK_SECTOR_CODE,DATE_OF_ESTABLISHMENT,EMPLOYEES_NO,SECTOR,SUBSECTOR,INDUSTRY,REGISTRATION_TYPE,COMP_DATA_NUMBER,COUNTRY,REGION,CITY,ISSUE_DATE,EXPIRY_DATE,UNDER_RENEWAL,MCI_CONTRACT_NO,MCI_CONTRACT_DATE,BRANCH_OFFICER,AUTHORIZED_TO_ACCESS_DETAILS,COUNTRY_1,DOCUMENT_TYPE,DOCUMENT_NUMBER,DOCUMENT_ISSUE_DATE,DOCUMENT_EXPIRY_DATE,PREFERRED_LANGUAGE,HEAD_BRANCH,ACCOUNT_CURRENCY,BIC_CODE,SUP,NFA_CODE,ENTRY_DATE_TIME";
		logger.info("Column names are"+column_names);
		query=query+table_name+"("+column_names+") ";
		String result="VALUES (";
		
		for(int i=0;i<comp_data_value_list.size();i++)
		{
			result=result+"'"+comp_data_value_list.get(i)+"',";
		}
		result=result+"'"+date+"'";
		//result = result.substring(0, result.length() - 1);
		query=query+result+")";
		logger.info("Query for saving company data is"+query);
	    iformObj.saveDataInDB(query);
	    */
		
		/*
		String table_name="NG_MSB_SEARCH_COMPANY_DATA";
		String column_names="CIC_NO,USER_NAME,CIC_STATUS,REGISTRATION_AMEND_DATE,CLOSURE_DATE,BLACKLIST_STATUS,CR_NUMBER,NAME_OF_ENITITY_ENG,NAME_OF_ENTITY_ARB,ENTITY_TYPE_JUR_STATUS,COUNTRY_OF_INCORP,RESIDENCE,CENTRAL_BANK_SECTOR_CODE,DATE_OF_ESTABLISHMENT,EMPLOYEES_NO,SECTOR,SUBSECTOR,INDUSTRY,REGISTRATION_TYPE,COMP_DATA_NUMBER,COUNTRY,REGION,CITY,ISSUE_DATE,EXPIRY_DATE,UNDER_RENEWAL,MCI_CONTRACT_NO,MCI_CONTRACT_DATE,BRANCH_OFFICER,AUTHORIZED_TO_ACCESS_DETAILS,COUNTRY_1,DOCUMENT_TYPE,DOCUMENT_NUMBER,DOCUMENT_ISSUE_DATE,DOCUMENT_EXPIRY_DATE,PREFERRED_LANGUAGE,HEAD_BRANCH,ACCOUNT_CURRENCY,BIC_CODE,SUP,NFA_CODE,ENTRY_DATE_TIME";
		String company_data_id="MSB_SEARCH_CIC,MSB_SEARCH_USER,MSB_SEARCH_CIC_STATUS,MSB_SEARCH_REG_AMEND_DATE,MSB_SEARCH_CLOSURE_DATE,MSB_SEARCH_BLACKLIST_STATUS,MSB_SEARCH_CR_NO,MSB_SEARCH_NAME_OF_ENTITY_EN,MSB_SEARCH_NAME_OF_ENTITY_AR,MSB_SEARCH_ENTITY_TYPE_JURI_STATUS,MSB_SEARCH_COUNTRY_OF_INCORPORATION,MSB_SEARCH_RESIDENCE,MSB_SEARCH_CENTRAL_BANK_SECTOR_CODE,MSB_SEARCH_DATE_OF_ESTABLISHMENT,MSB_SEARCH_EMPLOYEES_NO,MSB_SEARCH_SECTOR,MSB_SEARCH_SUBSECTOR,MSB_SEARCH_INDUSTRY,MSB_SEARCH_REGISTRATION_TYPE,MSB_SEARCH_NUMBER,MSB_SEARCH_COUNTRY,MSB_SEARCH_REGION,MSB_SEARCH_CITY,MSB_SEARCH_ISSUE_DATE,MSB_SEARCH_EXPIRY_DATE,MSB_SEARCH_UNDER_RENEWAL,MSB_SEARCH_MCI_CONTRACT_NUMBER,MSB_SEARCH_MCI_CONTRACT_DATE,MSB_SEARCH_BRANCH_OFFICER,MSB_SEARCH_AUTHORIZED_ACC_DTL,MSB_SEARCH_COUNTRY_1,MSB_SEARCH_DOCUMENT_TYPE,MSB_SEARCH_DOCUMENT_NUMBER,MSB_SEARCH_DOC_ISSUE_DATE,MSB_SEARCH_DOC_EXPIRY_DATE,MSB_SEARCH_PREFERRED_LANGUAGE,MSB_SEARCH_HEAD_BRANCH,MSB_SEARCH_ACCOUNT_CURRENCY,MSB_SEARCH_BIC_CODE,MSB_SEARCH_SUP,MSB_SEARCH_NFA_CODE";
		setDatainDBfromSearchScreen(iformObj,"NG_MSB_CIC_NO",table_name,company_data_id,column_names);
		*/
		//Adding Sajwa code
		String table_name="NG_MSB_SEARCH_COMPANY_DATA";
		String column_names="CIC_NO,USER_NAME,CIC_STATUS,REGISTRATION_AMEND_DATE,CLOSURE_DATE,BLACKLIST_STATUS,CR_NUMBER,NAME_OF_ENITITY_ENG,NAME_OF_ENTITY_ARB,ENTITY_TYPE_JUR_STATUS,COUNTRY_OF_INCORP,RESIDENCE,CENTRAL_BANK_SECTOR_CODE,DATE_OF_ESTABLISHMENT,EMPLOYEES_NO,SECTOR,SUBSECTOR,INDUSTRY,REGISTRATION_TYPE,COMP_DATA_NUMBER,COUNTRY,REGION,CITY,ISSUE_DATE,EXPIRY_DATE,UNDER_RENEWAL,MCI_CONTRACT_NO,MCI_CONTRACT_DATE,BRANCH_OFFICER,AUTHORIZED_TO_ACCESS_DETAILS,COUNTRY_1,DOCUMENT_TYPE,DOCUMENT_NUMBER,DOCUMENT_ISSUE_DATE,DOCUMENT_EXPIRY_DATE,PREFERRED_LANGUAGE,HEAD_BRANCH,ACCOUNT_CURRENCY,BIC_CODE,SUP,NFA_CODE,AMENDMENT_DATE,GOVERNMNT_FLG,ANTI_MONEY_LAUN_FLG,FIRCO_UNDER_INV_FLG,FIRCO_BLKLST_FLG,OTHR_BANK_BLKLST_FLG,ENTITY_TYPE_CD,ENTITY_TYPE_DESC,INCORP_CTRY_CD,RESIDENCE_FLG,SECTOR_CD,SECTOR_DESC,SAMA_SECTOR_DESC,SUB_SECTOR_CD,SUB_SECTOR_DESC,ACTIVITY_CD,ACTIVITY_DESC,ISSUE_DATE_CALENDER,REGIS_TYPE_ISSUE_DATE,ISSUE_TIMESTAMP,EXPIRY_DATE_CALENDER,REGIS_TYPE_EXPIRY_DATE,EXPIRY_TIMESTAMP,REGIS_TYPE_CTRYCODE,REGIS_TYPE_CITYCODE,REGIS_TYPE_CITYNAME,USER_AUTH_FLG,CTRY_CD,SUPERVISION_CD,SUPERVISION_DESC,TIER3_FLG,TIER2_FLG,SME_NON_BORROW_FLG,SE_BORROW_FLG,ME_BORROW_FLG,MI_BORROW_FLG,EMAIL,WEBSITE,SAMA_SECTOR_CD,UNN_DESC,CTRY_NAME,INCORP_CTRY,JOIN_DATE,REGISTRATION_CTRY,SESSION_LANG,UNN_NO,ENTRY_DATE_TIME";
		String company_data_id="MSB_SEARCH_CIC,MSB_SEARCH_USER,MSB_SEARCH_CIC_STATUS,MSB_SEARCH_REG_AMEND_DATE,MSB_SEARCH_CLOSURE_DATE,MSB_SEARCH_BLACKLIST_STATUS,MSB_SEARCH_CR_NO,MSB_SEARCH_NAME_OF_ENTITY_EN,MSB_SEARCH_NAME_OF_ENTITY_AR,MSB_SEARCH_ENTITY_TYPE_JURI_STATUS,MSB_SEARCH_COUNTRY_OF_INCORPORATION,MSB_SEARCH_RESIDENCE,MSB_SEARCH_CENTRAL_BANK_SECTOR_CODE,MSB_SEARCH_DATE_OF_ESTABLISHMENT,MSB_SEARCH_EMPLOYEES_NO,MSB_SEARCH_SECTOR,MSB_SEARCH_SUBSECTOR,MSB_SEARCH_INDUSTRY,MSB_SEARCH_REGISTRATION_TYPE,MSB_SEARCH_NUMBER,MSB_SEARCH_COUNTRY,MSB_SEARCH_REGION,MSB_SEARCH_CITY,MSB_SEARCH_ISSUE_DATE,MSB_SEARCH_EXPIRY_DATE,MSB_SEARCH_UNDER_RENEWAL,MSB_SEARCH_MCI_CONTRACT_NUMBER,MSB_SEARCH_MCI_CONTRACT_DATE,MSB_SEARCH_BRANCH_OFFICER,MSB_SEARCH_AUTHORIZED_ACC_DTL,MSB_SEARCH_COUNTRY_1,MSB_SEARCH_DOCUMENT_TYPE,MSB_SEARCH_DOCUMENT_NUMBER,MSB_SEARCH_DOC_ISSUE_DATE,MSB_SEARCH_DOC_EXPIRY_DATE,MSB_SEARCH_PREFERRED_LANGUAGE,MSB_SEARCH_HEAD_BRANCH,MSB_SEARCH_ACCOUNT_CURRENCY,MSB_SEARCH_BIC_CODE,MSB_SEARCH_SUP,MSB_SEARCH_NFA_CODE,MSB_SEARCH_AMENDMENT_DATE,MSB_SEARCH_GOVERNMNT_FLG,MSB_SEARCH_ANTI_MONEY_LAUN_FLG,MSB_SEARCH_FIRCO_UNDER_INV_FLG,MSB_SEARCH_FIRCO_BLKLST_FLG,MSB_SEARCH_OTHR_BANK_BLKLST_FLG,MSB_SEARCH_ENTITY_TYPE_CD,MSB_SEARCH_ENTITY_TYPE_DESC,MSB_SEARCH_INCORP_CTRY_CD,MSB_SEARCH_RESIDENCE_FLG,MSB_SEARCH_SECTOR_CD,MSB_SEARCH_SECTOR_DESC,MSB_SEARCH_SAMA_SECTOR_DESC,MSB_SEARCH_SUB_SECTOR_CD,MSB_SEARCH_SUB_SECTOR_DESC,MSB_SEARCH_ACTIVITY_CD,MSB_SEARCH_ACTIVITY_DESC,MSB_SEARCH_ISSUE_DATE_CALENDER,MSB_SEARCH_REGIS_TYPE_ISSUE_DATE,MSB_SEARCH_ISSUE_TIMESTAMP,MSB_SEARCH_EXPIRY_DATE_CALENDER,MSB_SEARCH_REGIS_TYPE_EXPIRY_DATE,MSB_SEARCH_EXPIRY_TIMESTAMP,MSB_SEARCH_REGIS_TYPE_CTRYCODE,MSB_SEARCH_REGIS_TYPE_CITYCODE,MSB_SEARCH_REGIS_TYPE_CITYNAME,MSB_SEARCH_USER_AUTH_FLG,MSB_SEARCH_CTRY_CD,MSB_SEARCH_SUPERVISION_CD,MSB_SEARCH_SUPERVISION_DESC,MSB_SEARCH_TIER3_FLG,MSB_SEARCH_TIER2_FLG,MSB_SEARCH_SME_NON_BORROW_FLG,MSB_SEARCH_SE_BORROW_FLG,MSB_SEARCH_ME_BORROW_FLG,MSB_SEARCH_MI_BORROW_FLG,MSB_SEARCH_EMAIL,MSB_SEARCH_WEBSITE,MSB_SEARCH_SAMA_SECTOR_CD,MSB_SEARCH_UNN_DESC,MSB_SEARCH_CTRY_NAME,MSB_SEARCH_INCORP_CTRY,MSB_SEARCH_JOIN_DATE,MSB_SEARCH_REGISTRATION_CTRY,SESSION_LANG,MSB_SEARCH_UNN_NO";
		setDatainDBfromSearchScreen(iformObj,"NG_MSB_CIC_NO",table_name,company_data_id,column_names);
		
		
		
		//sajwa code end
		String grid_id="MSB_SEARCH_KEY_CONTACT_GRID";
		table_name="NG_MSB_SEARCH_KEY_CONTACT_GRID";
		column_names="CONTACT_TYPE,INTERNATIONAL_PREFIX,AREA_CODE,NUMBER,EXTENSION,ENTRY_DATE_TIME";
		String field_list="Contact Type,International Prefix,Area Code,Number,Extension";
		setDatainDBfromSearchScreenGrid(iformObj,"NG_MSB_CIC_NO",grid_id,table_name,column_names,field_list);
		
		grid_id="NG_MSB_SEARCH_ADDRESS_LIST_GRID";
		table_name="NG_MSB_SEARCH_ADDRESS_LIST_GRID";
		column_names="ADDR_TYPE,ADDR_TYPE_DESC,ORIGINAL_NO,STREET_NAME,QUARTER_NAME,UNIT_NO,ZIP_CODE,CITY_CODE,ADDITIONAL_NO,NEW_ADDR_DEF_FLG,REGION_CD,REGION_DESC,CTRY_DESC,CITY_NAME,ENTRY_DATE_TIME";
		field_list="Address Type,Address Type Description,Original Number,Street Name,Quarter Name,Unit Number,ZIP Code,City Code,Additional Number,New Add. Default Flg,Region Code,Region Description,Country Description,City Name";
		setDatainDBfromSearchScreenGrid(iformObj,"NG_MSB_CIC_NO",grid_id,table_name,column_names,field_list);

		
		grid_id="MSB_SEARCH_SHAREHOLDER_GRID";
		table_name="NG_MSB_SEARCH_SHAREHOLDERS_DETAILS";
		column_names="CompanyCIC,RoleCd,RoleDesc,Percent_VAL,GroupRoleCd,GroupRoleDesc,ENTRY_DATE_TIME";
		field_list="Company CIC,Role Code,Role Description,Percent,Group Role Code,Group Role Description";
		setDatainDBfromSearchScreenGrid(iformObj,"NG_MSB_CIC_NO",grid_id,table_name,column_names,field_list);

		
		/*
		grid_id="MSB_SEARCH_ROLE_GRID";
		table_name="NG_MSB_SEARCH_RELATED_PARTY_ROLES_GRID";
		column_names="CHILD_CIC,ROLE_DESCRIPTION,PERCENTAGE,PARTY_TYPE,NAME_ENG,NAME_AR,GROUP_DESCRIPTION,CR,UNN,CICStatus,RegisterDate,Establishate,entityName,entityNameOther,entityTypeCd,entityTypeDesc,CountryCd,SectorCd,SubSectorCd,SamaSectorDesc,BankSectorDesc,ActivityDesc,SubSectorDesc,RegTypeCd,RegTypeDesc,entityCityName,entityRegionCd,entityCountryCd,entitySAMASectorCd,FirstNameAR,SecondNameAR,FamilyNameAR,FirstNameEN,SecondNameEN,FamilyNameEN,Nationality,BirthDate,Age,MaritalStatus,MaritalStatusDesc,AddressBuildingNumber,AddressUnitNumber,AddressStreetName,AddressRegion,AddressCityCd,AddressCityName,AddressAdditionalNumber,AddressPostalCd,PrefContactNo,MobileNum,PartyStatusDesc,NationalityDesc,PARENT_CIC,ENTRY_DATE_TIME";
		field_list="CIC,Role Description,Percentage,Party Type,Name (Eng),Name (Ar),Group Description,CR Number,UNN Number,CIC Status,Register Date,Establish Date,Entity Name,Entity Name Other,Entity Type Code,Entity Type Description,Country Code,Sector Code,Sub Sector Code,Sama Sector Description,Bank Sector Description,Activity Description,Sub Sector Description,Registration Type Code,Registration Type Description,Entity City Name,Entity Registration Code,Entity Country Code,Entity Sama Sector Code,First Name (Ar),Second Name (Ar),Family Name (Ar),First Name (Eng),Second Name (Eng),Family Name (Eng),Nationality,Birth Date,Age,Marital Status,Martial Status Description,Address Building No,Address Unit No,Address Street No,Address Region,Address City Code,Address City Name,Address Additional Number,Address Postal Code,Pref Contact Number,Mobile Number,Party Status Desciption,Nationality Description,Parent CIC";
		setDatainDBfromSearchScreenGrid(iformObj,"NG_MSB_CIC_NO",grid_id,table_name,column_names,field_list);
		*/
		
		grid_id="MSB_SEARCH_EVIDENCE_CODE_GRID";
		table_name="NG_MSB_SEARCH_EVIDENCE_CODE_GRID";
		column_names="EVIDENCE_CODE,DESCRIPTION,BRANCH_CODE,START_DATE,ENTRY_DATE_TIME";
		field_list="Evidence Code,Description,Branch Code,Start Date";
		setDatainDBfromSearchScreenGrid(iformObj,"NG_MSB_CIC_NO",grid_id,table_name,column_names,field_list);
		
		return "CRS data filled succesfully";
		
		
		
	}
	//isko hata dena bhai
	private String fillRelatedPartyDetailsDetailed(IFormReference iformObj, String responseXML) 
	{
		logger.info("Inside fillRelatedPartyDetailsDetailed");
		String[] callNamesGrid = { "Related_Party_ShareHolderlist", "Related_Party_CompaniesList","Related_Party_IndividualList" }; //For fillRelatedPartyDetailsDetailed
			for (String callNames : callNamesGrid) 
				{
					logger.info("Inside fillRelatedPartyDetailsDetailed and callname is "+callNames);
					setResponseDataGridSearchScreen(iformObj, callNames, responseXML);
				}
			
		return "Success~fillRelatedPartyDetailsDetailed";
		
	}

	private void setDatainDBfromSearchScreen(IFormReference iformObj,String cic_no_id,String table_name,String data_id,String column_names)//String escape_Column
	{
	//	DataEncryption.decrypt("df")
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String cic_number=getControlValue(iformObj, cic_no_id);
	   // String table_name="NG_MSB_SEARCH_COMPANY_DATA";
		String delete_query="DELETE FROM "+table_name+" WHERE CIC_NO='"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		//String new_request_data_id="MSB_SEARCH_CIC,MSB_SEARCH_USER,MSB_SEARCH_CIC_STATUS,MSB_SEARCH_REG_AMEND_DATE,MSB_SEARCH_CLOSURE_DATE,MSB_SEARCH_BLACKLIST_STATUS,MSB_SEARCH_CR_NO,MSB_SEARCH_NAME_OF_ENTITY_EN,MSB_SEARCH_NAME_OF_ENTITY_AR,MSB_SEARCH_ENTITY_TYPE_JURI_STATUS,MSB_SEARCH_COUNTRY_OF_INCORPORATION,MSB_SEARCH_RESIDENCE,MSB_SEARCH_CENTRAL_BANK_SECTOR_CODE,MSB_SEARCH_DATE_OF_ESTABLISHMENT,MSB_SEARCH_EMPLOYEES_NO,MSB_SEARCH_SECTOR,MSB_SEARCH_SUB_SECTOR,MSB_SEARCH_INDUSTRY,MSB_SEARCH_REGISTRATION_TYPE,MSB_SEARCH_NUMBER,MSB_SEARCH_COUNTRY,MSB_SEARCH_REGION,MSB_SEARCH_CITY,MSB_SEARCH_ISSUE_DATE,MSB_SEARCH_EXPIRY_DATE,MSB_SEARCH_UNDER_RENEWAL,MSB_SEARCH_MCI_CONTRACT_NUMBER,MSB_SEARCH_MCI_CONTRACT_DATE,MSB_SEARCH_BRANCH_OFFICER,MSB_SEARCH_AUTHORIZED_ACC_DTL,MSB_SEARCH_COUNTRY_1,MSB_SEARCH_DOCUMENT_TYPE,MSB_SEARCH_DOCUMENT_NUMBER,MSB_SEARCH_DOC_ISSUE_DATE,MSB_SEARCH_DOC_EXPIRY_DATE,MSB_SEARCH_PREFERRED_LANGUAGE,MSB_SEARCH_HEAD_BRANCH,MSB_SEARCH_ACCOUNT_CURRENCY,MSB_SEARCH_BIC_CODE,MSB_SEARCH_SUP,MSB_SEARCH_NFA_CODE";
		List<String> data_id_list=Arrays.asList(data_id.split(","));
		logger.info("For table"+table_name+"data_id_list is "+data_id_list);
		List<String> data_value_list=new ArrayList<>();
		Iterator<String> data_iterator=data_id_list.iterator();
		while(data_iterator.hasNext())
		{	
			data_value_list.add(((String) iformObj.getValue(data_iterator.next())).trim());
		};
		logger.info("Data value list for table"+table_name+"is "+data_value_list);
		String query="INSERT INTO ";
		//String column_names="CIC_NO,USER_NAME,CIC_STATUS,REGISTRATION_AMEND_DATE,CLOSURE_DATE,BLACKLIST_STATUS,CR_NUMBER,NAME_OF_ENITITY_ENG,NAME_OF_ENTITY_ARB,ENTITY_TYPE_JUR_STATUS,COUNTRY_OF_INCORP,RESIDENCE,CENTRAL_BANK_SECTOR_CODE,DATE_OF_ESTABLISHMENT,EMPLOYEES_NO,SECTOR,SUBSECTOR,INDUSTRY,REGISTRATION_TYPE,COMP_DATA_NUMBER,COUNTRY,REGION,CITY,ISSUE_DATE,EXPIRY_DATE,UNDER_RENEWAL,MCI_CONTRACT_NO,MCI_CONTRACT_DATE,BRANCH_OFFICER,AUTHORIZED_TO_ACCESS_DETAILS,COUNTRY_1,DOCUMENT_TYPE,DOCUMENT_NUMBER,DOCUMENT_ISSUE_DATE,DOCUMENT_EXPIRY_DATE,PREFERRED_LANGUAGE,HEAD_BRANCH,ACCOUNT_CURRENCY,BIC_CODE,SUP,NFA_CODE,ENTRY_DATE_TIME";
		logger.info("Column names for table "+table_name+"are "+column_names);
		query=query+table_name+"("+column_names+") ";
		String result="VALUES (";
		for(int i=0;i<data_value_list.size();i++)
		{
			if(i==0)
			{
				result=result+"'"+data_value_list.get(i)+"',";
			}
			else
				result=result+"N'"+data_value_list.get(i)+"',";
		}
		result=result+"'"+date+"'";
		//result = result.substring(0, result.length() - 1);
		query=query+result+")";
		logger.info("Query for saving company data is"+query);
		if(result.contains("VALUES")) // Always true, just using for safety
	    {
	    	if(result.split("VALUES")[1].trim()!="")
	    		iformObj.saveDataInDB(query);
	    }
	}

	private String fillHeaderDetails(IFormReference iformObj, String stringdata,String processInstanceID) 
	{
		logger.info("inside fillHeaderDetails function body");
		//String region="",area="",district="",branch="",channel="",branch_id="";
		String hrmsUserId="",hrmsFullName="",hrmsEmailID="",hrmsBranchID="",hrmsBranchName="",hrmsBranchRegion="",hrmsArea="",hrmsBranchDistrict="",hrmsBranchCity="",channel="",ho_brn="";
		//String userid_from_pdbuser="";
		String loggedInUserID="";
		String username=getUserName(iformObj);// Currently giving only administrator hence passing from js
		//String username=stringdata;
		String hrmsLinkedServerName=GetXML.getProp().getProperty("HRMS_Linked_server");
		String query="",email_query="";
		try
		{
		
			/*
			 * String query="SELECT Comment FROM PDBUser WHERE USERNAME = '"+username+"' ";
			 * List<List<String>> comment= iformObj.getDataFromDB(query);
			 * logger.info("Query from pdbuser is "+query+" and its result is "+comment);
			 * if(comment.size()>0) { if(comment.get(0).size()>0) userid_from_pdbuser =
			 * (String) comment.get(0).get(0); }
			 * logger.info("Value set in userid_from_pdbuser is  "+userid_from_pdbuser);
			 */
			loggedInUserID=getUserName(iformObj);
			if(loggedInUserID.length()>0)
			{
			 //query="SELECT * FROM OPENQUERY (TEST2,'SELECT a.BRANCH_ID,BRANCH_REGION,AREA,BRANCH_DISTRICT,B.BRANCH_NAME FROM APPS.XXARB_MSB_NEWGEN_EMP_DTLS_V A,APPS.XXARB_MSB_NEWGEN_BRANCH_DTLS_V B WHERE A.BRANCH_ID=B.BRANCH_ID AND A.USER_ID=''"+userid_from_pdbuser+"'' '); ";
			 //query="SELECT * FROM OPENQUERY ("+hrmsLinkedServerName+",'SELECT a.user_id,a.full_name_ARABIC,a.email_address,a.branch_id,a.branch_name_arabic,b.branch_region_arabic,b.area,b.branch_district_arabic,b.branch_city,a.ho_brn FROM APPS.XXARB_MSB_NEWGEN_EMP_DTLS_V A,APPS.XXARB_MSB_NEWGEN_BRANCH_DTLS_V B WHERE A.BRANCH_ID=B.BRANCH_ID AND A.BRANCH_NAME=B.BRANCH_NAME AND A.USER_ID=''"+loggedInUserID+"'' '); ";
			query="SELECT * FROM OPENQUERY ("+hrmsLinkedServerName+",'SELECT a.user_id,a.full_name_ARABIC,a.email_address,a.branch_id,a.branch_name_arabic,b.branch_region_arabic,b.area,b.branch_district_arabic,b.branch_city,a.ho_brn FROM APPS.XXARB_MSB_NEWGEN_EMP_DTLS_V A,APPS.XXARB_MSB_NEWGEN_BRANCH_DTLS_V B WHERE A.BRANCH_ID=B.BRANCH_ID and a.branch_name=b.branch_name AND upper(A.USER_ID)=upper(''"+loggedInUserID+"'')')";
			List<List<String>> result_from_query= iformObj.getDataFromDB(query);	
			logger.info("Query from HRMS is "+query+" and its result is "+result_from_query);
			 if(result_from_query.size()>0)
			 {
				 if(result_from_query.get(0).size()>4)
				 {
					 
					 hrmsUserId=result_from_query.get(0).get(0);
					 hrmsFullName=result_from_query.get(0).get(1);
					 hrmsEmailID=result_from_query.get(0).get(2);
					 hrmsBranchID=result_from_query.get(0).get(3);
					 hrmsBranchName=result_from_query.get(0).get(4);
					 hrmsBranchRegion=result_from_query.get(0).get(5);
					 hrmsArea=result_from_query.get(0).get(6);
					 hrmsBranchDistrict=result_from_query.get(0).get(7);
					 hrmsBranchCity=result_from_query.get(0).get(8);
					 ho_brn=result_from_query.get(0).get(9);
					 
				 }
				 
				 email_query="UPDATE NG_POS_EXTTABLE SET  RM_EMAIL_ID='"+hrmsEmailID+"' WHERE WI_NAME='"+processInstanceID+"' ";
				 logger.info("Query to set RM Email id from HRMS for Workitem '"+processInstanceID+"' is "+query);
				 iformObj.saveDataInDB(email_query);
				 
				 if(ho_brn.equalsIgnoreCase("Branch"))
					 channel="Branch"; //channel="Head Quarter";
				 	else
				 	 channel="Head Quarter"; //channel="Branch";
				 
				 query="UPDATE NG_POS_EXTTABLE SET REGION=N'"+hrmsBranchRegion+"',AREA=N'"+hrmsArea+"',DISTRICT=N'"+hrmsBranchDistrict+"',BRANCH=N'"+hrmsBranchCity+"',CHANNEL=N'"+channel+"' WHERE WI_NAME = '"+processInstanceID+"'  ";
				 String query_hrms="INSERT INTO ng_mast_hrms_data (USER_ID,FULL_NAME,EMAIL_ID,BRANCH_ID,BRANCH_NAME,BRANCH_REGION,AREA,BRANCH_DISTRICT,BRANCH_CITY,INSERTED_DATETIME) VALUES (N'"+hrmsUserId+"',N'"+hrmsFullName+"',N'"+hrmsEmailID+"',N'"+hrmsBranchID+"',N'"+hrmsBranchName+"',N'"+hrmsBranchRegion+"',N'"+hrmsArea+"',N'"+hrmsBranchDistrict+"',N'"+hrmsBranchCity+"',GETDATE())  ";
				 logger.info("Query to insert query_hrms is  "+query_hrms);
				 iformObj.saveDataInDB(query_hrms);
			 }
			 else
			 {
				 query="UPDATE NG_POS_EXTTABLE SET REGION='Riyadh Region',AREA='Central',DISTRICT='Riyadh',BRANCH='Riyadh',CHANNEL='Head Quarter' WHERE WI_NAME LIKE '"+processInstanceID+"'  ";
				 
			 }
			 logger.info("Query to insert header details in exttable is  "+query);
			 iformObj.saveDataInDB(query);
			 query="UPDATE NG_POS_EXTTABLE SET  RM_EMAIL_ID=(select MailId FROM PDBUSER WHERE USERNAME='"+username+"') WHERE WI_NAME='"+processInstanceID+"' ";
			logger.info("Query to set RM Email id from HRMS for Workitem '"+processInstanceID+"' is "+email_query);
			iformObj.saveDataInDB(query);
			 
			}
			else
			{
				query="UPDATE NG_POS_EXTTABLE SET REGION='Riyadh',AREA='Central',DISTRICT='Riyadh',BRANCH='Riyadh',CHANNEL='Head Quarter' WHERE WI_NAME LIKE '"+processInstanceID+"'  ";
				logger.info("Query to insert header details in exttable case 2 is  "+query);
				iformObj.saveDataInDB(query);
				
				query="UPDATE NG_POS_EXTTABLE SET  RM_EMAIL_ID=(select MailId FROM PDBUSER WHERE USERNAME='"+username+"') WHERE WI_NAME='"+processInstanceID+"' ";
				logger.info("Query to set RM Email id from HRMS for Workitem '"+processInstanceID+"' is "+email_query);
				iformObj.saveDataInDB(query);
			}
		}
		catch (Exception e)
		{
			 logger.info("Exception Occurred: fillHeaderDetails and exception is "+e);
		}
		
		return "fillHeaderDetails working sucessfully";
	}
	
	private void fillPOSdataFromSearchScreen(IFormReference iformObj, String processInstanceID) 
	{
		
		try {
	
			String table_name="NG_MSB_SEARCH_NEW_REQUEST_DATA";
			String new_request_column_names="CIC_NO,CUSTOMER_CATEGORY,REQUEST_TYPE,PRODUCT_CATEGORY,PRODUCT,LAST_12_MONTH_AVG_BAL,MAX_INDIC_AMT_ELIGIBLE,REQUIRED_AMT_SAR,ENTRY_DATE_TIME";
			String new_request_data_id="NG_MSB_CIC_NO,CUSTOMER_CATEGORY,REQUEST_TYPE,PRODUCT_CATEGORY,PRODUCT,LAST_TWELVE_AVERAGE_BALANCE,MAX_INDICATIVE_AMNT_ELEGIBLE,REQUIRED_AMT_SAR";
			setDatainDBfromSearchScreen(iformObj,"NG_MSB_CIC_NO",table_name,new_request_data_id,new_request_column_names);
		int saveDataOutPut;	
		String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
		String query="INSERT INTO NG_POS_STMTDATA_ACCMOVMNT_GRID SELECT '"+processInstanceID+"',FROM_DATE,TO_DATE,BANK_NAME,ACC_NO,DEPOSIT,WITHDRAWAL,AVG_BAL,NEG_BAL,ACC_MONTH,THROUGHPUT,ACC_STATUS FROM NG_MSB_SEARCH_STMTDATA_ACCMOVMNT_GRID WHERE CIC_NO='"+cic_number+"' ORDER BY FROM_DATE DESC  ";
		logger.info("Query to insert account movement from search screen data is "+query);
		saveDataOutPut=iformObj.saveDataInDB(query);
		logger.info("NG_POS_STMTDATA_ACCMOVMNT_GRID output === "+saveDataOutPut);
		//query="INSERT INTO NG_POS_THIQAH_DETAILS SELECT '"+processInstanceID+"',UNN_NO,COMPANY_NAME_AR,CR_START_DATE,CR_EXPIRY_DATE_HJ,PHONE_NO,BUSINESS_TYPE_AR,BUSINESS_ACTIVITY_AR,ADDRESS_AR,LOCATION, THIQAH_STATUS,CR_NUMBER FROM NG_MSB_SEARCH_THIQAH_DETAILS WHERE CIC_NO='"+cic_number+"' ";
		//logger.info("Query to insert thiqah details from search screen is "+query);
		//saveDataOutPut=iformObj.saveDataInDB(query);
		//logger.info("NG_POS_THIQAH_DETAILS output === "+saveDataOutPut);
		
		query="INSERT INTO NG_POS_CREDITLINE_CTF_MSB_GRID (WI_NAME,SYSTEM_NAME,PRODUCT_NAME,PRODUCT_TYPE,PRODUCT_CODE,ELIG_LIMIT_AMT,UTILIZED_AMT,AVAIL_DRAWDOWN,INSTL_AMT,ELIG_VALID_UPTO,CTF_STATUS,REPAYMNT_PERIOD,DOSSIER_NUMBER,INSTALLMENT_COUNT,PAID_INSTALLMENT_COUNT,PARTIAL_PAID_INSTALLMENT_COUNT,OUTSTANDING_BALANCE,FACILITY_TYPE) SELECT '"+processInstanceID+"','CTF',PRODUCT_NAME,PRODUCT_TYPE,PRODUCT_CODE,ELIG_LIMIT_AMT,UTILIZED_AMT,AVAIL_DRAWDOWN,INSTL_AMT,ELIG_VALID_UPTO,CTF_STATUS,REPAYMNT_PERIOD,DOSSIER_NUMBER,INSTALLMENT_COUNT,PAID_INSTALLMENT_COUNT,PARTIAL_PAID_INSTALLMENT_COUNT,OUTSTANDING_BALANCE,FACILITY_TYPE FROM NG_MSB_CREDITLINE_CTF_MSB_GRID WHERE CIC_NO='"+cic_number+"' ";
		logger.info("Query to inset in NG_POS_CREDITLINE_CTF_MSB_GRID from search screeen is "+query);
		saveDataOutPut=iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_CREDITLINE_DOSSIER_DETAILS_GRID(WI_NAME,DOSSIER_NUMBER,PRODUCT_CODE,DISBURSED_AMOUNT,MONTHLY_INSTALLMENT,DISBURSED_DATE,TENOR,LAST_INSTALMENT_DATE) SELECT '"+processInstanceID+"',DOSSIER_NUMBER,PRODUCT_CODE,DISBURSED_AMOUNT,MONTHLY_INSTALLMENT,DISBURSED_DATE,TENOR,LAST_INSTALMENT_DATE FROM NG_MSB_SEARCH_CREDITLINE_DOSSIER_DETAILS_GRID WHERE CIC_NO='"+cic_number+"' ";
		logger.info("Query to insert in NG_POS_CREDITLINE_DOSSIER_DETAILS_GRID from search screeen is "+query);
		saveDataOutPut=iformObj.saveDataInDB(query);
		
		logger.info("NG_POS_CREDITLINE_CTF_MSB_GRID output === "+saveDataOutPut);
		query="INSERT INTO NG_POS_STMTDATA_CORTEX_DETAIL (WI_NAME,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH,ARB_POS_USING_SINCE) SELECT '"+processInstanceID+"',TOT_THROUGPUT_LAST_12_MONTH,AVG_THROUGPUT_LAST_12_MONTH,TOT_THROUGPUT_LAST_3_MONTH,AVG_THROUGPUT_LAST_3_MONTH,ARB_USING_SINCE FROM NG_MSB_SEARCH_POS_THROUGPUT_DATA_ALL_MACHINES WHERE CIC_NO='"+cic_number+"' ";
		logger.info("Query to insert cortex data avg and total textboxes from search screeen is "+query);
		saveDataOutPut=iformObj.saveDataInDB(query);
		logger.info("NG_POS_STMTDATA_CORTEX_DETAIL output === "+saveDataOutPut);
		/*
		query="INSERT INTO NG_POS_COMPANY_DATA SELECT '"+processInstanceID+"',CIC_NO,USER_NAME,CIC_STATUS,REGISTRATION_AMEND_DATE,CLOSURE_DATE,BLACKLIST_STATUS,CR_NUMBER,NAME_OF_ENITITY_ENG,NAME_OF_ENTITY_ARB,ENTITY_TYPE_JUR_STATUS,COUNTRY_OF_INCORP,RESIDENCE,CENTRAL_BANK_SECTOR_CODE,DATE_OF_ESTABLISHMENT,EMPLOYEES_NO,SECTOR,SUBSECTOR,INDUSTRY,REGISTRATION_TYPE,COMP_DATA_NUMBER,COUNTRY,REGION,CITY,ISSUE_DATE,EXPIRY_DATE,UNDER_RENEWAL,MCI_CONTRACT_NO,MCI_CONTRACT_DATE,BRANCH_OFFICER,AUTHORIZED_TO_ACCESS_DETAILS,DOCUMENT_TYPE,COUNTRY_1,DOCUMENT_NUMBER,DOCUMENT_ISSUE_DATE,DOCUMENT_EXPIRY_DATE,PREFERRED_LANGUAGE,HEAD_BRANCH,ACCOUNT_CURRENCY,BIC_CODE,SUP,NFA_CODE FROM NG_MSB_SEARCH_COMPANY_DATA WHERE CIC_NO='"+cic_number+"' ";
		logger.info("Query to insert Company data from search screen is "+query);
		iformObj.saveDataInDB(query);
		*/
		//Adding Sajwa release
		query="INSERT INTO NG_POS_COMPANY_DATA (WI_NAME,CIC,USER_NAME,CIC_STATUS,REGISTRATION_AMEND_DATE,CLOSURE_DATE,BLACKLIST_STATUS,CR_NUMBER,NAME_OF_ENITITY_ENG,NAME_OF_ENTITY_ARB,ENTITY_TYPE_JUR_STATUS,COUNTRY_OF_INCORP,RESIDENCE,CENTRAL_BANK_SECTOR_CODE,DATE_OF_ESTABLISHMENT,EMPLOYEES_NO,SECTOR,SUBSECTOR,INDUSTRY,REGISTRATION_TYPE,COMP_DATA_NUMBER,COUNTRY,REGION,CITY,ISSUE_DATE,EXPIRY_DATE,UNDER_RENEWAL,MCI_CONTRACT_NO,MCI_CONTRACT_DATE,BRANCH_OFFICER,AUTHORIZED_TO_ACCESS_DETAILS,DOCUMENT_TYPE,COUNTRY_1,DOCUMENT_NUMBER,DOCUMENT_ISSUE_DATE,DOCUMENT_EXPIRY_DATE,PREFERRED_LANGUAGE,HEAD_BRANCH,ACCOUNT_CURRENCY,BIC_CODE,SUP,NFA_CODE,AMENDMENT_DATE,GOVERNMNT_FLG,ANTI_MONEY_LAUN_FLG,FIRCO_UNDER_INV_FLG,FIRCO_BLKLST_FLG,OTHR_BANK_BLKLST_FLG,ENTITY_TYPE_CD,ENTITY_TYPE_DESC,INCORP_CTRY_CD,RESIDENCE_FLG,SECTOR_CD,SECTOR_DESC,SAMA_SECTOR_DESC,SUB_SECTOR_CD,SUB_SECTOR_DESC,ACTIVITY_CD,ACTIVITY_DESC,ISSUE_DATE_CALENDER,REGIS_TYPE_ISSUE_DATE,ISSUE_TIMESTAMP,EXPIRY_DATE_CALENDER,REGIS_TYPE_EXPIRY_DATE,EXPIRY_TIMESTAMP,REGIS_TYPE_CTRYCODE,REGIS_TYPE_CITYCODE,REGIS_TYPE_CITYNAME,USER_AUTH_FLG,CTRY_CD,SUPERVISION_CD,SUPERVISION_DESC,TIER3_FLG,TIER2_FLG,SME_NON_BORROW_FLG,SE_BORROW_FLG,ME_BORROW_FLG,MI_BORROW_FLG,EMAIL,WEBSITE,SAMA_SECTOR_CD,UNN_DESC,CTRY_NAME,INCORP_CTRY,JOIN_DATE,REGISTRATION_CTRY,UNN_NO) SELECT '"+processInstanceID+"',CIC_NO,USER_NAME,CIC_STATUS,REGISTRATION_AMEND_DATE,CLOSURE_DATE,BLACKLIST_STATUS,CR_NUMBER,NAME_OF_ENITITY_ENG,NAME_OF_ENTITY_ARB,ENTITY_TYPE_JUR_STATUS,COUNTRY_OF_INCORP,RESIDENCE,CENTRAL_BANK_SECTOR_CODE,DATE_OF_ESTABLISHMENT,EMPLOYEES_NO,SECTOR,SUBSECTOR,INDUSTRY,REGISTRATION_TYPE,COMP_DATA_NUMBER,COUNTRY,REGION,CITY,ISSUE_DATE,EXPIRY_DATE,UNDER_RENEWAL,MCI_CONTRACT_NO,MCI_CONTRACT_DATE,BRANCH_OFFICER,AUTHORIZED_TO_ACCESS_DETAILS,DOCUMENT_TYPE,COUNTRY_1,DOCUMENT_NUMBER,DOCUMENT_ISSUE_DATE,DOCUMENT_EXPIRY_DATE,PREFERRED_LANGUAGE,HEAD_BRANCH,ACCOUNT_CURRENCY,BIC_CODE,SUP,NFA_CODE,AMENDMENT_DATE,GOVERNMNT_FLG,ANTI_MONEY_LAUN_FLG,FIRCO_UNDER_INV_FLG,FIRCO_BLKLST_FLG,OTHR_BANK_BLKLST_FLG,ENTITY_TYPE_CD,ENTITY_TYPE_DESC,INCORP_CTRY_CD,RESIDENCE_FLG,SECTOR_CD,SECTOR_DESC,SAMA_SECTOR_DESC,SUB_SECTOR_CD,SUB_SECTOR_DESC,ACTIVITY_CD,ACTIVITY_DESC,ISSUE_DATE_CALENDER,REGIS_TYPE_ISSUE_DATE,ISSUE_TIMESTAMP,EXPIRY_DATE_CALENDER,REGIS_TYPE_EXPIRY_DATE,EXPIRY_TIMESTAMP,REGIS_TYPE_CTRYCODE,REGIS_TYPE_CITYCODE,REGIS_TYPE_CITYNAME,USER_AUTH_FLG,CTRY_CD,SUPERVISION_CD,SUPERVISION_DESC,TIER3_FLG,TIER2_FLG,SME_NON_BORROW_FLG,SE_BORROW_FLG,ME_BORROW_FLG,MI_BORROW_FLG,EMAIL,WEBSITE,SAMA_SECTOR_CD,UNN_DESC,CTRY_NAME,INCORP_CTRY,JOIN_DATE,REGISTRATION_CTRY,UNN_NO FROM NG_MSB_SEARCH_COMPANY_DATA WHERE CIC_NO='"+cic_number+"'";
		logger.info("Query to insert Company data from search screen is "+query);
		saveDataOutPut=iformObj.saveDataInDB(query);
		
		logger.info("NG_POS_COMPANY_DATA output === "+saveDataOutPut);
		query="INSERT INTO NG_POS_ADDRESS_LIST_GRID (WI_NAME,ADDR_TYPE,ADDR_TYPE_DESC,ORIGINAL_NO,STREET_NAME,QUARTER_NAME,UNIT_NO,ZIP_CODE,CITY_CODE,CITY_NAME,ADDITIONAL_NO,NEW_ADDR_DEF_FLG,REGION_CD,REGION_DESC,CTRY_DESC) SELECT '"+processInstanceID+"',ADDR_TYPE,ADDR_TYPE_DESC,ORIGINAL_NO,STREET_NAME,QUARTER_NAME,UNIT_NO,ZIP_CODE,CITY_CODE,CITY_NAME,ADDITIONAL_NO,NEW_ADDR_DEF_FLG,REGION_CD,REGION_DESC,CTRY_DESC FROM NG_MSB_SEARCH_ADDRESS_LIST_GRID WHERE CIC_NO='"+cic_number+"'";
		logger.info("Query to insert address list from search screen is "+query);
		iformObj.saveDataInDB(query);
		//Sajwa code end
		
		
		logger.info("NG_POS_COMPANY_DATA output === "+saveDataOutPut);
		query="INSERT INTO NG_POS_STMTDATA_CORTEX_DETAIL_GRID SELECT '"+processInstanceID+"',CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT,TERMINAL_ID FROM NG_MSB_SEARCH_STMTDATA_CORTEX_DETAIL_GRID WHERE CIC_NO='"+cic_number+"' ";
		logger.info("Query to insert cortex details grid data from search screen is "+query);
		saveDataOutPut=iformObj.saveDataInDB(query);
	
		logger.info("NG_POS_STMTDATA_CORTEX_DETAIL_GRID output === "+saveDataOutPut);
		query="INSERT INTO NG_POS_CREDITLINE_LOANACC_GRID SELECT '"+processInstanceID+"',LOS_APPLN_NO,T24_LIMIT_REF,PROD_CATEGORY,PRODUCT,CUST_CATEGORY,CAMPAIGN,MAST_CONTRACT_NO,LOAN_ACC_NO,GROSS_AMT,FIN_AMT,CONTRACT_DATE,DISBURSAL_DATE,FIRST_INST_DATE,LAST_INST_DATE,GROSS_OUTSDING,OUTSTDNG_PRINCIPAL,OUTSTDNG_PROFIT,INSTALLMENT,TENURE,FREQUENCY,PROFIT_PERCENT,LOAN_STATUS,DPD,INSTALLMENT_PERIOD FROM NG_MSB_SEARCH_POS_CREDITLINE_FINACC_GRID WHERE CIC_NO='"+cic_number+"' ";
		logger.info("Query to insert credit line load details grid from search screen is "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_EVIDENCE_CODE_GRID (WI_NAME,EVIDENCE_CODE,DESCRIPTION,BRANCH_CODE,START_DATE) SELECT '"+processInstanceID+"',EVIDENCE_CODE,DESCRIPTION,BRANCH_CODE,START_DATE FROM NG_MSB_SEARCH_EVIDENCE_CODE_GRID WHERE CIC_NO='"+cic_number+"' " ;
		logger.info("Evidence Grid Query is: "+query);
		iformObj.saveDataInDB(query);
		
		//query="INSERT INTO NG_POS_RELATED_PARTY_ROLES_GRID (WI_NAME,ROLE_DESCRIPTION,PERCENTAGE,PARTY_TYPE,NAME_ENG,NAME_AR,CHILD_CIC,GROUP_DESCRIPTION) SELECT '"+processInstanceID+"',ROLE_DESCRIPTION,PERCENTAGE,PARTY_TYPE,NAME_ENG,NAME_AR,CHILD_CIC,GROUP_DESCRIPTION FROM NG_MSB_SEARCH_RELATED_PARTY_ROLES_GRID WHERE CIC_NO='"+cic_number+"'";
		query="INSERT INTO NG_POS_RELATED_PARTY_ROLES_GRID (WI_NAME,CIC_NO,PARENT_CIC,CHILD_CIC,ROLE_DESCRIPTION,PERCENTAGE,PARTY_TYPE,NAME_ENG,NAME_AR,GROUP_DESCRIPTION,CR,UNN,CICStatus,RegisterDate,Establishate,entityName,entityNameOther,entityTypeCd,entityTypeDesc,CountryCd,SectorCd,SubSectorCd,SamaSectorDesc,BankSectorDesc,ActivityDesc,SubSectorDesc,RegTypeCd,RegTypeDesc,entityCityName,entityRegionCd,entityCountryCd,entitySAMASectorCd,FirstNameAR,SecondNameAR,FamilyNameAR,FirstNameEN,SecondNameEN,FamilyNameEN,Nationality,BirthDate,Age,MaritalStatus,MaritalStatusDesc,AddressBuildingNumber,AddressUnitNumber,AddressStreetName,AddressRegion,AddressCityCd,AddressCityName,AddressAdditionalNumber,AddressPostalCd,PrefContactNo,MobileNum,PartyStatusDesc,NationalityDesc,ID_NUMBER,ID_ISSUE_DATE,ID_EXPIRY_DATE,GENDER,PARENT_CR,ROLE_TYPE) SELECT '"+processInstanceID+"',CIC_NO,PARENT_CIC,CHILD_CIC,ROLE_DESCRIPTION,PERCENTAGE,PARTY_TYPE,NAME_ENG,NAME_AR,GROUP_DESCRIPTION,CR,UNN,CICStatus,RegisterDate,Establishate,entityName,entityNameOther,entityTypeCd,entityTypeDesc,(SELECT COUNTRY FROM NG_MAST_COUNTRY_MAIN WHERE COUNTRY_CODE=CountryCd),SectorCd,SubSectorCd,SamaSectorDesc,BankSectorDesc,ActivityDesc,SubSectorDesc,RegTypeCd,RegTypeDesc,entityCityName,entityRegionCd,entityCountryCd,entitySAMASectorCd,FirstNameAR,SecondNameAR,FamilyNameAR,FirstNameEN,SecondNameEN,FamilyNameEN,(SELECT NATIONALITY FROM NG_MAST_COUNTRY WHERE CODE=Nationality),BirthDate,Age,MaritalStatus,MaritalStatusDesc,AddressBuildingNumber,AddressUnitNumber,AddressStreetName,AddressRegion,AddressCityCd,AddressCityName,AddressAdditionalNumber,AddressPostalCd,SUBSTRING(PrefContactNo,5,50),SUBSTRING(MobileNum,5,50),PartyStatusDesc,NationalityDesc,ID_NUMBER,ID_ISSUE_DATE,ID_EXPIRY_DATE,GENDER,PARENT_CR,'Owners' FROM NG_MSB_SEARCH_RELATED_PARTY_ROLES_GRID where cic_no='"+cic_number+"'  ";
		logger.info("Related party role grid Query is: "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_ENTITY_CONTACT_INFO_GRID SELECT '"+processInstanceID+"',CONTACT_TYPE,INTERNATIONAL_PREFIX,AREA_CODE,NUMBER,EXTENSION FROM NG_MSB_SEARCH_KEY_CONTACT_GRID WHERE CIC_NO='"+cic_number+"' " ;
		logger.info("Key contact grid Query is: "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_CIC_DETAILS_GRID SELECT '"+processInstanceID+"',CIC_NO,CR_NO,ENTITY_NAME_ENG,ENTITY_NAME_AR,UNN FROM NG_MSB_SEARCH_CIC_DETAILS_GRID WHERE CIC_NO='"+cic_number+"' " ;
		logger.info("CIC Details Query is: "+query);
		iformObj.saveDataInDB(query);
		

		String old_cic_no=(String) iformObj.getValue("MSB_SEARCH_OLD_CIC_NUMBER_2");
		
		query="UPDATE NG_POS_EXTTABLE  SET WI_NAME=a.ProcessInstanceID,cic_no='"+cic_number+"',PADDED_OLD_CIC_NO='"+old_cic_no+"',INITIAL_REQUEST_AMT=(SELECT REQUIRED_AMT_SAR FROM NG_MSB_SEARCH_NEW_REQUEST_DATA  WHERE CIC_NO='"+cic_number+"') ,PROSPECT_CUSTOMER=(SELECT PROSPECT_CUST_STATUS FROM NG_MSB_SEARCH_PROSPECT_CUST_STATUS WHERE CIC_NO='"+cic_number+"') FROM WFINSTRUMENTTABLE a, NG_POS_EXTTABLE b WHERE a.VAR_REC_1=b.ITEMINDEX and a.VAR_REC_2=b.ITEMTYPE and a.ProcessInstanceID='"+processInstanceID+"' " ;
		logger.info("Query for updating external table is: "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_APPLICATION_DATA(WI_NAME,CUSTOMER_CATEGORY,REQUEST_TYPE,PRODUCT_CATEGORY,PRODUCT,MAX_INDICATIVE_AMT_ELIGIBLE,REQ_AMNT_SAR) SELECT '"+processInstanceID+"',CUSTOMER_CATEGORY,REQUEST_TYPE,PRODUCT_CATEGORY,PRODUCT,MAX_INDIC_AMT_ELIGIBLE,REQUIRED_AMT_SAR FROM NG_MSB_SEARCH_NEW_REQUEST_DATA WHERE CIC_NO='"+cic_number+"' ";
		logger.info("Query to insert application data fields from search screen is "+query);
		iformObj.saveDataInDB(query);
		String dbquery="";
		
		query="INSERT INTO NG_POS_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES (WI_NAME,CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT) SELECT '"+processInstanceID+"',CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT FROM NG_MSB_SEARCH_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE CIC_NO='"+cic_number+"'   ORDER BY INSERTIONORDERID ";
		logger.info("Query to insert monthwise cortex data for all machines is "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_SHAREHOLDERS_DETAILS (WI_NAME,COMPANYCIC,ROLECD,ROLEDESC,PERCENT_VAL,GROUPROLECD,GROUPROLEDESC,CIC_NO) SELECT '"+processInstanceID+"',COMPANYCIC,ROLECD,ROLEDESC,PERCENT_VAL,GROUPROLECD,GROUPROLEDESC,CIC_NO FROM NG_MSB_SEARCH_SHAREHOLDERS_DETAILS WHERE CIC_NO='"+cic_number+"' ";
		logger.info("Query to insert data in shareholder list is "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_CLOSING_BALANCE_GRID (WI_NAME,ACCOUNT_NO,CLOSING_BALANCE,ACCOUNT_OPEN_DATE) SELECT '"+processInstanceID+"',ACCOUNT_NO,CLOSING_BALANCE,ACCOUNT_OPEN_DATE FROM NG_MSB_SEARCH_CLOSING_BALANCE_GRID WHERE CIC_NO='"+cic_number+"' ";
		logger.info("Query to insert data in NG_POS_CLOSING_BALANCE_GRID list is "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_ACCOUNT_STATUS_GRID (WI_NAME,ACCOUNT_NO,ACCOUNT_STATUS,ACCOUNT_BLOCK_CODE,ACCOUNT_DESCRIPTION) SELECT '"+processInstanceID+"',ACCOUNT_NO,ACCOUNT_STATUS,ACCOUNT_BLOCK_CODE,ACCOUNT_DESCRIPTION FROM NG_MSB_SEARCH_ACCOUNT_STATUS_GRID WHERE CIC_NO='"+cic_number+"' ";
		logger.info("Query to insert data in NG_POS_ACCOUNT_STATUS_GRID list is "+query);
		iformObj.saveDataInDB(query);
				
		//Inserting data for old CIC tables.
		
		query="INSERT INTO NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_GRID SELECT '"+processInstanceID+"',FROM_DATE,TO_DATE,BANK_NAME,ACC_NO,DEPOSIT,WITHDRAWAL,AVG_BAL,NEG_BAL,ACC_MONTH,THROUGHPUT,ACC_STATUS FROM NG_MSB_SEARCH_OLD_CIC_STMTDATA_ACCMOVMNT_GRID WHERE CIC_NO='"+old_cic_no+"' ORDER BY FROM_DATE DESC  ";
				logger.info("Query to insert account movement from search screen data is "+query);
				saveDataOutPut=iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL (WI_NAME,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH,ARB_POS_USING_SINCE) SELECT '"+processInstanceID+"',TOT_THROUGPUT_LAST_12_MONTH,AVG_THROUGPUT_LAST_12_MONTH,TOT_THROUGPUT_LAST_3_MONTH,AVG_THROUGPUT_LAST_3_MONTH,ARB_USING_SINCE FROM NG_MSB_SEARCH_OLD_CIC_POS_THROUGPUT_DATA_ALL_MACHINES WHERE CIC_NO='"+old_cic_no+"' ";
				logger.info("Query to insert cortex data avg and total textboxes from search screeen is "+query);
				saveDataOutPut=iformObj.saveDataInDB(query);
				logger.info("NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL output === "+saveDataOutPut);
				
		query="INSERT INTO NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID SELECT '"+processInstanceID+"',CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT,TERMINAL_ID FROM NG_MSB_SEARCH_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID WHERE CIC_NO='"+old_cic_no+"' ";
				logger.info("Query to insert cortex details grid data from search screen is "+query);
				saveDataOutPut=iformObj.saveDataInDB(query);
			
		query="INSERT INTO NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES (WI_NAME,CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT) SELECT '"+processInstanceID+"',CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT FROM NG_MSB_SEARCH_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE CIC_NO='"+old_cic_no+"'   ORDER BY INSERTIONORDERID ";
				logger.info("Query to insert monthwise cortex data for all machines is "+query);
				iformObj.saveDataInDB(query);
				
		query="INSERT INTO NG_POS_OLD_CIC_CLOSING_BALANCE_GRID (WI_NAME,ACCOUNT_NO,CLOSING_BALANCE,ACCOUNT_OPEN_DATE) SELECT '"+processInstanceID+"',ACCOUNT_NO,CLOSING_BALANCE,ACCOUNT_OPEN_DATE FROM NG_MSB_SEARCH_OLD_CIC_CLOSING_BALANCE_GRID WHERE CIC_NO='"+old_cic_no+"' ";
				logger.info("Query to insert data in NG_POS_OLD_CIC_CLOSING_BALANCE_GRID list is "+query);
				iformObj.saveDataInDB(query);
				
		query="INSERT INTO NG_POS_OLD_CIC_ACCOUNT_STATUS_GRID (WI_NAME,ACCOUNT_NO,ACCOUNT_STATUS,ACCOUNT_BLOCK_CODE,ACCOUNT_DESCRIPTION) SELECT '"+processInstanceID+"',ACCOUNT_NO,ACCOUNT_STATUS,ACCOUNT_BLOCK_CODE,ACCOUNT_DESCRIPTION FROM NG_MSB_SEARCH_OLD_CIC_ACCOUNT_STATUS_GRID WHERE CIC_NO='"+old_cic_no+"' ";
				logger.info("Query to insert data in NG_POS_OLD_CIC_ACCOUNT_STATUS_GRID list is "+query);
				iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_OLD_CIC_DETAILS (WI_NAME,CIC_NO,CR_NO,ENTITY_NAME_ENG,ENTITY_NAME_AR,UNN_NO) SELECT '"+processInstanceID+"',CIC_NO,CR_NO,ENTITY_NAME_ENG,ENTITY_NAME_AR,UNN_NO FROM NG_MSB_SEARCH_OLD_CIC_DETAILS WHERE CIC_NO='"+old_cic_no+"' ";
				logger.info("Query to insert data in NG_POS_OLD_CIC_DETAILS  is "+query);
				iformObj.saveDataInDB(query);

				
		String padded_cic_no=cic_number;
		for(int i=0;i<16-cic_number.length();i++)
		{
			padded_cic_no="0"+padded_cic_no;
		}
		fillPOSrelatedTable(iformObj, padded_cic_no,processInstanceID);
		/*
		query="INSERT INTO NG_POS_STMTDATA_OTHER_DETAIL_GRID (WI_NAME,OTHER_MONTH,BANK_NAME,THROUGHPUT,OTHER_TRANSACTION,AVG_TRANSACTN_AMT) SELECT '"+processInstanceID+"',POS_MONTH,(SELECT TOP 1 BANK_NAME FROM NG_STATEMENT_OCR_CUST_INFO WHERE CIC_NO = '"+padded_cic_no+"' ORDER BY CAST(SUBSTRING(WI_NAME,5,14) AS INT) DESC),THROUGHPUT,POS_TRANSACTION,AVG_TRANSACTN_AMT FROM NG_STATEMENT_OCR_POS_TRANSACTN_GRID WHERE WI_NAME=(SELECT TOP 1 WI_NAME FROM NG_STATEMENT_OCR_CUST_INFO WHERE CIC_NO = '"+padded_cic_no+"' ORDER BY CAST(SUBSTRING(WI_NAME,5,14) AS INT) DESC) order by convert(date,'01-'+POS_MONTH,103) desc  ";
		logger.info("Query to insert data in NG_POS_STMTDATA_OTHER_DETAIL_GRID list is "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_STMTDATA_OTHER_DETAIL (WI_NAME,NON_ARB_POS_USING_SINCE,BANK_NAME,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH)SELECT '"+processInstanceID+"',NON_ARB_POS_USING_SINCE,BANK_NAME,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH FROM NG_STATEMENT_OCR_CUST_INFO A, NG_STATEMENT_OCR_POS_TRANSACTN B WHERE A.WI_NAME=B.WI_NAME AND A.WI_NAME=(SELECT TOP 1 WI_NAME FROM NG_STATEMENT_OCR_CUST_INFO WHERE CIC_NO = '"+padded_cic_no+"' ORDER BY CAST(SUBSTRING(WI_NAME,5,14) AS INT) DESC)";
		logger.info("Query to insert data in NG_POS_STMTDATA_OTHER_DETAIL list is "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_STMTDATA_ACCMOVMNT_NON_ARB (WI_NAME,TOT_THROUGPUT_LAST_12,TOT_THROUGPUT_LAST_4,AVG_BAL_LAST_12,ZERO_BAL_LAST_12) SELECT '"+processInstanceID+"',TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,AVG_BAL_12MNTH,ZERO_BAL_12MNTH FROM NG_STATEMENT_OCR_CUST_INFO A, NG_STATEMENT_OCR_ACC_MVMNT B WHERE A.WI_NAME=B.WI_NAME AND A.WI_NAME=(SELECT TOP 1 WI_NAME FROM NG_STATEMENT_OCR_CUST_INFO  WHERE CIC_NO = '"+padded_cic_no+"' ORDER BY CAST(SUBSTRING(WI_NAME,5,14) AS INT) DESC)";
		logger.info("Query to insert data in NG_POS_STMTDATA_ACCMOVMNT_NON_ARB list is "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_ACCMOVMNT_NONARB_GRID (WI_NAME,ACC_MVMNT_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVG_BAL) SELECT '"+processInstanceID+"',TRANSACTION_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVERAGE_TRANSACTION FROM NG_MSB_SEARCH_NONPOS_ACCMOVMNT_DETAILS WHERE cic='"+cic_number+"' order by convert(date,'01-'+TRANSACTION_MONTH,103) desc ";
		logger.info("Query to insert data in NG_POS_ACCMOVMNT_NONARB_GRID list is "+query);
		iformObj.saveDataInDB(query);
		*/
		
		query="SELECT PARAM_VALUE FROM NG_POS_PARAM_CONFIG WHERE PARAM_KEY='LIMITVALIDITY' AND ISACTIVE='Y' ";
		List<List<String>> limit_validity = iformObj.getDataFromDB(query);
		if(limit_validity.size()>0)
		{
				logger.info("Setting limit validity "+limit_validity.get(0).get(0));
				//setControlValue(iformObj,"Q_NG_POS_APPLICATION_DATA_LIMIT_VALIDITY", limit_validity.get(0).get(0));
				dbquery="UPDATE NG_POS_APPLICATION_DATA SET LIMIT_VALIDITY='"+limit_validity.get(0).get(0)+"' WHERE WI_NAME='"+processInstanceID+"'";
				logger.info("Query to update limit validity from search screen is "+dbquery);
				saveDataInDB(iformObj, dbquery);
		}
		
		query="SELECT PARAM_VALUE FROM NG_POS_PARAM_CONFIG WHERE PARAM_KEY='DISBBANKNAME' AND ISACTIVE='Y' ";
		List<List<String>> bank_name = iformObj.getDataFromDB(query);
		if(bank_name.size()>0)
		{
			logger.info("Setting Disbursal Bank Name "+bank_name.get(0).get(0));
			//setControlValue(iformObj,"Q_NG_POS_APPLICATION_DATA_LIMIT_VALIDITY", limit_validity.get(0).get(0));
			dbquery="UPDATE NG_POS_APPLICATION_DATA SET DISBURSAL_BANKNAME='"+bank_name.get(0).get(0)+"' WHERE WI_NAME='"+processInstanceID+"'";
			logger.info("Query to update BankName from search screen is "+dbquery);
			saveDataInDB(iformObj, dbquery);
		}
		
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: fillPOSdataFromSearchScreen: and stack trace is"+e);
		}
		
	}

	 public void fillPOSrelatedTable(IFormReference iformObj,String cic,String wi_name)
	 {
		 //String cic=iformObj.getValue("Q_NG_STATEMENT_OCR_CUST_INFO_CIC_NO").toString();
		 String query="delete from NG_POS_STMTDATA_OTHER_DETAIL_GRID where wi_name='"+wi_name+"' ";
		 logger.debug("query : "+query);
				 iformObj.saveDataInDB(query);
				 query="INSERT INTO NG_POS_STMTDATA_OTHER_DETAIL_GRID (WI_NAME,OTHER_MONTH,BANK_NAME,THROUGHPUT,OTHER_TRANSACTION,AVG_TRANSACTN_AMT,num_of_pos,pos_since) "+
				 " select wi_name, TRANSACTION_MONTH,'' , sum(cast(THROUGHPUT as numeric(20,2))),sum(cast(NO_OF_TRANSACTION as numeric(20)))"
				 + ",sum(cast(AVERAGE_TRANSACTION as numeric(20,2))),num_of_pos,pos_since from "
				 + " (SELECT  '"+wi_name+"' wi_name, "
				 + "TRANSACTION_MONTH,THROUGHPUT,NO_OF_TRANSACTION  , AVERAGE_TRANSACTION,num_of_pos,pos_since   FROM NG_MSB_SEARCH_NONPOS_POS_DETAILS WHERE CIC= '"+cic+"' "
				 + "  ) a group by wi_name,TRANSACTION_MONTH,num_of_pos,pos_since order by convert(date,'01-'+TRANSACTION_MONTH,103) desc ";
				 logger.debug("query : "+query);
				 iformObj.saveDataInDB(query);
				 query="delete from NG_POS_ACCMOVMNT_NONARB_GRID  where wi_name='"+wi_name+"' ";
				 logger.debug("query : "+query);
				 iformObj.saveDataInDB(query);
				 query="INSERT INTO NG_POS_ACCMOVMNT_NONARB_GRID  (WI_NAME,ACC_MVMNT_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVG_BAL) "+
						 "  SELECT wi_name,TRANSACTION_MONTH,sum(cast(THROUGHPUT as numeric(20,2))),sum(cast(NO_OF_TRANSACTION as numeric(20))),"
						 + "sum(cast(AVERAGE_TRANSACTION as numeric(20,2))) "
						 + "  from ( select '"+wi_name+"' wi_name,TRANSACTION_MONTH, THROUGHPUT, NO_OF_TRANSACTION , "
						 + " AVERAGE_TRANSACTION  FROM NG_MSB_SEARCH_NONPOS_ACCMOVMNT_DETAILS WHERE CIC='"+cic+"'  ) a group by  wi_name,TRANSACTION_MONTH "
						 + " order by convert(date,'01-'+TRANSACTION_MONTH,103) desc";
						 logger.debug("query : "+query);
						 iformObj.saveDataInDB(query);
						 
			 query="delete from NG_POS_ACCMOVMNT_NONARB_GRID_REUPLOAD where wi_name='"+wi_name+"' ";
			 logger.debug("query : "+query);
					 iformObj.saveDataInDB(query);
			 query="delete from NG_POS_STMTDATA_OTHER_DETAIL_GRID_REUPLOAD where wi_name='"+wi_name+"' ";
			 logger.debug("query : "+query);
					 iformObj.saveDataInDB(query);
			
					 query="insert into  NG_POS_ACCMOVMNT_NONARB_GRID_REUPLOAD(WI_NAME,ACC_MVMNT_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVG_BAL,BANK_NAME,ACC_NO) select '"+wi_name+"',TRANSACTION_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVERAGE_TRANSACTION,BANK_NAME,ACCOUNT_NO from NG_MSB_SEARCH_NONPOS_ACCMOVMNT_DETAILS where cic='"+cic+"'";
					 logger.debug("query : "+query);
							 iformObj.saveDataInDB(query);
					 query="insert into  NG_POS_STMTDATA_OTHER_DETAIL_GRID_REUPLOAD (WI_NAME,OTHER_MONTH,THROUGHPUT,OTHER_TRANSACTION,AVG_TRANSACTN_AMT,BANK_NAME,ACC_NO,num_of_pos,pos_since)  select '"+wi_name+"',TRANSACTION_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVERAGE_TRANSACTION,BANK_NAME,ACCOUNT_NO,num_of_pos,pos_since from NG_MSB_SEARCH_NONPOS_POS_DETAILS where cic='"+cic+"'";
					 logger.debug("query : "+query);
							 iformObj.saveDataInDB(query);
							 
			
			 query="delete from NG_POS_STMTDATA_ACCMOVMNT_NON_ARB where wi_name='"+wi_name+"' ";
			 logger.debug("query : "+query);
			 iformObj.saveDataInDB(query);
              //query="INSERT INTO NG_POS_STMTDATA_ACCMOVMNT_NON_ARB (WI_NAME,TOT_THROUGPUT_LAST_12,TOT_THROUGPUT_LAST_4,AVG_BAL_LAST_12,ZERO_BAL_LAST_12) values( '"+wi_name+"','"+iformObj.getValue("Q_NG_STATEMENT_OCR_ACC_MVMNT_TOT_THRGPUT_12MNTH").toString()+"','"+iformObj.getValue("Q_NG_STATEMENT_OCR_ACC_MVMNT_AVG_THRGPUT_12MNTH").toString()+"','"+iformObj.getValue("Q_NG_STATEMENT_OCR_ACC_MVMNT_AVG_BAL_12MNTH").toString()+"','"+iformObj.getValue("Q_NG_STATEMENT_OCR_ACC_MVMNT_ZERO_BAL_12MNTH").toString()+"') ";
             // logger.info("Query to insert data in NG_POS_STMTDATA_ACCMOVMNT_NON_ARB list is "+query);
              //iformObj.saveDataInDB(query);
              
              query="delete from NG_POS_STMTDATA_OTHER_DETAIL where wi_name='"+wi_name+"' ";
 			 logger.debug("query : "+query);
 			 iformObj.saveDataInDB(query);
              //query="INSERT INTO NG_POS_STMTDATA_OTHER_DETAIL(WI_NAME,NON_ARB_POS_USING_SINCE,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH) values( '"+wi_name+"','"+iformObj.getValue("Q_NG_STATEMENT_OCR_CUST_INFO_NON_ARB_POS_USING_SINCE").toString()+"','"+iformObj.getValue("Q_NG_STATEMENT_OCR_POS_TRANSACTN_TOT_THRGPUT_12MNTH").toString()+"','"+iformObj.getValue("Q_NG_STATEMENT_OCR_POS_TRANSACTN_AVG_THRGPUT_12MNTH").toString()+"','"+iformObj.getValue("Q_NG_STATEMENT_OCR_POS_TRANSACTN_TOT_THRGPUT_4MNTH").toString()+"','"+iformObj.getValue("Q_NG_STATEMENT_OCR_POS_TRANSACTN_AVG_THRGPUT_4MNTH").toString()+"') ";
              //logger.info("Query to insert data in NG_POS_STMTDATA_ACCMOVMNT_NON_ARB list is "+query);
             // iformObj.saveDataInDB(query);

			//Using Old Queries Here
             query="INSERT INTO NG_POS_STMTDATA_ACCMOVMNT_NON_ARB (WI_NAME,TOT_THROUGPUT_LAST_12,TOT_THROUGPUT_LAST_4,AVG_BAL_LAST_12,ZERO_BAL_LAST_12) SELECT '"+wi_name+"',TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,AVG_BAL_12MNTH,ZERO_BAL_12MNTH FROM NG_STATEMENT_OCR_CUST_INFO A, NG_STATEMENT_OCR_ACC_MVMNT B WHERE A.WI_NAME=B.WI_NAME AND A.WI_NAME=(SELECT TOP 1 WI_NAME FROM NG_STATEMENT_OCR_CUST_INFO  WHERE CIC_NO = '"+cic+"' ORDER BY CAST(SUBSTRING(WI_NAME,5,14) AS INT) DESC)";
      		logger.info("Query to insert data in NG_POS_STMTDATA_ACCMOVMNT_NON_ARB list is "+query);
      		iformObj.saveDataInDB(query);
      		
      		query="INSERT INTO NG_POS_STMTDATA_OTHER_DETAIL (WI_NAME,NON_ARB_POS_USING_SINCE,BANK_NAME,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH)SELECT '"+wi_name+"',NON_ARB_POS_USING_SINCE,BANK_NAME,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH FROM NG_STATEMENT_OCR_CUST_INFO A, NG_STATEMENT_OCR_POS_TRANSACTN B WHERE A.WI_NAME=B.WI_NAME AND A.WI_NAME=(SELECT TOP 1 WI_NAME FROM NG_STATEMENT_OCR_CUST_INFO WHERE CIC_NO = '"+cic+"' ORDER BY CAST(SUBSTRING(WI_NAME,5,14) AS INT) DESC)";
    		logger.info("Query to insert data in NG_POS_STMTDATA_OTHER_DETAIL list is "+query);
    		iformObj.saveDataInDB(query);
    		
	 }

	
	private String msbSearchButtonClicked(IFormReference iformObj, String stringData) 
	{
			
			
			String callName="";//"CustBasicDataInq";
			String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");	
			logger.info("ss"+cic_number+"dd");
			if(cic_number.length()>0)
			{
				callName="CustBasicDataInq";
				logger.info("Setting callname as "+callName);
			}
			else
			{
				callName="CustBasicDataInq_WithoutCIC";
				logger.info("Setting callname as "+callName);
			}
			String cr_number=getControlValue(iformObj, "NG_MSB_CR_NO");
			String english_name=getControlValue(iformObj, "NG_MSB_COMP_ENGLISH_NAME");
			String arabic_name=getControlValue(iformObj, "NG_MSB_COMP_ARABIC_NAME");
			String unn_number=getControlValue(iformObj, "NG_MSB_UNN_NO");
			//String application_no=getControlValue(iformObj, "NG_MSB_UNN_NO");
			
			logger.info("Search Screen header values are"+cic_number+"#"+cr_number+"#"+english_name);
			
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
						try {
							
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
					if (tagValue.startsWith("formid~")) {
						String value = (String) iformObj.getValue(tagValue.split("~")[1]);
						parser.changeValue(request_prefix+tag, value);
					}
					
				}
				
			if(!(cic_number.length()==0))
			{
				parser.changeValue("alr1:FuncID","0001");		
			}
			else if(!(cr_number.length()==0))
			{
				parser.changeValue("alr1:FuncID","0002");		
			}else if(!(english_name.length()==0))
			{
				parser.changeValue("alr1:FuncID","0003");		
			}else if(!(arabic_name.length()==0))
			{
				parser.changeValue("alr1:FuncID","0004");		
			}else if(!(unn_number.length()==0))
			{
				parser.changeValue("alr1:FuncID","0005");		
			}else
			{
				return "No Result";
			}
			
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML is :\n" + parser.toString());
			String responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
			JSONObject return_obj = setResponseDataGrid(iformObj,callName,responseXML);
			for (Iterator iterator = return_obj.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				iformObj.addDataToGrid(key, (JSONArray) return_obj.get(key));
			}
			

			String grid_id="MSB_SEARCH_HEADER_GRID";
			String table_name="NG_MSB_SEARCH_CIC_DETAILS_GRID";
			String column_names="CR_NO,ENTITY_NAME_ENG,ENTITY_NAME_AR,UNN,ENTRY_DATE_TIME";
			String field_list="CR Number,Entity Name (Eng),Entity Name (Ar),UNN";
			setDatainDBfromSearchScreenGrid(iformObj,"NG_MSB_CIC_NO",grid_id,table_name,column_names,field_list);
			
			
			return "MSB Search Button results fetched successfully";
	}
	
	
	public String fillTerminalData_SearchScreen(IFormReference iformObj, String callName)
	{
		try
		{
		logger.info("Inside fillterminaldata search screeen function for call Name "+callName);
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String []callnames=callName.split("#");
		String responseXML=createRequestXML(iformObj, callnames[0]);
		
		String restricted_tags=GetXML.getProp().getProperty(callnames[0]+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			responseXML=responseXML.replace(temp,"");
		
		logger.info("Response XML received by setResponseDataGrid is" + responseXML);
		String tagName = "_TagNameResponseGrid"; //Later replace this name
		String tagNames = GetXML.getProp().getProperty(callnames[0] + tagName);
		logger.info(tagNames);
		
		List<String> terminal_id=new ArrayList<>();
		
		String[] tags = tagNames.split("~");
		WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
		logger.info("objWFxmlResponse value is " + objWFxmlResponse);
		
		String statuscode=GetXML.getProp().getProperty(callnames[0]+"_StatusCode");
		String []status_code_split=statuscode.split("~");
			
		if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0], tags[1]);
			logger.info("Wfmxmlsit is --------------" + WFXmlList);
				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) {
						String xyz = WFXmlList.getVal(tags[2]);
						logger.info("terminal values derived is"+xyz);
						terminal_id.add(xyz);
					}
				}
		/*
		terminal_id.add("6380980406806615");
		terminal_id.add("6387717806821579");
		terminal_id.add("6380980606806617");
		terminal_id.add("6387628206821580");
		*/
		logger.info("Termainal ids in list are"+terminal_id);//5588540901933028, 5588541001933029
		
		String cic_number="";	
		if( callnames[0].equalsIgnoreCase("MerchantDtlsInq_OldCIC_SearchScreen"))
		{
			cic_number=getControlValue(iformObj, "MSB_SEARCH_OLD_CIC_NUMBER_2");
		}
		else
		{
			cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
		}
		
		String tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Grid_Terminalwise");
		String delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table is emptied :: "+delete_query);
		
		tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Terminalwise");
		delete_query="DELETE FROM "+tablename+" where CIC= '"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		
		logger.info("With this query table for throuput details is emptied :: "+delete_query);
		
		for(String terminalid:terminal_id)
		{
			logger.info("Inside createRequestXML Function and callName is " + callnames[1]);
			tagName = "_TagName";
			tagNames = GetXML.getProp().getProperty(callnames[1] + tagName);
			
			String header_tags=GetXML.getProp().getProperty(callnames[1]+"_Header");
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
			
			logger.info(tagNames);
			tags = tagNames.split(",");
			
			
			String request_prefix=GetXML.getProp().getProperty(callnames[1]+"_RequestPrefix");
			if(request_prefix.equals(null))
			{
				request_prefix="";
			}
			logger.info("Request prefix is "+request_prefix+"please check");

			String requestXML = readDummyRequest(callnames[1]);
			XMLParser parser = new XMLParser(requestXML);
			
			for (String tag : tags) {
				String tagValue1 = parser.getValueOf(request_prefix+tag);
				logger.info("tagValue is "+tagValue1);
				if(tagValue1.contains("header~"))
				{
					try {
						
					if(tagValue1.split("~")[1].equalsIgnoreCase("UUID"))
					{
						parser.changeValue(request_prefix+tag, java.util.UUID.randomUUID().toString());
					}
					else
					{
					String value=(String) jsonobj_header.get(tagValue1.split("~")[1]);
					logger.info("Value to be replaced by jsonobj_header is "+value);
					parser.changeValue(request_prefix+tag, value);
					}
					}
					catch(Exception e)
					{
						logger.info("Exception is "+e);
					}
				}
				if (tagValue1.startsWith("formid~")) {
					String value = (String) iformObj.getValue(tagValue1.split("~")[1]);
					parser.changeValue(request_prefix+tag, value);
				}
			}
			
			//parser.changeValue(request_prefix+"TerminalID", terminalid); // need to recheck
			parser.changeValue("TerminalNum", terminalid); // need to recheck
		    
			logger.info("Please make sure terminal values are right in this request or not");
			logger.info("RequestXML for MerchantPOSTrxnsSummaryInq_SearchScreen is:\\n" + parser.toString());
			boolean bFound=false;
			responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callnames[1],iformObj);
			String returnResponse=responseXML; // iski functionality check karni hain
			restricted_tags=GetXML.getProp().getProperty(callnames[1]+"_RestrictedTags");
			restricted_values=restricted_tags.split(",");
			for(String temp:restricted_values)
				responseXML=responseXML.replace(temp,"");
			
			logger.info("Response XML received by setResponseDataGrid is" + responseXML);
			tagName = "_TagNameResponseGrid";	
			tagNames = GetXML.getProp().getProperty(callnames[1] + tagName);
			
			logger.info(tagNames);
			String[] tagValue = tagNames.split(",");
			//date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			//cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
			
			String values=" ";
			String query="";
			String columnames="CIC_NO,";
			String insertinto="INSERT INTO ";
			tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Grid_Terminalwise");
			
			//delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
			//iformObj.saveDataInDB(delete_query);
			//logger.info("With this query table is emptied :: "+delete_query);
			
			statuscode=GetXML.getProp().getProperty(callnames[1]+"_StatusCode");
			status_code_split=statuscode.split("~");
			
			
			for(String tag: tagValue)
			{
				tags=tag.split("~");
				objWFxmlResponse = new WFXmlResponse(responseXML);
				logger.info("objWFxmlResponse value is "+objWFxmlResponse);
				
				columnames="CIC_NO,";
				values=" ";
				for(int j=2;j<tags.length;++j)
				{
					String tag_split_values=tags[j];
					logger.info("Tag values split to set column names"+tag_split_values);
					String []hash_split_values=tag_split_values.split("#");
					columnames=columnames+hash_split_values[0]+",";
				}
				
				columnames=columnames+"ENTRY_DATE_TIME, TERMINAL_ID";
				logger.info("column names are"+columnames);
				
				if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
				WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
				logger.info("Wfmxmlsit is --------------"+WFXmlList);
				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) {
				
					values=values+"( '"+cic_number+"',";
					
					for(int j=2;j<tags.length;++j)
					{
						String tag_split_values=tags[j];
						if((!tag_split_values.contains("@")))
						{
							String []hash_split_values=tag_split_values.split("#");
							String result_from_response=WFXmlList.getVal(hash_split_values[1]);
							if(result_from_response== null || result_from_response=="")
							{
								result_from_response=" ";
							}
							else if(hash_split_values[0].equalsIgnoreCase("THROUGHPUT") || hash_split_values[0].equalsIgnoreCase("AVG_TRANSACTN_AMT"))
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
							
							values=values+"'"+result_from_response+"',";
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
					values=values+"'"+date+"','"+terminalid+"'),";
					bFound=true;
				}
				
				if (values.endsWith(",")) {
					values = values.substring(0, values.length() - 1);
				}
				
				logger.info("Final column variables are"+columnames);
				logger.info("values are"+values);
				
				query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
				logger.info("Query for setting response in MerchantPOSTrxnsSummaryInq_SearchScreen_Grid table is"+query);
				iformObj.saveDataInDB(query);	
				
				}
				else
				{
					logger.info("For "+callName+" Status code returned from response is not success ");
				}
				
			}
			
			/*
			logger.info("Setting Customer category based on bfound: "+bFound);
			if(bFound)
			{
				setControlValue(iformObj,"CUSTOMER_CATEGORY","ARB POS Customer");
				logger.info("Setting customer category as : arb pos customer");
				//iformObj.setStyle("UPLOAD_NON_ARB","disable","true");
			} else
			{
				setControlValue(iformObj,"CUSTOMER_CATEGORY","Non POS");
				iformObj.setStyle("UPLOAD_NON_ARB","disable","false");
				logger.info("Setting customer category as : non pos");
			}
			*/
			
			tagName = "_TagNameResponse";
			tagNames = GetXML.getProp().getProperty(callnames[1] + tagName);
			logger.info(tagNames);
			tags = tagNames.split(",");
			
			parser = new XMLParser(responseXML);
			values="( '"+cic_number+"',";
			query="";
			columnames="CIC,";
			insertinto="INSERT INTO ";
			tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Terminalwise");
		
			String tag_value;
			for (String tag : tags) 
			{
				logger.info("Tag =" + tag);
				String[] key = tag.split("~");
				logger.info("Key is "+key[0]);
				if(key[0].contains("#"))
					{
						if(!key[0].contains("@"))
			    		{
							String []parent_child_tags=key[0].split("#");
					    	logger.info("Length of hash String is "+parent_child_tags.length);
					    	String result=responseXML;
					    	for(int i=0;i<parent_child_tags.length;i++)
					    	{
					    		XMLParser internal_parser=new XMLParser(result);
					    		result=internal_parser.getValueOf(parent_child_tags[i]);
					    	}
					    	tag_value=result;
			    		}
						else
						{
							String[] inputTagswithoutRateSign = key[0].split("@");
					    	String []parent_child_tags=inputTagswithoutRateSign[0].split("#");
					    	logger.info("Length of hash String is "+parent_child_tags.length);
					    		String result=responseXML;
					    		for(int i=0;i<parent_child_tags.length;i++)
					    		{
					    			XMLParser internal_parser=new XMLParser(result);
					    			result=internal_parser.getValueOf(parent_child_tags[i]);
					    			logger.info("For "+parent_child_tags[i]+" result is "+result);
					    		}
					    	String internal_query="";
					    	internal_query="(SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y' )";
						    logger.info("Query to replace key with value is"+internal_query);
						    tag_value=internal_query;
						}
					}
					else
					{
						if(!key[0].contains("@"))
						{
							tag_value = parser.getValueOf(key[0]);
						}
						else
						{
							String []inputTagswithoutRateSign=key[0].split("@");
							String result = parser.getValueOf(inputTagswithoutRateSign[0]);
			    			String internal_query="";
			    			
			    			internal_query="(SELECT PARAM_VALUE FROM NG_MAST_POS_TAG_KEY_VALUE_CONFIG WHERE PARAM_KEY='"+result+"' AND TAG_IDENT='"+inputTagswithoutRateSign[1]+"' AND ISACTIVE='Y' )" ;
				    		logger.info("Query to replace key with value is"+internal_query);
				    		tag_value=internal_query;
						}
						
					}
					
					logger.info("Tag Value Derived from ResponseXML is " + tagValue);
					logger.info("Key 2 =" + key[1]);
					if(tag_value.contains("SELECT PARAM_VALUE"))
					{
						values=values+tag_value+",";
					}
					else
					{
					values=values+"'"+tag_value+"',";
					}
					columnames=columnames+key[1]+",";
				}
				
				//Logic to calculate 4 month average
				String newquery="SELECT TOP 4 THROUGHPUT FROM NG_MSB_SEARCH_STMTDATA_CORTEX_DETAIL_GRID WHERE CIC_NO='"+cic_number+"' and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC";// ORDER BY CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC";
				if( callnames[0].equalsIgnoreCase("MerchantDtlsInq_OldCIC_SearchScreen"))
				{
					newquery="SELECT TOP 4 THROUGHPUT FROM NG_MSB_SEARCH_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID WHERE CIC_NO='"+cic_number+"' and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC";// ORDER BY CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC";
				}
				//logger.info("Query to calculate average 4 month balance is "+newquery);
				List<List<String>> top_4_avg= iformObj.getDataFromDB(newquery);	
				
			//	logger.info("Result form newquery is "+top_4_avg+" Its first obejct is "+top_4_avg.get(0));
				double avg_transaction_amt=0;
				if(top_4_avg.size()>0)
				{
					for (Iterator<List<String>> iter = top_4_avg.iterator(); iter.hasNext(); ) {
					    List<String> element = iter.next();
					    if(!element.get(0).equalsIgnoreCase("") && !element.get(0).equalsIgnoreCase(" ") && !element.get(0).equalsIgnoreCase("  "))
					    {
						    avg_transaction_amt=avg_transaction_amt+Double.parseDouble(element.get(0));
					    }   
					}	
				}

				logger.info("avg_transaction_amt is "+avg_transaction_amt);
				columnames=columnames+"AVG_THROUGPUT_LAST_3_MONTH,TOT_THROUGPUT_LAST_3_MONTH,";
				values=values+"'"+String.format("%.2f", avg_transaction_amt/4)+"','"+String.format("%.2f", avg_transaction_amt)+"',";
				//End of Logic to calculate 4 month average
			
				columnames=columnames+"ENTRY_DATE_TIME,TERMINAL_ID";
				values=values+"'"+date+"','"+terminalid+"')";

				query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
				logger.info("Query for setting cortex data in search screen tables is"+query);
				iformObj.saveDataInDB(query);	
				
			
		}
	logger.info("All good in terminal call");
	}
	catch(Exception e)
	{
		logger.info("Exception Occurred: fillTerminalData_SearchScreen and exception is "+e);
	}
	return "Sahdev Kansal returns success";

	}
	
	
	/*
	public String fillTerminalData_SearchScreen(IFormReference iformObj, String callName)
	{
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String []callnames=callName.split("#");
	
		String tagName = "_TagNameResponseGrid"; //Later replace this name
		String tagNames = GetXML.getProp().getProperty(callnames[1] + tagName);
		logger.info(tagNames);
		String responseXML="";
		String returnResponse="";
		List<String> terminal_id=new ArrayList<>();
		
		String[] tags = tagNames.split("~");
		WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
		
		terminal_id.add("All");
		int counter=0,final_counter_4_plus=0,final_counter_zero=0,final_counter_else=0;
		boolean flag=false;
		
		String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");		
		String tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Grid_Terminalwise");
		String delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table is emptied :: "+delete_query);
		
		tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Terminalwise");
		delete_query="DELETE FROM "+tablename+" where CIC= '"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table for throuput details is emptied :: "+delete_query);
		
		for(String terminalid:terminal_id)
		{
			logger.info("Inside createRequestXML Function and callName is " + callnames[1]);
			tagName = "_TagName";
			tagNames = GetXML.getProp().getProperty(callnames[1] + tagName);
			
			String header_tags=GetXML.getProp().getProperty(callnames[1]+"_Header");
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
			
			logger.info(tagNames);
			tags = tagNames.split(",");
			
			
			String request_prefix=GetXML.getProp().getProperty(callnames[1]+"_RequestPrefix");
			if(request_prefix.equals(null))
			{
				request_prefix="";
			}
			logger.info("Request prefix is "+request_prefix+"please check");

			String requestXML = readDummyRequest(callnames[1]);
			XMLParser parser = new XMLParser(requestXML);
			
			for (String tag : tags) {
				String tagValue1 = parser.getValueOf(request_prefix+tag);
				logger.info("tagValue is "+tagValue1);
				if(tagValue1.contains("header~"))
				{
					try {
						
					if(tagValue1.split("~")[1].equalsIgnoreCase("UUID"))
					{
						parser.changeValue(request_prefix+tag, java.util.UUID.randomUUID().toString());
					}
					else
					{
					String value=(String) jsonobj_header.get(tagValue1.split("~")[1]);
					logger.info("Value to be replaced by jsonobj_header is "+value);
					parser.changeValue(request_prefix+tag, value);
					}
					}
					catch(Exception e)
					{
						logger.info("Exception is "+e);
					}
				}
				if (tagValue1.startsWith("formid~")) {
					String value = (String) iformObj.getValue(tagValue1.split("~")[1]);
					parser.changeValue(request_prefix+tag, value);
				}
			}
			
		//	parser.changeValue(request_prefix+"TerminalID", terminalid);
			
			logger.info("Please make sure terminal values are right in this response or not");
			logger.info("RequestXML for MerchantPOSTrxnsSummaryInq_SearchScreen is:\\n" + parser.toString());
			responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callnames[1],iformObj);
			returnResponse=responseXML;
			String restricted_tags=GetXML.getProp().getProperty(callnames[1]+"_RestrictedTags");
			String []restricted_values=restricted_tags.split(",");
			for(String temp:restricted_values)
				responseXML=responseXML.replace(temp,"");
			
			logger.info("Response XML received by setResponseDataGrid is" + responseXML);
			tagName = "_TagNameResponseGrid";
			tagNames = GetXML.getProp().getProperty(callnames[1] + tagName);
			
			logger.info(tagNames);
			
			String insertinto="INSERT INTO ";
			tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Grid_Terminalwise");
			
			String columnames=" ( CIC_NO, TERMINAL_ID,";
			
			//JSONArray jsonArr = new JSONArray();
			//JSONObject jsonObj = null;
			
			ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
			ArrayList<String> singleList = null;//= new ArrayList<String>();

			tags = tagNames.split("~");
			
			columnames=columnames+" ENTRY_DATE_TIME )";
			
			logger.info("column names to be used for query are"+columnames);
			logger.info("tag names are"+tagNames);
			parser = new XMLParser(responseXML);
			
			String statuscode=GetXML.getProp().getProperty(callnames[1]+"_StatusCode");
			
			logger.info("Status code from property file is"+statuscode);
			
			String []status_code_split=statuscode.split("~");
			
			logger.info("After split values are"+status_code_split[0]+""+status_code_split[1]);
			
			String status_code_in_response=parser.getValueOf(status_code_split[0]);
			
			logger.info("Status code in response is "+status_code_in_response+"please confirm"+status_code_split[1]);
			String sValues="";
			boolean bFound=false;
			objWFxmlResponse = new WFXmlResponse(responseXML);
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
			logger.info("Wfmxmlsit is --------------"+WFXmlList);
			logger.info("Wfmxmlsit is --------------"+tags[0]+" "+tags[1]);
			if(status_code_in_response.equalsIgnoreCase(status_code_split[1]))
			{
				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) {
					columnames=" ( CIC_NO, TERMINAL_ID,";
					sValues="('"+cic_number+"','"+terminalid+"',";
					for(int j=2;j<tags.length;++j)
					{
						String tag_split_values=tags[j];
						String []hash_split_values=tag_split_values.split("#");
						sValues=sValues+"'"+WFXmlList.getVal(hash_split_values[1])+"',";
						columnames=columnames+hash_split_values[0]+",";
						
						
					}
					sValues=sValues+"'"+date+"')";
					columnames=columnames+" ENTRY_DATE_TIME )";
					String query=insertinto+tablename+columnames +"VALUES "+sValues;
					logger.info("Your final Query is" + insertinto+tablename+columnames +"VALUES "+sValues);
					iformObj.saveDataInDB(insertinto+tablename+columnames +"VALUES "+sValues);
					bFound=true;
				}
			}
			
			
			if(bFound)
			{
				setControlValue(iformObj,"CUSTOMER_CATEGORY","ARB POS Customer");
				iformObj.setStyle("UPLOAD_NON_ARB","disable","true");
			}
			else
			{
				setControlValue(iformObj,"CUSTOMER_CATEGORY","Non POS");
				iformObj.setStyle("UPLOAD_NON_ARB","disable","false");
			}
			
			
			
		}
		
		
				return returnResponse;

	}
	*/

	
	public String fillTerminalData_SearchScreen_old(IFormReference iformObj, String callName)
	{
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String []callnames=callName.split("#");
		String responseXML=createRequestXML(iformObj, callnames[0]);
		
		String restricted_tags=GetXML.getProp().getProperty(callnames[0]+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			responseXML=responseXML.replace(temp,"");
		
		logger.info("Response XML received by setResponseDataGrid is" + responseXML);
		String tagName = "_TagNameResponseGrid"; //Later replace this name
		String tagNames = GetXML.getProp().getProperty(callnames[0] + tagName);
		logger.info(tagNames);
		
		List<String> terminal_id=new ArrayList<>();
		
		String[] tags = tagNames.split("~");
		WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
		logger.info("objWFxmlResponse value is " + objWFxmlResponse);
		
		String statuscode=GetXML.getProp().getProperty(callnames[0]+"_StatusCode");
		String []status_code_split=statuscode.split("~");
			
		if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0], tags[1]);
			logger.info("Wfmxmlsit is --------------" + WFXmlList);
				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) {
						String xyz = WFXmlList.getVal(tags[2]);
						logger.info("terminal values derived is"+xyz);
						terminal_id.add(xyz);
					}
				}
		logger.info("Termainal ids in list are"+terminal_id);//5588540901933028, 5588541001933029
		
		int counter=0,final_counter_4_plus=0,final_counter_zero=0,final_counter_else=0;
		boolean flag=false;
		
		String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");		
		String tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Grid");
		String delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table is emptied :: "+delete_query);
		
		tablename=GetXML.getProp().getProperty(callnames[1]+"_Table");
		delete_query="DELETE FROM "+tablename+" where CIC= '"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table for throughput details is emptied :: "+delete_query);
		
		for(String terminalid:terminal_id)
		{
			logger.info("Inside createRequestXML Function and callName is " + callnames[1]);
			tagName = "_TagName";
			tagNames = GetXML.getProp().getProperty(callnames[1] + tagName);
			
			String header_tags=GetXML.getProp().getProperty(callnames[1]+"_Header");
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
			
			logger.info(tagNames);
			tags = tagNames.split(",");
			
			
			String request_prefix=GetXML.getProp().getProperty(callnames[1]+"_RequestPrefix");
			if(request_prefix.equals(null))
			{
				request_prefix="";
			}
			logger.info("Request prefix is "+request_prefix+"please check");

			String requestXML = readDummyRequest(callnames[1]);
			XMLParser parser = new XMLParser(requestXML);

			for (String tag : tags) {
				String tagValue1 = parser.getValueOf(request_prefix+tag);
				logger.info("tagValue is "+tagValue1);
				if(tagValue1.contains("header~"))
				{
					try {
						
					if(tagValue1.split("~")[1].equalsIgnoreCase("UUID"))
					{
						parser.changeValue(request_prefix+tag, java.util.UUID.randomUUID().toString());
					}
					else
					{
					String value=(String) jsonobj_header.get(tagValue1.split("~")[1]);
					logger.info("Value to be replaced by jsonobj_header is "+value);
					parser.changeValue(request_prefix+tag, value);
					}
					}
					catch(Exception e)
					{
						logger.info("Exception is "+e);
					}
				}
				if (tagValue1.startsWith("formid~")) {
					String value = (String) iformObj.getValue(tagValue1.split("~")[1]);
					parser.changeValue(request_prefix+tag, value);
				}
			}
			
			parser.changeValue(request_prefix+"TerminalNum", terminalid);
			
			logger.info("Please make sure terminal values are right in this response or not");
			logger.info("RequestXML for MerchantPOSTrxnsSummaryInq_SearchScreen is:\\n" + parser.toString());
			responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callnames[1],iformObj);

			restricted_tags=GetXML.getProp().getProperty(callnames[1]+"_RestrictedTags");
			restricted_values=restricted_tags.split(",");
			for(String temp:restricted_values)
				responseXML=responseXML.replace(temp,"");
			
			logger.info("Response XML received by setResponseDataGrid for MerchantPOSTrxnsSummaryInq_SearchScreen is"+responseXML);
			tagName = "_TagNameResponseGrid";
		    tagNames = GetXML.getProp().getProperty(callnames[1] + tagName);
			
			logger.info(tagNames);
			String[] tagValue = tagNames.split(",");
			
			date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
			
			String values=" ";
			String query="";
			String columnames="CIC_NO,";
			String insertinto="INSERT INTO ";
			tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Grid_Terminalwise");
			
			delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
			iformObj.saveDataInDB(delete_query);
			logger.info("With this query table is emptied :: "+delete_query);
			
			statuscode=GetXML.getProp().getProperty(callnames[1]+"_StatusCode");
			status_code_split=statuscode.split("~");
			
			
			for(String tag: tagValue)
			{
				tags=tag.split("~");
				objWFxmlResponse = new WFXmlResponse(responseXML);
				logger.info("objWFxmlResponse value is "+objWFxmlResponse);
				
				columnames="CIC_NO,";
				values=" ";
				for(int j=2;j<tags.length;++j)
				{
					String tag_split_values=tags[j];
					logger.info("Tag values split to set column names"+tag_split_values);
					String []hash_split_values=tag_split_values.split("#");
					columnames=columnames+hash_split_values[0]+",";
				}
				
				columnames=columnames+"ENTRY_DATE_TIME, TERMINAL_ID";
				logger.info("column names are"+columnames);
				
				if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
				WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
				logger.info("Wfmxmlsit is --------------"+WFXmlList);
				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) {
				
					values=values+"( '"+cic_number+"',";
					
					for(int j=2;j<tags.length;++j)
					{
						String tag_split_values=tags[j];
						if((!tag_split_values.contains("@")))
						{
							String []hash_split_values=tag_split_values.split("#");
							String result_from_response=WFXmlList.getVal(hash_split_values[1]);
							if(result_from_response== null || result_from_response=="")
							{
								result_from_response=" ";
							}
							values=values+"'"+result_from_response+"',";
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
					values=values+"'"+date+"','"+terminalid+"'),";
				}
				
				if (values.endsWith(",")) {
					values = values.substring(0, values.length() - 1);
				}
				
				logger.info("Final column variables are"+columnames);
				logger.info("values are"+values);
				
				query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
				logger.info("Query for setting response in MerchantPOSTrxnsSummaryInq_SearchScreen_Grid table is"+query);
				iformObj.saveDataInDB(query);	
				
				}
				else
				{
					logger.info("For "+callName+" Status code returned from response is not success ");
				}
				
			}
			
			parser = new XMLParser(responseXML);
			tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Terminalwise");
			delete_query="DELETE FROM "+tablename+" where CIC= '"+cic_number+"' ";
			iformObj.saveDataInDB(delete_query);
			logger.info("With this query table is emptied :: "+delete_query);
			
			//setResponseDataSearchScreen(iformObj,callnames[1],responseXML);
			String tagNamesresponse = "_TagNameResponse";
			String tagNamesResponse = GetXML.getProp().getProperty(callnames[1] + tagNamesresponse);
			tags = tagNamesResponse.split(",");
			values="( '"+cic_number+"',";
			query="";
			columnames="CIC,";
			insertinto="INSERT INTO ";
			
			for (String tag : tags) {
			
				logger.info("Tag =" + tag);
				String[] key = tag.split("~");
				logger.info("Key is " +key[0]);
				String temp = parser.getValueOf(key[0]);
				logger.info("Tag Value Derived from ResponseXML is " + temp);
				logger.info("Key 2 =" + key[1]);
				
				values=values+"'"+temp+"',";
				columnames=columnames+key[1]+",";
			}
			

			query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
			logger.info("Query for calculating throughput details is"+query);
			iformObj.saveDataInDB(query);			
			}
		
			return "fillTerminalData_SearchScreen saved successfully";
		}

	public String fillTerminalData_allmachines_SearchScreen(IFormReference iformObj,String callName)
	{
		
	try
	{
		logger.info("Filling terminal data for all machines");
		//String callName="MerchantPOSTrxnsSummaryInq_SearchScreen";
		String responseXML="";// createRequestXML(iformObj, callName);
		
		//Start
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
					try {
						
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
				if (tagValue.startsWith("formid~")) {
					String value = (String) iformObj.getValue(tagValue.split("~")[1]);
					parser.changeValue(request_prefix+tag, value);
				}
				
			}
			
			
			//parser.changeValue(request_prefix+"TerminalID",""); // need to recheck
			//parser.changeValue("TerminalNum","");
			System.out.println("RequestXML is :\n" + parser.toString());
			String Request=parser.toString();
			Request=Request.replaceAll("<TerminalNum>[a-zA-Z0-9]*</TerminalNum>","");
			logger.info("RequestXML  :\n" + Request);
			responseXML = new SocketConnector().getSocketXMLResponse(Request, callName,iformObj);
	
			System.out.println("Response XML is: \n" + responseXML);
			//logger.info("Response XML is: \n" + responseXML);

		}catch(Exception e)
		{
			logger.info("Exception occurred: createRequestXML "+e);
		
		}
		//End
	
		logger.info("Make sure terminal id is null here "+responseXML);
		setResponseDataGridSearchScreen(iformObj, callName, responseXML);
		boolean bFound=false;
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			responseXML=responseXML.replace(temp,"");
		
		String tagName = "_TagNameResponse";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		logger.info(tagNames);
		String[] tags = tagNames.split(",");
 
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		

		String cic_number="";
		if( callName.equalsIgnoreCase("MerchantPOSTrxnsSummaryInq_OldCIC_SearchScreen") )
		{
			cic_number=getControlValue(iformObj, "MSB_SEARCH_OLD_CIC_NUMBER_2");
		}
		else
		{
			cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
		}
		XMLParser parser = new XMLParser(responseXML);
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
			for (String tag : tags) 
			{
				logger.info("Tag =" + tag);
				String[] key = tag.split("~");
				logger.info("Key is "+key[0]);
				if(key[0].contains("#"))
				{
					if(!key[0].contains("@"))
		    		{
						String []parent_child_tags=key[0].split("#");
				    	logger.info("Length of hash String is "+parent_child_tags.length);
				    	String result=responseXML;
				    	for(int i=0;i<parent_child_tags.length;i++)
				    	{
				    		XMLParser internal_parser=new XMLParser(result);
				    		result=internal_parser.getValueOf(parent_child_tags[i]);
				    	}
				    	tagValue=result;
		    		}
					else
					{
						String[] inputTagswithoutRateSign = key[0].split("@");
				    	String []parent_child_tags=inputTagswithoutRateSign[0].split("#");
				    	logger.info("Length of hash String is "+parent_child_tags.length);
				    		String result=responseXML;
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
				
				tagValue=tagValue.replace("'","''");
				logger.info("Tag Value Derived from ResponseXML is " + tagValue);
				logger.info("Key 2 =" + key[1]);
				if(tagValue.contains("SELECT PARAM_VALUE"))
				{
					values=values+tagValue+",";
				}
				else
				{
				values=values+"'"+tagValue+"',";
				}
				columnames=columnames+key[1]+",";
				bFound=true;
			}
			
			//Logic to calculate 4 month average
			String newquery="SELECT TOP 4 THROUGHPUT FROM NG_MSB_SEARCH_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE CIC_NO='"+cic_number+"' and cortex_month<>'' AND CORTEX_MONTH<>'0' ORDER BY convert(date,'01/'+CORTEX_MONTH,103) DESC";//CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC";
			if( callName.equalsIgnoreCase("MerchantPOSTrxnsSummaryInq_OldCIC_SearchScreen") )
			{
				newquery="SELECT TOP 4 THROUGHPUT FROM NG_MSB_SEARCH_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE CIC_NO='"+cic_number+"' and cortex_month<>'' AND CORTEX_MONTH<>'0' ORDER BY convert(date,'01/'+CORTEX_MONTH,103) DESC";//CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC";
			}
			logger.info("Query to calculate average 4 month balance is "+newquery);
			List<List<String>> top_4_avg= iformObj.getDataFromDB(newquery);	
			
			logger.info("Result form newquery is "+top_4_avg+" Its first obejct is "+top_4_avg.get(0));
			double tot_transaction_amt=0;
			if(top_4_avg.size()>0)
			{
				for (Iterator<List<String>> iter = top_4_avg.iterator(); iter.hasNext(); ) 
				{
				    List<String> element = iter.next();
				    if(!element.get(0).equalsIgnoreCase("") && !element.get(0).equalsIgnoreCase(" ") && !element.get(0).equalsIgnoreCase("  "))
				    {
				    	tot_transaction_amt=tot_transaction_amt+Double.parseDouble(element.get(0));
				    	logger.info("Individual avg_transaction amoutn for 4 months is "+element+" and sum is "+tot_transaction_amt );    
				    }
				}	
			}
			logger.info("Total Transaction_amt is "+tot_transaction_amt);
			columnames=columnames+"AVG_THROUGPUT_LAST_3_MONTH,TOT_THROUGPUT_LAST_3_MONTH,";
			values=values+"'"+String.format("%.2f", tot_transaction_amt/4)+"','"+String.format("%.2f", tot_transaction_amt)+"',";
			//End of Logic to calculate 4 month average
		
			columnames=columnames+"ENTRY_DATE_TIME";
			values=values+"'"+date+"')";

			query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
			logger.info("Query for setting cortex data in search screen tables is"+query);
			iformObj.saveDataInDB(query);	

		}
		else
		{
			logger.info("For "+callName+" Status code returned from response is not success ");
		}
	
		
		
		/*if(bFound==true)
		{
			setControlValue(iformObj,"CUSTOMER_CATEGORY","ARB POS Customer");
			//iformObj.setStyle("UPLOAD_NON_ARB","disable","true"); // Temporarily commenting it
		}*/
	}
	catch(Exception e)
	{
		logger.info("Exception Occurred:: fillTerminalData_allmachines_SearchScreen and exception is "+e);
	}
		return "";
	}
	/*
	private String uploadNonARB(IFormReference iformObj, String stringdsata) {

		//String delete_query="DELETE FROM NG_MSB_PREVIOUS_APPLICATION_GRID";
	    //iformObj.saveDataInDB(delete_query);
		 
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		JSONArray previousApplicationDataGrid = iformObj.getDataFromGrid("PREVIOUS_APP_GRID");
		logger.info(previousApplicationDataGrid);
	
		String table_name="NG_MSB_SEARCH_PREVIOUS_APPLICATION_GRID";
		String query="INSERT INTO ";
		String column_names="SERIAL_NO,APPLICATION_NO,CIC_NO,CURRENT_STATUS,CUSTOMER_CATEGORY,CAMPAIGN,LIMIT_NUMBER,LIMIT_AMOUNT,LOAN_AMOUNT,PRODUCT,PRODUCT_CATEGORY,ENTRY_DATE_TIME";
		logger.info("Column names are"+column_names);
		query=query+table_name+"("+column_names+") ";
		String result="VALUES (";
		String field_list="S. No,Application No,CIC No,Current Status,Customer Category,Campaign,Limit Number,Limit Amount,Loan Amount,Product,Product Category";
		String field_list_array[]=field_list.split(",");

		Iterator iterator = previousApplicationDataGrid.iterator();
		while (iterator.hasNext()) {
			JSONObject slide = (JSONObject) iterator.next();
			
			for(int i=0;i<field_list_array.length;i++)
			{
				result=result+"'"+slide.get(field_list_array[i])+"',";
			}
			
			result=result+"'"+date+"'),(";
		  
		}
		
		result=result.substring(0,result.length()-2);
		query=query+result;
	    logger.info("Query for inserting data from search screen into grid is "+query);
	    iformObj.saveDataInDB(query);
	    
		return "All ok";
	}
	*/
	private void setDatainDBfromSearchScreenGrid(IFormReference iformObj,String cic_no_id,String grid_id,String table_name,String column_names,String field_list )
	{
		try 
		{
		String cic_number=getControlValue(iformObj, cic_no_id);
		String delete_query="DELETE FROM "+table_name+" WHERE CIC_NO='"+cic_number+"' ";
		iformObj.saveDataInDB(delete_query);
		
		
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		JSONArray DataGrid = iformObj.getDataFromGrid(grid_id);
		logger.info(DataGrid);
		
		//String table_name="NG_MSB_SEARCH_PREVIOUS_APPLICATION_GRID";
		String query="INSERT INTO ";
		//String column_names="SERIAL_NO,APPLICATION_NO,CIC_NO,CURRENT_STATUS,CUSTOMER_CATEGORY,CAMPAIGN,LIMIT_NUMBER,LIMIT_AMOUNT,LOAN_AMOUNT,PRODUCT,PRODUCT_CATEGORY,ENTRY_DATE_TIME";
		logger.info("Column names are"+column_names);
		query=query+table_name+"( CIC_NO ,"+column_names+") ";
		String result="VALUES ";
		//String field_list="S. No,Application No,CIC No,Current Status,Customer Category,Campaign,Limit Number,Limit Amount,Loan Amount,Product,Product Category";
		String field_list_array[]=field_list.split(",");
		Iterator iterator = DataGrid.iterator();
		while (iterator.hasNext()) 
		{
			JSONObject slide = (JSONObject) iterator.next();
			result=result+"('"+cic_number+"',";
			for(int i=0;i<field_list_array.length;i++)
			{
				result=result+"N'"+ ((String) slide.get(field_list_array[i])).trim()+"',";
			}
			
			result=result+"'"+date+"'),";
		  
		}
		
		result=result.substring(0,result.length()-1);
		query=query+result;
	    logger.info("Query for inserting data for table "+table_name+" into grid is "+query);
	    if(result.contains("VALUES")) // Always true, just using for safety
	    {
	    	if(result.split("VALUES")[1].trim()!="")
	    		iformObj.saveDataInDB(query);
	    }
		}
		catch(Exception e)
		{
			logger.info("Exception OCcurred: setDatainDBfromSearchScreenGrid "+e);
		}
	}

	@Override
	public String generateHTML(EControl arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomFilterXML(FormDef arg0, IFormReference arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String introduceWorkItemInWorkFlow(IFormReference arg0, HttpServletRequest arg1, HttpServletResponse arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String introduceWorkItemInWorkFlow(IFormReference arg0, HttpServletRequest arg1, HttpServletResponse arg2,
			WorkdeskModel arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setMaskedValue(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg1;
	}

	@Override
	public void updateDataInWidget(IFormReference arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public String validateDocumentConfiguration(String arg0, String arg1, File arg2, Locale arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray validateSubmittedForm(FormDef arg0, IFormReference arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
