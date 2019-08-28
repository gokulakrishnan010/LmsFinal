/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvscs.lms.login.model;

import com.tvscs.lms.util.StatusCodes;

/**
 *
 * @author Balasubramaniyan.M
 */
public class ActionResult {

	private String code;
	private String message;
	private int out;
	private String sid;
	private String loginTime;
	private Object data;

	public ActionResult() {
		this.code = StatusCodes.getInstance().COD_SR;
		this.message = StatusCodes.getInstance().MSG_OK;
	}

	public String getCode() {
		return code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.code = StatusCodes.getInstance().COD_EX;
		this.message = StatusCodes.getInstance().MSG_UNABLE;
	}

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
}
