package com.tvscs.lms.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvscs.lms.error.InvalidRequestException;
import com.tvscs.lms.error.ResourceNotFoundException;
import com.tvscs.lms.model.UserModel;
import com.tvscs.lms.service.UserService;
import com.tvscs.lms.util.Helper;

@RestController

@RequestMapping("/employee")
public class UserController {
	
	
	@Autowired
	public UserService objUserService;
	
	/***Mandatory Employee API***/

    //Returns all employee details	
	
	@GetMapping("/all")
	
	private ResponseEntity<List<UserModel>> getEmployeeDetails() {	 
		  
		return new ResponseEntity<List<UserModel>>(objUserService.viewAll(),HttpStatus.OK);
		
	}
	
   //Returns all employee details other than new joinee
	
   @GetMapping("/existing")
	
	   
   public ResponseEntity<Page<UserModel>>  getExistingEmployees(@RequestParam Optional<Integer> page,
			@RequestParam Optional<Integer> limit,@RequestParam Optional<String> sortBy) 
	{
	    
	   return new ResponseEntity<Page<UserModel>>(objUserService.findExistingEmployees(page,limit,sortBy),HttpStatus.OK);
		
	}
	
	//Returns employee details of employee based on list of employee id
	
     @GetMapping("/Id")
	
	private ResponseEntity<List<UserModel>> getEmployeeDetailsList(@RequestParam List<String> Id) {	 
    	 
    	 
    	 
		  
		return new ResponseEntity<List<UserModel>>(objUserService.findByListId(Id),HttpStatus.OK);
		
	}
	
	//Returns employee details of employee based on employee id
		
	@GetMapping("/Id/{Id}")
	
	public ResponseEntity<Optional<UserModel>> getEmployeeDetailsById(@PathVariable String Id) throws InvalidRequestException, ResourceNotFoundException {
		
		Helper.employeeIdValidate(Id);
		
		return new ResponseEntity<Optional<UserModel>>(objUserService.findById(Id),HttpStatus.OK);

	}
	
	
	//Returns employee details of employee based on today's date
	
	@GetMapping("/newjoineelist")
	
	public  ResponseEntity<Page<UserModel>> getNewJoinee(@RequestParam Optional<Integer> page,
			@RequestParam Optional<Integer> limit,@RequestParam Optional<String> sortBy) 
	{
	
		 return new  ResponseEntity<Page<UserModel>>(objUserService.findByempJoiningDate(page,limit,sortBy),HttpStatus.OK);

	}
	
	//Returns employee details of employee based on joining date
	
	@GetMapping("/doj/{joiningDate}")
	
	public ResponseEntity<Page<UserModel>> getEmpDetailsByJoinDate(@PathVariable Date joiningDate,@RequestParam Optional<Integer> page,
			@RequestParam Optional<Integer> limit,@RequestParam Optional<String> sortBy) 
	{
	
		 return new ResponseEntity<Page<UserModel>>(objUserService.findByempJoiningDate(joiningDate,page,limit,sortBy),HttpStatus.OK);

	}
	
	
	/***Mandatory Employee API end***/
	
	
	
	/***Optional Employee API***/

	
	//Returns employee details of employee based on location
	
	@GetMapping("/location/{location}")
	
	public ResponseEntity<Page<UserModel>> getEmpDetailsByLocation(@PathVariable String location,@RequestParam Optional<Integer> page,
		@RequestParam Optional<Integer> limit,@RequestParam Optional<String> sortBy) 
	{	
		 
		 return new ResponseEntity<Page<UserModel>>(objUserService.findByempLocation(location,page,limit,sortBy),HttpStatus.OK);

	}
		
	//Returns employee details of employee based on region
	
     @GetMapping("/region/{region}")
	
	public ResponseEntity<Page<UserModel>> getEmpDetailsByRegion(@PathVariable String region,@RequestParam Optional<Integer> page,
		@RequestParam Optional<Integer> limit,@RequestParam Optional<String> sortBy) 
	{	
		 
		 return new ResponseEntity<Page<UserModel>>(objUserService.findByempRegion(region,page,limit,sortBy),HttpStatus.OK);

	}
		
	//Returns employee details of employee based on supervisor employee id
		
	@GetMapping("/appraiserid/{id}")
	
	public ResponseEntity<Page<UserModel>> getEmpDetailsByReportManagerId(@PathVariable Long reportManagerId,@RequestParam Optional<Integer> page,
		@RequestParam Optional<Integer> limit,@RequestParam Optional<String> sortBy) 
	{		
		 return new ResponseEntity<Page<UserModel>>(objUserService.findByEmpReportManagerId(reportManagerId,page,limit,sortBy),HttpStatus.OK);

	}
	
	//Returns employee details of employee based on employee name
		
	@GetMapping("/name/{name}")
	
    public ResponseEntity<Page<UserModel>> employeeDetailsByName(@PathVariable Optional<String> name,@RequestParam Optional<Integer> page, 
        @RequestParam Optional<Integer> limit,@RequestParam Optional<String> sortBy) 
    {	       
    	return new ResponseEntity<Page<UserModel>>(objUserService.findByName(name,page,limit,sortBy),HttpStatus.OK);
    }
		
	//Returns employee details of employee based on department
		
   @GetMapping("/department/{department}")
	
    public ResponseEntity<Page<UserModel>> getEmployeeBydepartment(@PathVariable Optional<String> department,@RequestParam Optional<Integer> page, 
        @RequestParam Optional<Integer> limit,@RequestParam Optional<String> sortBy) 
    {	       
    	return new ResponseEntity<Page<UserModel>>(objUserService.findByDepartment(department,page,limit,sortBy),HttpStatus.OK);
    }
	   
	/***Optional Employee API end***/

	 
}