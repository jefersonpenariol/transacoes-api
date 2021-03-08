package br.com.jeferson.transacoes.enums;

public enum OperationTypesEnum {
	COMPRA_A_VISTA("1"),
	COMPRA_PARCELADA("2"),
	SAQUE("3"),
	PAGAMENTO("4");
	
	private String operationType;
	
	private OperationTypesEnum(String operationType) {
		this.operationType = operationType;
	}

	public String operationType() {
		return operationType;
	}	
	
}
