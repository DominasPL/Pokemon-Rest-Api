package com.github.dominaspl.pokemonrestapi.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class PokemonDTO {

    private Long pokemonID;
    private String pokemonName;
    private List<TypeDTO> typeDTOS = new ArrayList<>();


}
