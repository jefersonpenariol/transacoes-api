package br.com.jeferson.transacoes.controllers;

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

@RestController
public class AccountsController {
	
	@Autowired
	private AccountsService accountService;

	
	@PostMapping("/api/accounts")
	public ResponseEntity<Accounts> criarConta(@RequestBody Accounts conta){
		return ResponseEntity.ok(accountService.gravar(conta));
	}
	
	@GetMapping("/api/accounts/{accountId}")
	public ResponseEntity<Accounts> consultarConta(@PathVariable("accountId") Long accountId){
		Accounts conta = accountService.buscarPorId(accountId);
		if(conta == null) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta n�o Encontrada");
		}
		
		return ResponseEntity.ok(conta);					
	}
}