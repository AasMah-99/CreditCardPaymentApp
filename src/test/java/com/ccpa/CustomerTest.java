package com.ccpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.ccpa.exception.CustomerNotAddedException;
import com.ccpa.exception.CustomerNotDeletedException;
import com.ccpa.exception.CustomerNotFoundException;
import com.ccpa.exception.CustomerNotUpdatedException;
import com.ccpa.model.Customer;
import com.ccpa.repository.CustomerRepository;
import com.ccpa.service.CustomerService;


@SpringBootTest(classes = CreditcardpayementappApplication.class)
@Transactional
@Rollback(true)

 class CustomerTest {

	@Autowired
	private CustomerService customerService;
	
	CustomerRepository customerRepository;
	
	public Customer addCustomer() throws CustomerNotFoundException, CustomerNotAddedException {
		Customer customer = new Customer();
		customer.setName("Rohit");
		customer.setEmail("rohit@gmail.com");
		customer.setContactNo("3223234343");
		customer.setDob(LocalDate.of(1992, 2, 14));

		Long id = customerService.addCustomer(customer).getCustId();
		return customerService.getCustomer(id);
	}
	
	//Test case for add customer
		@Test
		void testAddCustomer() throws CustomerNotFoundException,CustomerNotAddedException {
			Customer customer = addCustomer();
			assertEquals("Rohit", customer.getName());
			assertEquals("rohit@gmail.com", customer.getEmail());
			assertEquals("3223234343", customer.getContactNo());
			assertEquals(LocalDate.of(1992, 2, 14), customer.getDob());
		}
		
		//Test case for delete customer
		@Test
		void testDeleteCustomer() throws CustomerNotAddedException, CustomerNotFoundException, CustomerNotDeletedException {
			Customer customer = addCustomer();
			Long customerId=customer.getCustId();
			customerService.removeCustomer(customer.getCustId());
			assertThrows(CustomerNotFoundException.class, () -> {
				customerService.getCustomer(customerId);
				});

		}
		
		//Test case for update customer
		@Test
		void testUpdateCustomer() throws CustomerNotFoundException, CustomerNotUpdatedException, CustomerNotAddedException {
			Customer customer = addCustomer();
			customer.setName("Kumar");
			customerService.updateCustomer(customer.getCustId(), customer);
			assertEquals("Kumar", customer.getName());
		}
		
		//Test case for getting customer by custId
		@Test
		void testGetCustomerById() throws CustomerNotFoundException, CustomerNotAddedException {
			Customer customer = addCustomer();
			customerService.getCustomer(customer.getCustId());
			assertEquals("Rohit", customer.getName());
			assertEquals("rohit@gmail.com", customer.getEmail());
			assertEquals("3223234343", customer.getContactNo());
			assertEquals(LocalDate.of(1992, 2, 14), customer.getDob());
		}
		
		//Test case for getting all customers
		@Test
		void testGetAllCustomer() throws CustomerNotFoundException, CustomerNotAddedException {
			Customer customer = addCustomer();
			customerService.getAllCustomers();
			assertEquals("Rohit", customer.getName());
			assertEquals("rohit@gmail.com", customer.getEmail());
			assertEquals("3223234343", customer.getContactNo());
			assertEquals(LocalDate.of(1992, 2, 14), customer.getDob());
		}
}
