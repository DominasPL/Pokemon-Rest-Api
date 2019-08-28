package com.github.dominaspl.pokemonrestapi.converters;

import com.github.dominaspl.pokemonrestapi.dtos.BaseStatsDTO;
import com.github.dominaspl.pokemonrestapi.models.BaseStats;

public class BaseStatsConverter {


    public static BaseStatsDTO convertToBaseStatsDTO(BaseStats baseStats) {

        BaseStatsDTO baseStatsDTO = new BaseStatsDTO();
        baseStatsDTO.setBaseStatsID(baseStats.getBaseStatsID());
        baseStatsDTO.setHp(baseStats.getHp());
        baseStatsDTO.setAttack(baseStats.getAttack());
        baseStatsDTO.setDefense(baseStats.getDefense());
        baseStatsDTO.setSpeed(baseStats.getSpeed());

        return baseStatsDTO;
    }
}
