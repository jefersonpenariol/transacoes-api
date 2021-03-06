package br.com.jeferson.transacoes.enums;

public enum OperationTypesEnum {
	COMPRA_A_VISTA("1"),
	COMPRA_PARCELADA("2"),
	SAQUE("3"),
	PAGAMENTO("4");
	
	private String tipoPagamento;
	
	private OperationTypesEnum(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	
}
