package br.com.jeferson.transacoes.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jeferson.transacoes.entities.Accounts;
import br.com.jeferson.transacoes.repositories.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountsServiceTest {

	@Autowired
	private AccountsService accountsService;

	@MockBean
	private AccountRepository accountRepository;

	private Accounts account;
	
	private static final Long NUMERO_DOCUMENTO = 12345678000L;
	
	
	@Before
	public void setUp() {		
		account = new Accounts();
		account.setDocumentNumber(NUMERO_DOCUMENTO);
	}
	
	@Test
	public void testGravar() {
		BDDMockito.given(this.accountRepository.save(account)).willReturn(account);
		Accounts acc = this.accountsService.gravar(account);
		
		assertNotNull(acc);
	}

	@Test
	public void testBuscarPorId() {
		
		BDDMockito.given(accountRepository.findByAccountId(account.getAccountId())).willReturn(account);	
		Accounts acc = this.accountsService.buscarPorId(NUMERO_DOCUMENTO);
		
		assertNotNull(acc);
	}
}
