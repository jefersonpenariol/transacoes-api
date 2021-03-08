package br.com.jeferson.transacoes.services;

import br.com.jeferson.transacoes.entities.Accounts;

public interface AccountsService {
	
	/**
	 * Persiste uma conta na base de dados.
	 * 
	 * @param Accounts
	 * @return Accounts
	 */
	Accounts addAccount(Accounts account);

	/**
	 * Busca uma conta na base de dados por meio do Id da conta.
	 * 
	 * @param accountId
	 * @return Accounts
	 */
	Accounts findById(Long accountId);
}
