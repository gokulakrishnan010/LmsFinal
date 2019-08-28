package com.tvscs.lms.login.model;

public class LmsLoginResponse {

	private String code;
	private String message;
	private boolean isPasswordExpired;
	private String userType;
	/**
	 * 
	 */
	public LmsLoginResponse() {
		super();
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return the isPasswordExpired
	 */
	public boolean isPasswordExpired() {
		return isPasswordExpired;
	}
	/**
	 * @param isPasswordExpired the isPasswordExpired to set
	 */
	public void setPasswordExpired(boolean isPasswordExpired) {
		this.isPasswordExpired = isPasswordExpired;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
