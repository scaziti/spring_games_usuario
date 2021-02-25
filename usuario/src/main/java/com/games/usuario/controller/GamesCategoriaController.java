package com.games.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
