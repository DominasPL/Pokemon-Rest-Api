package com.github.dominaspl.pokemonrestapi.services;

import com.github.dominaspl.pokemonrestapi.converters.BaseStatsConverter;
import com.github.dominaspl.pokemonrestapi.converters.PokemonConverter;
import com.github.dominaspl.pokemonrestapi.converters.TypeConverter;
import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;
import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;
import com.github.dominaspl.pokemonrestapi.models.Pokemon;
import com.github.dominaspl.pokemonrestapi.repositories.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    private PokemonRepository pokemonRepository;
    private TypeService typeService;
    private StateService stateService;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, TypeService typeService, StateService stateService) {
        this.pokemonRepository = pokemonRepository;
        this.typeService = typeService;
        this.stateService = stateService;
    }

    @Override
    public List<PokemonDTO> findAllPokemons() {

        List<Pokemon> pokemonList = pokemonRepository.findPokemonByState(stateService.findAllStates().get(0));

        if (pokemonList.isEmpty()) {
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
        Pokemon pokemon = optionalPokemon.orElseThrow(() -> new IllegalStateException("Pokemon not found!"));

        if (!pokemon.getState().getIsActive()) {
            throw new IllegalStateException("Pokemon not found!");
        }

        return PokemonConverter.convertToPokemonDTO(pokemon);

    }

    @Override
    @Transactional
    public PokemonDTO savePokemon(PokemonDTO pokemonDTO) {

        if (pokemonDTO == null) {
            throw new IllegalArgumentException("Pokemon must be given!");
        }

        Set<TypeDTO> correctTypes = typeService.checkTypesInDatabase(pokemonDTO.getTypes());

        if (correctTypes.isEmpty()) {
            throw new IllegalStateException("Types not found!");
        }

        Pokemon pokemon = PokemonConverter.convertToPokemon(pokemonDTO, correctTypes, stateService.findAllStates().get(0));
        pokemonRepository.save(pokemon);

        return PokemonConverter.convertToPokemonDTO(pokemon);
    }

    @Override
    @Transactional
    public PokemonDTO updatePokemon(Long id, PokemonDTO pokemonDTO) {

        if (id == null || pokemonDTO == null) {
            throw new IllegalArgumentException("Id and pokemon must be given!");
        }

        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        Pokemon pokemon = optionalPokemon.orElse(null);

        if (pokemon == null) {
            return savePokemon(pokemonDTO);
        } else {

            if (!pokemon.getState().getIsActive()) {
                throw new IllegalStateException("It is not possible to update deleted pokemon!");
            }

            Set<TypeDTO> correctTypes = typeService.checkTypesInDatabase(pokemonDTO.getTypes());

            if (correctTypes.isEmpty()) {
                throw new IllegalStateException("Types not found!");
            }

            pokemon.setPokemonName(pokemonDTO.getPokemonName());
            pokemon.setTypes(TypeConverter.convertToTypeList(new ArrayList<>(correctTypes)));
            pokemon.setBaseStats(BaseStatsConverter.convertToBaseStats(pokemon.getBaseStats().getBaseStatsID(), pokemonDTO.getBaseStats()));

            pokemonRepository.save(pokemon);
        }

        return PokemonConverter.convertToPokemonDTO(pokemon);
    }

    @Override
    @Transactional
    public PokemonDTO deletePokemonFromRestApi(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Id must be given!");
        }

        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        Pokemon pokemon = optionalPokemon.orElse(null);

        if (pokemon == null || !pokemon.getState().getIsActive()) {
            throw new IllegalStateException("Pokemon not found!");
        }

        pokemon.setState(stateService.findAllStates().get(1));

        pokemonRepository.save(pokemon);

        return PokemonConverter.convertToPokemonDTO(pokemon);
    }

    @Override
    @Transactional
    public void deletePokemonByTypeId(Long typeId) {

        if (typeId == null) {
            throw new IllegalArgumentException("Type must be given!");
        }

        for (Pokemon pokemon : pokemonRepository.findPokemonsByTypeId(typeId)) {
            pokemon.setState(stateService.findAllStates().get(1));
        }
    }
}
