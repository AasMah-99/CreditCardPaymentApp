package com.ccpa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

class CreditCardControllerTest {

	@Autowired
	MockMvc mvc;

	@Test
	void testGetCreditCard() {
		try {
			mvc.perform(get("/creditCard/getcreditCard/{cardId}")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllCreditCard() {
		try {
			mvc.perform(get("/creditCard/allCreditCardDetails")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testDeleteCreditCard() {
		try {
			mvc.perform(delete("/creditCard/deleteCreditCard/{cardId}")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateCreditCard() {
		try {
			mvc.perform(put("/creditCard/updateCreditCard/{cardId}")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testAddCreditCard() {
		try {
			mvc.perform(post("/creditCard/deleteCreditCard/{cardId}")).andExpect(status().isCreated())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
