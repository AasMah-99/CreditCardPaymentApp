package com.ccpa.service;

import java.util.List;

import com.ccpa.exception.AccountNotAddedException;
import com.ccpa.exception.AccountNotDeletedException;
import com.ccpa.exception.AccountNotFoundException;
import com.ccpa.exception.AccountNotUpdatedException;
import com.ccpa.model.Account;

public interface AccountService {
	
	public Account addAccount(Account account) throws AccountNotAddedException;
	
	public Account removeAccount(Long id)throws AccountNotDeletedException;
	
	public Account updateAccount(Long id,Account account) throws AccountNotUpdatedException;
	
	public Account getAccount(Long id)throws AccountNotFoundException;
	
	public List<Account> getAllAccounts();
	
}
