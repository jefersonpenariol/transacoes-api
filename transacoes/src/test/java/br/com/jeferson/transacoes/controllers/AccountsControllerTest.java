package br.com.jeferson.transacoes.controllers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jeferson.transacoes.entities.Accounts;
import br.com.jeferson.transacoes.repositories.AccountRepository;
import br.com.jeferson.transacoes.services.AccountsService;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountsController.class)
public class AccountsControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	
	private AccountsService accountsService;

	@MockBean
	private AccountRepository accountRepository;
	
	private Accounts account = new Accounts();
	
	private static final Long ACCOUNT_ID = 123L;
	
	@Test
	public void testCriarConta() throws JsonProcessingException, Exception{
		ObjectMapper mapper = new ObjectMapper();
		BDDMockito.given(this.accountsService.addAccount(Mockito.any(Accounts.class))).willReturn(new Accounts());
		mvc.perform(post("/api/accounts")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(account)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testConsultarConta() throws JsonProcessingException, Exception {	
		BDDMockito.given(accountsService.findById(Mockito.anyLong())).willReturn(account);
		
		 mvc.perform(get("/api/accounts/" + ACCOUNT_ID)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	}

	@Test
	public void testConsultarContaContaInexistente() throws JsonProcessingException, Exception {	
		BDDMockito.given(accountsService.findById(456L))
			.willThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta n�o Encontrada"));
		
		 mvc.perform(get("/api/accounts/" + ACCOUNT_ID)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound());
	}
	
}
