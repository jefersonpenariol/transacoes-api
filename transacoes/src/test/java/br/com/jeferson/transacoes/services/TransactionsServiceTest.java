package br.com.jeferson.transacoes.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jeferson.transacoes.entities.Transactions;
import br.com.jeferson.transacoes.enums.OperationTypesEnum;
import br.com.jeferson.transacoes.repositories.TransactionsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionsServiceTest {

	@Autowired
	private TransactionsService transactionService;

	@MockBean
	private TransactionsRepository transactionRepository;

	private Transactions transaction;
	
	@Before
	public void setUp() {
		transaction = new Transactions();
		transaction.setAccountId(12345678900L);
		transaction.setOperationTypeId(OperationTypesEnum.COMPRA_A_VISTA.getTipoPagamento());
		transaction.setAmount(BigDecimal.ONE);
	}
	
	@Test
	public void testGravar() {
		BDDMockito.given(this.transactionRepository.save(transaction)).willReturn(transaction);
		Transactions transac = this.transactionService.gravar(transaction);
		
		assertNotNull(transac);
	}
	
}
