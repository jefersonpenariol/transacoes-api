package br.com.jeferson.transacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeferson.transacoes.entities.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Long>{
	
	Accounts findByAccountId(Long id);
}
