package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projeto.ufc.domain.Pedido;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.repository.PedidoRepository;
import com.projeto.ufc.repository.PedidoRepositoryCozinha;
import com.projeto.ufc.repository.PedidoRepositoryGarcom;

@Service
public class CozinhaService {
	
	@Autowired
	private PedidoRepositoryCozinha pedidoRepositoryCozinha;
	
	@Autowired
	private PedidoRepositoryGarcom pedidoRepositoryGarcom;
	
	
	public List<Pedido> listarPedidosParaPreparo(){
		return pedidoRepositoryCozinha.findAll();
	}
	
	public void adicionarPedido(Pedido pedido){
		pedido.setId(null);
		pedidoRepositoryCozinha.save(pedido);
	}
	
	public void deletar(@PathVariable("id") Long id){ // quando deletar aqui colocar nos prontos pro garçom
		Pedido pedido = pedidoRepositoryCozinha.findOne(id);
		pedidoRepositoryGarcom.save(pedido);
		pedidoRepositoryCozinha.delete(id);
	}
	
	

}
