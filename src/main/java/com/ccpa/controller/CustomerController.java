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

import com.ccpa.exception.CustomerNotAddedException;
import com.ccpa.exception.CustomerNotDeletedException;
import com.ccpa.exception.CustomerNotFoundException;
import com.ccpa.exception.CustomerNotUpdatedException;
import com.ccpa.model.Customer;
import com.ccpa.repository.CustomerRepository;
import com.ccpa.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	CustomerRepository customerRepository;
	private static final String message = "message";

	// Adding customer informations with POST mapping
	@PostMapping("/addCustomer")
	public ResponseEntity<Map<String, Object>> addCustomer(@RequestBody Customer customer)
			throws CustomerNotAddedException {
		Map<String, Object> res = new HashMap<>();
		res.put("data", customerService.addCustomer(customer));
		res.put(message, "Customer inserted successfully!");
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	// Deleting customer informations with DELETE mapping
	@DeleteMapping("/deleteCustomer/{custId}")
	public ResponseEntity<Map<String, Object>> deleteCustomer(@PathVariable Long custId)
			throws CustomerNotDeletedException {
		Map<String, Object> res = new HashMap<>();
		res.put("data", customerService.removeCustomer(custId));
		res.put(message, "Customer with Id " + custId + " Delete Successfully!");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// Updating specific customer informations with PUT mapping
	@PutMapping("/updateCustomer/{custId}")
	public ResponseEntity<Map<String, Object>> updateCustomer(@RequestBody Customer customer,
			@PathVariable("custId") Long custId) throws CustomerNotUpdatedException {
		Map<String, Object> res = new HashMap<>();
		res.put("data", customerService.updateCustomer(custId, customer));
		res.put(message, "Customer with Id " + custId + " Updated SuccessFully");
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	// Getting customer informations with custId and GET mapping
	@GetMapping("/getCustomer/{custId}")
	public ResponseEntity<Map<String, Object>> getCustomer(@PathVariable Long custId) throws CustomerNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put("data", customerService.getCustomer(custId));
		res.put(message, "Customer with Id " + custId + " found!");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// Getting all customer informations with GET mapping
	@GetMapping("/allCustomers")
	public ResponseEntity<Map<String, Object>> getAllCustomer() {
		Map<String, Object> res = new HashMap<>();
		res.put(message, "All Customers are shown. ");
		res.put("data", customerService.getAllCustomers());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}