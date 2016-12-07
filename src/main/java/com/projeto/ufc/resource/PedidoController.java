package com.projeto.ufc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.Pedido;
import com.projeto.ufc.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(method = RequestMethod.POST,consumes="application/json")
	public void salvarPedido(@RequestBody Pedido pedido){
		pedidoService.salvar(pedido);
	}

}
