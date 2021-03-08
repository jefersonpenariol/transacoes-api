package br.com.jeferson.transacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeferson.transacoes.entities.OperationTypes;

public interface OperationTypesRepository extends JpaRepository<OperationTypes, String>{

}
