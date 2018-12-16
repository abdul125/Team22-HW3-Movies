package model;

import java.util.Date;

public class Transactions {
	private String cardHolderName;
	private String creditCardNumber;
	private double total;
	private String cardType;
	private String cvv;
	private String expirationDate;
	
	public Transactions(String cardHolderName, String creditCardNumber, double total, String cardType, String cvv,
			String expirationDate) {
		super();
		this.cardHolderName = cardHolderName;
		this.creditCardNumber = creditCardNumber;
		this.total = total;
		this.cardType = cardType;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	} 
}
