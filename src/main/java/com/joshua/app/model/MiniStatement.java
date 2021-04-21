package com.joshua.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "statements")
public class MiniStatement{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "transdate")
	private LocalDate date;

	@Column(name = "transType")
	private String transType;

	@Column(name = "reciever")
	private String recipient;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "balance")
	private int balance;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private UserProfile user;
	
	public MiniStatement() {
	}
	
	public MiniStatement(LocalDate date, String transType, String recipient, int amount, int balance, UserProfile user) {

		this.date = date;
		this.transType = transType;
		this.recipient = recipient;
		this.amount = amount;
		this.balance = balance;
		this.user = user;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "MiniStatement [date=" + date + ", transType=" + transType + ", recipient=" + recipient + ", amount="
				+ amount + ", balance=" + balance + ", user=" + user + "]";
	}
	
}
