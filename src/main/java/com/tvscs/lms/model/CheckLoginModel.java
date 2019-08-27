package com.tvscs.lms.model;

import com.signon.model.LoginRequest;

public class CheckLoginModel extends LoginRequest {
	private String password;
	private String appName;
	private String ipaddress;
	private String userName;


	public CheckLoginModel(String password, String applicationName, String ipaddress, String userName) {
		super(password, applicationName, ipaddress, userName);
		this.password = password;
		this.appName = applicationName;
		this.ipaddress = ipaddress;
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApplicationName() {
		return appName;
	}

	public void setApplicationName(String applicationName) {
		this.appName = applicationName;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
			this.ipaddress = ipaddress;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
	@Override
	public String toString() {
		return "CheckLoginModel [password=" + password + ", applicationName=" + appName + ", ipaddress="
				+ ipaddress + ", userName=" + userName + "]";
	}
}
