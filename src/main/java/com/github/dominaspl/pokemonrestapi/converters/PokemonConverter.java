package com.github.dominaspl.pokemonrestapi.converters;

import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;
import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;
import com.github.dominaspl.pokemonrestapi.models.Pokemon;
import com.github.dominaspl.pokemonrestapi.models.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PokemonConverter {


    public static List<PokemonDTO> convertToPokemonDTOList(List<Pokemon> pokemonList) {

        List<PokemonDTO> pokemonDTOList = new ArrayList<>();

        for (Pokemon pokemon : pokemonList) {
            pokemonDTOList.add(convertToPokemonDTO(pokemon));
        }

        pokemonDTOList.sort((o1, o2) -> o1.getPokemonName().compareTo(o2.getPokemonName()));

        return pokemonDTOList;

    }

    public static PokemonDTO convertToPokemonDTO(Pokemon pokemon) {

        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setPokemonName(pokemon.getPokemonName());
        pokemonDTO.setTypes(TypeConverter.convertToTypeDTOList(pokemon.getTypes()));
        pokemonDTO.setBaseStats(BaseStatsConverter.convertToBaseStatsDTO(pokemon.getBaseStats()));

        return pokemonDTO;
    }

    public static Pokemon convertToPokemon(PokemonDTO pokemonDTO, Set<TypeDTO> correctTypes, State state) {

        Pokemon pokemon = new Pokemon();
        pokemon.setPokemonName(pokemonDTO.getPokemonName()) ;
        pokemon.setTypes(TypeConverter.convertToTypeList(new ArrayList<>(correctTypes)));
        pokemon.setBaseStats(BaseStatsConverter.convertToBaseStats(pokemonDTO.getBaseStats()));
        pokemon.setState(state);

        return pokemon;

    }
}
