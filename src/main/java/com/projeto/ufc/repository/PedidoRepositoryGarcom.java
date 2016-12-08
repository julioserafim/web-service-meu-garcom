package com.projeto.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ufc.domain.PedidoCozinha;
import com.projeto.ufc.domain.PedidoGarcom;

public interface PedidoRepositoryGarcom extends JpaRepository<PedidoGarcom, Long>{

	void save(PedidoCozinha pedidoCozinha);
	
}
