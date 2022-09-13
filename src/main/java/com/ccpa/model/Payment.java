package com.ccpa.model;
import javax.persistence.*;

@Entity                          
@Table(name = "payment")         
public class Payment {
	
	@Id                          
	@GeneratedValue              
	private Long paymentId;
	private String method;
	private Double amountDue;
	
	public Payment() {
	}

	public Payment(Long paymentId, String method, Double amountDue) {
		this.paymentId = paymentId;
		this.method = method;
		this.amountDue = amountDue;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(Double amountDue) {
		this.amountDue = amountDue;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", method=" + method + ", amountDue=" + amountDue + "]";
	}
}
