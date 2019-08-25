package com.github.dominaspl.pokemonrestapi.converters;

import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;
import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;
import com.github.dominaspl.pokemonrestapi.models.Pokemon;
import com.github.dominaspl.pokemonrestapi.models.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PokemonConverter {


    public static List<PokemonDTO> convertToPokemonDTOList(List<Pokemon> pokemonList) {

        List<PokemonDTO> pokemonDTOList = new ArrayList<>();

        for (Pokemon pokemon : pokemonList) {
            pokemonDTOList.add(convertToPokemonDTO(pokemon));
        }

        pokemonDTOList.sort((o1, o2) -> o1.getPokemonID().compareTo(o2.getPokemonID()));

        return pokemonDTOList;
    }

    public static PokemonDTO convertToPokemonDTO(Pokemon pokemon) {

        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setPokemonID(pokemon.getPokemonID());
        pokemonDTO.setPokemonName(pokemon.getPokemonName());
        pokemonDTO.setTypes(TypeConverter.convertToTypeDTOList(pokemon.getTypes()));

        return pokemonDTO;
    }


}
