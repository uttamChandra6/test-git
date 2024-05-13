package com.newgen.iforms.user;

import com.newgen.workstep.POS_Search;

import ISPack.CPISDocumentTxn;
import ISPack.ISUtil.JPDBRecoverDocData;
import ISPack.ISUtil.JPISException;
import ISPack.ISUtil.JPISIsIndex;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
//SK
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;

import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.xmlapi.IFormCallBroker;
import com.newgen.integration.GetXML;
import com.newgen.integration.SocketConnector;
import com.newgen.mvcbeans.model.wfobjects.WDGeneralData;
import com.newgen.omni.jts.cmgr.XMLParser;
import com.newgen.omni.wf.util.app.NGEjbClient;
import com.newgen.omni.wf.util.excp.NGException;
import com.newgen.util.NumberToArabic;
import com.newgen.wfdesktop.xmlapi.WFXmlList;
import com.newgen.wfdesktop.xmlapi.WFXmlResponse;

import org.json.JSONException;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class StringDataHandler extends POSCommon {
	Logger logger = Logger.getLogger(StringDataHandler.class);
	
	public static final String AMPTAG="#amp#";

	public String stringHandler(IFormReference iformObj, String control, String stringdata) 
	{
		logger.info("inside stringHandler method @@@@@");
		String callName = "";
		String responseXML;
		boolean SetPQList_flag=false;
		// Logger.getLogger() 
		if (control.equalsIgnoreCase("setRoutingLevel")) {
			logger.info("Inside stringHandler function");
			String returnValue="";
			returnValue=setRoutingLevel(iformObj, "Branch");
			returnValue=setRoutingLevel(iformObj, "Credit Officer");
			return returnValue;
		} else if (control.equalsIgnoreCase("AddToDecisionHistoryGrid")) {
			logger.info("inside Decision function choice");
			return addToDecisionHistoryGrid(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("refreshCreditlIne")) 
		{
			logger.info("inside refreshCreditlIne choice");
			return refreshCreditlIne(iformObj, stringdata); 
		}
		else if (control.equalsIgnoreCase("callReapprovalProc")) 
		{
			logger.info("inside callReapprovalProc choice");
			return callReapprovalProc(iformObj, stringdata); 
		}
		else if (control.equalsIgnoreCase("fillTerminalData_AfterApplicationCreation")) 
		{
			logger.info("inside fillTerminalData_AfterApplicationCreation choice");
			return fillTerminalData_AfterApplicationCreation(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("fillTerminalData_AfterApplicationCreation_OldCIC")) 
		{
			logger.info("inside fillTerminalData_AfterApplicationCreation_OldCIC choice");
			return fillTerminalData_AfterApplicationCreation_OldCIC(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("submitForReapproval")) 
		{
			logger.info("inside submitForReapproval choice");
			return submitForReapproval(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("dataTansferForReapproval")) 
		{
			logger.info("inside dataTansferForReapproval choice");
			return dataTansferForReapproval(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("updateLimitAfterReapproval")) 
		{
			logger.info("inside updateLimitAfterReapproval choice");
			return updateLimitAfterReapproval(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("fillStatementAnalysisDetails_PQ1")) 
		{
			logger.info("inside fillStatementAnalysisDetails_PQ1n choice");
			return fillStatementAnalysisDetails_PQ1(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("SetConditionPrecedent")) 
		{
			logger.info("inside SetConditionPrecedent handling");
			return SetConditionPrecedent(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("ConditionPrecedentValidationCheck")) 
		{
			logger.info("inside ConditionPrecedentValidationCheck handling");
			return ConditionPrecedentValidationCheck(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("RelatedPartyCityArabicToEnglish")) 
		{
			logger.info("inside RelatedPartyCityArabicToEnglish function");
			return RelatedPartyCityArabicToEnglish(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("brokerFeeWaiveOff")) 
		{
			logger.info("inside brokerFeeWaiveOffn function");
			return brokerFeeWaiveOff(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("updateAccountDataAfterApplicationCreation")) 
		{
			logger.info("inside updateAccountDataAfterApplicationCreation function");
			return updateAccountDataAfterApplicationCreation(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("updateAccountDataAfterApplicationCreation_oldCIC")) 
		{
			logger.info("inside updateAccountDataAfterApplicationCreation_oldCIC function");
			return updateAccountDataAfterApplicationCreation_oldCIC(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("fetchTHIQAH")) {
			logger.info("Inside Fetch Thiqah button");
			callName = "GetCrInfobyCrNo";
			// responseXML = createRequestXML(iformObj, callName);
			// setResponseData(iformObj, callName, responseXML);
			return "";
		} else if (control.equalsIgnoreCase("createDisbursementWI")) {
			logger.info("inside create Disbursement WI details");
			return createDisbursementWI(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("documentNameFromDocumentIndex")) {
			logger.info("inside documentNameFromDocumentIndex function");
			return documentNameFromDocumentIndex(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillStatementData")) {
			logger.info("inside fill statement data");
			return fillStatementData(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillStatementDataOldCIC")) {
			logger.info("inside fillStatementDataOldCIC ");
			return fillStatementDataOldCIC(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("sitevisitmandatorydocumentCheck")) {
			logger.info("inside sitevisitmandatorydocumentCheck handling");
			return sitevisitmandatorydocumentCheck(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillCTFMSBData")) {
			logger.info("inside fillCTFMSBData function ");
			return fillCTFMSBData(iformObj, stringdata);
		} else if (control.equalsIgnoreCase("calculateTopUpOutstanding")) {
			logger.info("inside calculateTopUpOutstanding function ");
			return calculateTopUpOutstanding(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fetchCompanyDataPQ1")) {
			logger.info("inside fetchCompanyDataPQ1 function ");
			return fetchCompanyDataPQ1(iformObj, stringdata);
		}
		 else if (control.equalsIgnoreCase("fillTerminalId")) {
			logger.info("inside fillTerminalId function ");
			return fillTerminalId(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillTerminalIdOldCIC")) {
			logger.info("inside fillTerminalIdOldCIC function ");
			return fillTerminalIdOldCIC(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillPOSdetails")) {
			logger.info("inside fillPOSdetails function ");
			return fillPOSdetails(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillPOSdetailsOldCIC")) {
			logger.info("inside fillPOSdetailsOldCIC function ");
			return fillPOSdetailsOldCIC(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("SetPQList")) {
			logger.info("inside SetPQList function ");
			return SetPQList(iformObj, stringdata);
		} else if (control.equalsIgnoreCase("fillTrassetData")) {
			logger.info("inside fillTrassetData function ");
			return fillTrassetData(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillFullRMName")) {
			logger.info("inside fillFullRMName function ");
			return fillFullRMName(iformObj, stringdata);
		} 
		else if (control.equalsIgnoreCase("fetchSIMAH")) {
			logger.info("inside fetchSIMAH function ");
			return fillSIMAHData(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillSIMAHDataIndividual")) 
		{
			logger.info("inside fillSIMAHDataIndividual function ");
			return fillSIMAHDataIndividual(iformObj, stringdata);
		}
		
		else if (control.equalsIgnoreCase("ToConvertHijriDate")) {
			logger.info("inside ToConvertHijriDate function ");
			return ConvertHijriDate(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fetchCreditLineDataApprovedSales")) {
			logger.info("inside fetchCreditLineDataApprovedSales function ");
			return fetchCreditLineDataApprovedSales(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("calculateProfitPercentage")) {
			logger.info("inside calculateProfitPercentage function ");
			return calculateProfitPercentage(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("generateAmmortization")) {
			logger.info("inside generateAmmortization function ");
			return generateAmmortization(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("generateAmmortizationChild")) {
			logger.info("inside generateAmmortizationChild function ");
			return generateAmmortizationChild(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillHeaderDetails")) {
			logger.info("inside fillHeaderDetails function ");
			String temp=fillHeaderDetails(iformObj, stringdata);
			temp=overrideSourceChannel(iformObj, stringdata);
			return temp;
			
		}
		// ashutosh-start
		else if (control.equalsIgnoreCase("template_gen_btn")) {
			logger.info("111111PRINT_CLIENT_APP_FORM");
			try {
				logger.info("inside try block");
				return generateTemplate(iformObj, stringdata);
			} catch (Exception e) {

				e.getMessage();
			}
		}else if (control.equalsIgnoreCase("document_upload")) {
			logger.info("inside java control of @@@ document_upload ");
			return Documentgrid(iformObj, stringdata);
		}/*else if (control.equalsIgnoreCase("CallCommodityPurchase")) {
			logger.info("inside COMMODITY Purchase ");
			return CallCommodityPurchase(iformObj, stringdata);
		}*/
		else if (control.equalsIgnoreCase("CallContractSimulation")) {
			logger.info("inside CallContractSimulation call ");
			return CallContractSimulation(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("MSBContractMngRq")) {
			logger.info("inside MSBContractMngRq call to stipulate master contract ");
			return MSBContractMngRq(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("MSBContractMngRqChild")) {
			logger.info("inside MSBContractMngRqChild call to stipulate master contract for child ");
			return MSBContractMngRqChild(iformObj, stringdata);
		}
		
		else if (control.equalsIgnoreCase("CallRepaymntAccCreation")) {
			logger.info("inside CallRepaymntAccCreation function");
			return CallRepaymntAccCreation(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("relatedpartyfetchCIC")) {
			logger.info("inside relatedpartyfetchCIC function");
			return relatedpartyfetchCIC(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillMoveAccGrid")) {
			logger.info("inside fillMoveAccGrid function ");
			return fillMoveAccGrid(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillMoveAccGridOldCIC")) {
			logger.info("inside fillMoveAccGridOldCIC function ");
			return fillMoveAccGridOldCIC(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("CallMSBLimitMng")) {
			logger.info("inside CallMSBLimitMng function ");
			return CallMSBLimitMng(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("test3check")) {
			logger.info("inside test3check function ");
			return test3check(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("fetchBankAccount")) {
			logger.info("inside fetchBankAccount function ");
			return fetchBankAccount(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("retrurnMax_and_Min_rate")) 
		{
			logger.info("inside retrurnMax_and_Min_rate function ");
			return return_max_min_rate(iformObj, stringdata); 
		}
		else if (control.equalsIgnoreCase("return_max_min_FEE_amount")) 
		{
			logger.info("inside return_max_min_FEE_amount function ");
			return return_max_min_FEE_amount(iformObj, stringdata); 
		}else if (control.equalsIgnoreCase("return_max_min_Broker_FEE_amount")) 
		{
			logger.info("inside return_max_min_Broker_FEE_amount function ");
			return return_max_min_Broker_FEE_amount(iformObj, stringdata); 
		}
		else if (control.equalsIgnoreCase("retrurnMax_and_Min_FEE_rate")) {
			logger.info("inside retrurnMax_and_Min_FEE_rate function ");
			return return_max_min_FEE_rate(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("calculateFixedFeeAmount")) {
			logger.info("inside retrurnMax_and_Min_FEE_rate function ");
			return calculateFixedFeeAmount(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("CallShortCICMng")) {
			logger.info("inside CallShortCICMng call ");
			return CallShortCICMng(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillNoOfExceptionAndAlerts")) {
			logger.info("inside fillNoOfExceptionAndAlerts function ");
			return fillNoOfExceptionAndAlerts(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("calculateLosAppNum")) {
			logger.info("inside calculateLosAppNum function ");
			return calculateLosAppNum(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("fillArabicAmountFields")) {
			logger.info("inside fillArabicAmountFields function ");
			return fillArabicAmountFields(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("checkCRExpiry")) {
			logger.info("inside checkCRExpiry function ");
			return checkCRExpiry(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("rejectWorkItem")) {
			logger.info("inside rejectWorkItem function ");
			return rejectWorkItem(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("isarabic")) {
			logger.info("inside isarabic function ");
			return isarabic(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("retrurnMax_and_Min_Amount")) {
			logger.info("inside retrurnMax_and_Min function ");
			return return_max_min_amount(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("CallCommodityPurchase")) {
			logger.info("inside COMMODITY Purchase ");
			return CallCommodityPurchase(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("ConfirmPurchase")) {
			logger.info("inside ConfirmDealKey ");
			return ConfirmPurchase(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("calculateLosAppNum")) {
			logger.info("inside calculateLosAppNum function ");
			return calculateLosAppNum(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("CommoditySell")) {
			logger.info("inside COMMODITY Sell ");
			return CommoditySell(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("ConfirmSell")) {
			return ConfirmSell(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("CalculateFeesGrid")) {
			logger.info("inside CalculateFeesGrid for disbursement ");
			return calculateDisbursementAdminFee(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("CallContractSimulationChild")) {
			logger.info("inside CallContractSimulationChild call ");
			return CallContractSimulationChild(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("TMSblockUnblockGrid")) {
			logger.info("inside TMSblockUnblockGrid ");
			return TMSblockUnblockGrid(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("ExecuteAutoSell")) {
			logger.info("inside ExecuteAutoSell ");
			return ExecuteAutoSell(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("LoanDisbursement")) {
			logger.info("inside LoanDisbursement ");
			return LoanDisbursement(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("BuyAndContractOnLoad")) {
			logger.info("inside BuyAndContractOnLoad ");
			return BuyAndContractOnLoad(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("subFormLoadSIMAH")) {
			logger.info("inside subFormLoadSIMAH ");
			return subFormLoadSIMAH(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("subFormLoadSIMAHCommercial")) {
			logger.info("inside subFormLoadSIMAHCommercial ");
			return subFormLoadSIMAHCommercial(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("RelatedPartyHiddenRowSet")) {
			logger.info("inside BuyAndContractOnLoad ");
			return RelatedPartyHiddenRowSet(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("subFormTest")) {
			logger.info("inside subFormTest ");
			return subFormTest(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("SiteVisitChecklist")) {
			logger.info("inside Locationvisitgrid ");
			return SiteVisitChecklist(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("defaultcampaign")) {
			logger.info("inside defaultcampaign ");
			return defaultcampaign(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("AddRelatedPartyPQ")) {
            logger.info("inside AddRelatedPartyPQ function ");
            return AddRelatedPartyPQ(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("pqapprovedAmountAfterSIMAH")) {
            logger.info("inside pqapprovedAmountAfterSIMAH function ");
            return pqapprovedAmountAfterSIMAH(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("calculateCurrentDBR")) {
            logger.info("inside calculateCurrentDBR function ");
            return calculateCurrentDBR(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("BrokerDocumentcall")) {
            logger.info("inside BrokerDocumentcall function ");
            return BrokerDocumentcall_main(iformObj,stringdata);
		}else if (control.equalsIgnoreCase("maxCommodityPurchaseCheck")) {
            logger.info("inside maxCommodityPurchaseCheck function ");
            return maxCommodityPurchaseCheck(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("stagewisemandatorydocumentCheck")) {
            logger.info("inside stagewisemandatorydocumentCheck function ");
            return stagewisemandatorydocumentCheck(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("corporateGuaranteeCheck")) {
            logger.info("inside corporateGuaranteeCheck function ");
            return corporateGuaranteeCheck(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("RelatedPartyfillSIMAHDataCommercial")) {
            logger.info("inside RelatedPartyfillSIMAHDataCommercial function ");
            return RelatedPartyfillSIMAHDataCommercial(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("fillMerchantDetails")) {
            logger.info("inside fillMerchantDetails function ");
            return fillMerchantDetails(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("calculateT24BranchCode")) {
            logger.info("inside calculateT24BranchCode function ");
            return calculateT24BranchCode(iformObj,stringdata);
		}
		else if (control.equalsIgnoreCase("SIMAHvalidationcheck")) {
            logger.info("inside SIMAHvalidationcheck function ");
            return SIMAHvalidationcheck(iformObj,stringdata);
		}
		else if (control.equalsIgnoreCase("deletingDisbursedData")) 
		{
			logger.info("inside deletingDisbursedData function ");
			return deletingDisbursedData(iformObj, stringdata);
		}else if (control.equalsIgnoreCase("SuccessorGuarantorCheck")) 
		{
			logger.info("inside SuccessorGuarantorCheck function ");
			return SuccessorGuarantorCheck(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("ParentCrToChilCRMappingCheck")) 
		{
			logger.info("inside ParentCrToChilCRMappingCheck function ");
			return ParentCrToChilCRMappingCheck(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("relatedpartyFetchDataFromIDnumber")) {
			logger.info("inside relatedpartyFetchDataFromIDnumber function");
			return relatedpartyFetchDataFromIDnumber(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("assignWorkitem")) {
			logger.info("inside assignWorkitem function");
			return assignWorkitem(iformObj, stringdata);
		}
		/*
		 * else if (control.equalsIgnoreCase("downloadAllWIDocument")) {
		 * logger.info("inside downloadAllWIDocument function "); String
		 * wi_name=getWorkitemName(iformObj); obj=new CreateDocument(); return
		 * obj.downloadAllWIDocument(iformObj,wi_name); }
		 */
		else if (control.equalsIgnoreCase("template_gen_btn_cic")) 
		{
			logger.info("111111PRINT_CLIENT_APP_FORM");
			try 
			{
				logger.info("inside try block");
				return generateTemplateWithCIC(iformObj, stringdata);
			} 
			catch (Exception e) 
			{
				
				e.getMessage();
			
			}
		}
		else if (control.equalsIgnoreCase("msbUploadNonARBButtonClicked")) {
			logger.info("Inside msbUploadNonARBButtonClicked  function");
			return new POS_Search().msbUploadNonARBButtonClicked(iformObj, stringdata);
		}
			else if (control.equalsIgnoreCase("refreshAfterStatementUpload")) {
			logger.info("Inside refreshAfterStatementUpload  function");
			return refreshAfterStatementUpload(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("refreshAfterStatementUpload1")) {
				logger.info("Inside refreshAfterStatementUpload1  function");
				return refreshAfterStatementUpload1(iformObj, stringdata);
			}
		else if (control.equalsIgnoreCase("refreshPOSstatement")) {
			logger.info("Inside refreshPOSstatement  function");
			return refreshPOSstatement(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("refreshAccstatement")) {
			logger.info("Inside refreshAccstatement  function");
			return refreshAccstatement(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("cancelCommoditycall")) {
			logger.info("Inside cancelCommoditycall  function");
			return cancelCommoditycall(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("transferMerchantDataForTMS")) {
			logger.info("Inside transferMerchantDataForTMS  function");
			return transferMerchantDataForTMS(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("transferMerchantDataForTMS_cancelcommodity")) 
		{
			logger.info("Inside transferMerchantDataForTMS_cancelcommodity  function");
			return transferMerchantDataForTMS_cancelcommodity(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("refreshterminalData")) {
			logger.info("Inside refreshterminalData  function");
			return refreshterminalData(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("hideShowRetryBlockingButton")) 
		{
			logger.info("Inside hideShowRetryBlockingButton function");
			return hideShowRetryBlockingButton(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("checkTerminalValidationDuringSubmission")) 
		{
			logger.info("Inside checkTerminalValidationDuringSubmission function");
			return checkTerminalValidationDuringSubmission(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("ReapprovalRemoveMandatoryDoc")) 
		{
            logger.info("inside ReapprovalRemoveMandatoryDoc function");
            return ReapprovalRemoveMandatoryDoc(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("approvedSalesEntryDateSet")) 
		{
            logger.info("inside approvedSalesEntryDateSet function");
            return approvedSalesEntryDateSet(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("approvedSalesExpiryCheck")) 
		{
            logger.info("inside approvedSalesExpiryCheck function");
            return approvedSalesExpiryCheck(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("updateAdminAndBrokerFeesExternalTable")) 
		{
            logger.info("inside updateAdminAndBrokerFeesExternalTable function");
            return updateAdminAndBrokerFeesExternalTable(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("SIMAHexpiryCheck")) 
		{
            logger.info("inside SIMAHexpiryCheck function");
            return SIMAHexpiryCheck(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("checkAccountBlockCode") || control.equalsIgnoreCase("checkAccountBlockCode_beforesell")) 
		{
			stringdata=control;
			logger.info("inside checkAccountBlockCode function ");
			return checkAccountBlockCode(iformObj, stringdata);
		}
		else if (control.equalsIgnoreCase("validateDataBeforePurchase")) 
		{
            logger.info("inside validateDataBeforePurchase function");
            return validateDataBeforePurchase(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("validateFeesAmount")) 
		{
            logger.info("inside validateFeesAmount function");
            return validateFeesAmount(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("fetchGroupPolicyExposure")) 
		{
            logger.info("inside fetchGroupPolicyExposure function");
            return fetchGroupPolicyExposure(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("fillComboGroupPolicyCIC")) 
		{
            logger.info("inside fillComboGroupPolicyCIC function");
            return fillComboGroupPolicyCIC(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("fillGroupExposureCreditLineGrid")) 
		{
            logger.info("inside fillGroupExposureCreditLineGrid function");
            return fillGroupExposureCreditLineGrid(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("fillMainPartyInfoinGroupExpoGrid")) 
		{
            logger.info("inside fillMainPartyInfoinGroupExpoGrid function");
            return fillMainPartyInfoinGroupExpoGrid(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("fillCTFMSBData_GroupExposure")) 
		{
            logger.info("inside fillCTFMSBData_GroupExposure function");
            return fillCTFMSBData_GroupExposure(iformObj, stringdata);
        }
		else if (control.equalsIgnoreCase("fillThiqahPQ2")) 
		{
            logger.info("inside fillThiqahPQ2 function");
            return fillThiqahPQ2(iformObj, stringdata);
        }
		
		return stringdata;
		
	}

	private String fillThiqahPQ2(IFormReference iformObj, String stringdata) 
	{	String wi_name=getWorkitemName(iformObj);
		logger.info("Inside handling of fillThiqahPQ2 for workitem "+wi_name);
		try
		{
			logger.info("Setting Thiqah information after application creation");
			String callName = "GetCrInfobyCrNo_PQ1"; //For Thiqah details
			String responseXML = createRequestXML(iformObj, callName);
			JSONObject jsonobj=setResponseData(iformObj, callName, responseXML);
			
			for(Iterator iterator = jsonobj.keySet().iterator(); iterator.hasNext();) 
			{
			    String key = (String) iterator.next();
			    setControlValue(iformObj, key, jsonobj.get(key).toString());
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: Inside fillThiqahPQ2 and exception is "+e);
			return "error~Error in fillThiqahPQ2, please check";
		}

		return "success~fillThiqahPQ2";
	}

	private String fillGroupExposureCreditLineGrid(IFormReference iformObj, String stringdata) 
	{
		String wi_name=getWorkitemName(iformObj);
		logger.info("Inside handling of fillGroupExposureCreditLineGrid for workitem "+wi_name);
		try
		{
			String regex="^0+(?!$)";
			String cic_no=stringdata.replaceAll(regex,"");
			String query="";
			JSONArray jsonarr = new JSONArray();
            JSONObject jsonobj = null;
            
			query="SELECT LOS_APPLN_NO,T24_LIMIT_REF,PROD_CATEGORY,PRODUCT,CUST_CATEGORY,CAMPAIGN,MAST_CONTRACT_NO,LOAN_ACC_NO,GROSS_AMT,FIN_AMT,CONTRACT_DATE,DISBURSAL_DATE,FIRST_INST_DATE,LAST_INST_DATE,GROSS_OUTSDING,OUTSTDNG_PRINCIPAL,OUTSTDNG_PROFIT,INSTALLMENT,TENURE,FREQUENCY,PROFIT_PERCENT,LOAN_STATUS,DPD,INSTALLMENT_PERIOD FROM NG_POS_CREDITLINE_LOANACC_GRID_GROUP_EXPOSURE WHERE WI_NAME='"+wi_name+"' AND CIC_NO='"+cic_no+"' ";
			List<List<String>> result = iformObj.getDataFromDB(query);
			logger.info("query to fetch Loan Account Data is "+query+"and it's result is "+result);
		        for (List<String> value : result) 
		        {
		               jsonobj = new JSONObject();
		               jsonobj.put("LOS Application No", value.get(0));
		               jsonobj.put("T24 Limit Reference", value.get(1));
		               jsonobj.put("Product Category", value.get(2));
		               jsonobj.put("Product", value.get(3));
		               jsonobj.put("Customer Category", value.get(4));
		               jsonobj.put("Campaign", value.get(5));
		               jsonobj.put("Master Contract No", value.get(6));
		               jsonobj.put("Disbursement Account Number", value.get(7));
		               jsonobj.put("Principal&Profit", value.get(8));
		               jsonobj.put("Financing Amount", value.get(9));
		               jsonobj.put("Contract Date", value.get(10));
		               jsonobj.put("Disbursal Date", value.get(11));
		               jsonobj.put("First Installment Date", value.get(12));
		               jsonobj.put("Last Installment date", value.get(13));
		               jsonobj.put("Gross Outstanding", value.get(14));
		               jsonobj.put("Outstanding Principal", value.get(15));
		               jsonobj.put("Outstanding Profit", value.get(16));
		               jsonobj.put("Installment", value.get(17));
		               jsonobj.put("Tenure", value.get(18));
		               jsonobj.put("Frequency", value.get(19));
		               jsonobj.put("Profit %", value.get(20));
		               jsonobj.put("Status", value.get(21));
		               jsonobj.put("DPD", value.get(22));
		               jsonobj.put("Installment Period", value.get(23));
		               jsonarr.add(jsonobj);               
		        }
		        iformObj.clearTable("CL_FINANCE_ACC_DETAILS_GROUP_EX_GRID");
		        
		        logger.info("Group Exposure JSON for Loan Account Details Grid for cic "+cic_no+" and wi_name "+wi_name+" is "+jsonarr);
		        iformObj.addDataToGrid("CL_FINANCE_ACC_DETAILS_GROUP_EX_GRID", jsonarr);
		        
		        jsonarr=new JSONArray();
		        
		        query="SELECT SYSTEM_NAME,DOSSIER_NUMBER,PRODUCT_NAME,PRODUCT_TYPE,PRODUCT_CODE,ELIG_LIMIT_AMT,UTILIZED_AMT,AVAIL_DRAWDOWN,INSTL_AMT,ELIG_VALID_UPTO,CTF_STATUS,REPAYMNT_PERIOD,INSTALLMENT_COUNT,PAID_INSTALLMENT_COUNT,PARTIAL_PAID_INSTALLMENT_COUNT,OUTSTANDING_BALANCE,FACILITY_TYPE FROM NG_POS_CREDITLINE_CTF_MSB_GRID_GROUP_EXPOSURE WHERE WI_NAME='"+wi_name+"' AND CIC_NO='"+cic_no+"' ";
				result = iformObj.getDataFromDB(query);
				logger.info("query to fetch CTF MSB Data is "+query+"and it's result is "+result);
				  for (List<String> value : result) 
			        {
			               jsonobj = new JSONObject();
			               jsonobj.put("System Name", value.get(0));
			               jsonobj.put("Dossier No", value.get(1));
			               jsonobj.put("Product Name", value.get(2));
			               jsonobj.put("Product Type", value.get(3));
			               jsonobj.put("Product Code", value.get(4));
			               jsonobj.put("Eligible Limit Amount", value.get(5));
			               jsonobj.put("Utilized Amount", value.get(6));
			               jsonobj.put("Available For Drawdown", value.get(7));
			               jsonobj.put("Installment Amount", value.get(8));
			               jsonobj.put("Eligibility Valid Up To", value.get(9));
			               jsonobj.put("Status", value.get(10));
			               jsonobj.put("Repayment Period", value.get(11));
			               jsonobj.put("Installment Count", value.get(12));
			               jsonobj.put("Paid Installment Count", value.get(13));
			               jsonobj.put("Partial Paid Installment Count", value.get(14));
			               jsonobj.put("Outstanding Balance", value.get(15));
			               jsonobj.put("Facility Type", value.get(16));
			               jsonarr.add(jsonobj);               
			        }
			        iformObj.clearTable("CL_CTF_MSB_GROUP_EX_GRID");
			        
			        logger.info("Group Exposure JSON for Loan Account Details Grid for cic "+cic_no+" and wi_name "+wi_name+" is "+jsonarr);
			        iformObj.addDataToGrid("CL_CTF_MSB_GROUP_EX_GRID", jsonarr);
			        
			        jsonarr=new JSONArray();
			       
			        query = "SELECT CIC,CUST_NAME,LIMIT_REF,TICKET,CONTRACT_AMOUNT,LIMIT_DESC,LIMIT_UTIL_AMOUNT,LIMIT_UNUTIL_AMOUNT,PRODUCT,REVOLVING,PROFIT_RATE_TYPE,PROFIT_RATE,TENOR,TOTAL_NO_INSTALLMENT,FREQUENCY_OF_INSTALLMENT,CAST(INSTALMENT_AMOUNT AS NUMERIC(20,2)),NO_INSTALLMENT_PAID,NO_OVERDUE_INSTALLMENT,CONTRACT_EFFECTIVE_DATE,CONTRACT_EXPIRY_DATE,NEXT_INSTALMENT_DUE_DATE,OUTSTANDING_PRINCIPAL,OUTSTANDING_PROFIT,GROSS_OUTSTANDING,PDO_AMOUNT,PDO_DATE,WRITE_OFF,CONTRACT_STATUS,ORR,RM_CODE,RM_NAME,CLIENT_ACCOUNT_NUMBER FROM NG_POS_CREDITLINE_TRASSET_DET_GRID_GROUP_EXPOSURE WHERE CIC='" + cic_no + "' ";
			        result = iformObj.getDataFromDB(query);
					logger.info("query to fetch Trasset Data is "+query+"and it's result is "+result);
					for (List<String> value : result) 
					{
			        	jsonobj = new JSONObject();
						logger.info("Size of value is "+value.size());
						jsonobj.put("CIC Number",value.get(0));
						jsonobj.put("Customer Name",value.get(1));
						jsonobj.put("Limit ref No",value.get(2));
						jsonobj.put("Tr Reference (Contract No)",value.get(3));
						jsonobj.put("Contract Amount",value.get(4));
						jsonobj.put("Limit Description",value.get(5));
						jsonobj.put("Limit Utilized Amount",value.get(6));
						jsonobj.put("Limit UnUtilized Amount ",value.get(7));
						jsonobj.put("Product Name",value.get(8));
						jsonobj.put("Revolving/Non Revolving",value.get(9));
						jsonobj.put("Profit rate Type",value.get(10));
						jsonobj.put("Profit Rate",value.get(11));
						jsonobj.put("Tenure of financing",value.get(12));
						jsonobj.put("Total No of Instalment",value.get(13));
						jsonobj.put("Frequency ",value.get(14));
						jsonobj.put("Instalment Amount",value.get(15));
						jsonobj.put("No of instalments paid",value.get(16));
						jsonobj.put("No of Overdue Instalments",value.get(17));
						jsonobj.put("Contract Effective date",value.get(18));
						jsonobj.put("Contract Expiry date",value.get(19));
						jsonobj.put("Next instalment due date",value.get(20));
						jsonobj.put("Outstanding principal",value.get(21));
						jsonobj.put("Outstanding Profit",value.get(22));
						jsonobj.put("Gross Outstanding",value.get(23));
						jsonobj.put("PDO Amount",value.get(24));
						jsonobj.put("PDO date (oldest) - DPD",value.get(25));
						jsonobj.put("Write Off",value.get(26));
						jsonobj.put("Contract Status",value.get(27));
						jsonobj.put("ORR",value.get(28));
						jsonobj.put("RM Code",value.get(29));
						jsonobj.put("RM Name",value.get(30));
						jsonobj.put("Client Account Number",value.get(31));
						jsonarr.add(jsonobj);
					}
					
					iformObj.clearTable("CL_TRASSET_DET_GROUP_EX_GRID");
					logger.info("Group Exposure JSON for Trasset Details Grid for cic "+cic_no+" and wi_name "+wi_name+" is "+jsonarr);
				    iformObj.addDataToGrid("CL_TRASSET_DET_GROUP_EX_GRID", jsonarr);
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: Inside fillGroupExposureCreditLineGrid and exception is "+e);
			return "error~Error in fillGroupExposureCreditLineGrid, please check";
		}

		return "success~fillGroupExposureCreditLineGrid";
	}
	
	private String fillMainPartyInfoinGroupExpoGrid(IFormReference iformObj, String stringdata) 
	{
		String wi_name=getWorkitemName(iformObj);
		String main_comapnay_cic_number=(String) iformObj.getValue("PADDED_CIC_NO");
		logger.info("Inside handling of fillMainPartyInfoinGroupExpoGrid for workitem "+wi_name);
		try 
        {
			JSONArray jsonarr=new JSONArray();
			JSONObject jsonobj = new JSONObject();
			String outstanding_amount="";
			String query="SELECT SUM(B.OUTSTANDING) FROM ( SELECT CAST(REPLACE(IIF(OUTSTANDING_BALANCE ='',NULL,OUTSTANDING_BALANCE ),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_CREDITLINE_CTF_MSB_GRID B WHERE B.PRODUCT_CODE='1012' AND B.WI_NAME = '"+wi_name+"'  UNION SELECT CAST(REPLACE(IIF(OUTSTDNG_PRINCIPAL='',NULL,OUTSTDNG_PRINCIPAL),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_CREDITLINE_LOANACC_GRID WHERE WI_NAME = '"+wi_name+"' AND PRODUCT='Point of Sale Finance' UNION SELECT CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_TRASSET_DETAILS_GRID_NEW WHERE WI_NAME = '"+wi_name+"' and CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))<'7500000' ) B";
			logger.info("Query to get outstanding amount for main CIC for "+wi_name+" is "+query);    
        	List<List<String>> result = getDataFromDB(iformObj, query);
        	if(result.size()>0)
        	{
        		if(result.get(0).size()>0)
        		{
        			outstanding_amount=result.get(0).get(0);
        		}
        	}
        	
        	String entity_name_eng=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_NAME_OF_ENITITY_ENG");
        	String entity_name_ar=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_NAME_OF_ENTITY_ARB");
        	String cr_number=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_CR_NUMBER");
        	String unn_number=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_UNN_NO");
        	String cr_issue_date=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_ISSUE_DATE");
        	String cr_expiry_date=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_EXPIRY_DATE");
        	String unn_issue_date=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_REGIS_TYPE_ISSUE_DATE");
        	String unn_expiry_date=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_REGIS_TYPE_EXPIRY_DATE");
        	String sector=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_SECTOR");
        	String subsector=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_SUBSECTOR");
        	String industry=(String) iformObj.getValue("Q_NG_POS_COMPANY_DATA_INDUSTRY");
        	
        	jsonobj.put("Sr. No.","1");
        	jsonobj.put("CR Type","Main CR");
        	jsonobj.put("CIC",main_comapnay_cic_number);
        	jsonobj.put("Entity Name (Eng)",entity_name_eng);
			jsonobj.put("Entity Name (AR)",entity_name_ar);
			jsonobj.put("CR Number",cr_number);
			jsonobj.put("UNN Number",unn_number);
			jsonobj.put("Consolidated Finance Outstanding",outstanding_amount);
			jsonobj.put("CR Issue Date",cr_issue_date);
			jsonobj.put("CR Expiry Date",cr_expiry_date);
			jsonobj.put("UNN Issue Date",unn_issue_date);
			jsonobj.put("UNN Expiry Date",unn_expiry_date);
			jsonobj.put("Sector",sector);
			jsonobj.put("Subsector",subsector);
			jsonobj.put("Industry",industry);
			
			jsonarr.add(jsonobj);
			iformObj.addDataToGrid("GROUP_EXPOSURE_GRID", jsonarr);
        }
		catch(Exception e)
		{
			logger.info("Exception Occurred: Inside fillMainPartyInfoinGroupExpoGrid and exception is "+e);
			return "error~Error in fillMainPartyInfoinGroupExpoGrid, please check";
		}
		return "success~fillMainPartyInfoinGroupExpoGrid";
	}
	
	private String fillComboGroupPolicyCIC(IFormReference iformObj, String stringdata) 
	{
		String wi_name=getWorkitemName(iformObj);
		String main_comapnay_cic_number=(String) iformObj.getValue("PADDED_CIC_NO");
		logger.info("Inside handling of fillComboGroupPolicyCIC for workitem "+wi_name);
		stringdata="CL_GROUP_EXPOSURE_CIC";
        iformObj.clearCombo(stringdata);
        try 
        {
        	String query = "SELECT DISTINCT CIC FROM NG_POS_GRP_COMPANY_EXPO_GRID WHERE WI_NAME='"+wi_name+"' ";
        	logger.info("Query to select distinct CIC no for "+wi_name+" is "+query);    
        	List<List<String>> cic_number = getDataFromDB(iformObj, query);
	        for (List<String> value : cic_number) 
	        {
	               String result = value.get(0);
	               if(!result.equalsIgnoreCase(main_comapnay_cic_number))
	               {
	            	   logger.info("CIC no set in dropdown are" + result);
		               iformObj.addItemInCombo(stringdata, result, result);
	               }
	        }
        }
        catch(Exception e)
        {
               logger.info("Exception occurred: fillComboGroupPolicyCIC and Exception is "+e);
        }
       
        return "success~fillComboGroupPolicyCIC";
	}

	
	private String fetchGroupPolicyExposure(IFormReference iformObj, String stringdata) 
	{
		String wi_name=getWorkitemName(iformObj);
		logger.info("Inside handling of fetchGroupPolicyExposure for workitem "+wi_name);
		try
		{
			String callname="",responseXML="",return_string="";
			callname = "MSBEntityDataInq_GroupExposure";
			responseXML = createRequestXML(iformObj, callname);
			JSONObject jobj = setResponseData_2(iformObj, callname, responseXML);
			logger.info("Inside MSBEntityDataInq_GroupExposure call "+jobj);
			XMLParser parser = new XMLParser(responseXML);
			for(Iterator iterator = jobj.keySet().iterator(); iterator.hasNext();)
			{
				String key = (String) iterator.next();
				if(key.equalsIgnoreCase("Error"))
				{
					return_string="Error~"+jobj.get(key).toString();
					return return_string;
				}
				else
				{
					logger.info("Values set for"+key+" are "+jobj.get(key).toString());
					 if(key.equalsIgnoreCase("table18054_SECTOR"))
			    	{
			    		String Sector_Code=parser.getValueOf("SectorCd");
			    		String Sector_Code_desc=parser.getValueOf("SectorDesc");
			    		logger.info("sector Setting:::"+Sector_Code+" and "+Sector_Code_desc);
			    		setControlValue(iformObj, key, Sector_Code+"-"+Sector_Code_desc);
			    		
			    	}
			    	else if(key.equalsIgnoreCase("table18054_SUBSECTOR"))
			    	{
			    		String Sub_Sector_Code=parser.getValueOf("SubSectorCd");
			    		String Sub_Sector_Code_desc=parser.getValueOf("SubSectorDesc");
			    		logger.info("sub sector Setting:::"+Sub_Sector_Code+" and "+Sub_Sector_Code_desc);
			    		setControlValue(iformObj, key, Sub_Sector_Code+"-"+Sub_Sector_Code_desc);
			    		
			    	}
			    	else if(key.equalsIgnoreCase("table18054_INDUSTRY"))
			    	{
			    		String city_code=parser.getValueOf("ActivityCd");
			    		String city_desc=parser.getValueOf("ActivityDesc");
			    		logger.info("sub sector Setting:::"+city_code+" and "+city_desc);
			    		setControlValue(iformObj, key, city_code+"-"+city_desc);
			    		
			    	}
			    	else
			    	{
			    		setControlValue(iformObj, key, jobj.get(key).toString());
			    	}
				}
			}
			logger.info("For MSBEntityDataInq_GroupExposure Entity data json object is "+jobj);
			
			String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			String cic_no=(String) iformObj.getValue("table18054_CIC");
			String regex="^0+(?!$)";
			String unpadded_cic_no=cic_no.replaceAll(regex,"");
			logger.info("For Workitem no "+wi_name+" Group exposure CIC no is "+cic_no+" and unpadded cic_no is "+unpadded_cic_no);
			
			callname="CustOutstandingInq_GroupExposure";
			responseXML = createRequestXML(iformObj, callname);
			String results=setResponseDataGridApprovedSales(iformObj, callname, responseXML,cic_no,wi_name);
			fetchAllCTFDataGroupExposure(iformObj, callname,cic_no,wi_name);
			
			String query="DELETE FROM NG_POS_CREDITLINE_TRASSET_DET_GRID_GROUP_EXPOSURE WHERE CIC ='"+unpadded_cic_no+"' ";
			logger.info("Query to delete from NG_POS_CREDITLINE_TRASSET_DET_GRID_GROUP_EXPOSURE  is "+query);
			iformObj.saveDataInDB(query);
			
			query="INSERT INTO NG_POS_CREDITLINE_TRASSET_DET_GRID_GROUP_EXPOSURE (WI_NAME,CIC,CUST_NAME,LIMIT_REF,TICKET,CONTRACT_AMOUNT,LIMIT_DESC,LIMIT_UTIL_AMOUNT,LIMIT_UNUTIL_AMOUNT,PRODUCT,REVOLVING,PROFIT_RATE_TYPE,PROFIT_RATE,TENOR,TOTAL_NO_INSTALLMENT,FREQUENCY_OF_INSTALLMENT,INSTALMENT_AMOUNT,NO_INSTALLMENT_PAID,NO_OVERDUE_INSTALLMENT,CONTRACT_EFFECTIVE_DATE,CONTRACT_EXPIRY_DATE,NEXT_INSTALMENT_DUE_DATE,OUTSTANDING_PRINCIPAL,OUTSTANDING_PROFIT,GROSS_OUTSTANDING,PDO_AMOUNT,PDO_DATE,WRITE_OFF,CONTRACT_STATUS,ORR,RM_CODE,RM_NAME,CLIENT_ACCOUNT_NUMBER,ENTRY_DATE_TIME) SELECT '"+wi_name+"',CIC,CUST_NAME,LIMIT_REF,TICKET,CONTRACT_AMOUNT,LIMIT_DESC,LIMIT_UTIL_AMOUNT,LIMIT_UNUTIL_AMOUNT,PRODUCT,REVOLVING,PROFIT_RATE_TYPE,PROFIT_RATE,TENOR,TOTAL_NO_INSTALLMENT,FREQUENCY_OF_INSTALLMENT,CAST(INSTALMENT_AMOUNT AS NUMERIC(20,2)),NO_INSTALLMENT_PAID,NO_OVERDUE_INSTALLMENT,CONTRACT_EFFECTIVE_DATE,CONTRACT_EXPIRY_DATE,NEXT_INSTALMENT_DUE_DATE,OUTSTANDING_PRINCIPAL,OUTSTANDING_PROFIT,GROSS_OUTSTANDING,PDO_AMOUNT,PDO_DATE,WRITE_OFF,CONTRACT_STATUS,ORR,RM_CODE,RM_NAME,CLIENT_ACCOUNT_NUMBER,'"+date+"' FROM NG_MAST_TRASSET_DATA WHERE CIC = '"+unpadded_cic_no+"' ";
			logger.info("Query to insert in NG_POS_CREDITLINE_TRASSET_DET_GRID_GROUP_EXPOSURE  is "+query);
			iformObj.saveDataInDB(query);
			
			query="SELECT SUM(B.OUTSTANDING) FROM ( SELECT CAST(REPLACE(IIF(OUTSTANDING_BALANCE ='',NULL,OUTSTANDING_BALANCE ),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_CREDITLINE_CTF_MSB_GRID_GROUP_EXPOSURE B WHERE B.PRODUCT_CODE='1012' AND B.CIC_NO = '"+unpadded_cic_no+"' AND B.WI_NAME='"+wi_name+"'  UNION SELECT CAST(REPLACE(IIF(OUTSTDNG_PRINCIPAL='',NULL,OUTSTDNG_PRINCIPAL),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_CREDITLINE_LOANACC_GRID_GROUP_EXPOSURE WHERE CIC_NO = '"+unpadded_cic_no+"' AND WI_NAME='"+wi_name+"' AND PRODUCT='Point of Sale Finance' UNION SELECT CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_CREDITLINE_TRASSET_DET_GRID_GROUP_EXPOSURE   WHERE  CIC = '"+unpadded_cic_no+"' AND WI_NAME='"+wi_name+"' and CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))<'7500000' ) B";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to calculate outstanding Group Exposure for "+unpadded_cic_no+" is "+query+" and it's result is "+result);
			String outstanding_amount="";
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					outstanding_amount=result.get(0).get(0);
				}
			}
			
			logger.info("Setting value of  : "+outstanding_amount);
			iformObj.setValue("table18054_CONS_FIN_OUTSTNDNG", outstanding_amount);
			
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: Inside fetchGroupPolicyExposure and exception is "+e);
			return "error~Error in fetchGroupPolicyExposure, please check";
		}

		return "success~fetchGroupPolicyExposure";
	}

	private String validateFeesAmount(IFormReference iformObj, String stringData) 
	{
		String wi_name=getWorkitemName(iformObj);
		logger.info("Inside handling of validateFeesAmount for workitem "+wi_name);
		try
		{	int incorrect_fees_count=0;
			String query="select COUNT(*) from NG_POS_APPLICATION_DATA a,NG_POS_FEES_CHRGD_GRID b, NG_POS_EXTTABLE c where a.wi_name=b.wi_name and b.wi_name=c.wi_name and c.wi_name=a.wi_name  and b.FEES_NAME ='Admin fees' AND b.FEES_TYPE='Rate'  and b.FEES_AMNT!=round(a.REQ_AMNT_SAR*b.FEES_PER/100,2) AND A.WI_NAME='"+wi_name+"' ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to validate fees amount before submission from RM stage is "+query+" and it's result is "+result);
			if(result.size()>0)
			{
				if(result.size()>0)
				{
					if(result.get(0).size()>0)
					{
						try 
						{
							incorrect_fees_count=Integer.parseInt(result.get(0).get(0));
						}
						catch(Exception e)
						{
							incorrect_fees_count=0;
						}
						
						if(incorrect_fees_count==1)
						{
								logger.info("Fees amount is incorrect hence throwing errror");
								return "Error~ Can not  as submit as fees amount is incorrect. ";
						}
					}
				}
			}
			return "Success~All Good";
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: Inside validateFeesAmount and exception is "+e);
			return "Error~Error in validateFeesAmount, please check";
		}

	}
	
	private String validateDataBeforePurchase(IFormReference iformObj, String stringData) 
	{
		String wi_name=getWorkitemName(iformObj);
		logger.info("Inside handling of validateDataBeforePurchase for workitem "+wi_name);
		try
		{
			LocalDateTime localdate=LocalDateTime.now();
			int todays_day=localdate.getDayOfMonth();
			int instalment_day=0;
			logger.info("Today's date is "+todays_day);
			String query="SELECT cast(SUBSTRING(instalment_date,0,3) as int) FROM NG_POS_DISBURSAL_DATA_INSTALMENT_DETAILS_GRID WHERE wi_name='"+wi_name+"' AND INSTALMENT_NO=1 ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to validate today's date and installment date is "+query+" and it's result is "+result);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					try 
					{
						instalment_day=Integer.parseInt(result.get(0).get(0));
					}
					catch(Exception e)
					{
						instalment_day=0;
					}
				}
			}
			
			if(todays_day!=30 && todays_day!=31)
			{
				if(todays_day!=instalment_day)
				{
					logger.info("Today's date is "+todays_day+" and istalLment day is "+instalment_day+ "Hence returning with error.");
					return "Error~Please re-calculate installment.";
				}
			}
			
			int incorrect_fees_count=0;
			
			query="select COUNT(*) from NG_POS_APPLICATION_DATA a,NG_POS_DISBURSAL_DATA_FEES_CHRGD_GRID b, NG_POS_EXTTABLE c where a.wi_name=b.wi_name and b.wi_name=c.wi_name and c.wi_name=a.wi_name  and b.FEES_NAME ='Admin fees' AND b.FEES_TYPE='Rate'  and b.FEES_AMNT!=round(a.REQ_AMNT_SAR*b.FEES_PER/100,2) AND A.WI_NAME='"+wi_name+"' ";
			result=iformObj.getDataFromDB(query);
			logger.info("Query to validate fees amount before purchase is "+query+" and it's result is "+result);
			if(result.size()>0)
			{
				if(result.size()>0)
				{
					if(result.get(0).size()>0)
					{
						try 
						{
							incorrect_fees_count=Integer.parseInt(result.get(0).get(0));
						}
						catch(Exception e)
						{
							incorrect_fees_count=0;
						}
						
						if(incorrect_fees_count==1)
						{
								logger.info("Fees amount is incorrect hence throwing errror");
								return "Error~ Can not purchase commodity as fees amount is incorrect. ";
						}
					}
				}
			}
			return "Success~All Good";
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: Inside validateDataBeforePurchase and exception is "+e);
			return "Error~Error in validateDataBeforePurchase, please check";
		}
	}

	private String checkAccountBlockCode(IFormReference iformObj, String stringData) 
	{
		logger.info("Inside handling of checkAccountBlockCode");
		try
		{
			String account_number="", block_code="",block_description="";
			//String return_string="Success~";
			String callName="MSBAcctsDataInq_BlockStatusCheck_PQ1";
			String response=createRequestXML(iformObj, callName);
			
			int block_present=0;
			
			String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
			String []restricted_values=restricted_tags.split(",");
			for(String temp:restricted_values)
				response=response.replace(temp,"");
		
			//logger.info("Response XML received by setResponseDataGrid is"+ResponseXML);
			String tagName = "_TagNameResponseGrid";
			String tagNames = GetXML.getProp().getProperty(callName + tagName);
			logger.info(tagNames);
			
			String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
			String []status_code_split=statuscode.split("~");
			String return_string="<style>table, th, td {border:1px solid black; text-align:center}</style><h3>Following block codes are present for this CIC-</h3><table style=\"width:100%\"> <tr>  "
					+ "<th>Account Number</th>  <th>Block Code</th>  <th>Block Description</th>"
					+ "</tr>";			
			String[] tagValue = tagNames.split(",");
			for(String tag: tagValue)
			{
				String []tags=tag.split("~");
				WFXmlResponse objWFxmlResponse = new WFXmlResponse(response);
				logger.info("objWFxmlResponse value is "+objWFxmlResponse);

				JSONArray jsonarr=new JSONArray();
				
				logger.info("Status codes are"+status_code_split[0]+"and"+status_code_split[1]);
				
				logger.info("Value of status tag in response is"+objWFxmlResponse.getVal(status_code_split[0]));
				
				if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) 
				{
					WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
					for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
					{
						
						if(WFXmlList.getVal("AcctStatus").equalsIgnoreCase("Active") )
						{
							logger.info("Accouns Status is active");
							if(WFXmlList.getVal("AcctBlkCd").equalsIgnoreCase("A8") || WFXmlList.getVal("AcctBlkCd").equalsIgnoreCase("B9") || WFXmlList.getVal("AcctBlkCd").equalsIgnoreCase("FP") || WFXmlList.getVal("AcctBlkCd").equalsIgnoreCase("50"))
							{
								logger.info("Required block codes are present");
								if(stringData.equalsIgnoreCase("checkAccountBlockCode_beforesell"))
								{
									String disbusal_account_no=(String)iformObj.getValue("Q_NG_POS_APPLICATION_DATA_DISBURSAL_ACC_NO");
									if(WFXmlList.getVal("AcctNum").equalsIgnoreCase(disbusal_account_no))
									{
										logger.info("Case 1: For "+getActivityName(iformObj)+" Account status is active and account block code is "+WFXmlList.getVal("AcctBlkCd"));
										block_present++;
										return_string=return_string+"<tr>  <td>"+WFXmlList.getVal("AcctNum")+"</td>  <td>"+WFXmlList.getVal("AcctBlkCd")+"</td>  <td>"+WFXmlList.getVal("AcctBlkDesc")+"</td></tr>";
									}
								}
								else
								{
									logger.info("Case 2: For "+getActivityName(iformObj)+" Account status is active and account block code is "+WFXmlList.getVal("AcctBlkCd"));
									block_present++;
									return_string=return_string+"<tr>  <td>"+WFXmlList.getVal("AcctNum")+"</td>  <td>"+WFXmlList.getVal("AcctBlkCd")+"</td>  <td>"+WFXmlList.getVal("AcctBlkDesc")+"</td></tr>";
								}
								
							}
							
						}
					}
					return_string="Success~"+block_present+"~"+return_string;
				}
				else
				{
					return "Error~Error received in "+callName+" with error code "+objWFxmlResponse.getVal(status_code_split[0])+"and error description is "+objWFxmlResponse.getVal("StatusDesc");
				}
			}
			logger.info("checkAccountBlockCode: return_string is "+ return_string);
			return return_string;
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: Inside checkAccountBlockCode and exception is "+e);
			return "Error~Error in checkAccountBlockCode, please check";
		}
		
	}
	
	private String SIMAHexpiryCheck(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside handling of SIMAHexpiryCheck");
		try
		{
			long days;
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT DATEDIFF(DAY,CAST(REFERENCE_NO AS DATETIME),GETDATE()) FROM NG_POS_SIMAH_BASIC_DETAILS WHERE WI_NAME= '"+wi_name+"'    ";
	        List<List<String>> result=iformObj.getDataFromDB(query);
	        logger.info("For "+wi_name+" using this query we are going to check expiry for SIMAH "+query+" and it's result is "+result);
	        if(result.size()>0)
			{
	        	if(result.get(0).size()>0)
				{
	        		try
	        		{
	        			days=Long.parseLong(result.get(0).get(0));
	        		}
	        		catch(Exception e)
	        		{
	        			days=0;
	        		}
	        		
	        		if(days>=60)
	        		{
	        			return "Expired~"+days;
	        		}
	        		else
	        		{
	        			return "NotExpired~"+days;
	        		}
				}
	        	else
	        	{
	        		return "Expired";
	        	}
			}
	        else
	        {
	        	return "Expired";
	        }
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: SIMAHexpiryCheck and Exception is "+e);
		}
		return "Error~Internal Error in SIMAHexpiryCheck, Please check logs";
	}
	
	private String updateAdminAndBrokerFeesExternalTable(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of updateAdminAndBrokerFeesExternalTable");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="UPDATE NG_POS_EXTTABLE SET ADMIN_FEES=(SELECT FEES_AMNT FROM NG_POS_FEES_CHRGD_GRID WHERE WI_NAME='"+wi_name+"' AND FEES_NAME='Admin fees'),ADMIN_FEES_DISB=(SELECT FEES_AMNT FROM NG_POS_FEES_CHRGD_GRID WHERE WI_NAME='"+wi_name+"' AND FEES_NAME='Admin fees') WHERE WI_NAME='"+wi_name+"'   ";
			iformObj.saveDataInDB(query);
			logger.info("Query to update admin fees for workitem "+wi_name+" is "+query);
			query="UPDATE NG_POS_EXTTABLE SET BROKER_FEES=(SELECT FEES_AMNT FROM NG_POS_FEES_CHRGD_GRID WHERE WI_NAME='"+wi_name+"' AND FEES_NAME='Broker fees'),BROKER_FEES_DISB=(SELECT FEES_AMNT FROM NG_POS_FEES_CHRGD_GRID WHERE WI_NAME='"+wi_name+"' AND FEES_NAME='Broker fees') WHERE WI_NAME='"+wi_name+"'  ";
			iformObj.saveDataInDB(query);
			logger.info("Query to update broker fees for workitem "+wi_name+" is "+query);
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: updateAdminAndBrokerFeesExternalTable and Exception is "+e);
		}
		return "Error~Error in updateAdminAndBrokerFeesExternalTable";
	}

	private String approvedSalesExpiryCheck(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of approvedSalesExpiryCheck");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT IIF(DATEDIFF(DAY,CAST(APPROVED_SALES_ENTRYDATE AS datetime),GETDATE())>90,'true','false') FROM NG_POS_EXTTABLE WHERE WI_NAME= '"+wi_name+"'    ";
	        List<List<String>> result=iformObj.getDataFromDB(query);
	        logger.info("For "+wi_name+" using this query we are going to check expiry for approved sales "+query+" and it's result is "+result);
	        if(result.size()>0)
			{
	        	if(result.get(0).size()>0)
				{
					if(result.get(0).get(0).equalsIgnoreCase("true"))
					{
						return "Success~pass";
					}
					else
					{
						return "Success~fail";
					}
				}
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: approvedSalesExpiryCheck and Exception is "+e);
		}
		return "Error~Error in approvedSalesExpiryCheck";
	}

	private String approvedSalesEntryDateSet(IFormReference iformObj, String stringdata) 
    {
		logger.info("Inside handling of approvedSalesEntryDateSet");
		try
		{ 
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT CONVERT(VARCHAR(40),ENTRYDATE,20) FROM NG_POS_EXTTABLE WHERE WI_NAME= '"+wi_name+"' ";
	        List<List<String>> result=iformObj.getDataFromDB(query);
	        logger.info("For "+wi_name+" using this query we are going to set entry date of approved sales "+query+" and it's result is "+result);
	        if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					query="UPDATE NG_POS_EXTTABLE SET APPROVED_SALES_ENTRYDATE='"+result.get(0).get(0)+"' WHERE WI_NAME= '"+wi_name+"'  ";
					iformObj.saveDataInDB(query);
				}
			}
			return "Success";
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: approvedSalesEntryDateSet and Exception is "+e);
		}
		return "Error~Error in approvedSalesEntryDateSet";
    }
	
	
	private String ReapprovalRemoveMandatoryDoc(IFormReference iformObj, String stringdata) 
    {
		logger.info("Inside handling of ReapprovalRemoveMandatoryDoc");
		try
		{
           String wi_name=getWorkitemName(iformObj);
           String query="DELETE FROM NG_POS_DOCUMENT_GRID WHERE WI_NAME ='"+wi_name+"' and upload_status is null and MANDATORY='Yes' ";
           logger.info("For "+wi_name+" using this query we are deleting existing MandatoryDoc with upload status not success "+query);
           iformObj.saveDataInDB(query);
           return "Success";
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: ReapprovalRemoveMandatoryDoc and Exception is "+e);
		}
		return "Error~Error in ReapprovalRemoveMandatoryDoc";
    }

	
	private String checkTerminalValidationDuringSubmission(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside handling of checkTerminalValidationDuringSubmission");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT BYPASS_TMS_FLAG FROM NG_POS_EXTTABLE WHERE WI_NAME='"+wi_name+"'   ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("For checkTerminalValidationDuringSubmission: Query to BYPASS_TMS_FLAG is "+query+" and it's result is "+result);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					if(result.get(0).get(0).equalsIgnoreCase("true"))
					{
						return "Success~pass";
					}
				}
			}
			
			String merchant_id="",request_type="",request_status="",inner_query="",inner_request_type="",inner_request_status="";
			List<List<String>> inner_result=null;
			query="select  MERCHANT_ID,REQ_TYPE,REQ_STATUS,cast(INSERTIONORDERID as numeric) from NG_POS_TERMINAL_BLOCK where  APPLICATION_NUM = '"+wi_name+"' group by MERCHANT_ID,REQ_TYPE,REQ_STATUS,cast(INSERTIONORDERID as numeric) order by cast(INSERTIONORDERID as numeric) desc ";
			result=iformObj.getDataFromDB(query);
			logger.info("For checkTerminalValidationDuringSubmission : Query to fetch terminals with success status are "+query+" and it's result is "+result);
			for(List<String> list:result)
			{
				for(int i=0;i<list.size();i++)
				{
					merchant_id=list.get(0);
					request_type=list.get(1);
					request_status=list.get(2);
					
					if(request_type.equalsIgnoreCase("block") && request_status.equalsIgnoreCase("Completed"))
					{
						inner_query="select  top 1 MERCHANT_ID,REQ_TYPE,REQ_STATUS from NG_POS_TERMINAL_BLOCK where  MERCHANT_ID='"+merchant_id+"' and APPLICATION_NUM ='"+wi_name+"'   order by cast(INSERTIONORDERID as numeric) desc";
						inner_result=iformObj.getDataFromDB(inner_query);
						logger.info("For checkTerminalValidationDuringSubmission : Query to fetch top row for merchant id "+merchant_id+" is "+inner_query+" and it's result is "+inner_result);

						if(inner_result.size()>0)
						{
							if(inner_result.get(0).size()==3)
							{
								inner_request_type=list.get(1);
								inner_request_status=list.get(2);
								
								if(inner_request_type.equalsIgnoreCase("block") && inner_request_status.equalsIgnoreCase("Completed"))
								{
									return "Success~pass";
								}
							}
						}
					}
				}
			}
			
			return "Success~fail";				
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: checkTerminalValidationDuringSubmission and Exception is "+e);
		}
		return "Error~Error in checkTerminalValidationDuringSubmission";
	}
	
	private String refreshterminalData(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside handling of refreshterminalData");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="INSERT INTO NG_POS_TERMINAL_BLOCK_FAILED (REQ_ID,RSPNS_DATETIME,NGREQ_DATETIME,MERCHANT_ID,CIC,APPLICATION_NUM,BOTPICKUP_DATETIME,STATUS_DESC) SELECT REQ_ID,RSPNS_DATETIME,NGREQ_DATETIME,MERCHANT_ID,CIC,APPLICATION_NUM,BOTPICKUP_DATETIME,STATUS_DESC FROM NG_POS_TERMINAL_BLOCK WHERE APPLICATION_NUM='"+wi_name+"' AND REQ_STATUS!='Completed' AND REQ_STATUS!=''  "; 
			logger.info("Query to maintian audit trail for refreshterminalData is "+query);
			iformObj.saveDataInDB(query);
			query="UPDATE NG_POS_TERMINAL_BLOCK SET REQ_STATUS='',BOTPICKUP_DATETIME='',STATUS_DESC='',RSPNS_DATETIME='' WHERE APPLICATION_NUM='"+wi_name+"' AND REQ_STATUS!='Completed' AND REQ_STATUS!=''  ";
			logger.info("Query to refreshterminalData is "+query);
			iformObj.saveDataInDB(query);
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: refreshterminalData and Exception is "+e);
		}
		
		return "Success~refreshterminalData";
	}
	
	private String transferMerchantDataForTMS(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside handling of transferMerchantDataForTMS");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String timestamp="";//=new Timestamp(System.currentTimeMillis()).toString();
	       // timestamp=timestamp.replace(" ","").replace("-","").replace(":","").replace(".","").replace("/","");
			String req_id="";//timestamp;
			String customer_name=(String)iformObj.getValue("Q_NG_POS_COMPANY_DATA_NAME_OF_ENITITY_ENG");
			List merchant_id_list;
			String merchant_id="";
			String date_of_Expiry="",cic="",cr_no="",unn_no="",tenure="",amount="";
			cic=(String)iformObj.getValue("PADDED_CIC_NO");
			cr_no=(String)iformObj.getValue("Q_NG_POS_COMPANY_DATA_CR_NUMBER");
			unn_no=(String)iformObj.getValue("Q_NG_POS_COMPANY_DATA_UNN_NO");
			amount=(String)iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
			tenure=(String)iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
			date_of_Expiry="";//Last Repayment Schedule
			
			if(unn_no==null || unn_no.length()==0 )
			{
				unn_no=cr_no;
			}

			String query="select top 1 a.last_inst_date from (select top 1 convert(date,INSTALMENT_DATE,104) as last_inst_date,format(CAST(instalment_amount  AS float) ,'N') as INSTALMENT_AMT from NG_POS_DISBURSAL_DATA_INSTALMENT_DETAILS_GRID where wi_name ='"+wi_name+"' ORDER BY cast(INSTALMENT_NO as numeric) desc union select top 1 convert(date,INSTALMENT_DATE,104) as last_inst_date,format(CAST(instalment_amount  AS float) ,'N') as INSTALMENT_AMT from NG_POS_INSTALMENT_DETAILS_GRID where wi_name='"+wi_name+"' ORDER BY cast(INSTALMENT_NO as numeric) desc) a order by a.last_inst_date desc";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("For transferMerchantDataForTMS: Query to fetch last date is "+query+" and it's result is "+result);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					date_of_Expiry=result.get(0).get(0);
				}
			}
			
			query="SELECT DISTINCT MERCHANT_NUMBER FROM NG_POS_MERCHANT_DETAILS_GRID WHERE WI_NAME='"+wi_name+"' ";
			List<List<String>> output=iformObj.getDataFromDB(query);
			logger.info("For transferMerchantDataForTMS: Query to fetch merchant number is "+query+" and it's result is "+output);
			for(List<String> merchant_number: output)
			{
				timestamp=new Timestamp(System.currentTimeMillis()).toString();
		        timestamp=timestamp.replace(" ","").replace("-","").replace(":","").replace(".","").replace("/","");
				req_id=timestamp+wi_name;
				query="INSERT INTO NG_POS_TERMINAL_BLOCK(REQ_ID,CUSTOMER_NAME,MERCHANT_ID,DATE_OF_EXPIRY,CIC,UNN_NO,CR_NUM,FACILITIES_TENOR,UTILISATION_DATE,AMOUNT,REQ_TYPE,REQ_STATUS,APPLICATION_NUM,NGREQ_DATETIME,BOTPICKUP_DATETIME,STATUS_DESC,RSPNS_DATETIME) VALUES('"+req_id+"','"+customer_name+"','"+merchant_number.get(0)+"','"+date_of_Expiry+"','"+cic+"','"+unn_no+"','"+cr_no+"','"+tenure+"',GETDATE(),'"+amount+"','block','','"+wi_name+"',GETDATE(),'','','')   ";
				logger.info("Query to insert into terminal block is "+query);
				iformObj.saveDataInDB(query);
			}
	
			hideShowRetryBlockingButton( iformObj,  stringdata) ;
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: transferMerchantDataForTMS and Exception is "+e);
		}
		
		return "Success~transferMerchantDataForTMS";
	}
	
	private String transferMerchantDataForTMS_cancelcommodity(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside handling of transferMerchantDataForTMS_cancelcommodity");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String request_type=(String)iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
			if(request_type.equalsIgnoreCase("Top-Up Request"))
			{
				logger.info("As request type is Top-Up Request, we are not unblocking the terminals for "+wi_name);
				return "Success~transferMerchantDataForTMS_cancelcommodity :: Not updated because request type is Top-Up Request ";
			}
			String timestamp="";//=new Timestamp(System.currentTimeMillis()).toString();
	       // timestamp=timestamp.replace(" ","").replace("-","").replace(":","").replace(".","").replace("/","");
			String req_id="";//timestamp;
			String customer_name=(String)iformObj.getValue("Q_NG_POS_COMPANY_DATA_NAME_OF_ENITITY_ENG");
			List merchant_id_list;
			String merchant_id="";
			String date_of_Expiry="",cic="",cr_no="",unn_no="",tenure="",amount="";
			cic=(String)iformObj.getValue("PADDED_CIC_NO");
			cr_no=(String)iformObj.getValue("Q_NG_POS_COMPANY_DATA_CR_NUMBER");
			unn_no=(String)iformObj.getValue("Q_NG_POS_COMPANY_DATA_UNN_NO");
			amount=(String)iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
			tenure=(String)iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
			date_of_Expiry="";//Last Repayment Schedule

			String query="select top 1 a.last_inst_date from (select top 1 convert(date,INSTALMENT_DATE,104) as last_inst_date,format(CAST(instalment_amount  AS float) ,'N') as INSTALMENT_AMT from NG_POS_DISBURSAL_DATA_INSTALMENT_DETAILS_GRID where wi_name ='"+wi_name+"' ORDER BY cast(INSTALMENT_NO as numeric) desc union select top 1 convert(date,INSTALMENT_DATE,104) as last_inst_date,format(CAST(instalment_amount  AS float) ,'N') as INSTALMENT_AMT from NG_POS_INSTALMENT_DETAILS_GRID where wi_name='"+wi_name+"' ORDER BY cast(INSTALMENT_NO as numeric) desc) a order by a.last_inst_date desc";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("For transferMerchantDataForTMS: Query to fetch last date is "+query+" and it's result is "+result);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					date_of_Expiry=result.get(0).get(0);
				}
			}
			
			query="SELECT DISTINCT MERCHANT_NUMBER FROM NG_POS_MERCHANT_DETAILS_GRID WHERE WI_NAME='"+wi_name+"' ";
			List<List<String>> output=iformObj.getDataFromDB(query);
			logger.info("For transferMerchantDataForTMS: Query to fetch merchant number is "+query+" and it's result is "+output);
			for(List<String> merchant_number: output)
			{
				timestamp=new Timestamp(System.currentTimeMillis()).toString();
		        timestamp=timestamp.replace(" ","").replace("-","").replace(":","").replace(".","").replace("/","");
				req_id=timestamp+wi_name;
				query="INSERT INTO NG_POS_TERMINAL_BLOCK(REQ_ID,CUSTOMER_NAME,MERCHANT_ID,DATE_OF_EXPIRY,CIC,UNN_NO,CR_NUM,FACILITIES_TENOR,UTILISATION_DATE,AMOUNT,REQ_TYPE,REQ_STATUS,APPLICATION_NUM,NGREQ_DATETIME,BOTPICKUP_DATETIME,STATUS_DESC,RSPNS_DATETIME) VALUES('"+req_id+"','"+customer_name+"','"+merchant_number.get(0)+"',GETDATE(),'"+cic+"','"+unn_no+"','"+cr_no+"','"+tenure+"',GETDATE(),'"+amount+"','unblock','','"+wi_name+"',GETDATE(),'','','')   ";
				logger.info("Query to insert into terminal block is "+query);
				iformObj.saveDataInDB(query);
			}
	
			hideShowRetryBlockingButton( iformObj,  stringdata) ;
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: transferMerchantDataForTMS_cancelcommodity and Exception is "+e);
		}
		
		return "Success~transferMerchantDataForTMS_cancelcommodity";
	}
	
	
	private String hideShowRetryBlockingButton(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of hideShowRetryBlockingButton");
		String return_string="";
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT COUNT(1) FROM NG_POS_TERMINAL_BLOCK WHERE APPLICATION_NUM='"+wi_name+"' AND REQ_STATUS!='Completed'  ";
			List<List<String>> output=iformObj.getDataFromDB(query);
			int count=0;
			logger.info("For hideShowRetryBlockingButton: Query to fetch failed merchant number is "+query+" and it's result is "+output);
			if(output.size()>0)
			{
				if(output.get(0).size()>0)
				{
					count=Integer.parseInt(output.get(0).get(0));					
				}
			}
			
			if(count>0)
			{
				return_string=" Request Status Fail is present in Terminal Table";
				iformObj.setStyle("RETRY_BLOCK_UNBLOCK","disable","false");
				iformObj.setStyle("RETRY_BLOCK_UNBLOCK","visible","true");

			}
			else
			{
				return_string=" Request Status Fail is absent in Terminal Table";				
				iformObj.setStyle("RETRY_BLOCK_UNBLOCK","disable","true");
				iformObj.setStyle("RETRY_BLOCK_UNBLOCK","visible","false");
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: hideShowRetryBlockingButton and Exception is "+e);
		}
		return "success~"+return_string;
	}
	
	private String cancelCommoditycall(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of updateLimitAfterReapproval");
		try
		{
			String ddcap_cancel_flag=(String) iformObj.getValue("DDCAP_CANCEL_FLAG");
			String contractmng_cancel_flag=(String) iformObj.getValue("CONTRACT_CANCEL_FLAG");
			String callName="",responseXML="",return_string="";
		
				callName = "DDCAP_Cancel";
				responseXML = createRequestXML(iformObj, callName);
				JSONObject jobj2 = setResponseData_2(iformObj, callName, responseXML);
				logger.info("Inside DDCAP_Cancel call "+jobj2);
				return_string ="Success~CancelCommodity executed";

				for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
				{
					String key = (String) iterator.next();
					if(key.equalsIgnoreCase("Error"))
					{
						return_string="Error~"+jobj2.get(key).toString();
						return return_string;
					}
					else
					{
						logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
						//setControlValue(iformObj, key, jobj2.get(key).toString());
					}
				}
				logger.info("For DDCAP_Cancel object is "+jobj2);
			
			
			
				callName = "MSBCommodityMngRq_ManualCancel";
				responseXML = createRequestXML(iformObj, callName);
				JSONObject jobj3 = setResponseData_2(iformObj, callName, responseXML);
				logger.info("Inside MSBCommodityMngRq_ManualCancel call "+jobj3);
	
				for(Iterator iterator = jobj3.keySet().iterator(); iterator.hasNext();)
				{
					String key = (String) iterator.next();
					if(key.equalsIgnoreCase("Error"))
					{
						return_string="Error~"+jobj3.get(key).toString();
						return return_string;
					}
					else
					{
						logger.info("Values set for"+key+" are "+jobj3.get(key).toString());
						setControlValue(iformObj, key, jobj3.get(key).toString());
					}
				}
				logger.info("For MSBCommodityMngRq_ManualCancel is "+jobj3);

		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: cancelCommoditycall and Exception is "+e);
		}
		
		return "Success~cancelCommoditycall";
	}
	
	private String updateLimitAfterReapproval(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of updateLimitAfterReapproval");
		String return_string="Success~updateLimitAfterReapproval executed";
		String wi_name=getWorkitemName(iformObj);
		String amount=(String) iformObj.getValue("Q_NG_POS_DISBURSAL_DATA_DISBURSAL_AMT");
		String query="";
		
		String limit_enable_flag=(String) iformObj.getValue("LIMIT_ENABLE_UPDATE_FLAG");
		String limit_create_flag=(String) iformObj.getValue("LIMIT_CREATE_UPDATE_FLAG");
		String contract_update_flag=(String) iformObj.getValue("CONTRACT_UPDATE_FLAG");

		String call_name="",responseXML="";
		JSONObject jobj2;
		
		try
		{
		
		if(!limit_create_flag.equalsIgnoreCase("Y"))
		{
			call_name="MSBLimitMng_Create_Update";
			responseXML ="";
			//one
			try
			{
				logger.info("Inside createRequestXML Function and callName is " + call_name);
				String tagName = "_TagName";
				
				String request_prefix=GetXML.getProp().getProperty(call_name+"_RequestPrefix");
				if(request_prefix.equals(null))
				{
					request_prefix="";
				}
				logger.info("Request prefix is "+request_prefix+"please check");
				
				String header_tags=GetXML.getProp().getProperty(call_name+"_Header");
				String []header_tags_arry=header_tags.split(",");
				
				logger.info("Header tags are "+header_tags);
				JSONObject jsonobj_header=new JSONObject();
				for(String temp:header_tags_arry)
				{
					String[] hash_split=temp.split("#");
					jsonobj_header.put(hash_split[0],hash_split[1]);
				}
				
				logger.info("JSOn object is "+jsonobj_header);
			
				String tagNames = GetXML.getProp().getProperty(call_name + tagName);
				logger.info(tagNames);
				String[] tags = tagNames.split(",");
		
				String requestXML = readDummyRequest(call_name);
		
				XMLParser parser = new XMLParser(requestXML);
				
		
				for (String tag : tags) 
				{
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
					//String amount=(String) iformObj.getValue("Q_NG_POS_DISBURSAL_DATA_DISBURSAL_AMT");
					parser.changeValue(request_prefix+"ApprovedAmt",amount);
					
					/* //Removing logic for expiry date.
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
					parser.changeValue(request_prefix+"ExpiryDate",expiry_date);
					*/
				}
				
				logger.info("CreateRequestXML :Handling Language in Request ");
				logger.info("Language tag for "+call_name+" present in proerty file or not ??? "+GetXML.getProp().containsKey(call_name+"_LanguageTag"));
				if(GetXML.getProp().containsKey(call_name+"_LanguageTag"))
				{
					logger.info("CreateRequestXML : Language tag is present in property file");
					String language_tag=GetXML.getProp().getProperty(call_name+"_LanguageTag");
					logger.info("CreateRequestXML : Language tag value in property file is "+language_tag);
					String session_lang=(String) iformObj.getValue("SESSION_LANG");
					logger.info("CreateRequestXML : Session Language is "+session_lang);
					parser.changeValue(request_prefix+language_tag, session_lang);
					logger.info(request_prefix+language_tag+" got value "+session_lang);
				}
				
				logger.info("Request prefix is "+request_prefix+"please check");
				
				
				System.out.println("RequestXML is :\n" + parser.toString());
				logger.info("RequestXML is :\n" + parser.toString());
				responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), call_name,iformObj);
				System.out.println("Response XML is: \n" + responseXML);
					//logger.info("Response XML is: \n" + responseXML)
				}
				catch(Exception e)
				{
					logger.info("Exception occurred: createRequestXML "+e);
					return "Exception Occurred: ";
				}
			
			jobj2 = setResponseData_2(iformObj, call_name, responseXML);
			logger.info("Inside updateLimitAfterReapproval for call"+call_name+" result is"+jobj2);
			for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
			{
				String key = (String) iterator.next();
				if(key.equalsIgnoreCase("Error"))
				{
					return_string="Error~"+jobj2.get(key).toString();
					return return_string;
				}
				else
				{
					logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
					setControlValue(iformObj, key, "Y");
					limit_create_flag="Y";
					query="UPDATE NG_POS_EXTTABLE SET LIMIT_CREATE_UPDATE_FLAG='Y' WHERE WI_NAME='"+wi_name+"' ";
					logger.info("Query for updating limit create update flag is "+query);
					saveDataInDB(iformObj,query);
				}
			}
		}
			
			//Two
			if(!limit_enable_flag.equalsIgnoreCase("Y"))
			{
			try
			{
				call_name="MSBLimitMng_Enable_Update";
				logger.info("Inside createRequestXML Function and callName is " + call_name);
				String tagName = "_TagName";
				
				String request_prefix=GetXML.getProp().getProperty(call_name+"_RequestPrefix");
				if(request_prefix.equals(null))
				{
					request_prefix="";
				}
				logger.info("Request prefix is "+request_prefix+"please check");
				
				String header_tags=GetXML.getProp().getProperty(call_name+"_Header");
				String []header_tags_arry=header_tags.split(",");
				
				logger.info("Header tags are "+header_tags);
				JSONObject jsonobj_header=new JSONObject();
				for(String temp:header_tags_arry)
				{
					String[] hash_split=temp.split("#");
					jsonobj_header.put(hash_split[0],hash_split[1]);
				}
				
				logger.info("JSOn object is "+jsonobj_header);
			
				String tagNames = GetXML.getProp().getProperty(call_name + tagName);
				logger.info(tagNames);
				String[] tags = tagNames.split(",");
		
				String requestXML = readDummyRequest(call_name);
		
				XMLParser parser = new XMLParser(requestXML);
				
		
				for (String tag : tags) 
				{
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
					
					parser.changeValue(request_prefix+"ApprovedAmt",amount);
					/* //Removing logic for expiry date.
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
					parser.changeValue(request_prefix+"ExpiryDate",expiry_date);
					*/
				}
				
				logger.info("CreateRequestXML :Handling Language in Request ");
				logger.info("Language tag for "+call_name+" present in proerty file or not ??? "+GetXML.getProp().containsKey(call_name+"_LanguageTag"));
				if(GetXML.getProp().containsKey(call_name+"_LanguageTag"))
				{
					logger.info("CreateRequestXML : Language tag is present in property file");
					String language_tag=GetXML.getProp().getProperty(call_name+"_LanguageTag");
					logger.info("CreateRequestXML : Language tag value in property file is "+language_tag);
					String session_lang=(String) iformObj.getValue("SESSION_LANG");
					logger.info("CreateRequestXML : Session Language is "+session_lang);
					parser.changeValue(request_prefix+language_tag, session_lang);
					logger.info(request_prefix+language_tag+" got value "+session_lang);
				}
				
				logger.info("Request prefix is "+request_prefix+"please check");
				
				
				System.out.println("RequestXML is :\n" + parser.toString());
				logger.info("RequestXML is :\n" + parser.toString());
				responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), call_name,iformObj);
				System.out.println("Response XML is: \n" + responseXML);
					//logger.info("Response XML is: \n" + responseXML)
				}
				catch(Exception e)
				{
					logger.info("Exception occurred: createRequestXML "+e);
					return "";
				}
			
			jobj2 = setResponseData_2(iformObj, call_name, responseXML);
			logger.info("Inside updateLimitAfterReapproval for call"+call_name+" result is"+jobj2);
			for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
			{
				String key = (String) iterator.next();
				if(key.equalsIgnoreCase("Error"))
				{
					return_string="Error~"+jobj2.get(key).toString();
					return return_string;
				}
				else
				{
					logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
					setControlValue(iformObj, key, "Y");
					limit_enable_flag="Y";
					query="UPDATE NG_POS_EXTTABLE SET LIMIT_ENABLE_UPDATE_FLAG='Y' WHERE WI_NAME='"+wi_name+"' ";
					logger.info("Query for updating limit enable update flag is "+query);
					saveDataInDB(iformObj,query);
				}
			}
		}
			
		
		query="SELECT req_amt_before_reapproval FROM NG_POS_EXTTABLE WHERE WI_NAME = '"+wi_name+"'  ";
		List<List<String>> req_amount_before_approval_list=iformObj.getDataFromDB(query);
		logger.info(" Requested Amount Before Approval is : "+req_amount_before_approval_list);
		double req_amount_before_approval=0;
		try
		{
			if(req_amount_before_approval_list.size()>0)
			{
				if(req_amount_before_approval_list.get(0).size()>0)
				{
					req_amount_before_approval=Double.parseDouble(req_amount_before_approval_list.get(0).get(0));
				}
			}
		}
		catch(Exception e)
		{
			req_amount_before_approval=0;
		}
		String requested_amount_string=amount;
		double requested_amount=0;
		try
		{
			requested_amount=Double.parseDouble(requested_amount_string);
		}
		catch(Exception e)
		{
			requested_amount=0;
		}
		logger.info(" Disbursal amount is : "+req_amount_before_approval_list);
		if(requested_amount>=req_amount_before_approval)
		{
			//increase
			call_name="MSBContractMng_Increase";
		}
		else
		{
			//call_name="MSBContractMng_Decrease"; 
			call_name="MSBContractMng_Increase";
		}
		
		logger.info("");
		
		
		if(!contract_update_flag.equalsIgnoreCase("Y"))
		{
			logger.info("Inside createRequestXML Function and callName is " + call_name);
			String tagName = "_TagName";
			
			String request_prefix=GetXML.getProp().getProperty(call_name+"_RequestPrefix");
			if(request_prefix.equals(null))
			{
				request_prefix="";
			}
			logger.info("Request prefix is "+request_prefix+"please check");
			
			String header_tags=GetXML.getProp().getProperty(call_name+"_Header");
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
		
			String tagNames = GetXML.getProp().getProperty(call_name + tagName);
			logger.info(tagNames);
			String[] tags = tagNames.split(",");
	
			String requestXML = readDummyRequest(call_name);
	
			XMLParser parser = new XMLParser(requestXML);
			
	
			for (String tag : tags) 
			{
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
				
				parser.changeValue(request_prefix+"ChangedAmount",amount);
			}
			
			logger.info("CreateRequestXML :Handling Language in Request ");
			logger.info("Language tag for "+call_name+" present in proerty file or not ??? "+GetXML.getProp().containsKey(call_name+"_LanguageTag"));
			if(GetXML.getProp().containsKey(call_name+"_LanguageTag"))
			{
				logger.info("CreateRequestXML : Language tag is present in property file");
				String language_tag=GetXML.getProp().getProperty(call_name+"_LanguageTag");
				logger.info("CreateRequestXML : Language tag value in property file is "+language_tag);
				String session_lang=(String) iformObj.getValue("SESSION_LANG");
				logger.info("CreateRequestXML : Session Language is "+session_lang);
				parser.changeValue(request_prefix+language_tag, session_lang);
				logger.info(request_prefix+language_tag+" got value "+session_lang);
			}
			
			logger.info("Request prefix is "+request_prefix+"please check");
			
			
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML is :\n" + parser.toString());
			responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), call_name,iformObj);	
			
			//responseXML = createRequestXML(iformObj, call_name);
				jobj2 = setResponseData_2(iformObj, call_name, responseXML);
				logger.info("Inside submitForReapproval for call"+call_name+" result is"+jobj2);
				for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
				{
					String key = (String) iterator.next();
					if(key.equalsIgnoreCase("Error"))
					{
						return_string="Error~"+jobj2.get(key).toString();
						return return_string;
					}
					else
					{
						logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
						setControlValue(iformObj, key,"Y");
						contract_update_flag="Y";
						query="UPDATE NG_POS_EXTTABLE SET CONTRACT_UPDATE_FLAG='Y' WHERE WI_NAME='"+wi_name+"' ";
						logger.info("Query for updating contract update flag is "+query);
						saveDataInDB(iformObj,query);
					}
				}
		}
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: updateLimitAfterReapproval and exception is "+e);
			return "Error~updateLimitAfterReapproval Error";
		}
	return return_string;
	}
	
	
	
	private String submitForReapproval(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of submitForReapproval");
		String return_string="Success~submitForReapproval executed";
		String wi_name=getWorkitemName(iformObj);
		try
		{
			
			String purchase_status=(String) iformObj.getValue("Q_NG_DIS_COMMODITY_PURCHASE_DEAL_KEY");
			String confirm_purchase_status=(String) iformObj.getValue("BUY_COMM_CONFIRM_STATUS");
			
			String reapproval_flag=(String) iformObj.getValue("REAPPROVAL_FLAG");
			
			String contract_update_flag=(String) iformObj.getValue("CONTRACT_UPDATE_FLAG");
			String limit_enable_flag=(String) iformObj.getValue("LIMIT_ENABLE_UPDATE_FLAG");
			String limit_create_flag=(String) iformObj.getValue("LIMIT_CREATE_UPDATE_FLAG");

			String master_contract_flag=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REF_NO_MASTER_AGRMNT");
			String enable_limit_flag=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_LIMIT_REF_PARENT");
			String create_limit_flag=(String) iformObj.getValue("T24_LIMIT_REF");
			
			/*
			if(contract_update_flag.equalsIgnoreCase("I000000") && limit_create_flag.equalsIgnoreCase("I000000") && limit_enable_flag.equalsIgnoreCase("I000000") && reapproval_flag.equalsIgnoreCase("true"))
			{
				logger.info("As update limit has already happened for this workitem we are clearing their status from exttable.");
				String query="UPDATE NG_POS_EXTTABLE SET LIMIT_CREATE_UPDATE_FLAG='',LIMIT_ENABLE_UPDATE_FLAG='',CONTRACT_UPDATE_FLAG='' WHERE WI_NAME='"+wi_name+"' ";
				logger.info("For "+wi_name+" using this query we are updating variables in external table "+query);
				iformObj.setValue("LIMIT_CREATE_UPDATE_FLAG", "");
				iformObj.setValue("LIMIT_ENABLE_UPDATE_FLAG", "");
				iformObj.setValue("CONTRACT_UPDATE_FLAG", "");
				
				contract_update_flag="";
				limit_enable_flag="";
				limit_create_flag="";
				iformObj.saveDataInDB(query);
			}
			 */
			
			String call_name="",responseXML="";
			JSONObject jobj2;
			
			if(purchase_status.equalsIgnoreCase("") && confirm_purchase_status.equalsIgnoreCase(""))
			{
				if(!contract_update_flag.equalsIgnoreCase("Z") && master_contract_flag.length()>0)
				{
					call_name="MSBContractMng_Decrease";
					responseXML = createRequestXML(iformObj, call_name);
					jobj2 = setResponseData_2(iformObj, call_name, responseXML);
					logger.info("Inside submitForReapproval for call"+call_name+" result is"+jobj2);
					

					for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
					{
						String key = (String) iterator.next();
						if(key.equalsIgnoreCase("Error"))
						{
							return_string="Error~"+jobj2.get(key).toString();
							return return_string;
						}
						else
						{
							logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
							setControlValue(iformObj, key,"Z");
							contract_update_flag="Z";
						}
					}
				}
				
				//limit_enable_flag=(String) iformObj.getValue("LIMIT_ENABLE_UPDATE_FLAG");	
				if(!limit_enable_flag.equalsIgnoreCase("Z") && enable_limit_flag.length()>0)
				{
					call_name="MSBLimitMng_Enable_Update";
					responseXML = createRequestXML(iformObj, call_name);
					jobj2 = setResponseData_2(iformObj, call_name, responseXML);
					logger.info("Inside submitForReapproval for call"+call_name+" resutl is"+jobj2);
					for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
					{
						String key = (String) iterator.next();
						if(key.equalsIgnoreCase("Error"))
						{
							return_string="Error~"+jobj2.get(key).toString();
						return return_string;
						}
						else
						{
							logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
							setControlValue(iformObj, key,"Z");
							limit_enable_flag="Z";
						}
					}
				}
				
				//limit_create_flag=(String) iformObj.getValue("LIMIT_CREATE_UPDATE_FLAG");
				if(!limit_create_flag.equalsIgnoreCase("Z") && create_limit_flag.length()>0 )
				{
					call_name="MSBLimitMng_Create_Update";
					responseXML = createRequestXML(iformObj, call_name);
					jobj2 = setResponseData_2(iformObj, call_name, responseXML);
					logger.info("Inside submitForReapproval for call"+call_name+" resutl is"+jobj2);
					for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
					{
						String key = (String) iterator.next();
						if(key.equalsIgnoreCase("Error"))
						{
							return_string="Error~"+jobj2.get(key).toString();
							return return_string;
						}
						else
						{
							logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
							setControlValue(iformObj, key, "Z");
							limit_create_flag="Z";
						}
					}
				}
			
				
				if(contract_update_flag.equalsIgnoreCase("Z") && limit_enable_flag.equalsIgnoreCase("Z") && limit_create_flag.equalsIgnoreCase("Z") )
				{
					 dataTansferForReapproval(iformObj, stringdata);
					 String query="UPDATE NG_POS_EXTTABLE SET REAPPROVAL_FLAG='true' WHERE WI_NAME='"+wi_name+"'   ";
					logger.info("For "+wi_name+" using this query we are updating reapproval flag in external table "+query);
					iformObj.saveDataInDB(query);
				}
				/*else
				{
					logger.info("Ideally, control should never come here. ");
					return "Error~ Invalid scenario for reapproval";
				}*/
				
			}
			else
			{
				return_string="Error~Purchase of Commodity has already happened hence reapproval is not possible";
			}
				
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: submitForReapproval and exception is "+e);
			return "Error~submitForReapproval Error";
		}
		return return_string;
	}

	private String dataTansferForReapproval(IFormReference iformObj, String stringdata) 
	{
		String wi_name=getWorkitemName(iformObj);
		String query="DELETE FROM NG_POS_PQLIST_STATUS_GRID_reapproval WHERE WI_NAME ='"+wi_name+"'  ";
		logger.info("For "+wi_name+" using this query we are deleting existing pq reqapproval table "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_PQLIST_STATUS_GRID_reapproval (WI_NAME,PQ_DESCRIPTION,PQ_TYPE,PQ_CATEGORY,PQ_STATUS,PQ_REMARKS,minimum_level,minimum_level_credit,PQ_FAIL_IDENTIFICATION,PQ_DESCRIPTION_ARABIC) SELECT WI_NAME,PQ_DESCRIPTION,PQ_TYPE,PQ_CATEGORY,PQ_STATUS,PQ_REMARKS,minimum_level,minimum_level_credit,PQ_FAIL_IDENTIFICATION,PQ_DESCRIPTION_ARABIC FROM NG_POS_PQLIST_STATUS_GRID WHERE WI_NAME ='"+wi_name+"'  ";
		logger.info("For "+wi_name+" using this query we are inserting in pq reqapproval table "+query);
		iformObj.saveDataInDB(query);
		
		query="DELETE FROM NG_POS_RELATED_PARTY_ROLES_GRID_REAPPROVAL WHERE WI_NAME ='"+wi_name+"'  ";
		logger.info("For "+wi_name+" using this query we are deleting existing related party reqapproval table "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_RELATED_PARTY_ROLES_GRID_REAPPROVAL(WI_NAME,CIC_NO,PARENT_CIC,CHILD_CIC,ROLE_DESCRIPTION,PERCENTAGE,PARTY_TYPE,NAME_ENG,NAME_AR,GROUP_DESCRIPTION,CR,UNN,CICStatus,RegisterDate,Establishate,entityName,entityNameOther,entityTypeCd,entityTypeDesc,CountryCd,SectorCd,SubSectorCd,SamaSectorDesc,BankSectorDesc,ActivityDesc,SubSectorDesc,RegTypeCd,RegTypeDesc,entityCityName,entityRegionCd,entityCountryCd,entitySAMASectorCd,FirstNameAR,SecondNameAR,FamilyNameAR,FirstNameEN,SecondNameEN,FamilyNameEN,Nationality,BirthDate,Age,MaritalStatus,MaritalStatusDesc,AddressBuildingNumber,AddressUnitNumber,AddressStreetName,AddressRegion,AddressCityCd,AddressCityName,AddressAdditionalNumber,AddressPostalCd,PrefContactNo,MobileNum,PartyStatusDesc,NationalityDesc,AUTHORIZED_SIGNATORY,SIMAH_REQUIRED,ID_NUMBER,ID_ISSUE_DATE,ID_EXPIRY_DATE,GENDER,ROLE_TYPE,DESIGNATION,PARENT_CR,PERSONAL_GUARANTEE,STREET_NAME_ENG,STREET_NAME_AR,DISTRICT_NAME_ENG,DISTRICT_NAME_AR,ENTITY_TYPE,CAPITAL_AMT,PAID_CAPITAL_AMT,CONSENT_FORM_STATUS,SIMAH_STATUS,SUCCESSOR_FOR) SELECT WI_NAME,CIC_NO,PARENT_CIC,CHILD_CIC,ROLE_DESCRIPTION,PERCENTAGE,PARTY_TYPE,NAME_ENG,NAME_AR,GROUP_DESCRIPTION,CR,UNN,CICStatus,RegisterDate,Establishate,entityName,entityNameOther,entityTypeCd,entityTypeDesc,CountryCd,SectorCd,SubSectorCd,SamaSectorDesc,BankSectorDesc,ActivityDesc,SubSectorDesc,RegTypeCd,RegTypeDesc,entityCityName,entityRegionCd,entityCountryCd,entitySAMASectorCd,FirstNameAR,SecondNameAR,FamilyNameAR,FirstNameEN,SecondNameEN,FamilyNameEN,Nationality,BirthDate,Age,MaritalStatus,MaritalStatusDesc,AddressBuildingNumber,AddressUnitNumber,AddressStreetName,AddressRegion,AddressCityCd,AddressCityName,AddressAdditionalNumber,AddressPostalCd,PrefContactNo,MobileNum,PartyStatusDesc,NationalityDesc,AUTHORIZED_SIGNATORY,SIMAH_REQUIRED,ID_NUMBER,ID_ISSUE_DATE,ID_EXPIRY_DATE,GENDER,ROLE_TYPE,DESIGNATION,PARENT_CR,PERSONAL_GUARANTEE,STREET_NAME_ENG,STREET_NAME_AR,DISTRICT_NAME_ENG,DISTRICT_NAME_AR,ENTITY_TYPE,CAPITAL_AMT,PAID_CAPITAL_AMT,CONSENT_FORM_STATUS,SIMAH_STATUS,SUCCESSOR_FOR FROM NG_POS_RELATED_PARTY_ROLES_GRID WHERE WI_NAME='"+wi_name+"' ";
		logger.info("For "+wi_name+" using this query we are inserting in related party reqapproval table "+query);
		iformObj.saveDataInDB(query);

		query="UPDATE NG_POS_EXTTABLE SET req_amt_before_reapproval=(SELECT REQ_AMNT_SAR FROM NG_POS_APPLICATION_dATA  WHERE WI_NAME='"+wi_name+"') WHERE WI_NAME='"+wi_name+"'   ";
		logger.info("For "+wi_name+" using this query we are updating req_amt_before_reapproval in external table "+query);
		iformObj.saveDataInDB(query);
	
		query="DELETE FROM NG_POS_APPLICATION_DATA_REAPPROVAL WHERE WI_NAME ='"+wi_name+"'  ";
		logger.info("For "+wi_name+" using this query we are deleting existing related party reqapproval table "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_APPLICATION_DATA_REAPPROVAL SELECT * FROM NG_POS_APPLICATION_DATA WHERE WI_NAME='"+wi_name+"' ";
		logger.info("For "+wi_name+" using this query we are updating req_amt_before_reapproval in external table "+query);
		iformObj.saveDataInDB(query);
		
		query="DELETE FROM NG_POS_FEES_CHRGD_GRID_REAPPROVAL WHERE WI_NAME ='"+wi_name+"'  ";
		logger.info("For "+wi_name+" using this query we are deleting existing related party reqapproval table "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_FEES_CHRGD_GRID_REAPPROVAL (WI_NAME,FEES_NAME,FEES_METHOD,FEES_TYPE,FEES_PER,FEES_AMNT,VAT_FEES,TOTAL_FEES) SELECT WI_NAME,FEES_NAME,FEES_METHOD,FEES_TYPE,FEES_PER,FEES_AMNT,VAT_FEES,TOTAL_FEES FROM NG_POS_FEES_CHRGD_GRID WHERE WI_NAME='"+wi_name+"' ";
		logger.info("For "+wi_name+" using this query we are updating NG_POS_FEES_CHRGD_GRID_REAPPROVAL in external table "+query);
		iformObj.saveDataInDB(query);

		query="DELETE FROM NG_POS_SITE_VISIT_REAPPROVAL WHERE WI_NAME ='"+wi_name+"'  ";
		logger.info("For "+wi_name+" using this query we are deleting existing related party reqapproval table "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_SITE_VISIT_REAPPROVAL SELECT * FROM NG_POS_SITE_VISIT WHERE WI_NAME='"+wi_name+"' ";
		logger.info("For "+wi_name+" using this query we are updating req_amt_before_reapproval in external table "+query);
		iformObj.saveDataInDB(query);
		
		query="DELETE FROM NG_POS_BUSINESS_DATA_REAPPROVAL WHERE WI_NAME ='"+wi_name+"'  ";
		logger.info("For "+wi_name+" using this query we are deleting data from NG_POS_BUSINESS_DATA_REAPPROVAL "+query);
		iformObj.saveDataInDB(query);
		
		query="INSERT INTO NG_POS_BUSINESS_DATA_REAPPROVAL SELECT * FROM NG_POS_BUSINESS_DATA WHERE WI_NAME='"+wi_name+"' ";
		logger.info("For "+wi_name+" using this query we are inserting into NG_POS_BUSINESS_DATA_REAPPROVAL in external table "+query);
		iformObj.saveDataInDB(query);
		
		/*
		query="INSERT INTO NG_POS_REAPPROVAL_STATUS SELECT WI_NAME,LIMIT_CREATE_UPDATE_FLAG,LIMIT_ENABLE_UPDATE_FLAG,CONTRACT_UPDATE_FLAG,GETDATE() FROM NG_POS_EXTTABLE WHERE WI_NAME='"+wi_name+"' ";
		logger.info("For "+wi_name+" using this query we are updating req_amt_before_reapproval in external table "+query);
		iformObj.saveDataInDB(query);
		*/

		return "";
	}
	private String sitevisitmandatorydocumentCheck(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of sitevisitmandatorydocumentCheck");
		try
		{
		
		String wi_name=getWorkitemName(iformObj);
		String query="select count(1) from NG_POS_SITE_VISIT where wi_name = '"+wi_name+"' and SITE_VISIT_REQUIRED ='true'";
		List<List<String>> result=iformObj.getDataFromDB(query);
		logger.info("Query to perform sitevisitmandatorydocumentCheck is "+query+" and it's result is "+result);
		int count,inner_counter;
		if(result.size()>0)
		{
			if(result.get(0).size()>0)
			{
				count=Integer.parseInt(result.get(0).get(0));
				if(count>0)
				{
					query="select count(1) from NG_POS_DOCUMENT_GRID where DOCUMENT_NAME in('Site visit report','Clear and Visible Photograph (In and Out)') and UPLOAD_STATUS='success' and wi_name = '"+wi_name+"'   ";
					List<List<String>> new_result=iformObj.getDataFromDB(query);
					logger.info("Query to perform sitevisitmandatorydocumentCheck_2 is "+query+" and it's result is "+new_result);
					if(new_result.size()>0)
					{
						if(new_result.get(0).size()>0)
						{
							inner_counter=Integer.parseInt(new_result.get(0).get(0));
							if(inner_counter<2)
							{
								return "Error~Site Visit Report and Clear and Visible Photo In and Out are Mandatory";
							}
						}	
					}
				}
			}
		}
		
		
		
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: sitevisitmandatorydocumentCheck and exception is "+e);
			return "Error~sitevisitmandatorydocumentCheck Error";
		}

		return "Success~sitevisitmandatorydocumentCheck";
	}



	private String overrideSourceChannel(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of overrideSourceChannel");
		try
		{
			String user_id=GetXML.getProp().getProperty("Users_ID");
			String user_id_split[]=user_id.split(",");
			logger.info("For these users we are setting channel as branch by default "+user_id);
			String logged_in_user=iformObj.getUserName();

			for(int i=0;i<user_id_split.length;i++)
			{
				if(user_id_split[i].equalsIgnoreCase(logged_in_user))
				{
					iformObj.setValue("CHANNEL", "Branch");
				}
			}
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: overrideSourceChannel and exception is "+e);
			return "Error~overrideSourceChannel";
		}

		return "Success~overrideSourceChannel";
	}

	private String ConditionPrecedentValidationCheck(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of ConditionPrecedentValidationCheck");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT COUNT(*) FROM NG_POS_CONDITION_PRECEDENT WHERE WI_NAME = '"+wi_name+"' AND CP_STATUS='YES' AND ATTACHMENT_STATUS!='true'  ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to perform ConditionPrecedentValidationCheck is "+query+" and it's result is "+result);
			String counter="";
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					counter=result.get(0).get(0);
				}
			}
			
			if(counter.equalsIgnoreCase("0"))
			{
				logger.info("ConditionPrecedentValidationCheck success, all documents uploaded");
				return "Success~pass";
			}
			else
			{
				logger.info("ConditionPrecedentValidationCheck failure, documents upload is pending");
				return "Success~fail";
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: ConditionPrecedentValidationCheck and exception is "+e);
			return "Error~ConditionPrecedentValidationCheck";
		}
	}

	private String parentcrnotequaltocrvalidationcheck(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of parentcrnotequaltocrvalidationcheck");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT COUNT(1) FROM NG_POS_RELATED_PARTY_ROLES_GRID WHERE CR=PARENT_CR AND WI_NAME='"+wi_name+"'    ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to perform parentcrnotequaltocrvalidationcheck is "+query+" and it's result is "+result);
			String counter="";
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					counter=result.get(0).get(0);
				}
			}
			
			if(counter.equalsIgnoreCase("0"))
			{
				logger.info("parentcrnotequaltocrvalidationcheck success, none parent cr and child cr are equal uploaded");
				return "Success~pass";
			}
			else
			{
				logger.info("parentcrnotequaltocrvalidationcheck failure, parent cr and child cr are equal for atleast one case.");
				return "Success~fail";
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: parentcrnotequaltocrvalidationcheck and exception is "+e);
			return "Error~parentcrnotequaltocrvalidationcheck";
		}
	}

	private String ParentCrToChilCRMappingCheck(IFormReference iformObj, String stringdata) {
		logger.info("Inside handling of ParentCrToChilCRMappingCheck");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT COUNT(1) FROM NG_POS_RELATED_PARTY_ROLES_GRID WHERE PARTY_TYPE='Company' AND WI_NAME='"+wi_name+"' AND ROLE_TYPE!='Others' AND CR NOT IN (SELECT  PARENT_CR FROM NG_POS_RELATED_PARTY_ROLES_GRID WHERE WI_NAME='"+wi_name+"') ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to perform ParentCrToChilCRMappingCheck is "+query+" and it's result is "+result);
			String counter="";
			int count;
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					counter=result.get(0).get(0);
				}
			}
			
			if(counter.equalsIgnoreCase("0"))
			{
				logger.info("ParentCrToChilCRMappingCheck success, all companies have child cr");
				return "Success~pass";
			}
			else
			{
				logger.info("ParentCrToChilCRMappingCheck failure,  all companies don't have child cr");
				return "Success~fail";
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: ParentCrToChilCRMappingCheck and exception is "+e);
			return "Error~ParentCrToChilCRMappingCheck";
		}
	}



	private String RelatedPartyCityArabicToEnglish(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of RelatedPartyCityArabicToEnglish");
		String final_value="";
		try
		{
			String result=isarabic(iformObj,"table10599_ADDRESS_CITY_NAME");
			if(result.equalsIgnoreCase("true") || result.equalsIgnoreCase("mix"))
			{
				String arabic_value=(String) iformObj.getValue("table10599_ADDRESS_CITY_NAME");
				String query="SELECT CITY FROM NG_MAST_CITY WHERE CITY_AR=N'"+arabic_value+"'   ";
				List<List<String>> db_result=iformObj.getDataFromDB(query);
				logger.info("Query to perform RelatedPartyCityArabicToEnglish is "+query+" and it's result is "+db_result);
				if(db_result.size()>0)
				{
					if(db_result.get(0).size()>0)
					{
						final_value=db_result.get(0).get(0);
					}
				}
				iformObj.setValue("table10599_ADDRESS_CITY_NAME", final_value);
			}
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: RelatedPartyCityArabicToEnglish and exception is "+e);
			return "Error~RelatedPartyCityArabicToEnglish";
		}
		return "Success~RelatedPartyCityArabicToEnglish";
	}

	private String updateAccountDataAfterApplicationCreation(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of updateAccountDataAfterApplicationCreation");
		try
		{
			String date= new Timestamp(System.currentTimeMillis()).toString();
			iformObj.setValue("Q_NG_POS_APPLICATION_DATA_REFRESH_DATE_TIME",date);
			iformObj.clearTable("Q_NG_POS_STMTDATA_ACCMOVMNT_GRID");
			String activity_name=iformObj.getActivityName();
			String callName="MSBAcctsDataInq_PQ1";
			String responseXML = createRequestXML(iformObj, callName);
			String method_result=setResponseDataGridToDBAfterApplicationCreation(iformObj,callName,responseXML);
			String wi_name=getWorkitemName(iformObj);
			if(method_result.contains("Success"))
			{
				//iformObj.clearTable("Q_NG_POS_STMTDATA_ACCMOVMNT_GRID");
				callName="MSBAcctsDataInq_PQ1_ClosingBalance";
				setResponseDataGridToDBAfterApplicationCreation(iformObj,callName,responseXML);
				callName="MSBAcctsDataInq_PQ1_AccountStatus";
				setResponseDataGridToDBAfterApplicationCreation(iformObj,callName,responseXML);
				fetchBankAccount(iformObj,stringdata);
				fillStatementData(iformObj,"Q_NG_POS_STMTDATA_ACCMOVMNT_ACCOUNT_NO");
				try
				{
					//String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");	
					String query="SELECT DISTINCT ACC_NO FROM NG_POS_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='"+wi_name+"' ";
					logger.info("fillAccountMovementDetails fetch query is "+query);
					List<List<String>> acc_number = iformObj.getDataFromDB(query);
					logger.info("fillAccountMovementDetails account numbers are "+acc_number);
					double total_12_month_througput=0,average_12_month_througput=0,average_12_month_balance=0;
					int zero_balance_12_month=0;
					for (List<String> value : acc_number) 
					{
						logger.info("fillAccountMovementDetails_PQ1 account numbers in loop is "+value.get(0));
						query="SELECT TOP 12 DEPOSIT,AVG_BAL FROM NG_POS_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='"+wi_name+"' and acc_no='"+value.get(0)+"' ORDER BY TO_DATE DESC";
						logger.info("fillAccountMovementDetails_PQ1 fetch query 2 is "+query);
						List<List<String>> query_result_combined= iformObj.getDataFromDB(query);
						logger.info("fillAccountMovementDetails_PQ1 fetch query 2 result is "+query_result_combined);
						for(List<String> query_result:query_result_combined)
						{
							logger.info("fillAccountMovementDetails_PQ1 fetch query 2 result values are  "+query_result.get(0).toString());
							total_12_month_througput=total_12_month_througput+Double.parseDouble(query_result.get(0).toString());
							logger.info("fillAccountMovementDetails_PQ1 total_12_month_througput is "+total_12_month_througput +"and result from query is "+query_result.get(0).toString());
							average_12_month_balance=average_12_month_balance+Double.parseDouble(query_result.get(1).toString());
							logger.info("fillAccountMovementDetails_PQ1 average_12_month_balance is "+average_12_month_balance +"and result from query is "+query_result.get(1).toString());
							double zero=Double.parseDouble(query_result.get(0).toString());
							logger.info("fillAccountMovementDetails_PQ1 Zeros are "+zero);
							if(zero==0.0)
							{
								zero_balance_12_month=zero_balance_12_month+1;
							}
						}
					}
					logger.info("fillAccountMovementDetails_PQ1 average_12_month_througput is "+average_12_month_througput);
					average_12_month_througput=total_12_month_througput/12;
					iformObj.setValue("Q_NG_POS_STMTDATA_ACCMOVMNT_TOT_THRGPUT_12MNTH",String.format("%.2f",total_12_month_througput) );
					iformObj.setValue("Q_NG_POS_STMTDATA_ACCMOVMNT_AVG_THRGPUT_12MNTH",String.format("%.2f",average_12_month_througput) );
					iformObj.setValue("Q_NG_POS_STMTDATA_ACCMOVMNT_TOT_THRGPUT_4MNTH",String.format("%.2f",average_12_month_balance) );
					iformObj.setValue("Q_NG_POS_STMTDATA_ACCMOVMNT_AVG_THRGPUT_4MNTH", Integer.toString(zero_balance_12_month));
					
					//query="INSERT INTO NG_POS_STMTDATA_ACCMOVMNT (WI_NAME,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH) VALUES('"+processInstanceID+"','"+String.format("%.2f",total_12_month_througput)+"','"+String.format("%.2f",average_12_month_througput)+"','"+String.format("%.2f",average_12_month_balance)+"','"+zero_balance_12_month+"') ";
					//logger.info("fillAccountMovementDetails save query is "+query);
					//iformObj.saveDataInDB(query);
					if(activity_name!="PQ1 without SIMAH")
					{
						pqapprovedAmountAfterSIMAH(iformObj,stringdata);
					}
				}
				catch(Exception e)
				{
					logger.info("fillAccountMovementDetails exception occurred:  "+e);
				}
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: updateAccountDataAfterApplicationCreation and exception is "+e);
			return "Error~updateAccountDataAfterApplicationCreation";
		}
		return "Successs~updateAccountDataAfterApplicationCreation";
	}

	private String updateAccountDataAfterApplicationCreation_oldCIC(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of updateAccountDataAfterApplicationCreation_oldCIC");
		try
		{
			//String date= new Timestamp(System.currentTimeMillis()).toString();
			//iformObj.setValue("Q_NG_POS_APPLICATION_DATA_REFRESH_DATE_TIME",date);
			iformObj.clearTable("Q_NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_GRID");
			String activity_name=iformObj.getActivityName();
			String callName="MSBAcctsDataInq_OldCIC_PQ1";
			String responseXML = createRequestXML(iformObj, callName);
			String method_result=setResponseDataGridToDBAfterApplicationCreation(iformObj,callName,responseXML);
			String wi_name=getWorkitemName(iformObj);
			if(method_result.contains("Success"))
			{
				//iformObj.clearTable("Q_NG_POS_STMTDATA_ACCMOVMNT_GRID");
				callName="MSBAcctsDataInq_OldCIC_PQ1_ClosingBalance";
				setResponseDataGridToDBAfterApplicationCreation(iformObj,callName,responseXML);
				callName="MSBAcctsDataInq_OldCIC_PQ1_AccountStatus";
				setResponseDataGridToDBAfterApplicationCreation(iformObj,callName,responseXML);
				//fetchBankAccount(iformObj,stringdata); //To be checked
				fillStatementDataOldCIC(iformObj,"Q_NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_ACC_NO");
				try
				{
					//String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");	
					String query="SELECT DISTINCT ACC_NO FROM NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='"+wi_name+"' ";
					logger.info("fillAccountMovementDetails fetch query is "+query);
					List<List<String>> acc_number = iformObj.getDataFromDB(query);
					logger.info("fillAccountMovementDetails account numbers are "+acc_number);
					double total_12_month_througput=0,average_12_month_througput=0,average_12_month_balance=0;
					int zero_balance_12_month=0;
					for (List<String> value : acc_number) 
					{
						logger.info("fillAccountMovementDetails_PQ1 account numbers in loop is "+value.get(0));
						query="SELECT TOP 12 DEPOSIT,AVG_BAL FROM NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='"+wi_name+"' and acc_no='"+value.get(0)+"' ORDER BY TO_DATE DESC";
						logger.info("fillAccountMovementDetails_PQ1 fetch query 2 is "+query);
						List<List<String>> query_result_combined= iformObj.getDataFromDB(query);
						logger.info("fillAccountMovementDetails_PQ1 fetch query 2 result is "+query_result_combined);
						for(List<String> query_result:query_result_combined)
						{
							logger.info("fillAccountMovementDetails_PQ1 fetch query 2 result values are  "+query_result.get(0).toString());
							total_12_month_througput=total_12_month_througput+Double.parseDouble(query_result.get(0).toString());
							logger.info("fillAccountMovementDetails_PQ1 total_12_month_througput is "+total_12_month_througput +"and result from query is "+query_result.get(0).toString());
							average_12_month_balance=average_12_month_balance+Double.parseDouble(query_result.get(1).toString());
							logger.info("fillAccountMovementDetails_PQ1 average_12_month_balance is "+average_12_month_balance +"and result from query is "+query_result.get(1).toString());
							double zero=Double.parseDouble(query_result.get(0).toString());
							logger.info("fillAccountMovementDetails_PQ1 Zeros are "+zero);
							if(zero==0.0)
							{
								zero_balance_12_month=zero_balance_12_month+1;
							}
						}
					}
					logger.info("fillAccountMovementDetails_PQ1 average_12_month_througput is "+average_12_month_througput);
					average_12_month_througput=total_12_month_througput/12;
					iformObj.setValue("Q_NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_TOT_THRGPUT_12MNTH",String.format("%.2f",total_12_month_througput) );
					iformObj.setValue("Q_NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_AVG_THRGPUT_12MNTH",String.format("%.2f",average_12_month_througput) );
					iformObj.setValue("Q_NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_TOT_THRGPUT_4MNTH",String.format("%.2f",average_12_month_balance) );
					iformObj.setValue("Q_NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_AVG_THRGPUT_4MNTH", Integer.toString(zero_balance_12_month));
					
					//query="INSERT INTO NG_POS_STMTDATA_ACCMOVMNT (WI_NAME,TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH) VALUES('"+processInstanceID+"','"+String.format("%.2f",total_12_month_througput)+"','"+String.format("%.2f",average_12_month_througput)+"','"+String.format("%.2f",average_12_month_balance)+"','"+zero_balance_12_month+"') ";
					//logger.info("fillAccountMovementDetails save query is "+query);
					//iformObj.saveDataInDB(query);
					if(activity_name!="PQ1 without SIMAH")
					{
						pqapprovedAmountAfterSIMAH(iformObj,stringdata);
					}
				}
				catch(Exception e)
				{
					logger.info("fillAccountMovementDetails_OldCIC exception occurred:  "+e);
				}
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: updateAccountDataAfterApplicationCreation_oldCIC and exception is "+e);
			return "Error~updateAccountDataAfterApplicationCreation_oldCIC";
		}
		return "Successs~updateAccountDataAfterApplicationCreation_oldCIC";
	}

	
	private String SuccessorGuarantorCheck(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside handling of SuccessorGuarantorCheck");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT COUNT(*) FROM NG_POS_RELATED_PARTY_ROLES_GRID A WHERE CAST (AGE AS FLOAT)>=60 AND ID_NUMBER NOT IN (SELECT SUBSTRING(SUCCESSOR_FOR,CHARINDEX('(',SUCCESSOR_FOR)+1,CHARINDEX(')',SUCCESSOR_FOR) -CHARINDEX('(',SUCCESSOR_FOR)-1) FROM NG_POS_RELATED_PARTY_ROLES_GRID B WHERE ROLE_TYPE='Successor Guarantor' AND A.WI_NAME=B.WI_NAME) AND A.WI_NAME = '"+wi_name+"' ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to perform SuccessorGuarantorCheck is "+query+" and it's result is "+result);
			String counter="";
			int count;
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					counter=result.get(0).get(0);
				}
			}
			
			if(counter.equalsIgnoreCase("0"))
			{
				logger.info("SuccessorGuarantorCheck success, all individual whose age is greater than 60 have successor guarantee");
				return "Success~pass";
			}
			else
			{
				logger.info("SuccessorGuarantorCheck failure, all individual whose age is greater than 60 don't have successor guarantee");
				return "Success~fail";
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: SuccessorGuarantorCheck and exception is "+e);
			return "Error~SuccessorGuarantorCheck";
		}
	}



	private String documentNameFromDocumentIndex(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of fetchCompanyDataPQ1");
		try
		{
			logger.info("Document index sent to this method is "+stringdata);
			String query="SELECT  NAME FROM PDBDocument WHERE DocumentIndex='"+stringdata+"' ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to fetch documentNameFromDocumentIndex is "+query+"and it's result is "+result);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					logger.info("We are returning Success~"+result.get(0).get(0));
					return "Success~"+result.get(0).get(0);
				}
				else
				{
					return "Error~documentNameFromDocumentIndex";
				}
			}
			else
			{
				return "Error~documentNameFromDocumentIndex";
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred:: documentNameFromDocumentIndex and exception is"+e);
		}
		return "Error~documentNameFromDocumentIndex";
	}



	private String fetchCompanyDataPQ1(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of fetchCompanyDataPQ1");
		try
		{
			String callName="MSBEntityDataInq_PQ1";
			String responseXML = createRequestXML(iformObj, callName);		
			JSONObject jsonobj=setResponseData(iformObj, callName, responseXML);
			String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
			String []restricted_values=restricted_tags.split(",");
			for(String temp:restricted_values)
				responseXML=responseXML.replace(temp,"");
			
			XMLParser parser = new XMLParser(responseXML);
			
			for(Iterator iterator = jsonobj.keySet().iterator(); iterator.hasNext();) 
			{
			    String key = (String) iterator.next();
			    
			    	logger.info("Values set for"+key+" are "+jsonobj.get(key).toString());
			    	if(key.equalsIgnoreCase("Q_NG_POS_COMPANY_DATA_ENTITY_TYPE_JUR_STATUS"))
			    	{
			    		String Evidence_Code=parser.getValueOf("EntityTypeCd");
			    		String Evidence_Code_desc=parser.getValueOf("EntityTypeDesc");
			    		logger.info("Entity Type Setting:::"+Evidence_Code+" and "+Evidence_Code_desc);
			    		setControlValue(iformObj, key, Evidence_Code+"-"+Evidence_Code_desc);
						
			    	}
			    	else if(key.equalsIgnoreCase("Q_NG_POS_COMPANY_DATA_SECTOR"))
			    	{
			    		String Sector_Code=parser.getValueOf("SectorCd");
			    		String Sector_Code_desc=parser.getValueOf("SectorDesc");
			    		logger.info("sector Setting:::"+Sector_Code+" and "+Sector_Code_desc);
			    		setControlValue(iformObj, key, Sector_Code+"-"+Sector_Code_desc);
			    		
			    	}
			    	else if(key.equalsIgnoreCase("Q_NG_POS_COMPANY_DATA_SUBSECTOR"))
			    	{
			    		String Sub_Sector_Code=parser.getValueOf("SubSectorCd");
			    		String Sub_Sector_Code_desc=parser.getValueOf("SubSectorDesc");
			    		logger.info("sub sector Setting:::"+Sub_Sector_Code+" and "+Sub_Sector_Code_desc);
			    		setControlValue(iformObj, key, Sub_Sector_Code+"-"+Sub_Sector_Code_desc);
			    		
			    	}
			    	else if(key.equalsIgnoreCase("Q_NG_POS_COMPANY_DATA_COUNTRY_OF_INCORP"))
			    	{
			    		String country_code=parser.getValueOf("IncorporationCtryCd");
			    		String country_desc=parser.getValueOf("RegistrationCtry");
			    		logger.info("sub sector Setting:::"+country_code+" and "+country_desc);
			    		setControlValue(iformObj, key, country_code+"-"+country_desc);
			    		
			    	}
			    	else if(key.equalsIgnoreCase("Q_NG_POS_COMPANY_DATA_COUNTRY"))
			    	{
			    		String country_code=parser.getValueOf("CtryCode");
			    		String country_desc=parser.getValueOf("CtryName");
			    		logger.info("sub sector Setting:::"+country_code+" and "+country_desc);
			    		setControlValue(iformObj, key, country_code+"-"+country_desc);
			    		
			    	}
			    	else if(key.equalsIgnoreCase("Q_NG_POS_COMPANY_DATA_CITY"))
			    	{
			    		String city_code=parser.getValueOf("CityCode");
			    		String city_desc=parser.getValueOf("CityName");
			    		logger.info("sub sector Setting:::"+city_code+" and "+city_desc);
			    		setControlValue(iformObj, key, city_code+"-"+city_desc);
			    	}
			    	else if(key.equalsIgnoreCase("Q_NG_POS_COMPANY_DATA_INDUSTRY"))
			    	{
			    		String city_code=parser.getValueOf("ActivityCd");
			    		String city_desc=parser.getValueOf("ActivityDesc");
			    		logger.info("sub sector Setting:::"+city_code+" and "+city_desc);
			    		setControlValue(iformObj, key, city_code+"-"+city_desc);
			    		
			    	}
			    	else if(key.equalsIgnoreCase("Q_NG_POS_COMPANY_DATA_CENTRAL_BANK_SECTOR_CODE"))
			    	{
			    		String city_code=parser.getValueOf("SAMASectorCd");
			    		String city_desc=parser.getValueOf("SamaSectorDesc");
			    		logger.info("sub sector Setting:::"+city_code+" and "+city_desc);
			    		setControlValue(iformObj, key, city_code+"-"+city_desc);
			    	}
			    	else if(key.equalsIgnoreCase("Q_NG_POS_COMPANY_DATA_PREFERRED_LANGUAGE"))
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
			
			JSONObject return_obj = setResponseDataGrid(iformObj,callName,responseXML);
			for (Iterator iterator = return_obj.keySet().iterator(); iterator.hasNext();) 
			{
				String key = (String) iterator.next();
				iformObj.clearTable(key);
				iformObj.addDataToGrid(key, (JSONArray) return_obj.get(key));
			}
			
			logger.info("Setting Thiqah information after application creation");
			callName = "GetCrInfobyCrNo_PQ1"; //For Thiqah details
			responseXML = createRequestXML(iformObj, callName);
			jsonobj=setResponseData(iformObj, callName, responseXML);
			
			for(Iterator iterator = jsonobj.keySet().iterator(); iterator.hasNext();) 
			{
			    String key = (String) iterator.next();
			    setControlValue(iformObj, key, jsonobj.get(key).toString());
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: fetchCompanyDataPQ1 and exception is "+e);
		}
		return "Success~fetchCompanyDataPQ1";
	}



	private String brokerFeeWaiveOff(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of brokerFeeWaiveOff");
		try
		{
			
		String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
		String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
		String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
		String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
		String tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
		String requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
		
		if(requested_amt==null || requested_amt=="")
		{
			requested_amt="0";
		}
		
		double admin_Fees_rate=0,admin_Fees_vat_per=0,admin_fees=0,vat,broker_fees_vat,total_admin_fees=0,total_broker_fees=0,max_fees_amount=0,broker_fees=0;
		String query="SELECT BROKER_FEE_WAIVEOFF FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_tenure>='"+tenure+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+" ";
		List<List<String>> returned_result = iformObj.getDataFromDB(query);
		logger.info("Query to check broker fee waiveoff is "+query+" and it's result is "+returned_result);
		String broker_fee_waiveoff="";
		
		if(returned_result.size()>0)
		{
			if(returned_result.get(0).size()>0)
			{
				broker_fee_waiveoff=returned_result.get(0).get(0);
			}
		}
		
		if(broker_fee_waiveoff==null || broker_fee_waiveoff.equalsIgnoreCase("NULL") || broker_fee_waiveoff.equals("") || broker_fee_waiveoff.equalsIgnoreCase("No"))
		{
			logger.info("As broker fees waiveoff is "+broker_fee_waiveoff+" and hence we are returning NotEnabled");
			return "NotEnabled";
		}
		else
		{
			logger.info("As broker fees waiveoff is "+broker_fee_waiveoff+" and hence we are returning Enabled");
			return "Enabled";
		}
		
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: brokerFeeWaiveOff and exception is "+e);
		}
		return "Error~brokerFeeWaiveOff";
	}

	private String refreshCreditlIne(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside handling of refreshCreditlIne");
		try
		{
			String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			String wi_name=getWorkitemName(iformObj);
			String cic_no=(String) iformObj.getValue("PADDED_CIC_NO");
			String regex="^0+(?!$)";
			String unpadded_cic_no=cic_no.replaceAll(regex,"");
			logger.info("For Workitem no "+wi_name+"Padded CIC no is "+cic_no+" and unpadded cic_no is "+unpadded_cic_no);
			String callname="CustOutstandingInq_ApprovedSales";
			String responseXML = createRequestXML(iformObj, callname);
			String result=setResponseDataGridApprovedSales(iformObj, callname, responseXML,cic_no,wi_name);
			fetchAllCTFDataApprovedSales(iformObj, callname,cic_no,wi_name);
			
			String query="DELETE FROM NG_POS_CREDITLINE_TRASSET_DET_GRID_APROVED_SALES WHERE WI_NAME ='"+wi_name+"' ";
			logger.info("Query to delete from NG_POS_CREDITLINE_TRASSET_DET_GRID_APROVED_SALES  is "+query);
			iformObj.saveDataInDB(query);
			
			query="INSERT INTO NG_POS_CREDITLINE_TRASSET_DET_GRID_APROVED_SALES (WI_NAME,CIC,CUST_NAME,LIMIT_REF,TICKET,CONTRACT_AMOUNT,LIMIT_DESC,LIMIT_UTIL_AMOUNT,LIMIT_UNUTIL_AMOUNT,PRODUCT,REVOLVING,PROFIT_RATE_TYPE,PROFIT_RATE,TENOR,TOTAL_NO_INSTALLMENT,FREQUENCY_OF_INSTALLMENT,INSTALMENT_AMOUNT,NO_INSTALLMENT_PAID,NO_OVERDUE_INSTALLMENT,CONTRACT_EFFECTIVE_DATE,CONTRACT_EXPIRY_DATE,NEXT_INSTALMENT_DUE_DATE,OUTSTANDING_PRINCIPAL,OUTSTANDING_PROFIT,GROSS_OUTSTANDING,PDO_AMOUNT,PDO_DATE,WRITE_OFF,CONTRACT_STATUS,ORR,RM_CODE,RM_NAME,CLIENT_ACCOUNT_NUMBER,ENTRY_DATE_TIME) SELECT '"+wi_name+"',CIC,CUST_NAME,LIMIT_REF,TICKET,CONTRACT_AMOUNT,LIMIT_DESC,LIMIT_UTIL_AMOUNT,LIMIT_UNUTIL_AMOUNT,PRODUCT,REVOLVING,PROFIT_RATE_TYPE,PROFIT_RATE,TENOR,TOTAL_NO_INSTALLMENT,FREQUENCY_OF_INSTALLMENT,CAST(INSTALMENT_AMOUNT AS NUMERIC(20,2)),NO_INSTALLMENT_PAID,NO_OVERDUE_INSTALLMENT,CONTRACT_EFFECTIVE_DATE,CONTRACT_EXPIRY_DATE,NEXT_INSTALMENT_DUE_DATE,OUTSTANDING_PRINCIPAL,OUTSTANDING_PROFIT,GROSS_OUTSTANDING,PDO_AMOUNT,PDO_DATE,WRITE_OFF,CONTRACT_STATUS,ORR,RM_CODE,RM_NAME,CLIENT_ACCOUNT_NUMBER,'"+date+"' FROM NG_MAST_TRASSET_DATA WHERE CIC = '"+unpadded_cic_no+"' ";
			logger.info("Query to insert in NG_POS_CREDITLINE_TRASSET_DET_GRID_APROVED_SALES  is "+query);
			iformObj.saveDataInDB(query);
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: refreshCreditlIne and exception is "+e);
		}
		return "success~refreshCreditlIne";
	}

	private String fetchCreditLineDataApprovedSales(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside handling of fetchCreditLineDataApprovedSales");
		try
		{
			String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			String wi_name=getWorkitemName(iformObj);
			String cic_no=(String) iformObj.getValue("PADDED_CIC_NO");
			String regex="^0+(?!$)";
			String unpadded_cic_no=cic_no.replaceAll(regex,"");
			logger.info("For Workitem no "+wi_name+"Padded CIC no is "+cic_no+" and unpadded cic_no is "+unpadded_cic_no);
			String callname="CustOutstandingInq_ApprovedSales";
			String responseXML = createRequestXML(iformObj, callname);
			setResponseDataGridApprovedSales(iformObj, callname, responseXML,cic_no,wi_name);
			
			fetchAllCTFDataApprovedSales(iformObj, callname,cic_no,wi_name);
			
			String query="DELETE FROM NG_POS_CREDITLINE_TRASSET_DET_GRID_APROVED_SALES WHERE WI_NAME ='"+wi_name+"' ";
			logger.info("Query to delete from NG_POS_CREDITLINE_TRASSET_DET_GRID_APROVED_SALES  is "+query);
			iformObj.saveDataInDB(query);
			
			query="INSERT INTO NG_POS_CREDITLINE_TRASSET_DET_GRID_APROVED_SALES (WI_NAME,CIC,CUST_NAME,LIMIT_REF,TICKET,CONTRACT_AMOUNT,LIMIT_DESC,LIMIT_UTIL_AMOUNT,LIMIT_UNUTIL_AMOUNT,PRODUCT,REVOLVING,PROFIT_RATE_TYPE,PROFIT_RATE,TENOR,TOTAL_NO_INSTALLMENT,FREQUENCY_OF_INSTALLMENT,INSTALMENT_AMOUNT,NO_INSTALLMENT_PAID,NO_OVERDUE_INSTALLMENT,CONTRACT_EFFECTIVE_DATE,CONTRACT_EXPIRY_DATE,NEXT_INSTALMENT_DUE_DATE,OUTSTANDING_PRINCIPAL,OUTSTANDING_PROFIT,GROSS_OUTSTANDING,PDO_AMOUNT,PDO_DATE,WRITE_OFF,CONTRACT_STATUS,ORR,RM_CODE,RM_NAME,CLIENT_ACCOUNT_NUMBER,ENTRY_DATE_TIME) SELECT '"+wi_name+"',CIC,CUST_NAME,LIMIT_REF,TICKET,CONTRACT_AMOUNT,LIMIT_DESC,LIMIT_UTIL_AMOUNT,LIMIT_UNUTIL_AMOUNT,PRODUCT,REVOLVING,PROFIT_RATE_TYPE,PROFIT_RATE,TENOR,TOTAL_NO_INSTALLMENT,FREQUENCY_OF_INSTALLMENT,CAST(INSTALMENT_AMOUNT AS NUMERIC(20,2)),NO_INSTALLMENT_PAID,NO_OVERDUE_INSTALLMENT,CONTRACT_EFFECTIVE_DATE,CONTRACT_EXPIRY_DATE,NEXT_INSTALMENT_DUE_DATE,OUTSTANDING_PRINCIPAL,OUTSTANDING_PROFIT,GROSS_OUTSTANDING,PDO_AMOUNT,PDO_DATE,WRITE_OFF,CONTRACT_STATUS,ORR,RM_CODE,RM_NAME,CLIENT_ACCOUNT_NUMBER,'"+date+"' FROM NG_MAST_TRASSET_DATA WHERE CIC = '"+unpadded_cic_no+"' ";
			logger.info("Query to insert in NG_POS_CREDITLINE_TRASSET_DET_GRID_APROVED_SALES  is "+query);
			iformObj.saveDataInDB(query);

			
			logger.info("All data is fetched, now need to move on to calculating new outstanding amount");
			
			query="SELECT sum(B.OUTSTANDING) FROM ( SELECT  CAST(REPLACE(IIF(outstanding_balance='',NULL,outstanding_balance),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_CREDITLINE_CTF_MSB_GRID_APROVED_SALES B WHERE B.PRODUCT_CODE='1012' AND B.WI_NAME = '"+wi_name+"' UNION SELECT CAST(REPLACE(IIF(OUTSTDNG_PRINCIPAL='',NULL,OUTSTDNG_PRINCIPAL),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_CREDITLINE_LOANACC_GRID_APROVED_SALES WHERE WI_NAME = '"+wi_name+"' AND PRODUCT='Point of Sale Finance' UNION SELECT CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2)) AS OUTSTANDING_PRINCIPAL FROM NG_POS_CREDITLINE_TRASSET_DET_GRID_APROVED_SALES WHERE WI_NAME = '"+wi_name+"'  and CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))<'7500000' ) B";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to calculate New TopUpOutstanding is "+query+" and it's result is "+result);
			String new_outstanding_amount="";
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					new_outstanding_amount=result.get(0).get(0);
				}
			}
			
			logger.info("Setting value of TOP_UP_OUTSTANDING_APPR_SALES as : "+new_outstanding_amount);
			iformObj.setValue("TOP_UP_OUTSTANDING_APPR_SALES", new_outstanding_amount);

			String old_outstanding_string=(String) iformObj.getValue("TOP_UP_OUTSTANDING");
			logger.info("String value of old_outstanding_string is : "+old_outstanding_string);
			if(old_outstanding_string.trim().equalsIgnoreCase("") || old_outstanding_string.trim().equalsIgnoreCase("0") || old_outstanding_string.trim().equalsIgnoreCase("0.00"))
			{
				logger.info("As old_outstanding_string value is "+old_outstanding_string+" we are calculating it again");
				calculateTopUpOutstanding(iformObj,stringdata); 
				old_outstanding_string=(String) iformObj.getValue("TOP_UP_OUTSTANDING");
			}
			
			String commitment_amount_string=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_COMMITMENT_AMT");
			
			logger.info("String value of new_outstanding_amount is : "+new_outstanding_amount);
			logger.info("String value of old_outstanding_string is : "+old_outstanding_string);
			logger.info("String value of commitment_amount_string is : "+commitment_amount_string);
			
			BigDecimal old_outstanding,new_outstanding,commitment_amount;
			try
			{
				old_outstanding=new BigDecimal(old_outstanding_string);
			}
			catch(Exception e)
			{
				logger.info("Exception Occurred: fetchCreditLineDataApprovedSales in conversion of old_outstanding_string "+old_outstanding_string+" to BigDecimal and exception is "+e);
				old_outstanding=new BigDecimal(0);
			}
			
			try
			{
				new_outstanding=new BigDecimal(new_outstanding_amount);
			}
			catch(Exception e)
			{
				logger.info("Exception Occurred: fetchCreditLineDataApprovedSales in conversion of new_outstanding_amount"+new_outstanding_amount+" to BigDecimal and exception is "+e);
				new_outstanding=new BigDecimal(0);
			}
			
			try
			{
				commitment_amount=new BigDecimal(commitment_amount_string);
			}
			catch(Exception e)
			{
				logger.info("Exception Occurred: fetchCreditLineDataApprovedSales in conversion of commitment_amount_string "+commitment_amount_string+" to BigDecimal and exception is "+e);
				commitment_amount=new BigDecimal(0);
			}
			logger.info("BigDecimal value of new_outstanding_amount is : "+new_outstanding);
			logger.info("BigDecimal value of old_outstanding_string is : "+old_outstanding);
			logger.info("BigDecimal value of commitment_amount_string is : "+commitment_amount);
		
			BigDecimal diff_outstanding=old_outstanding.subtract(new_outstanding);
			
			logger.info("Difference between old and new outstanding amount is : "+diff_outstanding);
			logger.info("Result of compare to is "+diff_outstanding.compareTo(new BigDecimal(0)));
			
			if(diff_outstanding.compareTo(new BigDecimal(0))>=0)
			{
				logger.info("LimitAllowed");
				return "LimitAllowed";
			}
			else
			{
				logger.info("LimitNotAllowed");
				return "LimitNotAllowed";
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: fetchCreditLineDataApprovedSales and exception is "+e);
		}
		return "success~fetchCreditLineDataApprovedSales";
	}



	private String calculateTopUpOutstanding(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of calculateTopUpOutstanding");
		String wi_name=getWorkitemName(iformObj);
		try
		{
		
		String query="SELECT SUM(B.OUTSTANDING) FROM ( SELECT CAST(REPLACE(IIF(OUTSTANDING_BALANCE ='',NULL,OUTSTANDING_BALANCE ),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_CREDITLINE_CTF_MSB_GRID B WHERE B.PRODUCT_CODE='1012' AND B.WI_NAME = '"+wi_name+"'  UNION SELECT CAST(REPLACE(IIF(OUTSTDNG_PRINCIPAL='',NULL,OUTSTDNG_PRINCIPAL),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_CREDITLINE_LOANACC_GRID WHERE WI_NAME = '"+wi_name+"' AND PRODUCT='Point of Sale Finance' UNION SELECT CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2)) AS OUTSTANDING FROM NG_POS_TRASSET_DETAILS_GRID_NEW WHERE WI_NAME = '"+wi_name+"' and CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))<'7500000' ) B";
		List<List<String>> result=iformObj.getDataFromDB(query);
		logger.info("Query to calculate TopUpOutstanding is "+query+" and it's result is "+result);
		String outstanding_amount="";
		if(result.size()>0)
		{
			if(result.get(0).size()>0)
			{
				outstanding_amount=result.get(0).get(0);
			}
		}
		
		logger.info("Setting value of TOP_UP_OUTSTANDING : "+outstanding_amount);
		iformObj.setValue("TOP_UP_OUTSTANDING", outstanding_amount);
		
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: calculateTopUpOutstanding and exception is "+e);
		}
		return "success~calculateTopUpOutstanding";
	}



	private String deletingDisbursedData(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of deletingDisbursedData");
		try
		{
			String cic_no = (String) iformObj.getValue("PADDED_CIC_NO");
			iformObj.saveDataInDB("delete from NG_MSB_SEARCH_NONPOS_ACCMOVMNT_DETAILS where cic='"+cic_no+"'  ");
			iformObj.saveDataInDB("delete from NG_MSB_SEARCH_NONPOS_POS_DETAILS where cic='"+cic_no+"'   ");
			//Newly added, deleting from process specific tables
			iformObj.saveDataInDB("delete from NG_STATEMENT_OCR_ACC_MVMNT where WI_NAME in (select WI_NAME from NG_STATEMENT_OCR_CUST_INFO where CIC_NO ='"+cic_no+"' )  ");
			iformObj.saveDataInDB("delete from NG_STATEMENT_OCR_POS_TRANSACTN where WI_NAME in (select WI_NAME from NG_STATEMENT_OCR_CUST_INFO where CIC_NO ='"+cic_no+"' )  ");
			iformObj.saveDataInDB("delete from NG_STATEMENT_OCR_POS_TRANSACTN_GRID where WI_NAME in (select WI_NAME from NG_STATEMENT_OCR_CUST_INFO where CIC_NO ='"+cic_no+"' )  ");
			iformObj.saveDataInDB("delete from NG_STATEMENT_OCR_ACC_MVMNT_GRID where WI_NAME in (select WI_NAME from NG_STATEMENT_OCR_CUST_INFO where CIC_NO  ='"+cic_no+"' ) ");
			//Newly added, deleting from process specific tables
			logger.info("Deleting records from NG_MSB_SEARCH_NONPOS_ACCMOVMNT_DETAILS and NG_MSB_SEARCH_NONPOS_POS_DETAILS where cic_no is "+cic_no);
			return "NG_MSB_SEARCH_NONPOS_POS_DETAILS foo delete query runs successfully";
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: deletingDisbursedData and exception is "+e);
		}
		return "Error in deletingDisbursedData ";
	}
	
	private String rejectWorkItem(IFormReference iformObj, String stringdata) 
	{
		try
		{
			String activityname=iformObj.getActivityName();
			String query="SELECT DECISION_KEY,DECISION,DECISION_AR FROM NG_MAST_DECISION WHERE DECISION='REJECT' AND WORKSTEPNAME='"+activityname+"' ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to find decision key in case of reject is "+query+" and it's result is "+result);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					logger.info("We are setting value of DECISION_KEY as "+result.get(0).get(0));
					iformObj.setValue("DECISION_KEY",result.get(0).get(0));
					iformObj.setValue("DECISION",result.get(0).get(1));
					iformObj.setValue("DECISION_AR",result.get(0).get(2));
					iformObj.setValue("Q_NG_POS_DECISION_REJECT_REASON","CR/UNN No is expired");
				}
			}
			return "success~rejectWorkItem";
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: rejectWorkItem and exception is "+e);
		}
		return "Error~rejectWorkItem";
	}

	private String checkCRExpiry(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside body of checkCRExpiry");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			/*In this query we are using concept of checking cr_unn_expiry_dates from config table just because
			  same concept is used in procedure NG_POS_Eligibility_check. If it is not required then use this query
			  instead.
			  String query="SELECT IIF(DATEDIFF(DAY,EXPIRYDATE,TODAYDATE)>0,'TRUE','FALSE'),TODAYDATE,EXPIRYDATE  FROM (SELECT IIF(DATEDIFF(YYYY,CONVERT(DATE,EXPIRY_DATE,23),CONVERT(DATE,GETDATE(),23))>300, CONVERT(DATE,FORMAT(getdate(),'yyyy-MM-dd','ar'),23),CONVERT(DATE,GETDATE(),23)) AS TODAYDATE , CONVERT(DATE,EXPIRY_DATE,23) AS EXPIRYDATE FROM NG_POS_COMPANY_DATA WHERE WI_NAME ='"+wi_name+"') S";
			*/
			String query="SELECT IIF(DATEDIFF(DAY,EXPIRYDATE,TODAYDATE)>0 OR DATEDIFF(DAY,EXPIRYDATE,DATEADD(day,CAST(DAYSS AS NUMERIC),TODAYDATE))>0,'TRUE','FALSE'), TODAYDATE,EXPIRYDATE,DAYSS  FROM  (SELECT IIF(DATEDIFF(YYYY,CONVERT(DATE,EXPIRY_DATE,23),CONVERT(DATE,GETDATE(),23))>300, CONVERT(DATE,FORMAT(getdate(),'yyyy-MM-dd','ar'),23),CONVERT(DATE,GETDATE(),23)) AS TODAYDATE , CONVERT(DATE,EXPIRY_DATE,23) AS EXPIRYDATE,PARAM_VALUE AS DAYSS FROM NG_POS_COMPANY_DATA,NG_POS_PARAM_CONFIG WHERE WI_NAME ='"+wi_name+"'  AND param_key='CRR_UNN_EXPIRY_DAYS') S  ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to check whether CR is expired or not is "+query+" and it's result is "+result);
			String cr_expired_or_not="";
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					cr_expired_or_not=result.get(0).get(0);
					logger.info("We are setting value of cr_expired_or_not as "+result.get(0).get(0));
				}
			}
			
			if(cr_expired_or_not.equals("TRUE"))
			{
				logger.info("Setting CR_UNN_EXPIRED as true");
				iformObj.setValue("CR_UNN_EXPIRED", "true");
				return "success~checkCRExpiry~true";
			}
			else
			{
				logger.info("Returning CR_UNN_EXPIRED as false");
				iformObj.setValue("CR_UNN_EXPIRED", "false");
				return "success~checkCRExpiry~false";				
			}
			
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: checkCRExpiry and exception is "+e);
		}
		return "Error~checkCRExpiry";
	}

	private String fillArabicAmountFields(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside handling of fillArabicAmountFields");
		try
		{
		String requested_amt="",disbursal_amt="",app_data_total_profit="",disb_total_profit="",requested_amt_plus_total_profit="",disbursal_amt_plus_total_profit="";
		double requested_amt_plus_total_profit_double=0,disbursal_amt_plus_total_profit_double=0;
		requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
		app_data_total_profit=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TOTAL_PROFIT");
		disbursal_amt=(String) iformObj.getValue("Q_NG_POS_DISBURSAL_DATA_DISBURSAL_AMT");
		disb_total_profit=(String) iformObj.getValue("Q_NG_POS_DISBURSAL_DATA_TOTAL_PROFIT");
		logger.info("fillArabicAmountFields data is captured successfully");
		
		if(requested_amt==null || requested_amt==""  || requested_amt.equals("") || requested_amt=="0.00")
			requested_amt="0";
		
		if(app_data_total_profit==null || app_data_total_profit.equals("")  || app_data_total_profit=="0" || app_data_total_profit=="0.00")
			app_data_total_profit="0";
		
		if(disbursal_amt==null || disbursal_amt=="0" || disbursal_amt.equals("") || disbursal_amt=="0.00")
			disbursal_amt="0";
		
		if( disb_total_profit==null || disb_total_profit.equals("") ||  disb_total_profit=="0" || disb_total_profit=="0.00" )
			disb_total_profit="0";
		
		try
		{
			if(requested_amt!=null && requested_amt!=""  && !requested_amt.equals("") && requested_amt!="0.00" && app_data_total_profit!=null && !app_data_total_profit.equals("")  && app_data_total_profit!="0" &&app_data_total_profit!="0.00" )
				requested_amt_plus_total_profit_double=Double.parseDouble(requested_amt)+Double.parseDouble(app_data_total_profit);
			
			if(disbursal_amt!=null && disbursal_amt!="0" && !disbursal_amt.equals("") && disbursal_amt!="0.00" && disb_total_profit!=null && !disb_total_profit.equals("") && disb_total_profit!="0" &&disb_total_profit!="0.00" )
				disbursal_amt_plus_total_profit_double=Double.parseDouble(disbursal_amt)+Double.parseDouble(disb_total_profit);
		}
		catch(Exception e)
		{
			logger.info("Exception occurred:: fillArabicAmountFields Part 1 and exception is "+e);
		}
		
		requested_amt_plus_total_profit=String.format("%.2f", requested_amt_plus_total_profit_double);
		disbursal_amt_plus_total_profit=String.format("%.2f", disbursal_amt_plus_total_profit_double);
		
		
		logger.info("fillArabicAmountFields data is captured successfully, here also");
		logger.info("fillArabicAmountFields requested amount is "+requested_amt);
		logger.info("fillArabicAmountFields requested amount plus profit is "+requested_amt_plus_total_profit);
		logger.info("fillArabicAmountFields disbursal amount is "+disbursal_amt);
		logger.info("fillArabicAmountFields disbursed amount plus profit is "+disb_total_profit);
		
		BigDecimal requested_amt_big=new BigDecimal(requested_amt);
		logger.info("sdfsfs");
		BigDecimal app_data_total_profit_big=new BigDecimal(requested_amt_plus_total_profit);
		logger.info("sdfsfsdddddd");
		BigDecimal disbursal_amt_big=new BigDecimal(disbursal_amt);
		logger.info("sdfsfsssssssssssssssssssssssssssssss");
		BigDecimal disbursal_amt_plus_total_profit_double_big=new BigDecimal(disbursal_amt_plus_total_profit);
		logger.info("sdfsfsd");
		logger.info("fillArabicAmountFields requested amount is "+requested_amt_big);
		logger.info("fillArabicAmountFields requested amount plus profit is "+app_data_total_profit_big);
		logger.info("fillArabicAmountFields disbursed amount is "+disbursal_amt_big);
		logger.info("fillArabicAmountFields disbursed amount plus profit is "+disbursal_amt_plus_total_profit_double_big);
		NumberToArabic n=new NumberToArabic();
		logger.info(" For "+requested_amt+" arabic is "+n.convertToArabic(requested_amt_big,"SAR"));
		logger.info(" For "+requested_amt_plus_total_profit_double+" arabic is "+n.convertToArabic(app_data_total_profit_big,"SAR"));
		logger.info(" For "+disbursal_amt+" arabic is "+n.convertToArabic(disbursal_amt_big,"SAR"));
		logger.info(" For "+disbursal_amt_plus_total_profit_double+" arabic is "+n.convertToArabic(disbursal_amt_plus_total_profit_double_big,"SAR"));

		try {
		String requsted_amt_arabic=new String (n.convertToArabic(requested_amt_big,"SAR").getBytes(),"UTF-8");
		logger.info("%%%%%%%%%%%%%%%%%%%%% requsted_amt_arabic "+requsted_amt_arabic);
		iformObj.setValue("REQUESTED_AMT_ARABIC",n.convertToArabic(requested_amt_big,"SAR"));
		iformObj.setValue("REQUESTED_AMT_PLUS_PROFIT_ARABIC",n.convertToArabic(app_data_total_profit_big,"SAR"));
		iformObj.setValue("DISBURSAL_AMT_ARABIC",n.convertToArabic(disbursal_amt_big,"SAR"));
		iformObj.setValue("DISBURSAL_AMT_PLUS_PROFIT_ARABIC",n.convertToArabic(disbursal_amt_plus_total_profit_double_big,"SAR"));

		
		/*
		iformObj.setValue("REQUESTED_AMT_ARABIC",new String (n.convertToArabic(requested_amt_big,"SAR").getBytes(),"UTF-8"));
		iformObj.setValue("REQUESTED_AMT_PLUS_PROFIT_ARABIC",new String (n.convertToArabic(app_data_total_profit_big,"SAR").getBytes(),"UTF-8"));
		iformObj.setValue("DISBURSAL_AMT_ARABIC",new String (n.convertToArabic(disbursal_amt_big,"SAR").getBytes(),"UTF-8"));
		iformObj.setValue("DISBURSAL_AMT_PLUS_PROFIT_ARABIC",new String (n.convertToArabic(disbursal_amt_plus_total_profit_double_big,"SAR").getBytes(),"UTF-8"));
	*/
	//	String wi_name=getWorkitemName(iformObj);
		//String query="UPDATE NG_POS_EXTTABLE SET REQUESTED_AMT_ARABIC=N'"+n.convertToArabic(requested_amt_big,"SAR")+"' WHERE WI_NAME='"+wi_name+"' ";
		
		} catch (UnsupportedEncodingException e) {
			logger.info("Exception occurred:: fillArabicAmountFields Part 2 and exception is "+e);
			e.printStackTrace();
		}
		
	}
		 catch (Exception e) {
				logger.info("Exception occurred:: fillArabicAmountFields Part 3 and exception is "+e);
				e.printStackTrace();
			}
		return "Success~fillArabicAmountFields";
	}

	private String fillHeaderDetails(IFormReference iformObj, String stringdata) 
	{
		String processInstanceID=getWorkitemName(iformObj);
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
			//loggedInUserID="0039355";
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
				 
				 //email_query="UPDATE NG_POS_EXTTABLE SET  RM_EMAIL_ID='"+hrmsEmailID+"' WHERE WI_NAME='"+processInstanceID+"' ";
				 //logger.info("Query to set RM Email id from HRMS for Workitem '"+processInstanceID+"' is "+query);
				 //iformObj.saveDataInDB(email_query);
				 
				 if(ho_brn.equalsIgnoreCase("Branch"))
					 channel="Branch"; //channel="Head Quarter";
				 	else
				 	 channel="Head Quarter"; //channel="Branch";
				 
				 //hrmsUserId="0039355";
				// query="UPDATE NG_POS_EXTTABLE SET REGION=N'"+hrmsBranchRegion+"',AREA=N'"+hrmsArea+"',DISTRICT=N'"+hrmsBranchDistrict+"',BRANCH=N'"+hrmsBranchName+"',CHANNEL=N'"+channel+"' WHERE WI_NAME = '"+processInstanceID+"'  ";
				 String query_hrms="DELETE FROM ng_mast_hrms_data WHERE USER_ID ='"+hrmsUserId+"'  ";
				 logger.info("Query to delete query_hrms is  "+query_hrms);
				 iformObj.saveDataInDB(query_hrms);
				 
				 
				 query_hrms="INSERT INTO ng_mast_hrms_data (USER_ID,FULL_NAME,EMAIL_ID,BRANCH_ID,BRANCH_NAME,BRANCH_REGION,AREA,BRANCH_DISTRICT,BRANCH_CITY,INSERTED_DATETIME) VALUES (N'"+hrmsUserId+"',N'"+hrmsFullName+"',N'"+hrmsEmailID+"',N'"+hrmsBranchID+"',N'"+hrmsBranchName+"',N'"+hrmsBranchRegion+"',N'"+hrmsArea+"',N'"+hrmsBranchDistrict+"',N'"+hrmsBranchCity+"',GETDATE())  ";
				 logger.info("Query to insert query_hrms is  "+query_hrms);
				 iformObj.saveDataInDB(query_hrms);
				 iformObj.setValue("RM_NAME", loggedInUserID);
				 iformObj.setValue("REGION", hrmsBranchRegion);
				 iformObj.setValue("AREA", hrmsArea);
				 iformObj.setValue("DISTRICT", hrmsBranchDistrict);
				 iformObj.setValue("BRANCH", hrmsBranchCity);
				 iformObj.setValue("CHANNEL", channel);
				 iformObj.setValue("RM_EMAIL_ID", hrmsEmailID);
				 
			 }
			 else
			 {
				 //query="UPDATE NG_POS_EXTTABLE SET REGION='Riyadh Region',AREA='Central',DISTRICT='Riyadh',BRANCH='Riyadh',CHANNEL='Head Quarter' WHERE WI_NAME LIKE '"+processInstanceID+"'  ";
				 	iformObj.setValue("RM_NAME", loggedInUserID);
				 	iformObj.setValue("REGION", "Riyadh");
					iformObj.setValue("AREA", "Central");
					iformObj.setValue("DISTRICT", "Riyadh");
					iformObj.setValue("BRANCH", "Riyadh");
					iformObj.setValue("CHANNEL", "Head Quarter"); 
					
					email_query="select MailId FROM PDBUSER WHERE USERNAME='"+username+"' ";
					List<List<String>> result=iformObj.getDataFromDB(email_query);
					logger.info("Query to select RM Email id from PDBuser for Workitem '"+processInstanceID+"' is "+email_query+" and it's result is "+result);
					if(result.size()>0)
					{
						if(result.get(0).size()>0)
						{
							iformObj.setValue("RM_EMAIL_ID", result.get(0).get(0));
						}
					}
					
					
			 }
			// logger.info("Query to insert header details in exttable is  "+query);
			// iformObj.saveDataInDB(query);
			 
			}
			else
			{
				//query="UPDATE NG_POS_EXTTABLE SET REGION='Riyadh Region',AREA='Central',DISTRICT='Riyadh',BRANCH='Riyadh-Branch',CHANNEL='Head Quarter' WHERE WI_NAME LIKE '"+processInstanceID+"'  ";
				//	logger.info("Query to insert header details in exttable case 2 is  "+query);
				//iformObj.saveDataInDB(query);
				iformObj.setValue("RM_NAME", loggedInUserID);
				iformObj.setValue("REGION", "Riyadh");
				iformObj.setValue("AREA", "Central");
				iformObj.setValue("DISTRICT", "Riyadh");
				iformObj.setValue("BRANCH", "Riyadh");
				iformObj.setValue("CHANNEL", "Head Quarter");
				
				email_query="select MailId FROM PDBUSER WHERE USERNAME='"+username+"' ";
				List<List<String>> result=iformObj.getDataFromDB(email_query);
				logger.info("Query to select RM Email id from PDBuser for Workitem '"+processInstanceID+"' is "+email_query+" and it's result is "+result);
				if(result.size()>0)
				{
					if(result.get(0).size()>0)
					{
						iformObj.setValue("RM_EMAIL_ID", result.get(0).get(0));
					}
				}
			}
		}
		catch (Exception e)
		{
			 logger.info("Exception Occurred: fillHeaderDetails and exception is "+e);
		}
		
		return "fillHeaderDetails working sucessfully";
	}

	private String fillFullRMName(IFormReference iformObj, String stringdata) 
	{
        logger.info("inside implementation of fillFullRMName function ");
		String rm_name=(String) iformObj.getValue("RM_NAME");
		logger.info("RM name on form is  "+rm_name);
		String fullrmname="",firstname="",secondname="";
		try
		{
			String query="SELECT PersonalName,FamilyName FROM PDBUSER WHERE UserName='"+rm_name+"'";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Query to fetch full name is "+query+" and its result is "+result);
			if(result.size()>0)
			{
				if(result.get(0).size()==2)
				{
					firstname=result.get(0).get(0);
					secondname=result.get(0).get(1);
				}
				else if(result.get(0).size()==1)
				{
					firstname=result.get(0).get(0);
					secondname="";
				}
			}
			
			if(firstname=="NULL" || firstname==null)
			{
				firstname="";
			}
			if(secondname=="NULL" || secondname==null)
			{
				secondname="";
			}
		
			fullrmname=firstname+" "+secondname;
			iformObj.setValue("FULL_RM_NAME", fullrmname);
			return "Success~"+fullrmname;
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: fillFullRMName and exception is "+e);
		}
		
		return "";
	}

	private String SIMAHvalidationcheck(IFormReference iformObj, String stringdata) 
	{
        logger.info("inside implementation of SIMAHvalidationcheck function ");
		
		String wi_name=getWorkitemName(iformObj);
		String query="";
		List<List<String>> result;
		String value="";
		try
		{
			query="select count(1) from NG_POS_RELATED_PARTY_ROLES_GRID where PARTY_TYPE='Individual' and SIMAH_REQUIRED='true' and WI_NAME='"+wi_name+"' and ID_NUMBER not in (select cid2 from NG_POS_SIMAH_IND_PROVIDED_SECTION)";
			result=iformObj.getDataFromDB(query);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					value=result.get(0).get(0);
					
				}
			}
			
			int i=Integer.parseInt(value);
			if(i>0)
			{
				return "error~Please Fetch SIMAH For All Individuals Party";
			}
			
			value="";
			query="select count(1) from NG_POS_RELATED_PARTY_ROLES_GRID where PARTY_TYPE='Company' and SIMAH_REQUIRED='true' and WI_NAME='"+wi_name+"' and UNN not in (SELECT CR_NO FROM NG_POS_SIMAH_RP_BASIC_DETAILS) ";
			result=iformObj.getDataFromDB(query);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					value=result.get(0).get(0);
					
				}
			}
			
			i=Integer.parseInt(value);
			if(i>0)
			{
				return "error~Please Fetch SIMAH For All Company Party";
			}
			
			value="";
			query="select count(1) from NG_POS_SIMAH_BASIC_DETAILS where WI_NAME='"+wi_name+"'  ";
			result=iformObj.getDataFromDB(query);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					value=result.get(0).get(0);
					
				}
			}
			
			i=Integer.parseInt(value);
			if(i==0)
			{
				return "error~Please Fetch SIMAH For Applicant Party";
			}
	
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: SIMAHvalidationcheck and exception is "+e);
			return "error~Error From Backend while applying SIMAH validation";
		}
		
		return "Success~SIMAHvalidationcheck";
	}

	private String fillMerchantDetails(IFormReference iformObj, String stringdata) 
	{	
		String wi_name=getWorkitemName(iformObj);
		String cic_no=(String) iformObj.getValue("PADDED_CIC_NO");
		String callname="MerchantDetailsInq";
		//createRequestXML customized to handle cic
		try
		{
			logger.info("Inside createRequestXML Function and callName is " + callname);
			String tagName = "_TagName";
			
			String request_prefix=GetXML.getProp().getProperty(callname+"_RequestPrefix");
			if(request_prefix.equals(null))
			{
				request_prefix="";
			}
			logger.info("Request prefix is "+request_prefix+"please check");
			
			String header_tags=GetXML.getProp().getProperty(callname+"_Header");
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
		
			String tagNames = GetXML.getProp().getProperty(callname + tagName);
			logger.info(tagNames);
			String[] tags = tagNames.split(",");
	
			String requestXML = readDummyRequest(callname);
	
			XMLParser parser = new XMLParser(requestXML);
			
	
			for (String tag : tags) 
			{
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
				if (tagValue.startsWith("formid~")) 
				{
					String value = (String) iformObj.getValue(tagValue.split("~")[1]);
					parser.changeValue(request_prefix+tag, value);
				}
				
			}
			
			//String timestamp=new Timestamp(System.currentTimeMillis()).toString();
			//logger.info("Setting Enquiy Reference for simah call "+timestamp);
			logger.info("CreateRequestXML :Handling Language in Request ");
			logger.info("Language tag for "+callname+" present in proerty file or not ??? "+GetXML.getProp().containsKey(callname+"_LanguageTag"));
			if(GetXML.getProp().containsKey(callname+"_LanguageTag"))
			{
				logger.info("CreateRequestXML : Language tag is present in property file");
				String language_tag=GetXML.getProp().getProperty(callname+"_LanguageTag");
				logger.info("CreateRequestXML : Language tag value in property file is "+language_tag);
				String session_lang=(String) iformObj.getValue("SESSION_LANG");
				logger.info("CreateRequestXML : Session Language is "+session_lang);
				parser.changeValue(request_prefix+language_tag, session_lang);
				logger.info(request_prefix+language_tag+" got value "+session_lang);
			}
			
			logger.info("Request prefix is "+request_prefix+"please check");
		//	parser.changeValue(request_prefix+"alr:CICNum", cic_no); //Just because of this we wrote this code, instead of using creatreqestxml
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML is :\n" + parser.toString());
			String responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callname,iformObj);
		
			String restricted_tags=GetXML.getProp().getProperty(callname+"_RestrictedTags");
			String []restricted_values=restricted_tags.split(",");
			for(String temp:restricted_values)
				responseXML=responseXML.replace(temp,"");
			
			//Hello
			String[] callNamesGrid = {"MerchantDetailsInq_MerchantList"};
		
			for (String callNames : callNamesGrid) 
				{
					
					//logger.info("Response XML received by setResponseDataGrid is"+responseXML);
					tagName = "_TagNameResponseGrid";
					tagNames = GetXML.getProp().getProperty(callNames + tagName);
					
					logger.info(tagNames);
					String[] tagValue = tagNames.split(",");
					
					String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
					
					
					String values=" ";
					String query="";
					//columnames="CIC_NO,CR_NO";
					String insertinto="INSERT INTO ";
					String tablename=GetXML.getProp().getProperty(callNames+"_Table_Grid");
					
					//Delete is not required as we are using workitemname for handling
					//String delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_no+"' ";
					//iformObj.saveDataInDB(delete_query);
					//logger.info("With this query table is emptied :: "+delete_query);
					
					String statuscode=GetXML.getProp().getProperty(callNames+"_StatusCode");
					String[] status_code_split=statuscode.split("~");
					
					
					for(String tag: tagValue)
					{
						tags=tag.split("~");
						WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
						//logger.info("objWFxmlResponse value is "+objWFxmlResponse);
						
						String columnames="CIC_NO,WI_NAME,";
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
							
							
						logger.info("Tags[0] is "+tags[0]);
						logger.info("Tags[1] is "+tags[1]);
						WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
						logger.info("Wfmxmlsit is --------------"+WFXmlList);
						logger.info("Size of Wfmxmlsit is "+WFXmlList.hasMoreElements());
						for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
						{
						
							values=values+"( '"+cic_no+"','"+wi_name+"',";
							
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
										result_from_response=" ";
									}
									
									if(hash_split_values[0].contains("$"))
										values=values+"'"+result_from_response+"',";
									else
										values=values+"N'"+result_from_response+"',";
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
						iformObj.saveDataInDB(query);	
						
						iformObj.setValue("MERCHANT_DETAILS_FETCHED","YES");
						
						}
						else
						{
							logger.info("For "+callname+" Status code returned from response is not success ");
							return "Error~In "+callname+" error received from backen";
						}
						
					}
				}
			}
			catch(Exception e)
			{
				logger.info("Excpetion Occurred::fillMerchantDetails and exception is "+e);
				return "Error~Error in fillMerchantDetails";
			}
	
		return "Success~fillMerchantDetails";
	}

	private String calculateT24BranchCode(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside calculateT24BranchCode");
		String disbursal_acc_no=(String)iformObj.getValue("Q_NG_POS_APPLICATION_DATA_DISBURSAL_ACC_NO");
		logger.info("Disbursement Account no is "+disbursal_acc_no);
		String rbs_branch_code="",T24_branch_code="";
		try
		{
			if(disbursal_acc_no!=null && disbursal_acc_no.trim().length()>=5)
			{
				rbs_branch_code=disbursal_acc_no.substring(0,5);
				logger.info("RBS Branch Code is "+rbs_branch_code);
				String query="SELECT T24_BRANCH_CODE FROM NG_MAST_T24_BRANCH_MAPPING WHERE RBS_BRANCH_CODE='"+rbs_branch_code+"' AND ISACTIVE='Y' ";
				List<List<String>> T24_branch_codes_result = iformObj.getDataFromDB(query);
				logger.info("Query to fetch T24_BRANCH_CODE no is "+query+" and its result is "+T24_branch_codes_result);
				if(T24_branch_codes_result.size()>0)
				{
					if(T24_branch_codes_result.get(0).size()>0)
					{
						logger.info("Setting T24_branch_codes_result as "+T24_branch_codes_result.get(0).get(0));
						T24_branch_code=T24_branch_codes_result.get(0).get(0);
						logger.info("Setting T24_branch_code as "+T24_branch_code);
						iformObj.setValue("T24_BRANCH_CODE", T24_branch_code);
						return "Success~"+T24_branch_code;
					}
					else
					{
						iformObj.setValue("T24_BRANCH_CODE","");
						iformObj.setValue("Q_NG_POS_APPLICATION_DATA_DISBURSAL_ACC_NO","");
						logger.info("T24 Company ID does not found for given Account no");
						return "Error~T24 Company ID does not exist for selected Account no";
					}
				}
				else
				{
					iformObj.setValue("T24_BRANCH_CODE","");
					iformObj.setValue("Q_NG_POS_APPLICATION_DATA_DISBURSAL_ACC_NO","");
					logger.info("T24 Company ID does not found for given Account no");
					return "Error~T24 Company ID does not exist for selected Account no";
				}
			}
			else
			{
				logger.info("Disbural Account number is either null or less than of 5 digit");
				return "Error~Error in Fetching T24 Branch code from given account number";
			}
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: calculateT24BranchCode"+e);
			return "Error~Error in fetching T24 Branch Code";
		}
	}

	private String corporateGuaranteeCheck(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside corporateGuaranteeCheck");
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT CR_NUMBER FROM NG_POS_CR_DETAILS_GRID WHERE WI_NAME ='"+wi_name+"' AND CR_TYPE='Main CR'";
			List<List<String>> cr_no=iformObj.getDataFromDB(query);
			logger.info( "corporateGuaranteeCheck: Query to get cr no is "+query+" and its result is "+cr_no);
			if(cr_no.size()>0)
			{
				if(cr_no.size()==1)
				{
					if(cr_no.get(0).get(0)!=null)
					{
						int count=0;
						query="SELECT COUNT(1) FROM NG_POS_RELATED_PARTY_ROLES_GRID WHERE ROLE_TYPE='Guarantor' and WI_NAME ='"+wi_name+"' AND PERSONAL_GUARANTEE='TRUE' AND PARENT_CR ='"+cr_no.get(0).get(0)+"' ";
						List<List<String>> count_Result=iformObj.getDataFromDB(query);
						logger.info( "corporateGuaranteeCheck: Query to get count is "+query+" and its result is "+cr_no);
						if(count_Result.size()>0)
						{
							if(count_Result.get(0).get(0)!=null)
							{
								count=Integer.parseInt(count_Result.get(0).get(0).trim());
							}
						}
						logger.info("Inside corporateGuaranteeCheck, and case count is "+count_Result);
						
						if(count>0)
						{
							return "Error~Please add Main Company as corporate Guarantor" ;
						}
						else
						{
							return "Success" ;
						}
					}					
				}
				else
				{
					return "Error~Something went wrong in CR Details";
				}
			}
			else
			{
				return "";
			}
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: stagewisemandatorydocumentCheck "+e);
		}
		return"";
	}
	
	private String stagewisemandatorydocumentCheck(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside stagewisemandatorydocumentCheck");
		try
		{
			int document_Count=0;
			String wi_name=getWorkitemName(iformObj);
			String query="select count(1) from NG_POS_DOCUMENT_GRID where wi_name='"+wi_name+"' and MANDATORY='Yes' and UPLOAD_STATUS is null";
			List<List<String>> stage_wise_mandatory_document_count=iformObj.getDataFromDB(query);
			logger.info( "stagewisemandatorydocumentCheck: Error in query "+query+" and its result is "+stage_wise_mandatory_document_count);
			if(stage_wise_mandatory_document_count.size()>0)
			{
				if(stage_wise_mandatory_document_count.size()>0)
				{
					if(stage_wise_mandatory_document_count.get(0).get(0)!=null)
					{
						document_Count=Integer.parseInt(stage_wise_mandatory_document_count.get(0).get(0).trim());
						logger.info("Inside stagewisemandatorydocumentCheck, and document count is "+document_Count);
						if(document_Count>0)
						{
							return "Pass" ;
						}
						else
						{
							return "Fail" ;
						}
					}					
				}
			}
			else
			{
				logger.info("Inside stagewisemandatorydocumentCheck, No result fetch from the query, Please check ");
			}
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: stagewisemandatorydocumentCheck "+e);
		}
		return "";
	}

	private String maxCommodityPurchaseCheck(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside maxCommodityPurchaseCheck");
		try
		{
			String query="SELECT IIF(SUM(CAST(A.AMOUNT_SAR AS FLOAT))>(select sum(cast(param_value as float)) from NG_POS_PARAM_CONFIG where PARAM_KEY='MAX_COMMODITY_CAP'),'Yes','No') OUTSTANDING_AMT FROM NG_DIS_COMMODITY_PURCHASE A WHERE A.WI_NAME NOT IN (SELECT WI_NAME FROM NG_POS_EXTTABLE B WHERE B.SELL_COMM_CONFIRM_STATUS <>'NULL') AND A.DEAL_KEY <> 'NULL' ";
			List<List<String>> max_commodity_purchase_check=iformObj.getDataFromDB(query);
			logger.info( "maxCommodityPurchaseCheck: Error in query "+query+" and its result is "+max_commodity_purchase_check);
			if(max_commodity_purchase_check.size()>0)
			{
				if(max_commodity_purchase_check.size()>0)
				{
					if(max_commodity_purchase_check.get(0).get(0).trim().equalsIgnoreCase("Yes"))
					{
						logger.info("Inside maxCommodityPurchaseCheck, Returning Yes");
						return "Yes";
					}
					else if (max_commodity_purchase_check.get(0).get(0).trim().equalsIgnoreCase("No"))
					{
						logger.info("Inside maxCommodityPurchaseCheck, Returning No");
						return "No";
					}
				}
			}
			else
			{
				logger.info("Inside maxCommodityPurchaseCheck, No result fetch from the query Please check ");
			}
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: maxCommodityPurchaseCheck "+e);
		}
		return "";
	}

	private String pqapprovedAmountAfterSIMAH(IFormReference iformObj, String stringdata) 
	{
		String wi_name=getWorkitemName(iformObj);
		BigDecimal approved_amt_after_SIMAH=new BigDecimal(0); 
		try
		{
		logger.info("inside pqapprovedAmountAfterSIMAH function body ");
		DecimalFormat df=new DecimalFormat("#.##");
		
		BigDecimal total_obligation=new BigDecimal(0);
		BigDecimal total_througput=new BigDecimal(0);
		BigDecimal maximum_amount_allowed_product_master=new BigDecimal(0);
		BigDecimal outstanding_principal=new BigDecimal(0);
		BigDecimal funded_utilization=new BigDecimal(0);
		BigDecimal temp_Variable=new BigDecimal(0);
		BigDecimal other_SIMAH_obligation=new BigDecimal(0);
		BigDecimal total_SIMAH_obligation=new BigDecimal(0);
		BigDecimal pos_internal_obligation=new BigDecimal(0);
		BigDecimal non_pos_internal_obligation=new BigDecimal(0);

		BigDecimal current_dbr=new BigDecimal(0);
		
		String requested_amt=(String )iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
		BigDecimal req_amt_sar;
		try
		{
			 req_amt_sar=new BigDecimal(requested_amt);
		}
		catch(Exception e)
		{
			 req_amt_sar=new BigDecimal(0);
		}
		
		logger.info("Requested Amount is "+req_amt_sar);
	
		/*
		String total_througput_12_month_arb=null,total_througput_12_month_non_arb=null;
		total_througput_12_month_arb=(String) iformObj.getValue("Q_NG_POS_STMTDATA_ACCMOVMNT_TOT_THRGPUT_12MNTH");
		if(total_througput_12_month_arb.trim()==""  )
		{
			total_througput_12_month_arb="0";
		}
		logger.info("ARB 12 month througput is "+total_througput_12_month_arb);
		
		total_througput_12_month_non_arb=(String) iformObj.getValue("Q_NG_POS_STMTDATA_OTHER_DETAIL_TOT_THRGPUT_12MNTH");
		if(total_througput_12_month_non_arb.trim()==""  )
		{
			total_througput_12_month_non_arb="0";
		}
		logger.info("Non-ARB 12 month througput is "+total_througput_12_month_non_arb);
		
		
		//double temp=Double.parseDouble(String.format("%.2f",total_througput_12_month_arb ))+Double.parseDouble(String.format("%.2f",total_througput_12_month_non_arb));
		double temp=Double.parseDouble(total_througput_12_month_arb )+Double.parseDouble(total_througput_12_month_non_arb);
		*/
		
		String query="SELECT MAX(MAX_AMOUNT) FROM NG_MAST_POS_PRODUCT";
		List<List<String>> resultfromdb=iformObj.getDataFromDB(query);
		logger.info("Inside pqapprovedAmountAfterSIMAH and query for finding maximum amount allowed is"+query+" and its result is "+resultfromdb);
		if(resultfromdb.size()>0)
		{
			if(resultfromdb.get(0).size()==1)
			{
				if(resultfromdb.get(0).get(0).trim()!="" && !resultfromdb.get(0).get(0).equalsIgnoreCase("Null") )
				{
					logger.info("Maximum amount allowed from db is "+resultfromdb.get(0).get(0));
					maximum_amount_allowed_product_master=new BigDecimal(resultfromdb.get(0).get(0));
					logger.info("Maximum amount allowed is "+maximum_amount_allowed_product_master);
				}
			}
		}
		
		
		
		query="SELECT SUM(D.X) FROM( SELECT SUM(CAST(REPLACE(IIF(TOT_THRGPUT_12MNTH='',NULL,TOT_THRGPUT_12MNTH),',','') AS NUMERIC(30,2))) AS X FROM NG_POS_STMTDATA_ACCMOVMNT WHERE WI_NAME='"+wi_name+"' UNION ALL SELECT SUM(CAST(REPLACE(IIF(TOT_THRGPUT_12MNTH='',NULL,TOT_THRGPUT_12MNTH),',','') AS NUMERIC(30,2))) AS X FROM NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT WHERE WI_NAME='"+wi_name+"' UNION ALL SELECT SUM(CAST(REPLACE(IIF(TOT_THROUGPUT_LAST_12='',NULL,TOT_THROUGPUT_LAST_12),',','') AS NUMERIC(30,2))) AS X FROM NG_POS_STMTDATA_ACCMOVMNT_NON_ARB WHERE WI_NAME='"+wi_name+"') D";
		resultfromdb=iformObj.getDataFromDB(query);
		logger.info("Inside pqapprovedAmountAfterSIMAH and query for total througput is"+query+" and its result is "+resultfromdb);
		if(resultfromdb.size()>0)
		{
			if(resultfromdb.get(0).size()==1)
			{
				if(resultfromdb.get(0).get(0).trim()!="" && !resultfromdb.get(0).get(0).equalsIgnoreCase("Null") )
				{
					logger.info("other_SIMAH_obligation from db is "+resultfromdb.get(0).get(0));
					total_througput=new BigDecimal(resultfromdb.get(0).get(0));
					logger.info("other_SIMAH_obligationl_obligation is "+total_througput);
				}
			}
		}
		
		//total_througput=temp;
		logger.info("Total 12 month througput is "+total_througput);
		
		
		
		//Calculating a
		query="SELECT SUM(CAST(REPLACE(IIF(UTILIZATION='',NULL,UTILIZATION),',','') AS NUMERIC(30,2)))*1000 FROM NG_POS_SIMAH_L1_C1_SUMMARY_GRID WHERE CREDITOR !='RAJB' AND WI_NAME='"+wi_name+"' ";
		resultfromdb=iformObj.getDataFromDB(query);
		logger.info("Inside pqapprovedAmountAfterSIMAH and query for other_SIMAH_obligation is NG_POS_SIMAH_L1_C1_SUMMARY_GRID is"+query+" and its result is "+resultfromdb);
		if(resultfromdb.size()>0)
		{
			if(resultfromdb.get(0).size()==1)
			{
				if(resultfromdb.get(0).get(0).trim()!="" && !resultfromdb.get(0).get(0).equalsIgnoreCase("Null") )
				{
					logger.info("other_SIMAH_obligation from db is "+resultfromdb.get(0).get(0));
					other_SIMAH_obligation=new BigDecimal(resultfromdb.get(0).get(0));
					logger.info("other_SIMAH_obligationl_obligation is "+other_SIMAH_obligation);
				}
			}
		}
		
		//Calculating b
		query="SELECT sum(Outstanding) from( SELECT SUM(CAST(REPLACE(IIF(OUTSTDNG_PRINCIPAL='',NULL,OUTSTDNG_PRINCIPAL),',','') AS NUMERIC(30,2))) AS Outstanding FROM NG_POS_CREDITLINE_LOANACC_GRID WHERE WI_NAME='"+wi_name+"' AND PRODUCT='Point of Sale Finance' UNION SELECT sum(Outstanding) from( SELECT SUM(CAST(REPLACE (IIF(OUTSTANDING_BALANCE='',NULL,OUTSTANDING_BALANCE),',','') AS NUMERIC(30,2))) AS Outstanding FROM NG_POS_CREDITLINE_CTF_MSB_GRID WHERE WI_NAME='"+wi_name+"'AND PRODUCT_CODE='1012' ) TEMP UNION SELECT SUM(CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))) FROM NG_POS_TRASSET_DETAILS_GRID_NEW  WHERE WI_NAME='"+wi_name+"' AND CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))<=(SELECT MAX(MAX_AMOUNT) FROM NG_MAST_POS_PRODUCT)   ) b";
		resultfromdb=iformObj.getDataFromDB(query);
		logger.info("Inside pqapprovedAmountAfterSIMAH and query for pos_internal_obligation  is"+query+" and its result is "+resultfromdb);
		if(resultfromdb.size()>0)
		{
			if(resultfromdb.get(0).size()==1)
			{
				if(resultfromdb.get(0).get(0).trim()!="" && !resultfromdb.get(0).get(0).equalsIgnoreCase("Null") )
				{
					logger.info("pos_internal_obligation from db is "+resultfromdb.get(0).get(0));
					pos_internal_obligation=new BigDecimal(resultfromdb.get(0).get(0));
					logger.info("pos_internal_obligation is "+pos_internal_obligation);
				}
			}
		}

		//Calculating c
		query="SELECT SUm(Outstanding) from( SELECT SUM(CAST(REPLACE(IIF(OUTSTDNG_PRINCIPAL='',NULL,OUTSTDNG_PRINCIPAL),',','') AS NUMERIC(30,2))) AS Outstanding FROM NG_POS_CREDITLINE_LOANACC_GRID WHERE WI_NAME='"+wi_name+"' AND PRODUCT!='Point of Sale Finance' UNION SELECT sum(Outstanding) from( SELECT SUM(CAST(REPLACE(IIF(OUTSTANDING_BALANCE='',NULL,OUTSTANDING_BALANCE),',','') AS NUMERIC(30,2))) AS Outstanding FROM NG_POS_CREDITLINE_CTF_MSB_GRID WHERE WI_NAME='"+wi_name+"' AND PRODUCT_CODE!='1012' ) TEMP UNION SELECT SUM(CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))) FROM NG_POS_TRASSET_DETAILS_GRID_NEW  WHERE WI_NAME='"+wi_name+"' AND CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))>(SELECT MAX(MAX_AMOUNT) FROM NG_MAST_POS_PRODUCT) )  C  ";
		resultfromdb=iformObj.getDataFromDB(query);
		logger.info("Inside pqapprovedAmountAfterSIMAH and query for non_pos_internal_obligation  is"+query+" and its result is "+resultfromdb);
		if(resultfromdb.size()>0)
		{
			if(resultfromdb.get(0).size()==1)
			{
				if(resultfromdb.get(0).get(0).trim()!="" && !resultfromdb.get(0).get(0).equalsIgnoreCase("Null") )
				{
						logger.info("non_pos_internal_obligation from db is "+resultfromdb.get(0).get(0));
						non_pos_internal_obligation=new BigDecimal(resultfromdb.get(0).get(0));
						logger.info("non_pos_internal_obligation is "+non_pos_internal_obligation);
				}
			}
		}
		
		String commitment_amount_string=(String )iformObj.getValue("Q_NG_POS_APPLICATION_DATA_COMMITMENT_AMT");
		logger.info("Commitment amount fetched is "+commitment_amount_string);
		BigDecimal commitment_amount;
		try
		{
			commitment_amount=new BigDecimal(commitment_amount_string);
		}
		catch(Exception e)
		{
			commitment_amount=new BigDecimal(0);
		}
		
		//total_obligation=other_SIMAH_obligation+pos_internal_obligation+non_pos_internal_obligation;
		total_obligation=total_obligation.add(other_SIMAH_obligation);
		total_obligation=total_obligation.add(pos_internal_obligation);
		total_obligation=total_obligation.add(non_pos_internal_obligation);
		total_obligation=total_obligation.subtract(commitment_amount);
		logger.info("Final value of total_obligation is "+total_obligation);
		
		MathContext m=new MathContext(4);
		//current_dbr=(total_obligation+req_amt_sar)/total_througput;
		if(!total_througput.equals(0))
		{
			
			current_dbr=current_dbr.add(total_obligation);
			logger.info("Step 1 value of dbr is"+current_dbr);
			current_dbr=current_dbr.add(req_amt_sar);
			logger.info("Step 2 value of dbr is "+current_dbr);
			current_dbr=current_dbr.divide(total_througput,m);
			logger.info("Step 3 value of dbr is "+current_dbr);
			current_dbr=current_dbr.multiply(new BigDecimal(100));
			logger.info("Step 4 value of dbr is "+current_dbr);
		}
	
		logger.info("Current DBR is "+current_dbr);
		logger.info("Current DBR after formatting is "+df.format(current_dbr));
		iformObj.setValue("Q_NG_POS_ELIGIBILITY_CRNT_DBR",df.format(current_dbr));
		
		total_obligation=total_obligation.add(commitment_amount); // Done because we only want to change DBR not PQ2 amount
		
		//approved_amt_after_SIMAH=0.40*total_througput-total_obligation;
		approved_amt_after_SIMAH=total_througput.multiply(new BigDecimal("0.40"));
		approved_amt_after_SIMAH=approved_amt_after_SIMAH.subtract(total_obligation);
		
		logger.info("Approved amount after SIMAH as per old calculation is "+approved_amt_after_SIMAH);
		
		if(approved_amt_after_SIMAH.compareTo(maximum_amount_allowed_product_master)==1 || approved_amt_after_SIMAH.compareTo(maximum_amount_allowed_product_master)==0 )
		{
			logger.info("Approved Amount after SIMAH is greater than Maximum amount allowed at product level");
			logger.info("Hence, we are setting pq2 approvd amount equal to Maxium amount allowed at product level");
			approved_amt_after_SIMAH=maximum_amount_allowed_product_master;
		}
		
		temp_Variable=temp_Variable.add(approved_amt_after_SIMAH);
		temp_Variable=temp_Variable.add(pos_internal_obligation);

		if(temp_Variable.compareTo(maximum_amount_allowed_product_master)==1 || temp_Variable.compareTo(maximum_amount_allowed_product_master)==0)
		{
			logger.info("now as pq2 approved amount is coming more than Maximum amount allowed at product level");
			logger.info("Hence, we are subtracting internal obligation from pq2 approvd amount");
			approved_amt_after_SIMAH=maximum_amount_allowed_product_master.subtract(pos_internal_obligation);
		}
		
		logger.info("Approved amount after SIMAH as per new calculation is "+approved_amt_after_SIMAH);
		BigDecimal zero=new BigDecimal("0");
		
		if(approved_amt_after_SIMAH.compareTo(zero)==-1)
		{
			logger.info("Approved amount after SIMAH is negative hence putting it as 0");
			approved_amt_after_SIMAH=zero;
		}
		

		String pq_approve_amount_string=(String )iformObj.getValue("pq1_approved_amount");
		BigDecimal pq_approve_amount;
		try
		{
			pq_approve_amount=new BigDecimal(pq_approve_amount_string);
		}
		catch(Exception e)
		{
			pq_approve_amount=new BigDecimal(0);
		}
		
		String pq_approve_amount_with_exception_string=(String )iformObj.getValue("PQ1_AMOUNT_WITH_EXCEPTION");
		BigDecimal pq_approve_amount_with_exception;
		try
		{
			pq_approve_amount_with_exception=new BigDecimal(pq_approve_amount_with_exception_string);
		}
		catch(Exception e)
		{
			pq_approve_amount_with_exception=new BigDecimal(0);
		}
		
		pq_approve_amount=pq_approve_amount.max(pq_approve_amount_with_exception);
		
		logger.info("PQ1 Approved Amount is "+pq_approve_amount);
		logger.info("PQ1 Approved Amount With Exception is "+pq_approve_amount_with_exception);
		logger.info("PQ1 apporved amount is "+pq_approve_amount+" and pq2 amount upto now is "+approved_amt_after_SIMAH+" and their minimum is "+pq_approve_amount.min(approved_amt_after_SIMAH));
	
		
		BigDecimal final_amount=new BigDecimal(0);
		final_amount=pq_approve_amount.min(approved_amt_after_SIMAH);
		String request_type=(String)iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
		if(request_type.equalsIgnoreCase("Top-Up Request"))
		{
			
			final_amount=final_amount.add(commitment_amount);
			logger.info("As request type is Top-Up Request, we are adding commitment amount of "+commitment_amount+"into final amount and result is "+final_amount);
		}

		logger.info("Final value of pq2_approved_amount is "+final_amount);
		
		iformObj.setValue("Q_NG_POS_APPLICATION_DATA_APPROVED_LIMIT_AMT_AFTER_SIMAH",String.format("%.2f",final_amount));
		iformObj.setValue("Q_NG_POS_ELIGIBILITY_ELIG_AMT_AFTER_SIMAH",String.format("%.2f",final_amount));

		//Calculating SIMAH Obligation
		query="SELECT SUM(CAST(REPLACE(IIF(UTILIZATION='',NULL,UTILIZATION),',','') AS NUMERIC(30,2))) FROM NG_POS_SIMAH_L1_C1_SUMMARY_GRID WHERE WI_NAME='"+wi_name+"' ";
		resultfromdb=iformObj.getDataFromDB(query);
		logger.info("Inside pqapprovedAmountAfterSIMAH and query for total_SIMAH_obligation is"+query+" and its result is "+resultfromdb);
		if(resultfromdb.size()>0)
		{
			if(resultfromdb.get(0).size()==1)
				{
					if(resultfromdb.get(0).get(0).trim()!="" && !resultfromdb.get(0).get(0).equalsIgnoreCase("Null") )
					{
						logger.info("total_SIMAH_obligation from db is "+resultfromdb.get(0).get(0));
						total_SIMAH_obligation=new BigDecimal(resultfromdb.get(0).get(0));
						logger.info("total_SIMAH_obligation is "+total_SIMAH_obligation);
					}
				}
		}
		iformObj.setValue("Q_NG_POS_ELIGIBILITY_SIMAH_OBLIGATION",String.format("%.2f",total_SIMAH_obligation));
		
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: calculatepqamountafterSIMAH and exception is "+e);
		}
		return "Success~calculatepqamountafterSIMAH"+approved_amt_after_SIMAH;
	}
	
	private String calculateCurrentDBR(IFormReference iformObj, String stringData)
	{
		BigDecimal total_througput=new BigDecimal(0);
		BigDecimal total_obligation=new BigDecimal(0);
		BigDecimal req_amt_sar=new BigDecimal(0);
		

		//BigDecimal total_obligation=new BigDecimal(0);
		//BigDecimal total_througput=new BigDecimal(0);
		BigDecimal outstanding_principal=new BigDecimal(0);
		BigDecimal funded_utilization=new BigDecimal(0);
		
		BigDecimal other_SIMAH_obligation=new BigDecimal(0);
		BigDecimal total_SIMAH_obligation=new BigDecimal(0);
		BigDecimal pos_internal_obligation=new BigDecimal(0);
		BigDecimal non_pos_internal_obligation=new BigDecimal(0);
		
		String wi_name=getWorkitemName(iformObj);
		String query="SELECT SUM(D.X) FROM( SELECT SUM(CAST(REPLACE(IIF(TOT_THRGPUT_12MNTH='',NULL,TOT_THRGPUT_12MNTH),',','') AS NUMERIC(30,2))) AS X FROM NG_POS_STMTDATA_ACCMOVMNT WHERE WI_NAME='"+wi_name+"' UNION ALL SELECT SUM(CAST(REPLACE(IIF(TOT_THRGPUT_12MNTH='',NULL,TOT_THRGPUT_12MNTH),',','') AS NUMERIC(30,2))) AS X FROM NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT WHERE WI_NAME='"+wi_name+"' UNION ALL SELECT SUM(CAST(REPLACE(IIF(TOT_THROUGPUT_LAST_12='',NULL,TOT_THROUGPUT_LAST_12),',','') AS NUMERIC(30,2))) AS X FROM NG_POS_STMTDATA_ACCMOVMNT_NON_ARB WHERE WI_NAME='"+wi_name+"') D";
		List<List<String>> resultfromdb=iformObj.getDataFromDB(query);
		logger.info("Inside pqapprovedAmountAfterSIMAH and query for total througput is"+query+" and its result is "+resultfromdb);
		if(resultfromdb.size()>0)
		{
			if(resultfromdb.get(0).size()==1)
			{
				if(resultfromdb.get(0).get(0).trim()!="" && !resultfromdb.get(0).get(0).equalsIgnoreCase("Null") )
				{
					logger.info("other_SIMAH_obligation from db is "+resultfromdb.get(0).get(0));
					total_througput=new BigDecimal(resultfromdb.get(0).get(0));
					logger.info("other_SIMAH_obligationl_obligation is "+total_througput);
				}
			}
		}
		
		//total_througput=temp;
		logger.info("Total 12 month througput is "+total_througput);
			
		try
		{
			query="SELECT SUM(CAST(REPLACE(IIF(UTILIZATION='',NULL,UTILIZATION),',','') AS NUMERIC(30,2)))*1000 FROM NG_POS_SIMAH_L1_C1_SUMMARY_GRID WHERE CREDITOR !='RAJB' AND WI_NAME='"+wi_name+"' ";
			resultfromdb=iformObj.getDataFromDB(query);
			logger.info("Inside pqapprovedAmountAfterSIMAH and query for other_SIMAH_obligation is NG_POS_SIMAH_L1_C1_SUMMARY_GRID is"+query+" and its result is "+resultfromdb);
			if(resultfromdb.size()>0)
			{
				if(resultfromdb.get(0).size()==1)
				{
					if(resultfromdb.get(0).get(0).trim()!="" && !resultfromdb.get(0).get(0).equalsIgnoreCase("Null") )
					{
						logger.info("other_SIMAH_obligation from db is "+resultfromdb.get(0).get(0));
						other_SIMAH_obligation=new BigDecimal(resultfromdb.get(0).get(0));
						logger.info("other_SIMAH_obligationl_obligation is "+other_SIMAH_obligation);
					}
				}
			}
			
			//Calculating b
			query="SELECT sum(Outstanding) from( SELECT SUM(CAST(REPLACE(IIF(OUTSTDNG_PRINCIPAL='',NULL,OUTSTDNG_PRINCIPAL),',','') AS NUMERIC(30,2))) AS Outstanding FROM NG_POS_CREDITLINE_LOANACC_GRID WHERE WI_NAME='"+wi_name+"' AND PRODUCT='Point of Sale Finance' UNION SELECT sum(Outstanding) from( SELECT SUM(CAST(REPLACE (IIF(OUTSTANDING_BALANCE='',NULL,OUTSTANDING_BALANCE),',','') AS NUMERIC(30,2))) AS Outstanding FROM NG_POS_CREDITLINE_CTF_MSB_GRID WHERE WI_NAME='"+wi_name+"'AND PRODUCT_CODE='1012' ) TEMP UNION SELECT SUM(CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))) FROM NG_POS_TRASSET_DETAILS_GRID_NEW  WHERE WI_NAME='"+wi_name+"' AND CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))<=(SELECT MAX(MAX_AMOUNT) FROM NG_MAST_POS_PRODUCT)   ) b";
			resultfromdb=iformObj.getDataFromDB(query);
			logger.info("Inside pqapprovedAmountAfterSIMAH and query for pos_internal_obligation  is"+query+" and its result is "+resultfromdb);
			if(resultfromdb.size()>0)
			{
				if(resultfromdb.get(0).size()==1)
				{
					if(resultfromdb.get(0).get(0).trim()!="" && !resultfromdb.get(0).get(0).equalsIgnoreCase("Null") )
					{
						logger.info("pos_internal_obligation from db is "+resultfromdb.get(0).get(0));
						pos_internal_obligation=new BigDecimal(resultfromdb.get(0).get(0));
						logger.info("pos_internal_obligation is "+pos_internal_obligation);
					}
				}
			}

			//Calculating c
			query="SELECT SUm(Outstanding) from( SELECT SUM(CAST(REPLACE(IIF(OUTSTDNG_PRINCIPAL='',NULL,OUTSTDNG_PRINCIPAL),',','') AS NUMERIC(30,2))) AS Outstanding FROM NG_POS_CREDITLINE_LOANACC_GRID WHERE WI_NAME='"+wi_name+"' AND PRODUCT!='Point of Sale Finance' UNION SELECT sum(Outstanding) from( SELECT SUM(CAST(REPLACE(IIF(OUTSTANDING_BALANCE='',NULL,OUTSTANDING_BALANCE),',','') AS NUMERIC(30,2))) AS Outstanding FROM NG_POS_CREDITLINE_CTF_MSB_GRID WHERE WI_NAME='"+wi_name+"' AND PRODUCT_CODE!='1012' ) TEMP UNION SELECT SUM(CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))) FROM NG_POS_TRASSET_DETAILS_GRID_NEW  WHERE WI_NAME='"+wi_name+"' AND CAST(REPLACE(IIF(OUTSTANDING_PRINCIPAL='',NULL,OUTSTANDING_PRINCIPAL),',','') AS NUMERIC(30,2))>(SELECT MAX(MAX_AMOUNT) FROM NG_MAST_POS_PRODUCT) )  C  ";
			resultfromdb=iformObj.getDataFromDB(query);
			logger.info("Inside pqapprovedAmountAfterSIMAH and query for non_pos_internal_obligation  is"+query+" and its result is "+resultfromdb);
			if(resultfromdb.size()>0)
			{
				if(resultfromdb.get(0).size()==1)
				{
					if(resultfromdb.get(0).get(0).trim()!="" && !resultfromdb.get(0).get(0).equalsIgnoreCase("Null") )
					{
							logger.info("non_pos_internal_obligation from db is "+resultfromdb.get(0).get(0));
							non_pos_internal_obligation=new BigDecimal(resultfromdb.get(0).get(0));
							logger.info("non_pos_internal_obligation is "+non_pos_internal_obligation);
					}
				}
			}
			
			String commitment_amount_string=(String )iformObj.getValue("Q_NG_POS_APPLICATION_DATA_COMMITMENT_AMT");
			logger.info("Commitment amount fetched is "+commitment_amount_string);
			BigDecimal commitment_amount;
			try
			{
				commitment_amount=new BigDecimal(commitment_amount_string);
			}
			catch(Exception e)
			{
				commitment_amount=new BigDecimal(0);
			}

			logger.info("Final value of Commitment amount is "+commitment_amount);
			
			//total_obligation=other_SIMAH_obligation+pos_internal_obligation+non_pos_internal_obligation;
			total_obligation=total_obligation.add(other_SIMAH_obligation);
			total_obligation=total_obligation.add(pos_internal_obligation);
			total_obligation=total_obligation.add(non_pos_internal_obligation);
			total_obligation=total_obligation.subtract(commitment_amount);
			logger.info("Final value of total_obligation is "+total_obligation);

		}
		catch (Exception e)
		{
			total_obligation=new BigDecimal(0);
		}
		
		String requested_amt=(String )iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
		try
		{
			req_amt_sar=new BigDecimal(requested_amt);
		}
		catch(Exception e)
		{
			req_amt_sar=new BigDecimal(0);
		}
		MathContext m=new MathContext(4);
		//current_dbr=(total_obligation+req_amt_sar)/total_througput;
		BigDecimal zero=new BigDecimal("0");
		BigDecimal current_dbr=new BigDecimal(0);
		if(!total_througput.equals(0))
		{
			current_dbr=current_dbr.add(total_obligation);
			logger.info("Step 1 value of dbr is"+current_dbr);
			current_dbr=current_dbr.add(req_amt_sar);
			logger.info("Step 2 value of dbr is "+current_dbr);
			current_dbr=current_dbr.divide(total_througput,m);
			logger.info("Step 3 value of dbr is "+current_dbr);
			current_dbr=current_dbr.multiply(new BigDecimal(100));
			logger.info("Step 4 value of dbr is "+current_dbr);
		}
		
		logger.info("Current DBR is "+current_dbr+" and after roundoff value is "+String.format("%.2f",current_dbr));
		
		
		iformObj.setValue("Q_NG_POS_ELIGIBILITY_CRNT_DBR",String.format("%.2f",current_dbr));
		
		return "";
	}

	private String AddRelatedPartyPQ(IFormReference iformObj, String stringData) {
		logger.info("Inside AddRelatedPartyPQ stringData :"+stringData);
		String eligibility="";
		try
     	{
		eligibility=callProcedurewithreturn(iformObj, "[NG_calculate_limit_PQ1]", getWorkitemName(iformObj).toString());
        logger.info("eligibility:"+eligibility);
        iformObj.setValue("pq1_approved_amount", eligibility.split("~")[0].replace("[[", "").replace("[", "").replace("]", ""));
        iformObj.setValue("Q_NG_POS_APPLICATION_DATA_MAX_INDICATIVE_AMT_ELIGIBLE", eligibility.split("~")[0].replace("[[", "").replace("[", "").replace("]", ""));
        iformObj.setValue("Q_NG_POS_ELIGIBILITY_ELIGIBLE_POS_LIMIT", eligibility.split("~")[0].replace("[[", "").replace("[", "").replace("]", ""));
        if(eligibility.split("~").length==3)
        	iformObj.setValue("PQ1_AMOUNT_WITH_EXCEPTION", eligibility.split("~")[1].replace("[[", "").replace("[", "").replace("]", ""));
        else
        	iformObj.setValue("PQ1_AMOUNT_WITH_EXCEPTION","0.00");
        
     	}
		catch(Exception e)
		{
			logger.info("Exception Occurred: AddRelatedPartyPQ and exception is +"+e);
		}
        return "Success~AddRelatedPartyPQ~"+eligibility;
 }
	
	private String callReapprovalProc(IFormReference iformObj, String stringData) 
	{
		String wi_name=getWorkitemName(iformObj);
		try
		{
			logger.info("Inside callReapprovalProc stringData :"+stringData);
			callProcedure(iformObj,"NG_calculate_reapproval_scenario", wi_name);
			
			String query="SELECT REAPPROVAL_SCENARIO FROM NG_POS_EXTTABLE WHERE WI_NAME='"+wi_name+"' ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			logger.info("Reapporval Scenario for "+wi_name+" is "+result);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					iformObj.setValue("REAPPROVAL_SCENARIO",result.get(0).get(0));
				}
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: callReapprovalProcand exception is +"+e);
		}
		return "Success~callReapprovalProc";
	}


	private String defaultcampaign(IFormReference iformObj, String stringdata) 
	{
		try 
		{
		
		String query="";
		List<List> result_list=null;
		if(((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN")).length()==0)
		{
			//Start Edit by Deepak Goyal
			//query="SELECT CAMPAIGN FROM NG_MAST_CAMPAIGN WHERE ISACTIVE='Y' ";
			query="SELECT CAMPAIGN FROM NG_MAST_CAMPAIGN WHERE getdate() between start_date and end_date ";
			//End Edit by Deepak Goyal
			result_list=iformObj.getDataFromDB(query);
			logger.info("For default campaing query is "+query+" and its result is "+result_list);
			if(result_list.size()>0)
			{
				if(result_list.size()==1)
				{
					logger.info("case1: Inside defaultcampaign: Setting default value of campaign as "+result_list.get(0).get(0));
					iformObj.setValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN",(String)result_list.get(0).get(0));
				}
				else
				{
					logger.info("case 2: Inside defaultcampaign: Setting default value of campaign as "+result_list.get(result_list.size()-1).get(0));
					iformObj.setValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN",(String)result_list.get(result_list.size()-1).get(0));
				}
			}
		}
		
		String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
		String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
		String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
		String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
		String requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
		
		String default_profit_rate="",def_tenure="",def_grace_period="",def_grace_period_captialization="",installment_type="";
		query="SELECT Def_Profit_Rate,Max_Tenure,GRACE_PERIOD,GRACE_PERIOD_CAPITALIZATION,TYPE_OF_INSTALLMENT FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+" ";
		result_list=iformObj.getDataFromDB(query);
		logger.info("Query for default profit,tenure,grace period is "+query+" and result is "+result_list);
		if(result_list.size()>0 )
		{
			if(result_list.get(0).size()==5)
			{
				logger.info("Size of result list is 5");
				default_profit_rate=(String) result_list.get(0).get(0);
				def_tenure=(String) result_list.get(0).get(1);
				def_grace_period=(String) result_list.get(0).get(2);
				def_grace_period_captialization=(String) result_list.get(0).get(3);
				installment_type=(String) result_list.get(0).get(4);
			}
		}
		
		logger.info("Setting values for default profit,tenure,grace period based on condition");
		
		logger.info("Value of Q_NG_POS_APPLICATION_DATA_PROFIT is "+iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PROFIT"));
		logger.info("Value of Q_NG_POS_APPLICATION_DATA_TENURE is "+iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE"));
		logger.info("Value of Q_NG_POS_APPLICATION_DATA_GRACE_PERIOD is "+iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_PERIOD"));
		logger.info("Value of Q_NG_POS_APPLICATION_DATA_GRACE_PRD_CAPITALIZATION is "+iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_PRD_CAPITALIZATION"));
		logger.info("Value of Q_NG_POS_APPLICATION_DATA_TYPE_OF_INSTALLMENT is "+iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TYPE_OF_INSTALLMENT"));
		
		if(((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PROFIT")).trim().equals("") || ((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PROFIT")).equals("0") ||  ((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PROFIT")).equals("0.0") )
		{
			logger.info("Setting Q_NG_POS_APPLICATION_DATA_PROFIT" + default_profit_rate);
			if(default_profit_rate.trim()!="" && default_profit_rate.trim()!=null)	
				iformObj.setValue("Q_NG_POS_APPLICATION_DATA_PROFIT", default_profit_rate);
		}
		if(((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PROPOSED_PROFIT")).trim().equals("") || ((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PROPOSED_PROFIT")).equals("0") ||  ((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PROPOSED_PROFIT")).equals("0.0") )
		{
			logger.info("Setting Q_NG_POS_APPLICATION_DATA_PROPOSED_PROFIT" + default_profit_rate);
			if(default_profit_rate.trim()!="" && default_profit_rate.trim()!=null)
			{
				iformObj.addItemInCombo("Q_NG_POS_APPLICATION_DATA_PROPOSED_PROFIT", default_profit_rate,default_profit_rate);
				iformObj.setValue("Q_NG_POS_APPLICATION_DATA_PROPOSED_PROFIT", default_profit_rate);
			}
		}
		if(((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_PERIOD")).trim().equals("") || true) // Always set grace period acc to product master
		{
			
			if(def_grace_period.trim()!=null && def_grace_period.trim().equalsIgnoreCase("Yes"))
			{	
				logger.info("Setting Q_NG_POS_APPLICATION_DATA_GRACE_PERIOD" + def_grace_period);
				iformObj.setValue("Q_NG_POS_APPLICATION_DATA_GRACE_PERIOD", def_grace_period.trim());
				iformObj.setStyle("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH","disable","false");
				//iformObj.setValue("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH", "0");
			}
			else
			{
				logger.info("Setting Q_NG_POS_APPLICATION_DATA_GRACE_PERIOD" + def_grace_period);
				iformObj.setValue("Q_NG_POS_APPLICATION_DATA_GRACE_PERIOD", def_grace_period.trim());
				iformObj.setStyle("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH","disable","true");
				//JSONArray obj=new JSONArray();
				iformObj.setValue("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH", "0");
			}
			
		}
		if(((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_PRD_CAPITALIZATION")).trim().equals("") || true)// Always set grace period acc to product master
		{
			logger.info("Setting Q_NG_POS_APPLICATION_DATA_GRACE_PRD_CAPITALIZATION"+ def_grace_period_captialization);
			if(def_grace_period_captialization.trim()!="" && def_grace_period_captialization.trim()!=null)
			iformObj.setValue("Q_NG_POS_APPLICATION_DATA_GRACE_PRD_CAPITALIZATION", def_grace_period_captialization);
		}
		if(((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TYPE_OF_INSTALLMENT")).trim().equals("") || true)// Always set grace period acc to product master
		{
			logger.info("Setting Q_NG_POS_APPLICATION_DATA_TYPE_OF_INSTALLMENT"+ installment_type);
			if(installment_type.trim()!="" && installment_type.trim()!=null)
			iformObj.setValue("Q_NG_POS_APPLICATION_DATA_TYPE_OF_INSTALLMENT", installment_type);
		}
		
		if(((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE")).trim().equals(""))
		{
			logger.info("Setting Q_NG_POS_APPLICATION_DATA_TENURE"+ def_tenure);
			if(def_tenure.trim()!="" && def_tenure.trim()!=null)
			{
				iformObj.setValue("Q_NG_POS_APPLICATION_DATA_TENURE", def_tenure);
				return "Success~TenureChanged";
				//Commenting this because if we set default tenure, then need some logic to calculate fees 
				//as, it is calculated on change of tenure. 
			}
				
		}
		
		}
		catch(Exception e)
		{
			logger.info("Exception occurred in defaultcampaign and exception is "+e);
		}
		
		return "Success~defaultcampaign";
	}

	private String SiteVisitChecklist(IFormReference iformObj, String stringdata) 
	{
		// TODO Auto-generated method stub
		logger.info("Inside Location Visit grid");
		JSONArray arr = new JSONArray();
		String query="SELECT SR_NO,ITEM_DESC,ITEM_CONFIRMATION FROM NG_MAST_SITEVISIT_CHECKLIST";
		String field_list="S. No.,Checklist,Value Confirmation,Description/Answer";
		String[] field_list_array=field_list.split(",");
		List<List<String>> jsonresult = iformObj.getDataFromDB(query);
		logger.info("the query is \n"+query+"\n field list array is \n"+field_list_array+"\n"+jsonresult);
		for (List<String> internal_list : jsonresult) 
			{
				JSONObject internal_object=null;
				internal_object=new JSONObject();
				for(int i=0;i<internal_list.size();i++)
					{
						internal_object.put(field_list_array[i],internal_list.get(i));
					}
				arr.add(internal_object);
			}
		logger.info("object array is"+arr.toString());
		iformObj.addDataToGrid("table10059_table48", arr);
		return "Success~SiteVisitChecklist";
	}
	
	private String RelatedPartyHiddenRowSet(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside BuyAndContractOnLoad function and strin data is "+stringdata);
		//2#3#checked 1#2#unchecked
		String row_index=null,checked_unchecked_flag=null,column_index=null;
		if(stringdata.contains("#"))
		{
			row_index=stringdata.split("#")[0];
			column_index=stringdata.split("#")[1];
			checked_unchecked_flag=stringdata.split("#")[2];
			
			logger.info("rowindex,column_index and checked unchecked flag is  "+row_index+", "+column_index+", "+checked_unchecked_flag);
		}
		JSONArray jarr=iformObj.getDataFromGrid("MSB_SEARCH_ROLE_GRID");
		iformObj.setTableCellValue("MSB_SEARCH_ROLE_GRID",Integer.parseInt(row_index),Integer.parseInt(column_index),checked_unchecked_flag);	
		logger.info("Json array after changes for  MSB_SEARCH_ROLE_GRID is "+jarr);
		return "Success~RelatedPartyHiddenRowSet";
	}
	
	private String subFormTest(IFormReference iformObj, String stringdata)
	{
		iformObj.setValue("SIMAH_IND_PROVIDED_ENQUIRY_REFERENCE","0031412623");
		return "sucess~subFormTest";
		
	}
	
	private String subFormLoadSIMAHCommercial(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside subFormCalled and cr_number is "+stringdata);
		String cr_number=stringdata;
		String field_list="SIMAH_COMM_SERVICE,SIMAH_COMM_ACTION,SIMAH_COMM_MEMBER_ID,SIMAH_COMM_USER_ID,SIMAH_COMM_RUN_NO,SIMAH_COMM_TOTAL_ITEMS,SIMAH_COMM_ERROR_ITEMS,SIMAH_COMM_REPORT_DATE_GR,SIMAH_COMM_REPORT_DATE_HJ,SIMAH_COMM_ENQUIRY_TYPE,SIMAH_COMM_ENQUIRY_NO,SIMAH_COMM_REFERENCE_NO,SIMAH_COMM_AMOUNT,SIMAH_COMM_GOVERNMENT_GUARANTEED,SIMAH_COMM_PRODUCT_TYPE,SIMAH_COMM_CREDIT_FACILITY,SIMAH_COMM_PREVIOUS_ENQUIRY_CNT,SIMAH_COMM_PREVIOUS_30_DAYS_DENQ_CNT,SIMAH_COMM_CI_COUNT,SIMAH_COMM_GUARANTEED_CI_COUNT,SIMAH_COMM_ISSUE_DATE,SIMAH_COMM_TOTAL_LIMITS,SIMAH_COMM_TOTAL_GUI_LIMITS,SIMAH_COMM_TOTAL_LIABILITIES,SIMAH_COMM_TOTAL_DEFAULTS,SIMAH_COMM_CURRENT_DEL_BAL,SIMAH_COMM_UNSETTLED_DEFAULT_COUNT,SIMAH_COMM_SETTLED_DEFAULT_COUNT,SIMAH_COMM_UNSETTLED_DEFAULTS_AMT,SIMAH_COMM_UNSETTLED_BC_COUNT,SIMAH_COMM_SETTLED_BC_COUNT,SIMAH_COMM_UNSETTLED_BC_AMOUNT,SIMAH_COMM_O_30_OVER,SIMAH_COMM_O_60_OVER,SIMAH_COMM_O_90_OVER,SIMAH_COMM_O_120_OVER,SIMAH_COMM_O_150_OVER,SIMAH_COMM_O_180_OVER,SIMAH_COMM_TC_30_OVER,SIMAH_COMM_TC_60_OVER,SIMAH_COMM_TC_90_OVER,SIMAH_COMM_TC_120_OVER,SIMAH_COMM_TC_150_OVER,SIMAH_COMM_TC_180_OVER,SIMAH_COMM_PDB_30_OVER,SIMAH_COMM_PDB_60_OVER,SIMAH_COMM_PDB_90_OVER,SIMAH_COMM_PDB_120_OVER,SIMAH_COMM_PDB_150_OVER,SIMAH_COMM_PDB_180_OVER,SIMAH_COMM_DISCLAIMER_ENG,SIMAH_COMM_DISCLAIMER_AR,SIMAH_COMM_CIC_NO,SIMAH_COMM_CHECKED_DATE,SIMAH_COMM_NAME,SIMAH_COMM_NAME_AR,SIMAH_COMM_C_DATE,SIMAH_COMM_PREVIOUS_NAME,SIMAH_COMM_PERVIOUS_NAME_AR,SIMAH_COMM_ISSUER,SIMAH_COMM_ISSUER_DESCRIPT,SIMAH_COMM_ISSUER_DESCRIPT_AR,SIMAH_COMM_IDCOD,SIMAH_COMM_ISSCIT,SIMAH_COMM_ISSCIT_DESCRIPT,SIMAH_COMM_ISSCIT_DESCRIPT_AR,SIMAH_COMM_EXPIRY_DATE,SIMAH_COMM_LEGAL_FORM,SIMAH_COMM_DATE_ESTABLISHED,SIMAH_COMM_BUSINESS_ACTIVITY,SIMAH_COMM_WEBSITE,SIMAH_COMM_NO_OF_STAFF,SIMAH_COMM_GENDER,SIMAH_COMM_DOB,SIMAH_COMM_NATIONALITY";
		String field_list_array[];
		field_list_array=field_list.split(",");
		String query="SELECT SERVICE,ACTION,MEMBER_ID,USER_ID,RUN_NO,TOTAL_ITEMS,ERROR_ITEMS,REPORT_DATE_GR,REPORT_DATE_HJ,ENQUIRY_TYPE,ENQUIRY_NO,REFERENCE_NO,AMOUNT,GOVERNMENT_GUARANTEED,PRODUCT_TYPE,CREDIT_FACILITY,PREVIOUS_ENQUIRY_CNT,PREVIOUS_30_DAYS_DENQ_CNT,CI_COUNT,GUARANTEED_CI_COUNT,ISSUE_DATE,TOTAL_LIMITS,TOTAL_GUI_LIMITS,TOTAL_LIABILITIES,TOTAL_DEFAULTS,CURRENT_DEL_BAL,UNSETTLED_DEFAULT_COUNT,SETTLED_DEFAULT_COUNT,UNSETTLED_DEFAULTS_AMT,UNSETTLED_BC_COUNT,SETTLED_BC_COUNT,UNSETTLED_BC_AMOUNT,O_30_OVER,O_60_OVER,O_90_OVER,O_120_OVER,O_150_OVER,O_180_OVER,TC_30_OVER,TC_60_OVER,TC_90_OVER,TC_120_OVER,TC_150_OVER,TC_180_OVER,PDB_30_OVER,PDB_60_OVER,PDB_90_OVER,PDB_120_OVER,PDB_150_OVER,PDB_180_OVER,DISCLAIMER_ENG,DISCLAIMER_AR,CIC_NO,CHECKED_DATE,NAME,NAME_AR,C_DATE,PREVIOUS_NAME,PERVIOUS_NAME_AR,ISSUER,ISSUER_DESCRIPT,ISSUER_DESCRIPT_AR,IDCOD,ISSCIT,ISSCIT_DESCRIPT,ISSCIT_DESCRIPT_AR,EXPIRY_DATE,LEGAL_FORM,DATE_ESTABLISHED,BUSINESS_ACTIVITY,WEBSITE,NO_OF_STAFF,GENDER,DOB,NATIONALITY FROM NG_POS_SIMAH_RP_BASIC_DETAILS WHERE CR_NO ='"+cr_number+"'";
		List<List<String>> result= iformObj.getDataFromDB(query);	
		logger.info("Query for SIMAH COMMERCIAL one-one field is  "+query+" and its result is "+result);
		for(List<String> internal_list: result  )
		{
			logger.info("Internal List is "+internal_list);
			for(int i=0;i<internal_list.size();i++)
			{
				logger.info("Setting values as "+field_list_array[i]+" in "+internal_list.get(i));
				iformObj.setValue(field_list_array[i],internal_list.get(i));
			}
		}
		logger.info("After inserting in one to one field");
		
		//SIMAH_RP_PREVIOUS_ENQUIRIES_GRID
		JSONArray arr = new JSONArray();
		query="SELECT ENQUIRY_DATE,ENQUIRER,ENQUIRY_TYPE,MEMBER_REFERENCE,PRODUCT_TYPE,AMOUNT,NAME FROM NG_POS_SIMAH_RP_PREVIOUS_ENQUIRIES_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Enquiry Date,Enquirer,Enquiry Type,Member Reference,Product Type,Amount,Name";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}
		iformObj.addDataToGrid("SIMAH_RP_PREVIOUS_ENQUIRIES_GRID", arr);
		logger.info("After SIMAH_RP_PREVIOUS_ENQUIRIES_GRID is "+arr);
		
		//SIMAH_RP_CONTACT_DETAILS_GRID
		arr = new JSONArray();
		query="SELECT PHONE_TYPE,COUNTRY,PREFIX,CONTACT_NUMBER,EXTENSION,UNFORMATED_CONTACT FROM NG_POS_SIMAH_RP_CONTACT_DETAILS_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Phone Type,Country,Prefix,Number,Extension,Unformatted Contact";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_CONTACT_DETAILS_GRID", arr);
		logger.info("After SIMAH_RP_CONTACT_DETAILS_GRID is "+arr);
		
		//SIMAH_RP_AS_NARRATIVE_GRID
		arr = new JSONArray();
		query="SELECT NARRATIVE_TYPE,DATE_LOADED,LOADED_BY,TEXT_ENG,TEXT_AR FROM NG_POS_SIMAH_RP_AS_NARRATIVE_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Type,Date Loaded,Loaded By,Text,Text (Ar)";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_AS_NARRATIVE_GRID", arr);
		logger.info("After SIMAH_RP_AS_NARRATIVE_GRID is "+arr);
		
		//SIMAH_RP_ADDRESS_DETAILS_GRID
		arr = new JSONArray();
		query="SELECT ADDRESS_LINE_1_ENG,ADDRESS_LINE_2_ENG,ADDRESS_LINE_3_ENG,ADDRESS_LINE_4_ENG,PO_BOX,CITY,POSTAL_CODE,EXTRA_NUMBER,DATE_OF_UPLOAD FROM NG_POS_SIMAH_RP_ADDRESS_DETAILS_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Address Line 1 (Eng),Address Line 2 (Eng),Address Line 3 (Eng),Address Line 4 (Eng),PO Box,City,Post Code,Extra Number,Date of Upload";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_ADDRESS_DETAILS_GRID", arr);
		logger.info("After SIMAH_RP_ADDRESS_DETAILS_GRID is "+arr);
		
		//SIMAH_RP_DEFAULTS_GRID
		arr = new JSONArray();
		query="SELECT PRODUCT_TYPE,CREDITOR,ACCOUNT_NO,DATE_LOADED,ORIGINAL_AMT,OS_BALANCE,DEFAULT_STATUS,SETTLEMENT_DATE FROM NG_POS_SIMAH_RP_DEFAULTS_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Product Type,Creditor,Account Number,Date Loaded,Original Amount,OS Balance,Default Status,Settlement Date";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_DEFAULTS_GRID", arr);
		logger.info("After SIMAH_RP_DEFAULTS_GRID is "+arr);
		
		//SIMAH_RP_GUARAN_KEY_STAKEHOLDER_GRID
		arr = new JSONArray();
		query="SELECT G_MEMBER,GUARANTOR_NAME_ENG,GUARANTOR_NAME_AR,ID_NUMBER,ID_ISSUER,ID_CITY,G_AMOUNT FROM NG_POS_SIMAH_RP_GUARAN_KEY_STAKEHOLDER_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="G Member,Guarantor Name (Eng),Guarantor Name (Ar),ID Number,ID Issuer,ID City,G Amount";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_GUARAN_KEY_STAKEHOLDER_GRID", arr);
		logger.info("After SIMAH_RP_GUARAN_KEY_STAKEHOLDER_GRID is "+arr);
		
		//SIMAH_RP_JUDGEMENT_GRID
		arr = new JSONArray();
		query="SELECT ENFORCE_DATE,RES_NUMBER,COURT_DATE,CASE_NUMBER,DATE_LOADED,ORIGINAL_CLAIM_AMOUNT,JUDGEMENT_STATUS,SETTLEMENT_DATE FROM NG_POS_SIMAH_RP_JUDGEMENT_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Enforce Date,Res. Number,Court Date,Case Number,Date Loaded,Original Claim Amount,Status,Settlement Date";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_JUDGEMENT_GRID", arr);
		logger.info("After SIMAH_RP_JUDGEMENT_GRID is "+arr);
		
		//SIMAH_RP_KEY_STAKEHOLDER_GRID
		arr = new JSONArray();
		query="SELECT NAME,NAME_U,NAME_ENG,NAME_AR,ID_NO,ID_ISSUER,CITY,RELATIONSHIP,RELATIONSHIP_AR,RELATIONSHIP_CODE,RELATIONSHIP_DESCRIPT,RELATIONSHIP_DESCRIPT_AR,PERCENTAGE_OWNED FROM NG_POS_SIMAH_RP_KEY_STAKEHOLDER_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Name,Name U,Name (Eng),Name (Ar),ID Number,ID Issuer,ID City,Relationship,Relationship (Ar),Relationship Code,Relationship Description,Relationship Description (Ar),Percentage Owned";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_KEY_STAKEHOLDER_GRID", arr);
		logger.info("After SIMAH_RP_KEY_STAKEHOLDER_GRID is "+arr);
		
		//SIMAH_RP_L1_C1_SUMMARY_GRID
		arr = new JSONArray();
		query="SELECT CREDITOR,APPROVED_LIMIT,GLOBAL_LIMIT,UTILIZATION,UN_UTILIZED_BALANCE,MEMBER_STATUS,PAST_DUE,COLLATERAL,RELATIONSHIP_AGE,AS_OF_DATE,FUNDED_LIMIT,FUNDED_CAP,FUNDED_UTILIZATION,FUNDED_UTILIZATION_BALANCE,NON_FUNDED_LIMIT,NON_FUNDED_CAP,NON_FUNDED_UTILIZATION,NON_FUNDED_UN_UTILIZED_BALANCE,SHARED_LIMIT FROM NG_POS_SIMAH_RP_L1_C1_SUMMARY_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Creditor,Approved Limit,Global Limit,Utilization,Un-Utilized Balance,Status,Past Due,Collateral,Relationship Age,As of Date,Funded Limit,Funded Cap,Funded Utilization,Funded Unutilized Balance,Non Funded Limit,Non Funded  Cap,Non Funded Utilization,Non Funded Unutilized Balance,Shared Limit";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_L1_C1_SUMMARY_GRID", arr);
		logger.info("After SIMAH_RP_L1_C1_SUMMARY_GRID is "+arr);
		
		//SIMAH_RP_L2_C1_SUMMARY_GRID
		arr = new JSONArray();
		query="SELECT CREDITOR,APPROVED_LIMIT,GLOBAL_LIMIT,UTILIZATION,UN_UTILIZED_BALANCE,MEMBER_STATUS,PAST_DUE,COLLATERAL,RELATIONSHIP_AGE,AS_OF_DATE,FUNDED_LIMIT,FUNDED_CAP,FUNDED_UTILIZATION,FUNDED_UTILIZATION_BALANCE,NON_FUNDED_LIMIT,NON_FUNDED_CAP,NON_FUNDED_UTILIZATION,NON_FUNDED_UN_UTILIZED_BALANCE,SHARED_LIMIT FROM NG_POS_SIMAH_RP_L2_C1_SUMMARY_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Creditor,Approved Limit,Global Limit,Utilization,Un-Utilized Balance,Status,Past Due,Collateral,Relationship Age,As of Date,Funded Limit,Funded Cap,Funded Utilization,Funded Unutilized Balance,Non Funded Limit,Non Funded  Cap,Non Funded Utilization,Non Funded Unutilized Balance,Shared Limit";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_L2_C1_SUMMARY_GRID", arr);
		logger.info("After SIMAH_RP_L2_C1_SUMMARY_GRID is "+arr);
		
		//SIMAH_RP_RATING_GRID
		arr = new JSONArray();
		query="SELECT RATING_DATE,BANK_NAME,UPDATED_DATE,RATING_CODE,RATING_DESCRIPT,RATING_DESCRIPT_AR FROM NG_POS_SIMAH_RP_RATING_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Rating Date,Bank Name, Updated Date,Rating Code,Rating Description,Rating Description (Ar)";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_RATING_GRID", arr);
		logger.info("After SIMAH_RP_RATING_GRID is "+arr);
		
		//SIMAH_RP_BOUNCED_CHEQUES_GRID
		arr = new JSONArray();
		query="SELECT REGISTRATION_DATE,REPORTING_BANK,LOAD_DATE,REFERENCE_NO,AMOUNT,DEFAULT_STATUS,SETTLEMENT_DATE,BCHQRSCD FROM NG_POS_SIMAH_RP_BOUNCED_CHEQUES_GRID WHERE CR_NO='"+cr_number+"' ";
		field_list="Registration Date,Reporting Bank,Load Date,Reference Number,Amount,Default Status,Settlement Date,BCHQRSCD";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}		
		iformObj.addDataToGrid("SIMAH_RP_BOUNCED_CHEQUES_GRID", arr);
		logger.info("After SIMAH_RP_BOUNCED_CHEQUES_GRID is "+arr);		
				
		return "success~subFormLoadSIMAHCommercial";
	}
	
	private String subFormLoadSIMAH(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside subFormCalled");
		String cic_number=stringdata;
		String field_list="SIMAH_IND_PROVIDED_ENQUIRY_REFERENCE,SIMAH_IND_PROVIDED_ENQUIRY_TYPE,SIMAH_IND_PROVIDED_NO_OF_APPLICANTS,SIMAH_IND_PROVIDED_ACCOUNT_TYPE,SIMAH_IND_PROVIDED_REPORT_DATE,SIMAH_IND_PROVIDED_ENQUIRY_NO,SIMAH_IND_PROVIDED_PRODUCT_TYPE,SIMAH_IND_PROVIDED_AMOUNT,SIMAH_IND_PROVIDED_MBR_TYPE,SIMAH_IND_PROVIDED_MBR_STS,SIMAH_IND_PROVIDED_CAPL,SIMAH_IND_PROVIDED_CID1,SIMAH_IND_PROVIDED_CID2,SIMAH_IND_PROVIDED_CID3,SIMAH_IND_PROVIDED_CVIP,SIMAH_IND_PROVIDED_PCNMFA,SIMAH_IND_PROVIDED_PCNM1A,SIMAH_IND_PROVIDED_PCDOB,SIMAH_IND_PROVIDED_PCGND,SIMAH_IND_PROVIDED_PCMAR,SIMAH_IND_PROVIDED_PCNAT,SIMAH_IND_PROVIDED_PCEML,SIMAH_IND_PROVIDED_ACNMFA,SIMAH_IND_PROVIDED_ACNM1A,SIMAH_IND_PROVIDED_ACNM2A,SIMAH_IND_PROVIDED_ACNM3A,SIMAH_IND_PROVIDED_ACDOB,SIMAH_IND_PROVIDED_ACGND,SIMAH_IND_PROVIDED_ACMAR,SIMAH_IND_PROVIDED_ACNAT,SIMAH_IND_PROVIDED_ACEML,SIMAH_IND_PROVIDED_CNT_PE,SIMAH_IND_PROVIDED_CNT_MTDE,SIMAH_IND_PROVIDED_CNT_CI,SIMAH_IND_PROVIDED_CNT_GCI,SIMAH_IND_PROVIDED_CNT_DEF,SIMAH_IND_PROVIDED_EIID,SIMAH_IND_PROVIDED_TOT_LIM,SIMAH_IND_PROVIDED_TOT_GLIM,SIMAH_IND_PROVIDED_TOT_LIAB,SIMAH_IND_PROVIDED_TOT_GLIAB,SIMAH_IND_PROVIDED_TOT_DEF,SIMAH_IND_PROVIDED_CUR_DB,SIMAH_IND_PROVIDED_DI_TEXT,SIMAH_IND_PROVIDED_DI_TEXT_AR";
		String field_list_array[];
		field_list_array=field_list.split(",");
		String query="SELECT ENQUIRY_REFERENCE,ENQUIRY_TYPE,NO_OF_APPLICANTS,ACCOUNT_TYPE,REPORT_DATE,ENQUIRY_NO,PRODUCT_TYPE,AMOUNT,MBR_TYPE,MBR_STS,CAPL,CID1,CID2,CID3,CVIP,PCNMFA,PCNM1A,PCDOB,PCGND,PCMAR,PCNAT,PCEML,ACNMFA,ACNM1A,ACNM2A,ACNM3A,ACDOB,ACGND,ACMAR,ACNAT,ACEML,CNT_PE,CNT_MTDE,CNT_CI,CNT_GCI,CNT_DEF,EIID,TOT_LIM,TOT_GLIM,TOT_LIAB,TOT_GLIAB,TOT_DEF,CUR_DB,DI_TEXT,DI_TEXT_AR FROM NG_POS_SIMAH_IND_PROVIDED_SECTION WHERE CIC_NO='"+cic_number+"'  ";
		List<List<String>> result= iformObj.getDataFromDB(query);	
		logger.info("Query for SIMAH Individual one-one field is  "+query+" and its result is "+result);
		for(List<String> internal_list: result  )
		{
			logger.info("Internal List is "+internal_list);
			for(int i=0;i<internal_list.size();i++)
			{
				logger.info("Setting values as "+field_list_array[i]+" in "+internal_list.get(i));
				iformObj.setValue(field_list_array[i],internal_list.get(i));
			}
		}
		logger.info("After inserting in one to one field");
		
		//NG_POS_SIMAH_IND_PREV_ENQUIRY_GRID
		JSONArray arr = new JSONArray();
		query="SELECT PE_DATE,PE_INQR,PE_TYPE,PE_MEMB_REF,PE_PRD,PE_AMOUNT,PE_NMFA,PE_NM1A,PE_NM2A,PE_NM3A,PE_RSN FROM NG_POS_SIMAH_IND_PREV_ENQUIRY_GRID WHERE CIC_NO='"+cic_number+"' ";
		field_list="Date of Inquiry,Inquirer,Inquiry Type,Member Enquiry Reference,Product Type,Amount Inquired,Family Name (Ar),First Name (Ar),Second Name (Ar),Third Name (Ar),Reason Code";
		//field_list="PE_DATE,PE_INQR,PE_TYPE,PE_MEMB_REF,PE_PRD,PE_AMOUNT,PE_NMFA,PE_NM1A,PE_NM2A,PE_NM3A,PE_RSN";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}
		iformObj.addDataToGrid("SIMAH_IND_PREV_ENQ_GRID", arr);
		
		//NG_POS_SIMAH_IND_CI_DETAILS_GRID
		arr = new JSONArray();
		query="SELECT CI_CRDTR,CI_PRD,CI_ACC_NO,CI_LIMIT,CI_ISSU_DT,CI_PROD_EXP_DT,CI_STATUS,CI_CLSD_DT,CI_TNR,CI_FRQ,CI_INSTL,CI_SAL,CI_SEC,CI_CUB,CI_ODB,CI_LAST_AMT_PD,CI_LAST_PAY_DT,CI_AS_OF_DT,CI_NXT_DU_DT,CI_SUMMRY FROM NG_POS_SIMAH_IND_CI_DETAILS_GRID WHERE CIC_NO='"+cic_number+"' ";
		field_list="Creditor,Product Type,Account Number,Credit Limit,Issue Date,Expiry Date,Status,Closed Date,Tenure,Frequency,Instalment Amount,Salary Flag,Security Type,Outstanding Balance,Past Due Balance,Last Amount Paid,Last Payment Date,As of Date,Next Payment Due Date,Payment Summary";
		//field_list="CI_CRDTR,CI_PRD,CI_ACC_NO,CI_LIMIT,CI_ISSU_DT,CI_PROD_EXP_DT,CI_STATUS,CI_CLSD_DT,CI_TNR,CI_FRQ,CI_INSTL,CI_SAL,CI_SEC,CI_CUB,CI_ODB,CI_LAST_AMT_PD,CI_LAST_PAY_DT,CI_AS_OF_DT,CI_NXT_DU_DT,CI_SUMMRY";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}
		iformObj.addDataToGrid("SIMAH_IND_CI_DET_GRID", arr);
		
		//NG_POS_IND_SIMAH_ADDRESS_GRID
		arr = new JSONArray();
		query="SELECT CA_LOAD_DT,CA_CADT,CA_CAD1A,CA_CAD6,CA_CAD7,CA_CAD8A,CA_CAD9 FROM NG_POS_IND_SIMAH_ADDRESS_GRID WHERE CIC_NO='"+cic_number+"' ";
		field_list="Address Load Date,Address Type,Address 1 (Ar),PO Box Number,Postal Code,City (Ar),Country Code";
	//	field_list="CA_LOAD_DT,CA_CADT,CA_CAD1A,CA_CAD6,CA_CAD7,CA_CAD8A,CA_CAD9";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}
		iformObj.addDataToGrid("SIMAH_IND_ADDR_GRID", arr);
		
		//NG_POS_IND_SIMAH_CONTACTS_GRID
		arr = new JSONArray();
		query="SELECT CCN1,CCN2,CCN3,CCN4,CCN5 FROM NG_POS_IND_SIMAH_CONTACTS_GRID WHERE CIC_NO='"+cic_number+"' ";
		field_list="Contact Type,Country Code,Area Code,Phone Number,Extension";
		//field_list="CCN1,CCN2,CCN3,CCN4,CCN5";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}
		iformObj.addDataToGrid("SIMAH_IND_CONTACTS_GRID", arr);
		
		//NG_POS_IND_SIMAH_EMPLOYERS_GRID
		arr = new JSONArray();
		query="SELECT ETYP,ENMA,EADT,EAD1A,EAD2A,EAD6,EAD7,EAD8A,EAD9,EOCA,EDOE,ELEN,ECEX,EDLD,EMBS,ETMS FROM NG_POS_IND_SIMAH_EMPLOYERS_GRID WHERE CIC_NO='"+cic_number+"'  ";
		field_list="Employer type,Employer Name (Ar),Address Type,Address 1 (Ar),Address 2 (Ar),PO Box,Postal Code,City (Ar),Country Code,Occupation (Ar),Date of Employment,Length of Service,Contract Expiry Date,Date Loaded,Monthly Basic Salary,Total Monthly Salary";
		//field_list="ETYP,ENMA,EADT,EAD1A,EAD2A,EAD6,EAD7,EAD8A,EAD9,EOCA,EDOE,ELEN,ECEX,EDLD,EMBS,ETMS";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		logger.info("Query for SIMAH Individual employers gridd is  "+query+" and its result is "+result);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				logger.info("Setting values as "+field_list_array[i]+" in "+internal_list.get(i));
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}	
		iformObj.addDataToGrid("SIMAH_IND_EMPLOYERS_GRID", arr);
		
		
		//NG_POS_SIMAH_IND_NARRATIVES_GRID
		arr = new JSONArray();
		query="SELECT NA_LOAD_DT,NA_LOADED_BY,NA_TYPE,NA_TEXT,NA_TEXT_AR FROM NG_POS_SIMAH_IND_NARRATIVES_GRID WHERE CIC_NO='"+cic_number+"' ";
		field_list="Load Date,Loaded By,Type,Text,Text (Ar)";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}
		iformObj.addDataToGrid("SIMAH_IND_NARRATIVES_GRID", arr);
		
		
		//NG_POS_SIMAH_IND_DEFAULTS_GRID
		arr = new JSONArray();
		query="SELECT PRODUCT_TYPE,APPLICANT_TYPE,ACCOUNT_NUMBER,CREDITOR,LOAD_DATE,ORIGINAL_AMT_AT_LOAD_DATE,OUTSTANDING_BALANCE,DEFAULTS_STATUS FROM NG_POS_SIMAH_IND_DEFAULTS_GRID WHERE CIC_NO='"+cic_number+"' ";
		field_list="Product Type,Applicant Type,Account Number,Creditor,Load Date,Original Amount at Load Date,Outstanding Balance,Status,Settlement Date";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		logger.info("Queryt to fetch defaults details in simah individual is "+query+" and it's result is "+result);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}
		logger.info("JSON array to fetch from SIMAH_IND_DEFAULT_GRID is "+arr);
		iformObj.addDataToGrid("SIMAH_IND_DEFAULT_GRID", arr);
		
		//NG_POS_SIMAH_IND_PUBLIC_NOTICES_GRID
		arr = new JSONArray();
		query="SELECT PN_LOAD_DT,PN_TYPE,PN_PUBLICATION,PN_COMMENT,PN_PUBLICATION_AR,PN_COMMENT_AR FROM NG_POS_SIMAH_IND_PUBLIC_NOTICES_GRID WHERE CIC_NO='"+cic_number+"' ";
		field_list="Load Date,Type,Publication,Comment,Publication (Ar),Comment (Ar)";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}
		iformObj.addDataToGrid("SIMAH_IND_PUBLIC_NOTICES_GRID", arr);
				
		//NG_POS_SIMAH_IND_JUDGEMENTS
		arr = new JSONArray();
		query="SELECT EJ_ENFORCE_DATE,EJ_RES_NUMBER,EJ_EXEC_TYPE,EJ_CITY,EJ_COURT_CODE,EJ_CASE_NUMBER,EJ_DATE_LOADED,EJ_ORIG_CLAIM_AMT,EJ_CLAIM_AMT,EJ_STATUS,EJ_SETTLE_DATE FROM NG_POS_SIMAH_IND_JUDGEMENTS WHERE CIC_NO='"+cic_number+"' ";
		field_list="Enforce Date,Res Number,Execution Type,City,Court Code,Case Number,Date Loaded,Originial Claim Amount,Claim Amount,Status,Settle Date";
		field_list_array=field_list.split(",");
		result = iformObj.getDataFromDB(query);
		for (List<String> internal_list : result) 
		{
			JSONObject internal_object=null;
			internal_object=new JSONObject();
			for(int i=0;i<internal_list.size();i++)
			{
				internal_object.put(field_list_array[i],internal_list.get(i));
			}
			arr.add(internal_object);
		}
		iformObj.addDataToGrid("SIMAH_IND_JUDGEMENTS", arr);		
		
		return "success~subFormCalled";
	}

	private boolean checkSIMAHValidity(IFormReference iformObj,String cic_no_or_crno,String party_type)
	{
		logger.info("Inside handling of checkSIMAHValidity function");
		try
		{
			String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			LocalDateTime today_date=LocalDateTime.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
			String query="";
			if(party_type.equalsIgnoreCase("Individual"))
				query="SELECT ENTRY_DATE_TIME FROM NG_POS_SIMAH_IND_PROVIDED_SECTION WHERE CIC_NO='"+cic_no_or_crno+"'  ";
			else
				query="SELECT ENTRY_DATE_TIME FROM NG_POS_SIMAH_RP_BASIC_DETAILS WHERE CR_NO='"+cic_no_or_crno+"'  ";
			List<List<String>> entry_date=iformObj.getDataFromDB(query);
			if(entry_date.size()>0)
			{
				if(entry_date.get(0).size()>0)
				{
					String checked_date=entry_date.get(0).get(0);
					LocalDateTime checked_date_obj = LocalDateTime.parse(checked_date,DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
					LocalDateTime date_after_30_days=checked_date_obj.plusDays(30);
					
					if(today_date.compareTo(date_after_30_days)>0)
					{
						logger.info("In checkSIMAHValidity coming here because today's date is greater than 30 days, hence new SIMAH data need to be fetched");
						return true;
					}
					else
					{
						logger.info("In checkSIMAHValidity coming here because today's date is less than 30 days, hence old data need to be shown");
						return false;
					}
				}
				else
				{
					logger.info("In checkSIMAHValidity coming here because no record is present for this cic in database , hence new SIMAH data need to be fetched");
					return true;
				}
			}
			else
			{
				logger.info("In checkSIMAHValidity coming here because no record is present for this cic in database , hence new SIMAH data need to be fetched");
				return true;
			}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: checkSIMAHValidity and exception is "+e);
			logger.info("Just because of this exception we are returning true");
			return true;
		}
		
	}
	
	private String RelatedPartyfillSIMAHDataCommercial(IFormReference iformObj, String stringdata)
	{
		//stringdata_split[0] CIC_NUMBER
		//stringdata_split[1] ROW NUMBER
		//stringdata_split[2] CR_NUMBER
		//stringdata_split[3] UNN_NUMBER
		String[] stringdata_split=stringdata.split("#");
		logger.info("Inside handling of RelatedPartyfillSIMAHDataCommercial and unn no is"+stringdata_split[3]);
		boolean SIMAH_Required_or_not=checkSIMAHValidity(iformObj,stringdata_split[3],"Company");
		if(SIMAH_Required_or_not==false)
		{
			return "checkSIMAHValidity~Success~Record Already present";
		}
		
		int row_index=0;
		if(stringdata_split[1]!="")
			row_index=Integer.parseInt(stringdata_split[1]);
		String callname="SIMAH_Commercial_RP";
		//createRequestXML customized to handle cic/cr no
		try
		{
			logger.info("Inside createRequestXML Function and callName is " + callname);
			String tagName = "_TagName";
			
			String request_prefix=GetXML.getProp().getProperty(callname+"_RequestPrefix");
			if(request_prefix.equals(null))
			{
				request_prefix="";
			}
			logger.info("Request prefix is "+request_prefix+"please check");
			
			String header_tags=GetXML.getProp().getProperty(callname+"_Header");
			String []header_tags_arry=header_tags.split(",");
			
			logger.info("Header tags are "+header_tags);
			JSONObject jsonobj_header=new JSONObject();
			for(String temp:header_tags_arry)
			{
				String[] hash_split=temp.split("#");
				jsonobj_header.put(hash_split[0],hash_split[1]);
			}
			
			logger.info("JSOn object is "+jsonobj_header);
		
			String tagNames = GetXML.getProp().getProperty(callname + tagName);
			logger.info(tagNames);
			String[] tags = tagNames.split(",");
	
			String requestXML = readDummyRequest(callname);
	
			XMLParser parser = new XMLParser(requestXML);
			
	
			for (String tag : tags) 
			{
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
				if (tagValue.startsWith("formid~")) 
				{
					String value = (String) iformObj.getValue(tagValue.split("~")[1]);
					parser.changeValue(request_prefix+tag, value);
				}
				
			}
			
			String timestamp=new Timestamp(System.currentTimeMillis()).toString();
			logger.info("Setting Enquiy Reference for simah call "+timestamp);
			parser.changeValue(request_prefix+"com:ENQUIRY_REFERENCE", timestamp);
			logger.info("CreateRequestXML :Handling Language in Request ");
			logger.info("Language tag for "+callname+" present in proerty file or not ??? "+GetXML.getProp().containsKey(callname+"_LanguageTag"));
			if(GetXML.getProp().containsKey(callname+"_LanguageTag"))
			{
				logger.info("CreateRequestXML : Language tag is present in property file");
				String language_tag=GetXML.getProp().getProperty(callname+"_LanguageTag");
				logger.info("CreateRequestXML : Language tag value in property file is "+language_tag);
				String session_lang=(String) iformObj.getValue("SESSION_LANG");
				logger.info("CreateRequestXML : Session Language is "+session_lang);
				parser.changeValue(request_prefix+language_tag, session_lang);
				logger.info(request_prefix+language_tag+" got value "+session_lang);
			}
			
			logger.info("Request prefix is "+request_prefix+"please check");
			parser.changeValue(request_prefix+"alr:CICNum", stringdata_split[0]);
			parser.changeValue(request_prefix+"com:CIDN", stringdata_split[3]);
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML is :\n" + parser.toString());
			String responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callname,iformObj);
			
		String restricted_tags=GetXML.getProp().getProperty(callname+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			responseXML=responseXML.replace(temp,"");
		
		
		tagName = "_TagNameResponse";
		tagNames = GetXML.getProp().getProperty(callname + tagName);
		logger.info(tagNames);
		tags = tagNames.split(",");
 
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		
		String cic_number=stringdata_split[0];
		String cr_number=stringdata_split[3];
		
		logger.info("CIC Number is "+cic_number+" and CR Number(UNN Number) is "+cr_number+" and  rowindex is "+stringdata_split[1]+" ");
		
		parser = new XMLParser(responseXML);
		String values="( '"+cic_number+"','"+cr_number+"',";
		String query="";
		String columnames="CIC_NO,CR_NO,";
		String insertinto="INSERT INTO ";
		String tablename=GetXML.getProp().getProperty(callname+"_Table");
		
		String delete_query="DELETE FROM "+tablename+" where CR_NO= '"+cr_number+"' ";
		iformObj.saveDataInDB(delete_query);
		logger.info("With this query table is emptied :: "+delete_query);
		
		String statuscode=GetXML.getProp().getProperty(callname+"_StatusCode");
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
				    		result=result.replace("'","''");
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
						values=values+"'"+tagValue+"',";
					else
						values=values+"N'"+tagValue+"',";
				}
				
				columnames=columnames+key[1].replace("$","")+",";
			}
			
			columnames=columnames+"ENTRY_DATE_TIME";
			values=values+"'"+date+"')";

			query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
			logger.info("SIMAH Comm Related Party: Query for "+callname+" setting response in tables is"+query);
			iformObj.saveDataInDB(query);	

		}
		else
		{
			
			String error_code=parser.getValueOf("StatusCd");
			String error_description=parser.getValueOf("StatusDesc");
			logger.info("For "+callname+" Status code returned from response is not success "+error_code+"ddddd"+error_description);
			if(error_code.equalsIgnoreCase("E064016"))
			{
				String service=parser.getValueOf("SERVICE");
				String action=parser.getValueOf("ACTION");
				String member_id=parser.getValueOf("MEMBER_ID");
				String user_id=parser.getValueOf("USER_ID");
				String run_no=parser.getValueOf("RUN_NO");
				String err_items=parser.getValueOf("ERR_ITEMS");
				String enquiry_refernce=parser.getValueOf("ENQUIRY_REFERENCE");
				
				query="INSERT INTO NG_POS_SIMAH_RP_BASIC_DETAILS (SERVICE,ACTION,MEMBER_ID,USER_ID,RUN_NO,ERROR_ITEMS,REFERENCE_NO,IDCOD,CR_NO,ENTRY_DATE_TIME) VALUES ('"+service+"','"+action+"','"+member_id+"','"+user_id+"','"+run_no+"','"+err_items+"','"+enquiry_refernce+"','"+cr_number+"','"+cr_number+"','"+date+"') ";
				logger.info("SIMAH Comm Related Party: Query when record is already present is for unn_no"+cr_number+" is "+query);
				iformObj.saveDataInDB(query);
				return "NoRecordFound~"+error_description;
			}
			else
				return "Error~In SIMAH error received error code "+error_code+" and it's description is "+error_description;
		}
		
		
		//Hello
	    String[] callNamesGrid = { "SIMAH_Commercial_RP_AddressDetails","SIMAH_Commercial_RP_CONTACTS","SIMAH_Commercial_RP_PreviousEnquiry","SIMAH_Commercial_RP_As_Narrative","SIMAH_Commercial_RP_Bounced_Cheques","SIMAH_Commercial_RP_Defaults","SIMAH_Commercial_RP_Guaran_Key_Stakeholders","SIMAH_Commercial_RP_Judgement","SIMAH_Commercial_RP_Key_Stakeholder","SIMAH_Commercial_RP_L1_C1_Summary","SIMAH_Commercial_RP_L2_C1_Summary","SIMAH_Commercial_RP_Rating"}; //For cortex, bankdetails and loan details
		//String[] callNamesGrid = { "MSBAcctsDataInq_SearchScreen", "MSBFacilitiesDataInq_SearchScreen"}; //For cortex and bankdetails
		for (String callNames : callNamesGrid) 
			{
				
				//logger.info("Response XML received by setResponseDataGrid is"+responseXML);
				tagName = "_TagNameResponseGrid";
				tagNames = GetXML.getProp().getProperty(callNames + tagName);
				
				logger.info(tagNames);
				String[] tagValue = tagNames.split(",");
				
				date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
				
				
				values=" ";
				query="";
				//columnames="CIC_NO,CR_NO";
				insertinto="INSERT INTO ";
				tablename=GetXML.getProp().getProperty(callNames+"_Table_Grid");
				
				delete_query="DELETE FROM "+tablename+" where CR_NO = '"+cr_number+"' ";
				iformObj.saveDataInDB(delete_query);
				logger.info("With this query table is emptied :: "+delete_query);
				
				statuscode=GetXML.getProp().getProperty(callNames+"_StatusCode");
				status_code_split=statuscode.split("~");
				
				
				for(String tag: tagValue)
				{
					tags=tag.split("~");
					WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
					//logger.info("objWFxmlResponse value is "+objWFxmlResponse);
					
					columnames="CIC_NO,CR_NO,";
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
					logger.info("Tags[0] is "+tags[0]);
					logger.info("Tags[1] is "+tags[1]);
					WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
					logger.info("Wfmxmlsit is --------------"+WFXmlList);
					logger.info("Size of Wfmxmlsit is "+WFXmlList.hasMoreElements());
					for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
					{
					
						values=values+"( '"+cic_number+"', '"+cr_number+"',";
						
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
									result_from_response=" ";
								}
								
								if(hash_split_values[0].contains("$"))
									values=values+"'"+result_from_response+"',";
								else
									values=values+"N'"+result_from_response+"',";
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
					
					if (values.endsWith(",")) {
						values = values.substring(0, values.length() - 1);
					}
					
					logger.info("Final column variables are"+columnames);
					logger.info("values are"+values);
					
					query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
					logger.info("Query for setting response in search screen tables is"+query);
					iformObj.saveDataInDB(query);	
					
					}
					else
					{
						logger.info("For "+callname+" Status code returned from response is not success ");
						return "Error~In "+callname+" error received from beacked";
					}
					
				}
			}
		}catch(Exception e)
		{
			logger.info("Excpetion Occurred::RelatedPartyfillSIMAHDataCommercial and exception is "+e);
			return "Error~Error in RelatedPartyfillSIMAHDataCommercial";
		}
		
		return "Success~RelatedPartyfillSIMAHDataCommercial";
	}

	private String fillSIMAHDataIndividual(IFormReference iformObj, String stringdata) 
	{	
		logger.info("Inside handling of fillSIMAHDataIndividual");
		String[] stringdata_split=stringdata.split("#");
		boolean SIMAH_Required_or_not=checkSIMAHValidity(iformObj,stringdata_split[0],"Individual");
		if(SIMAH_Required_or_not==false)
		{
			return "checkSIMAHValidity~Success~Record Already present";
		}
		int row_index=0;
		if(stringdata_split[1]!="")
			row_index=Integer.parseInt(stringdata_split[1]);
		
		JSONArray jsonarr=iformObj.getDataFromGrid("NG_POS_ROLE_GRID");
		JSONObject jsonobj=(JSONObject) jsonarr.get(row_index);
		logger.info("Inside fillSIMAHDataIndividual, row number is "+row_index+" and jsonobject is "+jsonobj);
		String callName = "SIMAH_Individual"; //For SIMAH Individual
		String country_query="",country_code="";
		String jsonResponse="";
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
			
	
			for (String tag : tags) 
			{
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
					if(tagValue.split("~")[1].equalsIgnoreCase("AMOUNT"))
					{
						logger.info("Value of requested amount is "+iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR"));
						parser.changeValue(request_prefix+tag,(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR") );
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("CID2"))
					{
						parser.changeValue(request_prefix+tag,(String) jsonobj.get("ID Number") );
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("CGND"))
					{
						String gender=(String) jsonobj.get("Gender");
						if(gender.equalsIgnoreCase("Male"))
							parser.changeValue(request_prefix+tag,"M" );
						else 
							parser.changeValue(request_prefix+tag,"F" );
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("CMAR"))
					{
						String marital_status=(String) jsonobj.get("Marital Status");
						if(marital_status.equalsIgnoreCase("Married"))
							parser.changeValue(request_prefix+tag,"M" );
						else
							parser.changeValue(request_prefix+tag,"S" );
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("CNAT"))
					{
						String nationality=(String) jsonobj.get("Nationality Description");
						if(nationality.trim().equals("Saudi"))
						{
							parser.changeValue(request_prefix+"CID1","T");
							parser.changeValue(request_prefix+tag,"SAU");
						}
						else
						{	
							logger.info("As nationality is not saudi, we are fetching country code from master table");
							country_query="SELECT TOP 1 COUNTRY_CODE_3  FROM NG_MAST_COUNTRY_CODE_SIMAH WHERE COUNTRY_NAME LIKE '%"+nationality+"%'   ";
							List<List<String>> country_code_list=iformObj.getDataFromDB(country_query);
							logger.info("Query to fetch SIMAH country code is "+country_query+" and it's result is "+country_code_list);
							if(country_code_list.size()>0)
							{
								if(country_code_list.get(0).size()>0)
								{
									country_code=country_code_list.get(0).get(0);
								}
							}
							
							parser.changeValue(request_prefix+"CID1","Q");
							logger.info("Changing value of "+tag+" with "+country_code);
							parser.changeValue(request_prefix+tag,country_code);
							logger.info("done");
												
						}
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("CAD6"))
					{
						parser.changeValue(request_prefix+tag,(String) jsonobj.get("Postal Code") );
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("CAD7"))
					{
						String addition_no=(String) jsonobj.get("Additional Number");
						if(addition_no.trim().equals(""))
							addition_no="1234";
						parser.changeValue(request_prefix+tag,addition_no );
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("CAD9"))
					{
						logger.info("As nationality is not saudi, we are fetching country code from master table Second query");
						String nationality=(String) jsonobj.get("Nationality Description");
						if(nationality.trim().equals("Saudi"))
							parser.changeValue(request_prefix+tag,"SAU");
						else
						{
							country_query="SELECT TOP 1 COUNTRY_CODE_3  FROM NG_MAST_COUNTRY_CODE_SIMAH WHERE COUNTRY_NAME LIKE '%"+nationality+"%'   ";
							List<List<String>> country_code_list=iformObj.getDataFromDB(country_query);
							logger.info("Query to fetch SIMAH country code is "+country_query+" and it's result is "+country_code_list);
							if(country_code_list.size()>0)
							{
								if(country_code_list.get(0).size()>0)
								{
									country_code=country_code_list.get(0).get(0);
								}
							}
							logger.info("Changing value of "+tag+" with "+country_code);
							parser.changeValue(request_prefix+tag,country_code);
							logger.info("done");
						}
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("RUN_NO"))
					{
						String run_no="";
						String query="SELECT NEXT VALUE FOR SEQ_SIMAH_IND_RUN_NO AS RUN_NO";
						List<List<String>> result=iformObj.getDataFromDB(query);
						if(result.size()>0)
						{
							if(result.get(0).size()>0)
							{
								run_no=result.get(0).get(0);
							}
						}
						
						logger.info("Query is "+query+" and its result is "+result+" and run_no is "+run_no+" and its length is "+run_no.length()+"");
						int run_no_size=run_no.length();
						for(int i=0;i<8-run_no_size;i++)
							run_no="0"+run_no;
						logger.info("RUN_NO used in request is "+run_no);
						parser.changeValue(request_prefix+tag,run_no);
					}
					else if(tagValue.split("~")[1].equalsIgnoreCase("ENQUIRY_REFERENCE"))
					{
						String run_no="";
						String query="SELECT NEXT VALUE FOR SEQ_SIMAH_IND_ENQUIRY_REF AS ENQUIRY_REF";
						List<List<String>> result=iformObj.getDataFromDB(query);
						if(result.size()>0)
						{
							if(result.get(0).size()>0)
							{
								run_no=result.get(0).get(0);
							}
						}
						logger.info("Query is "+query+" and its result is "+result+" and run_no is "+run_no+" and its length is "+run_no.length()+"");
						int run_no_size=run_no.length();
						for(int i=0;i<10-run_no_size;i++)
							run_no="0"+run_no;
						logger.info("ENQUIRY_REFERENCE used in request is "+run_no);
						parser.changeValue(request_prefix+tag,run_no);
					}
				}
				else if(tagValue.contains("CID3D"))
				{
					String expiry_date=(String) jsonobj.get("ID Expiry Date");
					if(expiry_date.contains("/"))
					{
						logger.info("Expiry date case 1");
						parser.changeValue(request_prefix+"CID3D",expiry_date.split("/")[0] );
						parser.changeValue(request_prefix+"CID3M",expiry_date.split("/")[1] );
						parser.changeValue(request_prefix+"CID3Y",expiry_date.split("/")[2] );
					}
					else if(expiry_date.contains("-"))
					{
						parser.changeValue(request_prefix+"CID3D",expiry_date.split("-")[0] );
						parser.changeValue(request_prefix+"CID3M",expiry_date.split("-")[1] );
						parser.changeValue(request_prefix+"CID3Y",expiry_date.split("-")[2] );
					}
					else
					{
						parser.changeValue(request_prefix+"CID3D",expiry_date.substring(0,2));
						parser.changeValue(request_prefix+"CID3M,",expiry_date.substring(2,4));
						parser.changeValue(request_prefix+"CID3Y",expiry_date.substring(4,8));
					}
				}
				else if(tagValue.contains("CDBD"))
				{
					String expiry_date=(String) jsonobj.get("Birth Date");
					if(expiry_date.contains("/"))
					{
						parser.changeValue(request_prefix+"CDBD",expiry_date.split("/")[0] );
						parser.changeValue(request_prefix+"CDBM",expiry_date.split("/")[1] );
						parser.changeValue(request_prefix+"CDBY",expiry_date.split("/")[2] );
					}
					else if(expiry_date.contains("-"))
					{
						parser.changeValue(request_prefix+"CDBD",expiry_date.split("-")[0] );
						parser.changeValue(request_prefix+"CDBM",expiry_date.split("-")[1] );
						parser.changeValue(request_prefix+"CDBY",expiry_date.split("-")[2] );
					}
					else
					{
						parser.changeValue(request_prefix+"CDBD",expiry_date.substring(0,2));
						parser.changeValue(request_prefix+"CDBM",expiry_date.substring(2,4));
						parser.changeValue(request_prefix+"CDBY",expiry_date.substring(4,8));
					}
				}
			}
			
			
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML is :\n" + parser.toString());
			//String responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
		
			//org.json.JSONObject jb = XML.toJSONObject(parser.toString());
			//logger.info("~~~~~~~~~~Sending JSON Request m@au~~~~~>>>>>>" + jb);
			//String Url="http://10.11.201.33:7804/enquiry/inthttpset.pgm";
			//String Url="https://consumerdev.simah.com/enquiry/inthttp.pgm";
			
			jsonResponse = executePOSTRequestSIMAHIndividual(parser.toString(), callName);
			if(jsonResponse.equalsIgnoreCase("Error~Exception in Request,Please Check"))
			{
				logger.info("Error~Unable to connect to proxy, please check credentials");
				return "Error~Unable to connect to proxy, please check credentials";
			}
			logger.info("~~~~~~~~~~Getting JSON Response m@au~~~~~>>>>>>" + jsonResponse);
			
			String callNameLog = "Simah Individual";
			String Callreq = parser.toString();
		    String wi_name = getWorkitemName(iformObj);
		    String activityName = getActivityName(iformObj);
		    String usrNAme = getUserName(iformObj);
			String colNames = "CALL_NAME,REQUEST,REQUEST_SENT,RESPONSE,RESPONSE_RECEIVED,EXCEPTION_OCCURED,STATUS,WI_NAME,ACTIVITY_NAME,USERNAME";
			String colValues = "'"+callNameLog+"','"+Callreq+"','"+new Timestamp(System.currentTimeMillis()).toString()+"','"+jsonResponse.toString().replace("'", "''")+"','"+new Timestamp(System.currentTimeMillis()).toString()+"','','','"+wi_name+"','"+activityName+"','"+usrNAme+"'";
			String logQury = "INSERT INTO NG_ARB_API_LOGS (CALL_NAME, REQUEST, REQUEST_SENT, RESPONSE, RESPONSE_RECEIVED, EXCEPTION_OCCURED, STATUS, WI_NAME, ACTIVITY_NAME, USERNAME)VALUES ("+colValues+")";
			logger.info("\n\n ------------------------ Query for API Logs"+logQury+"\n--------------------------------------------");	
		    saveDataInDB(iformObj, logQury);
		    logger.info("~~~~~~~~~~API Logs Saved... m@au~~~~~>>>>>>"+jsonResponse);
	
		
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			logger.info("Exception occurred: Simah Individual: and exception is "+e);
			e.printStackTrace();
		}

		String responseXML = jsonResponse;	
		//setResponseDataSearchScreen(iformObj, callName, responseXML);
		
		//Hello
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			responseXML=responseXML.replace(temp,"");
		
		
		String tagName = "_TagNameResponse";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		logger.info(tagNames);
		String[] tags = tagNames.split(",");
 
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		
		String cic_number=stringdata_split[0];
		
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
				    	String result=responseXML;
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
						values=values+"'"+tagValue+"',";
					else
						values=values+"N'"+tagValue+"',";
				}
				
				columnames=columnames+key[1].replace("$","")+",";
			}
			
			columnames=columnames+"ENTRY_DATE_TIME";
			values=values+"'"+date+"')";

			query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
			logger.info("Query for "+callName+" setting response in search screen tables is"+query);
			iformObj.saveDataInDB(query);	

		}
		else
		{		
			responseXML=responseXML.replace(" seq=\"1\"", "");
			WFXmlResponse simah_objWFxmlResponse = new WFXmlResponse(responseXML);
			List<String> Error_description=new ArrayList<String>();
			WFXmlList WFXmlList = simah_objWFxmlResponse.createList("ITEM","ERROR");
			System.out.println(WFXmlList.hasMoreElements());
			for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
			{
				Error_description.add(WFXmlList.getVal("RSP_MSG"));
			}
			String return_string="";
			for(int i=0;i<Error_description.size();i++)
			{
				return_string+=(i+1)+"- "+Error_description.get(i)+" ";
			}
			return "Error~In SIMAH Individual Error Received : "+return_string;
		}
		
		
		//Hello
	    String[] callNamesGrid = { "SIMAH_Individual_PreviousEnquiry", "SIMAH_Individual_CI_DETAILS","SIMAH_Individual_ADDRESS","SIMAH_Individual_CONTACTS","SIMAH_Individual_EMPLOYERS","SIMAH_Individual_Narrative","SIMAH_Individual_Public_Notices","SIMAH_Individual_Judgement","SIMAH_Individual_DEFAULT"}; //For SIMAH Individual Grid Details
		//String[] callNamesGrid = { "MSBAcctsDataInq_SearchScreen", "MSBFacilitiesDataInq_SearchScreen"}; //For cortex and bankdetails
		for (String callNames : callNamesGrid) 
			{
				
				logger.info("Response XML received by setResponseDataGrid is"+responseXML);
				tagName = "_TagNameResponseGrid";
				tagNames = GetXML.getProp().getProperty(callNames + tagName);
				
				logger.info(tagNames);
				String[] tagValue = tagNames.split(",");
				
				date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
				
				
				values=" ";
				query="";
				columnames="CIC_NO,";
				insertinto="INSERT INTO ";
				tablename=GetXML.getProp().getProperty(callNames+"_Table_Grid");
				
				delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
				iformObj.saveDataInDB(delete_query);
				logger.info("With this query table is emptied :: "+delete_query);
				
				statuscode=GetXML.getProp().getProperty(callNames+"_StatusCode");
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
									result_from_response=" ";
								}
								
								if(hash_split_values[0].contains("$"))
									values=values+"'"+result_from_response+"',";
								else
									values=values+"N'"+result_from_response+"',";
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
					
					if (values.endsWith(",")) {
						values = values.substring(0, values.length() - 1);
					}
					
					logger.info("Final column variables are"+columnames);
					logger.info("values are"+values);
					
					query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
					logger.info("Query for setting response in search screen tables is"+query);
					iformObj.saveDataInDB(query);	
					
					}
					else
					{
					    //String error_description="Error in fetching SIMAH, please check if data is correct";
						//logger.info("For "+callName+" Status code returned from response is not success ");
						return "Error~In "+callName+" Error received from backend";
					}
					
				}
			}

		return "Success~fillSIMAHDataIndividual";
	}



	private String calculateFixedFeeAmount(IFormReference iformObj, String stringdata) 
	{
		logger.info("Inside calculateFixedFeeAmount function");
		String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
		String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
		String cutomer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
		String fixedamount = "0";
		
		try
		{
			String query="SELECT Fixed FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+cutomer_category+"') AND a.request_type='"+request_type+"'";
			logger.info("To calculateFixedFeeAmount query is "+query);
			List<List<String>> result = iformObj.getDataFromDB(query);
			if(result.size()>0)
			{
				fixedamount = (String) result.get(0).get(0);
			}
		}
		catch(Exception e) 
		{
			logger.info("Exception occurred: calculateFixedFeeAmount "+e);
		}
		logger.info("Fixed amount String ============> "+fixedamount);
		
		return fixedamount;
	}



	private String BuyAndContractOnLoad(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside BuyAndContractOnLoad function ");
		try
		{
			String query="SELECT PARAM_VALUE FROM NG_POS_PARAM_CONFIG WHERE PARAM_KEY in ('COMM_MEASUREMENT','PURCHASE_CHARGES') AND ISACTIVE='Y' ";
			List<List<String>> buy_and_contract_onload_values = iformObj.getDataFromDB(query);
			logger.info("BuyAndContractOnLoad Query and result are "+query+" and "+buy_and_contract_onload_values);
			if(buy_and_contract_onload_values.size()==2)
				{
					iformObj.setValue("Q_NG_DIS_COMMODITY_PURCHASE_MEASUREMENT",buy_and_contract_onload_values.get(0).get(0));
					iformObj.setValue("Q_NG_DIS_COMMODITY_PURCHASE_PURCHASE_CHRGS",buy_and_contract_onload_values.get(1).get(0));
					logger.info("Setting values "+buy_and_contract_onload_values.get(0)+" and "+buy_and_contract_onload_values.get(1));
				}
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: BuyAndContractOnLoad "+e);
		}
		
		return "BuyAndContractOnLoad Executed Successfully";
	}



	private String LoanDisbursement(IFormReference iformObj, String stringdata) {
		String callName="MSBCommodityMng_LoanDisbursement";
		String responseXML = createRequestXML(iformObj, callName);
		JSONObject jobj2 = setResponseData_2(iformObj, callName, responseXML);
		logger.info("Inside LoanDisbursement call "+jobj2);
		String return_string="Success~LoanDisbursement executed";

		for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			if(key.equalsIgnoreCase("Error"))
			{
				return_string="Error~"+jobj2.get(key).toString();
			}
			else
			{
				logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
				setControlValue(iformObj, key, jobj2.get(key).toString());
			}
		}
		
		return return_string;
	}



	private String TMSblockUnblockGrid(IFormReference iformObj, String stringdata) {

		logger.info("\n\n\n==== Get Call TMS  ============================================");
		org.json.simple.JSONArray arr = new org.json.simple.JSONArray();
		String wi_name = getWorkitemName(iformObj);
		String query = "SELECT MERCHANT_NAME FROM NG_POS_STMTDATA_CORTEX_DETAIL WHERE WI_NAME='" + wi_name + "'";
		try {
			List<List<String>> marchant_id = getDataFromDB(iformObj, query);
			logger.info("\n\n ========================\n result of query " + marchant_id.size());
			for (List<String> value : marchant_id) {
				String result = value.get(0);
				logger.info("\nmarchant Id's form query are" + result);
				// execute api
				org.json.JSONObject jsonGETResponse = executeGETurl(result);
				logger.info("\nresponse of marchantID is ====> " + jsonGETResponse.toString(4));
				String status = jsonGETResponse.getString("success");
				String merchantID = jsonGETResponse.getJSONObject("data").getString("merchantID");
				logger.info("\n value form response is " + status + " and id..is " + merchantID);
				org.json.JSONObject json = new org.json.JSONObject();
				json.put("TMS Status", status);
				json.put("Merchant ID", merchantID);
				arr.add(json);
				logger.info("Inside TMSblockUnblockGrid array is " + arr);
			}
			iformObj.addDataToGrid("TMS_GRID", arr);
		} catch (Exception e) {
			logger.info("Exception occurred: TMS GRID " + e);
		}
		return "Data set to be TMS Grid Successfully";
	}
	
	private String ExecuteAutoSell(IFormReference iformObj, String stringdata) {
		logger.info("Inside ExecuteAutoSell call first call");
		String callName = "DDCAP_Cancel"; //For DealKey details
		String responseXML = createRequestXML(iformObj, callName);
		JSONObject jobj = setResponseData(iformObj, callName, responseXML);
		for (Iterator iterator = jobj.keySet().iterator(); iterator.hasNext();) 
		{
			String key = (String) iterator.next();
			logger.info("Values set for" + key + " are " + jobj.get(key).toString());
			setControlValue(iformObj, key, jobj.get(key).toString());
		}
		
		callName = "MSBCommodityMng_AutoSell"; //For DealKey details
		responseXML = createRequestXML(iformObj, callName);
		JSONObject jobj2 = setResponseData_2(iformObj, callName, responseXML);
		logger.info("Inside ExecuteAutoSell call second call"+jobj2);
		String return_string="Success~ExecuteAutoSell executed";

		for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			if(key.equalsIgnoreCase("Error"))
			{
				return_string="Error~"+jobj2.get(key).toString();
			}
			else
			{
				logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
				setControlValue(iformObj, key, jobj2.get(key).toString());
			}
		}
		
		return return_string;
	}
	
	private String ConfirmSell(IFormReference iformObj, String stringdata) {
		logger.info("Inside handling of ConfirmSale call ");
		String return_string="Success~ConfirmSell executed";
		try
		{		
		String callName="",responseXML="";
		
		callName = "confirmsale"; 
		responseXML = createRequestXML(iformObj, callName);
		JSONObject jobj = setResponseData_2(iformObj, callName, responseXML);
			
			for(Iterator iterator = jobj.keySet().iterator(); iterator.hasNext();)
			{
				String key = (String) iterator.next();
				if(key.equalsIgnoreCase("Error"))
				{
					return_string="Error~"+jobj.get(key).toString();
					return return_string;
				}
				else
				{
					logger.info("Values set for"+key+" are "+jobj.get(key).toString());
					setControlValue(iformObj, key, jobj.get(key).toString());
				}
			}
		
		logger.info("Inside T24 ConfirmSale call");
		callName = "MSBCommodityMng_sale"; 
		responseXML = createRequestXML(iformObj, callName);
		JSONObject jobj2 = setResponseData_2(iformObj, callName, responseXML);
		logger.info("For T24 ConfirmSell call object is :"+jobj2);
			
			for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
			{
				String key = (String) iterator.next();
				if(key.equalsIgnoreCase("Error"))
				{
					return_string="Error~"+jobj2.get(key).toString();
					return return_string;
				}
				else
				{
					logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
					setControlValue(iformObj, key, jobj2.get(key).toString());
				}
			}
		
		
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred:: ConfirmSell and Exception is "+e);
		}
		return return_string;
	}

	
	
	private String CommoditySell(IFormReference iformObj, String stringdata)
	{
		logger.info("Inside handling of CommoditySell");
		String return_string="Success~CommoditySell executed";
		try
		{
			String sell_status=(String) iformObj.getValue("Q_NG_DIS_STIPULATE_AND_SELL_SELL_STATUS");
			if(sell_status.length()==0)
			{
				String callName = "sale"; // For DDPPurchase details
				String responseXML = DDPRequestXML(iformObj, callName);
		
				logger.info("GOT response msg in CommoditySell " + responseXML);
		
				/*
				JSONObject jobj = setResponseData(iformObj, callName, responseXML);
				for (Iterator iterator = jobj.keySet().iterator(); iterator.hasNext();) {
					String key = (String) iterator.next();
					logger.info("Values set for" + key + " are " + jobj.get(key).toString());
					setControlValue(iformObj, key, jobj.get(key).toString());
				}
				*/
				JSONObject jobj2= setResponseData_2(iformObj, callName, responseXML);
				logger.info("For Broker CommoditySell call object is :"+jobj2);
				
				for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
				{
					String key = (String) iterator.next();
					if(key.equalsIgnoreCase("Error"))
					{
						return_string="Error~"+jobj2.get(key).toString();
						return return_string;
					}
					else
					{
						logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
						setControlValue(iformObj, key, jobj2.get(key).toString());
					}
				}
				
				logger.info("CommoditySell: for '"+getWorkitemName(iformObj)+"' : success received in DDCAP sell ");
			}
			
			String t24_sell_status=(String) iformObj.getValue("SELL_COMM_CONFIRM_STATUS");
			if(t24_sell_status.length()==0)
			{
				String purchase_result=ConfirmSell( iformObj,  stringdata);
				logger.info("t24_sell_status result is "+purchase_result);
				if(purchase_result.split("~")[0].equalsIgnoreCase("Error"))
				{
					logger.info("Finally returning this "+purchase_result);
					return purchase_result;
				}
			}
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred:: CommoditySell and Exception is "+e);
		}
		return return_string;
	}
	
private String ConfirmPurchase(IFormReference iformObj, String stringdata) 
{
	logger.info("Inside ConfirmSale call ==>");
	
	String confirm_status=getControlValue(iformObj, "BUY_COMM_CONFIRM_STATUS");
	String commodity_purchase_transaction_ref=getControlValue(iformObj, "Q_NG_DIS_COMMODITY_PURCHASE_TRANSACT_REFERENCE");
	String return_string="";
	
	if(confirm_status.length()==0)
	{
		String callName = "confirmpurchase"; //For DealKey details
		String responseXML = createRequestXML(iformObj, callName);
		JSONObject jobj_2 = setResponseData_2(iformObj, callName, responseXML);
		logger.info("For Broker CommoditySell call object is :"+jobj_2);
		
		return_string="Success~CommodityPurchase executed";
		
		for(Iterator iterator = jobj_2.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			if(key.equalsIgnoreCase("Error"))
			{
				return_string="Error~"+jobj_2.get(key).toString();
				return 	return_string;
			}
			else
			{
				logger.info("Values set for"+key+" are "+jobj_2.get(key).toString());
				setControlValue(iformObj, key, jobj_2.get(key).toString());
			}
		}
	}
	
	confirm_status=getControlValue(iformObj, "BUY_COMM_CONFIRM_STATUS"); //Don't remove its required.
	logger.info("Confirm status calculated again is "+confirm_status);
	
	if(confirm_status.length()>0 && commodity_purchase_transaction_ref.length()==0)
	{
		String callName = "MSBCommodityMng"; // For T24 Reference details
		String responseXML = createRequestXML(iformObj, callName);
		
	
		JSONObject jobj2 = setResponseData_2(iformObj, callName, responseXML);
		logger.info("For T24 CommodityPurchase call object is :"+jobj2);
		
	
		for(Iterator iterator = jobj2.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			if(key.equalsIgnoreCase("Error"))
			{
				return_string="Error~"+jobj2.get(key).toString();
				return return_string;
			}
			else
			{
				logger.info("Values set for"+key+" are "+jobj2.get(key).toString());
				setControlValue(iformObj, key, jobj2.get(key).toString());
			}
		}
	}
		// post hit here....... mohit's code 05/12/2021
		/*
		logger.info("\n\nhit json API now ++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		String callName="TMSBlock/Unblock";
		String Url=GetXML.getProp().getProperty(callName+"_Endpoint_URL");
		//String Url = "http://10.98.118.47:4001/tmsrpa";
		//TMSBlock/Unblock_Endpoint_URL=http://10.98.118.47:4001/tmsrpa
		logger.info("For TMS blocking url is "+Url);
		//String merchantIDs = "";
		String contractExpiryDate = "";
		String govtLicenseNumber = "";
	
		String cic_no = getControlValue(iformObj, "Q_NG_POS_COMPANY_DATA_CIC");
		String qury = "SELECT CR_NO FROM NG_POS_CIC_DETAILS_GRID WHERE CIC_NO = '" + cic_no + "'";
		try 
		{
			logger.info("Query to replace key with value is" + qury);
			List<List<String>> code_values = iformObj.getDataFromDB(qury);
			if (code_values.size() > 0) 
			{
				govtLicenseNumber = code_values.get(0).get(0);
			}
		} catch (Exception e) 
		{
			logger.info(
					"Exception occurred: during MkQQQQ Query	d: Database Query " + qury + " and stack trace is\n\n" + e);
		}
	

	
		String contractdt = (String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CONTRACT_DATE");
		int tanure = Integer.parseInt((String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE"));
		logger.info("contractdt =: " + contractdt + "tanure =: " + tanure);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		ZoneId defaultZoneId = ZoneId.systemDefault();
		if (!(contractdt.contains("-")))
		{
			contractdt = contractdt.replace("/", "-");
		} else 
		{
			logger.info("Not Contains -: ");
		}
		LocalDate dater = LocalDate.parse(contractdt);
		logger.info("\n\nDate : " + contractdt);
		LocalDate newDate = dater.plusMonths(tanure);
		logger.info("\n\nNew Date : " + newDate);
		Date date = Date.from(newDate.atStartOfDay(defaultZoneId).toInstant());
		logger.info("\n\nNew Date ===: " + sdf.format(date));
		String serDate = sdf.format(date);
		
		String wi_name=getWorkitemName(iformObj);
		
		String qury2 = "SELECT MERCHANT_NUMBER FROM NG_POS_MERCHANT_DETAILS_GRID WHERE WI_NAME='"+wi_name+"' ";	
		try 
		{
			List<List<String>> marchantID = iformObj.getDataFromDB(qury2);
			logger.info("Query to fetch merchant number is" + qury2+" and its result is "+marchantID);
			if (marchantID.size() > 0)
			{
				for(String merchantIDs:marchantID.get(0))
				{
					org.json.JSONObject jb = new org.json.JSONObject();
					jb.put("merchantID", merchantIDs);
					jb.put("contractExpiryDate", serDate);
					jb.put("govtLicenseNumber", govtLicenseNumber);
					org.json.JSONObject jsonResponse = executePOSTRequest(jb, Url);
					logger.info("~~~~~~~~~~Getting JSON Response m@au~~~~~>>>>>>" + jsonResponse);
					
					String callNameLog = "TMSBlock/Unblock";
					String Callreq = jb.toString();
				    String activityName = getActivityName(iformObj);
				    String usrNAme = getUserName(iformObj);
					String colNames = "CALL_NAME,REQUEST,REQUEST_SENT,RESPONSE,RESPONSE_RECEIVED,EXCEPTION_OCCURED,STATUS,WI_NAME,ACTIVITY_NAME,USERNAME";
					logger.info("All Ok till now");
					String colValues = "'"+callNameLog+"','"+Callreq+"','"+getCurrentTimeStamp()+"','"+jsonResponse.toString()+"','"+getCurrentTimeStamp()+"','','','"+wi_name+"','"+activityName+"','"+usrNAme+"'";
					String logQury = "INSERT INTO NG_ARB_API_LOGS (CALL_NAME, REQUEST, REQUEST_SENT, RESPONSE, RESPONSE_RECEIVED, EXCEPTION_OCCURED, STATUS, WI_NAME, ACTIVITY_NAME, USERNAME)VALUES ("+colValues+")";
					logger.info("\n\n ------------------------ Query for API Logs"+logQury+"\n--------------------------------------------");	
				    saveDataInDB(iformObj, logQury);
				    logger.info("~~~~~~~~~~API Logs Saved... m@au~~~~~>>>>>>"+jsonResponse);
				}
			}
		} 
		
		catch (JSONException e) 
		{
			// TODO Auto-generated catch block
			logger.info("Exception occurred: ConfirmPurchase: TMS Blocking and exception is "+e);
			e.printStackTrace();
		}
		*/
	//}
	
	return return_string;
}

public String getCurrentTimeStamp()
/*      */   {
/*      */     try {
/*  337 */       return new Timestamp(System.currentTimeMillis()).toString();
/*      */     } catch (Exception e) {
/*  339 */     System.out.println(e);
/*  340 */     }return "";
/*      */   }

private String cancel(IFormReference iformObj, String stringdata) 
{
	
	return "";
}
private String CallCommodityPurchase(IFormReference iformObj, String stringdata) 
{
	logger.info("Inside handling of CallCommodityPurchase");
	String return_string="Success~Broker Purchase Executed Successfully";
    try
    {
    	String deal_key=(String) iformObj.getValue("Q_NG_DIS_COMMODITY_PURCHASE_DEAL_KEY");
    	String purchase_qty=(String) iformObj.getValue("Q_NG_DIS_COMMODITY_PURCHASE_QTY");
    	String purchase_amt=(String) iformObj.getValue("Q_NG_DIS_COMMODITY_PURCHASE_AMOUNT_SAR");
    	
    	if(deal_key.length()==0 && purchase_qty.length()==0 && purchase_amt.length()==0)
	    {
    		 logger.info("For workitem "+getWorkitemName(iformObj)+" : we are not executing DDCAP Purchase");
    		 String wi_name=getWorkitemName(iformObj);
    		 /*
    			String query="select top 1 case when dateadd(month,-1,convert(date,a.INSTALMENT_DATE,104))<> cast(b.CONTRACT_DATE as date) then 'true' else 'false' end as first_inst_date from NG_POS_DISBURSAL_DATA_INSTALMENT_DETAILS_GRID a,NG_POS_DISBURSAL_DATA b where a.wi_name='"+wi_name+"' and a.WI_NAME=b.WI_NAME ORDER BY cast(a.INSTALMENT_NO as numeric) ";
    			List<List<String>> result = iformObj.getDataFromDB(query);
    		    logger.info("Query to check if installment recalculation is required or not is "+query+" and it's result is "+result);
    			if(result.size()>0)
    			{
    				if(result.get(0).size()>0)
    				{
    					if(result.get(0).get(0).equalsIgnoreCase("true"))
    					{
    						return_string="Error~Error~Please Recalculate Installment First";
    						return return_string;
    					}
    				}
    			}
    		    */	
    			String callName = "purchase"; // For DDPPurchase details
    			String responseXML = DDPRequestXML(iformObj, callName);
    			logger.info("GOT response msg --------" + responseXML);
    			JSONObject jobj_2 = setResponseData_2(iformObj, callName, responseXML);
    			logger.info("For DDCAP Commodity Purchase object is :"+jobj_2);
    			

    			for(Iterator iterator = jobj_2.keySet().iterator(); iterator.hasNext();)
    			{
    				String key = (String) iterator.next();
    				if(key.equalsIgnoreCase("Error"))
    				{
    					return_string="Error~"+jobj_2.get(key).toString();
    					return return_string;
    				}
    				else
    				{
    					logger.info("Values set for"+key+" are "+jobj_2.get(key).toString());
    					setControlValue(iformObj, key, jobj_2.get(key).toString());
    					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");//("yyyy-MM-dd");  
    					LocalDateTime now = LocalDateTime.now();  
    					iformObj.setValue("Q_NG_DIS_COMMODITY_PURCHASE_PURCHASE_DATE_TIME", dtf.format(now));
    				}
    			}		

	    }
    	logger.info("CallCommodityPurchase: for '"+getWorkitemName(iformObj)+"' : success received in DDCAP Purchase ");
		String t24_purchase_transaction_ref=(String) iformObj.getValue("Q_NG_DIS_COMMODITY_PURCHASE_TRANSACT_REFERENCE");
		if(t24_purchase_transaction_ref.length()==0)
		{
			String purchase_result=ConfirmPurchase( iformObj,  stringdata);
			logger.info("purchase_result result is "+purchase_result);
			if(purchase_result.split("~")[0].equalsIgnoreCase("Error"))
			{
				logger.info("Finally returning this "+purchase_result);
				return purchase_result;
			}
		}

	return return_string;
    }
    catch(Exception e)
    {
    	logger.info("Exception Occurred: CallCommodityPurchase and exception is "+e);
    }
    return "Error~CallCommodityPurchase";
	
}

	
	private String return_max_min_amount(IFormReference iformObj, String stringdata) {
		logger.info("+++++++++++++ we are inside max and min function ++++++++++++++");
		String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
		String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
		String cutomer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
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
	
	private String return_max_min_FEE_amount(IFormReference iformObj, String stringdata) {
		logger.info("+++++++++++++ we are inside max and min function ++++++++++++++");
		String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
		String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
		String cutomer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
		String maxamt = "";
		String minamt = "";
		try {
			String query = "SELECT  max(Max_Fees_Amount), min(Min_Fees_Amount) FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+cutomer_category+"') AND a.request_type='"+request_type+"' ";
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
	
	private String return_max_min_Broker_FEE_amount(IFormReference iformObj, String stringdata) {
		logger.info("+++++++++++++ we are inside max and min function broker fees is  ++++++++++++++");
		String maxamt = "";
		String minamt = "";
		
		String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
		String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
		String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
		String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
		String tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
		String requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
		
		if(requested_amt==null || requested_amt=="")
		{
			requested_amt="0";
		}
				
		try 
		{
			String query = "SELECT BROKER_FEE FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_tenure>='"+tenure+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+"";
			List<List<String>> result = iformObj.getDataFromDB(query);
			logger.info("To select min and max value of broker fees query is "+query+"and it's result is "+result);
			if(result.size()>0)
			{
				maxamt = (String) result.get(0).get(0);
				minamt = "0";
			}
		}
		catch(Exception e) {
			logger.info("Exception occurred: return_max_min_Broker_FEE_amount "+e);
		}
		String minMaxData = maxamt+"@"+minamt;
		logger.info("min max data String ============> "+minMaxData);

		return minMaxData;
	}
	
	private String calculateLosAppNum(IFormReference iformObj, String stringdata) 
	{
		String wi_name=getWorkitemName(iformObj);
		try 
		{
		/*
		String query="SELECT NEXT VALUE FOR SEQ_LOS_APPLICATION_NUMBER AS LOSAPPLICATIONNUMBER";
		List<List<String>> los_app_num_list = iformObj.getDataFromDB(query);
		String los_app_num="";
		if(los_app_num_list.size()>0)
		{
			los_app_num=los_app_num_list.get(0).get(0);
		}
		int no_of_zeroes=10-los_app_num.length();
	    for(int i=0;i<no_of_zeroes;i++)
		{
	    	los_app_num='0'+los_app_num;
	    }
	    */
		
		long wi_name_long=Long.parseLong(wi_name.substring(4, 18));
		String los_app_num=Long.toString(wi_name_long);
		int no_of_zeroes=10-los_app_num.length();
	    for(int i=0;i<no_of_zeroes;i++)
		{
	    	los_app_num='0'+los_app_num;
	    }
	    los_app_num="POS"+los_app_num;
	    
		setControlValue(iformObj,"LOS_APP_NUM",los_app_num);
		//dbquery="UPDATE NG_POS_EXTTABLE SET LOS_APP_NUM='"+los_app_num+"' WHERE WI_NAME='"+processInstanceID+"'";
		//logger.info("Query to update disbursal bank name from search screen is "+dbquery);
		//saveDataInDB(iformObj, dbquery);
		logger.info("Setting los application number"+wi_name+" as "+los_app_num);
		return los_app_num;
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred:: For wi_name "+wi_name+" in setting los application number");
			return "0";
		}
	}
	private String fillNoOfExceptionAndAlerts(IFormReference iformObj, String stringdata) {
		try
		{
			String wi_name=getWorkitemName(iformObj);
			String query="SELECT COUNT(PQ_CATEGORY) FROM NG_POS_PQLIST_STATUS_GRID WHERE PQ_CATEGORY='Alert' AND WI_NAME='"+wi_name+"' AND PQ_STATUS='Fail'  ";
			List<List<String>> alert_exception_count = iformObj.getDataFromDB(query);
			String no_of_exceptions="0",no_of_alerts="0";
			if(alert_exception_count.size()>0)
			{
				no_of_alerts=alert_exception_count.get(0).get(0);
			}
			setControlValue(iformObj,"Q_NG_POS_DECISION_TOTAL_ALERTS", no_of_alerts);
			
			query="SELECT COUNT(PQ_CATEGORY) FROM NG_POS_PQLIST_STATUS_GRID WHERE PQ_CATEGORY='Exception' AND WI_NAME='"+wi_name+"' AND PQ_STATUS='Fail'  ";
			alert_exception_count = iformObj.getDataFromDB(query);
			if(alert_exception_count.size()>0)
			{
				no_of_exceptions=alert_exception_count.get(0).get(0);
			}
			setControlValue(iformObj,"NO_OF_EXCEPTION", no_of_exceptions);
			
			logger.info("Inside ");
			
		}
		catch (Exception e)
		{
			logger.info("Exception occurred: fillNoOfExceptionAndAlerts ");
		}
		return "fillNoOfExceptionAndAlerts executed successfully";
	}

	private String CallShortCICMng(IFormReference iformObj, String stringdata) {
		// TODO Auto-generated method stub
		logger.info("coming call name  " +stringdata);
		if(stringdata.equalsIgnoreCase("Company")) //Company
		{
			String callName = "ShortCICMng_Corporate";
			logger.info("inside company det" +callName +"stringdata" +stringdata);
			String responseXML = createRequestXML_2(iformObj, callName);
			logger.info("response xml" +responseXML );
			
			JSONObject jobj = setResponseData(iformObj, callName, responseXML);
			logger.info("For corporate short cic object is "+jobj);
			for(Iterator iterator = jobj.keySet().iterator(); iterator.hasNext();)
				{
					String key = (String) iterator.next();
					logger.info("Values set for"+key+" are "+jobj.get(key).toString());
					setControlValue(iformObj, key, jobj.get(key).toString());
				}
						
		}
		else if(stringdata.equalsIgnoreCase("Individual")) //Individual
		{
			String callName = "ShortCICMng_Person";
			String responseXML = createRequestXML_2(iformObj, callName);
			JSONObject jobj = setResponseData(iformObj, callName, responseXML);
			logger.info("inside indivi details");
			logger.info("For individual short cic object is "+jobj);
			for(Iterator iterator = jobj.keySet().iterator(); iterator.hasNext();)
				{
					String key = (String) iterator.next();
					logger.info("Values set for"+key+" are "+jobj.get(key).toString());
					setControlValue(iformObj, key, jobj.get(key).toString());
				}
			logger.info("For individual short cic object is "+jobj);
		}
		return "calling short CIC";
	}


	
	private String return_max_min_rate(IFormReference iformObj, String stringdata) {
		String minMaxData=null;
		try {
		logger.info("+++++++++++++ we are inside max and min function ++++++++++++++");
		// max percantage
		String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
		String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
		String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
		String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
		String tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
		String requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
		
		if(requested_amt==null || requested_amt=="")
		{
			requested_amt="0";
		}
		
		String query="SELECT Max_Rate,Min_Rate FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_tenure>='"+tenure+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+" ";
		
		logger.info("+++++++++++++ we are inside max and min function ++++++++++++++");
		String maxamt = "0";
		String minamt = "0";
		
		try {
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
		minMaxData = maxamt+"@"+minamt;
		logger.info("min max data String ============> "+minMaxData);
		}catch(Exception e) {
			logger.info("Exception occurred: retrurnMax_and_Min "+e);
		}
		return minMaxData;
	}
	
	private String return_max_min_FEE_rate(IFormReference iformObj, String stringdata) {
		logger.info("+++++++++++++ we are inside return_max_min_FEE_rate function ++++++++++++++");
		// max percantage
		String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
		String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
		String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
		String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
		String tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
		String requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
		
		if(requested_amt==null || requested_amt=="")
		{
			requested_amt="0";
		}
		
		String query="SELECT FEE_Max_Rate,Fee_Min_Rate  FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_tenure>='"+tenure+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+" ";
		
		logger.info("+++++++++++++ we are inside max and min function ++++++++++++++");
		String maxamt = "0";
		String minamt = "0";
		
		try {
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
	
	/*Sahdev kansal
	private String return_max_min_rate(IFormReference iformObj, String stringdata) {
		logger.info("+++++++++++++ we are inside max and min function ++++++++++++++");
		// max percantage
		String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
		String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
		String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
		String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
		String tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
		String requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
		
		if(requested_amt==null || requested_amt=="")
		{
			requested_amt="0";
		}
		
		String query="SELECT Max_Rate,Min_Rate FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_tenure>='"+tenure+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+" ";
		
		logger.info("+++++++++++++ we are inside max and min function ++++++++++++++");
		String maxamt = "0";
		String minamt = "0";
		
		try {
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
	*/
	private String fetchBankAccount(IFormReference iformObj, String stringdata) {
		try
		{
		iformObj.clearTable("BANK_ACCNT_DET_GRID");
		String workitem=getWorkitemName(iformObj);
		//String query="SELECT DISTINCT(ACC_NO),BANK_NAME,ACC_STATUS FROM NG_POS_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='"+workitem+"' ";
		String query="SELECT WI_NAME FROM NG_POS_CLOSING_BALANCE_GRID WHERE WI_NAME = '"+workitem+"' ";
        List<List<String>> result = iformObj.getDataFromDB(query);
        List<List<String>> bank_details = null;
        if(result.size()>0)
		{
			if(result.get(0).size()>0)
			{
				query="select DISTINCT ACC_NO,BANK_NAME,ACCOUNT_STATUS,CLOSING_BALANCE,ACCOUNT_OPEN_DATE  from NG_POS_STMTDATA_ACCMOVMNT_GRID A,NG_POS_CLOSING_BALANCE_GRID B,NG_POS_ACCOUNT_STATUS_GRID C where A.WI_NAME=B.WI_NAME AND A.WI_NAME=C.WI_NAME AND B.WI_NAME=A.WI_NAME AND A.wi_name = '"+workitem+"' AND A.ACC_NO=B.ACCOUNT_NO AND A.ACC_NO=C.ACCOUNT_NO  AND A.ACC_NO=B.ACCOUNT_NO EXCEPT select DISTINCT ACC_NO,BANK_NAME,ACC_STATUS,CLOSING_BALANCE,ACCOUNT_OPEN_DATE  from NG_POS_STMTDATA_ACCMOVMNT_GRID A,NG_POS_CLOSING_BALANCE_GRID B,NG_POS_ACCOUNT_STATUS_GRID C where A.WI_NAME=B.WI_NAME AND A.WI_NAME=C.WI_NAME AND B.WI_NAME=A.WI_NAME AND A.wi_name = '"+workitem+"' AND A.ACC_NO=B.ACCOUNT_NO AND A.ACC_NO=C.ACCOUNT_NO AND A.ACC_NO=B.ACCOUNT_NO AND ACCOUNT_STATUS='' ";
				bank_details = iformObj.getDataFromDB(query);
				logger.info("Query to fetch bank account details is"+query+"and its result is "+bank_details);
			}
			else
			{
				query="select ACC_NO,BANK_NAME,ACCOUNT_STATUS,'',''  from NG_POS_STMTDATA_ACCMOVMNT_GRID A,NG_POS_ACCOUNT_STATUS_GRID B where A.wi_name = '"+workitem+"' EXCEPT select ACC_NO,BANK_NAME,ACCOUNT_STATUS,'',''  from NG_POS_STMTDATA_ACCMOVMNT_GRID A,NG_POS_ACCOUNT_STATUS_GRID B where A.wi_name = '"+workitem+"' and ACCOUNT_STATUS ='' ";
				bank_details = iformObj.getDataFromDB(query);
				logger.info("Query to fetch bank account details is"+query+"and its result is "+bank_details);
				
			}
		}
		else
		{
			query="select ACC_NO,BANK_NAME,ACCOUNT_STATUS,'',''  from NG_POS_STMTDATA_ACCMOVMNT_GRID A,NG_POS_ACCOUNT_STATUS_GRID B where A.wi_name = '"+workitem+"' EXCEPT select ACC_NO,BANK_NAME,ACCOUNT_STATUS,'',''  from NG_POS_STMTDATA_ACCMOVMNT_GRID A,NG_POS_ACCOUNT_STATUS_GRID B where A.wi_name = '"+workitem+"' and ACCOUNT_STATUS =''  ";
			bank_details = iformObj.getDataFromDB(query);
			logger.info("Query to fetch bank account details is"+query+"and its result is "+bank_details);
		}
		
		JSONArray jsonArray =new JSONArray();
		JSONObject jsonobject;
		for(List<String> temp:bank_details)
		{
			if(temp.size()==5)
			{
				jsonobject=new JSONObject();
				jsonobject.put("Bank Name",temp.get(1));
				jsonobject.put("Account Number",temp.get(0));
				jsonobject.put("Closing Balance",temp.get(3));
				jsonobject.put("Status ",temp.get(2));
				jsonobject.put("Relationship Since",temp.get(4));
				jsonArray.add(jsonobject);
			}
		}
		
		iformObj.addDataToGrid("BANK_ACCNT_DET_GRID",jsonArray);
		
		}
		catch (Exception e)
		{
			logger.info("Exception occurred: fetchBankAccount"+e);
		}
		return "fetchBankAccount executed successfully";
	}
	private String test3check(IFormReference iformObj, String stringdata) {
	
		JSONArray jsonArray =new JSONArray();
		JSONObject parentObj;
		parentObj = new JSONObject();
		parentObj.put("qAdvancelist1807_text", "5000");
		JSONArray chilGridArray=new JSONArray();
		JSONObject childGridRowObject=new JSONObject();
		childGridRowObject.put("childtxt","childtext");
		childGridRowObject.put("insertionorderid","0");
		chilGridArray.add(childGridRowObject);
		parentObj.put("table3_table4",chilGridArray);
		parentObj.put("INSERTIONORDERID","0");
		jsonArray.add(parentObj);
		iformObj.addDataToGrid("table3", jsonArray);

		return "test3check success";
	}
	/*
	private String AdvanceListViewTest(IFormReference iformObj, String stringdata) {
		 logger.info("Inside AdvanceListViewTest");
		 JSONArray jsonArray=new JSONArray();
		 JSONObject obj=new JSONObject();
		 obj.put("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_RELATED_PARTY_DETAILS_CIC", "112");
		 obj.put("Q_NG_POS_RELATED_PARTY_GRID_NG_POS_INDIVIDUAL_DETAILS_GENDER", "MAle");
		 //obj.put("FOUR", "2");
		 //obj.put("FIVE", "2");
		 jsonArray.add(obj);
		 iformObj.addDataToGrid("table85",jsonArray);
		 logger.info("Inside AdvanceListViewTest and jsonarray is "+jsonArray);
		return "AdvanceListViewTest returns sucess";
	}
	
	private String AdvanceListViewTest_2(IFormReference iformObj, String stringdata) {
		 logger.info("Inside AdvanceListViewTest");
		 JSONArray jsonArray=new JSONArray();
		 JSONObject obj=new JSONObject();
		 obj.put("THREE", "112");
		 obj.put("FIVE", "1212");
		 //obj.put("FOUR", "2");
		 //obj.put("FIVE", "2");
		 jsonArray.add(obj);
		 iformObj.addDataToGrid("table10049",jsonArray);
		 logger.info("Inside AdvanceListViewTest and jsonarray is "+jsonArray);
		return "AdvanceListViewTest returns sucess";
	}
	*/
	private String relatedpartyfetchCIC(IFormReference iformObj, String stringdata) 
	{
		try
		{
		String callName = "MSBEntityDataInq"; //For CRS details
		JSONObject jsonobj = new JSONObject();

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
			
	
			for (String tag : tags) 
			{
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
			
			String padded_cic_no= getControlValue(iformObj, "table10599_CHILD_CIC");
			parser.changeValue(request_prefix+"CICNum",padded_cic_no);
			String language_tag=GetXML.getProp().getProperty(callName+"_LanguageTag");
			String session_lang=(String) iformObj.getValue("SESSION_LANG");
			parser.changeValue(request_prefix+language_tag, session_lang);
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML is :\n" + parser.toString());
			String ResponseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);

		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			ResponseXML=ResponseXML.replace(temp,"");
	
		
		tagName = "_TagNameResponseFetchCIC";	
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");
		

		tagNames = GetXML.getProp().getProperty(callName + tagName);
		
		logger.info(tagNames);
		tags = tagNames.split(",");
		
		parser = new XMLParser(ResponseXML);
		
		String status_code_in_response=parser.getValueOf(status_code_split[0]);
		if(status_code_in_response.equalsIgnoreCase(status_code_split[1]))
		{
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
					    		jsonobj.put(key[1],result);
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
					    	
			    			jsonobj.put(key[1], returned_value);
			    		}
				}
				else
				{	
					if(!key[0].contains("@"))
					{
						String tagValue = parser.getValueOf(key[0]);
						jsonobj.put(key[1], tagValue);
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
		    			jsonobj.put(key[1], returned_value);
					}
				}
				
			}
		}
		else
		{
			logger.info("For "+callName+" Status code returned from response is not success ");
		}	
		
		String country_code=(String) jsonobj.get("table10599_COUNTRY_CODE");
		try
		{
			String query="SELECT COUNTRY FROM NG_MAST_Country_Main WHERE COUNTRY_CODE ='"+country_code+"'  ";
			List<List> result=iformObj.getDataFromDB(query);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					jsonobj.put("table10599_COUNTRY_CODE",result.get(0).get(0));
				}
			}
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: relatedpartyfetchCIC in country code query"+e);
			jsonobj.put("table10599_COUNTRY_CODE","");
		}
		
		//Handling date formats in related Party
		String register_date=(String) jsonobj.get("table10599_REGISTER_DATE");
		String new_date="";
		if(register_date.contains("/"))
		{
			new_date=register_date.split("/")[2]+"/"+register_date.split("/")[1]+"/"+register_date.split("/")[0];
		}
		else if(register_date.contains("-"))
		{
			new_date=register_date.split("-")[2]+"-"+register_date.split("-")[1]+"-"+register_date.split("-")[0];
		}
		jsonobj.put("table10599_REGISTER_DATE",new_date);
		
		new_date="";
		String establish_date=(String) jsonobj.get("table10599_ESTABLISHMENT");
		if(establish_date.contains("/"))
		{
			new_date=establish_date.split("/")[2]+"/"+establish_date.split("/")[1]+"/"+establish_date.split("/")[0];
		}
		else if(establish_date.contains("-"))
		{
			new_date=establish_date.split("-")[2]+"-"+establish_date.split("-")[1]+"-"+establish_date.split("-")[0];
		}
		jsonobj.put("table10599_ESTABLISHMENT",new_date);
		
		logger.info("In fetch CIC final JSon arrays is "+jsonobj);
		
		for(Iterator iterator = jsonobj.keySet().iterator(); iterator.hasNext();) 
		{
		    String key = (String) iterator.next();
		    logger.info("Values set for"+key+" are "+jsonobj.get(key).toString());
		    setControlValue(iformObj, key, jsonobj.get(key).toString());
		}
	
		
		JSONObject return_obj=new JSONObject();
		
		//logger.info("Response XML received by setResponseDataGrid is"+ResponseXML);
		tagName = "_TagNameResponseFetchCIC_AddressList";
		tagNames = GetXML.getProp().getProperty(callName + tagName);
		logger.info(tagNames);
		
		String[] tagValue = tagNames.split(",");
		for(String tag: tagValue)
		{
			tags=tag.split("~");
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(ResponseXML);
			logger.info("objWFxmlResponse value is "+objWFxmlResponse);

			JSONArray jsonarr=new JSONArray();
			
			logger.info("Status codes are"+status_code_split[0]+"and"+status_code_split[1]);
			
			logger.info("Value of status tag in response is"+objWFxmlResponse.getVal(status_code_split[0]));
			
			if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
			//logger.info("Wfmxmlsit is --------------"+WFXmlList);
			for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) {
			
				jsonobj = new JSONObject();
				for(int j=2;j<tags.length;++j)
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
				
				jsonarr.add(jsonobj);
				
			}
			logger.info("fetchCIC addreesstype array is"+jsonarr);
			JSONObject finaljsonobj=null;
			String address_type="";
			for(int i=0;i<jsonarr.size();i++)
			{
				jsonobj=(JSONObject) jsonarr.get(i);
				address_type=(String) jsonobj.get("table10599_AddressType");
				if(address_type.equalsIgnoreCase("02"))
				{
					finaljsonobj=jsonobj;
				}
			}
			
			if(finaljsonobj!=null)
			{
				finaljsonobj.remove("table10599_AddressType");
			}
			
			logger.info("fetchCIC addreesstype finalobject is"+finaljsonobj);
			
			for(Iterator iterator = finaljsonobj.keySet().iterator(); iterator.hasNext();) 
			{
				 String key = (String) iterator.next();
				 logger.info("Values set for"+key+" are "+finaljsonobj.get(key).toString());
				 setControlValue(iformObj, key, finaljsonobj.get(key).toString());
			}
			
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
			logger.info("Exception Occurred: relatedpartyfetchCIC"+e);
		}
		
		return "relatedpartyfetchCIC called Successfully";
	}

	private String fillMoveAccGrid(IFormReference iformObj, String stringdata) {
		logger.info("String data to fill fillMoveAccGrid is" + stringdata);
		String[] value_split = stringdata.split("#");
		String acc_id = getControlValue(iformObj, value_split[0]);
		iformObj.clearTable(value_split[1]);
		if (acc_id.equalsIgnoreCase("All")) 
		{
			logger.info("TerminalID to fillMoveAccGrid is " + acc_id + "and table id is is" + value_split[1]);
			String wi_name = getWorkitemName(iformObj);
			JSONArray jsonarr = new JSONArray();
			JSONObject jsonobj = null;

			String query = "SELECT FROM_DATE,TO_DATE,BANK_NAME,ACC_NO,DEPOSIT,WITHDRAWAL,AVG_BAL,NEG_BAL,ACC_MONTH,THROUGHPUT FROM NG_POS_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='"+ wi_name + "' ORDER BY FROM_DATE DESC ";
			List<List<String>> stmt_data = iformObj.getDataFromDB(query);
			for (List<String> value : stmt_data)
			 {
				jsonobj = new JSONObject();
				jsonobj.put("From Date", value.get(0));
				jsonobj.put("To Date", value.get(1));
				jsonobj.put("Bank Name", value.get(2));
				jsonobj.put("Account Number", value.get(3));
				jsonobj.put("Deposit", value.get(4));
				jsonobj.put("Withdrawal", value.get(5));
				jsonobj.put("Average Balance", value.get(6));
				jsonobj.put("Negative Balance", value.get(7));
				jsonobj.put("Month", value.get(8));
				jsonobj.put("Throughput", value.get(9));
				jsonarr.add(jsonobj);
			}

			logger.info("JSON Array to fill stmt details is" + jsonobj);
			iformObj.addDataToGrid(value_split[1], jsonarr);
			} 
			else 
			{
			logger.info("TerminalID to fillMoveAccGrid is " + acc_id + "and table id is is" + value_split[1]);
			String wi_name = getWorkitemName(iformObj);
			JSONArray jsonarr = new JSONArray();
			JSONObject jsonobj = null;

			String query = "SELECT FROM_DATE,TO_DATE,BANK_NAME,ACC_NO,DEPOSIT,WITHDRAWAL,AVG_BAL,NEG_BAL,ACC_MONTH,THROUGHPUT FROM NG_POS_STMTDATA_ACCMOVMNT_GRID WHERE ACC_NO='"+ acc_id + "' AND WI_NAME='" + wi_name + "'  ORDER BY FROM_DATE DESC ";
			List<List<String>> stmt_data = iformObj.getDataFromDB(query);
			for (List<String> value : stmt_data) 
			{
				jsonobj = new JSONObject();
				jsonobj.put("From Date", value.get(0));
				jsonobj.put("To Date", value.get(1));
				jsonobj.put("Bank Name", value.get(2));
				jsonobj.put("Account Number", value.get(3));
				jsonobj.put("Deposit", value.get(4));
				jsonobj.put("Withdrawal", value.get(5));
				jsonobj.put("Average Balance", value.get(6));
				jsonobj.put("Negative Balance", value.get(7));
				jsonobj.put("Month", value.get(8));
				jsonobj.put("Throughput", value.get(9));
				jsonarr.add(jsonobj);
			}

			logger.info("JSON Array to fill stmt details is" + jsonobj);
			iformObj.addDataToGrid(value_split[1], jsonarr);
		}
		return "Successfully loaded fillMoveAccGrid";
	}

	private String fillMoveAccGridOldCIC(IFormReference iformObj, String stringdata)
	{
		logger.info("String data to fill fillMoveAccGrid is" + stringdata);
		String[] value_split = stringdata.split("#");
		String acc_id = getControlValue(iformObj, value_split[0]);
		iformObj.clearTable(value_split[1]);
		if (acc_id.equalsIgnoreCase("All")) 
		{
			logger.info("TerminalID to fillMoveAccGrid is " + acc_id + "and table id is is" + value_split[1]);
			String wi_name = getWorkitemName(iformObj);
			JSONArray jsonarr = new JSONArray();
			JSONObject jsonobj = null;

			String query = "SELECT FROM_DATE,TO_DATE,BANK_NAME,ACC_NO,DEPOSIT,WITHDRAWAL,AVG_BAL,NEG_BAL,ACC_MONTH,THROUGHPUT FROM NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='"+ wi_name + "' ORDER BY FROM_DATE DESC ";
			List<List<String>> stmt_data = iformObj.getDataFromDB(query);
			for (List<String> value : stmt_data)
			 {
				jsonobj = new JSONObject();
				jsonobj.put("From Date", value.get(0));
				jsonobj.put("To Date", value.get(1));
				jsonobj.put("Bank Name", value.get(2));
				jsonobj.put("Account Number", value.get(3));
				jsonobj.put("Deposit", value.get(4));
				jsonobj.put("Withdrawal", value.get(5));
				jsonobj.put("Average Balance", value.get(6));
				jsonobj.put("Negative Balance", value.get(7));
				jsonobj.put("Month", value.get(8));
				jsonobj.put("Throughput", value.get(9));
				jsonarr.add(jsonobj);
			}

			logger.info("JSON Array to fill stmt details is" + jsonobj);
			iformObj.addDataToGrid(value_split[1], jsonarr);
			} 
			else 
			{
			logger.info("TerminalID to fillMoveAccGrid is " + acc_id + "and table id is is" + value_split[1]);
			String wi_name = getWorkitemName(iformObj);
			JSONArray jsonarr = new JSONArray();
			JSONObject jsonobj = null;

			String query = "SELECT FROM_DATE,TO_DATE,BANK_NAME,ACC_NO,DEPOSIT,WITHDRAWAL,AVG_BAL,NEG_BAL,ACC_MONTH,THROUGHPUT FROM NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_GRID WHERE ACC_NO='"+ acc_id + "' AND WI_NAME='" + wi_name + "'  ORDER BY FROM_DATE DESC ";
			List<List<String>> stmt_data = iformObj.getDataFromDB(query);
			for (List<String> value : stmt_data) 
			{
				jsonobj = new JSONObject();
				jsonobj.put("From Date", value.get(0));
				jsonobj.put("To Date", value.get(1));
				jsonobj.put("Bank Name", value.get(2));
				jsonobj.put("Account Number", value.get(3));
				jsonobj.put("Deposit", value.get(4));
				jsonobj.put("Withdrawal", value.get(5));
				jsonobj.put("Average Balance", value.get(6));
				jsonobj.put("Negative Balance", value.get(7));
				jsonobj.put("Month", value.get(8));
				jsonobj.put("Throughput", value.get(9));
				jsonarr.add(jsonobj);
			}

			logger.info("JSON Array to fill stmt details is" + jsonobj);
			iformObj.addDataToGrid(value_split[1], jsonarr);
		}
		return "Successfully loaded fillMoveAccGrid";
	}


	/*
	//By Mohit Kumar
	private String CallCommodityPurchase(IFormReference iformObj, String stringdata) {

		String callName = "MSBCommodityMng"; //For ammortization details
		String responseXML = createRequestXML(iformObj, callName);
		JSONObject jobj = setResponseData(iformObj, callName, responseXML);

		for(Iterator iterator = jobj.keySet().iterator(); iterator.hasNext();)
			{
				String key = (String) iterator.next();
				logger.info("Values set for"+key+" are "+jobj.get(key).toString());
				setControlValue(iformObj, key, jobj.get(key).toString());
			}
		
		return "Call COmmodity Purchse Call Successfully";
	}
	*/
	
	private String CallMSBLimitMng(IFormReference iformObj, String stringdata) 
	{
		// TODO Auto-generated method stub
		// ======= MSB Limit Mng call starts
		// ======= MSB Limit Mng call starts
		String return_string="Success~CallMSBLimitMng";
		String limitcreation_status=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_T24_LMT_CRTN_STATUS");
		String limitenable_status=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_T24_LMT_ENBL_STATUS");
		String limit_ref_number=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_LIMIT_REF_PARENT");
		
		if(limitenable_status.length()==0 && limit_ref_number.length()==0)
		{
			logger.info("MSB Limit Mng call starts, starts create");
			String callName = "MSBLimitMng_Create"; //For ammortization details
			logger.info("Callname:::::::"+callName);
			String responseXML = createRequestXML(iformObj, callName);
			JSONObject MSBLimitMng_obj = setResponseData_2(iformObj, callName, responseXML);
			
			for(Iterator iterator = MSBLimitMng_obj.keySet().iterator(); iterator.hasNext();)
			{
				String key = (String) iterator.next();
				logger.info("Values set for"+key+" are "+MSBLimitMng_obj.get(key).toString());
				setControlValue(iformObj, key, MSBLimitMng_obj.get(key).toString());
			}
			
			logger.info("For Create limit object is :"+MSBLimitMng_obj);

			for(Iterator iterator = MSBLimitMng_obj.keySet().iterator(); iterator.hasNext();)
			{
				String key = (String) iterator.next();
				if(key.equalsIgnoreCase("Error"))
				{
					return_string="Error~"+MSBLimitMng_obj.get(key).toString();
					return return_string;
				}
				else
				{
					logger.info("Values set for"+key+" are "+MSBLimitMng_obj.get(key).toString());
					setControlValue(iformObj, key, MSBLimitMng_obj.get(key).toString());
				}
			}	
			
			String T24LimitRef= (String) iformObj.getValue("T24_LIMIT_REF");
			logger.info("T24 limit ref no is "+T24LimitRef);
			callName = "MSBLimitMng_Enable"; //For ammortization details
			//responseXML = createRequestXML(iformObj, callName);
			
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
				
		
				for (String tag : tags) 
				{
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
					if (tagValue.startsWith("formid~")) 
					{
						String tagValue_in_request=tagValue.split("~")[1];
						String value ="";
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
								logger.info("Exception Occurred CallMSBLimitMng ");
							}
						}
						else
						{
							value = (String) iformObj.getValue(tagValue.split("~")[1]);
						}
						parser.changeValue(request_prefix+tag, value);
					}
					
				}
				
				parser.changeValue(request_prefix+"T24LimitRef", T24LimitRef);
				System.out.println("RequestXML is :\n" + parser.toString());
				logger.info("RequestXML for enable limtit after appending T24refno is :\n" + parser.toString());
				responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
			
				/*
			JSONObject MSBLimitMngEnable_obj = setResponseData(iformObj, callName, responseXML);
			for(Iterator iterator = MSBLimitMngEnable_obj.keySet().iterator(); iterator.hasNext();)
			{
			String key = (String) iterator.next();
			logger.info("Values set for"+key+" are "+MSBLimitMngEnable_obj.get(key).toString());
			setControlValue(iformObj, key, MSBLimitMngEnable_obj.get(key).toString());
			}
			*/
				
				JSONObject MSBLimitMngEnable_obj = setResponseData_2(iformObj, callName, responseXML);
				logger.info("For Enable limit object is :"+MSBLimitMngEnable_obj);
			     return_string="Success~Limit Creation executed";

				for(Iterator iterator = MSBLimitMngEnable_obj.keySet().iterator(); iterator.hasNext();)
				{
					String key = (String) iterator.next();
					if(key.equalsIgnoreCase("Error"))
					{
						return_string="Error~"+MSBLimitMngEnable_obj.get(key).toString();
						return return_string;
					}
					else
					{
						logger.info("Values set for"+key+" are "+MSBLimitMngEnable_obj.get(key).toString());
						setControlValue(iformObj, key, MSBLimitMngEnable_obj.get(key).toString());
					}
				}		
		}
		logger.info("CallMSBLimitMng: for '"+getWorkitemName(iformObj)+"' : success received in creating and enabling limit ");
		String master_agmt_ref_no=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REF_NO_MASTER_AGRMNT");
		if(master_agmt_ref_no.length()==0)
		{
			String stipulation_result=MSBContractMngRq(iformObj,stringdata) ;
			logger.info("Stipulation result is "+stipulation_result);
			if(stipulation_result.split("~")[0].equalsIgnoreCase("Error"))
			{
				logger.info("Finally returning this "+stipulation_result);
				return stipulation_result;
			}
		}
		
		return return_string;
		
	}
	
	
	private String CallMSBCustMngRq(IFormReference iformObj, String stringdata) {
		String callName = "MSBCustMng"; //For Prospect Customer
		logger.info("MSBCustMngRq@@@@ " + callName);
		String responseXML = createRequestXML(iformObj, callName);
		logger.info("CallMSBCustMngRq@@@@response " +responseXML);
		JSONObject CallMSBCustMngRq_obj = setResponseData(iformObj, callName, responseXML);
		for(Iterator iterator = CallMSBCustMngRq_obj.keySet().iterator(); iterator.hasNext();)
		{
		String key = (String) iterator.next();
		logger.info("Values set for"+key+" are "+CallMSBCustMngRq_obj.get(key).toString());
		setControlValue(iformObj, key, CallMSBCustMngRq_obj.get(key).toString());
		}
		return "CallMSBCustMngRq Called";
		}
	
	private String MSBContractMngRq(IFormReference iformObj, String stringdata) 
	{

		String callName = "MSBContractMng"; //For master stipulation at approved sales stage.
		String responseXML = "";
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
			
	
			for (String tag : tags) 
			{
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
			//logger.info("Handling special cases");
			String padded_cic_no=(String) iformObj.getValue("PADDED_CIC_NO");
			logger.info("CIC_No after appending zeroes are "+padded_cic_no);
			parser.changeValue(request_prefix+"alr1:CICNum",padded_cic_no);
			parser.changeValue(request_prefix+"CICNum",padded_cic_no);
			
			String customer_type=parser.getValueOf(request_prefix+"CustType");
			if(customer_type.equalsIgnoreCase("ARB POS Customer"))
				parser.changeValue(request_prefix+"CustType", "1");
			else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
				parser.changeValue(request_prefix+"CustType", "2");
			else if (customer_type.equalsIgnoreCase("ARB Non POS"))
				parser.changeValue(request_prefix+"CustType", "3");
			
			String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
			//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
			String frequency_value="";
			//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
			logger.info("InstallmentFrequency before change is "+frequency);
			if(frequency.equalsIgnoreCase("Monthly"))
			{
				frequency_value="e1m";
			}else if(frequency.equalsIgnoreCase("Quarterly"))
			{
				frequency_value="e3m";
			}else if(frequency.equalsIgnoreCase("Half-Yearly"))
			{
				frequency_value="e6m";
			}else if(frequency.equalsIgnoreCase("Annually"))
			{
				frequency_value="e12m";
			}
			frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
			parser.changeValue(request_prefix+"InstallmentFrequency",frequency_value);	
			logger.info("InstallmentFrequency after change is "+frequency_value);
			//String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			//logger.info("Date after change is "+date);
			//parser.changeValue(request_prefix+"ContractDate",date);	
			//logger.info("In contract date we have set value as "+date);
			String grace_in_month=parser.getValueOf(request_prefix+"GraceInMonth");
			String tag_grace_in_month;
			if(!grace_in_month.equalsIgnoreCase(""))
			{
				//logger.info("Grace period is not empty");
			    Integer month=Integer.parseInt(grace_in_month)+1;
				//logger.info("Month is : "+month);
				tag_grace_in_month="R_START + "+month.toString()+"M";
				parser.changeValue(request_prefix+"GraceInMonth", tag_grace_in_month);
				//logger.info("Grace period in month is : "+tag_grace_in_month);
			}
			
			/*if(!grace_period_captialization.equalsIgnoreCase("")) // Uncomment for grace_period_captialization handling
			{
				parser.changeValue(request_prefix+"GracePeriodCapitalization","R_MATURITY +"+grace_period_captialization);
			}*/
			
			String tenure=parser.getValueOf(request_prefix+"FinanceTenure");
			parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
			
			System.out.println("RequestXML for MSBContractMngRq is :\n" + parser.toString());
			logger.info("RequestXML is :\n" + parser.toString());
			responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
	
			System.out.println("Response XML is: \n" + responseXML);
			}
			catch(Exception e)
			{
				
				logger.info("Exception occurred: createRequestXMLfor MSBContractMngRq "+e.getStackTrace().toString());
				return "Error~Exception occurred: createRequestXMLfor MSBContractMngRq";
			}
		
		/*JSONObject MSBContractMngRq_obj = setResponseData(iformObj, callName, responseXML);
		for(Iterator iterator = MSBContractMngRq_obj.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			logger.info("Values set for"+key+" are "+MSBContractMngRq_obj.get(key).toString());
			setControlValue(iformObj, key, MSBContractMngRq_obj.get(key).toString());
		}*/
		
		JSONObject MSBContractMngRq_obj = setResponseData_2(iformObj, callName, responseXML);
		logger.info("For contract stimulation object is :"+MSBContractMngRq_obj);
		String return_string="Success~Contract Simulation executed";

		for(Iterator iterator = MSBContractMngRq_obj.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			if(key.equalsIgnoreCase("Error"))
			{
				return_string="Error~"+MSBContractMngRq_obj.get(key).toString();
				logger.info("MSBContractMng: for '"+getWorkitemName(iformObj)+"' : error received and error is "+return_string);
				return return_string;
			}
			else
			{
				logger.info("Values set for"+key+" are "+MSBContractMngRq_obj.get(key).toString());
				setControlValue(iformObj, key, MSBContractMngRq_obj.get(key).toString());
			}
		}		
		return return_string;
	}
	
	private String MSBContractMngRqChild(IFormReference iformObj, String stringdata) 
	{
		String callName = ""; //For contract sulation in application data
		String responseXML = "";// 
		try
		{
			//New Coding Start
			String grace_period_field="",grace_period_captilaization="",tenure="",installment_type="";
			/*
			String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
			String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
			String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
			String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
			String tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
			String requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
			
			if(requested_amt==null || requested_amt=="")
			{
				requested_amt="0";
			}
			
			//double admin_Fees_rate=0,admin_Fees_vat_per=0,admin_fees=0,vat,broker_fees_vat,total_admin_fees=0,total_broker_fees=0,max_fees_amount=0,broker_fees=0;
			String query="SELECT GRACE_PERIOD,GRACE_PERIOD_CAPITALIZATION FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_tenure>='"+tenure+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+" ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					grace_period_field=result.get(0).get(0);
					grace_period_captilaization=result.get(0).get(0);
				}
			}
			*/
			grace_period_field=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_PERIOD");
			grace_period_captilaization=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_PRD_CAPITALIZATION");
			tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
			installment_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TYPE_OF_INSTALLMENT");
			String grace_in_month=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH");
			boolean grace_period_zero_flag=false;
			try
			{
				if(Integer.parseInt(grace_in_month)==0)
				{
					grace_period_zero_flag=true;
				}
			}
			catch(Exception e)
			{
				grace_period_zero_flag=true;
			}
			
			
			if(grace_period_field.equalsIgnoreCase("Yes") && grace_period_zero_flag==false )
			{
				if(grace_period_captilaization.equalsIgnoreCase("Yes"))
				{
					callName="MSBContractMngChild_With_GP_With_Capitalization";
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
					

					for (String tag : tags) 
					{
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
						if (tagValue.startsWith("formid~")) {
							String value = (String) iformObj.getValue(tagValue.split("~")[1]);
							parser.changeValue(request_prefix+tag, value);
							
						}
						
					}
					
					String los_app_num = (String) iformObj.getValue("LOS_APP_NUM");
					logger.info("los_app_num =="+los_app_num);
					parser.changeValue(request_prefix+"LOSAppNum",los_app_num.concat("-001"));
					
					String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
					int no_of_zeroes=16-cic_no.length();
					for(int i=0;i<no_of_zeroes;i++)
					{
						cic_no='0'+cic_no;
					}
					
					logger.info("CIC_No after appending zeroes are "+cic_no);
					parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
					parser.changeValue(request_prefix+"CICNum",cic_no);

					String customer_type=parser.getValueOf(request_prefix+"CustType");
					if(customer_type.equalsIgnoreCase("ARB POS Customer"))
						parser.changeValue(request_prefix+"CustType", "1");
					else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
						parser.changeValue(request_prefix+"CustType", "2");
					else if (customer_type.equalsIgnoreCase("ARB Non POS"))
						parser.changeValue(request_prefix+"CustType", "3");
					
					String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
					//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
					String frequency_value="";
					//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
					logger.info("InstallmentFrequency before change is "+frequency);
					if(frequency.equalsIgnoreCase("Monthly"))
					{
						frequency_value="e1M";
					}else if(frequency.equalsIgnoreCase("Quarterly"))
					{
						frequency_value="e3M";
					}else if(frequency.equalsIgnoreCase("Half-Yearly"))
					{
						frequency_value="e6M";
					}else if(frequency.equalsIgnoreCase("Annually"))
					{
						frequency_value="e12M";
					}
					
					parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
					
					frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
					parser.changeValue(request_prefix+"InstallmentFrequency",frequency_value);	
					logger.info("InstallmentFrequency after change is "+frequency_value);
					
					grace_in_month=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH");
				
					logger.info("Request xml upto point 1 is "+parser.toString());
				
					parser.changeValue("GracePeriodCapitalizationFirst", "R_START + "+grace_in_month+"M");
					
					logger.info("Request xml upto point 2 is "+parser.toString());
					
					int grace_in_month_plus_one;
					try
					{
						if(Integer.parseInt(grace_in_month)<0)
						{
							return "Error~"+"Incorrect Value of Grace in Month" ;
						}
						grace_in_month_plus_one=Integer.parseInt(grace_in_month)+1;
					}
					catch(Exception e)
					{
						return "Error~"+"Incorrect Value of Grace in Month" ;
					}
					
					logger.info("Request xml upto point 3 is "+parser.toString());
					
					parser.changeValue("GraceInMonthLast", "R_START + "+grace_in_month_plus_one+"M");
					
					String request=parser.toString();
					//request=request.replace("DetailsLstOuter","DetailsLst");
					
					request=request.replace("DetailsLstInnerFirst","DetailsLstItem");
					request=request.replace("DetailsLstInnerLast","DetailsLstItem");
					request=request.replace("GraceInMonthFirst","GraceInMonth");
					request=request.replace("GraceInMonthLast","GraceInMonth");
					request=request.replace("GracePeriodCapitalizationFirst","GracePeriodCapitalization");
					request=request.replace("GracePeriodCapitalizationSecond","GracePeriodCapitalization");
					

					System.out.println("RequestXML for ContractSimulationMng is :\n" + request);
					logger.info("RequestXML is :\n" + parser.toString());
					responseXML = new SocketConnector().getSocketXMLResponse(request, callName,iformObj);
			
					System.out.println("Response XML is: \n" + responseXML);				
				}
				else
				{
					if(installment_type.equalsIgnoreCase("Without Payment"))
					{
						callName="MSBContractMngChild_With_GP_Without_Payment";
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
				
						logger.info("Now we will read dummy request");
						String requestXML = readDummyRequest(callName);
						logger.info("Dummy read is success");
						XMLParser parser = new XMLParser(requestXML);
						

						for (String tag : tags) 
						{
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
							if (tagValue.startsWith("formid~")) {
								String value = (String) iformObj.getValue(tagValue.split("~")[1]);
								parser.changeValue(request_prefix+tag, value);
							}
							
						}
						
						String los_app_num = (String) iformObj.getValue("LOS_APP_NUM");
						logger.info("los_app_num =="+los_app_num);
						parser.changeValue(request_prefix+"LOSAppNum",los_app_num.concat("-001"));
						
						String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
						int no_of_zeroes=16-cic_no.length();
						for(int i=0;i<no_of_zeroes;i++)
						{
							cic_no='0'+cic_no;
						}
						
						logger.info("CIC_No after appending zeroes are "+cic_no);
						parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
						parser.changeValue(request_prefix+"CICNum",cic_no);

						String customer_type=parser.getValueOf(request_prefix+"CustType");
						if(customer_type.equalsIgnoreCase("ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "1");
						else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "2");
						else if (customer_type.equalsIgnoreCase("ARB Non POS"))
							parser.changeValue(request_prefix+"CustType", "3");
						

						String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
						//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
						String frequency_value="";
						//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
						logger.info("InstallmentFrequency before change is "+frequency);
						if(frequency.equalsIgnoreCase("Monthly"))
						{
							frequency_value="e1M";
						}else if(frequency.equalsIgnoreCase("Quarterly"))
						{
							frequency_value="e3M";
						}else if(frequency.equalsIgnoreCase("Half-Yearly"))
						{
							frequency_value="e6M";
						}else if(frequency.equalsIgnoreCase("Annually"))
						{
							frequency_value="e12M";
						}
						
						
						frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
						parser.changeValue(request_prefix+"InstallmentFrequency",frequency_value);	
						logger.info("InstallmentFrequency after change is "+frequency_value);
						
						grace_in_month=parser.getValueOf(request_prefix+"GraceInMonth");
						try
						{
							Integer month=Integer.parseInt(grace_in_month)+1;
							String tag_grace_in_month="R_START + "+month.toString()+"M";
							parser.changeValue(request_prefix+"GraceInMonth", tag_grace_in_month);
						}
						catch(Exception e)
						{
							return "Error~"+"Incorrect Value of Grace in Month" ;
						}

						parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
						
						System.out.println("RequestXML for ContractSimulationMng is :\n" + parser.toString());
						logger.info("RequestXML is :\n" + parser.toString());
						responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
				
						System.out.println("Response XML is: \n" + responseXML);
						
					}
					else if(installment_type.equalsIgnoreCase("Only Profit"))
					{
						callName="MSBContractMngChild_With_GP_With_Int_Payment";
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
						

						for (String tag : tags) 
						{
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
							if (tagValue.startsWith("formid~")) {
								String value = (String) iformObj.getValue(tagValue.split("~")[1]);
								parser.changeValue(request_prefix+tag, value);
							}
							
						}
						
						String los_app_num = (String) iformObj.getValue("LOS_APP_NUM");
						logger.info("los_app_num =="+los_app_num);
						parser.changeValue(request_prefix+"LOSAppNum",los_app_num.concat("-001"));
						
						String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
						int no_of_zeroes=16-cic_no.length();
						for(int i=0;i<no_of_zeroes;i++)
						{
							cic_no='0'+cic_no;
						}
						
						logger.info("CIC_No after appending zeroes are "+cic_no);
						parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
						parser.changeValue(request_prefix+"CICNum",cic_no);

						String customer_type=parser.getValueOf(request_prefix+"CustType");
						if(customer_type.equalsIgnoreCase("ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "1");
						else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "2");
						else if (customer_type.equalsIgnoreCase("ARB Non POS"))
							parser.changeValue(request_prefix+"CustType", "3");
						
						String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
						//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
						String frequency_value="";
						//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
						logger.info("InstallmentFrequency before change is "+frequency);
						if(frequency.equalsIgnoreCase("Monthly"))
						{
							frequency_value="e1M";
						}else if(frequency.equalsIgnoreCase("Quarterly"))
						{
							frequency_value="e3M";
						}else if(frequency.equalsIgnoreCase("Half-Yearly"))
						{
							frequency_value="e6M";
						}else if(frequency.equalsIgnoreCase("Annually"))
						{
							frequency_value="e12M";
						}
						
						
						frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
						parser.changeValue(request_prefix+"InstallmentFrequencyFirst",frequency_value);
						parser.changeValue(request_prefix+"InstallmentFrequencySecond",frequency_value);
						
						
						grace_in_month=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH");
						
						parser.changeValue("GracePeriodCapitalizationSecondInner", "R_START + "+grace_in_month+"M");
						
						int grace_in_month_plus_one;
						try
						{
							if(Integer.parseInt(grace_in_month)<=0)
							{
								return "Error~"+"Incorrect Value of Grace in Month" ;
							}
							grace_in_month_plus_one=Integer.parseInt(grace_in_month)+1;
						}
						catch(Exception e)
						{
							return "Error~"+"Incorrect Value of Grace in Month" ;
						}
						
						parser.changeValue("GraceInMonthFirstInner", "R_START + "+grace_in_month_plus_one+"M");
						
						logger.info("InstallmentFrequency after change is "+frequency_value);
						parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
						
						
						String request=parser.toString();
						request=request.replace("DetailsLstFirst","DetailsLst");
						request=request.replace("DetailsLstFirstInner","DetailsLstItem");
						request=request.replace("DetailsLstSecond","DetailsLst");
						request=request.replace("DetailsLstSecondInner","DetailsLstItem");
						request=request.replace("DetailsLstInner","DetailsLstItem");
						
						request=request.replace("GraceInMonthFirstInner","GraceInMonth");
						request=request.replace("GraceInMonthSecondInner","GraceInMonth");
						
						request=request.replace("GracePeriodCapitalizationSecondInner","GracePeriodCapitalization");
						request=request.replace("GracePeriodCapitalizationFirstInner","GracePeriodCapitalization");
						
						
						request=request.replace("InstallmentTypeFirst","InstallmentType");
						request=request.replace("InstallmentFrequencyFirst","InstallmentFrequency");
						request=request.replace("InstallmentTypeSecond","InstallmentType");
						request=request.replace("InstallmentFrequencySecond","InstallmentFrequency");
						
						
						System.out.println("RequestXML for ContractSimulationMng is :\n" + request);
						logger.info("RequestXML is :\n" + parser.toString());
						responseXML = new SocketConnector().getSocketXMLResponse(request, callName,iformObj);
				
						System.out.println("Response XML is: \n" + responseXML);		
						
					}
					else
					{
						return "Error~"+"Installment Type can not be empty if Grace Period is No" ;
					}
				}
			}
			else if(grace_period_field.equalsIgnoreCase("No") || grace_period_field.equalsIgnoreCase("") || grace_period_zero_flag==true)
			{
				callName="MSBContractMngChild_Without_GP";
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
				

				for (String tag : tags) 
				{
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
					if (tagValue.startsWith("formid~")) {
						String value = (String) iformObj.getValue(tagValue.split("~")[1]);
						parser.changeValue(request_prefix+tag, value);
					}
					
				}
				
				String los_app_num = (String) iformObj.getValue("LOS_APP_NUM");
				logger.info("los_app_num =="+los_app_num);
				parser.changeValue(request_prefix+"LOSAppNum",los_app_num.concat("-001"));
				
				String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
				int no_of_zeroes=16-cic_no.length();
				for(int i=0;i<no_of_zeroes;i++)
				{
					cic_no='0'+cic_no;
				}
				
				logger.info("CIC_No after appending zeroes are "+cic_no);
				parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
				parser.changeValue(request_prefix+"CICNum",cic_no);

				String customer_type=parser.getValueOf(request_prefix+"CustType");
				if(customer_type.equalsIgnoreCase("ARB POS Customer"))
					parser.changeValue(request_prefix+"CustType", "1");
				else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
					parser.changeValue(request_prefix+"CustType", "2");
				else if (customer_type.equalsIgnoreCase("ARB Non POS"))
					parser.changeValue(request_prefix+"CustType", "3");
				
				String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
				//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
				String frequency_value="";
				//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
				logger.info("InstallmentFrequency before change is "+frequency);
				if(frequency.equalsIgnoreCase("Monthly"))
				{
					frequency_value="e1M";
				}else if(frequency.equalsIgnoreCase("Quarterly"))
				{
					frequency_value="e3M";
				}else if(frequency.equalsIgnoreCase("Half-Yearly"))
				{
					frequency_value="e6M";
				}else if(frequency.equalsIgnoreCase("Annually"))
				{
					frequency_value="e12M";
				}
				
				
				frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
				parser.changeValue(request_prefix+"InstallmentFrequency",frequency_value);	
				logger.info("InstallmentFrequency after change is "+frequency_value);
				
				parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
				
				System.out.println("RequestXML for ContractSimulationMng is :\n" + parser.toString());
				logger.info("RequestXML is :\n" + parser.toString());
				responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
		
				System.out.println("Response XML is: \n" + responseXML);
				 
			}
			//New Coding End
			}
			catch(Exception e)
			{
				
				logger.info("Exception occurred: createRequestXMLfor MSBContractMngRqChild "+e.getStackTrace().toString());
				return "";
			}
		
		/*JSONObject MSBContractMngRq_obj = setResponseData(iformObj, callName, responseXML);
		for(Iterator iterator = MSBContractMngRq_obj.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			logger.info("Values set for"+key+" are "+MSBContractMngRq_obj.get(key).toString());
			setControlValue(iformObj, key, MSBContractMngRq_obj.get(key).toString());
		}*/
		
		JSONObject MSBContractMngRq_obj = setResponseData_2(iformObj, callName, responseXML);
		logger.info("For contract stimulation of child object is :"+MSBContractMngRq_obj);
		String return_string="Success~Contract Stimulation of child executed";

		for(Iterator iterator = MSBContractMngRq_obj.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			if(key.equalsIgnoreCase("Error"))
			{
				return_string="Error~"+MSBContractMngRq_obj.get(key).toString();
			}
			else
			{
				logger.info("Values set for"+key+" are "+MSBContractMngRq_obj.get(key).toString());
				setControlValue(iformObj, key, MSBContractMngRq_obj.get(key).toString());
			}
		}		
		return return_string;
	}

	
	private String CallContractSimulation(IFormReference iformObj, String stringdata) {
		//String prospect_customer_result=CallMSBCustMngRq(iformObj, stringdata); //For Prospect Customer
		//logger.info("Prospect Customer Response is "+prospect_customer_result);	
		// ============= Contract Simulation Mng =============
		String callName = ""; //For contract sulation in application data
		String responseXML = "";// 
		try
		{
			
			//New Coding Start
			String grace_period_field="",grace_period_captilaization="",tenure="",installment_type="";
			/*
			String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
			String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
			String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
			String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
			String tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
			String requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
			
			if(requested_amt==null || requested_amt=="")
			{
				requested_amt="0";
			}
			
			//double admin_Fees_rate=0,admin_Fees_vat_per=0,admin_fees=0,vat,broker_fees_vat,total_admin_fees=0,total_broker_fees=0,max_fees_amount=0,broker_fees=0;
			String query="SELECT GRACE_PERIOD,GRACE_PERIOD_CAPITALIZATION FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_tenure>='"+tenure+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+" ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					grace_period_field=result.get(0).get(0);
					grace_period_captilaization=result.get(0).get(0);
				}
			}
			*/
			grace_period_field=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_PERIOD");
			grace_period_captilaization=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_PRD_CAPITALIZATION");
			tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
			installment_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TYPE_OF_INSTALLMENT");
			String grace_in_month=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH");
			boolean grace_period_zero_flag=false;
			try
			{
				if(Integer.parseInt(grace_in_month)==0)
				{
					grace_period_zero_flag=true;
				}
			}
			catch(Exception e)
			{
				grace_period_zero_flag=true;
			}
			
			if(grace_period_field.equalsIgnoreCase("Yes") && grace_period_zero_flag==false )
			{
				if(grace_period_captilaization.equalsIgnoreCase("Yes"))
				{
					callName="ContractSimulationMng_With_GP_With_Capitalization";
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
					

					for (String tag : tags) 
					{
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
						if (tagValue.startsWith("formid~")) {
							String value = (String) iformObj.getValue(tagValue.split("~")[1]);
							parser.changeValue(request_prefix+tag, value);
							
						}
						
					}
					
					String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
					int no_of_zeroes=16-cic_no.length();
					for(int i=0;i<no_of_zeroes;i++)
					{
						cic_no='0'+cic_no;
					}
					
					logger.info("CIC_No after appending zeroes are "+cic_no);
					parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
					parser.changeValue(request_prefix+"CICNum",cic_no);

					String customer_type=parser.getValueOf(request_prefix+"CustType");
					if(customer_type.equalsIgnoreCase("ARB POS Customer"))
						parser.changeValue(request_prefix+"CustType", "1");
					else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
						parser.changeValue(request_prefix+"CustType", "2");
					else if (customer_type.equalsIgnoreCase("ARB Non POS"))
						parser.changeValue(request_prefix+"CustType", "3");
					
					String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
					//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
					String frequency_value="";
					//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
					logger.info("InstallmentFrequency before change is "+frequency);
					if(frequency.equalsIgnoreCase("Monthly"))
					{
						frequency_value="e1m";
					}else if(frequency.equalsIgnoreCase("Quarterly"))
					{
						frequency_value="e3m";
					}else if(frequency.equalsIgnoreCase("Half-Yearly"))
					{
						frequency_value="e6m";
					}else if(frequency.equalsIgnoreCase("Annually"))
					{
						frequency_value="e12m";
					}
					
					parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
					
					frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
					parser.changeValue(request_prefix+"InstallmentFrequency",frequency_value);	
					logger.info("InstallmentFrequency after change is "+frequency_value);
				
					logger.info("Request xml upto point 1 is "+parser.toString());
				
					parser.changeValue("GracePeriodCapitalizationFirst", "R_START + "+grace_in_month+"M");
					
					logger.info("Request xml upto point 2 is "+parser.toString());
					
					int grace_in_month_plus_one;
					try
					{
						if(Integer.parseInt(grace_in_month)<=0)
						{
							return "Error~"+"Incorrect Value of Grace in Month" ;
						}
						grace_in_month_plus_one=Integer.parseInt(grace_in_month)+1;
					}
					catch(Exception e)
					{
						return "Error~"+"Incorrect Value of Grace in Month" ;
					}
					
					logger.info("Request xml upto point 3 is "+parser.toString());
					
					parser.changeValue("GraceInMonthLast", "R_START + "+grace_in_month_plus_one+"M");
					
					String request=parser.toString();
					//request=request.replace("DetailsLstOuter","DetailsLst");
					
					request=request.replace("DetailsLstInnerFirst","DetailsLstItem");
					request=request.replace("DetailsLstInnerLast","DetailsLstItem");
					request=request.replace("GraceInMonthFirst","GraceInMonth");
					request=request.replace("GraceInMonthLast","GraceInMonth");
					request=request.replace("GracePeriodCapitalizationFirst","GracePeriodCapitalization");
					request=request.replace("GracePeriodCapitalizationSecond","GracePeriodCapitalization");
					
					String reapproval_flag=(String) iformObj.getValue("REAPPROVAL_FLAG");
					if(reapproval_flag.equalsIgnoreCase("true"))
					{
						request=request.replaceAll("<LOSAppNum>[a-zA-Z0-9]*</LOSAppNum>","");
					}

					System.out.println("RequestXML for ContractSimulationMng is :\n" + request);
					logger.info("RequestXML is :\n" + parser.toString());
					responseXML = new SocketConnector().getSocketXMLResponse(request, callName,iformObj);
			
					System.out.println("Response XML is: \n" + responseXML);				
				}
				else
				{
					if(installment_type.equalsIgnoreCase("Without Payment"))
					{
						callName="ContractSimulationMng_With_GP_Without_Payment";
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
				
						logger.info("Now we will read dummy request");
						String requestXML = readDummyRequest(callName);
						logger.info("Dummy read is success");
						XMLParser parser = new XMLParser(requestXML);
						

						for (String tag : tags) 
						{
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
							if (tagValue.startsWith("formid~")) {
								String value = (String) iformObj.getValue(tagValue.split("~")[1]);
								parser.changeValue(request_prefix+tag, value);
							}
							
						}
						
						String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
						int no_of_zeroes=16-cic_no.length();
						for(int i=0;i<no_of_zeroes;i++)
						{
							cic_no='0'+cic_no;
						}
						
						logger.info("CIC_No after appending zeroes are "+cic_no);
						parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
						parser.changeValue(request_prefix+"CICNum",cic_no);

						String customer_type=parser.getValueOf(request_prefix+"CustType");
						if(customer_type.equalsIgnoreCase("ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "1");
						else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "2");
						else if (customer_type.equalsIgnoreCase("ARB Non POS"))
							parser.changeValue(request_prefix+"CustType", "3");
						

						String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
						//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
						String frequency_value="";
						//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
						logger.info("InstallmentFrequency before change is "+frequency);
						if(frequency.equalsIgnoreCase("Monthly"))
						{
							frequency_value="e1m";
						}else if(frequency.equalsIgnoreCase("Quarterly"))
						{
							frequency_value="e3m";
						}else if(frequency.equalsIgnoreCase("Half-Yearly"))
						{
							frequency_value="e6m";
						}else if(frequency.equalsIgnoreCase("Annually"))
						{
							frequency_value="e12m";
						}
						
						
						frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
						parser.changeValue(request_prefix+"InstallmentFrequency",frequency_value);	
						logger.info("InstallmentFrequency after change is "+frequency_value);
						
						try
						{
							Integer month=Integer.parseInt(grace_in_month)+1;
							String tag_grace_in_month="R_START + "+month.toString()+"M";
							parser.changeValue(request_prefix+"GraceInMonth", tag_grace_in_month);
						}
						catch(Exception e)
						{
							return "Error~"+"Incorrect Value of Grace in Month" ;
						}

						parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
						
						String request=parser.toString();
						
						String reapproval_flag=(String) iformObj.getValue("REAPPROVAL_FLAG");
						if(reapproval_flag.equalsIgnoreCase("true"))
						{
							request=request.replaceAll("<LOSAppNum>[a-zA-Z0-9]*</LOSAppNum>","");
						}
						
						System.out.println("RequestXML for ContractSimulationMng is :\n" + request);
						logger.info("RequestXML is :\n" + request);
						responseXML = new SocketConnector().getSocketXMLResponse(request, callName,iformObj);
				
						System.out.println("Response XML is: \n" + responseXML);
						
					}
					else if(installment_type.equalsIgnoreCase("Only Profit"))
					{
						callName="ContractSimulationMng_With_GP_With_Int_Payment";
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
						

						for (String tag : tags) 
						{
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
							if (tagValue.startsWith("formid~")) {
								String value = (String) iformObj.getValue(tagValue.split("~")[1]);
								parser.changeValue(request_prefix+tag, value);
							}
							
						}
						
						String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
						int no_of_zeroes=16-cic_no.length();
						for(int i=0;i<no_of_zeroes;i++)
						{
							cic_no='0'+cic_no;
						}
						
						logger.info("CIC_No after appending zeroes are "+cic_no);
						parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
						parser.changeValue(request_prefix+"CICNum",cic_no);

						String customer_type=parser.getValueOf(request_prefix+"CustType");
						if(customer_type.equalsIgnoreCase("ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "1");
						else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "2");
						else if (customer_type.equalsIgnoreCase("ARB Non POS"))
							parser.changeValue(request_prefix+"CustType", "3");
						
						String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
						//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
						String frequency_value="";
						//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
						logger.info("InstallmentFrequency before change is "+frequency);
						if(frequency.equalsIgnoreCase("Monthly"))
						{
							frequency_value="e1m";
						}else if(frequency.equalsIgnoreCase("Quarterly"))
						{
							frequency_value="e3m";
						}else if(frequency.equalsIgnoreCase("Half-Yearly"))
						{
							frequency_value="e6m";
						}else if(frequency.equalsIgnoreCase("Annually"))
						{
							frequency_value="e12m";
						}
						
						
						frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
						parser.changeValue(request_prefix+"InstallmentFrequencyFirst",frequency_value);
						parser.changeValue(request_prefix+"InstallmentFrequencySecond",frequency_value);
						
						
						parser.changeValue("GracePeriodCapitalizationSecondInner", "R_START + "+grace_in_month+"M");
						
						int grace_in_month_plus_one;
						try
						{
							if(Integer.parseInt(grace_in_month)<=0)
							{
								return "Error~"+"Incorrect Value of Grace in Month" ;
							}
							grace_in_month_plus_one=Integer.parseInt(grace_in_month)+1;
						}
						catch(Exception e)
						{
							return "Error~"+"Incorrect Value of Grace in Month" ;
						}
						
						parser.changeValue("GraceInMonthFirstInner", "R_START + "+grace_in_month_plus_one+"M");
						
						logger.info("InstallmentFrequency after change is "+frequency_value);
						parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
						
						
						String request=parser.toString();
						request=request.replace("DetailsLstFirst","DetailsLst");
						request=request.replace("DetailsLstFirstInner","DetailsLstItem");
						request=request.replace("DetailsLstSecond","DetailsLst");
						request=request.replace("DetailsLstSecondInner","DetailsLstItem");
						request=request.replace("DetailsLstInner","DetailsLstItem");
						
						request=request.replace("GraceInMonthFirstInner","GraceInMonth");
						request=request.replace("GraceInMonthSecondInner","GraceInMonth");
						
						request=request.replace("GracePeriodCapitalizationSecondInner","GracePeriodCapitalization");
						request=request.replace("GracePeriodCapitalizationFirstInner","GracePeriodCapitalization");
						
						
						request=request.replace("InstallmentTypeFirst","InstallmentType");
						request=request.replace("InstallmentFrequencyFirst","InstallmentFrequency");
						request=request.replace("InstallmentTypeSecond","InstallmentType");
						request=request.replace("InstallmentFrequencySecond","InstallmentFrequency");
						

						String reapproval_flag=(String) iformObj.getValue("REAPPROVAL_FLAG");
						if(reapproval_flag.equalsIgnoreCase("true"))
						{
							request=request.replaceAll("<LOSAppNum>[a-zA-Z0-9]*</LOSAppNum>","");
						}
						
						System.out.println("RequestXML for ContractSimulationMng is :\n" + request);
						logger.info("RequestXML is :\n" + parser.toString());
						responseXML = new SocketConnector().getSocketXMLResponse(request, callName,iformObj);
				
						System.out.println("Response XML is: \n" + responseXML);		
						
					}
					else
					{
						return "Error~"+"Installment Type can not be empty if Grace Period is No" ;
					}
				}
			}
			else if(grace_period_field.equalsIgnoreCase("No") || grace_period_field.equalsIgnoreCase("") || grace_period_zero_flag==true)
			{
				callName="ContractSimulationMng_Without_GP";
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
				

				for (String tag : tags) 
				{
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
					if (tagValue.startsWith("formid~")) {
						String value = (String) iformObj.getValue(tagValue.split("~")[1]);
						parser.changeValue(request_prefix+tag, value);
					}
					
				}
				
				String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
				int no_of_zeroes=16-cic_no.length();
				for(int i=0;i<no_of_zeroes;i++)
				{
					cic_no='0'+cic_no;
				}
				
				logger.info("CIC_No after appending zeroes are "+cic_no);
				parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
				parser.changeValue(request_prefix+"CICNum",cic_no);

				String customer_type=parser.getValueOf(request_prefix+"CustType");
				if(customer_type.equalsIgnoreCase("ARB POS Customer"))
					parser.changeValue(request_prefix+"CustType", "1");
				else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
					parser.changeValue(request_prefix+"CustType", "2");
				else if (customer_type.equalsIgnoreCase("ARB Non POS"))
					parser.changeValue(request_prefix+"CustType", "3");
				
				String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
				//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
				String frequency_value="";
				//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
				logger.info("InstallmentFrequency before change is "+frequency);
				if(frequency.equalsIgnoreCase("Monthly"))
				{
					frequency_value="e1m";
				}else if(frequency.equalsIgnoreCase("Quarterly"))
				{
					frequency_value="e3m";
				}else if(frequency.equalsIgnoreCase("Half-Yearly"))
				{
					frequency_value="e6m";
				}else if(frequency.equalsIgnoreCase("Annually"))
				{
					frequency_value="e12m";
				}
				
				
				frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
				parser.changeValue(request_prefix+"InstallmentFrequency",frequency_value);	
				logger.info("InstallmentFrequency after change is "+frequency_value);
				
				parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
				String request=parser.toString();
				
				String reapproval_flag=(String) iformObj.getValue("REAPPROVAL_FLAG");
				if(reapproval_flag.equalsIgnoreCase("true"))
				{
					request=request.replaceAll("<LOSAppNum>[a-zA-Z0-9]*</LOSAppNum>","");
				}
				
				System.out.println("RequestXML for ContractSimulationMng is :\n" + request);
				logger.info("RequestXML is :\n" + parser.toString());
				responseXML = new SocketConnector().getSocketXMLResponse(request, callName,iformObj);
		
				System.out.println("Response XML is: \n" + responseXML);
				 
			}
			//New Coding End
			
		}catch(Exception e)
		{
			
			logger.info("Exception occurred: createRequestXMLfor "+callName+" "+e.getStackTrace().toString());
			return "";
		}
	
		
		
		JSONObject ContractSimulation_obj = setResponseData_2(iformObj, callName, responseXML);
		logger.info("For contract stimulation object is :"+ContractSimulation_obj);
		String return_string="Success~Contract Simulation executed";

		for(Iterator iterator = ContractSimulation_obj.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			if(key.equalsIgnoreCase("Error"))
			{
				return_string="Error~"+ContractSimulation_obj.get(key).toString();
				return return_string ;
			}
			else
			{
				logger.info("Values set for"+key+" are "+ContractSimulation_obj.get(key).toString());
				setControlValue(iformObj, key, ContractSimulation_obj.get(key).toString());
			}
		}
		
		logger.info("From here we are executing generateAmmortization");
		return_string=generateAmmortization(iformObj, stringdata);
		return return_string ;
	}

	private String CallContractSimulationChild(IFormReference iformObj, String stringdata) 
	{
		String callName = ""; //For contract sulation in application data
		String responseXML = "";// 
		try
		{
			//New Coding Start
			String grace_period_field="",grace_period_captilaization="",tenure="",installment_type="";
			/*
			String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
			String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
			String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
			String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
			String tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
			String requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
			
			if(requested_amt==null || requested_amt=="")
			{
				requested_amt="0";
			}
			
			//double admin_Fees_rate=0,admin_Fees_vat_per=0,admin_fees=0,vat,broker_fees_vat,total_admin_fees=0,total_broker_fees=0,max_fees_amount=0,broker_fees=0;
			String query="SELECT GRACE_PERIOD,GRACE_PERIOD_CAPITALIZATION FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_tenure>='"+tenure+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+" ";
			List<List<String>> result=iformObj.getDataFromDB(query);
			if(result.size()>0)
			{
				if(result.get(0).size()>0)
				{
					grace_period_field=result.get(0).get(0);
					grace_period_captilaization=result.get(0).get(0);
				}
			}
			*/
			grace_period_field=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_PERIOD");
			grace_period_captilaization=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_PRD_CAPITALIZATION");
			tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
			installment_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TYPE_OF_INSTALLMENT");
			String grace_in_month=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH");
			boolean grace_period_zero_flag=false;
			try
			{
				if(Integer.parseInt(grace_in_month)==0)
				{
					grace_period_zero_flag=true;
				}
			}
			catch(Exception e)
			{
				grace_period_zero_flag=true;
			}
			if(grace_period_field.equalsIgnoreCase("Yes") && grace_period_zero_flag==false )
			{
				if(grace_period_captilaization.equalsIgnoreCase("Yes"))
				{
					callName="ContractSimulationMngChild_With_GP_With_Capitalization";
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
					

					for (String tag : tags) 
					{
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
						if (tagValue.startsWith("formid~")) {
							String value = (String) iformObj.getValue(tagValue.split("~")[1]);
							parser.changeValue(request_prefix+tag, value);
							
						}
						
					}
					
					String los_app_num = (String) iformObj.getValue("LOS_APP_NUM");
					logger.info("los_app_num =="+los_app_num);
					parser.changeValue(request_prefix+"LOSAppNum",los_app_num.concat("-001"));
					
					String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
					int no_of_zeroes=16-cic_no.length();
					for(int i=0;i<no_of_zeroes;i++)
					{
						cic_no='0'+cic_no;
					}
					
					logger.info("CIC_No after appending zeroes are "+cic_no);
					parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
					parser.changeValue(request_prefix+"CICNum",cic_no);

					String customer_type=parser.getValueOf(request_prefix+"CustType");
					if(customer_type.equalsIgnoreCase("ARB POS Customer"))
						parser.changeValue(request_prefix+"CustType", "1");
					else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
						parser.changeValue(request_prefix+"CustType", "2");
					else if (customer_type.equalsIgnoreCase("ARB Non POS"))
						parser.changeValue(request_prefix+"CustType", "3");
					
					String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
					//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
					String frequency_value="";
					//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
					logger.info("InstallmentFrequency before change is "+frequency);
					if(frequency.equalsIgnoreCase("Monthly"))
					{
						frequency_value="e1m";
					}else if(frequency.equalsIgnoreCase("Quarterly"))
					{
						frequency_value="e3m";
					}else if(frequency.equalsIgnoreCase("Half-Yearly"))
					{
						frequency_value="e6m";
					}else if(frequency.equalsIgnoreCase("Annually"))
					{
						frequency_value="e12m";
					}
					
					parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
					
					frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
					parser.changeValue(request_prefix+"InstallmentFrequency",frequency_value);	
					logger.info("InstallmentFrequency after change is "+frequency_value);
					
					grace_in_month=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH");
				
					logger.info("Request xml upto point 1 is "+parser.toString());
				
					parser.changeValue("GracePeriodCapitalizationFirst", "R_START + "+grace_in_month+"M");
					
					logger.info("Request xml upto point 2 is "+parser.toString());
					
					int grace_in_month_plus_one;
					try
					{
						if(Integer.parseInt(grace_in_month)<=0)
						{
							return "Error~"+"Incorrect Value of Grace in Month" ;
						}
						grace_in_month_plus_one=Integer.parseInt(grace_in_month)+1;
					}
					catch(Exception e)
					{
						return "Error~"+"Incorrect Value of Grace in Month" ;
					}
					
					logger.info("Request xml upto point 3 is "+parser.toString());
					
					parser.changeValue("GraceInMonthLast", "R_START + "+grace_in_month_plus_one+"M");
					
					String request=parser.toString();
					//request=request.replace("DetailsLstOuter","DetailsLst");
					
					request=request.replace("DetailsLstInnerFirst","DetailsLstItem");
					request=request.replace("DetailsLstInnerLast","DetailsLstItem");
					request=request.replace("GraceInMonthFirst","GraceInMonth");
					request=request.replace("GraceInMonthLast","GraceInMonth");
					request=request.replace("GracePeriodCapitalizationFirst","GracePeriodCapitalization");
					request=request.replace("GracePeriodCapitalizationSecond","GracePeriodCapitalization");
					

					System.out.println("RequestXML for ContractSimulationMng is :\n" + request);
					logger.info("RequestXML is :\n" + parser.toString());
					responseXML = new SocketConnector().getSocketXMLResponse(request, callName,iformObj);
			
					System.out.println("Response XML is: \n" + responseXML);				
				}
				else
				{
					if(installment_type.equalsIgnoreCase("Without Payment"))
					{
						callName="ContractSimulationMngChild_With_GP_Without_Payment";
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
				
						logger.info("Now we will read dummy request");
						String requestXML = readDummyRequest(callName);
						logger.info("Dummy read is success");
						XMLParser parser = new XMLParser(requestXML);
						

						for (String tag : tags) 
						{
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
							if (tagValue.startsWith("formid~")) {
								String value = (String) iformObj.getValue(tagValue.split("~")[1]);
								parser.changeValue(request_prefix+tag, value);
							}
							
						}
						
						String los_app_num = (String) iformObj.getValue("LOS_APP_NUM");
						logger.info("los_app_num =="+los_app_num);
						parser.changeValue(request_prefix+"LOSAppNum",los_app_num.concat("-001"));
						
						String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
						int no_of_zeroes=16-cic_no.length();
						for(int i=0;i<no_of_zeroes;i++)
						{
							cic_no='0'+cic_no;
						}
						
						logger.info("CIC_No after appending zeroes are "+cic_no);
						parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
						parser.changeValue(request_prefix+"CICNum",cic_no);

						String customer_type=parser.getValueOf(request_prefix+"CustType");
						if(customer_type.equalsIgnoreCase("ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "1");
						else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "2");
						else if (customer_type.equalsIgnoreCase("ARB Non POS"))
							parser.changeValue(request_prefix+"CustType", "3");
						

						String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
						//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
						String frequency_value="";
						//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
						logger.info("InstallmentFrequency before change is "+frequency);
						if(frequency.equalsIgnoreCase("Monthly"))
						{
							frequency_value="e1m";
						}else if(frequency.equalsIgnoreCase("Quarterly"))
						{
							frequency_value="e3m";
						}else if(frequency.equalsIgnoreCase("Half-Yearly"))
						{
							frequency_value="e6m";
						}else if(frequency.equalsIgnoreCase("Annually"))
						{
							frequency_value="e12m";
						}
						
						
						frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
						parser.changeValue(request_prefix+"InstallmentFrequency",frequency_value);	
						logger.info("InstallmentFrequency after change is "+frequency_value);
						
						 grace_in_month=parser.getValueOf(request_prefix+"GraceInMonth");
						try
						{
							Integer month=Integer.parseInt(grace_in_month)+1;
							String tag_grace_in_month="R_START + "+month.toString()+"M";
							parser.changeValue(request_prefix+"GraceInMonth", tag_grace_in_month);
						}
						catch(Exception e)
						{
							return "Error~"+"Incorrect Value of Grace in Month" ;
						}

						parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
						
						System.out.println("RequestXML for ContractSimulationMng is :\n" + parser.toString());
						logger.info("RequestXML is :\n" + parser.toString());
						responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
				
						System.out.println("Response XML is: \n" + responseXML);
						
					}
					else if(installment_type.equalsIgnoreCase("Only Profit"))
					{
						callName="ContractSimulationMngChild_With_GP_With_Int_Payment";
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
						

						for (String tag : tags) 
						{
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
							if (tagValue.startsWith("formid~")) {
								String value = (String) iformObj.getValue(tagValue.split("~")[1]);
								parser.changeValue(request_prefix+tag, value);
							}
							
						}
						
						String los_app_num = (String) iformObj.getValue("LOS_APP_NUM");
						logger.info("los_app_num =="+los_app_num);
						parser.changeValue(request_prefix+"LOSAppNum",los_app_num.concat("-001"));
						
						String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
						int no_of_zeroes=16-cic_no.length();
						for(int i=0;i<no_of_zeroes;i++)
						{
							cic_no='0'+cic_no;
						}
						
						logger.info("CIC_No after appending zeroes are "+cic_no);
						parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
						parser.changeValue(request_prefix+"CICNum",cic_no);

						String customer_type=parser.getValueOf(request_prefix+"CustType");
						if(customer_type.equalsIgnoreCase("ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "1");
						else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
							parser.changeValue(request_prefix+"CustType", "2");
						else if (customer_type.equalsIgnoreCase("ARB Non POS"))
							parser.changeValue(request_prefix+"CustType", "3");
						
						String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
						//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
						String frequency_value="";
						//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
						logger.info("InstallmentFrequency before change is "+frequency);
						if(frequency.equalsIgnoreCase("Monthly"))
						{
							frequency_value="e1m";
						}else if(frequency.equalsIgnoreCase("Quarterly"))
						{
							frequency_value="e3m";
						}else if(frequency.equalsIgnoreCase("Half-Yearly"))
						{
							frequency_value="e6m";
						}else if(frequency.equalsIgnoreCase("Annually"))
						{
							frequency_value="e12m";
						}
						
						
						frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
						parser.changeValue(request_prefix+"InstallmentFrequencyFirst",frequency_value);
						parser.changeValue(request_prefix+"InstallmentFrequencySecond",frequency_value);
						
						
						grace_in_month=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_GRACE_IN_MONTH");
						
						parser.changeValue("GracePeriodCapitalizationSecondInner", "R_START + "+grace_in_month+"M");
						
						int grace_in_month_plus_one;
						try
						{
							if(Integer.parseInt(grace_in_month)<=0)
							{
								return "Error~"+"Incorrect Value of Grace in Month" ;
							}
							grace_in_month_plus_one=Integer.parseInt(grace_in_month)+1;
						}
						catch(Exception e)
						{
							return "Error~"+"Incorrect Value of Grace in Month" ;
						}
						
						parser.changeValue("GraceInMonthFirstInner", "R_START + "+grace_in_month_plus_one+"M");
						
						logger.info("InstallmentFrequency after change is "+frequency_value);
						parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
						
						
						String request=parser.toString();
						request=request.replace("DetailsLstFirst","DetailsLst");
						request=request.replace("DetailsLstFirstInner","DetailsLstItem");
						request=request.replace("DetailsLstSecond","DetailsLst");
						request=request.replace("DetailsLstSecondInner","DetailsLstItem");
						request=request.replace("DetailsLstInner","DetailsLstItem");
						
						request=request.replace("GraceInMonthFirstInner","GraceInMonth");
						request=request.replace("GraceInMonthSecondInner","GraceInMonth");
						
						request=request.replace("GracePeriodCapitalizationSecondInner","GracePeriodCapitalization");
						request=request.replace("GracePeriodCapitalizationFirstInner","GracePeriodCapitalization");
						
						
						request=request.replace("InstallmentTypeFirst","InstallmentType");
						request=request.replace("InstallmentFrequencyFirst","InstallmentFrequency");
						request=request.replace("InstallmentTypeSecond","InstallmentType");
						request=request.replace("InstallmentFrequencySecond","InstallmentFrequency");
						
						
						System.out.println("RequestXML for ContractSimulationMng is :\n" + request);
						logger.info("RequestXML is :\n" + parser.toString());
						responseXML = new SocketConnector().getSocketXMLResponse(request, callName,iformObj);
				
						System.out.println("Response XML is: \n" + responseXML);		
						
					}
					else
					{
						return "Error~"+"Installment Type can not be empty if Grace Period is No" ;
					}
				}
			}
			else if(grace_period_field.equalsIgnoreCase("No") || grace_period_field.equalsIgnoreCase("") || grace_period_zero_flag==true)
			{ 
				callName="ContractSimulationMngChild_Without_GP";
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
				

				for (String tag : tags) 
				{
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
					if (tagValue.startsWith("formid~")) {
						String value = (String) iformObj.getValue(tagValue.split("~")[1]);
						parser.changeValue(request_prefix+tag, value);
					}
					
				}
				
				String los_app_num = (String) iformObj.getValue("LOS_APP_NUM");
				logger.info("los_app_num =="+los_app_num);
				parser.changeValue(request_prefix+"LOSAppNum",los_app_num.concat("-001"));
				
				String cic_no=parser.getValueOf(request_prefix+"alr1:CICNum");
				int no_of_zeroes=16-cic_no.length();
				for(int i=0;i<no_of_zeroes;i++)
				{
					cic_no='0'+cic_no;
				}
				
				logger.info("CIC_No after appending zeroes are "+cic_no);
				parser.changeValue(request_prefix+"alr1:CICNum",cic_no);
				parser.changeValue(request_prefix+"CICNum",cic_no);

				String customer_type=parser.getValueOf(request_prefix+"CustType");
				if(customer_type.equalsIgnoreCase("ARB POS Customer"))
					parser.changeValue(request_prefix+"CustType", "1");
				else if(customer_type.equalsIgnoreCase("Non-ARB POS Customer"))
					parser.changeValue(request_prefix+"CustType", "2");
				else if (customer_type.equalsIgnoreCase("ARB Non POS"))
					parser.changeValue(request_prefix+"CustType", "3");
				
				String frequency=getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_FREQUENCY");
				//String no_of_installments=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_NO_OF_INSTALLMENT");
				String frequency_value="";
				//parser.changeValue(request_prefix+"InstallmentFrequency","e"+no_of_installments+"M");
				logger.info("InstallmentFrequency before change is "+frequency);
				if(frequency.equalsIgnoreCase("Monthly"))
				{
					frequency_value="e1m";
				}else if(frequency.equalsIgnoreCase("Quarterly"))
				{
					frequency_value="e3m";
				}else if(frequency.equalsIgnoreCase("Half-Yearly"))
				{
					frequency_value="e6m";
				}else if(frequency.equalsIgnoreCase("Annually"))
				{
					frequency_value="e12m";
				}
				
				
				frequency_value="e0Y "+frequency_value+" e0W e0D e0F";
				parser.changeValue(request_prefix+"InstallmentFrequency",frequency_value);	
				logger.info("InstallmentFrequency after change is "+frequency_value);
				
				parser.changeValue(request_prefix+"FinanceTenure",tenure+"M");
				
				System.out.println("RequestXML for ContractSimulationMng is :\n" + parser.toString());
				logger.info("RequestXML is :\n" + parser.toString());
				responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
		
				System.out.println("Response XML is: \n" + responseXML);
				 
			}
			//New Coding End
			
		}catch(Exception e)
		{
			
			logger.info("Exception occurred: createRequestXMLfor ContractSimulationMng "+e.getStackTrace().toString());
			return "";
		}

		
		JSONObject ContractSimulation_obj = setResponseData_2(iformObj, callName, responseXML);
		logger.info("For contract stimulation object is :"+ContractSimulation_obj);
		String return_string="Success~Contract Simulation executed";

		for(Iterator iterator = ContractSimulation_obj.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			if(key.equalsIgnoreCase("Error"))
			{
				return_string="Error~"+ContractSimulation_obj.get(key).toString();
				return return_string ;
			}
			else
			{
				logger.info("Values set for"+key+" are "+ContractSimulation_obj.get(key).toString());
				setControlValue(iformObj, key, ContractSimulation_obj.get(key).toString());
			}
		}
		logger.info("From here we are executing generateAmmortization");
		return_string=generateAmmortizationChild(iformObj, stringdata);
		return return_string ;
	}

	private String CallRepaymntAccCreation(IFormReference iformObj, String stringdata) {
		// TODO Auto-generated method stub
		// ======= MSB Acc Mng call starts
		String callName = "MSBAcctMng"; //For ammortization details
		String responseXML = createRequestXML(iformObj, callName);
		
		/*JSONObject MSBAcctMng_obj = setResponseData(iformObj, callName, responseXML);
		for(Iterator iterator = MSBAcctMng_obj.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			logger.info("Values set for"+key+" are "+MSBAcctMng_obj.get(key).toString());
			setControlValue(iformObj, key, MSBAcctMng_obj.get(key).toString());
		}
		*/
		
		JSONObject MSBAcctMng_obj = setResponseData_2(iformObj, callName, responseXML);
		logger.info("For CallRepaymntAccCreation object is :"+MSBAcctMng_obj);
		String return_string="Success~MSBAcctMng_obj executed";

		for(Iterator iterator = MSBAcctMng_obj.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			if(key.equalsIgnoreCase("Error"))
			{
				return_string="Error~"+MSBAcctMng_obj.get(key).toString();
			}
			else
			{
				logger.info("Values set for"+key+" are "+MSBAcctMng_obj.get(key).toString());
				setControlValue(iformObj, key, MSBAcctMng_obj.get(key).toString());
			}
		}
		return return_string;
	}
	
	/*
	private String CallMSBLimitMng(IFormReference iformObj, String stringdata) {
		// TODO Auto-generated method stub
		// ======= MSB Limit Mng call starts
		// ======= MSB Limit Mng call starts
		String callName = "MSBLimitMng"; //For ammortization details
		String responseXML = createRequestXML_2(iformObj, callName);
		JSONObject MSBLimitMng_obj = setResponseData(iformObj, callName, responseXML);
		for(Iterator iterator = MSBLimitMng_obj.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			logger.info("Values set for"+key+" are "+MSBLimitMng_obj.get(key).toString());
			setControlValue(iformObj, key, MSBLimitMng_obj.get(key).toString());
		}
		return "Calling MSB Limit Mng";
	}
	
	
	
	private String CallMSBLimitInq(IFormReference iformObj, String stringdata) {
		// TODO Auto-generated method stub
		// ======= MSB Limit Inq call starts
		logger.info("Code for MSBLimitInq starts here");
		String callName = "MSBLimitInq";
		String responseXML = createRequestXML_2(iformObj, callName);
		JSONObject MSBLimit_obj = setResponseDataGrid(iformObj, callName, responseXML);
		List<String> cleared_list = new ArrayList<String>();
		for (Iterator iterator = MSBLimit_obj.keySet().iterator(); iterator.hasNext();) {
		String key = (String) iterator.next();
		logger.info("Key for CallMSBLimitInq table is " + key + "and value is" + MSBLimit_obj.get(key));
		if (!cleared_list.contains(key)) {
			iformObj.clearTable(key);
			cleared_list.add(key);
		}
		iformObj.addDataToGrid(key, (JSONArray) MSBLimit_obj.get(key));
		}
		return "Calling MSB Limit Inq";
	}
	*/
	private String generateAmmortization(IFormReference iformObj, String stringdata) 
	{
				
		logger.info("Inside generateAmmortization function");
		String callName = "ContractAmortizationInq"; //For ammortization details
		String ResponseXML = createRequestXML(iformObj, callName);
		//JSONObject return_obj=new JSONObject();
		
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
			iformObj.clearTable(tags[tags.length-1]);
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(ResponseXML);
			logger.info("objWFxmlResponse value is "+objWFxmlResponse);

			JSONArray jsonarr=new JSONArray();
			
			logger.info("Status codes are"+status_code_split[0]+"and"+status_code_split[1]);
			String status_code_in_response=objWFxmlResponse.getVal(status_code_split[0]);
			String error_description=objWFxmlResponse.getVal("StatusDesc");
			logger.info("Value of status tag in response is"+status_code_in_response);
			
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
						if(hash_split_values[0].equalsIgnoreCase("Installment Date (DD-MM-YYYY)"))
						{
							SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
							SimpleDateFormat outputFormatter=new SimpleDateFormat("dd-MM-yyyy");
							try {
								Date installment_date_date = (Date)inputFormatter.parse(result_from_response);
								String result_installment_date=outputFormatter.format(installment_date_date);
								result_from_response=result_installment_date;
								} 
							catch (java.text.ParseException e) 
							{
								logger.info("Exception occurred: generateAmmortization ");
								result_from_response=WFXmlList.getVal(hash_split_values[1]);
								e.printStackTrace();
							}
						}
						else if(hash_split_values[0].equalsIgnoreCase("Installment Date (Hijri)"))
						{
							SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
							SimpleDateFormat outputFormatter=new SimpleDateFormat("dd-MM-yyyy");
							try {
								Date installment_date_date = (Date)inputFormatter.parse(result_from_response);
								String result_installment_date=outputFormatter.format(installment_date_date);
								result_from_response=result_installment_date;
								} 
							catch (java.text.ParseException e) 
							{
								logger.info("Exception occurred: generateAmmortization ");
								result_from_response=WFXmlList.getVal(hash_split_values[1]);
								e.printStackTrace();
							}
						}
						else if(hash_split_values[0].equalsIgnoreCase("Outstanding Balance"))
						{
							result_from_response=WFXmlList.getVal(hash_split_values[1]).replaceAll("-","");
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
						else if(hash_split_values[0].equalsIgnoreCase("Profit") || hash_split_values[0].equalsIgnoreCase("Installment Amount") || hash_split_values[0].equalsIgnoreCase("Principal"))
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
						else if(result_from_response.equals(null) || result_from_response.equals(""))
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
				logger.info(jsonobj);
				jsonarr.add(jsonobj);
			}
			logger.info("Final json array that we are setting in installment detail grid is "+jsonarr);
			iformObj.addDataToGrid(tags[tags.length-1], jsonarr);
			}
			else
			{
				logger.info("For "+callName+" Status code returned from response is not success ");
				return "Error~In "+callName+" error received with error code "+status_code_in_response+"-"+error_description;
			}
			
			}
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: setResponseDataGrid "+e);
		}
		
		try {
			iformObj.clearTable("STANDING_INSTRUCT_GRID");
			String disbursal = (String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_DISBURSAL_ACC_NO");
			String amount = (String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_INSTALLMENT_AMNT");
			amount=String.format("%.2f", Double.parseDouble(amount));
			JSONArray jsonarr2 = iformObj.getDataFromGrid("Q_NG_POS_INSTALMENT_DETAILS_GRID");
			String strt_date="";
			String end_date="";
			if(jsonarr2.size() > 0) {
				JSONObject jsonobj2 = (JSONObject) jsonarr2.get(0);
				strt_date = (String) jsonobj2.get("Installment Date (DD-MM-YYYY)");
				logger.info("from_date: "+ strt_date);
				JSONObject jsonobj3 = (JSONObject) jsonarr2.get((jsonarr2.size()-1));
				end_date = (String) jsonobj3.get("Installment Date (DD-MM-YYYY)");
				logger.info("to_date: "+ end_date);
			}
			String[] from_date = strt_date.split("-");
			String[] to_date = end_date.split("-");
			strt_date = from_date[0]+"/"+from_date[1]+"/"+from_date[2];
			end_date = to_date[0]+"/"+to_date[1]+"/"+to_date[2];
			
				JSONArray jsonArr = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("SSI Bank", "Al Rajhi Bank");
				jsonObj.put("Component", "EMI");
				jsonObj.put("Account Number", disbursal);
				jsonObj.put("From Date", strt_date);
				jsonObj.put("To Date", end_date);
				jsonObj.put("Amount", amount);

				logger.info("Json Array is" + jsonObj);
				jsonArr.add(jsonObj);
				
				iformObj.addDataToGrid("STANDING_INSTRUCT_GRID", jsonArr);
			}
			catch(Exception e)
			{
				logger.info("Exception occurred: standingInstrution "+e);
			}
			

		
		//iformObj.addDataToGrid(return_obj.g, evidence_code_obj_array);
		
		return "Success~Ammortization details generated successfully";
		
	}
	
	private String generateAmmortizationChild(IFormReference iformObj, String stringdata) {
		
		logger.info("Inside generateAmmortization function");
		String callName = "ContractAmortizationInqChild"; //For ammortization details
		String ResponseXML = createRequestXML(iformObj, callName);
		//JSONObject return_obj=new JSONObject();
		
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
			iformObj.clearTable(tags[tags.length-1]);
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(ResponseXML);
			logger.info("objWFxmlResponse value is "+objWFxmlResponse);

			JSONArray jsonarr=new JSONArray();
			
			logger.info("Status codes are"+status_code_split[0]+"and"+status_code_split[1]);
			String status_code_in_response=objWFxmlResponse.getVal(status_code_split[0]);
			String error_description=objWFxmlResponse.getVal("StatusDesc");
			logger.info("Value of status tag in response is"+status_code_in_response);
			
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
						if(hash_split_values[0].equalsIgnoreCase("Installment Date (DD-MM-YYYY)"))
						{
							SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
							SimpleDateFormat outputFormatter=new SimpleDateFormat("dd-MM-yyyy");
							try {
								Date installment_date_date = (Date)inputFormatter.parse(result_from_response);
								String result_installment_date=outputFormatter.format(installment_date_date);
								result_from_response=result_installment_date;
								} 
							catch (java.text.ParseException e) 
							{
								logger.info("Exception occurred: generateAmmortization ");
								result_from_response=WFXmlList.getVal(hash_split_values[1]);
								e.printStackTrace();
							}
						}
						else if(hash_split_values[0].equalsIgnoreCase("Installment Date (Hijri)"))
						{
							SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
							SimpleDateFormat outputFormatter=new SimpleDateFormat("dd-MM-yyyy");
							try {
								Date installment_date_date = (Date)inputFormatter.parse(result_from_response);
								String result_installment_date=outputFormatter.format(installment_date_date);
								result_from_response=result_installment_date;
								} 
							catch (java.text.ParseException e) 
							{
								logger.info("Exception occurred: generateAmmortization ");
								result_from_response=WFXmlList.getVal(hash_split_values[1]);
								e.printStackTrace();
							}
						}
						else if(hash_split_values[0].equalsIgnoreCase("Outstanding Balance"))
						{
							result_from_response=WFXmlList.getVal(hash_split_values[1]).replaceAll("-","");
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
						else if(hash_split_values[0].equalsIgnoreCase("Profit") || hash_split_values[0].equalsIgnoreCase("Installment Amount") || hash_split_values[0].equalsIgnoreCase("Principal"))
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
						else if(result_from_response.equals(null) || result_from_response.equals(""))
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
				logger.info(jsonarr);
				jsonarr.add(jsonobj);
			}
			logger.info("Final json array that we are setting in installment detail grid is "+jsonarr);
			iformObj.addDataToGrid(tags[tags.length-1], jsonarr);
			}
			else
			{
				logger.info("For "+callName+" Status code returned from response is not success ");
				return "Error~In "+callName+" error received with error code "+status_code_in_response+"-"+error_description;
			}
			
			}
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: setResponseDataGrid "+e);
		}
		//iformObj.addDataToGrid(return_obj.g, evidence_code_obj_array);
		
		return "Success~Ammortization details generated successfully";
		
	}
	
	private String calculateProfitPercentage(IFormReference iformObj, String stringdata) {
		String result_string="";
		try
		{
			String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
			String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
			String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
			String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
			String tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
			String requested_amt=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQ_AMNT_SAR");
			
			if(requested_amt==null || requested_amt=="")
			{
				requested_amt="0";
			}
			
			double admin_Fees_rate=0,admin_Fees_vat_per=0,admin_fees=0,vat,broker_fees_vat,total_admin_fees=0,total_broker_fees=0,max_fees_amount=0,broker_fees=0;
			String query="SELECT DEF_PROFIT_RATE,RATE,VAT_PER,MAX_FEES_AMOUNT,BROKER_FEE FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_tenure>='"+tenure+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+" ";
			logger.info("Query to calculate profit percentage is "+query);
			List<List<String>> returned_result = iformObj.getDataFromDB(query);
			if(returned_result.size()>0 && returned_result.get(0).size()==5)
			{
				//setControlValue(iformObj,"Q_NG_POS_APPLICATION_DATA_PROFIT", returned_result.get(0).get(0));
				iformObj.setValue("Q_NG_POS_APPLICATION_DATA_PROFIT", returned_result.get(0).get(0));
				iformObj.setValue("Q_NG_POS_APPLICATION_DATA_PROPOSED_PROFIT", returned_result.get(0).get(0));
				admin_Fees_rate= Double.parseDouble(returned_result.get(0).get(1));
				admin_Fees_vat_per=Double.parseDouble(returned_result.get(0).get(2));
				max_fees_amount=Double.parseDouble(returned_result.get(0).get(3));
				broker_fees=Double.parseDouble(returned_result.get(0).get(4));
				logger.info("Setting Profit percentage, fees rate, fees vat and broker fees as :  "+returned_result.get(0).get(0)+", "+returned_result.get(0).get(1)+", "+returned_result.get(0).get(2)+","+returned_result.get(0).get(4));
				result_string= returned_result.get(0).get(0);
			}
			else
			{
				return "Error~No Scheme Available";
			}
		
			if(result_string.equalsIgnoreCase(""))
			{
				iformObj.setValue("Q_NG_POS_APPLICATION_DATA_PROFIT","0");
			}
			
			setControlValue(iformObj,"ADMIN_FEES_RATE", Double.toString(admin_Fees_rate));
			logger.info("Setting Profit ADMIN_FEES_RATE as "+Double.toString(admin_Fees_rate));
			setControlValue(iformObj,"ADMIN_FEES_VAT_PERC",	Double.toString(admin_Fees_vat_per) );
			logger.info("Setting Profit ADMIN_FEES_VAT_PERC as "+Double.toString(admin_Fees_vat_per));
			admin_fees=Double.parseDouble(requested_amt)*admin_Fees_rate/100;//75000
			if(admin_fees>=max_fees_amount)
				admin_fees=max_fees_amount;
			
			vat=admin_fees*admin_Fees_vat_per/100;
			total_admin_fees=admin_fees+vat;
			logger.info("Setting total admin fees as "+total_admin_fees);
			if(total_admin_fees!=0)
				setControlValue(iformObj,"ADMIN_FEES",String.format("%.2f",admin_fees) );
			else
				setControlValue(iformObj,"ADMIN_FEES","0" );
			
			if(broker_fees!=0)
				setControlValue(iformObj,"BROKER_FEES",String.format("%.2f",broker_fees) );
			else
				setControlValue(iformObj,"BROKER_FEES","0" );
			

			broker_fees_vat=broker_fees*15/100;
			total_broker_fees=broker_fees+broker_fees_vat;
			logger.info("Setting total broker fees as "+total_broker_fees);
			if(total_admin_fees!=0)
				setControlValue(iformObj,"ADMIN_FEES",String.format("%.2f",admin_fees) );
			else
				setControlValue(iformObj,"ADMIN_FEES","0" );
			
			iformObj.clearTable("FEES_CHRGD_GRID");
			JSONObject fees_grid_object=new JSONObject();
			JSONArray fees_grid_array=new JSONArray();
			fees_grid_object.put("Fees Name","Admin fees");
			fees_grid_object.put("Fees Method","With Disbursal");
			fees_grid_object.put("Fees Type ","Rate");
			fees_grid_object.put("Fees %",String.format("%.2f",admin_Fees_rate)); 
			fees_grid_object.put("Fees Amount",String.format("%.2f",admin_fees)); 
			fees_grid_object.put("VAT on Fees",String.format("%.2f",vat)); 
			fees_grid_object.put("Total Fees",String.format("%.2f",total_admin_fees)); 
			fees_grid_object.put("Default Admin Fee Rate",String.format("%.2f",admin_Fees_rate));
			fees_grid_array.add(fees_grid_object);
			logger.info("Fee charged array is "+fees_grid_array);
			
			fees_grid_object=new JSONObject();
			fees_grid_object.put("Fees Name","Broker fees");
			fees_grid_object.put("Fees Method","With Disbursal");
			fees_grid_object.put("Fees Type ","Fixed"); 
			fees_grid_object.put("Fees %",""); 
			fees_grid_object.put("Fees Amount",String.format("%.2f",broker_fees)); 
			fees_grid_object.put("VAT on Fees",String.format("%.2f",broker_fees_vat));
			fees_grid_object.put("Total Fees",String.format("%.2f",total_broker_fees)); 
			fees_grid_array.add(fees_grid_object);
			
			iformObj.addDataToGrid("FEES_CHRGD_GRID", fees_grid_array);
			logger.info("Fee charged array is "+fees_grid_array);
			
			
			//listview mein disable
			
			/*
			String los_app_num=getWorkitemName(iformObj);
		    los_app_num=los_app_num.substring(4,los_app_num.length() - 4);
		    los_app_num=los_app_num.replaceFirst("^0+(?!$)","");
		    int no_of_zeroes=10-los_app_num.length();
		    for(int i=0;i<no_of_zeroes;i++)
			{
		    	los_app_num='0'+los_app_num;
		    }
		    
		    logger.info("Setting LOS Application no as "+los_app_num);
			setControlValue(iformObj,"LOS_APPLICATION_NO",los_app_num);
			*/
		
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: calculateProfitPercentage: with stack trace "+e);
		}
		/*
		try
		{
			String disbursal = (String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_DISBURSAL_ACC_NO");
			String amount = (String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_INSTALLMENT_AMNT");
			JSONArray jsonarr2 = iformObj.getDataFromGrid("Q_NG_POS_INSTALMENT_DETAILS_GRID");
			String strt_date="";
			String end_date="";
			if(jsonarr2.size() > 0) 
			{
				JSONObject jsonobj2 = (JSONObject) jsonarr2.get(0);
				strt_date = (String) jsonobj2.get("Installment Date");
				logger.info("from_date: "+ strt_date);
				JSONObject jsonobj3 = (JSONObject) jsonarr2.get((jsonarr2.size()-1));
				end_date = (String) jsonobj3.get("Installment Date");
				logger.info("to_date: "+ end_date);
			}
			String[] from_date = strt_date.split("-");
			String[] to_date = end_date.split("-");
			strt_date = from_date[2]+"/"+from_date[1]+"/"+from_date[0];
			end_date = to_date[2]+"/"+to_date[1]+"/"+to_date[0];
			
				JSONArray jsonArr = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("SSI Bank", "Al Rajhi Bank");
				jsonObj.put("Component", "EMI");
				jsonObj.put("Account Number", disbursal);
				jsonObj.put("From Date", strt_date);
				jsonObj.put("To Date", end_date);
				jsonObj.put("Amount", amount);
	
				logger.info("Json Array is" + jsonObj);
				jsonArr.add(jsonObj);
				
				iformObj.addDataToGrid("table62", jsonArr);
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: standingInstrution "+e);
		}
		*/
		return "Success~"+result_string;
	}
	
	private String calculateDisbursementAdminFee(IFormReference iformObj, String stringdata) {
		try
		{
			iformObj.clearTable("FEES_CHRGD_GRID_DISB");
			JSONArray fees_grid_original_Data_array= iformObj.getDataFromGrid("FEES_CHRGD_GRID");
			iformObj.addDataToGrid("FEES_CHRGD_GRID_DISB", fees_grid_original_Data_array);
			String admin_fees=(String)iformObj.getValue("ADMIN_FEES");
			String broker_fees=(String)iformObj.getValue("BROKER_FEES");
			setControlValue(iformObj,"ADMIN_FEES_DISB",admin_fees);
			setControlValue(iformObj,"BROKER_FEES_DISB",broker_fees);
			logger.info("Fee charged array in FEES_CHRGD_GRID_DISB is "+fees_grid_original_Data_array);
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: calculateProfitPercentage: with stack trace "+e);
		}
		return "Fees details grid filled for disbursement successfully";
	}
	
	/*
	private String calculateDisbursementAdminFee(IFormReference iformObj, String stringdata) {
		try
		{
			String product_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_PRODUCT_CATEGORY");
			String customer_category=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CUSTOMER_CATEGORY");
			String request_type=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_REQUEST_TYPE");
			String campaign=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_CAMPAIGN");
			String tenure=(String) iformObj.getValue("Q_NG_POS_APPLICATION_DATA_TENURE");
			String requested_amt=(String) iformObj.getValue("Q_NG_POS_DISBURSAL_DATA_DISBURSAL_AMT");
			
			if(requested_amt==null || requested_amt=="")
			{
				requested_amt="0";
			}
			
			double admin_Fees_rate=0,admin_Fees_vat_per=0,admin_fees=0,vat,broker_fees_vat,total_admin_fees=0,total_broker_fees=0,max_fees_amount=0,broker_fees=0;
			String query="SELECT DEF_PROFIT_RATE,RATE,VAT_PER,MAX_FEES_AMOUNT,BROKER_FEE FROM NG_MAST_POS_PRODUCT A,NG_MAST_POS_FEE B WHERE A.FeeID=B.Fees_ID AND a.CustCategoryID=b.Scheme_ID AND A.Product=(SELECT CODE FROM NG_MAST_PRODUCT WHERE PRODUCT_CATEGORY = '"+product_category+"') AND a.custcategoryID=(SELECT CODE FROM NG_MAST_CUSTOMER WHERE customer_CATEGORY = '"+customer_category+"') AND a.request_type='"+request_type+"' AND a.campaign='"+campaign+"' AND a.max_tenure>='"+tenure+"' AND a.max_amount>="+requested_amt+" AND a.min_amount<="+requested_amt+" ";
			logger.info("Query to calculate fees details for disbusement is "+query);
			List<List<String>> returned_result = iformObj.getDataFromDB(query);
			if(returned_result.size()>0 && returned_result.get(0).size()==5)
			{
				admin_Fees_rate= Double.parseDouble(returned_result.get(0).get(1));
				admin_Fees_vat_per=Double.parseDouble(returned_result.get(0).get(2));
				max_fees_amount=Double.parseDouble(returned_result.get(0).get(3));
				broker_fees=Double.parseDouble(returned_result.get(0).get(4));
				logger.info("Setting Profit percentage, fees rate, fees vat and broker fees is  :  "+returned_result.get(0).get(0)+", "+returned_result.get(0).get(1)+", "+returned_result.get(0).get(2)+","+returned_result.get(0).get(4));
			}
		
			admin_fees=Double.parseDouble(requested_amt)*admin_Fees_rate/100;//75000
			if(admin_fees>=max_fees_amount)
				admin_fees=max_fees_amount;
			vat=admin_fees*admin_Fees_vat_per/100;
			total_admin_fees=admin_fees+vat;
			logger.info("Setting total admin fees as "+total_admin_fees);
			if(total_admin_fees!=0)
				setControlValue(iformObj,"ADMIN_FEES_DISB",String.format("%.2f",admin_fees) );
			else
				setControlValue(iformObj,"ADMIN_FEES_DISB","0" );
			
			if(broker_fees!=0)
				setControlValue(iformObj,"BROKER_FEES_DISB",String.format("%.2f",broker_fees) );
			else
				setControlValue(iformObj,"BROKER_FEES_DISB","0" );
			
			
			broker_fees_vat=broker_fees*15/100;
			total_broker_fees=broker_fees+broker_fees_vat;
			logger.info("Setting total broker fees as "+total_broker_fees);
			if(total_admin_fees!=0)
				setControlValue(iformObj,"ADMIN_FEES",String.format("%.2f",admin_fees) );
			else
				setControlValue(iformObj,"ADMIN_FEES","0" );
			
			iformObj.clearTable("FEES_CHRGD_GRID_DISB");
			JSONObject fees_grid_object=new JSONObject();
			JSONArray fees_grid_array=new JSONArray();
			fees_grid_object.put("Fees Name","Admin fees");
			fees_grid_object.put("Fees Method","With Disbursal");
			fees_grid_object.put("Fees Type ","Rate");
			fees_grid_object.put("Fees %",admin_Fees_rate);
			fees_grid_object.put("Fees Amount",admin_fees);
			fees_grid_object.put("VAT on Fees",vat);
			fees_grid_object.put("Total Fees",total_admin_fees);
			fees_grid_array.add(fees_grid_object);
			
			
			fees_grid_object=new JSONObject();
			fees_grid_object.put("Fees Name","Broker fees");
			fees_grid_object.put("Fees Method","With Disbursal");
			fees_grid_object.put("Fees Type ","Fixed"); 
			fees_grid_object.put("Fees %",""); 
			fees_grid_object.put("Fees Amount",String.format("%.2f",broker_fees)); 
			fees_grid_object.put("VAT on Fees",String.format("%.2f",broker_fees_vat));
			fees_grid_object.put("Total Fees",String.format("%.2f",total_broker_fees)); 
			fees_grid_array.add(fees_grid_object);
			
			//iformObj.addDataToGrid("FEES_CHRGD_GRID", fees_grid_array);
			//logger.info("Fee charged array is "+fees_grid_array);
			
			iformObj.addDataToGrid("FEES_CHRGD_GRID_DISB", fees_grid_array);
			logger.info("Fee charged array in FEES_CHRGD_GRID_DISB is "+fees_grid_array);
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: calculateProfitPercentage: with stack trace "+e);
		}
		return "Fees details grid filled for disbursement successfully";
	}
	*/
	private String ConvertHijriDate(IFormReference iformObj, String stringdata) {
		logger.info("Inside covert hijri to Gr function with stringdata "+stringdata);
		String data_split[] = stringdata.split("#");
		String input_date = getControlValue(iformObj, data_split[0]);
		if( data_split[0].equalsIgnoreCase("table10599_BIRTH_DATE"))
		{
			logger.info("Inside if condition");
			String str = new String(input_date);
			String dateval = str.substring(6,8);
			String monthval = str.substring(4,6);
			String yearval = str.substring(0,4);
			input_date = dateval+monthval+yearval;
			logger.info(input_date);
		}
		String output_date="";
		logger.info("Input date without hash is "+input_date);
		if(input_date.length()>0)
		{
			if(input_date.length()==8)
				input_date = input_date.substring(0,2)+'/'+input_date.substring(2,4)+'/'+input_date.substring(4,8);
			//input_date=addHashtoDate(iformObj, input_date);
			logger.info("Input date with hash is "+input_date);
			Date input_formatted_date = null;
			try 
			{
				input_formatted_date = new SimpleDateFormat("dd/MM/yyyy").parse(input_date);
			}
			catch (java.text.ParseException e)
			{
				logger.info(" ConvertHijriDate Exception is" + e);
				e.printStackTrace();
			}
			output_date = convertHijriToGr(iformObj, input_formatted_date);
			logger.info("Output date with hash is "+output_date);
			setControlValue(iformObj, data_split[1], output_date);
		}
		
		return "Gr date set successfully and result is "+output_date;
	}

	private String fillSIMAHData(IFormReference iformObj, String stringdata) 
	{	
	 try
	 {
		logger.info("Inside fillSIMAHData function handling");
		String current_wi_name=getWorkitemName(iformObj);
		String padded_cic_no=(String) iformObj.getValue("PADDED_CIC_NO");
		logger.info("Current workstep name is "+current_wi_name+" and padded cic no is "+padded_cic_no);
		String query="SELECT WI_NAME,CHECKED_DATE FROM NG_POS_SIMAH_EXPIRY_CHECK WHERE CIC_NO='"+padded_cic_no+"' AND ISACTIVE='Y' ORDER BY CHECKED_DATE DESC ";
		List<List<String>> simah_details = iformObj.getDataFromDB(query);
		logger.info("Query to check SIMAH expiry is "+query+" and it's result is "+simah_details);
		// New Code for 60 days expiry check
		//LocalDateTime today_date=LocalDateTime.parse(new SimpleDateFormat().format(new Date()),DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		LocalDateTime today_date=LocalDateTime.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		logger.info("fillSIMAHData: Today's date is "+today_date);
		if(simah_details.size()>0)
		{	
			logger.info("In fillsimah data coming here because record is present in NG_POS_SIMAH_EXPIRY_CHECK");
			List<String> latest_cic_record=simah_details.get(0);
			String wi_name=latest_cic_record.get(0);
			String checked_date=latest_cic_record.get(1);
			
			LocalDateTime checked_date_obj = LocalDateTime.parse(checked_date,DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
			LocalDateTime date_after_30_days=checked_date_obj.plusDays(30);
			logger.info("Inside fillSIMAHData: Last checked date for cic_no "+padded_cic_no+" is "+checked_date_obj+ ", its 30 days later date is "+date_after_30_days+" and todays date is "+today_date);
			logger.info("Comparison of today date with 30 days after is "+today_date.compareTo(date_after_30_days));
			logger.info("Comparison of today date with 30 days after is "+date_after_30_days.compareTo(today_date));
			
			if(today_date.compareTo(date_after_30_days)>0)
			{
				logger.info("In fillsimah data coming here because today's date is greater than 30 days, hence hitting url to fetch SIMAH data");
				if(!wi_name.equalsIgnoreCase(current_wi_name))
				{		
						logger.info("In fillsimah data coming here because current winame is not equal to winame fetched from DB");	
						String callName = "RetrieveCommercialSummaryReport";
						String responseXML = createRequestXML(iformObj, callName);
						String cic_no="";
						JSONObject jsonobj = setResponseData_2(iformObj, callName, responseXML);
	
						for (Iterator iterator = jsonobj.keySet().iterator(); iterator.hasNext();) 
						{
							String key = (String) iterator.next();
							if (!jsonobj.get(key).toString().contains("#")) 
							{
								setControlValue(iformObj, key, jsonobj.get(key).toString());
							}
						}
						JSONObject return_obj = setResponseDataGrid(iformObj, callName, responseXML);
						for (Iterator iterator = return_obj.keySet().iterator(); iterator.hasNext();) 
						{
							String key = (String) iterator.next();
							iformObj.addDataToGrid(key, (JSONArray) return_obj.get(key));
						}
						logger.info("In fillsimah data, we fetched fresh record");
						
						//String enquiry_no=(String) jsonobj.get("Q_NG_POS_SIMAH_BASIC_DETAILS_ENQUIRY_NO");
						String reference_no=(String) jsonobj.get("Q_NG_POS_SIMAH_BASIC_DETAILS_REFERENCE_NO");
						
						//if(enquiry_no.trim().equalsIgnoreCase("") && reference_no.trim().equalsIgnoreCase(""))
						if(reference_no.trim().equalsIgnoreCase(""))
						{
							logger.info("but as no result came we are not inserting into NG_POS_SIMAH_EXPIRY_CHECK");
						}
						else
						{
							query="UPDATE NG_POS_SIMAH_EXPIRY_CHECK SET ISACTIVE='N' WHERE WI_NAME='"+wi_name+"' ";
							iformObj.saveDataInDB(query);
							logger.info("In fillsimah data, query to update for old workitem into NG_POS_SIMAH_EXPIRY_CHECK is "+query);	
							
							query="INSERT INTO NG_POS_SIMAH_EXPIRY_CHECK (WI_NAME,CIC_NO,CHECKED_DATE) VALUES ('"+current_wi_name+"','"+padded_cic_no+"', getdate()  )";
							iformObj.saveDataInDB(query);
							logger.info("In fillsimah data, query to insert into NG_POS_SIMAH_EXPIRY_CHECK is "+query);	 
						}	
						
				}
				else
				{
					logger.info("Clearing tables to override data");
					
					iformObj.setValue("Q_NG_POS_SIMAH_BASIC_DETAILS_REFERENCE_NO", "");
					
					iformObj.clearTable("Q_NG_POS_SIMAH_ADDRESS_DETAILS_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_CONTACT_DETAILS_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_PREVIOUS_ENQUIRIES_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_RATING_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_L1_C1_SUMMARY_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_L2_C1_SUMMARY_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_DEFAULTS_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_BOUNCED_CHEQUES_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_KEY_STAKEHOLDER_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_GUARAN_KEY_STAKEHOLDER_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_KEY_STAKEHOLDER_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_JUDGEMENT_GRID");
					iformObj.clearTable("Q_NG_POS_SIMAH_AS_NARRATIVE_GRID");
					iformObj.clearTable("Q_NG_POS_CREDITLINE_SIMAH_NONFUNDED_DET_GRID");
					iformObj.clearTable("Q_NG_POS_CREDITLINE_SIMAH_FUNDED_DET_GRID");

					
					String callName = "RetrieveCommercialSummaryReport";
					//LocalDateTime today_date=LocalDateTime.parse(new SimpleDateFormat().format(new Date()),DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
					String responseXML = createRequestXML(iformObj, callName);
					String cic_no="";
					JSONObject jsonobj = setResponseData_2(iformObj, callName, responseXML);
	
					for (Iterator iterator = jsonobj.keySet().iterator(); iterator.hasNext();) 
					{
						String key = (String) iterator.next();
						if (!jsonobj.get(key).toString().contains("#")) 
						{
							setControlValue(iformObj, key, jsonobj.get(key).toString());
						}
					}
	
					JSONObject return_obj = setResponseDataGrid(iformObj, callName, responseXML);
					for (Iterator iterator = return_obj.keySet().iterator(); iterator.hasNext();) 
					{
						String key = (String) iterator.next();
						iformObj.addDataToGrid(key, (JSONArray) return_obj.get(key));
					}
			
					
					//String enquiry_no=(String) jsonobj.get("Q_NG_POS_SIMAH_BASIC_DETAILS_ENQUIRY_NO");
					String reference_no=(String) jsonobj.get("Q_NG_POS_SIMAH_BASIC_DETAILS_REFERENCE_NO");
					
					//if(enquiry_no.trim().equalsIgnoreCase("") && reference_no.trim().equalsIgnoreCase(""))
					if(reference_no.trim().equalsIgnoreCase(""))
					{
						logger.info("but as no result came we are not inserting into NG_POS_SIMAH_EXPIRY_CHECK");
					}
					else
					{
						query="UPDATE NG_POS_SIMAH_EXPIRY_CHECK SET CHECKED_DATE='"+today_date+"' WHERE WI_NAME='"+current_wi_name+"'  ";
						iformObj.saveDataInDB(query);
						logger.info("FillSimah update query in case of same wsname older than 30 days is "+query);
					}	
					
					//query="UPDATE NG_POS_SIMAH_EXPIRY_CHECK SET CHECKED_DATE='"+today_date+"' WHERE WI_NAME='"+current_wi_name+"'  ";
					//iformObj.saveDataInDB(query);
					//logger.info("FillSimah update query in case of same wsname older than 30 days is "+query);
				}
			}
			else
			{	
				if(!current_wi_name.equalsIgnoreCase(wi_name))
				{
					boolean record_already_present_flag=false;
					query="SELECT ENQUIRY_NO,SERVICE,REPORT_DATE_GR FROM NG_POS_SIMAH_BASIC_DETAILS WHERE WI_NAME='"+current_wi_name+"'   ";
					List<List> result=iformObj.getDataFromDB(query);
					logger.info("Query to check if records are present for this workitem no or not is "+query+" and its result is "+result);
					if(result.size()>0)
					{
						if(result.get(0).size()>0)
						{
							if(result.get(0).get(0)!=null ||result.get(0).get(0)!="")
								record_already_present_flag=true;
						}
					}
					logger.info("record_already_present_flag is "+record_already_present_flag);
					
					if(!record_already_present_flag)
					{
						logger.info("In fillsimah data coming here because today's date is less than 30 days, hence fetching record from DB");
						query="UPDATE NG_POS_EXTTABLE SET SIMAH_COMM_STATUS=(SELECT SIMAH_COMM_STATUS FROM NG_POS_EXTTABLE WHERE WI_NAME='"+wi_name+"') WHERE WI_NAME='"+current_wi_name+"' ";
						logger.info("Query to update SIMAH Commercial Status in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_ADDRESS_DETAILS_GRID (WI_NAME,ADDRESS_LINE_1_ENG,ADDRESS_LINE_2_ENG,ADDRESS_LINE_3_ENG,ADDRESS_LINE_4_ENG,ADDRESS_LINE_1_AR,ADDRESS_LINE_2_AR,ADDRESS_LINE_3_AR,ADDRESS_LINE_4_AR,PO_BOX,CITY,POSTAL_CODE,EXTRA_NUMBER,DATE_OF_UPLOAD) SELECT '"+current_wi_name+"',ADDRESS_LINE_1_ENG,ADDRESS_LINE_2_ENG,ADDRESS_LINE_3_ENG,ADDRESS_LINE_4_ENG,ADDRESS_LINE_1_AR,ADDRESS_LINE_2_AR,ADDRESS_LINE_3_AR,ADDRESS_LINE_4_AR,PO_BOX,CITY,POSTAL_CODE,EXTRA_NUMBER,DATE_OF_UPLOAD FROM NG_POS_SIMAH_ADDRESS_DETAILS_GRID WHERE WI_NAME='"+wi_name+"'";					
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_ADDRESS_DETAILS_GRID (WI_NAME,ADDRESS_LINE_1_ENG,ADDRESS_LINE_2_ENG,ADDRESS_LINE_3_ENG,ADDRESS_LINE_4_ENG,ADDRESS_LINE_1_AR,ADDRESS_LINE_2_AR,ADDRESS_LINE_3_AR,ADDRESS_LINE_4_AR,PO_BOX,CITY,POSTAL_CODE,EXTRA_NUMBER,DATE_OF_UPLOAD) SELECT '"+current_wi_name+"',ADDRESS_LINE_1_ENG,ADDRESS_LINE_2_ENG,ADDRESS_LINE_3_ENG,ADDRESS_LINE_4_ENG,ADDRESS_LINE_1_AR,ADDRESS_LINE_2_AR,ADDRESS_LINE_3_AR,ADDRESS_LINE_4_AR,PO_BOX,CITY,POSTAL_CODE,EXTRA_NUMBER,DATE_OF_UPLOAD FROM NG_POS_SIMAH_ADDRESS_DETAILS_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_AS_NARRATIVE_GRID (WI_NAME,NARRATIVE_TYPE,DATE_LOADED,LOADED_BY,TEXT_ENG,TEXT_AR) SELECT '"+current_wi_name+"',NARRATIVE_TYPE,DATE_LOADED,LOADED_BY,TEXT_ENG,TEXT_AR FROM NG_POS_SIMAH_AS_NARRATIVE_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_BASIC_DETAILS (WI_NAME,SERVICE,ACTION,MEMBER_ID,USER_ID,RUN_NO,TOTAL_ITEMS,ERROR_ITEMS,REPORT_DATE_GR,REPORT_DATE_HJ,ENQUIRY_TYPE,ENQUIRY_NO,REFERENCE_NO,AMOUNT,GOVERNMENT_GUARANTEED,PRODUCT_TYPE,CREDIT_FACILITY) SELECT '"+current_wi_name+"',SERVICE,ACTION,MEMBER_ID,USER_ID,RUN_NO,TOTAL_ITEMS,ERROR_ITEMS,REPORT_DATE_GR,REPORT_DATE_HJ,ENQUIRY_TYPE,ENQUIRY_NO,REFERENCE_NO,AMOUNT,GOVERNMENT_GUARANTEED,PRODUCT_TYPE,CREDIT_FACILITY FROM NG_POS_SIMAH_BASIC_DETAILS WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_BOUNCED_CHEQUES_GRID (WI_NAME,REGISTRATION_DATE,REPORTING_BANK,LOAD_DATE,REFERENCE_NO,AMOUNT,DEFAULT_STATUS,SETTLEMENT_DATE,BCHQRSCD) SELECT '"+current_wi_name+"',REGISTRATION_DATE,REPORTING_BANK,LOAD_DATE,REFERENCE_NO,AMOUNT,DEFAULT_STATUS,SETTLEMENT_DATE,BCHQRSCD FROM NG_POS_SIMAH_BOUNCED_CHEQUES_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_CONSUMER_BUREAU_SUMMARY (WI_NAME,PREVIOUS_ENQUIRY_CNT,PREVIOUS_30_DAYS_DENQ_CNT,CI_COUNT,GUARANTEED_CI_COUNT,ISSUE_DATE,TOTAL_LIMITS,TOTAL_GUI_LIMITS,TOTAL_LIABILITIES,TOTAL_DEFAULTS,CURRENT_DEL_BAL) SELECT '"+current_wi_name+"',PREVIOUS_ENQUIRY_CNT,PREVIOUS_30_DAYS_DENQ_CNT,CI_COUNT,GUARANTEED_CI_COUNT,ISSUE_DATE,TOTAL_LIMITS,TOTAL_GUI_LIMITS,TOTAL_LIABILITIES,TOTAL_DEFAULTS,CURRENT_DEL_BAL FROM NG_POS_SIMAH_CONSUMER_BUREAU_SUMMARY WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_CONTACT_DETAILS_GRID (WI_NAME,PHONE_TYPE,COUNTRY,PREFIX,CONTACT_NUMBER,EXTENSION,UNFORMATED_CONTACT) SELECT '"+current_wi_name+"',PHONE_TYPE,COUNTRY,PREFIX,CONTACT_NUMBER,EXTENSION,UNFORMATED_CONTACT FROM NG_POS_SIMAH_CONTACT_DETAILS_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_DEFAULT_SUMMARY (WI_NAME,UNSETTLED_DEFAULT_COUNT,SETTLED_DEFAULT_COUNT,UNSETTLED_DEFAULTS_AMT,UNSETTLED_BC_COUNT,SETTLED_BC_COUNT,UNSETTLED_BC_AMOUNT) SELECT '"+current_wi_name+"',UNSETTLED_DEFAULT_COUNT,SETTLED_DEFAULT_COUNT,UNSETTLED_DEFAULTS_AMT,UNSETTLED_BC_COUNT,SETTLED_BC_COUNT,UNSETTLED_BC_AMOUNT FROM NG_POS_SIMAH_DEFAULT_SUMMARY WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_DEFAULTS_GRID (WI_NAME,PRODUCT_TYPE,CREDITOR,ACCOUNT_NO,DATE_LOADED,ORIGINAL_AMT,OS_BALANCE,DEFAULT_STATUS,SETTLEMENT_DATE) SELECT '"+current_wi_name+"',PRODUCT_TYPE,CREDITOR,ACCOUNT_NO,DATE_LOADED,ORIGINAL_AMT,OS_BALANCE,DEFAULT_STATUS,SETTLEMENT_DATE FROM NG_POS_SIMAH_DEFAULTS_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_DELIQUENCIES_SUMMARY (WI_NAME,O_30_OVER,O_60_OVER,O_90_OVER,O_120_OVER,O_150_OVER,O_180_OVER,TC_30_OVER,TC_60_OVER,TC_90_OVER,TC_120_OVER,TC_150_OVER,TC_180_OVER,PDB_30_OVER,PDB_60_OVER,PDB_90_OVER,PDB_120_OVER,PDB_150_OVER,PDB_180_OVER) SELECT '"+current_wi_name+"',O_30_OVER,O_60_OVER,O_90_OVER,O_120_OVER,O_150_OVER,O_180_OVER,TC_30_OVER,TC_60_OVER,TC_90_OVER,TC_120_OVER,TC_150_OVER,TC_180_OVER,PDB_30_OVER,PDB_60_OVER,PDB_90_OVER,PDB_120_OVER,PDB_150_OVER,PDB_180_OVER FROM NG_POS_SIMAH_DELIQUENCIES_SUMMARY WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_DISCLAIMER (WI_NAME,DISCLAIMER_ENG,DISCLAIMER_AR) SELECT '"+current_wi_name+"',DISCLAIMER_ENG,DISCLAIMER_AR FROM NG_POS_SIMAH_DISCLAIMER WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_GUARAN_KEY_STAKEHOLDER_GRID (WI_NAME,G_MEMBER,GUARANTOR_NAME_ENG,GUARANTOR_NAME_AR,ID_NUMBER,ID_ISSUER,ID_CITY,G_AMOUNT) SELECT '"+current_wi_name+"',G_MEMBER,GUARANTOR_NAME_ENG,GUARANTOR_NAME_AR,ID_NUMBER,ID_ISSUER,ID_CITY,G_AMOUNT FROM NG_POS_SIMAH_GUARAN_KEY_STAKEHOLDER_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_ID_DETAILS (WI_NAME,NAME,NAME_AR,C_DATE,PREVIOUS_NAME,PERVIOUS_NAME_AR,ISSUER,ISSUER_DESCRIPT,ISSUER_DESCRIPT_AR,IDCOD,ISSCIT,ISSCIT_DESCRIPT,ISSCIT_DESCRIPT_AR,EXPIRY_DATE,LEGAL_FORM,DATE_ESTABLISHED,BUSINESS_ACTIVITY,WEBSITE,NO_OF_STAFF,GENDER,DOB,NATIONALITY) SELECT '"+current_wi_name+"',NAME,NAME_AR,C_DATE,PREVIOUS_NAME,PERVIOUS_NAME_AR,ISSUER,ISSUER_DESCRIPT,ISSUER_DESCRIPT_AR,IDCOD,ISSCIT,ISSCIT_DESCRIPT,ISSCIT_DESCRIPT_AR,EXPIRY_DATE,LEGAL_FORM,DATE_ESTABLISHED,BUSINESS_ACTIVITY,WEBSITE,NO_OF_STAFF,GENDER,DOB,NATIONALITY FROM NG_POS_SIMAH_ID_DETAILS WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_JUDGEMENT_GRID (WI_NAME,ENFORCE_DATE,RES_NUMBER,COURT_DATE,CASE_NUMBER,DATE_LOADED,ORIGINAL_CLAIM_AMOUNT,JUDGEMENT_STATUS,SETTLEMENT_DATE) SELECT '"+current_wi_name+"',ENFORCE_DATE,RES_NUMBER,COURT_DATE,CASE_NUMBER,DATE_LOADED,ORIGINAL_CLAIM_AMOUNT,JUDGEMENT_STATUS,SETTLEMENT_DATE FROM NG_POS_SIMAH_JUDGEMENT_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_KEY_STAKEHOLDER_GRID (WI_NAME,NAME,NAME_U,NAME_ENG,NAME_AR,ID_NO,ID_ISSUER,CITY,RELATIONSHIP,RELATIONSHIP_AR,RELATIONSHIP_CODE,RELATIONSHIP_DESCRIPT,RELATIONSHIP_DESCRIPT_AR,PERCENTAGE_OWNED) SELECT '"+current_wi_name+"',NAME,NAME_U,NAME_ENG,NAME_AR,ID_NO,ID_ISSUER,CITY,RELATIONSHIP,RELATIONSHIP_AR,RELATIONSHIP_CODE,RELATIONSHIP_DESCRIPT,RELATIONSHIP_DESCRIPT_AR,PERCENTAGE_OWNED FROM NG_POS_SIMAH_KEY_STAKEHOLDER_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_L1_C1_SUMMARY_GRID (WI_NAME,CREDITOR,APPROVED_LIMIT,GLOBAL_LIMIT,UTILIZATION,UN_UTILIZED_BALANCE,MEMBER_STATUS,PAST_DUE,COLLATERAL,RELATIONSHIP_AGE,AS_OF_DATE,FUNDED_LIMIT,FUNDED_CAP,FUNDED_UTILIZATION,FUNDED_UTILIZATION_BALANCE,NON_FUNDED_LIMIT,NON_FUNDED_CAP,NON_FUNDED_UTILIZATION,NON_FUNDED_UN_UTILIZED_BALANCE,SHARED_LIMIT) SELECT '"+current_wi_name+"',CREDITOR,APPROVED_LIMIT,GLOBAL_LIMIT,UTILIZATION,UN_UTILIZED_BALANCE,MEMBER_STATUS,PAST_DUE,COLLATERAL,RELATIONSHIP_AGE,AS_OF_DATE,FUNDED_LIMIT,FUNDED_CAP,FUNDED_UTILIZATION,FUNDED_UTILIZATION_BALANCE,NON_FUNDED_LIMIT,NON_FUNDED_CAP,NON_FUNDED_UTILIZATION,NON_FUNDED_UN_UTILIZED_BALANCE,SHARED_LIMIT FROM NG_POS_SIMAH_L1_C1_SUMMARY_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_L2_C1_SUMMARY_GRID (WI_NAME,CREDITOR,APPROVED_LIMIT,GLOBAL_LIMIT,UTILIZATION,UN_UTILIZED_BALANCE,MEMBER_STATUS,PAST_DUE,COLLATERAL,RELATIONSHIP_AGE,AS_OF_DATE,FUNDED_LIMIT,FUNDED_CAP,FUNDED_UTILIZATION,FUNDED_UTILIZATION_BALANCE,NON_FUNDED_LIMIT,NON_FUNDED_CAP,NON_FUNDED_UTILIZATION,NON_FUNDED_UN_UTILIZED_BALANCE,SHARED_LIMIT) SELECT '"+current_wi_name+"',CREDITOR,APPROVED_LIMIT,GLOBAL_LIMIT,UTILIZATION,UN_UTILIZED_BALANCE,MEMBER_STATUS,PAST_DUE,COLLATERAL,RELATIONSHIP_AGE,AS_OF_DATE,FUNDED_LIMIT,FUNDED_CAP,FUNDED_UTILIZATION,FUNDED_UTILIZATION_BALANCE,NON_FUNDED_LIMIT,NON_FUNDED_CAP,NON_FUNDED_UTILIZATION,NON_FUNDED_UN_UTILIZED_BALANCE,SHARED_LIMIT FROM NG_POS_SIMAH_L2_C1_SUMMARY_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_PREVIOUS_ENQUIRIES_GRID (WI_NAME,ENQUIRY_DATE,ENQUIRER,ENQUIRY_TYPE,MEMBER_REFERENCE,PRODUCT_TYPE,AMOUNT,NAME) SELECT '"+current_wi_name+"',ENQUIRY_DATE,ENQUIRER,ENQUIRY_TYPE,MEMBER_REFERENCE,PRODUCT_TYPE,AMOUNT,NAME FROM NG_POS_SIMAH_PREVIOUS_ENQUIRIES_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						query="INSERT INTO NG_POS_SIMAH_RATING_GRID (WI_NAME,RATING_DATE,BANK_NAME,UPDATED_DATE,RATING_CODE,RATING_DESCRIPT,RATING_DESCRIPT_AR) SELECT '"+current_wi_name+"',RATING_DATE,BANK_NAME,UPDATED_DATE,RATING_CODE,RATING_DESCRIPT,RATING_DESCRIPT_AR FROM NG_POS_SIMAH_RATING_GRID WHERE WI_NAME='"+wi_name+"'  ";
						logger.info("Query to fetch in fillSimah is "+query);
						iformObj.saveDataInDB(query);
						logger.info("In fillsimah data, query to insert int NG_POS_SIMAH_ADDRESS_DETAILS_GRID is "+query);
					
					}
					else
					{
						logger.info("Record was already present for this workitem and 30 days are not over so we are doing nothing");
					}
					//query="INSERT INTO NG_POS_SIMAH_EXPIRY_CHECK (WI_NAME,CIC_NO,CHECKED_DATE) VALUES ('"+current_wi_name+"','"+padded_cic_no+"', getdate()  )";
					//iformObj.saveDataInDB(query);
					//logger.info("In fillsimah data, query to insert int NG_POS_SIMAH_EXPIRY_CHECK is "+query);
				}
				else
				{
					logger.info("Not 30 days passed since last time SIMAH was checked for this particular workitem ");
					logger.info("Hence we are doing nothing ");
				}
			} 
		}
		else
		{
			logger.info("In fillsimah data coming there is not entry for '"+current_wi_name+"' in NG_POS_SIMAH_EXPIRY_CHECK");
			String callName = "RetrieveCommercialSummaryReport";
			//LocalDateTime today_date=LocalDateTime.parse(new SimpleDateFormat().format(new Date()),DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
			
			String responseXML = createRequestXML(iformObj, callName);
			String cic_no="";
			JSONObject jsonobj = setResponseData_2(iformObj, callName, responseXML);

			for (Iterator iterator = jsonobj.keySet().iterator(); iterator.hasNext();) 
			{
				String key = (String) iterator.next();
				if (!jsonobj.get(key).toString().contains("#")) 
				{
					setControlValue(iformObj, key, jsonobj.get(key).toString());
				}
			}

			JSONObject return_obj = setResponseDataGrid(iformObj, callName, responseXML);
			for (Iterator iterator = return_obj.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				iformObj.addDataToGrid(key, (JSONArray) return_obj.get(key));
			}
			
			logger.info("In fillsimah data, we fetched fresh record");
			
			
			//String enquiry_no= (String) jsonobj.get("Q_NG_POS_SIMAH_BASIC_DETAILS_ENQUIRY_NO");
			String reference_no=(String) jsonobj.get("Q_NG_POS_SIMAH_BASIC_DETAILS_REFERENCE_NO");
			//logger.info("Enquiry no is "+enquiry_no+" and reference no is "+reference_no);
			logger.info("Reference no is "+reference_no);
			//if(enquiry_no==null || reference_no==null ||(enquiry_no.trim().equalsIgnoreCase("") && reference_no.trim().equalsIgnoreCase("")))
			if(reference_no==null || reference_no.trim().equalsIgnoreCase(""))
			{
				logger.info("but as no result came we are not inserting into NG_POS_SIMAH_EXPIRY_CHECK");
			}
			else
			{
				query="INSERT INTO NG_POS_SIMAH_EXPIRY_CHECK (WI_NAME,CIC_NO,CHECKED_DATE) VALUES ('"+current_wi_name+"','"+padded_cic_no+"', getdate()  )";
				iformObj.saveDataInDB(query);
				logger.info("In fillsimah data, query to insert into NG_POS_SIMAH_EXPIRY_CHECK is "+query);	 
			}	
		}
		
		// New Code for 60 days expiry check
		
		/* Old Working Code For Simah commercial without checking expiry
		String callName = "RetrieveCommercialSummaryReport";
		
		String responseXML = createRequestXML(iformObj, callName);
		String cic_no="";
		JSONObject jsonobj = setResponseData(iformObj, callName, responseXML);

		for (Iterator iterator = jsonobj.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			if (!jsonobj.get(key).toString().contains("#")) {
				setControlValue(iformObj, key, jsonobj.get(key).toString());
			}
		}

		JSONObject return_obj = setResponseDataGrid(iformObj, callName, responseXML);
		for (Iterator iterator = return_obj.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			iformObj.addDataToGrid(key, (JSONArray) return_obj.get(key));
		} 
		*/
	 }
	 catch(Exception e)
	 {
		 logger.info("Exception Occurred: fillSIMAHData "+e);
	 }
		return "SIMAH fetched sucessfully";
	}
	
	private String fillPOSdetails(IFormReference iformObj, String stringdata) 
	{
		logger.info("String data to fill posdetails is" + stringdata);
		String[] value_split = stringdata.split("#");
		String terminal_id = getControlValue(iformObj, value_split[0]);
		iformObj.clearTable(value_split[1]);
		logger.info("TerminalID to fillPOSdetails is " + terminal_id + "and table id is  is" + value_split[1]);
		
		String wi_name=getWorkitemName(iformObj);
		JSONArray jsonarr = new JSONArray();
		JSONObject jsonobj = null;
		
		if (terminal_id.equalsIgnoreCase("All")) 
		{
			String query = "SELECT CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT FROM NG_POS_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE WI_NAME='"+wi_name+"'  and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC " ;
			List<List<String>> pos_data = iformObj.getDataFromDB(query);
			for (List<String> value : pos_data) 
			{
				jsonobj = new JSONObject();
				jsonobj.put("Month", value.get(0));
				jsonobj.put("Throughput", value.get(1));
				jsonobj.put("Transaction", value.get(2));
				jsonobj.put("Average Transaction Amount", value.get(3));
				jsonarr.add(jsonobj);
			}
		}
		else
		{
			String query = "SELECT CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT FROM NG_POS_STMTDATA_CORTEX_DETAIL_GRID WHERE TERMINAL_ID='"+ terminal_id + "' AND WI_NAME='"+wi_name+"'  and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC" ;
			List<List<String>> pos_data = iformObj.getDataFromDB(query);
			for (List<String> value : pos_data) 
			{
				jsonobj = new JSONObject();
				jsonobj.put("Month", value.get(0));
				jsonobj.put("Throughput", value.get(1));
				jsonobj.put("Transaction", value.get(2));
				jsonobj.put("Average Transaction Amount", value.get(3));
				jsonarr.add(jsonobj);
			}
		}
		logger.info("JSON Array to fill pos details is" + jsonobj);
		iformObj.addDataToGrid(value_split[1], jsonarr);
		return "successfully filled POS Details";

	}

	private String fillPOSdetailsOldCIC(IFormReference iformObj, String stringdata) 
	{
		logger.info("String data to fill posdetails is" + stringdata);
		String[] value_split = stringdata.split("#");
		String terminal_id = getControlValue(iformObj, value_split[0]);
		iformObj.clearTable(value_split[1]);
		logger.info("TerminalID to fillPOSdetails is " + terminal_id + "and table id is  is" + value_split[1]);
		
		String wi_name=getWorkitemName(iformObj);
		JSONArray jsonarr = new JSONArray();
		JSONObject jsonobj = null;
		
		if (terminal_id.equalsIgnoreCase("All")) 
		{
			String query = "SELECT CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT FROM NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE WI_NAME='"+wi_name+"'  and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC " ;
			List<List<String>> pos_data = iformObj.getDataFromDB(query);
			for (List<String> value : pos_data) 
			{
				jsonobj = new JSONObject();
				jsonobj.put("Month", value.get(0));
				jsonobj.put("Throughput", value.get(1));
				jsonobj.put("Transaction", value.get(2));
				jsonobj.put("Average Transaction Amount", value.get(3));
				jsonarr.add(jsonobj);
			}
		}
		else
		{
			String query = "SELECT CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT FROM NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID WHERE TERMINAL_ID='"+ terminal_id + "' AND WI_NAME='"+wi_name+"'  and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC" ;
			List<List<String>> pos_data = iformObj.getDataFromDB(query);
			for (List<String> value : pos_data) 
			{
				jsonobj = new JSONObject();
				jsonobj.put("Month", value.get(0));
				jsonobj.put("Throughput", value.get(1));
				jsonobj.put("Transaction", value.get(2));
				jsonobj.put("Average Transaction Amount", value.get(3));
				jsonarr.add(jsonobj);
			}
		}
		logger.info("JSON Array to fill pos details is" + jsonobj);
		iformObj.addDataToGrid(value_split[1], jsonarr);
		return "successfully filled POS Details";

	}

	private String SetPQList(IFormReference iformObj, String stringdata) {
		String wi_name=getActivityName(iformObj);
		logger.info("inside SetPQList function and wi_name is "+wi_name );
		String procedurename = "NG_CHECK_PQ_STATUS";
		
		if(wi_name.equalsIgnoreCase("PQ1 without SIMAH"))	
		{
			String parameterlist = getWorkitemName(iformObj) + "~" + "PQ1";
			callProcedure(iformObj, procedurename, parameterlist);
		}
		else if(wi_name.equalsIgnoreCase("PQ2 with SIMAH") || wi_name.equalsIgnoreCase("Sales Rework") || wi_name.equalsIgnoreCase("Reapproval"))
		{
			String parameterlist = getWorkitemName(iformObj) + "~" + "PQ2";
			callProcedure(iformObj, procedurename, parameterlist);
		}
		logger.info("Exit SetPQList function ");
		
		return "hello";
	}
	
	private String SetConditionPrecedent(IFormReference iformObj, String stringdata) 
	{
		String wi_name=getActivityName(iformObj);
		logger.info("inside SetConditionPrecedent function and wi_name is "+wi_name );
		try
		{
		
		logger.info("inside SetPQList function and wi_name is "+wi_name );
		String procedurename = "NG_CONDITION_PRECEDENT";
		String parameterlist = getWorkitemName(iformObj);
		String result="All good";//callProcedurewithreturn(iformObj, procedurename, parameterlist);
		callProcedure(iformObj, procedurename, parameterlist);
		logger.info("Result from "+procedurename+" for workitem no "+wi_name+" is "+result);
		}
		catch(Exception e)
		{
			 logger.info("Exception Occurred: SetConditionPrecedent "+e);
		}
		return "Success~SetConditionPrecedent";
	}

	private String fillTerminalId(IFormReference iformObj, String stringdata) 
	{

        String wi_name=getWorkitemName(iformObj);
        iformObj.clearCombo(stringdata);
        iformObj.addItemInCombo(stringdata, "All","All");
        iformObj.setValue(stringdata,"All");
        String query = "SELECT DISTINCT TERMINAL_ID FROM NG_POS_STMTDATA_CORTEX_DETAIL_GRID WHERE WI_NAME='"+wi_name+"' ";
        try {
        List<List<String>> terminal_id = getDataFromDB(iformObj, query);
        for (List<String> value : terminal_id) {
               String result = value.get(0);
               logger.info("Terminal Id's set in dropdown are" + result);
               iformObj.addItemInCombo(stringdata, result, result);
        }
        }
        catch(Exception e)
        {
               logger.info("Exception occurred: fillTerminalId "+e);
        }
        //Start Edit By Deepak Goyal For Cortex Grid On Load
        try
        {
               JSONArray jsonarr = new JSONArray();
               JSONObject jsonobj = null;
               //iformObj.clearTable("");// Commenting this to resolve ETableControl issue in IformsViewer/error.log
               query = "SELECT CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT FROM NG_POS_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE WI_NAME='"+wi_name+"'  and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC " ;
               List<List<String>> pos_data = iformObj.getDataFromDB(query);
               logger.info("query to fetch cortex data is "+query+"and it's result is "+pos_data);
        for (List<String> value : pos_data) 
        {
               jsonobj = new JSONObject();
               jsonobj.put("Month", value.get(0));
               jsonobj.put("Throughput", value.get(1));
               jsonobj.put("Transaction", value.get(2));
               jsonobj.put("Average Transaction Amount", value.get(3));
               jsonarr.add(jsonobj);
        }
        iformObj.clearTable("Q_NG_POS_STMTDATA_CORTEX_DETAIL_GRID");
        
        logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Cortex data is"+iformObj.getDataFromGrid("Q_NG_POS_STMTDATA_CORTEX_DETAIL_GRID"));
        iformObj.addDataToGrid("Q_NG_POS_STMTDATA_CORTEX_DETAIL_GRID", jsonarr);
        }
        catch(Exception e)
        {
        	logger.info("Exception occurred: fillTerminalId "+e);
        }
        //End Edit By Deepak Goyal For Cortex Grid On Load
        return "Terminal ID filled Successfully";   
	}

	private String fillTerminalIdOldCIC(IFormReference iformObj, String stringdata) 
	{

        String wi_name=getWorkitemName(iformObj);
        iformObj.clearCombo(stringdata);
        iformObj.addItemInCombo(stringdata, "All","All");
        iformObj.setValue(stringdata,"All");
        String query = "SELECT DISTINCT TERMINAL_ID FROM NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID WHERE WI_NAME='"+wi_name+"' ";
        try {
        List<List<String>> terminal_id = getDataFromDB(iformObj, query);
        for (List<String> value : terminal_id) {
               String result = value.get(0);
               logger.info("Terminal Id's set in dropdown are" + result);
               iformObj.addItemInCombo(stringdata, result, result);
        }
        }
        catch(Exception e)
        {
               logger.info("Exception occurred: fillTerminalId "+e);
        }
        //Start Edit By Deepak Goyal For Cortex Grid On Load
        try
        {
               JSONArray jsonarr = new JSONArray();
               JSONObject jsonobj = null;
               //iformObj.clearTable("");// Commenting this to resolve ETableControl issue in IformsViewer/error.log
               query = "SELECT CORTEX_MONTH,THROUGHPUT,CORTEX_TRANSACTION,AVG_TRANSACTN_AMT FROM NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE WI_NAME='"+wi_name+"'  and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC " ;
               List<List<String>> pos_data = iformObj.getDataFromDB(query);
               logger.info("query to fetch cortex data is "+query+"and it's result is "+pos_data);
        for (List<String> value : pos_data) 
        {
               jsonobj = new JSONObject();
               jsonobj.put("Month", value.get(0));
               jsonobj.put("Throughput", value.get(1));
               jsonobj.put("Transaction", value.get(2));
               jsonobj.put("Average Transaction Amount", value.get(3));
               jsonarr.add(jsonobj);
        }
        iformObj.clearTable("Q_NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID");
        
        logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Cortex data is"+iformObj.getDataFromGrid("Q_NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID"));
        iformObj.addDataToGrid("Q_NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID", jsonarr);
        }
        catch(Exception e)
        {
        	logger.info("Exception occurred: fillTerminalId "+e);
        }
        //End Edit By Deepak Goyal For Cortex Grid On Load
        return "Terminal ID filled Successfully";   
	}

	private String fillCTFMSBData(IFormReference iformObj, String stringdata) 
	{
		String wi_name=getWorkitemName(iformObj);
		logger.info("Inside handling of fillCTFMSBData for wi_name "+wi_name+" and stringdata is "+stringdata);
		
		try
		{
			
		int rowindex = Integer.parseInt(stringdata);
		logger.info("Row index selected by user is" + rowindex);
		JSONArray jsonarr = iformObj.getDataFromGrid("Q_NG_POS_CREDITLINE_CTF_MSB_GRID");
		JSONObject jsonobj = (JSONObject) jsonarr.get(rowindex);
		String dossier_id = (String) jsonobj.get("Dossier No");
		logger.info("Dossier Id is" + dossier_id);
				
		jsonarr = new JSONArray();
		jsonobj = new JSONObject();
		
		String field_name[]={"Dossier Number","Code","Disbursed Amount","Monthly Installment","Disbursal Date","Dossier Tenor","Last Installment Date"};
		String query="SELECT DOSSIER_NUMBER,PRODUCT_CODE,DISBURSED_AMOUNT,MONTHLY_INSTALLMENT,DISBURSED_DATE,TENOR,LAST_INSTALMENT_DATE FROM NG_POS_CREDITLINE_DOSSIER_DETAILS_GRID WHERE WI_NAME='"+wi_name+"' AND DOSSIER_NUMBER='"+dossier_id+"'  ";
		List<List<String>> result_list=iformObj.getDataFromDB(query);
		logger.info("Query to fetch CTF details based on dossier no is "+query+" and it's result is"+result_list);
		String result="";
		for(List<String> inner_list:result_list)
		{
			for(int i=0;i<inner_list.size();i++)
			{
				result=inner_list.get(i);
				jsonobj.put(field_name[i],result);
			}
		}
		
		iformObj.clearTable("table90");
		jsonarr.add(jsonobj);
		logger.info("Jsonarray for fillCTFMSBData is "+jsonarr);
		iformObj.addDataToGrid("table90", jsonarr); //table 90 is id of grid below CTF/MSB Grid.
				
		
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: fillCTFMSBData and exception is "+e);
		}
		
		return "success~fillCTFMSBData";
	}
	
	private String fillCTFMSBData_GroupExposure(IFormReference iformObj, String stringdata) 
	{
		String wi_name=getWorkitemName(iformObj);
		logger.info("Inside handling of fillCTFMSBData_GroupExposure for wi_name "+wi_name+" and stringdata is "+stringdata);
		
		try
		{
			
		int rowindex = Integer.parseInt(stringdata);
		logger.info("Row index selected by user is" + rowindex);
		JSONArray jsonarr = iformObj.getDataFromGrid("CL_CTF_MSB_GROUP_EX_GRID");
		JSONObject jsonobj = (JSONObject) jsonarr.get(rowindex);
		String dossier_id = (String) jsonobj.get("Dossier No");
		logger.info("Dossier Id is" + dossier_id);
				
		jsonarr = new JSONArray();
		jsonobj = new JSONObject();
		
		String field_name[]={"Dossier Number","Code","Disbursed Amount","Monthly Installment","Disbursal Date","Dossier Tenor","Last Installment Date"};
		String query="SELECT DOSSIER_NUMBER,PRODUCT_CODE,DISBURSED_AMOUNT,MONTHLY_INSTALLMENT,DISBURSED_DATE,TENOR,LAST_INSTALMENT_DATE FROM NG_POS_CREDITLINE_DOSSIER_DETAILS_GRID_GROUP_EXPOSURE WHERE WI_NAME='"+wi_name+"' AND DOSSIER_NUMBER='"+dossier_id+"'  ";
		List<List<String>> result_list=iformObj.getDataFromDB(query);
		logger.info("Query to fetch CTF details based on dossier no is "+query+" and it's result is"+result_list);
		String result="";
		for(List<String> inner_list:result_list)
		{
			for(int i=0;i<inner_list.size();i++)
			{
				result=inner_list.get(i);
				jsonobj.put(field_name[i],result);
			}
		}
		
		iformObj.clearTable("CL_DOSSIER_DET_GROUP_EX_GRID");
		jsonarr.add(jsonobj);
		logger.info("Jsonarray for fillCTFMSBData is "+jsonarr);
		iformObj.addDataToGrid("CL_DOSSIER_DET_GROUP_EX_GRID", jsonarr); //table 90 is id of grid below CTF/MSB Grid.
				
		
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: fillCTFMSBData_GroupExposure and exception is "+e);
		}
		
		return "success~fillCTFMSBData_GroupExposure";
	}
	
/*
	private String fillCTFMSBData(IFormReference iformObj, String stringdata) {

		String callName = "LoanDisburseDataInq";
		logger.info(stringdata);
		int rowindex = Integer.parseInt(stringdata);
		logger.info("Row index selected by user is" + rowindex);
		JSONArray jsonarr = iformObj.getDataFromGrid("Q_NG_POS_CREDITLINE_CTF_MSB_GRID");
		JSONObject jsonobj = (JSONObject) jsonarr.get(rowindex);
		String dossier_id = (String) jsonobj.get("Dossier No");
		logger.info("Dossier Id is" + dossier_id);
		
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
			
	
			for (String tag : tags) 
			{
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
					parser.changeValue(request_prefix+tag, value);
				}
			}
			
			parser.changeValue(request_prefix+"DossierID", dossier_id);
			System.out.println("RequestXML is :\n" + parser.toString());
			logger.info("RequestXML is :\n" + parser.toString());
			String responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
	
			System.out.println("Response XML is: \n" + responseXML);
			//logger.info("Response XML is: \n" + responseXML);
		
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			responseXML = responseXML.replace(temp, "");

		logger.info("Response XML received by setResponseDataGrid for CTF MSB is" + responseXML);
		tagName = "_TagNameResponseGrid";
		tagNames = GetXML.getProp().getProperty(callName + tagName);

		logger.info(tagNames);

		String statuscode = GetXML.getProp().getProperty(callName + "_StatusCode");
		String[] status_code_split = statuscode.split("~");

		String[] tagValue = tagNames.split(",");
		for (String tag : tagValue) {
			tags = tag.split("~");
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
			logger.info("objWFxmlResponse value is " + objWFxmlResponse);
			jsonarr = new JSONArray();
			if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
				WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0], tags[1]);
				logger.info("Wfmxmlsit is --------------" + WFXmlList);

				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) {

					jsonobj = new JSONObject();
					logger.info("iiiiiiiiii" + i);
					logger.info("Dossier id we want is" + dossier_id);
					logger.info("Dossier id avaiaalable is" + WFXmlList.getVal("DossierID"));
                    if (dossier_id.contains(WFXmlList.getVal("DossierID"))) { 
						for (int j = 2; j < tags.length - 1; ++j) {
							String one = tags[j];
							logger.info("333333333333333333" + one);
							String[] temp = one.split("#");
							logger.info("@@@" + temp[0] + "!!!!" + temp[1]);
							String xyz = WFXmlList.getVal(temp[1]);
							logger.info("xyz" + xyz);
							if (xyz == null || xyz == "") {
								xyz = " ";
							}
							jsonobj.put(temp[0], xyz);
						}
						jsonarr.add(jsonobj);
					}

				}
				logger.info(jsonarr);
				logger.info("ID of table is table90");
				iformObj.clearTable("table90");
				iformObj.addDataToGrid("table90", jsonarr);
			} else {
				logger.info("For " + callName + " Status code returned from response is not success ");
			}
		}
	}
	catch(Exception e)
	{
		logger.info("Exception in LoanDisburseDataInq calls is "+e);
	}
		return "All Good";
	
}	
	*/

	/*
	private String fillCTFMSBData(IFormReference iformObj, String stringdata) {

		String callName = "LoanDisburseDataInq";
		logger.info(stringdata);
		int rowindex = Integer.parseInt(stringdata);
		logger.info("Row index selected by user is" + rowindex);
		JSONArray jsonarr = iformObj.getDataFromGrid("Q_NG_POS_CREDITLINE_CTF_MSB_GRID");
		JSONObject jsonobj = (JSONObject) jsonarr.get(rowindex);
		String dossier_id = (String) jsonobj.get("Dossier No");
		logger.info("Dossier Id is" + dossier_id);
		logger.info("Inside createRequestXML Function and callName is " + callName);
		String tagName = "_TagName";
		String tagNames = GetXML.getProp().getProperty(callName + tagName);
		logger.info(tagNames);
		String request_prefix=GetXML.getProp().getProperty(callName+"_RequestPrefix");
		if(request_prefix.equals(null))
		{
			request_prefix="";
		}
		String[] tags = tagNames.split(",");

		String requestXML = readDummyRequest(callName);
		XMLParser parser = new XMLParser(requestXML);

		for (String tag : tags) {
			String tagValue = parser.getValueOf(tag);
			if (tagValue.startsWith("formid~")) {
				String value = (String) iformObj.getValue(tagValue.split("~")[1]);
				parser.changeValue(request_prefix+tag, value);
			}
		}

		parser.changeValue(request_prefix+"DossierID", dossier_id);
		logger.info("RequestXML is :\n" + parser.toString());
		String responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
		
		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			responseXML = responseXML.replace(temp, "");

		logger.info("Response XML received by setResponseDataGrid for CTF MSB is" + responseXML);
		tagName = "_TagNameResponseGrid";
		tagNames = GetXML.getProp().getProperty(callName + tagName);

		logger.info(tagNames);

		String statuscode = GetXML.getProp().getProperty(callName + "_StatusCode");
		String[] status_code_split = statuscode.split("~");

		String[] tagValue = tagNames.split(",");
		for (String tag : tagValue) {
			tags = tag.split("~");
			WFXmlResponse objWFxmlResponse = new WFXmlResponse(responseXML);
			logger.info("objWFxmlResponse value is " + objWFxmlResponse);
			jsonarr = new JSONArray();
			if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) {
				WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0], tags[1]);
				logger.info("Wfmxmlsit is --------------" + WFXmlList);

				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) {

					jsonobj = new JSONObject();
					logger.info("iiiiiiiiii" + i);
					logger.info("Dossier id we want is" + dossier_id);
					logger.info("Dossier id avaiaalable is" + WFXmlList.getVal("DossierID"));
					if (WFXmlList.getVal("DossierID").equalsIgnoreCase(dossier_id)) {
						for (int j = 2; j < tags.length - 1; ++j) {
							String one = tags[j];
							logger.info("333333333333333333" + one);
							String[] temp = one.split("#");
							logger.info("@@@" + temp[0] + "!!!!" + temp[1]);
							String xyz = WFXmlList.getVal(temp[1]);
							logger.info("xyz" + xyz);
							if (xyz == null || xyz == "") {
								xyz = " ";
							}
							jsonobj.put(temp[0], xyz);
						}
						jsonarr.add(jsonobj);
					}

				}
				logger.info(jsonarr);
				logger.info("ID of table is table90");
				iformObj.clearTable("table90");
				iformObj.addDataToGrid("table90", jsonarr);
			} else {
				logger.info("For " + callName + " Status code returned from response is not success ");
			}
		}

		return "All Good";
	}*/
	
	
	
	private String fillStatementData(IFormReference iformObj, String stringdata) 
	{
		iformObj.clearCombo(stringdata);
		iformObj.addItemInCombo(stringdata, "All", "All");
		String wi_name = getWorkitemName(iformObj);
		String query = "SELECT DISTINCT ACC_NO FROM NG_POS_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='" + wi_name + "' ";
		try 
		{
			List<List<String>> account_no = getDataFromDB(iformObj, query);
			for (List<String> value : account_no) 
			{
				String result = value.get(0);
				logger.info("Account No's set in dropdown are" + result);
				iformObj.addItemInCombo(stringdata, result, result);
			}
			
			iformObj.clearTable("Q_NG_POS_STMTDATA_ACCMOVMNT_GRID");
			iformObj.setValue(stringdata,"All");
			query = "SELECT FROM_DATE,TO_DATE,BANK_NAME,ACC_NO,DEPOSIT,WITHDRAWAL,AVG_BAL,NEG_BAL,ACC_MONTH,THROUGHPUT FROM NG_POS_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='"+ wi_name + "' ORDER BY FROM_DATE DESC ";
			JSONObject jsonobj = new JSONObject();
			JSONArray jsonarr= new JSONArray();
			List<List<String>> stmt_data = iformObj.getDataFromDB(query);
			for (List<String> value : stmt_data)
			 {
				jsonobj = new JSONObject();
				jsonobj.put("From Date", value.get(0));
				jsonobj.put("To Date", value.get(1));
				jsonobj.put("Bank Name", value.get(2));
				jsonobj.put("Account Number", value.get(3));
				jsonobj.put("Deposit", value.get(4));
				jsonobj.put("Withdrawal", value.get(5));
				jsonobj.put("Average Balance", value.get(6));
				jsonobj.put("Negative Balance", value.get(7));
				jsonobj.put("Month", value.get(8));
				jsonobj.put("Throughput", value.get(9));
				jsonarr.add(jsonobj);
			}

			logger.info("JSON Array to fill stmt details is" + jsonobj);
			iformObj.addDataToGrid("Q_NG_POS_STMTDATA_ACCMOVMNT_GRID", jsonarr);
			
		} 
		catch (Exception e) 
		{
			logger.info("Exception occurred: fillAccounts " + e);
		}
		return "";
	}

	private String fillStatementDataOldCIC(IFormReference iformObj, String stringdata) 
	{
		iformObj.clearCombo(stringdata);
		iformObj.addItemInCombo(stringdata, "All", "All");
		String wi_name = getWorkitemName(iformObj);
		String query = "SELECT DISTINCT ACC_NO FROM NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='" + wi_name + "' ";
		try 
		{
			List<List<String>> account_no = getDataFromDB(iformObj, query);
			for (List<String> value : account_no) 
			{
				String result = value.get(0);
				logger.info("Account No's set in dropdown are" + result);
				iformObj.addItemInCombo(stringdata, result, result);
			}
			
			iformObj.clearTable("Q_NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_GRID");
			iformObj.setValue(stringdata,"All");
			query = "SELECT FROM_DATE,TO_DATE,BANK_NAME,ACC_NO,DEPOSIT,WITHDRAWAL,AVG_BAL,NEG_BAL,ACC_MONTH,THROUGHPUT FROM NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_GRID WHERE WI_NAME='"+ wi_name + "' ORDER BY FROM_DATE DESC ";
			JSONObject jsonobj = new JSONObject();
			JSONArray jsonarr= new JSONArray();
			List<List<String>> stmt_data = iformObj.getDataFromDB(query);
			for (List<String> value : stmt_data)
			 {
				jsonobj = new JSONObject();
				jsonobj.put("From Date", value.get(0));
				jsonobj.put("To Date", value.get(1));
				jsonobj.put("Bank Name", value.get(2));
				jsonobj.put("Account Number", value.get(3));
				jsonobj.put("Deposit", value.get(4));
				jsonobj.put("Withdrawal", value.get(5));
				jsonobj.put("Average Balance", value.get(6));
				jsonobj.put("Negative Balance", value.get(7));
				jsonobj.put("Month", value.get(8));
				jsonobj.put("Throughput", value.get(9));
				jsonarr.add(jsonobj);
			}

			logger.info("JSON Array to fill stmt details is" + jsonobj);
			iformObj.addDataToGrid("Q_NG_POS_OLD_CIC_STMTDATA_ACCMOVMNT_GRID", jsonarr);
			
		} 
		catch (Exception e) 
		{
			logger.info("Exception occurred: fillAccounts " + e);
		}
		return "";
	}

	private String createDisbursementWI(IFormReference iformObj, String stringdata) {
		POSCommon obj = new POSCommon(iformObj);
		logger.info("createDisbursementWI before call");
		String winame_disbursement = obj.createWorkitemDisbursement(iformObj, stringdata);

		try {

			String app_limit_amt = getControlValue(iformObj,
					"Q_NG_POS_APPLICATION_DATA_APPROVED_LIMIT_AMT_AFTER_SIMAH");
			String avail_amt_for_disbursement = getControlValue(iformObj,
					"Q_NG_POS_APPLICATION_DATA_AVAIL_AMT_FOR_DISBURSEMENT");
			String amt_to_be_disbursed = getControlValue(iformObj, "Q_NG_POS_APPLICATION_DATA_AMT_TO_BE_DISBURSED");
			String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			String parent_wi_name = getControlValue(iformObj, "WI_NAME");
			/*
			 * String
			 * query="SELECT WI_NAME FROM NG_DISBURSEMENT_EXTTABLE WHERE PARENT_WI_NAME='"
			 * +parent_wi_name+"'"; logger.info(query); List<List<String>>
			 * result=getDataFromDB(iformObj, query);
			 * disbursement_workitem_no=result.get(0).get(0);
			 */
			logger.info("Disburseemnt work item no" + winame_disbursement);
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("Application Amount after SIMAH", app_limit_amt);
			jsonObj.put("Available Amount for Disbursement", avail_amt_for_disbursement);
			jsonObj.put("Amount to be Disbursed", amt_to_be_disbursed);
			jsonObj.put("Date Time", date);
			jsonObj.put("Disbursement Workitem No.", winame_disbursement);

			logger.info("Json Array is" + jsonObj);
			jsonArr.add(jsonObj);
			iformObj.addDataToGrid("Q_NG_POS_DISBURSEMENT_GRID", jsonArr);

		} catch (Exception e) {
			logger.error("Exception catched in  addToDecisionHistoryGrid", e);
		}

		return winame_disbursement;
	}

	/*
	 * private String fillDisbursementDetails(IFormReference iformObj, String
	 * stringdata) {
	 * 
	 * 
	 * try {
	 * 
	 * String app_limit_amt = getControlValue(iformObj,
	 * "Q_NG_POS_APPLICATION_DATA_APPROVED_LIMIT_AMT_AFTER_SIMAH"); String
	 * avail_amt_for_disbursement = getControlValue(iformObj,
	 * "Q_NG_POS_APPLICATION_DATA_AVAIL_AMT_FOR_DISBURSEMENT"); String
	 * amt_to_be_disbursed = getControlValue(iformObj,
	 * "Q_NG_POS_APPLICATION_DATA_AMT_TO_BE_DISBURSED"); String date = new
	 * SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()); String
	 * disbursement_workitem_no = winame_disbursement;
	 * 
	 * String parent_wi_name = getControlValue(iformObj, "WI_NAME");
	 * 
	 * logger.info("Disburseemnt work item no" + disbursement_workitem_no);
	 * JSONArray jsonArr = new JSONArray(); JSONObject jsonObj = new JSONObject();
	 * jsonObj.put("Application Amount after SIMAH", app_limit_amt);
	 * jsonObj.put("Available Amount for Disbursement", avail_amt_for_disbursement);
	 * jsonObj.put("Amount to be Disbursed", amt_to_be_disbursed);
	 * jsonObj.put("Date Time", date); jsonObj.put("Disbursement Workitem No.",
	 * disbursement_workitem_no);
	 * 
	 * logger.info("Json Array is" + jsonObj); jsonArr.add(jsonObj);
	 * iformObj.addDataToGrid("Q_NG_POS_DISBURSEMENT_GRID", jsonArr);
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception catched in  addToDecisionHistoryGrid", e); }
	 * 
	 * return "All is well"; }
	 */
	
	public String addToDecisionHistoryGrid(IFormReference iformObj, String stringData) 
	{
		try {
			
			logger.info("inside addToDecisionHistoryGrid for workitem no "+getWorkitemName(iformObj));
			
			String strData[] = stringData.split("#");
			String Workstep = strData[0];
			logger.info("workstep name is " + Workstep);
			String username = strData[1];
			logger.info("username name is " + username);
			String decision = getControlValue(iformObj, "DECISION");
			logger.info("decision name is " + decision);
			String action = getControlValue(iformObj, "REMARKS");
			logger.info("action name is " + action);
			String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			logger.info("date name is " + date);
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObj = new JSONObject();
			String query="SELECT CONCAT(PERSONALNAME,' ',FAMILYNAME),MAILID FROM PDBUser WHERE UserName='"+username+"'";
			String emailvalue="",fullname="",TAT="";
			List<List<String>> data = iformObj.getDataFromDB(query);
			for (List<String> value : data) 
			{
				fullname = value.get(0);
				emailvalue= value.get(1);
			}
			jsonObj.put("Date Time", date);

			logger.info(date);
			//Start Edit By Deepak Goyal
            if(Workstep.equalsIgnoreCase("PQ1 without SIMAH"))
            {
                  //query="select  datediff(MINUTE,Createddatetime,getdate()) as TAT from WFINSTRUMENTTABLE where ProcessInstanceID='"+getWorkitemName(iformObj)+"'";
                  query="select convert(char(5),dateadd(minute,datediff(MINUTE,Createddatetime,getdate())-((datediff(DAY,Createddatetime,getdate())-dbo.fn_GetTotalWorkingDays(cast(Createddatetime as date),cast(getdate() as date)))*24*60),'00:00'),108) as TAT from WFINSTRUMENTTABLE where ProcessInstanceID='"+getWorkitemName(iformObj)+"' ";
            	  List<List<String>> data1 = iformObj.getDataFromDB(query);
                  for (List<String> value : data1) 
                  {
                         TAT = value.get(0);                     
                  }
            }
            else
            {
                  //query="select top 1 datediff(MINUTE,convert(datetime,(select top 1 b.date_time from NG_POS_DECISION_GRID b where b.WI_NAME=a.wi_name and b.decision <> 'Auto Sell' order by b.insertionOrderId desc),103),convert(datetime,getdate(),103)) as TAT from NG_POS_DECISION_GRID a where WI_NAME='"+getWorkitemName(iformObj)+"' and decision <> 'Auto Sell' order by a.insertionOrderId desc";
                  query="select convert(char(5),dateadd(minute,datediff(MINUTE,b.actualdate,b.currentdate)-((datediff(DAY,b.actualdate,b.currentdate)-dbo.fn_GetTotalWorkingDays(cast(b.actualdate as date),cast(b.currentdate as date)))*24*60),'00:00'),108) as TAT from (select top 1 convert(datetime,(select top 1 b.date_time from NG_POS_DECISION_GRID b where b.WI_NAME=a.wi_name and b.decision <> 'Auto Sell' order by b.insertionOrderId desc),103) as actualdate,convert(datetime,getdate(),103) as currentdate from NG_POS_DECISION_GRID a where WI_NAME='"+getWorkitemName(iformObj)+"' and decision <> 'Auto Sell' order by a.insertionOrderId desc) b";
            	  List<List<String>> data1 = iformObj.getDataFromDB(query);
                  for (List<String> value : data1) 
                  {
                         TAT = value.get(0);                     
                  }
            }
            //End Edit By Deepak Goyal

			jsonObj.put("Workstep", Workstep);
			logger.info("inside Decision his");
			logger.info(Workstep);
			jsonObj.put("Decision", decision);
			logger.info(decision);
			jsonObj.put("User ID", username);
			logger.info(username);
			jsonObj.put("Remark", action);
			logger.info(action);
			jsonObj.put("Email ID", emailvalue);
			logger.info(emailvalue);
			jsonObj.put("User Name", fullname);
			logger.info(fullname);
			jsonObj.put("TAT", TAT);
			logger.info("TAT is ===== "+TAT);
			logger.info("Jason object value of decsion key for workitem no "+getWorkitemName(iformObj)+" at stage "+Workstep+"is " + jsonObj);
			jsonArr.add(jsonObj);
			iformObj.addDataToGrid("table78", jsonArr); // table78 is the id of decision history table
			
			if(Workstep.equalsIgnoreCase("PQ1 without SIMAH"))
			{
				iformObj.setValue("PQ1_SUBMITTED_BY", username);
				iformObj.setValue("PQ2_SUBMITTED_BY", username);
				logger.info("At workstep "+Workstep+" username is "+username);
			}
			else if(Workstep.equalsIgnoreCase("PQ2 with SIMAH"))
			{
				iformObj.setValue("PQ2_SUBMITTED_BY", username);
				iformObj.setValue("SALES_REWORK_SUBMITTED_BY", username);
				iformObj.setValue("APPROVED_SALES_SUBMITTED_BY", username);
				iformObj.setValue("DISBURSEMENT_INITIATE_SUBMITTED_BY", username);
				iformObj.setValue("BUY_AND_CONTRACT_SUBMITTED_BY", username);
				logger.info("At workstep "+Workstep+" username is "+username);
			}
			else if(Workstep.equalsIgnoreCase("Sales Rework") || Workstep.equalsIgnoreCase("Reapproval"))
			{
				iformObj.setValue("SALES_REWORK_SUBMITTED_BY", username);
				iformObj.setValue("APPROVED_SALES_SUBMITTED_BY", username);
				logger.info("At workstep "+Workstep+" username is "+username);
			}
			else if(Workstep.equalsIgnoreCase("Approved Sales"))
			{
				iformObj.setValue("APPROVED_SALES_SUBMITTED_BY", username);
				iformObj.setValue("DISBURSEMENT_INITIATE_SUBMITTED_BY", username);
				logger.info("At workstep "+Workstep+" username is "+username);
			}
			else if(Workstep.equalsIgnoreCase("Disbursal_Initiate"))
			{
				iformObj.setValue("DISBURSEMENT_INITIATE_SUBMITTED_BY", username);
				iformObj.setValue("BUY_AND_CONTRACT_SUBMITTED_BY", username);
				logger.info("At workstep "+Workstep+" username is "+username);
			}
			else if(Workstep.equalsIgnoreCase("Buy_and_Contract"))
			{
				iformObj.setValue("BUY_AND_CONTRACT_SUBMITTED_BY", username);
				//iformObj.setValue("SELL_AND_STIPLULATE_SUBMITTED_BY", username);
				logger.info("At workstep "+Workstep+" username is "+username);
			}
			else if(Workstep.equalsIgnoreCase("Verifying_Signed_Contract"))
			{
				iformObj.setValue("SELL_AND_STIPLULATE_SUBMITTED_BY", username);
				logger.info("At workstep "+Workstep+" username is "+username);
			}
			else if(Workstep.equalsIgnoreCase("Sell_and_Stipulation_Maker") || Workstep.equalsIgnoreCase("Stipulation_and_Sell_Checker"))
			{
				iformObj.setValue("SELL_AND_STIPLULATE_SUBMITTED_BY", username);
				logger.info("At workstep "+Workstep+" username is "+username);
			}
				
			
		} catch (Exception e) {
			logger.error("Exception catched in  addToDecisionHistoryGrid", e);
		}
		return "SUCCESS~DataAddedToGrid";
	}
	
	
	/*
	private String setRoutingLevel(IFormReference iformObj, String stringdata) {
		// TODO Auto-generated method stub
		logger.info("Inside setRoutingLevel function");
		String query = "";

		// Added by SK
		if (stringdata.equalsIgnoreCase("BR")) {
			logger.info("BR CASE");
			query = "select max(route_level) as final_level from(select min(b.level_id) as route_level from ng_pos_exttable A, ng_mast_authority_matrix B, ng_mast_level_mapping c where A.channel=B.filter and B.process_name=C.process_name and b.approval_type=C.approval_type and B.filter=C.filter and B.level_id=C.level_id and B.amt>A.app_limit_amt AND B.APPROVAL_TYPE='Business' AND A.WI_NAME='"
					+ getWorkitemName(iformObj)
					+ "' UNION select min(B.level_id) as route_level from ng_pos_exttable A, ng_mast_authority_matrix B, ng_mast_level_mapping c where A.channel=B.filter and B.process_name=C.process_name and b.approval_type=C.approval_type and B.filter=C.filter and B.level_id=C.level_id and A.no_of_exception=B.no_of_exception AND B.APPROVAL_TYPE='Business' AND A.WI_NAME='"
					+ getWorkitemName(iformObj) + "') D";
		} else if (stringdata.equalsIgnoreCase("CR")) {
			logger.info("CR CASE");
			query = "select max(route_level) as final_level from(select min(b.level_id) as route_level from ng_pos_exttable A, ng_mast_authority_matrix B, ng_mast_level_mapping c where A.channel=B.filter and B.process_name=C.process_name and b.approval_type=C.approval_type and B.filter=C.filter and B.level_id=C.level_id and B.amt>A.app_limit_amt AND B.APPROVAL_TYPE='Credit Risk' AND A.WI_NAME='"
					+ getWorkitemName(iformObj)
					+ "' UNION select min(B.level_id) as route_level from ng_pos_exttable A, ng_mast_authority_matrix B, ng_mast_level_mapping c where A.channel=B.filter and B.process_name=C.process_name and b.approval_type=C.approval_type and B.filter=C.filter and B.level_id=C.level_id and A.no_of_exception=B.no_of_exception AND B.APPROVAL_TYPE='Credit Risk' AND A.WI_NAME='"
					+ getWorkitemName(iformObj) + "') D";
		}

		String final_level = "";
		List<List<String>> comboValues = getDataFromDB(iformObj, query);
		logger.info(comboValues);

		for (List<String> value : comboValues) {
			final_level = value.get(0);
			logger.debug("final_level :: " + final_level);
			setControlValue(iformObj, "FINAL_ROUTING_LEVEL", final_level);
		}

		return "SUCCESS";

	}
*/
	private String fillTrassetData(IFormReference iformObj, String stringdata) {

		String cic_no = getControlValue(iformObj, "Q_NG_POS_COMPANY_DATA_CIC");
		// String wi_name=getControlValue(iformObj, "WI_NAME");

		String query = "SELECT CIC,CUST_NAME,LIMIT_REF,TICKET,CONTRACT_AMOUNT,LIMIT_DESC,LIMIT_UTIL_AMOUNT,LIMIT_UNUTIL_AMOUNT,PRODUCT,REVOLVING,PROFIT_RATE_TYPE,PROFIT_RATE,TENOR,TOTAL_NO_INSTALLMENT,FREQUENCY_OF_INSTALLMENT,CAST(INSTALMENT_AMOUNT AS NUMERIC(20,2)),NO_INSTALLMENT_PAID,NO_OVERDUE_INSTALLMENT,CONTRACT_EFFECTIVE_DATE,CONTRACT_EXPIRY_DATE,NEXT_INSTALMENT_DUE_DATE,OUTSTANDING_PRINCIPAL,OUTSTANDING_PROFIT,GROSS_OUTSTANDING,PDO_AMOUNT,PDO_DATE,WRITE_OFF,CONTRACT_STATUS,ORR,RM_CODE,RM_NAME,CLIENT_ACCOUNT_NUMBER FROM NG_MAST_TRASSET_DATA WHERE CIC='" + cic_no + "' ";
		List<List<String>> result = getDataFromDB(iformObj, query);
		logger.info("Trasset Query is "+query +" and its result is "+result);
		try {
			if(result.size()>0)
			{
				logger.info("result from mast data is" + result);
				logger.info("result at 0 index is " + result.get(0));
				logger.info("result at 0,0 index is" + result.get(0).get(0));
	
				JSONArray jsonarray = new JSONArray();
				JSONObject jsonobject;
	
				//List<List<String>> resultfromDB = getDataFromDB(iformObj, query);
				logger.info(result);
				for (List<String> value : result) {
					jsonobject = new JSONObject();
					logger.info("Suze of value is "+value.size());
					jsonobject.put("CIC Number",value.get(0));
					jsonobject.put("Customer Name",value.get(1));
					jsonobject.put("Limit ref No",value.get(2));
					jsonobject.put("Tr Reference (Contract No)",value.get(3));
					jsonobject.put("Contract Amount",value.get(4));
					jsonobject.put("Limit Description",value.get(5));
					jsonobject.put("Limit Utilized Amount",value.get(6));
					jsonobject.put("Limit UnUtilized Amount ",value.get(7));
					jsonobject.put("Product Name",value.get(8));
					jsonobject.put("Revolving/Non Revolving",value.get(9));
					jsonobject.put("Profit rate Type",value.get(10));
					jsonobject.put("Profit Rate",value.get(11));
					jsonobject.put("Tenure of financing",value.get(12));
					jsonobject.put("Total No of Instalment",value.get(13));
					jsonobject.put("Frequency ",value.get(14));
					jsonobject.put("Instalment Amount",value.get(15));
					jsonobject.put("No of instalments paid",value.get(16));
					jsonobject.put("No of Overdue Instalments",value.get(17));
					jsonobject.put("Contract Effective date",value.get(18));
					jsonobject.put("Contract Expiry date",value.get(19));
					jsonobject.put("Next instalment due date",value.get(20));
					jsonobject.put("Outstanding principal",value.get(21));
					jsonobject.put("Outstanding Profit",value.get(22));
					jsonobject.put("Gross Outstanding",value.get(23));
					jsonobject.put("PDO Amount",value.get(24));
					jsonobject.put("PDO date (oldest) - DPD",value.get(25));
					jsonobject.put("Write Off",value.get(26));
					jsonobject.put("Contract Status",value.get(27));
					jsonobject.put("ORR",value.get(28));
					jsonobject.put("RM Code",value.get(29));
					jsonobject.put("RM Name",value.get(30));
					jsonobject.put("Client Account Number",value.get(31));
					/*
					jsonobject.put("Trasset Ref No", value.get(1));
					jsonobject.put("Product Name", value.get(2));
					jsonobject.put("Revolving", value.get(3));
					jsonobject.put("Profit Rate Type", value.get(4));
					jsonobject.put("Profit Rate", value.get(5));
					jsonobject.put("Effective Date",value.get(8));
					jsonobject.put("Expiry Date", value.get(9));
					jsonobject.put("Amount Internal",value.get(11));
					jsonobject.put("Amount Total Understanding",value.get(12));
					jsonobject.put("Outstanding Amount", value.get(13));
					jsonobject.put("Available Amount", value.get(14));
					jsonobject.put("ORR", " ");
					jsonobject.put("Days in PDO", value.get(16));
					jsonobject.put("PDO Amount", value.get(17));
					jsonobject.put("Write Off", value.get(18));
					jsonobject.put("RM code", value.get(20));
					jsonobject.put("RM Name", value.get(21));
					jsonobject.put("TL Name", value.get(22));
					*/
					jsonarray.add(jsonobject);
				}
				logger.info("Jsonarray for trasset details is "+jsonarray);
				iformObj.addDataToGrid("Q_NG_POS_CREDITLINE_TRASSET_DET_GRID", jsonarray);
			}
		}
		catch(Exception e)
		{
			logger.info("Exception occurred: fillTrassetData: Database Query "+query+" and stack trace is"+e);
		}		
		return "Trasset Data filled succesfully";
	}

	 //Replaced on 26 FEb
	/* 
	private String setRoutingLevel(IFormReference iformObj,String stringdata) 
	  { 
       logger.info("Inside setRoutingLevel function");
       //getWorkitemName(iformObj)
       String query="select max(route_level) as final_level from( select min(c.level_id) as route_level from ng_pos_exttable A, ng_mast_authority_matrix B, ng_mast_level_mapping c where A.channel=B.filter and A.channel=c.filter AND B.process_name=C.process_name AND b.approval_type=C.approval_type AND B.filter=C.filter and b.APPROVAL_TYPE='Business' AND B.level_id=C.level_id and convert(float,B.amt)>=convert(float,A.app_limit_amt) AND a.wi_name='"+getWorkitemName(iformObj)+"' UNION select max(C.level_id) as route_level from ng_pos_exttable A, ng_mast_authority_matrix B,ng_mast_level_mapping c WHERE A.channel=B.filter and A.channel=c.filter and b.APPROVAL_TYPE='Business' and B.process_name=C.process_name AND b.approval_type=C.approval_type and B.filter=C.filter and B.level_id=C.level_id AND (A.no_of_exception=B.no_of_exception or A.no_of_exception>B.no_of_exception) AND a.wi_name='"+getWorkitemName(iformObj)+"') D ";
       String final_level=""; 
       List<List<String>> comboValues = getDataFromDB(iformObj,query);
       logger.info("For setting routing values db result is "+comboValues);
	  
		for (List<String> value : comboValues)
		{
			final_level = value.get(0);
			logger.debug("final_level :: " + final_level);
			setControlValue(iformObj, "FINAL_ROUTING_LEVEL", final_level);
		}

		return "setRoutingLevel set successfully";
	  
	  }
	 */
	
	private String setRoutingLevel(IFormReference iformObj,String stringdata) 
    { 
  logger.info("Inside setRoutingLevel function");
  String numberOfException=iformObj.getValue("NO_OF_EXCEPTION").toString();
  String approval_type;
  String RCODChannel;
  if (stringdata.equalsIgnoreCase("Credit Officer"))
  {
     approval_type="Credit Risk";
   
     if(numberOfException.equalsIgnoreCase("0"))
     {
        RCODChannel="Branch";
     }
     else
     {
        RCODChannel="Head Quarter";
     }
     
     String pricing_waiver_query="SELECT COUNT(*) FROM NG_POS_PQLIST_STATUS_GRID WHERE WI_NAME ='"+getWorkitemName(iformObj)+"' AND PQ_DESCRIPTION='Pricing Max waiver of Rate/Fees ' AND PQ_STATUS='Fail' ";
     List<List<String>> pricing_waiver_query_result = iformObj.getDataFromDB(pricing_waiver_query);
     logger.info("Query to check whether Pricing wavier failed for this case or not is "+pricing_waiver_query+" and it's result is "+pricing_waiver_query_result);
     if(pricing_waiver_query_result.size()>0)
     {
    	 if(pricing_waiver_query_result.get(0).size()>0)
    	 {
    		 if(pricing_waiver_query_result.get(0).get(0).equalsIgnoreCase("1"))
    		 {
    			 try 
    			 {
	    			 int numberOfException_int=Integer.parseInt(numberOfException);
	    			 if(numberOfException_int>0)
	    			 {
	    				 numberOfException_int=numberOfException_int-1;
	    				 numberOfException=Integer.toString(numberOfException_int);
	    			 }
    			 }
    			 catch(Exception e)
    			 {
    				  
    			 }
    		 }
    	 }
     }
     
  }
  else
  {
     approval_type="Business";
     RCODChannel=iformObj.getValue("CHANNEL").toString();
  }
  String query="select max(route_level) as final_level from( select min(c.level_id) as route_level from ng_pos_exttable A, ng_mast_authority_matrix B, ng_mast_level_mapping c where A.channel=B.filter and A.channel=c.filter AND B.process_name=C.process_name AND b.approval_type=C.approval_type AND B.filter=C.filter and b.APPROVAL_TYPE='"+approval_type+"' AND B.level_id=C.level_id and convert(float,B.amt)>=convert(float,A.app_limit_amt) AND a.wi_name='"+getWorkitemName(iformObj)+"' UNION select max(C.level_id) as route_level from ng_pos_exttable A, ng_mast_authority_matrix B,ng_mast_level_mapping c WHERE A.channel=B.filter and A.channel=c.filter and b.APPROVAL_TYPE='"+approval_type+"' and B.process_name=C.process_name AND b.approval_type=C.approval_type and B.filter=C.filter and B.level_id=C.level_id AND (A.no_of_exception=B.no_of_exception or A.no_of_exception>B.no_of_exception) AND a.wi_name='"+getWorkitemName(iformObj)+"') D ";
  String query2="";
  if(approval_type.equalsIgnoreCase("Credit Risk"))
  {
         query2="select max(cast(iif(minimum_level_credit='',0,minimum_level_credit) as numeric)) as minimum_level from NG_POS_PQLIST_STATUS_GRID where wi_name = '"+getWorkitemName(iformObj)+"' ";
  }
  else
  {
         query2="select max(cast(iif(minimum_level='',0,minimum_level) as numeric)) as minimum_level from NG_POS_PQLIST_STATUS_GRID where wi_name = '"+getWorkitemName(iformObj)+"' ";
  }
  int final_level=0; 
  try
       {
              List<List<String>> comboValues = iformObj.getDataFromDB(query);
              List<List<String>> query2_comboValues = iformObj.getDataFromDB(query2);
              logger.info("Query for routing level query is "+query+" and its result is "+comboValues);
              logger.info("Query for routing level query2 is "+query2+" and its result is "+query2_comboValues);
              if(comboValues.size()>0  && query2_comboValues.size()>0)
              {
                     if(comboValues.get(0).size()>0 && query2_comboValues.get(0).size()>0 )
                     {
                     final_level=Math.max(Integer.parseInt(comboValues.get(0).get(0)),Integer.parseInt(query2_comboValues.get(0).get(0)));
                     }
                     
              }
              
              if(approval_type.equalsIgnoreCase("Credit Risk"))
        {
            setControlValue(iformObj, "FINAL_ROUTING_LEVEL_CREDIT", Integer.toString(final_level));
        }
        else
        {
            setControlValue(iformObj, "FINAL_ROUTING_LEVEL", Integer.toString(final_level));
       }
       }
  catch(Exception e)
       {
              logger.info("Exception occurred : setRoutingLevel and exception is "+e);
       }
        
         query="select actual_description from ng_mast_level_mapping where APPROVAL_TYPE='"+approval_type+"' and LEVEL_ID='"+final_level+"' and FILTER='"+RCODChannel+"'";
         String actual_description=""; 
         List<List<String>> actual_description_Values = getDataFromDB(iformObj,query);
         logger.info("For setting routing values db result is "+actual_description_Values);
           
                for (List<String> value_new : actual_description_Values)
                {
                      actual_description = value_new.get(0);
                      logger.debug("actual_description :: " + actual_description);
                      if(approval_type.equalsIgnoreCase("Credit Risk"))
                      {
                             setControlValue(iformObj, "FINAL_ROUTING_LEVEL_CRD", actual_description);
                             
                      }
                      else
                      {
                             setControlValue(iformObj, "FINAL_ROUTING_LEVEL_BUSS", actual_description);
                      }
                      
                }
         return "setRoutingLevel set successfully";
    
    }




	
	// chirag-start
	Properties p;

	public void loadProperties() {
		logger.info("insise loAD properties" + System.getProperty("user.dir"));

		p = new Properties();
		String sConfigFile = System.getProperty("user.dir") + System.getProperty("file.separator")
				+ "template_generation_AlRajhi" + System.getProperty("file.separator") + "template_gen.properties";

		try {
			logger.info("properties try block");
			p.load(new FileInputStream(sConfigFile));
		} catch (IOException e) {

		}
	}

	public String generateTemplate(IFormReference iformObj, String stringdata) {

		logger.info("inside generate tempalte method");
		WDGeneralData wdgeneralObj = iformObj.getObjGeneralData();
		loadProperties();
		String sJtsIp = p.getProperty("sJtsIp");
		String sJtsPort = p.getProperty("sJtsPort");
		String pStorageDIR = p.getProperty("storageDIR_gen_templates");
		String attachInOD = p.getProperty("attachInOD");
		String socketIP = "127.0.0.1";
		int portNo = Integer.parseInt(p.getProperty("utlity_serversocket_portNo"));
		logger.info("sJtsIp " + sJtsIp);
		logger.info("sJtsPort " + sJtsPort);
		logger.info("portNo " + portNo);
		logger.info("pStorageDIR " + pStorageDIR);
		logger.info("attachInOD " + attachInOD);
		logger.info("socketIP " + socketIP);

		String serverName = "Jboss";
		String sServerIp = iformObj.getServerIp();
		String sServerPort = iformObj.getServerPort();
		String sSessionId = wdgeneralObj.getM_strDMSSessionId();
		String sCabname = iformObj.getCabinetName();
		String sWIName = getWorkitemName(iformObj);
		String sProcessName = iformObj.getProcessName();
		String sTemplateName = stringdata;
		String filetype = "DOC";
		String COLLATERAL = "collateral";
		COLLATERAL = (COLLATERAL == null) ? "" : COLLATERAL;

		final String SS_EXEC_ERROR_MSG = "Error from Call Client Socket Server while Web-Service execution";
		final String SS_CONN_ERROR_MSG = "Could not connect to Call Client Socket Server";

		String iBPSserverIP = iformObj.getServerIp();
		String iBPSserverPort = iformObj.getServerPort();

		logger.info("\n");
		logger.info("serverName " + serverName);
		logger.info("sServerIp " + sServerIp);
		logger.info("sServerPort " + sServerPort);
		logger.info("sSessionId " + sSessionId);
		logger.info("sCabname " + sCabname);
		logger.info("sWIName " + sWIName);
		logger.info("sTemplateName " + sTemplateName);
		logger.info("sProcessName " + sProcessName);
		logger.info("filetype " + filetype);
		logger.info("System.getProperty user.dir  " + System.getProperty("user.dir"));
		logger.info("\n");
		logger.info("COLLATERAL:" + COLLATERAL);
		logger.info("iBPSserverIP:" + iBPSserverIP);
		logger.info("iBPSserverPort:" + iBPSserverPort);
		System.err.println("Data Receieved");
		String responseXml = null;
		String requestXml = null;

		System.err.println("portNo to listen from SocketCall.jsp : " + portNo);

		requestXml = "WI_NAME=" + sWIName + "~~JTS_IP=" + sJtsIp + "~~JTS_PORT=" + sJtsPort + "~~SESSION_ID="
				+ sSessionId + "~~SERVER_IP=" + sServerIp + "~~SERVER_PORT=" + sServerPort + "~~SERVER_NAME="
				+ serverName + "~~CABINET_NAME=" + sCabname + "~~PROCESS_NAME=" + sProcessName + "~~TEMPLATE_NAME="
				+ sTemplateName + "~~FILE_TYPE=" + filetype + "~~pStorageDIR=" + pStorageDIR + "~~attachInOD="
				+ attachInOD + "~~COLLATERAL=" + COLLATERAL + "~~iBPSserverIP=" + iBPSserverIP + "~~iBPSserverPort="
				+ iBPSserverPort;

		logger.info("requestXml " + requestXml);

		try {
			String tempResponseXml = null;
			try {
				Socket client = new Socket(socketIP, portNo);
				client.setSoTimeout(3600000);
				DataOutputStream outData = new DataOutputStream(client.getOutputStream());

				String dataToBeSent = requestXml;
				byte[] dataByteArr = dataToBeSent.getBytes("UTF-8");
				outData.writeInt(dataByteArr.length);
				outData.write(dataByteArr);

				DataInputStream in = new DataInputStream(client.getInputStream());

				int dataLength = in.readInt();
				byte[] data = new byte[dataLength];
				in.readFully(data);
				tempResponseXml = new String(data, "UTF-8");

				in.close();
			} catch (UnknownHostException e) {
				tempResponseXml = SS_CONN_ERROR_MSG;
				logger.info("UnknownHostException  " + e);
			} catch (IOException e) {
				tempResponseXml = SS_CONN_ERROR_MSG;
				logger.info("IOException  " + e);
			} catch (Exception e) {
				tempResponseXml = SS_EXEC_ERROR_MSG;
				logger.info("Exception  " + e);
			}

			if (tempResponseXml == null || tempResponseXml.length() == 0) {
				responseXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<message>\n"
						+ "<ErrorCode>1</ErrorCode>\n"
						+ "<ErrorDesc>No Response Received from Call Client Socket Server.</ErrorDesc>\n"
						+ "</message>";
				logger.info("tempResponseXml 12  ");
			} else {
				if (tempResponseXml.equals(SS_EXEC_ERROR_MSG) || tempResponseXml.equals(SS_CONN_ERROR_MSG)) {
					responseXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<message>\n"
							+ "<ErrorCode>1</ErrorCode>\n" + "<ErrorDesc>" + tempResponseXml + "</ErrorDesc>\n"
							+ "</message>";
					logger.info("tempResponseXml 13  ");
				} else {
					logger.info("tempResponseXml 14  ");
					responseXml = tempResponseXml;
				}
			}
			logger.info("tempResponseXml 15  ");
		} catch (Exception e) {
			logger.info("tempResponseXml 16  ");
			responseXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<message>\n" + "<ErrorCode>1</ErrorCode>\n"
					+ "<ErrorDesc>Error while generating template.</ErrorDesc>\n" + "</message>";
		}
		if(responseXml.contains("<Status>0</Status>"))
		{
			logger.info("inside ifffffff@@@@@");
			return "template generated";
		}
		else
		{
			logger.info("inside else@@@@@");
			return responseXml;
		}
	//Chirag -end
	}
	
	

	//ashutosh-start
	public String Documentgrid(IFormReference iformobj, String stringdata) {
		// on upload button
		logger.info("Inside handling of Documentgrid");
		try {
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String wi_name=getWorkitemName(iformobj);
		/*logger.info("inside try");
		String winame = getWorkitemName(iformobj);

		String data = "SELECT UPLOAD_STATUS,UPLOAD_DATE_TIME FROM NG_POS_DOCUMENT_GRID where WI_NAME='" + winame + "' ";
		logger.info("query is @@-----" + data);



		List<List<String>> dataresult = iformobj.getDataFromDB(data);
		logger.info("dataresult is @@-----" + dataresult);

		logger.info("string data value@@@" + Stringdata);
		int colIndex_status = 3;
		int colIndex_datetime=4;
		logger.info("colindex of status is----" + colIndex_status);
		logger.info("colindex of date_time is----" + colIndex_datetime);
		*/
		String document_name="";
		int rowindex;
		if(stringdata.contains("#"))
		{
			document_name=stringdata.split("#")[1];
			rowindex = Integer.parseInt(stringdata.split("#")[0]);
		}
		else
		{
			rowindex = Integer.parseInt(stringdata);
		}
		String query="UPDATE NG_POS_DOCUMENT_GRID SET UPLOAD_STATUS='success',UPLOAD_DATE_TIME='"+date+"' WHERE WI_NAME='"+wi_name+"' AND DOCUMENT_NAME='"+document_name+"'   ";
		logger.info("Query to update document grid for workitem no "+wi_name+"is "+query);
		iformobj.saveDataInDB(query);
		
		logger.info("rowindex is>>>>>" + stringdata);
	
		logger.info("date is$$$$"+date);
		iformobj.setTableCellValue("document_table", rowindex, 3, "success");
		iformobj.setTableCellValue("document_table", rowindex, 4, date);
		logger.info("if complete####");
		}
		catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
		logger.info("inside catch",e);
		}
		return "successfully added to document grid";
		// iformobj.addDataToGrid("document_table", jarray);
		}
//ashutosh-end
	

	public String generateTemplateWithCIC(IFormReference iformObj, String stringdata) {

		logger.info("inside generate tempalte CIC vala method");
		WDGeneralData wdgeneralObj = iformObj.getObjGeneralData();
		loadProperties();
		String sJtsIp = p.getProperty("sJtsIp");
		String sJtsPort = p.getProperty("sJtsPort");
		String pStorageDIR = p.getProperty("storageDIR_gen_templates");
		String attachInOD = p.getProperty("attachInOD");
		String socketIP = "127.0.0.1";
		int portNo = Integer.parseInt(p.getProperty("utlity_serversocket_portNo"));
		logger.info("sJtsIp " + sJtsIp);
		logger.info("sJtsPort " + sJtsPort);
		logger.info("portNo " + portNo);
		logger.info("pStorageDIR " + pStorageDIR);
		logger.info("attachInOD " + attachInOD);
		logger.info("socketIP " + socketIP);

		String serverName = "Jboss";
		String sServerIp = iformObj.getServerIp();
		String sServerPort = iformObj.getServerPort();
		String sSessionId = wdgeneralObj.getM_strDMSSessionId();
		String sCabname = iformObj.getCabinetName();
		String sWIName = getWorkitemName(iformObj);
		String sProcessName = iformObj.getProcessName();
		
	       logger.info("  1996 inside tamp generate with cic and sTemplateName");// "+sTemplateName+"  and cic_is"+cic_is);

		String sTemplateName = stringdata.split("##")[0]; 
		String cic_is = stringdata.split("##")[1];
		String rowhasindex = stringdata.split("##")[2];
		
		
       logger.info(" line no 4708 inside tamp generate with cic and stringdata value is "+stringdata+"sTemplateName "+sTemplateName+"  and cic_is"+cic_is+"rowhasindex "+rowhasindex);
		
		//String sTemplateName = stringdata;
		String filetype = "DOC";
		//String filetype = "PDF";
		String COLLATERAL = "collateral";
		COLLATERAL = (COLLATERAL == null) ? "" : COLLATERAL;

		final String SS_EXEC_ERROR_MSG = "Error from Call Client Socket Server while Web-Service execution";
		final String SS_CONN_ERROR_MSG = "Could not connect to Call Client Socket Server";

		String iBPSserverIP = iformObj.getServerIp();
		String iBPSserverPort = iformObj.getServerPort();

		logger.info("\n");
		logger.info("serverName " + serverName);
		logger.info("sServerIp " + sServerIp);
		logger.info("sServerPort " + sServerPort);
		logger.info("sSessionId " + sSessionId);
		logger.info("sCabname " + sCabname);
		logger.info("sWIName " + sWIName);
		logger.info("sTemplateName " + sTemplateName);
		logger.info("sCIC " + cic_is);
		logger.info("sProcessName " + sProcessName);
		logger.info("filetype " + filetype);
		logger.info("System.getProperty user.dir  " + System.getProperty("user.dir"));
		logger.info("\n");
		logger.info("COLLATERAL:" + COLLATERAL);
		logger.info("iBPSserverIP:" + iBPSserverIP);
		logger.info("iBPSserverPort:" + iBPSserverPort);
		System.err.println("Data Receieved");
		String responseXml = null;
		String requestXml = null;

		System.err.println("portNo to listen from SocketCall.jsp : " + portNo);

		
		requestXml = "WI_NAME=" + sWIName + "~~JTS_IP=" + sJtsIp + "~~JTS_PORT=" + sJtsPort + "~~SESSION_ID="
				+ sSessionId + "~~SERVER_IP=" + sServerIp + "~~SERVER_PORT=" + sServerPort + "~~SERVER_NAME="
				+ serverName + "~~CABINET_NAME=" + sCabname + "~~PROCESS_NAME=" + sProcessName + "~~TEMPLATE_NAME="
				+ sTemplateName + "~~FILE_TYPE=" + filetype + "~~pStorageDIR=" + pStorageDIR + "~~attachInOD="
				+ attachInOD + "~~COLLATERAL=" + COLLATERAL + "~~iBPSserverIP=" + iBPSserverIP + "~~iBPSserverPort="
				+ iBPSserverPort+ "~~CIC=" + cic_is +"~~rowhasindex=" + rowhasindex ;
		
		
		logger.info("requestXml " + requestXml);

		try {
			String tempResponseXml = null;
			try {
				Socket client = new Socket(socketIP, portNo);
				client.setSoTimeout(3600000);
				DataOutputStream outData = new DataOutputStream(client.getOutputStream());

				String dataToBeSent = requestXml;
				byte[] dataByteArr = dataToBeSent.getBytes("UTF-8");
				outData.writeInt(dataByteArr.length);
				outData.write(dataByteArr);

				DataInputStream in = new DataInputStream(client.getInputStream());

				int dataLength = in.readInt();
				byte[] data = new byte[dataLength];
				in.readFully(data);
				tempResponseXml = new String(data, "UTF-8");

				in.close();
			} catch (UnknownHostException e) {
				tempResponseXml = SS_CONN_ERROR_MSG;
				logger.info("UnknownHostException  " + e);
			} catch (IOException e) {
				tempResponseXml = SS_CONN_ERROR_MSG;
				logger.info("IOException  " + e);
			} catch (Exception e) {
				tempResponseXml = SS_EXEC_ERROR_MSG;
				logger.info("Exception  " + e);
			}

			if (tempResponseXml == null || tempResponseXml.length() == 0) {
				responseXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<message>\n"
						+ "<ErrorCode>1</ErrorCode>\n"
						+ "<ErrorDesc>No Response Received from Call Client Socket Server.</ErrorDesc>\n"
						+ "</message>";
				logger.info("tempResponseXml 12  ");
			} else {
				if (tempResponseXml.equals(SS_EXEC_ERROR_MSG) || tempResponseXml.equals(SS_CONN_ERROR_MSG)) {
					responseXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<message>\n"
							+ "<ErrorCode>1</ErrorCode>\n" + "<ErrorDesc>" + tempResponseXml + "</ErrorDesc>\n"
							+ "</message>";
					logger.info("tempResponseXml 13  ");
				} else {
					logger.info("tempResponseXml 14  ");
					responseXml = tempResponseXml;
				}
			}
			logger.info("tempResponseXml 15  ");
		} catch (Exception e) {
			logger.info("tempResponseXml 16  ");
			responseXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<message>\n" + "<ErrorCode>1</ErrorCode>\n"
					+ "<ErrorDesc>Error while generating template.</ErrorDesc>\n" + "</message>";
		}
		if(responseXml.contains("<Status>0</Status>"))
		{
			logger.info("inside ifffffff@@@@@");
			return "template generated";
		}
		else
		{
			logger.info("inside else@@@@@");
			return responseXml;
		}
	//Chirag -end
	}
	
	public String Base64DecodePdf (String hex,IFormReference iformObj,String docName)
    {
         String document_path=GetXML.getProp().getProperty("Broker_Document_Path");
         
         String fileLocation=document_path+"\\"+getWorkitemName(iformObj);
         //String fileLocation=document_path+"\\"+docName;
          String path="\\POS\\Broker Document"+"\\"+docName;
         //String path=docName;
         File file = new File(fileLocation);
         if (!file.exists())
         {
                file.mkdirs();
         }
         fileLocation=fileLocation+"\\"+docName;
         file = new File(fileLocation);
         logger.info("Broker Dcoument: File location for Base64DecodePdf " + fileLocation);
      logger.info("Broker Dcoument: Path for Base64DecodePdf " + path);
      try ( FileOutputStream fos = new FileOutputStream(file);) 
      {
        byte[] decoder = asByteArray(hex);
        fos.write(decoder);
        System.out.println("PDF File Saved");
        logger.info("PDF File Saved");
        fos.close();
        return fileLocation;
      }
      catch (Exception e) 
      {
        e.printStackTrace();
      }
      
      return "Error";
    }
	
	/*
	public String Base64DecodePdf (String hex,IFormReference iformObj,String docName)
    {
	  String document_path=GetXML.getProp().getProperty("Broker_Document_Path");
	  
	  String fileLocation=document_path+"\\"+getWorkitemName(iformObj);
	  //String fileLocation=document_path+"\\"+docName;
	   String path="\\POS\\Broker Document"+"\\"+docName;
	  //String path=docName;
	  File file = new File(fileLocation);
	  if (!file.exists())
	  {
		  file.mkdirs();
	  }
	  fileLocation=fileLocation+"\\"+docName;
	  file = new File(fileLocation);
	  logger.info("Broker Dcoument: File location for Base64DecodePdf " + fileLocation);
      logger.info("Broker Dcoument: Path for Base64DecodePdf " + path);
      try ( FileOutputStream fos = new FileOutputStream(file);) 
      {
        byte[] decoder = asByteArray(hex);
        fos.write(decoder);
        System.out.println("PDF File Saved");
        logger.info("PDF File Saved");
        fos.close();
        return fileLocation;
      }
      catch (Exception e) 
      {
        e.printStackTrace();
      }
      
      return "Error";
    }
	*/
	
  public static byte[] asByteArray(String hex) 
  {
           
           byte[] bts=new byte[hex.length()/2];
           for (int i=0;i<bts.length;i++)
           {
                  bts[i]=(byte) Integer.parseInt(hex.substring(2*i,2*i+2),16);
           }

             return bts;
 }
  /*
  private String BrokerDocumentcall_main(IFormReference iformObj, String stringdata) {
      logger.info("Inside document broker main function");
	  try {
    	  String requestXML=stringdata;
          // URL url = new URL ("http://ip:port/download_url");
          String urlStr="http://dpwt.alrajhibank.com.sa:7711/cgi-bin/bitonws.cgi";
          System.setProperty("http.maxRedirects", "30");
          CookieHandler.setDefault(new CookieManager(null,CookiePolicy.ACCEPT_ALL));
          URL url = new URL(urlStr);
          //String authStr = "FTSRAJB:ftsrajb" ;
          //String authEncoded = Base64.getEncoder().encodeToString((authStr).getBytes());;
          //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy1", 80));
          //Properties systemProperties = System.getProperties();
          // systemProperties.put("proxySetrue");
          //systemProperties.setProperty("http.proxyHost","proxy1");
          //systemProperties.setProperty("http.proxyPort","80");
          //System.setProperty("http.proxyUser", "ARBANK\\CON7004");
          //System.setProperty("http.proxyPassword", "FKwp9123");

          
          //HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
          System.out.println("requestXML is === "+requestXML);
          logger.info("Request xml is "+requestXML);
          
          
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("POST");
          connection.setDoOutput(true);
//            connection.setRequestProperty("Authorization", "Basic " + authEncoded);
//            connection.setRequestProperty("Proxy-Authorization", "Basic " + authEncoded);
          try(OutputStream os = connection.getOutputStream()) {
          byte[] input = requestXML.getBytes("utf-8");
          os.write(input, 0, input.length);
          }
          // File file = new File(outFilePath);
          // InputStream in = (InputStream) connection.getInputStream();
          String result="";
          
          result = new BufferedReader(new InputStreamReader( connection.getInputStream())).lines().parallel().collect(Collectors.joining("\n"));
          
          // OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
          System.out.println("result ==== "+result);
          logger.info("Broker Document Response is :::::"+result);
          }
          catch (Exception e) {
          e.printStackTrace();
          logger.info("Exception Occured Broker Document and exception is "+e);
          }


        return ""; 
  }
  */
  
  private String BrokerDocumentcall_main(IFormReference iformObj, String stringdata) 
  {
	  try
	  {
	  String response;
      XMLParser parser;
      String hex;
      String return_string="";
      String broker_ip=GetXML.getProp().getProperty("BrokerDocumentIP");
      String broker_port=GetXML.getProp().getProperty("BrokerDocumentPort");
      String broker_database_name=GetXML.getProp().getProperty("BrokerDocumentDataBaseName");
      String broker_volume=GetXML.getProp().getProperty("BrokerDocumentVolume");
      String wi_name=getWorkitemName(iformObj);
      
      logger.info("BrokerDocumentcall_main : For "+getWorkitemName(iformObj)+" IP is "+broker_ip+" ,Port is "+broker_port+" ,Database is "+broker_database_name+" ,Volume is "+broker_volume);
      //Start Edit By Deepak Goyal
      String folderindex="";
      String sQuery1="select folderindex from pdbfolder where  name = '"+getWorkitemName(iformObj)+"' ";
      List<List<String>> folderindexlist=iformObj.getDataFromDB(sQuery1);
      if(folderindexlist.size()>0)
      {
    	  if(folderindexlist.get(0).size()>0)
    	  {
    		  folderindex=folderindexlist.get(0).get(0);
    	  }
      }

      
      String document_list[] = null;
      if(getActivityName(iformObj).equalsIgnoreCase("Buy_and_Contract"))
      {
    	 document_list=new String[]{"DD&amp;Co Sellers Offer.pdf","DD&amp;Co Purchasers Acceptance.pdf","Holding Certificate.pdf","Customer Holding Certificate.pdf"};
    	 //document_list=new String[]{"Customer Holding Certificate.pdf"};
      }
      else if (getActivityName(iformObj).equalsIgnoreCase("Sell_and_Stipulation_Maker") || getActivityName(iformObj).equalsIgnoreCase("Stipulation_and_Sell_Checker"))
      {
    	  document_list=new String[]{"CTL Sellers Offer.pdf","CTL Purchasers Acceptance.pdf","Form of Delivery Instruction.pdf"};
      }
     // String document_list[]= {"Holding Certificate.pdf","DD&amp;Co Sellers Offer.pdf"};
    //End Edit By Deepak Goyal
      String document_name_modified="";
      for(String document:document_list)
	  {
		  try
	      {
	           
			  	logger.info("Calling BrokerDocumentcall from main function with document name" + document);
	             response=BrokerDocumentcall(iformObj,document);
	             logger.info("response from BrokerDocumentcall==" + response);
	             parser = new XMLParser(response);
	             logger.info("After parser");
	             hex=parser.getValueOf("pdfhex");
	             logger.info("hex value= "+hex);
	             document=document.replace("&amp;","");
	             String path=Base64DecodePdf(hex,iformObj,document);
	             logger.info("After Base64DecodePdf method call and path is "+path);
	             addDocumentToWorkitem(broker_ip,broker_port,broker_database_name,broker_volume,path,getSessionId(iformObj),folderindex,document,iformObj.getUserName(),"0");
	             if(hex.equalsIgnoreCase("")||hex==null)
	            	 return_string=return_string+document+"#"+"Error~";
	             else
	            	 return_string=return_string+document+"#"+"Success~";
	             
	            document_name_modified=document.replaceAll(".pdf", "");
	     	  	
	            if(document_name_modified.equalsIgnoreCase("Customer Holding Certificate"))
	     	  	{
	     	  		document_name_modified="Customer Holding Certificate";
	     	  	}
	     	  	else if(document_name_modified.equalsIgnoreCase("Holding Certificate"))
	     	  	{
	     	  		document_name_modified="Holding Certificate";
	     	  	}
	     	  	else if(document_name_modified.equalsIgnoreCase("DDCo Purchasers Acceptance"))
	     	  	{
	     	  		document_name_modified="DOCO Purchaser acceptance";
	     	  	}
	     	  	else if(document_name_modified.equalsIgnoreCase("DDCo Sellers Offer"))
	     	  	{
	     	  		document_name_modified="DDCO Seller Offer";
	     	  	}
	     	  	else if(document_name_modified.equalsIgnoreCase("CTL Purchasers Acceptance"))
	     	  	{
	     	  		document_name_modified="CTL Purchaser acceptance";
	     	  	}
	            
	            String query=" UPDATE NG_POS_DOCUMENT_GRID SET UPLOAD_STATUS='success',UPLOAD_DATE_TIME=GETDATE() WHERE WI_NAME='"+wi_name+"' AND DOCUMENT_NAME='"+document_name_modified+"' ";
	            logger.info("For updating document grid in case of broker docuemnt query is "+query);
	            iformObj.saveDataInDB(query);	
	      }
	      catch(Exception e)
	      {
	             logger.info("Exception in BrokerDocumentcall_main method ==== "+e);
	      }
	  } 
      int length=return_string.length() -1;
      if (return_string.endsWith("~"))
      	return_string=return_string.substring(0, return_string.length() - 1);  
	  
      return return_string;
	  }
	  catch(Exception e)
	  {
		  logger.info("Exception Occurred: in BrokerDocumentcall_main method ==== "+e);
	  }
      
      return "";
}
  //Parent Folder INdex=
  //volume=3
  
  private String addDocumentToWorkitem(String AppIP,String AppPort,String CabinetName,String Volume,String Path,String SessionID,String ParentFolderIndex,String DocumentName,String UserName,String DocSize)
  {
	  
      JPDBRecoverDocData jpidesc = new JPDBRecoverDocData();
      JPISIsIndex isindex = new JPISIsIndex();
      NGEjbClient ejbOb = null;
	try {
		ejbOb = NGEjbClient.getSharedInstance();
	} catch (NGException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      String sOutputXML="";
      String isIndex="";
      try {
             //CPISDocumentTxn.AddDocument_MT(null, "10.242.195.133",(short) 3333, "MSBNEWGEN_SIT", (short)3, "C:\\Users\\con7029\\Desktop\\Filenet\\Archived_Documents\\arabic.txt", jpidesc, "2", isindex, null);
             //CPISDocumentTxn.add(null, "10.242.195.133",(short) 3333, "MSBNEWGEN_SIT", (short)3, "C:\\Users\\con7029\\Desktop\\Filenet\\Archived_Documents\\arabic.txt", jpidesc, "2", isindex, null);
    	  	logger.info("AppIP == "+AppIP);
    	  	logger.info("AppPort == "+AppPort);
    	  	logger.info("CabinetName == "+CabinetName);
    	  	logger.info("Volume == "+Volume);
    	  	logger.info("Path == "+Path);
    	  	logger.info("SessionID == "+SessionID);
    	  	logger.info("ParentFolderIndex == "+ParentFolderIndex);
    	  	
    	  	logger.info("UserName == "+UserName);
    	  	UserName="pdf";
    	  	DocumentName=DocumentName.replaceAll(".pdf", "");
    	  	if(DocumentName.equalsIgnoreCase("Customer Holding Certificate"))
    	  	{
    	  		DocumentName="Customer Holding Certificate";
    	  	}
    	  	else if(DocumentName.equalsIgnoreCase("Holding Certificate"))
    	  	{
    	  		DocumentName="Holding Certificate";
    	  	}
    	  	else if(DocumentName.equalsIgnoreCase("DDCo Purchasers Acceptance"))
    	  	{
    	  		DocumentName="DOCO Purchaser acceptance";
    	  	}
    	  	else if(DocumentName.equalsIgnoreCase("DDCo Sellers Offer"))
    	  	{
    	  		DocumentName="DDCO Seller Offer";
    	  	}
    	  	else if(DocumentName.equalsIgnoreCase("CTL Purchasers Acceptance"))
     	  	{
    	  		DocumentName="CTL Purchaser acceptance";
     	  	}
    	  	logger.info("DocumentName == "+DocumentName);
    	  	logger.info("DocSize == "+DocSize);
    	  	DocSize="1960";
             CPISDocumentTxn.AddDocument_MT(null, AppIP, (new Short("3333")).shortValue(), CabinetName, (new Short(Volume)).shortValue(), Path, jpidesc, null, isindex);
             isIndex=(new StringBuilder()).append(isindex.m_nDocIndex).append("#").append(isindex.m_sVolumeId).append("#").toString();
             System.out.println("isIndex == "+isIndex);
             logger.info("isIndex == "+isIndex);
      } catch (JPISException e) {
             // TODO Auto-generated catch block
            // e.printStackTrace();
             logger.info("Exception in addDocumentToWorkitem method ==== "+e);
      }
      
      try
			{
				/*
				 * String inputXml = "<NGOAddDocument_Input>\n" +
				 * "<Option>NGOAddDocument</Option>\n" +
				 * "<CabinetName>"+CabinetName+"</CabinetName>\n" + "<UserDBId>" + SessionID +
				 * "</UserDBId>\n" + "<GroupIndex>0</GroupIndex>\n" + "<Document>\n" +
				 * "<ParentFolderIndex>" +ParentFolderIndex+ "</ParentFolderIndex>\n" +
				 * "<NoOfPages>1</NoOfPages>\n" + "<DocumentName>" + DocumentName +
				 * "</DocumentName>\n" + "<CreatedByAppName>"+UserName+"</CreatedByAppName>\n" +
				 * "<ISIndex>" + isIndex.trim()+"</ISIndex>\n" +
				 * "<DocumentType>I</DocumentType>" + "<DocumentSize>" +DocSize +
				 * "</DocumentSize>\n" + "<Comment>"+ DocumentName +"</Comment>" +
				 * "</Document>\n" + "</NGOAddDocument_Input>";
				 */
				String inputXml ="<?xml version=\"1.0\"?>\r\n"
				+ "<NGOAddDocument_Input>\r\n"
				+ "<Option>NGOAddDocument</Option>\r\n"
				+ "<CabinetName>"+CabinetName+"</CabinetName>\r\n"
				+ "<UserDBId>"+ SessionID +"</UserDBId>\r\n"
				+ "<GroupIndex>0</GroupIndex>\r\n"
				+ "<ParentFolderIndex>"+ParentFolderIndex+"</ParentFolderIndex>\r\n"
				+ "<DocumentName>"+ DocumentName +"</DocumentName>\r\n"
				+ "<CreatedByAppName>"+UserName+"</CreatedByAppName>\r\n"
				+ "<Comment>"+ DocumentName +"</Comment>\r\n"
				+ "<VersionComment>"+ DocumentName +"</VersionComment>\r\n"
				+ "<VolumeIndex>"+Volume+"</VolumeIndex>\r\n"
				+ "<FilePath>"+Path+"</FilePath>\r\n"
				+ "<ISIndex>"+ isIndex.trim()+"</ISIndex>\r\n"
				+ "<NoOfPages>1</NoOfPages>\r\n"
				+ "<DocumentType>I</DocumentType>\r\n"
				+ "<DocumentSize>"+DocSize +"</DocumentSize>\r\n"
				+ "</NGOAddDocument_Input>";
			logger.info("inputXml == "+inputXml);
			logger.info("Before logger == ");
			//logger.info("iFormReference.getObjGeneralData().getM_strJTSIP() == "+iFormReference.getObjGeneralData().getM_strJTSIP());
			//logger.info("iFormReference.getObjGeneralData().getM_strJTSPORT() == "+iFormReference.getObjGeneralData().getM_strJTSPORT());
			logger.info("After logger == ");
			  //sOutputXML= ejbOb.makeCall(AppIP,AppPort,"JBossEAP",inputXml);			  
			  sOutputXML = IFormCallBroker.execute(inputXml, "127.0.0.1", Integer.valueOf("3333"));
			  logger.info("sOutputXML == "+sOutputXML);
			   }
      
      catch(Exception exception)
      {
      System.out.println(exception.getMessage());
      logger.info("Exception Occurred: addDocumentToWorkitem and exception is "+exception.getMessage());
      // writeLog(callingFile,LOG_FILE_NAME,"Exception in get doc : " + exception.getMessage());
      
      }

      return sOutputXML;
  }
  private String BrokerDocumentcall(IFormReference iformObj, String document) {
         String callName="Broker_Document";
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
                
  
                for (String tag : tags) 
                {
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
                             parser.changeValue(request_prefix+tag, value);
                      }      
                }
                
                parser.changeValue("DocumentKey",document);
                
                logger.info("RequestXML is :\n" + parser.toString());
                String responseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);
  
                //String responseXML=" <?xml version=\"1.0\" encoding=\"UTF-8\"?><SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:ns=\"urn:bitonws\"><SOAP-ENV:Header></SOAP-ENV:Header><SOAP-ENV:Body><ns:getdocumentResponse><pdfhex>255044462d312e320a7a475fd5f9df4aa418b7b02373361fa66452204c84731f0a312030206f626a0a3c3c0a2f54797065202f436174616c6f670a2f50616765732033203020520a2f4f75746c696e65732032203020520a3e3e0a656e646f626a0a322030206f626a0a3c3c0a2f54797065202f4f75746c696e65730a2f436f756e7420300a3e3e0a656e646f626a0a332030206f626a0a3c3c0a2f54797065202f50616765730a2f436f756e7420310a2f4b696473205b203520302052205d0a3e3e0a656e646f626a0a342030206f626a0a5b2f504446202f54657874202f496d61676543205d0a656e646f626a0a352030206f626a0a3c3c0a2f54797065202f506167650a2f506172656e742033203020520a2f5265736f7572636573203c3c0a2f466f6e74203c3c0a2f4663706466302037203020520a3e3e0a2f584f626a656374203c3c0a2f494d63706466302038203020520a3e3e0a2f50726f63536574203420302052203e3e0a2f4d65646961426f78205b30203020353935203834325d0a2f43726f70426f78205b30203020353935203834325d0a2f526f74617465203237300a2f436f6e74656e74732036203020520a3e3e0a656e646f626a0a362030206f626a0a3c3c0a2f4c656e677468203933390a2f46696c746572205b2f466c6174654465636f64655d0a3e3e0a73747265616d0a789ced995d739b381486eff915e76aa7bb93ba86183bf19de38fadb7769c267432dd3b1904a815928b44b2fef77b643bc44e4dd234f8e382779c09c8801ea4f7708eb05daba3a0bef1cfded6e827d66a2bb2ac0bcffa30f067415887f39a8b6d5e68990df04696f5c3da7a8155a3ebacf65be7ad5abd5177d7aefcde7e06e091c3769adbbe696c6dc5e33f0cc74bd69eb43e3f0fd76a3e81f35e80db7ac6bb5b1ac03f4400b8603b6db7d5ae9fc2974fe0b184c28e7545a2451ff69fe07db3bcbfcce7ddae3bfd153df054304f55c114a98229520e734d43b8943568d41db76983db689eba0db8eafd7b08983df659a81ce6e364d41b5efe0dddfeb5371c0cbb1daf0f83c9355c7546a34e6ff865bc4f983df4f5a272985b0abe14214b13d031d1d0ebfdd195306209d398b8ee89c2660a4a720af25ed01464b8680925e7f29e8908ba324964c034a3aafd469872eff1f794c33cdcd7bc8d89947312b02c3918cc30a042b390f944332930cadbfb8ff21ce6734610c60ccce9995d3b3b072f95739864c2a76ad7103fc1ecabc3e794c3783155743d2220267714a6940a13430168b93f980e876bf22d667041c47713a9440430147754e904dd8498e94ca64b43ed1c06fbc082d814c24edd71f0f191c21de119dd68ddb18ed4334c3f3c5c55cc66cb072c53b98be6e821b5b4904e8950214d535ab2938ed3333bebe1155a0fed8dc0c63909a8268ce35c90a9c428bf679ce33c414c31d01906bcc6918ae8c2eb25c31cd534cda8080c434a7dca66da18f8357c4c289d66bed9fefdec719c9e79cd303cb8873332e54bd3dcac0c64ceba2121fa2f434f0573e8c6248d7e31d7e6306c59b82dbdbae1e474e559d36722710f2b410152a0a565bae00ec8bcdc9129e56a6f540e6356029dcb1e4c2ee1a2ffb1331ac064703098cd02fc303ace693a3488d15a3ac0148d1f82cba76496695c194514533831b316483f33017e8247a80c1ba6733c50513fc3e09a71a231d2924558631651991f9fe0291889426a7c8afec8181e86c7b348108da7d45e82d9eb1014a88229520553a40aa648154c912a98225530455a7b431e3185b91a53f2240c994fdb70da849b9804e0c524a1eac4d4e414ec0ebc878b0c17e6a9825bacb643dc63dc2c734e6024458005fb4ddf06e76bbf14185c2df645c4171501fedd128ed5807995ef3867ad33770743f214a6a394f419562fe0a524a030a6c9f4f16defea96c7b8e0e5d0ffcfc7f54154fecf978f3038377c01b315e30a2b2826b26505f5f86e764cd2ef54970e53d605dfa2b51f70fb9ef53fe93f35120a656e6473747265616d0a656e646f626a0a372030206f626a0a3c3c0a2f54797065202f466f6e740a2f53756274797065202f54797065310a2f4e616d65202f4663706466300a2f42617365466f6e74202f436f75726965720a2f456e636f64696e67202f4d6163526f6d616e456e636f64696e670a3e3e0a656e646f626a0a382030206f626a0a3c3c0a2f54797065202f584f626a6563740a2f53756274797065202f496d6167650a2f4e616d65202f494d63706466300a2f5769647468203137380a2f4865696768742036350a2f46696c746572202f4443544465636f64650a2f42697473506572436f6d706f6e656e7420380a2f436f6c6f725370616365202f4465766963655247420a2f4c656e67746820343531340a3e3e0a73747265616d0affd8ffe000104a46494600010101005f005f0000ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108004100b203012200021101031101ffc4001d000100020301010101000000000000000000060804050703090102ffc4004610000103040102020506070f05000000000102030400050611071221083113142241511532376175b31823527172819109243842545662739394a1b1b4d1d316333536f0ffc4001c0100010403010000000000000000000000000102030504060708ffc4003a1100010302030308070705000000000000010002110321041231054151062232617191a1b11333427281c1d11415343562e1f043525392b2ffda000c03010002110311003f0086e1189dff0039c805b6ccc2a43eb3d6fbee1210d249eeb5abddfe24fbb7567f02e01c3ac4cb6fdf1b55fa7800a8bfb4b093fd16c798fd2dfe6152ce1dc222e0b85c5b625b47afba90ecf78772e3a4771bfc94fcd1f50df993532aa7c06caa749a1f544bbaf72e8fcabe5ee331d5dd87c0bcb288b02db1745a49d403b808b6badb16db6eb7db1811edb022c26479371d94b69fd890056552956e00160b9d39ce79cce327ad2bc66c48b363aa3cc8ccc9655f39b75b0b49fd47b57b52948948d71699060ae599df0561191b2e3b6f882c33ceca5e849d364ff49af9bafd1e93f5d55be46c1afb825f3e4dbcb23a57b54692decb4fa47bd27e23de0f71fac137dea37c93885bb37c4e558e7a52952c75c67fa76a61d1f3563fc88f7824554e3b65d3acd2ea621de6ba0725b9798dd9b59b4b18f35289b19b96f583adb7824c8d20afeb8c16b738d31771c5296b559e21529476492ca3b9a915697028326d783582d9310112625b2330f241df4ad0d252a1fb41ad95ca3bb2e03d1989d2203ae20a53263a5b2e347f2921c4a91bfd2491f5559d11cc683c07905a4e3dcd762eab9a6c5ce8eccce85914aab3c2f99725665cdb9760b76e47bb3506ca2488ef45b75bd0eacb6fa5b4f5f547503d8ece80ef526e3fe5cc9ec5cd4ff0f7263d0e74b2426d77b623fab997d492b47a5403d00a9242474000293d3ed6faaaeeaec5acc25ad70738343e04ce5226448bc0d46bdab00d402677183dbf4eb56029557797b36e47c63c4663581db3902e62cd7c5c6539d76f80a7580ebea42928518fad009edd409f8eeb77ca7c8f9c70866d687321bb2b2ec2af2be953d221b4d4e82a4001690a61286d7bea0b1d48d900a7d9d75146ec6aaf14f238135012d17131a8b889b181bf8a573f29708d2e7b0ab0f4ac7626c6916d45c633a97e2b8c87db71bf682d0475023e3b1557cf3066d937145d39271bc8cc1b9c2c81a8113194c165d66536a5a02193b417d6ead2bd9285a77d2a094a75bac6c26cfab8a2436d04033c5c4803bc5f86f4a5c201e3a774f92b514ac7b63b25eb6c57a6b023ca719429e642b7e8d6402a4efdfa3b15c324728e51c8bcc52f8e78de6b365b659ca9579bfae3a243bb42c24a1842f6df756d1d4a0adf75003a7da661f075310e706c434124ee006ffa46bb905e03339d2de3a0ed5dee95cdb278fc878c3b69936acacdfad922eb0e3dcd37684c092c32e3c94294c2e3a1a477ea0085a1474490a1ad54c723cab18c68b0323c8ecf66f58eaf43ebf35b8fe93a75be9eb50deb637af88a63b0e79b90e699d266dd512941bc2dc52bf10a4ad095a1414950d820ec11f1afdac74a94a528425294a10be61f3e4d98df36e6886e5c84245ee50094b8401f8d55423e509ffcba4ff6aaff007a97f880fa70cd7edb95f7aaa83576dc0b1bf66a76f65be415738dcacaf9427ff2e93fdaabfde9f284ff00e5d27fb557fbd62d2b2bd1b780ee4d957efc03baebdc252d6f38b715f2dbe3a94a24ff00da66ac1557af003f41f2bedb91f74cd585ae39b6c46d0adef1f92b0a7d0094a563dca3bb2e03d1989d2203ae20a53263a5b2e347f2921c4a91bfd2491f555584f5537c2eff000b7e4bfcf3bfd626b1399633f9278e8c5adf67415bf6f54054a2dff152d2cbeb27e1a6c8ff00eed5d9712e03b4629955c729b0e739945bc5cc2fd724a9705d2ef5ac2d5ecae2948da803d80a9771ef1a62b844a9972b5c7912af370ef3eed3de2fcb9449d92a59ec9d9d6c20241d0edd856d5536be1a9e23ed34c97114c300822f97292677789ea503e9b9e2a37fb8cfc3eaabbf88bfe19fc73f9a07faa72b71fba1f299384e2d6a4a7ae648ba2dd6903ba8a52d949d0f3f37135d1b2ae07b364b9f44ce6e99965cabdc25a150dd42e1844708595a12947ab7490924fce049f7935beb7f1463a3316731c8665d32abf46e910e5dddc6c88800ec1a699436d27bfb5be827abb83ba653da585a670af924d1699106e649001368bdcf7029ce0ecef70de001dd0b94665c9773e368bc5dc58f4df91654cb6c145e2eeb421c721363a5b21b0b0a475152160a9614123be8f98805c202fc32f88545fd56bf5cc2af614db523d1871d8edac82b425676a0b41efadfb68fafe6d95e62e22c3b94e0c667258f25a9314fef79d0dc0dbeda4904a76a4a925275e4a075eed1ef5abb270360f131a38fde9fbfe57092d966322f97371f4c36fa529096109e96da2027b2d290b009015a3aa5c36d5c1d3a52e065d98546c74b312410e9b16cda7e69aea47286036811d446ff008ac2e0eb7c79ee5cf374e6779b8c0bfcb7938f43957d7e434c464ec766d6b3b7094a9452ada9b000f64850ae37e05d2f58796b3bc5ef20b3770d0eb439f3ca9a79495f7f7f7583f5f9d778e1ae11c278ae5cd9d8f09f2a74c4fa354a9eea1c710dec1f468e94a40492013db674367b0ad8669c518b64b94c4cb9b55c2c593c55a14dde2d2f066428246ba16149536e248f64f5a4ed23a7cbb545f78e19afaf441269d46800c00446961a8e3bc9bf5252c73997d667b7e9d5c3bd4e96b42002b5a520909049d7727407eb355738adf7b24f10dccf27274071c8d01eb736d3c9eae889d6a484807f8a528493db44ab7efefdfed78836ccf62e17abeddf249515457117722ca5119446ba92db0db6d95e89016a4958054028051074d95f15596f792cfc8e15def58f5cae90156fb93b6a719489ac9000f48975b70050034169095007cfcb55f83af4680aac27a6d89836320f6dc083f052ce9d45a7b8cae79e02eed76b970b3f1ee2b75c8f02e8ec784b7093a6ba1b5740dfb8294afdbaf75582ad36158bd8f0dc6a263b8ec1443b7c54e908076493dca944f75289ee49adcd45b4f12cc562ea56a62038c8fe75ebf151d16163034a5294ac152a5294a10be5df880fa70cd7edb95f7aaa8354e7c407d3866bf6dcafbd5541abb8607f0b4fdd6f9055aee914a529594915f8f003f41f2bedb91f74cd585aaf5e007e83e57db723ee99ab0b5c676dfe635bde3f25614fa012bc2e1321dba0bf3ee12d889123a0b8f3efb810db6803654a51ec00f89af7a5558eb4f5126793b8d9f790cb3c85893aeb8a094211798e54a513a0000bee6a5b550f831a691e3933a4a1b4242533c8012068979bd9ff0013fb6ade2b7a3d2013ee04eaacb69e0a9e11cc6b09399ad75e37898b704c6b897b9bc0c2c0b7deecd71b8cdb75beef025cd80a4a6647624a16ec6277a0e241da09d1d6f5e46b3eab478799f6c5f37729a2cf8a2a0e46da9c3283d7d2fc371e4bca0a4b67d592b4214bf68a941647b923cab2b1ff0013175bee0d7fc96d9c5d324aac4e8f5c6dbbaa7d0b6c7492a70baa68771af9894a8eb64f48f39ab6c7ad9f2d2120061325a3a62dbf49b03de8cd720f123c2558dac0bedeacf61806e17dbb40b5430a083226c8432d851f21d4a206cfc2b87e41e24bd578eed79e5938faeb73b1bca4b57194f4a4c64447c9d7a246d254f688502b4a423c875751294e178c0bf63d75e10c7efb3ec726ef60b94a62430e46ba7a949656b694b6c8059750a051d615bf2d8d6fcc368ec8afe9a9b2b3480e765b413235113ac5c031295af6bb4e13fcf9f05630104020820f9114aac3e2373dcaecb078e31bc722c2b7d9afca8aad7ae2cbee25059fdeeb5747b0dfb690543a94a1e600d85758ce7931fc47fe9db24db24697986432447856b893d4a8e3db014e2e429a494a024824fa3277d802015063f65560c639b7ce5c00dfcd2412786867845ca636a0204f007aaeba3569f23cab18c68b0323c8ecf66f58eaf43ebf35b8fe93a75be9eb50deb637af88a88e33cb16a97032e391454d92e587b8b1788c87fd6101b00a90eb4be9495a1691db6849df6d7913c57c457215c73af0cd22fcbc5576cb25d2e0d0b6483303cead2dbc46df6c2006ba82091d2a706c1048f67a9709b2ead5aed65410d96826ded5c44d8daf6dca4cc3cfc35fe75ab55025c59f0989d064b32a2c86d2eb2fb2e05b6e2143614950ec411dc115ed50ce0afa15c27ec185f708a99d60e2290a559f4c7b248ee247c9369bb3b03b8a5294a853d6af13be41c971c837db6b8171a6321c4f7d949f7a4fd60ec1fac56d2a9770772bcce3f9ab8535b72658a4afa9e6127db655e5e91bdf6deb5b1efd0f2ab758ae4f61ca6dc9b8582e91e73040eaf46af6907e0a49ee93f5102b03038f662982fcede16dbcaae4a62b61e25dcd26893cd76e8e07811a5f5d47010cbe7047135eef332f174c3d8933a6beb9121e54a7c171c512547417a1b27c876ac3fc1d385ff98d1bfbdc8ff92bab52aec6d0c5b440aae8f78fd56a191bc1729fc1d385ff0098d1bfbdc8ff00929f83a70bff0031a37f7b91ff0025756a52fde58cff002bbfd8fd5191bc168305c371ac1eccbb3e2b6b45b60b8faa42994bab582e10904ed649f248ede5dab6b77b843b4dae4dcee0fa23c48ad29d79c57925206cd6a331cd717c462a9fbfde234456b6967aba9e73f4503da3f9f5af8d555e6de609f9e2fe4bb734e5bec2dafa832a57e324287929cd76d0f7246c03df67b6a971fb4d9465cf76679f899eb5b6f26b9238ddb759b95a5b477bc8811fa6753c22c37956ef1ab9a2f78e5b2f2db45a44f86d4a4a09d94871015afd5bac9b84c876e82fcfb84b622448e82e3cfbee0436da00d952947b003e26b45c59f4638afd8b0fee51524acaa4eccc693c07905aee369b69626a536e81ce03b039c07800a9570d65f8ac3f18f99dfe66476a8b689499a98f39f9686d874975b23a5c51093b092477efaed56266f2e62f72e40c6f0cc4eff02f12ee2eb8fcc7a03c87da8f19b69c59ea5a769ea529094e81d8049eddb7d3295758bda14712f6bdd4cf35a1a2e22c20136f8c2c2ca65c67a5fb2a8fe1b323c7d8f129cad35fbe5b5a8929c95223c85ca4069d693214b52d2bde8a427da241f2d9f2150ce04bdd9a27879e62832aeb063ca7a3ad4cb4ebe9429c0a69484f4827dada8848d7bc81ef157ae9592edb6c7661e8cdc531a8fe990786f8f825ca7366fd59bc2215189178b41f00d1ed62e904cff958a3d57d613e97abd64af5d1bdefa0856b5e477e55bdf10978b4caf069c711235d20bf215ea2034dc84a964b5156874681dfb0a212afc92403a3572a94e3b75a6a0a9e8f4a86a6bc44469e29aca7922fa023be7eaa9e789b991dcc73857308ebf59b143537eb1358fc636823d01e9253fc6fc5b9dbcf6850f3159be2bd32d8e40c0b97176abe3d8b47650dcb0c1762c88e9f4c54145495256ca9697074eca0ec04ab47b55b6a5474b6dfa234c8a7390bf7ea1e49234b113af82414b9b949f6437bb42ab85eb0ec3b36e25ce2ebc536abbc9917b8090aba4b95354e5c9d69c0bf448129454bd747495f96cf48274ae9e6f98e5d639be08a0e30998945fadcfb51665b48264465372082a71006db49eda52b4364277d5daaebd29b476c6480e69700e6b84bafcd1104c5c4700237593b21b1de27c47eca13c12b7070fe2b11f873e1c9856a8d16433321bb19c438db494a874b89492363e701a3ee26a6d4a55457abe9aabaa446624f7927e6969b723437825294a893d7ce1ae95e1a7e96adbfa2aff314a568783fc433b42f58f293f28c4fb8ef2575294a56f8bc9c95857eff00c2cdfea55fe54a535dd12a5a1eb5bda3cc2a0596ff00ecb70feb955aba52b9fbfa457aff000bea19d83c82bf9c5ff4698b7d8d13ee51522a52b7ea3eadbd83c82f23ed1fc656f7dfff004e4a529522c34a529421294a5084a529421294a5084a529421294a5085ffd90a656e6473747265616d0a656e646f626a0a392030206f626a0a3c3c0a2f43726561746f7220284269746f6e290a2f4372656174696f6e446174652028443a3230323230313035313235373033290a2f50726f647563657220285b436c6962504446204c69627261727920322e30322d72312d325d204c696e7578290a2f417574686f722028557365723a204269746f6e2041646d696e204163636f756e74205b6269746f6e5d290a2f5469746c6520284e6f205469746c65290a2f5375626a65637420284e6f6e65290a2f4b6579776f7264732028436c6962504446290a3e3e0a656e646f626a0a787265660a302031300a303030303030303030302036353533352066200a30303030303030303333203030303030206e200a30303030303030303938203030303030206e200a30303030303030313434203030303030206e200a30303030303030323033203030303030206e200a30303030303030323430203030303030206e200a30303030303030343530203030303030206e200a30303030303031343633203030303030206e200a30303030303031353733203030303030206e200a30303030303036323639203030303030206e200a747261696c65720a3c3c0a2f53697a652031300a2f526f6f742031203020520a2f496e666f2039203020520a3e3e0a7374617274787265660a363438340a2525454f460a</pdfhex></ns:getdocumentResponse></SOAP-ENV:Body></SOAP-ENV:Envelope>";
                
                logger.info("Response XML is: \n" + responseXML);
                return responseXML;
         }
         catch(Exception e)
         {
                logger.info("Exception occurred: createRequestXML "+e);
                return "";
         }
         
         //return "success~BrokerDocumentcall";
  }
  private String relatedpartyFetchDataFromIDnumber(IFormReference iformObj, String stringdata)
	{
		try
		{
		String callName = "CustCICInq"; //For Related Party individual details
		JSONObject jsonobj = new JSONObject();
	
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
			
	
			for (String tag : tags) 
			{
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
		
			String id_no= getControlValue(iformObj, "table10599_ID_NUMBER"); //Check this
			parser.changeValue(request_prefix+"IDNumber",id_no);
			parser.changeValue(request_prefix+"arb:IDNum",id_no);
			
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
			
			
		System.out.println("RequestXML is :\n" + parser.toString());
		logger.info("RequestXML is :\n" + parser.toString());
		String ResponseXML = new SocketConnector().getSocketXMLResponse(parser.toString(), callName,iformObj);

		String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
		String []restricted_values=restricted_tags.split(",");
		for(String temp:restricted_values)
			ResponseXML=ResponseXML.replace(temp,"");
	
		tagName = "_TagNameResponseGrid";
		tagNames = GetXML.getProp().getProperty(callName + tagName);
		logger.info("TagNames from property file are "+tagNames);
		
		String statuscode=GetXML.getProp().getProperty(callName+"_StatusCode");
		String []status_code_split=statuscode.split("~");
	
		tags=tagNames.split("~");
		WFXmlResponse objWFxmlResponse = new WFXmlResponse(ResponseXML);
		logger.info("objWFxmlResponse value is "+objWFxmlResponse);

		JSONArray jsonarr=new JSONArray();
			
		logger.info("Status codes are"+status_code_split[0]+"and"+status_code_split[1]);
			
		logger.info("Value of status tag in response is"+objWFxmlResponse.getVal(status_code_split[0]));
			
		String new_date="";
		
		if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) 
		{
			WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
			for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
			{
				jsonobj = new JSONObject();
				for(int j=2;j<tags.length;++j)
				{
					String tag_split_values=tags[j];
					String []hash_split_values=tag_split_values.split("#");
					String result_from_response=WFXmlList.getVal(hash_split_values[1]);
					logger.info("Everything OK Till now");
					if(hash_split_values[1].equalsIgnoreCase("IdExpiryDate") || hash_split_values[1].equalsIgnoreCase("IDIssueDate"))
					{
						try
						{
							if(result_from_response.contains("/"))
							{
								new_date=result_from_response.split("/")[2]+"/"+result_from_response.split("/")[1]+"/"+result_from_response.split("/")[0];
							}
							else if(result_from_response.contains("-"))
							{
								new_date=result_from_response.split("-")[2]+"-"+result_from_response.split("-")[1]+"-"+result_from_response.split("-")[0];
							}
							result_from_response=new_date;
						}
						catch(Exception e)
						{
							result_from_response="";
						}
					}
					
					if(result_from_response.equals(null))
					{
						result_from_response="";
					}
					
					jsonobj.put(hash_split_values[0],result_from_response.trim());
				}
			}	
				
			logger.info("Current Json Object is"+jsonobj);
			jsonarr.add(jsonobj);
		}
		else
		{
			logger.info("For "+callName+" Status code returned from response is not success ");
			String error_description=objWFxmlResponse.getVal("StatusDesc");
			return "Error~In "+callName+" error received with error code "+objWFxmlResponse.getVal(status_code_split[0]+"-"+error_description);
		}
			
		logger.info("Final Value of Json Array is "+jsonarr);
		logger.info("This array will contain json objects which will contain one-to-one field id with their value in key value pair form");
			
		JSONObject finaljsonobj = new JSONObject();
			
		if(jsonarr.size()>0)
		{
			finaljsonobj=(JSONObject) jsonarr.get(0); // Here later on we can apply condition to check which json object we need
		}
			
		for(Iterator iterator = finaljsonobj.keySet().iterator(); iterator.hasNext();) 
		{
			 String key = (String) iterator.next();
			 logger.info("Values set for"+key+" are "+finaljsonobj.get(key).toString());
			 setControlValue(iformObj, key, finaljsonobj.get(key).toString());
		}
			
		}
		catch(Exception e)
		{
			logger.info("Exception Occurred: relatedpartyFetchDataFromIDnumber"+e);
		}
		
		return "relatedpartyFetchDataFromIDnumber called Successfully";
	}
  private String refreshAfterStatementUpload(IFormReference iformObj, String stringdata) 
  {
	  logger.info("inside  refreshAfterStatementUpload ");
	  String date= new Timestamp(System.currentTimeMillis()).toString();
	  iformObj.setValue("Q_NG_POS_APPLICATION_DATA_REUPLOAD_DATE_TIME",date);
	  iformObj.clearCombo("BANK_NAME_REUPLOAD_ACC");
	  iformObj.clearCombo("BANK_NAME_REUPLOAD_POS");
	  try
	  {
	  String cic=getControlValue(iformObj, "PADDED_CIC_NO");
	  String wi_name=getWorkitemName(iformObj);
	  logger.info("inside  refreshAfterStatementUpload1 ");
      String query="select ' All' union select bank_name+'_'+acc_no from NG_POS_STMTDATA_OTHER_DETAIL_GRID_REUPLOAD where wi_name='"+getWorkitemName(iformObj)+"'  ";
      List<List<String>> result =iformObj.getDataFromDB(query);
             
             logger.info("query : "+query+" , result  : "+result);
             if(!result.isEmpty())
             {
                    for(int i=0;i<result.size();i++)
                    {
                          iformObj.addItemInCombo("BANK_NAME_REUPLOAD_ACC", result.get(i).get(0),result.get(i).get(0));
                          iformObj.addItemInCombo("BANK_NAME_REUPLOAD_POS", result.get(i).get(0),result.get(i).get(0));
                    }
                    
                    
             }
             iformObj.clearTable("table10670");
				iformObj.clearTable("Q_NG_POS_STMTDATA_OTHER_DETAIL_GRID");
             query="select ACC_MVMNT_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVG_BAL   from NG_POS_ACCMOVMNT_NONARB_GRID where wi_name='"+wi_name+"'   ORDER BY convert(date,'01-'+ACC_MVMNT_MONTH,103) DESC";
 			loadListView(iformObj,query,"ACC_MVMNT_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVG_BAL","table10670","Month,Througput,No of Transaction,Average Balance");
 			 query="select OTHER_MONTH,THROUGHPUT,OTHER_TRANSACTION,AVG_TRANSACTN_AMT   from NG_POS_STMTDATA_OTHER_DETAIL_GRID where wi_name='"+wi_name+"'   ORDER BY convert(date,'01-'+OTHER_MONTH,103) DESC";
  			loadListView(iformObj,query,"OTHER_MONTH,THROUGHPUT,OTHER_TRANSACTION,AVG_TRANSACTN_AMT","Q_NG_POS_STMTDATA_OTHER_DETAIL_GRID","Month,Throughput,Transaction,Average Transaction Amount");
  			 logger.info("query : "+query+" , result  : "+result);
  			query="select TOT_THROUGPUT_LAST_12,TOT_THROUGPUT_LAST_4,AVG_BAL_LAST_12,ZERO_BAL_LAST_12 from NG_POS_STMTDATA_ACCMOVMNT_NON_ARB where wi_name='"+getWorkitemName(iformObj)+"'  ";
  	        result =iformObj.getDataFromDB(query);
	  	      if(!result.isEmpty())
	          {
	                  iformObj.setValue("Q_NG_POS_STMTDATA_ACCMOVMNT_NON_ARB_TOT_THROUGPUT_LAST_12", result.get(0).get(0));
	                  iformObj.setValue("Q_NG_POS_STMTDATA_ACCMOVMNT_NON_ARB_TOT_THROUGPUT_LAST_4", result.get(0).get(1));
	                  iformObj.setValue("Q_NG_POS_STMTDATA_ACCMOVMNT_NON_ARB_AVG_BAL_LAST_12", result.get(0).get(2));
	                  iformObj.setValue("Q_NG_POS_STMTDATA_ACCMOVMNT_NON_ARB_ZERO_BAL_LAST_12", result.get(0).get(3));
	                 
	                 
	          }
	  	      
	  	    query="select TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH,TOT_THRGPUT_4MNTH,AVG_THRGPUT_4MNTH from NG_POS_STMTDATA_OTHER_DETAIL where wi_name='"+getWorkitemName(iformObj)+"'  ";
  	        result =iformObj.getDataFromDB(query);
	  	      if(!result.isEmpty())
	          {
	                  iformObj.setValue("Q_NG_POS_STMTDATA_OTHER_DETAIL_TOT_THRGPUT_12MNTH", result.get(0).get(0));
	                  iformObj.setValue("Q_NG_POS_STMTDATA_OTHER_DETAIL_AVG_THRGPUT_12MNTH", result.get(0).get(1));
	                  iformObj.setValue("Q_NG_POS_STMTDATA_OTHER_DETAIL_TOT_THRGPUT_4MNTH", result.get(0).get(2));
	                  iformObj.setValue("Q_NG_POS_STMTDATA_OTHER_DETAIL_AVG_THRGPUT_4MNTH", result.get(0).get(3));
	                 
	                 
	          }
  			
	  	      
	  	    /* query="SELECT NON_ARB_POS_USING_SINCE,NON_ARB_POS_MACHINE_NO FROM NG_STATEMENT_OCR_CUST_INFO A, NG_STATEMENT_OCR_POS_TRANSACTN B WHERE A.WI_NAME=B.WI_NAME AND A.WI_NAME=(SELECT TOP 1 WI_NAME FROM NG_STATEMENT_OCR_CUST_INFO WHERE CIC_NO = '"+cic+"' ORDER BY CAST(SUBSTRING(WI_NAME,5,14) AS INT) DESC)";
	  	     result =iformObj.getDataFromDB(query);
	  	     String zero_count="";
	  	     logger.info("Query for setting no of pos machine is "+query+" and its result is "+result);
	  	     if(!result.isEmpty())
	          {
	                  iformObj.setValue("Q_NG_POS_STMTDATA_OTHER_DETAIL_NON_ARB_POS_USING_SINCE", result.get(0).get(0));
	                  iformObj.setValue("Q_NG_POS_STMTDATA_STMT_ANALYSIS_NO_NON_POS_MACHINE", result.get(0).get(1));
	                  zero_count=result.get(0).get(1);
	          }*/
	  	      
	  	  
  				query="SELECT convert(varchar,min(convert(date,pos_since,103)),103),sum(num_of_pos) FROM (select pos_since,num_of_pos,row_number() over(partition by  bank_name+'_'+acc_no order by  bank_name+'_'+acc_no ) rownum from NG_POS_STMTDATA_OTHER_DETAIL_GRID_REUPLOAD  WHERE   wi_name = '"+wi_name+"') a where rownum=1";

  		
  			 
  			result =iformObj.getDataFromDB(query);
  			     String zero_count="";
  			     String using_since="";
  			     logger.info("Query for setting no of pos machine is "+query+" and its result is "+result);
  			     if(!result.isEmpty())
  		       {
  		               iformObj.setValue("Q_NG_POS_STMTDATA_OTHER_DETAIL_NON_ARB_POS_USING_SINCE", result.get(0).get(0));
  		               iformObj.setValue("NO_OF_NON_POS_ARB_MACHINE", result.get(0).get(1));
  		               zero_count=result.get(0).get(1);
  		             using_since=result.get(0).get(0);
  		       }
  			     	
	  	     
	  	   query="UPDATE NG_POS_STMTDATA_STMT_ANALYSIS SET NO_NON_POS_MACHINE='"+zero_count+"',using_since='"+using_since+"' WHERE WI_NAME='"+wi_name+"' ";
	  	   logger.info("Query for setting no of pos machine part 2 is "+query+" and its result is "+result);
	  	   iformObj.saveDataInDB(query);
	  }
	  catch(Exception e)
		{
			logger.info("Exception Occurred: refreshAfterStatementUpload"+e);
		}

	  
	  return "";
	  
  }

  private String refreshAfterStatementUpload1(IFormReference iformObj, String stringdata) 
  {
	  logger.info("inside  refreshAfterStatementUpload1 ");
	  try
	  {
	  String cic=getControlValue(iformObj, "PADDED_CIC_NO");
	  String wi_name=getWorkitemName(iformObj);
	  logger.info("inside  refreshAfterStatementUpload1 ");
      String query="select ' All' union select bank_name+'_'+acc_no from NG_POS_STMTDATA_OTHER_DETAIL_GRID_REUPLOAD where wi_name='"+getWorkitemName(iformObj)+"'  ";
      List<List<String>> result =iformObj.getDataFromDB(query);
             
             logger.info("query : "+query+" , result  : "+result);
             if(!result.isEmpty())
             {
                    for(int i=0;i<result.size();i++)
                    {
                          iformObj.addItemInCombo("BANK_NAME_REUPLOAD_ACC", result.get(i).get(0),result.get(i).get(0));
                          iformObj.addItemInCombo("BANK_NAME_REUPLOAD_POS", result.get(i).get(0),result.get(i).get(0));
                    }
                    
                    
             }
             	
	  }
	  catch(Exception e)
		{
			logger.info("Exception Occurred: refreshAfterStatementUpload"+e);
		}

	  
	  return "";
	  
  }

  
  private String refreshAccstatement(IFormReference iformObj, String stringdata) 
  {
	  logger.info("inside refreshAccstatement ");
	  try
	  {
		  String cic=getControlValue(iformObj, "PADDED_CIC_NO");
		  String wi_name=getWorkitemName(iformObj);
		  String bankName=getControlValue(iformObj, "BANK_NAME_REUPLOAD_ACC");
		  if(stringdata.equalsIgnoreCase("OnLoad"))
		  {
			 logger.info("As stringdata is OnLoad we are defaulting things to All");
			setControlValue(iformObj, "BANK_NAME_REUPLOAD_ACC", " All");
			bankName="All";
		  }
		  logger.info("inside  refreshAccstatement ");
	      String query="";
	      iformObj.clearTable("table10670");
			//iformObj.clearTable("Q_NG_POS_STMTDATA_OTHER_DETAIL_GRID");
			if("All".equalsIgnoreCase(bankName.trim()))
				 query="select ACC_MVMNT_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVG_BAL   from NG_POS_ACCMOVMNT_NONARB_GRID where wi_name='"+wi_name+"'   ORDER BY convert(date,'01-'+ACC_MVMNT_MONTH,103) DESC";
			else
				query="select ACC_MVMNT_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVG_BAL   from NG_POS_ACCMOVMNT_NONARB_GRID_REUPLOAD where wi_name='"+wi_name+"' and bank_name+'_'+acc_no='"+bankName+"'  ORDER BY convert(date,'01-'+ACC_MVMNT_MONTH,103) DESC";
			
			logger.info("inside  refreshAccstatement "+query);	
		loadListView(iformObj,query,"ACC_MVMNT_MONTH,THROUGHPUT,NO_OF_TRANSACTION,AVG_BAL","table10670","Month,Througput,No of Transaction,Average Balance");
	  }
	  catch(Exception e)
	  {
		  logger.info("Exception Occurred: refreshAccstatement and exception is "+e);
	  }
	  return "success~refreshAccstatement";
	  
  }
  
  private String refreshPOSstatement(IFormReference iformObj, String stringdata) 
  {
	  logger.info("inside refreshPOSstatement ");
	  try
	  { 
		  String cic=getControlValue(iformObj, "PADDED_CIC_NO");
		  String wi_name=getWorkitemName(iformObj);
		  String bankName=getControlValue(iformObj, "BANK_NAME_REUPLOAD_POS");
		  if(stringdata.equalsIgnoreCase("OnLoad"))
		  {
			logger.info("As stringdata is OnLoad we are defaulting things to All");
			setControlValue(iformObj, "BANK_NAME_REUPLOAD_POS", " All");
			bankName="All";
		  }
		  logger.info("inside  refreshPOSstatement ");
	      String query="";
	             
					iformObj.clearTable("Q_NG_POS_STMTDATA_OTHER_DETAIL_GRID");
		if("All".equalsIgnoreCase(bankName.trim()))
			query="select OTHER_MONTH,THROUGHPUT,OTHER_TRANSACTION,AVG_TRANSACTN_AMT   from NG_POS_STMTDATA_OTHER_DETAIL_GRID where wi_name='"+wi_name+"'   ORDER BY convert(date,'01-'+OTHER_MONTH,103) DESC";
	
		else
	        query="select OTHER_MONTH,THROUGHPUT,OTHER_TRANSACTION,AVG_TRANSACTN_AMT   from NG_POS_STMTDATA_OTHER_DETAIL_GRID_REUPLOAD where wi_name='"+wi_name+"' and bank_name+'_'+acc_no='"+bankName+"'  ORDER BY convert(date,'01-'+OTHER_MONTH,103) DESC";
		logger.info("inside  refreshPOSstatement "+query);	
	  			loadListView(iformObj,query,"OTHER_MONTH,THROUGHPUT,OTHER_TRANSACTION,AVG_TRANSACTN_AMT","Q_NG_POS_STMTDATA_OTHER_DETAIL_GRID","Month,Throughput,Transaction,Average Transaction Amount");
	  			
	  			if("All".equalsIgnoreCase(bankName.trim()))
	  				query="SELECT convert(varchar,min(convert(date,pos_since,103)),103),sum(num_of_pos) FROM (select pos_since,num_of_pos,row_number() over(partition by  bank_name+'_'+acc_no order by  bank_name+'_'+acc_no ) rownum from NG_POS_STMTDATA_OTHER_DETAIL_GRID_REUPLOAD  WHERE   wi_name = '"+wi_name+"') a where rownum=1";
	
	  			else
	  			  query="SELECT top 1 pos_since,num_of_pos FROM NG_POS_STMTDATA_OTHER_DETAIL_GRID_REUPLOAD  WHERE  wi_name='"+wi_name+"'  and bank_name+'_'+acc_no='"+bankName+"' ";
	  			 
	  			List<List<String>> result =iformObj.getDataFromDB(query);
	  			     String zero_count="";
	  			     logger.info("Query for setting no of pos machine is "+query+" and its result is "+result);
	  			     if(!result.isEmpty())
	  		       {
	  		               iformObj.setValue("Q_NG_POS_STMTDATA_OTHER_DETAIL_NON_ARB_POS_USING_SINCE", result.get(0).get(0));
	  		               iformObj.setValue("NO_OF_NON_POS_ARB_MACHINE", result.get(0).get(1));
	  		               zero_count=result.get(0).get(1);
	  		       }
	  }
	  catch(Exception e)
	  {
		  logger.info("Exception Occurred: refreshPOSstatement and exception is "+e);
	  }
	  
	  return "success~refreshPOSstatement";
	  
  }
  public void loadListView(IFormReference formObject,String query,String columns,String listview,String listviewcolumns)
	{
		try
		{
			String sOutput=getDataFromDBWithColumns(formObject, query, columns);
			 org.json.simple.JSONArray jsonArray=new JSONArray();
			 org.json.simple.JSONObject obj;	
	            logger.debug("sOutput " + sOutput);
	        formObject.clearTable(listview);
	       
			if(!getTagValues(sOutput,"TotalRetrieved").equalsIgnoreCase("0"))
			{					
				String [] allData = getTagValue(sOutput,"Row").split(";");				
				String[] sEachData; 
				for(int i=0;i<allData.length;i++)
				{
					obj=new  org.json.simple.JSONObject();
					sEachData =columns.split(",");
				
					for(int j=0;j<sEachData.length;j++)
					{
						try
						{
							obj.put(listviewcolumns.split(",")[j],allData[i].split(",")[j]);
						}
						catch(Exception e)
						{
							obj.put(listviewcolumns.split(",")[j],"");
						}
					}
					jsonArray.add(obj)		;
				}
				logger.debug("jsonArray " + jsonArray );
				formObject.addDataToGrid(listview, jsonArray);				
			}
		}
		catch(Exception e)
		{
			logger.debug("Error  " ,e);
		}
	}
	
	public String getDataFromDBWithColumns(IFormReference formobj,String query, String columns)
	{
		StringBuilder data=new StringBuilder();
		
		List<List<String>> retval=formobj.getDataFromDB(query);
		logger.debug("retval  " + retval);
		String[] cols=columns.split(",");
		if(retval.isEmpty())
			return "<TotalRetrieved>0</TotalRetrieved>";
		logger.debug("retval.size()" + retval.size() );
		data.append("<Data><TotalRetrieved>"+retval.size()+"</TotalRetrieved>");
		for(int i=0;i<retval.size();i++)
		{
			data.append("<Row>");
			for(int j=0;j<retval.get(i).size();j++)
			{
				data.append("<"+cols[j]+">"+retval.get(i).get(j)+"</"+cols[j]+">");
			}
			data.append("</Row>");
		}
		data.append("</Data>");
		return data.toString();
	}
	
	public String getTagValues(String sXML, String sTagName) 
	{  
		StringBuilder sTagValues=new StringBuilder() ;		
		String sStartTag = "<" + sTagName + ">";
		String sEndTag = "</" + sTagName + ">";
		String tempXML = sXML;
		tempXML=tempXML.replaceAll("&",AMPTAG);
		try
		{
			for(int i=0;i<sXML.split(sEndTag).length-1;i++) 
			{
				if(tempXML.indexOf(sStartTag) != -1) 
				{
					sTagValues.append(tempXML.substring(tempXML.indexOf(sStartTag) + sStartTag.length(), tempXML.indexOf(sEndTag)));
					tempXML=tempXML.substring(tempXML.indexOf(sEndTag) + sEndTag.length(), tempXML.length());
				}
				if(tempXML.indexOf(sStartTag) != -1) 
				{    
					sTagValues.append(",");					
				}
			}			
			
		}
		catch(Exception e) 
		{   
			logger.debug(e.getMessage(),e);
		}
		return sTagValues.toString().replace(AMPTAG, "&").trim();
	}
	public String getTagValue(String xml, String tag) throws ParserConfigurationException, SAXException, IOException 
	{
		String col="#col#";
		String comma="#Comma#";
		xml=xml.replaceAll("&",AMPTAG);
		xml=xml.replaceAll(";",col);
		xml=xml.replaceAll(",",comma);
		Document doc = getDocument(xml);
		NodeList nodeList = doc.getElementsByTagName(tag);
		String value = "";

		int length = nodeList.getLength();		

		if (length > 0) 
		{
			String sTempValue ="";
			for(int j=0;j<length;j++)
			{
				Node node =  nodeList.item(j);

				if (node.getNodeType() == Node.ELEMENT_NODE) 
				{
					NodeList childNodes = node.getChildNodes();					
					int count = childNodes.getLength();	

					for (int i = 0; i < count; i++) 
					{	
						Node item = childNodes.item(i);
						if (item.getNodeType() == Node.ELEMENT_NODE) 
						{	
							sTempValue=item.getTextContent();

							if(sTempValue.indexOf(AMPTAG)!= -1)
							{
								sTempValue =sTempValue.replaceAll(AMPTAG, "&");
							}

							value += sTempValue+",";	
						}
						else if (item.getNodeType() == Node.TEXT_NODE)
						{
							value= item.getNodeValue();
							if(value.indexOf(AMPTAG)!= -1)
							{
								
								value =value.replaceAll(AMPTAG, "&");
								value =value.replaceAll(col, ";");
								value =value.replaceAll(comma, ",");
							}
							return value;
						}
					}
					if(!value.equalsIgnoreCase(""))
					{
						value = value.substring(0, value.length()-1);
						value = value+";";
					}

				}
				else if (node.getNodeType() == Node.TEXT_NODE)
				{
					value= node.getNodeValue();
					if(value.indexOf(AMPTAG)!= -1)
					{
						
						value =value.replaceAll(AMPTAG, "&");
						value =value.replaceAll(col, ";");
						value =value.replaceAll(comma, ",");
					}
					return value;
				}
			}

			if(!value.equalsIgnoreCase(""))
			{
				value = value.substring(0, value.length()-1);
			}
			return value;
		}
		return "";
	}
	private Document getDocument(String xml) throws ParserConfigurationException, SAXException, IOException  
	{

		// Step 1: create a DocumentBuilderFactory
		DocumentBuilderFactory dbf =
				DocumentBuilderFactory.newInstance();
		dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

		// Step 2: create a DocumentBuilder
		DocumentBuilder db = dbf.newDocumentBuilder();

		// Step 3: parse the input file to get a Document object
		return db.parse(new InputSource(new StringReader(xml)));
		
	} 
	
	 public String fillTerminalData_AfterApplicationCreation_OldCIC(IFormReference iformObj, String callName)
		{
			callName="MerchantDtlsInq_OldCIC_PQ1#MerchantPOSTrxnsSummaryInq_OldCIC_PQ1";
			try
			{
				logger.info("Inside fillterminaldata PQ1 function");
				String wi_name=getWorkitemName(iformObj);
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
			
				if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) 
				{
					WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0], tags[1]);
					logger.info("Wfmxmlsit is --------------" + WFXmlList);
					for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
					{
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
				String tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Grid_Terminalwise");
				String delete_query="DELETE FROM "+tablename+" where WI_NAME= '"+wi_name+"' ";
				iformObj.saveDataInDB(delete_query);
				logger.info("With this query table is emptied :: "+delete_query);
				
				
				//int counter=0,final_counter_4_plus=0,final_counter_zero=0,final_counter_else=0;
				//boolean flag=false;
				String cic_number=getControlValue(iformObj, "PADDED_OLD_CIC_NO");
				//String wi_name=getWorkitemName(iformObj);
				/*
				String tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Grid_Terminalwise");
				String delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
				iformObj.saveDataInDB(delete_query);
				logger.info("With this query table is emptied :: "+delete_query);
		
				tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Terminalwise");
				delete_query="DELETE FROM "+tablename+" where CIC= '"+cic_number+"' ";
				iformObj.saveDataInDB(delete_query);
		
				logger.info("With this query table for throuput details is emptied :: "+delete_query);
				*/
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
			
					for (String tag : tags) 
					{
						String tagValue1 = parser.getValueOf(request_prefix+tag);
						logger.info("tagValue is "+tagValue1);
						if(tagValue1.contains("header~"))
						{
							try 
							{
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
						if (tagValue1.startsWith("formid~")) 
						{
							String value = (String) iformObj.getValue(tagValue1.split("~")[1]);
							parser.changeValue(request_prefix+tag, value);
						}
					}
			
					//parser.changeValue(request_prefix+"TerminalID", terminalid); // need to recheck
					parser.changeValue("TerminalNum", terminalid); // need to recheck
		    
					logger.info("Please make sure terminal values are right in this request or not");
					logger.info("RequestXML for MerchantPOSTrxnsSummaryInq_SearchScreen is:\\n" + parser.toString());
					//boolean bFound=false;
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
					//String columnames="CIC_NO,";
					String columnames="WI_NAME,";
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
				
						columnames="WI_NAME,";
						values=" ";
						for(int j=2;j<tags.length;++j)
						{
							String tag_split_values=tags[j];
							logger.info("Tag values split to set column names"+tag_split_values);
							String []hash_split_values=tag_split_values.split("#");
							columnames=columnames+hash_split_values[0]+",";
						}
				
						columnames=columnames+"TERMINAL_ID";
						logger.info("column names are"+columnames);
				
						if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) 
						{
							WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
							logger.info("Wfmxmlsit is --------------"+WFXmlList);
							for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
							{
								values=values+"( '"+wi_name+"',";
					
								for(int j=2;j<tags.length;++j)
								{
									String tag_split_values=tags[j];
									if((!tag_split_values.contains("@")))
									{
										String []hash_split_values=tag_split_values.split("#");
										String result_from_response=WFXmlList.getVal(hash_split_values[1]);
										if(result_from_response== null )
										{
											result_from_response="";
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
								values=values+"'"+terminalid+"'),";
							}
				
							if (values.endsWith(",")) 
							{
								values = values.substring(0, values.length() - 1);
							}
				
							logger.info("Final column variables are"+columnames);
							logger.info("values are"+values);
				
							query=insertinto+tablename+" ( "+ columnames +" ) VALUES "+values;
							logger.info("Query for setting response in MerchantPOSTrxnsSummaryInq_OldCIC_PQ1 table is"+query);
							iformObj.saveDataInDB(query);	
				
						}
						else
						{
							logger.info("For "+callName+" Status code returned from response is not success ");
						}
				
			}
				}
				
				fillTerminalData_allmachines_PQ1_OldCIC(iformObj);
				iformObj.clearTable("Q_NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID");
				fillTerminalIdOldCIC(iformObj,"Q_NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_ARB_POS_MACHINE"); 
				fillStatementAnalysisDetails_PQ1(iformObj,wi_name);
				
	logger.info("All good in terminal call");
	}
	catch(Exception e)
	{
		logger.info("Exception Occurred: fillTerminalData_pq1_oldCIC and exception is "+e);
	}
	return "Sahdev Kansal returns success";

	}
	
	public String fillTerminalData_allmachines_PQ1_OldCIC(IFormReference iformObj)
	{
	  String wi_name=getWorkitemName(iformObj);
			try
			{
				logger.info("Filling terminal data for all machines");
				
				String callName="MerchantPOSTrxnsSummaryInq_OldCIC_PQ1";
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
						if (tagValue.startsWith("formid~")) 
						{
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
				setResponseDataGridToDBAfterApplicationCreation(iformObj, callName, responseXML);
				//New Functionality
				//boolean bFound=false;
				
				String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
				String []restricted_values=restricted_tags.split(",");
				for(String temp:restricted_values)
					responseXML=responseXML.replace(temp,"");
				
				String tagName = "_TagNameResponse";
				String tagNames = GetXML.getProp().getProperty(callName + tagName);
				logger.info(tagNames);
				String[] tags = tagNames.split(",");
		
				//String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
				
				//String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
				
				XMLParser parser = new XMLParser(responseXML);
				String values="";
				String query="";
				String columnames="";
				String insertinto="INSERT INTO ";
				//String tablename=GetXML.getProp().getProperty(callName+"_Table");
				
				//String delete_query="DELETE FROM "+tablename+" where WI_NAME= '"+wi_name+"' ";
				//iformObj.saveDataInDB(delete_query);
				//logger.info("With this query table is emptied :: "+delete_query);
				
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
						//bFound=true;
					}
					
					//Logic to calculate 4 month average
					String newquery="SELECT TOP 4 THROUGHPUT FROM NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE WI_NAME	='"+wi_name+"' and cortex_month<>'' AND CORTEX_MONTH<>'0' ORDER BY convert(date,'01/'+CORTEX_MONTH,103) DESC";//CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC";
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
					columnames=columnames+"Q_NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_AVG_THRPUT_4MNTH,Q_NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_TOT_THRGPUT_4MNTH";
					values=values+"'"+String.format("%.2f", tot_transaction_amt/4)+"','"+String.format("%.2f", tot_transaction_amt);
					//End of Logic to calculate 4 month average
		
					String column_names_split[]=columnames.split(",");
					String values_split[]=values.split(",");
					
					for(int i=0;i<column_names_split.length;i++)
					{
						values_split[i]=values_split[i].replaceAll("'","");
						iformObj.setValue(column_names_split[i],"");
					}
					
					for(int i=0;i<column_names_split.length;i++)
					{
						values_split[i]=values_split[i].replaceAll("'","");
						iformObj.setValue(column_names_split[i], values_split[i]);
					}
					
					logger.info("Array for setting cortex data in search screen tables is"+column_names_split+ "and "+values_split);
					//iformObj.saveDataInDB(query);	
		
				}
				else
				{
					logger.info("For "+callName+" Status code returned from response is not success ");
				}
				
			}
			catch(Exception e)
			{
				logger.info("Exception Occurred:: fillTerminalData_allmachines_PQ1_OldCIC and exception is "+e);
			}
		return "";
	}
  
  	
  public String fillTerminalData_AfterApplicationCreation(IFormReference iformObj, String callName)
	{
		callName="MerchantDtlsInq_PQ1#MerchantPOSTrxnsSummaryInq_PQ1";
		try
		{
			logger.info("Inside fillterminaldata PQ1 function");
			String wi_name=getWorkitemName(iformObj);
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
		
			if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) 
			{
				WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0], tags[1]);
				logger.info("Wfmxmlsit is --------------" + WFXmlList);
				for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
				{
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
			String tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Grid_Terminalwise");
			String delete_query="DELETE FROM "+tablename+" where WI_NAME= '"+wi_name+"' ";
			iformObj.saveDataInDB(delete_query);
			logger.info("With this query table is emptied :: "+delete_query);
			
			
			//int counter=0,final_counter_4_plus=0,final_counter_zero=0,final_counter_else=0;
			//boolean flag=false;
			String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
			//String wi_name=getWorkitemName(iformObj);
			/*
			String tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Grid_Terminalwise");
			String delete_query="DELETE FROM "+tablename+" where CIC_NO= '"+cic_number+"' ";
			iformObj.saveDataInDB(delete_query);
			logger.info("With this query table is emptied :: "+delete_query);
	
			tablename=GetXML.getProp().getProperty(callnames[1]+"_Table_Terminalwise");
			delete_query="DELETE FROM "+tablename+" where CIC= '"+cic_number+"' ";
			iformObj.saveDataInDB(delete_query);
	
			logger.info("With this query table for throuput details is emptied :: "+delete_query);
			*/
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
		
				for (String tag : tags) 
				{
					String tagValue1 = parser.getValueOf(request_prefix+tag);
					logger.info("tagValue is "+tagValue1);
					if(tagValue1.contains("header~"))
					{
						try 
						{
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
					if (tagValue1.startsWith("formid~")) 
					{
						String value = (String) iformObj.getValue(tagValue1.split("~")[1]);
						parser.changeValue(request_prefix+tag, value);
					}
				}
		
				//parser.changeValue(request_prefix+"TerminalID", terminalid); // need to recheck
				parser.changeValue("TerminalNum", terminalid); // need to recheck
	    
				logger.info("Please make sure terminal values are right in this request or not");
				logger.info("RequestXML for MerchantPOSTrxnsSummaryInq_SearchScreen is:\\n" + parser.toString());
				//boolean bFound=false;
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
				//String columnames="CIC_NO,";
				String columnames="WI_NAME,";
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
			
					columnames="WI_NAME,";
					values=" ";
					for(int j=2;j<tags.length;++j)
					{
						String tag_split_values=tags[j];
						logger.info("Tag values split to set column names"+tag_split_values);
						String []hash_split_values=tag_split_values.split("#");
						columnames=columnames+hash_split_values[0]+",";
					}
			
					columnames=columnames+"TERMINAL_ID";
					logger.info("column names are"+columnames);
			
					if (objWFxmlResponse.getVal(status_code_split[0]).equals(status_code_split[1])) 
					{
						WFXmlList WFXmlList = objWFxmlResponse.createList(tags[0],tags[1]);
						logger.info("Wfmxmlsit is --------------"+WFXmlList);
						for (int i = 0; WFXmlList.hasMoreElements(true); WFXmlList.skip(true), i++) 
						{
							values=values+"( '"+wi_name+"',";
				
							for(int j=2;j<tags.length;++j)
							{
								String tag_split_values=tags[j];
								if((!tag_split_values.contains("@")))
								{
									String []hash_split_values=tag_split_values.split("#");
									String result_from_response=WFXmlList.getVal(hash_split_values[1]);
									if(result_from_response== null )
									{
										result_from_response="";
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
							values=values+"'"+terminalid+"'),";
						}
			
						if (values.endsWith(",")) 
						{
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
		/*
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
			String newquery="SELECT TOP 4 THROUGHPUT FROM NG_MSB_SEARCH_STMTDATA_CORTEX_DETAIL_GRID WHERE CIC_NO='"+cic_number+"' ORDER BY CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC";
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

					//logger.info("Individual avg_transaction amoutn for 4 months is "+element+" and sum is "+avg_transaction_amt );    
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
			*/
	}
			
			fillTerminalData_allmachines_PQ1(iformObj);
			iformObj.clearTable("Q_NG_POS_STMTDATA_CORTEX_DETAIL_GRID");
			fillTerminalId(iformObj,"Q_NG_POS_STMTDATA_CORTEX_DETAIL_ARB_POS_MACHINE"); 
			fillStatementAnalysisDetails_PQ1(iformObj,wi_name);
			
logger.info("All good in terminal call");
}
catch(Exception e)
{
	logger.info("Exception Occurred: fillTerminalData_SearchScreen and exception is "+e);
}
return "Sahdev Kansal returns success";

}

public String fillTerminalData_allmachines_PQ1(IFormReference iformObj)
{
String wi_name=getWorkitemName(iformObj);
		try
		{
			logger.info("Filling terminal data for all machines");
			
			String callName="MerchantPOSTrxnsSummaryInq_PQ1";
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
					if (tagValue.startsWith("formid~")) 
					{
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
			setResponseDataGridToDBAfterApplicationCreation(iformObj, callName, responseXML);
			//New Functionality
			//boolean bFound=false;
			
			String restricted_tags=GetXML.getProp().getProperty(callName+"_RestrictedTags");
			String []restricted_values=restricted_tags.split(",");
			for(String temp:restricted_values)
				responseXML=responseXML.replace(temp,"");
			
			String tagName = "_TagNameResponse";
			String tagNames = GetXML.getProp().getProperty(callName + tagName);
			logger.info(tagNames);
			String[] tags = tagNames.split(",");
	
			//String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			
			//String cic_number=getControlValue(iformObj, "NG_MSB_CIC_NO");
			
			XMLParser parser = new XMLParser(responseXML);
			String values="";
			String query="";
			String columnames="";
			String insertinto="INSERT INTO ";
			String tablename=GetXML.getProp().getProperty(callName+"_Table");
			
			//String delete_query="DELETE FROM "+tablename+" where WI_NAME= '"+wi_name+"' ";
			//iformObj.saveDataInDB(delete_query);
			//logger.info("With this query table is emptied :: "+delete_query);
			
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
					//bFound=true;
				}
				
				//Logic to calculate 4 month average
				String newquery="SELECT TOP 4 THROUGHPUT FROM NG_POS_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE WI_NAME	='"+wi_name+"' and cortex_month<>'' AND CORTEX_MONTH<>'0' ORDER BY convert(date,'01/'+CORTEX_MONTH,103) DESC";//CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC";
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
				columnames=columnames+"Q_NG_POS_STMTDATA_CORTEX_DETAIL_AVG_THRGPUT_4MNTH,Q_NG_POS_STMTDATA_CORTEX_DETAIL_TOT_THRGPUT_4MNTH";
				values=values+"'"+String.format("%.2f", tot_transaction_amt/4)+"','"+String.format("%.2f", tot_transaction_amt);
				//End of Logic to calculate 4 month average
	
				String column_names_split[]=columnames.split(",");
				String values_split[]=values.split(",");
				
				for(int i=0;i<column_names_split.length;i++)
				{
					values_split[i]=values_split[i].replaceAll("'","");
					iformObj.setValue(column_names_split[i],"");
				}
				
				for(int i=0;i<column_names_split.length;i++)
				{
					values_split[i]=values_split[i].replaceAll("'","");
					iformObj.setValue(column_names_split[i], values_split[i]);
				}
				
				logger.info("Query for setting cortex data in search screen tables is"+column_names_split+ "and "+values_split);
				//iformObj.saveDataInDB(query);	
	
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
			logger.info("Exception Occurred:: fillTerminalData_allmachines_PQ1 and exception is "+e);
		}
	return "";
}

private String fillStatementAnalysisDetails_PQ1(IFormReference iformObj, String WI_name) 
{
	//Logic to calculate 3 month average
	try 
	{
	
	String newquery="SELECT TOP 3 THROUGHPUT FROM NG_POS_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE WI_NAME='"+WI_name+"' and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC";//--CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC";
	List<List<String>> top_3_throughput= iformObj.getDataFromDB(newquery);	
	logger.info("Query to calculate total througput 3 month for main CIC Cortex is "+newquery+" and its result is "+top_3_throughput);
	
	double total_transaction_amt_3_months=0;
	if(top_3_throughput.size()>0)
	{
		for (Iterator<List<String>> iter = top_3_throughput.iterator(); iter.hasNext(); ) 
		{
		    List<String> element = iter.next();
		    total_transaction_amt_3_months=total_transaction_amt_3_months+Double.parseDouble(element.get(0));    
		}	
	}
	
	logger.info("Total Transaction Amount of 3 months for main CIC cortex is "+total_transaction_amt_3_months);
//	iformObj.setValue("Q_NG_POS_STMTDATA_STMT_ANALYSIS_AVG_POS_MACHN_LAST_3MNTH",Double.toString(total_transaction_amt_3_months));	
	
	newquery="SELECT TOT_THRGPUT_12MNTH,AVG_THRGPUT_12MNTH FROM NG_POS_STMTDATA_CORTEX_DETAIL where WI_NAME='"+WI_name+"' ";
	List<List<String>> top_12_throughput= iformObj.getDataFromDB(newquery);	
	logger.info("Query to calculate total througput and avg througput 12 month for main CIC Cortex is "+newquery+ "and it's result is "+top_12_throughput);

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
	//newquery="select TOP 3 THROUGHPUT from NG_MSB_SEARCH_NONPOS_POS_DETAILS where CIC='"+cic_number+"' ORDER BY convert(DATETIME,replace('01-'+transaction_month,'-',' '),13) desc";
	newquery="select TOP 3 THROUGHPUT from NG_POS_STMTDATA_OTHER_DETAIL_GRID where WI_NAME='"+WI_name+"' ORDER BY convert(date,'01/'+OTHER_MONTH,103) DESC";//convert(DATETIME,replace('01-'+OTHER_MONTH,'-',' '),13) desc";		
			List<List<String>> top_3_throughput_nonPOS= iformObj.getDataFromDB(newquery);
			logger.info("Query to calculate total througput for Non ARB Cortex (Bank statement upload) 3 month is "+newquery+ "and it's result is "+top_3_throughput_nonPOS);
			if(top_3_throughput_nonPOS.size()>0)
			{
				for (Iterator<List<String>> iter = top_3_throughput_nonPOS.iterator(); iter.hasNext(); ) 
				{
				    List<String> element = iter.next();
				    if(element.get(0)!="")
				    total_transaction_amt_3_months=total_transaction_amt_3_months+Double.parseDouble(element.get(0));
				}	
			}
	//End By Deepak Goyal
			
			
	//Start Edit By Deepak Goyal
	double total_transaction_amt_9_months_non=0;
	newquery="select TOP 9 THROUGHPUT from NG_POS_STMTDATA_OTHER_DETAIL_GRID where WI_NAME='"+WI_name+"' ORDER BY convert(date,'01/'+OTHER_MONTH,103) ASC";//convert(DATETIME,replace('01-'+OTHER_MONTH,'-',' '),13) asc";
	//newquery="select TOP 3 THROUGHPUT from NG_POS_STMTDATA_OTHER_DETAIL_GRID where WI_NAME='"+WI_name+"' ORDER BY convert(DATETIME,replace('01-'+OTHER_MONTH,'-',' '),13) desc";
	List<List<String>> top_9_throughput= iformObj.getDataFromDB(newquery);	
	logger.info("Query to calculate total througput for Non ARB Cortex (Bank statement upload) 9 month is "+newquery+" and it's result is "+top_9_throughput);		
	if(top_9_throughput.size()>0)
	{
		for (Iterator<List<String>> iter = top_9_throughput.iterator(); iter.hasNext(); ) 
		{
		    List<String> element = iter.next();
		    if(element.get(0)!="")
		    total_transaction_amt_9_months_non=total_transaction_amt_9_months_non+Double.parseDouble(element.get(0));
			    
		}	
	}
	total_transaction_amt_9_months=total_transaction_amt_9_months+total_transaction_amt_9_months_non;
	//End edit by Deepak Goyal
	
	
	//Start of Calculation for Old CIC Data
	double total_transaction_amt_9_months_oldCIC=0,total_transaction_amt_3_months_oldCIC=0;
	newquery="SELECT TOP 3 THROUGHPUT FROM NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE WI_NAME='"+WI_name+"' and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) DESC";//--CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) DESC		
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
	
	newquery="SELECT TOP 9 THROUGHPUT FROM NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_GRID_ALL_MACHINES WHERE WI_NAME='"+WI_name+"' and cortex_month<>'' and cortex_month<>'0' ORDER BY convert(date,'01/'+cortex_month,103) ASC ";//--CAST(REPLACE(SUBSTRING(CORTEX_MONTH,4,7) +SUBSTRING(CORTEX_MONTH,1,3),'/','') AS INT) ASC
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
	List<List<String>> no_of_pos_machine_object= iformObj.getDataFromDB(newquery);
	logger.info("Result of query to calculate no of pos machines for main party CIC is "+newquery+" and it's result is "+no_of_pos_machine_object);
	if(no_of_pos_machine_object.size()>0)
	{
		if(!no_of_pos_machine_object.get(0).get(0).equalsIgnoreCase("NULL") && !no_of_pos_machine_object.get(0).get(0).equalsIgnoreCase(""))
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
	
	
	String no_non_of_pos_machine="0";
	//newquery="SELECT TOP 1 NON_ARB_POS_MACHINE_NO FROM NG_STATEMENT_OCR_CUST_INFO WHERE CIC_NO ='"+padded_cic_no+"' ORDER BY CAST(SUBSTRING(WI_NAME,5,14) AS INT) DESC ";
	newquery="SELECT convert(varchar,min(convert(date,pos_since,103)),103),sum(num_of_pos) FROM (select pos_since,num_of_pos,row_number() over(partition by  bank_name+'_'+acc_no order by  bank_name+'_'+acc_no ) rownum from NG_POS_STMTDATA_OTHER_DETAIL_GRID_REUPLOAD  WHERE   wi_name = '"+WI_name+"') a where rownum=1";
	List<List<String>> no_of_non_pos_machine_object= iformObj.getDataFromDB(newquery);
	logger.info("Result of query to calculate no of non pos machines is "+newquery+"and its result is "+no_of_non_pos_machine_object);
	if(no_of_non_pos_machine_object.size()>0)
	{
		if(!no_of_non_pos_machine_object.get(0).get(1).equalsIgnoreCase("NULL"))
			no_non_of_pos_machine=no_of_non_pos_machine_object.get(0).get(1);
	}
	
	String savequery="INSERT INTO NG_POS_STMTDATA_STMT_ANALYSIS (WI_NAME,AVG_POS_MACHN_LAST_3MNTH,AVG_POS_MACHN_LAST_12MNTH,NO_POS_MACHINE,NO_NON_POS_MACHINE) VALUES ('"+WI_name+"','"+String.format("%.2f",total_transaction_amt_3_months/3)+"','"+String.format("%.2f",total_transaction_amt_9_months/9)+"','"+ String.valueOf(no_of_pos_machine)+"','"+no_non_of_pos_machine+" ') ";
	logger.info("Query to update statement analysis in statement data tab is "+savequery);
	
	//saveDataInDB(iformObj, savequery);
	iformObj.setValue("Q_NG_POS_STMTDATA_STMT_ANALYSIS_AVG_POS_MACHN_LAST_3MNTH", String.format("%.2f",total_transaction_amt_3_months/3));
	iformObj.setValue("Q_NG_POS_STMTDATA_STMT_ANALYSIS_AVG_POS_MACHN_LAST_12MNTH", String.format("%.2f",total_transaction_amt_9_months/9));
	iformObj.setValue("Q_NG_POS_STMTDATA_STMT_ANALYSIS_NO_NON_POS_MACHINE",no_non_of_pos_machine );
	try 
	{
		iformObj.setValue("Q_NG_POS_STMTDATA_STMT_ANALYSIS_NO_POS_MACHINE",String.valueOf(Double.valueOf(no_of_pos_machine).intValue()));
	}
	catch(Exception e)
	{
		iformObj.setValue("Q_NG_POS_STMTDATA_STMT_ANALYSIS_NO_POS_MACHINE","0");
	}
	
		
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
	List<List<String>> max_limit_amnt= iformObj.getDataFromDB(newquery);	
	logger.info("Query to calculate maximum indicative amount is "+newquery+" and it's result is "+max_limit_amnt);
	String max_indicative_amt="0";
	if(max_limit_amnt.size()>0)
	{
		max_indicative_amt=max_limit_amnt.get(0).get(0);
	}
	//iformObj.setValue("Q_NG_POS_ELIGIBILITY_ELIGIBLE_POS_LIMIT",max_indicative_amt);
	//savequery="UPDATE NG_POS_ELIGIBILITY SET POS_TRNOVR_ALL='"+Double.toString(total_transaction_amt_12_months_non_arb+total_transaction_amt_12_months)+"',POS_TRNOVR_ALRAJHI='"+Double.toString(total_transaction_amt_12_months)+"',POS_TRNOVR_OTHRBANK='"+Double.toString(total_transaction_amt_12_months_non_arb)+"',AVG_POS_MNTHLY_TRNOVRALL='"+Double.toString(avg_transaction_amt_12_months_non_arb+avg_transaction_amt_12_months)+"',AVG_POS_MNTHLY_TRNOVRALL_ALRAJHI='"+Double.toString(avg_transaction_amt_12_months)+"',AVG_POS_MNTHLY_TRNOVRALL_OTHRBANK='"+Double.toString(avg_transaction_amt_12_months_non_arb)+"',ELIGIBILE_POS_LIMIT='"+max_indicative_amt+"' WHERE WI_NAME='"+WI_name+"' ";
	savequery="INSERT INTO NG_POS_ELIGIBILITY (WI_NAME,POS_TRNOVR_ALL,POS_TRNOVR_ALRAJHI,POS_TRNOVR_OTHRBANK,AVG_POS_MNTHLY_TRNOVRALL,AVG_POS_MNTHLY_TRNOVRALL_ALRAJHI,AVG_POS_MNTHLY_TRNOVRALL_OTHRBANK,ELIGIBILE_POS_LIMIT) VALUES ('"+WI_name+"','"+String.format("%.2f",total_transaction_amt_12_months_non_arb+total_transaction_amt_12_months)+"','"+String.format("%.2f",total_transaction_amt_12_months)+"','"+String.format("%.2f",total_transaction_amt_12_months_non_arb)+"','"+String.format("%.2f",avg_transaction_amt_12_months_non_arb+avg_transaction_amt_12_months)+"','"+String.format("%.2f",avg_transaction_amt_12_months)+"','"+String.format("%.2f",avg_transaction_amt_12_months_non_arb)+"','"+max_indicative_amt+"')";
	logger.info("Query to update eligibilty tab is "+savequery);
	//saveDataInDB(iformObj, savequery);
	
	iformObj.setValue("Q_NG_POS_ELIGIBILITY_POS_TRNOVR_ALL", String.format("%.2f",total_transaction_amt_12_months_non_arb+total_transaction_amt_12_months));
	iformObj.setValue("Q_NG_POS_ELIGIBILITY_POS_TRNOVR_ALRAJHI", String.format("%.2f",total_transaction_amt_12_months));
	iformObj.setValue("Q_NG_POS_ELIGIBILITY_POS_TRNOVR_OTHRBANK", String.format("%.2f",total_transaction_amt_12_months_non_arb));
	
	iformObj.setValue("Q_NG_POS_ELIGIBILITY_AVG_POS_MNTHLY_TRNOVRALL", String.format("%.2f",avg_transaction_amt_12_months_non_arb+avg_transaction_amt_12_months));
	iformObj.setValue("Q_NG_POS_ELIGIBILITY_AVG_POS_MNTHLY_TRNOVRALL_ALRAJHI", String.format("%.2f",avg_transaction_amt_12_months));
	iformObj.setValue("Q_NG_POS_ELIGIBILITY_AVG_POS_MONTHLY_TRNOVRALL_OTHRBANK", String.format("%.2f",avg_transaction_amt_12_months_non_arb));
	
	double total_4_months_eligb=0;
	String temp=(String) iformObj.getValue("Q_NG_POS_STMTDATA_CORTEX_DETAIL_AVG_THRGPUT_4MNTH");
	String temp2=(String) iformObj.getValue("Q_NG_POS_OLD_CIC_STMTDATA_CORTEX_DETAIL_AVG_THRPUT_4MNTH");
	total_4_months_eligb=Double.parseDouble(temp)+Double.parseDouble(temp2);
	iformObj.setValue("Q_NG_POS_ELIGIBILITY_AVG_THRGPUT_4MNTH", String.format("%.2f",total_4_months_eligb));
	
	}
	catch(Exception e)
	{
		logger.info("Exception occurred: fillStatementAnalysisDetails  "+e);
	}
	return "fillStatementAnalysisDetails executed Successfully";
}


}

	

