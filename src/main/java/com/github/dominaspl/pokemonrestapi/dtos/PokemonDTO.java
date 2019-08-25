package com.github.dominaspl.pokemonrestapi.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@XmlRootElement
public class PokemonDTO {

    private Long pokemonID;
    private String pokemonName;
    private List<TypeDTO> types = new ArrayList<>();


}
