package com.games.usuario.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{idProduto}")
	public ResponseEntity<GamesProdutosModel> GetByID(@PathVariable long idProduto)
	{
		return this.repository.findById(idProduto)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricaoProduto}")
	public ResponseEntity<List<GamesProdutosModel>> GetByDescricao(@PathVariable String descricaoProduto)
	{
		return ResponseEntity.ok(this.repository.findAllByDescricaoProdutoContainingIgnoreCase(descricaoProduto));
	}
	
	@PostMapping
	public ResponseEntity<GamesProdutosModel> post(@RequestBody GamesProdutosModel produto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(produto));
	}
	
}
