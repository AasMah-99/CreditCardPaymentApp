package com.ccpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.ccpa.exception.AccountNotAddedException;
import com.ccpa.exception.AccountNotDeletedException;
import com.ccpa.exception.AccountNotFoundException;
import com.ccpa.exception.AccountNotUpdatedException;
import com.ccpa.model.Account;
import com.ccpa.service.AccountService;

@SpringBootTest(classes = CreditcardpayementappApplication.class)
@Transactional
@Rollback(true)
public class AccountTest {
	
	@Autowired
	private AccountService accountService;
	
	public Account addAccount() throws AccountNotAddedException {
		Account account = new Account();
		account.setAccountName("Himanshi Gupta");
		account.setAccountType("Savings");
		account.setBalance(230000.00);
		
		Long id =  accountService.addAccount(account).getAccountId();
		return accountService.addAccount(account);
	}
    //Test case for add account
	@Test
	 void testAddAccount() throws AccountNotAddedException {
		Account account = addAccount();	
		assertEquals("Himanshi Gupta", account.getAccountName());
		assertEquals("Savings", account.getAccountType());
		assertEquals(230000.00, account.getBalance());
			
		}	
	
	//Test case for update account
			@Test
			void testUpdateAccount() throws AccountNotAddedException, AccountNotUpdatedException {
				Account account = addAccount();
				account.setAccountName("Divesh Ojha");
				accountService.updateAccount(account.getAccountId(), account);
				assertEquals("Divesh Ojha", account.getAccountName());
			}
	

	//Test case for delete customer
	@Test
	void testDeleteAccount() throws AccountNotAddedException, AccountNotDeletedException {
		Account account = addAccount();
		Long accountId=account.getAccountId();
		accountService.removeAccount(account.getAccountId());
		assertThrows(AccountNotFoundException.class, () -> {
			accountService.getAccount(accountId);
			});
	}
	
	//Test case for getting all customers
			@Test
			void testGetAllAccounts() throws AccountNotAddedException{
			Account account = addAccount();
				accountService.getAllAccounts();
				assertEquals("Himanshi Gupta", account.getAccountName());
				assertEquals("Savings", account.getAccountType());
				assertEquals(230000.0, account.getBalance());
			}

			
}
