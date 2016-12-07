package com.projeto.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ufc.domain.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long>{
	
}
