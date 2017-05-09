package com.co.transactions.domain.transaction;

public class Transaction {

	private String transactionId;
	private String accountId;
	private String merchant;
	private boolean isPending;
	private String transactionTime;
	private double amount;
	private String previousTransactionId;
	private String categorization;
	private String clearDate;
	
	public Transaction(){
		super();
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public boolean isPending() {
		return isPending;
	}
	public void setPending(boolean isPending) {
		this.isPending = isPending;
	}
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPreviousTransactionId() {
		return previousTransactionId;
	}
	public void setPreviousTransactionId(String previousTransactionId) {
		this.previousTransactionId = previousTransactionId;
	}
	public String getCategorization() {
		return categorization;
	}
	public void setCategorization(String categorization) {
		this.categorization = categorization;
	}
	public String getClearDate() {
		return clearDate;
	}
	public void setClearDate(String clearDate) {
		this.clearDate = clearDate;
	}
}
