package com.github.dominaspl.pokemonrestapi.repositories;

import com.github.dominaspl.pokemonrestapi.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
