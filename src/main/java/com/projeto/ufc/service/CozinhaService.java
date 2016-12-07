package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ufc.domain.Pedido;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.repository.PedidoRepository;
import com.projeto.ufc.repository.PedidoRepositoryCozinha;

@Service
public class CozinhaService {
	
	@Autowired
	private PedidoRepositoryCozinha pedidoRepositoryCozinha;
	
	
	
	public List<Pedido> listarPedidosParaPreparo(){
		return pedidoRepositoryCozinha.findAll();
	}
	
	public void adicionarPedido(Pedido pedido){
		pedido.setCod_pedido(null);
		pedidoRepositoryCozinha.save(pedido);
	}
	
	public void deletar(Prato prato){ // quando deletar aqui colocar nos prontos pro garçom
		
	}

}
