package com.projeto.ufc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "cardapio")
public class Cardapio {
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_cardapio;
	
	@OneToMany
	@JoinColumn(name = "cod_prato")
	private List<Prato> prato;
	
	
	public Long getCod_cardapio() {
		return cod_cardapio;
	}

	public void setCod_cardapio(Long cod_cardapio) {
		this.cod_cardapio = cod_cardapio;
	}

	public List<Prato> getPrato() {
		return prato;
	}

	public void setPrato(List<Prato> prato) {
		this.prato = prato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_cardapio == null) ? 0 : cod_cardapio.hashCode());
		result = prime * result + ((prato == null) ? 0 : prato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cardapio other = (Cardapio) obj;
		if (cod_cardapio == null) {
			if (other.cod_cardapio != null)
				return false;
		} else if (!cod_cardapio.equals(other.cod_cardapio))
			return false;
		if (prato == null) {
			if (other.prato != null)
				return false;
		} else if (!prato.equals(other.prato))
			return false;
		return true;
	}

	


}
