package com.github.dominaspl.pokemonrestapi.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class BaseStatsDTO {

    @NotNull(message = "HP must be given!")
    @Min(1) @Max(9999)
    private Integer hp;

    @NotNull(message = "Attack must be given!")
    @Min(1) @Max(9999)
    private Integer attack;

    @NotNull(message = "Defense must be given!")
    @Min(1) @Max(9999)
    private Integer defense;

    @NotNull(message = "Speed must be given!")
    @Min(1) @Max(9999)
    private Integer speed;


}
