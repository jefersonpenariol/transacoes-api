package br.com.jeferson.transacoes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class Accounts {

	@Id
	@Column(name = "ACCOUNT_ID")
	private Long accountId;
	
	@Column(name = "DOCUMENT_NUMBER", nullable = false)
	private Long documentNumber;
	
	
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(Long documentNumber) {
		this.documentNumber = documentNumber;
	}
	
}
