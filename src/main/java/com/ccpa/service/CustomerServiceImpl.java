package com.ccpa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccpa.exception.CustomerNotAddedException;
import com.ccpa.exception.CustomerNotDeletedException;
import com.ccpa.exception.CustomerNotFoundException;
import com.ccpa.exception.CustomerNotUpdatedException;
import com.ccpa.model.Customer;
import com.ccpa.repository.CustomerRepository;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotAddedException {
		return customerRepository.save(customer);
	}

	@Override
	public Customer removeCustomer(Long custId) throws CustomerNotDeletedException {
		if (customerRepository.existsById(custId)) {
			customerRepository.deleteById(custId);
		}
		else {
		throw new CustomerNotDeletedException("Customer Id Not Found");
		}
		return null;
	}
	
	@Override
	public Customer updateCustomer(Long custId, Customer customer) throws CustomerNotUpdatedException {
		if(customerRepository.existsById(custId)){
			Customer customerFromDb = (customerRepository).getCustomerById(custId);
			customerFromDb.setCustId(custId);
			customerFromDb.setUserId(customer.getUserId());
			customerFromDb.setName(customer.getName());
			customerFromDb.setEmail(customer.getEmail());
			customerFromDb.setContactNo(customer.getContactNo());
			customerFromDb.setDob(customer.getDob());
			customerFromDb.setAddress(customer.getAddress());
		    customerRepository.save(customerFromDb);
			}
		else {
			throw new CustomerNotUpdatedException("Customer Id not Found for Updating");
		}
		return customer;
	}
	
	@Override
	public Customer getCustomer(Long custId) throws CustomerNotFoundException {
		Optional<Customer> customer = customerRepository.findById(custId);
		if (customer.isPresent()) {
			return customer.get();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
}

