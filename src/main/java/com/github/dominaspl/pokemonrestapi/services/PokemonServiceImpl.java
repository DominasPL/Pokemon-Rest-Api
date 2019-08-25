package com.github.dominaspl.pokemonrestapi.services;

import com.github.dominaspl.pokemonrestapi.converters.PokemonConverter;
import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;
import com.github.dominaspl.pokemonrestapi.models.Pokemon;
import com.github.dominaspl.pokemonrestapi.repositories.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    private PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<PokemonDTO> findAllPokemons() {

        List<Pokemon> pokemonList = pokemonRepository.findAll();

        if (pokemonList == null) {
            throw new IllegalStateException("Pokemons not found!");
        }

        return PokemonConverter.convertToPokemonDTOList(pokemonList);

    }


}
