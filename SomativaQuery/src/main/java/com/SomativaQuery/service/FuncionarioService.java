package com.SomativaQuery.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SomativaQuery.entities.Funcionario;
import com.SomativaQuery.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	public Funcionario getFuncionarioById(Long id) {
		Optional<Funcionario> Funcionario = funcionarioRepository.findById(id);
		return Funcionario.orElse(null);
	}
	//Query Method
	public List<Funcionario> getFuncionariosPorNome(String nome){
		return funcionarioRepository.findByNome(nome);
	}
	//Query Method
	public List<Funcionario> getFuncionariosPorNomeESalario(String nome, BigDecimal salario){
		return funcionarioRepository.findByNomeAndSalario(nome, salario);
	}

	public Funcionario salvarFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario updateFuncionario(Long id, Funcionario updatedFuncionario) {
		Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(id);
		if (existingFuncionario.isPresent()) {
			updatedFuncionario.setId(id);
			return funcionarioRepository.save(updatedFuncionario);
		}
		return null;
	}

	public boolean deleteFuncionario(Long id) {
		Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(id);
		if (existingFuncionario.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		}
		return false;
	}



}


