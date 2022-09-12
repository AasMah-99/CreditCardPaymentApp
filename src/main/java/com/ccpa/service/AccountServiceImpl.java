package com.ccpa.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccpa.exception.AccountNotAddedException;
import com.ccpa.exception.AccountNotDeletedException;
import com.ccpa.exception.AccountNotFoundException;
import com.ccpa.exception.AccountNotUpdatedException;
import com.ccpa.model.Account;
import com.ccpa.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
    AccountRepository accountRepository;

	//Function to Add account with specific exceptions
	@Override
	public Account addAccount(Account account) throws AccountNotAddedException{
		if (Objects.isNull(account))
			throw new AccountNotAddedException("Account Not Found!");
		return accountRepository.save(account);
	}
     
	//Function to remove Account with specific Exception
	@Override
	public Account removeAccount(Long id) throws AccountNotDeletedException {
		accountRepository.deleteById(id);
		if(accountRepository.existsById(id)) {
			throw new AccountNotDeletedException("Error Deleting Account");
		}		
		
		return null;
	}
    
	//Function to update account with specific exception
	@Override
	public Account updateAccount(Long id, Account account) throws AccountNotUpdatedException {
		if(accountRepository.existsById(id)){
			Account acc= accountRepository.save(account);
			if(acc!=null) {
				return null;
			}
		}
		throw new AccountNotUpdatedException("error updating account");
	}	

	//Function to get account with Id
	@Override
	public Account getAccount(Long id) throws AccountNotFoundException {
		
		if(id==null) {
			throw new AccountNotFoundException("Id cannot be Null");
		}else if(!accountRepository.existsById(id)) {
			throw new AccountNotFoundException("Account with id "+id+" Does not Exists");
		}
		return accountRepository.findById(id).orElse(null);

	}

	//Function to get all accounts
	@Override
	public List<Account> getAllAccounts() {
		List<Account> account = (List<Account>) accountRepository.findAll();
		return account;
	}

}
