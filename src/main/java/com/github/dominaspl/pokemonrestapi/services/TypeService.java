package com.github.dominaspl.pokemonrestapi.services;

import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;

import java.util.List;
import java.util.Set;

public interface TypeService {

    List<TypeDTO> findAllTypes();
    TypeDTO findTypeById(Long id);
    Set<TypeDTO> checkTypesInDatabase(List<TypeDTO> types);
}
