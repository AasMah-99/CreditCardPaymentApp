package com.ccpa;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

class TransactionControllerTest {
	
	@Autowired
	MockMvc mockMvc;

	@Test
	void testGetAllTransaction() {
		try {
			mockMvc.perform(get("/transaction/getAllTransactions"))
			.andExpect(status().isFound())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetTransactionById() {
		
		try {
			mockMvc.perform(get("/transaction/getTransaction/{transactionId}")).andExpect(status().isFound())
			.andExpectAll(content().contentType(MediaType.APPLICATION_JSON));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testAddTransaction() {
		
		try {
			mockMvc.perform(post("/transaction/addTransaction")).andExpect(status().isCreated())
			.andExpectAll(content().contentType(MediaType.APPLICATION_JSON));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testUpdateTransaction() {
		
		try {
			mockMvc.perform(put("/transaction/updateTransaction/{transactionId}")).andExpect(status().isOk())
			.andExpectAll(content().contentType(MediaType.APPLICATION_JSON));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testDeleteTransaction() {
		
		try {
			mockMvc.perform(delete("/transaction/deleteTransaction/{transactionId}")).andExpect(status().isOk())
			.andExpectAll(content().contentType(MediaType.APPLICATION_JSON));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
