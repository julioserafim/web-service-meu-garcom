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
	private Long id;
	
	private String nome;
	
	private Long latitude;
	
	private int quantidadeMesa;
	
	private Long logitude;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public int getQuantidadeMesa() {
		return quantidadeMesa;
	}

	public void setQuantidadeMesa(int quantidadeMesa) {
		this.quantidadeMesa = quantidadeMesa;
	}

	public Long getLogitude() {
		return logitude;
	}

	public void setLogitude(Long logitude) {
		this.logitude = logitude;
	}
	
	
	
}
