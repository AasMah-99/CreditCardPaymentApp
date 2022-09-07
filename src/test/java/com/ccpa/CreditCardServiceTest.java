package com.ccpa;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.ccpa.exception.CreditCardNotAddedException;
import com.ccpa.exception.CreditCardNotDeletedException;
import com.ccpa.exception.CreditCardNotFoundException;
import com.ccpa.exception.CreditCardNotUpdatedException;
import com.ccpa.model.CreditCard;
import com.ccpa.service.CreditCardService;

@SpringBootTest(classes = CreditcardpayementappApplication.class)
@Rollback(true)
class CreditCardServiceTest {

	@Autowired
	private CreditCardService creditCardService;

	public CreditCard addCreditCard() throws CreditCardNotAddedException, CreditCardNotFoundException {
		CreditCard creditCard = new CreditCard();
		creditCard.setCardName("Rohit");
		creditCard.setBankName("SBI");

		Long id = creditCardService.addCreditCard(creditCard).getId();
		return creditCardService.getCreditCard(id);
	}

	@Test
	void testAddCreditCard() throws CreditCardNotAddedException, CreditCardNotFoundException {
		CreditCard creditCard = addCreditCard();
		assertEquals("Rohit", creditCard.getCardName());
		assertEquals("SBI", creditCard.getBankName());

	}

	@Test
	void testGetCreditCard()
			throws CreditCardNotAddedException, CreditCardNotFoundException, CreditCardNotUpdatedException {

		CreditCard card = creditCardService.getCreditCard(3L);
		assertEquals("Rinita", card.getCardName());

	}
	
	@Test
	void testDeleteCreditCard() throws CreditCardNotAddedException, CreditCardNotFoundException, CreditCardNotDeletedException {
		CreditCard card = addCreditCard();
		Long cardId=card.getId();
		creditCardService.removeCreditCard(card.getId());
		assertThrows(CreditCardNotFoundException.class, () -> {
			creditCardService.getCreditCard(cardId);
			});

	}

}
