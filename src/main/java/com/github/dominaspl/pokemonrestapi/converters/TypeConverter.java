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

            public static List<Type> convertToTypeList(List<TypeDTO> typesDTOList) {

        List<Type> types = new ArrayList<>();

        for (TypeDTO typeDTO : typesDTOList) {
            Type type = new Type();
            type.setTypeID(typeDTO.getTypeID());
            type.setTypeName(typeDTO.getTypeName());
            types.add(type);
        }

        return types;
    }

    public static Type convertToType(TypeDTO typeDTO) {

        Type type = new Type();
        type.setTypeName(typeDTO.getTypeName());
        return type;
    }
}
