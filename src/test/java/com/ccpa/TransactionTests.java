package com.ccpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ccpa.controller.TransactionController;
import com.ccpa.exception.TransactionNotAddException;
import com.ccpa.exception.TransactionNotDeletedException;
import com.ccpa.exception.TransactionNotFoundException;
import com.ccpa.model.Transaction;
import com.ccpa.repository.TransactionRepository;
import com.ccpa.service.TransactionService;

@SpringBootTest(classes = CreditcardpayementappApplication.class)
@Transactional
@Rollback(true)
//@WebMvcTest(CreditcardpayementappApplication.class)
class TransactionTests {
	
	@Autowired
	TransactionService transactionService;
	
	TransactionRepository transactionRepository;
	
	public Transaction addTransaction() throws TransactionNotFoundException, TransactionNotAddException{
		Transaction transaction = new Transaction();
//		Transaction transaction2 = new Transaction();
//		Transaction transaction3 = new Transaction();
//		Transaction transaction1 = new Transaction("123456", LocalDate.of(2023, 03, 13), "Pending", 25000.00, "Online", "First Transaction");
//		Transaction transaction2 = new Transaction(2L,"123457", LocalDate.of(2023, 04, 14), "Payed", 26000.00, "Cash", "Second Transaction");
//		Transaction transaction3 = new Transaction(3L,"123458", LocalDate.of(2023, 05, 15), "Pending", 27000.00, "NFT", "Third Transaction");
		transaction.setCardNumber("123456");
		transaction.setStatus("Pending");
		transaction.setPaymentMethord("Online");
		transaction.setTranDate(LocalDate.of(2023, 03, 13));
		transaction.setAmount(25000.00);
		transaction.setDescription("first Transaction");
		
//		transaction2.setCardNumber("123457");
//		transaction2.setStatus("Pending");
//		transaction2.setPaymentMethord("Online");
//		transaction2.setTranDate(LocalDate.of(2023, 03, 13));
//		transaction2.setAmount(24000.00);
//		transaction2.setDescription("second Transaction");
//		
//		transaction3.setCardNumber("123458");
//		transaction3.setStatus("Pending");
//		transaction3.setPaymentMethord("Online");
//		transaction3.setTranDate(LocalDate.of(2023, 03, 13));
//		transaction3.setAmount(26000.00);
//		transaction3.setDescription("third Transaction");
		
		

		Long id = transactionService.addTranscation(transaction).getTranId();
		return transactionService.getTransactionDetails(id);
	}
	
//	@Test
//	public void testGetAllTransaction() throws Exception{
//		List<Transaction> trans = new ArrayList<>(Arrays.asList(transaction1,transaction2,transaction3));
//	    
//	    Mockito.when(transactionRepository.findAll()).thenReturn(trans);
//	    
//	    mockMvc.perform(MockMvcRequestBuilders
//	            .get("/transaction")
//	            .contentType(MediaType.APPLICATION_JSON))
//	            .andExpect(status().isOk())
//	            .andExpect(jsonPath("$", Matchers.hasSize(3)));
//		
//	}
		
	@Test
	void testAddTransaction() throws TransactionNotFoundException, TransactionNotAddException{
		Transaction transaction = addTransaction();
		assertEquals("123456", transaction.getCardNumber());
		assertEquals("Pending", transaction.getStatus());
		assertEquals("Online", transaction.getPaymentMethord());
		assertEquals(LocalDate.of(2023, 03, 13), transaction.getTranDate());
		assertEquals(25000.00, transaction.getAmount());
		assertEquals("first Transaction", transaction.getDescription());
		
	}
//	
//	@Test
//	void testDeleteTransaction() throws TransactionNotDeletedException, TransactionNotFoundException{
//		
//	}

}
