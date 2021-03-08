package br.com.jeferson.transacoes.services.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeferson.transacoes.entities.Transactions;
import br.com.jeferson.transacoes.enums.OperationTypesEnum;
import br.com.jeferson.transacoes.repositories.TransactionsRepository;
import br.com.jeferson.transacoes.services.TransactionsService;

@Service
public class TransactionsServiceImpl implements TransactionsService{

	private static final Logger log = LoggerFactory.getLogger(TransactionsServiceImpl.class);
	
	@Autowired
	private TransactionsRepository transactionRepository;

	@Override
	public Transactions addTransaction(Transactions transaction) {
		log.info("Gravando transaction - account: " + transaction.getAccountId());
		
		if(!OperationTypesEnum.PAGAMENTO.operationType().equals(transaction.getOperationTypeId())) {
			transaction.setAmount(transaction.getAmount().negate());
		}
		transaction.setEventDate(new Date());
		
		return transactionRepository.save(transaction); 
	}
}
