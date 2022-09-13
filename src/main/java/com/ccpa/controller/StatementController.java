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

import com.ccpa.exception.StatementNotAddedException;
import com.ccpa.exception.StatementNotDeletedException;
import com.ccpa.exception.StatementNotFoundException;
import com.ccpa.exception.StatementNotUpdatedException;
import com.ccpa.model.Statement;
import com.ccpa.service.CustomerService;
import com.ccpa.service.StatementService;

@RestController
@RequestMapping("/statement")
public class StatementController {

	@Autowired
	StatementService statementService;

	@Autowired
	CustomerService customerService;

	private static final String message = "message";

	// Adding statement informations with POST mapping
	@PostMapping("/addStatement")
	public ResponseEntity<Map<String, Object>> addstatement(@RequestBody Statement statement)
			throws StatementNotAddedException {
		Map<String, Object> res = new HashMap<>();
		res.put("data", statementService.addStatement(statement));
		res.put(message, "Statement inserted successfully!");
		return new ResponseEntity<>(res, HttpStatus.CREATED);

	}

	// Deleting statement informations with DELETE mapping
	@DeleteMapping("/deleteStatement/{statementId}")
	public ResponseEntity<Map<String, Object>> deleteStatement(@PathVariable Long statementId)
			throws StatementNotDeletedException {
		Map<String, Object> res = new HashMap<>();
		res.put("data", statementService.removeStatement(statementId));
		res.put(message, "Statement with Id " + statementId + " Deleted Successfully!");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// Updating specific statement informations with PUT mapping
	@PutMapping("/updateStatement/{statementId}")
	public ResponseEntity<Map<String, Object>> updateStatement(@RequestBody Statement statement,
			@PathVariable("statementId") Long statementId) throws StatementNotUpdatedException {
		Map<String, Object> res = new HashMap<>();
		res.put("data", statementService.updateStatement(statementId, statement));
		res.put(message, "Statement with Id " + statementId + " Updated SuccessFully");
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	// Getting statement informations with statementId and GET mapping
	@GetMapping("/getStatement/{statementId}")
	public ResponseEntity<Map<String, Object>> getStatement(@PathVariable Long statementId)
			throws StatementNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put("data", statementService.getStatement(statementId));
		res.put(message, "Statement with Id " + statementId + " found!");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// Getting all statement informations with GET mapping
	@GetMapping("/allStatements")
	public ResponseEntity<Map<String, Object>> getAllStatement() {
		Map<String, Object> res = new HashMap<>();
		res.put(message, "All Statements are shown. ");
		res.put("data", statementService.getAllStatements());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
