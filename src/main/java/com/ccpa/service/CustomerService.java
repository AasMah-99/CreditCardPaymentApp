package com.ccpa.service;

import java.util.List;

import com.ccpa.exception.CustomerNotAddedException;
import com.ccpa.exception.CustomerNotDeletedException;
import com.ccpa.exception.CustomerNotFoundException;
import com.ccpa.exception.CustomerNotUpdatedException;
import com.ccpa.model.Customer;

public interface CustomerService {
	
	//	All CRUD services operationfor customer
	public Customer addCustomer(Customer customer) throws CustomerNotAddedException;

	public Customer removeCustomer(Long custId) throws CustomerNotDeletedException;

	public Customer updateCustomer(Long custId, Customer customer) throws CustomerNotUpdatedException;

	public Customer getCustomer(Long custId) throws CustomerNotFoundException;

	public List<Customer> getAllCustomers();
}
