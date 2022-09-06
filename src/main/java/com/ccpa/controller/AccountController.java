package com.ccpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccpa.exception.AccountNotAddedException;
import com.ccpa.exception.AccountNotDeletedException;
import com.ccpa.exception.AccountNotFoundException;
import com.ccpa.exception.AccountNotUpdatedException;
import com.ccpa.model.Account;
import com.ccpa.service.AccountService;

@RestController 
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/addAccount")
	 public ResponseEntity<Account> addAccount(@RequestBody Account account) throws AccountNotAddedException {
	    return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.OK);
	  }
	
	@DeleteMapping("/removeAccount/{id}")
	 public ResponseEntity<Account> removeAccount(@PathVariable Long id) throws AccountNotDeletedException {
	    return new ResponseEntity<>(accountService.removeAccount(id), HttpStatus.OK);
	  }
	
	
	@PutMapping("/updateAccount/{id}")
	 public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable("id") Long id) throws AccountNotUpdatedException {
	    return new ResponseEntity<>(accountService.updateAccount(id, account), HttpStatus.OK);
	  }
	
	@GetMapping("/getAccountById/{id}")
    public ResponseEntity<Account> getaccountbyId(@PathVariable("id") Long id) throws AccountNotFoundException {
	  	return new ResponseEntity<>(accountService.getAccount(id),HttpStatus.FOUND);
	  }
	
	@GetMapping("/getAllAccounts")
	 public ResponseEntity<List<Account>> getAllaccounts() {
	  	return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.FOUND);
	  }
}
