package br.com.jeferson.transacoes.util;

import br.com.jeferson.transacoes.enums.OperationTypesEnum;

public class TransactionUtil {

	public static Boolean isValidTipoOperacao(String tipoOperacao) {
		for (OperationTypesEnum TipoOperacaoEnum : OperationTypesEnum.values()) {
			if (TipoOperacaoEnum.tipoOperacao().equals(tipoOperacao)) {
				return true;
			}
		}
		return false;
	}

}
