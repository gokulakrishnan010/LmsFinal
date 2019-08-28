package com.tvscs.lms.employee.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tvscs.lms.employee.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> 
{
	@Query("select emp from UserModel emp where emp_no IN (:id)")
	
	List<UserModel> findById(@Param("id") List<String> id);
	
	@Query("select emp from UserModel emp where emp_no =?1")
	Optional<UserModel> findById(String id);
	
	@Query("select emp from UserModel emp where emp_doj=?1")
	Page<UserModel> findByemp_doj(Date joiningDate,PageRequest pageRequest);
	
	@Query("select emp from UserModel emp where emp_region like %?1%")
	Page<UserModel> findByemp_region(String location,PageRequest pageRequest);

	@Query("select emp from UserModel emp where emp_location like %?1%")
	Page<UserModel> findByemp_location(String location,PageRequest pageRequest);

	 @Query("select emp from UserModel emp where emp_appraiser_id = ?1")
	 Page<UserModel> findByemp_appraiser_id(Long reportManagerId,PageRequest pageRequest);

	 @Query("select emp from UserModel emp where emp_name like %?1%")
	Page<UserModel> findByemp_name(String name, PageRequest pageRequest);

	 @Query("select emp from UserModel emp where emp_doj NOT IN (CURRENT_DATE)")
	Page<UserModel> findById(PageRequest pageRequest);
	 
	 @Query("select emp from UserModel emp where emp_doj IN (CURRENT_DATE)")
		Page<UserModel> findByemp_doj(PageRequest pageRequest);

	 @Query("select emp from UserModel emp where emp_department like %?1%")
	 Page<UserModel> findByemp_department(Optional<String> department, PageRequest pageRequest);

}
