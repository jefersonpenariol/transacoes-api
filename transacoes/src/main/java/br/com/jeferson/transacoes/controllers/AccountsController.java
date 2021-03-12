package br.com.jeferson.transacoes.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.jeferson.transacoes.entities.Accounts;
import br.com.jeferson.transacoes.services.AccountsService;
import br.com.jeferson.transacoes.util.AccountsUtil;

@RestController
public class AccountsController {
	
	@Autowired
	private AccountsService accountService;

	
	@PostMapping("/api/accounts")
	public ResponseEntity<Accounts> addAccount(@RequestBody Accounts account){
		
		if(!AccountsUtil.isValidDocumentNumber(account.getDocumentNumber())){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid document number. Document Number: " + account.getDocumentNumber());
		}
		
		if(account.getAvailableCreditLimit().compareTo(BigDecimal.ZERO) <= 0 ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid account limit. Document Number: " + account.getDocumentNumber());
		}
		
		return ResponseEntity.ok(accountService.addAccount(account));
	}
	
	@GetMapping("/api/accounts/{account_id}")
	public ResponseEntity<Accounts> findAccountById(@PathVariable("account_id") Long accountId){
		Accounts conta = accountService.findById(accountId);
		if(conta == null) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found. Account: " + accountId);
		}
		
		return ResponseEntity.ok(conta);					
	}
}
