package com.github.dominaspl.pokemonrestapi.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TypeDTO {

    private Long typeID;
    private String typeName;

}
