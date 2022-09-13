package com.ccpa.service;

import java.util.List;

import com.ccpa.model.CreditCard;
import com.ccpa.exception.CreditCardNotAddedException;
import com.ccpa.exception.CreditCardNotDeletedException;
import com.ccpa.exception.CreditCardNotFoundException;
import com.ccpa.exception.CreditCardNotUpdatedException;

public interface CreditCardService {

	public CreditCard addCreditCard(CreditCard creditCard) throws CreditCardNotAddedException;

	public CreditCard removeCreditCard(Long cardId) throws CreditCardNotDeletedException;

	public CreditCard updateCreditCard(Long cardId, CreditCard card) throws CreditCardNotUpdatedException;

	public CreditCard getCreditCard(Long cardId) throws CreditCardNotFoundException;

	public List<CreditCard> getAllCreditCards();

}
