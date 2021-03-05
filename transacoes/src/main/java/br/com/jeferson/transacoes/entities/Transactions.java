package br.com.jeferson.transacoes.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {

	@Id
	@Column(name = "TRANSACTION_ID")
	private Long transactionId;
	
	@Column(name = "ACCOUNT_ID", nullable = false)
	private Long accountId;
	
	@Column(name = "OPERATION_TYPE_ID", nullable = false)
	private String operationTypeId;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@Column(name = "EVENT_DATE")
	private Date eventDate;
	
	
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getOperationTypeId() {
		return operationTypeId;
	}
	public void setOperationTypeId(String operationTypeId) {
		this.operationTypeId = operationTypeId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
}
