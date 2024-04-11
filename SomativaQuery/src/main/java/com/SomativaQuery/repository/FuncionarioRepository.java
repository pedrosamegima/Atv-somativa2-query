package com.SomativaQuery.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SomativaQuery.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	List<Funcionario> findByNome(String nome);
	List<Funcionario> findByNomeAndSalario(String nome, BigDecimal salario);

}
