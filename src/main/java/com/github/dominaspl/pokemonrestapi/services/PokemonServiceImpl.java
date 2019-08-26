package com.github.dominaspl.pokemonrestapi.services;

import com.github.dominaspl.pokemonrestapi.converters.PokemonConverter;
import com.github.dominaspl.pokemonrestapi.converters.TypeConverter;
import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;
import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;
import com.github.dominaspl.pokemonrestapi.models.Pokemon;
import com.github.dominaspl.pokemonrestapi.models.Type;
import com.github.dominaspl.pokemonrestapi.repositories.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    private PokemonRepository pokemonRepository;
    private TypeService typeService;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, TypeService typeService) {
        this.pokemonRepository = pokemonRepository;
        this.typeService = typeService;
    }

    @Override
    public List<PokemonDTO> findAllPokemons() {

        List<Pokemon> pokemonList = pokemonRepository.findAll();

        if (pokemonList == null) {
            throw new IllegalStateException("Pokemons not found!");
        }

        return PokemonConverter.convertToPokemonDTOList(pokemonList);

    }

    @Override
    public PokemonDTO findPokemonById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Id must be given!");
        }

        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        Pokemon pokemon = optionalPokemon.orElse(new Pokemon());

        return PokemonConverter.convertToPokemonDTO(pokemon);

    }

    @Override
    @Transactional
    public void savePokemon(PokemonDTO pokemonDTO) {

        if (pokemonDTO == null) {
            throw new IllegalArgumentException("Pokemon must be given!");
        }

        Set<TypeDTO> correctTypes = typeService.checkTypesInDatabase(pokemonDTO.getTypes());

        if (!correctTypes.isEmpty()) {
            Pokemon pokemon = PokemonConverter.convertToPokemon(pokemonDTO.getPokemonName(), correctTypes);
            pokemonRepository.save(pokemon);
        }
    }

    @Override
    @Transactional
    public void updatePokemon(Long id, PokemonDTO pokemonDTO) {

        if (id == null || pokemonDTO == null) {
            throw new IllegalArgumentException("Id && pokemon && types must be given!");
        }

        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        Pokemon pokemon = optionalPokemon.orElse(new Pokemon());

        if (pokemon.getPokemonID() == null) {
            savePokemon(pokemonDTO);
        } else {
            Set<TypeDTO> correctTypes = typeService.checkTypesInDatabase(pokemonDTO.getTypes());
            if (!correctTypes.isEmpty()) {
                pokemon.setPokemonName(pokemonDTO.getPokemonName());
                pokemon.setTypes(TypeConverter.convertToTypeList(new ArrayList<>(correctTypes)));
                pokemonRepository.save(pokemon);
            }
        }
    }

    @Override
    @Transactional
    public void deletePokemonFromRestApi(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Id must be given!");
        }




    }


}
