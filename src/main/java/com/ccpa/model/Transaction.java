package com.ccpa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue
	private Long tranId;
	private String cardNumber;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate tranDate;
	private String status;
	private Double amount;
	private String paymentMethord;
	private String description;
	public Transaction() {
	}
	public Transaction(Long tranId, String cardNumber, LocalDate tranDate, String status, Double amount,String paymentMethord, String description) {
		this.tranId = tranId;
		this.cardNumber = cardNumber;
		this.tranDate = tranDate;
		this.status = status;
		this.amount = amount;
		this.paymentMethord = paymentMethord;
		this.description = description;
	}
	public Long getTranId() {
		return tranId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public LocalDate getTranDate() {
		return tranDate;
	}
	public String getStatus() {
		return status;
	}
	public Double getAmount() {
		return amount;
	}
	public String getPaymentMethord() {
		return paymentMethord;
	}
	public String getDescription() {
		return description;
	}
	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setTranDate(LocalDate tranDate) {
		this.tranDate = tranDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setPaymentMethord(String paymentMethord) {
		this.paymentMethord = paymentMethord;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Transaction [tranId=" + tranId + ", cardNumber=" + cardNumber + ", tranDate=" + tranDate + ", status="
				+ status + ", amount=" + amount + ", paymentMethord=" + paymentMethord + ", description=" + description
				+ "]";
	}
}
