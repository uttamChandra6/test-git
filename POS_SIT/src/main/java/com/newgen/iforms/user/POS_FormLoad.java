package com.newgen.iforms.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.newgen.iforms.custom.IFormReference;

public class POS_FormLoad extends POSCommon {

	private static final String EXCEPTION_OCCURED = null;
	private static final String UNHANDLED = null;
	private static final String SUCCESS = null;
	private static final String FAIL = null;
	Logger logger = Logger.getLogger(POS_FormLoad.class);

	public String onLoad(IFormReference iformObj, String control, String stringdata) {

		// ashutosh-start-28-sept

		logger.info("inside ON load method@@");

		if (control.equalsIgnoreCase("document_table")) {
			logger.info("inside if block@@@ashu");
			return mandatorydocumentupload(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("redirectwi")) {
			logger.info("inside if block@@@Vik");
			return workitemtime(iformObj, stringdata);
		}

		return "onload worked fine";

	}
	
	private String workitemtime(IFormReference iformobj, String Stringdata) {
		 String wiDTime ="No_data_Found";
		try 
	    {
			logger.info("inside worktiem redirect ****"+ Stringdata);
	    	String winame = getWorkitemName(iformobj);
	    	String wsname=iformobj.getActivityName();
	    	String query = "SELECT ENTRYDATE FROM NG_POS_EXTTABLE WHERE CURR_WSNAME='"+wsname+"' and WI_NAME='"+winame+"'";
	    	logger.info("query is @@-----" + query);
	    	List<List<String>> dateresult = iformobj.getDataFromDB(query);
	        logger.info("dateresult is @@-----" + dateresult);
	       
	        
	        if(dateresult.size() > 0)
	         wiDTime = dateresult.get(0).get(0);
	        
	    }
		catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			logger.info("please check code again####", e);
	     }
		return wiDTime;
	}

