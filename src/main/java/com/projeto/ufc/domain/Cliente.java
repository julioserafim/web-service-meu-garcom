package com.projeto.ufc.domain;

import javax.persistence.Entity;

@Entity
public class Cliente {
	private String nome;
	private int mesa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

}
