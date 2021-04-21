package com.joshua.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.app.model.MiniStatement;
import com.joshua.app.model.UserAccount;
import com.joshua.app.model.UserProfile;
import com.joshua.app.repository.AccountRepository;
import com.joshua.app.repository.StatementRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private StatementRepository stateRepository;

	@Autowired
	private UserService userService;
	
	public String createAccount(UserAccount account) {
		accountRepository.save(account);
		return "Account Created Successfull";
	}
	
	public UserAccount getAccount(UserProfile user) {
		return accountRepository.findByUser(user);
	}
	

   public void depositAmount(UserProfile user,int amount) {
	UserAccount account = getAccount(user);
	int newBalance = amount + account.getAccountBalance();
	account.setAccountBalance(newBalance);  
	accountRepository.save(account);
	MiniStatement statement = new MiniStatement(LocalDate.now(), "Deposit","N/A", amount, account.getAccountBalance(), user);
	stateRepository.save(statement);
	
	}
   
	
   public void withdrawAmount(UserProfile user,int amount) {
		UserAccount account = getAccount(user);
		int newBalance = account.getAccountBalance() - amount;
		account.setAccountBalance(newBalance);  
		accountRepository.save(account);
		
		MiniStatement statement = new MiniStatement(LocalDate.now(), "WithDraw","N/A", amount, account.getAccountBalance(), user);
		stateRepository.save(statement);
		
		}
   
   public void transferMoney(UserProfile sender, String to, int amount) {
	   
      UserProfile reciever = (UserProfile) userService.loadUserByUsername(to);
      UserAccount recieverAccount = getAccount(reciever);
      
	  UserAccount senderAccount = getAccount(sender);
	  int senderBalance = senderAccount.getAccountBalance() - amount;
	  int recieverBalance = recieverAccount.getAccountBalance() + amount;
	  
	  senderAccount.setAccountBalance(senderBalance);
	  recieverAccount.setAccountBalance(recieverBalance);
	  
	  accountRepository.save(senderAccount);
	  accountRepository.save(recieverAccount);
	  
	  MiniStatement statement = new MiniStatement(LocalDate.now(), "Transfer",reciever.getUserName(), amount, senderAccount.getAccountBalance(), sender);
	  stateRepository.save(statement);
	  
  }
   
   public List<MiniStatement> getMiniStatements(UserProfile user) {
	   return stateRepository.findByUser(user);
   }
   
   public void deleteStatements(Long id) {
	    stateRepository.deleteById(id);
   }
}
