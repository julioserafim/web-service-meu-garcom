package com.projeto.ufc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projeto.ufc.domain.Cardapio;
import com.projeto.ufc.domain.Pedido;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.domain.Usuario;

@Service
public class GerenteService {

	public List<Prato> listarPratosFinalizados() {
		return null;
	}

	public void adicionarPrato(Prato prato, Long restaurante) {

	}

	public void deletarPrato(Prato prato, Long restaurante) {

	}

	public Cardapio retornarCardapioRestaurante(Long restaurante) {
		return null;
	}

	public void adicionarFuncionario(Usuario usuario) {

	}

	public void deletarFuncionario(Usuario usuario) {

	}

	public List<Usuario> retornarTodosFuncionarios(Long restaurante) {
		return null;
	}

}
