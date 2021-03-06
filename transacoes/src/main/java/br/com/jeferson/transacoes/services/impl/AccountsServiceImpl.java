package br.com.jeferson.transacoes.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeferson.transacoes.entities.Accounts;
import br.com.jeferson.transacoes.repositories.AccountRepository;
import br.com.jeferson.transacoes.services.AccountsService;

@Service
public class AccountsServiceImpl implements AccountsService{

	private static final Logger log = LoggerFactory.getLogger(AccountsServiceImpl.class);
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Accounts gravar(Accounts account) {
		log.info("Gravando account - Documento: " + account.getDocumentNumber());
		
		return accountRepository.save(account);
	}

	@Override
	public Accounts buscarPorId(Long accountId) {
		log.info("Buscando account - Id: " + accountId.toString());
		
		return accountRepository.findByAccountId(accountId);
	}
		
}
