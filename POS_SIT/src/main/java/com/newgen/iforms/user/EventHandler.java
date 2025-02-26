package com.newgen.iforms.user;

import java.io.File;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;

import com.newgen.iforms.EControl;
import com.newgen.iforms.FormDef;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;
import com.newgen.mvcbeans.model.WorkdeskModel;
import com.newgen.mvcbeans.model.wfobjects.WDGeneralData;

public class EventHandler extends POSCommon implements IFormServerEventHandler {
	


	//protected static IFormReference iFormOBJECT;
	protected String sessionId="";
	
	protected WDGeneralData wdgeneralObj;
	Logger logger = Logger.getLogger(POSCommon.class);
	
	@Override
	public void beforeFormLoad(FormDef arg0, IFormReference arg1) 
	{
	}

	@Override
	public String executeCustomService(FormDef arg0, IFormReference arg1,
			String arg2, String arg3, String arg4) 
	{
		return null;
	}

	@Override
	public JSONArray executeEvent(FormDef arg0, IFormReference arg1,String arg2, String arg3) 
	{
		return null;
	}

	
	public String executeServerEvent(IFormReference iformObj, String control,String event, String Stringdata) 
	{	
		logger.info("Inside executeServerEvent() ak 107 ---control: " + control + "\nevent: " + event + "\nStringdata" +Stringdata);
		logger.info("Inside ---control12: " + control + "\nevent: " + event + "\nStringdata" +Stringdata);
		wdgeneralObj = iformObj.getObjGeneralData();
		sessionId = wdgeneralObj.getM_strDMSSessionId();
		//iFormOBJECT = iformObj;
		event = event.toUpperCase();
		switch(event)
		{
		case "ONLOAD" : return new POS_FormLoad().onLoad(iformObj, control, Stringdata);
		case "" 	 : return new StringDataHandler().stringHandler(iformObj, control, Stringdata);
		case "CLICK" 	 : return new StringDataHandler().stringHandler(iformObj, control, Stringdata);
		default		 : return "unhandled event";
		}
	}

	@Override
	public String getCustomFilterXML(FormDef arg0, IFormReference arg1,String arg2) 
	{
		return null;
	}

	@Override
	public String setMaskedValue(String arg0, String arg1)
	{ 
		try
		{
				if((arg0.equalsIgnoreCase("Q_NG_POS_APPLICATION_DATA_TOTAL_PROFIT")|| arg0.equalsIgnoreCase("Q_NG_POS_APPLICATION_DATA_EFFECTIVE_RATE") ||
						arg0.equalsIgnoreCase("Q_NG_POS_APPLICATION_DATA_APR")|| arg0.equalsIgnoreCase("Q_NG_POS_APPLICATION_DATA_INSTALLMENT_AMNT")||
						arg0.equalsIgnoreCase("Q_NG_POS_DISBURSAL_DATA_TOTAL_PROFIT")|| arg0.equalsIgnoreCase("Q_NG_POS_DISBURSAL_DATA_EFFECTIVE_RATE")||
						arg0.equalsIgnoreCase("Q_NG_POS_DISBURSAL_DATA_APR_PER")|| arg0.equalsIgnoreCase("Q_NG_POS_DISBURSAL_DATA_INSTALMENT_AMT")||
						arg0.equalsIgnoreCase("Q_NG_DIS_COMMODITY_PURCHASE_UNIT_PRICE")|| arg0.equalsIgnoreCase("Q_NG_DIS_COMMODITY_PURCHASE_AMOUNT_SAR")||
						arg0.equalsIgnoreCase("Q_NG_DIS_COMMODITY_PURCHASE_QTY")) && arg1!=null && arg1!="" && arg1.length()>0 )
			{
					logger.info("Inside setMaskedValue: For "+arg0+" initial value is "+arg1);
			if(arg1.contains("."))
			{
			arg1=arg1.substring(0,arg1.indexOf(".")+3);
				logger.info("setMaskedValue: For "+arg0+" we are setting value "+arg1);
			}
			else
			{
				arg1=arg1+".00";
			}
			}
		}
		catch(Exception e)
		{
			logger.info("inside setMaskedValue method ############ ", e);
		}
		return arg1;
	}

	@Override
	public JSONArray validateSubmittedForm(FormDef arg0, IFormReference arg1,
			String arg2) 
	{
		return null;
	}

	@Override
	public String generateHTML(EControl arg0) {
		// TODO Auto-generated method stub
		return null;
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
	public String introduceWorkItemInWorkFlow(IFormReference arg0,
			HttpServletRequest arg1, HttpServletResponse arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String introduceWorkItemInWorkFlow(IFormReference arg0,
			HttpServletRequest arg1, HttpServletResponse arg2,
			WorkdeskModel arg3) {
		// TODO Auto-generated method stub
		return null;
	}
}
