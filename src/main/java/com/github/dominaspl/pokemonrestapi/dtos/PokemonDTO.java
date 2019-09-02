package com.github.dominaspl.pokemonrestapi.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
//@XmlRootElement
public class PokemonDTO {

    @NotEmpty(message = "Pokemon name must be given!")
    @Size(min = 1, max = 30, message = "Pokemon name should have 1 to 30 characters!")
    private String pokemonName;

    @Valid
    private List<TypeDTO> types = new ArrayList<>();

    @Valid
    private BaseStatsDTO baseStats;


}
