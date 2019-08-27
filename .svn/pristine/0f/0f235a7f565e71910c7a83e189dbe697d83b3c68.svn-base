package com.tvscs.lms.dao;

import java.util.List;
import java.util.Optional;

import com.tvscs.lms.model.Employee;

/**
 * @author 5030618
 *
 */
public interface IEmployeeDao {
	public Optional<Employee> getPerformanceById(Integer empId, Integer noOfMonths);
	public Optional<Employee> getMonthPerformance(Integer empId, String monthName, Integer year);
 	public Optional<List<Employee>> getEmpPerformanceByManagerId(Integer managerId, Integer noOfMonths);
	public Optional<List<Employee>> getEmpPerformanceByRegion(String region, Integer noOfMonths);
	public Optional<List<Employee>> getEmpPerformanceByDepartment(String department, Integer noOfMonths);
	public Optional<List<Employee>> getEmployeesPerformanceById(List<String> empIds, String targetDate);
	
}
