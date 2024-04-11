package com.SomativaQuery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SomativaQuery.entities.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long>{
	List<Dependente> findByNome(String nome);

}
