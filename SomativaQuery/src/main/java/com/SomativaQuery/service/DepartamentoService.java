package com.SomativaQuery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SomativaQuery.entities.Departamento;
import com.SomativaQuery.repository.DepartementoRepository;
@Service
public class DepartamentoService {
	private final DepartementoRepository departamentoRepository;
	
	@Autowired
	public DepartamentoService(DepartementoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	public List<Departamento> getAllDepartamento() {
		return departamentoRepository.findAll();
	}

	public Departamento getDepartamentoById(Long id) {
		Optional<Departamento> Departamento = departamentoRepository.findById(id);
		return Departamento.orElse(null);
	}
	//Query Method
	public List<Departamento> getDepartamentoPorNome(String nome){
		return departamentoRepository.findByNome(nome);
	}

	public Departamento salvarDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	public Departamento updateDepartamento(Long id, Departamento updatedDepartamento) {
		Optional<Departamento> existingDepartamento = departamentoRepository.findById(id);
		if (existingDepartamento.isPresent()) {
			updatedDepartamento.setId(id);
			return departamentoRepository.save(updatedDepartamento);
		}
		return null;
	}

	public boolean deleteDepartamento(Long id) {
		Optional<Departamento> existingDepartamento = departamentoRepository.findById(id);
		if (existingDepartamento.isPresent()) {
			departamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}



}
