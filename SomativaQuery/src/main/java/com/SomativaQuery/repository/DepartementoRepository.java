package com.SomativaQuery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SomativaQuery.entities.Departamento;

public interface DepartementoRepository extends JpaRepository<Departamento, Long>{
	List<Departamento> findByNome(String nome);

}
