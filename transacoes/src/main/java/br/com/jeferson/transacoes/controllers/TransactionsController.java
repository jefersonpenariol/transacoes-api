package br.com.jeferson.transacoes.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.jeferson.transacoes.entities.Accounts;
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
		
		if(!TransactionsUtil.isValidTOperationType(transaction.getOperationTypeId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid operation type. " + transaction.getOperationTypeId());				
		}
		
		if(transaction.getAccountId() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account ID is not present.");
		}
		
		Accounts account = accountService.findById(transaction.getAccountId());
		if(account == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found. Account: " + transaction.getAccountId());
		}
		
		BigDecimal amount = transaction.getAmount();
		if(transaction.getOperationTypeId().matches("1|2|3") && amount.compareTo(account.getAvailableCreditLimit()) > 0){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unavailable Limit - Limit " + account.getAvailableCreditLimit());
		}else {
			if(transaction.getOperationTypeId().matches("1|2|3")) {
				account.setAvailableCreditLimit(account.getAvailableCreditLimit().subtract(amount));
			}else {
				account.setAvailableCreditLimit(account.getAvailableCreditLimit().add(amount));
			}
			
			accountService.updateAccounts(account);
		}		
		
		if(transaction.getOperationTypeId().matches("4")) { //pagamento
			List<Transactions> transac = transactionService.findAll();
			BigDecimal amountRest = transaction.getAmount();
			for(Transactions transacao : transac) {	
				if(transaction.getOperationTypeId().matches("1|2|3") && amountRest.compareTo(BigDecimal.ZERO) > 0) {
					BigDecimal balance = transacao.getAmount().add(amountRest);
					
					transacao.setBalance(balance);
					amountRest = amountRest.subtract(transacao.getAmount());					
				}
			}
		}
		
		return ResponseEntity.ok(transactionService.addTransaction(transaction));
	}
	
}
