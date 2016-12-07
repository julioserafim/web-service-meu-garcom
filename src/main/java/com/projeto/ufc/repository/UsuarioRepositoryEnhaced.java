package com.projeto.ufc.repository;

import java.util.List;

import com.projeto.ufc.domain.Usuario;

public interface UsuarioRepositoryEnhaced {
	public Usuario findByLoginLike(String login);
	public List<Usuario> findByRestauranteLike(Long restaurante);
}
