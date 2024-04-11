package com.SomativaQuery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SomativaQuery.entities.Dependente;
import com.SomativaQuery.service.DependenteService;

@RestController
@RequestMapping("/dependente")
public class DependenteController {
	private final DependenteService DependenteService;
	@Autowired
	public DependenteController(DependenteService DependenteService) {
		this.DependenteService = DependenteService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dependente> getDependenteById(@PathVariable Long id) {
		Dependente Dependente = DependenteService.getDependenteById(id);
		if (Dependente != null) {
			return ResponseEntity.ok(Dependente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Dependente>> getAllDependente() {
		List<Dependente> Dependente = DependenteService.getAllDependente();
		return ResponseEntity.ok(Dependente);
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Dependente>> getDependentePorNome(@PathVariable String nome) {
		List<Dependente> Dependente = DependenteService.getDependentesPorNome(nome);
		return ResponseEntity.ok(Dependente);
	}

	@PostMapping("/")
	public ResponseEntity<Dependente> criarDependente(@RequestBody Dependente Dependente) {
		Dependente criarDependente = DependenteService.salvarDependente(Dependente);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarDependente);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Dependente> updateDependente(@PathVariable Long id,@RequestBody Dependente Dependente) {
		Dependente updatedDependente = DependenteService.updateDependente(id, Dependente);
		if (updatedDependente != null) {
			return ResponseEntity.ok(updatedDependente);
		} else {

			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDependente(@PathVariable Long id) {
		boolean deleted = DependenteService.deleteDependente(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Dependente foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}


