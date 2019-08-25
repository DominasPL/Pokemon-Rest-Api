package com.github.dominaspl.pokemonrestapi.services;

import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;

import java.util.List;

public interface PokemonService {

    List<PokemonDTO> findAllPokemons();

}
