package br.com.jeferson.transacoes.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import br.com.jeferson.transacoes.entities.Accounts;
import br.com.jeferson.transacoes.repositories.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountsServiceTest {

	@Autowired
	private AccountsService accountsService;

	@MockBean
	private AccountRepository accountRepository;

	private static final Long NUMERO_DOCUMENTO = 12345678000L;

	@Test
	public void testBuscarPorId() {
		BDDMockito.given(this.accountRepository.findByAccountId(Mockito.anyLong())).willReturn(new Accounts());
		Accounts acc = this.accountsService.buscarPorId(NUMERO_DOCUMENTO);
		assertNotNull(acc);
	}
	@Test
	public void testBuscarPorIdInvalido() {
		BDDMockito.given(this.accountRepository.findByAccountId(456L)).willThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não Encontrada"));
		Accounts acc = this.accountsService.buscarPorId(NUMERO_DOCUMENTO);
		assertNull(acc);
	}
	
	@Test
	public void testGravar() {
		BDDMockito.given(this.accountRepository.save(Mockito.any(Accounts.class))).willReturn(new Accounts());
		Accounts acc = this.accountsService.gravar(new Accounts());

		assertNotNull(acc);
	}
}
