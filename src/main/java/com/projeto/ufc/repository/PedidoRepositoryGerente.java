package com.projeto.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ufc.domain.PedidoGarcom;
import com.projeto.ufc.domain.PedidoGerente;

public interface PedidoRepositoryGerente extends JpaRepository<PedidoGerente, Long>{

	void save(PedidoGarcom pedidoGarcom);
	
}
