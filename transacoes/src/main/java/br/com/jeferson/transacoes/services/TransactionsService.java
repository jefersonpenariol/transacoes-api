package br.com.jeferson.transacoes.services;

import br.com.jeferson.transacoes.entities.Transactions;

public interface TransactionsService {

	/**
	 * Persiste uma transa��o na base de dados.
	 * 
	 * @param Transactions
	 * @return Transactions
	 */
	Transactions gravar(Transactions transacao);
	
}
