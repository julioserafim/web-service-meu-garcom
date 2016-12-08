package com.projeto.ufc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.PedidoGarcom;
import com.projeto.ufc.service.GarcomService;

@CrossOrigin
@RestController
@RequestMapping("/garcom/pedido")
public class GarcomController {
	
	@Autowired
	private GarcomService garcomService;
	
	
	@RequestMapping(method = RequestMethod.GET,produces="application/json")
	public List<PedidoGarcom> listarPratosProntos(){
		return garcomService.listarPedidoProntosEntrega();
	}
	
	@CrossOrigin(methods=RequestMethod.DELETE)
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public String deletarPedidoPratosProntosEntrega(@PathVariable("id") Long pedido){
		garcomService.deletar(pedido);
		return "Deletado com sucesso";
	}
}
