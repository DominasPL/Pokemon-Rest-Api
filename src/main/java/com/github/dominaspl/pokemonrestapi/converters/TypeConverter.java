package com.github.dominaspl.pokemonrestapi.converters;

import com.github.dominaspl.pokemonrestapi.dtos.TypeDTO;
import com.github.dominaspl.pokemonrestapi.models.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeConverter {


    public static List<TypeDTO> convertToTypeDTOList(List<Type> pokemonTypes) {

        List<TypeDTO> typeDTOList = new ArrayList<>();

        for (Type type : pokemonTypes) {
            TypeDTO typeDTO = new TypeDTO();
            typeDTO.setTypeID(type.getTypeID());
            typeDTO.setTypeName(type.getTypeName());
            typeDTOList.add(typeDTO);
        }

        return typeDTOList;

    }
}
