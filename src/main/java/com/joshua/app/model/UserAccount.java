package com.joshua.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="useraccount")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "accountBalance")
	private int accountBalance;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private UserProfile user;

	public UserAccount() {

	}
	
	public UserAccount(int accountBalance, UserProfile user) {
		this.accountBalance = accountBalance;
		this.user = user;
	}
	
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public UserProfile getUser() {
		return user;
	}
	public void setUser(UserProfile user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", accountBalance=" + accountBalance + ", user=" + user + "]";
	}
	
	
}
