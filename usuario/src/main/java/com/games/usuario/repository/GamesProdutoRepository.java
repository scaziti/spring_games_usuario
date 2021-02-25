package com.games.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.usuario.model.GamesProdutosModel;

public interface GamesProdutoRepository extends JpaRepository<GamesProdutosModel, Long>
{
	public List<GamesProdutosModel> findByDescricaoProdutoContainingIgnoreCase(String descricaoProduto);
}
