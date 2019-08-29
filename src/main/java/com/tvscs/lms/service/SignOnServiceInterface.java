package com.tvscs.lms.service;

import com.signon.model.LoginRequest;
import com.signon.model.ServiceRequest;
import com.tvscs.lms.model.ActionResult;
import com.tvscs.lms.model.LmsLoginResponse;
import com.tvscs.lms.model.LoginResult;
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
