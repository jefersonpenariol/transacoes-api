package br.com.jeferson.transacoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jeferson.transacoes.entities.Accounts;
import br.com.jeferson.transacoes.services.AccountsService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountsService accountService;
	
	@PostMapping("/api/accounts")
	public ResponseEntity<Accounts> criarConta(@RequestBody Accounts conta){
		Accounts novaConta = accountService.gravar(conta);
		return ResponseEntity.ok(novaConta);
	}

}
