package com.tvscs.lms.performance.dao.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

//import com.tvscs.lms.employee.repository.UserRepository;
import com.tvscs.lms.error.DepartmentNotFoundException;
import com.tvscs.lms.error.EmployeeNotFoundException;
import com.tvscs.lms.error.RegionNotFoundException;
import com.tvscs.lms.performance.dao.IEmployeeDao;
import com.tvscs.lms.performance.model.Employee;
import com.tvscs.lms.util.EmployeeResultSetExtractor;
import com.tvscs.lms.util.EmployeeRowMapper;
import com.tvscs.lms.util.PerformanceUtil;
import com.tvscs.lms.util.Regions;
import com.tvscs.lms.util.StatusCodes;



@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private NamedParameterJdbcTemplate namParamjdbcTemplate;

	@Autowired
	//private UserRepository repo;

	private Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	/**
	 * To fetch the Performance data based on employee Id
	 *
	 */
	@Override
	public Optional<Employee> getPerformanceById(Integer empId, Integer noOfMonths) {
		Employee employee = null;
		try {
			logger.info("User accessing data from getPerformanceById()");
			employee = namParamjdbcTemplate.queryForObject(StatusCodes.FETCH_RATING_BY_ID,
					new MapSqlParameterSource().addValue(StatusCodes.EMPLOYEE_ID, empId.toString())
					.addValue(StatusCodes.TARGET_DATE, PerformanceUtil.getTargetDate(noOfMonths)), 
					new EmployeeRowMapper());
		} catch (Exception e) {
			logger.error("Error in getPerformanceById()", e);
			throw new EmployeeNotFoundException(empId.toString());
		}
		return Optional.of(employee);
	}

	/**
	 * To fetch the Performance data of employees who are reporting 
	 * to a manager based on manager Id.
	 *
	 */
	@Override
	public  Optional<List<Employee>> getEmpPerformanceByManagerId(Integer managerId, Integer noOfMonths) {
		List<Employee> employeeDupList = null;
		try {
			logger.info("User accessing data from getPerformanceByByManagerId()");
			employeeDupList = namParamjdbcTemplate.query(StatusCodes.FETCH_EMPS_PERF_BY_MNG_ID, 
					new MapSqlParameterSource().addValue(StatusCodes.MANAGER_ID, managerId.toString())
					.addValue(StatusCodes.TARGET_DATE, PerformanceUtil.getTargetDate(noOfMonths)),
					new EmployeeResultSetExtractor());
		} catch (Exception e) {
			logger.error("Error in getPerformanceByByManagerId()", e);
			throw new EmployeeNotFoundException(managerId.toString());
		}
		return 	Optional.of(PerformanceUtil.getUniqueEmployeeList(employeeDupList));
	}

	/**
	 * To fetch the Performance data of employees in a region.
	 *
	 */
	@Override
	public Optional<List<Employee>> getEmpPerformanceByRegion(String region, Integer noOfMonths) {
		List<Employee> employeeDupList = null;
		try {
			logger.info(" User accessing data from getEmpPerformanceByRegion()");
			employeeDupList = namParamjdbcTemplate.query(StatusCodes.FETCH_EMPS_PERF_BY_REGION, 
					new MapSqlParameterSource().addValue(StatusCodes.REGION, 
							Regions.valueOf(region).getRegion()).
					addValue(StatusCodes.TARGET_DATE, PerformanceUtil.getTargetDate(noOfMonths)), 
					new EmployeeResultSetExtractor());
		} catch (Exception e) {
			logger.error("Error in getEmpPerformanceByRegion()", e);
			throw new RegionNotFoundException(region);
		}
		return Optional.of(PerformanceUtil.getUniqueEmployeeList(employeeDupList));
	}
	/**
	 * To fetch the Performance of employees based on list of employee ids.
	 *
	 */
	@Override
	public Optional<List<Employee>> getEmployeesPerformanceById(List<String> empIds, String targetDate) {
		List<Employee> employeeDupList = null;
		try {
			logger.info(" User accessing data from getEmployeesPerformanceById()");
			employeeDupList = namParamjdbcTemplate.query(StatusCodes.GET_EMPS_PERF_BY_ID, 
					new MapSqlParameterSource().addValue(StatusCodes.EMPLOYEE_IDS, empIds).
					addValue(StatusCodes.TARGET_DATE, targetDate), 
					new EmployeeResultSetExtractor());
		} catch (Exception e) {
			logger.error("Error in getEmployeesPerformanceById()", e);
			throw new EmployeeNotFoundException(empIds);
		}
		return Optional.of(PerformanceUtil.getUniqueEmployeeList(employeeDupList));
	}

	/**
	 * To fetch the Performance of employees in a department by getting empId list 
	 * from User Repository and passing it to getEmployeesPerformanceById().
	 *
	 */
	@Override
	public Optional<List<Employee>> getEmpPerformanceByDepartment(String department, Integer noOfMonths) {
		Optional<List<Employee>> employeeDupList = null;
		try {
			logger.info(" User accessing data from getEmpPerformanceByDepartment()");
		//	employeeDupList = getEmployeesPerformanceById(repo.getEmployeeIdsByDepartment(department), PerformanceUtil.getTargetDate(noOfMonths));
		} catch (Exception e) {
			logger.error("Error in getEmpPerformanceByDepartment()", e);
			throw new DepartmentNotFoundException(department);
		}
		return employeeDupList;
	}
    
	/**
	 * To fetch a particular month Performance of an employee 
	 *
	 */
	@Override
	public Optional<Employee> getMonthPerformance(Integer empId, String monthName, Integer year) {
		Employee employee = null;
		logger.info(" User accessing data from getMonthPerformance()");
		try {
			employee = namParamjdbcTemplate.queryForObject(StatusCodes.GET_ONE_MONTH_PERF, 
					new MapSqlParameterSource().addValue(StatusCodes.EMPLOYEE_ID, empId.toString())
					    .addValue(StatusCodes.TARGET_DATE, PerformanceUtil.getTargetDateByMonth(monthName, year)), 
					new EmployeeRowMapper());
		} catch (Exception e) {
			logger.info(" Error in getMonthPerformance()", e);
			throw new EmployeeNotFoundException(empId.toString());
		}
		return Optional.of(employee);
	}


}
