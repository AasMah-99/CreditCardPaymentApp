package com.ccpa.service;

import java.util.List;

import com.ccpa.exception.TransactionNotAddException;
import com.ccpa.exception.TransactionNotDeletedException;
import com.ccpa.exception.TransactionNotFoundException;
import com.ccpa.exception.TranscationNotUpdatedExcption;
import com.ccpa.model.Transaction;

public interface TransactionService {
	
	//	All CRUD services are added
	public Transaction getTransactionDetails(Long transId) throws TransactionNotFoundException;
	
	public List<Transaction> getAllTransactions();
	
	public Transaction addTranscation(Transaction transaction) throws TransactionNotAddException;
	
	public Transaction removeTransaction(Long transId) throws TransactionNotDeletedException;

	public Transaction updateTransaction(Long transId, Transaction transaction) throws TranscationNotUpdatedExcption;
}
