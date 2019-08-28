package com.tvscs.lms.employee.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.tvscs.lms.employee.model.UserModel;

public interface UserService {

	List<UserModel> viewAll();

	Optional<UserModel> findById(String Id);

	Page<UserModel> findByempJoiningDate(Date joiningDate,Optional<Integer> page,Optional<Integer> limit, Optional<String> sortBy);
	
	Page<UserModel> findByempRegion(String joiningDate,Optional<Integer> page,Optional<Integer> limit, Optional<String> sortBy);

	Page<UserModel> findByempLocation(String location,Optional<Integer> page,Optional<Integer> limit, Optional<String> sortBy);

	Page<UserModel> findByEmpReportManagerId(Long reportManagerId,Optional<Integer> page,Optional<Integer> limit, Optional<String> sortBy);

	Page<UserModel> findByName(Optional<String> name, Optional<Integer> page,Optional<Integer> limit, Optional<String> sortBy);

	List<UserModel> findByListId(List<String> id);

	Page<UserModel> findExistingEmployees(Optional<Integer> page, Optional<Integer> limit,Optional<String> sortBy);

	Page<UserModel> findByempJoiningDate(Optional<Integer> page, Optional<Integer> limit, Optional<String> sortBy);

	Page<UserModel> findByDepartment(Optional<String> department, Optional<Integer> page, Optional<Integer> limit,
			Optional<String> sortBy);

}
