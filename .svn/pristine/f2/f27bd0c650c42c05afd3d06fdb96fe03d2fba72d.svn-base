package com.tvscs.lms.service.impl;

import com.signon.model.LoginRequest;
import com.signon.model.LoginResponse;
import com.signon.model.ServiceRequest;
import com.signon.model.ServiceResponse;
import com.tvscs.lms.model.ActionResult;
import com.tvscs.lms.model.LmsLoginResponse;
import com.tvscs.lms.model.LoginResult;
import com.tvscs.lms.service.SignOnServiceInterface;
import com.tvscs.lms.util.StatusCodes;
import com.tvscs.service.utill.EmployeeDetailsResponse;
import com.tvscs.service.utill.ServiceKeyCodes;
import com.tvscs.service.utill.SignOnCodes;
import com.tvscs.service.utill.SignOnService;
import com.tvscs.service.utill.SigonServiceInterface;


public class SignOnServiceImpl implements SignOnServiceInterface {
    
	StatusCodes statusCodes = StatusCodes.getInstance();
	SigonServiceInterface serviceInterface = new SignOnService(); ;
	ServiceKeyCodes keycodes = ServiceKeyCodes.getInstance();

	/**
	 *
	 */
	@Override
	public LmsLoginResponse checkLogin(LoginRequest request) {

		LmsLoginResponse result = new LmsLoginResponse();
		LoginResponse response = serviceInterface.checkSignOnLogin(request);
		SignOnCodes signOnCodes = SignOnCodes.getInstance();
		if (response.getResult().equalsIgnoreCase(signOnCodes.SIG_SUUCCRES)
				&& (response.getErrorCode().equalsIgnoreCase(signOnCodes.STATUS_PASSWILLEXPIRE)
						|| response.getErrorCode().equalsIgnoreCase(signOnCodes.STATUS_LOGINSUCCESS))) {
			result.setCode(statusCodes.COD_SR);
			result.setMessage(statusCodes.MSG_OK);

			if (response.getErrorCode().equalsIgnoreCase(signOnCodes.STATUS_PASSWILLEXPIRE)) {
				result.setMessage(response.getMessage());
				result.setPasswordExpired(true);
			} else {
				result.setPasswordExpired(false);
			}
		} else {
			result.setCode(statusCodes.COD_ER);
			result.setMessage(response.getError());
		}
		return result;
	}

	/**
	 *
	 */
	@Override
	public LoginResult checkLoginExternal(LoginRequest request) {
		LoginResult result = new LoginResult();
		LoginResponse response = serviceInterface.checkSignOnLoginExt(request);
	
		if (response.getResult().equalsIgnoreCase(statusCodes.ZERO)) {
			// Success
			result.setCode(statusCodes.COD_SR);
			result.setMessage(statusCodes.MSG_OK);

			if (response.getErrorCode().equalsIgnoreCase(statusCodes.PS)) {
				result.setMessage(response.getMessage());
				result.setIsPasswordExppired(true);
			} else {
				result.setIsPasswordExppired(false);
			}
		} else {
			// Failure
			result.setCode(statusCodes.COD_ER);
			result.setMessage(response.getMessage());
		}
		return result;
	}

	/**
	 *
	 */
	@Override
	public LoginResult checkLoginLosExternal(LoginRequest request) {
		LoginResult result = new LoginResult();
		LoginResponse response = serviceInterface.checkSignOnLoginExt(request);
		
		if (response.getResult().equalsIgnoreCase(statusCodes.ZERO)) {
			// Success
			result.setCode(statusCodes.COD_SR);
			result.setMessage(statusCodes.MSG_OK);

			if (response.getErrorCode().equalsIgnoreCase(statusCodes.PS)) {
				result.setMessage(response.getMessage());
				result.setIsPasswordExppired(true);
			} else {
				result.setIsPasswordExppired(false);
			}
		} else {
			// Failure
			result.setCode(statusCodes.COD_ER);
			result.setMessage(response.getMessage());
		}
		return result;
	}

	/**
	 *
	 */
	@Override
	public ActionResult forgotPassword(ServiceRequest request) {
		ActionResult result = new ActionResult();
		ServiceResponse response = serviceInterface.getPassword(request);
		if (response.getResponseCode().equalsIgnoreCase(statusCodes.COD_SR)) {
			result.setCode(statusCodes.COD_SR);
			result.setMessage(response.getResponseMessage());
		} else {
			result.setCode(statusCodes.COD_ER);
			result.setMessage(response.getResponseMessage());
		}
		return result;
	}

	/**
	 *
	 */
	@Override
	public EmployeeDetailsResponse getEmployeeDetails(ServiceRequest request) {
		return serviceInterface.getEmployeeDetails(request);
	}
   
	/**
	 * @return
	 */
	public static boolean authorizeAccess() {
		boolean authenticated = false;
		return authenticated;
	}

}
