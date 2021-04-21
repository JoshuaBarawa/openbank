package com.joshua.app.controller;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.joshua.app.email.EmailSender;
import com.joshua.app.model.UserProfile;
import com.joshua.app.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public ModelAndView login(ModelAndView view) {
		view.setViewName("app.login");
		
		return view;
	}
	
	
	@GetMapping("/user/resetpassword")
	public ModelAndView passReset(ModelAndView view) {
		view.setViewName("app.resetpassword");
		
		return view;
	}
	
	@PostMapping("/user/sendemail")
	public ModelAndView passwordReset(ModelAndView view,@RequestParam("email")String email) {
		view.setViewName("app.resetpassword");
		UserProfile user = (UserProfile) userService.loadUserByUsername(email)  ;
		if(user!= null) {
			
			Random code = new Random();
			int password = code.nextInt(99999);
			
			user.setPassword(passwordEncoder.encode(String.valueOf(password)));
			
			userService.editUser(user);
			emailSender.sendEmail(email, String.valueOf(password));
			
			view.getModel().put("msg", " A reset code has be sent to your email."+ 
					" Use it to login and reset your password");
			view.setViewName("app.resetpassword");
		}
		
		else {
			view.getModel().put("error", "Email does not exist!!");
			view.setViewName("app.resetpassword");		
		}
		
		return view;
	}
	
	
	@GetMapping("/admin/users")
	public ModelAndView getUsers(ModelAndView view) {
		view.setViewName("app.users");
		view.getModel().put("users", userService.getUsers());
		return view;
	}

	
	@PostMapping("/freeze/{id}")
	public ModelAndView delete(ModelAndView view, @PathVariable("id")Long id) {
		view.setViewName("app.users");
		UserProfile user  = userService.getUser(id);
		user.setEnabled(false);
		user.setPassword(passwordEncoder.encode("locked"));
		
		
		userService.editUser(user);
		getUsers(view);
		return view;
	}
	
	@PostMapping("/open/{id}")
	public ModelAndView unfreeze(ModelAndView view, @PathVariable("id")Long id) {
		view.setViewName("app.users");
		UserProfile user  = userService.getUser(id);
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode("locked"));
		userService.editUser(user);
		getUsers(view);
		return view;
	}
	
	
	@GetMapping("/user/signup")
	public ModelAndView confirmToken(ModelAndView view) {
		view.getModel().put("user", new UserProfile());
		view.setViewName("app.signup");
		return view;
	}
	
	@PostMapping("/user/signup")
	public ModelAndView signUp(ModelAndView view,@Valid @ModelAttribute("user")UserProfile userProfile, BindingResult results) {
		
		boolean user = userService.loadUserByUsername(userProfile.getEmail()) != null ;
		if(user == true) {
			view.setViewName("app.signup");
			view.getModel().put("error", "Email Already Exists!!");
		}
		
		else if(results.hasErrors()) {
			view.getModel().put("error", "Fill all credetials please!!");
		}
		
		else {
			userService.signUpUser(userProfile);
			view.setViewName("app.login");
		}
		
		return view;
	}

	@GetMapping("/profile")
	public ModelAndView updateUser(ModelAndView view, @AuthenticationPrincipal Authentication auth) {
		view.setViewName("app.profile");
		view.getModel().put("user", userService.getLoggedInUser(auth));
		return view;
	}
	
	@PostMapping("/update")
	public ModelAndView updateUser(ModelAndView view, @AuthenticationPrincipal Authentication auth,@ModelAttribute("user")UserProfile user
			,BindingResult result) {
		view.setViewName("app.profile");
	   userService.updateUser(user, auth);	
	   
	   view.getModel().put("msg", "User Updated Successful");
		
		return view;
	}
	
}
