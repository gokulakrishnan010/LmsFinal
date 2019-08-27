package com.tvscs.lms.error;

import com.tvscs.lms.util.StatusCodes;

public class ServiceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6097633346536781401L;
	public ServiceNotFoundException(){
		super(StatusCodes.getInstance().MSG_UNABLE);
	}
}
