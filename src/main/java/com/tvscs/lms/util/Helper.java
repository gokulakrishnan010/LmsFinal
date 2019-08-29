package com.tvscs.lms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tvscs.lms.error.InvalidRequestException;
import com.tvscs.lms.error.ResourceNotFoundException;

public class Helper {
    
	 static String validateMessage ="";
	
	public static void employeeIdValidate(String strEmpId) throws InvalidRequestException, ResourceNotFoundException {
		
		boolean isValid=isValidId(strEmpId);
		
		if(isValid) {
			throw new InvalidRequestException(validateMessage);
		}
		else {
			throw new ResourceNotFoundException("No data Found");
		}
		
				
	}
	
	public static boolean isValidId(String strEmpId) {
		
		boolean splCharFlg = false;
		
		boolean nullFlg = false;
		
		boolean lengthFlg = false;
		
		boolean isValid = false;
		
		splCharFlg=checkSpecialCharacter(strEmpId);
		
		lengthFlg=checkMaxlength(strEmpId);
		
		nullFlg=checkNull(strEmpId);
		
		if(splCharFlg || nullFlg || lengthFlg) {
			
			isValid = true;
		}
		
		return isValid;
		
	}
	
    public static boolean checkSpecialCharacter(String strValidate) {
    	
    	String strMessage ="";
    	
    	boolean splCharFlg=false;
		
    	Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
    	 
        Matcher matcher = pattern.matcher(strValidate);
   
        if (!matcher.matches()) {
        	
        	strMessage="The requested parameter "+strValidate+" has special characters and charecters,only numbers are allowed";
        	
        	validateMessage+=","+strMessage;
        	
        	splCharFlg=true;
        	
        } 
		
        return splCharFlg;
	}
    
    public static boolean checkMaxlength(String strValidate) {
		
    	String strMessage ="";
    	
    	boolean lengthFlg=false;
    	
    	if(strValidate.length()!=7) {
    		
    		strMessage="The requested parameter "+strValidate+" must have only maximum size of 7";
        	
        	validateMessage+=","+strMessage;
        	
        	lengthFlg=true;
    	}
		
		return lengthFlg;
		
	}
    
   
    
    public static boolean checkNull(String strValidate) {
		
    	String strMessage=correctNull(strValidate);
    	
    	boolean nullFlg=false;
    	
    	if(strMessage.equalsIgnoreCase("")) {
    		
    		strMessage="The requested parameter must not be null or empty";
    		
    		validateMessage+=","+strMessage;
    		
    		nullFlg=true;
    	}
		
		return nullFlg;
		
	}
    
    public static String correctNull(String strValidate) {
    	
  		
  		if(strValidate.equals(null) || strValidate.equals("") || strValidate.equals(" ")) {
  			strValidate ="";
  		}
  		
  		return strValidate;
  		
  	}
    
    
    public static boolean checkDateFormat(String strValidate) {
		
  		String strMessage ="";
  		
  		boolean dateFlg=false;
  		
  		String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
  		 
  		Pattern pattern = Pattern.compile(regex);
  		
  		Matcher matcher = pattern.matcher(strValidate);
  		
  		if(!matcher.matches()) {
  			
  			strMessage="The requested date must be in the format of dd/mm/yyyy";
  			
  			validateMessage+=","+strMessage;
  			
  			dateFlg=true;
  		}
  		  		
  		return dateFlg;
  		
  	}
    
    
	
	
}
