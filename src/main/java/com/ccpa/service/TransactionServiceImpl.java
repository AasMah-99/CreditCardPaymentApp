package com.ccpa.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccpa.exception.TransactionNotAddException;
import com.ccpa.exception.TransactionNotDeletedException;
import com.ccpa.exception.TransactionNotFoundException;
import com.ccpa.exception.TranscationNotUpdatedExcption;
import com.ccpa.model.Transaction;
import com.ccpa.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	//Function to GET Transaction details with "transId" with required Exceptions
	@Override
	public Transaction getTransactionDetails(Long transId) throws TransactionNotFoundException {
		if(transId==null) {
			throw new TransactionNotFoundException("Transaction Id cannot be Null");
		}else if(!transactionRepository.existsById(transId)) {
			throw new TransactionNotFoundException("This Transaction Id "+transId+" does not Exists");
		}
		return transactionRepository.findById(transId).orElse(null);
	}

	//Function to  GET ALL Transaction details from database
	@Override
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	//Function to ADD Transaction details with required Exceptions
	@Override
	public Transaction addTranscation(Transaction transaction) throws TransactionNotAddException {
		if (Objects.isNull(transaction))
			throw new TransactionNotAddException("Values cannot be null Transaction not Added");
		return transactionRepository.save(transaction);
	}

	//Function to DELETE Transaction details with required Exceptions
	@Override
	public Transaction removeTransaction(Long transId) throws TransactionNotDeletedException {
		transactionRepository.deleteById(transId);
		if(transactionRepository.existsById(transId)) {
			throw new TransactionNotDeletedException("Error Deleting Transation");
		}
		return null;
	}

	//Function to UPDATE Transaction details with required Exceptions
	@Override
	public Transaction updateTransaction(Long transId, Transaction transaction) throws TranscationNotUpdatedExcption {
		if(transactionRepository.existsById(transId)){
			Transaction trans = transactionRepository.save(transaction);
			if(trans!=null) {
				return trans;
			}
		}
		throw new TranscationNotUpdatedExcption("error updating transaction");
	}

}
