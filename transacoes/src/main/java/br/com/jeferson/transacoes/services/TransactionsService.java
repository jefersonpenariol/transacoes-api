package br.com.jeferson.transacoes.services;

import java.util.List;

import br.com.jeferson.transacoes.entities.Transactions;

public interface TransactionsService {

	/**
	 * Persiste uma transação na base de dados.
	 * 
	 * @param Transactions
	 * @return Transactions
	 */
	Transactions addTransaction(Transactions transaction);
	
	Transactions updateTransaction(Transactions transaction);
	
	List<Transactions> findAll();
}
