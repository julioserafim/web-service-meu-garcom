package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ufc.domain.Restaurante;
import com.projeto.ufc.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	RestauranteRepository restauranteRepository;

	public void salvar(Restaurante restaurante){
		restaurante.setCodigo(null);
		restauranteRepository.save(restaurante);
	}
	
	public List<Restaurante> listarRestaurantes(){
		return restauranteRepository.findAll();
	}
}
