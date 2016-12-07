package com.projeto.ufc.repository;

import com.projeto.ufc.domain.Cardapio;

public interface CardapioRepositoryEnhaced {
	public Cardapio findByRestauranteLike(Long id);
}
