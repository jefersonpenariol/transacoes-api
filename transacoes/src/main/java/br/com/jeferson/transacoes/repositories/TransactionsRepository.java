package br.com.jeferson.transacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeferson.transacoes.entities.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long>{
}
