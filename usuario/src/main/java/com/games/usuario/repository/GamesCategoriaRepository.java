package com.games.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.usuario.model.GamesCategoriaModel;

@Repository
public interface GamesCategoriaRepository extends JpaRepository<GamesCategoriaModel, Long>
{
	public List<GamesCategoriaModel> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);
}
