package com.projeto.ufc.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String cliente;
	
	private int mesa;
	
	private Long restaurante;
	
	/*@OneToMany
	private List<Long> pratos;*/
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	public Long getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Long restaurante) {
		this.restaurante = restaurante;
	}
	
	/*public List<Long> getPratos() {
		return pratos;
	}
	public void setPratos(List<Long> pratos) {
		this.pratos = pratos;
	}*/
	
	
	

}
