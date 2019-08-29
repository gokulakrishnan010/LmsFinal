package com.tvscs.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="EMPLOYEE_DETAILS")
public class UserModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	//ID

	private String empId;
	
	//Employee Personal Information
	
	private String empName;
	private String empEmailId;
	private String empAddress;
	private String empState;
	private String empCity;
	private String empPincode;
	private Long empMobile;
	
	//Employee Qualification Details
	
	private String empFirstQualification;
	private String empFirstCourse;
	private String empAppraisal;
	private String empScndQualification;
	private String empScndCourse;
	
	//Employee Organisation Details
	
	private String empJoiningDate;
	private String empProduct;
	private String empFunction;
	private String empDepartment;
	private String empRegion;
	private String empPlArea;
	private String empLocation;
	private String empGrade;
	private String empDesignation;
	
	//Employee Reporting Head Details
	
	private String empReportManagerId;
	private String empReportManagerName;
	private String empSLManagerId;
	private String empSLManagerName;
	
	//Whether still Available in the organisation
	
	private String empStatus;
	
	

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
	 * @return the empEmailId
	 */
	public String getEmpEmailId() {
		return empEmailId;
	}

	/**
	 * @param empEmailId the empEmailId to set
	 */
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	/**
	 * @return the empAddress
	 */
	public String getEmpAddress() {
		return empAddress;
	}

	/**
	 * @param empAddress the empAddress to set
	 */
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	/**
	 * @return the empState
	 */
	public String getEmpState() {
		return empState;
	}

	/**
	 * @param empState the empState to set
	 */
	public void setEmpState(String empState) {
		this.empState = empState;
	}

	/**
	 * @return the empCity
	 */
	public String getEmpCity() {
		return empCity;
	}

	/**
	 * @param empCity the empCity to set
	 */
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	/**
	 * @return the empPincode
	 */
	public String getEmpPincode() {
		return empPincode;
	}

	/**
	 * @param empPincode the empPincode to set
	 */
	public void setEmpPincode(String empPincode) {
		this.empPincode = empPincode;
	}

	/**
	 * @return the empMobile
	 */
	public Long getEmpMobile() {
		return empMobile;
	}

	/**
	 * @param empMobile the empMobile to set
	 */
	public void setEmpMobile(Long empMobile) {
		this.empMobile = empMobile;
	}

	/**
	 * @return the empFirstQualification
	 */
	public String getEmpFirstQualification() {
		return empFirstQualification;
	}

	/**
	 * @param empFirstQualification the empFirstQualification to set
	 */
	public void setEmpFirstQualification(String empFirstQualification) {
		this.empFirstQualification = empFirstQualification;
	}

	/**
	 * @return the empFirstCourse
	 */
	public String getEmpFirstCourse() {
		return empFirstCourse;
	}

	/**
	 * @param empFirstCourse the empFirstCourse to set
	 */
	public void setEmpFirstCourse(String empFirstCourse) {
		this.empFirstCourse = empFirstCourse;
	}

	/**
	 * @return the empAppraisal
	 */
	public String getEmpAppraisal() {
		return empAppraisal;
	}

	/**
	 * @param empAppraisal the empAppraisal to set
	 */
	public void setEmpAppraisal(String empAppraisal) {
		this.empAppraisal = empAppraisal;
	}

	/**
	 * @return the empScndQualification
	 */
	public String getEmpScndQualification() {
		return empScndQualification;
	}

	/**
	 * @param empScndQualification the empScndQualification to set
	 */
	public void setEmpScndQualification(String empScndQualification) {
		this.empScndQualification = empScndQualification;
	}

	/**
	 * @return the empScndCourse
	 */
	public String getEmpScndCourse() {
		return empScndCourse;
	}

	/**
	 * @param empScndCourse the empScndCourse to set
	 */
	public void setEmpScndCourse(String empScndCourse) {
		this.empScndCourse = empScndCourse;
	}

	/**
	 * @return the empJoiningDate
	 */
	public String getEmpJoiningDate() {
		return empJoiningDate;
	}

	/**
	 * @param empJoiningDate the empJoiningDate to set
	 */
	public void setEmpJoiningDate(String empJoiningDate) {
		this.empJoiningDate = empJoiningDate;
	}

	/**
	 * @return the empProduct
	 */
	public String getEmpProduct() {
		return empProduct;
	}

	/**
	 * @param empProduct the empProduct to set
	 */
	public void setEmpProduct(String empProduct) {
		this.empProduct = empProduct;
	}

	/**
	 * @return the empFunction
	 */
	public String getEmpFunction() {
		return empFunction;
	}

	/**
	 * @param empFunction the empFunction to set
	 */
	public void setEmpFunction(String empFunction) {
		this.empFunction = empFunction;
	}

	/**
	 * @return the empDepartment
	 */
	public String getEmpDepartment() {
		return empDepartment;
	}

	/**
	 * @param empDepartment the empDepartment to set
	 */
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	/**
	 * @return the empRegion
	 */
	public String getEmpRegion() {
		return empRegion;
	}

	/**
	 * @param empRegion the empRegion to set
	 */
	public void setEmpRegion(String empRegion) {
		this.empRegion = empRegion;
	}

	/**
	 * @return the empPlArea
	 */
	public String getEmpPlArea() {
		return empPlArea;
	}

	/**
	 * @param empPlArea the empPlArea to set
	 */
	public void setEmpPlArea(String empPlArea) {
		this.empPlArea = empPlArea;
	}

	/**
	 * @return the empLocation
	 */
	public String getEmpLocation() {
		return empLocation;
	}

	/**
	 * @param empLocation the empLocation to set
	 */
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	/**
	 * @return the empGrade
	 */
	public String getEmpGrade() {
		return empGrade;
	}

	/**
	 * @param empGrade the empGrade to set
	 */
	public void setEmpGrade(String empGrade) {
		this.empGrade = empGrade;
	}

	/**
	 * @return the empDesignation
	 */
	public String getEmpDesignation() {
		return empDesignation;
	}

	/**
	 * @param empDesignation the empDesignation to set
	 */
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	/**
	 * @return the empReportManagerId
	 */
	public String getEmpReportManagerId() {
		return empReportManagerId;
	}

	/**
	 * @param empReportManagerId the empReportManagerId to set
	 */
	public void setEmpReportManagerId(String empReportManagerId) {
		this.empReportManagerId = empReportManagerId;
	}

	/**
	 * @return the empReportManagerName
	 */
	public String getEmpReportManagerName() {
		return empReportManagerName;
	}

	/**
	 * @param empReportManagerName the empReportManagerName to set
	 */
	public void setEmpReportManagerName(String empReportManagerName) {
		this.empReportManagerName = empReportManagerName;
	}

	/**
	 * @return the empSLManagerId
	 */
	public String getEmpSLManagerId() {
		return empSLManagerId;
	}

	/**
	 * @param empSLManagerId the empSLManagerId to set
	 */
	public void setEmpSLManagerId(String empSLManagerId) {
		this.empSLManagerId = empSLManagerId;
	}

	/**
	 * @return the empSLManagerName
	 */
	public String getEmpSLManagerName() {
		return empSLManagerName;
	}

	/**
	 * @param empSLManagerName the empSLManagerName to set
	 */
	public void setEmpSLManagerName(String empSLManagerName) {
		this.empSLManagerName = empSLManagerName;
	}

	/**
	 * @return the empStatus
	 */
	public String getEmpStatus() {
		return empStatus;
	}

	/**
	 * @param empStatus the empStatus to set
	 */
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	
	
	

}
