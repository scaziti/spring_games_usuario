package com.games.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<GamesUsuarioModel> GetById(@PathVariable long idUsuario)
	{
		return repository.findById(idUsuario)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nomeUsuario}")
	public ResponseEntity<List<GamesUsuarioModel>> GetByNome(@PathVariable String nomeUsuario)
	{
		return ResponseEntity.ok(this.repository.findAllByNomeUsuarioContainingIgnoreCase(nomeUsuario));
	}
	
	@PostMapping
	public ResponseEntity<GamesUsuarioModel> post(@RequestBody GamesUsuarioModel usuario)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(usuario));
	}
	
	@PutMapping
	public ResponseEntity<GamesUsuarioModel> put(@RequestBody GamesUsuarioModel usuario)
	{
		return ResponseEntity.status(HttpStatus.OK).body(this.repository.save(usuario));
	}
	
	@DeleteMapping("/{idUsuario}")
	public void delete(@PathVariable long idUsuario)
	{
		this.repository.deleteById(idUsuario);
	}
}
