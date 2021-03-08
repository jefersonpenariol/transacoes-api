package br.com.jeferson.transacoes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "OPERATION_TYPES")
public class OperationTypes {

	@Id
	@Column(name = "OPERATION_TYPE_ID", length = 1)
	@JsonProperty("operation_type_id")
	private String operationTypeId;
	
	@Column(name = "DESCRIPTION", length = 20)
	@JsonProperty("description")
	private String description;
	
	
	public String getOperationTypeId() {
		return operationTypeId;
	}
	public void setOperationTypeId(String operationTypeId) {
		this.operationTypeId = operationTypeId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
