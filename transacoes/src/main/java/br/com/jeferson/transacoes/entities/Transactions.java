package br.com.jeferson.transacoes.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TRANSACTIONS")
@SequenceGenerator(name="TRANSAC_SEQ", sequenceName="TRANSACTIONS_SEQ", initialValue = 1, allocationSize = 1)
public class Transactions {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TRANSAC_SEQ")
	@JsonProperty("transaction_id")
	private Long transactionId;
	
	@Column(name = "ACCOUNT_ID", nullable = false)
	@JsonProperty("account_id")
	private Long accountId;
	
	@Column(name = "OPERATION_TYPE_ID", length = 1, nullable = false)
	@JsonProperty("operation_type_id")
	private String operationTypeId;
	
	@Column(name = "AMOUNT")
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@Column(name = "EVENT_DATE")
	@JsonProperty("event_date")
	private Date eventDate;
	
	@Column(name = "BALANCE")
	@JsonProperty("balance")
	private BigDecimal balance;
	
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
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
}
