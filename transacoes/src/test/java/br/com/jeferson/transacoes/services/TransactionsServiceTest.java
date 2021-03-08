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
	Transactions transaction = new Transactions();
	
	@Test
	public void testAddTransaction() {
		transaction.setAccountId(1233456L);
		transaction.setAccountId(2L);
		transaction.setOperationTypeId("1");
		transaction.setAmount(BigDecimal.ONE);
		
		BDDMockito.given(transactionRepository.save(Mockito.any(Transactions.class))).willReturn(new Transactions());
		Transactions transac = this.transactionService.addTransaction(transaction);
		
		assertNotNull(transac);
	}
	
	@Test
	public void testAddTransactionInvalidOperationType() {
		transaction.setAccountId(1233456L);
		transaction.setAccountId(2L);
		transaction.setOperationTypeId("5");
		transaction.setAmount(BigDecimal.ONE);
		
		BDDMockito.given(transactionRepository.save(Mockito.any(Transactions.class))).willReturn(new Transactions());
		Transactions transac = this.transactionService.addTransaction(transaction);
		
		assertNotNull(transac);
	}
	
}
