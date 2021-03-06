package br.com.jeferson.transacoes.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ACCOUNTS")
@SequenceGenerator(name="ACC_SEQ", sequenceName="ACCOUNTS_SEQ", initialValue = 1, allocationSize = 1)
public class Accounts {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ACC_SEQ")
	@JsonProperty("account_id")
	private Long accountId;
	
	@Column(name = "DOCUMENT_NUMBER", length = 11, nullable = false)
	@JsonProperty("document_number")
	private String documentNumber;
	
	@OneToMany(mappedBy = "accountId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Transactions> transactions;
	
	@Column(name = "AVAILABLE_CREDIT_LIMIT")
	@JsonProperty("available_credit_limit")
	private BigDecimal availableCreditLimit;
	
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	
	public List<Transactions> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	public BigDecimal getAvailableCreditLimit() {
		return availableCreditLimit;
	}
	
	public void setAvailableCreditLimit(BigDecimal availableCreditLimit) {
		this.availableCreditLimit = availableCreditLimit;
	}
	
}
