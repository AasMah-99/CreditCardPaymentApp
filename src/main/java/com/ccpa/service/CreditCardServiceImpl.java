package com.ccpa.service;

import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;

import com.ccpa.repository.*;
import com.ccpa.model.*;
import com.ccpa.exception.CreditCardNotAddedException;
import com.ccpa.exception.CreditCardNotDeletedException;
import com.ccpa.exception.CreditCardNotFoundException;
import com.ccpa.exception.CreditCardNotUpdatedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	CreditCardRepository creditCardRepository;

	// Function to ADD credit card details with required Exceptions
	@Override
	public CreditCard addCreditCard(CreditCard creditCard) throws CreditCardNotAddedException {

		if (Objects.isNull(creditCard))
			throw new CreditCardNotAddedException("Credit card is not Added!");
		return creditCardRepository.save(creditCard);
	}

	// Function to DELETE credit card details with required Exceptions
	@Override
	public CreditCard removeCreditCard(Long cardId) throws CreditCardNotDeletedException {

		creditCardRepository.deleteById(cardId);
		if (creditCardRepository.existsById(cardId)) {
			throw new CreditCardNotDeletedException("Error Deleting Credit Card");
		}
		return null;

	}

	// Function to UPDATE credit card details with required Exceptions
	@Override
	public CreditCard updateCreditCard(Long cardId, CreditCard card) throws CreditCardNotUpdatedException {

		if (creditCardRepository.existsById(cardId)) {
			CreditCard creditcard = creditCardRepository.save(card);
			if (creditcard != null) {
				return null;
			}
		}
		throw new CreditCardNotUpdatedException("error updating Credit Card");
	}

	// Function to FIND credit card with "cardId" details with required Exceptions
	@Override
	public CreditCard getCreditCard(Long cardId) throws CreditCardNotFoundException {

		if (cardId == null) {
			throw new CreditCardNotFoundException("Card Id cannot be Null");
		} else if (!creditCardRepository.existsById(cardId)) {
			throw new CreditCardNotFoundException("Credit Card with Card Id " + cardId + " Does not Exists");
		}
		return creditCardRepository.findById(cardId).orElse(null);

	}

	// Function to GET ALL credit cards from database
	@Override
	public List<CreditCard> getAllCreditCard() {

		return creditCardRepository.findAll();
	}

}
