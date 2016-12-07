package com.projeto.ufc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.domain.Restaurante;
import com.projeto.ufc.service.GerenteService;
import com.projeto.ufc.service.RestauranteService;

@RestController
@RequestMapping("/restaurante")
public class GerenteController {
	@Autowired
	private GerenteService gerenteService;
	
	@RequestMapping(method = RequestMethod.POST,consumes="application/json")
	public String adicionarPratoGerente(@RequestBody Prato prato, Long restaurante){
		gerenteService.adicionarPrato(prato, restaurante);
		return "Salvo com sucesso";
	}

}
