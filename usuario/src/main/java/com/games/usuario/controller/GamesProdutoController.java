package com.games.usuario.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.games.usuario.model.GamesProdutosModel;
import com.games.usuario.repository.GamesProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class GamesProdutoController 
{
	@Autowired
	public GamesProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<GamesProdutosModel>> GetAll()
	{
		return ResponseEntity.ok(this.repository.findAll());
	}
	
}
