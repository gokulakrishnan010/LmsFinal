package com.tvscs.lms.service;

import java.util.List;

import com.tvscs.lms.model.Employee;

/**
 * @author 5030618
 *
 */
public interface IEmployeeService {
	public Employee getPerformanceById(Integer empId, Integer noOfMonths);
	public Employee getMonthPerformance(Integer empId, String monthName, Integer year);
	public List<Employee> getEmpPerformanceByManagerId(Integer empId, Integer noOfMonths);
	public List<Employee> getEmpPerformanceByRegion(String region, Integer noOfMonths);
	public List<Employee> getEmpPerformanceByDepartment(String department, Integer noOfMonths);
	public List<Employee> getEmployeesPerformanceById(List<Integer> empIds, Integer noOfMonths);

}
