package com.tvscs.lms.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.tvscs.lms.model.Employee;
import com.tvscs.lms.model.Performance;

/**
 * @author 5030618
 *
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = null;
		List<Performance> performList = new ArrayList<>();
		do {
			if(rs.isFirst()) {
				employee = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
			Performance monthlyStats = new Performance();
			monthlyStats.setAssignedTotal(rs.getDouble(8));
			monthlyStats.setCollection(rs.getDouble(9));
			monthlyStats.setRating(rs.getString(10));
			monthlyStats.setTargetDate(rs.getDate(11));
			monthlyStats.setForTheMonth(rs.getDate(11).toLocalDate().minusMonths(1).getMonth().toString());
			performList.add(monthlyStats);	
		}while(rs.next());
		employee.setMonthlyPerformance(performList);
		return employee;
	}

}
