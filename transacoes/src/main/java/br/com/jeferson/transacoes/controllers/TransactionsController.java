package br.com.jeferson.transacoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.jeferson.transacoes.entities.Transactions;
import br.com.jeferson.transacoes.services.AccountsService;
import br.com.jeferson.transacoes.services.TransactionsService;
import br.com.jeferson.transacoes.util.TransactionsUtil;

@RestController
public class TransactionsController {
	
	@Autowired
	private TransactionsService transactionService;
	
	@Autowired
	private AccountsService accountService;
	
	@PostMapping("/api/transactions")
	public ResponseEntity<Transactions> addTransaction(@RequestBody Transactions transaction){
		
		if(transaction.getAccountId() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account ID is not present.");
		}
		
		if(!TransactionsUtil.isValidTOperationType(transaction.getOperationTypeId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid operation type. " + transaction.getOperationTypeId());				
		}
		
		if(!hasAccount(transaction.getAccountId())) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found. Account: " + transaction.getAccountId());
		}
		
		return ResponseEntity.ok(transactionService.addTransaction(transaction));
	}
	
	private Boolean hasAccount(Long accountId) {
		return accountService.findById(accountId) != null;
	}
}
