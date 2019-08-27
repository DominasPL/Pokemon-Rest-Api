package com.github.dominaspl.pokemonrestapi.services;

import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;

import java.util.List;

public interface PokemonService {

    List<PokemonDTO> findAllPokemons();
    PokemonDTO findPokemonById(Long id);
    PokemonDTO savePokemon(PokemonDTO pokemonDTO);
    PokemonDTO updatePokemon(Long id, PokemonDTO pokemonDTO);
    PokemonDTO deletePokemonFromRestApi(Long id);
}
