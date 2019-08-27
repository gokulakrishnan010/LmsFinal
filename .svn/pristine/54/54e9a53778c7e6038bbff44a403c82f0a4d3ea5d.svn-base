package com.tvscs.lms.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.tvscs.lms.model.Employee;
import com.tvscs.lms.model.Performance;

/**
 * @author 5030618
 *
 */
public class EmployeeResultSetExtractor implements ResultSetExtractor<List<Employee>> {

	/**
	 * Employee Result set extractor 
	 */
	@Override
	public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Employee employee = null;
		List<Performance> performList = null;
		List<Employee> employeeDupList = new ArrayList<>();
		while(rs.next()){
			employee = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			Performance monthlyStats = new Performance();
			monthlyStats.setAssignedTotal(rs.getDouble(8));
			monthlyStats.setCollection(rs.getDouble(9));
			monthlyStats.setRating(rs.getString(10));
			monthlyStats.setTargetDate(rs.getDate(11));
			monthlyStats.setForTheMonth(rs.getDate(11).toLocalDate().minusMonths(1).getMonth().toString());
			performList = new ArrayList<>();
			performList.add(monthlyStats);
			employee.setMonthlyPerformance(performList);
			employeeDupList.add(employee);
		}
		return employeeDupList;
	}

}
