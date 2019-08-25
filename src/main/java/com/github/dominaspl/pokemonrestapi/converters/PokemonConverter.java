package com.github.dominaspl.pokemonrestapi.converters;

import com.github.dominaspl.pokemonrestapi.dtos.PokemonDTO;
import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;
import com.github.dominaspl.pokemonrestapi.models.Pokemon;
import com.github.dominaspl.pokemonrestapi.models.Type;

import java.util.ArrayList;
import java.util.List;

public class PokemonConverter {


    public static List<PokemonDTO> convertToPokemonDTOList(List<Pokemon> pokemonList) {

        List<PokemonDTO> pokemonDTOList = new ArrayList<>();

        for (Pokemon pokemon : pokemonList) {

            PokemonDTO pokemonDTO = new PokemonDTO();
            pokemonDTO.setPokemonID(pokemon.getPokemonID());
            pokemonDTO.setPokemonName(pokemon.getPokemonName());

            List<Type> pokemonTypes = pokemon.getTypes();
            List<TypeDTO> pokemonDTOTypes = new ArrayList<>();
            for (Type type : pokemonTypes) {
                TypeDTO typeDTO = new TypeDTO();
                typeDTO.setTypeID(type.getTypeID());
                typeDTO.setTypeName(type.getTypeName());
                pokemonDTOTypes.add(typeDTO);
            }

            pokemonDTO.setTypes(pokemonDTOTypes);
            pokemonDTOList.add(pokemonDTO);
        }

        return pokemonDTOList;
    }
}
