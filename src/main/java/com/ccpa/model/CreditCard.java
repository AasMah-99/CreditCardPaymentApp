package com.ccpa.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "creditCard")

public class CreditCard {

	@Id
	@GeneratedValue
	private Long id;
	private String cardName;
	private String cardType;
	private String cardNumber;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private LocalDate expiryDate;
	private String bankName;

	public CreditCard() {

	}

	public CreditCard(Long id, String cardName, String cardType, String cardNumber, LocalDate expiryDate,
			String bankName) {
		this.id = id;
		this.cardName = cardName;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.bankName = bankName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", cardName=" + cardName + ", cardType=" + cardType + ", cardNumber="
				+ cardNumber + ", expiryDate=" + expiryDate + ", bankName=" + bankName + "]";
	}

}
