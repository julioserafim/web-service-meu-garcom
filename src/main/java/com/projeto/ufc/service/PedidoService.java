package com.projeto.ufc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ufc.domain.Pedido;
import com.projeto.ufc.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public void salvar(Pedido pedido){
		pedido.setId(null);
		pedidoRepository.save(pedido);
	}
	

}
