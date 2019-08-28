package com.tvscs.lms.security.service;
///*package com.tvscs.lms.security.service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.tvscs.lms.security.dao.UserDao;
//import com.tvscs.lms.security.model.DAOUser;
//import com.tvscs.lms.security.model.UserDTO;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//	
//	@Autowired(required=true)
//	private UserDao userDao;
//
//	@Autowired(required=true)
//	private PasswordEncoder bcryptEncoder;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		DAOUser user = userDao.findByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				new ArrayList<>());
//	}
//	
//	public DAOUser save(UserDTO user) {
//		DAOUser newUser = new DAOUser();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		return userDao.save(newUser);
//	}
//}*/
//
//package com.tvscs.lms.security;
//
//import java.util.ArrayList;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//@Configuration
//public class JwtUserDetailsService implements UserDetailsService {
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("Shezartech".equals(username)) {
//			return new User("Shezartech","$2a$10$5OwqHx7Fz.RWedo8Qt4I2.UGK1Sw636DeeCkM8w.MdsrH5b2qubFu",new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}
//}