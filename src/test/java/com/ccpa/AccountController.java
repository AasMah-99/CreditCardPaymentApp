package com.ccpa;

/*import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;*/
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

public class AccountController {

	@Autowired
	MockMvc mvc;

	@Test
	void testGetAccount() {
		try {
			mvc.perform(get("/account/getaAccountById/{accountId}")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllAccount() {
		try {
			mvc.perform(get("/account/getAllAccounts")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRemoveAccount() {
		try {
			mvc.perform(delete("/account/removeAccount/{id}")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateAccount() {
		try {
			mvc.perform(put("/account/updateAccount/{id}")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testAddAccount() {
		try {
			mvc.perform(post("/account/addAccount")).andExpect(status().isCreated())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

