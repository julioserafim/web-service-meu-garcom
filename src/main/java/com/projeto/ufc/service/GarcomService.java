package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ufc.domain.Pedido;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.repository.PedidoRepositoryGarcom;

@Service
public class GarcomService {
	
	@Autowired
	private PedidoRepositoryGarcom pedidoRepository;

	public List<Pedido> listarPedidoProntosEntrega() {
		return pedidoRepository.findAll();
	}

	public void deletar(Long id) {
		
	}

	
}
