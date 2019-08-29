package com.tvscs.lms.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tvscs.lms.model.UserModel;
import com.tvscs.lms.repository.UserRepository;
import com.tvscs.lms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository objUserRepo;

	@Override
	public List<UserModel> viewAll() {
		// TODO Auto-generated method stub
		return objUserRepo.findAll();
	}

	@Override
	public Optional<UserModel> findById(String Id) {
		// TODO Auto-generated method stub
		return objUserRepo.findById(Id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<UserModel> findByempJoiningDate(Date joiningDate,Optional<Integer> page, 
            Optional<Integer> limit, Optional<String> sortBy) {
		// TODO Auto-generated method stub
		
		return  objUserRepo.findByempJoiningDate(joiningDate, new PageRequest( page.orElse(0),limit.orElse(10),
				 Sort.Direction.ASC, sortBy.orElse("empId")));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Page<UserModel> findByempRegion(String location,Optional<Integer> page, 
            Optional<Integer> limit, Optional<String> sortBy) {
		// TODO Auto-generated method stub
		
		return  objUserRepo.findByempRegion(location, new PageRequest( page.orElse(0),limit.orElse(10),
				 Sort.Direction.ASC, sortBy.orElse("empId")));
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public Page<UserModel> findByempLocation(String location,Optional<Integer> page, 
            Optional<Integer> limit, Optional<String> sortBy) {
		// TODO Auto-generated method stub
		//return objUserRepo.findByempLocation(location);
		
		return  objUserRepo.findByempLocation(location, new PageRequest( page.orElse(0),limit.orElse(10),
				 Sort.Direction.ASC, sortBy.orElse("empId")));
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<UserModel> findByEmpReportManagerId(Long reportManagerId, Optional<Integer> page, 
                                                    Optional<Integer> limit, Optional<String> sortBy) 
	{
		// TODO Auto-generated method stub
		
		return  objUserRepo.findByEmpReportManagerId(reportManagerId, new PageRequest( page.orElse(0),limit.orElse(10),
				 Sort.Direction.ASC, sortBy.orElse("empId")));
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<UserModel> findByName(Optional<String> name, Optional<Integer> page, 
			                           Optional<Integer> limit,Optional<String> sortBy) 
	{
		// TODO Auto-generated method stub
		return  objUserRepo.findByempName(name.orElse("_"), new PageRequest( page.orElse(0),limit.orElse(10),
				 Sort.Direction.ASC, sortBy.orElse("empId")));
		
	}

	@Override
	public List<UserModel> findByListId(List<String> id) {
		// TODO Auto-generated method stub
		return objUserRepo.findById(id);
	}


	@SuppressWarnings("deprecation")
	@Override
	public Page<UserModel> findExistingEmployees(Optional<Integer> page,
			Optional<Integer> limit, Optional<String> sortBy) {
		// TODO Auto-generated method stub
		return  objUserRepo.findByempJoiningDate(new PageRequest( page.orElse(0),limit.orElse(10),
				 Sort.Direction.ASC, sortBy.orElse("empId")));
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<UserModel> findByempJoiningDate(Optional<Integer> page, Optional<Integer> limit,
			Optional<String> sortBy) {
		// TODO Auto-generated method stub
		return  objUserRepo.findByempJoiningDate( new PageRequest( page.orElse(0),limit.orElse(10),
				 Sort.Direction.ASC, sortBy.orElse("empId")));
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<UserModel> findByDepartment(Optional<String> department, Optional<Integer> page,
			Optional<Integer> limit, Optional<String> sortBy) {
		
		// TODO Auto-generated method stub
		return  objUserRepo.findByempDepartment(department,new PageRequest( page.orElse(0),limit.orElse(10), Sort.Direction.ASC, sortBy.orElse("empId")));
	}

	

}
