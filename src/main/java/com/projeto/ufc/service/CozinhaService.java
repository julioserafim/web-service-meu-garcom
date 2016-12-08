package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projeto.ufc.domain.PedidoCozinha;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.repository.PedidoRepositoryCozinha;
import com.projeto.ufc.repository.PratoRepository;

@Service
public class CozinhaService {
	
	@Autowired
	private PedidoRepositoryCozinha pedidoRepositoryCozinha;
	
	@Autowired
	private PratoRepository pratoRepository;
	
	@Autowired
	private GarcomService garcomService;
	
	
	public List<PedidoCozinha> listarPedidosParaPreparo(){
		return pedidoRepositoryCozinha.findAll();
	}
	
	public void adicionarPedido(PedidoCozinha pedidoCozinha){
		pedidoCozinha.setId(null);
		pedidoRepositoryCozinha.save(pedidoCozinha);
	}
	
	public void deletar(@PathVariable("id") Long id){ // quando deletar aqui colocar nos prontos pro garçom
		PedidoCozinha pedidoCozinha = pedidoRepositoryCozinha.findOne(id);
		Prato prato = pratoRepository.findOne(pedidoCozinha.getPrato_id());
		pedidoCozinha.setDescricao(prato.getDescricao());
		pedidoCozinha.setNome(prato.getNome());
		garcomService.adicionarPedidoGarcom(pedidoCozinha);
		pedidoRepositoryCozinha.delete(id);
	}
	
	public long retornarQuantidadePedido(){
		long quantidade;
		quantidade = pedidoRepositoryCozinha.count();
		
		return quantidade;
	}
	
	
}
