package com.games.usuario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class GamesProdutosModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String descricaoProduto;
	
	@NotNull
	private Double precoProduto;
	
	@NotNull
	private Integer estoqueProduto;
	
	@NotNull
	private Boolean ativo;
	
	
	public Long getIdProduto()
	{
		return this.idProduto;
	}
	
	public void setIdProduto(Long idProduto)
	{
		this.idProduto = idProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Integer getEstoqueProduto() {
		return estoqueProduto;
	}

	public void setEstoqueProduto(Integer estoqueProduto) {
		this.estoqueProduto = estoqueProduto;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
