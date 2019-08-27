/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvscs.lms.model;

/**
 *
 * @author Balasubramaniyan.M
 */
public class LoginResult extends ActionResult {

	private boolean isPasswordExpired;
	private String userType;

	public boolean isIsPasswordExppired() {
		return isPasswordExpired;
	}

	public void setIsPasswordExppired(boolean isPasswordExppired) {
		this.isPasswordExpired = isPasswordExppired;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
