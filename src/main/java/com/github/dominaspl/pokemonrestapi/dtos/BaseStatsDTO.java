package com.github.dominaspl.pokemonrestapi.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class BaseStatsDTO {

    private Long baseStatsID;

    @NotNull(message = "HP must be given!")
    private Integer hp;

    @NotNull(message = "Attack must be given!")
    private Integer attack;

    @NotNull(message = "Defense must be given!")
    private Integer defense;

    @NotNull(message = "Speed must be given!")
    private Integer speed;


}
