package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projeto.ufc.domain.PedidoGarcom;
import com.projeto.ufc.repository.PedidoRepositoryGarcom;
import com.projeto.ufc.repository.PedidoRepositoryGerente;

@Service
public class GarcomService {
	
	@Autowired
	private PedidoRepositoryGarcom pedidoRepositoryGarcom;
	
	@Autowired
	private PedidoRepositoryGerente pedidoRepositoryGerente;

	public List<PedidoGarcom> listarPedidoProntosEntrega() {
		return pedidoRepositoryGarcom.findAll();
	}

	public void deletar(@PathVariable("id") Long id) {
		PedidoGarcom pedidoGarcom = pedidoRepositoryGarcom.findOne(id);
		pedidoRepositoryGerente.save(pedidoGarcom);
		pedidoRepositoryGarcom.delete(id);
	}

	
}
