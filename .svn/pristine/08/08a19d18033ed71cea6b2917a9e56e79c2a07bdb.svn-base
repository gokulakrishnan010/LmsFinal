package com.tvscs.lms.util;

import java.time.Month;
import java.util.stream.IntStream;

import com.tvscs.lms.error.EmployeeNotFoundException;

/**
 * @author 5030618
 *
 */
public class DataValidator {


	public static boolean authenticateRequest(String accessKey) {
		//boolean authenticated = false;
		//		if(accessKey.equals(StatusCodes.ACCESS_KEY))
		//		{
		//			authenticated = true;
		//		}
		return true;
	}
    
	/**
	 * To validate inputs for performance module
	 * @param empId
	 * @param noOfMonths
	 * @return
	 */
	public static boolean validateInputs(String empId, Integer noOfMonths) {
		boolean isInputDataValid = false;
		if(validateEmpId(empId) && validateNoOfMonths(noOfMonths)) {
			isInputDataValid = true;
		}else {
			return isInputDataValid;
		}
		return  isInputDataValid ;
	}

	/**
	 * @param empId
	 * @return
	 */
	public static boolean  validateEmpId(String empId) {
		boolean isEmpIdValid = false;
		if (empId != null ) {
			empId.trim().chars().allMatch(Character::isDigit);
			isEmpIdValid = true;
		} else {
			return isEmpIdValid;
		}
		return isEmpIdValid;
	}

	/**
	 * To validate region from Regions Enum
	 * @param region
	 * @return
	 */
	public static boolean validateRegion(String region) {
		boolean isRegionValid = false;
		for (Regions reg : Regions.values()) {
			if (reg.toString().equals(region)) {
				isRegionValid = true;
			}
		}
		return isRegionValid;
	}

	/**
	 * @param empIds
	 * @param noOfMonths
	 * @return
	 */
	public static boolean validateEmpIds(String[] empIds,Integer noOfMonths) {
		boolean isEmpIdStringValid = true;
		if (empIds != null && empIds.length != 0) {
			for (String empId : empIds) {
				if (!validateEmpId(empId)) {
					return isEmpIdStringValid;
				}
			}
		} 
		return isEmpIdStringValid;

	}

	/**
	 * @param department
	 * @return
	 */
	public static boolean validateDepartment(String department) {
		boolean isDepartmentValid = false;
		for (Departments dept : Departments.values()) {
			if (dept.toString().equals(department)) {
				isDepartmentValid = true;
			}
		}
		return isDepartmentValid;

	}

	/**
	 * @param noOfMonths
	 * @return
	 */
	public static boolean validateNoOfMonths(Integer noOfMonths) {
		boolean isNoOfMonths = false;
		if (noOfMonths != null && IntStream.rangeClosed(1, 12).
				anyMatch(monthNumber-> monthNumber == noOfMonths)) {
			isNoOfMonths = true;
		}
		return isNoOfMonths ;
	}
	
	public static boolean validateMonthName(String monthName, Integer year) {
		boolean isMonthNameValid = false;
		try {
			if (IntStream.range(1, 12).anyMatch(monthNumber -> 
				monthNumber == Month.valueOf(monthName).getValue())) {
				isMonthNameValid =  true;
			}
		} catch (Exception e) {
			throw new EmployeeNotFoundException(monthName, year);
		}
		return isMonthNameValid;
	}
}
