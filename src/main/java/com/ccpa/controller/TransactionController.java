package com.ccpa.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.ccpa.exception.TransactionNotAddException;
import com.ccpa.exception.TransactionNotDeletedException;
import com.ccpa.exception.TransactionNotFoundException;
import com.ccpa.exception.TranscationNotUpdatedExcption;
import com.ccpa.model.Transaction;
import com.ccpa.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	private static final String status = "status";
	private static final String message = "message";

	@Autowired
	TransactionService transactionService;
	
	//To see all the Data of Transaction
	@GetMapping("/getAllTransactions")
	public ResponseEntity<Map<String, Object>> getAllTransaction() {
		Map<String, Object> trans = new HashMap<>();
		trans.put(status, true);
		trans.put(message, "All Transaction ");
		trans.put("data", transactionService.getAllTransactions());
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}
	
	//To see Data of Transaction with Transaction ID
	@GetMapping("/getTransaction/{transactionId}")
	public ResponseEntity<Map<String, Object>> getTransactionById(@PathVariable Long transId) throws TransactionNotFoundException {
		Map<String, Object> trans = new HashMap<>();
		trans.put(status, true);
		trans.put(message, "Transaction with Id!");
		trans.put("data", transactionService.getTransactionById(transId));
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}
	
	//To add the Data of Transaction
	@PostMapping("/addTransaction")
	public ResponseEntity<Map<String, Object>> addTransaction(@RequestBody Transaction transaction) throws TransactionNotAddException {
		Map<String, Object> trans = new HashMap<>();
		trans.put(status, true);
		trans.put(message, "Transaction inserted successfully!");
		trans.put("data", transactionService.addTranscation(transaction));
		return new ResponseEntity<>(trans, HttpStatus.CREATED);
	}

	//To Update Data of Transaction with Transaction ID
	@PutMapping("/updateTransaction")
	public ResponseEntity<Map<String, Object>> updateTransaction(@RequestBody Transaction transaction, @PathVariable Long transId) throws TranscationNotUpdatedExcption{
		Map<String, Object> trans = new HashMap<>();
		trans.put(status, true);
		trans.put(message, "Transaction Updated SuccessFully");
		trans.put("data", transactionService.updateTransaction(transId, transaction));
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}
	
	//To Delete Data of Transaction with Transaction ID
	@DeleteMapping("/deleteTransaction/{transactionId}")
	public ResponseEntity<Map<String, Object>> deleteTransactionById(@PathVariable Long transId) throws TransactionNotDeletedException {
		Map<String, Object> trans = new HashMap<>();
		trans.put(status, true);
		trans.put(message, "Transaction deleted successfully!");
		trans.put("data", transactionService.removeTransactionById(transId));
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}
	
}
