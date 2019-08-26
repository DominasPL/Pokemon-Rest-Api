package com.github.dominaspl.pokemonrestapi.services;

import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;

import java.util.List;

public interface PokemonService {

    List<PokemonDTO> findAllPokemons();
    PokemonDTO findPokemonById(Long id);
    void savePokemon(PokemonDTO pokemonDTO);
    void updatePokemon(Long id, PokemonDTO pokemonDTO);
    void deletePokemonFromRestApi(Long id);
}
