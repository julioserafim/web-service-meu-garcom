package com.projeto.ufc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ufc.domain.Prato;
import com.projeto.ufc.domain.Usuario;
import com.projeto.ufc.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void adicionarUsuario(Usuario usuario) {
		usuario.setId(null);
		usuarioRepository.save(usuario);
	}
	
	public void removerUsuario(Long id){
		usuarioRepository.delete(id);
	}
	
	
	
}
