package com.tvscs.lms.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.tvscs.lms.performance.model.Employee;
import com.tvscs.lms.performance.model.Performance;

/**
 * @author 5030618
 *
 */
public class PerformanceUtil {

	/**
	 * An Util method to get target date from given input
	 * @param noOfMonths
	 * @return TargetDate
	 */
	public static String getTargetDate(Integer noOfMonths) {
		LocalDate localDate = LocalDate.now();
		return localDate.minusMonths(noOfMonths+1).toString();
	}
     
	/**
	 * @param monthName
	 * @param year
	 * @return TargetDate
	 */
	public static String getTargetDateByMonth(String monthName, Integer year) {
		return LocalDate.of(year, Month.valueOf(monthName).plus(1), 1).toString();
	}
	/**
	 * To get unique employee with performance from duplicate 
	 * employee list
	 * @param empDuplicateRecords
	 * @return
	 */
	public static List<Employee> getUniqueEmployeeList(List<Employee> empDuplicateRecords){
		Set<Employee> employees = new HashSet<>(empDuplicateRecords);
		Set<Employee> uniqueEmpList = new HashSet<>();
		if(!empDuplicateRecords.isEmpty() && empDuplicateRecords != null) {
			for (Employee employee : employees) {
				List<Performance> performances = new ArrayList<>();
				for (Employee empdupObj : empDuplicateRecords) {
					if (employee.getEmpId().equals(empdupObj.getEmpId())){
						performances.add(empdupObj.getMonthlyPerformance().get(0));
					}
				}
				if(!performances.isEmpty()) {
					employee.setMonthlyPerformance(performances);
					uniqueEmpList.add(employee);
				}
			}
		}
		return uniqueEmpList.stream().collect(Collectors.toList());
	}
}

