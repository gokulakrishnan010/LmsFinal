package com.tvscs.lms.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tvscs.lms.model.User;


/**
 * @author Gokulkrishnan
 *
 */
public interface UserRepository extends JpaRepository<User, String> {
	
	//public Page<User> findByJoiningDate(Date joiningDate, Pageable pageable);
	@Query("select emp from User emp where emp.emp_doj = :joiningDate")
	public Page<User> findByemp_doj(Date joiningDate,Pageable pageRequest);
	
	@Query("select emp from User emp where emp_region like %?1%")
	Page<User> findByemp_region(String location,Pageable pageRequest);
	//public Page<User> findByRegion(String region, Pageable pageable);
	
	@Query(" select emp from User emp where emp_department = :department ")
	public Page<User> findByemp_department(String department, Pageable pageable);
	
	@Query(" select emp from User emp where emp_location = :location ")
	public Page<User> findByemp_location(String location, Pageable pageable);
	
	@Query(" select emp from User emp where emp_appraiser_id = :managerId ")
    public Page<User> findByemp_appraiser_id(String managerId, Pageable pageable);
	
	@Query("select emp from User emp")
	public Page<User> findAll(Pageable pageable);
	/**
	 * To get Employee Ids in the particular department to fetch thier 
	 * performance 
	 *
	 */
	@Query(" select emp.emp_no from User emp where emp.emp_department = :department")
	public List<String> getEmployeeIdsByDepartment(String department);
	
	/**
	 * To get existing Employee data whose date of joining is not  current date -1
	 *
	 */
	@Query("select emp from User emp where emp_doj NOT IN (CURRENT_DATE)")
	public Page<User> findExistingEmployees(Pageable pageable);
	
	@Query("select emp from User emp where emp_doj IN (CURRENT_DATE)")
	public Page<User> findNewJoinersByDate(Pageable pageable);
}
