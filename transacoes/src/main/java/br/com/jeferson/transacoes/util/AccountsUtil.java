package br.com.jeferson.transacoes.util;

public class AccountsUtil {
	/**
	 * Validate Account document number
	 * @param documentoNumber
	 */
	public static Boolean isValidDocumentNumber(String documentNumber) {
		if(documentNumber == null || documentNumber.length() != 11) {
			return false;
		}
		
		try {
			Long.parseLong(documentNumber);
		}catch( java.lang.NumberFormatException ex) {
			return false;
		}
		
		return true;
	}
}
