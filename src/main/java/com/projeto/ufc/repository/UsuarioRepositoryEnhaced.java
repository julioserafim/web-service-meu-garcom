package com.projeto.ufc.repository;

import com.projeto.ufc.domain.Usuario;

public interface UsuarioRepositoryEnhaced {
	public Usuario findByLoginLike(String login);
}
