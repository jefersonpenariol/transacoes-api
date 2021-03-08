package br.com.jeferson.transacoes.util;

import br.com.jeferson.transacoes.enums.OperationTypesEnum;

public class TransactionUtil {

	public static Boolean isValidTOperationType(String operationType) {
		for (OperationTypesEnum operationTypeEnum : OperationTypesEnum.values()) {
			if (operationTypeEnum.operationType().equals(operationType)) {
				return true;
			}
		}
		return false;
	}

}
