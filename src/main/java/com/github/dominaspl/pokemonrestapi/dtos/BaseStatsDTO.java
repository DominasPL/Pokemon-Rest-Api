package com.github.dominaspl.pokemonrestapi.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BaseStatsDTO {

    private Long baseStatsID;

    private Integer hp;

    private Integer attack;

    private Integer defense;

    private Integer speed;


}
