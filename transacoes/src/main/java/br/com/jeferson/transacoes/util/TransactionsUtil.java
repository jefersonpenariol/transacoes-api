package br.com.jeferson.transacoes.util;

import br.com.jeferson.transacoes.enums.OperationTypesEnum;

public class TransactionsUtil {
	/**
	 * Validate Operation Type
	 * @param operationType
	 */
	public static Boolean isValidTOperationType(String operationType) {
		for (OperationTypesEnum operationTypeEnum : OperationTypesEnum.values()) {
			if (operationTypeEnum.operationType().equals(operationType)) {
				return true;
			}
		}
		return false;
	}
}
