package com.github.dominaspl.pokemonrestapi.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
//@XmlRootElement
public class PokemonDTO {

    private Long pokemonID;

    @NotEmpty(message = "Pokemon name must be given!")
    private String pokemonName;
    private List<TypeDTO> types = new ArrayList<>();


}
