package com.games.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
