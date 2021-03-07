package br.com.jeferson.transacoes.enums;

public enum OperationTypesEnum {
	COMPRA_A_VISTA("1"),
	COMPRA_PARCELADA("2"),
	SAQUE("3"),
	PAGAMENTO("4");
	
	private String tipoOperacao;
	
	private OperationTypesEnum(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public String tipoOperacao() {
		return tipoOperacao;
	}	
	
}
