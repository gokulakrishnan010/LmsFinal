package com.tvscs.lms.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.tvscs.lms.model.User;

public interface IUserService {
   /**
 * @param userId
 * @return
 */
public Optional<User> getEmployeeById(Integer userId);
   /**
 * @param userId
 * @return
 */
public boolean isUserExist(String userId);
   /**
 * @param joiningDate
 * @param pageNum
 * @param pageSize
 * @return
 */
public Page<User> findByJoiningDate(Date joiningDate, int pageNum,int pageSize);
   /**
 * @param region
 * @param pageNum
 * @param pageSize
 * @return
 */
public List<User> findByRegion(String region, int pageNum,int pageSize);
   /**
 * @param department
 * @param pageNum
 * @param pageSize
 * @return
 */
public List<User> findByDepartment(String department, int pageNum,int pageSize);
   /**
 * @param location
 * @param pageNum
 * @param pageSize
 * @return
 */
public List<User> findByLocation(String location, int pageNum,int pageSize);
   /**
 * @param managerId
 * @param pageNum
 * @param pagesize
 * @return
 */
public List<User> findByManagerId(Integer managerId, int pageNum,int pageSize);
   /**
 * @param empIdList
 * @return
 */
public Optional<List<User>> getEmployeesById(List<Integer> empIdList);
   /**
 * @param pageNum
 * @param pagesize
 * @return
 */
public Page<User> getAllEmployees(int pageNum,int pageSize);
   /**
 * @param page
 * @param limit
 * @param sortBy
 * @return
 */
public Page<User> findExistingEmployees(int pageNum,int pageSize);
   /**
 * @param page
 * @param limit
 * @param sortBy
 * @return
 */
public Page<User> findNewJoinersByDate(int pageNum,int pagesize);
}
