package com.ccpa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ccpa.exception.CustomerNotAddedException;
import com.ccpa.exception.CustomerNotDeletedException;
import com.ccpa.exception.CustomerNotFoundException;
import com.ccpa.exception.CustomerNotUpdatedException;
import com.ccpa.exception.StatementNotAddedException;
import com.ccpa.exception.StatementNotDeletedException;
import com.ccpa.exception.StatementNotFoundException;
import com.ccpa.exception.StatementNotUpdatedException;

//Test cases for all customer and statement exception
class StatementCustomerExceptionTest {
	
	public String customerNotFoundHandler(Long custId) throws CustomerNotFoundException {
		throw new CustomerNotFoundException();
	}

	public String customerNotAddedHandler(Long custId) throws CustomerNotAddedException {
		throw new CustomerNotAddedException();
	}

	public String customerNotUpdatedHandler(Long custId) throws CustomerNotUpdatedException {
		throw new CustomerNotUpdatedException();
	}

	public String customerNotDeletedHandler(Long custId) throws CustomerNotDeletedException {
		throw new CustomerNotDeletedException();
	}

	public String statementNotFoundHandler(Long statementId) throws StatementNotFoundException {
		throw new StatementNotFoundException();
	}

	public String statementNotAddedHandler(Long statementId) throws StatementNotAddedException {
		throw new StatementNotAddedException();
	}

	public String statementNotUpdatedHandler(Long statementId) throws StatementNotUpdatedException {
		throw new StatementNotUpdatedException();
	}

	public String statementNotDeletedHandler(Long statementId) throws StatementNotDeletedException {
		throw new StatementNotDeletedException();
	}

	@Test
	void CustomerNotFoundHandler() {
		assertThrows(CustomerNotFoundException.class, () -> {
			customerNotFoundHandler((long) 34324);
		});
	}

	@Test
	void CustomerNotAddedHandler() {
		assertThrows(CustomerNotAddedException.class, () -> {
			customerNotAddedHandler((long) 3433);
		});
	}

	@Test
	void CustomerNotUpdatedHandler() {
		assertThrows(CustomerNotUpdatedException.class, () -> {
			customerNotUpdatedHandler((long) 3424);
		});
	}

	@Test
	void CustomerNotDeletedHandler() {
		assertThrows(CustomerNotDeletedException.class, () -> {
			customerNotDeletedHandler((long) 343784);
		});
	}

	@Test
	void StatementNotFoundHandler() {
		assertThrows(StatementNotFoundException.class, () -> {
			statementNotFoundHandler((long) 14343);
		});
	}

	@Test
	void StatementNotAddedHandler() {
		assertThrows(StatementNotAddedException.class, () -> {
			statementNotAddedHandler((long) 87899);
		});
	}

	@Test
	void StatementNotUpdatedHandler() {
		assertThrows(StatementNotUpdatedException.class, () -> {
			statementNotUpdatedHandler((long) 564);
		});
	}

	@Test
	void StatementNotDeletedHandler() {
		assertThrows(StatementNotDeletedException.class, () -> {
			statementNotDeletedHandler((long) 14534);
		});
	}

}
