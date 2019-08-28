package com.tvscs.lms.login.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signon.model.LoginRequest;
import com.tvscs.lms.login.model.CheckLoginModel;
import com.tvscs.lms.login.model.LmsLoginResponse;
import com.tvscs.lms.login.serviceImpl.SignOnServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	SignOnServiceImpl signOn = new SignOnServiceImpl();

	@PostMapping(path = "/access")
	@ResponseBody
	public String  authenticateUser(@RequestBody CheckLoginModel checkLogin){   
		LmsLoginResponse loginResult = null;
		try {
			logger.info("User accessing /access endpoint.");
			loginResult = signOn.checkLogin(new LoginRequest(checkLogin.getPassword(), checkLogin.getApplicationName(), 
					checkLogin.getIpaddress(),checkLogin.getUserName()));
		} catch (Exception e) {
            logger.error("Error in getLoginDetails()",e);
		}
		return new JSONObject(loginResult).toString();
	}

}
