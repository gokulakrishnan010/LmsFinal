package com.tvscs.lms;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.tvscs.service.utill.ServiceKeyCodes;
@SpringBootApplication(scanBasePackages={"com.tvscs.lms.*"})
public class LmsAutomationApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(LmsAutomationApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LmsAutomationApplication.class);
	}
	
	@PostConstruct
	private void init() {
		ServiceKeyCodes keyCodes = ServiceKeyCodes.getInstance();
		keyCodes.SERVICEURL = "http://intranetuserloginuat.tvscredit.com/Service.asmx";
	}
	
}
