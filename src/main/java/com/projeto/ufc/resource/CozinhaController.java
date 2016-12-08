package com.projeto.ufc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.PedidoCozinha;
import com.projeto.ufc.service.CozinhaService;

@CrossOrigin
@RestController
@RequestMapping("/cozinha/pedido")
public class CozinhaController {

	@Autowired
	private CozinhaService cozinhaService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<PedidoCozinha> listarPratosASeremPreparados() {
		return cozinhaService.listarPedidosParaPreparo();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public String adicionaPedidoPratos(@RequestBody PedidoCozinha pedido) {
		cozinhaService.adicionarPedido(pedido);
		return "{msg:OK}";
	}
	
	@CrossOrigin(methods=RequestMethod.DELETE)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deletarPedidoPrato(@PathVariable("id")Long id) {
		cozinhaService.deletar(id);
		return "{msg:OK}";
	}
	
	@RequestMapping(value = "/quantidade",method = RequestMethod.GET, produces = "application/json")
	public String quantidade() {
		long numero;
		numero = cozinhaService.retornarQuantidadePedido();
		
		return "{quantidade:" + numero + "}";
	}
	

}
