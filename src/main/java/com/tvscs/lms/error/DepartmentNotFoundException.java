package com.tvscs.lms.error;

public class DepartmentNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3033934321966945382L;
	
	public DepartmentNotFoundException(String department) {
		super("Requested Department "+department+" Not Found");
	}
   
}
