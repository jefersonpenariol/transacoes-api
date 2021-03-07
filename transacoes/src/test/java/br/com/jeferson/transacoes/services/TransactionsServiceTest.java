package br.com.jeferson.transacoes.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jeferson.transacoes.entities.Transactions;
import br.com.jeferson.transacoes.repositories.TransactionsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionsServiceTest {

	@Autowired
	private TransactionsService transactionService;

	@MockBean
	private TransactionsRepository transactionRepository;
	Transactions transacao = new Transactions();
	
	@Test
	public void testGravar() {
		transacao.setAccountId(1233456L);
		transacao.setAccountId(2L);
		transacao.setOperationTypeId("1");
		transacao.setAmount(BigDecimal.ONE);
		
		BDDMockito.given(transactionRepository.save(Mockito.any(Transactions.class))).willReturn(new Transactions());
		Transactions transac = this.transactionService.gravar(transacao);
		
		assertNotNull(transac);
	}
	
	@Test
	public void testGravarTipoOperacaoInvalido() {
		transacao.setAccountId(1233456L);
		transacao.setAccountId(2L);
		transacao.setOperationTypeId("5");
		transacao.setAmount(BigDecimal.ONE);
		
		BDDMockito.given(transactionRepository.save(Mockito.any(Transactions.class))).willReturn(new Transactions());
		Transactions transac = this.transactionService.gravar(transacao);
		
		assertNotNull(transac);
	}
	
}
