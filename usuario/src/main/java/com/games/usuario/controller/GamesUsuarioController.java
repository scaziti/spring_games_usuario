package com.games.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.games.usuario.model.GamesUsuarioModel;
import com.games.usuario.repository.GamesUsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class GamesUsuarioController 
{
	@Autowired
	public GamesUsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<GamesUsuarioModel>> GetAll()
	{
		return ResponseEntity.ok(this.repository.findAll());
	}
}
