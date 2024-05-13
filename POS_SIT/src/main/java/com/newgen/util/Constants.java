/*
---------------------------------------------------------------------------------------------------------
				NEWGEN SOFTWARE TECHNOLOGIES LIMITED
Group						: Application -Projects
Project/Product				:      ADNIC
Application					: Motor Claim Process
Module					: IBPS 5 process
File Name					: Constants.java
Author						: Shobhit Jain , Navjot Singh
Date (DD/MM/YYYY)			: 30 May 2020
Description					: Constant java file
-------------------------------------------------------------------------------------------------------
CHANGE HISTORY
-------------------------------------------------------------------------------------------------------
Problem No/CR No   Change Date   Changed By    Change Description
------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------*/

package com.newgen.util;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {
	
	private Constants() {
	}
	public static final Character DOCUMENT_MANDATORY_FLAG = 'Y';
	public static final String DECISION_SUBMIT = "Submit";
	public static final String DECISION_REJECT = "Reject";
	

	public static class WORKSTEP 
	{
		private WORKSTEP() {
		}
		
		public static final String POS_SEARCH = "MSB_Search";
		public static final String FNOL_LEGAL_INTRODUCTION = "FNOL_Legal";
		public static final String FNOL_AMBULANCE_INTRODUCTION = "FNOL_Ambulance";
		public static final String FNOL_TPI_INTIMATION_INTRODUCTION = "FNOL_TPI_Intimation";
		public static final String FNOL_TPI_INWARDS_INTRODUCTION = "FNOL_TPI_Inwards";

		public static final String FNOL = "FNOL";
		public static final String FNOL_LEGAL = "FNOLLegal";
		public static final String FNOL_AMBULANCE = "FNOLAmbulance";
		public static final String FNOL_TPI_INTIMATION = "FNOLTPIIntimation";
		public static final String FNOL_TPI_INWARDS = "FNOLTPIInward";
		public static final String HOLD_WAIT_FOR_DOC = "Hold_wait_for_doc";

		public static final String REVIEW_AND_ACTION = "Review_and_action";
		public static final String SALVAGE = "Salvage";
		public static final String SALVAGE_TPI_INWARDS = "Salvage_TPI_Inwards";
		public static final String DISCREPANCY_HANDLER = "DiscrepancyHandler";
		public static final String CLAIMS_MANAGER = "Claims_Manager";
		public static final String CLAIMS_HANDLER = "Claims_Handler";
		public static final String RepSrvAllocation = "Repairer_Surveyor_Allocation";
		
		
		public static final String SETTLEMENT_TOTAL_LOSS = "Settlement_TL";
		public static final String SETTLEMENT_NON_TOTAL_LOSS = "Settlement_Non_TL";
		
		public static final String TPIINWARDS ="TPI_Inwards";
		public static final String RECOVERY_SUBMISSION ="Recovery_Submission";
		public static final String RECOVERY_INDIVIDUAL ="Recovery_Individual";
		public static final String MOTOR_LEGAL ="Motor_Legal";
		public static final String HOLD_WAIT_FOR_TPI_SALVAGE ="HOLD_Wait_TPI_Salvage";
		public static final String EXIT ="Exit";
		public static final String SURVEYOR ="Surveyor";
		
		

	}

	public static class APINames 
	{
		private APINames() {
		}
		
		public static final String SEARCH_POLICY = "SearchPolicy";
		public static final String FETCH_CLAIM_HISTORY = "FetchClaimHistory";
		public static final String GENERATE_CLAIM = "GenerateClaim";
		public static final String CREATE_RESERVE = "CreateReserve";
		public static final String FETCH_RESERVE = "FetchReserve";
		public static final String FETCH_DOCUMENT_ON_BASE = "FetchDocumentOnBase";
		public static final String TO_ADNIC_PORTAL_OPTION = "ToAdnicPortal";
		public static final String GENERATE_LPO_OPTION = "GenerateLPO";
		public static final String PAYMENT_STATUS_OPTION = "PaymentStatus";
		public static final String CREATE_SALVAGE_OPTION = "CreateSalvage";
		public static final String CREATE_RECOVERY_OPTION = "CreateRecovery";
		public static final String CREATE_SETTLEMENT_OPTION = "CreateSettlement";
		public static final String REVERSE_CLAIM_OPTION = "ReverseClaim";
		public static final String SEND_SMS_OPTION = "SendSMS";
		public static final String UPLOAD_DOC_OPTION = "UploadDoc";
		public static final String CLOSE_CLAIM_OPTION = "CloseClaim";
	}

	public static class SalvageTPIInwards 
	{
		private SalvageTPIInwards() {
		}

		public static final String FIELD_TPI_COMPANY_NAME = "Q_SALVAGE_SETTLEMENT_TPI_TPI_Company_Name";
		public static final String FIELD_TPI_COMPANT_ESTIMATE = "Q_SALVAGE_SETTLEMENT_TPI_tpi_company_emirate";
		public static final String CHECKBOX_SEND_TO_ADNIC_PORTAL = "Q_SALVAGE_SETTLEMENT_TPI_send_adnic_portal";
		public static final String FIELD_TPI_SALVAGE_AMOUNT = "Q_SALVAGE_SETTLEMENT_TPI_TPI_Salvage_Amount";
		public static final String FIELD_ADNIC_SALVAGE_AMOUNT = "Q_SALVAGE_SETTLEMENT_TPI_ADNIC_Salvage_Amount";
		public static final String FIELD_DIFFERENCE_IN_SALVAGE_AMOUNT = "Q_SALVAGE_SETTLEMENT_TPI_Difference_in_Salvage";
		public static final String FIELD_HIGHEST_BUYER_NAME = "Q_SALVAGE_SETTLEMENT_TPI_highest_buyer_name";
		public static final String FIELD_BUYER_CONTACT = "Q_SALVAGE_SETTLEMENT_TPI_buyer_contact";
		public static final String FIELD_CONTACT_NUMBER_OF_GARAGE = "Q_SALVAGE_SETTLEMENT_TPI_contact_number_of_garage";
		public static final String FIELD_NAME_OF_GARAGE_PERSON = "Q_SALVAGE_SETTLEMENT_TPI_name_of_garage_person";
		public static final String FIELD_BASE_BID_AMOUNT = "Q_SALVAGE_SETTLEMENT_TPI_base_bid_amount";
		public static final String FIELD_EMIRATE = "Q_SALVAGE_SETTLEMENT_TPI_emirate";
		public static final String FIELD_VEHICLE_MAKE = "Q_SALVAGE_SETTLEMENT_TPI_vehicle_make";
		public static final String FIELD_VEHICLE_MODEL = "Q_SALVAGE_SETTLEMENT_TPI_vehicle_model";
		public static final String FIELD_YEAR = "Q_SALVAGE_SETTLEMENT_TPI_year";
		public static final String FIELD_CHASSIS_NUMBER = "Q_SALVAGE_SETTLEMENT_TPI_chassis_number";
		public static final String FIELD_VEHICLE_USAGE = "Q_SALVAGE_SETTLEMENT_TPI_vehicle_usage";
		public static final String FIELD_COLOR = "Q_SALVAGE_SETTLEMENT_TPI_color";
		public static final String FIELD_VEHICLE_LOCATION = "Q_SALVAGE_SETTLEMENT_TPI_vehicle_location";
	}
	
	public static class FNOLTeam 
	{
		private FNOLTeam() {
		}
		
		public static final String JSON_CLAIM_DETAILS_SECTION = "ClaimDetails";
		public static final String JSON_CLAIMANT_DETAILS_SECTION = "ClaimantDetails";
		public static final String JSON_DRIVER_DETAILS_SECTION = "DriverDetails";
		public static final String JSON_VEHICLE_DETAILS_SECTION = "VehicleDetails";
		public static final String JSON_RESERVE_DETAILS_SECTION = "ReserveDetails";
		public static final String JSON_EXPENSES_DETAILS_SECTION = "ExpensesDetails";
		public static final String JSON_BODILY_INJURY_DETAILS_SECTION = "BodilyInjuryDetails";
		public static final String JSON_PROPERTY_DETAILS_SECTION = "PropertyDetails";
		public static final String JSON_TPI_DETAILS_SECTION = "TPIDetails";
		public static final String JSON_RECOVERY_DETAILS_SECTION = "RecoveryDetails";
		public static final String JSON_TPI_DRIVER_DETAILS_SECTION = "TPDriverDetails";

		public static class Header 
		{
			private Header() {
			}

			public static final String FIELD_SOURCE_SYSTEM = "SOURCE_SYSTEM";
			public static final String FIELD_INSURED_NAME = "insured_name";
			public static final String FIELD_FNOLName = "FNOLName";
			public static final String FIELD_CLAIM_NO = "ClaimNo";
			public static final String FIELD_DAMAGE_TYPE = "CauseOfLoss";
			public static final String FIELD_DATE_OF_LOSS = "DateOfLoss";
			public static final String FIELD_CLAIM_STATUS = "Claim_Status";
			public static final String FIELD_CLAIM_SUBSTATUS = "Claim_SubStatus";
			public static final String FIELD_CLAIM_FULL_STATUS = "Full_Claim_Status";
			
		}

		public static class SearchPolicy 
		{
			private SearchPolicy() {
			}

			public static final String FIELD_DATE_OF_LOSS = "Q_SearchDtl_Date_Of_Loss";
			public static final String FIELD_POLICY_NO = "PolicyNo";
			public static final String FIELD_EMAIL_ID = "Q_SearchDtl_EMail_Id";
			public static final String FIELD_MAKE = "Q_SearchDtl_Make";
			public static final String FIELD_MODEL = "Q_SearchDtl_Model";
			public static final String FIELD_INSURED_NAME = "Q_SearchDtl_Insured_Name";
			public static final String FIELD_TC_NUMBER = "Q_SearchDtl_TC_Number";
			public static final String FIELD_MOBILE_NO = "Q_SearchDtl_MobileNo";
			public static final String FIELD_CHASSIS_NO = "Q_SearchDtl_Chassis_No";
			public static final String FIELD_VEHICLE_REG_NO = "Q_SearchDtl_Registration_No";
			public static final String CHECKBOX_COINSURANCE = "co_insurance";
			public static final String CHECKBOX_DEMO_POLICY = "demo_policy";
			public static final String FIELD_POLICY_FILE_NUMBER = "Q_SearchDtl_policy_file_number";
			public static final String FIELD_POLICY_ID = "Q_SearchDtl_Policy_Id";
			public static final String FIELD_ENGINE_NO = "Q_SearchDtl_Engine_no";
			public static final String FIELD_FLEET_SEQUENCE_NO = "Q_SearchDtl_Fleet_seq_no";
			public static final String FIELD_EXPIRY_DATE = "Q_SearchDtl_Policy_Expiry_Date";
			public static final String GRID_POLICY_DETAILS = "PD_Grid";
			public static final String GRID_VEHICLE_DETAILS = "VD_Grid";

		}

		public static class PolicyDetailSubForm 
		{
			private PolicyDetailSubForm() {
			}

			public static final String GRID_DRIVER_DETAILS = "table147";
			public static final String FIELD_THE_INSURED = "Q_Fetch_Policy_Insured";
			public static final String FIELD_INSURED_EMAIL_ID = "Q_Fetch_Policy_Insured_email";
			public static final String FIELD_INSURED_MOBILE_NUMBER = "Q_Fetch_Policy_Insured_Contact";
			public static final String FIELD_PLATE_NUMBER = "Q_Fetch_Policy_plate_number";
			public static final String FIELD_CHASSIS_NO = "Q_Fetch_Policy_Chassis_No";
			public static final String FIELD_MAKE = "Q_Fetch_Policy_Make";
			public static final String FIELD_MODEL = "Q_Fetch_Policy_Model";
			public static final String FIELD_ENGINE_NO = "Q_Fetch_Policy_Engine_No";
			public static final String FIELD_MANUFACTURING_YEAR = "Q_Fetch_Policy_Year_of_Manufacture";
			public static final String FIELD_COLOR = "Q_Fetch_Policy_Color";
			public static final String FIELD_INSURED_VALUE = "Q_Fetch_Policy_Sum_Insured";
			public static final String FIELD_POLICY_ID = "Q_Fetch_Policy_policyid"; // also policy seq no
			public static final String FIELD_VEHICLE_SEQUENCE_NO = "Q_Fetch_Policy_vehicle_seq_no";
			public static final String FIELD_PLATE_CODE = "Q_Fetch_Policy_PlateCode";
			public static final String FIELD_PLATE_CATEGORY = "Q_Fetch_Policy_PlateCategory";
			public static final String FIELD_REGISTRATION_DATE = "Q_Fetch_Policy_Registration_Date";
			public static final String FIELD_BODY_TYPE = "Q_Fetch_Policy_Type_of_Body";
			public static final String FIELD_VEHICLE_START_DATE = "Q_Fetch_Policy_vehicleStartDate";
			public static final String FIELD_VEHICLE_END_DATE = "Q_Fetch_Policy_vehicleEndDate";
			public static final String FIELD_SOURCE_OF_BUSINESS = "Q_Fetch_Policy_source_of_business";
			public static final String FIELD_POLICY_BRANCH = "Q_Fetch_Policy_policy_branch";
			public static final String FIELD_POLICY_CENTER = "Q_Fetch_Policy_policy_center";
			public static final String FIELD_TC_NUMBER = "Q_Fetch_Policy_tc_number";

		}
		public static class ClaimHistorySubForm 
		{
			private ClaimHistorySubForm() {
			}

			public static final String GRID_CLAIM_HISTORY_DETAILS = "table294";
		}

		public static class ClaimDetailsSheet 
		{
			private ClaimDetailsSheet() {
			}
			
			// Claim Details Section
			public static final String FIELD_INTIMATION_TYPE = "IntimationType";
			public static final String FIELD_COVER_DESCRIPTION = "Q_CLAIM_DETAILS_Accident_Type";
			public static final String FIELD_DAMAGE_TYPE = "Q_CLAIM_DETAILS_TypeofLoss";
			public static final String FIELD_REQUEST_NOTIFIED_BY = "CaseNotifiedBy";
			public static final String FIELD_RECOVERY_SELECTED = "Q_CLAIM_DETAILS_recovery";
			public static final String FIELD_DATE_OF_INTIMATION = "intimation_date";
			public static final String FIELD_COUNTRY_OF_LOSS = "Q_CLAIM_DETAILS_area_of_loss";
			public static final String FIELD_AREA = "Q_CLAIM_DETAILS_claim_area";
			public static final String FIELD_CITY_OF_LOSS = "Q_CLAIM_DETAILS_Accident_Location";
			public static final String FIELD_CAUSE_OF_LOSS = "Q_CLAIM_DETAILS_Cause_Of_Loss";
			public static final String FIELD_NATURE_OF_LOSS = "Q_CLAIM_DETAILS_Secondary_Cause";
			public static final String FIELD_DATE_OF_LOSS = "Q_CLAIM_DETAILS_Date_Of_Loss";
			public static final String FIELD_TIME_OF_LOSS = "Q_CLAIM_DETAILS_Time_Of_Loss";
			public static final String FIELD_ACCIDENT_REPORT_NUMBER = "PoliceReportNo";
			public static final String FIELD_ACCIDENT_REPORT_DATE = "PoliceReportDate";
			public static final String FIELD_EVENT_NAME = "Q_CLAIM_DETAILS_event_name";
			public static final String FIELD_EVENT_CODE = "Q_CLAIM_DETAILS_event_code";
			public static final String FIELD_EVENT_PERIOD_FROM = "Q_CLAIM_DETAILS_event_period";
			public static final String FIELD_EVENT_PERIOD_TO = "Q_CLAIM_DETAILS_event_period_to";
			public static final String FIELD_RESPONISIBILITY_PERCENTAGE = "Q_CLAIM_DETAILS_Responsibility";
			public static final String FIELD_CURRENCY = "Q_CLAIM_DETAILS_Currency";
			public static final String FIELD_TYPE_OF_RECOVERY = "type_of_recovery";
			public static final String CHECKBOX_IS_GOVERNMENT_VEHICLE = "Q_CLAIM_DETAILS_Government_Vehicle";

			public static final String CHECKBOX_IS_LEGAL = "Q_CLAIM_DETAILS_Is_Legal";
			public static final String CHECKBOX_IS_SALVAGE = "Q_CLAIM_DETAILS_salvage";
			public static final String CHECKBOX_IS_CLAIMANT_INSURED = "Q_CLAIM_DETAILS_Claimant_is_Insured";
			public static final String CHECKBOX_IS_RECOVERY = "Q_CLAIM_DETAILS_recovery";

			// Claimant Details Section
			public static final String FIELD_PARTY_TYPE = "Q_CLAIMANT_DETAILS_Party_Type";
			public static final String FIELD_CLAIMANT_FIRST_NAME = "first_name";
			public static final String FIELD_CLAIMANT_LAST_NAME = "last_name";
			public static final String FIELD_CLAIMANT_DOB = "Q_CLAIMANT_DETAILS_date_of_birth";
			public static final String FIELD_CLAIMANT_GENDER = "Q_CLAIMANT_DETAILS_Gender";
			public static final String FIELD_CLAIMANT_EMAIL_ID = "EMAIL_CLAIMANT";
			public static final String FIELD_CLAIMANT_MOBILE_NUMBER = "Mobile_no";
			public static final String FIELD_CLAIMANT_TC_NUMBER = "Q_CLAIMANT_DETAILS_Tc_Number";
			public static final String CHECKBOX_IS_VIP = "Q_CLAIMANT_DETAILS_VIP";
			public static final String FIELD_CLAIMANT_NATIONALITY = "Q_CLAIMANT_DETAILS_nationality";
			public static final String FIELD_CLAIMANT_EMIRATES_ID = "Q_CLAIMANT_DETAILS_ClaimantNationalID";

			public static final String FIELD_CLAIMANT_INDIVIDUAL_PARTY_TYPE_VALUE = "I";

			// TPI Details Section
			public static final String FIELD_ACCOUNT_BRANCH = "Q_TPI_DETAILS_account_branch";
			public static final String FIELD_TPI_POLICY_NO = "Q_TPI_DETAILS_Policy_No";
			public static final String FIELD_COMPANY_NAME = "Q_TPI_DETAILS_Company_Name";
			public static final String FIELD_COMPANY_CODE = "Q_TPI_DETAILS_Company_code";

			// Driver Details Section
			public static final String CHECKBOX_IS_DRIVER_INSURED = "Q_OD_DRIVER_DETAILS_Is_DriveSameasInsured";
			public static final String FIELD_DRIVER_FIRST_NAME = "Q_OD_DRIVER_DETAILS_FirstName";
			public static final String FIELD_DRIVER_LAST_NAME = "Q_OD_DRIVER_DETAILS_LastName";
			public static final String FIELD_DRIVER_DATE_OF_BIRTH = "Q_OD_DRIVER_DETAILS_Driver_Date_Of_Birth";
			public static final String FIELD_DRIVER_TC_NUMBER = "Q_OD_DRIVER_DETAILS_TC_number";
			public static final String FIELD_DRIVER_GENDER = "Q_OD_DRIVER_DETAILS_Gender";
			public static final String FIELD_DRIVER_LICENSE_NO = "Q_OD_DRIVER_DETAILS_Driver_License_No";
			public static final String FIELD_DRIVER_LICENSE_EXPIRY_DATE = "Q_OD_DRIVER_DETAILS_License_Expiry_Date";
			public static final String FIELD_DRIVER_LICENSE_PLACE_OF_ISSUE = "Q_OD_DRIVER_DETAILS_Driver_License_Place_Of_Issue";
			public static final String FIELD_DRIVER_AGE = "Q_OD_DRIVER_DETAILS_Driver_Age";
			public static final String FIELD_DRIVER_NATIONAL_ID = "Q_OD_DRIVER_DETAILS_NationalID";
			public static final String FIELD_DRIVER_NATIONALITY = "Q_OD_DRIVER_DETAILS_Nationality";

			// Driver Details Section
			public static final String FIELD_TP_DRIVER_FIRST_NAME = "Q_TP_DRIVER_DETAILS_first_name";
			public static final String FIELD_TP_DRIVER_LAST_NAME = "Q_TP_DRIVER_DETAILS_last_name";
			public static final String FIELD_TP_DRIVER_DATE_OF_BIRTH = "Q_TP_DRIVER_DETAILS_Date_Of_Birth";
			public static final String FIELD_TP_DRIVER_TC_NUMBER = "Q_TP_DRIVER_DETAILS_tc_number";
			public static final String FIELD_TP_DRIVER_GENDER = "Q_TP_DRIVER_DETAILS_Gender";
			public static final String FIELD_TP_DRIVER_LICENSE_NO = "Q_TP_DRIVER_DETAILS_License_No";
			public static final String FIELD_TP_DRIVER_LICENSE_EXPIRY_DATE = "Q_TP_DRIVER_DETAILS_Expiry_Date";
			public static final String FIELD_TP_DRIVER_LICENSE_PLACE_OF_ISSUE = "Q_TP_DRIVER_DETAILS_Place_Of_Issue";
			public static final String FIELD_TP_DRIVER_AGE = "Q_TP_DRIVER_DETAILS_Age";

			// Recovery Details Section
			public static final String FIELD_RECOVERY_TYPE = "type_of_recovery";
			public static final String FIELD_RECOVERY_COMPANY_CODE = "Q_Third_Party_Vehicle_Company_code";
			public static final String FIELD_RECOVERY_COMPANY_NAME = "Q_Third_Party_Vehicle_Insurance_Company_Name";
			public static final String FIELD_RECOVERY_POLICY_NO = "Q_Third_Party_Vehicle_Policy_Number";
			public static final String FIELD_RECOVERY_FIRST_NAME = "Q_Third_Party_Vehicle_First_Name";
			public static final String FIELD_RECOVERY_LAST_NAME = "Q_Third_Party_Vehicle_Last_Name";
			public static final String FIELD_RECOVERY_GENDER = "Q_Third_Party_Vehicle_gender";
			public static final String FIELD_RECOVERY_DATE_OF_BIRTH = "Q_Third_Party_Vehicle_date_of_birth";
			public static final String FIELD_RECOVERY_ACCOUNT_BRANCH = "Q_Third_Party_Vehicle_account_branch";
			public static final String RECOVERY_TYPE_INDIVIDUAL_CODE = "0"; // RECOVERY TYPE DROP DOWN INDIVIDUAL CODE
			public static final String FIELD_RECOVERY_PLATE_NO = "Q_Third_Party_Vehicle_Vehicle_Plate_Number";
			public static final String FIELD_RECOVERY_CHASSIS_NO = "Q_Third_Party_Vehicle_chasis_number";
			public static final String FIELD_RECOVERY_MAKE = "Q_Third_Party_Vehicle_Make_of_Vehicle";
			public static final String FIELD_RECOVERY_MODEL = "Q_Third_Party_Vehicle_Model_of_Vehicle";

			// Bodily Injury Details Section
			public static final String FIELD_BODILY_NAME = "Q_BODILY_DEATH_INJURY_Name";
			public static final String FIELD_BODILY_DATE_OF_BIRTH = "Q_BODILY_DEATH_INJURY_date_of_birth";
			public static final String FIELD_BODILY_NATIONALITY = "Q_BODILY_DEATH_INJURY_Nationality";
			public static final String FIELD_BODILY_GENDER = "Q_BODILY_DEATH_INJURY_gender";

			// Property Details Section
			public static final String FIELD_PROPERTY_DESCRIPTION = "Q_PROPERTY_Property_Description";

			// Vehicle Details Section
			public static final String FIELD_VEHICLE_PLATE_CATEGORY = "Q_VEHICLE_DETAILS_Registration_No";
			public static final String FIELD_VEHICLE_PLATE_CODE = "Q_VEHICLE_DETAILS_Sequence_No";
			public static final String FIELD_VEHICLE_PLATE_NO = "plate_number";
			public static final String FIELD_VEHICLE_CHASSIS_NO = "ChassisNo";
			public static final String FIELD_VEHICLE_MAKE = "make";
			public static final String FIELD_VEHICLE_MODEL = "model";
			public static final String FIELD_VEHICLE_MANUFACTURING_YEAR = "Q_VEHICLE_DETAILS_Manuf_Year";
			public static final String FIELD_VEHICLE_ENGINE_NO = "Q_VEHICLE_DETAILS_Engine_No";
			public static final String FIELD_VEHICLE_REGISTRATION_DATE = "Q_VEHICLE_DETAILS_Vehicle_Registration_Date";
			public static final String FIELD_VEHICLE_COLOUR = "Q_VEHICLE_DETAILS_Colour";
			public static final String FIELD_VEHICLE_TYPE = "Q_VEHICLE_DETAILS_Vehicle_Type";
			public static final String FIELD_VEHICLE_TRAFFIC_FILE_NUMBER = "Q_VEHICLE_DETAILS_traffic_File_Number";
			public static final String FIELD_VEHICLE_ACCOUNT_BRANCH = "Q_VEHICLE_DETAILS_account_branch";
			public static final String FIELD_VEHICLE_COMPANY_CODE = "Q_VEHICLE_DETAILS_company_code";
			public static final String FIELD_VEHICLE_COMPANY_NAME = "Q_VEHICLE_DETAILS_insrnce_company";
			public static final String FIELD_VEHICLE_POLICY_TYPE = "Q_VEHICLE_DETAILS_policy_type";
			public static final String FIELD_VEHICLE_POLICY_NUMBER = "Q_VEHICLE_DETAILS_policy_number";
			public static final String FIELD_VEHICLE_INSURED_VALUE = "Q_VEHICLE_DETAILS_insured_value";

			public static class Sections 
			{
				private Sections() {
				}
				
				public static final String SECTION_CLAIM_DETAILS = "ClaimDetails";
				public static final String SECTION_CLAIMAINT_DETAILS = "ClaimantDetails";
				public static final String SECTION_DRIVER_DETAILS = "ODDriverDetails";
				public static final String SECTION_VEHICAL_DETAILS = "VehicalDetails";
				public static final String SECTION_BODILY_DEATH = "BodilyDeath";
				public static final String SECTION_PROPERTY = "Property";
				public static final String SECTION_TPI_DETAILS = "TPIDetails";
				public static final String SECTION_RECOVERY_DETAILS = "RecoveryDetails";
				public static final String SECTION_EXISTING_CLAIM_CHECK = "ExistingClaimCheck";
				public static final String SECTION_DUPLICATE_CLAIM = "DuplicateClaim";
				public static final String SECTION_TP_DRIVER_DETAILS = "TPDriverDetails";
			}
		}

		public static class ReserveAndExpenseSheet 
		{
			private ReserveAndExpenseSheet() {
			}

			public static final String FIELD_ADDITIONAL_EXCESS = "Q_Reserve_Details_Additional_Excess";
			public static final String FIELD_POLICY_EXCESS = "Q_Reserve_Details_Policy_Excess";
			public static final String FIELD_TOTAL_EXCESS = "Q_Reserve_Details_Total_Excess";
			public static final String FIELD_CURRENCY = "Q_Reserve_Details_currency";
			public static final String FIELD_DEPRECIATION = "Q_Reserve_Details_depreciation";
			public static final String FIELD_NET_RESERVE_AMOUNT = "Q_Reserve_Details_net_resrv_amnt";
			public static final String FIELD_EXPECTED_RECOVERY_AMOUNT = "Q_EXPENSE_DETAILS_xpected_rcvry_amnt";
			public static final String FIELD_SALVAGE_OS_AMOUNT = "Q_EXPENSE_DETAILS_salvage_amnt";
			public static final String GRID_RESERVE_DETAILS = "ReserveTable1";
			public static final String GRID_EXPENSE_DETAILS = "Expenses";
			public static final String BUTTON_CREATE_RESERVE = "createReserveBtn";
		}

		public static class DocumentSheet 
		{
			private DocumentSheet() {
			}
			
			public static final String BUTTON_GENERATE_CLAIM = "button82";
			public static final String BUTTON_POLICY_DOCUMENT = "fetchOnBase";
			public static final String BUTTON_GENERATE_LPO = "generateDocLPO";
			public static final String BUTTON_LATEST_RESERVE = "fetchReserveBtn";
		}

		public static class DecisionSheet 
		{
			private DecisionSheet() {
			}

			public static final String COMBO_DEICISION = "Decision";
		}
		
		public static class ReviewAndActionSheet 
		{
			private ReviewAndActionSheet() {
			}

			//Survey Details
			public static final String FIELD_TOTAL_EXCESS="Q_RVW_SURVEY_DTLS_total_excess";
			public static final String FIELD_TOTAL_DEDUCTIBLE_EXCESS="Q_RVW_SURVEY_DTLS_TOTAL_DEDUCTIBLE_EXCESS";
			public static final String FIELD_DEPRECIATION="Q_RVW_SURVEY_DTLS_DEPRECIATION";

			//Estimate
			public static final String GRID_FINAL_ESTIMATE = "grid_estimateDetailsOuter";
			
			//Action
			public static final String FIELD_INSURED_VALUE="Q_RVW_ACTION_DTLS_insured_value";
			public static final String FIELD_EXPECTED_TOTAL_LOSS="Q_RVW_ACTION_DTLS_xpected_total_loss";
			public static final String FIELD_DEPRECIATION_PERCENT="Q_RVW_ACTION_DTLS_depreciation_percent";
			public static final String FIELD_SAVED_AMOUNT="Q_RVW_ACTION_DTLS_saved_amnt";
			public static final String FIELD_FINAL_AMOUNT="Q_RVW_ACTION_DTLS_final_amnt";
			public static final String FIELD_REPAIR_COST="Q_RVW_ACTION_DTLS_repair_cost";
			public static final String FIELD_APPROVAL_TYPE="approval_type";
			public static final String FIELD_DEPRECIATION_AMOUNT="Q_RVW_ACTION_DTLS_depreciation_amount";
			public static final String FIELD_DEPRECIATION_DAYS="Q_RVW_ACTION_DTLS_depreciation_days";
			public static final String FIELD_OTHER_DEDUTIBLES="Q_RVW_ACTION_DTLS_other_deductibles";
			public static final String FIELD_EXPECTED_SALVAGE_AMOUNT = "Q_RVW_ACTION_DTLS_expected_salvage_amount";
			public static final String FIELD_TP_MARKET_VALUE =  "Q_RVW_ACTION_DTLS_tp_market_value";
			
			//Issue Debit Notes
			public static final String FIELD_DEDUCTIBLE_TYPE = "Q_RVW_ACTION_DTLS_deductible_type";
			public static final String FIELD_DEDUCTIBLE_AMOUNT = "Q_RVW_ACTION_DTLS_amount";
			public static final String FIELD_DEDUCTIBLE_CUSTOMER_CODE = "Q_RVW_ACTION_DTLS_customer_code";
			public static final String FIELD_DEDUCTIBLE_CUSTOMER_NAME = "Q_RVW_ACTION_DTLS_customer_name";
			public static final String FIELD_DEDUCTIBLE_BRANCH = "Q_RVW_ACTION_DTLS_branch";
			
			public static final String BUTTON_CANCEL_LPO = "button78";
		}
		
		public static class SettlementTotalLossSheet 
		{
			private SettlementTotalLossSheet() {
			}
			
			//reserve settlement section
			public static final String GRID_RESERVE_SETTLEMENT = "ReserveTableSettlement_TL";
			public static final String GRID_EXPENSE_PROCESSING_DETAILS = "settle_expense_payee_table_tl";
			
			//settlement processing section
			public static final String FIELD_PAYEE_CODE ="Q_Reserve_Details_CT_RESERVE_GRID_reserve_Payee_code";
			public static final String FIELD_PAYEE_NAME ="Q_Reserve_Details_CT_RESERVE_GRID_Reserve_Payee_name_TL";
			public static final String FIELD_PAYEE_BRANCH ="Q_Reserve_Details_CT_RESERVE_GRID_Reserve_Payee_branch_TL";
			public static final String FIELD_EXPENSE_PAYEE_BRANCH_CODE = "expense_settlement_grid_payee_branch_code_hidden"; //hidden field for branch code
		}	
			
		public static class SettlementNonTotalLossSheet 
		{
			private SettlementNonTotalLossSheet() {
			}
			
			//reserve settlement section
			public static final String GRID_RESERVE_SETTLEMENT = "ReserveTableSettlement";
			
			public static final String FIELD_RESERVE_DETAILS_CAUSE_OF_LOSS = "Q_Reserve_Details_CT_RESERVE_GRID_Cause_of_Loss";
			public static final String FIELD_RESERVE_DETAILS_OUTSTANDING_RESERVE = "Q_Reserve_Details_CT_RESERVE_GRID_Outstanding_Reserve";
			public static final String FIELD_RESERVE_DETAILS_FINAL_SETTLEMENT = "Q_Reserve_Details_CT_RESERVE_GRID_Final_Settlement";
			public static final String FIELD_RESERVE_DETAILS_RESERVE_CURRENCY = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_currency";
			public static final String FIELD_RESERVE_DETAILS_LPO_NUMBER = "Q_Reserve_Details_CT_RESERVE_GRID_LPO_Number";
			public static final String FIELD_RESERVE_DETAILS_LPO_AMOUNT = "Q_Reserve_Details_CT_RESERVE_GRID_LPO_Amount";
			public static final String FIELD_RESERVE_DETAILS_TOTAL_EXCESS = "Q_Reserve_Details_CT_RESERVE_GRID_Total_Excess";
			public static final String FIELD_RESERVE_DETAILS_VAT = "Q_Reserve_Details_CT_RESERVE_GRID_vat";
			public static final String FIELD_RESERVE_DETAILS_INVOICE_NUMBER = "Q_Reserve_Details_CT_RESERVE_GRID_Invoice_Number";
			public static final String FIELD_RESERVE_DETAILS_INVOICE_AMOUNT = "Q_Reserve_Details_CT_RESERVE_GRID_Invoice_Amount";
			public static final String FIELD_RESERVE_DETAILS_INVOICE_DATE = "Q_Reserve_Details_CT_RESERVE_GRID_Invoice_Date";
			public static final String FIELD_RESERVE_DETAILS_INVOICE_RECEIVED_DATE = "Q_Reserve_Details_CT_RESERVE_GRID_Invoice_Rec_Date";
			public static final String FIELD_RESERVE_DETAILS_REPAIRER_NAME = "Q_Reserve_Details_CT_RESERVE_GRID_repairer_name";
			public static final String FIELD_RESERVE_DETAILS_REPAIRER_CODE = "Q_Reserve_Details_CT_RESERVE_GRID_repairer_code";
			public static final String FIELD_RESERVE_DETAILS_PAYEE_BRANCH = "Q_Reserve_Details_CT_RESERVE_GRID_payee_branch";
			public static final String BUTTON_RESERVE_DETAILS_INVOICE_DETAILS_SECTION = "reserve_invoice_settle";
			public static final String FIELD_RESERVE_DETAILS_MODE_OF_PAYMENT = "Q_Reserve_Details_CT_RESERVE_GRID_Mode_of_Payment";
			public static final String FIELD_RESERVE_DETAILS_PAYEE_CODE = "Q_Reserve_Details_CT_RESERVE_GRID_Reserve_Payee_code_non_TL";
			public static final String FIELD_RESERVE_DETAILS_PAYEE_NAME = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_Payee_name";
			public static final String FIELD_RESERVE_DETAILS_SETTLEMENT_PAYEE_BRANCH = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_Payee_branch";
			public static final String FIELD_RESERVE_DETAILS_PAYEE_TYPE = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_Payee_Type";
			public static final String FIELD_RESERVE_DETAILS_PAYMENT_TYPE = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_Payment_type";
			public static final String FIELD_RESERVE_DETAILS_SETTLEMENT_INVOICE_NO = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_Invoice_No";
			public static final String FIELD_RESERVE_DETAILS_SETTLEMENT_INVOICE_AMOUNT = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_Invoice_Amount";
			public static final String FIELD_RESERVE_DETAILS_SETTLEMENT_INVOICE_DATE = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_Invoice_Date";
			public static final String FIELD_RESERVE_DETAILS_AMOUNT = "Q_Reserve_Details_CT_RESERVE_GRID_Amount";
			public static final String FIELD_RESERVE_DETAILS_SETTLEMENT_VAT_AMOUNT = "Q_Reserve_Details_CT_RESERVE_GRID_VAT_Amount";
			public static final String FIELD_RESERVE_DETAILS_BENEFICIARY_NAME = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_Beneficiary_name";
			public static final String FIELD_RESERVE_DETAILS_IBAN_NO = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_IBAN_no";
			public static final String FIELD_RESERVE_DETAILS_BANK_NAME = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_Bank_Name";
			public static final String FIELD_RESERVE_DETAILS_BANK_ACCOUNT_NO = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_Bank_Account_No";
			public static final String BUTTON_RESERVE_DETAILS_SETTLEMENT_PROCESSING_SECTION = "table249_button114";
			public static final String FIELD_EXPENSE_PAYEE_BRANCH_CODE = "expense_settlement_grid_payee_branch_code_hidden"; //hidden field for branch code
			public static final String FIELD_DEDUCTIBLE_AMOUNT = "Q_Reserve_Details_CT_RESERVE_GRID_Debit_note_AMOUNT";
			public static final String FIELD_DEDUCTIBLE_CUSTOMER_NAME = "Q_Reserve_Details_CT_RESERVE_GRID_CUSTOMER_NAME";
			public static final String FIELD_DEDUCTIBLE_BRANCH = "Q_Reserve_Details_CT_RESERVE_GRID_BRANCH";
			public static final String FIELD_DEDUCTIBLE_CUSTOMER_CODE = "Q_Reserve_Details_CT_RESERVE_GRID_CUSTOMER_CODE";
			public static final String FIELD_DEDUCTIBLE_TYPE = "Q_Reserve_Details_CT_RESERVE_GRID_deductibe_type";

			//mortgage fields
			public static final String FIELD_MORTGAGE_MODE_OF_PAYMENT = "Q_Reserve_Details_CT_RESERVE_GRID_Mode_of_Payment1";
			public static final String FIELD_MORTGAGE_PAYEE_CODE = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_TL_Payee_code";
			public static final String FIELD_MORTGAGE_PAYEE_NAME = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_TL_Payee_name";
			public static final String FIELD_MORTGAGE_PAYEE_BRANCH = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_TL_Payee_branch";
			public static final String FIELD_MORTGAGE_BENEFICIARY_NAME = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_TL_Beneficiary_name";
			public static final String FIELD_MORTGAGE_IBAN_NO = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_TL_IBAN_no";
			public static final String FIELD_MORTGAGE_BANK_NAME = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_TL_Bank_Name";
			public static final String FIELD_MORTGAGE_BANK_ACCOUNT_NO = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_TL_Bank_Account_No";
			public static final String FIELD_MORTGAGE_PAYEE_TYPE = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_TL_Payee_Type";
			public static final String FIELD_MORTGAGE_PAYMENT_TYPE = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_TL_Payment_type";
			public static final String FIELD_MORTGAGE_AMOUNT = "Q_Reserve_Details_CT_RESERVE_GRID_reserve_TL_Invoice_Amount";
			
			//Control names of elements on expense Modal
			public static final String GRID_EXPENSE_PROCESSING_DETAILS = "settle_expense_payee_table";
			public static final String FIELD_EXPENSE_TYPE = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_Type";
			public static final String FIELD_EXPENSE_CODE = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_Account_Details";
			public static final String FIELD_EXPENSE_CAUSE_OF_LOSS = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_Cause_of_Loss";
			public static final String FIELD_EXPENSE_COVER_CODE = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_CoverCode";
			public static final String FIELD_EXPENSE_OUTSTANDING_EXPENSE = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_Outstanding_Expense";
			public static final String FIELD_EXPENSE_PAYABLE_AMOUNT = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_Pyable_Amount";
			public static final String FIELD_EXPENSE_INVOICE_NUMBER = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_Invoice_Number";
			public static final String FIELD_EXPENSE_INVOICE_DATE = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_Invoice_Date";
			public static final String FIELD_EXPENSE_INVOICE_RECEIVED_DATE = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_Invoice_Rec_Date";
			public static final String FIELD_EXPENSE_MODE_OF_SETTLEMENT = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_Mode_of_Settlement";
			public static final String FIELD_EXPENSE_INVOICE_AMOUNT = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_Invoice_Amount";
			public static final String FIELD_EXPENSE_VAT_AMOUNT = "Q_EXPENSE_DETAILS_CT_EXPENSE_DETAILS_GRID_VAT_Amount";
			
		}

		public static class TotalLossSheet 
		{
			private TotalLossSheet() {
			}
			
			//TotalLoss			
			public static final String FIELD_NET_COMPENSATION_AMOUNT = "Q_Total_Loss_net_compensation";
			public static final String FIELD_LOT_NUMBER ="Q_Total_Loss_lot_number";
			public static final String FIELD_VEHICLE_RELEASE_LETTER_DATE ="Q_Total_Loss_release_letter_Date";
			public static final String FIELD_VEHICLE_TRIP_CONFIRMATION_DATE="Q_Total_Loss_trip_conformation_Date";
			public static final String FIELD_NEW_LOCATON ="Q_Total_Loss_new_location";
			
		}
		
		public static class SalvageSheet 
		{
			private SalvageSheet() {
			}
			
			//Salvage Details
			public static final String FIELD_COMPENSATION_AMOUNT = "Q_SALVAGE_DETAILS_Compnsation_amnt";
			public static final String FIELD_DAMAGE_TYPE = "Q_SALVAGE_DETAILS_damage_type";
			public static final String FIELD_EXPECTED_SALVAGE_AMOUNT = "Q_SALVAGE_DETAILS_expected_salvage_amount";
			public static final String FIELD_OLD_LOCATION = "Q_SALVAGE_DETAILS_old_location";
			public static final String FIELD_CONTACT_NUMBER_OF_GARAGE = "Q_SALVAGE_DETAILS_contact_no_garage";
			public static final String FIELD_NAME_OF_GARAGE_PERSON = "Q_SALVAGE_DETAILS_name_person_garage";
			public static final String FIELD_INSURED_VALUE = "Q_SALVAGE_DETAILS_insured_val";
			
			//Bid Details
			public static final String FIELD_LOT_NUMBER = "Q_SALVAGE_BID_DETAILS_Lot_Number";
			public static final String FIELD_VEHICLE_RELEASE_LETTER_DATE ="Q_SALVAGE_BID_DETAILS_Vehicle_Release_Letter_Date";
			public static final String FIELD_VEHICLE_TRIP_CONFIRMATION_DATE="Q_SALVAGE_BID_DETAILS_vehicle_trip_date";
			public static final String FIELD_NEW_LOCATON ="Q_SALVAGE_BID_DETAILS_new_location";
			
			//Copart details
			public static final String FIELD_COPART_PAYMENT_TYPE = "Q_SALVAGE_SETTLEMENT_payment_type_copart";
			public static final String FIELD_COPART_PAYEE_TYPE = "Q_SALVAGE_SETTLEMENT_payee_type_copart";
			public static final String FIELD_COPART_MODE_OF_PAYMENT = "Q_SALVAGE_SETTLEMENT_mode_of_payment_copart";
			
			//settlement section
			public static final String FIELD_COMMISION = "Q_SALVAGE_SETTLEMENT_Copart_Commission";
			public static final String FIELD_SALVAGE_REFERENCE_NO = "Q_SALVAGE_SETTLEMENT_reference";
			public static final String FIELD_COPART_VAT = "Q_SALVAGE_SETTLEMENT_Copart_Vat";
			public static final String FIELD_BUYER_CODE = "Q_SALVAGE_SETTLEMENT_buyer_code";
			public static final String FIELD_BUYER_NAME = "Q_SALVAGE_SETTLEMENT_Buyer_Name";
			public static final String FIELD_SALVAGE_AMOUNT = "Q_SALVAGE_SETTLEMENT_Salvage_Amount";
			public static final String FIELD_VAT_AMOUNT = "Q_SALVAGE_SETTLEMENT_VAT_Amount";
			public static final String FIELD_SALVAGE_REALISED = "Q_SALVAGE_SETTLEMENT_salvage_realised";
			public static final String FIELD_PAYMENT_TYPE = "Q_SALVAGE_SETTLEMENT_payment_type";
			public static final String FIELD_PAYEE_TYPE = "Q_SALVAGE_SETTLEMENT_payee_type";
			public static final String FIELD_PAYMENT_REFERENCE_NO = "Q_SALVAGE_SETTLEMENT_payment_reference_number";
			public static final String FIELD_PAYMENT_BUYER_BRANCH = "Q_SALVAGE_SETTLEMENT_buyer_branch";
			public static final String FIELD_MODE_OF_PAYMENT = "Q_SALVAGE_SETTLEMENT_mode_of_payment";
			public static final String FIELD_SELL_DATE = "Q_SALVAGE_SETTLEMENT_payment_date";
		}
		
		public static class RecoverySettlementSheet 
		{
			private RecoverySettlementSheet() {
			}
			
			// Third Party Recovery Details Section
			public static final String FIELD_INSURANCE_COMPANY_NAME = "Q_TPRecovDetail_Insurance_Company_Name";
			public static final String FIELD_COMPANY_CODE = "Q_TPRecovDetail_company_code";
			public static final String FIELD_BRANCH = "Q_TPRecovDetail_Branch";
			
			//Recovery Section
			public static final String FIELD_TPI_CLAIM_NO = "Q_Recovery_TPI_Claim_Number";
			
			//Recoverable settlement section
			public static final String FIELD_RECOVERABLE_SETTLEMENT_TPI_CREDIT_NOTE = "Q_Recoverable_Settlement_TPI_Credit_Note";
			public static final String FIELD_RECOVERABLE_SETTLEMENT_TPI_CREDIT_NOTE_AMOUNT = "Q_Recoverable_Settlement_TPI_Credit_Note_Amount";
			public static final String FIELD_RECOVERABLE_SETTLEMENT_TPI_CREDIT_NOTE_DATE = "Q_Recoverable_Settlement_TPI_Credit_Note_Date";
			public static final String FIELD_RECOVERABLE_SETTLEMENT_PAYEE_TYPE = "Q_Recoverable_Settlement_Payee_Type";
			public static final String FIELD_RECOVERABLE_SETTLEMENT_PAYMENT_TYPE = "Q_Recoverable_Settlement_Payment_Type";
			
			//Recoverable Total Loss settlement section
			public static final String FIELD_TOTAL_LOSS_RECOVERABLE_SETTLEMENT_TPI_CREDIT_NOTE = "Q_Recoverable_Total_Loss_Settlement_TPI_Credit_Note";
			public static final String FIELD_TOTAL_LOSS_RECOVERABLE_SETTLEMENT_TPI_CREDIT_NOTE_AMOUNT = "Q_Recoverable_Total_Loss_Settlement_TPI_Credit_Note_Amount";
			public static final String FIELD_TOTAL_LOSS_RECOVERABLE_SETTLEMENT_TPI_CREDIT_NOTE_DATE = "Q_Recoverable_Total_Loss_Settlement_TPI_Credit_Note_Date";
			public static final String FIELD_TOTAL_LOSS_RECOVERABLE_PAYEE_TYPE = "Q_Recoverable_Total_Loss_Settlement_Payee_Type";
			public static final String FIELD_TOTAL_LOSS_RECOVERABLE_PAYMENT_TYPE = "Q_Recoverable_Total_Loss_Settlement_Payment_Type";
		}
		
		public static class TPIInwardSettlementSheet
		{
			private TPIInwardSettlementSheet() {
			}
			//settlement to TPI section
			public static final String FIELD_SETTLEMENT_PAYEE_TYPE = "Q_Recovery_inward_Settlement_to_TPI_Payee_Type";
			public static final String FIELD_SETTLEMENT_PAYMENT_TYPE = "Q_Recovery_inward_Settlement_to_TPI_Payment_Type";
			public static final String FIELD_SETTLEMENT_NET_PAYABLE_AMOUNT = "Q_Recovery_inward_Settlement_to_TPI_Net_Payable_Amount";
			public static final String FIELD_SETTLEMENT_ADNIC_NOTE_NO = "Q_Recovery_inward_Settlement_to_TPI_ADNIC_Credit_Note_Number";
			public static final String FIELD_SETTLEMENT_ADNIC_CREDIT_NOTE_DATE = "Q_Recovery_inward_Settlement_to_TPI_ADNIC_Credit_Note_Date";
			public static final String FIELD_SETTLEMENT_ADNIC_CREDIT_NOTE_AMOUNT = "Q_Recovery_inward_Settlement_to_TPI_ADNIC_Credit_Note_Amount";
			public static final String FIELD_TPI_CLAIM_NO = "Q_TPI_DETAILS_Claim_No";
			
			//Total loss settlement to TPI section
			public static final String FIELD_TOTAL_LOSS_SETTLEMENT_PAYEE_TYPE = "Q_Recovery_Inward_Total_Loss_Settlement_To_TPI_Payee_Type";
			public static final String FIELD_TOTAL_LOSS_SETTLEMENT_PAYMENT_TYPE = "Q_Recovery_Inward_Total_Loss_Settlement_To_TPI_Payment_Type";
			public static final String FIELD_TOTAL_LOSS_SETTLEMENT_NET_PAYABLE_AMOUNT = "Q_Recovery_Inward_Total_Loss_Settlement_To_TPI_Net_Payable_Amount";
			public static final String FIELD_TOTAL_LOSS_SETTLEMENT_ADNIC_NOTE_NO = "Q_Recovery_Inward_Total_Loss_Settlement_To_TPI_ADNIC_Credit_Note_Number";
			public static final String FIELD_TOTAL_LOSS_SETTLEMENT_ADNIC_CREDIT_NOTE_DATE = "Q_Recovery_Inward_Total_Loss_Settlement_To_TPI_ADNIC_Credit_Note_Date";
			public static final String FIELD_TOTAL_LOSS_SETTLEMENT_ADNIC_CREDIT_NOTE_AMOUNT = "Q_Recovery_Inward_Total_Loss_Settlement_To_TPI_ADNIC_Credit_Note_Amount";
		}
	}
	
	public static class DocumentNames 
	{
		private DocumentNames() {
		}

		public static final String POLICY_SCHEDULE = "Policy Schedule";
		public static final String VEHICLE_CERTIFICATE = "Vehicle List Or Certificate";
		public static final String POLICE_REPORT = "Police Report";
		public static final String DRIVER_LICENSE = "DriverLicense";
		public static final String REGISTRATION_CARD = "Registration Card";
		public static final String AMBULANCE_INVOICE = "Ambulance Invoice";
		public static final String FULL_DOCUMENTS_FROM_TPI = "Full Documents from- TPI";
		public static final String POLICY_COPY = "Policy Copy";
		public static final String CLAIM_ACKNOWLEDGEMENT_LETTER = "Claim Acknowledgement Letter";
	};

	public static class ErrorMessages 
	{
		private ErrorMessages() {
		}

		public static final String DOCUMENT_ADD_ERR_MSG = "Error occurred while adding document to Work Item";
		public static final String SOCKET_ERR_MSG = "Error occurred while connecting to core system.";
	}

	public static class Event 
	{
		private Event() {
		}

		public static final String LOAD = "load";
		public static final String CLICK = "click";
		public static final String VALUE_CHANGE = "onchange";
	}

	public static class Procedures 
	{
		private Procedures() {
		}

		public static final String DOCUMENT_MANDATORY_CHECK = "NG_MC_Doc_Mand_Check";
		public static final String UPDATE_INVOICE = "NG_ADNIC_UPDATE_INVOICE";
	}
	
	public static class Tables
	{
		private Tables(){
		}

		public static final String EXTERNAL_TABLE = "NG_ADNIC_MC_EXT_TABLE";
		public static final String SETTLEMENT_DETAILS_TABLE = "NG_ADNIC_SETTLEMENT_DETAILS";
		public static final String KPG_GARAGE_DETAILS_TABLE = "NG_ADNIC_KPG_GARAGE";
		public static final String NON_KPG_GARAGE_DETAILS_TABLE = "NG_ADNIC_NON_KPG_GARAGE";
		public static final String AGENCY_DETAILS_TABLE = "NG_ADNIC_AGENCY_MASTER";
		public static final String RESERVE_DATA_DETAILS_TABLE = "NG_ADNIC_RESERVE_DATA_DETAILS";
		public static final String SALVAGE_REFERENCE_DETAILS_TABLE = "NG_ADNIC_SALVAGE_REF_DETAILS";
		public static final String FETCH_RESERVE_DETAILS_TABLE = "NG_ADNIC_FETCH_RESERVE_DETAILS";
	}
	
	public static class SettlementType
	{
		private SettlementType(){
		}

		public static final String LPO = "LPOSettlement";//credit note
		public static final String NON_TOTAL_LOSS_MISC = "NonTotalLossMiscSettlement";//credit note
		public static final String TOTAL_LOSS = "TotalLossSettlement";//credit note
		public static final String TOTAL_LOSS_EXPENSE = "TotalLossExpenseSettlement";//credit
		public static final String NON_TOTAL_LOSS_EXPENSE = "NonTotalLossExpenseSettlement";//credit
		public static final String MORTGAGE = "MortgageSettlement";
		public static final String NON_TOTAL_LOSS_DEDUCTABLE = "NonTotalLossDeductable";//deductible
		public static final String CLAIM_HANDLER_DEDUCTABLE = "ClaimHandlerDeductable";//deductible
		public static final String REVIEW_AND_ACTION_DEDUCTABLE = "ReviewAndActionDeductable";
		public static final String SALVAGE = "SalvageSettlement";
		public static final String COPART = "CopartSettlement";
		public static final String RECOVERY = "RecoverySettlement";
		public static final String RECOVERY_TOTAL_LOSS = "RecoveryTotalLossSettlement";
		public static final String TPI = "TPISettlement";
		public static final String TPI_TOTAL_LOSS = "TPITotalLossSettlement";
	}
	
	public static class AuthorityMAtrixApproval
	{
		private AuthorityMAtrixApproval()
		{
		}
		
		public static final String ClaimsHAndler_LPO = "LPO";
		public static final String ClaimsHAndler_TotalLoss = "Total Loss";
		public static final String ClaimsHAndler_CashLoss = "Cash Loss";
		public static final String ClaimsHAndler_TPIInward = "TPI_CH";
		public static final String SettlementNonTL = "SNTL";		
		public static final String SettlementTL = "STL";
		public static final String TPIInwardsSettlement = "TPI_Inwards";
		public static final String SalvageSettlement = "Salvage";
		public static final String ExgratiaNTL = "ExNTL";
		public static final String ExgratiaTL = "ExTL";
		
	}
	
	public static class FullClaimStatus
	{
		private FullClaimStatus(){
		}

		public static final String CLAIM_OUTSTANDING = "Claim Outstanding";
		public static final String CLAIM_SETTLED_FULLY = "Claim Settled Fully";
		public static final String CLAIM_SETTLED_PARTIALLY = "Claim Settled Partially";
		public static final String CLAIM_REJECTED = "Claim Rejected";
		public static final String CLAIM_CLOSED = "Claim Closed";
	}
}