package com.tvscs.lms.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvscs.lms.error.InvalidAccessKeyException;
import com.tvscs.lms.model.Employee;
import com.tvscs.lms.service.IEmployeeService;
import com.tvscs.lms.util.DataValidator;
import com.tvscs.lms.util.StatusCodes;

/**
 * @author 5030618
 *
 */

@RestController
@RequestMapping("/performance")
public class EmployeePerformanceController {
	private Logger logger = LoggerFactory.getLogger(EmployeePerformanceController.class);

	@Autowired
	public IEmployeeService service;

	/**
	 * To get the Employee Performance data based on the empId
	 */
	@GetMapping("/get/{empId}/{noOfMonths}/{accessKey}")
	public ResponseEntity<?> getEmployeePerformanceById(@PathVariable Integer empId, 
			@PathVariable Integer noOfMonths, @PathVariable String accessKey) {
		ResponseEntity<?> resEntity = null;
		Employee employee = null;
		if(DataValidator.authenticateRequest(accessKey)) {
			logger.info("User is entering /get end point.");
			employee = service.getPerformanceById(empId, noOfMonths);
			resEntity = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}else {
			logger.error("Error in getEmployeePerformanceById()",
					StatusCodes.INVALID_ACCESS_KEY,HttpStatus.UNAUTHORIZED);
			throw new InvalidAccessKeyException(StatusCodes.INVALID_ACCESS_KEY);
		}
		return resEntity;
	}
	/**
	 * To fetch Performance data of employees under a manager
	 *
	 */
	@GetMapping("/head/{managerId}/{noOfMonths}/{accessKey}")
	public ResponseEntity<?> getEmpPerformanceByManagerId(@PathVariable Integer managerId, 
			@PathVariable Integer noOfMonths, @PathVariable String accessKey){
		ResponseEntity<?> resEntity = null;
		List<Employee>  employees = null;
		if(DataValidator.authenticateRequest(accessKey)) {
			logger.info("User is entering /head end point.");
			employees = service.getEmpPerformanceByManagerId(managerId, noOfMonths);
			resEntity = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		}else {
			logger.error("Error in getEmpPerformanceByManagerId()",
					StatusCodes.INVALID_ACCESS_KEY,HttpStatus.UNAUTHORIZED);
			throw new InvalidAccessKeyException(StatusCodes.INVALID_ACCESS_KEY);
		}
		return resEntity;
	}

	/**
	 * To fetch Employees Performance data of employees in a region
	 *
	 */
	@GetMapping("/bulk/{region}/{noOfMonths}/{accessKey}")
	public ResponseEntity<?> getEmpPerformanceByRegion(@PathVariable String region, 
			@PathVariable Integer noOfMonths, @PathVariable String accessKey){
		ResponseEntity<?> resEntity = null;
		List<Employee> employees = null;
		if(DataValidator.authenticateRequest(accessKey) && 
				DataValidator.validateRegion(region)) {
			logger.info("User is entering /bulk end point.");
			employees = service.getEmpPerformanceByRegion(region, noOfMonths);
			resEntity = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		}else {
			logger.error("Error in getEmpPerformanceByRegion()"
					,StatusCodes.INVALID_ACCESS_KEY,HttpStatus.UNAUTHORIZED);
			throw new InvalidAccessKeyException(StatusCodes.INVALID_ACCESS_KEY);
		}
		return resEntity;
	}

	/**
	 * To fetch Employees Performance data of employees with employee id list
	 *
	 */

	@GetMapping("/group/{empIds}/{noOfMonths}/{accessKey}")
	public ResponseEntity<?> getEmployeesPerformanceById(@PathVariable Integer[] empIds,
			@PathVariable Integer noOfMonths, @PathVariable String accessKey){
		ResponseEntity<?> resEntity = null;
		List<Employee> employees = null;
		if(DataValidator.authenticateRequest(accessKey)) {
			logger.info("User is entering /group end point in performance module");
			employees = service.getEmployeesPerformanceById(Arrays.asList(empIds), noOfMonths);
			resEntity = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		}else {
			logger.error("Error in getEmployeesPerformanceById()",
					StatusCodes.INVALID_ACCESS_KEY,HttpStatus.UNAUTHORIZED);
			throw new InvalidAccessKeyException(StatusCodes.INVALID_ACCESS_KEY);
		}
		return resEntity;
	}

	/**
	 * To fetch Employees Performance data of all the employees in a department
	 *
	 */
	@GetMapping("division/{department}/{noOfMonths}/{accessKey}")
	public ResponseEntity<?> getEmpPerformanceByDepartment(@PathVariable String department,@PathVariable Integer noOfMonths,
			@PathVariable String accessKey){
		ResponseEntity<?> resEntity = null;
		List<Employee> employees = null;
		if(DataValidator.authenticateRequest(accessKey) && 
				DataValidator.validateDepartment(department)) {
			logger.info("User is entering /all end point in performance module");
			employees = service.getEmpPerformanceByDepartment(department, noOfMonths);
			resEntity = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		}else {
			logger.error("Error in getEmpPerformanceByDepartment()"
					,StatusCodes.INVALID_ACCESS_KEY,HttpStatus.UNAUTHORIZED);
			throw new InvalidAccessKeyException(StatusCodes.INVALID_ACCESS_KEY);
		}
		return resEntity;
	}
	
	@GetMapping("month/{empId}/{monthName}/{year}/{accessKey}")
	public ResponseEntity<?> getEmpMonthPerformance(@PathVariable Integer empId,@PathVariable String  monthName, 
			@PathVariable Integer year,
			@PathVariable String accessKey){
		ResponseEntity<?> resEntity = null;
		Employee employee = null;
		if (DataValidator.authenticateRequest(accessKey) &&
				DataValidator.validateMonthName(monthName, year)) {
			employee = service.getMonthPerformance(empId, monthName, year);
			resEntity = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			logger.error("Error in getEmpMonthPerformance()"
					,StatusCodes.INVALID_ACCESS_KEY,HttpStatus.UNAUTHORIZED);
			throw new InvalidAccessKeyException(StatusCodes.INVALID_ACCESS_KEY);
		}
		return resEntity;
	}
}
