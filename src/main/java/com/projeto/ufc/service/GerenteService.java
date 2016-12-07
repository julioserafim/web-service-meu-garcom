package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.ufc.domain.Cardapio;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.domain.Usuario;
import com.projeto.ufc.repository.CardapioRepository;
import com.projeto.ufc.repository.PratoRepository;

@Service
public class GerenteService {
	@Autowired
	private PratoRepository pratoRepository;
	
	@Autowired
	private CardapioRepository cardapioRepository;
	
	

	public List<Prato> listarPratosFinalizados(Prato prato) {
		return null;
	}

	public void adicionarPrato(Prato prato, Long restaurante) {
		prato.setId(null);
		pratoRepository.save(prato);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletarPrato(@PathVariable("id") Long id, Long restaurante) {
		pratoRepository.delete(id);	
	}

	public Cardapio retornarCardapioRestaurante(Long restaurante) {
			Cardapio cardapio = cardapioRepository.findByRestauranteLike(restaurante);
			return cardapio;
	}

	public void adicionarFuncionario(Usuario usuario) {

	}

	public void deletarFuncionario(Usuario usuario) {

	}

	public List<Usuario> retornarTodosFuncionarios(Long restaurante) {
		return null;
	}

}
