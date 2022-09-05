package com.ccpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Account {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
  private long accountId;
	
  private String accountName;
	
  private double balance;

  private String accountType;
  
public Account(long accountId, String accountName, double balance, String accountType) {
	super();
	this.accountId = accountId;
	this.accountName = accountName;
	this.balance = balance;
	this.accountType = accountType;
}

public long getAccountId() {
	return accountId;
}

public void setAccountId(long accountId) {
	this.accountId = accountId;
}

public String getAccountName() {
	return accountName;
}

public void setAccountName(String accountName) {
	this.accountName = accountName;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public String getAccountType() {
	return accountType;
}

public void setAccountType(String accountType) {
	this.accountType = accountType;
}

@Override
public String toString() {
	return "Account [accountId=" + accountId + ", accountName=" + accountName + ", balance=" + balance
			+ ", accountType=" + accountType + "]";
}

public Account() {
	
}
}

