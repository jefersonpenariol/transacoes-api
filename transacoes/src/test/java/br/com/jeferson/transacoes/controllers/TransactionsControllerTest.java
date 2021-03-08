package br.com.jeferson.transacoes.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jeferson.transacoes.entities.Accounts;
import br.com.jeferson.transacoes.entities.Transactions;
import br.com.jeferson.transacoes.repositories.TransactionsRepository;
import br.com.jeferson.transacoes.services.AccountsService;
import br.com.jeferson.transacoes.services.TransactionsService;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionsController.class)
public class TransactionsControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TransactionsService transactionService;

	@MockBean
	private AccountsService accountService;
	
	@MockBean
	private TransactionsRepository transactionRepository;
	
	private Transactions transaction = new Transactions();
	

	@Test
	public void testAddTransaction() throws JsonProcessingException, Exception {
		ObjectMapper mapper = new ObjectMapper();
		BDDMockito.given(accountService.findById(2L)).willReturn(new Accounts());
		
		transaction.setAccountId(1233456L);
		transaction.setAccountId(2L);
		transaction.setOperationTypeId("1");
		transaction.setAmount(BigDecimal.ONE);
	
		mvc.perform(post("/api/transactions")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(transaction)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testAddTransactionAccountIdNull() throws JsonProcessingException, Exception {
		ObjectMapper mapper = new ObjectMapper();
		transaction.setAccountId(1233456L);
		transaction.setAccountId(null);
		transaction.setOperationTypeId("1");
		transaction.setAmount(BigDecimal.ONE);
		
		mvc.perform(post("/api/transactions")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(transaction)))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testAddTransactionAccountIdNotFound() throws JsonProcessingException, Exception {		
		ObjectMapper mapper = new ObjectMapper();
		transaction.setAccountId(1233456L);
		transaction.setAccountId(2L);
		transaction.setOperationTypeId("1");
		transaction.setAmount(BigDecimal.ONE);
		
		mvc.perform(post("/api/transactions")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(transaction)))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void testAddTransactionInvalidOperationType() throws JsonProcessingException, Exception {
		ObjectMapper mapper = new ObjectMapper();
		transaction.setAccountId(1233456L);
		transaction.setAccountId(2L);
		transaction.setOperationTypeId("5");
		transaction.setAmount(BigDecimal.ONE);
		
		mvc.perform(post("/api/transactions")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(transaction)))
				.andExpect(status().isBadRequest());
	}
}

