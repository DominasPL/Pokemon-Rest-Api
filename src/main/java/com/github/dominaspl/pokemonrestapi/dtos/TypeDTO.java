package com.github.dominaspl.pokemonrestapi.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@RequiredArgsConstructor
@XmlRootElement
public class TypeDTO {

    private Long typeID;
    private String typeName;

}
