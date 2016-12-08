package com.projeto.ufc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.Pedido;
import com.projeto.ufc.service.CozinhaService;

@RestController
@RequestMapping("/cozinha")
public class CozinhaController {

	@Autowired
	private CozinhaService cozinhaService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Pedido> listarPratosASeremPreparados() {
		return cozinhaService.listarPedidosParaPreparo();
	}

	@RequestMapping(value = "/pedido", method = RequestMethod.POST, consumes = "application/json")
	public String adicionaPedidoPratos(@RequestBody Pedido pedido) {
		cozinhaService.adicionarPedido(pedido);
		return "Pedido Salvo com sucesso";
	}

	@RequestMapping(value = "/pedido/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	public String deletarPedidoPratos(@PathVariable("id")Long id) {
		cozinhaService.deletar(id);
		return "Deletado com sucesso";
	}

}
