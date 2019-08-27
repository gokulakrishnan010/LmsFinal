/*
 * To change this license header;   public final String  choose License Headers in Project Properties.
 * To change this template file;   public final String  choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvscs.lms.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 5030618
 */
public class StatusCodes {
	private static final StatusCodes statusCodes = new StatusCodes();

	public static StatusCodes getInstance() {
		return statusCodes;
	}

	private StatusCodes() {
	}

	public static String getLoginTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	public  final String ZERO = "0";
	public  final String PS = "PS";
	public  final String PORT_CA = "CA";
	public  final String COD_SR = "SR";
	public  final String COD_ER = "ER";
	public  final String COD_EX = "EX";
	public  final String FILE_FI = "FI_";
	public  final String PURPOSE_REPORT = "REPORT";
	public  final String PURPOSE_TRANSACTION = "TRANSACTION";
	public  final String SIG_SUUCCRES = "0";
	public  final String SIG_ERRRES = "1";
	public  final String MSG_REQUESTERROR = "Invalid Request Data";
	public  final String MSG_ACCESSDENIEDERROR = "Invalid Request Data/Access Denied";
	public  final String MSG_NOIMAGE = "No Images Attached";
	public  final String MSG_UNAUTHERROR = "Un Authorized Access.";
	public  final String MSG_NODATAFOUND = "No Data Found";
	public  final String MSG_INVALIDOREMPLOYEE = "Invalid Employee ID/ Employee Id De Activated";
	public  final String MSG_NOACTION = "No Action Found.";
	public final String MSG_OK = "Ok";
	public final String MSG_UNABLE = "Unable to process your request now. Please try again later.";
	public  final String MSG_NOTEXITINCCE = "Invalid User ID/ Not Exists";
	public  final String CONS_PD = "PD";
	public  final String CONS_SANC = "SA";
	public  final String MSG_INVALIDORUSERDEACTIVATE = "User id is invalid/ user de-activated In Portal.";
	public  final String ACTION_INSERT = "I";
	public  final String ACTION_REINTI = "R";
	public  final String ACTION_UPDATE = "U";
	public  final String ACTION_RANGELEADS = "R";
	public  final String ACTION_RECENTLEADS = "R";
	public final String ACTION_VIEWLEADS = "L";
	public  final String ACTION_LOGINRECIEDLEADS = "LR";
	public  final String ACTION_SUBMIT = "C";
	public  final String ACTION_SAVE = "D";
	public  final int REG_FROMW = 0;
	public  final int REG_FROMM = 1;
	public  final String STATUS_NEW = "N";
	public  final String STATUS_COMPLETED = "C";
	public  final String STATUS_INPRGRESS = "I";
	public  final String NOSUITABLESCHEME = "no_suitable_scheme_details_found";
	public  final String SCHEMESNOTFOUND = "schemes_not_found";
	public  final String MSG_NODATA = "No data.";

	public  final String REQUESTERROR = "Invalid Request Data";
	public  final String ACCESSDENIEDERROR = "Invalid Request Data/Access Denied";
	public  final String UNAUTHERROR = "Un Authorized Access.";
	public  final String SESSIONERROR = "No session";
	public  final String SESSIONMISMATCHERROR = "User id mismatch";

	public final String MEDIUM_M = "M";
	public final String MEDIUM_W = "W";
	public final String CASETYPE_FRESH = "F";
	public final String CASETYPE_REUPLOAD = "R";

	public final String MSG_FISUBMITMESSAGE = "FI Saved Successfully";

	//SQL queries
	public static final String FETCH_RATING_BY_ID = " SELECT SCE_CODE, SCE_NAME, TM_CODE, TM_NAME, DESIGNATION, PL_AREA, "
			+ " REGION, ALLOCATION_AMT, COLLECTION, RATING, TARGET_DATE "
			+ " FROM  TABUSER.tbl_trn_emp_prod WHERE SCE_CODE = :emp_no " + 
			" AND TARGET_DATE > TO_DATE(:targetDate,'yyyy/mm/dd')  ORDER BY TARGET_DATE DESC ";

	public static final String FETCH_EMPS_PERF_BY_MNG_ID = " SELECT SCE_CODE, SCE_NAME, TM_CODE, TM_NAME, DESIGNATION, "
			+ " PL_AREA, REGION, ALLOCATION_AMT, COLLECTION, RATING, TARGET_DATE FROM  TABUSER.tbl_trn_emp_prod "+
			" WHERE SCE_CODE IN (SELECT DISTINCT SCE_CODE FROM TABUSER.tbl_trn_emp_prod "+
			" WHERE TM_CODE = :managerId) AND SCE_CODE NOT IN ('TVSCS') AND TARGET_DATE > TO_DATE(:targetDate,'yyyy/mm/dd') ORDER BY SCE_CODE ";

	public static final String FETCH_EMPS_PERF_BY_REGION =  " SELECT SCE_CODE, SCE_NAME, TM_CODE, TM_NAME, DESIGNATION, PL_AREA, REGION,"+
			" ALLOCATION_AMT, COLLECTION, RATING, TARGET_DATE FROM  TABUSER.tbl_trn_emp_prod"+
			" WHERE SCE_CODE IN(SELECT DISTINCT SCE_CODE FROM TABUSER.tbl_trn_emp_prod "+
			" WHERE REGION = :region) AND SCE_CODE NOT IN ('TVSCS') AND TARGET_DATE > TO_DATE(:targetDate,'yyyy/mm/dd') ORDER BY SCE_CODE";


	public static final String GET_EMPS_PERF_BY_ID = " SELECT SCE_CODE,SCE_NAME, TM_CODE, TM_NAME, DESIGNATION, PL_AREA, " 
			+ " REGION, ALLOCATION_AMT, COLLECTION, RATING, TARGET_DATE FROM " 
			+ " TABUSER.tbl_trn_emp_prod WHERE SCE_CODE IN(:empIds) "  
			+ " AND TARGET_DATE > TO_DATE(:targetDate,'yyyy/mm/dd') ORDER BY SCE_CODE ";

	public static final String GET_ONE_MONTH_PERF = " SELECT SCE_CODE,SCE_NAME, TM_CODE, TM_NAME, DESIGNATION, PL_AREA, " 
			+ " REGION, ALLOCATION_AMT, COLLECTION, RATING, TARGET_DATE FROM " 
			+ " TABUSER.tbl_trn_emp_prod WHERE SCE_CODE = :empId AND TARGET_DATE = TO_DATE(:targetDate,'yyyy/mm/dd')";

	public static final String INVALID_ACCESS_KEY = "AccessKey / InpuData Not valid";
	public static final String ACCESS_KEY = "";
	public static final String UNABLE_TO_PROCESS = "Ok";
	public static final String EMPLOYEE_ID = "emp_no";
	public static final String TARGET_DATE = "targetDate";
	public static final String MANAGER_ID = "managerId";
	public static final String EMPLOYEE_IDS = "empIds";
	public static final String REGION = "region";
	public static final String INVALID_REQUEST_DATA="IRD";
	public static final String NO_DATA_FOUND = "LMS_ER_007";
	public static final String SERV_UNAVAILABLE="LMS_ER_503";
	public static final String EMP_NOT_FOUND = "LMS_ER_404";
	public static final String NO_DATA_AVAILABLE=" No employees found for request data ";
}