	public String mandatorydocumentupload(IFormReference iformobj, String Stringdata) 
	{

        try 
        {
        logger.info("insidemandatorydocumentupload@@ashu");
        String winame = getWorkitemName(iformobj);
        String wsname=iformobj.getActivityName();
        String data = "SELECT DOCUMENT_NAME, DOCUMENT_EXP_DATE ,MANDATORY,UPLOAD_STATUS,UPLOAD_DATE_TIME FROM NG_POS_DOCUMENT_GRID where WI_NAME='" + winame + "' ";
        logger.info("query is @@-----" + data);

        List<List<String>> dataresult = iformobj.getDataFromDB(data);
        logger.info("dataresult is @@-----" + dataresult);
        
        String disbursal_amount_string=(String)iformobj.getValue("Q_NG_POS_DISBURSAL_DATA_DISBURSAL_AMT");
        double disbursal_amount=0;
        try
        {
        	disbursal_amount=Double.parseDouble(disbursal_amount_string);
        }
        catch(Exception e)
        {
        	disbursal_amount=0;
        }
        
        logger.info("Disbursal amount is "+disbursal_amount);
        
        String query ="";
        if(getActivityName(iformobj).equalsIgnoreCase("PQ1 without SIMAH"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,PQ1_WITHOUT_SIMAH FROM NG_MAST_DOCUMENT WHERE PQ1_WITHOUT_SIMAH IN ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("PQ2 with SIMAH"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,PQ2_WITH_SIMAH FROM NG_MAST_DOCUMENT WHERE PQ1_WITHOUT_SIMAH NOT IN ('Yes','No') and PQ2_WITH_SIMAH in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Sales Rework") || getActivityName(iformobj).equalsIgnoreCase("Reapproval"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,sales_rework FROM NG_MAST_DOCUMENT WHERE PQ2_WITH_SIMAH NOT IN ('Yes','No') and sales_rework in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Team Leader") || getActivityName(iformobj).equalsIgnoreCase("Branch Manager"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,business_approval FROM NG_MAST_DOCUMENT WHERE business_approval in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Credit Officer"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,credit_officer_approval FROM NG_MAST_DOCUMENT WHERE business_approval NOT IN ('Yes','No') and credit_officer_approval in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Supervisor Credit 1") || getActivityName(iformobj).equalsIgnoreCase("Supervisor Credit 2"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,credit_approval FROM NG_MAST_DOCUMENT WHERE credit_officer_approval NOT IN ('Yes','No') and credit_approval in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Approved Sales"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,approved_case FROM NG_MAST_DOCUMENT WHERE credit_approval NOT IN ('Yes','No') and approved_case in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Disbursal_Initiate"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,disbursment_initiate FROM NG_MAST_DOCUMENT WHERE approved_case NOT IN ('Yes','No') and disbursment_initiate in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Buy_and_Contract"))
        {
               //query = "SELECT DOCUMENT_NAME,buy_and_contract FROM NG_MAST_DOCUMENT WHERE disbursment_initiate NOT IN ('Yes','No') and buy_and_contract in ('Yes','No') and ISACTIVE='Y'";
             query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,iif((select COUNT(1) from NG_POS_RELATED_PARTY_ROLES_GRID where PERSONAL_GUARANTEE='true' and PARTY_TYPE='Company' and wi_name='"+winame+"')>0 and DOCUMENT_NAME='Corporate Guarantee','Yes',buy_and_contract) FROM NG_MAST_DOCUMENT WHERE disbursment_initiate NOT IN ('Yes','No') and buy_and_contract in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Physical_Delivery_Review"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,physical_delivery FROM NG_MAST_DOCUMENT WHERE buy_and_contract NOT IN ('Yes','No') and physical_delivery in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Deliver_Commodity"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,Deliver_Commodity FROM NG_MAST_DOCUMENT WHERE buy_and_contract NOT IN ('Yes','No') and Deliver_Commodity in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Sell_and_Stipulation_Maker") && disbursal_amount<=1000000)
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,sell_and_stipulate FROM NG_MAST_DOCUMENT WHERE buy_and_contract NOT IN ('Yes','No') and sell_and_stipulate in ('Yes','No') and ISACTIVE='Y'";
        }
        else if(getActivityName(iformobj).equalsIgnoreCase("Stipulation_and_Sell_Checker"))
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,sell_and_stipulate FROM NG_MAST_DOCUMENT WHERE buy_and_contract NOT IN ('Yes','No') and sell_and_stipulate in ('Yes','No') and ISACTIVE='Y'";
        }
        else
        {
               query = "SELECT DOCUMENT_NAME,DOCUMENT_NAME_AR,sell_and_stipulate FROM NG_MAST_DOCUMENT WHERE 1<>1";
        }
        logger.info("query is @@-----" + query);
        List<List<String>> result = iformobj.getDataFromDB(query);
        logger.info("result is @@-----" + result);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = null;
        if(dataresult.isEmpty() || dataresult==null)
        {
        

        for (List<String> value : result) {

               jsonObject = new JSONObject();
               logger.info("inside for loop ashu@@@");
               jsonObject.put("Document Name", value.get(0).trim());
               jsonObject.put("Mandatory", value.get(2));
               jsonObject.put("Document Name (Arabic)", value.get(1));
               jsonArray.add(jsonObject);

               logger.info("jason array ashu@@@@" + jsonArray);
        }
               iformobj.addDataToGrid("document_table", jsonArray);
        } 
               else 
               {
                     
                     
                     for (List<String> value : result) {
                            String document_name_main="";
                            String document_name_mast="";
                            boolean match_Found=false;
             
                            document_name_mast=value.get(0);
                            logger.info("Checking Master document name == "+document_name_mast);
                            for (List<String> valueMain : dataresult) {
                                   
                                   document_name_main=valueMain.get(0);
                                   logger.info("Main document name == "+document_name_main);
                                   if(document_name_main.trim().equalsIgnoreCase(document_name_mast.trim()))
                                   {
                                          logger.info("Inside match found condition main doc name==="+document_name_main+" master doc name ==== "+document_name_mast);
                                          match_Found=true;
                                          break;
                                   }
                            }
                            if(!match_Found)
                            {
                                   jsonObject = new JSONObject();
                                   jsonArray.clear();
                                   logger.info("inside not match found condition addinf document in grid");
                                   jsonObject.put("Document Name", value.get(0).trim());
                                   logger.info("inside not match found condition addinf document in grid document name === "+value.get(0));
                                   jsonObject.put("Mandatory", value.get(2));
                                   logger.info("inside not match found condition addinf document in grid mandatory ==== "+value.get(1));
                                   jsonObject.put("Document Name (Arabic)", value.get(1));
                                   jsonArray.add(jsonObject);
                                   iformobj.addDataToGrid("document_table", jsonArray);
                            }
                     
                     }
                     
                     
                     /*
                     * String docgridupdate="Update NG_POS_DOCUMENT_GRID set DOCUMENT_NAME='"+
                     * dataresult.get(0)+"' , DOCUMENT_EXP_DATE='"+dataresult.get(1)+"',MANDATORY='"
                     * +dataresult.get(2)+"',UPLOAD_STATUS='"+dataresult.get(3)+
                     * "',UPLOAD_DATE_TIME='"+dataresult.get(4)+"' where WI_NAME='" + winame + "' ";
                     * logger.info("ashu@@@@@"+docgridupdate);
                     */
               }
        }
        catch (Exception e) {
               // TODO: handle exception
        e.getMessage();
        logger.info("please check code again####", e);
        }
        
        return "successfully added to document grid";
 }
	// ashutosh-end-28-sept
}
