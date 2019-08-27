package com.tvscs.lms.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tvscs.lms.error.DepartmentNotFoundException;
import com.tvscs.lms.error.EmployeeNotFoundException;
import com.tvscs.lms.error.RegionNotFoundException;
import com.tvscs.lms.model.User;
import com.tvscs.lms.repo.UserRepository;
import com.tvscs.lms.service.IUserService;
import com.tvscs.lms.util.Departments;
import com.tvscs.lms.util.Regions;
import com.tvscs.lms.util.StatusCodes;

/**
 * @author 5030618
 *
 */
@Service
public class UserServiceImpl implements IUserService{

	/**
	 * User Repository 
	 */
	@Autowired
	private UserRepository repo;

	/**
	 * Logging
	 */
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * To get employee data based on empId
	 */
	@Override
	@Cacheable(value = "users-cache", unless = "#result==null")
	public Optional<User> getEmployeeById(Integer userId) {
		logger.info(" User Accessing data from getEmployeeById()");
		return repo.findById(userId.toString());

	}

	/**
	 *To get employee data by Joining date 
	 */
	@Override
	public Page<User> findByJoiningDate(Date joiningDate, int pageNum, int pageSize) {
		logger.info(" User Accessing data from findByJoiningDate()");
		return  repo.findByemp_doj(joiningDate, 
				PageRequest.of(pageNum, pageSize, Sort.by(StatusCodes.EMPLOYEE_ID)));

	}

	/**
	 *To check whether user exist or not 
	 */
	@Override
	public boolean isUserExist(String userId) {
		return repo.existsById(userId);
	}

	/**
	 *To get employee data in a region 
	 */
	@Override
	@Cacheable(value = "users-cache",  unless = "#result==null")
	public List<User> findByRegion(String region, int pageNum,int pageSize) {
		Page<User> pageOfUsers = null;
		logger.info(" User Accessing data from findByRegion()");
		try {
			pageOfUsers = repo.findByemp_region(Regions.valueOf(region).getRegion(), 
					PageRequest.of(pageNum, pageSize, Sort.by(StatusCodes.EMPLOYEE_ID)));

		} catch (Exception e) {
			logger.error("Error in findByRegion() "+region);
			throw new RegionNotFoundException(region);
		}
		if (pageOfUsers.hasContent()) {
			return pageOfUsers.getContent();
		}else {
			logger.warn("No Employees found in this region :"+region);
			throw new EmployeeNotFoundException();
		}
	}

	/**
	 *To get employees  data by department  
	 */
	@Override
	@Cacheable(value = "users-cache", unless = "#result==null")
	public List<User> findByDepartment(String department, int pageNum, int pageSize) {
		logger.info(" User Accessing data from findByDepartment()");
		Page<User> pageOfUsers = null;
		try {
			pageOfUsers = repo.findByemp_department(Departments.valueOf(department).getDepartment(), 
					PageRequest.of(pageNum, pageSize, Sort.by(StatusCodes.EMPLOYEE_ID)));

		} catch (Exception e) {
			throw new DepartmentNotFoundException(department);
		}
		if (pageOfUsers.hasContent()) {
			return pageOfUsers.getContent();
		}else {
			throw new EmployeeNotFoundException();
		}    
	}

	/**
	 *To get employee data by location 
	 */
	@Override
	public List<User> findByLocation(String location, int pageNum,int pageSize) {
		Page<User> pageOfUsers = null;
		logger.info(" User Accessing data from findByLocation()");
		try {
			pageOfUsers = repo.findByemp_location(location, 
					PageRequest.of(pageNum, pageSize, Sort.by(StatusCodes.EMPLOYEE_ID)));
		} catch (Exception e) {
			throw new RegionNotFoundException(location, pageOfUsers.getTotalElements());
		}
		if (pageOfUsers.hasContent()) {
			return pageOfUsers.getContent();
		}else {
			logger.warn("No Employees found in this location :"+location);
			throw new EmployeeNotFoundException();
		}
	}

	/**
	 * To get employee data by managerId
	 */
	@Override
	public List<User> findByManagerId(Integer managerId, int pageNum,int pageSize) {
		logger.info(" User Accessing data from findByManagerId()");
		Page<User> pageOfUsers = null;
		try {
			pageOfUsers = repo.findByemp_appraiser_id(managerId.toString(), 
					PageRequest.of(pageNum, pageSize, Sort.by(StatusCodes.EMPLOYEE_ID)));
		} catch (Exception e) {
			throw new EmployeeNotFoundException(managerId.toString(), 
					(int)pageOfUsers.getTotalElements());
		}
		if (pageOfUsers.hasContent()) {
			return pageOfUsers.getContent();
		}else {
			logger.warn("No Employees found under this manager :"+managerId);
			throw new EmployeeNotFoundException();
		}
	}


	/**
	 * To get employee data of a group of employees by
	 * emp Id list
	 */
	@Override
	public Optional<List<User>> getEmployeesById(List<Integer> empIdList) {
		logger.info(" User Accessing data from getEmployeesById()");
			return Optional.of(repo.findAllById(empIdList.stream().
					map(String::valueOf).collect(Collectors.toSet())));
	}

	/**
	 * To get employee data of all employees
	 */
	@Override
	public Page<User> getAllEmployees(int pageNum, int pageSize) {
		logger.info(" User Accessing data from getAllEmployees()");
		return  repo.findAll(PageRequest.of(pageNum, pageSize, 
				Sort.by(StatusCodes.EMPLOYEE_ID)));
	}

	/**
	 * to fetch the existing employee list 
	 */
	@Override
	public Page<User> findExistingEmployees(int pageNum,int pageSize) {
		return repo.findExistingEmployees(
				PageRequest.of(pageNum, pageSize, Sort.by(StatusCodes.EMPLOYEE_ID)));
	}

	/**
	 * To fetch the new joiners list by current date-1
	 */
	@Override
	public Page<User> findNewJoinersByDate(int pageNum,int pageSize) {
		return repo.findNewJoinersByDate( 
				PageRequest.of(pageNum, pageSize, Sort.by(StatusCodes.EMPLOYEE_ID)));
	}


}
