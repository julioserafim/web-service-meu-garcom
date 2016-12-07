package com.projeto.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ufc.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>,UsuarioRepositoryEnhaced{

}
