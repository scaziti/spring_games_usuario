package com.games.usuario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.games.usuario.model.GamesUsuarioModel;

public interface GamesUsuarioRepository extends JpaRepository<GamesUsuarioModel, Long>
{
	public List<GamesUsuarioModel> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
}
