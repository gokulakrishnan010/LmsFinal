package com.tvscs.lms.login.service;

import com.signon.model.LoginRequest;
import com.signon.model.ServiceRequest;
import com.tvscs.lms.login.model.ActionResult;
import com.tvscs.lms.login.model.LmsLoginResponse;
import com.tvscs.lms.login.model.LoginResult;
import com.tvscs.service.utill.EmployeeDetailsResponse;

public interface SignOnServiceInterface {
	/**
	 * @param request
	 * @return
	 */
	public LmsLoginResponse checkLogin(LoginRequest request);
	/**
	 * @param request
	 * @return
	 */
	public ActionResult forgotPassword(ServiceRequest request);
	/**
	 * @param request
	 * @return
	 */
	public EmployeeDetailsResponse getEmployeeDetails(ServiceRequest request);
	/**
	 * @param request
	 * @return
	 */
	public LoginResult checkLoginExternal(LoginRequest request);
	/**
	 * @param request
	 * @return
	 */
	public LoginResult checkLoginLosExternal(LoginRequest request);
}
