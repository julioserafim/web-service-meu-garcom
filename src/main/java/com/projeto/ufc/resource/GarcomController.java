package com.projeto.ufc.resource;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.service.GarcomService;

@RestController
@RequestMapping("garcom/pedido")
public class GarcomController {
	
	private GarcomService garcomService;
	
	@RequestMapping(method = RequestMethod.GET,produces="application/json")
	public List<Prato> listarPratosProntos(Long restaurante){
		return garcomService.listarPratosParaPreparo();
	}
	
	@RequestMapping(value = "/prato",method = RequestMethod.POST,consumes="application/json")
	public String deletarPedidoPratos(@RequestBody Prato prato,@PathVariable("id") Long restaurante){
		garcomService.deletar(prato);
		return "Deletado com sucesso";
	}
}
