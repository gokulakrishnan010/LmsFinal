package com.tvscs.lms.error;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -209876989089190208L;
    
	public EmployeeNotFoundException(String empId) {
		super("Employee Id: "+empId+" Not Found");
	}
	
	public EmployeeNotFoundException(String managerId, int noOfEmpoyess) {
		super(" Incorrect Manager Id :"+managerId+
			  " / No Employees Reporting to this Manager");
	}
	
	public EmployeeNotFoundException(List<String> empIdList) {
		super(" No Employees Found with below Ids "+empIdList);
	}
	
	public EmployeeNotFoundException(LocalDate joiningDate) {
		super(" No Employees Found who Joined on this Date :"+joiningDate);
	}
	
	public EmployeeNotFoundException() {
		super(" No employees found for request data ");
	}
	
	public EmployeeNotFoundException(String monthName, Integer year) {
		super(" Performance for "+monthName+" "+year+" Not Found");
	}
}
