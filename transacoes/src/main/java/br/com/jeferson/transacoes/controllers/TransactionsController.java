package br.com.jeferson.transacoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.jeferson.transacoes.entities.Transactions;
import br.com.jeferson.transacoes.services.TransactionsService;
import br.com.jeferson.transacoes.util.TransactionUtil;

@RestController
public class TransactionsController {
	
	@Autowired
	private TransactionsService transactionService;
	
	@PostMapping("/api/transactions")
	public ResponseEntity<Transactions> criarTransacao(@RequestBody Transactions transacao){
		
		if(!TransactionUtil.isValidTipoOperacao(transacao.getOperationTypeId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de Opera��o Inv�lido.");				
		}
		
		return ResponseEntity.ok(transactionService.gravar(transacao));
	}

}
