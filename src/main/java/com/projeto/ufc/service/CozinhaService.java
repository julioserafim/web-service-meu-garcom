package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projeto.ufc.domain.Pedido;
import com.projeto.ufc.domain.PedidoCozinha;
import com.projeto.ufc.repository.PedidoRepositoryCozinha;
import com.projeto.ufc.repository.PedidoRepositoryGarcom;

@Service
public class CozinhaService {
	
	@Autowired
	private PedidoRepositoryCozinha pedidoRepositoryCozinha;
	
	@Autowired
	private PedidoRepositoryGarcom pedidoRepositoryGarcom;
	
	
	public List<PedidoCozinha> listarPedidosParaPreparo(){
		return pedidoRepositoryCozinha.findAll();
	}
	
	public void adicionarPedido(PedidoCozinha pedidoCozinha){
		pedidoCozinha.setId(null);
		pedidoRepositoryCozinha.save(pedidoCozinha);
	}
	
	public void deletar(@PathVariable("id") Long id){ // quando deletar aqui colocar nos prontos pro garçom
		PedidoCozinha pedidoCozinha = pedidoRepositoryCozinha.findOne(id);
		pedidoRepositoryGarcom.save(pedidoCozinha);
		pedidoRepositoryCozinha.delete(id);
	
	}
	
	

}
