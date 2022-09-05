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
@RequestMapping("/Account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/add")
	 public ResponseEntity<Account> addAccount(@RequestBody Account account) throws AccountNotAddedException {
	    return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.OK);
	  }
	
	@DeleteMapping("/removeAccount/{id}")
	 public ResponseEntity<Account> removeAccount(@PathVariable Long id) throws AccountNotDeletedException {
	    return new ResponseEntity<>(accountService.removeAccount(id), HttpStatus.OK);
	  }
	
	
	@PutMapping("/updateAccount")
	 public ResponseEntity<Account> updateNotes(@RequestBody Long id, Account account) throws AccountNotUpdatedException {
	    return new ResponseEntity<>(accountService.updateAccount(id, account), HttpStatus.OK);
	  }
	
	@GetMapping("/getaccountbyId/{accountId}")
    public ResponseEntity<Account> getaccountbyId(@PathVariable Long id) throws AccountNotFoundException {
	  	return new ResponseEntity<>(accountService.getAccount(id),HttpStatus.FOUND);
	  }
	
	@GetMapping("/getAllaccounts")
	 public ResponseEntity<List<Account>> getAllaccounts(@PathVariable Long id) {
	  	return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.FOUND);
	  }
	


}
