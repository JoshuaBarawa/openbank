package com.joshua.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.joshua.app.model.UserAccount;
import com.joshua.app.model.UserProfile;
import com.joshua.app.model.UserRole;
import com.joshua.app.repository.UserRepository;



@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email);
	}
	
	public void deleteUser(Long id){
	 userRepository.deleteById(id);;
	}
	
	public UserProfile getUser(Long id) {
		
		UserProfile user = userRepository.findById(id).get();
		
		return user;
	}
	
	public void editUser(UserProfile user) {
		userRepository.save(user);
	}
	
	public List<UserProfile> getUsers(){
		return (List<UserProfile>) userRepository.findAll();
	}
	
	public String signUpUser(UserProfile user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.USER);
		userRepository.save(user);
	    accountService.createAccount(new UserAccount(0,user));
		
	
		return "User successfuly saved";
	}
	
	public UserProfile getLoggedInUser(Authentication auth) {
		
		UserProfile user = null;
		Object principal = auth.getPrincipal();
		
		if(auth!=null && principal instanceof UserDetails) {
		  String name = ((UserDetails) principal).getUsername();
		 user = (UserProfile)loadUserByUsername(name);
		 
		}
		
		return user;
	}
	
	 public void updateUser(UserProfile user, Authentication auth) {
		   
		   UserProfile profile = getLoggedInUser(auth);
		   profile.setUserName(user.getUserName());
		   profile.setEmail(user.getEmail());
		   profile.setIdNumber(user.getIdNumber());
		   profile.setPhoneNumber(user.getPhoneNumber());
		   profile.setPassword(passwordEncoder.encode(user.getPassword()));
	 
		  userRepository.save(profile);
	   }
	
}
