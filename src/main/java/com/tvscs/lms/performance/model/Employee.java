package com.tvscs.lms.performance.model;

import java.util.List;

public class Employee {
	private String empId;
	private String empName;
	private String managerId;
	private String managerName;
	private String designation;
	private String location;
	private String region;
	private List<Performance> monthlyPerformance;


	/**
	 * 
	 */
	public Employee() {
		super();
	}

	/**
	 * @param empId
	 * @param empName
	 * @param managerCode
	 * @param managerName
	 * @param designation
	 * @param location
	 * @param region
	 * @param monthlyPerformance
	 */
	public Employee(String empId, String empName, String managerId, String managerName, String designation,
			String location, String region, List<Performance> monthlyPerformance) {

		this.empId = empId;
		this.empName = empName;
		this.managerId = managerId;
		this.managerName = managerName;
		this.designation = designation;
		this.location = location;
		this.region = region;
		this.monthlyPerformance = monthlyPerformance;
	}

    

	/**
	 * @param empId
	 * @param monthlyPerformance
	 */
	public Employee(String empId, List<Performance> monthlyPerformance) {
		super();
		this.empId = empId;
		this.monthlyPerformance = monthlyPerformance;
	}

	/**
	 * @param empId
	 * @param empName
	 * @param managerCode
	 * @param managerName
	 * @param designation
	 * @param location
	 * @param region
	 */
	public Employee(String empId, String empName, String managerCode, String managerName, String designation,
			String location, String region) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.managerId = managerCode;
		this.managerName = managerName;
		this.designation = designation;
		this.location = location;
		this.region = region;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the managerCode
	 */
	public String getmanagerId() {
		return managerId;
	}

	/**
	 * @param managerCode the managerCode to set
	 */
	public void setmanagerId(String managerCode) {
		this.managerId = managerCode;
	}

	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the monthlyPerformance
	 */
	public List<Performance> getMonthlyPerformance() {
		return monthlyPerformance;
	}

	/**
	 * @param monthlyPerformance the monthlyPerformance to set
	 */
	public void setMonthlyPerformance(List<Performance> monthlyPerformance) {
		this.monthlyPerformance = monthlyPerformance;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", managerCode=" + managerId + ", managerName="
				+ managerName + ", designation=" + designation + ", location=" + location + ", region=" + region
				+ ", monthlyPerformance=" + monthlyPerformance + "]";
	}

}
