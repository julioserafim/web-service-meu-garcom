package com.projeto.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ufc.domain.Pedido;

public interface PedidoRepositoryGarcom extends JpaRepository<Pedido, Long>{
	
}