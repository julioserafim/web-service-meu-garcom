package com.projeto.ufc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.Cliente;
import com.projeto.ufc.domain.Pedido;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.domain.Restaurante;
import com.projeto.ufc.service.CozinhaService;
import com.projeto.ufc.service.RestauranteService;

@RestController
@RequestMapping("cozinha/pedido")
public class CozinhaController {

	@Autowired
	CozinhaService cozinhaService;
	
	@RequestMapping(method = RequestMethod.GET,produces="application/json")
	public List<Prato> listarPratosASeremPreparados(){
		return cozinhaService.listarPratosParaPreparo();
	}; 
	
	@RequestMapping(value = "/{id}",method = RequestMethod.POST,consumes="application/json")
	public String adicionaPedidoPratos(@RequestBody Cliente cliente, @RequestBody Pedido pedido, @PathVariable("id") Long restaurante){
		cozinhaService.adicionarPedido(pedido);
		return "Salvo com sucesso";
	}
	
	@RequestMapping(value = "/prato",method = RequestMethod.POST,consumes="application/json")
	public String deletarPedidoPratos(@RequestBody Prato prato,@PathVariable("id") Long restaurante){
		cozinhaService.deletar(prato);
		return "Salvo com sucesso";
	}
	
	

}
