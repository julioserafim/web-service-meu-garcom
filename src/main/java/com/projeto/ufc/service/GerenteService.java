package com.projeto.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.ufc.domain.PedidoGarcom;
import com.projeto.ufc.domain.PedidoGerente;
import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.domain.Usuario;
import com.projeto.ufc.repository.CardapioRepository;
import com.projeto.ufc.repository.PedidoRepositoryGerente;
import com.projeto.ufc.repository.PratoRepository;
import com.projeto.ufc.repository.UsuarioRepository;

@Service
public class GerenteService {
	@Autowired
	private PratoRepository pratoRepository;
	
	@Autowired
	private CardapioRepository cardapioRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepositoryGerente pedidoGerenteRepository;
	
	

	public List<PedidoGerente> listarPedidosFinalizados(PedidoGerente pedidoGerente) {
		return pedidoGerenteRepository.findAll();
	}

	public void adicionarPrato(Prato prato) {
		prato.setId(null);
		pratoRepository.save(prato);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletarPrato(@PathVariable("id") Long id) {
		pratoRepository.delete(id);	
	}

	public List<Prato> retornarCardapio() {
			return pratoRepository.findAll();
			
	}

	public void adicionarFuncionario(Usuario usuario) {
		 usuario.setCod_usuario(null);
		 usuarioRepository.save(usuario);
	}

	public void deletarFuncionario(@PathVariable("id") Long id) {
			usuarioRepository.delete(id);
	}

	public List<Usuario> retornarTodosFuncionarios() {
		return usuarioRepository.findAll();
		
	}
	
	public void adicionarPedidoFinalizado(PedidoGarcom pedidoGarcom) {
		PedidoGerente pedidoGerente = new PedidoGerente();
		pedidoGerente.setId(pedidoGarcom.getId());
		pedidoGerente.setMesa(pedidoGarcom.getMesa());
		pedidoGerente.setPrato_id(pedidoGarcom.getPrato_id());
	
		pedidoGerenteRepository.save(pedidoGerente);
	}

}
