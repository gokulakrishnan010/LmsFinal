package com.tvscs.lms.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tvscs.lms.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> 
{
	@Query("select emp from UserModel emp where empId IN (:id)")
	
	List<UserModel> findById(@Param("id") List<String> id);
	
	@Query("select emp from UserModel emp where empId =?1")
	Optional<UserModel> findById(String id);
	
	@Query("select emp from UserModel emp where empJoiningDate=?1")
	Page<UserModel> findByempJoiningDate(Date joiningDate,PageRequest pageRequest);
	
	@Query("select emp from UserModel emp where empRegion like %?1%")
	Page<UserModel> findByempRegion(String location,PageRequest pageRequest);

	@Query("select emp from UserModel emp where empLocation like %?1%")
	Page<UserModel> findByempLocation(String location,PageRequest pageRequest);

	 @Query("select emp from UserModel emp where EmpReportManagerId = ?1")
	 Page<UserModel> findByEmpReportManagerId(Long reportManagerId,PageRequest pageRequest);

	 @Query("select emp from UserModel emp where empName like %?1%")
	Page<UserModel> findByempName(String name, PageRequest pageRequest);

	 @Query("select emp from UserModel emp where empJoiningDate NOT IN (CURRENT_DATE)")
	Page<UserModel> findById(PageRequest pageRequest);
	 
	 @Query("select emp from UserModel emp where empJoiningDate IN (CURRENT_DATE)")
		Page<UserModel> findByempJoiningDate(PageRequest pageRequest);

	 @Query("select emp from UserModel emp where empDepartment like %?1%")
	 Page<UserModel> findByempDepartment(Optional<String> department, PageRequest pageRequest);


}
