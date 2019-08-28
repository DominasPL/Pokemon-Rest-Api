package com.github.dominaspl.pokemonrestapi.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "base_stats")
@Data
@RequiredArgsConstructor
public class BaseStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long baseStatsID;

    @Column(nullable = false)
    private Integer hp;

    @Column(nullable = false)
    private Integer attack;

    @Column(nullable = false)
    private Integer defense;

    @Column(nullable = false)
    private Integer speed;


}
