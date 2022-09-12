package com.ccpa.service;

import java.util.List;

import com.ccpa.exception.StatementNotAddedException;
import com.ccpa.exception.StatementNotDeletedException;
import com.ccpa.exception.StatementNotFoundException;
import com.ccpa.exception.StatementNotUpdatedException;
import com.ccpa.model.Statement;

public interface StatementService {
	
    //	All CRUD services operation for statement
	public Statement addStatement(Statement statement) throws StatementNotAddedException;

	public Statement removeStatement(Long statementId) throws StatementNotDeletedException;

	public Statement updateStatement(Long statementId, Statement statement) throws StatementNotUpdatedException;

	public Statement getStatement(Long statementId) throws StatementNotFoundException;

	public List<Statement> getAllStatements();
	
}
