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

import com.ccpa.model.CreditCard;
import com.ccpa.exception.CreditCardNotAddedException;
import com.ccpa.exception.CreditCardNotDeletedException;
import com.ccpa.exception.CreditCardNotFoundException;
import com.ccpa.exception.CreditCardNotUpdatedException;
import com.ccpa.service.CreditCardService;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {

	private static final String status = "status";
	private static final String message = "message";

	@Autowired
	CreditCardService creditCardService;

	// Adding credit card informations with POST mapping
	@PostMapping("/addCreditCard")
	public ResponseEntity<Map<String, Object>> addCreditCard(@RequestBody CreditCard creditCard)
			throws CreditCardNotAddedException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Card added successfully!");
		res.put("data", creditCardService.addCreditCard(creditCard));
		return new ResponseEntity<>(res, HttpStatus.CREATED);

	}

	// Getting credit card informations with cardId and GET mapping
	@GetMapping("/getCreditCard/{cardId}")
	public ResponseEntity<Map<String, Object>> getCreditCardById(@PathVariable Long cardId)
			throws CreditCardNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Credit card with Id!");
		res.put("data", creditCardService.getCreditCard(cardId));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// Getting all credit card informations with GET mapping
	@GetMapping("/allCreditCardDetails")
	public ResponseEntity<Map<String, Object>> getAllCreditCard() {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "All Credit cards ");
		res.put("data", creditCardService.getAllCreditCards());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// Deleting credit card informations with DELETE mapping
	@DeleteMapping("/deleteCreditCard/{cardId}")
	public ResponseEntity<Map<String, Object>> deleteCreditCardById(@PathVariable Long cardId)
			throws CreditCardNotDeletedException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Card deleted successfully!");
		res.put("data", creditCardService.removeCreditCard(cardId));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// Updating specific credit card informations with PUT mapping
	@PutMapping("/updateCreditCard/{cardId}")
	public ResponseEntity<Map<String, Object>> updateCreditCard(@RequestBody CreditCard creditCard,
			@PathVariable Long cardId) throws CreditCardNotUpdatedException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Card updated successfully!");
		res.put("data", creditCardService.updateCreditCard(cardId, creditCard));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
