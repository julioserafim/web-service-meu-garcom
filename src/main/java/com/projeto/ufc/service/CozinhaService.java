package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ufc.domain.Pedido;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.repository.PedidoRepository;

@Service
public class CozinhaService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	
	public List<Pedido> listarPedidosParaPreparo(){
		return pedidoRepository.findAll();
	}
	
	public void adicionarPedido(Pedido pedido){
		pedido.setCod_pedido(null);
		pedidoRepository.save(pedido);
	}
	
	public void deletar(Prato prato){ // quando deletar aqui colocar nos prontos pro garçom
		
	}

}
