package com.projeto.ufc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_pedido;
		
	private int mesa;
		
	@JoinColumn(name = "prato_id")
	private Long prato_id;
	
	public Long getPrato_id() {
		return prato_id;
	}
	public void setPrato(Long prato_id) {
		this.prato_id= prato_id;
	}
	
	public Long getCod_pedido() {
		return cod_pedido;
	}
	public void setCod_pedido(Long cod_pedido) {
		this.cod_pedido = cod_pedido;
	}
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	
}
