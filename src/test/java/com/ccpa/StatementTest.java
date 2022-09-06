package com.ccpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.ccpa.exception.StatementNotAddedException;
import com.ccpa.exception.StatementNotDeletedException;
import com.ccpa.exception.StatementNotFoundException;
import com.ccpa.exception.StatementNotUpdatedException;
import com.ccpa.model.Statement;
import com.ccpa.repository.StatementRepository;
import com.ccpa.service.StatementService;

	@SpringBootTest(classes = CreditcardpayementappApplication.class)
	@Transactional
	@Rollback(true)
	class StatementTest {
		@Autowired
		private StatementService statementService;
		
		StatementRepository statementRepository;
		
		public Statement addStatement() throws StatementNotFoundException, StatementNotAddedException {
			Statement statement = new Statement();

			statement.setDueAmount(3223.30);
			statement.setBillingDate(LocalDate.of(2022, 9, 04));
			statement.setDueDate(LocalDate.of(2022, 9, 14));

			Long id = statementService.addStatement(statement).getStatementId();
			return statementService.getStatement(id);
		}
		
		//Test case for adding statement
			@Test
			void testAddStatement() throws StatementNotFoundException,StatementNotAddedException {
				Statement statement = addStatement();
				assertEquals(3223.30, statement.getDueAmount());
				assertEquals(LocalDate.of(2022, 9, 04), statement.getBillingDate());
				assertEquals(LocalDate.of(2022, 9, 14), statement.getDueDate());
			}
			
			//Test case for deleting statement
			@Test
			void testDeleteStatement() throws StatementNotAddedException, StatementNotFoundException, StatementNotDeletedException {
				Statement statement = addStatement();
				Long statementId=statement.getStatementId();
				statementService.removeStatement(statement.getStatementId());
				assertThrows(StatementNotFoundException.class, () -> {
					statementService.getStatement(statementId);
					});

			}
			
			//Test case for updating statement
			@Test
			void testUpdateStatement() throws StatementNotFoundException, StatementNotUpdatedException, StatementNotAddedException {
				Statement statement = addStatement();
				statement.setDueAmount(213.46);
				statementService.updateStatement(statement.getStatementId(), statement);
				assertEquals(213.46, statement.getDueAmount());
			}
			
			//Test case for getting statement by statementId
			@Test
			void testGetStatementById() throws StatementNotFoundException, StatementNotAddedException {
				Statement statement = addStatement();
				statementService.getStatement(statement.getStatementId());
				assertEquals(3223.30, statement.getDueAmount());
				assertEquals(LocalDate.of(2022, 9, 04), statement.getBillingDate());
				assertEquals(LocalDate.of(2022, 9, 14), statement.getDueDate());
			}
			
			//Test case for getting all statements
			@Test
			void testGetAllStatement() throws StatementNotFoundException, StatementNotAddedException {
				Statement statement = addStatement();
				statementService.getAllStatements();
				assertEquals(3223.30, statement.getDueAmount());
				assertEquals(LocalDate.of(2022, 9, 04), statement.getBillingDate());
				assertEquals(LocalDate.of(2022, 9, 14), statement.getDueDate());
			}
	}
