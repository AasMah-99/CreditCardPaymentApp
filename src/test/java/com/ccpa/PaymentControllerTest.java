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

class PaymentControllerTest {

	@Autowired
	MockMvc mockMvc;

	
	@Test
	void testGetPaymentById() {
		
		try {
			mockMvc.perform(get("/payment/getPayment/{paymentId}")).andExpect(status().isFound())
			.andExpectAll(content().contentType(MediaType.APPLICATION_JSON));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testAddPayment() {
		
		try {
			mockMvc.perform(post("/payment/addPayment")).andExpect(status().isCreated())
			.andExpectAll(content().contentType(MediaType.APPLICATION_JSON));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testUpdatePayment() {
		
		try {
			mockMvc.perform(put("/payment/updatePayment/{paymentId}")).andExpect(status().isOk())
			.andExpectAll(content().contentType(MediaType.APPLICATION_JSON));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testDeletePayment() {
		
		try {
			mockMvc.perform(delete("/payment/deletePayment/{paymentId}")).andExpect(status().isOk())
			.andExpectAll(content().contentType(MediaType.APPLICATION_JSON));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
