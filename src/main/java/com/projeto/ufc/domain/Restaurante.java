package com.projeto.ufc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "restaurante")
public class Restaurante {
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "Campo Titulo não pode ser nulo")
	private String nomeRestaurante;
	
	@NotEmpty(message = "Campo Cardapio não pode ser nulo")
	private Long cardapio;
	
	@NotEmpty(message = "Campo Quantidade de Mesa não pode ser nulo")
	private int quantidadeMesa;
	
	@NotEmpty(message = "Campo Responsavel não pode ser nulo")
	private String responsavel;
	 	
	public int getQuantidadeMesa() {
		return quantidadeMesa;
	}

	public void setQuantidadeMesa(int quantidadeMesa) {
		this.quantidadeMesa = quantidadeMesa;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
	}
	
	
	
}
