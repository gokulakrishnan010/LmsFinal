package com.tvscs.lms.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvscs.lms.dao.IEmployeeDao;
import com.tvscs.lms.error.EmployeeNotFoundException;
import com.tvscs.lms.model.Employee;
import com.tvscs.lms.service.IEmployeeService;
import com.tvscs.lms.util.PerformanceUtil;

/**
 * @author 5030618
 *
 */

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;

	private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	/**
	 * To find the month wise performance data 
	 * of all employees who are reporting to a manager
	 * based on his Id.
	 *
	 */

	@Override
	public List<Employee> getEmpPerformanceByManagerId(Integer managerId, Integer noOfMonths) {
		Optional<List<Employee>> empOptional = dao.getEmpPerformanceByManagerId(managerId, noOfMonths);
		if (empOptional.isPresent()) {
			return empOptional.get();
		} else {
			logger.warn("No Employees found under this manager "+managerId.toString());
			throw new EmployeeNotFoundException(managerId.toString(),empOptional.get().size());
		}

	}

	/**
	 * To find the month wise performance data 
	 * of an employee based on employee Id.
	 *
	 */

	@Override
	public Employee getPerformanceById(Integer empId, Integer noOfMonths) {
		Optional<Employee> employee = dao.getPerformanceById(empId, noOfMonths);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new EmployeeNotFoundException();
		}
	}

	/**
	 *To find the month wise performance data of
	 *employees in a region
	 */
	@Override
	public List<Employee> getEmpPerformanceByRegion(String region, Integer noOfMonths) {
		Optional<List<Employee>> empOptional = dao.getEmpPerformanceByRegion(region, noOfMonths);
		if (empOptional.isPresent()) {
			return empOptional.get();
		} else {
			throw new EmployeeNotFoundException();
		}
	}

	/**
	 * To find the month wise performance data of
	 * employees with list of emp ids
	 */
	@Override
	public List<Employee> getEmployeesPerformanceById(List<Integer> empIdList, Integer noOfMonths) {
		Optional<List<Employee>> empOptional = dao.getEmployeesPerformanceById(empIdList.stream().
				map(String::valueOf).collect(Collectors.toList()), 
				PerformanceUtil.getTargetDate(noOfMonths));
		if (empOptional.isPresent()) {
			return empOptional.get();
		} else {
			throw new EmployeeNotFoundException(empIdList.stream().
					map(String::valueOf).collect(Collectors.toList()));
		}
	}

	/**
	 * To find the month wise performance data 
	 * of all employees in a department
	 */
	@Override
	public List<Employee> getEmpPerformanceByDepartment(String department, Integer noOfMonths) {
		Optional<List<Employee>> empOptional = dao.getEmpPerformanceByDepartment(department, noOfMonths);
		if (empOptional.isPresent()) {
			return empOptional.get();
		} else {
			throw new EmployeeNotFoundException();
		}

	}

	@Override
	public Employee getMonthPerformance(Integer empId, String monthName, Integer year) {
		Optional<Employee> employee = dao.getMonthPerformance(empId, monthName, year);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new EmployeeNotFoundException();
		}
	}


}
