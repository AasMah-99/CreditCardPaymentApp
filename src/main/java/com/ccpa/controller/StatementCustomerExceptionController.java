package com.ccpa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ccpa.exception.CustomerNotAddedException;
import com.ccpa.exception.CustomerNotDeletedException;
import com.ccpa.exception.CustomerNotFoundException;
import com.ccpa.exception.CustomerNotUpdatedException;
import com.ccpa.exception.StatementNotAddedException;
import com.ccpa.exception.StatementNotDeletedException;
import com.ccpa.exception.StatementNotFoundException;
import com.ccpa.exception.StatementNotUpdatedException;

@RestControllerAdvice
public class StatementCustomerExceptionController {
	private static final String status = "status";
	private static final String message = "message";

	//handling customer not added exception
	@ExceptionHandler(CustomerNotAddedException.class)
	public ResponseEntity<Map<String, Object>> customerNotAddedHandler(CustomerNotAddedException cnax) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, cnax.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	//handling customer not deleted exception
	@ExceptionHandler(CustomerNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> customerNotDeletedHandler(CustomerNotDeletedException cndx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, cndx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//handling customer not updated exception
	@ExceptionHandler(CustomerNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> customerNotUpdatedHandler(CustomerNotUpdatedException cnux) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, cnux.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_MODIFIED);
	}

	//handling customer not found exception
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Map<String, Object>> customerNotFoundHandler(CustomerNotFoundException cnfe) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, cnfe.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	//handling statement not added exception
	@ExceptionHandler(StatementNotAddedException.class)
	public ResponseEntity<Map<String, Object>> statementNotAddedHandler(StatementNotAddedException snax) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, snax.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	//handling statement not deleted exception
	@ExceptionHandler(StatementNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> statementNotDeletedHandler(StatementNotDeletedException sndx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, sndx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//handling statement not updated exception
	@ExceptionHandler(StatementNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> statementNotUpdatedHandler(StatementNotUpdatedException snux) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, snux.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_MODIFIED);
	}

	//handling statement not found exception
	@ExceptionHandler(StatementNotFoundException.class)
	public ResponseEntity<Map<String, Object>> statementNotFoundHandler(StatementNotFoundException snfe) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, snfe.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
}
