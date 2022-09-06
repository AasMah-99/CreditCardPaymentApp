package com.ccpa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccpa.exception.StatementNotAddedException;
import com.ccpa.exception.StatementNotDeletedException;
import com.ccpa.exception.StatementNotFoundException;
import com.ccpa.exception.StatementNotUpdatedException;
import com.ccpa.model.Statement;
import com.ccpa.repository.StatementRepository;

@Service
@Transactional
public class StatementServiceImpl implements StatementService {

	@Autowired
	StatementRepository statementRepository;

	// Function to ADD statement details with required Exceptions
	@Override
	public Statement addStatement(Statement statement) throws StatementNotAddedException {
		return statementRepository.save(statement);
	}

	// Function to DELETE statement details with required Exceptions
	@Override
	public Statement removeStatement(Long statementId) throws StatementNotDeletedException {
		if (statementRepository.existsById(statementId)) {
			statementRepository.deleteById(statementId);
		} else {
			throw new StatementNotDeletedException("Statement Id Not Found");
		}
		return null;
	}

	// Function to UPDATE statement details with required Exceptions
	@Override
	public Statement updateStatement(Long statementId, Statement statement) throws StatementNotUpdatedException {
		if (statementRepository.existsById(statementId)) {
			Statement statementFromDb = statementRepository.getStatementById(statementId);
			statementFromDb.setStatementId(statementId);
			statementFromDb.setDueAmount(statement.getDueAmount());
			statementFromDb.setBillingDate(statement.getBillingDate());
			statementFromDb.setDueDate(statement.getDueDate());
			statementFromDb.setCustomer(statement.getCustomer());
		} else {
			throw new StatementNotUpdatedException("Statement Id not Found for Updating");
		}
		return statement;
	}

	// Function to GET statement details by statementId with required Exceptions
	@Override
	public Statement getStatement(Long statementId) throws StatementNotFoundException {
		Optional<Statement> statement = statementRepository.findById(statementId);
		if (statement.isPresent()) {
			return statementRepository.getStatementById(statementId);
		}
		throw new StatementNotFoundException("Statement Id , given by you is not found! ");
	}

	// Function to GET all statement details 
	@Override
	public List<Statement> getAllStatements() {
		return statementRepository.findAll();
	}

}
