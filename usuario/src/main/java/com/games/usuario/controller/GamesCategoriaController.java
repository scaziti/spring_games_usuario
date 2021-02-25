package com.games.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.games.usuario.model.GamesCategoriaModel;
import com.games.usuario.repository.GamesCategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class GamesCategoriaController 
{
	@Autowired
	public GamesCategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<GamesCategoriaModel>> GetAll()
	{
		return ResponseEntity.ok(this.repository.findAll());
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<GamesCategoriaModel> GetById(@PathVariable long idCategoria)
	{
		return this.repository.findById(idCategoria)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomecategoria/{nomeCategoria}")
	public ResponseEntity<List<GamesCategoriaModel>> GetByNome(@PathVariable String nomeCategoria)
	{
		return ResponseEntity.ok(this.repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
	
	@PostMapping
	public ResponseEntity<GamesCategoriaModel> post(@RequestBody GamesCategoriaModel categoria)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<GamesCategoriaModel> put(@RequestBody GamesCategoriaModel categoria)
	{
		return ResponseEntity.status(HttpStatus.OK).body(this.repository.save(categoria));
	}
}
