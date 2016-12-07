package com.projeto.ufc.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ufc.domain.Restaurante;
import com.projeto.ufc.service.RestauranteService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
	
	
	@Autowired
	private RestauranteService restauranteService;
	
	@RequestMapping(method = RequestMethod.GET,produces="application/json")
	public List<Restaurante> listarRestaurantes(){
		return restauranteService.listarRestaurantes();
	}; 
	
	@RequestMapping(method = RequestMethod.POST,consumes="application/json")
	public String cadastrarRestaurante(@RequestBody Restaurante restaurante){
		restauranteService.salvar(restaurante);
		return "Salvo com sucesso";
	}
	
	

}
