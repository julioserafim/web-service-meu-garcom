package com.projeto.ufc.resource;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.PedidoGarcom;
import com.projeto.ufc.service.GarcomService;

@RestController
@RequestMapping("/garcom/pedido")
public class GarcomController {
	
	private GarcomService garcomService;
	
	@RequestMapping(method = RequestMethod.GET,produces="application/json")
	public List<PedidoGarcom> listarPratosProntos(){
		return garcomService.listarPedidoProntosEntrega();
	}
	
	@RequestMapping(method = RequestMethod.DELETE,consumes="application/json")
	public String deletarPedidoPratosProntosEntrega(@PathVariable("id") Long pedido){
		garcomService.deletar(pedido);
		return "Deletado com sucesso";
	}
}
