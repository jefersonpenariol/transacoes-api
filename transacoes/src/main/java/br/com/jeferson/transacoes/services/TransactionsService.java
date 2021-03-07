package br.com.jeferson.transacoes.services;

import br.com.jeferson.transacoes.entities.Transactions;

public interface TransactionsService {

	/**
	 * Persiste uma transação na base de dados.
	 * 
	 * @param Transactions
	 * @return Transactions
	 */
	Transactions gravar(Transactions transacao);
	
}
