package com.joshua.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.joshua.app.model.UserAccount;
import com.joshua.app.model.UserProfile;
import com.joshua.app.service.AccountService;
import com.joshua.app.service.UserService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public ModelAndView home(ModelAndView view,@AuthenticationPrincipal Authentication auth) {
		view.setViewName("app.home");
		UserProfile user = userService.getLoggedInUser(auth);
		UserAccount account = accountService.getAccount(user);
		
		view.getModel().put("account", account);
			
		return view;
	}
	
	@GetMapping("/deposit")
	public ModelAndView depositAmount(ModelAndView view) {
		view.setViewName("app.deposit");
		return view;
	}
	
	
	@PostMapping("/deposit")
	public ModelAndView depositAmount(ModelAndView view, @AuthenticationPrincipal Authentication auth, @RequestParam("amount")int amount) {
		view.setViewName("app.deposit");
		UserProfile user = userService.getLoggedInUser(auth);
		if(amount <= 0) {
		view.getModel().put("error", "Cannot deposit that amount!!");
		}
		accountService.depositAmount(user, amount);
		view.getModel().put("msg", "Amount Deposited Successfuly");
		return view;
	}
	
	@GetMapping("/withdraw")
	public ModelAndView withdrawAmount(ModelAndView view) {
		view.setViewName("app.withdraw");
		return view;
	}
	
	
	@PostMapping("/withdraw")
	public ModelAndView withdrawAmount(ModelAndView view, @AuthenticationPrincipal Authentication auth, @RequestParam("amount")int amount) {
		view.setViewName("app.withdraw");
		UserProfile user = userService.getLoggedInUser(auth);
		UserAccount account = accountService.getAccount(user);
		
		if(account.getAccountBalance() <= 0) {
		view.getModel().put("error", "You have insufficient amount in your account!!");
		}
		
		else if( account.getAccountBalance() < amount) {
			view.getModel().put("error", "You have insufficient amount in your account!!");
		}
		
		else {
		accountService.withdrawAmount(user, amount);
		view.getModel().put("msg", "Amount Withdrawed Successfuly");
		}
		return view;
	}
	
	@GetMapping("/transfer")
	public ModelAndView transferAmount(ModelAndView view) {
		view.setViewName("app.transfer");
		return view;
	}
	
	
	@PostMapping("/transfer")
	public ModelAndView transferAmount(ModelAndView view, @AuthenticationPrincipal Authentication auth,
			@RequestParam("recipient")String to, @RequestParam("amount")int amount) {
		
		view.setViewName("app.transfer");
		UserProfile user = userService.getLoggedInUser(auth);
		UserAccount account = accountService.getAccount(user);
		
		if(account.getAccountBalance() <= 0) {
		view.getModel().put("error", "You have insufficient amount in your account to complete the transaction!!");
		}
		
		else if( account.getAccountBalance() < amount) {
			view.getModel().put("error", "You have insufficient amount in your account to complete the transaction!!");
		}
		
		else if(userService.loadUserByUsername(to) == null){
			view.getModel().put("error", "User with Email Address does not exists!!");
		}
		
		else {
		accountService.transferMoney(user, to, amount);
		view.getModel().put("msg", "Transfer was Successfuly");
		}
		return view;
	}
	
	@GetMapping("/statements")
	public ModelAndView getStatements(ModelAndView view,@AuthenticationPrincipal Authentication auth) {
		view.setViewName("app.statements");
		UserProfile user = userService.getLoggedInUser(auth);
		view.getModel().put("statements", accountService.getMiniStatements(user));
		
		return view;
	}
	
	
	@PostMapping("/delete/{id}")
	public ModelAndView deleteStatement(ModelAndView view,@PathVariable("id")Long id,@AuthenticationPrincipal Authentication auth) {
		view.setViewName("app.statements");
       accountService.deleteStatements(id);
        getStatements(view, auth);
		return view;
	}
	
}

