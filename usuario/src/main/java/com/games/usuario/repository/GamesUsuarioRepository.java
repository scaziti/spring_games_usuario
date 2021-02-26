package com.games.usuario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.usuario.model.GamesUsuarioModel;

@Repository
public interface GamesUsuarioRepository extends JpaRepository<GamesUsuarioModel, Long>
{
	public List<GamesUsuarioModel> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
}
