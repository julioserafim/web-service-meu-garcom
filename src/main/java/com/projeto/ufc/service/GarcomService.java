package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projeto.ufc.domain.PedidoCozinha;
import com.projeto.ufc.domain.PedidoGarcom;
import com.projeto.ufc.repository.PedidoRepositoryGarcom;
import com.projeto.ufc.repository.PedidoRepositoryGerente;

@Service
public class GarcomService {
	
	@Autowired
	private PedidoRepositoryGarcom pedidoRepositoryGarcom;
	
	@Autowired
	private GerenteService gerenteService;

	public List<PedidoGarcom> listarPedidoProntosEntrega() {
		return pedidoRepositoryGarcom.findAll();
	}
	
	public void adicionarPedidoGarcom(PedidoCozinha pedidoCozinha){
		PedidoGarcom pedidoGarcom = new PedidoGarcom();
		pedidoGarcom.setId(pedidoCozinha.getId());
		pedidoGarcom.setMesa(pedidoCozinha.getMesa());
		pedidoGarcom.setPrato_id(pedidoCozinha.getPrato_id());
	
		pedidoRepositoryGarcom.save(pedidoGarcom);
		
	}

	public void deletar(@PathVariable("id") Long id) {
		PedidoGarcom pedidoGarcom = pedidoRepositoryGarcom.findOne(id);
		gerenteService.adicionarPedidoFinalizado(pedidoGarcom);
		pedidoRepositoryGarcom.delete(id);
	}
	
	public long retornarQuantidadePedido(){
		long quantidade;
		quantidade = pedidoRepositoryGarcom.count();
		
		return quantidade;
	}

	
}
